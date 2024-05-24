package com.example.alertdialogdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectedItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_items);

        TextView txtSelectedItems = findViewById(R.id.txtSelectedItems);
        String selectedItems = getIntent().getStringExtra("selectedItems");
        txtSelectedItems.setText(selectedItems);
    }
}
