package com.sasha.discordsensei.teach;

import com.sasha.discordsensei.teach.impl.LessonActivity;
import com.sasha.discordsensei.teach.impl.QuizActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public LessonActivity getLessonByName(String s) {
        List<TeacherActivity> activities = elements
                .stream()
                .filter(e->e instanceof LessonActivity)
                .collect(Collectors.toList());
        for (TeacherActivity activity : activities) {
            if  (activity.getActivityName().equalsIgnoreCase(s)) {
                return (LessonActivity) activity;
            }
        }
        return null;
    }
    public QuizActivity getQuizByName(String s) {
        List<TeacherActivity> activities = elements
                .stream()
                .filter(e->e instanceof QuizActivity)
                .collect(Collectors.toList());
        for (TeacherActivity activity : activities) {
            if  (activity.getActivityName().equalsIgnoreCase(s)) {
                return (QuizActivity) activity;
            }
        }
        return null;
    }

    // get assessment

}
