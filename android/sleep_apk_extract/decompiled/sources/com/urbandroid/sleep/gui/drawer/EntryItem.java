package com.urbandroid.sleep.gui.drawer;

/* JADX INFO: loaded from: classes.dex */
public abstract class EntryItem {
    public int icon;
    public String title;

    public EntryItem(String str, int i) {
        this.title = str;
        this.icon = i;
    }

    public abstract void onClick();
}
