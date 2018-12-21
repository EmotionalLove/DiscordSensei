package com.sasha.discordsensei.teach.impl.util;

/**
 * Created by Sasha at 1:01 PM on 12/21/2018
 */
public class ShortResponseQuestion {

    private String question;
    private String answer;

    private boolean doQuestion(String str) {
        return (str.equalsIgnoreCase(answer));
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
