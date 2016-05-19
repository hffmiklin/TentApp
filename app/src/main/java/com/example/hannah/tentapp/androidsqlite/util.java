package com.example.hannah.tentapp.androidsqlite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emeli on 2016-05-19.
 */
public class Util {
    public static List<String> examToString (List<Exam> examList){
        List<String> strings = new ArrayList<>();
        for (Exam ex : examList) {
            strings.add(ex != null ? ex.getCourseNr() : null);
        }

        return strings;
    }

}
