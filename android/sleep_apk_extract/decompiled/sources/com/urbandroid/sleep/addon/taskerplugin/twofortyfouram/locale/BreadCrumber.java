package com.urbandroid.sleep.addon.taskerplugin.twofortyfouram.locale;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.urbandroid.sleep.R;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BreadCrumber {
    public static CharSequence generateBreadcrumb(Context context, Intent intent, String str) {
        if (context == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("context cannot be null");
            return null;
        }
        try {
            if (str == null) {
                Log.w("LocaleApiLibrary", "currentCrumb cannot be null");
                return "";
            }
            if (intent == null) {
                Log.w("LocaleApiLibrary", "intent cannot be null");
                return str;
            }
            String stringExtra = intent.getStringExtra("com.twofortyfouram.locale.intent.extra.BREADCRUMB");
            return stringExtra != null ? context.getString(R.string.twofortyfouram_locale_breadcrumb_format, stringExtra, context.getString(R.string.twofortyfouram_locale_breadcrumb_separator), str) : str;
        } catch (Exception e) {
            Log.e("LocaleApiLibrary", "Encountered error generating breadcrumb", e);
            return "";
        }
    }
}
