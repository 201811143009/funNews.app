package com.helloworld.youth.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.helloworld.youth.R
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
       var mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(root, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .createAgentWeb()
            .ready()
            .go("http://v.juhe.cn/toutiao/index")
    }
}