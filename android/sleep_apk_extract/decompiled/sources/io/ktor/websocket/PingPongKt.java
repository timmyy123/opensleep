package io.ktor.websocket;

import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import io.ktor.util.CryptoKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Pong;", "outgoing", "Lio/ktor/websocket/Frame$Ping;", "ponger", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame;", "", "periodMillis", "timeoutMillis", "Lkotlin/Function2;", "Lio/ktor/websocket/CloseReason;", "Lkotlin/coroutines/Continuation;", "", "", "onTimeout", "pinger", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;JJLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/CoroutineName;", "PongerCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "PingerCoroutineName", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class PingPongKt {
    private static final CoroutineName PongerCoroutineName = new CoroutineName("ws-ponger");
    private static final CoroutineName PingerCoroutineName = new CoroutineName("ws-pinger");

    /* JADX INFO: renamed from: io.ktor.websocket.PingPongKt$pinger$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", l = {65, 74, 96}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Frame.Pong> $channel;
        final /* synthetic */ Function2<CloseReason, Continuation<? super Unit>, Object> $onTimeout;
        final /* synthetic */ SendChannel<Frame> $outgoing;
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ long $timeoutMillis;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: io.ktor.websocket.PingPongKt$pinger$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$1", f = "PingPong.kt", l = {67}, m = "invokeSuspend")
        public static final class C00751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Channel<Frame.Pong> $channel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00751(Channel<Frame.Pong> channel, Continuation<? super C00751> continuation) {
                super(2, continuation);
                this.$channel = channel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00751(this.$channel, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Channel<Frame.Pong> channel;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0 && i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                do {
                    channel = this.$channel;
                    this.label = 1;
                } while (channel.receive(this) != coroutine_suspended);
                return coroutine_suspended;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(long j, long j2, Function2<? super CloseReason, ? super Continuation<? super Unit>, ? extends Object> function2, Channel<Frame.Pong> channel, SendChannel<? super Frame> sendChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$periodMillis = j;
            this.$timeoutMillis = j2;
            this.$onTimeout = function2;
            this.$channel = channel;
            this.$outgoing = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$periodMillis, this.$timeoutMillis, this.$onTimeout, this.$channel, this.$outgoing, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00d9, code lost:
        
            if (r13.invoke(r1, r12) == r0) goto L29;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b7 A[Catch: CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00de, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00de, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00de, PHI: r1 r6 r13
          0x00b7: PHI (r1v7 byte[]) = (r1v5 byte[]), (r1v13 byte[]) binds: [B:23:0x00b4, B:12:0x0025] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r6v10 kotlin.random.Random) = (r6v6 kotlin.random.Random), (r6v14 kotlin.random.Random) binds: [B:23:0x00b4, B:12:0x0025] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r13v7 java.lang.Object) = (r13v5 java.lang.Object), (r13v0 java.lang.Object) binds: [B:23:0x00b4, B:12:0x0025] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00de, blocks: (B:7:0x0012, B:12:0x0025, B:12:0x0025, B:12:0x0025, B:25:0x00b7, B:25:0x00b7, B:25:0x00b7, B:27:0x00bb, B:27:0x00bb, B:27:0x00bb, B:18:0x006b, B:18:0x006b, B:18:0x006b, B:22:0x0082, B:22:0x0082, B:22:0x0082, B:15:0x0032, B:15:0x0032, B:15:0x0032), top: B:34:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[Catch: CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00de, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00de, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00de, TRY_LEAVE, TryCatch #0 {CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00de, blocks: (B:7:0x0012, B:12:0x0025, B:12:0x0025, B:12:0x0025, B:25:0x00b7, B:25:0x00b7, B:25:0x00b7, B:27:0x00bb, B:27:0x00bb, B:27:0x00bb, B:18:0x006b, B:18:0x006b, B:18:0x006b, B:22:0x0082, B:22:0x0082, B:22:0x0082, B:15:0x0032, B:15:0x0032, B:15:0x0032), top: B:34:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00dc  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b4 -> B:25:0x00b7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Random Random;
            byte[] bArr;
            Random random;
            long j;
            C00751 c00751;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DefaultWebSocketSessionKt.getLOGGER().trace("Starting WebSocket pinger coroutine with period " + this.$periodMillis + " ms and timeout " + this.$timeoutMillis + " ms");
                Random = RandomKt.Random(DateJvmKt.getTimeMillis());
                bArr = new byte[32];
                j = this.$periodMillis;
                c00751 = new C00751(this.$channel, null);
                this.L$0 = Random;
                this.L$1 = bArr;
                this.label = 1;
                if (TimeoutKt.withTimeoutOrNull(j, c00751, this) != coroutine_suspended) {
                }
            } else {
                if (i == 1) {
                    bArr = (byte[]) this.L$1;
                    random = (Random) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    random.nextBytes(bArr);
                    String str = "[ping " + CryptoKt.hex(bArr) + " ping]";
                    long j2 = this.$timeoutMillis;
                    PingPongKt$pinger$1$rc$1 pingPongKt$pinger$1$rc$1 = new PingPongKt$pinger$1$rc$1(this.$outgoing, str, this.$channel, null);
                    this.L$0 = random;
                    this.L$1 = bArr;
                    this.label = 2;
                    obj = TimeoutKt.withTimeoutOrNull(j2, pingPongKt$pinger$1$rc$1, this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bArr = (byte[]) this.L$1;
                random = (Random) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Unit) obj) == null) {
                    Random = random;
                    j = this.$periodMillis;
                    c00751 = new C00751(this.$channel, null);
                    this.L$0 = Random;
                    this.L$1 = bArr;
                    this.label = 1;
                    if (TimeoutKt.withTimeoutOrNull(j, c00751, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    random = Random;
                    random.nextBytes(bArr);
                    String str2 = "[ping " + CryptoKt.hex(bArr) + " ping]";
                    long j22 = this.$timeoutMillis;
                    PingPongKt$pinger$1$rc$1 pingPongKt$pinger$1$rc$12 = new PingPongKt$pinger$1$rc$1(this.$outgoing, str2, this.$channel, null);
                    this.L$0 = random;
                    this.L$1 = bArr;
                    this.label = 2;
                    obj = TimeoutKt.withTimeoutOrNull(j22, pingPongKt$pinger$1$rc$12, this);
                    if (obj == coroutine_suspended) {
                        if (((Unit) obj) == null) {
                        }
                    }
                    return coroutine_suspended;
                }
                DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket pinger has timed out");
                Function2<CloseReason, Continuation<? super Unit>, Object> function2 = this.$onTimeout;
                CloseReason closeReason = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, "Ping timeout");
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.PingPongKt$ponger$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", l = {117, 32}, m = "invokeSuspend")
    public static final class C22671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Frame.Ping> $channel;
        final /* synthetic */ SendChannel<Frame.Pong> $outgoing;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C22671(Channel<Frame.Ping> channel, SendChannel<? super Frame.Pong> sendChannel, Continuation<? super C22671> continuation) {
            super(2, continuation);
            this.$channel = channel;
            this.$outgoing = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22671(this.$channel, this.$outgoing, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
        
            if (r6.send(r7, r10) == r0) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[Catch: all -> 0x0020, TryCatch #1 {all -> 0x0020, blocks: (B:7:0x001b, B:19:0x0043, B:23:0x0055, B:25:0x005d, B:28:0x0084, B:14:0x0034, B:18:0x003f), top: B:38:0x0009, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0084 A[Catch: all -> 0x0020, TRY_LEAVE, TryCatch #1 {all -> 0x0020, blocks: (B:7:0x001b, B:19:0x0043, B:23:0x0055, B:25:0x005d, B:28:0x0084, B:14:0x0034, B:18:0x003f), top: B:38:0x0009, outer: #0 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0081 -> B:8:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ReceiveChannel receiveChannel;
            SendChannel<Frame.Pong> sendChannel;
            ChannelIterator it;
            SendChannel<Frame.Pong> sendChannel2;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } finally {
                }
            } catch (ClosedSendChannelException unused) {
            }
            if (i != 0) {
                if (i == 1) {
                    it = (ChannelIterator) this.L$2;
                    receiveChannel = (ReceiveChannel) this.L$1;
                    sendChannel2 = (SendChannel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                it = (ChannelIterator) this.L$2;
                receiveChannel = (ReceiveChannel) this.L$1;
                sendChannel2 = (SendChannel) this.L$0;
                ResultKt.throwOnFailure(obj);
                sendChannel = sendChannel2;
                this.L$0 = sendChannel;
                this.L$1 = receiveChannel;
                this.L$2 = it;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                sendChannel2 = sendChannel;
                obj = objHasNext;
                if (((Boolean) obj).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                } else {
                    Frame.Ping ping = (Frame.Ping) it.next();
                    DefaultWebSocketSessionKt.getLOGGER().trace("Received ping message, sending pong message");
                    Frame.Pong pong = new Frame.Pong(ping.getData(), null, 2, null);
                    this.L$0 = sendChannel2;
                    this.L$1 = receiveChannel;
                    this.L$2 = it;
                    this.label = 2;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            receiveChannel = this.$channel;
            sendChannel = this.$outgoing;
            it = receiveChannel.iterator();
            this.L$0 = sendChannel;
            this.L$1 = receiveChannel;
            this.L$2 = it;
            this.label = 1;
            objHasNext = it.hasNext(this);
            if (objHasNext != coroutine_suspended) {
            }
        }
    }

    public static final SendChannel<Frame.Pong> pinger(CoroutineScope coroutineScope, SendChannel<? super Frame> sendChannel, long j, long j2, Function2<? super CloseReason, ? super Continuation<? super Unit>, ? extends Object> function2) {
        coroutineScope.getClass();
        sendChannel.getClass();
        function2.getClass();
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default(null, 1, null);
        Channel channelChannel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, completableJobJob$default.plus(PingerCoroutineName), null, new AnonymousClass1(j, j2, function2, channelChannel$default, sendChannel, null), 2, null);
        CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.INSTANCE);
        element.getClass();
        ((Job) element).invokeOnCompletion(new CodecsKt$$ExternalSyntheticLambda2(completableJobJob$default, 25));
        return channelChannel$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pinger$lambda$0(CompletableJob completableJob, Throwable th) {
        Job.cancel$default(completableJob, null, 1, null);
        return Unit.INSTANCE;
    }

    public static final SendChannel<Frame.Ping> ponger(CoroutineScope coroutineScope, SendChannel<? super Frame.Pong> sendChannel) {
        coroutineScope.getClass();
        sendChannel.getClass();
        Channel channelChannel$default = ChannelKt.Channel$default(5, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, PongerCoroutineName, null, new C22671(channelChannel$default, sendChannel, null), 2, null);
        return channelChannel$default;
    }
}
