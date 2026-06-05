package com.urbandroid.sleep.smartwatch.pebble;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever;
import io.rebble.pebblekit2.client.DefaultPebbleSender;
import io.rebble.pebblekit2.client.PebbleSender;
import io.rebble.pebblekit2.common.model.PebbleDictionaryItem;
import io.rebble.pebblekit2.model.ConnectedWatch;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0002RQB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b \u0010\u001cJ\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000eH\u0016¢\u0006\u0004\b(\u0010\u001eJ\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u0019H\u0016¢\u0006\u0004\b-\u0010\u001cJ\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000eH\u0002¢\u0006\u0004\b1\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00102\u001a\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010\t\"\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010A\u001a\b\u0018\u00010@R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010C\u001a\b\u0018\u00010@R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010BR\u001c\u0010D\u001a\b\u0018\u00010@R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u001c\u0010E\u001a\b\u0018\u00010@R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010BR\u001c\u0010F\u001a\b\u0018\u00010@R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010BR\u0016\u0010G\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010KR\u0014\u0010P\u001a\u00020M8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/pebble/RePebble;", "Lcom/urbandroid/sleep/smartwatch/SmartWatch;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Lio/rebble/pebblekit2/client/DefaultPebbleSender;", "getSenderLazy", "()Lio/rebble/pebblekit2/client/DefaultPebbleSender;", "Lcom/urbandroid/sleep/smartwatch/IConnectivityCallback;", "callback", "", "timeoutMillis", "", "asyncConnectionCheck", "(Lcom/urbandroid/sleep/smartwatch/IConnectivityCallback;J)V", "", "isConnected", "()Z", "startApp", "ts", "updateAlarm", "(J)V", "updatePause", "", "delay", "startAlarm", "(I)V", "stopAlarm", "()V", "batchSize", "setBatchSize", "suspended", "setSuspended", "(Z)V", "Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;", "listener", "startTracking", "(Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;)V", "stopTracking", "Lcom/urbandroid/sleep/sensor/IAccelManager;", "getAccelManager", "()Lcom/urbandroid/sleep/sensor/IAccelManager;", "repeat", ViewHierarchyConstants.HINT_KEY, "", "getPlatform", "()Ljava/lang/String;", "setEnableHr", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "sender", "Lio/rebble/pebblekit2/client/DefaultPebbleSender;", "getSender", "setSender", "(Lio/rebble/pebblekit2/client/DefaultPebbleSender;)V", "Lcom/urbandroid/sleep/smartwatch/pebble/PebbleAccelManager;", "accelManager", "Lcom/urbandroid/sleep/smartwatch/pebble/PebbleAccelManager;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/urbandroid/sleep/smartwatch/pebble/RePebble$ResendNAckedTemplate;", "startAlarmResender", "Lcom/urbandroid/sleep/smartwatch/pebble/RePebble$ResendNAckedTemplate;", "setBatchSizeResender", "enableHrResender", "suspendStatusResender", "hintResender", "trackingRunning", "Z", "Ljava/lang/Runnable;", "startAppRunnable", "Ljava/lang/Runnable;", "closeSenderRunnable", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Companion", "ResendNAckedTemplate", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RePebble implements SmartWatch, CoroutineScope {
    private static final UUID APP_UUID;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object QUEUE_LOCK;
    private static final LinkedList<ResendNAckedTemplate> queuedTemplates;
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final PebbleAccelManager accelManager;
    private final Runnable closeSenderRunnable;
    private final Context context;
    private ResendNAckedTemplate enableHrResender;
    private final Handler handler;
    private ResendNAckedTemplate hintResender;
    private DefaultPebbleSender sender;
    private ResendNAckedTemplate setBatchSizeResender;
    private ResendNAckedTemplate startAlarmResender;
    private final Runnable startAppRunnable;
    private ResendNAckedTemplate suspendStatusResender;
    private boolean trackingRunning;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0018\u00010\nR\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/pebble/RePebble$Companion;", "", "<init>", "()V", "APP_UUID", "Ljava/util/UUID;", "getAPP_UUID", "()Ljava/util/UUID;", "queuedTemplates", "Ljava/util/LinkedList;", "Lcom/urbandroid/sleep/smartwatch/pebble/RePebble$ResendNAckedTemplate;", "Lcom/urbandroid/sleep/smartwatch/pebble/RePebble;", "QUEUE_LOCK", "MESSAGE_TIMEOUT_MS", "", "pebbleStartDisabledTill", "isPebbleStartBlocked", "", "()Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UUID getAPP_UUID() {
            return RePebble.APP_UUID;
        }

        public final boolean isPebbleStartBlocked() {
            return false;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.pebble.RePebble$isConnected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$isConnected$1", f = "RePebble.kt", l = {78}, m = "invokeSuspend", v = 2)
    public static final class C21821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ DefaultPebbleInfoRetriever $infoRetriever;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21821(DefaultPebbleInfoRetriever defaultPebbleInfoRetriever, Continuation<? super C21821> continuation) {
            super(2, continuation);
            this.$infoRetriever = defaultPebbleInfoRetriever;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21821(this.$infoRetriever, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C21821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<ConnectedWatch>> connectedWatches = this.$infoRetriever.getConnectedWatches();
                this.label = 1;
                obj = FlowKt.firstOrNull(connectedWatches, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(obj != null);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.pebble.RePebble$startApp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$startApp$1", f = "RePebble.kt", l = {106}, m = "invokeSuspend", v = 2)
    public static final class C21871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.pebble.RePebble$startApp$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$startApp$1$1", f = "RePebble.kt", l = {109}, m = "invokeSuspend", v = 2)
        public static final class C00561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RePebble this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00561(RePebble rePebble, Continuation<? super C00561> continuation) {
                super(2, continuation);
                this.this$0 = rePebble;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00561(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Logger.logInfo("RePebble: Starting app");
                        DefaultPebbleSender senderLazy = this.this$0.getSenderLazy();
                        UUID app_uuid = RePebble.INSTANCE.getAPP_UUID();
                        this.label = 1;
                        if (PebbleSender.startAppOnTheWatch$default(senderLazy, app_uuid, null, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                } catch (IllegalArgumentException e) {
                    Logger.logSevere("Pebble app not installed, startApp()", e);
                }
                return Unit.INSTANCE;
            }
        }

        public C21871(Continuation<? super C21871> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RePebble.this.new C21871(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C00561 c00561 = new C00561(RePebble.this, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, c00561, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.pebble.RePebble$stopAlarm$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$stopAlarm$2", f = "RePebble.kt", l = {210}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.pebble.RePebble$stopAlarm$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$stopAlarm$2$1", f = "RePebble.kt", l = {212}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RePebble this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RePebble rePebble, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = rePebble;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        DefaultPebbleSender senderLazy = this.this$0.getSenderLazy();
                        UUID app_uuid = RePebble.INSTANCE.getAPP_UUID();
                        this.label = 1;
                        if (PebbleSender.stopAppOnTheWatch$default(senderLazy, app_uuid, null, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                } catch (Exception e) {
                    Logger.logSevere("RePebble stop error", e);
                }
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RePebble.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(RePebble.this, null);
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.pebble.RePebble$stopTracking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$stopTracking$1", f = "RePebble.kt", l = {300}, m = "invokeSuspend", v = 2)
    public static final class C21891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.pebble.RePebble$stopTracking$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.pebble.RePebble$stopTracking$1$1", f = "RePebble.kt", l = {302}, m = "invokeSuspend", v = 2)
        public static final class C00571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
            int label;
            final /* synthetic */ RePebble this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00571(RePebble rePebble, Continuation<? super C00571> continuation) {
                super(2, continuation);
                this.this$0 = rePebble;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00571(this.this$0, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
                return ((C00571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i != 0) {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    DefaultPebbleSender senderLazy = this.this$0.getSenderLazy();
                    UUID app_uuid = RePebble.INSTANCE.getAPP_UUID();
                    this.label = 1;
                    Object objStopAppOnTheWatch$default = PebbleSender.stopAppOnTheWatch$default(senderLazy, app_uuid, null, this, 2, null);
                    return objStopAppOnTheWatch$default == coroutine_suspended ? coroutine_suspended : objStopAppOnTheWatch$default;
                } catch (Exception e) {
                    Logger.logSevere("RePebble: stop error", e);
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
                return invoke2(coroutineScope, (Continuation<Object>) continuation);
            }
        }

        public C21891(Continuation<? super C21891> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RePebble.this.new C21891(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C00571 c00571 = new C00571(RePebble.this, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, c00571, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            RePebble.this.handler.postDelayed(RePebble.this.closeSenderRunnable, 3000L);
            return Unit.INSTANCE;
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("24b0a1e5-f0b1-440d-8e53-8f26688a3f07");
        uuidFromString.getClass();
        APP_UUID = uuidFromString;
        queuedTemplates = new LinkedList<>();
        QUEUE_LOCK = new Object();
    }

    public RePebble(Context context) {
        context.getClass();
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.context = context;
        this.startAppRunnable = new RePebble$$ExternalSyntheticLambda0(this, 1);
        this.closeSenderRunnable = new RePebble$$ExternalSyntheticLambda0(this, 2);
        this.accelManager = new PebbleAccelManager(context);
        this.handler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeSenderRunnable$lambda$0(RePebble rePebble) {
        Logger.logInfo("RePebble: Closing sender");
        DefaultPebbleSender defaultPebbleSender = rePebble.sender;
        if (defaultPebbleSender != null) {
            if (defaultPebbleSender != null) {
                try {
                    defaultPebbleSender.close();
                } catch (Exception unused) {
                    Logger.logSevere("RePebble: Sender already closed");
                }
            }
            rePebble.sender = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEnableHr() {
        if (this.trackingRunning) {
            Logger.logInfo("RePebble: enabling hr");
            ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate(this) { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.setEnableHr.1
                {
                    super();
                }

                @Override // com.urbandroid.sleep.smartwatch.pebble.RePebble.ResendNAckedTemplate
                public Map<UInt, PebbleDictionaryItem> doCreateDictionary() {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(UInt.m2388boximpl(10), new PebbleDictionaryItem.UInt8(1));
                    return linkedHashMap;
                }
            };
            this.enableHrResender = resendNAckedTemplate;
            resendNAckedTemplate.send();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAppRunnable$lambda$0(RePebble rePebble) {
        Logger.logInfo("RePebble: Restarting app on pebble");
        rePebble.startApp();
    }

    public void asyncConnectionCheck(final IConnectivityCallback callback, long timeoutMillis) {
        callback.getClass();
        final long jCurrentTimeMillis = System.currentTimeMillis() + timeoutMillis;
        new Runnable() { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.asyncConnectionCheck.1
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long j = jCurrentTimeMillis;
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("RePebble: connectivity check ", " < ", jCurrentTimeMillis2);
                sbM.append(j);
                Logger.logSevere(sbM.toString());
                if (System.currentTimeMillis() > jCurrentTimeMillis || callback.isCancelled()) {
                    callback.status(this, false);
                } else if (this.isConnected()) {
                    callback.status(this, true);
                } else {
                    new Handler().postDelayed(this, 500L);
                }
            }
        }.run();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public IAccelManager getAccelManager() {
        return this.accelManager;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        return "RePebble";
    }

    public final DefaultPebbleSender getSenderLazy() {
        if (this.sender == null) {
            this.sender = new DefaultPebbleSender(this.context);
        }
        DefaultPebbleSender defaultPebbleSender = this.sender;
        defaultPebbleSender.getClass();
        return defaultPebbleSender;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(final int repeat) {
        ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate(this) { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.hint.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.RePebble.ResendNAckedTemplate
            public Map<UInt, PebbleDictionaryItem> doCreateDictionary() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(UInt.m2388boximpl(8), new PebbleDictionaryItem.UInt8(repeat));
                return linkedHashMap;
            }
        };
        this.hintResender = resendNAckedTemplate;
        resendNAckedTemplate.send();
    }

    public final boolean isConnected() {
        try {
            return ((Boolean) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21821(new DefaultPebbleInfoRetriever(this.context), null), 1, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setBatchSize(final int batchSize) {
        if (this.trackingRunning) {
            Logger.logInfo("RePebble: Setting Pebble batch size to: " + batchSize);
            ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate(this) { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.setBatchSize.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.urbandroid.sleep.smartwatch.pebble.RePebble.ResendNAckedTemplate
                public Map<UInt, PebbleDictionaryItem> doCreateDictionary() {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(UInt.m2388boximpl(5), new PebbleDictionaryItem.UInt8(batchSize));
                    return linkedHashMap;
                }
            };
            this.setBatchSizeResender = resendNAckedTemplate;
            resendNAckedTemplate.send();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setSuspended(final boolean suspended) {
        if (this.trackingRunning) {
            ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate(this) { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.setSuspended.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.urbandroid.sleep.smartwatch.pebble.RePebble.ResendNAckedTemplate
                public Map<UInt, PebbleDictionaryItem> doCreateDictionary() {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(UInt.m2388boximpl(6), new PebbleDictionaryItem.UInt8(suspended ? 1 : 0));
                    return linkedHashMap;
                }
            };
            this.suspendStatusResender = resendNAckedTemplate;
            resendNAckedTemplate.send();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(final int delay) {
        if (!startApp()) {
            Logger.logSevere("RePebble: App not installed, startAlarm()");
            return;
        }
        ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate(this) { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.startAlarm.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.RePebble.ResendNAckedTemplate
            public Map<UInt, PebbleDictionaryItem> doCreateDictionary() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(UInt.m2388boximpl(1), new PebbleDictionaryItem.Int32(delay));
                return linkedHashMap;
            }
        };
        this.startAlarmResender = resendNAckedTemplate;
        resendNAckedTemplate.send();
    }

    public final boolean startApp() {
        if (INSTANCE.isPebbleStartBlocked()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21871(null), 3, null);
        return true;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener listener) {
        try {
            this.trackingRunning = true;
            if (!startApp()) {
                Logger.logSevere("RePebble: app not installed, startTracking()");
                return;
            }
            Logger.logInfo("RePebble: Starting tracking");
            if (new Settings(this.context).isHrWear()) {
                this.handler.postDelayed(new RePebble$$ExternalSyntheticLambda0(this, 0), 5000L);
            }
        } catch (Exception e) {
            Logger.logSevere("RePebble start error", e);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
        ResendNAckedTemplate resendNAckedTemplate = this.startAlarmResender;
        if (resendNAckedTemplate != null) {
            resendNAckedTemplate.cancel();
        }
        this.startAlarmResender = null;
        ResendNAckedTemplate resendNAckedTemplate2 = this.setBatchSizeResender;
        if (resendNAckedTemplate2 != null) {
            resendNAckedTemplate2.cancel();
        }
        this.setBatchSizeResender = null;
        ResendNAckedTemplate resendNAckedTemplate3 = this.enableHrResender;
        if (resendNAckedTemplate3 != null) {
            resendNAckedTemplate3.cancel();
        }
        ResendNAckedTemplate resendNAckedTemplate4 = this.suspendStatusResender;
        if (resendNAckedTemplate4 != null) {
            resendNAckedTemplate4.cancel();
        }
        this.suspendStatusResender = null;
        ResendNAckedTemplate resendNAckedTemplate5 = this.hintResender;
        if (resendNAckedTemplate5 != null) {
            resendNAckedTemplate5.cancel();
        }
        this.hintResender = null;
        new ResendNAckedTemplate(this) { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.stopAlarm.1
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.RePebble.ResendNAckedTemplate
            public Map<UInt, PebbleDictionaryItem> doCreateDictionary() {
                Logger.logInfo("RePebble: Sending stop alarm.");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(UInt.m2388boximpl(2), new PebbleDictionaryItem.UInt8(1));
                return linkedHashMap;
            }
        }.send();
        if (this.trackingRunning) {
            return;
        }
        this.handler.removeCallbacks(this.startAppRunnable);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass2(null), 3, null);
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        this.trackingRunning = false;
        Logger.logInfo("RePebble: Stopping tracking");
        this.handler.removeCallbacks(this.startAppRunnable);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21891(null), 3, null);
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(final long ts) {
        new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.updateAlarm.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.RePebble.ResendNAckedTemplate
            public Map<UInt, PebbleDictionaryItem> doCreateDictionary() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(ts);
                int i = calendar.get(10);
                if (new Settings(RePebble.this.getContext()).is24HourFormat()) {
                    i = calendar.get(11);
                }
                int i2 = calendar.get(12);
                zza$$ExternalSyntheticOutline0.m(i, i2, "RePebble: updating alarm ", ":");
                if (ts - System.currentTimeMillis() < TimeChart.DAY) {
                    linkedHashMap.put(UInt.m2388boximpl(3), new PebbleDictionaryItem.UInt8(i));
                    linkedHashMap.put(UInt.m2388boximpl(4), new PebbleDictionaryItem.UInt8(i2));
                }
                int offset = (int) ((ts + ((long) TimeZone.getDefault().getOffset(ts))) / 1000);
                Logger.logInfo("RePebble: updating alarm " + ts);
                Logger.logInfo("RePebble: updating alarm, timezone adjusted " + (((long) offset) - ts));
                return linkedHashMap;
            }
        }.send();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(final long ts) {
        new ResendNAckedTemplate(this) { // from class: com.urbandroid.sleep.smartwatch.pebble.RePebble.updatePause.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.RePebble.ResendNAckedTemplate
            public Map<UInt, PebbleDictionaryItem> doCreateDictionary() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Logger.logInfo("RePebble: updating pause " + ts);
                int offset = (int) ((ts + ((long) TimeZone.getDefault().getOffset(ts))) / 1000);
                Logger.logInfo("RePebble: updating pause, timezone adjusted " + (((long) offset) - ts));
                linkedHashMap.put(UInt.m2388boximpl(7), new PebbleDictionaryItem.Int32(offset));
                return linkedHashMap;
            }
        }.send();
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b¢\u0004\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0007\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006J\u001b\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH&¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/smartwatch/pebble/RePebble$ResendNAckedTemplate;", "", "<init>", "(Lcom/urbandroid/sleep/smartwatch/pebble/RePebble;)V", "", "cancel", "()V", "send", "", "delay", "(J)V", "doSend", "removeSelfAndExecuteNext", "", "Lkotlin/UInt;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "doCreateDictionary", "()Ljava/util/Map;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "", "retry", "I", "getRetry", "()I", "setRetry", "(I)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public abstract class ResendNAckedTemplate {
        private Job job;
        private int retry = 3;

        public ResendNAckedTemplate() {
        }

        public final void cancel() {
            Job job = this.job;
            if (job != null) {
                Job.cancel$default(job, null, 1, null);
            }
            synchronized (RePebble.QUEUE_LOCK) {
                Logger.logInfo("RePebble: Adding to pebble queue.");
                RePebble.queuedTemplates.remove(this);
            }
        }

        public abstract Map<UInt, PebbleDictionaryItem> doCreateDictionary();

        public final void doSend(long delay) {
            Map<UInt, PebbleDictionaryItem> mapDoCreateDictionary = doCreateDictionary();
            RePebble rePebble = RePebble.this;
            this.job = BuildersKt__Builders_commonKt.launch$default(rePebble, null, null, new RePebble$ResendNAckedTemplate$doSend$1(delay, mapDoCreateDictionary, rePebble, this, null), 3, null);
        }

        public final int getRetry() {
            return this.retry;
        }

        public final void removeSelfAndExecuteNext() {
            if (RePebble.queuedTemplates.isEmpty()) {
                Logger.logSevere("Pebble: Unexpected first element in resend queue!!");
                return;
            }
            RePebble.queuedTemplates.removeFirst();
            if (RePebble.queuedTemplates.isEmpty()) {
                return;
            }
            try {
                Object first = RePebble.queuedTemplates.getFirst();
                first.getClass();
                ((ResendNAckedTemplate) first).doSend();
            } catch (Exception unused) {
                Logger.logWarning("RePebble: Failed to remove first ");
            }
        }

        public final void send(long delay) {
            synchronized (RePebble.QUEUE_LOCK) {
                try {
                    Logger.logInfo("RePebble: Adding to pebble queue.");
                    RePebble.queuedTemplates.addLast(this);
                    if (RePebble.queuedTemplates.size() > 1) {
                        Logger.logInfo("RePebble queue non-empty. Post-add: " + RePebble.queuedTemplates.size() + " ... waiting.");
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            doSend();
        }

        public final void setRetry(int i) {
            this.retry = i;
        }

        public final void doSend() {
            doSend(-1L);
        }

        public final void send() {
            send(-1L);
        }
    }
}
