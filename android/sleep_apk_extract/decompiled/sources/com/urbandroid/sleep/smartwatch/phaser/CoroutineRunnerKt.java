package com.urbandroid.sleep.smartwatch.phaser;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.bluetoothle.BluetoothException;
import com.urbandroid.sleep.smartwatch.phaser.protocol.SleepPhaserBLEClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aB\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a:\u0010\u000b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0086@¢\u0006\u0002\u0010\f\u001a\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u000f\u001a\u000e\u0010\u0010\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"retryWithReconnect", "R", "phaser", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;", "retryCount", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reconnectBefore", "(Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reconnect", "", "(Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shortDelay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class CoroutineRunnerKt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.CoroutineRunnerKt$reconnect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.CoroutineRunnerKt", f = "CoroutineRunner.kt", l = {133, 134, 135}, m = "reconnect", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineRunnerKt.reconnect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.CoroutineRunnerKt$reconnectBefore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.CoroutineRunnerKt", f = "CoroutineRunner.kt", l = {127, 128}, m = "reconnectBefore", v = 2)
    public static final class C21931<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C21931(Continuation<? super C21931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineRunnerKt.reconnectBefore(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.CoroutineRunnerKt$retryWithReconnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.CoroutineRunnerKt", f = "CoroutineRunner.kt", l = {113, 114}, m = "retryWithReconnect", v = 2)
    public static final class C21941<R> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C21941(Continuation<? super C21941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineRunnerKt.retryWithReconnect(null, 0, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
    
        if (r6.connect(r0) != r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object reconnect(SleepPhaserBLEClient sleepPhaserBLEClient, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
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
            if (sleepPhaserBLEClient.isConnected()) {
                return Unit.INSTANCE;
            }
            anonymousClass1.L$0 = sleepPhaserBLEClient;
            anonymousClass1.label = 1;
            if (sleepPhaserBLEClient.disconnectSync(anonymousClass1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            sleepPhaserBLEClient = (SleepPhaserBLEClient) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            sleepPhaserBLEClient = (SleepPhaserBLEClient) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(sleepPhaserBLEClient);
            anonymousClass1.label = 3;
        }
        anonymousClass1.L$0 = sleepPhaserBLEClient;
        anonymousClass1.label = 2;
        if (shortDelay(anonymousClass1) != coroutine_suspended) {
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(sleepPhaserBLEClient);
            anonymousClass1.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object reconnectBefore(SleepPhaserBLEClient sleepPhaserBLEClient, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        C21931 c21931;
        if (continuation instanceof C21931) {
            c21931 = (C21931) continuation;
            int i = c21931.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21931.label = i - Integer.MIN_VALUE;
            } else {
                c21931 = new C21931(continuation);
            }
        }
        Object obj = c21931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21931.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c21931.L$0 = SpillingKt.nullOutSpilledVariable(sleepPhaserBLEClient);
            c21931.L$1 = function1;
            c21931.label = 1;
            if (reconnect(sleepPhaserBLEClient, c21931) != coroutine_suspended) {
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        function1 = (Function1) c21931.L$1;
        sleepPhaserBLEClient = (SleepPhaserBLEClient) c21931.L$0;
        ResultKt.throwOnFailure(obj);
        c21931.L$0 = SpillingKt.nullOutSpilledVariable(sleepPhaserBLEClient);
        c21931.L$1 = SpillingKt.nullOutSpilledVariable(function1);
        c21931.label = 2;
        Object objInvoke = function1.invoke(c21931);
        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.urbandroid.sleep.smartwatch.phaser.protocol.SleepPhaserBLEClient] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [com.urbandroid.sleep.smartwatch.phaser.protocol.SleepPhaserBLEClient, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.urbandroid.sleep.smartwatch.phaser.protocol.SleepPhaserBLEClient] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x009a -> B:42:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object retryWithReconnect(SleepPhaserBLEClient sleepPhaserBLEClient, int i, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        C21941 c21941;
        ?? r2;
        int i2;
        if (continuation instanceof C21941) {
            c21941 = (C21941) continuation;
            int i3 = c21941.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c21941.label = i3 - Integer.MIN_VALUE;
            } else {
                c21941 = new C21941(continuation);
            }
        }
        Object obj = c21941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r22 = c21941.label;
        try {
        } catch (BluetoothException e) {
            e = e;
            if (sleepPhaserBLEClient != i) {
            }
        }
        if (r22 != 0) {
            if (r22 != 1) {
                if (r22 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                int i4 = c21941.I$1;
                int i5 = c21941.I$0;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            i2 = c21941.I$1;
            i = c21941.I$0;
            function1 = (Function1) c21941.L$1;
            SleepPhaserBLEClient sleepPhaserBLEClient2 = (SleepPhaserBLEClient) c21941.L$0;
            ResultKt.throwOnFailure(obj);
            r2 = sleepPhaserBLEClient2;
            c21941.L$0 = r2;
            c21941.L$1 = function1;
            c21941.I$0 = i;
            c21941.I$1 = i2;
            c21941.label = 2;
            Object objInvoke = function1.invoke(c21941);
            return objInvoke != coroutine_suspended ? coroutine_suspended : objInvoke;
        }
        ResultKt.throwOnFailure(obj);
        if (i >= 0) {
            int i6 = 0;
            ?? r10 = sleepPhaserBLEClient;
            try {
            } catch (BluetoothException e2) {
                r22 = r10;
                sleepPhaserBLEClient = i6;
                e = e2;
                if (sleepPhaserBLEClient != i) {
                    throw e;
                }
                Logger.logSevere("SleepPhaser async task error, " + r22.getInfo(), e);
                if (sleepPhaserBLEClient != i) {
                    i6 = sleepPhaserBLEClient + 1;
                    r10 = r22;
                    c21941.L$0 = r10;
                    c21941.L$1 = function1;
                    c21941.I$0 = i;
                    c21941.I$1 = i6;
                    c21941.label = 1;
                    if (reconnect(r10, c21941) != coroutine_suspended) {
                    }
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("Never happens");
                return null;
            }
            c21941.L$0 = r10;
            c21941.L$1 = function1;
            c21941.I$0 = i;
            c21941.I$1 = i6;
            c21941.label = 1;
            if (reconnect(r10, c21941) != coroutine_suspended) {
                r2 = r10;
                i2 = i6;
                c21941.L$0 = r2;
                c21941.L$1 = function1;
                c21941.I$0 = i;
                c21941.I$1 = i2;
                c21941.label = 2;
                Object objInvoke2 = function1.invoke(c21941);
                if (objInvoke2 != coroutine_suspended) {
                }
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Never happens");
        return null;
    }

    private static final Object shortDelay(Continuation<? super Unit> continuation) {
        Object objDelay = DelayKt.delay(10L, continuation);
        return objDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : Unit.INSTANCE;
    }
}
