package com.example.alertdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private String[] items = {"Samsung","Apple","HTC","Asus"};
    private boolean[] itemsChecked = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("關於本書")
                        .setMessage("Android程式設計與應用\n作者：陳會安\n教師:恰克虎")
                        .setCancelable(true)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("退出")
                        .setMessage("確定要退出嗎？")
                        .setCancelable(false)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "取消退出", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        Button btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("選擇顏色")
                        .setItems(new String[]{"红色", "黄色", "绿色"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Button btnColor = (Button) findViewById(R.id.btnColor);
                                switch (which) {
                                    case 0:
                                        btnColor.setBackgroundColor(Color.RED);
                                        break;
                                    case 1:
                                        btnColor.setBackgroundColor(Color.YELLOW);
                                        break;
                                    case 2:
                                        btnColor.setBackgroundColor(Color.GREEN);
                                        break;
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "您取消了选择！", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("請勾選選項?")
                        .setPositiveButton("確定", MainActivity.this)
                        .setNegativeButton("取消", MainActivity.this)
                        .setMultiChoiceItems(items, itemsChecked, null)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
//        switch (which) {
//            case DialogInterface.BUTTON_POSITIVE:
//                finish();
//                break;
//            case DialogInterface.BUTTON_NEGATIVE:
//                Toast.makeText(this, "取消退出", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        Button btnColor = (Button) findViewById(R.id.btnColor);
//        switch (which) {
//            case 0:
//                btnColor.setBackgroundColor(Color.RED);
//                break;
//            case 1:
//                btnColor.setBackgroundColor(Color.YELLOW);
//                break;
//            case 2:
//                btnColor.setBackgroundColor(Color.GREEN);
//                break;
//        }

        String msg = "";
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                for (int index = 0; index < items.length; index++) {
                    if (itemsChecked[index]) {
                        msg += items[index] + "\n";
                    }
                }
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(msg);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this, "您取消了選擇！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}