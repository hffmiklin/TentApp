package com.example.hannah.tentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.graphics.Typeface;

public class ExamInformation extends AppCompatActivity {

    TextView courseName, courseDate, courseTime, courseAid, coursePlace, courseRegOpen, courseRegClose, courseRegYN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_information);


        courseName = (TextView) findViewById(R.id.courseNameTextView);
        courseDate = (TextView) findViewById(R.id.dateTextView);
        courseTime = (TextView) findViewById(R.id.courseTimeTextView);
        courseAid = (TextView) findViewById(R.id.courseAidTextView);
        coursePlace = (TextView) findViewById(R.id.coursePlaceTextView);
        courseRegOpen = (TextView) findViewById(R.id.courseRegOpenTextView);
        courseRegClose = (TextView) findViewById(R.id.courseRegCloseTextView);
        courseRegYN = (TextView) findViewById(R.id.courseRegTextView);

        Bundle extras = getIntent().getExtras();

        String courseNameString = extras.getString("course_name");
        String courseDateString = extras.getString("course_date");
        String courseTimeString = extras.getString("course_time");
        String courseAidString = extras.getString("course_aid");
        String coursePlaceString = extras.getString("course_place");
        String courseRegOpenString = extras.getString("course_reg_open");
        String courseRegCloseString = extras.getString("course_reg_close");
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

        courseRegOpen.setTypeface(Typeface.MONOSPACE);
        courseRegOpen.setText(String.format("%-16s" + courseRegOpenString, "Första anmdag: "));

        courseRegClose.setTypeface(Typeface.MONOSPACE);
        courseRegClose.setText(String.format("%-16s" + courseRegCloseString, "Sista anmdag: "));

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
