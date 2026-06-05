package kotlinx.io;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.io.EOFException;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006\u001a-\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/io/Source;", "", "readByteArray", "(Lkotlinx/io/Source;)[B", "", "byteCount", "(Lkotlinx/io/Source;I)[B", "size", "readByteArrayImpl", "sink", "startIndex", "endIndex", "", "readTo", "(Lkotlinx/io/Source;[BII)V", "kotlinx-io-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class SourcesKt {
    public static final byte[] readByteArray(Source source, int i) {
        source.getClass();
        long j = i;
        if (j >= 0) {
            return readByteArrayImpl(source, i);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m("byteCount (", ") < 0", j));
        return null;
    }

    private static final byte[] readByteArrayImpl(Source source, int i) throws EOFException {
        if (i == -1) {
            for (long j = 2147483647L; source.getBufferField().getSizeMut() < 2147483647L && source.request(j); j *= 2) {
            }
            if (source.getBufferField().getSizeMut() >= 2147483647L) {
                throw new IllegalStateException(("Can't create an array of size " + source.getBufferField().getSizeMut()).toString());
            }
            i = (int) source.getBufferField().getSizeMut();
        } else {
            source.require(i);
        }
        byte[] bArr = new byte[i];
        readTo$default(source.getBufferField(), bArr, 0, 0, 6, null);
        return bArr;
    }

    public static final void readTo(Source source, byte[] bArr, int i, int i2) throws EOFException {
        source.getClass();
        bArr.getClass();
        _UtilKt.checkBounds(bArr.length, i, i2);
        int i3 = i;
        while (i3 < i2) {
            int atMostTo = source.readAtMostTo(bArr, i3, i2);
            if (atMostTo == -1) {
                throw new EOFException("Source exhausted before reading " + (i2 - i) + " bytes. Only " + atMostTo + " bytes were read.");
            }
            i3 += atMostTo;
        }
    }

    public static /* synthetic */ void readTo$default(Source source, byte[] bArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        readTo(source, bArr, i, i2);
    }

    public static final byte[] readByteArray(Source source) {
        source.getClass();
        return readByteArrayImpl(source, -1);
    }
}
