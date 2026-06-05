package com.urbandroid.smartlight.hue.yahue;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.smartlight.hue.yahue.YaHueDiscovery;
import io.github.zeroone3010.yahueapi.HueBridge;
import io.github.zeroone3010.yahueapi.HueBridgeConnectionBuilder;
import io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0016J\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000f¨\u0006!"}, d2 = {"Lcom/urbandroid/smartlight/hue/yahue/YaHueDiscovery;", "Lcom/urbandroid/smartlight/common/discovery/Discovery;", "Lcom/urbandroid/smartlight/common/model/Gateway$YaHue;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "tag", "", "kotlin.jvm.PlatformType", "getTag", "()Ljava/lang/String;", "Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "appName", "getAppName", "discover", "", "listener", "Lcom/urbandroid/smartlight/common/discovery/Discovery$Listener;", "authenticate", "gateway", "Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;", "close", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class YaHueDiscovery implements Discovery<Gateway.YaHue>, FeatureLogger, CoroutineScope {
    private final String appName;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$authenticate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$authenticate$1", f = "YaHueDiscovery.kt", l = {75}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Gateway.YaHue $gateway;
        final /* synthetic */ Discovery.AuthListener<Gateway.YaHue> $listener;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$authenticate$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$authenticate$1$1", f = "YaHueDiscovery.kt", l = {81}, m = "invokeSuspend")
        public static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Gateway.YaHue $gateway;
            final /* synthetic */ Discovery.AuthListener<Gateway.YaHue> $listener;
            int label;
            final /* synthetic */ YaHueDiscovery this$0;

            /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$authenticate$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$authenticate$1$1$1", f = "YaHueDiscovery.kt", l = {}, m = "invokeSuspend")
            public static final class C00681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Gateway.YaHue $gateway;
                final /* synthetic */ String $key;
                final /* synthetic */ Discovery.AuthListener<Gateway.YaHue> $listener;
                int label;
                final /* synthetic */ YaHueDiscovery this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00681(YaHueDiscovery yaHueDiscovery, String str, Discovery.AuthListener<Gateway.YaHue> authListener, Gateway.YaHue yaHue, Continuation<? super C00681> continuation) {
                    super(2, continuation);
                    this.this$0 = yaHueDiscovery;
                    this.$key = str;
                    this.$listener = authListener;
                    this.$gateway = yaHue;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00681(this.this$0, this.$key, this.$listener, this.$gateway, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    YaHueDiscovery yaHueDiscovery = this.this$0;
                    String str = "Auth key " + this.$key;
                    Logger.logInfo(Logger.defaultTag, yaHueDiscovery.getTag() + ": " + ((Object) str), null);
                    String str2 = this.$key;
                    Discovery.AuthListener<Gateway.YaHue> authListener = this.$listener;
                    if (str2 != null) {
                        authListener.success(this.$gateway.toAuthenticated(str2));
                    } else {
                        authListener.failed(this.$gateway);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00671(YaHueDiscovery yaHueDiscovery, Gateway.YaHue yaHue, Discovery.AuthListener<Gateway.YaHue> authListener, Continuation<? super C00671> continuation) {
                super(2, continuation);
                this.this$0 = yaHueDiscovery;
                this.$gateway = yaHue;
                this.$listener = authListener;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00671(this.this$0, this.$gateway, this.$listener, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws ExecutionException, InterruptedException {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    YaHueDiscovery yaHueDiscovery = this.this$0;
                    String str = "Auth auth " + this.$gateway.getIp();
                    Logger.logInfo(Logger.defaultTag, yaHueDiscovery.getTag() + ": " + ((Object) str), null);
                    String str2 = new HueBridgeConnectionBuilder(this.$gateway.getIp()).initializeApiConnection(this.this$0.getAppName()).get();
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    C00681 c00681 = new C00681(this.this$0, str2, this.$listener, this.$gateway, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, c00681, this) == coroutine_suspended) {
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
        public AnonymousClass1(Gateway.YaHue yaHue, Discovery.AuthListener<Gateway.YaHue> authListener, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$gateway = yaHue;
            this.$listener = authListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return YaHueDiscovery.this.new AnonymousClass1(this.$gateway, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C00671 c00671 = new C00671(YaHueDiscovery.this, this.$gateway, this.$listener, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, c00671, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$discover$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$discover$1", f = "YaHueDiscovery.kt", l = {44}, m = "invokeSuspend")
    public static final class C22341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Discovery.Listener<Gateway.YaHue> $listener;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$discover$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$discover$1$1", f = "YaHueDiscovery.kt", l = {59}, m = "invokeSuspend")
        public static final class C00691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Discovery.Listener<Gateway.YaHue> $listener;
            int label;
            final /* synthetic */ YaHueDiscovery this$0;

            /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$discover$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$discover$1$1$1", f = "YaHueDiscovery.kt", l = {}, m = "invokeSuspend")
            public static final class C00701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ List<HueBridge> $bridges;
                final /* synthetic */ Discovery.Listener<Gateway.YaHue> $listener;
                int label;
                final /* synthetic */ YaHueDiscovery this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C00701(List<? extends HueBridge> list, YaHueDiscovery yaHueDiscovery, Discovery.Listener<Gateway.YaHue> listener, Continuation<? super C00701> continuation) {
                    super(2, continuation);
                    this.$bridges = list;
                    this.this$0 = yaHueDiscovery;
                    this.$listener = listener;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00701(this.$bridges, this.this$0, this.$listener, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    List<HueBridge> list = this.$bridges;
                    list.getClass();
                    YaHueDiscovery yaHueDiscovery = this.this$0;
                    Discovery.Listener<Gateway.YaHue> listener = this.$listener;
                    for (HueBridge hueBridge : list) {
                        String str = Logger.defaultTag;
                        Logger.logInfo(str, yaHueDiscovery.getTag() + ": " + ((Object) ("Bridge found: " + hueBridge)), null);
                        String name = hueBridge.getName();
                        name.getClass();
                        String ip = hueBridge.getIp();
                        ip.getClass();
                        String mac = hueBridge.getMac();
                        String name2 = hueBridge.getName();
                        name2.getClass();
                        listener.found(new Gateway.YaHue(name, ip, mac, name2));
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00691(YaHueDiscovery yaHueDiscovery, Discovery.Listener<Gateway.YaHue> listener, Continuation<? super C00691> continuation) {
                super(2, continuation);
                this.this$0 = yaHueDiscovery;
                this.$listener = listener;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$2(YaHueDiscovery yaHueDiscovery, HueBridge hueBridge) {
            }

            private static final Unit invokeSuspend$lambda$2$lambda$1(HueBridge hueBridge, YaHueDiscovery yaHueDiscovery) {
                if (hueBridge == null) {
                    return null;
                }
                String str = Logger.defaultTag;
                Logger.logInfo(str, yaHueDiscovery.getTag() + ": " + ((Object) ("Bridge found: " + hueBridge)), null);
                return Unit.INSTANCE;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00691(this.this$0, this.$listener, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws ExecutionException, InterruptedException {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HueBridgeDiscoveryService hueBridgeDiscoveryService = new HueBridgeDiscoveryService();
                    final YaHueDiscovery yaHueDiscovery = this.this$0;
                    Future<List<HueBridge>> futureDiscoverBridges = hueBridgeDiscoveryService.discoverBridges(new Consumer() { // from class: com.urbandroid.smartlight.hue.yahue.YaHueDiscovery$discover$1$1$$ExternalSyntheticLambda0
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj2) {
                            YaHueDiscovery.C22341.C00691.invokeSuspend$lambda$2(yaHueDiscovery, (HueBridge) obj2);
                        }
                    }, HueBridgeDiscoveryService.DiscoveryMethod.MDNS);
                    futureDiscoverBridges.getClass();
                    List<HueBridge> list = futureDiscoverBridges.get();
                    YaHueDiscovery yaHueDiscovery2 = this.this$0;
                    String str = "Bridges found: " + list.size();
                    Logger.logInfo(Logger.defaultTag, yaHueDiscovery2.getTag() + ": " + ((Object) str), null);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    C00701 c00701 = new C00701(list, this.this$0, this.$listener, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, c00701, this) == coroutine_suspended) {
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
        public C22341(Discovery.Listener<Gateway.YaHue> listener, Continuation<? super C22341> continuation) {
            super(2, continuation);
            this.$listener = listener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return YaHueDiscovery.this.new C22341(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C00691 c00691 = new C00691(YaHueDiscovery.this, this.$listener, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, c00691, this) == coroutine_suspended) {
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public YaHueDiscovery(Context context) {
        String packageName;
        context.getClass();
        this.context = context;
        this.tag = HueBridgeDiscoveryService.TAG;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new YaHueDiscovery$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
        String packageName2 = context.getPackageName();
        if (packageName2 == null) {
            packageName = context.getPackageName();
        } else {
            int iHashCode = packageName2.hashCode();
            if (iHashCode != -920550783) {
                if (iHashCode != -920546920) {
                    if (iHashCode == 123854368 && packageName2.equals("com.urbandroid.sleep")) {
                        packageName = "SleepAsAndroid";
                    }
                } else if (packageName2.equals("com.urbandroid.lux")) {
                    packageName = "Twilight";
                }
            } else if (packageName2.equals("com.urbandroid.hue")) {
                packageName = "Huemanic";
            }
        }
        this.appName = packageName;
    }

    public void authenticate(Gateway.YaHue gateway, Discovery.AuthListener<Gateway.YaHue> listener) {
        gateway.getClass();
        listener.getClass();
        listener.authRequired(gateway);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(gateway, listener, null), 3, null);
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void close() {
        Job.cancel$default(this.job, null, 1, null);
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void discover(Discovery.Listener<Gateway.YaHue> listener) {
        listener.getClass();
        Logger.logInfo(Logger.defaultTag, getTag() + ": Discovery start", null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C22341(listener, null), 3, null);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public /* bridge */ /* synthetic */ void authenticate(Gateway gateway, Discovery.AuthListener authListener) {
        authenticate((Gateway.YaHue) gateway, (Discovery.AuthListener<Gateway.YaHue>) authListener);
    }
}
