package com.sasha.discordsensei.teach.impl.util;

import java.util.List;

/**
 * Created by Sasha at 12:52 PM on 12/21/2018
 */
public class MultipleChoiceQuestion {

    private String question;
    private List<MultipleChoiceAnswer> responses;

    public boolean doQuestion(int answer) {
        int zeroAnswer = answer - 1;
        if (zeroAnswer < 1 || zeroAnswer > responses.size()) return false;
        return responses.get(zeroAnswer).isCorrect();
    }

    public List<MultipleChoiceAnswer> getResponses() {
        return responses;
    }

    public void addResponse(MultipleChoiceAnswer response) {
        this.responses.add(response);
    }

    public String getQuestion() {
        return question;
    }
}
