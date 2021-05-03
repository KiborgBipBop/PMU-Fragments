package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AddButton extends Fragment {
    Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_button, container, false);
        addButton = (Button) view.findViewById(R.id.add);

        addButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            FragmentManager fragmentManager =  getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Selection f = new Selection();
            fragmentTransaction.replace(R.id.top_layout, f);
            fragmentTransaction.commit();
        }
    });
        return view;
    }
}