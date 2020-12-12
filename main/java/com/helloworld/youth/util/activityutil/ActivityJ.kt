package com.helloworld.util.activityutil

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.helloworld.youth.ui.BaseActivity
import com.helloworld.youth.util.activityutil.ActivityJump
import com.helloworld.youth.util.activityutil.ActivityManager

class ActivityJ<T : BaseActivity?>  // private Class<T> tClass;
 constructor() {
    // 普通跳转
    fun NormalJump(mContext: Context, cls: Class<T>?) {
        Log.d("错误", mContext.javaClass.toString())
        //        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        val intent = Intent(mContext, cls)
        mContext.startActivity(intent)
        //    ((AppCompatActivity) mContext).overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
// AlertDialogUtil.closeDialog();
// ((Activity) mContext).overridePendingTransition(R.anim.activity_in,
// R.anim.activity_out);
    }

    // 带参跳转
    fun BundleJump(
        mContext: Context,
        cls: Class<T>?,
        bundle: Bundle?
    ) { //        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        ActivityManager.getScreenManager()
            .pushActivity(mContext as Activity)
        val intent = Intent(mContext, cls)
        //intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(bundle!!)
        mContext.startActivity(intent)
        //  ((AppCompatActivity) mContext).overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
// ((Activity) mContext).overridePendingTransition(R.anim.activity_in,
// R.anim.activity_out);
    }

    // 带返回值跳转跳转
    fun JumpForResult(
        mActivity: Activity, cls: Class<T>?,
        bundle: Bundle?, requestCode: Int
    ) { //        if (!mActivity.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager().pushActivity(mActivity);
//        }
        val intent = Intent(mActivity, cls)
        intent.putExtras(bundle!!)
        mActivity.startActivityForResult(intent, requestCode)
        //   mActivity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
// mActivity.overridePendingTransition(R.anim.activity_in,
// R.anim.activity_out);
    }

    fun JumpForResultNobundle(
        mActivity: Activity, cls: Class<T>?,
        requestCode: Int
    ) { //        if (!mActivity.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager().pushActivity(mActivity);
//        }
        val intent = Intent(mActivity, cls)
        mActivity.startActivityForResult(intent, requestCode)
        //        mActivity.overridePendingTransition(R.anim.activity_in,
//                R.anim.activity_out);
    }

    // 登录跳转
// public static void LoginStatusCheck(Context mContext, Class<?> cls) {
// if (!mContext.getClass().equals(MainActivity.class)) {
// ActivityManager.getScreenManager()
// .pushActivity((Activity) mContext);
// }
// //Boolean result = ConnData.getLoginState();
// if (result) {
// Intent intent = new Intent(mContext, cls);
// mContext.startActivity(intent);
// } else {
// // ConnData.setJumpClass(cls);
// Intent intent = new Intent(mContext, LoginActivity.class);
// mContext.startActivity(intent);
// }
// }
// 跳转到登陆
    fun NormalJumpFromLogin(
        mContext: Context,
        cls: Class<T>?
    ) {
        val intent = Intent(mContext, cls)
        mContext.startActivity(intent)
    }

    // 返回到主页
    fun BackToHome(mContext: Context?) { //        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        ActivityManager.getScreenManager().popAllActivity()
    }

    // 返回到固定Activity
    fun BackToStep(
        mContext: Context?,
        mactivity: Activity
    ) { //        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        if (ActivityManager.getScreenManager().activityStack.contains(
                mactivity
            )
        ) {
            for (activity in ActivityManager.getScreenManager().activityStack) {
                if (activity.javaClass == mactivity) {
                    return
                } else {
                    ActivityManager.getScreenManager()
                        .popActivity(activity)
                }
            }
        }
    }

    // 返回到主页
    fun BackToHome2(mContext: Context?) { //        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        ActivityManager.getScreenManager().popAllActivity()
    }

    // 返回第几部
    fun BackByStep(
        mContext: Context?,
        num: Int
    ) { //        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        ActivityManager.getScreenManager().popActivity(num)
    }

    //    // 返回登陆
//    public static void BackToLogin(Context mContext) {
//        if (!mContext.getClass().equals(LoginActivity.class)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
//        ActivityManager.getScreenManager().popAllActivity();
//        ActivityJump.NormalJump(mContext, LoginActivity.class);
//        // ActivityManager.getScreenManager().pushActivity(activity);
//    }
// public static void NormalJump(Fragment fragment, Class<?> cls) {
// //Log.d("错误", String.valueOf(mContext.getClass()));
//
// Intent intent = new
//
// Intent intent = new Intent(fragment, cls);
// mContext.startActivity(intent);
// }
    fun AdvertisementJump(mContext: Activity, cls: Class<*>?) {
        Log.d("错误", mContext.javaClass.toString())
        //        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        val intent = Intent(mContext, cls)
        mContext.startActivity(intent)
        mContext.finish()
        // ((Activity) mContext).overridePendingTransition(R.anim.activity_in,
// R.anim.activity_out);
    }

    companion object {
        //    public void settClass(Class<T> cls) {
//        tClass = cls;
//    }
        @Volatile
        var instance: ActivityJ<*>? = null
            get() {
                if (field == null) {
                    synchronized(ActivityJump::class.java) {
                        if (field == null) {
                            field = ActivityJ<BaseActivity?>()
                        }
                    }
                }
                return field
            }
            private set

        // 结束
        fun finish(activity: Activity?) { // Log.d("错误", String.valueOf(mContext.getClass()));
            ActivityManager.getScreenManager()
                .popActivity(activity)
            // .pushActivity((Activity) mContext);
// Intent intent = new Intent(mContext, cls);
//  mContext.startActivity(intent);
// AlertDialogUtil.closeDialog();
// Intent intent = new Intent(mContext, cls);
//  mContext.startActivity(intent);
// AlertDialogUtil.closeDialog();
// ((Activity) mContext).overridePendingTransition(R.anim.activity_in,
// R.anim.activity_out);
        }

        // 单一返回
        fun Back(mContext: Context) {
            if (mContext as Activity == ActivityManager.getScreenManager()
                    .currentActivity()
            ) {
                ActivityManager.getScreenManager()
                    .popActivity(mContext)
            } else {
                mContext.finish()
            }
        }
    }
}
