package com.example.itsadmin.triviaadv;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.*;
import java.util.ArrayList;

public class Main extends AppCompatActivity implements AsyncTaskThread.ICommuncateWithAsync {

  private TextView textTV;
    private TextView idTV;
    private ArrayList<Questions> details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTV = (TextView) findViewById(R.id.text);
        idTV = (TextView) findViewById(R.id.id);



        //Establish HTTP client to service that returns a questions array
        //Each question contains, a text and a choices element

        //Accessing the internet
        Log.d("TAG","Are you connected? "+isConnectedOnline());
       new AsyncTaskThread(this).execute("http://dev.theappsdr.com/apis/trivia_json/index.php");


    }
    //Check connection to internet
    private boolean isConnectedOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected())
        {
            return true;
        }
        return false;
    }

    public Context getContext(){
        return this;
    }

    @Override
    public void sendData(ArrayList<Questions> result)
    {
        details = result;
        textTV.setText(result.get(0).getText());
        idTV.setText(result.get(0).getId());
    }
}
