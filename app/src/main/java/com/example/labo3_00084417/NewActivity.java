package com.example.labo3_00084417;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewActivity extends AppCompatActivity {

    TextView sText1;
    Button mSubmitAction;
    String textAux = "Texto Quemado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        sText1 = findViewById(R.id.prueba_text);
        mSubmitAction = findViewById(R.id.btnShare);


        //Si la activity fue levantada por el intent
        Intent new_intent = getIntent();


        if(new_intent!=null){
            textAux = new_intent.getStringExtra(AppConstant.TEXT1_KEY);
        }
        sText1.setText(textAux);
        mSubmitAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Enviando implicitamente
                Intent mIntent2 = new Intent();
                mIntent2.setAction(Intent.ACTION_SEND);
                mIntent2.setType("text/plain");
                mIntent2.putExtra(Intent.EXTRA_TEXT,textAux);
                startActivity(mIntent2);
            }
        });
    }
}
