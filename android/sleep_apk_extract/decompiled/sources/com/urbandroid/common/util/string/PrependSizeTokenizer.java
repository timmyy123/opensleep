package com.urbandroid.common.util.string;

/* JADX INFO: loaded from: classes5.dex */
public class PrependSizeTokenizer {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private String f58data;

    public PrependSizeTokenizer(String str) {
        this.f58data = str;
    }

    public boolean hasToken() {
        String str = this.f58data;
        return str != null && str.length() >= 4;
    }

    public String nextToken() {
        if (!hasToken()) {
            return null;
        }
        int i = Integer.parseInt(this.f58data.substring(0, 4), 16) + 4;
        String strSubstring = this.f58data.substring(4, i);
        this.f58data = this.f58data.substring(i);
        return strSubstring;
    }
}
