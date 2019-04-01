package pls.s226939.onlykulka;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;

import android.os.Handler;

public class SensorActivity implements Runnable, SensorListener, SensorEventListener {

    Ball ball;
    Target target;
    Handler handler;


int a = 10;

    public SensorActivity(Ball b, Target t, Handler h)
    {
        ball = b;
        target = t;
        handler = h;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        ball.setMove_pos_x((int) Math.ceil(-event.values[0]));
        ball.setMove_pos_y((int) Math.ceil(event.values[1]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(int sensor, float[] values) {

    }

    @Override
    public void onAccuracyChanged(int sensor, int accuracy) {

    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            target.setTargetPos();
            ball.setCenterPos();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true)
        {
            try{
                Thread.sleep(a);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        target.invalidate();
                        ball.move();
                        ball.invalidate();

                        if(ball.getPos().x==target.getPos().y && ball.getPos().y==target.getPos().y)
                        {
                            a+=50;
                        }

                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
