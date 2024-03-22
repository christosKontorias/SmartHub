package com.example.smarthub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean isLiked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText searchEditText = findViewById(R.id.searchEditText);
        ImageView searchImageView = findViewById(R.id.searchImageView);
        LinearLayout linearLayoutCompass = findViewById(R.id.linearLayoutCompass);
        LinearLayout linearLayoutQRScanner = findViewById(R.id.linearLayoutQRScanner);
        LinearLayout linearLayoutCalculator = findViewById(R.id.linearLayoutCalculator);
        LinearLayout linearLayoutFlashlight = findViewById(R.id.linearLayoutFlashlight);
        LinearLayout linearLayoutCalendar = findViewById(R.id.linearLayoutCalendar);
        LinearLayout linearLayoutBMICalculator = findViewById(R.id.linearLayoutBMICalculator);
        LinearLayout linearLayoutClock = findViewById(R.id.linearLayoutClock);
        LinearLayout linearLayoutNotes = findViewById(R.id.linearLayoutNotes);
        LinearLayout linearLayoutFXConverter = findViewById(R.id.linearLayoutFXConverter);
        LinearLayout linearLayoutUnitsConverter = findViewById(R.id.linearLayoutUnitsConverter);
        ImageView likeImageView = findViewById(R.id.imageNewsPost);


        // Google Search Image Navigation
        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = searchEditText.getText().toString().trim();
                if (!searchQuery.isEmpty()) {
                    String searchUrl = "https://www.google.com/search?q=" + Uri.encode(searchQuery);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl));
                    startActivity(intent);
                }
            }
        });

        //Opens BMI Calculator Activity
        linearLayoutBMICalculator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, BMICalculatorActivity.class));
            }
        });

        //Opens Notes Activity
        linearLayoutNotes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, NotesActivity.class));
            }
        });

        //Opens Clock Activity
        linearLayoutClock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, ClockActivity.class));
            }
        });

        //Opens Calculator Activity
        linearLayoutCalculator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
            }
        });

        //Opens Flashlight Activity
        linearLayoutFlashlight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, FlashlightActivity.class));
            }
        });

        //Opens QR Scanner Activity
        linearLayoutQRScanner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, QRScannerActivity.class));
            }
        });

        //Opens FX Converter Activity
        linearLayoutFXConverter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, FXConverterActivity.class));
            }
        });

        //Opens Compass Activity
        linearLayoutCompass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, CompassActivity.class));
            }
        });

        //Opens Calendar Activity
        linearLayoutCalendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
            }
        });

        //Opens Units Converter Activity
        linearLayoutUnitsConverter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, UnitsConverterActivity.class));
            }
        });

        // Set OnClickListener to the ImageView
        likeImageView.setOnClickListener(view -> {
            // Toggle between the outline and filled heart images
            if (isLiked) {
                likeImageView.setImageResource(R.drawable.outline_heart_icon_24);
            } else {
                likeImageView.setImageResource(R.drawable.filled_heart_icon_24);
            }
            isLiked = !isLiked;
        });
    }
}