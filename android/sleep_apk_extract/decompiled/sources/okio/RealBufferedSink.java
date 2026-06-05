package okio;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import java.nio.ByteBuffer;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u0017\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u000b\u0010\u0019J'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000b\u0010\u001bJ\u0017\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u000b\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0014H\u0016¢\u0006\u0004\b%\u0010#J\u0017\u0010'\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0014H\u0016¢\u0006\u0004\b'\u0010#J\u0017\u0010)\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0001H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0001H\u0016¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020\nH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\nH\u0016¢\u0006\u0004\b3\u0010/J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0010H\u0016¢\u0006\u0004\b7\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u00109R\u0014\u0010:\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010A\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b@\u0010/\u001a\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "Lokio/Buffer;", ShareConstants.FEED_SOURCE_PARAM, "", "byteCount", "", "write", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "(Lokio/ByteString;)Lokio/BufferedSink;", "", "string", "writeUtf8", "(Ljava/lang/String;)Lokio/BufferedSink;", "", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/BufferedSink;", "", "([B)Lokio/BufferedSink;", SpotifyService.OFFSET, "([BII)Lokio/BufferedSink;", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "Lokio/Source;", "writeAll", "(Lokio/Source;)J", "b", "writeByte", "(I)Lokio/BufferedSink;", "s", "writeShort", "i", "writeInt", "v", "writeHexadecimalUnsignedLong", "(J)Lokio/BufferedSink;", "emitCompleteSegments", "()Lokio/BufferedSink;", "emit", "flush", "()V", "", "isOpen", "()Z", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lokio/Sink;", "bufferField", "Lokio/Buffer;", "closed", "Z", "getBuffer", "()Lokio/Buffer;", "getBuffer$annotations", "buffer", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        sink.getClass();
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        try {
            if (this.bufferField.getSize() > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.getSize());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return null;
        }
        long size = this.bufferField.getSize();
        if (size > 0) {
            this.sink.write(this.bufferField, size);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return null;
        }
        long jCompleteSegmentByteCount = this.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.bufferField, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return;
        }
        if (this.bufferField.getSize() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.getSize());
        }
        this.sink.flush();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: getBuffer, reason: from getter */
    public Buffer getBufferField() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: timeout */
    public Timeout getThis$0() {
        return this.sink.getThis$0();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        source.getClass();
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return 0;
        }
        int iWrite = this.bufferField.write(source);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) {
        source.getClass();
        long j = 0;
        while (true) {
            long j2 = source.read(this.bufferField, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int b) {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return null;
        }
        this.bufferField.writeByte(b);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long v) {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return null;
        }
        this.bufferField.writeHexadecimalUnsignedLong(v);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i) {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return null;
        }
        this.bufferField.writeInt(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int s) {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return null;
        }
        this.bufferField.writeShort(s);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String string) {
        string.getClass();
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return null;
        }
        this.bufferField.writeUtf8(string);
        return emitCompleteSegments();
    }

    @Override // okio.Sink
    public void write(Buffer source, long byteCount) {
        source.getClass();
        if (!this.closed) {
            this.bufferField.write(source, byteCount);
            emitCompleteSegments();
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String string, int beginIndex, int endIndex) {
        string.getClass();
        if (!this.closed) {
            this.bufferField.writeUtf8(string, beginIndex, endIndex);
            return emitCompleteSegments();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
        return null;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString byteString) {
        byteString.getClass();
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
        return null;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] source) {
        source.getClass();
        if (!this.closed) {
            this.bufferField.write(source);
            return emitCompleteSegments();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
        return null;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] source, int offset, int byteCount) {
        source.getClass();
        if (!this.closed) {
            this.bufferField.write(source, offset, byteCount);
            return emitCompleteSegments();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
        return null;
    }
}
