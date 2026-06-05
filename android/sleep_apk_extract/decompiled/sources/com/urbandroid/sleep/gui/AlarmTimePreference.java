package com.urbandroid.sleep.gui;

import android.content.Context;
import android.os.Bundle;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.material.chip.Chip$$ExternalSyntheticLambda0;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.SetAlarm$$ExternalSyntheticLambda2;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001*B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/urbandroid/sleep/gui/AlarmTimePreference;", "Landroid/preference/ListPreference;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "onBindView", "(Landroid/view/View;)V", "Landroid/os/Bundle;", ServerProtocol.DIALOG_PARAM_STATE, "showDialog", "(Landroid/os/Bundle;)V", "Lcom/urbandroid/sleep/gui/AlarmTimePreference$OnAlarmSwitch;", "listener", "Lcom/urbandroid/sleep/gui/AlarmTimePreference$OnAlarmSwitch;", "getListener", "()Lcom/urbandroid/sleep/gui/AlarmTimePreference$OnAlarmSwitch;", InAppPurchaseConstants.METHOD_SET_LISTENER, "(Lcom/urbandroid/sleep/gui/AlarmTimePreference$OnAlarmSwitch;)V", "Lcom/google/android/material/materialswitch/MaterialSwitch;", "switch", "Lcom/google/android/material/materialswitch/MaterialSwitch;", "getSwitch", "()Lcom/google/android/material/materialswitch/MaterialSwitch;", "setSwitch", "(Lcom/google/android/material/materialswitch/MaterialSwitch;)V", "", "alarmIsEnabled", "Ljava/lang/Boolean;", "getAlarmIsEnabled", "()Ljava/lang/Boolean;", "setAlarmIsEnabled", "(Ljava/lang/Boolean;)V", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "checkedListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "OnAlarmSwitch", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AlarmTimePreference extends ListPreference {
    private Boolean alarmIsEnabled;
    private final CompoundButton.OnCheckedChangeListener checkedListener;
    private OnAlarmSwitch listener;
    private MaterialSwitch switch;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/gui/AlarmTimePreference$OnAlarmSwitch;", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface OnAlarmSwitch {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmTimePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
        this.checkedListener = new Chip$$ExternalSyntheticLambda0(this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkedListener$lambda$0(AlarmTimePreference alarmTimePreference, CompoundButton compoundButton, boolean z) {
        compoundButton.getClass();
        alarmTimePreference.alarmIsEnabled = Boolean.valueOf(z);
        OnAlarmSwitch onAlarmSwitch = alarmTimePreference.listener;
        if (onAlarmSwitch != null) {
            ((SetAlarm$$ExternalSyntheticLambda2) onAlarmSwitch).f$0.lambda$onCreatePreference$4(z);
        }
    }

    public final Boolean getAlarmIsEnabled() {
        return this.alarmIsEnabled;
    }

    public final MaterialSwitch getSwitch() {
        return this.switch;
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        this.switch = view != null ? (MaterialSwitch) view.findViewById(R.id.enable_alarm) : null;
        Boolean bool = this.alarmIsEnabled;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            MaterialSwitch materialSwitch = this.switch;
            if (materialSwitch != null) {
                materialSwitch.setChecked(zBooleanValue);
            }
        }
        MaterialSwitch materialSwitch2 = this.switch;
        if (materialSwitch2 != null) {
            materialSwitch2.setOnCheckedChangeListener(this.checkedListener);
        }
    }

    public final void setAlarmIsEnabled(Boolean bool) {
        this.alarmIsEnabled = bool;
    }

    public final void setListener(OnAlarmSwitch onAlarmSwitch) {
        this.listener = onAlarmSwitch;
    }

    @Override // android.preference.DialogPreference
    public void showDialog(Bundle state) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmTimePreference(Context context) {
        super(context);
        context.getClass();
        this.checkedListener = new Chip$$ExternalSyntheticLambda0(this, 1);
    }
}
