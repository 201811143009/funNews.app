package com.helloworld.util.httputil

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.fastjson.FastJsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpRequest {
    val BASEURL: String = ""
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(FastJsonConverterFactory.create())
        .client(
            OkHttpClient().newBuilder().connectTimeout(25, TimeUnit.SECONDS).writeTimeout(
                20,
                TimeUnit.SECONDS
            ).readTimeout(20, TimeUnit.SECONDS).build()
        )
        .build();

    fun Get(url: String, params: Map<String, String>,responseCallBack: ResponseCallBack) {
        var service = retrofit.create(
            RequestInterface::class.java);
        service.Get(BASEURL + url, params).enqueue(responseCallBack)
    }
    fun Post(url: String, params: Map<String, String>,responseCallBack: ResponseCallBack) {
        var service = retrofit.create(
            RequestInterface::class.java);
        service.Post(BASEURL + url, params).enqueue(responseCallBack)
    }

}