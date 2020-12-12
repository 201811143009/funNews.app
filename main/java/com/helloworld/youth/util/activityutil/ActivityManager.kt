package com.helloworld.util.activityutil

import android.app.Activity
import java.util.*

class ActivityManagerKT private constructor() {
    // 栈顶弹出
    fun popActivity() {
        var activity = activityStack.lastElement()
        if (activity != null) {
            activity.finish()
        }
    }

    // 指定activity弹出
    fun popActivity(activity: Activity?) {
        if (activity != null) {
            activity.finish()
            activityStack.remove(activity)
        }
    }

    // 弹出到指定activity
    fun popAssignActivity(clazz: Class<*>) {
        for (a in activityStack.indices.reversed()) {
            if (activityStack[a].javaClass == clazz) {
                screenManager!!.popActivity(
                    activityStack[a]
                )
                return
            }
        }
    }

    // 返回栈顶activity
    fun currentActivity(): Activity? {
        return if ( activityStack.size == 0) {
            null
        } else activityStack.lastElement()
    }

    // 增加（压栈）
    fun pushActivity(activity: Activity) {

        activityStack.add(activity)
    }

    // 保留一个指定activity
    fun popAllActivityExceptOne(cls: Class<*>) {
        while (true) {
            val activity = currentActivity() ?: break
            if (activity.javaClass == cls) {
                break
            }
            popActivity(activity)
        }
    }

    // 弹出所有activity
    fun popAllActivity() {
        while (true) {
            val activity = currentActivity() ?: break
            popActivity(activity)
        }
    }

    // 弹出所有n个activity
    fun popActivity(num: Int) {
        for (i in 0 until num) {
            val activity = currentActivity() ?: break
            popActivity(activity)
        }
    }


    fun getActivity(activityName: String): Activity? {
        for (i in activityStack.indices) {
            if (activityStack[i].javaClass.name == activityName) {
                return activityStack[i]
            }
        }
        return null
    }

    companion object {
        // 栈
        private var activityStack: Stack<Activity> = Stack()
        private var instance: ActivityManagerKT? = null
        // 管理器
        val screenManager: ActivityManagerKT?
            get() {
                if (instance == null) {
                    instance = ActivityManagerKT()
                }
                return instance
            }
        fun get(): ActivityManagerKT{
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
        fun getStack(): Stack<Activity>{
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return activityStack
        }

    }
}