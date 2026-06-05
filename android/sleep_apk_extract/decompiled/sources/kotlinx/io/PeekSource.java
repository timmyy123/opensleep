package kotlinx.io;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lkotlinx/io/PeekSource;", "Lkotlinx/io/RawSource;", "Lkotlinx/io/Source;", "upstream", "<init>", "(Lkotlinx/io/Source;)V", "Lkotlinx/io/Buffer;", "sink", "", "byteCount", "readAtMostTo", "(Lkotlinx/io/Buffer;J)J", "", "close", "()V", "Lkotlinx/io/Source;", "buffer", "Lkotlinx/io/Buffer;", "getBuffer$annotations", "Lkotlinx/io/Segment;", "expectedSegment", "Lkotlinx/io/Segment;", "", "expectedPos", "I", "", "closed", "Z", "pos", "J", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PeekSource implements RawSource {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final Source upstream;

    public PeekSource(Source source) {
        source.getClass();
        this.upstream = source;
        Buffer buffer = source.getBufferField();
        this.buffer = buffer;
        this.expectedSegment = buffer.getHead();
        Segment head = buffer.getHead();
        this.expectedPos = head != null ? head.getPos() : -1;
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable, kotlinx.io.RawSink
    public void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r3 == r4.getPos()) goto L16;
     */
    @Override // kotlinx.io.RawSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readAtMostTo(Buffer sink, long byteCount) {
        sink.getClass();
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Source is closed.");
            return 0L;
        }
        if (byteCount < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m("byteCount (", ") < 0", byteCount));
            return 0L;
        }
        Segment segment = this.expectedSegment;
        if (segment != null) {
            if (segment == this.buffer.getHead()) {
                int i = this.expectedPos;
                Segment head = this.buffer.getHead();
                head.getClass();
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Peek source is invalid because upstream source was used");
            return 0L;
        }
        if (byteCount == 0) {
            return 0L;
        }
        if (!this.upstream.request(this.pos + 1)) {
            return -1L;
        }
        if (this.expectedSegment == null && this.buffer.getHead() != null) {
            this.expectedSegment = this.buffer.getHead();
            Segment head2 = this.buffer.getHead();
            head2.getClass();
            this.expectedPos = head2.getPos();
        }
        long jMin = Math.min(byteCount, this.buffer.getSizeMut() - this.pos);
        Buffer buffer = this.buffer;
        long j = this.pos;
        buffer.copyTo(sink, j, j + jMin);
        this.pos += jMin;
        return jMin;
    }
}
