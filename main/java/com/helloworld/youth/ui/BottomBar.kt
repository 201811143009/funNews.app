package com.helloworld.youth.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.helloworld.youth.R

/**
 * Created by long on 2018/3/17.
 */
class BottomBar : FrameLayout {
    private var fragmentManager: FragmentManager? = null
    private var activity: AppCompatActivity? = null
    private var radioGroup: RadioGroup? = null
    var bottomBarsetListener: BottomBarsetListener? = null

    interface BottomBarsetListener {
        fun onCheckedChanged(radioGroup: RadioGroup?, id: Int)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        // TODO Auto-generated constructor stub
        bottomBar = this@BottomBar
        activity = context as AppCompatActivity
        fragmentManager = activity!!.supportFragmentManager
        LayoutInflater.from(context).inflate(
            R.layout.view_bottombar, this,
            true
        )
        radioGroup = findViewById(R.id.RadioGroup)

        // 默认选中 首页
        initRadioGroup()
    }

    private fun initRadioGroup() {
        radioGroup!!.setOnCheckedChangeListener { radioGroup, i ->
            if (bottomBarsetListener != null) {
                bottomBarsetListener!!.onCheckedChanged(radioGroup, i)
            }
        }
    }

    constructor(context: Context) : super(context) {
        //activity = (MainActivity) context;
        bottomBar = this@BottomBar
        // TODO Auto-generated constructor stub
    }

    companion object {
        var bottomBar: BottomBar? = null
    }
}