package com.example.smarthub;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ImageView likeImageView;
    boolean isLiked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeImageView = findViewById(R.id.imageNewsPost);

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