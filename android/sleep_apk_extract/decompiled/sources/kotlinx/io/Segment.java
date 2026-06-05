package kotlinx.io;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\bT\u0018\u0000 v2\u00020\u0001:\u0001vB\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003B3\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0002\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b \u0010!J\u0017\u0010'\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010*\u001a\u00020\u001dH\u0000¢\u0006\u0004\b(\u0010)J\u000f\u0010-\u001a\u00020#H\u0000¢\u0006\u0004\b+\u0010,J\u001f\u00101\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0004\b/\u00100J'\u00107\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006H\u0000¢\u0006\u0004\b5\u00106J'\u0010<\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0000¢\u0006\u0004\b;\u00106J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u000bH\u0001¢\u0006\u0004\b>\u0010?J\u001f\u0010A\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0006H\u0001¢\u0006\u0004\bA\u0010BJ\u0017\u0010F\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u0006H\u0000¢\u0006\u0004\bD\u0010EJ\u001f\u0010J\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u001dH\u0000¢\u0006\u0004\bH\u0010IJ'\u0010J\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u001dH\u0000¢\u0006\u0004\bH\u0010MJ/\u0010J\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020\u001dH\u0000¢\u0006\u0004\bH\u0010OJ7\u0010J\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u001dH\u0000¢\u0006\u0004\bH\u0010QR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010RR(\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0007\u0010S\u0012\u0004\bX\u0010\u0003\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR(\u0010\b\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\b\u0010S\u0012\u0004\b[\u0010\u0003\u001a\u0004\bY\u0010U\"\u0004\bZ\u0010WR$\u0010\\\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\f\u0010bR*\u0010c\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bc\u0010d\u0012\u0004\bh\u0010\u0003\u001a\u0004\be\u0010\u000f\"\u0004\bf\u0010gR*\u0010i\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bi\u0010d\u0012\u0004\bl\u0010\u0003\u001a\u0004\bj\u0010\u000f\"\u0004\bk\u0010gR\u0014\u0010o\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u001a\u0010r\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bq\u0010\u0003\u001a\u0004\bp\u0010UR\u001a\u0010u\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bt\u0010\u0003\u001a\u0004\bs\u0010U¨\u0006w"}, d2 = {"Lkotlinx/io/Segment;", "", "<init>", "()V", "", "data", "", "pos", SpotifyService.LIMIT, "Lkotlinx/io/SegmentCopyTracker;", "shareToken", "", "owner", "([BIILkotlinx/io/SegmentCopyTracker;Z)V", "sharedCopy$kotlinx_io_core", "()Lkotlinx/io/Segment;", "sharedCopy", "pop$kotlinx_io_core", "pop", "segment", "push$kotlinx_io_core", "(Lkotlinx/io/Segment;)Lkotlinx/io/Segment;", "push", "byteCount", "split$kotlinx_io_core", "(I)Lkotlinx/io/Segment;", "split", "compact$kotlinx_io_core", "compact", "", "byte", "", "writeByte$kotlinx_io_core", "(B)V", "writeByte", "", "short", "writeShort$kotlinx_io_core", "(S)V", "writeShort", "readByte$kotlinx_io_core", "()B", "readByte", "readShort$kotlinx_io_core", "()S", "readShort", "sink", "writeTo$kotlinx_io_core", "(Lkotlinx/io/Segment;I)V", "writeTo", "dst", "dstStartOffset", "dstEndOffset", "readTo$kotlinx_io_core", "([BII)V", "readTo", "src", "srcStartOffset", "srcEndOffset", "write$kotlinx_io_core", "write", "readOnly", "dataAsByteArray", "(Z)[B", "bytesToCommit", "writeBackData", "([BI)V", "index", "getUnchecked$kotlinx_io_core", "(I)B", "getUnchecked", SDKConstants.PARAM_VALUE, "setUnchecked$kotlinx_io_core", "(IB)V", "setUnchecked", "b0", "b1", "(IBB)V", "b2", "(IBBB)V", "b3", "(IBBBB)V", "[B", "I", "getPos", "()I", "setPos", "(I)V", "getPos$annotations", "getLimit", "setLimit", "getLimit$annotations", "copyTracker", "Lkotlinx/io/SegmentCopyTracker;", "getCopyTracker$kotlinx_io_core", "()Lkotlinx/io/SegmentCopyTracker;", "setCopyTracker$kotlinx_io_core", "(Lkotlinx/io/SegmentCopyTracker;)V", "Z", "next", "Lkotlinx/io/Segment;", "getNext", "setNext", "(Lkotlinx/io/Segment;)V", "getNext$annotations", "prev", "getPrev", "setPrev", "getPrev$annotations", "getShared$kotlinx_io_core", "()Z", "shared", "getSize", "getSize$annotations", "size", "getRemainingCapacity", "getRemainingCapacity$annotations", "remainingCapacity", "Companion", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Segment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SegmentCopyTracker copyTracker;
    private final byte[] data;
    private int limit;
    private Segment next;
    public boolean owner;
    private int pos;
    private Segment prev;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ7\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/io/Segment$Companion;", "", "<init>", "()V", "SIZE", "", "SHARE_MINIMUM", "new", "Lkotlinx/io/Segment;", "new$kotlinx_io_core", "data", "", "pos", SpotifyService.LIMIT, "copyTracker", "Lkotlinx/io/SegmentCopyTracker;", "owner", "", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Segment new$kotlinx_io_core(byte[] data2, int pos, int limit, SegmentCopyTracker copyTracker, boolean owner) {
            data2.getClass();
            return new Segment(data2, pos, limit, copyTracker, owner, null);
        }

        private Companion() {
        }

        public final /* synthetic */ Segment new$kotlinx_io_core() {
            return new Segment(null);
        }
    }

    private Segment() {
        this.data = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.owner = true;
        this.copyTracker = null;
    }

    public final Segment compact$kotlinx_io_core() {
        int i;
        Segment segment = this.prev;
        if (segment == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("cannot compact");
            return null;
        }
        segment.getClass();
        if (segment.owner) {
            int i2 = this.limit - this.pos;
            Segment segment2 = this.prev;
            segment2.getClass();
            int i3 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            segment3.getClass();
            if (segment3.getShared$kotlinx_io_core()) {
                i = 0;
            } else {
                Segment segment4 = this.prev;
                segment4.getClass();
                i = segment4.pos;
            }
            if (i2 <= i3 + i) {
                Segment segment5 = this.prev;
                segment5.getClass();
                writeTo$kotlinx_io_core(segment5, i2);
                if (pop$kotlinx_io_core() == null) {
                    SegmentPool.recycle(this);
                    return segment5;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("Check failed.");
                return null;
            }
        }
        return this;
    }

    public final /* synthetic */ byte[] dataAsByteArray(boolean readOnly) {
        return this.data;
    }

    /* JADX INFO: renamed from: getCopyTracker$kotlinx_io_core, reason: from getter */
    public final SegmentCopyTracker getCopyTracker() {
        return this.copyTracker;
    }

    public final /* synthetic */ int getLimit() {
        return this.limit;
    }

    public final /* synthetic */ Segment getNext() {
        return this.next;
    }

    public final /* synthetic */ int getPos() {
        return this.pos;
    }

    public final /* synthetic */ Segment getPrev() {
        return this.prev;
    }

    public final /* synthetic */ int getRemainingCapacity() {
        return this.data.length - this.limit;
    }

    public final boolean getShared$kotlinx_io_core() {
        SegmentCopyTracker segmentCopyTracker = this.copyTracker;
        if (segmentCopyTracker != null) {
            return segmentCopyTracker.getShared();
        }
        return false;
    }

    public final /* synthetic */ int getSize() {
        return this.limit - this.pos;
    }

    public final byte getUnchecked$kotlinx_io_core(int index) {
        return this.data[this.pos + index];
    }

    public final Segment pop$kotlinx_io_core() {
        Segment segment = this.next;
        Segment segment2 = this.prev;
        if (segment2 != null) {
            segment2.getClass();
            segment2.next = this.next;
        }
        Segment segment3 = this.next;
        if (segment3 != null) {
            segment3.getClass();
            segment3.prev = this.prev;
        }
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push$kotlinx_io_core(Segment segment) {
        segment.getClass();
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        if (segment2 != null) {
            segment2.getClass();
            segment2.prev = segment;
        }
        this.next = segment;
        return segment;
    }

    public final byte readByte$kotlinx_io_core() {
        byte[] bArr = this.data;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public final short readShort$kotlinx_io_core() {
        byte[] bArr = this.data;
        int i = this.pos;
        int i2 = (bArr[i] & 255) << 8;
        short s = (short) ((bArr[i + 1] & 255) | i2);
        this.pos = i + 2;
        return s;
    }

    public final void readTo$kotlinx_io_core(byte[] dst, int dstStartOffset, int dstEndOffset) {
        dst.getClass();
        int i = dstEndOffset - dstStartOffset;
        byte[] bArr = this.data;
        int i2 = this.pos;
        ArraysKt___ArraysJvmKt.copyInto(bArr, dst, dstStartOffset, i2, i2 + i);
        this.pos += i;
    }

    public final /* synthetic */ void setLimit(int i) {
        this.limit = i;
    }

    public final /* synthetic */ void setNext(Segment segment) {
        this.next = segment;
    }

    public final /* synthetic */ void setPos(int i) {
        this.pos = i;
    }

    public final /* synthetic */ void setPrev(Segment segment) {
        this.prev = segment;
    }

    public final void setUnchecked$kotlinx_io_core(int index, byte b0, byte b1, byte b2, byte b3) {
        byte[] bArr = this.data;
        int i = this.limit + index;
        bArr[i] = b0;
        bArr[i + 1] = b1;
        bArr[i + 2] = b2;
        bArr[i + 3] = b3;
    }

    public final Segment sharedCopy$kotlinx_io_core() {
        SegmentCopyTracker segmentCopyTrackerTracker = this.copyTracker;
        if (segmentCopyTrackerTracker == null) {
            segmentCopyTrackerTracker = SegmentPool.tracker();
            this.copyTracker = segmentCopyTrackerTracker;
        }
        SegmentCopyTracker segmentCopyTracker = segmentCopyTrackerTracker;
        byte[] bArr = this.data;
        int i = this.pos;
        int i2 = this.limit;
        segmentCopyTracker.addCopy();
        Unit unit = Unit.INSTANCE;
        return new Segment(bArr, i, i2, segmentCopyTracker, false);
    }

    public final Segment split$kotlinx_io_core(int byteCount) {
        Segment segmentTake;
        if (byteCount <= 0 || byteCount > this.limit - this.pos) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("byteCount out of range");
            return null;
        }
        if (byteCount >= 1024) {
            segmentTake = sharedCopy$kotlinx_io_core();
        } else {
            segmentTake = SegmentPool.take();
            byte[] bArr = this.data;
            byte[] bArr2 = segmentTake.data;
            int i = this.pos;
            ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr2, 0, i, i + byteCount, 2, (Object) null);
        }
        segmentTake.limit = segmentTake.pos + byteCount;
        this.pos += byteCount;
        Segment segment = this.prev;
        if (segment != null) {
            segment.push$kotlinx_io_core(segmentTake);
            return segmentTake;
        }
        segmentTake.next = this;
        this.prev = segmentTake;
        return segmentTake;
    }

    public final void write$kotlinx_io_core(byte[] src, int srcStartOffset, int srcEndOffset) {
        src.getClass();
        ArraysKt___ArraysJvmKt.copyInto(src, this.data, this.limit, srcStartOffset, srcEndOffset);
        this.limit = (srcEndOffset - srcStartOffset) + this.limit;
    }

    public final /* synthetic */ void writeBackData(byte[] data2, int bytesToCommit) {
        data2.getClass();
    }

    public final void writeByte$kotlinx_io_core(byte b) {
        byte[] bArr = this.data;
        int i = this.limit;
        this.limit = i + 1;
        bArr[i] = b;
    }

    public final void writeShort$kotlinx_io_core(short s) {
        byte[] bArr = this.data;
        int i = this.limit;
        bArr[i] = (byte) ((s >>> 8) & PHIpAddressSearchManager.END_IP_SCAN);
        bArr[i + 1] = (byte) (s & 255);
        this.limit = i + 2;
    }

    public final void writeTo$kotlinx_io_core(Segment sink, int byteCount) {
        sink.getClass();
        if (!sink.owner) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("only owner can write");
            return;
        }
        if (sink.limit + byteCount > 8192) {
            if (sink.getShared$kotlinx_io_core()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
            int i = sink.limit;
            int i2 = sink.pos;
            if ((i + byteCount) - i2 > 8192) {
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
            byte[] bArr = sink.data;
            ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr, 0, i2, i, 2, (Object) null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i3 = sink.limit;
        int i4 = this.pos;
        ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr3, i3, i4, i4 + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }

    public /* synthetic */ Segment(byte[] bArr, int i, int i2, SegmentCopyTracker segmentCopyTracker, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, i, i2, segmentCopyTracker, z);
    }

    public /* synthetic */ Segment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Segment(byte[] bArr, int i, int i2, SegmentCopyTracker segmentCopyTracker, boolean z) {
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.copyTracker = segmentCopyTracker;
        this.owner = z;
    }

    public final void setUnchecked$kotlinx_io_core(int index, byte b0, byte b1) {
        byte[] bArr = this.data;
        int i = this.limit + index;
        bArr[i] = b0;
        bArr[i + 1] = b1;
    }

    public final void setUnchecked$kotlinx_io_core(int index, byte b0, byte b1, byte b2) {
        byte[] bArr = this.data;
        int i = this.limit + index;
        bArr[i] = b0;
        bArr[i + 1] = b1;
        bArr[i + 2] = b2;
    }

    public final void setUnchecked$kotlinx_io_core(int index, byte value) {
        this.data[this.limit + index] = value;
    }
}
