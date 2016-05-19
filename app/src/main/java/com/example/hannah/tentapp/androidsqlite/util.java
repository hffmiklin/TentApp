package com.example.hannah.tentapp.androidsqlite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emeli on 2016-05-19.
 */
public class Util {
    public static List<String> examToString (List<Exam> examList){
        List<String> strings = new ArrayList<>();
        for (Object object : examList) {
            strings.add(object != null ? object.toString() : null);
        }

        return strings;
    }

}
