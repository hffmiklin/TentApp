package com.example.hannah.tentapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.graphics.drawable.*;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamList extends AppCompatActivity {

    List<String> courseList;
    List<String> courseDateList;
    List<String> courseTimeList;
    List<String> courseAidList;
    List<String> coursePlaceList;
    List<String> courseRegIntervalList1;
    List<String> courseRegIntervalList2;
    List<String> courseRegYesNoList;

    String userNameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_list);

        LinearLayout layout = (LinearLayout)findViewById(R.id.examListLayout);

        Bundle extras = getIntent().getExtras();
        userNameString = extras.getString("user_name");

        // TODO Import list of exams from database
        // hard coding list of strings instead of getting from db
        // just to see if "future" connection works

        courseList = new ArrayList<String>();
        courseList.add("TIG164 Interaktionsdesign");
        courseList.add("TIG015 Informationsteknologi och informationssystem");
        courseList.add("TIG016 Verksamheter och information");
        courseList.add("TIG058 Databaser och programmeringsteknik");
        courseList.add("TIG999 Harry Potter och hans världar");
        courseList.add("TIG059 Systemutvecklingsprojekt");
        courseList.add("TIG098 eBusiness och eGovernment");
        courseList.add("TIG162 Affärssystem");
        courseList.add("TIG163 Beslutsstödssystem");

        courseDateList = new ArrayList<String>();
        courseDateList.add("2016-06-03");
        courseDateList.add("2016-05-22");
        courseDateList.add("2016-05-17");
        courseDateList.add("2016-04-22");
        courseDateList.add("2016-04-04");
        courseDateList.add("2016-03-21");
        courseDateList.add("2016-03-10");
        courseDateList.add("2016-02-19");
        courseDateList.add("2016-02-16");

        courseTimeList = new ArrayList<String>();
        courseTimeList.add("8.30-12.30");
        courseTimeList.add("8.30-12.30");
        courseTimeList.add("8.30-12.30");
        courseTimeList.add("8.30-12.30");
        courseTimeList.add("14.30-18.30");
        courseTimeList.add("8.30-12.30");
        courseTimeList.add("14.30-18.30");
        courseTimeList.add("8.30-12.30");
        courseTimeList.add("8.30-12.30");

        courseAidList = new ArrayList<String>();
        courseAidList.add("Inget");
        courseAidList.add("Inget");
        courseAidList.add("Inget");
        courseAidList.add("Miniräknare");
        courseAidList.add("Kursbok");
        courseAidList.add("Inget");
        courseAidList.add("Kursbok");
        courseAidList.add("Inget");
        courseAidList.add("Inget");

        coursePlaceList = new ArrayList<String>();
        coursePlaceList.add("SAGA, sal 102");
        coursePlaceList.add("PATRICIA, sal 107");
        coursePlaceList.add("PATRICIA, sal 122");
        coursePlaceList.add("SAGA, sal 109");
        coursePlaceList.add("SAGA, sal 102");
        coursePlaceList.add("PATRICIA, sal 101");
        coursePlaceList.add("PATRICIA, sal 101");
        coursePlaceList.add("PATRICIA, sal Omega");
        coursePlaceList.add("SAGA, sal 103");

        courseRegIntervalList1 = new ArrayList<String>();
        courseRegIntervalList1.add("2016-04-03");
        courseRegIntervalList1.add("2016-03-22");
        courseRegIntervalList1.add("2016-03-17");
        courseRegIntervalList1.add("2016-02-22");
        courseRegIntervalList1.add("2016-02-04");
        courseRegIntervalList1.add("2016-01-21");
        courseRegIntervalList1.add("2016-01-10");
        courseRegIntervalList1.add("2015-12-19");
        courseRegIntervalList1.add("2015-12-16");

        courseRegIntervalList2 = new ArrayList<String>();
        courseRegIntervalList2.add("2016-05-03");
        courseRegIntervalList2.add("2016-04-22");
        courseRegIntervalList2.add("2016-04-17");
        courseRegIntervalList2.add("2016-03-22");
        courseRegIntervalList2.add("2016-03-04");
        courseRegIntervalList2.add("2016-02-21");
        courseRegIntervalList2.add("2016-02-10");
        courseRegIntervalList2.add("2016-01-19");
        courseRegIntervalList2.add("2016-01-16");

        courseRegYesNoList = new ArrayList<String>();
        courseRegYesNoList.add("Ja");
        courseRegYesNoList.add("Ja");
        courseRegYesNoList.add("Ja");
        courseRegYesNoList.add("Nej");
        courseRegYesNoList.add("Ja");
        courseRegYesNoList.add("Ja");
        courseRegYesNoList.add("Ja");
        courseRegYesNoList.add("Nej");
        courseRegYesNoList.add("Ja");



        for(int i = 0; i< courseList.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button courseButton = new Button(this);
            courseButton.setId(i);
            final int id = courseButton.getId();

            courseButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Intent intent = new Intent(ExamList.this,ExamInformation.class);
                    intent.putExtra("course_name", courseList.get(id));
                    intent.putExtra("course_date", courseDateList.get(id));
                    intent.putExtra("course_time", courseTimeList.get(id));
                    intent.putExtra("course_aid", courseAidList.get(id));
                    intent.putExtra("course_place", coursePlaceList.get(id));
                    intent.putExtra("course_reg_interval1", courseRegIntervalList1.get(id));
                    intent.putExtra("course_reg_interval2", courseRegIntervalList2.get(id));
                    intent.putExtra("course_reg_yes_no", courseRegYesNoList.get(id));
                    startActivity(intent);
                }
            });


            // Design button
            String courseListName = courseList.get(i);
            String[] stringParts = courseListName.split(" ");
            String courseButtonText = stringParts[0] + "\n";

            for(int j = 1; j<stringParts.length ; j++ ){
                courseButtonText = courseButtonText +" "+ stringParts[j];
            }
            courseButton.setText(courseButtonText);
            courseButton.setTextSize(18);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.RECTANGLE);
            drawable.setStroke(5, Color.WHITE);
            drawable.setColor(Color.LTGRAY);

            courseButton.setBackgroundDrawable(drawable);
            //courseButton.setBackgroundColor(Color.rgb(253,153,66));


            //courseButton.border färg
            layout.addView(courseButton, params);

        }

    }
}
