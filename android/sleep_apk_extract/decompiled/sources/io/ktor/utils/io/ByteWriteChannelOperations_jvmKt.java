package io.ktor.utils.io;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a2\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "min", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "block", "write", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ByteWriteChannelOperations_jvmKt {
    public static final Object write(ByteWriteChannel byteWriteChannel, int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer buffer = byteWriteChannel.getWriteBuffer().getBufferField();
        Segment segmentWritableSegment = buffer.writableSegment(i);
        byte[] bArrDataAsByteArray = segmentWritableSegment.dataAsByteArray(false);
        int limit = segmentWritableSegment.getLimit();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrDataAsByteArray, limit, bArrDataAsByteArray.length - limit);
        byteBufferWrap.getClass();
        function1.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - limit;
        if (iPosition == i) {
            segmentWritableSegment.writeBackData(bArrDataAsByteArray, iPosition);
            segmentWritableSegment.setLimit(segmentWritableSegment.getLimit() + iPosition);
            buffer.setSizeMut(buffer.getSizeMut() + ((long) iPosition));
        } else {
            if (iPosition < 0 || iPosition > segmentWritableSegment.getRemainingCapacity()) {
                StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(iPosition, "Invalid number of bytes written: ", ". Should be in 0..");
                sbM65m.append(segmentWritableSegment.getRemainingCapacity());
                throw new IllegalStateException(sbM65m.toString().toString());
            }
            if (iPosition != 0) {
                segmentWritableSegment.writeBackData(bArrDataAsByteArray, iPosition);
                segmentWritableSegment.setLimit(segmentWritableSegment.getLimit() + iPosition);
                buffer.setSizeMut(buffer.getSizeMut() + ((long) iPosition));
            } else if (SegmentKt.isEmpty(segmentWritableSegment)) {
                buffer.recycleTail();
            }
        }
        Object objFlush = byteWriteChannel.flush(continuation);
        return objFlush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlush : Unit.INSTANCE;
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return write(byteWriteChannel, i, function1, continuation);
    }
}
