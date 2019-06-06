package org.flyants.book.store;

import android.content.Context;

import org.flyants.book.dto.PeopleAppConfig;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.network.okhttp.RespEmptyCall;
import org.flyants.book.resources.Apis;
import org.flyants.common.store.IUpdate;
import org.flyants.common.store.OnCallback;

/**
 * APP 设置
 */
public class AppConfigStrore implements IUpdate<PeopleAppConfig> {

    private PeopleAppConfig appConfig;

    private static AppConfigStrore me = new AppConfigStrore();

    public static AppConfigStrore getInstance(){
        return me;
    }

    @Override
    public void loadObject(Context context, OnCallback<PeopleAppConfig> callback) {
        if(appConfig == null){
            Apis apis = RequestUtils.build(Apis.class);;
            apis.getPeopleConfig().enqueue(new RespCall<PeopleAppConfig>() {
                @Override
                public void onResp(PeopleAppConfig resp) {
                    appConfig = resp;
                    callback.call(appConfig);
                }
            });
        }else{
            callback.call(appConfig);
        }
    }


    @Override
    public void update(PeopleAppConfig appConfig) {
        Apis apis = RequestUtils.build(Apis.class);
        apis.updatePeopleConfig(appConfig).enqueue(new RespEmptyCall(){
            @Override
            public void onSuccess() {
                super.onSuccess();
                clean();
            }
        });
    }

    @Override
    public void clean() {
        appConfig = null;
    }


}
