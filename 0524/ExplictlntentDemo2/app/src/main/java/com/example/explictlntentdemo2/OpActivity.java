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
                double result = Double.NaN;  // Default to NaN to indicate unhandled cases
                RadioButton rdbAdd, rdbSubtract, rdbMultiply, rdbDivide;
                CheckBox chkDivide = (CheckBox) findViewById(R.id.chkDivide);

                Bundle bundle = OpActivity.this.getIntent().getExtras();
                if (bundle == null) return;

                int opd1 = Integer.parseInt(bundle.getString("OPERANDO1"));
                int opd2 = Integer.parseInt(bundle.getString("OPERANDO2"));

                rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
                rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
                rdbMultiply = (RadioButton) findViewById(R.id.rdbMultiply);
                rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);

                if (rdbAdd.isChecked()) {
                    result = opd1 + opd2;
                } else if (rdbSubtract.isChecked()) {
                    result = opd1 - opd2;
                } else if (rdbMultiply.isChecked()) {
                    result = opd1 * opd2;
                } else if (rdbDivide.isChecked()) {
                    chkDivide.setEnabled(true);
                    if (opd2 == 0) {
                        // Handle division by zero by showing an error or setting result to a specific value
                        result = Double.POSITIVE_INFINITY; // Example handling
                    } else if (chkDivide.isChecked()) {
                        result = opd1 / (double) opd2;
                    }
                }

                Intent rintent = new Intent();
                rintent.putExtra("RESULT", result);
                setResult(RESULT_OK, rintent);
                finish();
            }
        });
    }
}