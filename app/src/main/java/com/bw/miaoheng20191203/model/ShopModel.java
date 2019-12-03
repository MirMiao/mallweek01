package com.bw.miaoheng20191203.model;

import com.bw.miaoheng20191203.contract.IShopContract;
import com.bw.miaoheng20191203.eneity.ShopEntity;
import com.bw.miaoheng20191203.util.NetUtil;
import com.google.gson.Gson;

/**
 * 时间 :2019/12/3  9:38
 * 作者 :苗恒
 * 功能 :
 */
public class ShopModel implements IShopContract.IMoldel {
    @Override
    public void getData(String url, final ModelCallBack modelCallBack) {
        NetUtil.getInstance().getJson(url, new NetUtil.MyCallBack() {
            @Override
            public void getjson(String json) {
                ShopEntity shopEntity = new Gson().fromJson(json, ShopEntity.class);
                modelCallBack.success(shopEntity);
            }
        });
    }
}
