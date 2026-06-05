package com.urbandroid.smartlight.hue.yahue;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.philips.lighting.model.PHLightState;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.controller.Controller;
import com.urbandroid.smartlight.common.mapper.MappersKt;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Blinder;
import com.urbandroid.smartlight.common.model.BlinderState;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import io.github.zeroone3010.yahueapi.Color;
import io.github.zeroone3010.yahueapi.v2.Hue;
import io.github.zeroone3010.yahueapi.v2.UpdateState;
import io.github.zeroone3010.yahueapi.v2.domain.update.TimedEffectType;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0096@¢\u0006\u0002\u0010$J$\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010(\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010)J\u001e\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010+J\u0010\u0010.\u001a\u0004\u0018\u00010-H\u0086@¢\u0006\u0002\u0010$J\u0018\u0010/\u001a\u0004\u0018\u00010\u00142\u0006\u0010*\u001a\u00020#H\u0096@¢\u0006\u0002\u00100J,\u00101\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010(\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020&H\u0096@¢\u0006\u0002\u0010$J\u0018\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u00109J$\u0010:\u001a\u00020&2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002080\"2\u0006\u0010(\u001a\u000206H\u0096@¢\u0006\u0002\u0010<R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R-\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/urbandroid/smartlight/hue/yahue/YaHueController;", "Lcom/urbandroid/smartlight/common/controller/Controller;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "gateway", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$YaHue;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$YaHue;)V", "getContext", "()Landroid/content/Context;", "getGateway", "()Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$YaHue;", "tag", "", "getTag", "()Ljava/lang/String;", "stateMap", "Ljava/util/HashMap;", "Lcom/urbandroid/smartlight/common/model/State;", "Lkotlin/collections/HashMap;", "getStateMap", "()Ljava/util/HashMap;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "convertHueToHexInt", "", "hueValue", "getLights", "", "Lcom/urbandroid/smartlight/common/model/Light;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setState", "", "lights", ServerProtocol.DIALOG_PARAM_STATE, "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "light", "(Lcom/urbandroid/smartlight/common/model/Light;Lcom/urbandroid/smartlight/common/model/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ServerProtocol.DIALOG_PARAM_SDK_VERSION, "Lio/github/zeroone3010/yahueapi/v2/Hue;", "getSdk", "getState", "(Lcom/urbandroid/smartlight/common/model/Light;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "blink", "repeat", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "getBlinderState", "Lcom/urbandroid/smartlight/common/model/BlinderState;", "blinder", "Lcom/urbandroid/smartlight/common/model/Blinder;", "(Lcom/urbandroid/smartlight/common/model/Blinder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBlinderState", "blinders", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/BlinderState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class YaHueController implements Controller, FeatureLogger, CoroutineScope {
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final AuthenticatedGateway.YaHue gateway;
    private final CompletableJob job;
    private Hue sdk;
    private final HashMap<String, State> stateMap;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueController$blink$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueController", f = "YaHueController.kt", l = {188, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 193, 196}, m = "blink")
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YaHueController.this.blink((List<Light>) null, (State) null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueController$getLights$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/smartlight/common/model/Light;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueController$getLights$2", f = "YaHueController.kt", l = {104}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Light>>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return YaHueController.this.new AnonymousClass2(continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Light>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    YaHueController yaHueController = YaHueController.this;
                    this.label = 1;
                    obj = yaHueController.getSdk(this);
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
                obj.getClass();
                Collection<io.github.zeroone3010.yahueapi.v2.Light> collectionValues = ((Hue) obj).getLights().values();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
                for (io.github.zeroone3010.yahueapi.v2.Light light : collectionValues) {
                    String string = light.getId().toString();
                    string.getClass();
                    String name = light.getName();
                    name.getClass();
                    arrayList.add(new Light(string, name, null, 4, null));
                }
                return arrayList;
            } catch (Exception unused) {
                return CollectionsKt.emptyList();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Light>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Light>>) continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueController$setState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueController", f = "YaHueController.kt", l = {116}, m = "setState")
    public static final class C22331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C22331(Continuation<? super C22331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YaHueController.this.setState((List<Light>) null, (State) null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.hue.yahue.YaHueController$setState$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.hue.yahue.YaHueController$setState$4", f = "YaHueController.kt", l = {162}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Light $light;
        final /* synthetic */ State $state;
        Object L$0;
        int label;
        final /* synthetic */ YaHueController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(State state, YaHueController yaHueController, Light light, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = yaHueController;
            this.$light = light;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$state, this.this$0, this.$light, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UpdateState updateState;
            io.github.zeroone3010.yahueapi.v2.Light light;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    UpdateState updateState2 = new UpdateState();
                    if (this.$state.getSwitch() == State.Switch.ON_OFF) {
                        updateState2.alert();
                        YaHueController yaHueController = this.this$0;
                        String str = "Set state OFF alert " + this.$light.getId();
                        Logger.logInfo(Logger.defaultTag, yaHueController.getTag() + ": " + ((Object) str), null);
                    } else if (this.$state.getSwitch() == State.Switch.OFF) {
                        YaHueController yaHueController2 = this.this$0;
                        String str2 = "Set state OFF light " + this.$light.getId();
                        Logger.logInfo(Logger.defaultTag, yaHueController2.getTag() + ": " + ((Object) str2), null);
                        updateState2.off();
                    } else {
                        if (this.$state.getColor() != null) {
                            State state = this.$state;
                            YaHueController yaHueController3 = this.this$0;
                            PHLightState hueState = MappersKt.toHueState(state);
                            if (hueState.getHue() != null) {
                                Integer hue = MappersKt.toHueState(state).getHue();
                                hue.getClass();
                                updateState2.color(Color.of(yaHueController3.convertHueToHexInt(hue.intValue())));
                            }
                            if (hueState.getBrightness() != null) {
                                Integer brightness = MappersKt.toHueState(state).getBrightness();
                                brightness.getClass();
                                updateState2.brightness(brightness.intValue());
                            }
                            if (hueState.getX() != null && hueState.getY() != null) {
                                Float x = hueState.getX();
                                x.getClass();
                                float fFloatValue = x.floatValue();
                                Float y = hueState.getY();
                                y.getClass();
                                updateState2.xy(fFloatValue, y.floatValue());
                            }
                        }
                        updateState2.on();
                        if (MappersKt.toHueState(this.$state).getTransitionTime().intValue() > 0) {
                            updateState2.timedEffect(TimedEffectType.NO_EFFECT, Duration.ofMillis(((long) MappersKt.toHueState(this.$state).getTransitionTime().intValue()) * 100));
                        }
                        YaHueController yaHueController4 = this.this$0;
                        String str3 = "Set state ON color " + MappersKt.toHueState(this.$state) + " light " + this.$light.getId();
                        Logger.logInfo(Logger.defaultTag, yaHueController4.getTag() + ": " + ((Object) str3), null);
                    }
                    YaHueController yaHueController5 = this.this$0;
                    this.L$0 = updateState2;
                    this.label = 1;
                    Object sdk = yaHueController5.getSdk(this);
                    if (sdk == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    updateState = updateState2;
                    obj = sdk;
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    updateState = (UpdateState) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Hue hue2 = (Hue) obj;
                if (hue2 == null || (light = hue2.getLights().get(UUID.fromString(this.$light.getId()))) == null) {
                    return null;
                }
                light.setState(updateState);
                return Unit.INSTANCE;
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e);
                return Unit.INSTANCE;
            }
        }
    }

    public YaHueController(Context context, AuthenticatedGateway.YaHue yaHue) {
        context.getClass();
        yaHue.getClass();
        this.context = context;
        this.gateway = yaHue;
        this.tag = Common_smartlightKt.TAG;
        this.stateMap = new HashMap<>();
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new YaHueController$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x011c, code lost:
    
        r1.L$0 = r14;
        r1.L$1 = r13;
        r1.L$2 = r0;
        r1.L$3 = null;
        r1.I$0 = r6;
        r1.I$1 = r4;
        r1.I$2 = r2;
        r1.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0135, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(((long) r6) * r16, r1) != r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0138, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0179, code lost:
    
        r5 = 3;
        r1.L$0 = r15;
        r1.L$1 = r14;
        r1.L$2 = r13;
        r0 = null;
        r1.L$3 = null;
        r1.I$0 = r6;
        r1.I$1 = r4;
        r1.I$2 = r2;
        r9 = 4;
        r1.label = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0193, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(((long) r6) * r16, r1) != r3) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0196, code lost:
    
        r7 = r6;
        r6 = r4;
        r4 = r7;
        r7 = r1;
        r1 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011c A[EDGE_INSN: B:49:0x011c->B:29:0x011c BREAK  A[LOOP:0: B:23:0x00e4->B:28:0x0117], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0179 A[EDGE_INSN: B:52:0x0179->B:40:0x0179 BREAK  A[LOOP:1: B:34:0x0144->B:39:0x0177], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0196 -> B:44:0x019b). Please report as a decompilation issue!!! */
    @Override // com.urbandroid.smartlight.common.controller.Controller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object blink(List<Light> list, State state, int i, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        YaHueController yaHueController;
        long j;
        int i2;
        int iCount;
        AnonymousClass1 anonymousClass12;
        int i3;
        List<Light> list2;
        State state2;
        YaHueController yaHueController2;
        List<Light> list3;
        State state3;
        Iterator it;
        int i4;
        int i5;
        int i6;
        YaHueController yaHueController3;
        List<Light> list4;
        Iterator it2;
        State state4;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i7 = anonymousClass1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i7 - Integer.MIN_VALUE;
                yaHueController = this;
            } else {
                yaHueController = this;
                anonymousClass1 = yaHueController.new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = anonymousClass1.label;
        if (i8 != 0) {
            if (i8 == 1) {
                j = 1000;
                i6 = anonymousClass1.I$2;
                i5 = anonymousClass1.I$1;
                i4 = anonymousClass1.I$0;
                it2 = (Iterator) anonymousClass1.L$3;
                State state5 = (State) anonymousClass1.L$2;
                List<Light> list5 = (List) anonymousClass1.L$1;
                YaHueController yaHueController4 = (YaHueController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                state4 = state5;
                list4 = list5;
                yaHueController3 = yaHueController4;
                while (true) {
                    if (it2.hasNext()) {
                    }
                }
                return coroutine_suspended;
            }
            if (i8 == 2) {
                j = 1000;
                i6 = anonymousClass1.I$2;
                i5 = anonymousClass1.I$1;
                i4 = anonymousClass1.I$0;
                State state6 = (State) anonymousClass1.L$2;
                list4 = (List) anonymousClass1.L$1;
                yaHueController3 = (YaHueController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                Iterator it3 = list4.iterator();
                yaHueController2 = yaHueController3;
                list3 = list4;
                state3 = state6;
                it = it3;
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                return coroutine_suspended;
            }
            if (i8 == 3) {
                j = 1000;
                i6 = anonymousClass1.I$2;
                i5 = anonymousClass1.I$1;
                i4 = anonymousClass1.I$0;
                it = (Iterator) anonymousClass1.L$3;
                state3 = (State) anonymousClass1.L$2;
                list3 = (List) anonymousClass1.L$1;
                yaHueController2 = (YaHueController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                while (true) {
                    if (it.hasNext()) {
                        break;
                    }
                    Light light = (Light) it.next();
                    State state7 = new State(state3.getColor(), state3.getTransitionMs(), State.Switch.OFF, false);
                    anonymousClass1.L$0 = yaHueController2;
                    anonymousClass1.L$1 = list3;
                    anonymousClass1.L$2 = state3;
                    anonymousClass1.L$3 = it;
                    anonymousClass1.I$0 = i4;
                    anonymousClass1.I$1 = i5;
                    anonymousClass1.I$2 = i6;
                    anonymousClass1.label = 3;
                    if (yaHueController2.setState(light, state7, anonymousClass1) == coroutine_suspended) {
                        break;
                    }
                }
                return coroutine_suspended;
            }
            if (i8 != 4) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i6 = anonymousClass1.I$2;
            int i9 = anonymousClass1.I$1;
            int i10 = anonymousClass1.I$0;
            State state8 = (State) anonymousClass1.L$2;
            List<Light> list6 = (List) anonymousClass1.L$1;
            j = 1000;
            YaHueController yaHueController5 = (YaHueController) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            anonymousClass12 = anonymousClass1;
            Object obj2 = null;
            char c = 3;
            state2 = state8;
            list3 = list6;
            yaHueController2 = yaHueController5;
            char c2 = 4;
            iCount = i9;
            i2 = i10;
            i3 = i6 + 1;
            yaHueController = yaHueController2;
            list2 = list3;
            if (i3 < iCount) {
                return Unit.INSTANCE;
            }
            Iterator it4 = list2.iterator();
            int i11 = i3;
            list4 = list2;
            state4 = state2;
            anonymousClass1 = anonymousClass12;
            it2 = it4;
            yaHueController3 = yaHueController;
            i6 = i11;
            int i12 = iCount;
            i4 = i2;
            i5 = i12;
            while (true) {
                if (it2.hasNext()) {
                    break;
                }
                Light light2 = (Light) it2.next();
                State state9 = new State(state4.getColor(), state4.getTransitionMs(), State.Switch.ON, false);
                anonymousClass1.L$0 = yaHueController3;
                anonymousClass1.L$1 = list4;
                anonymousClass1.L$2 = state4;
                anonymousClass1.L$3 = it2;
                anonymousClass1.I$0 = i4;
                anonymousClass1.I$1 = i5;
                anonymousClass1.I$2 = i6;
                anonymousClass1.label = 1;
                if (yaHueController3.setState(light2, state9, anonymousClass1) == coroutine_suspended) {
                    break;
                }
            }
            return coroutine_suspended;
        }
        j = 1000;
        ResultKt.throwOnFailure(obj);
        i2 = i;
        iCount = CollectionsKt___CollectionsKt.count(new IntRange(0, i2));
        anonymousClass12 = anonymousClass1;
        i3 = 0;
        list2 = list;
        state2 = state;
        if (i3 < iCount) {
        }
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object close(Continuation<? super Unit> continuation) {
        Job.cancel$default(this.job, null, 1, null);
        return Unit.INSTANCE;
    }

    public final int convertHueToHexInt(int hueValue) {
        double d;
        double d2 = ((((double) (hueValue % NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) / 65535.0d) * 360.0d) / 60.0d;
        double d3 = 1.0d;
        double dAbs = (1.0d - Math.abs((d2 % 2.0d) - 1.0d)) * 1.0d;
        if (d2 >= 0.0d && d2 < 1.0d) {
            d = 0.0d;
        } else if (d2 < 1.0d || d2 >= 2.0d) {
            if (d2 >= 2.0d && d2 < 3.0d) {
                d = dAbs;
                dAbs = 1.0d;
            } else if (d2 < 3.0d || d2 >= 4.0d) {
                if (d2 >= 4.0d && d2 < 5.0d) {
                    d = 1.0d;
                    d3 = dAbs;
                } else if (d2 < 5.0d || d2 > 6.0d) {
                    d = 0.0d;
                    dAbs = 0.0d;
                    d3 = 0.0d;
                } else {
                    d = dAbs;
                }
                dAbs = 0.0d;
            } else {
                d = 1.0d;
            }
            d3 = 0.0d;
        } else {
            d3 = dAbs;
            dAbs = 1.0d;
            d = 0.0d;
        }
        return RangesKt___RangesKt.coerceIn(MathKt.roundToInt((d + 0.0d) * 255.0d), 0, PHIpAddressSearchManager.END_IP_SCAN) | (RangesKt___RangesKt.coerceIn(MathKt.roundToInt((d3 + 0.0d) * 255.0d), 0, PHIpAddressSearchManager.END_IP_SCAN) << 16) | (RangesKt___RangesKt.coerceIn(MathKt.roundToInt((dAbs + 0.0d) * 255.0d), 0, PHIpAddressSearchManager.END_IP_SCAN) << 8);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getBlinderState(Blinder blinder, Continuation<? super BlinderState> continuation) {
        String str = Logger.defaultTag;
        Logger.logWarning(str, getTag() + ": " + ((Object) ("getBlinderState not implemented - " + blinder)), null);
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getLights(Continuation<? super List<Light>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    public final Object getSdk(Continuation<? super Hue> continuation) {
        try {
            if (this.sdk == null) {
                this.sdk = new Hue(getGateway().getIp(), getGateway().getApiKey());
            }
            return this.sdk;
        } catch (Exception e) {
            Logger.logSevere(Logger.defaultTag, this.getTag() + ": SmartLight: YaHue error", e);
            return null;
        }
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getState(Light light, Continuation<? super State> continuation) {
        return this.stateMap.get(light.getId());
    }

    public final HashMap<String, State> getStateMap() {
        return this.stateMap;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setBlinderState(List<Blinder> list, BlinderState blinderState, Continuation<? super Unit> continuation) {
        String str = Logger.defaultTag;
        Logger.logWarning(str, getTag() + ": " + ((Object) ("setBlinderState not implemented - " + list)), null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbandroid.smartlight.common.controller.Controller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setState(List<Light> list, State state, Continuation<? super Unit> continuation) {
        C22331 c22331;
        YaHueController yaHueController;
        Iterator it;
        if (continuation instanceof C22331) {
            c22331 = (C22331) continuation;
            int i = c22331.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22331.label = i - Integer.MIN_VALUE;
            } else {
                c22331 = new C22331(continuation);
            }
        }
        Object obj = c22331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22331.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Iterator it2 = list.iterator();
            yaHueController = this;
            it = it2;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            it = (Iterator) c22331.L$2;
            State state2 = (State) c22331.L$1;
            YaHueController yaHueController2 = (YaHueController) c22331.L$0;
            ResultKt.throwOnFailure(obj);
            state = state2;
            yaHueController = yaHueController2;
        }
        while (it.hasNext()) {
            Light light = (Light) it.next();
            c22331.L$0 = yaHueController;
            c22331.L$1 = state;
            c22331.L$2 = it;
            c22331.label = 1;
            if (yaHueController.setState(light, state, c22331) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public AuthenticatedGateway.YaHue getGateway() {
        return this.gateway;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setBlinderState(Blinder blinder, BlinderState blinderState, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.setBlinderState(this, blinder, blinderState, continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setState(Light light, State state, Continuation<? super Unit> continuation) {
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ((Object) ("Set state " + light + ' ' + state)), null);
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass4(state, this, light, null), continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object blink(Light light, State state, int i, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.blink(this, light, state, i, continuation);
    }
}
