package com.example.pilltracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pilltracker.database.DBQueryHandler;
import com.example.pilltracker.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int CREATE_MEDICATION_REQUEST = 100;

    private ActivityMainBinding binding;
    private RecyclerView medicationsRV;
    private MedicationRVA adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // launch new medication activity
        binding.fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CreateMedicationActivity.class);
            startActivityForResult(intent, 1);
        });

        medicationsRV = findViewById(R.id.medicationsRV);
        adapter = new MedicationRVA(this);
        loadRecyclerView();
    }

    // reload recycler view when meds have been successfully inserted
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case CREATE_MEDICATION_REQUEST:
                if (resultCode == CreateMedicationActivity.SUCCESS) {
                    loadRecyclerView();
                }
                break;
        }
    }

    // retrieve meds and fill rv
    private void loadRecyclerView() {
        DBQueryHandler queryHandler = new DBQueryHandler(this);
        ArrayList<Medication> medsList = new ArrayList<>(queryHandler.getAllMedications());
        adapter.setMedications(medsList);
        medicationsRV.setAdapter(adapter);
        medicationsRV.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}