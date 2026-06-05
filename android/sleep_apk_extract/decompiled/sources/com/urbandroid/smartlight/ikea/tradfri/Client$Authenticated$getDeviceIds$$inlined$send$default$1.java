package com.urbandroid.smartlight.ikea.tradfri;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.controller.SafeResumeContinuation;
import com.urbandroid.smartlight.ikea.tradfri.Client;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/urbandroid/smartlight/ikea/tradfri/Client$send$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$send$2", f = "Client.kt", l = {476, 431}, m = "invokeSuspend")
public final class Client$Authenticated$getDeviceIds$$inlined$send$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Integer>>, Object> {
    final /* synthetic */ String $action;
    final /* synthetic */ Client.Method $method;
    final /* synthetic */ String $path;
    final /* synthetic */ String $payload;
    final /* synthetic */ long $timeoutInMs;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ Client this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Client$Authenticated$getDeviceIds$$inlined$send$default$1(Client client, Client.Method method, String str, String str2, String str3, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = client;
        this.$method = method;
        this.$path = str;
        this.$payload = str2;
        this.$action = str3;
        this.$timeoutInMs = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Client$Authenticated$getDeviceIds$$inlined$send$default$1(this.this$0, this.$method, this.$path, this.$payload, this.$action, this.$timeoutInMs, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Integer>> continuation) {
        return ((Client$Authenticated$getDeviceIds$$inlined$send$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex sendLock;
        final Client client;
        Client.Method method;
        String str;
        String str2;
        long j;
        String str3;
        Mutex mutex;
        final String str4;
        CoapClient coapClient;
        Client.Method method2;
        Object orThrow;
        Object objFromJson;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sendLock = this.this$0.getSendLock();
                client = this.this$0;
                method = this.$method;
                str = this.$path;
                String str5 = this.$payload;
                str2 = this.$action;
                j = this.$timeoutInMs;
                this.L$0 = sendLock;
                this.L$1 = client;
                this.L$2 = method;
                this.L$3 = str;
                this.L$4 = str5;
                this.L$5 = str2;
                this.J$0 = j;
                this.label = 1;
                if (sendLock.lock(null, this) != coroutine_suspended) {
                    str3 = str5;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                long j2 = this.J$0;
                String str6 = (String) this.L$5;
                String str7 = (String) this.L$4;
                str = (String) this.L$3;
                method = (Client.Method) this.L$2;
                client = (Client) this.L$1;
                Mutex mutex2 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                str2 = str6;
                sendLock = mutex2;
                j = j2;
                str3 = str7;
            } else {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex = (Mutex) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    orThrow = obj;
                    mutex.unlock(null);
                    return orThrow;
                } catch (Throwable th) {
                    th = th;
                }
            }
            client.setLastSendTimestamp(System.currentTimeMillis());
            str4 = method + ' ' + client.getGateway().getUri() + str + ' ';
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(str3 == null ? "" : str3);
            sb.append("... ");
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            Logger.logDebug(sb.toString(), null);
            coapClient = new CoapClient(client.getGateway().getUri() + str);
            method2 = Client.Method.PUT;
            if (method == method2) {
                coapClient.useNONs();
            } else {
                coapClient.useCONs();
            }
            coapClient.setEndpoint(client.getEndpoint());
            coapClient.setTimeout(Boxing.boxLong(j));
        } catch (Throwable th2) {
            th = th2;
            mutex = sendLock;
        }
        if (method == method2) {
            coapClient.put(str3, 50);
            sendLock.unlock(null);
            return null;
        }
        String str8 = str3;
        if (method == Client.Method.GET_SYNC) {
            CoapResponse coapResponse = coapClient.get();
            if (coapResponse != null) {
                String responseText = coapResponse.getResponseText();
                try {
                    objFromJson = Client.INSTANCE.getGson().fromJson(responseText, (Class<Object>) List.class);
                    Logger.logDebug("response: " + responseText, null);
                } catch (Exception e) {
                    Logger.logSevere("fail to parse json: " + coapResponse.getResponseText(), e);
                    objFromJson = null;
                }
            } else {
                objFromJson = null;
            }
            sendLock.unlock(null);
            return objFromJson;
        }
        Client.Method method3 = Client.Method.GET;
        Client.Method method4 = Client.Method.POST;
        if (!SetsKt.setOf((Object[]) new Client.Method[]{method3, method4}).contains(method)) {
            sendLock.unlock(null);
            return null;
        }
        this.L$0 = sendLock;
        this.L$1 = client;
        this.L$2 = method;
        this.L$3 = str8;
        this.L$4 = str4;
        this.L$5 = coapClient;
        this.L$6 = this;
        this.label = 2;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
        final SafeResumeContinuation safeResumeContinuation = new SafeResumeContinuation(safeContinuation);
        CoapHandler coapHandler = new CoapHandler() { // from class: com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$getDeviceIds$$inlined$send$default$1.1
            @Override // org.eclipse.californium.core.CoapHandler
            public void onError() {
                Logger.logSevere(str4 + " ... onError failed", null);
                safeResumeContinuation.resumeWith(Result.m2357constructorimpl(null));
            }

            @Override // org.eclipse.californium.core.CoapHandler
            public void onLoad(CoapResponse response) {
                response.getClass();
                String str9 = str4 + " ... response: code: " + response.getCode() + " payload: " + response.getResponseText();
                Object obj2 = null;
                if (!response.isSuccess()) {
                    Logger.logSevere(str9, null);
                    safeResumeContinuation.resumeWith(Result.m2357constructorimpl(null));
                    return;
                }
                Logger.logDebug(str9, null);
                SafeResumeContinuation safeResumeContinuation2 = safeResumeContinuation;
                String responseText2 = response.getResponseText();
                try {
                    Object objFromJson2 = Client.INSTANCE.getGson().fromJson(responseText2, (Class<Object>) List.class);
                    Logger.logDebug("response: " + responseText2, null);
                    obj2 = objFromJson2;
                } catch (Exception e2) {
                    Logger.logSevere("fail to parse json: " + response.getResponseText(), e2);
                }
                safeResumeContinuation2.resumeWith(Result.m2357constructorimpl(obj2));
            }
        };
        if (method == method3) {
            try {
                coapClient.get(coapHandler);
            } catch (Exception e2) {
                Logger.logSevere(null, e2);
                safeResumeContinuation.resumeWith(Result.m2357constructorimpl(null));
            }
        }
        if (method == method4) {
            coapClient.post(coapHandler, str8, 50);
        }
        orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        if (orThrow != coroutine_suspended) {
            mutex = sendLock;
            mutex.unlock(null);
            return orThrow;
        }
        return coroutine_suspended;
        th = th2;
        mutex = sendLock;
        mutex.unlock(null);
        throw th;
    }
}
