package com.bw.miaoheng20191203.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.RadioGroup;

import com.bw.miaoheng20191203.R;
import com.bw.miaoheng20191203.base.BaseActivity;
import com.bw.miaoheng20191203.view.fragment.FenleiFragment;
import com.bw.miaoheng20191203.view.fragment.FindFragment;
import com.bw.miaoheng20191203.view.fragment.HomeFragment;
import com.bw.miaoheng20191203.view.fragment.MyFragment;
import com.bw.miaoheng20191203.view.fragment.ShoppingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private ViewPager viewPager;
    private RadioGroup radioGroup;

    @Override
    protected void initData() {
        final List<Fragment> list=new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new FenleiFragment());
        list.add(new FindFragment());
        list.add(new ShoppingFragment());
        list.add(new MyFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 switch (i){
                     case R.id.rb_1:
                         viewPager.setCurrentItem(0);
                         break;
                     case R.id.rb_2:
                         viewPager.setCurrentItem(1);
                         break;
                     case R.id.rb_3:
                         viewPager.setCurrentItem(2);
                         break;
                     case R.id.rb_4:
                         viewPager.setCurrentItem(3);
                         break;
                     case R.id.rb_5:
                         viewPager.setCurrentItem(4);
                         break;
                 }
            }
        });
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
    }

    @Override
    protected int layoutid() {
        return R.layout.activity_main;
    }
    public void qie(){
        viewPager.setCurrentItem(0);
    }
}
