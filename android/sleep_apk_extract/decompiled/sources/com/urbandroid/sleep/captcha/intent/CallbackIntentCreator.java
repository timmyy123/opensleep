package com.urbandroid.sleep.captcha.intent;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public interface CallbackIntentCreator {
    Intent createSolvedIntent(Context context, String str);

    Intent createUnsolvedIntent(Context context, String str);
}
