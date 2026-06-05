package com.urbandroid.sleep.gui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import java.util.UnknownFormatConversionException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0010R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/gui/MaterialDialogListPreference;", "Landroid/preference/ListPreference;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "", "getSummary", "()Ljava/lang/CharSequence;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "onBindView", "(Landroid/view/View;)V", "Landroid/os/Bundle;", ServerProtocol.DIALOG_PARAM_STATE, "showDialog", "(Landroid/os/Bundle;)V", "show", "()V", "actionButton", "Landroid/view/View;", "getActionButton", "()Landroid/view/View;", "setActionButton", "Lcom/urbandroid/sleep/gui/IOnBindListener;", "bindListener", "Lcom/urbandroid/sleep/gui/IOnBindListener;", "getBindListener", "()Lcom/urbandroid/sleep/gui/IOnBindListener;", "setBindListener", "(Lcom/urbandroid/sleep/gui/IOnBindListener;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MaterialDialogListPreference extends ListPreference {
    private View actionButton;
    private IOnBindListener bindListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialDialogListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$0(MaterialDialogListPreference materialDialogListPreference, DialogInterface dialogInterface, int i) {
        materialDialogListPreference.onClick(null, -1);
        dialogInterface.dismiss();
        if (i < 0 || materialDialogListPreference.getEntryValues() == null) {
            return;
        }
        String string = materialDialogListPreference.getEntryValues()[i].toString();
        if (materialDialogListPreference.callChangeListener(string)) {
            materialDialogListPreference.setValue(string);
        }
    }

    public final View getActionButton() {
        return this.actionButton;
    }

    @Override // android.preference.ListPreference, android.preference.Preference
    public CharSequence getSummary() {
        try {
            return super.getSummary();
        } catch (Exception e) {
            Logger.logSevere("Pref getSummary " + this.getKey(), e);
            this.setSummary("");
            return "";
        }
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        try {
            super.onBindView(view);
        } catch (UnknownFormatConversionException e) {
            Logger.logInfo("Prefrence onBindView " + getKey() + " ");
            Logger.logSevere(e);
        }
        this.actionButton = view != null ? view.findViewById(R.id.pref_action_button) : null;
        IOnBindListener iOnBindListener = this.bindListener;
        if (iOnBindListener != null) {
            iOnBindListener.onBind();
        }
    }

    public final void setBindListener(IOnBindListener iOnBindListener) {
        this.bindListener = iOnBindListener;
    }

    public final void show() {
        showDialog(null);
    }

    @Override // android.preference.DialogPreference
    public void showDialog(Bundle state) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getContext());
        materialAlertDialogBuilder.setTitle(getTitle());
        materialAlertDialogBuilder.setIcon(getDialogIcon());
        materialAlertDialogBuilder.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
        CharSequence[] entries = getEntries();
        CharSequence[] entryValues = getEntryValues();
        entryValues.getClass();
        materialAlertDialogBuilder.setSingleChoiceItems(entries, ArraysKt.indexOf((String[]) entryValues, getValue()), (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(this, 11));
        View viewOnCreateDialogView = onCreateDialogView();
        if (viewOnCreateDialogView != null) {
            onBindDialogView(viewOnCreateDialogView);
            materialAlertDialogBuilder.setView(viewOnCreateDialogView);
        } else {
            materialAlertDialogBuilder.setMessage(getDialogMessage());
        }
        materialAlertDialogBuilder.show();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialDialogListPreference(Context context) {
        super(context);
        context.getClass();
    }
}
