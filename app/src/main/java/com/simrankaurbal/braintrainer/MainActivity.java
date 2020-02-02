package com.simrankaurbal.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Button startbutton;
    public Button firstoptionbutton;
    public Button secondoptionbutton;
    public Button thirdoptionbutton;
    public Button fourthoptionbutton;
    public TextView sumtextView;
    public TextView resulttextView;
    public TextView pointstextView;
    public TextView TimertextView;
    public  Button playagainbutton;
    ConstraintLayout gamelayout;

    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofcorrectanswer;

    int score = 0;
    int numberofquestions = 0;


    public void playagain(final View view)
    {
        score = 0;
        numberofquestions = 0;

        TimertextView.setText("30s");
        pointstextView.setText("0/0");
        resulttextView.setText("");

        generatequestion();


        playagainbutton.setVisibility(View.INVISIBLE);

        new CountDownTimer(30100,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                TimertextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");

            }

            @Override
            public void onFinish() {

                playagainbutton.setVisibility(View.VISIBLE);
                TimertextView.setText("0s");
                resulttextView.setText("Your Score:" + Integer.toString(score) + "/" + Integer.toString(numberofquestions));
            }
        }.start();


    }

    public void generatequestion()
    {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumtextView.setText(Integer.toString(a) + " + " + Integer.toString(b));


        locationofcorrectanswer = rand.nextInt(4);
        answers.clear();

        int incorrectanswer;

        for (int i =0; i<4; i++)
        {
            if (i==locationofcorrectanswer)
            {
                answers.add(a + b);
            }
            else {
                incorrectanswer = rand.nextInt(41);

                while (incorrectanswer == a + b)
                {
                    incorrectanswer = rand.nextInt(41);

                }
                answers.add(incorrectanswer);
            }
        }

        firstoptionbutton.setText(Integer.toString(answers.get(0)));
        secondoptionbutton.setText(Integer.toString(answers.get(1)));
        thirdoptionbutton.setText(Integer.toString(answers.get(2)));
        fourthoptionbutton.setText(Integer.toString(answers.get(3)));

    }







    public void chooseanswer(View view){
//        Log.i("Tag", (String) view.getTag());

        if (view.getTag().toString().equals(Integer.toString(locationofcorrectanswer))){
            Log.i("Correct","Correct");

            score++;
            resulttextView.setText("Correct");


        }
        else {
            resulttextView.setText("Wrong");
        }

        numberofquestions++;
        pointstextView.setText(Integer.toString(score) + "/" + Integer.toString(numberofquestions));
        generatequestion();

    }

    public void start(View view )
    {
        startbutton.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(ConstraintLayout.VISIBLE);
        playagain(findViewById(R.id.playagainbutton));

        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startbutton=(Button)findViewById(R.id.startbutton);
        firstoptionbutton=(Button)findViewById(R.id.firstoptionbutton);
        secondoptionbutton=(Button)findViewById(R.id.secondoptionbutton);
        thirdoptionbutton=(Button)findViewById(R.id.thirdoptionbutton);
        fourthoptionbutton=(Button)findViewById(R.id.fourthoptionbutton);
        sumtextView=(TextView)findViewById(R.id.sumtextView);
        resulttextView=(TextView)findViewById(R.id.resulttextView);
        pointstextView=(TextView)findViewById(R.id.pointstextView);
        TimertextView=(TextView) findViewById(R.id.TimertextView);
        playagainbutton=(Button)findViewById(R.id.playagainbutton);
        gamelayout=(ConstraintLayout)findViewById(R.id.gamelayout);


//        generatequestion();




    }




}