package com.urbandroid.sleep.share;

import android.content.Intent;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.SleepRecord;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ShareLoginActivity extends BaseActivity {
    public void resubmit() {
        Logger.logInfo("Share Login Activity Destroy");
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("sharing_resubmit_object_key");
            Logger.logInfo("Share Login Activity Destroy" + serializableExtra);
            if (serializableExtra == null || !(serializableExtra instanceof SleepRecord)) {
                return;
            }
            ShareAfterDismissService.shareExplicit(this, (SleepRecord) serializableExtra);
        }
    }
}
