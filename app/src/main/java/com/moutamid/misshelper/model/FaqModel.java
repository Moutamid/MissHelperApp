package com.moutamid.misshelper.model;


public class FaqModel {
    public String question;
    public String answer;
    public boolean isExpanded = false;

    public FaqModel(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
