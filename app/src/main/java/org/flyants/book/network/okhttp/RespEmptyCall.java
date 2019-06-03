package org.flyants.book.network.okhttp;

import android.content.Context;

import com.maning.mndialoglibrary.MProgressDialog;

import org.flyants.book.NChatApplication;
import org.flyants.book.utils.JsonUtils;
import org.flyants.book.utils.RespError;
import org.flyants.book.utils.ToastUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RespEmptyCall  implements Callback<ResponseBody> {


    private Context context;
    private boolean isLooding = false;
    private String loodingText = "";

    public RespEmptyCall() {
        this(false);
    }

    public RespEmptyCall(boolean isLooding) {
        this(isLooding,"");
    }

    public RespEmptyCall(boolean isLooding, String loodingText) {
        this(NChatApplication.getFlyantsApplication(),isLooding,loodingText);
    }

    public RespEmptyCall(Context context, boolean isLooding, String loodingText) {
        this.context = context;
        this.isLooding = isLooding;
        this.loodingText = loodingText;
        if(this.isLooding){
            MProgressDialog.showProgress(this.context,this.loodingText);
        }
    }

    public void onSuccess(){
        
    }

    public void onFail(){

    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if(this.isLooding){
            MProgressDialog.dismissProgress();
        }
        okhttp3.Response raw = response.raw();
        if (raw.code() == 200) {
            onSuccess();
        }else{
            try {
                RespError error = JsonUtils.toBean(response.errorBody().string(), RespError.class);
//                if(NotToastErrorCode.contains(error.getCode())){
//                    onFailure(call,null);
//                }else{
                    ToastUtils.show(error.getResp_msg());
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        if(this.isLooding){
            MProgressDialog.dismissProgress();
        }
        ToastUtils.show("网络开小差了");
        onFail();
    }
}
