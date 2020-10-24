package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.scorekeeper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding b;
     int ScoreTeamA=0;
     int ScoreTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        b.ThreeScoreTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTeamA+=3;
                b.teamAScore.setText(ScoreTeamA+"");
            }
        });
        b.TwoScoreTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTeamA+=2;
                b.teamAScore.setText(ScoreTeamA+"");
            }
        });
        b.FreeThrowTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.teamAScore.setText(++ScoreTeamA+"");
            }
        });
        b.ThreeScoreTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTeamB+=3;
                b.teamBScore.setText(ScoreTeamB+"");
            }
        });
        b.TwoScoreTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTeamB+=2;
                b.teamBScore.setText(ScoreTeamB+"");
            }
        });
        b.FreeThrowTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.teamBScore.setText(++ScoreTeamB+"");
            }
        });
        b.BtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTeamB=0;
                ScoreTeamA=0;
                b.teamBScore.setText("0");
                b.teamAScore.setText("0");
            }
        });
    }

}