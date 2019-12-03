package com.bw.miaoheng20191203.contract;

import com.bw.miaoheng20191203.eneity.ShopEntity;

/**
 * 时间 :2019/12/3  9:25
 * 作者 :苗恒
 * 功能 : 契约类
 */
public interface IShopContract {
    interface IMoldel{
        void getData(String url,ModelCallBack modelCallBack);
        //当请求成功的时候
        interface ModelCallBack{
            void success(ShopEntity shopEntity);
        }
    }
    interface IView{
        //成功
          void success(ShopEntity shopEntity);
          //失败
        void defire(Throwable throwable);
    }

    interface IPresenter{
       void getData(String url);
    }
}
