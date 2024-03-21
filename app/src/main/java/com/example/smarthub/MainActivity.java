package com.example.smarthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutBMICalculator, linearLayoutCompass, linearLayoutFlashlight, linearLayoutCalculator, linearLayoutNotes, linearLayoutFXConverter, linearLayoutCalendar, linearLayoutClock, linearLayoutUnitsConverter;
    ImageView likeImageView;
    boolean isLiked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutCompass = findViewById(R.id.linearLayoutCompass);
        linearLayoutCalculator = findViewById(R.id.linearLayoutCalculator);
        linearLayoutFlashlight = findViewById(R.id.linearLayoutFlashlight);
        linearLayoutCalendar = findViewById(R.id.linearLayoutCalendar);
        linearLayoutBMICalculator = findViewById(R.id.linearLayoutBMICalculator);
        linearLayoutClock = findViewById(R.id.linearLayoutClock);
        linearLayoutNotes = findViewById(R.id.linearLayoutNotes);
        linearLayoutFXConverter = findViewById(R.id.linearLayoutFXConverter);
        linearLayoutUnitsConverter = findViewById(R.id.linearLayoutUnitsConverter);
        likeImageView = findViewById(R.id.imageNewsPost);


        //Opens BMI Calculator Activity
        linearLayoutBMICalculator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, BMICalculatorActivity.class));
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

        //Opens Notes Activity
        linearLayoutNotes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, NotesActivity.class));
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

        //Opens Calendar Activity
        linearLayoutCalendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
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

        //Opens Clock Activity
        linearLayoutClock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, ClockActivity.class));
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

        //Opens Compass Activity
        linearLayoutCompass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Open new activity
                startActivity(new Intent(MainActivity.this, CompassActivity.class));
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
            isLiked = !isLiked; // Invert the liked status
        });
    }
}