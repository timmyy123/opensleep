package com.google.devtools.ksp.symbol;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/google/devtools/ksp/symbol/Variance;", "", "", "label", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "STAR", "INVARIANT", "COVARIANT", "CONTRAVARIANT", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Variance {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Variance[] $VALUES;
    private final String label;
    public static final Variance STAR = new Variance("STAR", 0, "*");
    public static final Variance INVARIANT = new Variance("INVARIANT", 1, "");
    public static final Variance COVARIANT = new Variance("COVARIANT", 2, "out");
    public static final Variance CONTRAVARIANT = new Variance("CONTRAVARIANT", 3, "in");

    private static final /* synthetic */ Variance[] $values() {
        return new Variance[]{STAR, INVARIANT, COVARIANT, CONTRAVARIANT};
    }

    static {
        Variance[] varianceArr$values = $values();
        $VALUES = varianceArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(varianceArr$values);
    }

    private Variance(String str, int i, String str2) {
        this.label = str2;
    }

    public static Variance valueOf(String str) {
        return (Variance) Enum.valueOf(Variance.class, str);
    }

    public static Variance[] values() {
        return (Variance[]) $VALUES.clone();
    }
}
