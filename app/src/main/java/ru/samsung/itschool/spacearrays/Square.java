package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by student2 on 27.11.17.
 */

public class Square implements Drawable,Touchable{
    float x, y, r = 20;
    Paint p = new Paint();

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, r, p);
    }
    public Square(float x , float y ){
        this.x= x;
        this.y=y;
    }

    @Override
    public void onTouch(MotionEvent event) {
        this.r*=1.5;
    }
}
