package com.example.labo3_00084417;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button submit_action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit_action = findViewById(R.id.submit_action);
        submit_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m_intent = new Intent(MainActivity.this,NewActivity.class);
                m_intent.putExtra(AppConstant.TEXT1_KEY,"Texto desde MainActivity");
                startActivity(m_intent);
            }
        });
    }
}
