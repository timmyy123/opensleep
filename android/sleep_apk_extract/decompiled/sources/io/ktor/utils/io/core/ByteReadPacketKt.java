package io.ktor.utils.io.core;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.Source;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\n\u001a\u00020\t*\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000b\"\u0017\u0010\f\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u001b\u0010\u0014\u001a\u00020\u0001*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011*\f\b\u0007\u0010\u0015\"\u00020\u00002\u00020\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/io/Source;", "", "count", "discard", "(Lkotlinx/io/Source;J)J", "Lkotlin/Function1;", "Lkotlinx/io/Buffer;", "", "block", "", "takeWhile", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)V", "ByteReadPacketEmpty", "Lkotlinx/io/Source;", "getByteReadPacketEmpty", "()Lkotlinx/io/Source;", "getRemaining", "(Lkotlinx/io/Source;)J", "getRemaining$annotations", "(Lkotlinx/io/Source;)V", "remaining", "ByteReadPacket", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ByteReadPacketKt {
    private static final Source ByteReadPacketEmpty = new Buffer();

    public static final long discard(Source source, long j) throws EOFException {
        source.getClass();
        source.request(j);
        long jMin = Math.min(j, getRemaining(source));
        source.getBufferField().skip(jMin);
        return jMin;
    }

    public static /* synthetic */ long discard$default(Source source, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return discard(source, j);
    }

    public static final long getRemaining(Source source) {
        source.getClass();
        return source.getBufferField().getSizeMut();
    }

    public static final void takeWhile(Source source, Function1<? super Buffer, Boolean> function1) {
        source.getClass();
        function1.getClass();
        while (!source.exhausted() && function1.invoke(source.getBufferField()).booleanValue()) {
        }
    }
}
