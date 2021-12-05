package com.example.intentbasedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

     ImageView IaV1,IaV2,IaV3,IaV4;
     Button BTN1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IaV1.findViewById(R.id.IV1);
        IaV2.findViewById(R.id.IV2);
        IaV3.findViewById(R.id.IV3);
        IaV4.findViewById(R.id.IV4);
        BTN1.findViewById(R.id.BTN1);

        BTN1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

            }
        });
              IaV2.setVisibility(View.GONE);
              IaV3.setVisibility(View.GONE);
              IaV4.setVisibility(View.GONE);

//        IaV2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        IaV3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        IaV4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}