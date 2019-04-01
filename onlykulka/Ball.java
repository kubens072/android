package pls.s226939.onlykulka;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class Ball extends View {

    private Paint p;
    public int pos_x=10;   //aktualna pozycja kulki w osi X
    public int pos_y=10;   //aktualna pozycja kulki w osi Y
    public int ball_size=10;   //rozmiar kulki
    int move_pos_x = 0; //zmienna przechowujaca ruch kulki z akcelometru w osi x
    int move_pos_y = 0; //zmienna przechowujaca ruch kulki z akcelometru w osi x

    public Ball(Context context,  AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.RED);
    }
    public void setMove_pos_x(int x)
    {
        move_pos_x=x;
    }
    public void setMove_pos_y(int y)
    {
        move_pos_y=y;
    }

    public void setCenterPos()
    {
        //pobieramy wysokosci szerokosc ekranu i dzielimy przez 2
        pos_x=getMeasuredWidthAndState()/2;
        pos_y=getMeasuredHeightAndState()/2;
    }

    //zmieniamy pozycje kulki w oparciu o akcelerometr
    public void move()
    {
        pos_x+=move_pos_x;
        pos_y+=move_pos_y;
    }
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        //i rysujemy nasza kulke w pozycji x i y
        canvas.drawCircle(pos_x,pos_y,ball_size,p);
    }

    public Point getPos()
    {
        return new Point(pos_x,pos_y);
    }

}
