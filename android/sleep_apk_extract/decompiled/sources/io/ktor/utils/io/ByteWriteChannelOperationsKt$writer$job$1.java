package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt$writer$job$1", f = "ByteWriteChannelOperations.kt", l = {142, 152, 153, 152, 153, 152, 153}, m = "invokeSuspend")
public final class ByteWriteChannelOperationsKt$writer$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<WriterScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ ByteChannel $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ByteWriteChannelOperationsKt$writer$job$1(Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object> function2, ByteChannel byteChannel, Continuation<? super ByteWriteChannelOperationsKt$writer$job$1> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$channel = byteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ByteWriteChannelOperationsKt$writer$job$1 byteWriteChannelOperationsKt$writer$job$1 = new ByteWriteChannelOperationsKt$writer$job$1(this.$block, this.$channel, continuation);
        byteWriteChannelOperationsKt$writer$job$1.L$0 = obj;
        return byteWriteChannelOperationsKt$writer$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteWriteChannelOperationsKt$writer$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #1 {all -> 0x0051, blocks: (B:19:0x004d, B:27:0x0088, B:29:0x0099, B:24:0x0068), top: B:71:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0129  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v7, types: [kotlinx.coroutines.CompletableJob, kotlinx.coroutines.Job] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        ByteChannel byteChannel;
        Unit unit;
        ByteChannel byteChannel2;
        Throwable th;
        Throwable th2;
        CoroutineScope coroutineScope;
        ByteChannel byteChannel3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
            try {
            } catch (Throwable th3) {
                try {
                    JobKt.cancel(r1, "Exception thrown while writing to channel", th3);
                    this.$channel.cancel(th3);
                    this.L$0 = coroutineScope;
                    this.L$1 = null;
                    this.label = 4;
                    if (r1.join(this) != coroutine_suspended) {
                        byteChannel = this.$channel;
                        Result.Companion companion = Result.INSTANCE;
                        this.L$0 = null;
                        this.label = 5;
                        if (byteChannel.flushAndClose(this) == coroutine_suspended) {
                        }
                        unit = Unit.INSTANCE;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    this.L$0 = coroutineScope;
                    this.L$1 = th;
                    this.label = 6;
                    if (r1.join(this) != coroutine_suspended) {
                        byteChannel2 = this.$channel;
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            this.L$0 = th;
                            this.L$1 = null;
                            this.label = 7;
                            if (byteChannel2.flushAndClose(this) != coroutine_suspended) {
                            }
                        } catch (Throwable th5) {
                            Throwable th6 = th;
                            th = th5;
                            th2 = th6;
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m2357constructorimpl(ResultKt.createFailure(th));
                            throw th2;
                        }
                    }
                }
                return coroutine_suspended;
            }
        } catch (Throwable th7) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m2357constructorimpl(ResultKt.createFailure(th7));
        }
        switch (r1) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                CompletableJob completableJobJob = JobKt.Job(JobKt.getJob(coroutineScope.getCoroutineContext()));
                Function2<WriterScope, Continuation<? super Unit>, Object> function2 = this.$block;
                WriterScope writerScope = new WriterScope(this.$channel, coroutineScope.getCoroutineContext().plus(completableJobJob));
                this.L$0 = coroutineScope;
                this.L$1 = completableJobJob;
                this.label = 1;
                r1 = completableJobJob;
                if (function2.invoke(writerScope, this) != coroutine_suspended) {
                    r1.complete();
                    if (JobKt.getJob(coroutineScope.getCoroutineContext()).isCancelled()) {
                        this.$channel.cancel(JobKt.getJob(coroutineScope.getCoroutineContext()).getCancellationException());
                    }
                    this.L$0 = coroutineScope;
                    this.L$1 = null;
                    this.label = 2;
                    if (r1.join(this) != coroutine_suspended) {
                        byteChannel3 = this.$channel;
                        Result.Companion companion5 = Result.INSTANCE;
                        this.L$0 = null;
                        this.label = 3;
                        if (byteChannel3.flushAndClose(this) == coroutine_suspended) {
                        }
                        unit = Unit.INSTANCE;
                        Result.m2357constructorimpl(unit);
                        return Unit.INSTANCE;
                    }
                    break;
                }
                return coroutine_suspended;
            case 1:
                CompletableJob completableJob = (CompletableJob) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                r1 = completableJob;
                r1.complete();
                if (JobKt.getJob(coroutineScope.getCoroutineContext()).isCancelled()) {
                }
                this.L$0 = coroutineScope;
                this.L$1 = null;
                this.label = 2;
                if (r1.join(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                ResultKt.throwOnFailure(obj);
                byteChannel3 = this.$channel;
                Result.Companion companion52 = Result.INSTANCE;
                this.L$0 = null;
                this.label = 3;
                if (byteChannel3.flushAndClose(this) == coroutine_suspended) {
                }
                unit = Unit.INSTANCE;
                Result.m2357constructorimpl(unit);
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure(obj);
                unit = Unit.INSTANCE;
                Result.m2357constructorimpl(unit);
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure(obj);
                byteChannel = this.$channel;
                Result.Companion companion6 = Result.INSTANCE;
                this.L$0 = null;
                this.label = 5;
                if (byteChannel.flushAndClose(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                unit = Unit.INSTANCE;
                Result.m2357constructorimpl(unit);
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure(obj);
                unit = Unit.INSTANCE;
                Result.m2357constructorimpl(unit);
                return Unit.INSTANCE;
            case 6:
                Throwable th8 = (Throwable) this.L$1;
                ResultKt.throwOnFailure(obj);
                th = th8;
                byteChannel2 = this.$channel;
                Result.Companion companion22 = Result.INSTANCE;
                this.L$0 = th;
                this.L$1 = null;
                this.label = 7;
                if (byteChannel2.flushAndClose(this) != coroutine_suspended) {
                    th2 = th;
                    Result.m2357constructorimpl(Unit.INSTANCE);
                    throw th2;
                }
                return coroutine_suspended;
            case 7:
                th2 = (Throwable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Result.m2357constructorimpl(Unit.INSTANCE);
                    throw th2;
                } catch (Throwable th9) {
                    th = th9;
                    Result.Companion companion32 = Result.INSTANCE;
                    Result.m2357constructorimpl(ResultKt.createFailure(th));
                    throw th2;
                }
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
