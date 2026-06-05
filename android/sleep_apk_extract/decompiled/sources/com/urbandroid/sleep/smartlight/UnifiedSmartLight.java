package com.urbandroid.sleep.smartlight;

import android.content.Context;
import androidx.appfunctions.AppFunctionException;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.wifi.WifiContext;
import com.urbandroid.common.wifi.Wifi_enablerKt;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.smartlight.common.Configuration;
import com.urbandroid.smartlight.common.controller.Controller;
import com.urbandroid.smartlight.common.controller.ControllerFactory;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Color;
import com.urbandroid.smartlight.common.model.ColorsKt;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u0010\u001a\u00020\r2.\u0010\u000f\u001a*\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\u0016J\u000f\u0010\"\u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010#\u001a\u00020\rH\u0016¢\u0006\u0004\b#\u0010\u0016J\u0017\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b#\u0010\u001cJ\u000f\u0010%\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010\u0016J\u000f\u0010&\u001a\u00020\rH\u0016¢\u0006\u0004\b&\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010+\u001a\u00020*8\u0016X\u0096D¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00106\u001a\u0002058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001d\u0010>\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/urbandroid/sleep/smartlight/UnifiedSmartLight;", "Lcom/urbandroid/sleep/smartlight/SmartLight;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Lkotlin/Function3;", "Lcom/urbandroid/smartlight/common/controller/Controller;", "", "Lcom/urbandroid/smartlight/common/model/Light;", "Lkotlin/coroutines/Continuation;", "", "", "block", "execute", "(Lkotlin/jvm/functions/Function3;)V", "", "isConnected", "()Z", "off", "()V", "force", "(Z)V", "", "timeoutSeconds", "nightLight", "(I)V", "progress", "max", "sunrise", "(II)V", "sunriseStart", "sunriseFull", ViewHierarchyConstants.HINT_KEY, "loop", "shortHint", "close", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "maxIntensity", "F", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "controller$delegate", "Lkotlin/Lazy;", "getController", "()Lcom/urbandroid/smartlight/common/controller/Controller;", "controller", "Lcom/urbandroid/smartlight/common/Configuration;", "configuration", "Lcom/urbandroid/smartlight/common/Configuration;", "Lkotlinx/coroutines/Job;", "lastJob", "Lkotlinx/coroutines/Job;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnifiedSmartLight implements SmartLight, FeatureLogger, CoroutineScope {
    private final Configuration configuration;
    private final Context context;

    /* JADX INFO: renamed from: controller$delegate, reason: from kotlin metadata */
    private final Lazy controller;
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private Job lastJob;
    private final float maxIntensity;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.UnifiedSmartLight$close$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.UnifiedSmartLight$close$1", f = "UnifiedSmartLight.kt", l = {136}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UnifiedSmartLight.this.new AnonymousClass1(continuation);
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
                Controller controller = UnifiedSmartLight.this.getController();
                if (controller != null) {
                    this.label = 1;
                    if (controller.close(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            Job.cancel$default(UnifiedSmartLight.this.job, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.UnifiedSmartLight$execute$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.UnifiedSmartLight$execute$2", f = "UnifiedSmartLight.kt", l = {144, 52}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<Controller, List<Light>, Continuation<? super Unit>, Object> $block;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super Controller, ? super List<Light>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = UnifiedSmartLight.this.new AnonymousClass2(this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objEnableWifi;
            CoroutineScope coroutineScope;
            int i;
            int i2;
            String str;
            Class<?> cls;
            int i3;
            int i4;
            UnifiedSmartLight unifiedSmartLight;
            Function3<Controller, List<Light>, Continuation<? super Unit>, Object> function3;
            CoroutineScope coroutineScope2;
            WifiContext wifiContext;
            Object objWithContext;
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                Class<?> cls2 = UnifiedSmartLight.this.getClass();
                UnifiedSmartLight unifiedSmartLight2 = UnifiedSmartLight.this;
                Function3<Controller, List<Light>, Continuation<? super Unit>, Object> function32 = this.$block;
                String simpleName = cls2.getSimpleName();
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                this.L$2 = SpillingKt.nullOutSpilledVariable(cls2);
                this.L$3 = unifiedSmartLight2;
                this.L$4 = function32;
                this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                this.L$6 = SpillingKt.nullOutSpilledVariable(simpleName);
                this.I$0 = 15;
                this.I$1 = 0;
                this.I$2 = 15;
                this.I$3 = 0;
                this.label = 1;
                objEnableWifi = Wifi_enablerKt.enableWifi(simpleName, 15, this);
                if (objEnableWifi != coroutine_suspended) {
                    coroutineScope = coroutineScope3;
                    i = 15;
                    i2 = 0;
                    str = simpleName;
                    cls = cls2;
                    i3 = 15;
                    i4 = 0;
                    unifiedSmartLight = unifiedSmartLight2;
                    function3 = function32;
                    coroutineScope2 = coroutineScope;
                }
                return coroutine_suspended;
            }
            if (i5 != 1) {
                if (i5 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                wifiContext = (WifiContext) this.L$5;
                try {
                    ResultKt.throwOnFailure(obj);
                    objWithContext = obj;
                    wifiContext.disable();
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    wifiContext.disable();
                    throw th;
                }
            }
            i4 = this.I$3;
            int i6 = this.I$2;
            int i7 = this.I$1;
            int i8 = this.I$0;
            String str2 = (String) this.L$6;
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$5;
            Function3<Controller, List<Light>, Continuation<? super Unit>, Object> function33 = (Function3) this.L$4;
            UnifiedSmartLight unifiedSmartLight3 = (UnifiedSmartLight) this.L$3;
            Class<?> cls3 = (Class) this.L$2;
            CoroutineScope coroutineScope5 = (CoroutineScope) this.L$1;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope5;
            cls = cls3;
            unifiedSmartLight = unifiedSmartLight3;
            function3 = function33;
            coroutineScope2 = coroutineScope4;
            str = str2;
            i3 = i8;
            i2 = i7;
            i = i6;
            objEnableWifi = obj;
            WifiContext wifiContext2 = (WifiContext) objEnableWifi;
            if (wifiContext2 != null) {
                try {
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    UnifiedSmartLight$execute$2$1$1 unifiedSmartLight$execute$2$1$1 = new UnifiedSmartLight$execute$2$1$1(unifiedSmartLight, function3, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(cls);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$5 = wifiContext2;
                    this.L$6 = null;
                    this.I$0 = i3;
                    this.I$1 = i2;
                    this.I$2 = i;
                    this.I$3 = i4;
                    this.I$4 = 0;
                    this.label = 2;
                    objWithContext = BuildersKt.withContext(io2, unifiedSmartLight$execute$2$1$1, this);
                    if (objWithContext != coroutine_suspended) {
                        wifiContext = wifiContext2;
                        wifiContext.disable();
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    wifiContext = wifiContext2;
                    wifiContext.disable();
                    throw th;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.UnifiedSmartLight$hint$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "controller", "Lcom/urbandroid/smartlight/common/controller/Controller;", "lights", "", "Lcom/urbandroid/smartlight/common/model/Light;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.UnifiedSmartLight$hint$1", f = "UnifiedSmartLight.kt", l = {126}, m = "invokeSuspend", v = 2)
    public static final class C21771 extends SuspendLambda implements Function3<Controller, List<? extends Light>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $loop;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21771(int i, Continuation<? super C21771> continuation) {
            super(3, continuation);
            this.$loop = i;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Controller controller, List<Light> list, Continuation<? super Unit> continuation) {
            C21771 c21771 = UnifiedSmartLight.this.new C21771(this.$loop, continuation);
            c21771.L$0 = controller;
            c21771.L$1 = list;
            return c21771.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Controller controller = (Controller) this.L$0;
            List<Light> list = (List) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                State state = new State(new Color.Hsb(200, 46920, 200, RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (UnifiedSmartLight.this.maxIntensity * 254.0f), 20), 254)), 0, State.Switch.ON, false, 8, null);
                int i2 = this.$loop;
                this.L$0 = SpillingKt.nullOutSpilledVariable(controller);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                this.label = 1;
                if (controller.blink(list, state, i2, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Controller controller, List<? extends Light> list, Continuation<? super Unit> continuation) {
            return invoke2(controller, (List<Light>) list, continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.UnifiedSmartLight$nightLight$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "controller", "Lcom/urbandroid/smartlight/common/controller/Controller;", "lights", "", "Lcom/urbandroid/smartlight/common/model/Light;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.UnifiedSmartLight$nightLight$1", f = "UnifiedSmartLight.kt", l = {96, 98, 99, 100, 101}, m = "invokeSuspend", v = 2)
    public static final class C21781 extends SuspendLambda implements Function3<Controller, List<? extends Light>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $timeoutSeconds;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21781(int i, Continuation<? super C21781> continuation) {
            super(3, continuation);
            this.$timeoutSeconds = i;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Controller controller, List<Light> list, Continuation<? super Unit> continuation) {
            C21781 c21781 = new C21781(this.$timeoutSeconds, continuation);
            c21781.L$0 = controller;
            c21781.L$1 = list;
            return c21781.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00c8, code lost:
        
            if (r1.setState(r2, r6, r17) != r3) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            State state;
            long secondsInMillis;
            Controller controller = (Controller) this.L$0;
            List<Light> list = (List) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                State state2 = new State(new Color.Hsb(500, 1, 254, 20), 400, State.Switch.ON, false, 8, null);
                this.L$0 = controller;
                this.L$1 = list;
                this.label = 1;
                if (controller.setState(list, state2, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    state = new State(null, 1000, State.Switch.OFF, false, 9, null);
                    this.L$0 = controller;
                    this.L$1 = list;
                    this.label = 3;
                    if (controller.setState(list, state, this) != coroutine_suspended) {
                        secondsInMillis = Utils.getSecondsInMillis(3);
                        this.L$0 = controller;
                        this.L$1 = list;
                        this.label = 4;
                        if (DelayKt.delay(secondsInMillis, this) != coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    secondsInMillis = Utils.getSecondsInMillis(3);
                    this.L$0 = controller;
                    this.L$1 = list;
                    this.label = 4;
                    if (DelayKt.delay(secondsInMillis, this) != coroutine_suspended) {
                        State state3 = new State(null, 10, State.Switch.OFF, false, 9, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(controller);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                        this.label = 5;
                    }
                    return coroutine_suspended;
                }
                if (i != 4) {
                    if (i == 5) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                State state32 = new State(null, 10, State.Switch.OFF, false, 9, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(controller);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                this.label = 5;
            }
            int i2 = this.$timeoutSeconds;
            if (i2 > 0) {
                this.L$0 = controller;
                this.L$1 = list;
                this.label = 2;
                if (DelayKt.delay(((long) i2) * 1000, this) != coroutine_suspended) {
                    state = new State(null, 1000, State.Switch.OFF, false, 9, null);
                    this.L$0 = controller;
                    this.L$1 = list;
                    this.label = 3;
                    if (controller.setState(list, state, this) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Controller controller, List<? extends Light> list, Continuation<? super Unit> continuation) {
            return invoke2(controller, (List<Light>) list, continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.UnifiedSmartLight$off$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "controller", "Lcom/urbandroid/smartlight/common/controller/Controller;", "lights", "", "Lcom/urbandroid/smartlight/common/model/Light;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.UnifiedSmartLight$off$1", f = "UnifiedSmartLight.kt", l = {80, 81, 84, 86}, m = "invokeSuspend", v = 2)
    public static final class C21791 extends SuspendLambda implements Function3<Controller, List<? extends Light>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public C21791(Continuation<? super C21791> continuation) {
            super(3, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Controller controller, List<Light> list, Continuation<? super Unit> continuation) {
            C21791 c21791 = UnifiedSmartLight.this.new C21791(continuation);
            c21791.L$0 = controller;
            c21791.L$1 = list;
            return c21791.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0134, code lost:
        
            if (r1.setState(r2, r11, r20) != r3) goto L29;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00ca -> B:15:0x0084). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Iterator<Light> it;
            Light next;
            Controller controller = (Controller) this.L$0;
            List<Light> list = (List) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UnifiedSmartLight unifiedSmartLight = UnifiedSmartLight.this;
                String str = "OFF - " + UnifiedSmartLight.off$ids(list);
                Logger.logInfo(Logger.defaultTag, unifiedSmartLight.getTag() + ": " + str, null);
                it = list.iterator();
            } else {
                if (i == 1) {
                    Light light = (Light) this.L$3;
                    Iterator<Light> it2 = (Iterator) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    next = light;
                    it = it2;
                    this.L$0 = controller;
                    this.L$1 = list;
                    this.L$2 = it;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                    this.label = 2;
                    if (DelayKt.delay(100L, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 2) {
                    it = (Iterator) this.L$2;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 3) {
                        if (i == 4) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    UnifiedSmartLight unifiedSmartLight2 = UnifiedSmartLight.this;
                    String str2 = "OFF after 28 sec - " + UnifiedSmartLight.off$ids(list);
                    Logger.logInfo(Logger.defaultTag, unifiedSmartLight2.getTag() + ": " + str2, null);
                    State state = new State(null, 10, State.Switch.OFF, false, 9, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(controller);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                    this.label = 4;
                }
            }
            if (!it.hasNext()) {
                next = it.next();
                State state2 = new State(null, 7000, State.Switch.OFF, false, 9, null);
                this.L$0 = controller;
                this.L$1 = list;
                this.L$2 = it;
                this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                this.label = 1;
                if (controller.setState(next, state2, this) != coroutine_suspended) {
                    this.L$0 = controller;
                    this.L$1 = list;
                    this.L$2 = it;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                    this.label = 2;
                    if (DelayKt.delay(100L, this) != coroutine_suspended) {
                        if (!it.hasNext()) {
                            long secondsInMillis = Utils.getSecondsInMillis(28);
                            this.L$0 = controller;
                            this.L$1 = list;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 3;
                            if (DelayKt.delay(secondsInMillis, this) != coroutine_suspended) {
                                UnifiedSmartLight unifiedSmartLight22 = UnifiedSmartLight.this;
                                String str22 = "OFF after 28 sec - " + UnifiedSmartLight.off$ids(list);
                                Logger.logInfo(Logger.defaultTag, unifiedSmartLight22.getTag() + ": " + str22, null);
                                State state3 = new State(null, 10, State.Switch.OFF, false, 9, null);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(controller);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                                this.label = 4;
                            }
                        }
                    }
                }
            }
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Controller controller, List<? extends Light> list, Continuation<? super Unit> continuation) {
            return invoke2(controller, (List<Light>) list, continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.UnifiedSmartLight$sunrise$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "controller", "Lcom/urbandroid/smartlight/common/controller/Controller;", "lights", "", "Lcom/urbandroid/smartlight/common/model/Light;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.UnifiedSmartLight$sunrise$1", f = "UnifiedSmartLight.kt", l = {108}, m = "invokeSuspend", v = 2)
    public static final class C21801 extends SuspendLambda implements Function3<Controller, List<? extends Light>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $max;
        final /* synthetic */ int $progress;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ UnifiedSmartLight this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21801(int i, int i2, UnifiedSmartLight unifiedSmartLight, Continuation<? super C21801> continuation) {
            super(3, continuation);
            this.$progress = i;
            this.$max = i2;
            this.this$0 = unifiedSmartLight;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Controller controller, List<Light> list, Continuation<? super Unit> continuation) {
            C21801 c21801 = new C21801(this.$progress, this.$max, this.this$0, continuation);
            c21801.L$0 = controller;
            c21801.L$1 = list;
            return c21801.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Color.Hsb hsb;
            Controller controller = (Controller) this.L$0;
            List<Light> list = (List) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = this.$progress;
                int i3 = this.$max;
                int i4 = 450 - ((i2 * 227) / i3);
                int iRoundToInt = MathKt.roundToInt((i2 * 10794.0f) / i3);
                int i5 = this.$progress;
                Color.Hsb hsb2 = new Color.Hsb(i4, iRoundToInt, 254 - ((i5 * 170) / this.$max), RangesKt.coerceAtLeast(MathKt.roundToInt(((this.this$0.maxIntensity * 254.0f) * i5) / this.$max), 1));
                int i6 = this.$progress;
                State state = new State(hsb2, (i6 == 100 && i6 == this.$max) ? 12000 : AppFunctionException.ERROR_APP_UNKNOWN_ERROR, State.Switch.ON, false, 8, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(controller);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                this.L$2 = hsb2;
                this.label = 1;
                if (controller.setState(list, state, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                hsb = hsb2;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                hsb = (Color.Hsb) this.L$2;
                ResultKt.throwOnFailure(obj);
            }
            UnifiedSmartLight unifiedSmartLight = this.this$0;
            String str = "color " + hsb + " " + ColorsKt.toRgb(hsb) + " " + ColorsKt.toTradfri(ColorsKt.toRgb(hsb)) + " ";
            Logger.logInfo(Logger.defaultTag, unifiedSmartLight.getTag() + ": " + str, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Controller controller, List<? extends Light> list, Continuation<? super Unit> continuation) {
            return invoke2(controller, (List<Light>) list, continuation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnifiedSmartLight(Context context) {
        context.getClass();
        this.context = context;
        this.tag = "SmartLight:Unified";
        this.maxIntensity = new Settings(context).getSmartlightMaxIntensity();
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new UnifiedSmartLight$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
        this.controller = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 15));
        this.configuration = new Configuration(context, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Controller controller_delegate$lambda$0(UnifiedSmartLight unifiedSmartLight) {
        AuthenticatedGateway authenticatedGatewayLoad = AuthenticatedGateway.INSTANCE.load(unifiedSmartLight.context);
        if (authenticatedGatewayLoad != null) {
            return new ControllerFactory(unifiedSmartLight.context).create(authenticatedGatewayLoad);
        }
        return null;
    }

    private final void execute(Function3<? super Controller, ? super List<Light>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Job job = this.lastJob;
        if (job != null) {
            Job.cancel$default(job, null, 1, null);
        }
        this.lastJob = BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass2(block, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Controller getController() {
        return (Controller) this.controller.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> off$ids(List<Light> list) {
        List<Light> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Light) it.next()).getId());
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void close() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
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

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint(int loop) {
        execute(new C21771(loop, null));
    }

    public boolean isConnected() {
        return AuthenticatedGateway.INSTANCE.load(this.context) != null;
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void nightLight(int timeoutSeconds) {
        Logger.logInfo(Logger.defaultTag, getTag() + ": PEELIGHT", null);
        execute(new C21781(timeoutSeconds, null));
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off(boolean force) {
        if (force || !AlarmKlaxon.isRunning()) {
            execute(new C21791(null));
            return;
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": OFF omitted", null);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void shortHint() {
        hint(1);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunrise(int progress, int max) {
        execute(new C21801(progress, max, this, null));
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseFull() {
        sunrise(100, 100);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseStart() {
        sunrise(0, 100);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint() {
        hint(3);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off() {
        off(false);
    }
}
