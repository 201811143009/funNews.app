package com.helloworld.youth.ui

import android.os.Bundle
import android.os.CountDownTimer
import com.helloworld.youth.BaseApplication
import com.helloworld.youth.R
import com.helloworld.youth.util.activityutil.ActivityJump
import kotlinx.android.synthetic.main.activity_index.*

class IndexActivity : BaseActivity() {

    private lateinit var countDownTimer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        count_down.setOnClickListener {
            ActivityJump.getInstance().NormalJump(context, MainActivity::class.java);
            this@IndexActivity.finish()
        }
        countDownTimer = object : CountDownTimer(BaseApplication.indexTime, 1000L) {
            override fun onFinish() {
                    ActivityJump.getInstance().NormalJump(context, MainActivity::class.java);
                    this@IndexActivity.finish()
            }

            override fun onTick(millisUntilFinished: Long) {
                count_down.setText("跳过 ${millisUntilFinished / 1000+1} s")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        countDownTimer.start()
    }
}