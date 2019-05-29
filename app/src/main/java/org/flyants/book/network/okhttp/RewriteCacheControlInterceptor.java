package org.flyants.book.network.okhttp;

import org.flyants.book.FlyantsApplication;
import org.flyants.book.utils.NetworkUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RewriteCacheControlInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        //无网自动访问缓存
        if(!NetworkUtil.IsNetWorkEnable(FlyantsApplication.getFlyantsApplication())){
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)//只访问缓存
                    .build();
        }

        Response response = chain.proceed(request);

//        if (NetworkUtil.IsNetWorkEnable(DuomiApplication.getDuomiApplication())) {
        int maxAge = 60;//缓存失效时间，单位为秒
        return response.newBuilder()
                .removeHeader("Pragma")//清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                .header("Cache-Control", "public ,max-age=" + maxAge)
                .build();
//        } else {
            //这段代码设置无效
//                int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
//                return response.newBuilder()
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                        .removeHeader("Pragma")
//                        .build();
//        }
//        return response;
    }
}
