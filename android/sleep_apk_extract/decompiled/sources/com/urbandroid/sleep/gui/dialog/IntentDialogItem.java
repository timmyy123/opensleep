package com.urbandroid.sleep.gui.dialog;

import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/IntentDialogItem;", "Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "title", "", "iconRes", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "<init>", "(Landroid/content/Context;Ljava/lang/String;ILandroid/content/Intent;)V", "", "onClick", "()V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IntentDialogItem extends DialogItem {
    private final Context context;
    private final Intent intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntentDialogItem(Context context, String str, int i, Intent intent) {
        super(str, i);
        context.getClass();
        str.getClass();
        intent.getClass();
        this.context = context;
        this.intent = intent;
    }

    @Override // com.urbandroid.sleep.gui.dialog.DialogItem
    public void onClick() {
        this.context.startActivity(this.intent);
    }
}
