package org.flyants.book.view.dynamic.publish;

import android.content.Context;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.StaticApis;
import org.flyants.book.utils.LogUtils;
import org.flyants.common.utils.UploadCallbacks;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadArrayImage {

    List<String> imageList = new ArrayList<>();
    Context context;
    UploadCallbacks uploadCallbacks;
    int uploadIndex = 0;

    StaticApis staticApis;

    public UploadArrayImage(Context context, UploadCallbacks uploadCallbacks, List<String> imageList) {
        this.imageList = imageList;
        this.context = context;
        this.uploadCallbacks = uploadCallbacks;
        this.staticApis = RequestUtils.buildStaticApi(StaticApis.class);
    }


    public void start(){
        upload(uploadIndex);
    }


    public void upload(int index){
        if(index >= imageList.size()){
            uploadCallbacks.onSuccessful(imageList);
            return;
        }
        File file = new File(imageList.get(index));
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file",file.getName(),requestBody);
        staticApis.upload(filePart).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if(response.isSuccessful()){
                        imageList.set(index,response.body().string());
                        uploadIndex = uploadIndex + 1;
                        uploadCallbacks.onProgressUpdate(index);
                        upload(uploadIndex);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtils.d(e.getMessage());
                    uploadCallbacks.onError();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtils.d(t.getMessage());
                uploadCallbacks.onError();
            }
        });
    }


}
