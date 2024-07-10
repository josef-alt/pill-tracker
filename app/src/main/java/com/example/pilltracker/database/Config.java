package com.example.pilltracker.database;

/*  This will hold all the table and column names as constants
 */
public class Config {
    // medications
    public static final String MEDS_TABLE = "medications";
    public static final String MED_ID = "_id";
    public static final String MED_NAME = "name";
    public static final String MED_DOSE = "dose";
    public static final String MED_FREQ = "freq";

    public static final String MEDS_LOG_TABLE = "medication_log";
    public static final String MED_LOG_LOG_ID = "_id";
    public static final String MED_LOG_MED_ID = "medication_id";
    public static final String MED_LOG_TIME = "timestamp";

    // measurements
    public static final String MEASURES_TABLE = "measurements";
    public static final String MEASURE_ID = "_id";
    public static final String MEASURE_NAME = "name";
    public static final String MEASURE_FREQ = "freq";

    public static final String MEASURE_LOG_TABLE = "measurement_log";
    public static final String MEASURE_LOG_MEASURE_ID = "_id";
    public static final String MEASURE_LOG_ID = "measurement_id";
    public static final String MEASURE_LOG_VALUE = "value";
    public static final String MEASURE_LOG_TIME = "timestamp";

    // reminders
    public static final String REMINDER_VIEW = "reminders";
}
