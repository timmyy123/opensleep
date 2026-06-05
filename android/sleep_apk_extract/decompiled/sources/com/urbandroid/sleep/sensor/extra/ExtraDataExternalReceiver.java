package com.urbandroid.sleep.sensor.extra;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.hecz.common.logging.Log;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.sleep.ContextExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/ExtraDataExternalReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtraDataExternalReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LocalBroadcastManager localBroadcastManager;
        StringBuilder sb = new StringBuilder();
        BaseActivity.traceIntent(sb, intent);
        Log.info("BTLE external onReceived " + (intent != null ? intent.getAction() : null) + " " + ((Object) sb));
        if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, "com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE") || context == null || (localBroadcastManager = ContextExtKt.getLocalBroadcastManager(context)) == null) {
            return;
        }
        Intent intent2 = new Intent(intent);
        intent2.putExtras(intent);
        localBroadcastManager.sendBroadcast(intent2);
    }
}
