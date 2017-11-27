package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.EventLog;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyDraw extends View implements View.OnClickListener{

	ArrayList objects = new ArrayList();

	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		makeSky();
		this.rocket = new Rocket(BitmapFactory.decodeResource(getResources(), R.drawable.rocket));
		this.rocket2 = new CtrlRocket(BitmapFactory.decodeResource(getResources(), R.drawable.rocket));
		objects.add(new Square(20,100));
		objects.add(new Square(20,50));
		objects.add(new MyRect(30,230));
		objects.add(new MyRect(1200,550));
		objects.add(new Rocket ((BitmapFactory.decodeResource(getResources(),R.drawable.rocket))));

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.rocket2.SetTarget(event.getX(),event.getY());
		this.rocket2.toX = event.getX();
		this.rocket2.toY = event.getY();
		for(Object object:objects){
			if(object instanceof Touchable){
				((Touchable)object).onTouch(event);
			}
		}
		return super.onTouchEvent(event);
	}

	Rocket rocket;
	CtrlRocket rocket2;



	Paint paint = new Paint();
	@Override
	protected void onDraw(Canvas canvas) {
		for(Object object : objects){
			if (object instanceof Drawable){
				((Drawable)object).draw(canvas);
				invalidate();
			}
		}
		//drawSky(canvas);
		//rocket.draw(canvas);
		//rocket2.draw(canvas);
		//rocket.move();
		//rocket2.move();


		// Запрос на перерисовку экрана
		invalidate();
	}
	
	final int numStars = 500;
	
	int xStar[] = new int[numStars];
	int yStar[] = new int[numStars];
	int alphaStar[] = new int[numStars];
	
	void makeSky()
	{
		// Звезды генерируются в зоне maxX на maxY
		int maxX = 2000;
		int maxY = 2000;
		for (int i = 0; i < numStars; i++)
		{	
		   xStar[i] = (int)(Math.random() * maxX);
		   yStar[i] = (int)(Math.random() * maxY);
		   alphaStar[i] = (int)(Math.random() * 256);
		}   
	}
	
	void drawSky(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		paint.setColor(Color.YELLOW);
		paint.setStrokeWidth(2);
		for (int i = 0; i < numStars; i++)
		{	
		   paint.setAlpha(alphaStar[i]);
		   alphaStar[i] += (int)(Math.random() * 11) - 5;
		   if (alphaStar[i] > 255) alphaStar[i] = 255;
		   if (alphaStar[i] < 0) alphaStar[i] = 0;
		   canvas.drawCircle(xStar[i], yStar[i], 3, paint);
		}   
	}

	@Override
	public void onClick(View view) {
		objects.clear();
	}
}
