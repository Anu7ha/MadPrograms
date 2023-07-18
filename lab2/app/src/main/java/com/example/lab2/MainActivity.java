package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    EditText a1,a2;
    TextView r1;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void calculate(View view){
        r1=findViewById(R.id.r1);
        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        Button button=(Button) view;
        if(button.getText().toString().equals("ADD")){
            a=Integer.parseInt(a1.getText().toString())+ Integer.parseInt(a2.getText().toString());
            r1.setText(Integer.toString(a));
        }
        else if(button.getText().toString().equals("SUB")){
            a=Integer.parseInt(a1.getText().toString())- Integer.parseInt(a2.getText().toString());
            r1.setText(Integer.toString(a));
        }
        else if(button.getText().toString().equals("MUL")){
            a=Integer.parseInt(a1.getText().toString())* Integer.parseInt(a2.getText().toString());
            r1.setText(Integer.toString(a));
        }
        else if (button.getText().toString().equals("DIV")){
            try {
                a = Integer.parseInt(a1.getText().toString()) / Integer.parseInt(a2.getText().toString());
                r1.setText(Integer.toString(a));
            }
            catch(Exception e){
                r1.setText("cannot be 0");
            }
        }
    }
}