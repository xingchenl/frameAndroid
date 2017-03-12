package com.example.xingchen.basedevelop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xingchen.basedevelop.util.EventMess;
import com.example.xingchen.basedevelop.util.VolleysPostString;

import de.greenrobot.event.EventBus;

public class Login extends AppCompatActivity {
private EditText username,passworld;
    private Button login;
    private TextView regist;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username= (EditText) findViewById(R.id.log_username);
        passworld= (EditText) findViewById(R.id.log_password);
        login= (Button) findViewById(R.id.loginBtn);
        regist= (TextView) findViewById(R.id.creat_TaxtView);
        String nameText=username.getText().toString();
        String passText=passworld.getText().toString();
        context=this;
        EventBus.getDefault().register(context);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolleysPostString volleysPostString=new VolleysPostString("url",context);
                volleysPostString.post();
            }
        });

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Regist.class);
                startActivity(intent);
            }
        });

    }
    public void onEventMainThread(EventMess event) {
        String msg = "登陆：" + event.getMessage();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        if(event.getMessage().equals("true")){
            Intent intent=new Intent(Login.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        Log.d("harvic", msg);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
