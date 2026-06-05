package com.urbandroid.sleep.service.automation.mqtt;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.automation.AutomationEvent;
import com.urbandroid.sleep.service.automation.AutomationTrigger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JH\u0010\u0010\u001a\u00020\r*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0013\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0017\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0094@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/service/automation/mqtt/MqttTrigger;", "Lcom/urbandroid/sleep/service/automation/AutomationTrigger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Lorg/eclipse/paho/client/mqttv3/MqttAsyncClient;", "", "id", "", "timeoutInMs", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "block", "whenConnected", "(Lorg/eclipse/paho/client/mqttv3/MqttAsyncClient;Ljava/lang/String;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cleanUp", "(Lorg/eclipse/paho/client/mqttv3/MqttAsyncClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbandroid/sleep/service/automation/AutomationEvent;", "event", "publish", "(Lorg/eclipse/paho/client/mqttv3/MqttAsyncClient;Lcom/urbandroid/sleep/service/automation/AutomationEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSend", "(Lcom/urbandroid/sleep/service/automation/AutomationEvent;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "()Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MqttTrigger extends AutomationTrigger {

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$doSend$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lorg/eclipse/paho/client/mqttv3/MqttAsyncClient;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$doSend$3", f = "MqttTrigger.kt", l = {25}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<MqttAsyncClient, Continuation<? super Boolean>, Object> {
        final /* synthetic */ AutomationEvent $event;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AutomationEvent automationEvent, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$event = automationEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = MqttTrigger.this.new AnonymousClass3(this.$event, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MqttAsyncClient mqttAsyncClient, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass3) create(mqttAsyncClient, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MqttAsyncClient mqttAsyncClient = (MqttAsyncClient) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            MqttTrigger mqttTrigger = MqttTrigger.this;
            AutomationEvent automationEvent = this.$event;
            this.L$0 = SpillingKt.nullOutSpilledVariable(mqttAsyncClient);
            this.label = 1;
            Object objPublish = mqttTrigger.publish(mqttAsyncClient, automationEvent, this);
            return objPublish == coroutine_suspended ? coroutine_suspended : objPublish;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$publish$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.mqtt.MqttTrigger", f = "MqttTrigger.kt", l = {136}, m = "publish", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MqttTrigger.this.publish(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$whenConnected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.mqtt.MqttTrigger", f = "MqttTrigger.kt", l = {136, 67, 80}, m = "whenConnected", v = 2)
    public static final class C21371 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C21371(Continuation<? super C21371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MqttTrigger.this.whenConnected(null, null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$whenConnected$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$whenConnected$2", f = "MqttTrigger.kt", l = {70, 72, 72}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function2<MqttAsyncClient, Continuation<? super Boolean>, Object> $block;
        final /* synthetic */ boolean $connected;
        final /* synthetic */ String $id;
        final /* synthetic */ MqttAsyncClient $this_whenConnected;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ MqttTrigger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(boolean z, Function2<? super MqttAsyncClient, ? super Continuation<? super Boolean>, ? extends Object> function2, MqttAsyncClient mqttAsyncClient, MqttTrigger mqttTrigger, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$connected = z;
            this.$block = function2;
            this.$this_whenConnected = mqttAsyncClient;
            this.this$0 = mqttTrigger;
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$connected, this.$block, this.$this_whenConnected, this.this$0, this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z;
            MqttTrigger mqttTrigger;
            MqttAsyncClient mqttAsyncClient;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Throwable th) {
                MqttTrigger mqttTrigger2 = this.this$0;
                MqttAsyncClient mqttAsyncClient2 = this.$this_whenConnected;
                String str2 = this.$id;
                this.L$0 = th;
                this.label = 3;
                if (mqttTrigger2.cleanUp(mqttAsyncClient2, str2, this) != coroutine_suspended) {
                    throw th;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.$connected) {
                    z = false;
                    return Boxing.boxBoolean(z);
                }
                Function2<MqttAsyncClient, Continuation<? super Boolean>, Object> function2 = this.$block;
                MqttAsyncClient mqttAsyncClient3 = this.$this_whenConnected;
                this.label = 1;
                obj = function2.invoke(mqttAsyncClient3, this);
                if (obj != coroutine_suspended) {
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    mqttTrigger = this.this$0;
                    mqttAsyncClient = this.$this_whenConnected;
                    str = this.$id;
                    this.Z$0 = zBooleanValue;
                    this.label = 2;
                    if (mqttTrigger.cleanUp(mqttAsyncClient, str, this) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    z = this.Z$0;
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(z);
                }
                if (i != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Throwable th2 = (Throwable) this.L$0;
                ResultKt.throwOnFailure(obj);
                throw th2;
            }
            ResultKt.throwOnFailure(obj);
            boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
            mqttTrigger = this.this$0;
            mqttAsyncClient = this.$this_whenConnected;
            str = this.$id;
            this.Z$0 = zBooleanValue2;
            this.label = 2;
            if (mqttTrigger.cleanUp(mqttAsyncClient, str, this) != coroutine_suspended) {
                z = zBooleanValue2;
                return Boxing.boxBoolean(z);
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$whenConnected$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$whenConnected$3", f = "MqttTrigger.kt", l = {81}, m = "invokeSuspend", v = 2)
    public static final class C21383 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ MqttAsyncClient $this_whenConnected;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21383(MqttAsyncClient mqttAsyncClient, String str, Continuation<? super C21383> continuation) {
            super(2, continuation);
            this.$this_whenConnected = mqttAsyncClient;
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqttTrigger.this.new C21383(this.$this_whenConnected, this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21383) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MqttTrigger mqttTrigger = MqttTrigger.this;
                MqttAsyncClient mqttAsyncClient = this.$this_whenConnected;
                String str = this.$id;
                this.label = 1;
                if (mqttTrigger.cleanUp(mqttAsyncClient, str, this) == coroutine_suspended) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttTrigger(Context context) {
        super(context, "mqtt");
        context.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cleanUp(MqttAsyncClient mqttAsyncClient, final String str, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            String str2 = Logger.defaultTag;
            Logger.logInfo(str2, getTag() + ": " + (str + " disconnecting ..."), null);
            mqttAsyncClient.disconnect(Utils.getSecondsInMillis(1), null, new IMqttActionListener() { // from class: com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$cleanUp$2$1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    MqttTrigger mqttTrigger = this.this$0;
                    String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(str, " disconnect failure");
                    Logger.logInfo(Logger.defaultTag, mqttTrigger.getTag() + ": " + strM$1, null);
                    Continuation<Boolean> continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m2357constructorimpl(Boolean.FALSE));
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    MqttTrigger mqttTrigger = this.this$0;
                    String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(str, " disconnected");
                    Logger.logInfo(Logger.defaultTag, mqttTrigger.getTag() + ": " + strM$1, null);
                    Continuation<Boolean> continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m2357constructorimpl(Boolean.TRUE));
                }
            });
        } catch (Exception e) {
            String str3 = str + " disconnect failure: " + e;
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + str3, null);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m2357constructorimpl(Boxing.boxBoolean(false)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object publish(MqttAsyncClient mqttAsyncClient, final AutomationEvent automationEvent, Continuation<? super Boolean> continuation) {
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
        Object result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        boolean zBooleanValue = false;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(result);
                byte[] bytes = automationEvent.toJSON().getBytes(Charsets.UTF_8);
                bytes.getClass();
                MqttMessage mqttMessage = new MqttMessage(bytes);
                mqttMessage.setQos(2);
                mqttMessage.setRetained(false);
                anonymousClass1.L$0 = mqttAsyncClient;
                anonymousClass1.L$1 = automationEvent;
                anonymousClass1.L$2 = mqttMessage;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass1), 1);
                cancellableContinuationImpl.initCancellability();
                mqttAsyncClient.publish(ContextExtKt.getSettings(getContext()).getMqttTopic(), mqttMessage, (Object) null, new IMqttActionListener() { // from class: com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$publish$2$1
                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        MqttTrigger mqttTrigger = this.this$0;
                        String strM = FileInsert$$ExternalSyntheticOutline0.m("message ", automationEvent.getEventName(), " publish failure");
                        Logger.logWarning(Logger.defaultTag, mqttTrigger.getTag() + ": " + strM, exception);
                        CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m2357constructorimpl(Boolean.FALSE));
                    }

                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onSuccess(IMqttToken asyncActionToken) {
                        MqttTrigger mqttTrigger = this.this$0;
                        String strM = FileInsert$$ExternalSyntheticOutline0.m("message ", automationEvent.getEventName(), " published");
                        Logger.logInfo(Logger.defaultTag, mqttTrigger.getTag() + ": " + strM, null);
                        CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m2357constructorimpl(Boolean.TRUE));
                    }
                });
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(anonymousClass1);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                automationEvent = (AutomationEvent) anonymousClass1.L$1;
                ResultKt.throwOnFailure(result);
            }
            zBooleanValue = ((Boolean) result).booleanValue();
        } catch (Exception e) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("message ", automationEvent.getEventName());
            Logger.logSevere(Logger.defaultTag, getTag() + ": " + strM, e);
        }
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016a, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r4, r6, r7) == r8) goto L69;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0065: MOVE (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:102), block:B:21:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0143  */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object whenConnected(MqttAsyncClient mqttAsyncClient, String str, long j, Function2<? super MqttAsyncClient, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        C21371 c21371;
        long j2;
        long j3;
        MqttAsyncClient mqttAsyncClient2;
        MqttAsyncClient mqttAsyncClient3;
        ?? r5;
        Function2<? super MqttAsyncClient, ? super Continuation<? super Boolean>, ? extends Object> function22;
        Function2<? super MqttAsyncClient, ? super Continuation<? super Boolean>, ? extends Object> function23;
        MqttAsyncClient mqttAsyncClient4;
        String str2;
        long j4;
        MqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1 mqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1;
        Function2<? super MqttAsyncClient, ? super Continuation<? super Boolean>, ? extends Object> function24;
        int i;
        MqttTrigger mqttTrigger = this;
        if (!(continuation instanceof C21371) || (r5 = (i = (c21371 = (C21371) continuation).label) & Integer.MIN_VALUE) == 0) {
            c21371 = mqttTrigger.new C21371(continuation);
            j2 = i;
        } else {
            int i2 = i - Integer.MIN_VALUE;
            c21371.label = i2;
            j2 = i2;
        }
        C21371 c213712 = c21371;
        Object objWithTimeout = c213712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = c213712.label;
        boolean zBooleanValue = false;
        if (r1 == 0) {
            ResultKt.throwOnFailure(objWithTimeout);
            try {
                mqttAsyncClient4 = mqttAsyncClient;
                str2 = str;
                j4 = j;
                try {
                    mqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1 = new MqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1(null, mqttTrigger, str2, mqttAsyncClient4, j4);
                    try {
                        c213712.L$0 = mqttAsyncClient4;
                        str2 = str;
                        try {
                            c213712.L$1 = str2;
                            function24 = function2;
                        } catch (TimeoutCancellationException e) {
                            e = e;
                            mqttTrigger = this;
                            r1 = function2;
                            j3 = j4;
                            r5 = str2;
                            mqttAsyncClient3 = mqttAsyncClient4;
                            String str3 = Logger.defaultTag;
                            Logger.logWarning(str3, mqttTrigger.getTag() + ": " + (r5 + " timeout " + j3 + " ms"), null);
                            if (mqttAsyncClient3.isConnected()) {
                            }
                            return Boxing.boxBoolean(zBooleanValue);
                        }
                    } catch (TimeoutCancellationException e2) {
                        e = e2;
                        mqttTrigger = this;
                        str2 = str;
                    }
                } catch (TimeoutCancellationException e3) {
                    e = e3;
                }
            } catch (TimeoutCancellationException e4) {
                e = e4;
                mqttAsyncClient4 = mqttAsyncClient;
                str2 = str;
                j4 = j;
            }
            try {
                c213712.L$2 = function24;
                c213712.J$0 = j4;
                c213712.J$1 = j4;
                c213712.I$0 = 0;
                c213712.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j4, mqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1, c213712);
            } catch (TimeoutCancellationException e5) {
                e = e5;
                mqttTrigger = this;
                r1 = function24;
                j3 = j4;
                r5 = str2;
                mqttAsyncClient3 = mqttAsyncClient4;
                String str32 = Logger.defaultTag;
                Logger.logWarning(str32, mqttTrigger.getTag() + ": " + (r5 + " timeout " + j3 + " ms"), null);
                if (mqttAsyncClient3.isConnected()) {
                }
                return Boxing.boxBoolean(zBooleanValue);
            }
            if (objWithTimeout != coroutine_suspended) {
                j3 = j4;
                r5 = str2;
                mqttAsyncClient3 = mqttAsyncClient4;
                function22 = function24;
                function23 = function22;
                boolean zBooleanValue2 = ((Boolean) objWithTimeout).booleanValue();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(zBooleanValue2, function23, mqttAsyncClient3, this, r5, null);
                r1 = function23;
                mqttTrigger = this;
                c213712.L$0 = mqttAsyncClient3;
                c213712.L$1 = r5;
                c213712.L$2 = SpillingKt.nullOutSpilledVariable(r1);
                c213712.J$0 = j3;
                c213712.Z$0 = zBooleanValue2;
                c213712.label = 2;
                objWithTimeout = TimeoutKt.withTimeout(j3, anonymousClass2, c213712);
                r1 = r1;
                r5 = r5;
                j3 = j3;
                if (objWithTimeout == coroutine_suspended) {
                }
                zBooleanValue = ((Boolean) objWithTimeout).booleanValue();
                return Boxing.boxBoolean(zBooleanValue);
            }
            return coroutine_suspended;
        }
        try {
        } catch (TimeoutCancellationException e6) {
            e = e6;
            j3 = j2;
            mqttAsyncClient3 = mqttAsyncClient2;
            String str322 = Logger.defaultTag;
            Logger.logWarning(str322, mqttTrigger.getTag() + ": " + (r5 + " timeout " + j3 + " ms"), null);
            if (mqttAsyncClient3.isConnected()) {
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithTimeout);
                return Boxing.boxBoolean(zBooleanValue);
            }
            long j5 = c213712.J$0;
            Function2 function25 = (Function2) c213712.L$2;
            String str4 = (String) c213712.L$1;
            MqttAsyncClient mqttAsyncClient5 = (MqttAsyncClient) c213712.L$0;
            ResultKt.throwOnFailure(objWithTimeout);
            j3 = j5;
            mqttAsyncClient3 = mqttAsyncClient5;
            r1 = function25;
            r5 = str4;
            zBooleanValue = ((Boolean) objWithTimeout).booleanValue();
            return Boxing.boxBoolean(zBooleanValue);
        }
        long j6 = c213712.J$0;
        Function2<? super MqttAsyncClient, ? super Continuation<? super Boolean>, ? extends Object> function26 = (Function2) c213712.L$2;
        String str5 = (String) c213712.L$1;
        MqttAsyncClient mqttAsyncClient6 = (MqttAsyncClient) c213712.L$0;
        ResultKt.throwOnFailure(objWithTimeout);
        j3 = j6;
        mqttAsyncClient3 = mqttAsyncClient6;
        function22 = function26;
        r5 = str5;
        function23 = function22;
        try {
            boolean zBooleanValue22 = ((Boolean) objWithTimeout).booleanValue();
            try {
                AnonymousClass2 anonymousClass22 = new AnonymousClass2(zBooleanValue22, function23, mqttAsyncClient3, this, r5, null);
                r1 = function23;
                mqttTrigger = this;
                try {
                    c213712.L$0 = mqttAsyncClient3;
                    c213712.L$1 = r5;
                    c213712.L$2 = SpillingKt.nullOutSpilledVariable(r1);
                    c213712.J$0 = j3;
                    c213712.Z$0 = zBooleanValue22;
                    c213712.label = 2;
                    objWithTimeout = TimeoutKt.withTimeout(j3, anonymousClass22, c213712);
                    r1 = r1;
                    r5 = r5;
                    j3 = j3;
                } catch (TimeoutCancellationException e7) {
                    e = e7;
                    String str3222 = Logger.defaultTag;
                    Logger.logWarning(str3222, mqttTrigger.getTag() + ": " + (r5 + " timeout " + j3 + " ms"), null);
                    if (mqttAsyncClient3.isConnected()) {
                        NonCancellable nonCancellable = NonCancellable.INSTANCE;
                        C21383 c21383 = mqttTrigger.new C21383(mqttAsyncClient3, r5, null);
                        c213712.L$0 = SpillingKt.nullOutSpilledVariable(mqttAsyncClient3);
                        c213712.L$1 = SpillingKt.nullOutSpilledVariable(r5);
                        c213712.L$2 = SpillingKt.nullOutSpilledVariable(r1);
                        c213712.L$3 = SpillingKt.nullOutSpilledVariable(e);
                        c213712.J$0 = j3;
                        c213712.label = 3;
                    }
                }
            } catch (TimeoutCancellationException e8) {
                e = e8;
                r1 = function23;
                mqttTrigger = this;
                String str32222 = Logger.defaultTag;
                Logger.logWarning(str32222, mqttTrigger.getTag() + ": " + (r5 + " timeout " + j3 + " ms"), null);
                if (mqttAsyncClient3.isConnected()) {
                }
            }
        } catch (TimeoutCancellationException e9) {
            e = e9;
            r1 = function23;
            mqttTrigger = this;
        }
        if (objWithTimeout == coroutine_suspended) {
            return coroutine_suspended;
        }
        zBooleanValue = ((Boolean) objWithTimeout).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    @Override // com.urbandroid.sleep.service.automation.AutomationTrigger
    public Object doSend(AutomationEvent automationEvent, long j, Continuation<? super Boolean> continuation) {
        String mqttServerUrl = ContextExtKt.getSettings(getContext()).getMqttServerUrl();
        String mqttClientId = ContextExtKt.getSettings(getContext()).getMqttClientId();
        if (StringsKt.isBlank(mqttClientId)) {
            mqttClientId = "SleepAsAndroid";
        }
        return whenConnected(new MqttAsyncClient(mqttServerUrl, mqttClientId, new MemoryPersistence()), automationEvent.getEventName(), j, new AnonymousClass3(automationEvent, null), continuation);
    }

    @Override // com.urbandroid.sleep.service.automation.AutomationTrigger
    public boolean isEnabled() {
        Settings settings = ContextExtKt.getSettings(getContext());
        if (!settings.isMqtt()) {
            return false;
        }
        String mqttServerUrl = settings.getMqttServerUrl();
        mqttServerUrl.getClass();
        return !StringsKt.isBlank(mqttServerUrl);
    }
}
