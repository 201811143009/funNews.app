package com.helloworld.util.httputil

import com.helloworld.util.httputil.ResponseData

interface StatusInterface {

    fun Success(responseData: ResponseData?)
    fun Failure(responseData: ResponseData?)
    fun Error( t: Throwable?)
}