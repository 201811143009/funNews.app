package com.helloworld.util.httputil

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response

open abstract class ResponseCallBack(context: Context) : retrofit2.Callback<ResponseData>,
    StatusInterface {
    var context = context



//    override fun Failure(responseData: ResponseData?) {
//        Toast.makeText(context, "获取数据失败", Toast.LENGTH_SHORT).show()
//    }

    override fun Error(t: Throwable?) {
        Toast.makeText(context, "错误:${t?.message}", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(call: Call<ResponseData>, t: Throwable) {
        Error(t)
    }

    override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
        if (response.isSuccessful) {
            Success(response.body())
        } else {
            Failure(response.body())
        }
    }

}