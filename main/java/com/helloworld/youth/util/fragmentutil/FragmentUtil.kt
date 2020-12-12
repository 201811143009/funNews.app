package com.helloworld.youth.util.fragmentutil

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.helloworld.youth.util.testutil.MLogUtil
import java.util.*

class FragmentUtil  // private Class<T> tClass;
private constructor() {
    // private static Stack<Fragment> stack = new Stack<Fragment>();
    fun addFragment(
        fragmentManager: FragmentManager,
        current: Fragment?, next: Fragment, nextTag: String?, layoutId: Int
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
//        fragmentTransaction.setTransition(android.R.animator.fade_in);
        if (current != null) {
            fragmentTransaction!!.hide(current)
        }
        if (fragmentManager.findFragmentByTag(nextTag) != null) {
           // MLogUtil.dLogPrint("已经创建了")
            for (fragment in fragmentManager.fragments) {
                if (fragment.javaClass == next.javaClass) {
                    fragmentTransaction!!.show(fragment)
                    continue
                    // fragmentTransaction.commitAllowingStateLoss();// 提交
                }
                //隐藏其他fragment
                fragmentTransaction!!.hide(fragment)
            }
        } else {
            for (fragment in fragmentManager.fragments) {
                //隐藏其他fragment
                fragmentTransaction!!.hide(fragment!!)
            }
            fragmentTransaction!!.add(layoutId, next, nextTag)
            fragmentTransaction!!.addToBackStack(nextTag)
        }
        fragmentTransaction!!.commitAllowingStateLoss() // 提交
        //  listTag.add(nextTag);
        // stack.add(current);
        // Log.d("添加回退表", String.valueOf(listTag.size()));
    }

    /**
     * 大功能 模块 使用 替换 使 只在 大功能中
     */
    fun replaceFragment(
        fragmentManager: FragmentManager,
        current: Fragment?, next: Fragment, nextTag: String?, layoutId: Int
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
//        fragmentTransaction.setTransition(android.R.animator.fade_in);
        if (current != null) {
            fragmentTransaction!!.hide(current)
        }
        if (fragmentManager.findFragmentByTag(nextTag) != null) {
            MLogUtil.dLogPrint("已经创建了")
            for (fragment in fragmentManager.fragments) {
                if (fragment.javaClass == next.javaClass) {
                    fragmentTransaction!!.show(fragment)
                    continue
                    // fragmentTransaction.commitAllowingStateLoss();// 提交
                }
                //隐藏其他fragment
                fragmentTransaction!!.hide(fragment)
            }
        } else {
            for (fragment in fragmentManager.fragments) {
                //隐藏其他fragment
                fragmentTransaction!!.hide(fragment!!)
            }
            fragmentTransaction!!.replace(layoutId, next, nextTag)
            fragmentTransaction!!.addToBackStack(nextTag)
        }
        fragmentTransaction!!.commitAllowingStateLoss() // 提交
        //  listTag.add(nextTag);
        // stack.add(current);
        // Log.d("添加回退表", String.valueOf(listTag.size()));
        // Log.d("添加回退表", String.valueOf(listTag.size()));
        // Log.d("添加回退栈", String.valueOf(stack.size()));
    }

    /**
     * 大功能 模块 使用 替换 使 只在 大功能中
     */
    fun replaceFragment2(
        fragmentManager: FragmentManager,
        current: Fragment?, next: Fragment?, tag: String, layoutId: Int
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
        // fragmentTransaction.setCustomAnimations(R.anim.fragment_in,
        // R.anim.fragment_out);
        val max = listTag.size
        for (i in 0 until max) {
            if (fragmentManager.findFragmentByTag(listTag[i]) != null) {
                MLogUtil.dLogPrint("不是同一个")
                fragmentManager.popBackStack()
                fragmentTransaction!!.remove(
                    fragmentManager
                        .findFragmentByTag(listTag[i])!!
                )
            }
        }
        for (i in listTagSub.indices) {
            if (fragmentManager.findFragmentByTag(listTagSub[i]) != null) {
                MLogUtil.dLogPrint("不是同一个")
                fragmentManager.popBackStack()
                fragmentTransaction!!.remove(
                    fragmentManager
                        .findFragmentByTag(listTagSub[i])!!
                )
            }
        }
        if (current != null) {
            fragmentTransaction!!.hide(current)
        }
        listTag.clear()
        listTagSub.clear()
        // stack.add(next);
        fragmentTransaction!!.replace(layoutId, next!!, tag)
        fragmentTransaction!!.commitAllowingStateLoss() // 提交
        listTag.add(tag)
        Log.d("添加回退表", listTag.size.toString())
        // Log.d("添加回退栈", String.valueOf(stack.size()));
    }

    fun addFragmentNoBlack(
        fragmentManager: FragmentManager,
        current: Fragment?, next: Fragment, tag: String, layoutId: Int
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
//        fragmentTransaction.setTransition(android.R.animator.fade_in);
        if (current != null) {
            fragmentTransaction!!.hide(current)
        } else {
            val max = listTag.size
            MLogUtil.dLogPrint("最大值", max)
            for (i in 0 until max) {
                MLogUtil.dLogPrint("list", listTag[i])
                MLogUtil.dLogPrint("便利", i)
                // 存在fragment
                val fragment = fragmentManager.findFragmentByTag(listTag[i])
                if (fragment != null) {
                    if (next.isAdded) {
                        MLogUtil.dLogPrint("添加过")
                        fragmentTransaction!!.hide(fragment)
                        MLogUtil.dLogPrint("隐藏" + fragment.javaClass.name)
                        fragmentTransaction!!.show(next)
                        // 没有添加
                    } else {
                        MLogUtil.dLogPrint("没添加过")
                        fragmentTransaction!!.hide(fragment)
                        MLogUtil.dLogPrint("隐藏" + fragment.javaClass.name)
                        if (!listTag.contains(tag)) {
                            MLogUtil.dLogPrint("tttt加过")
                            fragmentTransaction!!.add(layoutId, next, tag)
                            listTag.add(tag)
                        }

                        // fragmentTransaction.show(next);
                        Log.d("添加回退表没隐藏", listTag.size.toString())
                    }
                }
            }
        }
        fragmentTransaction!!.commitAllowingStateLoss() // 提交
        // stack.add(current);
        Log.d("添加回退表", listTag.size.toString())
        // Log.d("添加回退栈", String.valueOf(stack.size()));
    }

    fun addFragmentNoBlack2(
        fragmentManager: FragmentManager,
        current: Fragment?, next: Fragment, tag: String, layoutId: Int
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
//        fragmentTransaction.setTransition(android.R.animator.fade_in);
        if (current != null) {
            fragmentTransaction!!.hide(current)
        } else {
            val max = listTag.size
            MLogUtil.dLogPrint("最大值", max)
            for (i in 0 until max) {
                MLogUtil.dLogPrint("list", listTag[i])
                MLogUtil.dLogPrint("便利", i)
                // 存在fragment
                val fragment = fragmentManager.findFragmentByTag(listTag[i])
                if (fragment != null) {
                    if (next.isAdded) {
                        MLogUtil.dLogPrint("添加过")
                        fragmentTransaction!!.hide(fragment)
                        MLogUtil.dLogPrint("隐藏" + fragment.javaClass.name)
                        fragmentTransaction!!.show(next)
                        // 没有添加
                    } else {
                        MLogUtil.dLogPrint("没添加过")
                        fragmentTransaction!!.hide(fragment)
                        MLogUtil.dLogPrint("隐藏" + fragment.javaClass.name)
                        if (!listTag.contains(tag)) {
                            MLogUtil.dLogPrint("tttt加过")
                            fragmentTransaction!!.add(layoutId, next, tag)
                            listTag.add(tag)
                        }

                        // fragmentTransaction.show(next);
                        Log.d("添加回退表没隐藏", listTag.size.toString())
                    }
                }
            }
        }
        fragmentTransaction!!.commitAllowingStateLoss() // 提交
        // stack.add(current);
        Log.d("添加回退表", listTag.size.toString())
        // Log.d("添加回退栈", String.valueOf(stack.size()));
    }

    fun addFragmentCarte(
        fragmentManager: FragmentManager,
        current: Fragment?, next: Fragment, tag: String, layoutId: Int
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
//        fragmentTransaction.setTransition(android.R.animator.fade_in);
        if (current != null) {
            fragmentTransaction!!.hide(current)
        } else {
            val max = listTag.size
            MLogUtil.dLogPrint("最大值", max)
            for (i in 0 until max) {
                MLogUtil.dLogPrint("list", listTag[i])
                MLogUtil.dLogPrint("便利", i)
                // 存在fragment
                val fragment = fragmentManager.findFragmentByTag(listTag[i])
                if (fragment != null) {
                    if (next.isAdded) {
                        MLogUtil.dLogPrint("添加过")
                        fragmentTransaction!!.hide(fragment)
                        MLogUtil.dLogPrint("隐藏" + fragment.javaClass.name)
                        fragmentTransaction!!.show(next)
                        // 没有添加
                    } else {
                        MLogUtil.dLogPrint("没添加过")
                        fragmentTransaction!!.hide(fragment)
                        MLogUtil.dLogPrint("隐藏" + fragment.javaClass.name)
                        if (!listTag.contains(tag)) {
                            MLogUtil.dLogPrint("tttt加过")
                            fragmentTransaction!!.add(layoutId, next, tag)
                            listTag.add(tag)
                        }

                        // fragmentTransaction.show(next);
                        Log.d("添加回退表没隐藏", listTag.size.toString())
                    }
                }
            }
        }
        fragmentTransaction!!.commitAllowingStateLoss() // 提交
        // stack.add(current);
        Log.d("添加回退表", listTag.size.toString())
        // Log.d("添加回退栈", String.valueOf(stack.size()));
    }

    fun addFragmentNoBlack3(
        fragmentManager: FragmentManager,
        current: Fragment?, next: Fragment?, tag: String, layoutId: Int
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
//        fragmentTransaction.setTransition(android.R.animator.fade_in);
        if (current != null) {
            fragmentTransaction!!.hide(current)
        } else {
            val max = listTag.size
            MLogUtil.dLogPrint("最大值", max)
            for (i in 0 until max) {
                MLogUtil.dLogPrint("list", listTag[i])
                MLogUtil.dLogPrint("便利", i)
                // 存在fragment
                val fragment = fragmentManager.findFragmentByTag(listTag[i])
                if (fragment != null) {
                    MLogUtil.dLogPrint("没添加过")
                    fragmentTransaction!!.hide(fragment)
                    MLogUtil.dLogPrint("隐藏" + fragment.javaClass.name)
                    if (!listTag.contains(tag)) {
                        MLogUtil.dLogPrint("tttt加过")
                        fragmentTransaction!!.add(layoutId, next!!, tag)
                        listTag.add(tag)
                    }

                    // fragmentTransaction.show(next);
                    Log.d("添加回退表没隐藏", listTag.size.toString())
                }
            }
        }
        fragmentTransaction!!.commitAllowingStateLoss() // 提交
        // stack.add(current);
        Log.d("添加回退表", listTag.size.toString())
        // Log.d("添加回退栈", String.valueOf(stack.size()));
    }

    fun replaceFragmentSub(
        fragmentManager: FragmentManager,
        current: Fragment?, next: Fragment?, tag: String, layoutId: Int
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
//         fragmentTransaction.setCustomAnimations(R.anim.fragment_in,
        // R.anim.fragment_out);
        val max = listTagSub.size
        for (i in 0 until max) {
            if (fragmentManager.findFragmentByTag(listTagSub[i]) != null) {
                MLogUtil.dLogPrint("不是同一个")
                fragmentManager.popBackStack()
                fragmentTransaction!!.remove(
                    fragmentManager
                        .findFragmentByTag(listTagSub[i])!!
                )
            }
        }
        if (current != null) {
            fragmentTransaction!!.hide(current)
        }
        listTagSub.clear()
        // stack.add(next);
        fragmentTransaction!!.replace(layoutId, next!!, tag)
        fragmentTransaction!!.commitAllowingStateLoss() // 提交
        listTagSub.add(tag)
        Log.d("添加回退表", listTagSub.size.toString())
        // Log.d("添加回退栈", String.valueOf(stack.size()));
    }

    fun removeFragment(
        fragmentManager: FragmentManager,
        tag: String?
    ) {
        currfragmentManager = fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        //        fragmentTransaction
//                .setTransition(TRANSIT_FRAGMENT_FADE);
        if (fragmentManager.findFragmentByTag("CarteFragment") != null) {
            fragmentTransaction!!.remove(
                fragmentManager
                    .findFragmentByTag("CarteFragment")!!
            )
            fragmentTransaction!!.commitAllowingStateLoss() // 提交
        }
        if (listTag.contains("CarteFragment")) {
            listTag.remove("CarteFragment")
        }
    }

    // public static void jumpFragment(FragmentManager fragmentManager,
    // Fragment next, String tag, int layoutId) {
    // fragmentTransaction = fragmentManager.beginTransaction();
    // for (Fragment fragment : fragmentManager.getFragments()) {
    // if (fragment != MainFragment.getInstance()) {
    // fragmentTransaction.remove(fragment);
    // fragmentManager.popBackStack();
    // } else {
    // fragmentTransaction.hide(fragment);
    // }
    // }
    //
    // stack.clear();
    // stack.add(next);
    // fragmentTransaction.replace(layoutId, next, tag);
    // fragmentTransaction.commit();// 提交
    // Log.d("添加回退表", String.valueOf(listTag.size()));
    // Log.d("添加回退栈", String.valueOf(stack.size()));
    // }
    val fragmentsTag: List<*>
        get() = listTag

    fun getFragment(fragmentTag: String?): Fragment? {
        return currfragmentManager!!.findFragmentByTag(fragmentTag)
    } // public static List getFragments() {

    // return stack;
    // }
    companion object {
        //    public void settClass(Class<T> cls) {
        //        tClass = cls;
        //    }
        @Volatile
        var instance: FragmentUtil? = null
            get() {
                if (field == null) {
                    synchronized(FragmentUtil::class.java) {
                        if (field == null) {
                            field = FragmentUtil()
                        }
                    }
                }
                return field
            }
            private set

        // 存放 Tag 的 集合 用于获取 Fragment 回退状态
        private val listTag: MutableList<String> = ArrayList()
        private var fragmentTransaction: FragmentTransaction? = null
        private val listTagSub: MutableList<String> = ArrayList()
        private var currfragmentManager: FragmentManager? = null
    }
}