package com.example.smarthub;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UnitsConverterActivity extends AppCompatActivity {

    EditText inputNumber;
    Spinner units;
    TextView km, m, cm, mm, microm, nm, mile, yard, foot, inch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units_converter);

        EditText inputNumber = findViewById(R.id.inputNumber);
        units = findViewById(R.id.units);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        microm = findViewById(R.id.microm);
        nm = findViewById(R.id.nm);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);

        String[] arr = {"km", "m", "cm", "mm", "microm", "nm", "mile", "yard", "foot", "inch"};
        units.setAdapter(new ArrayAdapter(UnitsConverterActivity.this, android.R.layout.simple_list_item_1, arr));

        units.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        inputNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                update();
            }
        });
    }

    private void update() {
        if (!inputNumber.getText().toString().isEmpty() && units.getSelectedItem() != null) {
            double inputValue = Double.parseDouble(inputNumber.getText().toString());
            String selectedUnit = units.getSelectedItem().toString();

            double inputInKm;
            switch (selectedUnit) {
                case "km":
                    inputInKm = inputValue;
                    break;
                case "m":
                    inputInKm = inputValue / 1000;
                    break;
                case "cm":
                    inputInKm = inputValue / 100000;
                    break;
                case "mm":
                    inputInKm = inputValue / 1000000;
                    break;
                case "microm":
                    inputInKm = inputValue / 1000000000;
                    break;
                case "nm":
                    inputInKm = inputValue / 1000000000000.0; // Corrected the conversion factor
                    break;
                case "mile":
                    inputInKm = inputValue * 1.609;
                    break;
                case "yard":
                    inputInKm = inputValue / 1094;
                    break;
                case "foot":
                    inputInKm = inputValue / 3281;
                    break;
                case "inch":
                    inputInKm = inputValue / 39370;
                    break;
                default:
                    return;
            }
            setKm(inputInKm);
        }
    }

    private void setKm(double km_in){
        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(km_in * 1000));
        cm.setText(String.valueOf(km_in * 100000));
        mm.setText(String.valueOf(km_in * 1000000));
        microm.setText(String.valueOf(km_in * 1000000000));
        nm.setText(String.valueOf(km_in * 1000000000000.0));
        mile.setText(String.valueOf(km_in / 1.609));
        yard.setText(String.valueOf(km_in * 1094));
        foot.setText(String.valueOf(km_in * 3281));
        inch.setText(String.valueOf(km_in * 39370));
    }
}