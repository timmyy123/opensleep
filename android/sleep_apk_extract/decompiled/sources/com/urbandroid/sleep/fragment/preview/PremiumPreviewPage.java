package com.urbandroid.sleep.fragment.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.FirstUsePreviewActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import com.urbandroid.sleep.media.MediaListAdapter$$ExternalSyntheticLambda3;
import com.urbandroid.sleep.service.PrefStore;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager;
import com.urbandroid.sleep.trial.JavaBilling;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import java.io.Serializable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/PremiumPreviewPage;", "Ljava/io/Serializable;", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "resTitle", "resSummary", "resImage", "<init>", "(Landroid/content/Context;III)V", "", "action", "()V", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "parent", "adjustLayout", "(Landroid/app/Activity;Landroid/view/View;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PremiumPreviewPage extends PreviewPage implements Serializable {
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PremiumPreviewPage(Context context, int i, int i2, int i3) {
        super(context.getString(i), context.getString(i2), R.color.t1, R.color.t1, i3, R.anim.wave);
        context.getClass();
        this.context = context;
        setLayout(R.layout.fragment_preview_premium_compare);
        setButton(context.getString(R.string.agree));
        setButtonText(PreviewPage.INSTANCE.getNO_BUTTON());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void adjustLayout$lambda$0(ViewGroup viewGroup, Ref$ObjectRef ref$ObjectRef, Activity activity, PremiumPreviewPage premiumPreviewPage) {
        viewGroup.setVisibility(8);
        UnlockFlow unlockFlow = (UnlockFlow) ref$ObjectRef.element;
        if (unlockFlow != null) {
            unlockFlow.onStop();
        }
        FirstUsePreviewActivity firstUsePreviewActivity = (FirstUsePreviewActivity) activity;
        firstUsePreviewActivity.getWindow().setStatusBarColor(ColorUtil.i(premiumPreviewPage.context, R.color.tint_background_attention));
        firstUsePreviewActivity.getWindow().setNavigationBarColor(ColorUtil.i(premiumPreviewPage.context, R.color.tint_background_attention));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void adjustLayout$lambda$2(Activity activity, ViewGroup viewGroup, Ref$ObjectRef ref$ObjectRef, View view) {
        Logger.logInfo("Preview: premium button");
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialFinished("FirstUsePreviewActivity");
        if (!(activity instanceof FirstUsePreviewActivity)) {
            Intent intent = new Intent(activity, (Class<?>) AlarmClock.class);
            intent.putExtra("com.urbandroid.sleep.START_UNLOCK_CLOUD_PURCHASE", true);
            activity.startActivity(intent);
            activity.finish();
            return;
        }
        viewGroup.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.unfade));
        viewGroup.setVisibility(0);
        FirstUsePreviewActivity firstUsePreviewActivity = (FirstUsePreviewActivity) activity;
        firstUsePreviewActivity.getWindow().setStatusBarColor(ColorUtil.i(activity, R.color.bg_main));
        firstUsePreviewActivity.getWindow().setNavigationBarColor(ColorUtil.i(activity, R.color.bg_main));
        UnlockFlow unlockFlow = (UnlockFlow) ref$ObjectRef.element;
        if (unlockFlow != null) {
            unlockFlow.onCreate();
        }
        UnlockFlow unlockFlow2 = (UnlockFlow) ref$ObjectRef.element;
        if (unlockFlow2 != null) {
            unlockFlow2.onStart();
        }
    }

    @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
    public void action() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, com.urbandroid.sleep.alarmclock.UnlockFlow] */
    @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
    public void adjustLayout(Activity activity, View parent) {
        activity.getClass();
        parent.getClass();
        super.adjustLayout(activity, parent);
        Button button = (Button) parent.findViewById(R.id.trial);
        Button button2 = (Button) parent.findViewById(R.id.premium);
        EdgeToEdgeUtil.Companion.insetsBottom$default(EdgeToEdgeUtil.INSTANCE, parent.findViewById(R.id.bottom), 0, false, 6, null);
        ((TextView) parent.findViewById(R.id.title)).setText(getTitle());
        ((TextView) parent.findViewById(R.id.text)).setText(getText());
        Logger.logInfo("Preview: " + ((Object) getTitle()) + " " + ((Object) getText()));
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.activity_unlock);
        if (!TrialFilter.getInstance().isTrial()) {
            button.setText(R.string.unlock_restore_wait);
        } else if (TrialFilter.getInstance().isTrialExpired()) {
            button.setText(R.string.botton_free);
        } else {
            button.setText(activity.getString(R.string.premium_trial_days, Long.valueOf(TrialFilter.getInstance().getExpirationTime() / TimeChart.DAY)) + " *");
        }
        TextView textView = (TextView) parent.findViewById(R.id.no_card);
        if (textView != null) {
            String string = activity.getString(R.string.no_card);
            string.getClass();
            String lowerCase = string.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            textView.setText("* ".concat(lowerCase));
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (activity instanceof FirstUsePreviewActivity) {
            FirstUsePreviewActivity firstUsePreviewActivity = (FirstUsePreviewActivity) activity;
            if (firstUsePreviewActivity.getBilling() != null) {
                ref$ObjectRef.element = new UnlockFlow(activity, viewGroup, new PremiumPreviewPage$$ExternalSyntheticLambda0(viewGroup, ref$ObjectRef, activity, this));
                JavaBilling billing = firstUsePreviewActivity.getBilling();
                if (billing != null) {
                    ((UnlockFlow) ref$ObjectRef.element).setBilling(billing);
                }
            }
        }
        button2.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda3(activity, viewGroup, ref$ObjectRef, 5));
        button.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(activity, 18));
        SharedApplicationContext.getSettings().addShowCaseShown(FirstUsePreviewActivity.SHOWN_TUTORIAL);
        try {
            FirebaseAnalyticsManager firebaseAnalyticsManager = SharedApplicationContext.getInstance().getFirebaseAnalyticsManager();
            Context context = SharedApplicationContext.getInstance().getContext();
            context.getClass();
            firebaseAnalyticsManager.setPlainEvent("Tutorial_prefs", new PrefStore(context, "onboarding_prefs").toBundle());
        } catch (Exception unused) {
            Logger.logSevere("Cannot log tutorial prefs");
        }
    }

    public /* synthetic */ PremiumPreviewPage(Context context, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? R.string.upgrade_to_premium : i, (i4 & 4) != 0 ? R.string.free_to_use_summary : i2, (i4 & 8) != 0 ? R.drawable.preview_free : i3);
    }
}
