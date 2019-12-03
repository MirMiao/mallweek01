package com.bw.miaoheng20191203.view.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bw.miaoheng20191203.R;
import com.bw.miaoheng20191203.base.BaseFragment;
import com.bw.miaoheng20191203.contract.IShopContract;
import com.bw.miaoheng20191203.eneity.ShopEntity;
import com.bw.miaoheng20191203.presenter.ShopPresenter;
import com.bw.miaoheng20191203.util.NetUtil;
import com.bw.miaoheng20191203.view.activity.MainActivity;
import com.bw.miaoheng20191203.view.adapter.ShopAdapter;

import java.util.List;

/**
 * 时间 :2019/12/3  9:05
 * 作者 :苗恒
 * 功能 :
 */
public class ShoppingFragment extends BaseFragment implements IShopContract.IView {

    private ShopPresenter shopPresenter;
    private Button button;
    private GridView gridView;
    @Override
    protected void initData() {

        shopPresenter = new ShopPresenter(this);
        if(NetUtil.getInstance().hasNet(getActivity())){
            shopPresenter.getData("http://blog.zhaoliang5156.cn/api/mall/mall.json");
        }else{
        }
    }

    @Override
    protected void initView(View inflate) {
        button = inflate.findViewById(R.id.bt);
        gridView = inflate.findViewById(R.id.gl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.qie();
            }
        });
    }
    @Override
    protected int layoutid() {
        return R.layout.shopingfragment;
    }

    @Override
    public void success(ShopEntity shopEntity) {
         //请求成功的数据
        List<ShopEntity.ShopGridDataBean> shopGridData = shopEntity.getShopGridData();
        ShopAdapter shopAdapter = new ShopAdapter(getActivity(), shopGridData);
        gridView.setAdapter(shopAdapter);

    }

    @Override
    public void defire(Throwable throwable) {
        //请求失败
        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
    }
}
