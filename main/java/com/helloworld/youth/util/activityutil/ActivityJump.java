package com.helloworld.youth.util.activityutil;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class ActivityJump<T extends AppCompatActivity> {
    private static volatile ActivityJump instance = null;
   // private Class<T> tClass;

    private ActivityJump() {
    }

//    public void settClass(Class<T> cls) {
//        tClass = cls;
//    }

    public static ActivityJump getInstance() {

        if (instance == null) {
            synchronized (ActivityJump.class) {
                if (instance == null) {
                    instance = new ActivityJump();
                }
            }
        }
        return instance;
    }


    // 普通跳转
    public void NormalJump(Context mContext, Class<T> cls) {
        Log.d("错误", String.valueOf(mContext.getClass()));
//        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        Intent intent = new Intent(mContext, cls);
        mContext.startActivity(intent);
        //    ((AppCompatActivity) mContext).overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        // AlertDialogUtil.closeDialog();
        // ((Activity) mContext).overridePendingTransition(R.anim.activity_in,
        // R.anim.activity_out);

    }

    // 结束
    public static void finish(Activity activity) {
        // Log.d("错误", String.valueOf(mContext.getClass()));
        ActivityManager.getScreenManager().popActivity(activity);
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

    // 带参跳转
    public void BundleJump(Context mContext, Class<T> cls, Bundle bundle) {
//        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        ActivityManager.getScreenManager().pushActivity((Activity) mContext);
        Intent intent = new Intent(mContext, cls);
        //intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
        //  ((AppCompatActivity) mContext).overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        // ((Activity) mContext).overridePendingTransition(R.anim.activity_in,
        // R.anim.activity_out);
    }


    // 带返回值跳转跳转
    public void JumpForResult(Activity mActivity, Class<T> cls,
                              Bundle bundle, int requestCode) {
//        if (!mActivity.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager().pushActivity(mActivity);
//        }
        Intent intent = new Intent(mActivity, cls);
        intent.putExtras(bundle);

        mActivity.startActivityForResult(intent, requestCode);
        //   mActivity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        // mActivity.overridePendingTransition(R.anim.activity_in,
        // R.anim.activity_out);

    }

    public void JumpForResultNobundle(Activity mActivity, Class<T> cls,
                                      int requestCode) {
//        if (!mActivity.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager().pushActivity(mActivity);
//        }
        Intent intent = new Intent(mActivity, cls);

        mActivity.startActivityForResult(intent, requestCode);
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
    public void NormalJumpFromLogin(Context mContext, Class<T> cls) {
        Intent intent = new Intent(mContext, cls);
        mContext.startActivity(intent);
    }

    // 单一返回
    public static void Back(Context mContext) {
        if (((Activity) mContext).equals(ActivityManager.getScreenManager()
                .currentActivity())) {
            ActivityManager.getScreenManager().popActivity((Activity) mContext);
        } else {
            ((Activity) mContext).finish();
        }
    }

    // 返回到主页
    public void BackToHome(Context mContext) {
//        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        ActivityManager.getScreenManager().popAllActivity();
    }

    // 返回到固定Activity
    public void BackToStep(Context mContext, Activity mactivity) {
//        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        if (ActivityManager.getScreenManager().getActivityStack().contains(mactivity)) {
            for (Activity activity : ActivityManager.getScreenManager().getActivityStack()) {
                if (activity.getClass().equals(mactivity)) {
                    return;
                } else {
                    ActivityManager.getScreenManager().popActivity(activity);
                }
            }

        }
    }

    // 返回到主页
    public void BackToHome2(Context mContext) {
//        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        ActivityManager.getScreenManager().popAllActivity();
    }

    // 返回第几部
    public void BackByStep(Context mContext, int num) {
//        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        ActivityManager.getScreenManager().popActivity(num);
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
    public void AdvertisementJump(Activity mContext, Class<?> cls) {
        Log.d("错误", String.valueOf(mContext.getClass()));
//        if (!mContext.getClass().equals(tClass)) {
//            ActivityManager.getScreenManager()
//                    .pushActivity((Activity) mContext);
//        }
        Intent intent = new Intent(mContext, cls);
        mContext.startActivity(intent);
        mContext.finish();
        // ((Activity) mContext).overridePendingTransition(R.anim.activity_in,
        // R.anim.activity_out);

    }
}
