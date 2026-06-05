package com.urbandroid.sleep;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import androidx.view.OnBackPressedCallback;
import androidx.viewpager.widget.PagerAdapter;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.IBillingServiceStatusListener;
import com.urbandroid.sleep.trial.IBillingStatusListener;
import com.urbandroid.sleep.trial.JavaBilling;
import java.io.Serializable;
import kotlin.Metadata;
import org.mp4parser.boxes.iso14496.part12.FreeSpaceBox;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001&B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0006J#\u0010\u0014\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0017\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u0006R\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/urbandroid/sleep/FirstUsePreviewActivity;", "Lcom/urbandroid/sleep/PreviewActivity;", "Ljava/io/Serializable;", "Lcom/urbandroid/sleep/trial/IBillingStatusListener;", "Lcom/urbandroid/sleep/trial/IBillingServiceStatusListener;", "<init>", "()V", "", "getLayoutRes", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onServiceConnected", "", "sku", "Lcom/urbandroid/sleep/trial/IBillingStatusListener$Status;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "onStatusDetected", "(Ljava/lang/String;Lcom/urbandroid/sleep/trial/IBillingStatusListener$Status;)V", "onStart", "onResume", "onPause", "onStop", "", "canSkip", "()Z", FreeSpaceBox.TYPE, "isTrial", "Z", "Lcom/urbandroid/sleep/trial/JavaBilling;", SDKConstants.PARAM_VALUE, "billing", "Lcom/urbandroid/sleep/trial/JavaBilling;", "getBilling", "()Lcom/urbandroid/sleep/trial/JavaBilling;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FirstUsePreviewActivity extends PreviewActivity implements Serializable, IBillingStatusListener, IBillingServiceStatusListener {
    public static String SHOWN_TUTORIAL = "tutorial";
    private transient JavaBilling billing;
    private boolean isTrial = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(FirstUsePreviewActivity firstUsePreviewActivity, View view) {
        Toast.makeText(firstUsePreviewActivity, R.string.settings_dismiss_long_press_title, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(View view) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(FirstUsePreviewActivity firstUsePreviewActivity) {
        View viewFindViewById = firstUsePreviewActivity.findViewById(R.id.image);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
            viewFindViewById.startAnimation(AnimationUtils.loadAnimation(firstUsePreviewActivity.getApplicationContext(), R.anim.rock_logo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void skip$lambda$0(FirstUsePreviewActivity firstUsePreviewActivity, DialogInterface dialogInterface, int i) {
        firstUsePreviewActivity.getPager().setCurrentItem(firstUsePreviewActivity.getPager().getAdapter() != null ? r3.getCount() - 3 : 17, true);
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialSkipped(firstUsePreviewActivity.getSubClassName(), firstUsePreviewActivity.getPager().getCurrentItem());
    }

    @Override // com.urbandroid.sleep.PreviewActivity
    public boolean canSkip() {
        return true;
    }

    public final JavaBilling getBilling() {
        return this.billing;
    }

    @Override // com.urbandroid.sleep.PreviewActivity
    public int getLayoutRes() {
        return R.layout.activity_preview_first_use;
    }

    @Override // com.urbandroid.sleep.PreviewActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.billing = AlarmClock.initializeBilling(this, this, this);
        this.isTrial = TrialFilter.getInstance().isTrial();
        View viewFindViewById = findViewById(R.id.close);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new SmartWatchActivity$3$$ExternalSyntheticLambda0(this, 1));
        }
        View viewFindViewById2 = findViewById(R.id.close);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnLongClickListener(new FirstUsePreviewActivity$$ExternalSyntheticLambda1());
        }
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.urbandroid.sleep.FirstUsePreviewActivity$onCreate$callback$1
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (this.this$0.getPager().getAdapter() != null) {
                    if (this.this$0.getPager().getCurrentItem() == r0.getCount() - 1) {
                        setEnabled(false);
                    }
                }
                this.this$0.skip();
            }
        });
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isTrial = TrialFilter.getInstance().isTrial();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TrialFilter.getInstance().reevaluate();
        if (!this.isTrial || TrialFilter.getInstance().isTrial()) {
            return;
        }
        finish();
    }

    @Override // com.urbandroid.sleep.trial.IBillingServiceStatusListener
    public void onServiceConnected() {
        log("Preview: Billing connected");
    }

    @Override // com.urbandroid.sleep.PreviewActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        new Handler().postDelayed(new PreviewActivity$$ExternalSyntheticLambda1(this, 1), 500L);
    }

    @Override // com.urbandroid.sleep.trial.IBillingStatusListener
    public void onStatusDetected(String sku, IBillingStatusListener.Status status) {
        log("Preview: purchased " + sku + " status " + status);
        if (status == IBillingStatusListener.Status.OWNED) {
            finish();
        }
    }

    @Override // com.urbandroid.sleep.PreviewActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.urbandroid.sleep.PreviewActivity
    public void skip() {
        PagerAdapter adapter = getPager().getAdapter();
        int i = 1;
        if (adapter != null) {
            if (getPager().getCurrentItem() == adapter.getCount() - 1) {
                getOnBackPressedDispatcher().onBackPressed();
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialFinished(getSubClassName());
                return;
            }
        }
        new MaterialAlertDialogBuilder(this).setTitle((CharSequence) getString(R.string.skip_tutorial_title)).setMessage((CharSequence) getString(R.string.skip_tutorial_desc)).setNegativeButton(R.string.tutorial_already_knows, (DialogInterface.OnClickListener) new Sleep$$ExternalSyntheticLambda0(this, i)).setPositiveButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }
}
