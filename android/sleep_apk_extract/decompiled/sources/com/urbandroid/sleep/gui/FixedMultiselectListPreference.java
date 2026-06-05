package com.urbandroid.sleep.gui;

import android.content.Context;
import android.os.Bundle;
import android.preference.MultiSelectListPreference;
import android.util.AttributeSet;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.ServerProtocol;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/gui/FixedMultiselectListPreference;", "Landroid/preference/MultiSelectListPreference;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", ServerProtocol.DIALOG_PARAM_STATE, "", "showDialog", "(Landroid/os/Bundle;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class FixedMultiselectListPreference extends MultiSelectListPreference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedMultiselectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    @Override // android.preference.DialogPreference
    public void showDialog(Bundle state) {
        super.showDialog(state);
        DialogUtil.fixDivider(getDialog());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedMultiselectListPreference(Context context) {
        super(context);
        context.getClass();
    }
}
