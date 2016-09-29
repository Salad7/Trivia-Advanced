package com.example.itsadmin.triviaadv;

import java.util.ArrayList;

/**
 * Created by itsadmin on 9/28/2016.
 */
public class Questions {

    private int id;
    private String text;
    private ArrayList<String> choices;
    private int answer;

    Questions() {

    };

    public int getId()
    {
        return id;
    }

    public String getText()
    {
        return text;
    }

    private ArrayList<String> choices()
    {
        return choices;
    }
    private int getAnswer(){
        return answer;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void setChoices(ArrayList<String> choices)
    {
        this.choices = choices;
    }
}
