package com.urbandroid.sleep.gui;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda0;
import com.urbandroid.util.ColorUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001e\u0010\u0015J\u0019\u0010!\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010$\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0015R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/urbandroid/sleep/gui/DefaultValueListPreference;", "Lcom/urbandroid/sleep/gui/MaterialDialogListPreference;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Landroid/text/Spannable;", "getSummarySpannable", "()Landroid/text/Spannable;", "", "defaultValue", "", "newDefaultValue", "", "addDefaultValue", "(Ljava/lang/String;I)V", SDKConstants.PARAM_VALUE, "syncValueWithSummary", "(Ljava/lang/String;)V", "", "newValue", "", "callChangeListener", "(Ljava/lang/Object;)Z", "summaryResId", "setSummary", "(I)V", "setValue", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "onBindView", "(Landroid/view/View;)V", "originalDefaultEntryText", "Ljava/lang/String;", "longDesc", "getLongDesc", "()Ljava/lang/String;", "setLongDesc", "Landroid/widget/TextView;", "summaryText", "Landroid/widget/TextView;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultValueListPreference extends MaterialDialogListPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String longDesc;
    private String originalDefaultEntryText;
    private TextView summaryText;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/gui/DefaultValueListPreference$Companion;", "", "<init>", "()V", "getDefaultPrefix", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getDefaultPrefix(Context context) {
            context.getClass();
            return FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.default_ringtone_name), ": ");
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultValueListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    public static /* synthetic */ void addDefaultValue$default(DefaultValueListPreference defaultValueListPreference, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -2;
        }
        defaultValueListPreference.addDefaultValue(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addDefaultValue$lambda$0(DefaultValueListPreference defaultValueListPreference) {
        defaultValueListPreference.syncValueWithSummary(defaultValueListPreference.getValue());
    }

    public static final String getDefaultPrefix(Context context) {
        return INSTANCE.getDefaultPrefix(context);
    }

    private final Spannable getSummarySpannable() {
        CharSequence summary = getSummary();
        if (summary == null) {
            return new SpannableString("");
        }
        Companion companion = INSTANCE;
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

    public final void addDefaultValue(String defaultValue, int newDefaultValue) {
        int iFindIndexOfValue;
        defaultValue.getClass();
        CharSequence[] entries = getEntries();
        entries.getClass();
        CharSequence[] entryValues = getEntryValues();
        entryValues.getClass();
        try {
            iFindIndexOfValue = findIndexOfValue(defaultValue);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        String string = iFindIndexOfValue >= 0 ? entries[iFindIndexOfValue].toString() : null;
        this.originalDefaultEntryText = string;
        CharSequence[] charSequenceArr = new CharSequence[entries.length + 1];
        CharSequence[] charSequenceArr2 = new CharSequence[entryValues.length + 1];
        System.arraycopy(entries, 0, charSequenceArr, 1, entries.length);
        System.arraycopy(entryValues, 0, charSequenceArr2, 1, entryValues.length);
        Companion companion = INSTANCE;
        Context context = getContext();
        context.getClass();
        String defaultPrefix = companion.getDefaultPrefix(context);
        if (string == null) {
            string = "...";
        }
        charSequenceArr[0] = Html.fromHtml("<b>" + defaultPrefix + "</b>" + string);
        charSequenceArr2[0] = String.valueOf(newDefaultValue);
        setEntries(charSequenceArr);
        setEntryValues(charSequenceArr2);
        new Handler().postDelayed(new Endpoint$$ExternalSyntheticLambda0(this, 2), 500L);
    }

    @Override // android.preference.Preference
    public boolean callChangeListener(Object newValue) {
        syncValueWithSummary(String.valueOf(newValue));
        Logger.logInfo("Default " + newValue);
        return super.callChangeListener(newValue);
    }

    @Override // com.urbandroid.sleep.gui.MaterialDialogListPreference, android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        TextView textView = view != null ? (TextView) view.findViewById(android.R.id.summary) : null;
        this.summaryText = textView;
        if (textView != null) {
            textView.setText(getSummarySpannable(), TextView.BufferType.SPANNABLE);
        }
    }

    public final void setLongDesc(String str) {
        this.longDesc = str;
    }

    @Override // android.preference.Preference
    public void setSummary(int summaryResId) {
        super.setSummary(summaryResId);
        TextView textView = this.summaryText;
        if (textView != null) {
            textView.setText(getSummarySpannable(), TextView.BufferType.SPANNABLE);
        }
    }

    @Override // android.preference.ListPreference
    public void setValue(String value) {
        super.setValue(value);
        syncValueWithSummary(value);
    }

    public final void syncValueWithSummary(String value) {
        String str;
        if (value != null) {
            int iFindIndexOfValue = findIndexOfValue(value);
            str = "";
            if (iFindIndexOfValue == 0) {
                String str2 = this.originalDefaultEntryText;
                String str3 = this.longDesc;
                setSummary(str2 + (str3 != null ? FileInsert$$ExternalSyntheticOutline0.m("\n\n", str3) : ""));
                return;
            }
            if (iFindIndexOfValue > 0) {
                try {
                    CharSequence charSequence = getEntries()[iFindIndexOfValue];
                    CharSequence charSequence2 = getEntries()[0];
                    String str4 = this.longDesc;
                    if (str4 != null) {
                        str = "\n\n" + str4;
                    }
                    setSummary(((Object) charSequence) + "   " + ((Object) charSequence2) + str);
                } catch (Exception e) {
                    Logger.logSevere("failt to sync summary value: " + value + " key: " + getKey(), e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultValueListPreference(Context context) {
        super(context);
        context.getClass();
    }

    public final void addDefaultValue(String str) {
        str.getClass();
        addDefaultValue$default(this, str, 0, 2, null);
    }
}
