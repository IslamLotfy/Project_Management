package com.example.islam.project_management;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.islam.project_management.Models.ActivityModel;
import com.example.islam.project_management.RxFirebase.Authenticator;
import com.example.islam.project_management.RxFirebase.RxFireBaseDB;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private Authenticator authenticator;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        firebaseAuth=FirebaseAuth.getInstance();
        authenticator=Authenticator.getInstance();
//        rx.Observable<Object> observer= authenticator.createUser(getActivity(),"islam@gmail.com","islam222");
//        observer.subscribe();
//        authenticator.signIn(getActivity(),"islam@gmail.com","islam222", new OnCompleteListener<AuthResult>(){
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    System.out.println(firebaseAuth.getCurrentUser().getUid());
//                    Toast.makeText(getActivity(),firebaseAuth.getCurrentUser().getUid(),Toast.LENGTH_SHORT);
//                }

//        } );
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref=databaseReference.child("MobileStudio").child("Users").child("UserID").child("activities").child("approvedActivity");
//        Query messages = ref.orderByKey().limitToLast(1);
//        DatabaseReference ref=databaseReference.child("Users");
        System.out.println(ref.toString());

//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                ActivityModel activityModel= (ActivityModel) dataSnapshot.getValue();
//                Toast.makeText(getActivity(),activityModel.getUser(),Toast.LENGTH_LONG);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        RxFireBaseDB.observeValueEvent(ref).subscribe(dataSnapshot -> {

            Toast.makeText(getActivity(), dataSnapshot.toString(), Toast.LENGTH_LONG).show();
            ActivityModel activityModel = (ActivityModel) dataSnapshot.getValue();
            Log.w("tag ", dataSnapshot.getKey());
            Log.w("tag ",activityModel.getUser());
            Log.w("tag ", activityModel.getDate());
            Log.w("tag ", activityModel.getDuration());
        },throwable -> {
            Log.e("RxFirebaseSample", throwable.toString());
        });

        return view;
    }
}
