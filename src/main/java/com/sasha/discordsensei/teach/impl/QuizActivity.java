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

    public List<MultipleChoiceQuestion> multipleChoiceQuestions = new ArrayList<>();
    public List<ShortResponseQuestion> shortResponseQuestions = new ArrayList<>();

    @Override
    public void start() {

    }

    public boolean isPopulated() {
        return !multipleChoiceQuestions.isEmpty() || !shortResponseQuestions.isEmpty();
    }

}

