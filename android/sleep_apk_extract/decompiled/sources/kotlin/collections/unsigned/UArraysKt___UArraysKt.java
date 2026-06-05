package kotlin.collections.unsigned;

import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0005\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0087\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a \u0010\u0005\u001a\u00020\u0002*\u0004\u0018\u00010\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0087\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a \u0010\u0005\u001a\u00020\u0002*\u0004\u0018\u00010\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\tH\u0087\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a \u0010\u0005\u001a\u00020\u0002*\u0004\u0018\u00010\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0087\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/UIntArray;", "other", "", "contentEquals-KJPZfPQ", "([I[I)Z", "contentEquals", "Lkotlin/ULongArray;", "contentEquals-lec5QzE", "([J[J)Z", "Lkotlin/UByteArray;", "contentEquals-kV0jMPg", "([B[B)Z", "Lkotlin/UShortArray;", "contentEquals-FGO6Aew", "([S[S)Z", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
public abstract class UArraysKt___UArraysKt extends UArraysKt___UArraysJvmKt {
    /* JADX INFO: renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m2461contentEqualsFGO6Aew(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    /* JADX INFO: renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m2462contentEqualsKJPZfPQ(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    /* JADX INFO: renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m2463contentEqualskV0jMPg(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    /* JADX INFO: renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m2464contentEqualslec5QzE(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }
}
