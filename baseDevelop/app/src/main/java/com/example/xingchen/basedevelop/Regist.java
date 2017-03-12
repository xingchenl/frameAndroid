package com.example.xingchen.basedevelop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xingchen.basedevelop.util.EventMess;
import com.example.xingchen.basedevelop.util.VolleysPostString;

import de.greenrobot.event.EventBus;

public class Regist extends Activity {
    private EditText userName,passWorld,phoneNumber,email,homeAddress;
    private String nameText,passText,phoneText,emailText,addressText;
    private Button regist;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();
        getText();
        context=this;
        EventBus.getDefault().register(context);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolleysPostString volleysPostString=new VolleysPostString("url",context);
                volleysPostString.post();
            }
        });

    }

    public void init(){
        userName= (EditText) findViewById(R.id.re_username);
        passWorld= (EditText) findViewById(R.id.re_password);
        phoneNumber= (EditText) findViewById(R.id.re_phonenumber);
        email= (EditText) findViewById(R.id.re_email);
        homeAddress= (EditText) findViewById(R.id.re_homeaddress);
        regist= (Button) findViewById(R.id.re_regist);
    }
    public void getText(){
        nameText=userName.getText().toString();
        passText=passWorld.getText().toString();
        phoneText=phoneNumber.getText().toString();
        emailText=email.getText().toString();
        addressText=homeAddress.getText().toString();
    }

    public void onEventMainThread(EventMess event) {
        String msg = "登陆：" + event.getMessage();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        if(event.getMessage().equals("true")){
            Intent intent=new Intent(Regist.this,Login.class);
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
