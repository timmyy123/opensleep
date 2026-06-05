package com.urbandroid.sleep.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/gui/ListPreferenceWithButton;", "Lcom/urbandroid/sleep/gui/MaterialDialogListPreference;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "onBindView", "(Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ListPreferenceWithButton extends MaterialDialogListPreference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListPreferenceWithButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    @Override // com.urbandroid.sleep.gui.MaterialDialogListPreference, android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListPreferenceWithButton(Context context) {
        super(context);
        context.getClass();
    }
}
