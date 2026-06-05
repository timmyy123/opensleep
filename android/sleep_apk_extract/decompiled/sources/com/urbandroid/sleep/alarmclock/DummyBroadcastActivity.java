package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/DummyBroadcastActivity;", "Lcom/urbandroid/common/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DummyBroadcastActivity extends BaseActivity {
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logInfo("Anti-trampoline " + getIntent().getStringExtra("extra_broadcast_action"));
        Intent intent = getIntent();
        intent.getExtras();
        Intent intent2 = new Intent(intent);
        intent2.setAction(getIntent().getStringExtra("extra_broadcast_action"));
        intent2.setComponent(null);
        intent2.setPackage(getPackageName());
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        ContextExtKt.sendExplicitBroadcast$default(applicationContext, intent2, null, 2, null);
        finish();
    }
}
