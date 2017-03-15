package com.example.islam.project_management.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.islam.project_management.Activities.Login;
import com.example.islam.project_management.R;
import com.example.islam.project_management.RxFirebase.Authenticator;

/**
 * A placeholder fragment containing a simple view.
 */
public class SignupFragment extends Fragment {

    private EditText emailField;
    private EditText passField;
    private EditText confirmField;
    private Button signupButton;
    private EditText nameField1;
    private EditText nameField2;
    private ProgressDialog progressDialog;
    private String mail;
    private String pass;
    private String confirmPass;
    private String firstName;
    private String secondName;
    private Authenticator authenticator;

    public SignupFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        emailField = (EditText) view.findViewById(R.id.emailfield);
        passField = (EditText) view.findViewById(R.id.passfield);
        confirmField = (EditText) view.findViewById(R.id.confirmfield);
        nameField1 = (EditText) view.findViewById(R.id.firstname);
        nameField2 = (EditText) view.findViewById(R.id.secondname);
        signupButton = (Button) view.findViewById(R.id.signupbtn);
        progressDialog = new ProgressDialog(getActivity());
        authenticator = Authenticator.getInstance();

        signupButton.setOnClickListener(view1 -> {
            progressDialog.setTitle("loading");
            progressDialog.setMessage("please wait...");
            progressDialog.show();
            signup();
        });
        return view;
    }

    private void signup() {
        mail = emailField.getText().toString();
        pass = passField.getText().toString();
        confirmPass = confirmField.getText().toString();
        firstName = nameField1.getText().toString();
        secondName = nameField2.getText().toString();
        authenticator.createUser(getActivity(), mail, pass).subscribe(o -> {
            progressDialog.dismiss();
            Intent intent = new Intent(getActivity(), Login.class);
            startActivity(intent);
            getActivity().finish();
        });
    }
}
