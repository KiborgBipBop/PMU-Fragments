package com.example.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Selection extends Fragment {
    Button browse;
    Button add;
    Button close;
    ImageView image;
    Uri imageUri = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View V = inflater.inflate(R.layout.fragment_selection, container, false);
        image = (ImageView) V.findViewById(R.id.image_preview);
        browse = (Button) V.findViewById(R.id.browse);
        add = (Button) V.findViewById(R.id.add);
        close = (Button) V.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AddButton  f = new AddButton();
                fragmentTransaction.replace(R.id.top_layout, f);
                fragmentTransaction.commit();
            }
        });

        browse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                String[] mimeTypes = {"image/jpeg", "image/png"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
                startActivityForResult(intent, 0);
            }
        });

        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(imageUri == null)
                {
                    browse.setTextColor(Color.RED);
                    return;
                }
                else browse.setTextColor(Color.WHITE);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AddButton f = new AddButton();
                fragmentTransaction.replace(R.id.top_layout, f);
                fragmentTransaction.commit();
                MainActivity.gallery.addImage(imageUri);
            }
        });

        return V;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            // Для картинки
            case 0:
                if (resultCode == Activity.RESULT_OK)
                {
                    imageUri = data.getData();
                    image.setImageURI(imageUri);
                }
                break;
            case 1:
                if (resultCode == Activity.RESULT_OK)
                {
                    //musicUri = data.getData();
                }
                break;
        }
    }
}