package com.example.fragments;

import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.net.URI;
import java.util.HashMap;


public class Gallery extends Fragment {
    HashMap<ImageView, Uri> image_arr = new HashMap<>();
    private LinearLayout list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);
        list = view.findViewById(R.id.gallery_list);
        MainActivity.gallery = this;
        return view;
    }

    public void addImage(Uri imageURI){
        ImageView pic = new ImageView(getContext());
        pic.setImageURI(imageURI);
        list.addView(pic, 0);
    }
}