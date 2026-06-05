package kotlinx.io.unsafe;

import kotlin.Metadata;
import kotlinx.io.Segment;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\" \u0010\u0001\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\" \u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000b\" \u0010\u000e\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlinx/io/unsafe/SegmentReadContext;", "SegmentReadContextImpl", "Lkotlinx/io/unsafe/SegmentReadContext;", "getSegmentReadContextImpl", "()Lkotlinx/io/unsafe/SegmentReadContext;", "getSegmentReadContextImpl$annotations", "()V", "Lkotlinx/io/unsafe/SegmentWriteContext;", "SegmentWriteContextImpl", "Lkotlinx/io/unsafe/SegmentWriteContext;", "getSegmentWriteContextImpl", "()Lkotlinx/io/unsafe/SegmentWriteContext;", "getSegmentWriteContextImpl$annotations", "Lkotlinx/io/unsafe/BufferIterationContext;", "BufferIterationContextImpl", "Lkotlinx/io/unsafe/BufferIterationContext;", "getBufferIterationContextImpl", "()Lkotlinx/io/unsafe/BufferIterationContext;", "getBufferIterationContextImpl$annotations", "kotlinx-io-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class UnsafeBufferOperationsKt {
    private static final SegmentReadContext SegmentReadContextImpl = new SegmentReadContext() { // from class: kotlinx.io.unsafe.UnsafeBufferOperationsKt$SegmentReadContextImpl$1
        @Override // kotlinx.io.unsafe.SegmentReadContext
        public byte getUnchecked(Segment segment, int offset) {
            segment.getClass();
            return segment.getUnchecked$kotlinx_io_core(offset);
        }
    };
    private static final SegmentWriteContext SegmentWriteContextImpl = new SegmentWriteContext() { // from class: kotlinx.io.unsafe.UnsafeBufferOperationsKt$SegmentWriteContextImpl$1
        @Override // kotlinx.io.unsafe.SegmentWriteContext
        public void setUnchecked(Segment segment, int offset, byte value) {
            segment.getClass();
            segment.setUnchecked$kotlinx_io_core(offset, value);
        }

        @Override // kotlinx.io.unsafe.SegmentWriteContext
        public void setUnchecked(Segment segment, int offset, byte b0, byte b1) {
            segment.getClass();
            segment.setUnchecked$kotlinx_io_core(offset, b0, b1);
        }

        @Override // kotlinx.io.unsafe.SegmentWriteContext
        public void setUnchecked(Segment segment, int offset, byte b0, byte b1, byte b2) {
            segment.getClass();
            segment.setUnchecked$kotlinx_io_core(offset, b0, b1, b2);
        }

        @Override // kotlinx.io.unsafe.SegmentWriteContext
        public void setUnchecked(Segment segment, int offset, byte b0, byte b1, byte b2, byte b3) {
            segment.getClass();
            segment.setUnchecked$kotlinx_io_core(offset, b0, b1, b2, b3);
        }
    };
    private static final BufferIterationContext BufferIterationContextImpl = new BufferIterationContext() { // from class: kotlinx.io.unsafe.UnsafeBufferOperationsKt$BufferIterationContextImpl$1
        @Override // kotlinx.io.unsafe.SegmentReadContext
        public byte getUnchecked(Segment segment, int offset) {
            segment.getClass();
            return UnsafeBufferOperationsKt.SegmentReadContextImpl.getUnchecked(segment, offset);
        }
    };
}
