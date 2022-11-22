package com.example.cap3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cap3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
public class FragmentShare extends Fragment {
    private FloatingActionButton fab1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_fragment_share,container,false);
    }
    /*public View inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)*/
}