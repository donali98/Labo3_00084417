package com.example.labo3_00084417;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    JSONObject info;
    EditText txtUser,txtPass,txtEmail,txtGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        txtEmail = findViewById(R.id.txtEmail);
        txtGender = findViewById(R.id.txtGender);

        info = new JSONObject();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m_intent = new Intent(MainActivity.this,NewActivity.class);
                try {
                    info.put("username",txtUser.getText().toString());
                    info.put("password",txtPass.getText().toString());
                    info.put("email",txtEmail.getText().toString());
                    info.put("gender",txtGender.getText().toString());
                    m_intent.putExtra(AppConstant.TEXT1_KEY,  info.toString());
                    startActivity(m_intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
