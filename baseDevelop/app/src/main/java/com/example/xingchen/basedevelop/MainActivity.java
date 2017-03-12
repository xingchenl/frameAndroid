package com.example.xingchen.basedevelop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.xingchen.basedevelop.fragment.main_fragment;
import com.example.xingchen.basedevelop.fragment.message_fragment;
import com.example.xingchen.basedevelop.fragment.setting_fragment;
import com.example.xingchen.basedevelop.fragment.user_fragment;

public class MainActivity extends AppCompatActivity {
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;
    private RadioGroup rg_tab_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        onCleck();
    }

    public void init(){
        rb_channel = (RadioButton) findViewById(R.id.rb_channel);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_better = (RadioButton) findViewById(R.id.rb_better);
        rb_setting = (RadioButton) findViewById(R.id.rb_setting);
    }

    public void onCleck(){
        getFragmentManager().beginTransaction().replace(R.id.fragment, new main_fragment()).commit();
        rb_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment, new main_fragment()).commit();

            }
        });
        rb_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment, new message_fragment()).commit();

            }
        });
        rb_better.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment, new user_fragment()).commit();
            }
        });

        rb_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment, new setting_fragment()).commit();
            }
        });
    }
}
