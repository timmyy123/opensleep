package com.urbandroid.sleep.service.matter;

import android.os.Bundle;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContracts$StartIntentSenderForResult;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util$$ExternalSyntheticLambda2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/service/matter/MatterActivity;", "Lcom/urbandroid/common/BaseActivity;", "<init>", "()V", "matterManager", "Lcom/urbandroid/sleep/service/matter/MatterManager;", "commissioningLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/IntentSenderRequest;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MatterActivity extends BaseActivity {
    private final ActivityResultLauncher<IntentSenderRequest> commissioningLauncher = registerForActivityResult(new ActivityResultContracts$StartIntentSenderForResult(), new Util$$ExternalSyntheticLambda2(this, 6));
    private MatterManager matterManager;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void commissioningLauncher$lambda$0(MatterActivity matterActivity, ActivityResult activityResult) {
        activityResult.getClass();
        if (activityResult.getResultCode() != -1) {
            Logger.logInfo("Matter: Párování nebylo dokončeno");
            return;
        }
        MatterManager matterManager = matterActivity.matterManager;
        if (matterManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matterManager");
            matterManager = null;
        }
        matterManager.handleCommissioningResult(activityResult.getData());
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matter);
        MatterManager matterManager = new MatterManager(this);
        this.matterManager = matterManager;
        matterManager.startCommissioning(this.commissioningLauncher);
    }
}
