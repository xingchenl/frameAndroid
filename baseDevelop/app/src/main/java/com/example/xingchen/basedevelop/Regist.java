package com.example.xingchen.basedevelop;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Regist extends Activity {
    private EditText userName,passWorld,phoneNumber,email,homeAddress;
    private Button regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();

    }

    public void init(){
        userName= (EditText) findViewById(R.id.re_username);
        passWorld= (EditText) findViewById(R.id.re_password);
        phoneNumber= (EditText) findViewById(R.id.re_phonenumber);
        email= (EditText) findViewById(R.id.re_email);
        homeAddress= (EditText) findViewById(R.id.re_homeaddress);
        regist= (Button) findViewById(R.id.re_regist);
    }
}
