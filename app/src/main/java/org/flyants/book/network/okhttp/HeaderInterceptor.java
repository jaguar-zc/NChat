package org.flyants.book.network.okhttp;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {


    public final static String Authorization = "Authorization";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request()
                .newBuilder()
                .addHeader(Authorization, Authorization)
                .build();
        Response response = chain.proceed(request);
//        if (response.code() == 200 && response.body().contentLength() == 0) {
//            LogUtils.d("无返回数据");
//            return response.newBuilder()
//                    .      body(ResponseBody.create(MediaType.parse("UTF-8"), "success"))
//                    .build();
//        }
        return response;
    }
}