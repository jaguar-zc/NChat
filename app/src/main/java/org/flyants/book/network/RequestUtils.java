package org.flyants.book.network;


import org.flyants.book.FlyantsApplication;
import org.flyants.book.network.okhttp.HeaderInterceptor;
import org.flyants.book.network.okhttp.LoggingInterceptor;
import org.flyants.book.network.okhttp.RewriteCacheControlInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RequestUtils {

    private static final String HOST = "http://icooding.oss-cn-shenzhen.aliyuncs.com";

    private static Retrofit retrofit;


    static {
        File httpCacheDirectory = new File(FlyantsApplication.getFlyantsApplication().getCacheDir(), "FlyantsHttpCache");//这里为了方便直接把文件放在了SD卡根目录的HttpCache中，一般放在context.getCacheDir()中
        int cacheSize = 10 * 1024 * 1024;//设置缓存文件大小为10M
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .addInterceptor(new RewriteCacheControlInterceptor())//设置缓存拦截器
        .addInterceptor(new HeaderInterceptor())//设置Header
        .connectTimeout(30, TimeUnit.SECONDS)//设置连接超时时间
        .readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间.writeTimeout(BuildConfig.DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
        .cache(cache)
        .retryOnConnectionFailure(true);//错误重连
//        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new LoggingInterceptor());
//        }
        OkHttpClient client = builder.build();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(HOST)
                .client(client)
                .build();
    }

    public static <T> T build(Class<T> tClass){
        return (T) retrofit.create(tClass);
    }

}

