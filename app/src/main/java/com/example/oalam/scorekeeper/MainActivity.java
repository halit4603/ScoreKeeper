package com.example.oalam.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewTeam1;
    TextView textViewTeam2;
    ImageButton scoreIncrease;
    ImageButton scoreDecrease;
    int team1_score=0;
    int team2_score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTeam1=(TextView)findViewById(R.id.textView_score1);
        textViewTeam2=(TextView)findViewById(R.id.textView_score2);
        if (savedInstanceState != null) {
            team1_score = savedInstanceState.getInt("score1");
            team2_score = savedInstanceState.getInt("score2");

            //Set the score text views
            textViewTeam1.setText(String.valueOf(team1_score));
            textViewTeam2.setText(String.valueOf(team2_score));
        }
    }

    public void decreaseScore(View view) {
        switch (view.getId()){
            case R.id.imageButton_1_Minus:
                if(team1_score>0){
                team1_score--;}
                else{
                    team1_score=0;
                }
                textViewTeam1.setText(Integer.toString(team1_score));
                break;
            case R.id.imageButton_2_Minus:
                if(team2_score>0){
                    team2_score--;}
                else{
                    team2_score=0;
                }
                textViewTeam2.setText(Integer.toString(team2_score));

                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
//Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            }
            recreate();
        }
        return true;
    }
    public void increaseScore(View view) {
        switch (view.getId()){
            case R.id.imageButton_1_Plus:
                team1_score++;
                textViewTeam1.setText(String.valueOf(team1_score));

                break;
            case R.id.imageButton_2_Plus:
                team2_score++;
                textViewTeam2.setText(String.valueOf(team2_score));

                break;
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt("score1", team1_score);
        outState.putInt("score2", team2_score);
        super.onSaveInstanceState(outState);
    }
}
