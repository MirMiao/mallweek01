package com.bw.miaoheng20191203.presenter;

import com.bw.miaoheng20191203.contract.IShopContract;
import com.bw.miaoheng20191203.eneity.ShopEntity;
import com.bw.miaoheng20191203.model.ShopModel;
import com.bw.miaoheng20191203.view.fragment.ShoppingFragment;

/**
 * 时间 :2019/12/3  9:39
 * 作者 :苗恒
 * 功能 :
 */
public class ShopPresenter implements IShopContract.IPresenter {

    private ShopModel shopModel;
    IShopContract.IView iView;
 //使用构造传递给view层
    public ShopPresenter(IShopContract.IView iView){
        this.iView=iView;
    }
    @Override
    public void getData(String url) {
         //获取MOdel层的数据
        shopModel = new ShopModel();
        shopModel.getData(url, new IShopContract.IMoldel.ModelCallBack() {
            @Override
            public void success(ShopEntity shopEntity) {
                iView.success(shopEntity);
            }
        });
    }
}
