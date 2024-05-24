package com.example.explictlntentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
                EditText txtOpd2 = (EditText) findViewById(R.id.txtOpd2);

                Intent intent = new Intent(MainActivity.this, OpActivity.class);
                intent.putExtra("OPERANDO1", txtOpd1.getText().toString());
                intent.putExtra("OPERANDO2", txtOpd2.getText().toString());

                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getExtras() != null) {
            double result = data.getDoubleExtra("RESULT", Double.NaN);
            output.setText("計算結果: " + result);
        }
    }
}