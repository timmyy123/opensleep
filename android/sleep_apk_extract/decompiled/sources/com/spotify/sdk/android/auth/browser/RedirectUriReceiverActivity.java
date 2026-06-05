package com.spotify.sdk.android.auth.browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.spotify.sdk.android.auth.LoginActivity;

/* JADX INFO: loaded from: classes4.dex */
public class RedirectUriReceiverActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) LoginActivity.class);
        intent.setData(getIntent().getData());
        intent.addFlags(603979776);
        startActivity(intent);
        finish();
    }
}
