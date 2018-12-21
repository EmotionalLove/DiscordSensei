package com.sasha.discordsensei.teach;

import java.util.ArrayList;

/**
 * Created by Sasha at 12:42 PM on 12/21/2018
 */
public class TeacherActivityContainer {

    private String name;
    private String author;
    private ArrayList<TeacherActivity> elements;

    public void addElement(TeacherActivity element) {
        this.elements.add(element);
    }

    // get lesson
    // get quiz
    // get assessment

}
