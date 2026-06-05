package kotlinx.io;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.EOFException;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\n\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\n\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0001H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000fH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00105\u001a\u00020\u00068VX\u0097\u0004¢\u0006\f\u0012\u0004\b4\u0010'\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lkotlinx/io/RealSource;", "Lkotlinx/io/Source;", "Lkotlinx/io/RawSource;", ShareConstants.FEED_SOURCE_PARAM, "<init>", "(Lkotlinx/io/RawSource;)V", "Lkotlinx/io/Buffer;", "sink", "", "byteCount", "readAtMostTo", "(Lkotlinx/io/Buffer;J)J", "", "exhausted", "()Z", "", "require", "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "", "startIndex", "endIndex", "([BII)I", "Lkotlinx/io/RawSink;", "readTo", "(Lkotlinx/io/RawSink;J)V", "transferTo", "(Lkotlinx/io/RawSink;)J", "", "readShort", "()S", "peek", "()Lkotlinx/io/Source;", "close", "()V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlinx/io/RawSource;", "getSource", "()Lkotlinx/io/RawSource;", "closed", "Z", "bufferField", "Lkotlinx/io/Buffer;", "getBuffer", "()Lkotlinx/io/Buffer;", "getBuffer$annotations", "buffer", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealSource implements Source {
    private final Buffer bufferField;
    public boolean closed;
    private final RawSource source;

    public RealSource(RawSource rawSource) {
        rawSource.getClass();
        this.source = rawSource;
        this.bufferField = new Buffer();
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable, kotlinx.io.RawSink
    public void close() throws EOFException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override // kotlinx.io.Source
    public boolean exhausted() {
        if (!this.closed) {
            return this.bufferField.exhausted() && this.source.readAtMostTo(this.bufferField, 8192L) == -1;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Source is closed.");
        return false;
    }

    @Override // kotlinx.io.Source, kotlinx.io.Sink
    /* JADX INFO: renamed from: getBuffer, reason: from getter */
    public Buffer getBufferField() {
        return this.bufferField;
    }

    @Override // kotlinx.io.Source
    public Source peek() {
        if (!this.closed) {
            return CoreKt.buffered(new PeekSource(this));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Source is closed.");
        return null;
    }

    @Override // kotlinx.io.RawSource
    public long readAtMostTo(Buffer sink, long byteCount) {
        sink.getClass();
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Source is closed.");
            return 0L;
        }
        if (byteCount < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m(byteCount, "byteCount: "));
            return 0L;
        }
        if (this.bufferField.getSizeMut() == 0 && this.source.readAtMostTo(this.bufferField, 8192L) == -1) {
            return -1L;
        }
        return this.bufferField.readAtMostTo(sink, Math.min(byteCount, this.bufferField.getSizeMut()));
    }

    @Override // kotlinx.io.Source
    public byte readByte() throws EOFException {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // kotlinx.io.Source
    public short readShort() throws EOFException {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // kotlinx.io.Source
    public void readTo(RawSink sink, long byteCount) throws EOFException {
        sink.getClass();
        try {
            require(byteCount);
            this.bufferField.readTo(sink, byteCount);
        } catch (EOFException e) {
            sink.write(this.bufferField, this.bufferField.getSizeMut());
            throw e;
        }
    }

    @Override // kotlinx.io.Source
    public boolean request(long byteCount) {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Source is closed.");
            return false;
        }
        if (byteCount < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m(byteCount, "byteCount: "));
            return false;
        }
        while (this.bufferField.getSizeMut() < byteCount) {
            if (this.source.readAtMostTo(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.io.Source
    public void require(long byteCount) throws EOFException {
        if (!request(byteCount)) {
            throw new EOFException(zzba$$ExternalSyntheticOutline0.m("Source doesn't contain required number of bytes (", ").", byteCount));
        }
    }

    public String toString() {
        return "buffered(" + this.source + ')';
    }

    @Override // kotlinx.io.Source
    public long transferTo(RawSink sink) {
        Buffer buffer;
        sink.getClass();
        long j = 0;
        while (true) {
            long atMostTo = this.source.readAtMostTo(this.bufferField, 8192L);
            buffer = this.bufferField;
            if (atMostTo == -1) {
                break;
            }
            long jCompleteSegmentByteCount$kotlinx_io_core = buffer.completeSegmentByteCount$kotlinx_io_core();
            if (jCompleteSegmentByteCount$kotlinx_io_core > 0) {
                j += jCompleteSegmentByteCount$kotlinx_io_core;
                sink.write(this.bufferField, jCompleteSegmentByteCount$kotlinx_io_core);
            }
        }
        if (buffer.getSizeMut() <= 0) {
            return j;
        }
        long sizeMut = this.bufferField.getSizeMut() + j;
        Buffer buffer2 = this.bufferField;
        sink.write(buffer2, buffer2.getSizeMut());
        return sizeMut;
    }

    @Override // kotlinx.io.Source
    public int readAtMostTo(byte[] sink, int startIndex, int endIndex) {
        sink.getClass();
        _UtilKt.checkBounds(sink.length, startIndex, endIndex);
        if (this.bufferField.getSizeMut() == 0 && this.source.readAtMostTo(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.readAtMostTo(sink, startIndex, ((int) Math.min(endIndex - startIndex, this.bufferField.getSizeMut())) + startIndex);
    }
}
