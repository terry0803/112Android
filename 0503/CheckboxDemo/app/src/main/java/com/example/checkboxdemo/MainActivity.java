package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener {
    private CheckBox chkOriginal, chkBeef, chkSeafood;
    private TextView output;

    private int[] chkIds = {R.id.chkOriginal, R.id.chkBeef, R.id.chkSeafood};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        chkOriginal = (CheckBox) findViewById(R.id.chkOriginal);
//        chkBeef = (CheckBox) findViewById(R.id.chkBeef);
//        chkSeafood = (CheckBox) findViewById(R.id.chkSeafood);

      for(int chkId : chkIds) {
        CheckBox chk = (CheckBox) findViewById(chkId);
        chk.setOnCheckedChangeListener(this);
      }

        output = (TextView) findViewById(R.id.lblOutput);

//        Button btnConfirm = (Button) findViewById(R.id.button);
//        btnConfirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 設定顯示字串
//                String str = "";
//                if (chkOriginal.isChecked()) {
//                    str += chkOriginal.getText() + "\n";
//                }
//                if (chkBeef.isChecked()) {
//                    str += chkBeef.getText() + "\n";
//                }
//                if (chkSeafood.isChecked()) {
//                    str += chkSeafood.getText() + "\n";
//                }
//                // 設置輸出內容
//                output.setText(str);
//            }
//        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        TextView txvStatus = (TextView) findViewById(R.id.txvStatus);
        int chkId = buttonView.getId();
        String str = "";
        String status = "";
        if (chkId == R.id.chkOriginal) {
            status = (isChecked ? "選取" : "取消") + "原味...";
        } else if (chkId == R.id.chkBeef) {
            status = (isChecked ? "選取" : "取消") + "牛肉...";
        } else if (chkId == R.id.chkSeafood) {
            status = (isChecked ? "選取" : "取消") + "海鮮...";
        }
        txvStatus.setText(status);

        showResult();
    }

    public void showResult() {
        String str = "";
        for(int chkId : chkIds) {
          CheckBox chk = (CheckBox) findViewById(chkId);
          if (chk.isChecked()) {
              str += chk.getText() + "\n";
          }
        }
        output.setText(str);
    }
}