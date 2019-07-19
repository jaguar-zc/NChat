package org.flyants.book.network;


import org.flyants.book.BuildConfig;
import org.flyants.book.NChatApplication;
import org.flyants.book.R;
import org.flyants.book.network.okhttp.HeaderInterceptor;
import org.flyants.book.network.okhttp.LoggingInterceptor;
import org.flyants.book.network.okhttp.RewriteCacheControlInterceptor;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RequestUtils {

//    private static final String HOST = "http://icooding.oss-cn-shenzhen.aliyuncs.com";
//    private static final String HOST = "http://flyants-api.devopscloud.cn:10000";
//    private static final String HOST = "http://flyants-api.devopscloud.cn:10000";

    private static Retrofit retrofit;
    private static Retrofit retrofitStatic;


    static {
        File httpCacheDirectory = new File(NChatApplication.getFlyantsApplication().getCacheDir(), "FlyantsHttpCache");//这里为了方便直接把文件放在了SD卡根目录的HttpCache中，一般放在context.getCacheDir()中
        int cacheSize = 10 * 1024 * 1024;//设置缓存文件大小为10M
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .addInterceptor(new RewriteCacheControlInterceptor())//设置缓存拦截器
                .addInterceptor(new HeaderInterceptor())//设置Header
                .connectTimeout(30, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间.writeTimeout(BuildConfig.DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
                .cache(cache)
                .retryOnConnectionFailure(true);//错误重连
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new LoggingInterceptor());
        }
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(NChatApplication.getFlyantsApplication().getString(R.string.host))
                .client( builder.build())
                .build();


        OkHttpClient.Builder builderStatic = new OkHttpClient.Builder()
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .addInterceptor(new HeaderInterceptor())//设置Header
                .connectTimeout(60, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间.writeTimeout(BuildConfig.DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
                .retryOnConnectionFailure(true);//错误重连
        retrofitStatic = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(NChatApplication.getFlyantsApplication().getString(R.string.host))
                .client( builderStatic.build())
                .build();



    }

    /**
     * 请求自己服务器
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T build(Class<T> tClass){
        return (T) retrofit.create(tClass);
    }

    public static <T> T buildStaticApi(Class<T> tClass){
        return (T) retrofitStatic.create(tClass);
    }

}

