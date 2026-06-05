package com.urbandroid.sleep.gui.dialog;

import android.app.Activity;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.util.intent.ViewIntent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/ViewDialogItem;", "Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "title", "", "iconRes", "link", "<init>", "(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;)V", "", "onClick", "()V", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "Ljava/lang/String;", "getLink", "()Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ViewDialogItem extends DialogItem {
    private final Activity context;
    private final String link;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewDialogItem(Activity activity, String str, int i, String str2) {
        super(str, i);
        activity.getClass();
        str.getClass();
        str2.getClass();
        this.context = activity;
        this.link = str2;
    }

    @Override // com.urbandroid.sleep.gui.dialog.DialogItem
    public void onClick() {
        ViewIntent.urlCustomTab(this.context, this.link);
    }
}
