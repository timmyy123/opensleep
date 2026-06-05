package com.urbandroid.smartlight.ikea.tradfri;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.net.nsd.NsdManager;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.ikea.tradfri.Client;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0005R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "discover", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "callback", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$DiscoveryCallback;", IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, "ip", "(Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$DiscoveryCallback;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticate", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access;", "gateway", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "identity", "securityCode", "(Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateNextIdentity", "Access", "Gateway", "DiscoveryCallback", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Tradfri implements FeatureLogger {
    public static final Tradfri INSTANCE = new Tradfri();
    private static final String tag = DiscoveryKt.TAG;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$DiscoveryCallback;", "", "started", "", "found", "gateway", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "(Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "failed", SDKConstants.PARAM_DEBUG_MESSAGE, "", "finished", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface DiscoveryCallback {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void failed(DiscoveryCallback discoveryCallback, String str) {
                str.getClass();
            }

            public static void finished(DiscoveryCallback discoveryCallback) {
            }

            public static void started(DiscoveryCallback discoveryCallback) {
            }
        }

        void failed(String msg);

        void finished();

        Object found(Gateway gateway, Continuation<? super Unit> continuation);

        void started();
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.Tradfri$discover$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Tradfri$discover$2", f = "Tradfri.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DiscoveryCallback $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $ip;
        final /* synthetic */ CoroutineScope $scope;
        final /* synthetic */ String $serviceName;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.Tradfri$discover$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Tradfri$discover$2$1", f = "Tradfri.kt", l = {84}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DiscoveryCallback $callback;
            final /* synthetic */ DiscoveryListener $listener;
            final /* synthetic */ NsdManager $nsdManager;
            int I$0;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(DiscoveryListener discoveryListener, NsdManager nsdManager, DiscoveryCallback discoveryCallback, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$listener = discoveryListener;
                this.$nsdManager = nsdManager;
                this.$callback = discoveryCallback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$listener, this.$nsdManager, this.$callback, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00cb A[Catch: all -> 0x0018, TRY_LEAVE, TryCatch #1 {all -> 0x0018, blocks: (B:6:0x0014, B:21:0x0054, B:13:0x002b, B:16:0x0039, B:18:0x003f, B:22:0x0057, B:23:0x0095, B:27:0x00bf, B:29:0x00cb, B:26:0x009e), top: B:36:0x0014, inners: #0 }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0051 -> B:21:0x0054). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                int i;
                CoroutineScope coroutineScope;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    i = 10;
                    coroutineScope = (CoroutineScope) this.L$0;
                    if (this.$listener.isFinished().get()) {
                    }
                    Tradfri tradfri = Tradfri.INSTANCE;
                    StringBuilder sb = new StringBuilder();
                    sb.append("discover stopping ... [timeout: ");
                    sb.append(!this.$listener.isFinished().get());
                    sb.append(']');
                    String string = sb.toString();
                    Logger.logInfo(Logger.defaultTag, tradfri.getTag() + ": " + ((Object) string), null);
                    this.$nsdManager.stopServiceDiscovery(this.$listener);
                    if (!this.$listener.isFinished().get()) {
                    }
                    this.$listener.close();
                    return Unit.INSTANCE;
                }
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = this.I$0;
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i--;
                    if (this.$listener.isFinished().get() && i > 0 && CoroutineScopeKt.isActive(coroutineScope)) {
                        long secondsInMillis = Utils.getSecondsInMillis(5) / 10;
                        this.L$0 = coroutineScope;
                        this.I$0 = i;
                        this.label = 1;
                        if (DelayKt.delay(secondsInMillis, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i--;
                        if (this.$listener.isFinished().get()) {
                        }
                        Tradfri tradfri2 = Tradfri.INSTANCE;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("discover stopping ... [timeout: ");
                        sb2.append(!this.$listener.isFinished().get());
                        sb2.append(']');
                        String string2 = sb2.toString();
                        Logger.logInfo(Logger.defaultTag, tradfri2.getTag() + ": " + ((Object) string2), null);
                        this.$nsdManager.stopServiceDiscovery(this.$listener);
                        if (!this.$listener.isFinished().get()) {
                        }
                        this.$listener.close();
                        return Unit.INSTANCE;
                    }
                    Tradfri tradfri22 = Tradfri.INSTANCE;
                    StringBuilder sb22 = new StringBuilder();
                    sb22.append("discover stopping ... [timeout: ");
                    sb22.append(!this.$listener.isFinished().get());
                    sb22.append(']');
                    String string22 = sb22.toString();
                    Logger.logInfo(Logger.defaultTag, tradfri22.getTag() + ": " + ((Object) string22), null);
                    try {
                        this.$nsdManager.stopServiceDiscovery(this.$listener);
                    } catch (Exception e) {
                        Tradfri tradfri3 = Tradfri.INSTANCE;
                        String strValueOf = String.valueOf(e);
                        Logger.logSevere(Logger.defaultTag, tradfri3.getTag() + ": " + ((Object) strValueOf), null);
                    }
                    if (!this.$listener.isFinished().get()) {
                        this.$callback.failed("Timeout");
                    }
                    this.$listener.close();
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    this.$listener.close();
                    throw th;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, DiscoveryCallback discoveryCallback, String str, String str2, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$callback = discoveryCallback;
            this.$serviceName = str;
            this.$ip = str2;
            this.$scope = coroutineScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.$callback, this.$serviceName, this.$ip, this.$scope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            NsdManager nsdManager = DiscoveryKt.getNsdManager(this.$context);
            DiscoveryListener discoveryListener = new DiscoveryListener(this.$context, this.$callback, this.$serviceName, this.$ip);
            BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass1(discoveryListener, nsdManager, this.$callback, null), 3, null);
            nsdManager.discoverServices(TradfriKt.NSD_SERVICE_TYPE, 1, discoveryListener);
            return Unit.INSTANCE;
        }
    }

    private Tradfri() {
    }

    public static /* synthetic */ Object discover$default(Tradfri tradfri, CoroutineScope coroutineScope, Context context, DiscoveryCallback discoveryCallback, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str = null;
        }
        return tradfri.discover(coroutineScope, context, discoveryCallback, str, str2, continuation);
    }

    public final Object authenticate(Gateway gateway, String str, String str2, Continuation<? super Access> continuation) {
        return new Client.Plain(gateway, str2).authenticate(str, continuation);
    }

    public final Object discover(CoroutineScope coroutineScope, Context context, DiscoveryCallback discoveryCallback, String str, String str2, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(coroutineScope.getCoroutineContext().plus(Dispatchers.getIO()), new AnonymousClass2(context, discoveryCallback, str, str2, coroutineScope, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final String generateNextIdentity() {
        return "SaA-" + System.currentTimeMillis();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return tag;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "", "name", "", "ip", "port", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getIp", "getPort", "()I", ShareConstants.MEDIA_URI, "getUri", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Gateway {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String ip;
        private final String name;
        private final int port;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway$Companion;", "", "<init>", "()V", "resolve", "Lkotlin/Result;", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "scope", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, "", "ip", "resolve-yxL6bBk", "(Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /* JADX INFO: renamed from: resolve-yxL6bBk, reason: not valid java name */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object m2169resolveyxL6bBk(CoroutineScope coroutineScope, Context context, String str, String str2, Continuation<? super Result<Gateway>> continuation) {
                Tradfri$Gateway$Companion$resolve$1 tradfri$Gateway$Companion$resolve$1;
                if (continuation instanceof Tradfri$Gateway$Companion$resolve$1) {
                    tradfri$Gateway$Companion$resolve$1 = (Tradfri$Gateway$Companion$resolve$1) continuation;
                    int i = tradfri$Gateway$Companion$resolve$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        tradfri$Gateway$Companion$resolve$1.label = i - Integer.MIN_VALUE;
                    } else {
                        tradfri$Gateway$Companion$resolve$1 = new Tradfri$Gateway$Companion$resolve$1(this, continuation);
                    }
                }
                Object objWithContext = tradfri$Gateway$Companion$resolve$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = tradfri$Gateway$Companion$resolve$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objWithContext);
                    CoroutineContext coroutineContextPlus = coroutineScope.getCoroutineContext().plus(Dispatchers.getIO());
                    Tradfri$Gateway$Companion$resolve$2 tradfri$Gateway$Companion$resolve$2 = new Tradfri$Gateway$Companion$resolve$2(coroutineScope, context, str, str2, null);
                    tradfri$Gateway$Companion$resolve$1.label = 1;
                    objWithContext = BuildersKt.withContext(coroutineContextPlus, tradfri$Gateway$Companion$resolve$2, tradfri$Gateway$Companion$resolve$1);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objWithContext);
                }
                return ((Result) objWithContext).getValue();
            }

            private Companion() {
            }
        }

        public Gateway(String str, String str2, int i) {
            str.getClass();
            str2.getClass();
            this.name = str;
            this.ip = str2;
            this.port = i;
        }

        public static /* synthetic */ Gateway copy$default(Gateway gateway, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = gateway.name;
            }
            if ((i2 & 2) != 0) {
                str2 = gateway.ip;
            }
            if ((i2 & 4) != 0) {
                i = gateway.port;
            }
            return gateway.copy(str, str2, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIp() {
            return this.ip;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        public final Gateway copy(String name, String ip, int port) {
            name.getClass();
            ip.getClass();
            return new Gateway(name, ip, port);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Gateway)) {
                return false;
            }
            Gateway gateway = (Gateway) other;
            return Intrinsics.areEqual(this.name, gateway.name) && Intrinsics.areEqual(this.ip, gateway.ip) && this.port == gateway.port;
        }

        public final String getIp() {
            return this.ip;
        }

        public final String getName() {
            return this.name;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getUri() {
            return "coaps://" + this.ip + ':' + this.port;
        }

        public int hashCode() {
            return Integer.hashCode(this.port) + FileInsert$$ExternalSyntheticOutline0.m(this.name.hashCode() * 31, 31, this.ip);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Gateway(name=");
            sb.append(this.name);
            sb.append(", ip=");
            sb.append(this.ip);
            sb.append(", port=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.port, ')');
        }

        public /* synthetic */ Gateway(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i2 & 4) != 0 ? TradfriKt.COAPS_PORT : i);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0000J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access;", "", IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, "", "securityCode", "credential", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access$Credential;", "lastConnected", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access$Credential;J)V", "getServiceName", "()Ljava/lang/String;", "getSecurityCode", "getCredential", "()Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access$Credential;", "getLastConnected", "()J", "successfullyUsed", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Credential", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Access {
        private final Credential credential;
        private final long lastConnected;
        private final String securityCode;
        private final String serviceName;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access$Credential;", "", "identity", "", "token", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getIdentity", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Credential {
            private final String identity;
            private final String token;

            public Credential(String str, String str2) {
                str.getClass();
                str2.getClass();
                this.identity = str;
                this.token = str2;
            }

            public static /* synthetic */ Credential copy$default(Credential credential, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = credential.identity;
                }
                if ((i & 2) != 0) {
                    str2 = credential.token;
                }
                return credential.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getIdentity() {
                return this.identity;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            public final Credential copy(String identity, String token) {
                identity.getClass();
                token.getClass();
                return new Credential(identity, token);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Credential)) {
                    return false;
                }
                Credential credential = (Credential) other;
                return Intrinsics.areEqual(this.identity, credential.identity) && Intrinsics.areEqual(this.token, credential.token);
            }

            public final String getIdentity() {
                return this.identity;
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                return this.token.hashCode() + (this.identity.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Credential(identity=");
                sb.append(this.identity);
                sb.append(", token=");
                return FileInsert$$ExternalSyntheticOutline0.m(sb, this.token, ')');
            }
        }

        public Access(String str, String str2, Credential credential, long j) {
            str.getClass();
            str2.getClass();
            credential.getClass();
            this.serviceName = str;
            this.securityCode = str2;
            this.credential = credential;
            this.lastConnected = j;
        }

        public static /* synthetic */ Access copy$default(Access access, String str, String str2, Credential credential, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = access.serviceName;
            }
            if ((i & 2) != 0) {
                str2 = access.securityCode;
            }
            if ((i & 4) != 0) {
                credential = access.credential;
            }
            if ((i & 8) != 0) {
                j = access.lastConnected;
            }
            Credential credential2 = credential;
            return access.copy(str, str2, credential2, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getServiceName() {
            return this.serviceName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSecurityCode() {
            return this.securityCode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Credential getCredential() {
            return this.credential;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getLastConnected() {
            return this.lastConnected;
        }

        public final Access copy(String serviceName, String securityCode, Credential credential, long lastConnected) {
            serviceName.getClass();
            securityCode.getClass();
            credential.getClass();
            return new Access(serviceName, securityCode, credential, lastConnected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Access)) {
                return false;
            }
            Access access = (Access) other;
            return Intrinsics.areEqual(this.serviceName, access.serviceName) && Intrinsics.areEqual(this.securityCode, access.securityCode) && Intrinsics.areEqual(this.credential, access.credential) && this.lastConnected == access.lastConnected;
        }

        public final Credential getCredential() {
            return this.credential;
        }

        public final long getLastConnected() {
            return this.lastConnected;
        }

        public final String getSecurityCode() {
            return this.securityCode;
        }

        public final String getServiceName() {
            return this.serviceName;
        }

        public int hashCode() {
            return Long.hashCode(this.lastConnected) + ((this.credential.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.serviceName.hashCode() * 31, 31, this.securityCode)) * 31);
        }

        public final Access successfullyUsed() {
            return copy$default(this, null, null, null, System.currentTimeMillis(), 7, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Access(serviceName=");
            sb.append(this.serviceName);
            sb.append(", securityCode=");
            sb.append(this.securityCode);
            sb.append(", credential=");
            sb.append(this.credential);
            sb.append(", lastConnected=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.lastConnected, ')');
        }

        public /* synthetic */ Access(String str, String str2, Credential credential, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, credential, (i & 8) != 0 ? -1L : j);
        }
    }
}
