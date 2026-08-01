package com.example.unitconverter.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unitconverter.R;
import com.example.unitconverter.database.DatabaseHelper;
import com.example.unitconverter.utils.ConverterUtils;

import java.util.Locale;

public class ConverterActivity extends AppCompatActivity {

    private String category;
    private Spinner spinnerFrom, spinnerTo;
    private EditText etInput;
    private TextView tvOutput;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        category = getIntent().getStringExtra("CATEGORY");
        dbHelper = new DatabaseHelper(this);
        
        initViews();
        setupSpinners();
        setupListeners();
    }

    private void initViews() {
        spinnerFrom = findViewById(R.id.spinner_from);
        spinnerTo = findViewById(R.id.spinner_to);
        etInput = findViewById(R.id.et_input);
        tvOutput = findViewById(R.id.tv_output);
        TextView tvTitle = findViewById(R.id.tv_category_title);
        
        tvTitle.setText(category);
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
        
        findViewById(R.id.btn_reset).setOnClickListener(v -> {
            etInput.setText("");
            tvOutput.setText("0.0");
        });

        findViewById(R.id.fab_swap).setOnClickListener(v -> {
            int fromPos = spinnerFrom.getSelectedItemPosition();
            int toPos = spinnerTo.getSelectedItemPosition();
            spinnerFrom.setSelection(toPos);
            spinnerTo.setSelection(fromPos);
            performConversion();
        });

        findViewById(R.id.btn_copy).setOnClickListener(v -> {
            String result = tvOutput.getText().toString();
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Conversion Result", result);
            if (clipboard != null) {
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
            
            String inputStr = etInput.getText().toString();
            if (!inputStr.isEmpty()) {
                dbHelper.addHistory(category, spinnerFrom.getSelectedItem().toString(), 
                        spinnerTo.getSelectedItem().toString(), inputStr, result);
            }
        });
    }

    private void setupSpinners() {
        int arrayResId;
        if (category.equals(getString(R.string.cat_length))) arrayResId = R.array.units_length;
        else if (category.equals(getString(R.string.cat_weight))) arrayResId = R.array.units_weight;
        else if (category.equals(getString(R.string.cat_area))) arrayResId = R.array.units_area;
        else if (category.equals(getString(R.string.cat_volume))) arrayResId = R.array.units_volume;
        else if (category.equals(getString(R.string.cat_data))) arrayResId = R.array.units_data;
        else if (category.equals(getString(R.string.cat_time))) arrayResId = R.array.units_time;
        else if (category.equals(getString(R.string.cat_speed))) arrayResId = R.array.units_speed;
        else if (category.equals(getString(R.string.cat_pressure))) arrayResId = R.array.units_pressure;
        else if (category.equals(getString(R.string.cat_energy))) arrayResId = R.array.units_energy;
        else if (category.equals(getString(R.string.cat_power))) arrayResId = R.array.units_power;
        else if (category.equals(getString(R.string.cat_angle))) arrayResId = R.array.units_angle;
        else if (category.equals(getString(R.string.cat_fuel))) arrayResId = R.array.units_fuel;
        else if (category.equals(getString(R.string.cat_frequency))) arrayResId = R.array.units_frequency;
        else if (category.equals(getString(R.string.cat_force))) arrayResId = R.array.units_force;
        else if (category.equals(getString(R.string.cat_density))) arrayResId = R.array.units_density;
        else if (category.equals(getString(R.string.cat_cooking))) arrayResId = R.array.units_cooking;
        else arrayResId = R.array.units_temperature;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                arrayResId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
    }

    private void setupListeners() {
        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { performConversion(); }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        AdapterView.OnItemSelectedListener itemListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { performConversion(); }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        };

        spinnerFrom.setOnItemSelectedListener(itemListener);
        spinnerTo.setOnItemSelectedListener(itemListener);
    }

    private void performConversion() {
        String inputStr = etInput.getText().toString();
        if (inputStr.isEmpty()) {
            tvOutput.setText("0.0");
            return;
        }

        try {
            double inputValue = Double.parseDouble(inputStr);
            String fromUnit = spinnerFrom.getSelectedItem().toString();
            String toUnit = spinnerTo.getSelectedItem().toString();
            double result = 0;

            if (category.equals(getString(R.string.cat_length))) result = ConverterUtils.convertLength(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_weight))) result = ConverterUtils.convertWeight(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_temperature))) result = ConverterUtils.convertTemperature(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_area))) result = ConverterUtils.convertArea(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_volume))) result = ConverterUtils.convertVolume(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_data))) result = ConverterUtils.convertData(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_time))) result = ConverterUtils.convertTime(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_speed))) result = ConverterUtils.convertSpeed(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_pressure))) result = ConverterUtils.convertPressure(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_energy))) result = ConverterUtils.convertEnergy(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_power))) result = ConverterUtils.convertPower(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_angle))) result = ConverterUtils.convertAngle(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_fuel))) result = ConverterUtils.convertFuel(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_frequency))) result = ConverterUtils.convertFrequency(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_force))) result = ConverterUtils.convertForce(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_density))) result = ConverterUtils.convertDensity(inputValue, fromUnit, toUnit);
            else if (category.equals(getString(R.string.cat_cooking))) result = ConverterUtils.convertCooking(inputValue, fromUnit, toUnit);

            tvOutput.setText(String.format(Locale.getDefault(), "%.4f", result));
        } catch (NumberFormatException e) {
            tvOutput.setText("Error");
        }
    }
}