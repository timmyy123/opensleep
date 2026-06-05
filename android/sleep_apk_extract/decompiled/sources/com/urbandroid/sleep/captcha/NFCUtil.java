package com.urbandroid.sleep.captcha;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NFCUtil {
    public static boolean isNfcEnabled(Context context) {
        try {
            Class<?> cls = Class.forName("android.nfc.NfcAdapter");
            Object objInvoke = cls.getMethod("getDefaultAdapter", Context.class).invoke(cls, context);
            if (objInvoke == null) {
                return false;
            }
            return ((Boolean) cls.getMethod(IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, null).invoke(objInvoke, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
