package com.example.unitconverter.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.unitconverter.R;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        findViewById(R.id.btn_back_settings).setOnClickListener(v -> finish());
    }
}