package com.helloworld.youth.util.testutil

import android.content.Context
import android.content.pm.ApplicationInfo
import android.util.Log

class MLogUtil {

    fun init(context: Context) {
        MLogUtil.context = context
        isApkInDebug
    }

    companion object {
        private var context: Context? = null
        private const val debug = false

        //判断app但前是否在debug状态
        private val isApkInDebug: Boolean
            private get() = try {
                val info = context!!.applicationInfo
                info.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
            } catch (e: Exception) {
                false
            }

        //private static boolean debug = context.getApplicationInfo();
        private var TAG = "MLogUtil"
        fun setTAG(tag: String) {
            TAG = tag
        }

        fun dLogPrint(msg: Int) {
            if (debug) {
                Log.d(TAG, msg.toString())
            }
        }

        fun dLogPrint(msg: Boolean) {
            if (debug) {
                Log.d(TAG, msg.toString())
            }
        }

        fun dLogPrint(msg: Byte) {
            if (debug) {
                Log.d(TAG, msg.toString())
            }
        }

        fun dLogPrint(msg: Short) {
            if (debug) {
                Log.d(TAG, msg.toString())
            }
        }

        fun dLogPrint(msg: Double) {
            if (debug) {
                Log.d(TAG, msg.toString())
            }
        }

        fun dLogPrint(msg: Float) {
            if (debug) {
                Log.d(TAG, msg.toString())
            }
        }

        fun dLogPrint(msg: Char) {
            if (debug) {
                Log.d(TAG, msg.toString())
            }
        }

        fun dLogPrint(msg: String?) {
            if (debug) {
                Log.d(TAG, msg)
            }
        }



        fun dLogPrint(tag: String?, msg: Any) {
            if (debug) {
                Log.d(tag, msg.toString())
            }
        }

        fun dLogPrint(tag: String?, msg: Int) {
            if (debug) {
                Log.d(tag, msg.toString())
            }
        }

        fun dLogPrint(tag: String?, msg: Boolean) {
            if (debug) {
                Log.d(tag, msg.toString())
            }
        }

        fun dLogPrint(tag: String?, msg: Byte) {
            if (debug) {
                Log.d(tag, msg.toString())
            }
        }

        fun dLogPrint(tag: String?, msg: Short) {
            if (debug) {
                Log.d(tag, msg.toString())
            }
        }

        fun dLogPrint(tag: String?, msg: Char) {
            if (debug) {
                Log.d(tag, msg.toString())
            }
        }

        fun dLogPrint(tag: String?, msg: String) {
            if (debug) {
                Log.d(tag, msg)
            }
        }

        fun dLogPrint(tag: String?, msg: Double) {
            if (debug) {
                Log.d(tag, msg.toString())
            }
        }

        fun dLogPrint(tag: String?, msg: Float) {
            if (debug) {
                Log.d(tag, msg.toString())
            }
        }

        // //////////////
        fun eLogPrint(msg: Int) {
            if (debug) {
                Log.e(TAG, msg.toString())
            }
        }

        fun eLogPrint(msg: Boolean) {
            if (debug) {
                Log.e(TAG, msg.toString())
            }
        }

        fun eLogPrint(msg: Byte) {
            if (debug) {
                Log.e(TAG, msg.toString())
            }
        }

        fun eLogPrint(msg: Short) {
            if (debug) {
                Log.e(TAG, msg.toString())
            }
        }

        fun eLogPrint(msg: Double) {
            if (debug) {
                Log.e(TAG, msg.toString())
            }
        }

        fun eLogPrint(msg: Float) {
            if (debug) {
                Log.e(TAG, msg.toString())
            }
        }

        fun eLogPrint(msg: String?) {
            if (debug) {
                Log.e(TAG, msg)
            }
        }

        fun eLogPrint(msg: Any) {
            if (debug) {
                Log.e(TAG, msg.toString())
            }
        }

        fun eLogPrint(tag: String?, msg: Any) {
            if (debug) {
                Log.e(tag, msg.toString())
            }
        }

        fun eLogPrint(tag: String?, msg: Int) {
            if (debug) {
                Log.e(tag, msg.toString())
            }
        }

        fun eLogPrint(tag: String?, msg: Boolean) {
            if (debug) {
                Log.e(tag, msg.toString())
            }
        }

        fun eLogPrint(tag: String?, msg: Byte) {
            if (debug) {
                Log.e(tag, msg.toString())
            }
        }

        fun eLogPrint(tag: String?, msg: Short) {
            if (debug) {
                Log.e(tag, msg.toString())
            }
        }

        fun eLogPrint(tag: String?, msg: Char) {
            if (debug) {
                Log.e(tag, msg.toString())
            }
        }

        fun eLogPrint(tag: String?, msg: String) {
            if (debug) {
                Log.e(tag, msg)
            }
        }

        fun eLogPrint(tag: String?, msg: Double) {
            if (debug) {
                Log.e(tag, msg.toString())
            }
        }

        fun eLogPrint(tag: String?, msg: Float) {
            if (debug) {
                Log.e(tag, msg.toString())
            }
        }

        // ////////////////////
        fun vLogPrint(msg: Int) {
            if (debug) {
                Log.v(TAG, msg.toString())
            }
        }

        fun vLogPrint(msg: Boolean) {
            if (debug) {
                Log.v(TAG, msg.toString())
            }
        }

        fun vLogPrint(msg: Byte) {
            if (debug) {
                Log.v(TAG, msg.toString())
            }
        }

        fun vLogPrint(msg: Short) {
            if (debug) {
                Log.v(TAG, msg.toString())
            }
        }

        fun vLogPrint(msg: Double) {
            if (debug) {
                Log.v(TAG, msg.toString())
            }
        }

        fun vLogPrint(msg: Float) {
            if (debug) {
                Log.v(TAG, msg.toString())
            }
        }

        fun vLogPrint(msg: String?) {
            if (debug) {
                Log.v(TAG, msg)
            }
        }

        fun vLogPrint(msg: Any) {
            if (debug) {
                Log.v(TAG, msg.toString())
            }
        }

        fun vLogPrint(tag: String?, msg: Int) {
            if (debug) {
                Log.v(tag, msg.toString())
            }
        }

        fun vLogPrint(tag: String?, msg: Boolean) {
            if (debug) {
                Log.v(tag, msg.toString())
            }
        }

        fun vLogPrint(tag: String?, msg: Byte) {
            if (debug) {
                Log.v(tag, msg.toString())
            }
        }

        fun vLogPrint(tag: String?, msg: Short) {
            if (debug) {
                Log.v(tag, msg.toString())
            }
        }

        fun vLogPrint(tag: String?, msg: Char) {
            if (debug) {
                Log.v(tag, msg.toString())
            }
        }

        fun vLogPrint(tag: String?, msg: String) {
            if (debug) {
                Log.v(tag, msg)
            }
        }

        fun vLogPrint(tag: String?, msg: Double) {
            if (debug) {
                Log.v(tag, msg.toString())
            }
        }

        fun vLogPrint(tag: String?, msg: Float) {
            if (debug) {
                Log.v(tag, msg.toString())
            }
        }

        // /////////////////
        fun iLogPrint(msg: Int) {
            if (debug) {
                Log.i(TAG, msg.toString())
            }
        }

        fun iLogPrint(msg: Boolean) {
            if (debug) {
                Log.i(TAG, msg.toString())
            }
        }

        fun iLogPrint(msg: Byte) {
            if (debug) {
                Log.i(TAG, msg.toString())
            }
        }

        fun iLogPrint(msg: Short) {
            if (debug) {
                Log.i(TAG, msg.toString())
            }
        }

        fun iLogPrint(msg: Double) {
            if (debug) {
                Log.i(TAG, msg.toString())
            }
        }

        fun iLogPrint(msg: Float) {
            if (debug) {
                Log.i(TAG, msg.toString())
            }
        }

        fun iLogPrint(msg: String?) {
            if (debug) {
                Log.i(TAG, msg)
            }
        }

        fun iLogPrint(msg: Any) {
            if (debug) {
                Log.i(TAG, msg.toString())
            }
        }

        fun iLogPrint(tag: String?, msg: Int) {
            if (debug) {
                Log.i(tag, msg.toString())
            }
        }

        fun iLogPrint(tag: String?, msg: Boolean) {
            if (debug) {
                Log.i(tag, msg.toString())
            }
        }

        fun iLogPrint(tag: String?, msg: Byte) {
            if (debug) {
                Log.i(tag, msg.toString())
            }
        }

        fun iLogPrint(tag: String?, msg: Short) {
            if (debug) {
                Log.i(tag, msg.toString())
            }
        }

        fun iLogPrint(tag: String?, msg: Char) {
            if (debug) {
                Log.i(tag, msg.toString())
            }
        }

        fun iLogPrint(tag: String?, msg: String) {
            if (debug) {
                Log.i(tag, msg)
            }
        }

        fun iLogPrint(tag: String?, msg: Double) {
            if (debug) {
                Log.i(tag, msg.toString())
            }
        }

        fun iLogPrint(tag: String?, msg: Float) {
            if (debug) {
                Log.i(tag, msg.toString())
            }
        }

        // //////////////
        fun wLogPrint(msg: Int) {
            if (debug) {
                Log.w(TAG, msg.toString())
            }
        }

        fun wLogPrint(msg: Boolean) {
            if (debug) {
                Log.w(TAG, msg.toString())
            }
        }

        fun wLogPrint(msg: Byte) {
            if (debug) {
                Log.w(TAG, msg.toString())
            }
        }

        fun wLogPrint(msg: Short) {
            if (debug) {
                Log.w(TAG, msg.toString())
            }
        }

        fun wLogPrint(msg: Double) {
            if (debug) {
                Log.w(TAG, msg.toString())
            }
        }

        fun wLogPrint(msg: Float) {
            if (debug) {
                Log.w(TAG, msg.toString())
            }
        }

        fun wLogPrint(msg: String?) {
            if (debug) {
                Log.w(TAG, msg)
            }
        }

        fun wLogPrint(msg: Any) {
            if (debug) {
                Log.w(TAG, msg.toString())
            }
        }

        fun wLogPrint(tag: String?, msg: Int) {
            if (debug) {
                Log.w(tag, msg.toString())
            }
        }

        fun wLogPrint(tag: String?, msg: Boolean) {
            if (debug) {
                Log.w(tag, msg.toString())
            }
        }

        fun wLogPrint(tag: String?, msg: Byte) {
            if (debug) {
                Log.w(tag, msg.toString())
            }
        }

        fun wLogPrint(tag: String?, msg: Short) {
            if (debug) {
                Log.w(tag, msg.toString())
            }
        }

        fun wLogPrint(tag: String?, msg: Char) {
            if (debug) {
                Log.w(tag, msg.toString())
            }
        }

        fun wLogPrint(tag: String?, msg: String) {
            if (debug) {
                Log.w(tag, msg)
            }
        }

        fun wLogPrint(tag: String?, msg: Double) {
            if (debug) {
                Log.w(tag, msg.toString())
            }
        }

        fun wLogPrint(tag: String?, msg: Float) {
            if (debug) {
                Log.w(tag, msg.toString())
            }
        }

        // ////////////////////////////
        fun wtfLogPrint(msg: Int) {
            if (debug) {
                Log.wtf(TAG, msg.toString())
            }
        }

        fun wtfLogPrint(msg: Boolean) {
            if (debug) {
                Log.wtf(TAG, msg.toString())
            }
        }

        fun wtfLogPrint(msg: Byte) {
            if (debug) {
                Log.wtf(TAG, msg.toString())
            }
        }

        fun wtfLogPrint(msg: Short) {
            if (debug) {
                Log.wtf(TAG, msg.toString())
            }
        }

        fun wtfLogPrint(msg: Double) {
            if (debug) {
                Log.wtf(TAG, msg.toString())
            }
        }

        fun wtfLogPrint(msg: Float) {
            if (debug) {
                Log.w(TAG, msg.toString())
            }
        }

        fun wtfLogPrint(msg: String?) {
            if (debug) {
                Log.wtf(TAG, msg)
            }
        }

        fun wtfLogPrint(msg: Any) {
            if (debug) {
                Log.wtf(TAG, msg.toString())
            }
        }

        fun wtfLogPrint(tag: String?, msg: Int) {
            if (debug) {
                Log.wtf(tag, msg.toString())
            }
        }

        fun wtfLogPrint(tag: String?, msg: Boolean) {
            if (debug) {
                Log.wtf(tag, msg.toString())
            }
        }

        fun wtfLogPrint(tag: String?, msg: Byte) {
            if (debug) {
                Log.wtf(tag, msg.toString())
            }
        }

        fun wtfLogPrint(tag: String?, msg: Short) {
            if (debug) {
                Log.wtf(tag, msg.toString())
            }
        }

        fun wtfLogPrint(tag: String?, msg: Char) {
            if (debug) {
                Log.wtf(tag, msg.toString())
            }
        }

        fun wtfLogPrint(tag: String?, msg: String) {
            if (debug) {
                Log.wtf(tag, msg)
            }
        }

        fun wtfLogPrint(tag: String?, msg: Double) {
            if (debug) {
                Log.wtf(tag, msg.toString())
            }
        }

        fun wtfLogPrint(tag: String?, msg: Float) {
            if (debug) {
                Log.wtf(tag, msg.toString())
            }
        }
    }
}