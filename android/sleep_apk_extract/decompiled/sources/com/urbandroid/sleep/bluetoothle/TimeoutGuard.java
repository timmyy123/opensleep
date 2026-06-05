package com.urbandroid.sleep.bluetoothle;

import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u001e\b\u0002\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\rJ\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R-\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/urbandroid/sleep/bluetoothle/TimeoutGuard;", "", "", "timeoutMillis", "Lkotlin/Function0;", "now", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "timeoutReachedCallback", "<init>", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "refresh", "()V", "", "timeoutReached", "()Z", "startAsyncCheck", "stopAsyncCheck", "J", "getTimeoutMillis", "()J", "Lkotlin/jvm/functions/Function0;", "getNow", "()Lkotlin/jvm/functions/Function0;", "Lkotlin/jvm/functions/Function1;", "getTimeoutReachedCallback", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastRefresh", "Ljava/util/concurrent/atomic/AtomicLong;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TimeoutGuard {
    private final AtomicLong lastRefresh;
    private final Function0<Long> now;
    private final CoroutineScope scope;
    private final CompletableJob supervisorJob;
    private final long timeoutMillis;
    private final Function1<Continuation<? super Unit>, Object> timeoutReachedCallback;

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.TimeoutGuard$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.TimeoutGuard$2", f = "TimeoutGuard.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.TimeoutGuard$startAsyncCheck$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.TimeoutGuard$startAsyncCheck$2", f = "TimeoutGuard.kt", l = {25}, m = "invokeSuspend", v = 2)
    public static final class C20972 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public C20972(Continuation<? super C20972> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return TimeoutGuard.this.new C20972(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C20972) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (TimeoutGuard.this.timeoutReached()) {
                    Function1<Continuation<? super Unit>, Object> timeoutReachedCallback = TimeoutGuard.this.getTimeoutReachedCallback();
                    this.label = 1;
                    if (timeoutReachedCallback.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            TimeoutGuard.this.refresh();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TimeoutGuard(long j, Function0<Long> function0, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        function0.getClass();
        function1.getClass();
        this.timeoutMillis = j;
        this.now = function0;
        this.timeoutReachedCallback = function1;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(completableJobSupervisorJob$default));
        this.lastRefresh = new AtomicLong(function0.invoke().longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startAsyncCheck$lambda$0() {
        return true;
    }

    public final Function1<Continuation<? super Unit>, Object> getTimeoutReachedCallback() {
        return this.timeoutReachedCallback;
    }

    public final void refresh() {
        this.lastRefresh.set(this.now.invoke().longValue());
    }

    public final void startAsyncCheck() {
        long j = this.timeoutMillis / 4;
        BLEUtilKt.runWithFixedDelay(this.scope, j, j, new Tool$$ExternalSyntheticLambda0(27), new C20972(null));
    }

    public final void stopAsyncCheck() {
        JobKt.cancelChildren(this.supervisorJob, new CancellationException("TimeoutGuard.stopAsyncCheck()"));
    }

    public final boolean timeoutReached() {
        return this.now.invoke().longValue() - this.lastRefresh.get() > this.timeoutMillis;
    }

    public /* synthetic */ TimeoutGuard(long j, Function0 function0, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? new Tool$$ExternalSyntheticLambda0(26) : function0, (i & 4) != 0 ? new AnonymousClass2(null) : function1);
    }
}
