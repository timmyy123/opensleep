package com.urbandroid.sleep.nearby.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.sleep.StartTrackActivity$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001/B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000fH\u0002J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$J\b\u0010)\u001a\u00020\u000bH\u0016J\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/ReliableMessageQueue;", "Ljava/io/Closeable;", IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "logger", "Lcom/urbandroid/sleep/nearby/core/MyLogger;", "messageConsumer", "Lkotlin/Function1;", "Lcom/urbandroid/sleep/nearby/core/Message;", "", "maxBufferSize", "", "flushIntervalMillis", "", "statusChangeCallback", "Lcom/urbandroid/sleep/nearby/core/ConnectionStatus;", "<init>", "(Ljava/lang/String;Landroid/content/Context;Lcom/urbandroid/sleep/nearby/core/MyLogger;Lkotlin/jvm/functions/Function1;IJLkotlin/jvm/functions/Function1;)V", "mainHandler", "Landroid/os/Handler;", "endpoint", "Lcom/urbandroid/sleep/nearby/core/Endpoint;", "buffer", "", "serialNo", "lastReceivedSerialNo", "consume", "byteArray", "", "consumeMessages", "jsonMessages", "Lorg/json/JSONArray;", "consumeUnreliableMessage", "payload", "Lorg/json/JSONObject;", "consumeAck", "ack", "sendReliable", "sendUnreliable", "close", "isClosed", "", "flush", "sendAck", "sendMessages", "PeriodicSendAndAcknowledge", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReliableMessageQueue implements Closeable {
    private final List<Message> buffer;
    private final Context context;
    private final Endpoint endpoint;
    private final long flushIntervalMillis;
    private long lastReceivedSerialNo;
    private final MyLogger logger;
    private final Handler mainHandler;
    private final int maxBufferSize;
    private final Function1<Message, Unit> messageConsumer;
    private long serialNo;
    private final String serviceName;
    private final Function1<ConnectionStatus, Unit> statusChangeCallback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/ReliableMessageQueue$PeriodicSendAndAcknowledge;", "Ljava/lang/Runnable;", "<init>", "(Lcom/urbandroid/sleep/nearby/core/ReliableMessageQueue;)V", "run", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class PeriodicSendAndAcknowledge implements Runnable {
        public PeriodicSendAndAcknowledge() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            if (ReliableMessageQueue.this.endpoint.getClosed()) {
                return;
            }
            ReliableMessageQueue.this.flush();
            ReliableMessageQueue.this.mainHandler.postDelayed(this, ReliableMessageQueue.this.flushIntervalMillis);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReliableMessageQueue(String str, Context context, MyLogger myLogger, Function1<? super Message, Unit> function1, int i, long j, Function1<? super ConnectionStatus, Unit> function12) {
        str.getClass();
        context.getClass();
        myLogger.getClass();
        function1.getClass();
        function12.getClass();
        this.serviceName = str;
        this.context = context;
        this.logger = myLogger;
        this.messageConsumer = function1;
        this.maxBufferSize = i;
        this.flushIntervalMillis = j;
        this.statusChangeCallback = function12;
        Handler handler = new Handler(context.getMainLooper());
        this.mainHandler = handler;
        this.endpoint = new Endpoint(str, context, myLogger, new CodecsKt$$ExternalSyntheticLambda2(this, 11), function12);
        this.buffer = new ArrayList();
        this.lastReceivedSerialNo = -1L;
        handler.post(new PeriodicSendAndAcknowledge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(ConnectionStatus connectionStatus) {
        connectionStatus.getClass();
        return Unit.INSTANCE;
    }

    private final void consume(byte[] byteArray) throws JSONException {
        JSONObject jSONObject = new JSONObject(new String(byteArray, Charsets.UTF_8));
        String string = jSONObject.getString("type");
        if (string != null) {
            int iHashCode = string.hashCode();
            if (iHashCode != 96393) {
                if (iHashCode != 108417) {
                    if (iHashCode == 115961 && string.equals("unr")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("val");
                        jSONObject2.getClass();
                        consumeUnreliableMessage(jSONObject2);
                        return;
                    }
                } else if (string.equals(SDKConstants.PARAM_DEBUG_MESSAGE)) {
                    JSONArray jSONArray = jSONObject.getJSONArray("val");
                    jSONArray.getClass();
                    consumeMessages(jSONArray);
                    return;
                }
            } else if (string.equals("ack")) {
                consumeAck(jSONObject.getLong("val"));
                return;
            }
        }
        MyLogger.logWarning$default(this.logger, FileInsert$$ExternalSyntheticOutline0.m("Unknown type: ", string), null, 2, null);
    }

    private final void consumeAck(long ack) {
        while (!this.buffer.isEmpty() && this.buffer.get(0).getSerialNo() <= ack) {
            this.buffer.remove(0);
        }
    }

    private final void consumeMessages(JSONArray jsonMessages) throws JSONException {
        int length = jsonMessages.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jsonMessages.getJSONObject(i);
            long j = jSONObject.getLong("sn");
            JSONObject jSONObject2 = jSONObject.getJSONObject("pl");
            if (j > this.lastReceivedSerialNo) {
                Function1<Message, Unit> function1 = this.messageConsumer;
                jSONObject2.getClass();
                function1.invoke(new Message(j, jSONObject2));
                this.lastReceivedSerialNo = j;
            }
        }
    }

    private final void consumeUnreliableMessage(JSONObject payload) {
        this.messageConsumer.invoke(new Message(-1L, payload));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit endpoint$lambda$0(ReliableMessageQueue reliableMessageQueue, byte[] bArr) throws JSONException {
        bArr.getClass();
        reliableMessageQueue.consume(bArr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flush() throws JSONException {
        if (this.endpoint.getClosed() || !this.endpoint.isConnected() || this.buffer.isEmpty()) {
            return;
        }
        sendAck();
        sendMessages();
    }

    private final void sendAck() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "ack");
        jSONObject.put("val", this.lastReceivedSerialNo);
        String string = jSONObject.toString();
        string.getClass();
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        bytes.getClass();
        this.endpoint.send(bytes);
    }

    private final void sendMessages() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        int iMin = Math.min(100, this.buffer.size());
        for (int i = 0; i < iMin; i++) {
            Message message = this.buffer.get(i);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sn", message.getSerialNo());
            jSONObject.put("pl", message.getPayload());
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", SDKConstants.PARAM_DEBUG_MESSAGE);
        jSONObject2.put("val", jSONArray);
        String string = jSONObject2.toString();
        string.getClass();
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        bytes.getClass();
        this.endpoint.send(bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendReliable$lambda$0(ReliableMessageQueue reliableMessageQueue, JSONObject jSONObject) {
        while (true) {
            int size = reliableMessageQueue.buffer.size();
            int i = reliableMessageQueue.maxBufferSize;
            List<Message> list = reliableMessageQueue.buffer;
            if (size < i) {
                list.add(new Message(reliableMessageQueue.serialNo, jSONObject));
                reliableMessageQueue.serialNo++;
                return;
            }
            list.remove(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.endpoint.close();
    }

    public final boolean isClosed() {
        return this.endpoint.getClosed();
    }

    public final void sendReliable(JSONObject payload) {
        payload.getClass();
        this.mainHandler.post(new StartTrackActivity$$ExternalSyntheticLambda0(this, payload, 8));
    }

    public final void sendUnreliable(JSONObject payload) {
        payload.getClass();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "unr");
        jSONObject.put("val", payload);
        String string = jSONObject.toString();
        string.getClass();
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        bytes.getClass();
        this.endpoint.send(bytes);
    }

    public /* synthetic */ ReliableMessageQueue(String str, Context context, MyLogger myLogger, Function1 function1, int i, long j, Function1 function12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, context, myLogger, function1, (i2 & 16) != 0 ? 1000 : i, (i2 & 32) != 0 ? 10000L : j, (i2 & 64) != 0 ? new AiPrompt$$ExternalSyntheticLambda0(20) : function12);
    }
}
