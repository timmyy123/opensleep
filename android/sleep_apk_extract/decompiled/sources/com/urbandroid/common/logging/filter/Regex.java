package com.urbandroid.common.logging.filter;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/common/logging/filter/Regex;", "Lcom/urbandroid/common/logging/filter/Matcher;", "", "rgx", "<init>", "(Ljava/lang/String;)V", "s", "", "matches", "(Ljava/lang/String;)Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRgx", "Ljava/util/regex/Pattern;", "regex", "Ljava/util/regex/Pattern;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final /* data */ class Regex implements Matcher {
    private final Pattern regex;
    private final String rgx;

    public Regex(String str) {
        str.getClass();
        this.rgx = str;
        Pattern patternCompile = Pattern.compile(str);
        patternCompile.getClass();
        this.regex = patternCompile;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Regex) && Intrinsics.areEqual(this.rgx, ((Regex) other).rgx);
    }

    public int hashCode() {
        return this.rgx.hashCode();
    }

    @Override // com.urbandroid.common.logging.filter.Matcher
    public boolean matches(String s) {
        if (s == null) {
            return false;
        }
        return this.regex.matcher(s).matches();
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Regex(rgx="), this.rgx, ')');
    }
}
