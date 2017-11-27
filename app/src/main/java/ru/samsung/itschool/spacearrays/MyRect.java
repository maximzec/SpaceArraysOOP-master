package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by student2 on 27.11.17.
 */

public class MyRect implements Drawable {
    float x , y , size = 20;
    Paint p = new Paint();

    public MyRect(float x,float y ) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(x,y,x+size,y+size,p);
    }
}
