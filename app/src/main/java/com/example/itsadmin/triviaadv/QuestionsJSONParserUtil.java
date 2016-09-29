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

        JSONObject root = new JSONObject(in);
        JSONArray questionsJSONArray = root.getJSONArray("questions");
        for(int i = 0; i < questionsJSONArray.length(); i++)
        {
            JSONObject questionJSONObject = questionsJSONArray.getJSONObject(i);
            Questions question = new Questions();
            question.setText(questionJSONObject.getString("text"));
            question.setId(questionJSONObject.getInt("id"));
            //question.setImage(questionJSONObject.get("image"));
            //question.setChoices(questionJSONObject.get("choices"));
        }
        return questionList;
    }



}
