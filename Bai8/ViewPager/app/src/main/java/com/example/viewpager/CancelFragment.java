package com.example.viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpager.databinding.FragmentCancelBinding;

public class CancelFragment extends Fragment {

    FragmentCancelBinding binding;

    public CancelFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCancelBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}