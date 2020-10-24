package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multiplicationtable.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        b.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String input=b.edText.getText().toString().trim();
                if(input.length()==0){
                    Toast.makeText(MainActivity.this, "Invalid!", Toast.LENGTH_SHORT).show();
                    return;
                }
                b.tvtable.setText(getdisplay(Integer.parseInt(input)));
            }
        });
    }
    public String getdisplay(int no){
        StringBuilder str=new StringBuilder();
        for (int i=1;i<=10;i++){
            str.append(no).append("X").append(i).append("=").append(no * i).append("\n");
        }
        return str.toString();
    }
}