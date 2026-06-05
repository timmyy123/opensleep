package com.urbandroid.sleep.gui;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/gui/EnablePreference;", "Landroid/preference/CheckBoxPreference;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "setChecked", "", "checked", "", "enabledContainer", "Landroid/view/ViewGroup;", "onBindView", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnablePreference extends CheckBoxPreference {
    private ViewGroup enabledContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnablePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    @Override // android.preference.CheckBoxPreference, android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ViewGroup viewGroup = view != null ? (ViewGroup) view.findViewById(R.id.enabledContainer) : null;
        this.enabledContainer = viewGroup;
        if (viewGroup != null) {
            if (isChecked()) {
                viewGroup.setBackground(ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.card_pref_enabled));
            } else {
                viewGroup.setBackground(ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.card_pref_disabled));
            }
        }
    }

    @Override // android.preference.TwoStatePreference
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        ViewGroup viewGroup = this.enabledContainer;
        if (viewGroup != null) {
            if (checked) {
                viewGroup.setBackground(ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.card_pref_enabled));
            } else {
                viewGroup.setBackground(ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.card_pref_disabled));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnablePreference(Context context) {
        super(context);
        context.getClass();
    }
}
