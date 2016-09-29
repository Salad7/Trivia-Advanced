package com.example.itsadmin.triviaadv;

import android.os.AsyncTask;
import android.os.health.PackageHealthStats;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by itsadmin on 9/28/2016.
 */
public class AsyncTaskThread extends AsyncTask<String, Void, String> {


    AsyncTaskThread()
    {

    }

    //To parse a JSON file
    //Load whole file into a string
    //Use JSONArray class to parse the jsonstring into jsonarray or jsonobjects
    @Override
    protected String doInBackground(String...params)
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
                return  sb.toString();
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
    protected void onPostExecute(String result){
        Log.d("demo",result);
    }



}
