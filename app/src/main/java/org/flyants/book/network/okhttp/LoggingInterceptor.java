package org.flyants.book.network.okhttp;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.utils.LogUtils;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class LoggingInterceptor implements Interceptor {
    public static final String TAG = "NETWORK";


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl requestUrl = request.url();
        Headers requestHeaders = request.headers();
        LogUtils.d(TAG,"Request Url:" + requestUrl);
        LogUtils.d(TAG,"Request Method:" + request.method());

        if(StringUtils.equals(request.method(),"POST")){
            try {
                Buffer buffer = new Buffer();
                request.body().writeTo(buffer);
                String s = buffer.readByteString().utf8();
                LogUtils.d(TAG,"Request Body:" + s);
            } catch (Exception e) {
            }
        }
        LogUtils.d(TAG,"Request Header:" + requestHeaders.toString());
        Response response = chain.proceed(chain.request());
        String content = response.body().string();
        LogUtils.d(TAG,"Response Status:" + response.code());
        LogUtils.d(TAG,"Response Entity:" + content);
        return response.newBuilder()
                .body(ResponseBody.create(MediaType.parse("UTF-8"), content))
                .build();
    }
}