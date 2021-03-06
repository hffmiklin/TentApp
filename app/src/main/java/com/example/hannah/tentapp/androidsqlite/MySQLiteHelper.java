package com.example.hannah.tentapp.androidsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emeli on 2016-05-17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ladokMockup";

    //tables
    public static final String TABLE_STUDENT="student";
    public static final String TABLE_COURSE="course";
    public static final String TABLE_STUDENT_COURSE="student_course";
    public static final String TABLE_EXAM="exam";
    public static final String TABLE_STUDENT_EXAM="student_exam";
    public static final String TABLE_BUILDING="building";

    //Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_PNR = "pnr";
    private static final String KEY_GUL_ID = "gul_id";
    private static final String KEY_NAME = "name";

    //Student column names
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";

    //course column names
    private static final String KEY_NR = "nr";

    //exam column names
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME_START = "time_start";
    private static final String KEY_TIME_END = "time_end";
    private static final String KEY_AID = "aid";
    private static final String KEY_BUILDING = "building";
    private static final String KEY_ROOM = "room";
    private static final String KEY_REG_OPEN = "reg_open";
    private static final String KEY_REG_CLOSE = "reg_close";

    //student_exam column names
    private static final String KEY_REGISTERED = "registered";

    //building column names
    private static final String KEY_ADDRESS = "address";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create student table
        String CREATE_STUDENT_TABLE = "CREATE TABLE" + TABLE_STUDENT + "("
                + KEY_PNR + "PRIMARY KEY,"
                + KEY_GUL_ID + " TEXT,"
                + KEY_FIRST_NAME + "TEXT,"
                + KEY_LAST_NAME + "TEXT" + ")";
        db.execSQL(CREATE_STUDENT_TABLE);
        //create course table
        String CREATE_COURSE_TABLE = "CREATE TABLE" + TABLE_COURSE + "("
                + KEY_ID + "PRIMARY KEY,"
                + KEY_NR + " TEXT,"
                + KEY_NAME + "TEXT" + ")";
        db.execSQL(CREATE_COURSE_TABLE);
        //create student_course table
        String CREATE_STUDENT_COURSE_TABLE = "CREATE TABLE" + TABLE_STUDENT_COURSE + "("
                + KEY_PNR + "INT NOT NULL"
                + KEY_ID + "INT NOT NULL" + ")";
        db.execSQL(CREATE_STUDENT_COURSE_TABLE);
        //create exam table
        String CREATE_EXAM_TABLE = "CREATE TABLE" + TABLE_EXAM + "("
                + KEY_ID + "PRIMARY KEY NOT NULL"
                + KEY_DATE + "TEXT"
                + KEY_TIME_START + "TEXT"
                + KEY_TIME_END + "TEXT"
                + KEY_AID + "TEXT"
                + KEY_BUILDING + "TEXT"
                + KEY_ROOM + "TEXT"
                + KEY_REG_OPEN + "TEXT"
                + KEY_REG_CLOSE + "TEXT" + ")";
        db.execSQL(CREATE_EXAM_TABLE);
        //create student_exam table
        String CREATE_STUDENT_EXAM_TABLE = "CREATE TABLE" + TABLE_STUDENT_EXAM + "("
                + KEY_PNR + "INT NOT NULL"
                + KEY_ID + "INT NOT NULL"
                + KEY_REGISTERED + "TEXT" + ")";
        db.execSQL(CREATE_STUDENT_EXAM_TABLE);
        //create building table
        String CREATE_BUILDING_TABLE = "CREATE TABLE" + TABLE_BUILDING + "("
                + KEY_NAME + "TEXT NOT NULL"
                + KEY_ADDRESS + "TEXT NOT NULL" + ")";
        db.execSQL(CREATE_BUILDING_TABLE);

        //Initial data
        String INITIAL_DATA_STUDENT=
                "INSERT INTO " + TABLE_STUDENT + "(pnr, gul_id, first_name, last_name) VALUES " +
                        "(7503228222, 'guspetanh', 'Petter', 'Andersson')," +
                        "(9409153523, 'gusgrasmt', 'Smilla', 'Grandin')";
        db.execSQL(INITIAL_DATA_STUDENT);

        String INITIAL_DATA_COURSE=
                "INSERT INTO " + TABLE_COURSE + "(id, nr, name) VALUES " +
                        "(1, 'TIG163', 'Beslutsstödssystem')," +
                        "(2, 'TIG015', 'Informationsteknologi och informationssystem')," +
                        "(3, 'TIG058', 'Databaser och programmeringsteknik')";
        db.execSQL(INITIAL_DATA_COURSE);

        String INITIAL_DATA_STUDENT_COURSE=
                "INSERT INTO " + TABLE_STUDENT_COURSE + "(pnr, id) VALUES " +
                        "(7503228222, 1)," +
                        "(7503228222, 2)," +
                        "(9409153523, 2)," +
                        "(9409153523, 3)";
        db.execSQL(INITIAL_DATA_STUDENT_COURSE);

        String INITIAL_DATA_EXAM=
                "INSERT INTO " + TABLE_EXAM + "(id, date, time_start, time_end, aid, building, room, reg_start, reg_end) VALUES " +
                        "(1, '2016-02-16', '08:30', '12:30', 'Inget', 'Saga', 'sal 103', '2015-12-26', '2016-01-16')," +
                        "(2, '2016-05-22', '08:30', '12:30', 'Inget', 'Patricia', 'sal 107', '2016-03-22', '2016-04-22')," +
                        "(3, '2016-04-22', '08:30', '12:30', 'Kurslitteratur', 'Saga', 'sal 109', '2016-02-22', '2016-03-22')";
        db.execSQL(INITIAL_DATA_EXAM);

        String INITIAL_DATA_STUDENT_EXAM=
                "INSERT INTO " + TABLE_STUDENT_EXAM + "(pnr, exam_id, registered) VALUES " +
                        "(7503228222, 1, 'Ja')," +
                        "(7503228222, 2, 'Nej')," +
                        "(9409153523, 2, 'Ja')," +
                        "(9409153523, 3, 'Ja')";
        db.execSQL(INITIAL_DATA_STUDENT_EXAM);

        String INITIAL_DATA_BUILDING=
                "INSERT INTO " + TABLE_BUILDING + "(name, adress) VALUES " +
                        "('Saga', 'Hörselgången 4, Gothenburg')," +
                        "('Patricia', 'Forskningsgången 6, Gothenburg')," +
                        "('Jupiter', 'Hörselgången 5, Gothenburg')";
        db.execSQL(INITIAL_DATA_BUILDING);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_COURSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_EXAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUILDING);

        // Create tables again
        onCreate(db);
    }
}
