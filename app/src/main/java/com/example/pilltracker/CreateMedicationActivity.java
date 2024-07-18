package com.example.pilltracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.pilltracker.database.DBQueryHandler;

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

        // new medication insertion
        saveButton.setOnClickListener(event -> {
            // user input validation
            if(medName.getText().toString().isEmpty()) {
                return;
            }

            // insertion
            DBQueryHandler db = new DBQueryHandler(getApplicationContext());
            Medication newMed = new Medication(medName.getText().toString(), dosage.getText().toString(), reminder.getText().toString());

            // make sure insertion was successful before closing activity
            long code = db.insertMedication(newMed);
            Log.i("SQL", "New Med Id: " + code);
            if(code != -1) {
                setResult((int)code);
                finish();
            }
        });
    }
}