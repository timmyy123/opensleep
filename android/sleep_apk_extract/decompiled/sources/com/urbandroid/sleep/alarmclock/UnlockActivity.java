package com.urbandroid.sleep.alarmclock;

import android.os.Bundle;
import android.transition.Explode;
import android.view.ViewGroup;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;

/* JADX INFO: loaded from: classes4.dex */
public class UnlockActivity extends BaseActivity {
    private UnlockFlow unlockFlow;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18e01f66$1() {
        this.unlockFlow.onStop();
        finish();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(12);
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_unlock);
        UnlockFlow unlockFlow = new UnlockFlow(this, (ViewGroup) findViewById(R.id.root), new AlarmClock$$ExternalSyntheticLambda5(this, 1));
        this.unlockFlow = unlockFlow;
        unlockFlow.onCreate();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.unlockFlow.onStart();
        Logger.logInfo("UnlockPreview onStart()");
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.unlockFlow.onStop();
    }
}
