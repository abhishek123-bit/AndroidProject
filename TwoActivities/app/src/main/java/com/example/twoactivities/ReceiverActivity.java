package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.twoactivities.databinding.ActivityMainBinding;
import com.example.twoactivities.databinding.ActivityReceiverBinding;

public class ReceiverActivity extends AppCompatActivity {
    ActivityReceiverBinding b;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        b=ActivityReceiverBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        Intent intent =getIntent();
        String ReceiveMsg=intent.getStringExtra(Constant.EXTRA_MASSAGE);
        b.textSend.setText(ReceiveMsg);
        b.btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReplyMsg=b.MsgReply.getText().toString();
                if(ReplyMsg.length()==0){
                    Toast.makeText(ReceiverActivity.this, "Invalid!", Toast.LENGTH_SHORT).show();
                }
                Intent replyintent=new Intent();
                replyintent.putExtra(Constant.EXTRA_REPLY,ReplyMsg);
                setResult(RESULT_OK,replyintent);
                finish();
            }
        });
    }
}