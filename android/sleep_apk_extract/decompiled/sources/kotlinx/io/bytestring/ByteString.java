package kotlinx.io.bytestring;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000e¨\u0006\u001b"}, d2 = {"Lkotlinx/io/bytestring/ByteString;", "", "", "data", "", "dummy", "<init>", "([BLjava/lang/Object;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "compareTo", "(Lkotlinx/io/bytestring/ByteString;)I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "getBackingArrayReference", "()[B", "[B", "I", "getSize", "size", "Companion", "kotlinx-io-bytestring"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteString implements Comparable<ByteString> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ByteString EMPTY = new ByteString(new byte[0], null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final byte[] data;
    private int hashCode;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/io/bytestring/ByteString$Companion;", "", "<init>", "()V", "", "byteArray", "Lkotlinx/io/bytestring/ByteString;", "wrap$kotlinx_io_bytestring", "([B)Lkotlinx/io/bytestring/ByteString;", "wrap", "", "HEX_DIGITS", "[C", "kotlinx-io-bytestring"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ByteString wrap$kotlinx_io_bytestring(byte[] byteArray) {
            byteArray.getClass();
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new ByteString(byteArray, defaultConstructorMarker, defaultConstructorMarker);
        }

        private Companion() {
        }
    }

    private ByteString(byte[] bArr, Object obj) {
        this.data = bArr;
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString other) {
        other.getClass();
        if (other == this) {
            return 0;
        }
        byte[] bArr = this.data;
        byte[] bArr2 = other.data;
        int iMin = Math.min(getSize(), other.getSize());
        for (int i = 0; i < iMin; i++) {
            int iCompare = Intrinsics.compare(UByte.m2367constructorimpl(bArr[i]) & 255, UByte.m2367constructorimpl(bArr2[i]) & 255);
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Intrinsics.compare(getSize(), other.getSize());
    }

    public boolean equals(Object other) {
        int i;
        if (this == other) {
            return true;
        }
        if (other == null || ByteString.class != other.getClass()) {
            return false;
        }
        ByteString byteString = (ByteString) other;
        byte[] bArr = byteString.data;
        int length = bArr.length;
        byte[] bArr2 = this.data;
        if (length != bArr2.length) {
            return false;
        }
        int i2 = byteString.hashCode;
        if (i2 == 0 || (i = this.hashCode) == 0 || i2 == i) {
            return Arrays.equals(bArr2, bArr);
        }
        return false;
    }

    /* JADX INFO: renamed from: getBackingArrayReference, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    public final int getSize() {
        return this.data.length;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public String toString() {
        if (ByteStringKt.isEmpty(this)) {
            return "ByteString(size=0)";
        }
        String strValueOf = String.valueOf(getSize());
        StringBuilder sb = new StringBuilder((getSize() * 2) + strValueOf.length() + 22);
        sb.append("ByteString(size=");
        sb.append(strValueOf);
        sb.append(" hex=");
        byte[] bArr = this.data;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            byte b = bArr[i];
            char[] cArr = HEX_DIGITS;
            sb.append(cArr[(b >>> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ByteString(byte[] bArr, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, obj);
    }
}
