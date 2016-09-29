package com.example.itsadmin.triviaadv;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by itsadmin on 9/29/2016.
 */
public class QuestionsJSONParserUtil {


    static ArrayList<Questions> parseQuestions(String in) throws Exception {
        ArrayList<Questions> questionList = new ArrayList<Questions>();

        JSONObject root = new JSONObject(in);
        Questions question = new Questions();


        JSONArray questionsJSONArray = root.getJSONArray("questions");


        for (int i = 0; i < questionsJSONArray.length(); i++) {
            JSONObject questionJSONObject = questionsJSONArray.getJSONObject(i);
            JSONObject choices = questionJSONObject.getJSONObject("choices");
            JSONArray choice = choices.getJSONArray("choice");

            question.setText(questionJSONObject.getString("text"));
            question.setId(questionJSONObject.getInt("id"));
            String[] choicesArray = choice.toString().substring(1,(choice.toString()).length()-1).replace("},{", ",").split(",");
            for(int j = 0; j < choicesArray.length; j++) {
                choicesArray[j] = choicesArray[j].substring(1,choicesArray[j].length()-1);
            }
            question.setChoices(choicesArray);
            question.setAnswer(choices.getString("answer"));


           // question.setChoices(root.optString("choices"));
            questionList.add(question);
            //question.setImage(questionJSONObject.get("image"));
            //question.setChoices(questionJSONObject.get("choices"));
        }

    return questionList;


}


/**
        JSONObject root = new JSONObject(in);
        JSONArray questionsJSONArray = root.getJSONArray("questions");
        //We need to break the array down to object, like questions

        //Doesnt like choices for some reason
        //JSONArray choice = root.getJSONArray("questions");

        for(int i = 0; i < questionsJSONArray.length(); i++)
        {
            JSONObject questionJSONObject = questionsJSONArray.getJSONObject(i);
            Questions question = new Questions();
            question.setText(questionJSONObject.getString("text"));
            question.setId(questionJSONObject.getInt("id"));

            JSONArray jsonArray = questionJSONObject.getJSONArray("choice");
            for(int x = 0; x < jsonArray.length(); x ++){
                JSONObject choiceJSONObject = jsonArray.getJSONObject(x);
            //    temp.add(choiceJSONObject.getString("choices").toString());
            }



            //question.setChoices(temp);
            questionList.add(question);
            //question.setImage(questionJSONObject.get("image"));
            //question.setChoices(questionJSONObject.get("choices"));
        }
        return questionList;

 **/
    }






