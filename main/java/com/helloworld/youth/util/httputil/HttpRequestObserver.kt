package com.helloworld.util.httputil

//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.fastjson.FastJsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpRequestObserver {
    val BASEURL: String = "http://192.168.100.113:8080/hljgdserver/"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
      //  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(FastJsonConverterFactory.create())
        .client(
            OkHttpClient().newBuilder().connectTimeout(25, TimeUnit.SECONDS).writeTimeout(
                20,
                TimeUnit.SECONDS
            ).readTimeout(20, TimeUnit.SECONDS).build()
        )
        .build();

    fun Get(url: String, params: Map<String, String>, responseCallBack: ResponseObservber) {
        var service = retrofit.create(
            RequestRetrofitInterface::class.java);
//        service.Get(BASEURL + url, params).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread()).subscribe(responseCallBack)
    }

    fun Post(url: String, params: Map<String, String>, responseCallBack: ResponseObservber) {
        var service = retrofit.create(
            RequestRetrofitInterface::class.java);
        println("地址${BASEURL + url}")
//        service.Post(BASEURL + url, params).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread()).subscribe(responseCallBack)
    }

}