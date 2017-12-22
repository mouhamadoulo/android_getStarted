package com.example.ibrahim.getstartedapp;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText ed;
    Button btn;
    TextView resultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.mytextview);
        ed = (EditText) findViewById(R.id.myedittext);
        btn = (Button) findViewById(R.id.mybutton);
        resultat = (TextView) findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultat.setText("Votre réponse : "+ed.getText());
            }
        });

        //Liste des capteurs disponibles sur un device
        SensorManager sm = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        List<Sensor> availableSensors = sm.getSensorList(Sensor.TYPE_ALL);
        ListIterator li = availableSensors.listIterator();
        Log.i("LISTE","Liste des capteurs du téléphone");
        while(li.hasNext()){
            String nomSensor = ""+li.next();
            Log.i("SENSOR "+li.nextIndex(),nomSensor);
        }

    }


}
