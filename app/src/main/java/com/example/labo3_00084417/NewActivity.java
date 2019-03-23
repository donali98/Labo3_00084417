package com.example.labo3_00084417;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;



public class NewActivity extends AppCompatActivity {

    TextView txtUserResult,txtPassResult,txtEmailResult,txtGenderResult;
    Button btnSend;
    JSONObject info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        btnSend = findViewById(R.id.btnSendNew);
        txtUserResult = findViewById(R.id.txtNameResult);
        txtPassResult = findViewById(R.id.txtPasswordResult);
        txtEmailResult = findViewById(R.id.txtEmailResult);
        txtGenderResult = findViewById(R.id.txtGenderResult);


        //Si la activity fue levantada por el intent
        Intent new_intent = getIntent();

        if(new_intent!=null){
            String stringJson = new_intent.getExtras().getString(AppConstant.TEXT1_KEY);
            try {
                info = new JSONObject(stringJson);
                txtUserResult.setText(info.getString("username"));
                txtPassResult.setText(info.getString("password"));
                txtEmailResult.setText(info.getString("email"));
                txtGenderResult.setText(info.getString("gender"));


                //Log.i("newActivityLog",info.getString("username"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Enviando implicitamente
                Intent mIntent2 = new Intent();
                mIntent2.setAction(Intent.ACTION_SEND);
                mIntent2.setType("text/plain");
                mIntent2.putExtra(Intent.EXTRA_TEXT,"Texto");
                startActivity(mIntent2);
            }
        });
    }
}
