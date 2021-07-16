package com.example.laburante.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.laburante.R;
import com.example.laburante.base.BaseActivity;
import com.example.laburante.base.BaseViewModel;
import com.example.laburante.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding,
        BaseViewModel> {
    ActivityMainBinding
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}