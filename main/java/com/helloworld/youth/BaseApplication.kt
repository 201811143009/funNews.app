package com.helloworld.youth

import android.app.Application
import cn.com.weather.cj.widget.view.WeatherConfig

open class BaseApplication : Application() {
    companion object{

        var exitTimeInterval = 2000L
        var indexTime = 5000L
    }

    override fun onCreate() {
        super.onCreate()
        WeatherConfig.init( "rjbhoWsswp",null);
    }
}