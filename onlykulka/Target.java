package pls.s226939.onlykulka;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Target extends View {

    Random rand = new Random();
    private Paint p2;
    public  int tar_pos_x;
    public  int tar_pos_y;
    public int tar_size=20;


    public Target(Context context, AttributeSet attr) {
        super(context, attr);


        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.BLUE);
    }

    public void setTargetPos()
    {
        tar_pos_x = 400;
        tar_pos_y = 200;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawCircle(tar_pos_x,tar_pos_y,tar_size,p2);
    }


    public Point getPos()
    {
        return new Point(tar_pos_x,tar_pos_y);
    }
}
