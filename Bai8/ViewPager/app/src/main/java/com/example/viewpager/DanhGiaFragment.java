package com.example.viewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpager.databinding.FragmentDanhGiaBinding;

public class DanhGiaFragment extends Fragment {

    FragmentDanhGiaBinding binding;

    public DanhGiaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDanhGiaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}