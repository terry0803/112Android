package com.example.explictlntentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class OpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = 0.0;
                RadioButton rdbAdd, rdbSubtract, rdbMultiply, rdbDivide;
                CheckBox chkDivide;

                Bundle bundle = OpActivity.this.getIntent().getExtras();
                if (bundle == null) return;

                int opd1 = Integer.parseInt(bundle.getString("OPERANDO1"));
                int opd2 = Integer.parseInt(bundle.getString("OPERANDO2"));

                rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
                if (rdbAdd.isChecked()) {
                    result = opd1 + opd2;  // Addition
                }

                rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
                if (rdbSubtract.isChecked()) {
                    result = opd1 - opd2;  // Subtraction
                }
                rdbMultiply = (RadioButton) findViewById(R.id.rdbMultiply);
                if (rdbMultiply.isChecked()) {
                    result = opd1 * opd2;  // Multiplication
                }

                rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);
                chkDivide = (CheckBox) findViewById(R.id.chkDivide);
                if (rdbDivide.isChecked()) {
                    if (chkDivide.isChecked() && opd2 != 0) {
                        result = opd1 / (double) opd2;  // Division with double result
                    } else if (opd2 != 0) {
                        result = opd1 / opd2;  // Integer division
                    } else {
                        // Handle division by zero if necessary
                        // This could be showing a message or setting a specific error result
                    }
                }

                Intent rintent = new Intent();
                Bundle rbundle = new Bundle();
                rbundle.putDouble("RESULT", result);
                rintent.putExtras(rbundle);
                setResult(RESULT_OK, rintent);  // Set the result for the parent activity
                finish();  // Close this activity
            }
        });
    }
}