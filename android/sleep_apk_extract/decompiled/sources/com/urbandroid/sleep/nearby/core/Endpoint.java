package com.urbandroid.sleep.nearby.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.Strategy;
import com.google.android.gms.tasks.Task;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.StartTrackActivity$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.util.Experiments;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util$$ExternalSyntheticLambda2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00044567BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010!\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0003H\u0002J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\nJ\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0016J\u0006\u0010*\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020\u0011J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0003J\u000e\u0010.\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0003J\u0016\u0010/\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00032\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020\rJ\b\u00103\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/Endpoint;", "Ljava/io/Closeable;", IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "logger", "Lcom/urbandroid/sleep/nearby/core/MyLogger;", "payloadConsumer", "Lkotlin/Function1;", "", "", "statusChangeCallback", "Lcom/urbandroid/sleep/nearby/core/ConnectionStatus;", "<init>", "(Ljava/lang/String;Landroid/content/Context;Lcom/urbandroid/sleep/nearby/core/MyLogger;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "isDetailedPairLoggingExperiment", "", "mainHandler", "Landroid/os/Handler;", "strategy", "Lcom/google/android/gms/nearby/connection/Strategy;", "recoveryIntervalMillis", "", "receiveConnectionTimeoutMillis", "connectionInitiationTimeoutMillis", "endpointName", "client", "Lcom/google/android/gms/nearby/connection/ConnectionsClient;", "needsRecovery", "lastRecoveryAttempt", "closed", "remoteEndpointId", "startAdvertising", "startDiscovery", "requestConnection", "discoveredEndpointId", "requestConnectionAfterDelay", "send", "payload", "shutdown", "close", "isConnected", "isClosed", "logStatus", "s", "logPayload", "logError", "e", "", "getStatus", "propagateStatusChange", "MyConnectionLifecycleCallback", "MyPayloadCallback", "RecoverStep1", "RecoverStep2", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Endpoint implements Closeable {
    private final ConnectionsClient client;
    private volatile boolean closed;
    private final long connectionInitiationTimeoutMillis;
    private final Context context;
    private final String endpointName;
    private final boolean isDetailedPairLoggingExperiment;
    private volatile long lastRecoveryAttempt;
    private final MyLogger logger;
    private final Handler mainHandler;
    private volatile boolean needsRecovery;
    private final Function1<byte[], Unit> payloadConsumer;
    private final long receiveConnectionTimeoutMillis;
    private final long recoveryIntervalMillis;
    private volatile String remoteEndpointId;
    private final String serviceName;
    private final Function1<ConnectionStatus, Unit> statusChangeCallback;
    private final Strategy strategy;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/Endpoint$MyConnectionLifecycleCallback;", "Lcom/google/android/gms/nearby/connection/ConnectionLifecycleCallback;", "<init>", "(Lcom/urbandroid/sleep/nearby/core/Endpoint;)V", "onConnectionInitiated", "", "endpointId", "", "connInfo", "Lcom/google/android/gms/nearby/connection/ConnectionInfo;", "onConnectionResult", "resolution", "Lcom/google/android/gms/nearby/connection/ConnectionResolution;", "onDisconnected", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class MyConnectionLifecycleCallback extends ConnectionLifecycleCallback {
        public MyConnectionLifecycleCallback() {
        }

        @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
        public void onConnectionInitiated(String endpointId, ConnectionInfo connInfo) {
            endpointId.getClass();
            connInfo.getClass();
            Endpoint.this.logStatus("onConnectionInitiated " + endpointId + " " + connInfo.getEndpointName());
            boolean closed = Endpoint.this.getClosed();
            Endpoint endpoint = Endpoint.this;
            if (closed) {
                endpoint.client.rejectConnection("Already closed");
            } else {
                endpoint.client.acceptConnection(endpointId, Endpoint.this.new MyPayloadCallback());
            }
        }

        @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
        public void onConnectionResult(String endpointId, ConnectionResolution resolution) {
            endpointId.getClass();
            resolution.getClass();
            Endpoint.this.logStatus("onConnectionResult " + endpointId + " " + resolution.getStatus());
            boolean zIsSuccess = resolution.getStatus().isSuccess();
            Endpoint endpoint = Endpoint.this;
            if (!zIsSuccess) {
                endpoint.needsRecovery = true;
                return;
            }
            endpoint.remoteEndpointId = endpointId;
            Endpoint.this.client.stopDiscovery();
            Endpoint.this.client.stopAdvertising();
            Endpoint.this.propagateStatusChange();
        }

        @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
        public void onDisconnected(String endpointId) {
            endpointId.getClass();
            Endpoint.this.logStatus("onDisconnected " + endpointId);
            Endpoint.this.needsRecovery = true;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/Endpoint$MyPayloadCallback;", "Lcom/google/android/gms/nearby/connection/PayloadCallback;", "<init>", "(Lcom/urbandroid/sleep/nearby/core/Endpoint;)V", "payload", "Lcom/google/android/gms/nearby/connection/Payload;", "onPayloadReceived", "", "endpointId", "", "onPayloadTransferUpdate", "update", "Lcom/google/android/gms/nearby/connection/PayloadTransferUpdate;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class MyPayloadCallback extends PayloadCallback {
        private Payload payload;

        public MyPayloadCallback() {
        }

        @Override // com.google.android.gms.nearby.connection.PayloadCallback
        public void onPayloadReceived(String endpointId, Payload payload) {
            endpointId.getClass();
            payload.getClass();
            Endpoint.this.logPayload("onPayloadReceived " + payload.getId());
            this.payload = payload;
        }

        @Override // com.google.android.gms.nearby.connection.PayloadCallback
        public void onPayloadTransferUpdate(String endpointId, PayloadTransferUpdate update) {
            endpointId.getClass();
            update.getClass();
            Endpoint.this.logPayload("onPayloadTransferUpdate: " + update.getPayloadId() + " " + update.getStatus() + " " + update.getBytesTransferred());
            Payload payload = this.payload;
            if (payload != null) {
                payload.getClass();
                if (payload.getId() == update.getPayloadId()) {
                    int status = update.getStatus();
                    if (status != 1) {
                        if (status == 2 || status == 4) {
                            Endpoint.this.needsRecovery = true;
                            this.payload = null;
                            return;
                        }
                        return;
                    }
                    Function1 function1 = Endpoint.this.payloadConsumer;
                    Payload payload2 = this.payload;
                    payload2.getClass();
                    byte[] bArrAsBytes = payload2.asBytes();
                    bArrAsBytes.getClass();
                    function1.invoke(bArrAsBytes);
                    this.payload = null;
                    return;
                }
            }
            int status2 = update.getStatus();
            if (status2 == 2 || status2 == 4) {
                Endpoint.this.needsRecovery = true;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/Endpoint$RecoverStep1;", "Ljava/lang/Runnable;", "<init>", "(Lcom/urbandroid/sleep/nearby/core/Endpoint;)V", "run", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class RecoverStep1 implements Runnable {
        public RecoverStep1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Endpoint.this.getClosed()) {
                return;
            }
            if (System.currentTimeMillis() - Endpoint.this.lastRecoveryAttempt > Endpoint.this.connectionInitiationTimeoutMillis && !Endpoint.this.isConnected()) {
                Endpoint.this.needsRecovery = true;
            }
            boolean z = Endpoint.this.needsRecovery;
            Endpoint endpoint = Endpoint.this;
            if (!z) {
                endpoint.mainHandler.postDelayed(Endpoint.this.new RecoverStep1(), Endpoint.this.recoveryIntervalMillis);
            } else {
                endpoint.shutdown();
                Endpoint.this.mainHandler.postDelayed(Endpoint.this.new RecoverStep2(), Endpoint.this.recoveryIntervalMillis);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/Endpoint$RecoverStep2;", "Ljava/lang/Runnable;", "<init>", "(Lcom/urbandroid/sleep/nearby/core/Endpoint;)V", "run", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class RecoverStep2 implements Runnable {
        public RecoverStep2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Endpoint.this.getClosed()) {
                return;
            }
            Endpoint.this.needsRecovery = false;
            Endpoint.this.lastRecoveryAttempt = System.currentTimeMillis();
            Endpoint.this.startAdvertising();
            Endpoint.this.startDiscovery();
            Endpoint.this.mainHandler.postDelayed(Endpoint.this.new RecoverStep1(), Endpoint.this.recoveryIntervalMillis);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Endpoint(String str, Context context, MyLogger myLogger, Function1<? super byte[], Unit> function1, Function1<? super ConnectionStatus, Unit> function12) {
        str.getClass();
        context.getClass();
        myLogger.getClass();
        function1.getClass();
        function12.getClass();
        this.serviceName = str;
        this.context = context;
        this.logger = myLogger;
        this.payloadConsumer = function1;
        this.statusChangeCallback = function12;
        boolean zIsDetailedPairLoggingExperiment = Experiments.getInstance().isDetailedPairLoggingExperiment();
        this.isDetailedPairLoggingExperiment = zIsDetailedPairLoggingExperiment;
        Handler handler = new Handler(context.getMainLooper());
        this.mainHandler = handler;
        Strategy strategy = Strategy.P2P_POINT_TO_POINT;
        strategy.getClass();
        this.strategy = strategy;
        this.recoveryIntervalMillis = 10000L;
        this.receiveConnectionTimeoutMillis = 60000L;
        this.connectionInitiationTimeoutMillis = 120000L;
        this.endpointName = ServiceNamesKt.generateToken(20);
        this.lastRecoveryAttempt = System.currentTimeMillis();
        propagateStatusChange();
        if (!zIsDetailedPairLoggingExperiment) {
            Logger.addFilter(Filters.filter$default(Matchers.startsWith("Nearby: status:"), FrequencyGuards.maxCountPerInterval(60, 50), 0, 4, null));
            Logger.addFilter(Filters.filter$default(Matchers.startsWith("Nearby: error:"), FrequencyGuards.maxCountPerInterval(60, 10), 0, 4, null));
        }
        ConnectionsClient connectionsClient = Nearby.getConnectionsClient(context);
        connectionsClient.getClass();
        this.client = connectionsClient;
        startAdvertising();
        startDiscovery();
        handler.postDelayed(new RecoverStep1(), 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(ConnectionStatus connectionStatus) {
        connectionStatus.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void propagateStatusChange() {
        this.statusChangeCallback.invoke(getStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestConnection(String discoveredEndpointId) {
        if (getClosed()) {
            return;
        }
        logStatus("requestConnection " + discoveredEndpointId);
        Task<Void> taskRequestConnection = this.client.requestConnection(this.endpointName, discoveredEndpointId, new MyConnectionLifecycleCallback());
        taskRequestConnection.getClass();
        int i = 1;
        taskRequestConnection.addOnSuccessListener(new Util$$ExternalSyntheticLambda2(new Endpoint$$ExternalSyntheticLambda3(this, i), i));
        taskRequestConnection.addOnFailureListener(new Endpoint$$ExternalSyntheticLambda5(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestConnection$lambda$0(Endpoint endpoint, Void r1) {
        endpoint.logStatus("requestConnection success");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestConnection$lambda$2(Endpoint endpoint, Exception exc) {
        exc.getClass();
        endpoint.logError("requestConnection failure", exc);
        endpoint.needsRecovery = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestConnectionAfterDelay(String discoveredEndpointId) {
        if (getClosed()) {
            return;
        }
        logStatus("ready to accept connection");
        this.mainHandler.postDelayed(new StartTrackActivity$$ExternalSyntheticLambda0(this, discoveredEndpointId, 6), this.receiveConnectionTimeoutMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestConnectionAfterDelay$lambda$0(Endpoint endpoint, String str) {
        if (endpoint.isConnected()) {
            return;
        }
        endpoint.logStatus("No incoming connection yet, trying to initiate it.");
        endpoint.requestConnection(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void send$lambda$0(Endpoint endpoint, byte[] bArr) {
        if (endpoint.getClosed() || endpoint.needsRecovery || endpoint.remoteEndpointId == null) {
            return;
        }
        ConnectionsClient connectionsClient = endpoint.client;
        String str = endpoint.remoteEndpointId;
        str.getClass();
        Task<Void> taskSendPayload = connectionsClient.sendPayload(str, Payload.fromBytes(bArr));
        int i = 0;
        taskSendPayload.addOnSuccessListener(new Util$$ExternalSyntheticLambda2(new Endpoint$$ExternalSyntheticLambda3(endpoint, i), 2)).addOnFailureListener(new Endpoint$$ExternalSyntheticLambda5(endpoint, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit send$lambda$0$0(Endpoint endpoint, Void r1) {
        endpoint.logPayload("sendPayload success");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void send$lambda$0$2(Endpoint endpoint, Exception exc) {
        exc.getClass();
        endpoint.logError("sendPayload failure", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shutdown() {
        logStatus("shutdown");
        this.remoteEndpointId = null;
        this.client.stopDiscovery();
        this.client.stopAdvertising();
        this.client.stopAllEndpoints();
        propagateStatusChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAdvertising() {
        logStatus("startAdvertising");
        this.client.startAdvertising(this.endpointName, this.serviceName, new MyConnectionLifecycleCallback(), new AdvertisingOptions.Builder().setStrategy(this.strategy).build()).addOnSuccessListener(new LoginFragment$$ExternalSyntheticLambda0(new Endpoint$$ExternalSyntheticLambda3(this, 3), 29)).addOnFailureListener(new Endpoint$$ExternalSyntheticLambda5(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startAdvertising$lambda$0(Endpoint endpoint, Void r1) {
        endpoint.logStatus("startAdvertising success");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAdvertising$lambda$2(Endpoint endpoint, Exception exc) {
        exc.getClass();
        endpoint.logError("startAdvertising failure", exc);
        endpoint.needsRecovery = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDiscovery() {
        logStatus("startDiscovery");
        this.client.startDiscovery(this.serviceName, new EndpointDiscoveryCallback() { // from class: com.urbandroid.sleep.nearby.core.Endpoint.startDiscovery.1
            @Override // com.google.android.gms.nearby.connection.EndpointDiscoveryCallback
            public void onEndpointFound(String endpointId, DiscoveredEndpointInfo epInfo) {
                endpointId.getClass();
                epInfo.getClass();
                Endpoint endpoint = Endpoint.this;
                String serviceId = epInfo.getServiceId();
                String endpointName = epInfo.getEndpointName();
                StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("onEndpointFound ", endpointId, " ", serviceId, " ");
                sbM6m.append(endpointName);
                endpoint.logStatus(sbM6m.toString());
                if (Intrinsics.areEqual(Endpoint.this.serviceName, epInfo.getServiceId())) {
                    if (Endpoint.this.isConnected()) {
                        Endpoint.this.logStatus("already connected, ignoring the new device.");
                        return;
                    }
                    int iCompareTo = epInfo.getEndpointName().compareTo(Endpoint.this.endpointName);
                    Endpoint endpoint2 = Endpoint.this;
                    if (iCompareTo < 0) {
                        endpoint2.requestConnection(endpointId);
                    } else {
                        endpoint2.requestConnectionAfterDelay(endpointId);
                    }
                }
            }

            @Override // com.google.android.gms.nearby.connection.EndpointDiscoveryCallback
            public void onEndpointLost(String endpointId) {
                endpointId.getClass();
                Endpoint.this.logStatus("onEndpointLost " + endpointId);
            }
        }, new DiscoveryOptions.Builder().setStrategy(this.strategy).build()).addOnSuccessListener(new Util$$ExternalSyntheticLambda2(new Endpoint$$ExternalSyntheticLambda3(this, 2), 3)).addOnFailureListener(new Endpoint$$ExternalSyntheticLambda5(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDiscovery$lambda$0(Endpoint endpoint, Void r1) {
        endpoint.logStatus("startDiscovery success");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDiscovery$lambda$2(Endpoint endpoint, Exception exc) {
        exc.getClass();
        endpoint.logError("startDiscovery failure", exc);
        endpoint.needsRecovery = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        logStatus("close");
        this.mainHandler.post(new Endpoint$$ExternalSyntheticLambda0(this, 0));
    }

    public final ConnectionStatus getStatus() {
        return isConnected() ? ConnectionStatus.CONNECTED : ConnectionStatus.DISCONNECTED;
    }

    /* JADX INFO: renamed from: isClosed, reason: from getter */
    public final boolean getClosed() {
        return this.closed;
    }

    public final boolean isConnected() {
        return this.remoteEndpointId != null;
    }

    public final void logError(String s, Throwable e) {
        s.getClass();
        e.getClass();
        MyLogger myLogger = this.logger;
        String name = e.getClass().getName();
        String message = e.getMessage();
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Nearby: error: ", s, " ", name, " ");
        sbM6m.append(message);
        MyLogger.logInfo$default(myLogger, sbM6m.toString(), null, 2, null);
    }

    public final void logPayload(String s) {
        s.getClass();
        if (this.isDetailedPairLoggingExperiment) {
            MyLogger.logInfo$default(this.logger, FileInsert$$ExternalSyntheticOutline0.m("Nearby: payload: ", s), null, 2, null);
        }
    }

    public final void logStatus(String s) {
        s.getClass();
        MyLogger.logInfo$default(this.logger, FileInsert$$ExternalSyntheticOutline0.m("Nearby: status: ", s), null, 2, null);
    }

    public final void send(byte[] payload) {
        payload.getClass();
        this.mainHandler.post(new StartTrackActivity$$ExternalSyntheticLambda0(this, payload, 7));
    }

    public /* synthetic */ Endpoint(String str, Context context, MyLogger myLogger, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, context, myLogger, function1, (i & 16) != 0 ? new AiPrompt$$ExternalSyntheticLambda0(19) : function12);
    }
}
