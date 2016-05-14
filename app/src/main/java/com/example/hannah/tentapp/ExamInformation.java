package com.example.hannah.tentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExamInformation extends AppCompatActivity {

    TextView courseName, courseDate, courseTime, courseAid, coursePlace, courseRegInt, courseRegYN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_information);


        courseName = (TextView) findViewById(R.id.courseNameTextView);
        courseDate = (TextView) findViewById(R.id.dateTextView);
        courseTime = (TextView) findViewById(R.id.courseTimeTextView);
        courseAid = (TextView) findViewById(R.id.courseAidTextView);
        coursePlace = (TextView) findViewById(R.id.coursePlaceTextView);
        courseRegInt = (TextView) findViewById(R.id.courseRegIntervalTextView);
        courseRegYN = (TextView) findViewById(R.id.courseRegTextView);

        Bundle extras = getIntent().getExtras();

        String courseNameString = extras.getString("course_name");
        String courseDateString = extras.getString("course_date");
        String courseTimeString = extras.getString("course_time");
        String courseAidString = extras.getString("course_aid");
        String coursePlaceString = extras.getString("course_place");
        String courseRegIntervallString = extras.getString("course_reg_intervall");
        String courseRegYesNoString = extras.getString("course_reg_yes_no");

        courseName.setText(courseNameString);
        courseDate.setText("Datum: " + courseDateString);
        courseTime.setText("Tid: " + courseTimeString);
        courseAid.setText("Hjälpmedel: " + courseAidString);
        coursePlace.setText("Lokal: " + coursePlaceString);
        courseRegInt.setText("Registrering: " + courseRegIntervallString);
        courseRegYN.setText("Anmäld: " + courseRegYesNoString);




        // TODO import list of elements of chosen exam, connect with db

        // datum
        // tidstart + slut
        // hjälpmedel
        // sal, hus (om finns)
        // anmälningsintervall
        //anmäld eller inte
        // knapp: hitta hus+sal



    }
}
