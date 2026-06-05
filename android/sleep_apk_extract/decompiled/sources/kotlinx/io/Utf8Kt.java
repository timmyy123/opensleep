package kotlinx.io;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.io.internal._Utf8Kt;
import kotlinx.io.unsafe.SegmentReadContext;
import kotlinx.io.unsafe.SegmentWriteContext;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import kotlinx.io.unsafe.UnsafeBufferOperationsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\t¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\f¢\u0006\u0004\b\n\u0010\r\u001a\u0019\u0010\n\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\n\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/io/Sink;", "", "string", "", "startIndex", "endIndex", "", "writeString", "(Lkotlinx/io/Sink;Ljava/lang/String;II)V", "Lkotlinx/io/Source;", "readString", "(Lkotlinx/io/Source;)Ljava/lang/String;", "Lkotlinx/io/Buffer;", "(Lkotlinx/io/Buffer;)Ljava/lang/String;", "", "byteCount", "(Lkotlinx/io/Source;J)Ljava/lang/String;", "commonReadUtf8", "(Lkotlinx/io/Buffer;J)Ljava/lang/String;", "kotlinx-io-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class Utf8Kt {
    private static final String commonReadUtf8(Buffer buffer, long j) throws EOFException {
        if (j == 0) {
            return "";
        }
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Segment head = buffer.getHead();
        if (head == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Unreacheable");
            return null;
        }
        SegmentReadContext unused = UnsafeBufferOperationsKt.SegmentReadContextImpl;
        if (head.getSize() < j) {
            return _Utf8Kt.commonToUtf8String$default(SourcesKt.readByteArray(buffer, (int) j), 0, 0, 3, null);
        }
        byte[] bArrDataAsByteArray = head.dataAsByteArray(true);
        int pos = head.getPos();
        String strCommonToUtf8String = _Utf8Kt.commonToUtf8String(bArrDataAsByteArray, pos, Math.min(head.getLimit(), ((int) j) + pos));
        buffer.skip(j);
        return strCommonToUtf8String;
    }

    public static final String readString(Source source) {
        source.getClass();
        source.request(Long.MAX_VALUE);
        return commonReadUtf8(source.getBufferField(), source.getBufferField().getSizeMut());
    }

    public static final void writeString(Sink sink, String str, int i, int i2) {
        long sizeMut;
        long j;
        sink.getClass();
        str.getClass();
        int i3 = i;
        _UtilKt.checkBounds(str.length(), i3, i2);
        Buffer buffer = sink.getBufferField();
        while (i3 < i2) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            char cCharAt = str.charAt(i3);
            ref$IntRef.element = cCharAt;
            if (cCharAt < 128) {
                UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                Segment segmentWritableSegment = buffer.writableSegment(1);
                SegmentWriteContext segmentWriteContext = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                int i4 = -i3;
                int iMin = Math.min(i2, segmentWritableSegment.getRemainingCapacity() + i3);
                segmentWriteContext.setUnchecked(segmentWritableSegment, i3 + i4, (byte) ref$IntRef.element);
                i3++;
                while (i3 < iMin) {
                    char cCharAt2 = str.charAt(i3);
                    ref$IntRef.element = cCharAt2;
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    segmentWriteContext.setUnchecked(segmentWritableSegment, i3 + i4, (byte) cCharAt2);
                    i3++;
                }
                int i5 = i4 + i3;
                if (i5 == 1) {
                    segmentWritableSegment.setLimit(segmentWritableSegment.getLimit() + i5);
                    buffer.setSizeMut(buffer.getSizeMut() + ((long) i5));
                } else {
                    if (i5 < 0 || i5 > segmentWritableSegment.getRemainingCapacity()) {
                        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i5, "Invalid number of bytes written: ", ". Should be in 0..");
                        sbM65m.append(segmentWritableSegment.getRemainingCapacity());
                        throw new IllegalStateException(sbM65m.toString().toString());
                    }
                    if (i5 != 0) {
                        segmentWritableSegment.setLimit(segmentWritableSegment.getLimit() + i5);
                        buffer.setSizeMut(buffer.getSizeMut() + ((long) i5));
                    } else if (SegmentKt.isEmpty(segmentWritableSegment)) {
                        buffer.recycleTail();
                    }
                }
            } else {
                if (cCharAt < 2048) {
                    UnsafeBufferOperations unsafeBufferOperations2 = UnsafeBufferOperations.INSTANCE;
                    Segment segmentWritableSegment2 = buffer.writableSegment(2);
                    SegmentWriteContext segmentWriteContext2 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                    int i6 = ref$IntRef.element;
                    segmentWriteContext2.setUnchecked(segmentWritableSegment2, 0, (byte) ((i6 >> 6) | 192), (byte) ((i6 & 63) | 128));
                    segmentWritableSegment2.setLimit(segmentWritableSegment2.getLimit() + 2);
                    sizeMut = buffer.getSizeMut();
                    j = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    UnsafeBufferOperations unsafeBufferOperations3 = UnsafeBufferOperations.INSTANCE;
                    Segment segmentWritableSegment3 = buffer.writableSegment(3);
                    SegmentWriteContext segmentWriteContext3 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                    int i7 = ref$IntRef.element;
                    segmentWriteContext3.setUnchecked(segmentWritableSegment3, 0, (byte) ((i7 >> 12) | 224), (byte) (((i7 >> 6) & 63) | 128), (byte) ((i7 & 63) | 128));
                    segmentWritableSegment3.setLimit(segmentWritableSegment3.getLimit() + 3);
                    sizeMut = buffer.getSizeMut();
                    j = 3;
                } else {
                    int i8 = i3 + 1;
                    char cCharAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    int i9 = ref$IntRef.element;
                    if (i9 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        buffer.writeByte((byte) 63);
                        i3 = i8;
                    } else {
                        int i10 = (((i9 & 1023) << 10) | (cCharAt3 & 1023)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        UnsafeBufferOperations unsafeBufferOperations4 = UnsafeBufferOperations.INSTANCE;
                        Segment segmentWritableSegment4 = buffer.writableSegment(4);
                        UnsafeBufferOperationsKt.SegmentWriteContextImpl.setUnchecked(segmentWritableSegment4, 0, (byte) ((i10 >> 18) | 240), (byte) (((i10 >> 12) & 63) | 128), (byte) (((i10 >> 6) & 63) | 128), (byte) ((i10 & 63) | 128));
                        segmentWritableSegment4.setLimit(segmentWritableSegment4.getLimit() + 4);
                        buffer.setSizeMut(buffer.getSizeMut() + 4);
                        i3 += 2;
                    }
                }
                buffer.setSizeMut(sizeMut + j);
                i3++;
            }
        }
        sink.hintEmit();
    }

    public static final String readString(Buffer buffer) {
        buffer.getClass();
        return commonReadUtf8(buffer, buffer.getSizeMut());
    }

    public static final String readString(Source source, long j) {
        source.getClass();
        source.require(j);
        return commonReadUtf8(source.getBufferField(), j);
    }
}
