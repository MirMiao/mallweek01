package com.bw.miaoheng20191203.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bw.miaoheng20191203.R;
import com.bw.miaoheng20191203.eneity.ShopEntity;
import com.bw.miaoheng20191203.util.NetUtil;

import java.util.List;
import java.util.StringJoiner;

/**
 * 时间 :2019/12/3  10:09
 * 作者 :苗恒
 * 功能 :
 */
public class ShopAdapter extends BaseAdapter {
    Context context ;
    List<ShopEntity.ShopGridDataBean> shopGridData;
    public ShopAdapter(Context context , List<ShopEntity.ShopGridDataBean> shopGridData) {
        this.context=context;
        this.shopGridData=shopGridData;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         ViewHolder viewHolder;
         if(view==null){
             view=View.inflate(context,R.layout.item,null);
             viewHolder=new ViewHolder();
             viewHolder.imageView=view.findViewById(R.id.iv);
             viewHolder.t1=view.findViewById(R.id.tv_1);
             viewHolder.t2=view.findViewById(R.id.tv_2);
             view.setTag(viewHolder);
         }else{
             viewHolder= (ViewHolder) view.getTag();
         }
         viewHolder.t1.setText(shopGridData.get(i).getTitle());
         viewHolder.t2.setText(shopGridData.get(i).getPrice()+"");
        NetUtil.getInstance().getPhoto(shopGridData.get(i).getImageurl(),viewHolder.imageView);
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView t1;
        TextView t2;
    }
}
