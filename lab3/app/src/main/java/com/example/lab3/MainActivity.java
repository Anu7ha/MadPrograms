package com.example.lab3;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity {
    EditText u,p;
    String RE = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u = findViewById(R.id.n1);
        p = findViewById(R.id.p1);
    }
    public void Check(View view)
    {
        if(validatePassword(p.getText().toString()))
        {
            Intent intent = new Intent(this,login.class);
            Bundle bundle=new Bundle();
            bundle.putString("Username",u.getText().toString());
            bundle.putString("password",p.getText().toString());
            intent.putExtra("data",bundle);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Invalid password",Toast.LENGTH_SHORT).show();
        }
    }
    public boolean validatePassword(String p)
    {
        Pattern pattern = Pattern.compile(RE);
        Matcher match = pattern.matcher(p);
        return match.matches();
    }
}
