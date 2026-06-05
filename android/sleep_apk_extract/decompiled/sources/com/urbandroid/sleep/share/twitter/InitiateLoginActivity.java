package com.urbandroid.sleep.share.twitter;

import android.os.Bundle;
import com.urbandroid.common.BaseActivity;

/* JADX INFO: loaded from: classes5.dex */
public class InitiateLoginActivity extends BaseActivity {
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new OAuthRequestTokenTask(this).execute(new Void[0]);
        finish();
    }
}
