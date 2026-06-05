package kotlinx.io;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/io/InputStreamSource;", "Lkotlinx/io/RawSource;", "input", "Ljava/io/InputStream;", "<init>", "(Ljava/io/InputStream;)V", "readAtMostTo", "", "sink", "Lkotlinx/io/Buffer;", "byteCount", "close", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
class InputStreamSource implements RawSource {
    private final InputStream input;

    public InputStreamSource(InputStream inputStream) {
        inputStream.getClass();
        this.input = inputStream;
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable, kotlinx.io.RawSink
    public void close() throws IOException {
        this.input.close();
    }

    @Override // kotlinx.io.RawSource
    public long readAtMostTo(Buffer sink, long byteCount) throws IOException {
        sink.getClass();
        if (byteCount == 0) {
            return 0L;
        }
        if (byteCount < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) zzba$$ExternalSyntheticOutline0.m("byteCount (", ") < 0", byteCount));
            return 0L;
        }
        try {
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            Segment segmentWritableSegment = sink.writableSegment(1);
            int i = 0;
            byte[] bArrDataAsByteArray = segmentWritableSegment.dataAsByteArray(false);
            long j = this.input.read(bArrDataAsByteArray, segmentWritableSegment.getLimit(), (int) Math.min(byteCount, bArrDataAsByteArray.length - r5));
            if (j != -1) {
                i = (int) j;
            }
            if (i == 1) {
                segmentWritableSegment.writeBackData(bArrDataAsByteArray, i);
                segmentWritableSegment.setLimit(segmentWritableSegment.getLimit() + i);
                sink.setSizeMut(sink.getSizeMut() + ((long) i));
                return j;
            }
            if (i < 0 || i > segmentWritableSegment.getRemainingCapacity()) {
                throw new IllegalStateException(("Invalid number of bytes written: " + i + ". Should be in 0.." + segmentWritableSegment.getRemainingCapacity()).toString());
            }
            if (i == 0) {
                if (SegmentKt.isEmpty(segmentWritableSegment)) {
                    sink.recycleTail();
                }
                return j;
            }
            segmentWritableSegment.writeBackData(bArrDataAsByteArray, i);
            segmentWritableSegment.setLimit(segmentWritableSegment.getLimit() + i);
            sink.setSizeMut(sink.getSizeMut() + ((long) i));
            return j;
        } catch (AssertionError e) {
            if (JvmCoreKt.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    public String toString() {
        return "RawSource(" + this.input + ')';
    }
}
