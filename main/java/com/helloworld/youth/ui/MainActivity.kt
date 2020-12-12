package com.helloworld.youth.ui

import android.os.Bundle
import android.widget.RadioGroup
import com.helloworld.youth.R
import com.helloworld.youth.ui.BottomBar.BottomBarsetListener
import com.helloworld.youth.util.fragmentutil.FragmentUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bottombar.bottomBarsetListener = object: BottomBarsetListener{
            override fun onCheckedChanged(radioGroup: RadioGroup?, id: Int) {
                when (id){
                    R.id.bottombar_button1 -> FragmentUtil.instance?.addFragment(
                        supportFragmentManager,
                        null,
                        HomeFragment.newInstance("", ""),
                        "HomeFragment",
                        R.id.fragment_root
                    )
                    R.id.bottombar_button2 -> FragmentUtil.instance?.addFragment(
                        supportFragmentManager,
                        null,
                        HomeFragment.newInstance("", ""),
                        "HomeFragment",
                        R.id.fragment_root
                    )
                    R.id.bottombar_button3 -> FragmentUtil.instance?.addFragment(
                        supportFragmentManager,
                        null,
                        HomeFragment.newInstance("", ""),
                        "HomeFragment",
                        R.id.fragment_root
                    )
                    R.id.bottombar_button4 -> FragmentUtil.instance?.addFragment(
                        supportFragmentManager,
                        null,
                        MyFragment.newInstance("", ""),
                        "HomeFragment",
                        R.id.fragment_root
                    )

                }
            }
        }




    }
}