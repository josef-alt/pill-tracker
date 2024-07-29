package com.example.pilltracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.pilltracker.database.DBHandler;

public class Settings extends AppCompatActivity {
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(click -> {
            showConfirmationDialog();
        });
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Clear All Data?");

        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            // TODO clear all data
            dialogInterface.dismiss();
        });

        builder.setNegativeButton("No", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });

        builder.show();
    }
}