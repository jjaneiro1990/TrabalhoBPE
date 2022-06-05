package com.example.smartwatch;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.concurrent.ScheduledExecutorService;

public class SensorService extends Service implements SensorEventListener {
    private final static int SENS_ACCELEROMETER = Sensor.TYPE_ACCELEROMETER;
    private final static int SENS_TEMPERATURE = Sensor.TYPE_TEMPERATURE;
    private final static int SENS_GYROSCOPE = Sensor.TYPE_GYROSCOPE;
    private final static int SENS_STEP_COUNTER = Sensor.TYPE_STEP_COUNTER;
    private final static int SENS_HEARTRATE= Sensor.TYPE_HEART_RATE;

    SensorManager mSensorManager;
    private Sensor mSensor;
    private Watch relogio;
    private ScheduledExecutorService mScheduler;

    @Override
    public void onCreate(){
        super.onCreate();
        relogio = Watch.getInstance(this);

        Notification.Builder bu = new Notification.Builder(this);
        bu.setContentTitle("Recolhas de Dados");
        bu.setContentText("A recolher dados de sensor");
        bu.setSmallIcon(R.mipmap.ic_launcher);

        startForeground(1,bu.build());
        comecarMedicao();
    }

    private void comecarMedicao() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

