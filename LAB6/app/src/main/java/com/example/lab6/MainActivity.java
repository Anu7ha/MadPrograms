package com.example.lab6;
import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.view.View;
import android.widget.*;
import org.json.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;

public class MainActivity extends AppCompatActivity {
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
    }
    public void parsexml(View view) {
        try {
            InputStream is = getAssets().open("city.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(is);
            NodeList nodeList = document.getElementsByTagName("place");
            StringBuilder stringBuilder = new StringBuilder("XML DATA\n---------");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                stringBuilder.append("\nName: ").append(getValue("name", element));
                stringBuilder.append("\nLatitude: ").append(getValue("lat", element));
                stringBuilder.append("\nLongitude: ").append(getValue("long", element));
                stringBuilder.append("\nTemperature: ").append(getValue("temperature", element));
                stringBuilder.append("\nHumidity: ").append(getValue("humidity", element));
                stringBuilder.append("\n----------");
            }
            display.setText(stringBuilder.toString());
        } catch (Exception e) {
            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
        }
    }

    public void parsejson(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        try
            (InputStream is = getAssets().open("city.json");
             Scanner scanner = new Scanner(is).useDelimiter("\\A"))
                {
                    String json = scanner.hasNext() ? scanner.next() : "";
                    JSONArray jsonArray = new JSONArray(json);
                    stringBuilder.append("JSON DATA\n--------");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        stringBuilder.append(String.format("\nName: %s\nLatitude: %s\nLongitude: %s\nTemperature: %s\nHumidity: %s\n----------",
                                jsonObject.getString("name"),
                                jsonObject.getString("lat"),
                                jsonObject.getString("long"),
                                jsonObject.getString("temperature"),
                                jsonObject.getString("humidity")));

                    display.setText(stringBuilder.toString());
                }
        } catch (Exception e) {
            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
        }
    }

    private String getValue(String tag, Element element)
    {
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}