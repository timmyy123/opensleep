package com.urbandroid.sleep.gui;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.DefaultValueListPreference;
import com.urbandroid.util.ColorUtil;
import java.util.UnknownFormatConversionException;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/gui/DefaultValuePreference;", "Lcom/urbandroid/sleep/gui/MaterialDialogListPreference;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Landroid/text/Spannable;", "getSummarySpannable", "()Landroid/text/Spannable;", "", "summaryResId", "", "setSummary", "(I)V", "Landroid/os/Bundle;", ServerProtocol.DIALOG_PARAM_STATE, "showDialog", "(Landroid/os/Bundle;)V", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "onBindView", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "summaryText", "Landroid/widget/TextView;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultValuePreference extends MaterialDialogListPreference {
    private TextView summaryText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultValuePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    private final Spannable getSummarySpannable() {
        CharSequence summary = getSummary();
        if (summary == null) {
            return new SpannableString("");
        }
        DefaultValueListPreference.Companion companion = DefaultValueListPreference.INSTANCE;
        Context context = getContext();
        context.getClass();
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default(summary, companion.getDefaultPrefix(context), 0, false, 6, (Object) null);
        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default(summary, "\n", 0, false, 6, (Object) null);
        if (iIndexOf$default2 < iIndexOf$default) {
            iIndexOf$default2 = summary.length();
        }
        SpannableString spannableString = new SpannableString(summary);
        if (iIndexOf$default > 0) {
            spannableString.setSpan(new StrikethroughSpan(), iIndexOf$default, iIndexOf$default2, 17);
            spannableString.setSpan(new ForegroundColorSpan(ColorUtil.i(getContext(), R.color.quaternary)), iIndexOf$default, iIndexOf$default2, 17);
        }
        return spannableString;
    }

    @Override // com.urbandroid.sleep.gui.MaterialDialogListPreference, android.preference.Preference
    public void onBindView(View view) {
        try {
            super.onBindView(view);
        } catch (UnknownFormatConversionException e) {
            Logger.logInfo("DefaultValuePref " + getKey());
            Logger.logSevere(e);
            setSummary("");
            super.onBindView(view);
        }
        TextView textView = view != null ? (TextView) view.findViewById(android.R.id.summary) : null;
        this.summaryText = textView;
        if (textView != null) {
            textView.setText(getSummarySpannable(), TextView.BufferType.SPANNABLE);
        }
    }

    @Override // android.preference.Preference
    public void setSummary(int summaryResId) {
        super.setSummary(summaryResId);
        TextView textView = this.summaryText;
        if (textView != null) {
            textView.setText(getSummarySpannable(), TextView.BufferType.SPANNABLE);
        }
    }

    @Override // com.urbandroid.sleep.gui.MaterialDialogListPreference, android.preference.DialogPreference
    public void showDialog(Bundle state) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultValuePreference(Context context) {
        super(context);
        context.getClass();
    }
}
