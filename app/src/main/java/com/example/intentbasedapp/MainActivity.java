package com.example.intentbasedapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     ImageView IaV1,IaV2,IaV3,IaV4;
     Button BTN1;
     final int CREATE_CONTACT = 1;
     String name = "",number = "",web = "",location = "",mood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IaV1=(ImageView)findViewById(R.id.IV1);
        IaV2=(ImageView)findViewById(R.id.IV2);
        IaV3=(ImageView)findViewById(R.id.IV3);
        IaV4=(ImageView)findViewById(R.id.IV4);
        BTN1=(Button)findViewById(R.id.BTN1);

        BTN1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.intentbasedapp.CreateContact.class);
                startActivityForResult(intent,CREATE_CONTACT);// the activity starts the create contact activity and comes back with some result .
            }
        });
              IaV1.setVisibility(View.GONE);
              IaV2.setVisibility(View.GONE);
              IaV3.setVisibility(View.GONE);
              IaV4.setVisibility(View.GONE);

        IaV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
        IaV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+web));
                startActivity(intent);
            }
        });

        IaV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q =" +location));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CREATE_CONTACT)
        {
           if(resultCode == RESULT_OK)
           {
               IaV1.setVisibility(View.VISIBLE);
               IaV2.setVisibility(View.VISIBLE);
               IaV3.setVisibility(View.VISIBLE);
               IaV4.setVisibility(View.VISIBLE);

               name = data.getStringExtra("name");
               number = data.getStringExtra("number");
               web = data.getStringExtra("web");
               location = data.getStringExtra("map");
               mood = data.getStringExtra("mood");

               if(mood.equals("happy"))
               {
                   IaV1.setImageResource(R.drawable.happy);
               }
               else if(mood.equals("sad"))
               {
                   IaV1.setImageResource(R.drawable.sad);
               }
               else if(mood.equals("ok"))
               {
                   IaV1.setImageResource(R.drawable.ok);
               }
               else
               {
                   Toast.makeText(this,"No data Passed ", Toast.LENGTH_SHORT).show();
               }

           }
        }
    }
}