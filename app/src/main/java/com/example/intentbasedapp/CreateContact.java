package com.example.intentbasedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity implements View.OnClickListener {

    EditText ET1,ET2,ET3,ET4;
    ImageView IVsad,IVhappy,IVok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        ET1 = findViewById(R.id.ET1);
        ET2 = findViewById(R.id.ET2);
        ET3 =  findViewById(R.id.ET3);
        ET4 = findViewById(R.id.ET4);
        IVhappy = findViewById(R.id.IV6);
        IVsad = findViewById(R.id.IV7);
        IVok = findViewById(R.id.IV5);

         IVsad.setOnClickListener(this);
         IVhappy.setOnClickListener(this);
         IVsad.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(ET1.getText().toString().isEmpty()||ET2.getText().toString().isEmpty()||ET3.getText().toString().isEmpty()||ET4.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please Enter all Fields ",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent();// send back some data with this intent
            intent.putExtra("name", ET1.getText().toString().trim());
            intent.putExtra("number", ET2.getText().toString().trim());
            intent.putExtra("web", ET3.getText().toString().trim());
            intent.putExtra("map", ET4.getText().toString().trim());


            if (v.getId() == R.id.IV6) {
                intent.putExtra("mood","happy");
            }
            else if (v.getId() == R.id.IV5) {

                intent.putExtra("mood","ok");

            }
            else {
                intent.putExtra("mood","sad");

            }
               setResult(RESULT_OK,intent);
            CreateContact.this.finish();
        }

    }
}