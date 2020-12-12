 package com.helloworld.util.httputil

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
interface RequestInterface {
    @GET
    fun getCall() : Call<ResponseData>
    // @GET注解的作用:采用Get方法发送网络请求
    // getCall() = 接收网络请求数据的方法
    // 其中返回类型为Call<*>，*是接收数据的类（即上面定义的Translation类）
    // 如果想直接获得Responsebody中的内容，可以定义网络请求返回值为Call<ResponseBody>
    //动态配置URL地址

    @GET
    fun Get(@Url url:String,@FieldMap params:Map<String,String>):Call<ResponseData>

    //Post 表单形式请求
    @FormUrlEncoded
    @POST
    fun Post(@Url url:String,@FieldMap params:Map<String,String>):Call<ResponseData>

    //动态指定查询条件
    @GET
    fun getIpMsgQuery(@Query("ip") ip:String):Call<ResponseData>

    //动态指定查询条件组
    @GET
    fun getIpMsgQueryMap(@QueryMap option:Map<String,String>):Call<ResponseData>

    //POST JSON数据请求
    @POST
    fun getIpMsgPostBody(@Body ip: String):Call<ResponseData>

    //单文件上传
    @Multipart
    @POST
    fun upDateUser(@Part photo: MultipartBody.Part, @Part("description") description: RequestBody):Call<ResponseData>
    //多文件上传
    @Multipart
    @POST
    fun upDateUser(@PartMap photos:Map<String,String>, @Part("description") description: RequestBody):Call<ResponseData>
}
