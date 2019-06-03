package org.flyants.book.resources;

import org.flyants.book.utils.Page;
import org.flyants.book.view.dynamic.DynamicResp;
import org.flyants.book.view.dynamic.PublishReq;
import org.flyants.book.view.my.UserInfo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DynamicApis {


    @GET("/api/v1/app/dynamic/list/friend")
    Call<Page<DynamicResp>> getDynamicListByFriend(@Query("page")  int page);

    @GET("/api/v1/app/dynamic/list/self")
    Call<Page<DynamicResp>> getDynamicListBySelf(@Query("page")  int page);

    @POST("/api/v1/app/dynamic/publish")
    Call<ResponseBody> publish(@Body PublishReq publishReq);


}
