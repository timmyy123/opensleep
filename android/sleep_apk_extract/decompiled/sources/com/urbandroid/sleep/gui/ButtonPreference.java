package com.urbandroid.sleep.gui;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/gui/ButtonPreference;", "Landroid/preference/DialogPreference;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", ServerProtocol.DIALOG_PARAM_STATE, "", "showDialog", "(Landroid/os/Bundle;)V", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "onBindView", "(Landroid/view/View;)V", "Landroid/widget/Button;", "button", "Landroid/widget/Button;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ButtonPreference extends DialogPreference {
    private Button button;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindView$lambda$0(ButtonPreference buttonPreference, View view) {
        buttonPreference.getOnPreferenceClickListener().onPreferenceClick(buttonPreference);
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        Button button = view != null ? (Button) view.findViewById(R.id.title) : null;
        this.button = button;
        if (button != null) {
            button.setText(getTitle());
        }
        if ((this.button instanceof MaterialButton) && getIcon() != null) {
            Button button2 = this.button;
            button2.getClass();
            ((MaterialButton) button2).lambda$setSecondaryIcon$3(getIcon());
        }
        Button button3 = this.button;
        if (button3 != null) {
            button3.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 20));
        }
    }

    @Override // android.preference.DialogPreference
    public void showDialog(Bundle state) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(Context context) {
        super(context);
        context.getClass();
    }
}
