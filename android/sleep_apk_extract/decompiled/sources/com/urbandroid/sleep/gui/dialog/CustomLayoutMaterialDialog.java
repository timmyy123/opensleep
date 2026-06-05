package com.urbandroid.sleep.gui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/CustomLayoutMaterialDialog;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class CustomLayoutMaterialDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/CustomLayoutMaterialDialog$Companion;", "", "<init>", "()V", "builder", "Lcom/google/android/material/dialog/MaterialAlertDialogBuilder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "title", "", "layout", "", "message", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MaterialAlertDialogBuilder builder(Context context, String title, int layout, String message) {
            TextView textView;
            context.getClass();
            title.getClass();
            View viewInflate = InflatorUtil.INSTANCE.get(context).inflate(R.layout.dialog_success_anim, (ViewGroup) null, false);
            viewInflate.getClass();
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            if (message != null && (textView = (TextView) viewGroup.findViewById(R.id.message)) != null) {
                textView.setText(message);
            }
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
            materialAlertDialogBuilder.setTitle((CharSequence) title);
            materialAlertDialogBuilder.setView((View) viewGroup);
            materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null);
            return materialAlertDialogBuilder;
        }

        private Companion() {
        }
    }
}
