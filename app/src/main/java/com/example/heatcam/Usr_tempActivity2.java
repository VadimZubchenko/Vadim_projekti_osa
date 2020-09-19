package com.example.heatcam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.Executor;

public class Usr_tempActivity2 extends AppCompatActivity {
    private Button buttonStart, buttonStart2, buttonStart3;
    private TextView text, text2;
    ProgressBar vProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usr_t_layout);

        buttonStart = (Button)findViewById(R.id.start);
        buttonStart2 = (Button)findViewById(R.id.start2);
        buttonStart3 = (Button)findViewById(R.id.start3);
        text2 = (TextView)findViewById(R.id.textView2);
        text2.setText("THERMAL CAMERA");
        vProgressBar = (ProgressBar)findViewById(R.id.vprogressbar);



        buttonStart.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                buttonStart.setClickable(false);
                new asyncTaskUpdateProgress().execute();
                text = (TextView)findViewById(R.id.textView);

                text.setText("Your body temperature is too high!");
            }});
        buttonStart2.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                buttonStart2.setClickable(false);
                new asyncTaskUpdateProgress2().execute();
                text = (TextView)findViewById(R.id.textView);
                text.setText("Your body temperature is within normal limits!");
            }});
        buttonStart3.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                buttonStart3.setClickable(false);
                new asyncTaskUpdateProgress3().execute();
                text = (TextView)findViewById(R.id.textView);
                text.setText("Your body temperature is too low!");
            }});
    }


    public class asyncTaskUpdateProgress extends AsyncTask<Void, Integer, Void> {

        int progress;

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            buttonStart.setClickable(true);
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            progress = 0;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // TODO Auto-generated method stub
            vProgressBar.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            while(progress<80){
                progress++;
                publishProgress(progress);
                SystemClock.sleep(50);
            }
            return null;
        }


    }
    public class asyncTaskUpdateProgress2 extends AsyncTask<Void, Integer, Void> {

        int progress;

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            buttonStart.setClickable(true);
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            progress = 0;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // TODO Auto-generated method stub
            vProgressBar.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            while(progress<60){
                progress++;
                publishProgress(progress);
                SystemClock.sleep(50);
            }
            return null;
        }

    }
    public class asyncTaskUpdateProgress3 extends AsyncTask<Void, Integer, Void> {

        int progress;

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            buttonStart.setClickable(true);
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            progress = 0;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // TODO Auto-generated method stub
            vProgressBar.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            while(progress<30){
                progress++;
                publishProgress(progress);
                SystemClock.sleep(50);
            }
            return null;
        }

    }



}