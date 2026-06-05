package com.urbandroid.sleep.fragment.preview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/FirstPreviewPage;", "Ljava/io/Serializable;", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "", "action", "()V", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "parent", "adjustLayout", "(Landroid/app/Activity;Landroid/view/View;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FirstPreviewPage extends PreviewPage implements Serializable {
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirstPreviewPage(Context context) {
        super("first", context.getString(R.string.help_you), context.getString(R.string.help_users, Integer.valueOf(TrialFilter.APP_TOTAL_USERS_IN_MILLIONS)), R.color.sunset, R.color.sunrise, R.drawable.preview_logo, R.anim.rock);
        context.getClass();
        this.context = context;
        setLayout(R.layout.fragment_preview_first_page);
    }

    @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
    public void action() {
    }

    @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
    public void adjustLayout(Activity activity, View parent) {
        activity.getClass();
        parent.getClass();
        super.adjustLayout(activity, parent);
        ((TextView) parent.findViewById(R.id.app_users)).setText(TrialFilter.APP_TOTAL_USERS_IN_MILLIONS + "M");
        TextView textView = (TextView) parent.findViewById(R.id.app_years);
        int appYears = TrialFilter.getAppYears();
        StringBuilder sb = new StringBuilder();
        sb.append(appYears);
        textView.setText(sb.toString());
    }
}
