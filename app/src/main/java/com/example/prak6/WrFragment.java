package com.example.prak6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class WrFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wr, container, false);
        ImageView image = view.findViewById(R.id.wr_image);
        image.setImageResource(R.drawable.wr_image);

        return view;
    }
}
