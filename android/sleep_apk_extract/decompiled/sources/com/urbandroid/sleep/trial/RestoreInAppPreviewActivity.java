package com.urbandroid.sleep.trial;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.PreviewActivity;
import com.urbandroid.sleep.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/trial/RestoreInAppPreviewActivity;", "Lcom/urbandroid/sleep/PreviewActivity;", "<init>", "()V", "", "getLayoutRes", "()I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RestoreInAppPreviewActivity extends PreviewActivity {
    @Override // com.urbandroid.sleep.PreviewActivity
    public int getLayoutRes() {
        setListener(new PreviewActivity.PreviewListener() { // from class: com.urbandroid.sleep.trial.RestoreInAppPreviewActivity.getLayoutRes.1
            @Override // com.urbandroid.sleep.PreviewActivity.PreviewListener
            public void onFinish() {
                Logger.logInfo("Preview: onFinish()");
                RestoreInAppPreviewActivity restoreInAppPreviewActivity = RestoreInAppPreviewActivity.this;
                ViewIntent.market(restoreInAppPreviewActivity, restoreInAppPreviewActivity.getPackageName());
            }

            @Override // com.urbandroid.sleep.PreviewActivity.PreviewListener
            public void onSkip() {
                Logger.logInfo("Preview: onSkip()");
                RestoreInAppPreviewActivity.this.setResult(333);
            }
        });
        return R.layout.activity_preview_unlock_restore_inapp;
    }
}
