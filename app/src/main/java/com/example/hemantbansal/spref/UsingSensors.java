package com.example.hemantbansal.spref;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UsingSensors extends AppCompatActivity implements SensorEventListener{
    private Sensor msensor,stepDetector;
    private SensorManager msensorManager;
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_sensors);

        msensorManager=(SensorManager)getSystemService(UsingSensors.SENSOR_SERVICE);
        msensor=msensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        stepDetector=msensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

    }
    @Override
    protected void onResume(){
        super.onResume();
        msensorManager.registerListener(UsingSensors.this,msensor,SensorManager.SENSOR_DELAY_NORMAL);
        msensorManager.registerListener(UsingSensors.this,stepDetector,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause(){
        super.onPause();
        msensorManager.unregisterListener(UsingSensors.this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_PROXIMITY) {
            if (event.values[0] >= -0.01 && event.values[0] <= 0.01) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
                startActivity(intent);

            }
        }
        if(event.sensor.getType()==Sensor.TYPE_STEP_DETECTOR){
            if(f<2) {
                UtilMethods.toastS(UsingSensors.this, "detected");
                f++;
            }
            else{
                f=0;
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);

            }

            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);

        }

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
