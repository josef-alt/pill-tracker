package com.example.pilltracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.Toast;

import com.example.pilltracker.Medication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*  This is where all the queries will eventually go
 */
public class DBQueryHandler {

    private Context context;

    public DBQueryHandler(Context context) {
        this.context = context;
    }

    public long insertMedication(Medication medication) {
        long id = -1;

        DBHandler dbHandler = DBHandler.getInstance(context);
        SQLiteDatabase sqLiteDatabase = dbHandler.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(Config.MED_NAME, medication.getName());
        cv.put(Config.MED_DOSE, medication.getDose());
        cv.put(Config.MED_FREQ, medication.getFrequency());

        try {
            id = sqLiteDatabase.insertOrThrow(Config.MEDS_TABLE, null, cv);
            medication.setId(id);
        } catch(SQLiteException e) {
            Log.e("SQLite", e.getMessage());
            Toast.makeText(context, "Insert failed.", Toast.LENGTH_SHORT).show();
        } finally {
            sqLiteDatabase.close();
        }

        return id;
    }

    public List<Medication> getAllMedications() {
        DBHandler dbHandler = DBHandler.getInstance(context);
        SQLiteDatabase sqLiteDatabase = dbHandler.getReadableDatabase();

        Cursor cursor = null;
        try {
            String select = String.format("SELECT %s, %s, %s, %s FROM %s",
                    Config.MED_ID,
                    Config.MED_NAME,
                    Config.MED_DOSE,
                    Config.MED_FREQ,
                    Config.MEDS_TABLE);
            cursor = sqLiteDatabase.rawQuery(select, null);

            if(cursor != null) {
                if(cursor.moveToFirst()) {
                    List<Medication> medications = new ArrayList<>();
                    do {
                        long id = cursor.getLong(cursor.getColumnIndex(Config.MED_ID));
                        String med = cursor.getString(cursor.getColumnIndex(Config.MED_NAME));
                        String dose = cursor.getString(cursor.getColumnIndex(Config.MED_DOSE));
                        String freq = cursor.getString(cursor.getColumnIndex(Config.MED_FREQ));

                        medications.add(new Medication(id, med, dose, freq));
                    } while(cursor.moveToNext());

                    return medications;
                }
            }
        } catch(SQLiteException e) {
            Log.e("SQLite", e.getMessage());
            Toast.makeText(context, "Get failed.", Toast.LENGTH_SHORT).show();
        } finally {
             if(cursor != null) {
                 cursor.close();
             }
             sqLiteDatabase.close();
        }
        
        return Collections.emptyList();
    }
}
