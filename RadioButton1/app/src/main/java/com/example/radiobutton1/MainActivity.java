package com.example.radiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String outputStr = "";
                RadioButton rdbBoy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton rdbGirl = (RadioButton) findViewById(R.id.rdbGirl);
                if(rdbBoy.isChecked())
                    outputStr += getResources().getString(R.string.male)+"\n";
                else if(rdbGirl.isChecked())
                    outputStr += getResources().getString(R.string.female)+"\n";

                RadioGroup rgType = (RadioGroup) findViewById(R.id.rgType);

                if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    outputStr += getResources().getString(R.string.regularticket) + "\n";
                } else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
                    outputStr += getResources().getString(R.string.childticket) + "\n";
                } else {
                    outputStr += getResources().getString(R.string.studentticket) + "\n";
                }
                TextView lbloutput = (TextView) findViewById(R.id.lblOutput);
                lbloutput.setText(outputStr);
            }
        });
    }
}