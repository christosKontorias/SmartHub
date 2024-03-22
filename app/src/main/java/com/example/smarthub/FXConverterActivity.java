package com.example.smarthub;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class FXConverterActivity extends AppCompatActivity {
    TextView convertFromDropdownTextView, convertToDropdownTextView, conversionRateText;
    EditText amountToConvert;
    ArrayList<String> arrayList;
    Dialog fromDialog;
    Dialog toDialog;
    Button convertButton;
    String convertFromValue, convertToValue, conversionValue;
    String[] country = {"EUR", "USD", "GBP", "KWD", "INR", "CAD", "JPY", "ALL", "ARs", "AUD", "EGP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fxconverter);

        convertFromDropdownTextView = findViewById(R.id.convert_from_dropdown_menu);
        convertToDropdownTextView = findViewById(R.id.convert_to_dropdown_menu);
        convertButton = findViewById(R.id.conversionButton);
        conversionRateText = findViewById(R.id.conversionRateText);
        amountToConvert = findViewById(R.id.amountToConvertValueEditText);

        arrayList = new ArrayList<>();
        for (String i : country){
            arrayList.add(i);
        }

        convertFromDropdownTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDialog = new Dialog(FXConverterActivity.this);
                fromDialog.setContentView(R.layout.from_spinner);
                fromDialog.getWindow().setLayout(650,800);
                fromDialog.show();

                EditText editText = fromDialog.findViewById(R.id.edit_text);
                ListView listView = fromDialog.findViewById(R.id.list_view);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(FXConverterActivity.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(adapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }
                    @Override
                    public void afterTextChanged(Editable s) {}
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        convertFromDropdownTextView.setText(adapter.getItem(position));
                        fromDialog.dismiss();
                        convertFromValue = adapter.getItem(position);
                    }
                });
            }
        });

        convertToDropdownTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDialog = new Dialog(FXConverterActivity.this);
                toDialog.setContentView(R.layout.to_spinner);
                toDialog.getWindow().setLayout(650,800);
                toDialog.show();

                EditText editText = toDialog.findViewById(R.id.edit_text);
                ListView listView = toDialog.findViewById(R.id.list_view);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(FXConverterActivity.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(adapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }
                    @Override
                    public void afterTextChanged(Editable s) {}
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        convertToDropdownTextView.setText(adapter.getItem(position));
                        toDialog.dismiss();
                        convertToValue = adapter.getItem(position);
                    }
                });
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double amountToConvert = Double.valueOf(FXConverterActivity.this.amountToConvert.getText().toString());
                    //getConversionRate(convertFromValue, convertToValue, amountToConvert);
                    convertCurrency();
                }catch (Exception e){}
            }
        });
    }

    private void convertCurrency() {
        double conversionRate = getConversionRate(convertFromValue, convertToValue);
        if (conversionRate != -1) {
            double amount = Double.parseDouble(amountToConvert.getText().toString());
            double convertedAmount = amount * conversionRate;
            conversionValue = String.valueOf(round(convertedAmount, 2));
            conversionRateText.setText(conversionValue);
        } else {
        }
    }

    private double getConversionRate(String convertFrom, String convertTo) {
        return switch (convertFrom) {
            case "EUR" -> switch (convertTo) {
                case "USD" -> 1.18;
                case "GBP" -> 0.85;
                case "KWD" -> 0.36;
                case "INR" -> 88.08;
                case "CAD" -> 1.46;
                case "JPY" -> 129.98;
                case "ALL" -> 123.62;
                case "ARS" -> 115.97;
                case "AUD" -> 1.57;
                case "EGP" -> 18.56;
                default -> -1;
            };
            case "USD" -> switch (convertTo) {
                case "EUR" -> 0.85;
                case "GBP" -> 0.72;
                case "KWD" -> 0.30;
                case "INR" -> 73.97;
                case "CAD" -> 1.25;
                case "JPY" -> 111.72;
                case "ALL" -> 106.59;
                case "ARS" -> 100.30;
                case "AUD" -> 1.36;
                case "EGP" -> 16.09;
                default -> -1;
            };
            case "GBP" -> switch (convertTo) {
                case "EUR" -> 1.18;
                case "USD" -> 1.39;
                case "KWD" -> 0.42;
                case "INR" -> 103.50;
                case "CAD" -> 1.72;
                case "JPY" -> 152.55;
                case "ALL" -> 144.82;
                case "ARS" -> 136.49;
                case "AUD" -> 1.85;
                case "EGP" -> 21.83;
                default -> -1;
            };
            case "KWD" -> switch (convertTo) {
                case "EUR" -> 2.77;
                case "USD" -> 3.31;
                case "GBP" -> 2.38;
                case "INR" -> 251.62;
                case "CAD" -> 4.13;
                case "JPY" -> 366.84;
                case "ALL" -> 349.10;
                case "ARS" -> 328.92;
                case "AUD" -> 4.46;
                case "EGP" -> 52.68;
                default -> -1;
            };
            case "INR" -> switch (convertTo) {
                case "EUR" -> 0.011;
                case "USD" -> 0.014;
                case "GBP" -> 0.0096;
                case "KWD" -> 0.004;
                case "CAD" -> 0.018;
                case "JPY" -> 1.61;
                case "ALL" -> 1.53;
                case "ARS" -> 1.44;
                case "AUD" -> 0.019;
                case "EGP" -> 0.22;
                default -> -1;
            };
            case "ALL" -> switch (convertTo) {
                case "EUR" -> 0.0084;
                case "USD" -> 0.01;
                case "GBP" -> 0.007;
                case "KWD" -> 0.003;
                case "INR" -> 0.69;
                case "CAD" -> 0.012;
                case "JPY" -> 1.05;
                case "ARS" -> 0.94;
                case "AUD" -> 0.013;
                case "EGP" -> 0.15;
                default -> -1;
            };
            case "ARS" -> switch (convertTo) {
                case "EUR" -> 0.012;
                case "USD" -> 0.014;
                case "GBP" -> 0.01;
                case "KWD" -> 0.004;
                case "INR" -> 0.87;
                case "CAD" -> 0.013;
                case "JPY" -> 1.12;
                case "ALL" -> 1.06;
                case "AUD" -> 0.014;
                case "EGP" -> 0.17;
                default -> -1;
            };
            case "AUD" -> switch (convertTo) {
                case "EUR" -> 0.58;
                case "USD" -> 0.69;
                case "GBP" -> 0.50;
                case "KWD" -> 0.21;
                case "INR" -> 46.25;
                case "CAD" -> 0.92;
                case "JPY" -> 81.88;
                case "ALL" -> 78.11;
                case "ARS" -> 73.28;
                case "EGP" -> 8.63;
                default -> -1;
            };
            case "EGP" -> switch (convertTo) {
                case "EUR" -> 0.046;
                case "USD" -> 0.055;
                case "GBP" -> 0.039;
                case "KWD" -> 0.016;
                case "INR" -> 3.52;
                case "CAD" -> 0.078;
                case "JPY" -> 7.10;
                case "ALL" -> 6.75;
                case "ARS" -> 6.37;
                case "AUD" -> 0.12;
                default -> -1;
            };
            case "CAD" -> switch (convertTo) {
                case "EUR" -> 0.68;
                case "USD" -> 0.81;
                case "GBP" -> 0.58;
                case "KWD" -> 0.24;
                case "INR" -> 52.94;
                case "JPY" -> 89.35;
                case "ALL" -> 84.95;
                case "ARS" -> 80.11;
                case "AUD" -> 1.09;
                case "EGP" -> 12.87;
                default -> -1;
            };
            case "JPY" -> switch (convertTo) {
                case "EUR" -> 0.0077;
                case "USD" -> 0.0092;
                case "GBP" -> 0.0066;
                case "KWD" -> 0.0027;
                case "INR" -> 0.62;
                case "CAD" -> 0.011;
                case "ALL" -> 0.95;
                case "ARS" -> 0.89;
                case "AUD" -> 0.012;
                case "EGP" -> 0.14;
                default -> -1;
            };
            default -> -1;
        };
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
