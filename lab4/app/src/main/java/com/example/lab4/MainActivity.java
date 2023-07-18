package com.example.lab4;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity
{
    Timer mytimer = new Timer();
    int[] id = new int[]{R.drawable.one,R.drawable.two,R.drawable.three};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setwallpaper(View view)
    {
        mytimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                Random r = new Random();
                try
                {
                    setWallpaper(((BitmapDrawable)getResources().getDrawable(id[r.nextInt(3)])).getBitmap());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        },0,5000);
    }
}