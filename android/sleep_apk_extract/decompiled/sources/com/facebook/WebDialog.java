package com.facebook;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/WebDialog;", "", "()V", "getWebDialogTheme", "", "setWebDialogTheme", "", "theme", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebDialog {
    public static final WebDialog INSTANCE = new WebDialog();

    private WebDialog() {
    }

    public static final int getWebDialogTheme() {
        return com.facebook.internal.WebDialog.INSTANCE.getWebDialogTheme();
    }

    public static final void setWebDialogTheme(int theme) {
        com.facebook.internal.WebDialog.INSTANCE.setWebDialogTheme(theme);
    }
}
