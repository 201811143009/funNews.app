package com.helloworld.util.httputil

import com.alibaba.fastjson.JSONObject


class ResponseData {
    var id: Int = 0
    var code: Int = 0
    var msg: String? = null
    var data: Any? = null

    constructor(id: Int, code: Int, msg: String?, data: Any?) {
        this.id = id
        this.code = code
        this.msg = msg
        this.data = data

    }

    override fun toString(): String {
        return "ResponseData(id=$id, code=$code, msg=$msg, data=$data)"
    }

}



