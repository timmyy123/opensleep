package io.ktor.websocket;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.home.platform.traits.ValidationIssue;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.io.Sink;
import kotlinx.io.SourcesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0019\u0010\u0010J&\u0010\u001e\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010$J\"\u0010)\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020'H\u0082@¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b-\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020'028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020'028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010=\u001a\u00020<8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R*\u0010\u0005\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR*\u0010\u0006\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010B\u001a\u0004\bG\u0010D\"\u0004\bH\u0010FR\"\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0I8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020'0N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020'0\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u001e\u0010W\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR$\u0010[\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bY\u0010D\"\u0004\bZ\u0010F¨\u0006]"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "raw", "", "pingIntervalMillis", "timeoutMillis", "<init>", "(Lio/ktor/websocket/WebSocketSession;JJ)V", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "", "start", "(Ljava/util/List;)V", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Ping;", "ponger", "Lkotlinx/coroutines/Job;", "runIncomingProcessor", "(Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/Job;", "runOutgoingProcessor", "()Lkotlinx/coroutines/Job;", "outgoingProcessorLoop", "Lio/ktor/websocket/CloseReason;", "reason", "", "exception", "sendCloseSequence", "(Lio/ktor/websocket/CloseReason;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "tryClose", "()Z", "runOrCancelPinger", "()V", "Lkotlinx/io/Sink;", "packet", "Lio/ktor/websocket/Frame;", "frame", "checkMaxFrameSize", "(Lkotlinx/io/Sink;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processIncomingExtensions", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processOutgoingExtensions", "Lio/ktor/websocket/WebSocketSession;", "Lkotlinx/coroutines/CompletableDeferred;", "closeReasonRef", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/channels/Channel;", "filtered", "Lkotlinx/coroutines/channels/Channel;", "outgoingToBeProcessed", "Lkotlinx/coroutines/CompletableJob;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lkotlinx/coroutines/CompletableJob;", "", "_extensions", "Ljava/util/List;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "newValue", "J", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "getTimeoutMillis", "setTimeoutMillis", "Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "getExtensions", "()Ljava/util/List;", "extensions", SDKConstants.PARAM_VALUE, "getMaxFrameSize", "setMaxFrameSize", "maxFrameSize", "Companion", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {
    private final List<WebSocketExtension<?>> _extensions;
    private final Deferred<CloseReason> closeReason;
    private final CompletableDeferred<CloseReason> closeReasonRef;
    private volatile /* synthetic */ int closed;
    private final CompletableJob context;
    private final CoroutineContext coroutineContext;
    private final Channel<Frame> filtered;
    private final Channel<Frame> outgoingToBeProcessed;
    private long pingIntervalMillis;
    volatile /* synthetic */ Object pinger;
    private final WebSocketSession raw;
    private volatile /* synthetic */ int started;
    private long timeoutMillis;
    private static final Frame.Pong EmptyPong = new Frame.Pong(new byte[0], NonDisposableHandle.INSTANCE);
    static final /* synthetic */ AtomicReferenceFieldUpdater pinger$FU = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "closed");
    private static final /* synthetic */ AtomicIntegerFieldUpdater started$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "started");

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {336}, m = "checkMaxFrameSize")
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.checkMaxFrameSize(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {262, 266, 276}, m = "outgoingProcessorLoop")
    public static final class C22631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22631(Continuation<? super C22631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.outgoingProcessorLoop(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", l = {377, 183, 236, 189, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 192, ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER, 222, 236, 236, 236, 236}, m = "invokeSuspend")
    public static final class C22641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SendChannel<Frame.Ping> $ponger;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C22641(SendChannel<? super Frame.Ping> sendChannel, Continuation<? super C22641> continuation) {
            super(2, continuation);
            this.$ponger = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C22641 c22641 = DefaultWebSocketSessionImpl.this.new C22641(this.$ponger, continuation);
            c22641.L$0 = obj;
            return c22641;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:118:0x03fd, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close(r0, r4, r30) == r2) goto L152;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x0459, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close(r0, r4, r30) == r2) goto L152;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x04e4, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close(r0, r4, r30) == r2) goto L152;
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x03b8, code lost:
        
            r4 = r11.element;
            r4.getClass();
            io.ktor.utils.io.core.BytePacketBuilderKt.writeFully$default((kotlinx.io.Sink) r4, r0.getData(), 0, 0, 6, null);
            r0 = r12;
            r12 = r6;
            r6 = r0;
            r0 = r11;
            r11 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r0;
            r0 = r13;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:110:0x03bb A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #4 {all -> 0x0048, blocks: (B:9:0x0043, B:108:0x03b4, B:42:0x017c, B:44:0x0184, B:46:0x0194, B:47:0x01b0, B:49:0x01b4, B:51:0x01be, B:53:0x01cc, B:54:0x01d0, B:57:0x01ee, B:70:0x0239, B:72:0x023d, B:74:0x0243, B:77:0x025e, B:78:0x0262, B:80:0x0266, B:83:0x0281, B:84:0x0285, B:110:0x03bb, B:14:0x006c, B:22:0x00c1, B:25:0x00e6, B:30:0x0102, B:33:0x0127), top: B:159:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0184 A[Catch: all -> 0x0048, TryCatch #4 {all -> 0x0048, blocks: (B:9:0x0043, B:108:0x03b4, B:42:0x017c, B:44:0x0184, B:46:0x0194, B:47:0x01b0, B:49:0x01b4, B:51:0x01be, B:53:0x01cc, B:54:0x01d0, B:57:0x01ee, B:70:0x0239, B:72:0x023d, B:74:0x0243, B:77:0x025e, B:78:0x0262, B:80:0x0266, B:83:0x0281, B:84:0x0285, B:110:0x03bb, B:14:0x006c, B:22:0x00c1, B:25:0x00e6, B:30:0x0102, B:33:0x0127), top: B:159:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01ee A[Catch: all -> 0x0048, PHI: r6 r9 r10
          0x01ee: PHI (r6v26 kotlinx.coroutines.channels.ReceiveChannel<io.ktor.websocket.Frame>) = 
          (r6v10 kotlinx.coroutines.channels.ReceiveChannel<io.ktor.websocket.Frame>)
          (r6v33 kotlinx.coroutines.channels.ReceiveChannel<io.ktor.websocket.Frame>)
          (r6v33 kotlinx.coroutines.channels.ReceiveChannel<io.ktor.websocket.Frame>)
         binds: [B:30:0x0102, B:50:0x01bc, B:55:0x01ea] A[DONT_GENERATE, DONT_INLINE]
          0x01ee: PHI (r9v19 kotlin.jvm.internal.Ref$BooleanRef) = 
          (r9v4 kotlin.jvm.internal.Ref$BooleanRef)
          (r9v20 kotlin.jvm.internal.Ref$BooleanRef)
          (r9v20 kotlin.jvm.internal.Ref$BooleanRef)
         binds: [B:30:0x0102, B:50:0x01bc, B:55:0x01ea] A[DONT_GENERATE, DONT_INLINE]
          0x01ee: PHI (r10v20 kotlin.jvm.internal.Ref$ObjectRef) = 
          (r10v4 kotlin.jvm.internal.Ref$ObjectRef)
          (r10v21 kotlin.jvm.internal.Ref$ObjectRef)
          (r10v21 kotlin.jvm.internal.Ref$ObjectRef)
         binds: [B:30:0x0102, B:50:0x01bc, B:55:0x01ea] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {all -> 0x0048, blocks: (B:9:0x0043, B:108:0x03b4, B:42:0x017c, B:44:0x0184, B:46:0x0194, B:47:0x01b0, B:49:0x01b4, B:51:0x01be, B:53:0x01cc, B:54:0x01d0, B:57:0x01ee, B:70:0x0239, B:72:0x023d, B:74:0x0243, B:77:0x025e, B:78:0x0262, B:80:0x0266, B:83:0x0281, B:84:0x0285, B:110:0x03bb, B:14:0x006c, B:22:0x00c1, B:25:0x00e6, B:30:0x0102, B:33:0x0127), top: B:159:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0201  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x02b8 A[Catch: all -> 0x009a, TryCatch #5 {all -> 0x009a, blocks: (B:88:0x02b2, B:90:0x02b8, B:92:0x02bc, B:93:0x02be, B:95:0x02c2, B:96:0x02c8, B:97:0x02eb, B:99:0x02ef, B:104:0x0329, B:17:0x0095), top: B:160:0x0095 }] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x02eb A[Catch: all -> 0x009a, TryCatch #5 {all -> 0x009a, blocks: (B:88:0x02b2, B:90:0x02b8, B:92:0x02bc, B:93:0x02be, B:95:0x02c2, B:96:0x02c8, B:97:0x02eb, B:99:0x02ef, B:104:0x0329, B:17:0x0095), top: B:160:0x0095 }] */
        /* JADX WARN: Type inference failed for: r0v42, types: [T, io.ktor.websocket.Frame] */
        /* JADX WARN: Type inference failed for: r0v78 */
        /* JADX WARN: Type inference failed for: r0v94 */
        /* JADX WARN: Type inference failed for: r4v29, types: [T, kotlinx.io.Sink] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x0314 -> B:103:0x031c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x03ac -> B:108:0x03b4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0241 -> B:103:0x031c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            ReceiveChannel<Frame> receiveChannel;
            CoroutineScope coroutineScope;
            Ref$ObjectRef ref$ObjectRef;
            Ref$ObjectRef ref$ObjectRef2;
            Ref$BooleanRef ref$BooleanRef;
            ReceiveChannel<Frame> incoming;
            DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
            SendChannel sendChannel;
            ChannelIterator<Frame> it;
            ChannelIterator<Frame> channelIterator;
            ReceiveChannel<Frame> receiveChannel2;
            SendChannel sendChannel2;
            Ref$ObjectRef ref$ObjectRef3;
            CoroutineScope coroutineScope2;
            Object objHasNext;
            ChannelIterator<Frame> channelIterator2;
            SendChannel sendChannel3;
            DefaultWebSocketSessionImpl defaultWebSocketSessionImpl2;
            Ref$BooleanRef ref$BooleanRef2;
            Ref$ObjectRef ref$ObjectRef4;
            Ref$ObjectRef ref$ObjectRef5;
            CoroutineScope coroutineScope3;
            ?? r0;
            Sink sink;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = 1;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        coroutineScope = (CoroutineScope) this.L$0;
                        ref$ObjectRef = new Ref$ObjectRef();
                        ref$ObjectRef2 = new Ref$ObjectRef();
                        ref$BooleanRef = new Ref$BooleanRef();
                        try {
                            incoming = DefaultWebSocketSessionImpl.this.raw.getIncoming();
                            defaultWebSocketSessionImpl = DefaultWebSocketSessionImpl.this;
                            sendChannel = this.$ponger;
                            try {
                                it = incoming.iterator();
                                this.L$0 = coroutineScope;
                                this.L$1 = ref$ObjectRef;
                                this.L$2 = ref$ObjectRef2;
                                this.L$3 = ref$BooleanRef;
                                this.L$4 = defaultWebSocketSessionImpl;
                                this.L$5 = sendChannel;
                                this.L$6 = incoming;
                                this.L$7 = it;
                                this.L$8 = null;
                                this.label = i;
                                objHasNext = it.hasNext(this);
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                                receiveChannel = incoming;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    ChannelsKt.cancelConsumed(receiveChannel, th);
                                    throw th3;
                                }
                            }
                        } catch (ClosedSendChannelException unused) {
                            SendChannel.close$default(this.$ponger, null, 1, null);
                            Sink sink2 = (Sink) ref$ObjectRef2.element;
                            if (sink2 != null) {
                                sink2.close();
                                Unit unit = Unit.INSTANCE;
                            }
                            SendChannel.close$default(DefaultWebSocketSessionImpl.this.filtered, null, 1, null);
                            if (!ref$BooleanRef.element) {
                                DefaultWebSocketSessionImpl defaultWebSocketSessionImpl3 = DefaultWebSocketSessionImpl.this;
                                CloseReason closeReason = new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame");
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.L$8 = null;
                                this.label = 10;
                            }
                            break;
                        } catch (Throwable th4) {
                            try {
                                SendChannel.close$default(this.$ponger, null, 1, null);
                                DefaultWebSocketSessionImpl.this.filtered.close(th4);
                                SendChannel.close$default(this.$ponger, null, 1, null);
                                Sink sink3 = (Sink) ref$ObjectRef2.element;
                                if (sink3 != null) {
                                    sink3.close();
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                SendChannel.close$default(DefaultWebSocketSessionImpl.this.filtered, null, 1, null);
                                if (!ref$BooleanRef.element) {
                                    DefaultWebSocketSessionImpl defaultWebSocketSessionImpl4 = DefaultWebSocketSessionImpl.this;
                                    CloseReason closeReason2 = new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame");
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.L$7 = null;
                                    this.L$8 = null;
                                    this.label = 11;
                                }
                            } catch (Throwable th5) {
                                SendChannel.close$default(this.$ponger, null, 1, null);
                                Sink sink4 = (Sink) ref$ObjectRef2.element;
                                if (sink4 != null) {
                                    sink4.close();
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                SendChannel.close$default(DefaultWebSocketSessionImpl.this.filtered, null, 1, null);
                                if (ref$BooleanRef.element) {
                                    throw th5;
                                }
                                DefaultWebSocketSessionImpl defaultWebSocketSessionImpl5 = DefaultWebSocketSessionImpl.this;
                                CloseReason closeReason3 = new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame");
                                this.L$0 = th5;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.L$8 = null;
                                this.label = 12;
                                if (WebSocketSessionKt.close(defaultWebSocketSessionImpl5, closeReason3, this) != coroutine_suspended) {
                                    throw th5;
                                }
                            }
                            break;
                        }
                        if (objHasNext != coroutine_suspended) {
                            ChannelIterator<Frame> channelIterator3 = it;
                            coroutineScope2 = coroutineScope;
                            channelIterator = channelIterator3;
                            SendChannel sendChannel4 = sendChannel;
                            ref$ObjectRef3 = ref$ObjectRef;
                            receiveChannel2 = incoming;
                            sendChannel2 = sendChannel4;
                            if (((Boolean) objHasNext).booleanValue()) {
                                Unit unit4 = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel2, null);
                                SendChannel.close$default(this.$ponger, null, 1, null);
                                Sink sink5 = (Sink) ref$ObjectRef2.element;
                                if (sink5 != null) {
                                    sink5.close();
                                }
                                SendChannel.close$default(DefaultWebSocketSessionImpl.this.filtered, null, 1, null);
                                if (!ref$BooleanRef.element) {
                                    DefaultWebSocketSessionImpl defaultWebSocketSessionImpl6 = DefaultWebSocketSessionImpl.this;
                                    CloseReason closeReason4 = new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame");
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.L$7 = null;
                                    this.label = 9;
                                    break;
                                }
                                return Unit.INSTANCE;
                            }
                            Frame next = channelIterator.next();
                            Logger logger = DefaultWebSocketSessionKt.getLOGGER();
                            if (LoggerJvmKt.isTraceEnabled(logger)) {
                                logger.trace("WebSocketSession(" + coroutineScope2 + ") receiving frame " + next);
                            }
                            if (!(next instanceof Frame.Close)) {
                                if (next instanceof Frame.Pong) {
                                    SendChannel sendChannel5 = (SendChannel) defaultWebSocketSessionImpl.pinger;
                                    if (sendChannel5 != null) {
                                        this.L$0 = coroutineScope2;
                                        this.L$1 = ref$ObjectRef3;
                                        this.L$2 = ref$ObjectRef2;
                                        this.L$3 = ref$BooleanRef;
                                        this.L$4 = defaultWebSocketSessionImpl;
                                        this.L$5 = sendChannel2;
                                        this.L$6 = receiveChannel2;
                                        this.L$7 = channelIterator;
                                        this.label = 4;
                                        if (sendChannel5.send(next, this) != coroutine_suspended) {
                                            Unit unit5 = Unit.INSTANCE;
                                        }
                                    }
                                    CoroutineScope coroutineScope4 = coroutineScope2;
                                    it = channelIterator;
                                    coroutineScope = coroutineScope4;
                                    SendChannel sendChannel6 = sendChannel2;
                                    incoming = receiveChannel2;
                                    ref$ObjectRef = ref$ObjectRef3;
                                    sendChannel = sendChannel6;
                                } else if (next instanceof Frame.Ping) {
                                    this.L$0 = coroutineScope2;
                                    this.L$1 = ref$ObjectRef3;
                                    this.L$2 = ref$ObjectRef2;
                                    this.L$3 = ref$BooleanRef;
                                    this.L$4 = defaultWebSocketSessionImpl;
                                    this.L$5 = sendChannel2;
                                    this.L$6 = receiveChannel2;
                                    this.L$7 = channelIterator;
                                    this.label = 5;
                                    if (sendChannel2.send(next, this) != coroutine_suspended) {
                                        Unit unit6 = Unit.INSTANCE;
                                        CoroutineScope coroutineScope42 = coroutineScope2;
                                        it = channelIterator;
                                        coroutineScope = coroutineScope42;
                                        SendChannel sendChannel62 = sendChannel2;
                                        incoming = receiveChannel2;
                                        ref$ObjectRef = ref$ObjectRef3;
                                        sendChannel = sendChannel62;
                                    }
                                } else {
                                    Sink sink6 = (Sink) ref$ObjectRef2.element;
                                    this.L$0 = coroutineScope2;
                                    this.L$1 = ref$ObjectRef3;
                                    this.L$2 = ref$ObjectRef2;
                                    this.L$3 = ref$BooleanRef;
                                    this.L$4 = defaultWebSocketSessionImpl;
                                    this.L$5 = sendChannel2;
                                    this.L$6 = receiveChannel2;
                                    this.L$7 = channelIterator;
                                    this.L$8 = next;
                                    this.label = 6;
                                    if (defaultWebSocketSessionImpl.checkMaxFrameSize(sink6, next, this) != coroutine_suspended) {
                                        ReceiveChannel<Frame> receiveChannel3 = receiveChannel2;
                                        channelIterator2 = channelIterator;
                                        r0 = next;
                                        coroutineScope3 = coroutineScope2;
                                        ref$ObjectRef5 = ref$ObjectRef3;
                                        ref$ObjectRef4 = ref$ObjectRef2;
                                        ref$BooleanRef2 = ref$BooleanRef;
                                        defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl;
                                        sendChannel3 = sendChannel2;
                                        incoming = receiveChannel3;
                                        if (!r0.getFin()) {
                                            if (ref$ObjectRef5.element == 0) {
                                                ref$ObjectRef5.element = r0;
                                            }
                                            if (ref$ObjectRef4.element == 0) {
                                                ref$ObjectRef4.element = BytePacketBuilderKt.BytePacketBuilder();
                                                T t = ref$ObjectRef4.element;
                                                t.getClass();
                                                BytePacketBuilderKt.writeFully$default((Sink) t, r0.getData(), 0, 0, 6, null);
                                                Ref$ObjectRef ref$ObjectRef6 = ref$ObjectRef5;
                                                it = channelIterator2;
                                                ref$ObjectRef = ref$ObjectRef6;
                                                Ref$ObjectRef ref$ObjectRef7 = ref$ObjectRef4;
                                                sendChannel = sendChannel3;
                                                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                                ref$BooleanRef = ref$BooleanRef2;
                                                ref$ObjectRef2 = ref$ObjectRef7;
                                                coroutineScope = coroutineScope3;
                                            } else {
                                                T t2 = ref$ObjectRef4.element;
                                                t2.getClass();
                                                BytePacketBuilderKt.writeFully$default((Sink) t2, r0.getData(), 0, 0, 6, null);
                                                Ref$ObjectRef ref$ObjectRef62 = ref$ObjectRef5;
                                                it = channelIterator2;
                                                ref$ObjectRef = ref$ObjectRef62;
                                                Ref$ObjectRef ref$ObjectRef72 = ref$ObjectRef4;
                                                sendChannel = sendChannel3;
                                                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                                ref$BooleanRef = ref$BooleanRef2;
                                                ref$ObjectRef2 = ref$ObjectRef72;
                                                coroutineScope = coroutineScope3;
                                            }
                                        } else if (ref$ObjectRef5.element == 0) {
                                            Channel channel = defaultWebSocketSessionImpl2.filtered;
                                            Frame frameProcessIncomingExtensions = defaultWebSocketSessionImpl2.processIncomingExtensions(r0);
                                            this.L$0 = coroutineScope3;
                                            this.L$1 = ref$ObjectRef5;
                                            this.L$2 = ref$ObjectRef4;
                                            this.L$3 = ref$BooleanRef2;
                                            this.L$4 = defaultWebSocketSessionImpl2;
                                            this.L$5 = sendChannel3;
                                            this.L$6 = incoming;
                                            this.L$7 = channelIterator2;
                                            this.L$8 = null;
                                            this.label = 7;
                                            if (channel.send(frameProcessIncomingExtensions, this) != coroutine_suspended) {
                                                channelIterator = channelIterator2;
                                                receiveChannel2 = incoming;
                                                sendChannel2 = sendChannel3;
                                                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                                ref$BooleanRef = ref$BooleanRef2;
                                                ref$ObjectRef2 = ref$ObjectRef4;
                                                ref$ObjectRef3 = ref$ObjectRef5;
                                                coroutineScope2 = coroutineScope3;
                                                CoroutineScope coroutineScope422 = coroutineScope2;
                                                it = channelIterator;
                                                coroutineScope = coroutineScope422;
                                                SendChannel sendChannel622 = sendChannel2;
                                                incoming = receiveChannel2;
                                                ref$ObjectRef = ref$ObjectRef3;
                                                sendChannel = sendChannel622;
                                            }
                                        } else {
                                            T t3 = ref$ObjectRef4.element;
                                            t3.getClass();
                                            BytePacketBuilderKt.writeFully$default((Sink) t3, r0.getData(), 0, 0, 6, null);
                                            Frame.Companion companion = Frame.INSTANCE;
                                            T t4 = ref$ObjectRef5.element;
                                            t4.getClass();
                                            FrameType frameType = ((Frame) t4).getFrameType();
                                            T t5 = ref$ObjectRef4.element;
                                            t5.getClass();
                                            byte[] byteArray = SourcesKt.readByteArray(BytePacketBuilderKt.build((Sink) t5));
                                            T t6 = ref$ObjectRef5.element;
                                            t6.getClass();
                                            boolean rsv1 = ((Frame) t6).getRsv1();
                                            T t7 = ref$ObjectRef5.element;
                                            t7.getClass();
                                            boolean rsv2 = ((Frame) t7).getRsv2();
                                            T t8 = ref$ObjectRef5.element;
                                            t8.getClass();
                                            Frame frameByType = companion.byType(true, frameType, byteArray, rsv1, rsv2, ((Frame) t8).getRsv3());
                                            ref$ObjectRef5.element = null;
                                            Channel channel2 = defaultWebSocketSessionImpl2.filtered;
                                            Frame frameProcessIncomingExtensions2 = defaultWebSocketSessionImpl2.processIncomingExtensions(frameByType);
                                            this.L$0 = coroutineScope3;
                                            this.L$1 = ref$ObjectRef5;
                                            this.L$2 = ref$ObjectRef4;
                                            this.L$3 = ref$BooleanRef2;
                                            this.L$4 = defaultWebSocketSessionImpl2;
                                            this.L$5 = sendChannel3;
                                            this.L$6 = incoming;
                                            this.L$7 = channelIterator2;
                                            this.L$8 = null;
                                            this.label = 8;
                                            if (channel2.send(frameProcessIncomingExtensions2, this) != coroutine_suspended) {
                                                channelIterator = channelIterator2;
                                                receiveChannel2 = incoming;
                                                sendChannel2 = sendChannel3;
                                                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                                ref$BooleanRef = ref$BooleanRef2;
                                                ref$ObjectRef2 = ref$ObjectRef4;
                                                ref$ObjectRef3 = ref$ObjectRef5;
                                                coroutineScope2 = coroutineScope3;
                                                Unit unit7 = Unit.INSTANCE;
                                                CoroutineScope coroutineScope4222 = coroutineScope2;
                                                it = channelIterator;
                                                coroutineScope = coroutineScope4222;
                                                SendChannel sendChannel6222 = sendChannel2;
                                                incoming = receiveChannel2;
                                                ref$ObjectRef = ref$ObjectRef3;
                                                sendChannel = sendChannel6222;
                                            }
                                        }
                                    }
                                }
                                i = 1;
                                this.L$0 = coroutineScope;
                                this.L$1 = ref$ObjectRef;
                                this.L$2 = ref$ObjectRef2;
                                this.L$3 = ref$BooleanRef;
                                this.L$4 = defaultWebSocketSessionImpl;
                                this.L$5 = sendChannel;
                                this.L$6 = incoming;
                                this.L$7 = it;
                                this.L$8 = null;
                                this.label = i;
                                objHasNext = it.hasNext(this);
                                if (objHasNext != coroutine_suspended) {
                                }
                            } else if (!defaultWebSocketSessionImpl.getOutgoing().isClosedForSend()) {
                                SendChannel<Frame> outgoing = defaultWebSocketSessionImpl.getOutgoing();
                                CloseReason reason = FrameCommonKt.readReason((Frame.Close) next);
                                if (reason == null) {
                                    reason = DefaultWebSocketSessionKt.NORMAL_CLOSE;
                                }
                                Frame.Close close = new Frame.Close(reason);
                                this.L$0 = ref$ObjectRef2;
                                this.L$1 = ref$BooleanRef;
                                this.L$2 = receiveChannel2;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.label = 2;
                                if (outgoing.send(close, this) != coroutine_suspended) {
                                    ref$BooleanRef.element = true;
                                    Unit unit8 = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                                    SendChannel.close$default(this.$ponger, null, 1, null);
                                    sink = (Sink) ref$ObjectRef2.element;
                                    if (sink != null) {
                                        sink.close();
                                    }
                                    SendChannel.close$default(DefaultWebSocketSessionImpl.this.filtered, null, 1, null);
                                    if (!ref$BooleanRef.element) {
                                        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl7 = DefaultWebSocketSessionImpl.this;
                                        CloseReason closeReason5 = new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame");
                                        this.L$0 = unit8;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.L$6 = null;
                                        this.L$7 = null;
                                        this.label = 3;
                                        if (WebSocketSessionKt.close(defaultWebSocketSessionImpl7, closeReason5, this) == coroutine_suspended) {
                                        }
                                    }
                                    return unit8;
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        channelIterator = (ChannelIterator) this.L$7;
                        receiveChannel2 = (ReceiveChannel) this.L$6;
                        sendChannel2 = (SendChannel) this.L$5;
                        defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                        ref$BooleanRef = (Ref$BooleanRef) this.L$3;
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
                        ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                        coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objHasNext = obj;
                        if (((Boolean) objHasNext).booleanValue()) {
                        }
                        return coroutine_suspended;
                    case 2:
                        receiveChannel2 = (ReceiveChannel) this.L$2;
                        ref$BooleanRef = (Ref$BooleanRef) this.L$1;
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        ref$BooleanRef.element = true;
                        Unit unit82 = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                        SendChannel.close$default(this.$ponger, null, 1, null);
                        sink = (Sink) ref$ObjectRef2.element;
                        if (sink != null) {
                        }
                        SendChannel.close$default(DefaultWebSocketSessionImpl.this.filtered, null, 1, null);
                        if (!ref$BooleanRef.element) {
                        }
                        return unit82;
                    case 3:
                        Unit unit9 = (Unit) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        return unit9;
                    case 4:
                        channelIterator = (ChannelIterator) this.L$7;
                        receiveChannel2 = (ReceiveChannel) this.L$6;
                        sendChannel2 = (SendChannel) this.L$5;
                        defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                        ref$BooleanRef = (Ref$BooleanRef) this.L$3;
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
                        ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                        coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Unit unit10 = Unit.INSTANCE;
                        CoroutineScope coroutineScope42222 = coroutineScope2;
                        it = channelIterator;
                        coroutineScope = coroutineScope42222;
                        SendChannel sendChannel62222 = sendChannel2;
                        incoming = receiveChannel2;
                        ref$ObjectRef = ref$ObjectRef3;
                        sendChannel = sendChannel62222;
                        i = 1;
                        this.L$0 = coroutineScope;
                        this.L$1 = ref$ObjectRef;
                        this.L$2 = ref$ObjectRef2;
                        this.L$3 = ref$BooleanRef;
                        this.L$4 = defaultWebSocketSessionImpl;
                        this.L$5 = sendChannel;
                        this.L$6 = incoming;
                        this.L$7 = it;
                        this.L$8 = null;
                        this.label = i;
                        objHasNext = it.hasNext(this);
                        if (objHasNext != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 5:
                        channelIterator = (ChannelIterator) this.L$7;
                        receiveChannel2 = (ReceiveChannel) this.L$6;
                        sendChannel2 = (SendChannel) this.L$5;
                        defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                        ref$BooleanRef = (Ref$BooleanRef) this.L$3;
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
                        ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                        coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Unit unit11 = Unit.INSTANCE;
                        CoroutineScope coroutineScope422222 = coroutineScope2;
                        it = channelIterator;
                        coroutineScope = coroutineScope422222;
                        SendChannel sendChannel622222 = sendChannel2;
                        incoming = receiveChannel2;
                        ref$ObjectRef = ref$ObjectRef3;
                        sendChannel = sendChannel622222;
                        i = 1;
                        this.L$0 = coroutineScope;
                        this.L$1 = ref$ObjectRef;
                        this.L$2 = ref$ObjectRef2;
                        this.L$3 = ref$BooleanRef;
                        this.L$4 = defaultWebSocketSessionImpl;
                        this.L$5 = sendChannel;
                        this.L$6 = incoming;
                        this.L$7 = it;
                        this.L$8 = null;
                        this.label = i;
                        objHasNext = it.hasNext(this);
                        if (objHasNext != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 6:
                        Frame frame = (Frame) this.L$8;
                        channelIterator2 = (ChannelIterator) this.L$7;
                        incoming = (ReceiveChannel) this.L$6;
                        sendChannel3 = (SendChannel) this.L$5;
                        defaultWebSocketSessionImpl2 = (DefaultWebSocketSessionImpl) this.L$4;
                        ref$BooleanRef2 = (Ref$BooleanRef) this.L$3;
                        ref$ObjectRef4 = (Ref$ObjectRef) this.L$2;
                        ref$ObjectRef5 = (Ref$ObjectRef) this.L$1;
                        coroutineScope3 = (CoroutineScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            r0 = frame;
                            if (!r0.getFin()) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel = incoming;
                            throw th;
                        }
                        break;
                    case 7:
                        channelIterator = (ChannelIterator) this.L$7;
                        receiveChannel2 = (ReceiveChannel) this.L$6;
                        sendChannel2 = (SendChannel) this.L$5;
                        defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                        ref$BooleanRef = (Ref$BooleanRef) this.L$3;
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
                        ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                        coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope4222222 = coroutineScope2;
                        it = channelIterator;
                        coroutineScope = coroutineScope4222222;
                        SendChannel sendChannel6222222 = sendChannel2;
                        incoming = receiveChannel2;
                        ref$ObjectRef = ref$ObjectRef3;
                        sendChannel = sendChannel6222222;
                        i = 1;
                        this.L$0 = coroutineScope;
                        this.L$1 = ref$ObjectRef;
                        this.L$2 = ref$ObjectRef2;
                        this.L$3 = ref$BooleanRef;
                        this.L$4 = defaultWebSocketSessionImpl;
                        this.L$5 = sendChannel;
                        this.L$6 = incoming;
                        this.L$7 = it;
                        this.L$8 = null;
                        this.label = i;
                        objHasNext = it.hasNext(this);
                        if (objHasNext != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 8:
                        channelIterator = (ChannelIterator) this.L$7;
                        receiveChannel2 = (ReceiveChannel) this.L$6;
                        sendChannel2 = (SendChannel) this.L$5;
                        defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                        ref$BooleanRef = (Ref$BooleanRef) this.L$3;
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
                        ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                        coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Unit unit72 = Unit.INSTANCE;
                        CoroutineScope coroutineScope42222222 = coroutineScope2;
                        it = channelIterator;
                        coroutineScope = coroutineScope42222222;
                        SendChannel sendChannel62222222 = sendChannel2;
                        incoming = receiveChannel2;
                        ref$ObjectRef = ref$ObjectRef3;
                        sendChannel = sendChannel62222222;
                        i = 1;
                        this.L$0 = coroutineScope;
                        this.L$1 = ref$ObjectRef;
                        this.L$2 = ref$ObjectRef2;
                        this.L$3 = ref$BooleanRef;
                        this.L$4 = defaultWebSocketSessionImpl;
                        this.L$5 = sendChannel;
                        this.L$6 = incoming;
                        this.L$7 = it;
                        this.L$8 = null;
                        this.label = i;
                        objHasNext = it.hasNext(this);
                        if (objHasNext != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 9:
                    case 10:
                    case 11:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 12:
                        Throwable th7 = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th7;
                    default:
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", l = {246, 257, 257, 257, 250, 257, 257, 254, 257, 257}, m = "invokeSuspend")
    public static final class C22651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public C22651(Continuation<? super C22651> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultWebSocketSessionImpl.this.new C22651(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        
            if (r10 != r1) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) == r1) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00d3, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r10, null, r7, 1, null) != r1) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x010f, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r10, null, r7, 1, null) != r1) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0128, code lost:
        
            if (io.ktor.websocket.WebSocketSessionKt.close$default(r10, null, r7, 1, null) != r1) goto L55;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:54:0x012a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r10v0, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v16, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1] */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v2, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r10v27, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r10v29, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r10v32 */
        /* JADX WARN: Type inference failed for: r10v33 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v2, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4, types: [kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r7v5, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r7;
            Throwable th;
            ?? r72;
            WebSocketSession webSocketSession;
            ?? r73;
            ?? r10;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    try {
                    } catch (Throwable th2) {
                        r72 = this;
                        th = th2;
                        ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                        webSocketSession = DefaultWebSocketSessionImpl.this.raw;
                        r72.L$0 = th;
                        r72.label = 10;
                        if (WebSocketSessionKt.close$default(webSocketSession, null, r72, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r7 = this;
                    th = th;
                    r72 = r7;
                    ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                    webSocketSession = DefaultWebSocketSessionImpl.this.raw;
                    r72.L$0 = th;
                    r72.label = 10;
                    if (WebSocketSessionKt.close$default(webSocketSession, null, r72, 1, null) == coroutine_suspended) {
                    }
                }
            } catch (CancellationException unused) {
                DefaultWebSocketSessionImpl defaultWebSocketSessionImpl = DefaultWebSocketSessionImpl.this;
                CloseReason closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
                this.label = 5;
                r7 = this;
                try {
                    Object objSendCloseSequence$default = DefaultWebSocketSessionImpl.sendCloseSequence$default(defaultWebSocketSessionImpl, closeReason, null, r7, 2, null);
                    r73 = r7;
                    if (objSendCloseSequence$default != coroutine_suspended) {
                        ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                        WebSocketSession webSocketSession2 = DefaultWebSocketSessionImpl.this.raw;
                        r73.label = 6;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    r72 = r7;
                    ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                    webSocketSession = DefaultWebSocketSessionImpl.this.raw;
                    r72.L$0 = th;
                    r72.label = 10;
                    if (WebSocketSessionKt.close$default(webSocketSession, null, r72, 1, null) == coroutine_suspended) {
                    }
                }
            } catch (ClosedReceiveChannelException unused2) {
                ?? r74 = this;
                ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                WebSocketSession webSocketSession3 = DefaultWebSocketSessionImpl.this.raw;
                r74.label = 4;
            } catch (ClosedSendChannelException unused3) {
                ?? r75 = this;
                ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                WebSocketSession webSocketSession4 = DefaultWebSocketSessionImpl.this.raw;
                r75.label = 3;
            } catch (Throwable th5) {
                DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel(ExceptionsKt.CancellationException("Failed to send frame", th5));
                WebSocketSession webSocketSession5 = DefaultWebSocketSessionImpl.this.raw;
                this.label = 8;
                Object objCloseExceptionally = WebSocketSessionKt.closeExceptionally(webSocketSession5, th5, this);
                r10 = this;
                if (objCloseExceptionally != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    DefaultWebSocketSessionImpl defaultWebSocketSessionImpl2 = DefaultWebSocketSessionImpl.this;
                    this.label = 1;
                    if (defaultWebSocketSessionImpl2.outgoingProcessorLoop(this) != coroutine_suspended) {
                        ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                        WebSocketSession webSocketSession6 = DefaultWebSocketSessionImpl.this.raw;
                        this.label = 2;
                        this = WebSocketSessionKt.close$default(webSocketSession6, null, this, 1, null);
                        break;
                    }
                    return coroutine_suspended;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                    WebSocketSession webSocketSession62 = DefaultWebSocketSessionImpl.this.raw;
                    this.label = 2;
                    this = WebSocketSessionKt.close$default(webSocketSession62, null, this, 1, null);
                    break;
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 9:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                case 5:
                    ResultKt.throwOnFailure(obj);
                    r73 = this;
                    ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                    WebSocketSession webSocketSession22 = DefaultWebSocketSessionImpl.this.raw;
                    r73.label = 6;
                    break;
                case 8:
                    ResultKt.throwOnFailure(obj);
                    this = this;
                    ReceiveChannel.cancel$default(DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, null, 1, null);
                    WebSocketSession webSocketSession7 = DefaultWebSocketSessionImpl.this.raw;
                    r10.label = 9;
                    break;
                case 10:
                    Throwable th6 = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th6;
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {290}, m = "sendCloseSequence")
    public static final class C22661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C22661(Continuation<? super C22661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.sendCloseSequence(null, null, this);
        }
    }

    public DefaultWebSocketSessionImpl(WebSocketSession webSocketSession, long j, long j2) {
        webSocketSession.getClass();
        this.raw = webSocketSession;
        this.pinger = null;
        CompletableDeferred<CloseReason> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.closeReasonRef = completableDeferredCompletableDeferred$default;
        this.filtered = ChannelKt.Channel$default(8, null, null, 6, null);
        this.outgoingToBeProcessed = ChannelKt.Channel$default(UtilsKt.getOUTGOING_CHANNEL_CAPACITY(), null, null, 6, null);
        this.closed = 0;
        CompletableJob completableJobJob = JobKt.Job((Job) webSocketSession.getCoroutineContext().get(Job.INSTANCE));
        this.context = completableJobJob;
        this._extensions = new ArrayList();
        this.started = 0;
        this.coroutineContext = webSocketSession.getCoroutineContext().plus(completableJobJob).plus(new CoroutineName("ws-default"));
        this.pingIntervalMillis = j;
        this.timeoutMillis = j2;
        this.closeReason = completableDeferredCompletableDeferred$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkMaxFrameSize(Sink sink, Frame frame, Continuation<? super Unit> continuation) throws FrameTooBigException {
        AnonymousClass1 anonymousClass1;
        int i;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int length = frame.getData().length + (sink != null ? BytePacketBuilderKt.getSize(sink) : 0);
            if (length <= getMaxFrameSize()) {
                return Unit.INSTANCE;
            }
            if (sink != null) {
                sink.close();
            }
            CloseReason.Codes codes = CloseReason.Codes.TOO_BIG;
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(length, "Frame is too big: ", ". Max size is ");
            sbM65m.append(getMaxFrameSize());
            CloseReason closeReason = new CloseReason(codes, sbM65m.toString());
            anonymousClass1.I$0 = length;
            anonymousClass1.label = 1;
            if (WebSocketSessionKt.close(this, closeReason, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = length;
        } else {
            if (i3 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
        }
        throw new FrameTooBigException(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
    
        if (sendCloseSequence$default(r7, r8, null, r10, 2, null) == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00d8 -> B:20:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object outgoingProcessorLoop(Continuation<? super Unit> continuation) {
        C22631 c22631;
        ChannelIterator<Frame> it;
        ChannelIterator<Frame> channelIterator;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        if (continuation instanceof C22631) {
            c22631 = (C22631) continuation;
            int i = c22631.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22631.label = i - Integer.MIN_VALUE;
            } else {
                c22631 = new C22631(continuation);
            }
        }
        Object obj = c22631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22631.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            it = this.outgoingToBeProcessed.iterator();
        } else {
            if (i2 == 1) {
                channelIterator = (ChannelIterator) c22631.L$1;
                DefaultWebSocketSessionImpl defaultWebSocketSessionImpl2 = (DefaultWebSocketSessionImpl) c22631.L$0;
                ResultKt.throwOnFailure(obj);
                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                C22631 c226312 = c22631;
                if (((Boolean) obj).booleanValue()) {
                    Frame next = channelIterator.next();
                    Logger logger = DefaultWebSocketSessionKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Sending " + next + " from session " + defaultWebSocketSessionImpl);
                    }
                    if (next instanceof Frame.Close) {
                        CloseReason reason = FrameCommonKt.readReason((Frame.Close) next);
                        c226312.L$0 = null;
                        c226312.L$1 = null;
                        c226312.label = 2;
                    } else {
                        if ((next instanceof Frame.Text) || (next instanceof Frame.Binary)) {
                            next = defaultWebSocketSessionImpl.processOutgoingExtensions(next);
                        }
                        SendChannel<Frame> outgoing = defaultWebSocketSessionImpl.raw.getOutgoing();
                        c226312.L$0 = defaultWebSocketSessionImpl;
                        c226312.L$1 = channelIterator;
                        c226312.label = 3;
                        if (outgoing.send(next, c226312) != coroutine_suspended) {
                            it = channelIterator;
                            this = defaultWebSocketSessionImpl;
                            c22631 = c226312;
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i2 != 3) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ChannelIterator<Frame> channelIterator2 = (ChannelIterator) c22631.L$1;
            DefaultWebSocketSessionImpl defaultWebSocketSessionImpl3 = (DefaultWebSocketSessionImpl) c22631.L$0;
            ResultKt.throwOnFailure(obj);
            it = channelIterator2;
            this = defaultWebSocketSessionImpl3;
        }
        c22631.L$0 = this;
        c22631.L$1 = it;
        c22631.label = 1;
        Object objHasNext = it.hasNext(c22631);
        if (objHasNext != coroutine_suspended) {
            defaultWebSocketSessionImpl = this;
            channelIterator = it;
            obj = objHasNext;
            C22631 c2263122 = c22631;
            if (((Boolean) obj).booleanValue()) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Frame processIncomingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        return frame;
    }

    private final Frame processOutgoingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        return frame;
    }

    private final Job runIncomingProcessor(SendChannel<? super Frame.Ping> ponger) {
        return BuildersKt__Builders_commonKt.launch$default(this, DefaultWebSocketSessionKt.IncomingProcessorCoroutineName.plus(Dispatchers.getUnconfined()), null, new C22641(ponger, null), 2, null);
    }

    private final void runOrCancelPinger() {
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        SendChannel<Frame.Pong> sendChannelPinger;
        long pingIntervalMillis = getPingIntervalMillis();
        if (this.closed == 0 && pingIntervalMillis > 0) {
            defaultWebSocketSessionImpl = this;
            sendChannelPinger = PingPongKt.pinger(defaultWebSocketSessionImpl, this.raw.getOutgoing(), pingIntervalMillis, getTimeoutMillis(), new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null));
        } else {
            defaultWebSocketSessionImpl = this;
            sendChannelPinger = null;
        }
        SendChannel sendChannel = (SendChannel) pinger$FU.getAndSet(defaultWebSocketSessionImpl, sendChannelPinger);
        if (sendChannel != null) {
            SendChannel.close$default(sendChannel, null, 1, null);
        }
        if (sendChannelPinger != null) {
            ChannelResult.m2591isSuccessimpl(sendChannelPinger.mo2581trySendJP2dKIU(EmptyPong));
        }
        if (defaultWebSocketSessionImpl.closed == 0 || sendChannelPinger == null) {
            return;
        }
        defaultWebSocketSessionImpl.runOrCancelPinger();
    }

    private final Job runOutgoingProcessor() {
        return BuildersKt.launch(this, DefaultWebSocketSessionKt.OutgoingProcessorCoroutineName.plus(Dispatchers.getUnconfined()), CoroutineStart.UNDISPATCHED, new C22651(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendCloseSequence(CloseReason closeReason, Throwable th, Continuation<? super Unit> continuation) throws Throwable {
        C22661 c22661;
        if (continuation instanceof C22661) {
            c22661 = (C22661) continuation;
            int i = c22661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22661.label = i - Integer.MIN_VALUE;
            } else {
                c22661 = new C22661(continuation);
            }
        }
        Object obj = c22661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22661.label;
        if (i2 != 0) {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            CloseReason closeReason2 = (CloseReason) c22661.L$2;
            th = (Throwable) c22661.L$1;
            DefaultWebSocketSessionImpl defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) c22661.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                closeReason = closeReason2;
                this = defaultWebSocketSessionImpl;
                this.closeReasonRef.complete(closeReason);
                if (th != null) {
                    this.outgoingToBeProcessed.close(th);
                    this.filtered.close(th);
                }
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                closeReason = closeReason2;
                this = defaultWebSocketSessionImpl;
                this.closeReasonRef.complete(closeReason);
                if (th != null) {
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        if (!tryClose()) {
            return Unit.INSTANCE;
        }
        Logger logger = DefaultWebSocketSessionKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Sending Close Sequence for session " + this + " with reason " + closeReason + " and exception " + th);
        }
        this.context.complete();
        if (closeReason == null) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
        }
        try {
            runOrCancelPinger();
            if (closeReason.getCode() != CloseReason.Codes.CLOSED_ABNORMALLY.getCode()) {
                SendChannel<Frame> outgoing = this.raw.getOutgoing();
                Frame.Close close = new Frame.Close(closeReason);
                c22661.L$0 = this;
                c22661.L$1 = th;
                c22661.L$2 = closeReason;
                c22661.label = 1;
                if (outgoing.send(close, c22661) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.closeReasonRef.complete(closeReason);
            if (th != null) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            this.closeReasonRef.complete(closeReason);
            if (th != null) {
                this.outgoingToBeProcessed.close(th);
                this.filtered.close(th);
            }
            throw th;
        }
    }

    public static /* synthetic */ Object sendCloseSequence$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, CloseReason closeReason, Throwable th, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return defaultWebSocketSessionImpl.sendCloseSequence(closeReason, th, continuation);
    }

    private final boolean tryClose() {
        return closed$FU.compareAndSet(this, 0, 1);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation<? super Unit> continuation) {
        Object objFlush = this.raw.flush(continuation);
        return objFlush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlush : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public List<WebSocketExtension<?>> getExtensions() {
        return this._extensions;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.raw.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this.outgoingToBeProcessed;
    }

    public long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return DefaultWebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.raw.setMaxFrameSize(j);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        negotiatedExtensions.getClass();
        if (!started$FU.compareAndSet(this, 0, 1)) {
            Utf8$$ExternalSyntheticBUOutline0.m("WebSocket session ", (Object) this, (Object) " is already started.");
            return;
        }
        Logger logger = DefaultWebSocketSessionKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt.joinToString$default(negotiatedExtensions, null, null, null, null, 63));
        }
        this._extensions.addAll(negotiatedExtensions);
        runOrCancelPinger();
        runIncomingProcessor(PingPongKt.ponger(this, getOutgoing()));
        runOutgoingProcessor();
    }
}
