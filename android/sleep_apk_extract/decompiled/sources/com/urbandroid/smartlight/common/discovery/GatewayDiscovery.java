package com.urbandroid.smartlight.common.discovery;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.smartlight.hue.HueDiscovery;
import com.urbandroid.smartlight.hue.yahue.YaHueDiscovery;
import com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery;
import com.urbandroid.smartlight.ikea.tradfri.TradfriDiscovery;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020%H\u0016J\u0016\u0010&\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020'H\u0016J\b\u0010(\u001a\u00020\"H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/urbandroid/smartlight/common/discovery/GatewayDiscovery;", "Lcom/urbandroid/smartlight/common/discovery/Discovery;", "Lcom/urbandroid/smartlight/common/model/Gateway;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "tag", "", "getTag", "()Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "hueDiscovery", "Lcom/urbandroid/smartlight/hue/HueDiscovery;", "yaHueDiscovery", "Lcom/urbandroid/smartlight/hue/yahue/YaHueDiscovery;", "tradfriDiscovery", "Lcom/urbandroid/smartlight/ikea/tradfri/TradfriDiscovery;", "dirigeraDiscovery", "Lcom/urbandroid/smartlight/ikea/dirigera/DirigeraDiscovery;", "providers", "", "getProviders", "()Ljava/util/List;", "authenticate", "", "gateway", "listener", "Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;", "discover", "Lcom/urbandroid/smartlight/common/discovery/Discovery$Listener;", "close", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GatewayDiscovery implements Discovery<Gateway>, CoroutineScope, FeatureLogger {
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final DirigeraDiscovery dirigeraDiscovery;
    private final HueDiscovery hueDiscovery;
    private final CompletableJob job;
    private final List<Discovery<Gateway>> providers;
    private final String tag;
    private final TradfriDiscovery tradfriDiscovery;
    private final YaHueDiscovery yaHueDiscovery;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.common.discovery.GatewayDiscovery$discover$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.common.discovery.GatewayDiscovery$discover$2", f = "GatewayDiscovery.kt", l = {73}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Discovery.Listener<Gateway> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Discovery.Listener<Gateway> listener, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$listener = listener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$listener, continuation);
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
                this.label = 1;
                if (DelayKt.delay(120000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$listener.onStop();
            return Unit.INSTANCE;
        }
    }

    public GatewayDiscovery(Context context) {
        context.getClass();
        this.context = context;
        this.tag = Common_smartlightKt.TAG;
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default(null, 1, null);
        this.job = completableJobJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobJob$default);
        HueDiscovery hueDiscovery = new HueDiscovery(context);
        this.hueDiscovery = hueDiscovery;
        YaHueDiscovery yaHueDiscovery = new YaHueDiscovery(context);
        this.yaHueDiscovery = yaHueDiscovery;
        TradfriDiscovery tradfriDiscovery = new TradfriDiscovery(context);
        this.tradfriDiscovery = tradfriDiscovery;
        this.dirigeraDiscovery = new DirigeraDiscovery(context);
        this.providers = CollectionsKt.listOf((Object[]) new Discovery[]{hueDiscovery, yaHueDiscovery, tradfriDiscovery});
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void authenticate(Gateway gateway, Discovery.AuthListener<Gateway> listener) {
        gateway.getClass();
        listener.getClass();
        if (gateway instanceof Gateway.Tradfri) {
            this.tradfriDiscovery.authenticate((Gateway.Tradfri) gateway, (Discovery.AuthListener<Gateway.Tradfri>) listener);
            return;
        }
        if (gateway instanceof Gateway.YaHue) {
            this.yaHueDiscovery.authenticate((Gateway.YaHue) gateway, (Discovery.AuthListener<Gateway.YaHue>) listener);
            return;
        }
        if (gateway instanceof Gateway.Hue) {
            this.hueDiscovery.authenticate((Gateway.Hue) gateway, (Discovery.AuthListener<Gateway.Hue>) listener);
        } else if (gateway instanceof Gateway.Dirigera) {
            this.dirigeraDiscovery.authenticate((Gateway.Dirigera) gateway, (Discovery.AuthListener<Gateway.Dirigera>) listener);
        } else {
            Home$$ExternalSyntheticBUOutline0.m();
        }
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void close() {
        Iterator<T> it = this.providers.iterator();
        while (it.hasNext()) {
            ((Discovery) it.next()).close();
        }
        Job.cancel$default(this.job, null, 1, null);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.urbandroid.smartlight.common.discovery.GatewayDiscovery$discover$listenerWrapper$1] */
    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void discover(final Discovery.Listener<Gateway> listener) {
        listener.getClass();
        listener.onStart();
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ?? r6 = new Discovery.Listener<Gateway>() { // from class: com.urbandroid.smartlight.common.discovery.GatewayDiscovery$discover$listenerWrapper$1
            @Override // com.urbandroid.smartlight.common.discovery.Discovery.Listener
            public void failed(String message) {
                message.getClass();
                listener.failed(message);
            }

            @Override // com.urbandroid.smartlight.common.discovery.Discovery.Listener
            public void found(Gateway gateway) {
                gateway.getClass();
                GatewayDiscovery gatewayDiscovery = this;
                String str = "Found " + gateway.getClass().getSimpleName() + ' ' + gateway.getId();
                Logger.logInfo(Logger.defaultTag, gatewayDiscovery.getTag() + ": " + ((Object) str), null);
                listener.found(gateway);
            }

            @Override // com.urbandroid.smartlight.common.discovery.Discovery.Listener
            public void onStart() {
            }

            @Override // com.urbandroid.smartlight.common.discovery.Discovery.Listener
            public void onStop() {
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                int i = ref$IntRef2.element + 1;
                ref$IntRef2.element = i;
                if (i >= this.getProviders().size()) {
                    listener.onStop();
                }
            }
        };
        Iterator<T> it = this.providers.iterator();
        while (it.hasNext()) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new GatewayDiscovery$discover$1$1(this, (Discovery) it.next(), r6, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass2(listener, null), 3, null);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final List<Discovery<Gateway>> getProviders() {
        return this.providers;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }
}
