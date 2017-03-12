package com.example.xingchen.basedevelop.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xingchen.basedevelop.R;

/**
 * Created by xingchen on 2017/3/12.
 */

public class setting_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_setting,container,false);
        return root;
    }
}