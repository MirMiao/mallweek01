package com.bw.miaoheng20191203.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 时间 :2019/12/3  9:29
 * 作者 :苗恒
 * 功能 : 网络工具类
 */
public class NetUtil {
    private static NetUtil netUtil=new NetUtil();

    private NetUtil() {
    }

    public static NetUtil getInstance() {
        return netUtil;
    }
    @SuppressLint("StaticFieldLeak")
    public void getJson(final String url, final MyCallBack myCallBack){
         new AsyncTask<Void, Void, String>() {
             @Override
             protected void onPostExecute(String s) {
                 myCallBack.getjson(s);
             }

             @Override
             protected String doInBackground(Void... voids) {
                 String s="";
                 InputStream inputStream=null;
                 try {
                     URL url1 = new URL(url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if(httpURLConnection.getResponseCode()==200){
                         inputStream = httpURLConnection.getInputStream();
                        int len=-1;
                        byte[] bytes = new byte[1024];
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        while ((len=inputStream.read(bytes)) !=-1){
                            outputStream.write(bytes,0,len);
                        }
                        byte[] bytes1 = outputStream.toByteArray();
                         s = new String(bytes1);
                    }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }finally {
                     if (inputStream != null) {
                         try {
                             inputStream.close();
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     }
                 }

                 return s;
             }
         }.execute();
    }
    public interface MyCallBack{
        void getjson(String json);
    }
    @SuppressLint("StaticFieldLeak")
    public void getPhoto(final String url, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                InputStream inputStream=null;
                Bitmap bitmap=null;
                try {
                    URL url1 = new URL(url);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if(httpURLConnection.getResponseCode()==200){
                        inputStream = httpURLConnection.getInputStream();
                         bitmap = BitmapFactory.decodeStream(inputStream);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return bitmap;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
  public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else{
            return false;
        }
    }

}
