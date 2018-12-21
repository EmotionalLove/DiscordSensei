package com.sasha.discordsensei.teach.impl;

import com.sasha.discordsensei.teach.TeacherActivity;
import com.sasha.discordsensei.teach.impl.util.MultipleChoiceQuestion;
import com.sasha.discordsensei.teach.impl.util.ShortResponseQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasha at 12:50 PM on 12/21/2018
 */
public class QuizActivity extends TeacherActivity {

    private List<MultipleChoiceQuestion> multipleChoiceQuestions = new ArrayList<>();
    private List<ShortResponseQuestion> shortResponseQuestions = new ArrayList<>();

    @Override
    public void start() {

    }
}

