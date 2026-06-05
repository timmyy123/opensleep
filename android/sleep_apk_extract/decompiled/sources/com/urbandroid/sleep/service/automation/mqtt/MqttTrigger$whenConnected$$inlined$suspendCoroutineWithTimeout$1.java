package com.urbandroid.sleep.service.automation.mqtt;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {2, 3, 0})
@DebugMetadata(c = "com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1", f = "MqttTrigger.kt", l = {177}, m = "invokeSuspend", v = 2)
public final class MqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $id$inlined;
    final /* synthetic */ MqttAsyncClient $this_whenConnected$inlined;
    final /* synthetic */ long $timeoutInMs$inlined;
    int I$0;
    int label;
    final /* synthetic */ MqttTrigger this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1(Continuation continuation, MqttTrigger mqttTrigger, String str, MqttAsyncClient mqttAsyncClient, long j) {
        super(2, continuation);
        this.this$0 = mqttTrigger;
        this.$id$inlined = str;
        this.$this_whenConnected$inlined = mqttAsyncClient;
        this.$timeoutInMs$inlined = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1(continuation, this.this$0, this.$id$inlined, this.$this_whenConnected$inlined, this.$timeoutInMs$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MqttTrigger$whenConnected$$inlined$suspendCoroutineWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        char[] charArray;
        String str;
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
        this.I$0 = 0;
        this.label = 1;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        URI uri = new URI(ContextExtKt.getSettings(this.this$0.getContext()).getMqttServerUrl());
        String scheme = uri.getScheme();
        String host = uri.getHost();
        Integer numBoxInt = Boxing.boxInt(uri.getPort());
        if (numBoxInt.intValue() == -1) {
            numBoxInt = null;
        }
        int iIntValue = numBoxInt != null ? numBoxInt.intValue() : 1883;
        String str2 = scheme + "://" + host + ":" + iIntValue + uri.getPath();
        String userInfo = uri.getUserInfo();
        List listSplit$default = userInfo != null ? StringsKt.split$default(userInfo, new String[]{":"}, 0, 6) : null;
        String str3 = listSplit$default != null ? (String) CollectionsKt.getOrNull(listSplit$default, 0) : null;
        if (listSplit$default == null || (str = (String) CollectionsKt.getOrNull(listSplit$default, 1)) == null) {
            charArray = null;
        } else {
            charArray = str.toCharArray();
            charArray.getClass();
        }
        MqttTrigger mqttTrigger = this.this$0;
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(str2, " ", this.$id$inlined);
        Logger.logInfo(Logger.defaultTag, mqttTrigger.getTag() + ": " + strM$1, null);
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setCleanSession(true);
        if (charArray != null && charArray.length != 0) {
            mqttConnectOptions.setPassword(charArray);
        }
        if (str3 != null && str3.length() > 0) {
            mqttConnectOptions.setUserName(str3);
        }
        mqttConnectOptions.setServerURIs(new String[]{str2});
        mqttConnectOptions.setConnectionTimeout(((int) this.$timeoutInMs$inlined) / 1000);
        try {
            MqttAsyncClient mqttAsyncClient = this.$this_whenConnected$inlined;
            final MqttTrigger mqttTrigger2 = this.this$0;
            final String str4 = this.$id$inlined;
            mqttAsyncClient.connect(mqttConnectOptions, null, new IMqttActionListener() { // from class: com.urbandroid.sleep.service.automation.mqtt.MqttTrigger$whenConnected$connected$1$1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    MqttTrigger mqttTrigger3 = mqttTrigger2;
                    String str5 = str4 + " - connect failure: " + exception;
                    Logger.logWarning(Logger.defaultTag, mqttTrigger3.getTag() + ": " + str5, null);
                    Continuation<Boolean> continuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m2357constructorimpl(Boolean.FALSE));
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    MqttTrigger mqttTrigger3 = mqttTrigger2;
                    String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(str4, " - connect success");
                    Logger.logInfo(Logger.defaultTag, mqttTrigger3.getTag() + ": " + strM$12, null);
                    Continuation<Boolean> continuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m2357constructorimpl(Boolean.TRUE));
                }
            });
        } catch (Exception e) {
            MqttTrigger mqttTrigger3 = this.this$0;
            String str5 = this.$id$inlined + " - unhandled connect failure: " + e;
            Logger.logWarning(Logger.defaultTag, mqttTrigger3.getTag() + ": " + str5, null);
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(Boxing.boxBoolean(false)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
