package com.urbandroid.sleep.smartwatch.pebble;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.smartwatch.pebble.RePebble;
import io.rebble.pebblekit2.client.DefaultPebbleSender;
import io.rebble.pebblekit2.client.PebbleSender;
import io.rebble.pebblekit2.common.model.PebbleDictionaryItem;
import io.rebble.pebblekit2.common.model.TransmissionResult;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$ResendNAckedTemplate$doSend$1", f = "RePebble.kt", l = {356}, m = "invokeSuspend", v = 2)
public final class RePebble$ResendNAckedTemplate$doSend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<UInt, PebbleDictionaryItem> $data;
    final /* synthetic */ long $delay;
    int label;
    final /* synthetic */ RePebble this$0;
    final /* synthetic */ RePebble.ResendNAckedTemplate this$1;

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.pebble.RePebble$ResendNAckedTemplate$doSend$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$ResendNAckedTemplate$doSend$1$1", f = "RePebble.kt", l = {359, 364, 384}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<UInt, PebbleDictionaryItem> $data;
        final /* synthetic */ long $delay;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RePebble this$0;
        final /* synthetic */ RePebble.ResendNAckedTemplate this$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(long j, Map<UInt, ? extends PebbleDictionaryItem> map, RePebble rePebble, RePebble.ResendNAckedTemplate resendNAckedTemplate, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$delay = j;
            this.$data = map;
            this.this$0 = rePebble;
            this.this$1 = resendNAckedTemplate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$delay, this.$data, this.this$0, this.this$1, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x011a, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(1000, r10) == r0) goto L49;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AnonymousClass1 anonymousClass1;
            Map map;
            TransmissionResult transmissionResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$delay;
                if (j != -1) {
                    this.label = 1;
                    if (DelayKt.delay(j, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1 = this;
                    anonymousClass1.this$1.setRetry(anonymousClass1.this$1.getRetry() - 1);
                    anonymousClass1.this$1.send();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                anonymousClass1 = this;
                map = (Map) obj;
                if (map == null) {
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        transmissionResult = (TransmissionResult) ((Map.Entry) it.next()).getValue();
                        if (transmissionResult != null) {
                            break;
                        }
                    }
                    transmissionResult = null;
                    if (!Intrinsics.areEqual(transmissionResult, TransmissionResult.Success.INSTANCE)) {
                        Object obj2 = RePebble.QUEUE_LOCK;
                        RePebble.ResendNAckedTemplate resendNAckedTemplate = anonymousClass1.this$1;
                        RePebble rePebble = anonymousClass1.this$0;
                        synchronized (obj2) {
                            try {
                                Logger.logInfo("RePebble: Sender success");
                                resendNAckedTemplate.removeSelfAndExecuteNext();
                                if (RePebble.queuedTemplates.isEmpty()) {
                                    rePebble.handler.postDelayed(rePebble.closeSenderRunnable, 30000L);
                                }
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else if (Intrinsics.areEqual(transmissionResult, TransmissionResult.FailedDifferentAppOpen.INSTANCE)) {
                        Logger.logSevere("RePebble: Sender failed - restart app " + anonymousClass1.this$1.getRetry());
                        if (anonymousClass1.this$1.getRetry() > 0) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(map);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(transmissionResult);
                            anonymousClass1.label = 3;
                        }
                    } else {
                        if (Intrinsics.areEqual(transmissionResult, TransmissionResult.FailedNoPermissions.INSTANCE)) {
                            Logger.logSevere("RePebble: Sender no permission");
                            throw new NotImplementedError(null, 1, null);
                        }
                        if (Intrinsics.areEqual(transmissionResult, TransmissionResult.FailedTimeout.INSTANCE) || Intrinsics.areEqual(transmissionResult, TransmissionResult.FailedWatchNacked.INSTANCE) || Intrinsics.areEqual(transmissionResult, TransmissionResult.FailedWatchNotConnected.INSTANCE)) {
                            Logger.logSevere("RePebble: Sender failed");
                        } else if (transmissionResult instanceof TransmissionResult.Unknown) {
                            Logger.logSevere("Pebble send unknown error: " + transmissionResult);
                        } else {
                            if (transmissionResult != null) {
                                Home$$ExternalSyntheticBUOutline0.m();
                                return null;
                            }
                            Logger.logSevere("Pebble send nul result: " + transmissionResult);
                        }
                    }
                } else {
                    transmissionResult = null;
                    if (!Intrinsics.areEqual(transmissionResult, TransmissionResult.Success.INSTANCE)) {
                    }
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            Logger.logInfo("RePebble: Sending " + this.$data);
            this.this$0.handler.removeCallbacks(this.this$0.closeSenderRunnable);
            DefaultPebbleSender senderLazy = this.this$0.getSenderLazy();
            UUID app_uuid = RePebble.INSTANCE.getAPP_UUID();
            Map<UInt, PebbleDictionaryItem> map2 = this.$data;
            this.label = 2;
            anonymousClass1 = this;
            obj = PebbleSender.sendDataToPebble$default(senderLazy, app_uuid, map2, null, anonymousClass1, 4, null);
            if (obj != coroutine_suspended) {
                map = (Map) obj;
                if (map == null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RePebble$ResendNAckedTemplate$doSend$1(long j, Map<UInt, ? extends PebbleDictionaryItem> map, RePebble rePebble, RePebble.ResendNAckedTemplate resendNAckedTemplate, Continuation<? super RePebble$ResendNAckedTemplate$doSend$1> continuation) {
        super(2, continuation);
        this.$delay = j;
        this.$data = map;
        this.this$0 = rePebble;
        this.this$1 = resendNAckedTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RePebble$ResendNAckedTemplate$doSend$1(this.$delay, this.$data, this.this$0, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RePebble$ResendNAckedTemplate$doSend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$delay, this.$data, this.this$0, this.this$1, null);
            this.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
