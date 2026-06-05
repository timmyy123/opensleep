package com.urbandroid.sleep.gui.pref;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceManagerCompat {
    private static final String TAG = "PreferenceManagerCompat";

    public interface OnPreferenceTreeClickListener {
        boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference);
    }

    public static void dispatchActivityDestroy(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityDestroy", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, null);
        } catch (Exception e) {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityDestroy by reflection", e);
        }
    }

    public static void dispatchActivityResult(PreferenceManager preferenceManager, int i, int i2, Intent intent) {
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityResult", cls, cls, Intent.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, Integer.valueOf(i), Integer.valueOf(i2), intent);
        } catch (Exception e) {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityResult by reflection", e);
        }
    }

    public static void dispatchActivityStop(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityStop", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, null);
        } catch (Exception e) {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityStop by reflection", e);
        }
    }

    public static PreferenceScreen getPreferenceScreen(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("getPreferenceScreen", null);
            declaredMethod.setAccessible(true);
            return (PreferenceScreen) declaredMethod.invoke(preferenceManager, null);
        } catch (Exception e) {
            Log.w(TAG, "Couldn't call PreferenceManager.getPreferenceScreen by reflection", e);
            return null;
        }
    }

    public static PreferenceScreen inflateFromResource(PreferenceManager preferenceManager, Activity activity, int i, PreferenceScreen preferenceScreen) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("inflateFromResource", Context.class, Integer.TYPE, PreferenceScreen.class);
            declaredMethod.setAccessible(true);
            return (PreferenceScreen) declaredMethod.invoke(preferenceManager, activity, Integer.valueOf(i), preferenceScreen);
        } catch (Exception e) {
            Log.w(TAG, "Couldn't call PreferenceManager.inflateFromResource by reflection", e);
            return null;
        }
    }

    public static PreferenceManager newInstance(Activity activity, int i) {
        try {
            Constructor declaredConstructor = PreferenceManager.class.getDeclaredConstructor(Activity.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return (PreferenceManager) declaredConstructor.newInstance(activity, Integer.valueOf(i));
        } catch (Exception e) {
            Log.w(TAG, "Couldn't call constructor PreferenceManager by reflection", e);
            return null;
        }
    }

    public static void setFragment(PreferenceManager preferenceManager, PreferenceFragment preferenceFragment) {
    }

    public static void setOnPreferenceTreeClickListener(PreferenceManager preferenceManager, final OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        try {
            Field declaredField = PreferenceManager.class.getDeclaredField("mOnPreferenceTreeClickListener");
            declaredField.setAccessible(true);
            if (onPreferenceTreeClickListener != null) {
                declaredField.set(preferenceManager, Proxy.newProxyInstance(declaredField.getType().getClassLoader(), new Class[]{declaredField.getType()}, new InvocationHandler() { // from class: com.urbandroid.sleep.gui.pref.PreferenceManagerCompat.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) {
                        if (method.getName().equals("onPreferenceTreeClick")) {
                            return Boolean.valueOf(onPreferenceTreeClickListener.onPreferenceTreeClick((PreferenceScreen) objArr[0], (Preference) objArr[1]));
                        }
                        return null;
                    }
                }));
            } else {
                declaredField.set(preferenceManager, null);
            }
        } catch (Exception e) {
            Log.w(TAG, "Couldn't set PreferenceManager.mOnPreferenceTreeClickListener by reflection", e);
        }
    }

    public static boolean setPreferences(PreferenceManager preferenceManager, PreferenceScreen preferenceScreen) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("setPreferences", PreferenceScreen.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(preferenceManager, preferenceScreen)).booleanValue();
        } catch (Exception e) {
            Log.w(TAG, "Couldn't call PreferenceManager.setPreferences by reflection", e);
            return false;
        }
    }
}
