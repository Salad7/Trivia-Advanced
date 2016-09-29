package com.example.itsadmin.triviaadv;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by itsadmin on 9/29/2016.
 */
public class Trivia extends AppCompatActivity implements AsyncTaskThread.ICommuncateWithAsync{

    private TextView textTV;
    private Button idBtn;
    private ArrayList<Questions> details;
    private TextView choicesTV1;
    private TextView choicesTV2;
    private TextView choicesTV3;
    private  TextView choicesTV4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
        textTV = (TextView) findViewById(R.id.question);
        idBtn = (Button) findViewById(R.id.qid);
        choicesTV1 = (TextView) findViewById(R.id.choice1);
        choicesTV2 = (TextView) findViewById(R.id.choice2);
        choicesTV3 = (TextView) findViewById(R.id.choice3);
        choicesTV4 = (TextView) findViewById(R.id.choice4);




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
        idBtn.setText("Q"+result.get(0).getId());
        //for(int i = 0; i < 4; i++)
        //{
        //choicesTV1.setText(result.get(0).getChoices().get(0));
        //choicesTV1.setText(result.get(0).getChoices().get(1));
        //choicesTV1.setText(result.get(0).getChoices().get(2));
        //choicesTV1.setText(result.get(0).getChoices().get(3));
        //}
    }
}
