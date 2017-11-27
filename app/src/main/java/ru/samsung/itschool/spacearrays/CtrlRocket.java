package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;

/**
 * Created by student2 on 10.11.17.
 */

public class CtrlRocket extends Rocket {
    float toX,toY;
    public void SetTarget(float toX,float toY){
        this.toX=toX;
        this.toY=toY;
        float d = (float)Math.sqrt((toX-x)*(toX-x)+(toY-y)*(toY-y));
        vx = ((toX - x)/d)*10;
        vy = ((toY - y)/d)*10;

    }

    CtrlRocket(Bitmap pic) {
        super(pic);
        toX=this.x;
        toY=this.y;
    }
    void move(){

        if (((toX - x)*(toX-x) + (toY-y)*(toY-y))<10 ){
            vx=0;
            vy=0;
        }

        super.move();
    }

}
