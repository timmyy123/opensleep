package com.urbandroid.smartlight.ikea.tradfri;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.ServerProtocol;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.controller.Controller;
import com.urbandroid.smartlight.common.mapper.MappersKt;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Blinder;
import com.urbandroid.smartlight.common.model.BlinderState;
import com.urbandroid.smartlight.common.model.Color;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import com.urbandroid.smartlight.ikea.tradfri.Client;
import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import com.urbandroid.smartlight.ikea.tradfri.coapmodel.Device;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ<\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0004\b\u0017\u0010\fJ&\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020!H\u0096@¢\u0006\u0004\b$\u0010%J&\u0010'\u001a\u00020\u001b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0\u00152\u0006\u0010\u001a\u001a\u00020#H\u0096@¢\u0006\u0004\b'\u0010(J.\u0010+\u001a\u00020\u001b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010*\u001a\u00020)H\u0096@¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u001bH\u0096@¢\u0006\u0004\b-\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u00100R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00101\u001a\u0004\b2\u00103R\u001a\u00105\u001a\u0002048\u0016X\u0096D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010=\u001a\u00020<8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010;R\u0014\u0010B\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006K"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/TradfriController;", "Lcom/urbandroid/smartlight/common/controller/Controller;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;", "gateway", "<init>", "(Landroid/content/Context;Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;)V", "", "init", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlin/Function2;", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;", "Lkotlin/coroutines/Continuation;", "", "block", "execute", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/urbandroid/smartlight/common/model/Light;", "getLights", "lights", "Lcom/urbandroid/smartlight/common/model/State;", ServerProtocol.DIALOG_PARAM_STATE, "", "setState", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "light", "getState", "(Lcom/urbandroid/smartlight/common/model/Light;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbandroid/smartlight/common/model/Blinder;", "blinder", "Lcom/urbandroid/smartlight/common/model/BlinderState;", "getBlinderState", "(Lcom/urbandroid/smartlight/common/model/Blinder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "blinders", "setBlinderState", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/BlinderState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "repeat", "blink", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;", "getGateway", "()Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "offStateCheckJob", "offStateCheckScope", "Lkotlinx/coroutines/CoroutineScope;", "", "lastSaved", "J", "closed", "Z", "client", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TradfriController implements Controller, CoroutineScope, FeatureLogger {
    private Client.Authenticated client;
    private boolean closed;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final AuthenticatedGateway.Tradfri gateway;
    private final CompletableJob job;
    private long lastSaved;
    private final CompletableJob offStateCheckJob;
    private final CoroutineScope offStateCheckScope;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$blink$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController$blink$2", f = "TradfriController.kt", l = {178}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Client.Authenticated, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Light> $lights;
        final /* synthetic */ int $repeat;
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TradfriController this$0;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$blink$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController$blink$2$1", f = "TradfriController.kt", l = {180, 181, 189, 191, 193, 195, 198}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Client.Authenticated $$this$execute;
            final /* synthetic */ List<Client.Authenticated.LightId> $ids;
            final /* synthetic */ List<Light> $lights;
            final /* synthetic */ int $repeat;
            final /* synthetic */ State $state;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ TradfriController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List<Light> list, State state, Client.Authenticated authenticated, List<Client.Authenticated.LightId> list2, int i, TradfriController tradfriController, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$lights = list;
                this.$state = state;
                this.$$this$execute = authenticated;
                this.$ids = list2;
                this.$repeat = i;
                this.this$0 = tradfriController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$lights, this.$state, this.$$this$execute, this.$ids, this.$repeat, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x00d7, code lost:
            
                if (r4 == r10) goto L57;
             */
            /* JADX WARN: Removed duplicated region for block: B:16:0x00c3  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00eb  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x012c  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0140  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x018f  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x01cf  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x01dd  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0161 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:68:0x01af A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00d7 -> B:19:0x00db). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x01c5 -> B:51:0x01c7). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Collection arrayList;
                TradfriController tradfriController;
                Iterator it;
                List list;
                Light light;
                Object state;
                int i;
                List<Client.Authenticated.LightId> list2;
                Client.Authenticated authenticated;
                int i2;
                int i3;
                Iterator it2;
                List<Client.Authenticated.LightId> list3;
                List list4;
                Client.Authenticated authenticated2;
                List<Client.Authenticated.LightId> list5;
                List list6;
                Iterator it3;
                List<Client.Authenticated.LightId> list7;
                List list8;
                List list9;
                TradfriController tradfriController2;
                Iterator it4;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        List<Light> list10 = this.$lights;
                        TradfriController tradfriController3 = this.this$0;
                        arrayList = new ArrayList();
                        tradfriController = tradfriController3;
                        it = list10.iterator();
                        if (!it.hasNext()) {
                            light = (Light) it.next();
                            this.L$0 = tradfriController;
                            this.L$1 = arrayList;
                            this.L$2 = it;
                            this.L$3 = light;
                            this.label = 1;
                            state = tradfriController.getState(light, this);
                            break;
                        } else {
                            List list11 = (List) arrayList;
                            State.Switch r4 = this.$state.getSwitch();
                            Color color = this.$state.getColor();
                            int transitionMs = this.$state.getTransitionMs();
                            Client.Authenticated authenticated3 = this.$$this$execute;
                            List<Client.Authenticated.LightId> list12 = this.$ids;
                            Integer numBoxInt = Boxing.boxInt(transitionMs);
                            this.L$0 = list11;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 2;
                            if (Client.Authenticated.m2167setStatebMdYcbs$default(authenticated3, list12, color, null, r4, numBoxInt, false, this, 36, null) != coroutine_suspended) {
                                list = list11;
                                i = this.$repeat;
                                list2 = this.$ids;
                                authenticated = this.$$this$execute;
                                i2 = 0;
                                if (i2 >= i) {
                                    tradfriController2 = this.this$0;
                                    it4 = list.iterator();
                                    while (it4.hasNext()) {
                                        Pair pair = (Pair) it4.next();
                                        Light light2 = (Light) pair.component1();
                                        State state2 = (State) pair.component2();
                                        this.L$0 = tradfriController2;
                                        this.L$1 = it4;
                                        this.L$2 = null;
                                        this.label = 7;
                                        if (tradfriController2.setState(light2, state2, this) == coroutine_suspended) {
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                list4 = list;
                                i3 = i2;
                                list3 = list2;
                                it2 = list2.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        this.L$0 = list4;
                                        this.L$1 = list3;
                                        this.L$2 = authenticated;
                                        this.L$3 = null;
                                        this.I$0 = i;
                                        this.I$1 = i3;
                                        this.label = 4;
                                        if (DelayKt.delay(1000L, this) != coroutine_suspended) {
                                            authenticated2 = authenticated;
                                            list5 = list3;
                                            list6 = list4;
                                        }
                                        break;
                                    } else {
                                        int id = ((Client.Authenticated.LightId) it2.next()).getId();
                                        this.L$0 = list4;
                                        this.L$1 = list3;
                                        this.L$2 = authenticated;
                                        this.L$3 = it2;
                                        this.I$0 = i;
                                        this.I$1 = i3;
                                        this.label = 3;
                                        if (authenticated.turnDeviceOn(id, this) == coroutine_suspended) {
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        light = (Light) this.L$3;
                        it = (Iterator) this.L$2;
                        arrayList = (Collection) this.L$1;
                        tradfriController = (TradfriController) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        state = obj;
                        State state3 = (State) state;
                        Pair pair2 = state3 != null ? TuplesKt.to(light, state3) : null;
                        if (pair2 != null) {
                            arrayList.add(pair2);
                        }
                        if (!it.hasNext()) {
                        }
                        return coroutine_suspended;
                    case 2:
                        list = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        ((Result) obj).getValue();
                        i = this.$repeat;
                        list2 = this.$ids;
                        authenticated = this.$$this$execute;
                        i2 = 0;
                        if (i2 >= i) {
                        }
                        break;
                    case 3:
                        i3 = this.I$1;
                        i = this.I$0;
                        it2 = (Iterator) this.L$3;
                        authenticated = (Client.Authenticated) this.L$2;
                        list3 = (List) this.L$1;
                        list4 = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (true) {
                            if (it2.hasNext()) {
                            }
                        }
                        return coroutine_suspended;
                    case 4:
                        i3 = this.I$1;
                        i = this.I$0;
                        authenticated2 = (Client.Authenticated) this.L$2;
                        list5 = (List) this.L$1;
                        list6 = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Iterator it5 = list5.iterator();
                        List<Client.Authenticated.LightId> list13 = list5;
                        authenticated = authenticated2;
                        it3 = it5;
                        list8 = list6;
                        list7 = list13;
                        while (true) {
                            if (it3.hasNext()) {
                                this.L$0 = list8;
                                this.L$1 = list7;
                                this.L$2 = authenticated;
                                this.L$3 = null;
                                this.I$0 = i;
                                this.I$1 = i3;
                                this.label = 6;
                                if (DelayKt.delay(1000L, this) != coroutine_suspended) {
                                    list2 = list7;
                                    list9 = list8;
                                }
                                break;
                            } else {
                                int id2 = ((Client.Authenticated.LightId) it3.next()).getId();
                                this.L$0 = list8;
                                this.L$1 = list7;
                                this.L$2 = authenticated;
                                this.L$3 = it3;
                                this.I$0 = i;
                                this.I$1 = i3;
                                this.label = 5;
                                if (authenticated.turnDeviceOff(id2, this) == coroutine_suspended) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 5:
                        i3 = this.I$1;
                        i = this.I$0;
                        it3 = (Iterator) this.L$3;
                        authenticated = (Client.Authenticated) this.L$2;
                        list7 = (List) this.L$1;
                        list8 = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (true) {
                            if (it3.hasNext()) {
                            }
                        }
                        return coroutine_suspended;
                    case 6:
                        i3 = this.I$1;
                        i = this.I$0;
                        Client.Authenticated authenticated4 = (Client.Authenticated) this.L$2;
                        List<Client.Authenticated.LightId> list14 = (List) this.L$1;
                        list9 = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        authenticated = authenticated4;
                        list2 = list14;
                        List list15 = list9;
                        i2 = i3 + 1;
                        list = list15;
                        if (i2 >= i) {
                        }
                        break;
                    case 7:
                        it4 = (Iterator) this.L$1;
                        tradfriController2 = (TradfriController) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (it4.hasNext()) {
                        }
                        return Unit.INSTANCE;
                    default:
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<Light> list, int i, State state, TradfriController tradfriController, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$lights = list;
            this.$repeat = i;
            this.$state = state;
            this.this$0 = tradfriController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$lights, this.$repeat, this.$state, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Client.Authenticated authenticated, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(authenticated, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Client.Authenticated authenticated = (Client.Authenticated) this.L$0;
                StringBuilder sb = new StringBuilder("blink ");
                sb.append(this.$lights.size());
                sb.append(" light(s)   ");
                String strM = FileInsert$$ExternalSyntheticOutline0.m(this.$repeat, " times", sb);
                Logger.logInfo(Logger.defaultTag, authenticated.getTag() + ": " + ((Object) strM), null);
                List<Light> list = this.$lights;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(MappersKt.toLightId((Light) it.next()));
                }
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lights, this.$state, authenticated, arrayList, this.$repeat, this.this$0, null);
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

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$execute$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController", f = "TradfriController.kt", l = {87, 90}, m = "execute")
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TradfriController.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$getBlinderState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/smartlight/common/model/BlinderState;", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController$getBlinderState$2", f = "TradfriController.kt", l = {158}, m = "invokeSuspend")
    public static final class C22382 extends SuspendLambda implements Function2<Client.Authenticated, Continuation<? super BlinderState>, Object> {
        final /* synthetic */ Blinder $blinder;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22382(Blinder blinder, Continuation<? super C22382> continuation) {
            super(2, continuation);
            this.$blinder = blinder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C22382 c22382 = new C22382(this.$blinder, continuation);
            c22382.L$0 = obj;
            return c22382;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Client.Authenticated authenticated, Continuation<? super BlinderState> continuation) {
            return ((C22382) create(authenticated, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<Device.BlinderState> blinderStates;
            Device.BlinderState blinderState;
            Float position;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Client.Authenticated authenticated = (Client.Authenticated) this.L$0;
                int i2 = Integer.parseInt(this.$blinder.getId());
                this.label = 1;
                obj = authenticated.getDevice(i2, this);
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
            Device device = (Device) obj;
            if (device == null || (blinderStates = device.getBlinderStates()) == null || (blinderState = (Device.BlinderState) CollectionsKt.firstOrNull((List) blinderStates)) == null || (position = blinderState.getPosition()) == null) {
                return null;
            }
            return new BlinderState(position.floatValue());
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$getLights$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController", f = "TradfriController.kt", l = {93}, m = "getLights")
    public static final class C22391 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C22391(Continuation<? super C22391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TradfriController.this.getLights(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$getLights$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/smartlight/common/model/Light;", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController$getLights$2", f = "TradfriController.kt", l = {94}, m = "invokeSuspend")
    public static final class C22402 extends SuspendLambda implements Function2<Client.Authenticated, Continuation<? super List<? extends Light>>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C22402(Continuation<? super C22402> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C22402 c22402 = new C22402(continuation);
            c22402.L$0 = obj;
            return c22402;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Client.Authenticated authenticated, Continuation<? super List<Light>> continuation) {
            return ((C22402) create(authenticated, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Client.Authenticated authenticated = (Client.Authenticated) this.L$0;
                this.label = 1;
                obj = authenticated.getDevices(this);
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
            List list = (List) obj;
            if (list == null) {
                return null;
            }
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(MappersKt.toLight((Device) it.next()));
            }
            return arrayList;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Client.Authenticated authenticated, Continuation<? super List<? extends Light>> continuation) {
            return invoke2(authenticated, (Continuation<? super List<Light>>) continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$getState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/smartlight/common/model/State;", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController$getState$2", f = "TradfriController.kt", l = {142}, m = "invokeSuspend")
    public static final class C22412 extends SuspendLambda implements Function2<Client.Authenticated, Continuation<? super State>, Object> {
        final /* synthetic */ Light $light;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22412(Light light, Continuation<? super C22412> continuation) {
            super(2, continuation);
            this.$light = light;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C22412 c22412 = new C22412(this.$light, continuation);
            c22412.L$0 = obj;
            return c22412;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Client.Authenticated authenticated, Continuation<? super State> continuation) {
            return ((C22412) create(authenticated, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<Device.State> states;
            Device.State state;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Client.Authenticated authenticated = (Client.Authenticated) this.L$0;
                int id = MappersKt.toLightId(this.$light).getId();
                this.label = 1;
                obj = authenticated.getDevice(id, this);
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
            Device device = (Device) obj;
            if (device == null || (states = device.getStates()) == null || (state = (Device.State) CollectionsKt.firstOrNull((List) states)) == null) {
                return null;
            }
            Color.D65 d65 = (state.getColorY() == null || state.getColorX() == null) ? null : new Color.D65(state.getColorX().intValue(), state.getColorY().intValue(), state.getBrightness());
            Integer transitionInCentiSeconds = state.getTransitionInCentiSeconds();
            int iIntValue = transitionInCentiSeconds != null ? transitionInCentiSeconds.intValue() : 0;
            Integer on = state.getOn();
            return new State(d65, iIntValue, on != null ? State.Switch.INSTANCE.of(Boxing.boxInt(on.intValue())) : null, false, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$init$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController", f = "TradfriController.kt", l = {64}, m = "init")
    public static final class C22421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C22421(Continuation<? super C22421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TradfriController.this.init(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$setBlinderState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController$setBlinderState$2", f = "TradfriController.kt", l = {169}, m = "invokeSuspend")
    public static final class C22432 extends SuspendLambda implements Function2<Client.Authenticated, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Blinder> $blinders;
        final /* synthetic */ BlinderState $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22432(List<Blinder> list, BlinderState blinderState, Continuation<? super C22432> continuation) {
            super(2, continuation);
            this.$blinders = list;
            this.$state = blinderState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C22432 c22432 = new C22432(this.$blinders, this.$state, continuation);
            c22432.L$0 = obj;
            return c22432;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Client.Authenticated authenticated, Continuation<? super Unit> continuation) {
            return ((C22432) create(authenticated, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator<Blinder> it;
            Client.Authenticated authenticated;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Client.Authenticated authenticated2 = (Client.Authenticated) this.L$0;
                StringBuilder sb = new StringBuilder("setBlinderState ");
                List<Blinder> list = this.$blinders;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((Blinder) it2.next()).getId());
                }
                sb.append(arrayList);
                sb.append(" blinders(s) to position ");
                sb.append(this.$state.getPosition());
                String string = sb.toString();
                Logger.logInfo(Logger.defaultTag, authenticated2.getTag() + ": " + ((Object) string), null);
                it = this.$blinders.iterator();
                authenticated = authenticated2;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                it = (Iterator) this.L$1;
                authenticated = (Client.Authenticated) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                int i2 = Integer.parseInt(it.next().getId());
                float position = this.$state.getPosition();
                this.L$0 = authenticated;
                this.L$1 = it;
                this.label = 1;
                if (authenticated.setBlinder(i2, position, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$setState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController$setState$2", f = "TradfriController.kt", l = {113, 116, 117, 119}, m = "invokeSuspend")
    public static final class C22442 extends SuspendLambda implements Function2<Client.Authenticated, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Light> $lights;
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ TradfriController this$0;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.TradfriController$setState$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.TradfriController$setState$2$2", f = "TradfriController.kt", l = {123, 125, 127}, m = "invokeSuspend")
        public static final class C00722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Client.Authenticated $$this$execute;
            final /* synthetic */ Light $light;
            final /* synthetic */ State $state;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ TradfriController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00722(TradfriController tradfriController, Light light, Client.Authenticated authenticated, State state, Continuation<? super C00722> continuation) {
                super(2, continuation);
                this.this$0 = tradfriController;
                this.$light = light;
                this.$$this$execute = authenticated;
                this.$state = state;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00722(this.this$0, this.$light, this.$$this$execute, this.$state, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00a1 A[Catch: Exception -> 0x00a6, TryCatch #2 {Exception -> 0x00a6, blocks: (B:29:0x009d, B:31:0x00a1, B:35:0x00aa, B:37:0x00ae, B:26:0x0088), top: B:52:0x009d }] */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00ae A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #2 {Exception -> 0x00a6, blocks: (B:29:0x009d, B:31:0x00a1, B:35:0x00aa, B:37:0x00ae, B:26:0x0088), top: B:52:0x009d }] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x009d A[EXC_TOP_SPLITTER, PHI: r1 r6 r7 r8 r9 r10 r14
              0x009d: PHI (r1v5 int) = (r1v2 int), (r1v10 int) binds: [B:27:0x009a, B:16:0x003b] A[DONT_GENERATE, DONT_INLINE]
              0x009d: PHI (r6v3 com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated) = 
              (r6v1 com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated)
              (r6v7 com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated)
             binds: [B:27:0x009a, B:16:0x003b] A[DONT_GENERATE, DONT_INLINE]
              0x009d: PHI (r7v3 com.urbandroid.smartlight.common.model.State) = (r7v1 com.urbandroid.smartlight.common.model.State), (r7v7 com.urbandroid.smartlight.common.model.State) binds: [B:27:0x009a, B:16:0x003b] A[DONT_GENERATE, DONT_INLINE]
              0x009d: PHI (r8v3 int) = (r8v1 int), (r8v9 int) binds: [B:27:0x009a, B:16:0x003b] A[DONT_GENERATE, DONT_INLINE]
              0x009d: PHI (r9v4 com.urbandroid.smartlight.common.model.Light) = (r9v1 com.urbandroid.smartlight.common.model.Light), (r9v9 com.urbandroid.smartlight.common.model.Light) binds: [B:27:0x009a, B:16:0x003b] A[DONT_GENERATE, DONT_INLINE]
              0x009d: PHI (r10v5 com.urbandroid.smartlight.ikea.tradfri.TradfriController) = 
              (r10v0 com.urbandroid.smartlight.ikea.tradfri.TradfriController)
              (r10v9 com.urbandroid.smartlight.ikea.tradfri.TradfriController)
             binds: [B:27:0x009a, B:16:0x003b] A[DONT_GENERATE, DONT_INLINE]
              0x009d: PHI (r14v4 java.lang.Object) = (r14v2 java.lang.Object), (r14v0 java.lang.Object) binds: [B:27:0x009a, B:16:0x003b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009a -> B:52:0x009d). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                TradfriController tradfriController;
                Light light;
                Client.Authenticated authenticated;
                State state;
                int i;
                int i2;
                TradfriController tradfriController2;
                Light light2;
                int i3;
                Client.Authenticated authenticated2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i4 = this.label;
                if (i4 != 0) {
                    if (i4 == 1) {
                        i3 = this.I$1;
                        int i5 = this.I$0;
                        state = (State) this.L$3;
                        Client.Authenticated authenticated3 = (Client.Authenticated) this.L$2;
                        light2 = (Light) this.L$1;
                        tradfriController2 = (TradfriController) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = i5;
                        authenticated = authenticated3;
                        this.L$0 = tradfriController2;
                        this.L$1 = light2;
                        this.L$2 = authenticated;
                        this.L$3 = state;
                        this.I$0 = i;
                        this.I$1 = i3;
                        this.label = 2;
                        obj = tradfriController2.getState(light2, this);
                        if (obj == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i4 != 2) {
                        if (i4 != 3) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        authenticated2 = (Client.Authenticated) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        } catch (Exception e) {
                            e = e;
                            String str = Logger.defaultTag;
                            Logger.logWarning(str, authenticated2.getTag() + ": " + ((Object) ("offStateCheck failure " + e)), null);
                            return Unit.INSTANCE;
                        }
                    }
                    i3 = this.I$1;
                    int i6 = this.I$0;
                    state = (State) this.L$3;
                    Client.Authenticated authenticated4 = (Client.Authenticated) this.L$2;
                    light2 = (Light) this.L$1;
                    tradfriController2 = (TradfriController) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i = i6;
                        authenticated = authenticated4;
                    } catch (Exception e2) {
                        e = e2;
                        authenticated2 = authenticated4;
                        String str2 = Logger.defaultTag;
                        Logger.logWarning(str2, authenticated2.getTag() + ": " + ((Object) ("offStateCheck failure " + e)), null);
                        return Unit.INSTANCE;
                    }
                    try {
                        State state2 = (State) obj;
                        if ((state2 == null ? state2.getSwitch() : null) != State.Switch.ON) {
                            List listListOf = CollectionsKt.listOf(light2);
                            this.L$0 = authenticated;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 3;
                            if (C22442.invokeSuspend$applyState(state, authenticated, listListOf, this) != coroutine_suspended) {
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        int i7 = i3 + 1;
                        light = light2;
                        i2 = i7;
                        tradfriController = tradfriController2;
                        if (i2 < i) {
                            return Unit.INSTANCE;
                        }
                        this.L$0 = tradfriController;
                        this.L$1 = light;
                        this.L$2 = authenticated;
                        this.L$3 = state;
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.label = 1;
                        if (DelayKt.delay(2000L, this) != coroutine_suspended) {
                            int i8 = i2;
                            light2 = light;
                            i3 = i8;
                            tradfriController2 = tradfriController;
                            this.L$0 = tradfriController2;
                            this.L$1 = light2;
                            this.L$2 = authenticated;
                            this.L$3 = state;
                            this.I$0 = i;
                            this.I$1 = i3;
                            this.label = 2;
                            obj = tradfriController2.getState(light2, this);
                            if (obj == coroutine_suspended) {
                                State state22 = (State) obj;
                                if ((state22 == null ? state22.getSwitch() : null) != State.Switch.ON) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (Exception e3) {
                        e = e3;
                        authenticated2 = authenticated;
                        String str22 = Logger.defaultTag;
                        Logger.logWarning(str22, authenticated2.getTag() + ": " + ((Object) ("offStateCheck failure " + e)), null);
                        return Unit.INSTANCE;
                    }
                }
                ResultKt.throwOnFailure(obj);
                tradfriController = this.this$0;
                light = this.$light;
                authenticated = this.$$this$execute;
                state = this.$state;
                i = 7;
                i2 = 0;
                if (i2 < i) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22442(State state, TradfriController tradfriController, List<Light> list, Continuation<? super C22442> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = tradfriController;
            this.$lights = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final Object invokeSuspend$applyState(State state, Client.Authenticated authenticated, List<Light> list, Continuation<? super Unit> continuation) {
            TradfriController$setState$2$applyState$1 tradfriController$setState$2$applyState$1;
            Object objM2167setStatebMdYcbs$default;
            Client.Authenticated authenticated2;
            if (continuation instanceof TradfriController$setState$2$applyState$1) {
                tradfriController$setState$2$applyState$1 = (TradfriController$setState$2$applyState$1) continuation;
                int i = tradfriController$setState$2$applyState$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    tradfriController$setState$2$applyState$1.label = i - Integer.MIN_VALUE;
                } else {
                    tradfriController$setState$2$applyState$1 = new TradfriController$setState$2$applyState$1(continuation);
                }
            }
            TradfriController$setState$2$applyState$1 tradfriController$setState$2$applyState$12 = tradfriController$setState$2$applyState$1;
            Object obj = tradfriController$setState$2$applyState$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = tradfriController$setState$2$applyState$12.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                List<Light> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (Light light : list2) {
                    arrayList.add(new Client.Authenticated.LightId(MappersKt.toTradfriDevice(light).getId(), light.getType()));
                }
                State.Switch r5 = state.getSwitch();
                Color color = state.getColor();
                int transitionMs = state.getTransitionMs() / 100;
                boolean emulated = state.getEmulated();
                Integer numBoxInt = Boxing.boxInt(transitionMs);
                tradfriController$setState$2$applyState$12.L$0 = authenticated;
                tradfriController$setState$2$applyState$12.label = 1;
                objM2167setStatebMdYcbs$default = Client.Authenticated.m2167setStatebMdYcbs$default(authenticated, arrayList, color, null, r5, numBoxInt, emulated, tradfriController$setState$2$applyState$12, 4, null);
                if (objM2167setStatebMdYcbs$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                authenticated2 = authenticated;
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                authenticated2 = (Client.Authenticated) tradfriController$setState$2$applyState$12.L$0;
                ResultKt.throwOnFailure(obj);
                objM2167setStatebMdYcbs$default = ((Result) obj).getValue();
            }
            Throwable thM2360exceptionOrNullimpl = Result.m2360exceptionOrNullimpl(objM2167setStatebMdYcbs$default);
            if (thM2360exceptionOrNullimpl != null) {
                Logger.logSevere(Logger.defaultTag, authenticated2.getTag() + ": setState failure", thM2360exceptionOrNullimpl);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C22442 c22442 = new C22442(this.$state, this.this$0, this.$lights, continuation);
            c22442.L$0 = obj;
            return c22442;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Client.Authenticated authenticated, Continuation<? super Unit> continuation) {
            return ((C22442) create(authenticated, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
        
            if (invokeSuspend$applyState(r1, r14, r2, r13) == r0) goto L48;
         */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0135 A[LOOP:0: B:51:0x012f->B:53:0x0135, LOOP_END] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00bc -> B:28:0x00bf). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Client.Authenticated authenticated;
            ArrayList arrayList;
            ArrayList arrayList2;
            TradfriController tradfriController;
            Iterator it;
            List list;
            Client.Authenticated authenticated2;
            Client.Authenticated authenticated3;
            List list2;
            Iterator it2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                authenticated = (Client.Authenticated) this.L$0;
                if (this.$state.getSwitch() == State.Switch.OFF) {
                    List<Light> list3 = this.$lights;
                    TradfriController tradfriController2 = this.this$0;
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    tradfriController = tradfriController2;
                    it = list3.iterator();
                    if (it.hasNext()) {
                    }
                    return coroutine_suspended;
                }
                JobKt__JobKt.cancelChildren$default(this.this$0.offStateCheckJob, null, 1, null);
                State state = this.$state;
                List<Light> list4 = this.$lights;
                this.label = 1;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            list2 = (List) this.L$1;
                            Client.Authenticated authenticated4 = (Client.Authenticated) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            authenticated3 = authenticated4;
                            it2 = list2.iterator();
                            while (it2.hasNext()) {
                                BuildersKt__Builders_commonKt.launch$default(this.this$0.offStateCheckScope, null, null, new C00722(this.this$0, (Light) it2.next(), authenticated3, this.$state, null), 3, null);
                            }
                            return Unit.INSTANCE;
                        }
                        list = (List) this.L$1;
                        authenticated2 = (Client.Authenticated) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        authenticated = authenticated2;
                        if (!list.isEmpty()) {
                            this.L$0 = authenticated;
                            this.L$1 = list;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.label = 4;
                            if (DelayKt.delay(500L, this) != coroutine_suspended) {
                                authenticated3 = authenticated;
                                list2 = list;
                                it2 = list2.iterator();
                                while (it2.hasNext()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    Object next = this.L$5;
                    it = (Iterator) this.L$4;
                    arrayList2 = (ArrayList) this.L$3;
                    arrayList = (ArrayList) this.L$2;
                    tradfriController = (TradfriController) this.L$1;
                    Client.Authenticated authenticated5 = (Client.Authenticated) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    State state2 = (State) obj;
                    if ((state2 == null ? state2.getSwitch() : null) != State.Switch.ON) {
                        arrayList.add(next);
                    } else {
                        arrayList2.add(next);
                    }
                    authenticated = authenticated5;
                    if (it.hasNext()) {
                        next = it.next();
                        this.L$0 = authenticated;
                        this.L$1 = tradfriController;
                        this.L$2 = arrayList;
                        this.L$3 = arrayList2;
                        this.L$4 = it;
                        this.L$5 = next;
                        this.label = 2;
                        Object state3 = tradfriController.getState((Light) next, this);
                        if (state3 != coroutine_suspended) {
                            authenticated5 = authenticated;
                            obj = state3;
                            State state22 = (State) obj;
                            if ((state22 == null ? state22.getSwitch() : null) != State.Switch.ON) {
                            }
                            authenticated = authenticated5;
                            if (it.hasNext()) {
                                Pair pair = new Pair(arrayList, arrayList2);
                                List list5 = (List) pair.component1();
                                list = (List) pair.component2();
                                if (list5.isEmpty()) {
                                    if (!list.isEmpty()) {
                                    }
                                    return Unit.INSTANCE;
                                }
                                State state4 = this.$state;
                                this.L$0 = authenticated;
                                this.L$1 = list;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.label = 3;
                                if (invokeSuspend$applyState(state4, authenticated, list5, this) != coroutine_suspended) {
                                    authenticated2 = authenticated;
                                    authenticated = authenticated2;
                                    if (!list.isEmpty()) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public TradfriController(Context context, AuthenticatedGateway.Tradfri tradfri) {
        context.getClass();
        tradfri.getClass();
        this.context = context;
        this.gateway = tradfri;
        this.tag = Common_smartlightKt.TAG;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        CoroutineContext coroutineContextPlus = Dispatchers.getMain().plus(completableJobSupervisorJob$default);
        CoroutineExceptionHandler.Companion companion = CoroutineExceptionHandler.INSTANCE;
        this.coroutineContext = coroutineContextPlus.plus(new TradfriController$special$$inlined$CoroutineExceptionHandler$1(companion, this));
        CompletableJob completableJobSupervisorJob$default2 = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.offStateCheckJob = completableJobSupervisorJob$default2;
        this.offStateCheckScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default2).plus(new TradfriController$special$$inlined$CoroutineExceptionHandler$2(companion, this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        if (r8 == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object execute(Function2<? super Client.Authenticated, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        Client.Authenticated authenticated;
        Object objInvoke;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objInit = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInit);
            if (this.closed) {
                return null;
            }
            if (this.client == null) {
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = function2;
                anonymousClass1.label = 1;
                objInit = init(anonymousClass1);
            } else {
                authenticated = this.client;
                if (authenticated == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    authenticated = null;
                }
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 2;
                objInvoke = function2.invoke(authenticated, anonymousClass1);
                if (objInvoke != coroutine_suspended) {
                    return objInvoke;
                }
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objInit);
                return objInit;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        function2 = (Function2) anonymousClass1.L$1;
        this = (TradfriController) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objInit);
        if (!((Boolean) objInit).booleanValue()) {
            return null;
        }
        authenticated = this.client;
        if (authenticated == null) {
        }
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        objInvoke = function2.invoke(authenticated, anonymousClass1);
        if (objInvoke != coroutine_suspended) {
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object init(Continuation<? super Boolean> continuation) {
        C22421 c22421;
        Tradfri.Access.Credential credential;
        Tradfri.Gateway nativeGateway;
        TradfriController tradfriController;
        Object objM2169resolveyxL6bBk;
        Tradfri.Access.Credential credential2;
        Tradfri.Gateway gateway;
        Client.Authenticated authenticated;
        String ip;
        if (continuation instanceof C22421) {
            c22421 = (C22421) continuation;
            int i = c22421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22421.label = i - Integer.MIN_VALUE;
            } else {
                c22421 = new C22421(continuation);
            }
        }
        C22421 c224212 = c22421;
        Object obj = c224212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c224212.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Logger.logInfo(Logger.defaultTag, getTag() + ": Client init", null);
            credential = new Tradfri.Access.Credential(getGateway().getIdentity(), getGateway().getToken());
            nativeGateway = MappersKt.toNativeGateway(getGateway());
            Long timestamp = getGateway().getTimestamp();
            this.lastSaved = timestamp != null ? timestamp.longValue() : System.currentTimeMillis();
            if (!AuthenticatedGateway.needResolveIp$default(getGateway(), 0L, 1, null)) {
                tradfriController = this;
                tradfriController.client = new Client.Authenticated(nativeGateway, credential);
                StringBuilder sb = new StringBuilder("Client init ");
                authenticated = tradfriController.client;
                if (authenticated == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    authenticated = null;
                }
                sb.append(authenticated);
                sb.append("\tgateway last saved: ");
                sb.append(Utils.getPrettyDate(tradfriController.lastSaved));
                String string = sb.toString();
                Logger.logInfo(Logger.defaultTag, tradfriController.getTag() + ": " + ((Object) string), null);
                return Boxing.boxBoolean(true);
            }
            Tradfri.Gateway.Companion companion = Tradfri.Gateway.INSTANCE;
            Context context = this.context;
            String id = getGateway().getId();
            String ip2 = getGateway().getIp();
            c224212.L$0 = this;
            c224212.L$1 = credential;
            c224212.L$2 = nativeGateway;
            c224212.label = 1;
            objM2169resolveyxL6bBk = companion.m2169resolveyxL6bBk(this, context, id, ip2, c224212);
            if (objM2169resolveyxL6bBk == coroutine_suspended) {
                return coroutine_suspended;
            }
            tradfriController = this;
            credential2 = credential;
            gateway = nativeGateway;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            gateway = (Tradfri.Gateway) c224212.L$2;
            credential2 = (Tradfri.Access.Credential) c224212.L$1;
            tradfriController = (TradfriController) c224212.L$0;
            ResultKt.throwOnFailure(obj);
            objM2169resolveyxL6bBk = ((Result) obj).getValue();
        }
        if (Result.m2363isSuccessimpl(objM2169resolveyxL6bBk)) {
            Tradfri.Gateway gateway2 = (Tradfri.Gateway) (Result.m2362isFailureimpl(objM2169resolveyxL6bBk) ? null : objM2169resolveyxL6bBk);
            if (gateway2 != null && (ip = gateway2.getIp()) != null) {
                tradfriController.lastSaved = System.currentTimeMillis();
                AuthenticatedGateway.Tradfri.copy$default(tradfriController.getGateway(), null, ip, 0, null, null, null, Boxing.boxLong(tradfriController.lastSaved), 61, null).save(tradfriController.context);
            }
        }
        if (Result.m2362isFailureimpl(objM2169resolveyxL6bBk)) {
            Logger.logSevere(Logger.defaultTag, tradfriController.getTag() + ": Can't resolve Tradfri Gateway", null);
            return Boxing.boxBoolean(false);
        }
        if (Result.m2362isFailureimpl(objM2169resolveyxL6bBk)) {
            objM2169resolveyxL6bBk = gateway;
        }
        nativeGateway = (Tradfri.Gateway) objM2169resolveyxL6bBk;
        credential = credential2;
        tradfriController.client = new Client.Authenticated(nativeGateway, credential);
        StringBuilder sb2 = new StringBuilder("Client init ");
        authenticated = tradfriController.client;
        if (authenticated == null) {
        }
        sb2.append(authenticated);
        sb2.append("\tgateway last saved: ");
        sb2.append(Utils.getPrettyDate(tradfriController.lastSaved));
        String string2 = sb2.toString();
        Logger.logInfo(Logger.defaultTag, tradfriController.getTag() + ": " + ((Object) string2), null);
        return Boxing.boxBoolean(true);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object blink(List<Light> list, State state, int i, Continuation<? super Unit> continuation) {
        return execute(new AnonymousClass2(list, i, state, this, null), continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object close(Continuation<? super Unit> continuation) {
        this.closed = true;
        Client.Authenticated authenticated = null;
        Job.cancel$default(this.job, null, 1, null);
        CoroutineScopeKt.cancel$default(this.offStateCheckScope, null, 1, null);
        Client.Authenticated authenticated2 = this.client;
        if (authenticated2 != null) {
            if (authenticated2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("client");
            } else {
                authenticated = authenticated2;
            }
            authenticated.close();
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getBlinderState(Blinder blinder, Continuation<? super BlinderState> continuation) {
        return execute(new C22382(blinder, null), continuation);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbandroid.smartlight.common.controller.Controller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getLights(Continuation<? super List<Light>> continuation) {
        C22391 c22391;
        if (continuation instanceof C22391) {
            c22391 = (C22391) continuation;
            int i = c22391.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22391.label = i - Integer.MIN_VALUE;
            } else {
                c22391 = new C22391(continuation);
            }
        }
        Object objExecute = c22391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22391.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecute);
            C22402 c22402 = new C22402(null);
            c22391.label = 1;
            objExecute = execute(c22402, c22391);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objExecute);
        }
        List list = (List) objExecute;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getState(Light light, Continuation<? super State> continuation) {
        return execute(new C22412(light, null), continuation);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setBlinderState(List<Blinder> list, BlinderState blinderState, Continuation<? super Unit> continuation) {
        return execute(new C22432(list, blinderState, null), continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setState(List<Light> list, State state, Continuation<? super Unit> continuation) {
        return execute(new C22442(state, this, list, null), continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public AuthenticatedGateway.Tradfri getGateway() {
        return this.gateway;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setBlinderState(Blinder blinder, BlinderState blinderState, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.setBlinderState(this, blinder, blinderState, continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setState(Light light, State state, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.setState(this, light, state, continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object blink(Light light, State state, int i, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.blink(this, light, state, i, continuation);
    }
}
