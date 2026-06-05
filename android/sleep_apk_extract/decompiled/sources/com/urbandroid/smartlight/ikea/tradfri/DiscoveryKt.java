package com.urbandroid.smartlight.ikea.tradfri;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"TAG", "", "TAG_DISCOVERY", "nsdManager", "Landroid/net/nsd/NsdManager;", "Landroid/content/Context;", "getNsdManager", "(Landroid/content/Context;)Landroid/net/nsd/NsdManager;", "resolveGatewayOrNull", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "smartlight_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DiscoveryKt {
    public static final String TAG = "ikea-tradfri";
    public static final String TAG_DISCOVERY = "ikea-tradfri:discovery";

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.DiscoveryKt$resolveGatewayOrNull$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.DiscoveryKt", f = "discovery.kt", l = {133}, m = "resolveGatewayOrNull")
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
            return DiscoveryKt.resolveGatewayOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.DiscoveryKt$resolveGatewayOrNull$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.DiscoveryKt$resolveGatewayOrNull$2", f = "discovery.kt", l = {135}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends Integer>>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ NsdServiceInfo $serviceInfo;
        final /* synthetic */ String $serviceName;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.DiscoveryKt$resolveGatewayOrNull$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.DiscoveryKt$resolveGatewayOrNull$2$1", f = "discovery.kt", l = {137}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends Integer>>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ NsdServiceInfo $serviceInfo;
            final /* synthetic */ String $serviceName;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Context context, NsdServiceInfo nsdServiceInfo, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$context = context;
                this.$serviceInfo = nsdServiceInfo;
                this.$serviceName = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$serviceInfo, this.$serviceName, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<String, Integer>> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Context context = this.$context;
                    NsdServiceInfo nsdServiceInfo = this.$serviceInfo;
                    final String str = this.$serviceName;
                    final boolean z = false;
                    final String str2 = DiscoveryKt.TAG;
                    final FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.smartlight.ikea.tradfri.DiscoveryKt$resolveGatewayOrNull$2$1$invokeSuspend$$inlined$featureLog$default$1
                        @Override // com.urbandroid.common.FeatureLogger
                        public String getTag() {
                            String str3 = str2;
                            String strStringPlus = "";
                            if (z) {
                                String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                                if (strM == null) {
                                    strStringPlus = null;
                                } else if (!StringsKt.isBlank(strM)) {
                                    strStringPlus = Intrinsics.stringPlus(":", strM);
                                }
                            }
                            return Intrinsics.stringPlus(str3, strStringPlus);
                        }
                    };
                    this.L$0 = context;
                    this.L$1 = nsdServiceInfo;
                    this.L$2 = str;
                    this.L$3 = featureLogger;
                    this.L$4 = this;
                    this.label = 1;
                    final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
                    DiscoveryKt.getNsdManager(context).resolveService(nsdServiceInfo, new NsdManager.ResolveListener() { // from class: com.urbandroid.smartlight.ikea.tradfri.DiscoveryKt$resolveGatewayOrNull$2$1$1$1$1
                        @Override // android.net.nsd.NsdManager.ResolveListener
                        public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
                            serviceInfo.getClass();
                            FeatureLogger featureLogger2 = featureLogger;
                            String str3 = "gateway " + str + " onResolveFailed: " + errorCode;
                            Logger.logWarning(Logger.defaultTag, featureLogger2.getTag() + ": " + ((Object) str3), null);
                            safeContinuation.resumeWith(Result.m2357constructorimpl(null));
                        }

                        @Override // android.net.nsd.NsdManager.ResolveListener
                        public void onServiceResolved(NsdServiceInfo serviceInfo) {
                            serviceInfo.getClass();
                            FeatureLogger featureLogger2 = featureLogger;
                            String str3 = "gateway " + str + " resolved: " + serviceInfo.getHost().getHostAddress();
                            Logger.logWarning(Logger.defaultTag, featureLogger2.getTag() + ": " + ((Object) str3), null);
                            Continuation<Pair<String, Integer>> continuation = safeContinuation;
                            Result.Companion companion = Result.INSTANCE;
                            continuation.resumeWith(Result.m2357constructorimpl(TuplesKt.to(serviceInfo.getHost().getHostAddress(), Integer.valueOf(serviceInfo.getPort()))));
                        }
                    });
                    obj = safeContinuation.getOrThrow();
                    if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(this);
                    }
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
                return (Pair) obj;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends String, ? extends Integer>> continuation) {
                return invoke2(coroutineScope, (Continuation<? super Pair<String, Integer>>) continuation);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Context context, NsdServiceInfo nsdServiceInfo, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$serviceName = str;
            this.$context = context;
            this.$serviceInfo = nsdServiceInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$serviceName, this.$context, this.$serviceInfo, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<String, Integer>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$serviceInfo, this.$serviceName, null);
                    this.label = 1;
                    obj = TimeoutKt.withTimeout(2000L, anonymousClass1, this);
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
                return (Pair) obj;
            } catch (TimeoutCancellationException e) {
                Logger.logWarning("gateway " + this.$serviceName + " timeout", null);
                Logger.logSevere(null, e);
                return null;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends String, ? extends Integer>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<String, Integer>>) continuation);
        }
    }

    public static final NsdManager getNsdManager(Context context) {
        context.getClass();
        NsdManager nsdManager = (NsdManager) ContextCompat.getSystemService(context, NsdManager.class);
        if (nsdManager != null) {
            return nsdManager;
        }
        throw new NotImplementedError("An operation is not implemented: NsdManager not found");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveGatewayOrNull(Context context, String str, Continuation<? super Tradfri.Gateway> continuation) {
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceName(str);
            nsdServiceInfo.setServiceType(TradfriKt.NSD_SERVICE_TYPE);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, context, nsdServiceInfo, null);
            anonymousClass1.L$0 = str;
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, anonymousClass2, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        Pair pair = (Pair) objWithContext;
        if (pair != null) {
            return new Tradfri.Gateway(str, (String) pair.getFirst(), ((Number) pair.getSecond()).intValue());
        }
        return null;
    }
}
