package com.example.hannah.tentapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.graphics.drawable.*;

public class ExamList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_list);

        LinearLayout layout = (LinearLayout)findViewById(R.id.examListLayout);

        // TODO Import list of exams from database
        // hard coding list of strings instead of getting from db
        // just to see if "future" connection works

        List<String> courseList = new ArrayList<String>();
        courseList.add("TIG164 \n Interaktionsdesign");
        courseList.add("TIG015 \n Informationsteknologi och informationssystem");
        courseList.add("TIG016 \n Verksamheter och information");
        courseList.add("TIG058 \n Databaser och programmeringsteknik");
        courseList.add("TIG999 \n Harry Potter och hans världar");
        courseList.add("TIG059 \n Systemutvecklingsprojekt");
        courseList.add("TIG098 \n eBusiness och eGovernment");
        courseList.add("TIG162 \n Affärssystem");
        courseList.add("TIG163 \n Beslutsstödssystem");

        for(int i = 0; i< courseList.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button courseButton = new Button(this);
            courseButton.setText(courseList.get(i));
            courseButton.setTextSize(20);

            // Design button
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
