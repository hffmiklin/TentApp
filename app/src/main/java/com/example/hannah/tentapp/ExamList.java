
package com.example.hannah.tentapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.graphics.drawable.*;
import android.view.View;

import com.example.hannah.tentapp.androidsqlite.MySQLiteHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamList extends AppCompatActivity {

    MySQLiteHelper helper;

    List<String> courseList;
    List<String> courseDateList;
    List<String> courseTimeList;
    List<String> courseAidList;
    List<String> coursePlaceList;
    List<String> courseRegOpenList;
    List<String> courseRegCloseList;
    List<String> courseRegYesNoList;
    List<String> courseBuildingList;

    String userNameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_list);

        helper = new MySQLiteHelper(getApplicationContext());

        LinearLayout layout = (LinearLayout)findViewById(R.id.examListLayout);

        Bundle extras = getIntent().getExtras();
        userNameString = extras.getString("user_name");

        courseList = new ArrayList<String>();
        courseList = helper.getCourseNames();

        courseDateList = new ArrayList<String>();
        courseDateList = helper.getExamDates();

        courseTimeList = new ArrayList<String>();
        courseTimeList = helper.getExamTimes();

        courseAidList = new ArrayList<String>();
        courseAidList = helper.getAids();

        coursePlaceList = new ArrayList<String>();
        coursePlaceList = helper.getPlaces();

        courseRegOpenList = new ArrayList<String>();
        courseRegOpenList = helper.getRegOpens();

        courseRegCloseList = new ArrayList<String>();
        courseRegCloseList = helper.getRegCloses();

        courseRegYesNoList = new ArrayList<String>();
        courseRegYesNoList = helper.getRegistered();

        courseBuildingList = new ArrayList<String>();
        courseBuildingList = helper.getBuildings();

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
                    intent.putExtra("course_reg_open", courseRegOpenList.get(id));
                    intent.putExtra("course_reg_close", courseRegCloseList.get(id));
                    intent.putExtra("course_reg_yes_no", courseRegYesNoList.get(id));
                    intent.putExtra("course_building", courseBuildingList.get(id));
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

            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.RECTANGLE);
            drawable.setStroke(10, Color.WHITE);

            drawable.setColor(Color.parseColor("#fd9942"));

            courseButton.setText(courseButtonText);
            courseButton.setTextSize(18);
            courseButton.setTextColor(Color.parseColor("#ffffff"));


            courseButton.setBackgroundDrawable(drawable);
            //courseButton.setBackgroundColor(Color.parseColor("#fd9942"));
            //courseButton.setBackgroundColor(Color.rgb(253,153,66));


            //courseButton.border färg
            layout.addView(courseButton, params);

        }

    }
}
