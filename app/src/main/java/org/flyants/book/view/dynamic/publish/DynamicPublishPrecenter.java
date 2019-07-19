package org.flyants.book.view.dynamic.publish;

import com.maning.mndialoglibrary.MProgressDialog;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.DynamicApis;
import org.flyants.book.resources.StaticApis;
import org.flyants.book.utils.JsonUtils;
import org.flyants.book.utils.LogUtils;
import org.flyants.book.utils.ToastUtils;
import org.flyants.book.view.dynamic.DynamicVisibility;
import org.flyants.book.view.dynamic.PublishReq;
import org.flyants.common.store.OnCallback;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.utils.UploadCallbacks;

import java.util.List;

import okhttp3.ResponseBody;

class DynamicPublishPrecenter extends BasePresenter<DynamicPublishView,UIDynamicPublishView>  implements OnCallback<UserInfo> {

    DynamicApis dynamicApis ;
    StaticApis staticApis ;

    public DynamicPublishPrecenter(DynamicPublishView t, UIDynamicPublishView uiDynamicPublishView) {
        super(t, uiDynamicPublishView);
    }

    @Override
    public void onViewInit() {
        dynamicApis = RequestUtils.build(DynamicApis.class);
        staticApis = RequestUtils.build(StaticApis.class);
        UserStore.getInstence().loadObject(context,this);
    }

    @Override
    public void call(UserInfo userInfo) {
        uiView.setViewAttrs(userInfo);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void publish() {
        String content = uiView.getContent();
        String location = uiView.getLocation();
        DynamicVisibility dynamicVisibility = uiView.getDynamicVisibility();
        List<String> imageList = uiView.getImageList();
        if(StringUtils.isEmpty(content)){
            return;
        }
        int size = imageList.size();
        LogUtils.d(content);
        LogUtils.d(location);
        LogUtils.d(dynamicVisibility);
        UploadArrayImage uploadArrayImage = new UploadArrayImage(view, new UploadCallbacks() {
            @Override
            public void onProgressUpdate(int percentage) {
                LogUtils.d("上传图片进度["+percentage+"]");
            }

            @Override
            public void onError() {
                ToastUtils.show("上传图片失败");
                LogUtils.d("上传图片失败");
            }

            @Override
            public void onSuccessful(List<String> path) {
                LogUtils.d("uploadImage successful ");
                PublishReq publishReq  = new PublishReq();
                publishReq.setImages(path);
                publishReq.setText(content);
                publishReq.setVisibility(dynamicVisibility);
                publishReq.setLocation(location);
                LogUtils.d("uploadImage successful:"+ JsonUtils.convertObjectToJSON(publishReq));
                dynamicApis.publish(publishReq).enqueue(new RespCall<ResponseBody>() {
                    @Override
                    public void onResp(ResponseBody resp) {
                        ToastUtils.show("发布成功");
                        view.finish();
                    }
                });
            }
        },imageList);
        uploadArrayImage.start();
    }
}
