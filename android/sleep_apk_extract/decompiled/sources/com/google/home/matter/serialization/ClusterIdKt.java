package com.google.home.matter.serialization;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"hex4", "", "Lkotlin/UShort;", "hex4-xj2QHRw", "(S)Ljava/lang/String;", "hex8", "Lkotlin/UInt;", "hex8-WZ4Q5Ns", "(I)Ljava/lang/String;", "java.com.google.home.matter.serialization_serialization-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ClusterIdKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hex4-xj2QHRw, reason: not valid java name */
    public static final String m533hex4xj2QHRw(short s) {
        String lowerCase = UStringsKt.m2522toStringolVBNx4(s, 16).toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return StringsKt__StringsKt.padStart(lowerCase, 4, '0');
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hex8-WZ4Q5Ns, reason: not valid java name */
    public static final String m534hex8WZ4Q5Ns(int i) {
        String lowerCase = UStringsKt.m2521toStringV7xB4Y4(i, 16).toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return StringsKt__StringsKt.padStart(lowerCase, 8, '0');
    }
}
