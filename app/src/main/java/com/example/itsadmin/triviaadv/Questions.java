package com.example.itsadmin.triviaadv;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.ArrayList;

/**
 * Created by itsadmin on 9/28/2016.
 */
public class Questions {

    private int id;
    private String text;
    private ArrayList<String> choices;
    private int answer;
    private Bitmap image;

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

    public Bitmap getImage()
    {
        return image;
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

    public void setImage(Bitmap b)
    {
        return image;
    }
}
