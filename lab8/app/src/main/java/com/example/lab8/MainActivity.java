package com.example.lab8;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity
{
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.Value);
    }
    public void inputNumber(View view)
    {
        Button b = (Button) view;
        String operation = b.getText().toString();
        if(operation.equals("Clear"))
            e1.setText("");
        else if (operation.equals("Save"))
        {
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.PHONE,e1.getText().toString());
            startActivity(intent);
        }
        else if (operation.equals("Call"))
        {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + e1.getText().toString()));
            startActivity(intent);
        }
        else
            e1.append(b.getText().toString());
    }
}
