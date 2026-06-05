package com.urbandroid.sleep.fragment.preview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/AnalyticsConsentPreviewPage;", "Ljava/io/Serializable;", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "", "action", "()V", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "parent", "adjustLayout", "(Landroid/app/Activity;Landroid/view/View;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnalyticsConsentPreviewPage extends PreviewPage implements Serializable {
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsConsentPreviewPage(Context context) {
        super("ANAL", context.getString(R.string.analytics), context.getString(R.string.analytics_consent), R.color.t1, R.color.t1, R.drawable.preview_personalize, R.anim.wave);
        context.getClass();
        this.context = context;
        setLayout(R.layout.fragment_preview_page_analytics);
        setButton(context.getString(R.string.agree));
        setCancel(context.getString(R.string.not_interested));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void adjustLayout$lambda$0(AnalyticsConsentPreviewPage analyticsConsentPreviewPage, View view) {
        try {
            Context context = analyticsConsentPreviewPage.context;
            ViewIntent.url(context, context.getString(R.string.privacy_policy_link));
        } catch (Exception unused) {
        }
    }

    @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
    public void action() {
        SharedApplicationContext.getSettings().setUserAnalyticsAgreed();
    }

    @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
    public void adjustLayout(Activity activity, View parent) {
        activity.getClass();
        parent.getClass();
        super.adjustLayout(activity, parent);
        parent.findViewById(R.id.read_more).setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 17));
    }
}
