package org.flyants.book.store;

import android.content.Context;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.NChatApplication;
import org.flyants.book.utils.JsonUtils;
import org.flyants.book.utils.LogUtils;
import org.flyants.book.view.area.Provinces;
import org.flyants.common.store.IStore;
import org.flyants.common.store.OnCallback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AreaStore implements IStore<String,List<Provinces> > {

    public static AreaStore me = new AreaStore();

    private static List<Provinces> provincesList = new ArrayList<>();

    {
        StoreManager.getInstance().register(this);
    }

    @Override
    public void loadObject(Context context, OnCallback<List<Provinces>> callback) {
        this.loadObject(context,null,callback);
    }

    @Override
    public void loadObject(Context context, String param, OnCallback<List<Provinces>> callback) {
        if(provincesList.size() == 0){
//            OssApis build = RequestUtils.buildExternalReq(OssApis.class);
//            build.getAreaAll().enqueue(new RespCall<List<Provinces>>() {
//                @Override
//                public void onResp(List<Provinces> resp) {
//                    provincesList = resp;
//                    callback.call(provincesList);
//                }
//            });
            String areaStr = getAreaStr();
            LogUtils.d("getAreaStr:"+areaStr);
            if(StringUtils.isNotEmpty(areaStr)){
                provincesList = JsonUtils.toList(areaStr, Provinces.class);
                callback.call(provincesList);
            }
        }else{
            callback.call(provincesList);
        }
    }


    private String getAreaStr(){
        String fileName = "1562643354498.txt";
        String Result="";
        try(InputStreamReader inputReader = new InputStreamReader(NChatApplication.getFlyantsApplication().getResources().getAssets().open(fileName) );BufferedReader bufReader = new BufferedReader(inputReader)) {
            String line="";
            while((line = bufReader.readLine()) != null) {
                Result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result;
    }

    @Override
    public void clean() {
        provincesList.clear();
    }
}
