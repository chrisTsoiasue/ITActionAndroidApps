package com.itaction.chris.guessmysquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button[][] grid = new Button[9][4];
    private String userGuess;
    private String compChoice;
    private Random rand = new Random();
    private int numOfGuesses = 0; //Test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compChoice = (rand.nextInt(9) + 1) + ", " + (rand.nextInt(4) + 1);

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = findViewById(getResources().getIdentifier("button" + String.valueOf(i + 1) + String.valueOf(j + 1), "id", getPackageName()));
                grid[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String x = getResources().getResourceEntryName(v.getId());
                        userGuess = x.charAt(x.length() - 2) + ", " + x.charAt(x.length() - 1);
                        Toast.makeText(MainActivity.this, userGuess, Toast.LENGTH_SHORT).show();

                        if (compChoice.equals(userGuess))
                             Toast.makeText(MainActivity.this, "you win", Toast.LENGTH_SHORT).show();
                        else {
                            numOfGuesses++;

                            if (numOfGuesses >= 3)
                                Toast.makeText(MainActivity.this, "you lose", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }


        View.OnClickListener press = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hey", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
