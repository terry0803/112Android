package com.example.spinneradapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private String[] courses,desserts;

    private Spinner spCourses, spDesserts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = getResources().getStringArray(R.array.courses);
        desserts = getResources().getStringArray(R.array.desserts);

        spCourses = (Spinner) findViewById(R.id.spinner);
        spDesserts = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adapterCourses = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        ArrayAdapter<String> adapterDesserts = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, desserts);

        spCourses.setAdapter(adapterCourses);
        spDesserts.setAdapter(adapterDesserts);

        Button btnConfirm = (Button) findViewById(R.id.button);

        btnConfirm.setOnClickListener(v -> {
            String course = spCourses.getSelectedItem().toString();
            String dessert = spDesserts.getSelectedItem().toString();
            TextView output = (TextView) findViewById(R.id.lblOutput);
            output.setText("您選擇的主菜是：" + course +"\n" +"您選擇的甜點是：" + dessert);
        });

        Button btnModify = (Button) findViewById(R.id.btnModify);

        btnModify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                desserts[4] = "草莓蛋糕";
                adapterDesserts.notifyDataSetChanged();
            }
        });
    }
}