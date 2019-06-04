package org.flyants.book.network.okhttp;


import android.content.Context;

import com.maning.mndialoglibrary.MProgressDialog;

import org.flyants.book.NChatApplication;
import org.flyants.book.utils.JsonUtils;
import org.flyants.book.utils.RespError;
import org.flyants.book.utils.ToastUtils;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RespCall<T> implements Callback<T> {


    private Context context;
    private boolean isLooding = false;
    private String loodingText = "";

    public RespCall() {
        this(false);
    }

    public RespCall(boolean isLooding) {
        this(isLooding,"");
    }

    public RespCall(boolean isLooding, String loodingText) {
        this(NChatApplication.getFlyantsApplication(),isLooding,loodingText);
    }

    public RespCall(Context context, boolean isLooding, String loodingText) {
        this.context = context;
        this.isLooding = isLooding;
        this.loodingText = loodingText;
        if(this.isLooding){
            MProgressDialog.showProgress(this.context,this.loodingText);
        }
    }



    public abstract void onResp(T resp );

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(this.isLooding){
            MProgressDialog.dismissProgress();
        }
        if(response.code() != 200){
            try {
                RespError error = JsonUtils.toBean(response.errorBody().string(), RespError.class);
//                if(NotToastErrorCode.contains(error.getResp_code())){
//                    onServerError();
//                }else{
                    ToastUtils.show(error.getResp_msg());
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
                onResp(response.body());
        }
    }

    public void onServerError( ) {
        ToastUtils.show("服务器繁忙");
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if(this.isLooding){
            MProgressDialog.dismissProgress();
        }
        try {
            RespError error = JsonUtils.toBean(call.execute().errorBody().string(), RespError.class);
            ToastUtils.show(error.getResp_msg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
