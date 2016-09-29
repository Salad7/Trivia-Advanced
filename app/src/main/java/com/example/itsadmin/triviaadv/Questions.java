package com.example.itsadmin.triviaadv;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by itsadmin on 9/28/2016.
 */
public class Questions implements Serializable{

    private int id;
    private String text;
    private String[] choices;
    private String answer;
    private String image;

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

    public String getImage()
    {
        return image;
    }
    public void setAnswer(String b){
        answer = b;
    }
    public String[] getChoices()
    {
        return choices;
    }
    public String getAnswer(){
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

    public void setChoices(String[] choices) throws Exception
    {
        //pass in choices

        this.choices = choices;
    }

    public void setImage(String parseImage)
    {
         image = parseImage;

    }
}
