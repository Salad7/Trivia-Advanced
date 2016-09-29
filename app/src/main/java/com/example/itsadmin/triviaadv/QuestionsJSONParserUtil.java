package com.example.itsadmin.triviaadv;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by itsadmin on 9/29/2016.
 */
public class QuestionsJSONParserUtil {
    public static Context dlConext;

    static ArrayList<Questions> parseQuestions(String in) throws Exception {


        JSONObject root = new JSONObject(in);
        Questions question;
        ArrayList<Questions> questionList;



        JSONArray questionsJSONArray = root.getJSONArray("questions");

        questionList = new ArrayList<>();
        for (int i = 0; i < questionsJSONArray.length(); i++) {
            question = new Questions();
            JSONObject questionJSONObject = questionsJSONArray.getJSONObject(i);
            JSONObject choices = questionJSONObject.getJSONObject("choices");
            JSONArray choice = choices.getJSONArray("choice");

            question.setText(questionJSONObject.getString("text"));
            question.setId(questionJSONObject.getInt("id"));
            if(questionJSONObject.has("image"))
                //new DownloadImageAsyncTaskThread().execute("http://dev.theappsdr.com/apis/trivia_json/index.php");
                question.setImage(questionJSONObject.getString("image"));

                //Log.d("Image link",questionJSONObject.getString("image").toString());

            String[] choicesArray = choice.toString().substring(1,(choice.toString()).length()-1).replace("},{", ",").split(",");
            for(int j = 0; j < choicesArray.length; j++) {
                choicesArray[j] = choicesArray[j].substring(1,choicesArray[j].length()-1);
            }
            question.setChoices(choicesArray);



            question.setAnswer(choices.getString("answer"));

           // Log.d("Number",question.getText());
            questionList.add(question);
           // Log.d("text is " ,questionList.get(i).getText());

        }
    return questionList;


}



    }






