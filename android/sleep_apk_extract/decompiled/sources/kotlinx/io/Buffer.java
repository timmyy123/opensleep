package kotlinx.io;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.EOFException;
import kotlin.Metadata;
import kotlinx.io.unsafe.SegmentReadContext;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import kotlinx.io.unsafe.UnsafeBufferOperationsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.boxes.iso14496.part12.FreeSpaceBox;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0019\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0017¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0004J)\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\n¢\u0006\u0004\b\"\u0010\u0004J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\fJ'\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010)J\u001f\u0010+\u001a\u00020\n2\u0006\u0010%\u001a\u00020*2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\b2\u0006\u0010%\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0001H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u00020&H\u0001¢\u0006\u0004\b3\u00104J'\u00106\u001a\u00020\n2\u0006\u00105\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020&H\u0016¢\u0006\u0004\b6\u00107J\u001f\u00106\u001a\u00020\n2\u0006\u00105\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b6\u00108J\u0017\u0010:\u001a\u00020\b2\u0006\u00105\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u000fH\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0012H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\nH\u0016¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020\nH\u0000¢\u0006\u0004\bF\u0010\u0004J\u000f\u0010H\u001a\u00020\nH\u0001¢\u0006\u0004\bH\u0010\u0004J\u0017\u0010J\u001a\u00020I2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\bJ\u0010KR*\u0010L\u001a\u0004\u0018\u0001028\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bL\u0010M\u0012\u0004\bR\u0010\u0004\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR*\u0010S\u001a\u0004\u0018\u0001028\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bS\u0010M\u0012\u0004\bV\u0010\u0004\u001a\u0004\bT\u0010O\"\u0004\bU\u0010QR(\u0010W\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bW\u0010X\u0012\u0004\b[\u0010\u0004\u001a\u0004\bY\u0010\u001d\"\u0004\bZ\u0010\fR\u0011\u0010]\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\\\u0010\u001dR\u001a\u0010a\u001a\u00020\u00008VX\u0097\u0004¢\u0006\f\u0012\u0004\b`\u0010\u0004\u001a\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lkotlinx/io/Buffer;", "Lkotlinx/io/Source;", "Lkotlinx/io/Sink;", "<init>", "()V", "", "exhausted", "()Z", "", "byteCount", "", "require", "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "hintEmit", "flush", "out", "startIndex", "endIndex", "copyTo", "(Lkotlinx/io/Buffer;JJ)V", "completeSegmentByteCount$kotlinx_io_core", "()J", "completeSegmentByteCount", "position", "get", "(J)B", "clear", FreeSpaceBox.TYPE, "", "sink", "", "readAtMostTo", "([BII)I", "(Lkotlinx/io/Buffer;J)J", "Lkotlinx/io/RawSink;", "readTo", "(Lkotlinx/io/RawSink;J)V", "transferTo", "(Lkotlinx/io/RawSink;)J", "peek", "()Lkotlinx/io/Source;", "minimumCapacity", "Lkotlinx/io/Segment;", "writableSegment", "(I)Lkotlinx/io/Segment;", ShareConstants.FEED_SOURCE_PARAM, "write", "([BII)V", "(Lkotlinx/io/Buffer;J)V", "Lkotlinx/io/RawSource;", "transferFrom", "(Lkotlinx/io/RawSource;)J", "byte", "writeByte", "(B)V", "short", "writeShort", "(S)V", "close", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "recycleHead$kotlinx_io_core", "recycleHead", "recycleTail", "", "throwEof", "(J)Ljava/lang/Void;", "head", "Lkotlinx/io/Segment;", "getHead", "()Lkotlinx/io/Segment;", "setHead", "(Lkotlinx/io/Segment;)V", "getHead$annotations", "tail", "getTail", "setTail", "getTail$annotations", "sizeMut", "J", "getSizeMut", "setSizeMut", "getSizeMut$annotations", "getSize", "size", "getBuffer", "()Lkotlinx/io/Buffer;", "getBuffer$annotations", "buffer", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Buffer implements Source, Sink {
    private Segment head;
    private long sizeMut;
    private Segment tail;

    private final Void throwEof(long byteCount) throws EOFException {
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + getSizeMut() + ", required: " + byteCount + ')');
    }

    public final void clear() throws EOFException {
        skip(getSizeMut());
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable, kotlinx.io.RawSink
    public void close() {
    }

    public final long completeSegmentByteCount$kotlinx_io_core() {
        long sizeMut = getSizeMut();
        if (sizeMut == 0) {
            return 0L;
        }
        Segment segment = this.tail;
        segment.getClass();
        return (segment.getLimit() >= 8192 || !segment.owner) ? sizeMut : sizeMut - ((long) (segment.getLimit() - segment.getPos()));
    }

    public final void copyTo(Buffer out, long startIndex, long endIndex) {
        out.getClass();
        _UtilKt.checkBounds(getSizeMut(), startIndex, endIndex);
        if (startIndex == endIndex) {
            return;
        }
        long limit = endIndex - startIndex;
        out.sizeMut += limit;
        Segment next = this.head;
        long limit2 = startIndex;
        while (true) {
            next.getClass();
            if (limit2 < next.getLimit() - next.getPos()) {
                break;
            }
            limit2 -= (long) (next.getLimit() - next.getPos());
            next = next.getNext();
        }
        while (limit > 0) {
            next.getClass();
            Segment segmentSharedCopy$kotlinx_io_core = next.sharedCopy$kotlinx_io_core();
            segmentSharedCopy$kotlinx_io_core.setPos(segmentSharedCopy$kotlinx_io_core.getPos() + ((int) limit2));
            segmentSharedCopy$kotlinx_io_core.setLimit(Math.min(segmentSharedCopy$kotlinx_io_core.getPos() + ((int) limit), segmentSharedCopy$kotlinx_io_core.getLimit()));
            if (out.getHead() == null) {
                out.setHead(segmentSharedCopy$kotlinx_io_core);
                out.setTail(segmentSharedCopy$kotlinx_io_core);
            } else {
                Segment tail = out.getTail();
                tail.getClass();
                out.setTail(tail.push$kotlinx_io_core(segmentSharedCopy$kotlinx_io_core));
            }
            limit -= (long) (segmentSharedCopy$kotlinx_io_core.getLimit() - segmentSharedCopy$kotlinx_io_core.getPos());
            next = next.getNext();
            limit2 = 0;
        }
    }

    @Override // kotlinx.io.Source
    public boolean exhausted() {
        return getSizeMut() == 0;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public final byte get(long position) {
        long j = 0;
        if (position < 0 || position >= getSizeMut()) {
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("position (", ") is not within the range [0..size(", position);
            sbM.append(getSizeMut());
            sbM.append("))");
            throw new IndexOutOfBoundsException(sbM.toString());
        }
        if (position == 0) {
            Segment segment = this.head;
            segment.getClass();
            return segment.getUnchecked$kotlinx_io_core(0);
        }
        getHead().getClass();
        if (getSizeMut() - position >= position) {
            Segment head = getHead();
            while (head != null) {
                long limit = ((long) (head.getLimit() - head.getPos())) + j;
                if (limit > position) {
                    break;
                }
                head = head.getNext();
                j = limit;
            }
            head.getClass();
            return head.getUnchecked$kotlinx_io_core((int) (position - j));
        }
        Segment tail = getTail();
        long sizeMut = getSizeMut();
        while (tail != null && sizeMut > position) {
            sizeMut -= (long) (tail.getLimit() - tail.getPos());
            if (sizeMut <= position) {
                break;
            }
            tail = tail.getPrev();
        }
        tail.getClass();
        return tail.getUnchecked$kotlinx_io_core((int) (position - sizeMut));
    }

    @Override // kotlinx.io.Source, kotlinx.io.Sink
    public Buffer getBuffer() {
        return this;
    }

    public final /* synthetic */ Segment getHead() {
        return this.head;
    }

    /* JADX INFO: renamed from: getSize, reason: from getter */
    public final long getSizeMut() {
        return this.sizeMut;
    }

    public final /* synthetic */ long getSizeMut() {
        return this.sizeMut;
    }

    public final /* synthetic */ Segment getTail() {
        return this.tail;
    }

    @Override // kotlinx.io.Sink
    public void hintEmit() {
    }

    @Override // kotlinx.io.Source
    public Source peek() {
        return CoreKt.buffered(new PeekSource(this));
    }

    @Override // kotlinx.io.RawSource
    public long readAtMostTo(Buffer sink, long byteCount) {
        sink.getClass();
        if (byteCount < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m("byteCount (", ") < 0", byteCount));
            return 0L;
        }
        if (getSizeMut() == 0) {
            return -1L;
        }
        if (byteCount > getSizeMut()) {
            byteCount = getSizeMut();
        }
        sink.write(this, byteCount);
        return byteCount;
    }

    @Override // kotlinx.io.Source
    public byte readByte() throws EOFException {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(1L);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return (byte) 0;
        }
        int size = segment.getSize();
        if (size == 0) {
            recycleHead$kotlinx_io_core();
            return readByte();
        }
        byte byte$kotlinx_io_core = segment.readByte$kotlinx_io_core();
        this.sizeMut--;
        if (size == 1) {
            recycleHead$kotlinx_io_core();
        }
        return byte$kotlinx_io_core;
    }

    @Override // kotlinx.io.Source
    public short readShort() throws EOFException {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(2L);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return (short) 0;
        }
        int size = segment.getSize();
        if (size >= 2) {
            short short$kotlinx_io_core = segment.readShort$kotlinx_io_core();
            this.sizeMut -= 2;
            if (size == 2) {
                recycleHead$kotlinx_io_core();
            }
            return short$kotlinx_io_core;
        }
        require(2L);
        if (size == 0) {
            recycleHead$kotlinx_io_core();
            return readShort();
        }
        return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
    }

    @Override // kotlinx.io.Source
    public void readTo(RawSink sink, long byteCount) throws EOFException {
        sink.getClass();
        if (byteCount < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m("byteCount (", ") < 0", byteCount));
            return;
        }
        if (getSizeMut() >= byteCount) {
            sink.write(this, byteCount);
            return;
        }
        sink.write(this, getSizeMut());
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Buffer exhausted before writing ", " bytes. Only ", byteCount);
        sbM.append(getSizeMut());
        sbM.append(" bytes were written.");
        throw new EOFException(sbM.toString());
    }

    public final void recycleHead$kotlinx_io_core() {
        Segment segment = this.head;
        segment.getClass();
        Segment next = segment.getNext();
        this.head = next;
        if (next == null) {
            this.tail = null;
        } else {
            next.setPrev(null);
        }
        segment.setNext(null);
        SegmentPool.recycle(segment);
    }

    public final /* synthetic */ void recycleTail() {
        Segment segment = this.tail;
        segment.getClass();
        Segment prev = segment.getPrev();
        this.tail = prev;
        if (prev == null) {
            this.head = null;
        } else {
            prev.setNext(null);
        }
        segment.setPrev(null);
        SegmentPool.recycle(segment);
    }

    @Override // kotlinx.io.Source
    public boolean request(long byteCount) {
        if (byteCount >= 0) {
            return getSizeMut() >= byteCount;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m("byteCount: ", " < 0", byteCount));
        return false;
    }

    @Override // kotlinx.io.Source
    public void require(long byteCount) throws EOFException {
        if (byteCount < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m(byteCount, "byteCount: "));
            return;
        }
        if (getSizeMut() >= byteCount) {
            return;
        }
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + getSizeMut() + ", required: " + byteCount + ')');
    }

    public final /* synthetic */ void setHead(Segment segment) {
        this.head = segment;
    }

    public final /* synthetic */ void setSizeMut(long j) {
        this.sizeMut = j;
    }

    public final /* synthetic */ void setTail(Segment segment) {
        this.tail = segment;
    }

    public void skip(long byteCount) throws EOFException {
        if (byteCount < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m("byteCount (", ") < 0", byteCount));
            return;
        }
        long j = byteCount;
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException(zzba$$ExternalSyntheticOutline0.m("Buffer exhausted before skipping ", " bytes.", byteCount));
            }
            int iMin = (int) Math.min(j, segment.getLimit() - segment.getPos());
            long j2 = iMin;
            this.sizeMut -= j2;
            j -= j2;
            segment.setPos(segment.getPos() + iMin);
            if (segment.getPos() == segment.getLimit()) {
                recycleHead$kotlinx_io_core();
            }
        }
    }

    public String toString() {
        if (getSizeMut() == 0) {
            return "Buffer(size=0)";
        }
        int iMin = (int) Math.min(64L, getSizeMut());
        StringBuilder sb = new StringBuilder((iMin * 2) + (getSizeMut() > 64 ? 1 : 0));
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        int i = 0;
        for (Segment head = getHead(); head != null; head = head.getNext()) {
            SegmentReadContext segmentReadContext = UnsafeBufferOperationsKt.SegmentReadContextImpl;
            int i2 = 0;
            while (i < iMin && i2 < head.getSize()) {
                int i3 = i2 + 1;
                byte unchecked = segmentReadContext.getUnchecked(head, i2);
                i++;
                sb.append(_UtilKt.getHEX_DIGIT_CHARS()[(unchecked >> 4) & 15]);
                sb.append(_UtilKt.getHEX_DIGIT_CHARS()[unchecked & 15]);
                i2 = i3;
            }
        }
        if (getSizeMut() > 64) {
            sb.append((char) 8230);
        }
        return "Buffer(size=" + getSizeMut() + " hex=" + ((Object) sb) + ')';
    }

    @Override // kotlinx.io.Sink
    public long transferFrom(RawSource source) {
        source.getClass();
        long j = 0;
        while (true) {
            long atMostTo = source.readAtMostTo(this, 8192L);
            if (atMostTo == -1) {
                return j;
            }
            j += atMostTo;
        }
    }

    @Override // kotlinx.io.Source
    public long transferTo(RawSink sink) {
        sink.getClass();
        long sizeMut = getSizeMut();
        if (sizeMut > 0) {
            sink.write(this, sizeMut);
        }
        return sizeMut;
    }

    public final /* synthetic */ Segment writableSegment(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("unexpected capacity");
            return null;
        }
        Segment segment = this.tail;
        if (segment == null) {
            Segment segmentTake = SegmentPool.take();
            this.head = segmentTake;
            this.tail = segmentTake;
            return segmentTake;
        }
        segment.getClass();
        if (segment.getLimit() + minimumCapacity <= 8192 && segment.owner) {
            return segment;
        }
        Segment segmentPush$kotlinx_io_core = segment.push$kotlinx_io_core(SegmentPool.take());
        this.tail = segmentPush$kotlinx_io_core;
        return segmentPush$kotlinx_io_core;
    }

    @Override // kotlinx.io.RawSink
    public void write(Buffer source, long byteCount) {
        source.getClass();
        if (source == this) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("source == this");
            return;
        }
        _UtilKt.checkOffsetAndCount(source.sizeMut, 0L, byteCount);
        while (byteCount > 0) {
            source.head.getClass();
            if (byteCount < r0.getSize()) {
                Segment segment = this.tail;
                if (segment != null && segment.owner) {
                    if ((((long) segment.getLimit()) + byteCount) - ((long) (segment.getShared$kotlinx_io_core() ? 0 : segment.getPos())) <= 8192) {
                        Segment segment2 = source.head;
                        segment2.getClass();
                        segment2.writeTo$kotlinx_io_core(segment, (int) byteCount);
                        source.sizeMut -= byteCount;
                        this.sizeMut += byteCount;
                        return;
                    }
                }
                Segment segment3 = source.head;
                segment3.getClass();
                source.head = segment3.split$kotlinx_io_core((int) byteCount);
            }
            Segment segment4 = source.head;
            segment4.getClass();
            long size = segment4.getSize();
            Segment segmentPop$kotlinx_io_core = segment4.pop$kotlinx_io_core();
            source.head = segmentPop$kotlinx_io_core;
            if (segmentPop$kotlinx_io_core == null) {
                source.tail = null;
            }
            if (getHead() == null) {
                setHead(segment4);
                setTail(segment4);
            } else {
                Segment tail = getTail();
                tail.getClass();
                setTail(tail.push$kotlinx_io_core(segment4).compact$kotlinx_io_core());
                Segment tail2 = getTail();
                tail2.getClass();
                if (tail2.getPrev() == null) {
                    setHead(getTail());
                }
            }
            source.sizeMut -= size;
            this.sizeMut += size;
            byteCount -= size;
        }
    }

    public void writeByte(byte b) {
        writableSegment(1).writeByte$kotlinx_io_core(b);
        this.sizeMut++;
    }

    @Override // kotlinx.io.Sink
    public void writeShort(short s) {
        writableSegment(2).writeShort$kotlinx_io_core(s);
        this.sizeMut += 2;
    }

    @Override // kotlinx.io.Source
    public int readAtMostTo(byte[] sink, int startIndex, int endIndex) {
        sink.getClass();
        _UtilKt.checkBounds(sink.length, startIndex, endIndex);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(endIndex - startIndex, segment.getSize());
        segment.readTo$kotlinx_io_core(sink, startIndex, startIndex + iMin);
        this.sizeMut -= (long) iMin;
        if (SegmentKt.isEmpty(segment)) {
            recycleHead$kotlinx_io_core();
        }
        return iMin;
    }

    @Override // kotlinx.io.Sink
    public void write(byte[] source, int startIndex, int endIndex) {
        source.getClass();
        _UtilKt.checkBounds(source.length, startIndex, endIndex);
        int i = startIndex;
        while (i < endIndex) {
            Segment segmentWritableSegment = writableSegment(1);
            int iMin = Math.min(endIndex - i, segmentWritableSegment.getRemainingCapacity()) + i;
            segmentWritableSegment.write$kotlinx_io_core(source, i, iMin);
            i = iMin;
        }
        this.sizeMut += (long) (endIndex - startIndex);
    }
}
