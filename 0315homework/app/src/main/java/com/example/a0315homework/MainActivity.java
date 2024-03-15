package com.example.a0315homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 預設的帳號和密碼
    private final String defaultAccount = "a111222027";
    private final String defaultPassword = "930803";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText accountEditText = findViewById(R.id.Textaccount); // 注意这里的ID应该是Textaccount，根据您的XML布局
        EditText passwordEditText = findViewById(R.id.Textpassword);
        Button enterButton = findViewById(R.id.enterbutton);
        TextView showTextView = findViewById(R.id.show);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputAccount = accountEditText.getText().toString();
                String inputPassword = passwordEditText.getText().toString();

                // 检查账号和密码是否匹配预设值
                if (defaultAccount.equals(inputAccount) && defaultPassword.equals(inputPassword)) {
                    showTextView.setText("登入成功"); // 或者直接用字符串 "登入成功"
                } else {
                    showTextView.setText("登入失敗"); // 或者直接用字符串 "登入失敗"
                }
            }
        });
    }
}
