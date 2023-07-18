package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText u,p;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        u = findViewById(R.id.n1);
        p = findViewById(R.id.p1);
    }
    public void Check(View view)
    {
        Bundle bundle=getIntent().getBundleExtra("data");
        String user= bundle.getString("Username");
        String password= bundle.getString("password");

        if(user.equals(u.getText().toString())) {
            if(password.equals(p.getText().toString())) {
                Intent intent = new Intent(this,loginS.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this,"Invalid password",Toast.LENGTH_SHORT).show();
                count++;
            }
        }
        else
        {
            Toast.makeText(this,"Invalid password",Toast.LENGTH_SHORT).show();
            count++;
        }
        if(count==2){
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
            Button button=(Button) view;
            button.setEnabled(false);
        }

    }
}
