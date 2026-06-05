package io.ktor.utils.io;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.platform.traits.ValidationIssue;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.BuffersKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.io.EOFException;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0005\u0010\u0003\u001a \u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a$\u0010\u000f\u001a\u00020\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0012\u0010\u0003\u001a\u001c\u0010\u0014\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0014\u0010\n\u001a*\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u00162\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u000bH\u0007¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u001fH\u0007¢\u0006\u0004\b\u001c\u0010 \"\u001b\u0010$\u001a\u00020\u0006*\u00020\u00008F¢\u0006\f\u0012\u0004\b#\u0010\u001d\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "toByteArray", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Buffer;", "readBuffer", "", "max", "", "readUTF8Line", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", SpotifyService.LIMIT, "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Source;", "readRemaining", "packet", "readPacket", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "", "readUTF8LineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "rethrowCloseCauseIfNeeded", "(Lio/ktor/utils/io/ByteReadChannel;)V", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "Lio/ktor/utils/io/ByteChannel;", "(Lio/ktor/utils/io/ByteChannel;)V", "getAvailableForRead", "(Lio/ktor/utils/io/ByteReadChannel;)I", "getAvailableForRead$annotations", "availableForRead", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ByteReadChannelOperationsKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {169, 173, 180, 180}, m = "copyTo")
    public static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {84}, m = "readBuffer")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {323}, m = "readPacket")
    public static final class C22581 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22581(Continuation<? super C22581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readPacket(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {198}, m = "readRemaining")
    public static final class C22591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22591(Continuation<? super C22591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readRemaining(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {140}, m = "readUTF8Line")
    public static final class C22601 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C22601(Continuation<? super C22601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readUTF8Line(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8LineTo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {374, 383, ValidationIssue.TOO_MANY_OPERATIONS_FIELD_NUMBER}, m = "readUTF8LineTo")
    public static final class C22611 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C22611(Continuation<? super C22611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readUTF8LineTo(null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {37}, m = "toByteArray")
    public static final class C22621 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C22621(Continuation<? super C22621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.toByteArray(null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a2, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r1, 0, r13, r7, null) == r2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d7, code lost:
    
        if (r0 != r2) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00d7 -> B:20:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) throws Throwable {
        AnonymousClass2 anonymousClass2;
        ByteReadChannel byteReadChannel2;
        long j2;
        long j3;
        AnonymousClass2 anonymousClass22;
        ByteReadChannel byteReadChannel3;
        long j4;
        long j5;
        ?? r3;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        }
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r32 = anonymousClass2.label;
        int i2 = 1;
        try {
            if (r32 == 0) {
                ResultKt.throwOnFailure(obj);
                r32 = byteWriteChannel;
                j2 = j;
                j3 = j2;
                anonymousClass22 = anonymousClass2;
                byteReadChannel3 = byteReadChannel;
                if (byteReadChannel3.isClosedForRead()) {
                }
                anonymousClass22.L$0 = null;
                anonymousClass22.L$1 = null;
                anonymousClass22.J$0 = j3;
                anonymousClass22.J$1 = j2;
                anonymousClass22.label = 3;
                if (r32.flush(anonymousClass22) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (r32 == 1) {
                j2 = anonymousClass2.J$1;
                j3 = anonymousClass2.J$0;
                ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                r32 = byteWriteChannel2;
                long jMin = Math.min(j2, ByteReadPacketKt.getRemaining(byteReadChannel2.getReadBuffer()));
                byteReadChannel2.getReadBuffer().readTo(r32.getWriteBuffer(), jMin);
                j2 -= jMin;
                anonymousClass2.L$0 = byteReadChannel2;
                anonymousClass2.L$1 = r32;
                anonymousClass2.J$0 = j3;
                anonymousClass2.J$1 = j2;
                anonymousClass2.label = 2;
                Object objFlush = r32.flush(anonymousClass2);
                r3 = r32;
            } else {
                if (r32 != 2) {
                    if (r32 == 3) {
                        j4 = anonymousClass2.J$1;
                        j5 = anonymousClass2.J$0;
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxLong(j5 - j4);
                    }
                    if (r32 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th = (Throwable) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                j2 = anonymousClass2.J$1;
                j3 = anonymousClass2.J$0;
                ByteWriteChannel byteWriteChannel3 = (ByteWriteChannel) anonymousClass2.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                r3 = byteWriteChannel3;
                try {
                    ByteReadChannel byteReadChannel4 = byteReadChannel2;
                    anonymousClass22 = anonymousClass2;
                    byteReadChannel3 = byteReadChannel4;
                    if (!byteReadChannel3.isClosedForRead() || j2 <= 0) {
                        anonymousClass22.L$0 = null;
                        anonymousClass22.L$1 = null;
                        anonymousClass22.J$0 = j3;
                        anonymousClass22.J$1 = j2;
                        anonymousClass22.label = 3;
                        if (r32.flush(anonymousClass22) != coroutine_suspended) {
                            j4 = j2;
                            j5 = j3;
                            return Boxing.boxLong(j5 - j4);
                        }
                    } else {
                        if (byteReadChannel3.getReadBuffer().exhausted()) {
                            anonymousClass22.L$0 = byteReadChannel3;
                            anonymousClass22.L$1 = r32;
                            anonymousClass22.J$0 = j3;
                            anonymousClass22.J$1 = j2;
                            anonymousClass22.label = i2;
                        }
                        AnonymousClass2 anonymousClass23 = anonymousClass22;
                        byteReadChannel2 = byteReadChannel3;
                        anonymousClass2 = anonymousClass23;
                        r32 = r32;
                        long jMin2 = Math.min(j2, ByteReadPacketKt.getRemaining(byteReadChannel2.getReadBuffer()));
                        byteReadChannel2.getReadBuffer().readTo(r32.getWriteBuffer(), jMin2);
                        j2 -= jMin2;
                        anonymousClass2.L$0 = byteReadChannel2;
                        anonymousClass2.L$1 = r32;
                        anonymousClass2.J$0 = j3;
                        anonymousClass2.J$1 = j2;
                        anonymousClass2.label = 2;
                        Object objFlush2 = r32.flush(anonymousClass2);
                        r3 = r32;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    AnonymousClass2 anonymousClass24 = anonymousClass22;
                    byteReadChannel2 = byteReadChannel3;
                    anonymousClass2 = anonymousClass24;
                    try {
                        byteReadChannel2.cancel(th);
                        ByteWriteChannelOperationsKt.close(r32, th);
                        throw th;
                    } catch (Throwable th3) {
                        anonymousClass2.L$0 = th3;
                        anonymousClass2.L$1 = null;
                        anonymousClass2.label = 4;
                        if (r32.flush(anonymousClass2) != coroutine_suspended) {
                            throw th3;
                        }
                    }
                }
                i2 = 1;
                r32 = r3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static final int getAvailableForRead(ByteReadChannel byteReadChannel) {
        byteReadChannel.getClass();
        return (int) byteReadChannel.getReadBuffer().getBufferField().getSizeMut();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBuffer(ByteReadChannel byteReadChannel, Continuation<? super Buffer> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Buffer buffer;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            buffer = new Buffer();
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Buffer buffer2 = (Buffer) anonymousClass1.L$1;
            ByteReadChannel byteReadChannel2 = (ByteReadChannel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            buffer = buffer2;
            byteReadChannel = byteReadChannel2;
        }
        while (!byteReadChannel.isClosedForRead()) {
            buffer.transferFrom(byteReadChannel.getReadBuffer());
            anonymousClass1.L$0 = byteReadChannel;
            anonymousClass1.L$1 = buffer;
            anonymousClass1.label = 1;
            if (ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel, 0, anonymousClass1, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause == null) {
            return buffer;
        }
        throw closedCause;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0056 -> B:24:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0068 -> B:23:0x006a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readPacket(ByteReadChannel byteReadChannel, int i, Continuation<? super Source> continuation) throws EOFException {
        C22581 c22581;
        int i2;
        Buffer buffer;
        if (continuation instanceof C22581) {
            c22581 = (C22581) continuation;
            int i3 = c22581.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c22581.label = i3 - Integer.MIN_VALUE;
            } else {
                c22581 = new C22581(continuation);
            }
        }
        Object obj = c22581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c22581.label;
        if (i4 != 0) {
            if (i4 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i5 = c22581.I$0;
            buffer = (Buffer) c22581.L$1;
            ByteReadChannel byteReadChannel2 = (ByteReadChannel) c22581.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i5;
            byteReadChannel = byteReadChannel2;
            if (!byteReadChannel.isClosedForRead()) {
                long j = i2;
                if (ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()) > j - buffer.getSizeMut()) {
                    byteReadChannel.getReadBuffer().readTo(buffer, j - buffer.getSizeMut());
                } else {
                    Boxing.boxLong(byteReadChannel.getReadBuffer().transferTo(buffer));
                }
                if (buffer.getSizeMut() < i2) {
                    if (byteReadChannel.getReadBuffer().exhausted()) {
                        c22581.L$0 = byteReadChannel;
                        c22581.L$1 = buffer;
                        c22581.I$0 = i2;
                        c22581.label = 1;
                        if (ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel, 0, c22581, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        byteReadChannel2 = byteReadChannel;
                        i5 = i2;
                        i2 = i5;
                        byteReadChannel = byteReadChannel2;
                    }
                    if (!byteReadChannel.isClosedForRead()) {
                    }
                }
            }
            if (buffer.getSizeMut() < i2) {
                return buffer;
            }
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i2, "Not enough data available, required ", " bytes but only ");
            sbM65m.append(buffer.getSizeMut());
            sbM65m.append(" available");
            throw new EOFException(sbM65m.toString());
        }
        ResultKt.throwOnFailure(obj);
        i2 = i;
        buffer = new Buffer();
        if (buffer.getSizeMut() < i2) {
        }
        if (buffer.getSizeMut() < i2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readRemaining(ByteReadChannel byteReadChannel, Continuation<? super Source> continuation) {
        C22591 c22591;
        Sink sinkBytePacketBuilder;
        if (continuation instanceof C22591) {
            c22591 = (C22591) continuation;
            int i = c22591.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22591.label = i - Integer.MIN_VALUE;
            } else {
                c22591 = new C22591(continuation);
            }
        }
        Object obj = c22591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22591.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            sinkBytePacketBuilder = BytePacketBuilderKt.BytePacketBuilder();
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Sink sink = (Sink) c22591.L$1;
            ByteReadChannel byteReadChannel2 = (ByteReadChannel) c22591.L$0;
            ResultKt.throwOnFailure(obj);
            sinkBytePacketBuilder = sink;
            byteReadChannel = byteReadChannel2;
        }
        while (!byteReadChannel.isClosedForRead()) {
            sinkBytePacketBuilder.transferFrom(byteReadChannel.getReadBuffer());
            c22591.L$0 = byteReadChannel;
            c22591.L$1 = sinkBytePacketBuilder;
            c22591.label = 1;
            if (ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel, 0, c22591, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        rethrowCloseCauseIfNeeded(byteReadChannel);
        return sinkBytePacketBuilder.getBufferField();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readUTF8Line(ByteReadChannel byteReadChannel, int i, Continuation<? super String> continuation) {
        C22601 c22601;
        StringBuilder sb;
        if (continuation instanceof C22601) {
            c22601 = (C22601) continuation;
            int i2 = c22601.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c22601.label = i2 - Integer.MIN_VALUE;
            } else {
                c22601 = new C22601(continuation);
            }
        }
        Object obj = c22601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c22601.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb2 = new StringBuilder();
            c22601.L$0 = sb2;
            c22601.label = 1;
            Object uTF8LineTo = readUTF8LineTo(byteReadChannel, sb2, i, c22601);
            if (uTF8LineTo == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = uTF8LineTo;
            sb = sb2;
        } else {
            if (i3 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            sb = (StringBuilder) c22601.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ Object readUTF8Line$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadChannel, i, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r20, 0, r2, 1, null) == r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0132, code lost:
    
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013b, code lost:
    
        if (r4.getSizeMut() >= r0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013d, code lost:
    
        r2.L$0 = r15;
        r2.L$1 = r14;
        r2.L$2 = r13;
        r2.L$3 = r4;
        r2.I$0 = r0;
        r5 = 3;
        r2.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014e, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r15, 0, r2, 1, null) != r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0150, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0173, code lost:
    
        throw new io.ktor.utils.io.charsets.TooLongLineException("Line exceeds limit of " + r0 + " characters");
     */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0196: INVOKE (r13 I:java.lang.AutoCloseable), (r1 I:java.lang.Throwable) STATIC call: kotlin.jdk7.AutoCloseableKt.closeFinally(java.lang.AutoCloseable, java.lang.Throwable):void A[MD:(java.lang.AutoCloseable, java.lang.Throwable):void (m)] (LINE:407), block:B:79:0x0196 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00be A[Catch: all -> 0x004f, LOOP:0: B:38:0x00be->B:60:0x012d, LOOP_START, TryCatch #1 {all -> 0x004f, blocks: (B:14:0x0047, B:36:0x00b8, B:38:0x00be, B:40:0x00c8, B:42:0x00d4, B:44:0x00de, B:49:0x00f5, B:51:0x0103, B:52:0x010c, B:56:0x011d, B:60:0x012d, B:61:0x0132, B:63:0x013d, B:67:0x0158, B:68:0x0173, B:69:0x0174, B:72:0x017f, B:74:0x0189, B:21:0x006a), top: B:83:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103 A[Catch: all -> 0x004f, TryCatch #1 {all -> 0x004f, blocks: (B:14:0x0047, B:36:0x00b8, B:38:0x00be, B:40:0x00c8, B:42:0x00d4, B:44:0x00de, B:49:0x00f5, B:51:0x0103, B:52:0x010c, B:56:0x011d, B:60:0x012d, B:61:0x0132, B:63:0x013d, B:67:0x0158, B:68:0x0173, B:69:0x0174, B:72:0x017f, B:74:0x0189, B:21:0x006a), top: B:83:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0174 A[Catch: all -> 0x004f, TryCatch #1 {all -> 0x004f, blocks: (B:14:0x0047, B:36:0x00b8, B:38:0x00be, B:40:0x00c8, B:42:0x00d4, B:44:0x00de, B:49:0x00f5, B:51:0x0103, B:52:0x010c, B:56:0x011d, B:60:0x012d, B:61:0x0132, B:63:0x013d, B:67:0x0158, B:68:0x0173, B:69:0x0174, B:72:0x017f, B:74:0x0189, B:21:0x006a), top: B:83:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x014e -> B:66:0x0151). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation<? super Boolean> continuation) {
        C22611 c22611;
        Appendable appendable2;
        int i2;
        ByteReadChannel byteReadChannel2;
        int i3;
        Buffer buffer;
        Appendable appendable3;
        ByteReadChannel byteReadChannel3;
        AutoCloseable autoCloseable;
        Appendable appendable4;
        ByteReadChannel byteReadChannel4;
        Buffer buffer2;
        if (continuation instanceof C22611) {
            c22611 = (C22611) continuation;
            int i4 = c22611.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c22611.label = i4 - Integer.MIN_VALUE;
            } else {
                c22611 = new C22611(continuation);
            }
        }
        Object obj = c22611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c22611.label;
        byte b = 10;
        long j = 0;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                if (byteReadChannel.getReadBuffer().exhausted()) {
                    c22611.L$0 = byteReadChannel;
                    appendable2 = appendable;
                    c22611.L$1 = appendable2;
                    i2 = i;
                    c22611.I$0 = i2;
                    c22611.label = 1;
                } else {
                    appendable2 = appendable;
                    i2 = i;
                }
                byteReadChannel2 = byteReadChannel;
                i3 = i2;
            } else {
                if (i5 != 1) {
                    if (i5 == 2) {
                        buffer2 = (Buffer) c22611.L$3;
                        autoCloseable = (AutoCloseable) c22611.L$2;
                        appendable4 = (Appendable) c22611.L$1;
                        byteReadChannel4 = (ByteReadChannel) c22611.L$0;
                        ResultKt.throwOnFailure(obj);
                        buffer = buffer2;
                        byteReadChannel3 = byteReadChannel4;
                        appendable3 = appendable4;
                        if (byteReadChannel3.getReadBuffer().getBufferField().get(j) == b) {
                        }
                        appendable3.append(Utf8Kt.readString(buffer));
                        Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                        AutoCloseableKt.closeFinally(autoCloseable, null);
                        return boolBoxBoolean;
                    }
                    if (i5 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i3 = c22611.I$0;
                    buffer = (Buffer) c22611.L$3;
                    autoCloseable = (AutoCloseable) c22611.L$2;
                    appendable3 = (Appendable) c22611.L$1;
                    byteReadChannel3 = (ByteReadChannel) c22611.L$0;
                    ResultKt.throwOnFailure(obj);
                    long j2 = 0;
                    char c = 3;
                    j = j2;
                    b = 10;
                    if (!byteReadChannel3.isClosedForRead()) {
                        Boolean boolBoxBoolean2 = Boxing.boxBoolean(buffer.getSizeMut() > j);
                        if (boolBoxBoolean2.booleanValue()) {
                            appendable3.append(Utf8Kt.readString(buffer));
                        }
                        AutoCloseableKt.closeFinally(autoCloseable, null);
                        return boolBoxBoolean2;
                    }
                    while (true) {
                        if (byteReadChannel3.getReadBuffer().exhausted()) {
                            break;
                        }
                        byte b2 = byteReadChannel3.getReadBuffer().readByte();
                        if (b2 == 13) {
                            if (byteReadChannel3.getReadBuffer().exhausted()) {
                                c22611.L$0 = byteReadChannel3;
                                c22611.L$1 = appendable3;
                                c22611.L$2 = autoCloseable;
                                c22611.L$3 = buffer;
                                c22611.label = 2;
                                if (ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel3, 0, c22611, 1, null) != coroutine_suspended) {
                                    buffer2 = buffer;
                                    appendable4 = appendable3;
                                    byteReadChannel4 = byteReadChannel3;
                                }
                            }
                        } else {
                            if (b2 == b) {
                                appendable3.append(Utf8Kt.readString(buffer));
                                Boolean boolBoxBoolean3 = Boxing.boxBoolean(true);
                                AutoCloseableKt.closeFinally(autoCloseable, null);
                                return boolBoxBoolean3;
                            }
                            buffer.writeByte(b2);
                        }
                    }
                    if (byteReadChannel3.getReadBuffer().getBufferField().get(j) == b) {
                        ByteReadPacketKt.discard(byteReadChannel3.getReadBuffer(), 1L);
                    }
                    appendable3.append(Utf8Kt.readString(buffer));
                    Boolean boolBoxBoolean4 = Boxing.boxBoolean(true);
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    return boolBoxBoolean4;
                }
                i3 = c22611.I$0;
                Appendable appendable5 = (Appendable) c22611.L$1;
                byteReadChannel2 = (ByteReadChannel) c22611.L$0;
                ResultKt.throwOnFailure(obj);
                appendable2 = appendable5;
            }
            if (byteReadChannel2.isClosedForRead()) {
                return Boxing.boxBoolean(false);
            }
            buffer = new Buffer();
            appendable3 = appendable2;
            byteReadChannel3 = byteReadChannel2;
            autoCloseable = buffer;
            if (!byteReadChannel3.isClosedForRead()) {
            }
        } finally {
        }
    }

    public static final void rethrowCloseCauseIfNeeded(ByteReadChannel byteReadChannel) throws Throwable {
        byteReadChannel.getClass();
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toByteArray(ByteReadChannel byteReadChannel, Continuation<? super byte[]> continuation) {
        C22621 c22621;
        if (continuation instanceof C22621) {
            c22621 = (C22621) continuation;
            int i = c22621.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22621.label = i - Integer.MIN_VALUE;
            } else {
                c22621 = new C22621(continuation);
            }
        }
        Object buffer = c22621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22621.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(buffer);
            c22621.label = 1;
            buffer = readBuffer(byteReadChannel, c22621);
            if (buffer == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(buffer);
        }
        return BuffersKt.readBytes$default((Buffer) buffer, 0, 1, null);
    }

    public static final void rethrowCloseCauseIfNeeded(ByteWriteChannel byteWriteChannel) throws Throwable {
        byteWriteChannel.getClass();
        Throwable closedCause = byteWriteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static final void rethrowCloseCauseIfNeeded(ByteChannel byteChannel) {
        byteChannel.getClass();
        Throwable closedCause = byteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }
}
