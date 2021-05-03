package com.example.fragments;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class Login extends Fragment {
    private String myEmail = "qwe";
    private String myPassword = "123";
    EditText emailAddressField;
    EditText passwordField;
    Button bLogin, bRegister;
    private HashMap<String, String> users = new HashMap<>();

    DialogMessage dialogMessage = new DialogMessage();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, null);
        emailAddressField = (EditText) v.findViewById(R.id.email);
        passwordField = (EditText) v.findViewById(R.id.password);
        bLogin = (Button) v.findViewById(R.id.login);
        bRegister = (Button) v.findViewById(R.id.register);
        users.put(myEmail, myPassword);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
        return v;
    }

    public void signUp(){
        Registration f = new Registration();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_layout, f);
        transaction.commit();
    }

    public void signIn(){
        String inputEmail = String.valueOf(emailAddressField.getText());
        String inputPassword = String.valueOf(passwordField.getText());

        if(users.containsKey(inputEmail)) {
            if(users.get(inputEmail).equals(inputPassword))
            {
                loadGallery();
            }
            else
            {
                dialogMessage.title="Invalid password.";
                dialogMessage.show(getFragmentManager(), "t");
            }
        }
        else
        {
            dialogMessage.title="The email you provided has not been registered.";
            dialogMessage.show(getFragmentManager(), "r");
        }
    }

    public void loadGallery(){
        AddButton buttonF = new AddButton();
        Gallery galleryF = new Gallery();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.top_layout, buttonF);
        transaction.add(R.id.main_layout, galleryF);
        transaction.remove(this);
        transaction.commit();
    }
}