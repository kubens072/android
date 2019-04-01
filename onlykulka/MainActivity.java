package pls.s226939.onlykulka;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private Ball kulka;
    private Target target;
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//wymuszenie trubu portretowego bez zmiany mozliwosci

        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//przypisanie do zmiennej sensor naszego akcelerometru

        kulka = findViewById(R.id.kulka); //przypisanie do zmiennej kulka naszez zmiennej po ID w activity main
        target = findViewById(R.id.target); //przypisanie do zmienne target naszej zmiennej po ID w activity main


        //Tworzymy naszą klasę z gra i przekazujemy potrzebne zmienne
        activity = new SensorActivity(kulka, target, new Handler());

        Thread thread = new Thread(activity);
        thread.start();

    }


    protected void onResume() {

        super.onResume();
        sensorManager.registerListener(activity, sensor, sensorManager.SENSOR_DELAY_GAME);
    }
    protected void onPause() {

        super.onPause();
        sensorManager.unregisterListener((SensorListener) activity);

    }
}
