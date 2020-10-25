package com.example.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.twoactivities.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        b.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String SendMsg=b.MsgSend.getText().toString();
               if(SendMsg.length()==0){
                   Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                   return;
               }
                Intent intent=new Intent(MainActivity.this,ReceiverActivity.class);
                intent.putExtra(Constant.EXTRA_MASSAGE,SendMsg);
                startActivityForResult(intent,Constant.TEXT_REQUEST);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if((requestCode==1)){
            if(resultCode==RESULT_OK){
            String ReceivedMsg=data.getStringExtra(Constant.EXTRA_REPLY);
            b.textHeader.setVisibility(View.VISIBLE);
            b.textReply.setText(ReceivedMsg);
            b.textReply.setVisibility(View.VISIBLE);
            }
        }
    }
}