package com.example.pilltracker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*  Thread safe singleton for managing database access/creation
 */
public class DBHandler extends SQLiteOpenHelper {

    private static DBHandler database;
    private static final String DB_NAME = "pill-tracker-db";
    private static final int DB_VERSION = 1;

    public static DBHandler getInstance(Context context) {
        if(database == null) {
            synchronized (DBHandler.class) {
                if(database == null) {
                    database = new DBHandler(context);
                }
            }
        }
        return database;
    }

    private DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_meds_table = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s VARCHAR(50) NOT NULL, %s VARCHAR(50), %s VARCHAR(50))",
                Config.MEDS_TABLE,
                Config.MED_ID,
                Config.MED_NAME,
                Config.MED_DOSE,
                Config.MED_FREQ);
        sqLiteDatabase.execSQL(create_meds_table);

        String create_measurements_table = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s VARCHAR(50) NOT NULL, %s VARCHAR(50))",
                Config.MEASURES_TABLE,
                Config.MEASURE_ID,
                Config.MEASURE_NAME,
                Config.MEASURE_FREQ);
        sqLiteDatabase.execSQL(create_measurements_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // drop old tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Config.MEDS_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Config.MEASURES_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Config.MEDS_LOG_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Config.MEASURE_LOG_TABLE);

        // create new tables
        onCreate(sqLiteDatabase);
    }
}
