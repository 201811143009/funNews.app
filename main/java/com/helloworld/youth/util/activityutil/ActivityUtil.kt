package com.helloworld.util.activityutil

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.helloworld.youth.ui.BaseActivity

class ActivityUtil< T : BaseActivity> {
    companion object {
        private var instance: ActivityUtil<BaseActivity>? = null

            get() {
                if (field == null) {
                    field = ActivityUtil()
                }
                return field
            }
        fun get(): ActivityUtil<BaseActivity>{
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
    }


    // 普通跳转
    fun NormalJump(mContext: Context,  cls:T) {
        Log.d("错误", mContext.javaClass.name)
        val intent = Intent(mContext, cls::class.java)
        mContext.startActivity(intent)

    }

    // 结束
    fun finish(activity: Activity?) { // Log.d("错误", String.valueOf(mContext.getClass()));
        ActivityManagerKT.screenManager?.popActivity(activity)

    }

    // 带参跳转
    fun BundleJump(
        mContext: Context,
        cls: T,
        bundle: Bundle?
    ) {
        ActivityManagerKT.screenManager?.pushActivity(mContext as Activity)
        val intent = Intent(mContext, cls::class.java)
        intent.putExtras(bundle!!)
        mContext.startActivity(intent)
    }


    // 带返回值跳转跳转
    fun JumpForResult(
        mActivity: Activity, cls:T,
        bundle: Bundle?, requestCode: Int
    ) {
        val intent = Intent(mActivity, cls::class.java)
        intent.putExtras(bundle!!)
        mActivity.startActivityForResult(intent, requestCode)
    }

    fun JumpForResultNobundle(
        mActivity: Activity, cls:T,
        requestCode: Int
    ) {
//        }
        val intent = Intent(mActivity, cls::class.java)
        mActivity.startActivityForResult(intent, requestCode)
    }


    // 跳转到登陆
    fun NormalJumpFromLogin(mContext: Context, cls:T) {
        val intent = Intent(mContext, cls::class.java)
        mContext.startActivity(intent)
    }

    // 单一返回
    fun Back(mContext: Context) {
        if (mContext as Activity == ActivityManagerKT.screenManager?.currentActivity()
        ) {
            ActivityManagerKT.screenManager?.popActivity(mContext)
        } else {
            (mContext ).finish()
        }
    }

    // 返回到主页
//    fun BackToHome(mContext: Context?) {
//        ActivityManager.screenManager?.popAllActivity()
//    }

    // 返回到固定Activity
    fun BackToStep(
        mactivity: Activity
    ) {
        if (ActivityManagerKT.getStack().contains(
                mactivity
            )
        ) {
            for (activity in ActivityManagerKT.getStack()) {
                if (activity.javaClass == mactivity) {
                    return
                } else {
                    ActivityManagerKT.screenManager?.popActivity(activity)
                }
            }
        }
    }

//    // 返回到主页
//    fun BackToHome2(mContext: Context?) {
//        ActivityManager.screenManager?.popAllActivity()
//    }

    // 返回第几部
    fun BackByStep(
        num: Int
    ) {
        ActivityManagerKT.screenManager?.popActivity(num)
    }


    fun AdvertisementJump(mContext: Activity, cls: Class<*>?) {
        Log.d("错误", mContext.javaClass.toString())
        val intent = Intent(mContext, cls)
        mContext.startActivity(intent)
        mContext.finish()
    }
}