package com.urbandroid.sleep.gui.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H&J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0015\u001a\u00020\u0005H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "", "title", "", "iconRes", "", "<init>", "(Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getIconRes", "()I", "subtitle", "getSubtitle", "setSubtitle", "(Ljava/lang/String;)V", "onClick", "", "equals", "", "other", "hashCode", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DialogItem {
    private final int iconRes;
    private String subtitle;
    private final String title;

    public DialogItem(String str, int i) {
        str.getClass();
        this.title = str;
        this.iconRes = i;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogItem)) {
            return false;
        }
        DialogItem dialogItem = (DialogItem) other;
        return Intrinsics.areEqual(this.title, dialogItem.title) && this.iconRes == dialogItem.iconRes && Intrinsics.areEqual(this.subtitle, dialogItem.subtitle);
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((this.title.hashCode() * 31) + this.iconRes) * 31;
        String str = this.subtitle;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public abstract void onClick();

    public final void setSubtitle(String str) {
        this.subtitle = str;
    }
}
