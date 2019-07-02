package org.flyants.book.store;

import android.content.Context;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.view.area.Provinces;
import org.flyants.common.store.IStore;
import org.flyants.common.store.OnCallback;

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
            Apis build = RequestUtils.build(Apis.class);
            build.getAreaAll().enqueue(new RespCall<List<Provinces>>() {
                @Override
                public void onResp(List<Provinces> resp) {
                    provincesList = resp;
                    callback.call(provincesList);
                }
            });
        }else{
            callback.call(provincesList);
        }
    }

    @Override
    public void clean() {
        provincesList.clear();
    }
}
