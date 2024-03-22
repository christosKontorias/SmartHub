package com.example.smarthub;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;


public class CompassActivity extends AppCompatActivity implements SensorEventListener {
    ImageView imageViewCompass;
    TextView textViewDegrees;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        imageViewCompass = findViewById(R.id.imageViewCompass);
        textViewDegrees = findViewById(R.id.textViewDegrees);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s: sensorList){
            Log.d("Sensor", s.toString());
        }
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        int degrees = Math.round(event.values[0]);
        textViewDegrees.setText("Degree's: " + degrees + "°");
        imageViewCompass.setRotation(-degrees);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}