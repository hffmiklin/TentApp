package com.example.hannah.tentapp.androidsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emeli on 2016-05-17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ladokMockup";

    //tables
    public static final String TABLE_USER="user";
    public static final String TABLE_COURSE="course";
    public static final String TABLE_EXAM="exam";
    public static final String TABLE_USER_EXAM="user_exam";
    public static final String TABLE_BUILDING="building";
    
    //views
    public static final String VIEW_EXAM_LIST="exam_list";

    //Common column names
    private static final String KEY_PNR = "pnr";
    private static final String KEY_GUL_ID = "gul_id"; //is common?
    private static final String KEY_NAME = "name";

    //User column names
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_PASSWORD = "password";

    //course column names
    private static final String KEY_COURSE_ID = "id_course";
    private static final String KEY_NR = "nr";

    //exam column names
    private static final String KEY_EXAM_ID = "id_exam";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME_START = "time_start";
    private static final String KEY_TIME_END = "time_end";
    private static final String KEY_AID = "aid";
    private static final String KEY_BUILDING = "building";
    private static final String KEY_ROOM = "room";
    private static final String KEY_REG_OPEN = "reg_open";
    private static final String KEY_REG_CLOSE = "reg_close";

    //user_exam column names
    private static final String KEY_REGISTERED = "registered";

    //building column names
    private static final String KEY_ADDRESS = "address";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create user table
        String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + "("
            + KEY_PNR + " PRIMARY KEY, "
            + KEY_GUL_ID + " TEXT, "
            + KEY_FIRST_NAME + " TEXT, "
            + KEY_LAST_NAME + " TEXT, "
            + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
        //create course table
        String CREATE_COURSE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_COURSE + "("
            + KEY_COURSE_ID + " PRIMARY KEY, "
            + KEY_NR + " TEXT, "
            + KEY_NAME + " TEXT" + ")";
        db.execSQL(CREATE_COURSE_TABLE);
        //create exam table
        String CREATE_EXAM_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_EXAM + "("
            + KEY_EXAM_ID + " PRIMARY KEY NOT NULL, "
            + KEY_DATE + " TEXT, "
            + KEY_TIME_START + " TEXT, "
            + KEY_TIME_END + " TEXT, "
            + KEY_AID + " TEXT, "
            + KEY_BUILDING + " TEXT, "
            + KEY_ROOM + " TEXT,"
            + KEY_REG_OPEN + "  TEXT, "
            + KEY_REG_CLOSE + " TEXT, "
            + KEY_COURSE_ID + " INT"+ ")";
        db.execSQL(CREATE_EXAM_TABLE);
        //create user_exam table
        String CREATE_USER_EXAM_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USER_EXAM + "("
                + KEY_PNR + " INT NOT NULL, "
                + KEY_EXAM_ID + " INT NOT NULL, "
                + KEY_REGISTERED + " TEXT" + ")";
        db.execSQL(CREATE_USER_EXAM_TABLE);
        //create building table
        String CREATE_BUILDING_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_BUILDING + "("
                + KEY_NAME + " TEXT NOT NULL, "
                + KEY_ADDRESS + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_BUILDING_TABLE);

        //Initial data
        String INITIAL_DATA_USER=
                "INSERT INTO " + TABLE_USER + "(pnr, gul_id, first_name, last_name, password) VALUES " +
                        "(7503228222, 'admin', 'Petter', 'Andersson', 'password123')," +
                        "(9409153523, 'gusgrasmt', 'Smilla', 'Grandin', 'password123')";
        db.execSQL(INITIAL_DATA_USER);

        String INITIAL_DATA_COURSE=
                "INSERT INTO " + TABLE_COURSE + "(id_course, nr, name) VALUES " +
                        "(1, 'TIG163', 'Beslutsstödssystem')," +
                        "(2, 'TIG015', 'Informationsteknologi och informationssystem')," +
                        "(3, 'TIG058', 'Databaser och programmeringsteknik')";
        db.execSQL(INITIAL_DATA_COURSE);

        String INITIAL_DATA_EXAM=
                "INSERT INTO " + TABLE_EXAM + "(id_exam, date, time_start, time_end, aid, building, room, reg_open, reg_close, id_course) VALUES " +
                        "(1, '2016-02-16', '08:30', '12:30', 'Inget', 'Saga', 'sal 103', '2015-12-26', '2016-01-16', 1)," +
                        "(2, '2016-05-22', '08:30', '12:30', 'Inget', 'Patricia', 'sal 107', '2016-03-22', '2016-04-22', 2)," +
                        "(3, '2016-04-22', '08:30', '12:30', 'Kurslitteratur', 'Saga', 'sal 109', '2016-02-22', '2016-03-22', 3)";
        db.execSQL(INITIAL_DATA_EXAM);

        String INITIAL_DATA_USER_EXAM=
                "INSERT INTO " + TABLE_USER_EXAM + "(pnr, id_exam, registered) VALUES " +
                        "(7503228222, 1, 'Ja')," +
                        "(7503228222, 2, 'Nej')," +
                        "(9409153523, 2, 'Ja')," +
                        "(9409153523, 3, 'Ja')";
        db.execSQL(INITIAL_DATA_USER_EXAM);

        String INITIAL_DATA_BUILDING=
                "INSERT INTO " + TABLE_BUILDING + "(name, address) VALUES " +
                        "('Saga', 'Hörselgången 4, Gothenburg')," +
                        "('Patricia', 'Forskningsgången 6, Gothenburg')," +
                        "('Jupiter', 'Hörselgången 5, Gothenburg')";
        db.execSQL(INITIAL_DATA_BUILDING);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_EXAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUILDING);

        // Create tables again
        onCreate(db);
    }
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public void createView(String presentUser) {
        //create views
        SQLiteDatabase db = this.getWritableDatabase();
        String CREATE_VIEW_EXAM_COURSE_LIST = "CREATE VIEW IF NOT EXISTS " + VIEW_EXAM_LIST + " AS " +
                "SELECT " + TABLE_COURSE + "." + KEY_NR + ","
                + TABLE_COURSE + "." + KEY_NAME + ","
                + TABLE_EXAM + "." + KEY_DATE + ","
                + TABLE_EXAM + "." + KEY_TIME_START + ","
                + TABLE_EXAM + "." + KEY_TIME_END + ","
                + TABLE_EXAM + "." + KEY_AID + ","
                + TABLE_EXAM + "." + KEY_BUILDING + ","
                + TABLE_EXAM + "." + KEY_ROOM + ","
                + TABLE_EXAM + "." + KEY_REG_OPEN + ","
                + TABLE_EXAM + "." + KEY_REG_CLOSE + ","
                + TABLE_USER_EXAM + "." + KEY_REGISTERED + ","
                + TABLE_USER + "." + KEY_GUL_ID +
                " FROM " + TABLE_USER +
                " INNER JOIN " + TABLE_USER_EXAM +
                " ON " + TABLE_USER + "." + KEY_PNR + "=" + TABLE_USER_EXAM + "." + KEY_PNR +
                " INNER JOIN " + TABLE_EXAM +
                " ON " + TABLE_EXAM + "." + KEY_EXAM_ID + "=" + TABLE_USER_EXAM + "." + KEY_EXAM_ID +
                " INNER JOIN " + TABLE_COURSE +
                " ON " + TABLE_EXAM + "." + KEY_COURSE_ID + "=" + TABLE_COURSE + "." + KEY_COURSE_ID +
                " WHERE " + TABLE_USER + "." + KEY_GUL_ID + "=" + "'" + presentUser +"'";
        db.execSQL(CREATE_VIEW_EXAM_COURSE_LIST);
        db.close();
    }

    public List<String> getCourseNames() {
        Log.d("getCourseNames() ", "Start");
        List<Exam> courseNames;
        courseNames = new ArrayList<Exam>();
        String selectQuery = "SELECT " + KEY_NR + "," + KEY_NAME + " FROM " + VIEW_EXAM_LIST;
        Log.d("getCourseNames() ", "Created query");
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d("getCourseNames() ", "got ReadableDatabase");
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam ex = new Exam();
                Log.d("creating String Nr", c.getString((c.getColumnIndex(KEY_NR))));
                Log.d("c.getColumnIndex", Integer.toString(c.getColumnIndex(KEY_NR)));
                ex.setCourseNr(c.getString((c.getColumnIndex(KEY_NR))));
                Log.d("creating String Name", c.getString((c.getColumnIndex(KEY_NAME))));
                Log.d("c.getColumnIndex", Integer.toString(c.getColumnIndex(KEY_NAME)));
                ex.setCourseName((c.getString(c.getColumnIndex(KEY_NAME))));
                Log.d("ex.toString", ex.toString());
                courseNames.add(ex);
            } while (c.moveToNext());
        }
        String courseNameSize = Integer.toString(courseNames.size());
        Log.d("Size of courseName", courseNameSize);
        //List<String> courseNamesStrings = Util.examToString(courseNames);
        List<String> courseNamesStrings = new ArrayList<>();
        for (Exam ex : courseNames) {
            courseNamesStrings.add(ex != null ? ex.getCourseNr()+ " " + ex.getCourseName(): null);
        }

        return courseNamesStrings;
    }

    public List<String> getExamDates() {
        Log.d("getExamDates() ", "Start");
        List<Exam> examDates;
        examDates = new ArrayList<Exam>();
        String selectQuery = "SELECT " + KEY_DATE + " FROM " + VIEW_EXAM_LIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam ex = new Exam();
                Log.d("creating String Nr", c.getString((c.getColumnIndex(KEY_DATE))));
                Log.d("c.getColumnIndex", Integer.toString(c.getColumnIndex(KEY_DATE)));
                ex.setDate(c.getString((c.getColumnIndex(KEY_DATE))));
                examDates.add(ex);
            } while (c.moveToNext());
        }
        List<String> examDatesStrings = new ArrayList<>();
        for (Exam ex : examDates) {
            examDatesStrings.add(ex != null ? ex.getDate(): null);
        }

        return examDatesStrings;
    }

    public List<String> getExamTimes() {
        Log.d("getExamTimes() ", "Started");
        List<Exam> examTimes;
        examTimes = new ArrayList<Exam>();
        String selectQuery = "SELECT " + KEY_TIME_START + "," + KEY_TIME_END + " FROM " + VIEW_EXAM_LIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam ex = new Exam();
                Log.d("creating String Nr", c.getString((c.getColumnIndex(KEY_TIME_START))));
                Log.d("creating String Nr", c.getString((c.getColumnIndex(KEY_TIME_END))));
                ex.setTimeStart(c.getString(c.getColumnIndex(KEY_TIME_START)));
                ex.setTimeEnd(c.getString(c.getColumnIndex(KEY_TIME_END)));
                examTimes.add(ex);
            } while (c.moveToNext());
        }
        List<String> examTimesStrings = new ArrayList<>();
        for (Exam ex : examTimes) {
            examTimesStrings.add(ex != null ? ex.getTimeStart() + "-" + ex.getTimeEnd(): null);
        }

        return examTimesStrings;
    }

    public List<String> getAids() {
        Log.d("getAids() ", "Started");
        List<Exam> aids;
        aids = new ArrayList<Exam>();
        String selectQuery = "SELECT " + KEY_AID + " FROM " + VIEW_EXAM_LIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam ex = new Exam();
                Log.d("creating String Nr", c.getString((c.getColumnIndex(KEY_AID))));
                ex.setAid(c.getString(c.getColumnIndex(KEY_AID)));
                aids.add(ex);
            } while (c.moveToNext());
        }
        List<String> aidsStrings = new ArrayList<>();
        for (Exam ex : aids) {
            aidsStrings.add(ex != null ? ex.getAid(): null);
        }

        return aidsStrings;
    }

    public List<String> getPlaces() {
        Log.d("getPlaces() ", "Started");
        List<Exam> places;
        places = new ArrayList<Exam>();
        String selectQuery = "SELECT " + KEY_BUILDING + "," + KEY_ROOM + " FROM " + VIEW_EXAM_LIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam ex = new Exam();
                Log.d("creating Str Building", c.getString((c.getColumnIndex(KEY_BUILDING))));
                Log.d("creating String Room", c.getString((c.getColumnIndex(KEY_ROOM))));
                ex.setBuilding(c.getString(c.getColumnIndex(KEY_BUILDING)));
                ex.setRoom(c.getString(c.getColumnIndex(KEY_ROOM)));
                places.add(ex);
            } while (c.moveToNext());
        }
        List<String> placesStrings = new ArrayList<>();
        for (Exam ex : places) {
            placesStrings.add(ex != null ? ex.getBuilding() + ", " + ex.getRoom(): null);
        }

        return placesStrings;
    }

    public List<String> getRegOpens() {
            Log.d("getRegOpens() ", "Started");
            List<Exam> regOpens;
            regOpens = new ArrayList<Exam>();
            String selectQuery = "SELECT " + KEY_REG_OPEN + " FROM " + VIEW_EXAM_LIST;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    Exam ex = new Exam();
                    Log.d("creating Str RegOpen", c.getString((c.getColumnIndex(KEY_REG_OPEN))));
                    ex.setRegOpen(c.getString(c.getColumnIndex(KEY_REG_OPEN)));
                    regOpens.add(ex);
                } while (c.moveToNext());
            }
            List<String> regOpensStrings = new ArrayList<>();
            for (Exam ex : regOpens) {
                regOpensStrings.add(ex != null ? ex.getRegOpen(): null);
            }

        return regOpensStrings;
    }

    public List<String> getRegCloses() {
        Log.d("getRegCloses() ", "Started");
        List<Exam> regCloses;
        regCloses = new ArrayList<Exam>();
        String selectQuery = "SELECT " + KEY_REG_CLOSE + " FROM " + VIEW_EXAM_LIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam ex = new Exam();
                Log.d("creating Str RegClose", c.getString((c.getColumnIndex(KEY_REG_CLOSE))));
                ex.setRegClose(c.getString(c.getColumnIndex(KEY_REG_CLOSE)));
                regCloses.add(ex);
            } while (c.moveToNext());
        }
        List<String> regClosesStrings = new ArrayList<>();
        for (Exam ex : regCloses) {
            regClosesStrings.add(ex != null ? ex.getRegClose(): null);
        }

        return regClosesStrings;
    }

    public List<String> getRegistered() {
        Log.d("getRegistered() ", "Started");
        List<Exam> registered;
        registered = new ArrayList<Exam>();
        String selectQuery = "SELECT " + KEY_REGISTERED + " FROM " + VIEW_EXAM_LIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam ex = new Exam();
                Log.d("creating Str Registered", c.getString(c.getColumnIndex(KEY_REGISTERED)));
                ex.setRegistered(c.getString(c.getColumnIndex(KEY_REGISTERED)));
                registered.add(ex);
            } while (c.moveToNext());
        }
        List<String> registeredStrings = new ArrayList<>();
        for (Exam ex : registered) {
            registeredStrings.add(ex != null ? ex.getRegistered(): null);
        }

        return registeredStrings;
    }

    public List<String> getBuildings(){
        Log.d("getBuildings() ", "Started");
        List<Exam> buildings;
        buildings = new ArrayList<Exam>();
        String selectQuery = "SELECT " + KEY_BUILDING + " FROM " + VIEW_EXAM_LIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam ex = new Exam();
                Log.d("creating Str Buildings", c.getString(c.getColumnIndex(KEY_BUILDING)));
                ex.setBuilding(c.getString(c.getColumnIndex(KEY_BUILDING)));
                buildings.add(ex);
            } while (c.moveToNext());
        }
        List<String> buildingStrings = new ArrayList<>();
        for (Exam ex :  buildings) {
            buildingStrings.add(ex != null ? ex.getBuilding(): null);
            Log.d("getBuilding returns", ex.getBuilding());
        }

        return buildingStrings;
    }

    public String getExamAddress(String building_name) {
        Exam ex = new Exam();
        String selectQuery = "SELECT " + KEY_ADDRESS + " FROM " + VIEW_EXAM_LIST +
                " INNER JOIN " + TABLE_BUILDING +
                " ON " + VIEW_EXAM_LIST + "." + KEY_BUILDING + "=" + TABLE_BUILDING + "." + KEY_NAME +
                " WHERE " + TABLE_BUILDING + "." + KEY_NAME + "=" + "'" + building_name + "'";
        Log.d("selectQuery", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        c.moveToFirst();
        ex.setAddress(c.getString(c.getColumnIndex(KEY_ADDRESS)));
        Log.d("output query", c.getString(c.getColumnIndex(KEY_ADDRESS)));
        String addressString = ex.getAddress();

        return addressString;
    }
}
