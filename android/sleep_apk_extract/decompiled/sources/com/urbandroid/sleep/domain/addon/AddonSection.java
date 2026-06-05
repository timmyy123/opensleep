package com.urbandroid.sleep.domain.addon;

/* JADX INFO: loaded from: classes4.dex */
public class AddonSection implements AddonItem {
    private String title;

    public AddonSection(String str) {
        this.title = str;
    }

    @Override // com.urbandroid.sleep.domain.addon.AddonItem
    public String getTitle() {
        return this.title;
    }
}
