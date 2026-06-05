package com.urbandroid.sleep.smartwatch.phaser;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.bluetoothle.BLEUtilKt;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0013\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\u0010\u0019J9\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rj\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/smartwatch/phaser/CoroutineRunner;", "", "<init>", "()V", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "lastCallLogFlush", "Ljava/util/concurrent/atomic/AtomicLong;", "callLog", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "runBlocking", "", "timeoutMillis", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;)V", "launch", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "scheduleWithFixedDelay", "initialDelayMillis", "delayMillis", "(JJLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "cancelAllTasks", "BlockWrapper", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CoroutineRunner {
    private final StringBuilder callLog;
    private final AtomicLong lastCallLogFlush;
    private final Mutex mutex;
    private final CoroutineScope scope;
    private final CompletableJob supervisorJob;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B%\u0012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004H\u0086B¢\u0006\u0004\b\b\u0010\tR-\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/phaser/CoroutineRunner$BlockWrapper;", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "<init>", "(Lcom/urbandroid/sleep/smartwatch/phaser/CoroutineRunner;Lkotlin/jvm/functions/Function1;)V", "invoke", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "getBlock", "()Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastInvocation", "Ljava/util/concurrent/atomic/AtomicLong;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class BlockWrapper {
        private final Function1<Continuation<? super Unit>, Object> block;
        private final AtomicLong lastInvocation;
        final /* synthetic */ CoroutineRunner this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public BlockWrapper(CoroutineRunner coroutineRunner, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
            function1.getClass();
            this.this$0 = coroutineRunner;
            this.block = function1;
            this.lastInvocation = new AtomicLong(0L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x018e  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x01dd  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invoke(Continuation<? super Unit> continuation) throws Throwable {
            CoroutineRunner$BlockWrapper$invoke$1 coroutineRunner$BlockWrapper$invoke$1;
            long j;
            long j2;
            long jCurrentTimeMillis;
            long j3;
            long j4;
            long jCurrentTimeMillis2;
            StringBuilder sb;
            StringBuilder sb2;
            if (continuation instanceof CoroutineRunner$BlockWrapper$invoke$1) {
                CoroutineRunner$BlockWrapper$invoke$1 coroutineRunner$BlockWrapper$invoke$12 = (CoroutineRunner$BlockWrapper$invoke$1) continuation;
                int i = coroutineRunner$BlockWrapper$invoke$12.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    coroutineRunner$BlockWrapper$invoke$12.label = i - Integer.MIN_VALUE;
                    coroutineRunner$BlockWrapper$invoke$1 = coroutineRunner$BlockWrapper$invoke$12;
                } else {
                    coroutineRunner$BlockWrapper$invoke$1 = new CoroutineRunner$BlockWrapper$invoke$1(this, continuation);
                }
            }
            Object obj = coroutineRunner$BlockWrapper$invoke$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = coroutineRunner$BlockWrapper$invoke$1.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    j = 120000;
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    try {
                        Function1<Continuation<? super Unit>, Object> function1 = this.block;
                        coroutineRunner$BlockWrapper$invoke$1.J$0 = jCurrentTimeMillis3;
                        coroutineRunner$BlockWrapper$invoke$1.label = 1;
                        if (function1.invoke(coroutineRunner$BlockWrapper$invoke$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j4 = jCurrentTimeMillis3;
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (this.lastInvocation.get() > 0) {
                        }
                        this.lastInvocation.set(jCurrentTimeMillis2);
                        this.this$0.callLog.append("D:" + (jCurrentTimeMillis2 - j4) + ",");
                        if (jCurrentTimeMillis2 - this.this$0.lastCallLogFlush.get() > j) {
                        }
                    } catch (Error e) {
                        e = e;
                        Logger.logSevere("SleepPhaser async task error", e);
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        j3 = jCurrentTimeMillis3;
                        Logger.logSevere("SleepPhaser async task error", e);
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (this.lastInvocation.get() > 0) {
                            this.this$0.callLog.append("L:" + (jCurrentTimeMillis2 - this.lastInvocation.get()) + ",");
                        }
                        this.lastInvocation.set(jCurrentTimeMillis2);
                        this.this$0.callLog.append("D:" + (jCurrentTimeMillis2 - j3) + ",");
                        if (jCurrentTimeMillis2 - this.this$0.lastCallLogFlush.get() > j) {
                            sb = this.this$0.callLog;
                            sb2 = new StringBuilder("CoroutineRunner: ");
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        j2 = jCurrentTimeMillis3;
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (this.lastInvocation.get() > 0) {
                            this.this$0.callLog.append("L:" + (jCurrentTimeMillis - this.lastInvocation.get()) + ",");
                        }
                        this.lastInvocation.set(jCurrentTimeMillis);
                        this.this$0.callLog.append("D:" + (jCurrentTimeMillis - j2) + ",");
                        if (jCurrentTimeMillis - this.this$0.lastCallLogFlush.get() > j) {
                            Logger.logInfo("CoroutineRunner: " + ((Object) this.this$0.callLog));
                            this.this$0.callLog.delete(0, this.this$0.callLog.length());
                            this.this$0.lastCallLogFlush.set(jCurrentTimeMillis);
                        }
                        throw th;
                    }
                } else {
                    if (i2 != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    long j5 = coroutineRunner$BlockWrapper$invoke$1.J$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        j = 120000;
                        j4 = j5;
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (this.lastInvocation.get() > 0) {
                            this.this$0.callLog.append("L:" + (jCurrentTimeMillis2 - this.lastInvocation.get()) + ",");
                        }
                        this.lastInvocation.set(jCurrentTimeMillis2);
                        this.this$0.callLog.append("D:" + (jCurrentTimeMillis2 - j4) + ",");
                    } catch (Error e3) {
                        e = e3;
                        Logger.logSevere("SleepPhaser async task error", e);
                        throw e;
                    } catch (Exception e4) {
                        e = e4;
                        j = 120000;
                        j3 = j5;
                        Logger.logSevere("SleepPhaser async task error", e);
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (this.lastInvocation.get() > 0) {
                        }
                        this.lastInvocation.set(jCurrentTimeMillis2);
                        this.this$0.callLog.append("D:" + (jCurrentTimeMillis2 - j3) + ",");
                        if (jCurrentTimeMillis2 - this.this$0.lastCallLogFlush.get() > j) {
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        j = 120000;
                        j2 = j5;
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (this.lastInvocation.get() > 0) {
                        }
                        this.lastInvocation.set(jCurrentTimeMillis);
                        this.this$0.callLog.append("D:" + (jCurrentTimeMillis - j2) + ",");
                        if (jCurrentTimeMillis - this.this$0.lastCallLogFlush.get() > j) {
                        }
                        throw th;
                    }
                    if (jCurrentTimeMillis2 - this.this$0.lastCallLogFlush.get() > j) {
                        sb = this.this$0.callLog;
                        sb2 = new StringBuilder("CoroutineRunner: ");
                        sb2.append((Object) sb);
                        Logger.logInfo(sb2.toString());
                        this.this$0.callLog.delete(0, this.this$0.callLog.length());
                        this.this$0.lastCallLogFlush.set(jCurrentTimeMillis2);
                    }
                }
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th = th3;
                j2 = coroutineRunner$BlockWrapper$invoke$1;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner$launch$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner$launch$1", f = "CoroutineRunner.kt", l = {147, 51}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CoroutineRunner.this.new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            CoroutineRunner coroutineRunner;
            Function1<Continuation<? super Unit>, Object> function1;
            int i;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = CoroutineRunner.this.mutex;
                    coroutineRunner = CoroutineRunner.this;
                    Function1<Continuation<? super Unit>, Object> function12 = this.$block;
                    this.L$0 = mutex;
                    this.L$1 = coroutineRunner;
                    this.L$2 = function12;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        function1 = function12;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                i = this.I$0;
                function1 = (Function1) this.L$2;
                coroutineRunner = (CoroutineRunner) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                BlockWrapper blockWrapper = new BlockWrapper(coroutineRunner, function1);
                this.L$0 = mutex;
                this.L$1 = null;
                this.L$2 = null;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (blockWrapper.invoke(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner$runBlocking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner$runBlocking$1", f = "CoroutineRunner.kt", l = {147, 41}, m = "invokeSuspend", v = 2)
    public static final class C21921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ long $timeoutMillis;
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21921(long j, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C21921> continuation) {
            super(2, continuation);
            this.$timeoutMillis = j;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CoroutineRunner.this.new C21921(this.$timeoutMillis, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            long j;
            CoroutineRunner coroutineRunner;
            Function1<Continuation<? super Unit>, Object> function1;
            int i;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = CoroutineRunner.this.mutex;
                    j = this.$timeoutMillis;
                    coroutineRunner = CoroutineRunner.this;
                    Function1<Continuation<? super Unit>, Object> function12 = this.$block;
                    this.L$0 = mutex;
                    this.L$1 = coroutineRunner;
                    this.L$2 = function12;
                    this.J$0 = j;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        function1 = function12;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                i = this.I$0;
                j = this.J$0;
                function1 = (Function1) this.L$2;
                coroutineRunner = (CoroutineRunner) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                CoroutineRunner$runBlocking$1$1$1 coroutineRunner$runBlocking$1$1$1 = new CoroutineRunner$runBlocking$1$1$1(coroutineRunner, function1, null);
                this.L$0 = mutex;
                this.L$1 = null;
                this.L$2 = null;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (TimeoutKt.withTimeout(j, coroutineRunner$runBlocking$1$1$1, this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner$scheduleWithFixedDelay$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner$scheduleWithFixedDelay$2", f = "CoroutineRunner.kt", l = {147, 64}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ BlockWrapper $wrapper;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(BlockWrapper blockWrapper, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$wrapper = blockWrapper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CoroutineRunner.this.new AnonymousClass2(this.$wrapper, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            BlockWrapper blockWrapper;
            int i;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = CoroutineRunner.this.mutex;
                    BlockWrapper blockWrapper2 = this.$wrapper;
                    this.L$0 = mutex;
                    this.L$1 = blockWrapper2;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        blockWrapper = blockWrapper2;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                i = this.I$0;
                blockWrapper = (BlockWrapper) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.L$0 = mutex;
                this.L$1 = null;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (blockWrapper.invoke(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    public CoroutineRunner() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.lastCallLogFlush = new AtomicLong(System.currentTimeMillis());
        this.callLog = new StringBuilder();
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("SleepPhaser async task error"), FrequencyGuards.maxCountPerInterval(10, 10), 0, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean scheduleWithFixedDelay$lambda$0() {
        return true;
    }

    public final void cancelAllTasks() {
        JobKt.cancelChildren(this.supervisorJob, new CancellationException("CoroutineRunner.cancelAllTasks()"));
    }

    public final Job launch(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        block.getClass();
        return BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(block, null), 3, null);
    }

    public final void runBlocking(long timeoutMillis, Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        block.getClass();
        BuildersKt.runBlockingK(this.scope.getCoroutineContext(), new C21921(timeoutMillis, block, null));
    }

    public final Job scheduleWithFixedDelay(long initialDelayMillis, long delayMillis, Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        block.getClass();
        return BLEUtilKt.runWithFixedDelay(this.scope, initialDelayMillis, delayMillis, new HttpClientConfig$$ExternalSyntheticLambda4(10), new AnonymousClass2(new BlockWrapper(this, block), null));
    }
}
