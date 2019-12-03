package com.bw.miaoheng20191203.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.miaoheng20191203.R;
import com.bw.miaoheng20191203.base.BaseFragment;
import com.bw.miaoheng20191203.util.NetUtil;

/**
 * 时间 :2019/12/3  8:52
 * 作者 :苗恒
 * 功能 :
 */
public class HomeFragment extends BaseFragment {


    private LinearLayout linearLayout;
    private TextView textView;

    @Override
    protected void initData() {
        if(NetUtil.getInstance().hasNet(getActivity())){
            //有网
            linearLayout.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }else{
            linearLayout.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }
    }
    @Override
    protected void initView(View inflate) {
       //查询控件id
        linearLayout = inflate.findViewById(R.id.ll);
        textView = inflate.findViewById(R.id.tv);
    }
    @Override
    protected int layoutid() {
        return R.layout.homefragment;
    }

}
