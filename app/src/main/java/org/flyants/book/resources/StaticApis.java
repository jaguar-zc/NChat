package org.flyants.book.resources;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface StaticApis {
    @Multipart
    @POST("/api/v1/app/static/upload/file")
    Call<ResponseBody> upload(@Part MultipartBody.Part part);
}
