package kotlinx.io.bytestring.unsafe;

import kotlin.Metadata;
import kotlinx.io.bytestring.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/io/bytestring/unsafe/UnsafeByteStringOperations;", "", "<init>", "()V", "", "array", "Lkotlinx/io/bytestring/ByteString;", "wrapUnsafe", "([B)Lkotlinx/io/bytestring/ByteString;", "kotlinx-io-bytestring"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnsafeByteStringOperations {
    public static final UnsafeByteStringOperations INSTANCE = new UnsafeByteStringOperations();

    private UnsafeByteStringOperations() {
    }

    public final ByteString wrapUnsafe(byte[] array) {
        array.getClass();
        return ByteString.INSTANCE.wrap$kotlinx_io_bytestring(array);
    }
}
