package com.example.bancomillba_v1.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bancomillba_v1.R;

public class SettingsActiviti extends AppCompatActivity {
    @SuppressLint("ResourceType")
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.xml.root_preferences);
    }
}
