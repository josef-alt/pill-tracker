package com.example.pilltracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CreateMedicationActivity extends AppCompatActivity {
    private EditText medName, dosage, supply, reminder;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_medication);

        medName = findViewById(R.id.editName);
        dosage = findViewById(R.id.editDose);
        supply = findViewById(R.id.editSupply);
        reminder = findViewById(R.id.editReminder);
        saveButton = findViewById(R.id.saveButton);
    }
}