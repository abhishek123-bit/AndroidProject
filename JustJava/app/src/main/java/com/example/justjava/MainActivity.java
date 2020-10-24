
package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.justjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
     int quantity=0;
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

    }

    public void Increment(View view) {
       b.Quantity.setText(++quantity+"");
    }

    public void Decrement(View view) {
        if(quantity==0){
            return;
        }
        b.Quantity.setText(--quantity+"");
    }

    public void PriceOfOrder(View view) {
        int baseprice=5;
        if(b.checkBox.isChecked()){
            ++baseprice;
        }
        if(b.checkBox2.isChecked()){
            baseprice+=2;
        }
        int price=quantity*baseprice;
        if(price==0){
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            return;
        }
        if(b.nameOfperson.getText().length()==0){
            Toast.makeText(this, "Pls Enter Your name", Toast.LENGTH_SHORT).show();
            return;
        }

        String priceMessage="Name:"+b.nameOfperson.getText()+"\nTotal:$"+price+"\nThank you!";
        b.Price.setText(priceMessage);
    }
}