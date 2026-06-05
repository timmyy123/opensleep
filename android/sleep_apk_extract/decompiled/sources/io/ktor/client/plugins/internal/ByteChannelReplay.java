package io.ktor.client.plugins.internal;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/client/plugins/internal/ByteChannelReplay;", "", "Lio/ktor/utils/io/ByteReadChannel;", "origin", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;)V", "replay", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "CopyFromSourceTask", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteChannelReplay {
    private static final /* synthetic */ AtomicReferenceFieldUpdater content$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannelReplay.class, Object.class, "content");
    private volatile /* synthetic */ Object content;
    private final ByteReadChannel origin;

    /* JADX INFO: renamed from: io.ktor.client.plugins.internal.ByteChannelReplay$replay$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.internal.ByteChannelReplay$replay$1", f = "ByteChannelReplay.kt", l = {33, 34}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref$ObjectRef<CopyFromSourceTask> $copyTask;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$ObjectRef<CopyFromSourceTask> ref$ObjectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$copyTask = ref$ObjectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$copyTask, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
        
            if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r3, (byte[]) r11, 0, 0, r10, 6, null) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            WriterScope writerScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                writerScope = (WriterScope) this.L$0;
                CopyFromSourceTask copyFromSourceTask = this.$copyTask.element;
                copyFromSourceTask.getClass();
                this.L$0 = writerScope;
                this.label = 1;
                obj = copyFromSourceTask.awaitImpatiently(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            writerScope = (WriterScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            ByteWriteChannel channel = writerScope.getChannel();
            this.L$0 = null;
            this.label = 2;
        }
    }

    public ByteChannelReplay(ByteReadChannel byteReadChannel) {
        byteReadChannel.getClass();
        this.origin = byteReadChannel;
        this.content = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, io.ktor.client.plugins.internal.ByteChannelReplay$CopyFromSourceTask, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v8, types: [T, java.lang.Object] */
    public final ByteReadChannel replay() throws Throwable {
        if (this.origin.getClosedCause() != null) {
            Throwable closedCause = this.origin.getClosedCause();
            closedCause.getClass();
            throw closedCause;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r1 = this.content;
        ref$ObjectRef.element = r1;
        CompletableDeferred completableDeferred = null;
        Object[] objArr = 0;
        if (r1 == 0) {
            ?? copyFromSourceTask = new CopyFromSourceTask(this, completableDeferred, 1, objArr == true ? 1 : 0);
            ref$ObjectRef.element = copyFromSourceTask;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = content$FU;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, copyFromSourceTask)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    ref$ObjectRef.element = this.content;
                }
            }
            return ((CopyFromSourceTask) ref$ObjectRef.element).start();
        }
        return ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, null, false, new AnonymousClass1(ref$ObjectRef, null), 3, null).getChannel();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/client/plugins/internal/ByteChannelReplay$CopyFromSourceTask;", "", "Lkotlinx/coroutines/CompletableDeferred;", "", "savedResponse", "<init>", "(Lio/ktor/client/plugins/internal/ByteChannelReplay;Lkotlinx/coroutines/CompletableDeferred;)V", "Lio/ktor/utils/io/ByteReadChannel;", "start", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/WriterJob;", "receiveBody", "()Lio/ktor/utils/io/WriterJob;", "awaitImpatiently", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableDeferred;", "getSavedResponse", "()Lkotlinx/coroutines/CompletableDeferred;", "writerJob", "Lio/ktor/utils/io/WriterJob;", "getWriterJob", "setWriterJob", "(Lio/ktor/utils/io/WriterJob;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class CopyFromSourceTask {
        private final CompletableDeferred<byte[]> savedResponse;
        final /* synthetic */ ByteChannelReplay this$0;
        public WriterJob writerJob;

        public /* synthetic */ CopyFromSourceTask(ByteChannelReplay byteChannelReplay, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(byteChannelReplay, (i & 1) != 0 ? CompletableDeferredKt.CompletableDeferred$default(null, 1, null) : completableDeferred);
        }

        public final Object awaitImpatiently(Continuation<? super byte[]> continuation) {
            if (!ByteWriteChannelOperationsKt.isCompleted(getWriterJob())) {
                getWriterJob().getChannel().cancel(new SaveBodyAbandonedReadException());
            }
            return this.savedResponse.await(continuation);
        }

        public final CompletableDeferred<byte[]> getSavedResponse() {
            return this.savedResponse;
        }

        public final WriterJob getWriterJob() {
            WriterJob writerJob = this.writerJob;
            if (writerJob != null) {
                return writerJob;
            }
            Intrinsics.throwUninitializedPropertyAccessException("writerJob");
            return null;
        }

        public final WriterJob receiveBody() {
            return ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), false, new ByteChannelReplay$CopyFromSourceTask$receiveBody$1(this.this$0, this, null), 2, null);
        }

        public final void setWriterJob(WriterJob writerJob) {
            writerJob.getClass();
            this.writerJob = writerJob;
        }

        public final ByteReadChannel start() {
            setWriterJob(receiveBody());
            return getWriterJob().getChannel();
        }

        public CopyFromSourceTask(ByteChannelReplay byteChannelReplay, CompletableDeferred<byte[]> completableDeferred) {
            completableDeferred.getClass();
            this.this$0 = byteChannelReplay;
            this.savedResponse = completableDeferred;
        }
    }
}
