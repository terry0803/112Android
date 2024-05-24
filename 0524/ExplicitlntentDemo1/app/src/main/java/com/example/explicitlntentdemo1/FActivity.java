package com.example.explicitlntentdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factivity);

        convertTemperature();

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Closes the current activity
            }
        });
    }

    private void convertTemperature() {
        int c;
        double f = 0.0;
        String place = "";
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            c = bundle.getInt("TEMPC", 0);  // Gets the integer from the bundle with default value 0
            f = (9.0 / 5.0) * c + 32.0;    // Converts Celsius to Fahrenheit
            place = bundle.getString("PLACE", "");  // Gets the string from the bundle with default value empty string

            TextView output = (TextView) findViewById(R.id.lblOutput);
            output.setText(place + "\n華氏溫度: " + Double.toString(f));
        }
    }
}