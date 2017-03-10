package com.example.islam.project_management.RxFirebase;

/**
 * Created by islam on 09/03/17.
 */

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.File;

import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by ahmed on 11/21/2016.
 */
public class RxFirebaseStorage {
    @NonNull
    static Observable<FileDownloadTask.TaskSnapshot> getFile(@NonNull final StorageReference storageRef,
                                                             @NonNull final File destinationFile) {
        return Observable.create(new Observable.OnSubscribe<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void call(final Subscriber<? super FileDownloadTask.TaskSnapshot> subscriber) {
                StorageTask<FileDownloadTask.TaskSnapshot> task = storageRef.getFile(destinationFile).addOnProgressListener(taskSnapshot -> {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                    Log.d(TAG, String.format("upload progress for %s is %s", destinationFile.getAbsolutePath(), progress));
                    subscriber.onNext(taskSnapshot);
                }).addOnFailureListener(e -> {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onError(e);
                }).addOnSuccessListener(taskSnapshot -> {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onCompleted();
                });
                subscriber.add(Subscriptions.create(() -> task.cancel()));
            }
        });
    }

    @NonNull
    static Observable<String> putFile(@NonNull final StorageReference storageRef,
                                      @NonNull final Uri sourceFileUri) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                StorageTask<UploadTask.TaskSnapshot> task = storageRef.putFile(sourceFileUri).addOnProgressListener(taskSnapshot -> {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                    Log.d(TAG, String.format("upload progress for %s is %s", sourceFileUri.toString(), progress));
                }).addOnFailureListener(e -> {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onError(e);
                }).addOnSuccessListener(taskSnapshot -> {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onNext(taskSnapshot.getDownloadUrl().toString());
                    subscriber.onCompleted();
                });
                subscriber.add(Subscriptions.create(() -> task.cancel()));
            }
        });
    }

    @NonNull
    static Observable<Void> deleteFile(@NonNull final StorageReference storageRef) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(final Subscriber<? super Void> subscriber) {
                storageRef.delete().addOnFailureListener(e -> {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onError(e);
                }).addOnSuccessListener(aVoid -> {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onNext(aVoid);
                    subscriber.onCompleted();
                });
            }
        });
    }
}

