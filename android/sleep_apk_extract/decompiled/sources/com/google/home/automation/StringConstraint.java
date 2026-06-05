package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0015\u0018\u0000 %2\u00020\u0001:\u0001%BU\b\u0002\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eBA\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000fB!\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001f\u0010\u0016R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\n\u0010!R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/google/home/automation/StringConstraint;", "Lcom/google/home/automation/Constraint;", "", "", "allowedSet", "disallowedSet", "", "minLength", "maxLength", "", "isCaseSensitive", "Lkotlin/text/Regex;", "regex", "<init>", "(Ljava/util/Set;Ljava/util/Set;IIZLkotlin/text/Regex;)V", "(Ljava/util/Set;IIZLkotlin/text/Regex;)V", "(Ljava/util/Set;Z)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/Set;", "getAllowedSet", "()Ljava/util/Set;", "getDisallowedSet", "I", "getMinLength", "getMaxLength", "Z", "()Z", "Lkotlin/text/Regex;", "getRegex", "()Lkotlin/text/Regex;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StringConstraint implements Constraint {
    private final Set<String> allowedSet;
    private final Set<String> disallowedSet;
    private final boolean isCaseSensitive;
    private final int maxLength;
    private final int minLength;
    private final Regex regex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StringConstraint(Set<String> set, boolean z) {
        this(set, SetsKt.emptySet(), 0, 256, z, null);
        set.getClass();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StringConstraint)) {
            return false;
        }
        StringConstraint stringConstraint = (StringConstraint) other;
        return Intrinsics.areEqual(stringConstraint.allowedSet, this.allowedSet) && Intrinsics.areEqual(stringConstraint.disallowedSet, this.disallowedSet) && stringConstraint.minLength == this.minLength && stringConstraint.maxLength == this.maxLength && Intrinsics.areEqual(String.valueOf(stringConstraint.regex), String.valueOf(this.regex)) && stringConstraint.isCaseSensitive == this.isCaseSensitive;
    }

    public int hashCode() {
        Set<String> set = this.allowedSet;
        int iHashCode = Integer.hashCode(this.maxLength) + ((Integer.hashCode(this.minLength) + ((this.disallowedSet.hashCode() + ((set != null ? set.hashCode() : 0) * 31)) * 31)) * 31);
        Regex regex = this.regex;
        String string = regex != null ? regex.toString() : null;
        return Boolean.hashCode(this.isCaseSensitive) + zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, string != null ? string.hashCode() : 0, 31);
    }

    public String toString() {
        Set<String> set = this.allowedSet;
        int length = String.valueOf(set).length();
        Set<String> set2 = this.disallowedSet;
        int length2 = String.valueOf(set2).length();
        int i = this.minLength;
        int length3 = String.valueOf(i).length();
        int i2 = this.maxLength;
        int length4 = String.valueOf(i2).length();
        boolean z = this.isCaseSensitive;
        int length5 = String.valueOf(z).length();
        Regex regex = this.regex;
        StringBuilder sb = new StringBuilder(length + 44 + length2 + 12 + length3 + 12 + length4 + 18 + length5 + 8 + String.valueOf(regex).length() + 1);
        sb.append("StringConstraint(allowedSet=");
        sb.append(set);
        sb.append(", disallowedSet=");
        sb.append(set2);
        Fragment$$ExternalSyntheticOutline1.m(sb, ", minLength=", i, ", maxLength=", i2);
        sb.append(", isCaseSensitive=");
        sb.append(z);
        sb.append(", regex=");
        sb.append(regex);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StringConstraint(Set<String> set, int i, int i2, boolean z, Regex regex) {
        this(null, set, i, i2, z, regex);
        set.getClass();
    }

    private StringConstraint(Set<String> set, Set<String> set2, int i, int i2, boolean z, Regex regex) {
        this.allowedSet = set;
        this.disallowedSet = set2;
        this.minLength = i;
        this.maxLength = i2;
        this.isCaseSensitive = z;
        this.regex = regex;
    }
}
