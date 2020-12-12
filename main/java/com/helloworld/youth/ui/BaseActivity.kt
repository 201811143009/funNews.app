package com.helloworld.youth.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.helloworld.youth.BaseApplication
import com.helloworld.youth.util.activityutil.ActivityManager

open class BaseActivity : AppCompatActivity() {
    var params: HashMap<String, String> = HashMap()
    var exitTime = 0L
    var context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        //PushAgent.getInstance(context).onAppStart();
       // val tintManager = SystemBarTintManager(this)
        // enable status bar tint
//        tintManager.isStatusBarTintEnabled = true
//        // enable navigation bar tint
//        tintManager.setNavigationBarTintEnabled(true)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (context::class.java.equals(MainActivity::class.java)) {
            exit()
        } else {
            super.onBackPressed()
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    fun exit() {
        if (System.currentTimeMillis() - exitTime > BaseApplication.exitTimeInterval) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            finish()
            ActivityManager.getScreenManager().popAllActivity()
            System.exit(0)
        }
    }


}