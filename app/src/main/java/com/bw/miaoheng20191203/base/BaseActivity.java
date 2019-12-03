package com.bw.miaoheng20191203.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 时间 :2019/12/3  8:54
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutid());
         initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutid();
}
