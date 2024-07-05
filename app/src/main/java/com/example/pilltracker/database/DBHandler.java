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

    public DBHandler getInstance(Context context) {
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
        String create_meds_table = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL)",
                Config.TABLE_MEDS, Config.MEDS_ID, Config.MEDS_NAME);
        sqLiteDatabase.execSQL(create_meds_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // drop old tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Config.TABLE_MEDS);

        // create new tables
        onCreate(sqLiteDatabase);
    }
}
