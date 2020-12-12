package com.helloworld.youth.util.activityutil;

import android.app.Activity;

import java.util.Stack;

public class ActivityManager {
	// 栈
	private static Stack<Activity> activityStack = new Stack<Activity>();

	private static ActivityManager instance;

	private ActivityManager() {
	}

	// 管理器
	public static ActivityManager getScreenManager() {
		if (instance == null) {
			instance = new ActivityManager();
		}
		return instance;
	}

	// 栈顶弹出
	public void popActivity() {
		Activity activity = activityStack.lastElement();
		if (activity != null) {
			activity.finish();
			activity = null;
		}
	}

	// 指定activity弹出
	public void popActivity(Activity activity) {
		if (activity != null) {
			activity.finish();
			activityStack.remove(activity);
			activity = null;
		}
	}

	// 弹出到指定activity
	public void popAssignActivity(Class clazz) {
		for (int a = activityStack.size() - 1; a >= 0; a--) {
			if (activityStack.get(a).getClass().equals(clazz)) {
				ActivityManager.getScreenManager().popActivity(
						activityStack.get(a));
				return;
			}

		}
	}

	// 返回栈顶activity
	public Activity currentActivity() {
		if (activityStack == null || activityStack.size() == 0) {
			return null;
		}
		Activity activity = activityStack.lastElement();

		return activity;
	}

	// 增加（压栈）
	public void pushActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}

		activityStack.add(activity);
	}

	// 保留一个指定activity
	public void popAllActivityExceptOne(Class<?> cls) {
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
			if (activity.getClass().equals(cls)) {
				break;
			}
			popActivity(activity);
		}
	}

	// 弹出所有activity
	public void popAllActivity() {
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
			popActivity(activity);
		}
	}

	// 弹出所有n个activity
	public void popActivity(int num) {
		for (int i = 0; i < num; i++) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
			popActivity(activity);
		}
	}

	public Stack<Activity> getActivityStack() {
		return activityStack;
	}

	public Activity getActivity(String activityName) {
		for (int i = 0; i < activityStack.size(); i++) {
			if (activityStack.get(i).getClass().getName().equals(activityName)) {
				return activityStack.get(i);
			}
		}
		return null;
	}
}
