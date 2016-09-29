package com.example.itsadmin.triviaadv;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by itsadmin on 9/28/2016.
 */
public class AsyncTaskThread extends AsyncTask<String, Void, ArrayList<Questions>> {

    ProgressDialog progressDialog;
    ICommuncateWithAsync mContext;


    AsyncTaskThread(ICommuncateWithAsync context)
    {
    mContext = context;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progressDialog = new ProgressDialog(mContext.getContext());
        progressDialog.setMessage("Loading trivia");
        progressDialog.show();
    }

    //To parse a JSON file
    //Load whole file into a string
    //Use JSONArray class to parse the jsonstring into jsonarray or jsonobjects
    @Override
    protected ArrayList<Questions> doInBackground(String...params)
    {
        try {
            //Arraylist of a strings
            StringBuilder sb = new StringBuilder();
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int statusCode = con.getResponseCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = "";
                while((line = reader.readLine())!= null)
                {
                  sb.append(line+"\n");
                }
                reader.close();
                return  QuestionsJSONParserUtil.parseQuestions(sb.toString());
            }
            //con.getInputStream(); //Opens connection
            //BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //String line = "";
            //while((line = reader.readLine())!= null)
            //{
              //  sb.append(line+"\n");
            //}
            //reader.close();
            //return  sb.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    @Override
    protected void onPostExecute(ArrayList<Questions> questionses) {
        super.onPostExecute(questionses);
        progressDialog.dismiss();
        mContext.sendData(questionses);

    }

    @Override
    protected  void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);
    }

    static public interface ICommuncateWithAsync{
        public Context getContext();
        public void sendData(ArrayList<Questions> result);
    }


}
