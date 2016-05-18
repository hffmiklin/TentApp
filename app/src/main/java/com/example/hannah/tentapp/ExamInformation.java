package com.example.hannah.tentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.graphics.Typeface;

public class ExamInformation extends AppCompatActivity {

    TextView courseName, courseDate, courseTime, courseAid, coursePlace, courseRegInt1, courseRegInt2, courseRegYN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_information);


        courseName = (TextView) findViewById(R.id.courseNameTextView);
        courseDate = (TextView) findViewById(R.id.dateTextView);
        courseTime = (TextView) findViewById(R.id.courseTimeTextView);
        courseAid = (TextView) findViewById(R.id.courseAidTextView);
        coursePlace = (TextView) findViewById(R.id.coursePlaceTextView);
        courseRegInt1 = (TextView) findViewById(R.id.courseRegIntervalTextView1);
        courseRegInt2 = (TextView) findViewById(R.id.courseRegIntervalTextView2);
        courseRegYN = (TextView) findViewById(R.id.courseRegTextView);

        Bundle extras = getIntent().getExtras();

        String courseNameString = extras.getString("course_name");
        String courseDateString = extras.getString("course_date");
        String courseTimeString = extras.getString("course_time");
        String courseAidString = extras.getString("course_aid");
        String coursePlaceString = extras.getString("course_place");
        String courseRegInterval1String = extras.getString("course_reg_interval1");
        String courseRegInterval2String = extras.getString("course_reg_interval2");
        String courseRegYesNoString = extras.getString("course_reg_yes_no");


        //rader nedan formaterat strängar för tentainfon
        courseName.setText(courseNameString);

        courseDate.setTypeface(Typeface.MONOSPACE);
        courseDate.setText(String.format("%-16s" + courseDateString, "Provdatum: "));

        courseTime.setTypeface(Typeface.MONOSPACE);
        courseTime.setText(String.format("%-16s" + courseTimeString, "Tid: "));

        courseAid.setTypeface(Typeface.MONOSPACE);
        courseAid.setText(String.format("%-16s" + courseAidString, "Hjälpmedel: "));

        coursePlace.setTypeface(Typeface.MONOSPACE);
        coursePlace.setText(String.format("%-16s" + coursePlaceString, "Lokal: "));

        courseRegInt1.setTypeface(Typeface.MONOSPACE);
        courseRegInt1.setText(String.format("%-16s" + courseRegInterval1String, "Första anmdag: "));

        courseRegInt2.setTypeface(Typeface.MONOSPACE);
        courseRegInt2.setText(String.format("%-16s" + courseRegInterval2String, "Sista anmdag: "));

        courseRegYN.setTypeface(Typeface.MONOSPACE);
        courseRegYN.setText(String.format("%-16s" + courseRegYesNoString, "Anmäld: "));


        // TODO import list of elements of chosen exam, connect with db

        // datum
        // tidstart + slut
        // hjälpmedel
        // sal, hus (om finns)
        // anmälningsintervall
        //anmäld eller inte
        // knapp: hitta hus+sal



    }

    public void openMap(View view) {
        startActivity(new Intent(ExamInformation.this, MapsActivity.class));
    }
}
