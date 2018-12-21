package com.sasha.discordsensei.teach.impl.util;

/**
 * Created by Sasha at 12:52 PM on 12/21/2018
 */
public class MultipleChoiceAnswer {
    private String answer;
    private boolean isCorrect;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
