package com.simrankaurbal.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button startbutton;


    public void start(View view )
    {
        startbutton.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startbutton = (Button) findViewById(R.id.startbutton);
    }
}
