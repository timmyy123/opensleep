package com.urbandroid.smartlight.ikea.tradfri;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.mapper.MappersKt;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/TradfriDiscovery;", "Lcom/urbandroid/smartlight/common/discovery/Discovery;", "Lcom/urbandroid/smartlight/common/model/Gateway$Tradfri;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "tag", "", "getTag", "()Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "discover", "", "listener", "Lcom/urbandroid/smartlight/common/discovery/Discovery$Listener;", "authenticate", "gateway", "Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;", "close", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TradfriDiscovery implements Discovery<Gateway.Tradfri>, CoroutineScope, FeatureLogger {
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriDiscovery$authenticate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriDiscovery$authenticate$1", f = "TradfriDiscovery.kt", l = {58}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Gateway.Tradfri $gateway;
        final /* synthetic */ Discovery.AuthListener<Gateway.Tradfri> $listener;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ TradfriDiscovery this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Gateway.Tradfri tradfri, Discovery.AuthListener<Gateway.Tradfri> authListener, TradfriDiscovery tradfriDiscovery, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$gateway = tradfri;
            this.$listener = authListener;
            this.this$0 = tradfriDiscovery;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$gateway, this.$listener, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Gateway.Tradfri tradfri;
            Discovery.AuthListener<Gateway.Tradfri> authListener;
            TradfriDiscovery tradfriDiscovery;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                String secretCode = this.$gateway.getSecretCode();
                if (secretCode != null) {
                    tradfri = this.$gateway;
                    Discovery.AuthListener<Gateway.Tradfri> authListener2 = this.$listener;
                    TradfriDiscovery tradfriDiscovery2 = this.this$0;
                    Tradfri.Gateway nativeGateway = MappersKt.toNativeGateway(tradfri);
                    Tradfri tradfri2 = Tradfri.INSTANCE;
                    String strGenerateNextIdentity = tradfri2.generateNextIdentity();
                    this.L$0 = coroutineScope;
                    this.L$1 = tradfri;
                    this.L$2 = authListener2;
                    this.L$3 = tradfriDiscovery2;
                    this.L$4 = strGenerateNextIdentity;
                    this.label = 1;
                    obj = tradfri2.authenticate(nativeGateway, strGenerateNextIdentity, secretCode, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    authListener = authListener2;
                    tradfriDiscovery = tradfriDiscovery2;
                    str = strGenerateNextIdentity;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = (String) this.L$4;
            tradfriDiscovery = (TradfriDiscovery) this.L$3;
            authListener = (Discovery.AuthListener) this.L$2;
            tradfri = (Gateway.Tradfri) this.L$1;
            ResultKt.throwOnFailure(obj);
            Tradfri.Access access = (Tradfri.Access) obj;
            if (access != null) {
                authListener.success(tradfri.toAuthenticated(access.getCredential().getIdentity(), access.getCredential().getToken()));
                return Unit.INSTANCE;
            }
            String str2 = "Fail to authenticate gateway " + tradfri.getIp() + " with " + str;
            Logger.logSevere(Logger.defaultTag, tradfriDiscovery.getTag() + ": " + ((Object) str2), null);
            authListener.failed(tradfri);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriDiscovery$discover$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriDiscovery$discover$1", f = "TradfriDiscovery.kt", l = {31}, m = "invokeSuspend")
    public static final class C22451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Discovery.Listener<Gateway.Tradfri> $listener;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22451(Discovery.Listener<Gateway.Tradfri> listener, Continuation<? super C22451> continuation) {
            super(2, continuation);
            this.$listener = listener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C22451 c22451 = TradfriDiscovery.this.new C22451(this.$listener, continuation);
            c22451.L$0 = obj;
            return c22451;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Tradfri tradfri = Tradfri.INSTANCE;
                Context context = TradfriDiscovery.this.getContext();
                final Discovery.Listener<Gateway.Tradfri> listener = this.$listener;
                Tradfri.DiscoveryCallback discoveryCallback = new Tradfri.DiscoveryCallback() { // from class: com.urbandroid.smartlight.ikea.tradfri.TradfriDiscovery.discover.1.1
                    @Override // com.urbandroid.smartlight.ikea.tradfri.Tradfri.DiscoveryCallback
                    public void failed(String msg) {
                        msg.getClass();
                        listener.failed(msg);
                    }

                    @Override // com.urbandroid.smartlight.ikea.tradfri.Tradfri.DiscoveryCallback
                    public void finished() {
                        listener.onStop();
                    }

                    @Override // com.urbandroid.smartlight.ikea.tradfri.Tradfri.DiscoveryCallback
                    public Object found(Tradfri.Gateway gateway, Continuation<? super Unit> continuation) {
                        listener.found(MappersKt.toCommonGateway(gateway));
                        return Unit.INSTANCE;
                    }

                    @Override // com.urbandroid.smartlight.ikea.tradfri.Tradfri.DiscoveryCallback
                    public void started() {
                        listener.onStart();
                    }
                };
                this.label = 1;
                if (Tradfri.discover$default(tradfri, coroutineScope, context, discoveryCallback, null, null, this, 8, null) == coroutine_suspended) {
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

    public TradfriDiscovery(Context context) {
        context.getClass();
        this.context = context;
        this.tag = DiscoveryKt.TAG;
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default(null, 1, null);
        this.job = completableJobJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobJob$default).plus(new TradfriDiscovery$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    public void authenticate(Gateway.Tradfri gateway, Discovery.AuthListener<Gateway.Tradfri> listener) {
        gateway.getClass();
        listener.getClass();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(gateway, listener, this, null), 3, null);
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void close() {
        Discovery.DefaultImpls.close(this);
        Job.cancel$default(this.job, null, 1, null);
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void discover(Discovery.Listener<Gateway.Tradfri> listener) {
        listener.getClass();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C22451(listener, null), 3, null);
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
        authenticate((Gateway.Tradfri) gateway, (Discovery.AuthListener<Gateway.Tradfri>) authListener);
    }
}
