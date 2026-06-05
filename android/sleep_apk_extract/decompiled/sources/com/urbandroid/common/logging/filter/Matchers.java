package com.urbandroid.common.logging.filter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"regex", "Lcom/urbandroid/common/logging/filter/Matcher;", "rgx", "", "startsWith", "prefix", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class Matchers {
    public static final Matcher regex(String str) {
        str.getClass();
        return new Regex(str);
    }

    public static final Matcher startsWith(String str) {
        str.getClass();
        return new StartsWith(str);
    }
}
