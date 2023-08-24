package com.capstone.rideitout.Model;

import lombok.Getter;

@Getter
public class FAQ {
    private String question;
    private String answer;
    public FAQ() {

    }

    public FAQ(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
