package com.example.smarthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutCompass, linearLayoutCalculator, linearLayoutCalendar, linearLayoutClock, linearLayoutUnitsConverter;
    ImageView likeImageView;
    boolean isLiked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutCompass = findViewById(R.id.linearLayoutCompass);
        linearLayoutCalculator = findViewById(R.id.linearLayoutCalculator);
        linearLayoutCalendar = findViewById(R.id.linearLayoutCalendar);
        linearLayoutClock = findViewById(R.id.linearLayoutClock);
        linearLayoutUnitsConverter = findViewById(R.id.linearLayoutUnitsConverter);
        likeImageView = findViewById(R.id.imageNewsPost);


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