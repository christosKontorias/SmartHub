package com.example.smarthub;

import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FlashlightActivity extends AppCompatActivity {

    private ImageButton toggleButton;
    private boolean hasCameraFlash = false;
    private boolean flashOn = false;
    private CameraManager cameraManager;
    private String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashlight);

        toggleButton = findViewById(R.id.toggleButton);
        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFlashlight();
            }
        });
    }

    private void toggleFlashlight() {
        if (hasCameraFlash) {
            if (flashOn) {
                flashOn = false;
                toggleButton.setImageResource(R.drawable.power_red_icon_128);
                flashLightOff();
            } else {
                flashOn = true;
                toggleButton.setImageResource(R.drawable.power_green_icon_128);
                flashLightOn();
            }
        } else {
            Toast.makeText(FlashlightActivity.this, "No flash available on your device", Toast.LENGTH_SHORT).show();
        }
    }

    private void flashLightOn() {
        try {
            cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            Toast.makeText(FlashlightActivity.this, "Flashlight is ON", Toast.LENGTH_SHORT).show();
        } catch (CameraAccessException e) {
            Log.e("Camera Problem", "Cannot turn on camera flashlight");
        }
    }

    private void flashLightOff() {
        try {
            cameraManager.setTorchMode(cameraId, false);
            Toast.makeText(FlashlightActivity.this, "Flashlight is OFF", Toast.LENGTH_SHORT).show();
        } catch (CameraAccessException e) {
            Log.e("Camera Problem", "Cannot turn off camera flashlight");
        }
    }
}