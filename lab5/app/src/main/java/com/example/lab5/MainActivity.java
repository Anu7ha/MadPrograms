package com.example.lab5;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity
{
    int count=0;
    Timer mytimer = new Timer();;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.Value);
    }
    public void Counter(View view)
    {
        mytimer = new Timer();
        mytimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                t.setText(String.valueOf(count++));
            }
        },0,1000);
    }
    public void stop(View view)
    {
        mytimer.cancel();
    }
}