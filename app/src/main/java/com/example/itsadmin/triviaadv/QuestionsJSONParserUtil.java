package com.example.itsadmin.triviaadv;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by itsadmin on 9/29/2016.
 */
public class QuestionsJSONParserUtil {


    static ArrayList<Questions> parseQuestions(String in) throws Exception{
        ArrayList<Questions> questionList = new ArrayList<Questions>();
        ArrayList<String>  temp = new ArrayList<String>();

        JSONObject root = new JSONObject(in);
        JSONArray questionsJSONArray = root.getJSONArray("questions");
        //We need to break the arry down to object, like questions
        JSONArray choices = root.getJSONArray("choices");

        for(int i = 0; i < questionsJSONArray.length(); i++)
        {
            JSONObject questionJSONObject = questionsJSONArray.getJSONObject(i);
            Questions question = new Questions();
            question.setText(questionJSONObject.getString("text"));
            question.setId(questionJSONObject.getInt("id"));

            for(int x = 0; x < choices.length(); x ++){
                JSONObject choiceJSONObject = choices.getJSONObject(x);
                temp.add(choiceJSONObject.getString("choice"));
            }


            //question.setChoices(temp);
            question.setChoices(temp);
            questionList.add(question);
            //question.setImage(questionJSONObject.get("image"));
            //question.setChoices(questionJSONObject.get("choices"));
        }
        return questionList;
    }





}
