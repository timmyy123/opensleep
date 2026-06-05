package com.urbandroid.smartlight.ikea.tradfri;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.ikea.tradfri.Client;
import com.urbandroid.smartlight.ikea.tradfri.coapmodel.Device;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$DeviceTransition$start$1", f = "Client.kt", l = {151, 157, 161}, m = "invokeSuspend")
public final class Client$Authenticated$DeviceTransition$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device.State $fromState;
    final /* synthetic */ Device.State $toState;
    final /* synthetic */ int $transitionInCentiSeconds;
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ Client.Authenticated this$0;
    final /* synthetic */ Client.Authenticated.DeviceTransition this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Client$Authenticated$DeviceTransition$start$1(int i, Client.Authenticated authenticated, Device.State state, Device.State state2, Client.Authenticated.DeviceTransition deviceTransition, Continuation<? super Client$Authenticated$DeviceTransition$start$1> continuation) {
        super(2, continuation);
        this.$transitionInCentiSeconds = i;
        this.this$0 = authenticated;
        this.$fromState = state;
        this.$toState = state2;
        this.this$1 = deviceTransition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c5, code lost:
    
        if (r0.send(r3, r1) == r2) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0138, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(125, r1) == r2) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x018b, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(250, r1) != r2) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d2, code lost:
    
        if (r0.send(r3, r1) == r2) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object invokeSuspend$applyState(boolean z, Client.Authenticated authenticated, Client.Authenticated.DeviceTransition deviceTransition, Client.Authenticated.Step step, Device.State state, Continuation<? super Unit> continuation) {
        Client$Authenticated$DeviceTransition$start$1$applyState$1 client$Authenticated$DeviceTransition$start$1$applyState$1;
        Client.Authenticated authenticated2;
        Client.Authenticated.DeviceTransition deviceTransition2;
        Client.Authenticated authenticated3;
        Client.Authenticated.DeviceTransition deviceTransition3;
        Device.State state2;
        Client.Authenticated.DeviceTransition deviceTransition4;
        Client.Authenticated authenticated4;
        if (continuation instanceof Client$Authenticated$DeviceTransition$start$1$applyState$1) {
            client$Authenticated$DeviceTransition$start$1$applyState$1 = (Client$Authenticated$DeviceTransition$start$1$applyState$1) continuation;
            int i = client$Authenticated$DeviceTransition$start$1$applyState$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                client$Authenticated$DeviceTransition$start$1$applyState$1.label = i - Integer.MIN_VALUE;
            } else {
                client$Authenticated$DeviceTransition$start$1$applyState$1 = new Client$Authenticated$DeviceTransition$start$1$applyState$1(continuation);
            }
        }
        Object obj = client$Authenticated$DeviceTransition$start$1$applyState$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (client$Authenticated$DeviceTransition$start$1$applyState$1.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Device.State deviceState = step.toDeviceState();
                if (!z) {
                    if (authenticated.applyStateChannel.isClosedForSend()) {
                        return Unit.INSTANCE;
                    }
                    Channel channel = authenticated.applyStateChannel;
                    Pair pair = TuplesKt.to(CollectionsKt.listOf(new Client.Authenticated.LightId(deviceTransition.getDeviceId(), deviceTransition.getType())), Device.State.copy$default(deviceState, null, null, null, null, null, Boxing.boxInt(0), 31, null));
                    client$Authenticated$DeviceTransition$start$1$applyState$1.label = 7;
                    break;
                } else {
                    if (step.hasColorChanged(state) && step.hasBrightnessChanged(state)) {
                        if (!authenticated.applyStateChannel.isClosedForSend()) {
                            Channel channel2 = authenticated.applyStateChannel;
                            Pair pair2 = TuplesKt.to(CollectionsKt.listOf(new Client.Authenticated.LightId(deviceTransition.getDeviceId(), deviceTransition.getType())), Device.State.copy$default(deviceState, null, null, null, null, null, Boxing.boxInt(1), 15, null));
                            authenticated2 = authenticated;
                            client$Authenticated$DeviceTransition$start$1$applyState$1.L$0 = authenticated2;
                            deviceTransition2 = deviceTransition;
                            client$Authenticated$DeviceTransition$start$1$applyState$1.L$1 = deviceTransition2;
                            client$Authenticated$DeviceTransition$start$1$applyState$1.L$2 = deviceState;
                            client$Authenticated$DeviceTransition$start$1$applyState$1.label = 1;
                        } else {
                            authenticated2 = authenticated;
                            deviceTransition2 = deviceTransition;
                        }
                        Client.Authenticated.DeviceTransition deviceTransition5 = deviceTransition2;
                        authenticated3 = authenticated2;
                        deviceTransition3 = deviceTransition5;
                        state2 = deviceState;
                        client$Authenticated$DeviceTransition$start$1$applyState$1.L$0 = authenticated3;
                        client$Authenticated$DeviceTransition$start$1$applyState$1.L$1 = deviceTransition3;
                        client$Authenticated$DeviceTransition$start$1$applyState$1.L$2 = state2;
                        client$Authenticated$DeviceTransition$start$1$applyState$1.label = 2;
                        if (DelayKt.delay(125L, client$Authenticated$DeviceTransition$start$1$applyState$1) != coroutine_suspended) {
                            deviceTransition4 = deviceTransition3;
                            authenticated4 = authenticated3;
                            Device.State state3 = state2;
                            if (!authenticated4.applyStateChannel.isClosedForSend()) {
                                Channel channel3 = authenticated4.applyStateChannel;
                                Pair pair3 = TuplesKt.to(CollectionsKt.listOf(new Client.Authenticated.LightId(deviceTransition4.getDeviceId(), deviceTransition4.getType())), Device.State.copy$default(state3, null, null, null, null, null, Boxing.boxInt(1), 19, null));
                                client$Authenticated$DeviceTransition$start$1$applyState$1.L$0 = null;
                                client$Authenticated$DeviceTransition$start$1$applyState$1.L$1 = null;
                                client$Authenticated$DeviceTransition$start$1$applyState$1.L$2 = null;
                                client$Authenticated$DeviceTransition$start$1$applyState$1.label = 3;
                                if (channel3.send(pair3, client$Authenticated$DeviceTransition$start$1$applyState$1) != coroutine_suspended) {
                                }
                            }
                            client$Authenticated$DeviceTransition$start$1$applyState$1.L$0 = null;
                            client$Authenticated$DeviceTransition$start$1$applyState$1.L$1 = null;
                            client$Authenticated$DeviceTransition$start$1$applyState$1.L$2 = null;
                            client$Authenticated$DeviceTransition$start$1$applyState$1.label = 4;
                        }
                    } else {
                        if (!authenticated.applyStateChannel.isClosedForSend()) {
                            Channel channel4 = authenticated.applyStateChannel;
                            Pair pair4 = TuplesKt.to(CollectionsKt.listOf(new Client.Authenticated.LightId(deviceTransition.getDeviceId(), deviceTransition.getType())), Device.State.copy$default(deviceState, null, null, null, null, null, Boxing.boxInt(2), 31, null));
                            client$Authenticated$DeviceTransition$start$1$applyState$1.label = 5;
                            if (channel4.send(pair4, client$Authenticated$DeviceTransition$start$1$applyState$1) != coroutine_suspended) {
                            }
                        }
                        client$Authenticated$DeviceTransition$start$1$applyState$1.label = 6;
                    }
                    break;
                }
                return coroutine_suspended;
            case 1:
                state2 = (Device.State) client$Authenticated$DeviceTransition$start$1$applyState$1.L$2;
                deviceTransition3 = (Client.Authenticated.DeviceTransition) client$Authenticated$DeviceTransition$start$1$applyState$1.L$1;
                authenticated3 = (Client.Authenticated) client$Authenticated$DeviceTransition$start$1$applyState$1.L$0;
                ResultKt.throwOnFailure(obj);
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$0 = authenticated3;
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$1 = deviceTransition3;
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$2 = state2;
                client$Authenticated$DeviceTransition$start$1$applyState$1.label = 2;
                if (DelayKt.delay(125L, client$Authenticated$DeviceTransition$start$1$applyState$1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                state2 = (Device.State) client$Authenticated$DeviceTransition$start$1$applyState$1.L$2;
                deviceTransition4 = (Client.Authenticated.DeviceTransition) client$Authenticated$DeviceTransition$start$1$applyState$1.L$1;
                authenticated4 = (Client.Authenticated) client$Authenticated$DeviceTransition$start$1$applyState$1.L$0;
                ResultKt.throwOnFailure(obj);
                Device.State state32 = state2;
                if (!authenticated4.applyStateChannel.isClosedForSend()) {
                }
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$0 = null;
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$1 = null;
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$2 = null;
                client$Authenticated$DeviceTransition$start$1$applyState$1.label = 4;
                break;
            case 3:
                ResultKt.throwOnFailure(obj);
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$0 = null;
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$1 = null;
                client$Authenticated$DeviceTransition$start$1$applyState$1.L$2 = null;
                client$Authenticated$DeviceTransition$start$1$applyState$1.label = 4;
                break;
            case 4:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure(obj);
                client$Authenticated$DeviceTransition$start$1$applyState$1.label = 6;
                break;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 7:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Client$Authenticated$DeviceTransition$start$1(this.$transitionInCentiSeconds, this.this$0, this.$fromState, this.$toState, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Client$Authenticated$DeviceTransition$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x025d, code lost:
    
        if (invokeSuspend$applyState(r0, r1, r2, r3, r4, r31) == r6) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0155 A[Catch: ClosedSendChannelException -> 0x001b, TRY_LEAVE, TryCatch #1 {ClosedSendChannelException -> 0x001b, blocks: (B:7:0x0016, B:14:0x004a, B:30:0x0155, B:17:0x007a, B:28:0x013f), top: B:65:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x022c A[Catch: ClosedSendChannelException -> 0x01d2, TryCatch #0 {ClosedSendChannelException -> 0x01d2, blocks: (B:51:0x0220, B:32:0x0161, B:34:0x016b, B:38:0x017a, B:42:0x01c0, B:46:0x01d5, B:52:0x022c, B:57:0x023b), top: B:63:0x0220 }] */
    /* JADX WARN: Type inference failed for: r10v5, types: [T, com.urbandroid.smartlight.ikea.tradfri.coapmodel.Device$State] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$Step] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$Step] */
    /* JADX WARN: Type inference failed for: r7v14, types: [T, com.urbandroid.smartlight.ikea.tradfri.coapmodel.Device$State] */
    /* JADX WARN: Type inference failed for: r9v8, types: [T, com.urbandroid.smartlight.ikea.tradfri.coapmodel.Device$State, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0204 -> B:50:0x0215). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        Ref$ObjectRef ref$ObjectRef;
        Client.Authenticated.Step step;
        Client.Authenticated.DeviceTransition deviceTransition;
        int i;
        Ref$BooleanRef ref$BooleanRef;
        int i2;
        int i3;
        Ref$ObjectRef ref$ObjectRef2;
        Client.Authenticated authenticated;
        long j;
        Device.State state;
        int i4;
        Ref$BooleanRef ref$BooleanRef2;
        int i5;
        Ref$ObjectRef ref$ObjectRef3;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        String str2 = ": ";
        try {
        } catch (ClosedSendChannelException e) {
            e = e;
            str = ": ";
        }
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            int i7 = this.$transitionInCentiSeconds >= 6 ? 1 : 0;
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ref$ObjectRef4.element = this.this$0.toStep(this.$fromState);
            Client.Authenticated authenticated2 = this.this$0;
            String str3 = "DeviceTransition - from: " + this.$fromState + " to: " + this.$toState;
            Logger.logInfo(Logger.defaultTag, authenticated2.getTag() + ": " + ((Object) str3), null);
            int i8 = this.$transitionInCentiSeconds * 100;
            long j3 = i7 != 0 ? 250L : 50L;
            int i9 = i8 / ((int) j3);
            Client.Authenticated.Step stepCalculateStepTo = this.this$0.calculateStepTo(this.$fromState, this.$toState, i9);
            Client.Authenticated authenticated3 = this.this$0;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i8, i9, "DeviceTransition - time: ", " steps: ", " step: ");
            sbM.append(stepCalculateStepTo);
            String string = sbM.toString();
            Logger.logInfo(Logger.defaultTag, authenticated3.getTag() + ": " + ((Object) string), null);
            Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
            ref$ObjectRef5.element = Device.State.copy$default(this.$fromState, null, null, null, null, null, null, 31, null);
            Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
            Client.Authenticated authenticated4 = this.this$0;
            Device.State state2 = this.$toState;
            ref$ObjectRef = ref$ObjectRef5;
            step = stepCalculateStepTo;
            deviceTransition = this.this$1;
            i = i9;
            ref$BooleanRef = ref$BooleanRef3;
            i2 = 0;
            i3 = i7;
            ref$ObjectRef2 = ref$ObjectRef4;
            authenticated = authenticated4;
            j = j3;
            state = state2;
            if (i2 < i) {
            }
            return coroutine_suspended;
        }
        if (i6 == 1) {
            i4 = this.I$2;
            int i10 = this.I$1;
            long j4 = this.J$0;
            i5 = this.I$0;
            ?? r7 = (Device.State) this.L$7;
            Client.Authenticated.DeviceTransition deviceTransition2 = (Client.Authenticated.DeviceTransition) this.L$6;
            Device.State state3 = (Device.State) this.L$5;
            Client.Authenticated authenticated5 = (Client.Authenticated) this.L$4;
            Ref$BooleanRef ref$BooleanRef4 = (Ref$BooleanRef) this.L$3;
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            step = (Client.Authenticated.Step) this.L$1;
            Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            str = ": ";
            ref$ObjectRef.element = r7;
            ref$BooleanRef4.element = true;
            ref$BooleanRef2 = ref$BooleanRef4;
            i = i10;
            authenticated = authenticated5;
            ref$ObjectRef3 = ref$ObjectRef6;
            j2 = j4;
            deviceTransition = deviceTransition2;
            state = state3;
            Ref$BooleanRef ref$BooleanRef5 = ref$BooleanRef2;
            i2 = i4 + 1;
            ref$ObjectRef2 = ref$ObjectRef3;
            j = j2;
            ref$BooleanRef = ref$BooleanRef5;
            i3 = i5;
            str2 = str;
            if (i2 < i) {
            }
            return coroutine_suspended;
        }
        if (i6 != 2) {
            if (i6 == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i4 = this.I$2;
        int i11 = this.I$1;
        long j5 = this.J$0;
        i5 = this.I$0;
        Client.Authenticated.DeviceTransition deviceTransition3 = (Client.Authenticated.DeviceTransition) this.L$6;
        Device.State state4 = (Device.State) this.L$5;
        Client.Authenticated authenticated6 = (Client.Authenticated) this.L$4;
        ref$BooleanRef2 = (Ref$BooleanRef) this.L$3;
        Ref$ObjectRef ref$ObjectRef7 = (Ref$ObjectRef) this.L$2;
        Client.Authenticated.Step step2 = (Client.Authenticated.Step) this.L$1;
        ref$ObjectRef3 = (Ref$ObjectRef) this.L$0;
        ResultKt.throwOnFailure(obj);
        str = ": ";
        try {
            long j6 = j5;
            deviceTransition = deviceTransition3;
            j2 = j6;
            state = state4;
            ref$ObjectRef = ref$ObjectRef7;
            i = i11;
            authenticated = authenticated6;
            step = step2;
            Ref$BooleanRef ref$BooleanRef52 = ref$BooleanRef2;
            i2 = i4 + 1;
            ref$ObjectRef2 = ref$ObjectRef3;
            j = j2;
            ref$BooleanRef = ref$BooleanRef52;
            i3 = i5;
            str2 = str;
        } catch (ClosedSendChannelException e2) {
            e = e2;
            Client.Authenticated authenticated7 = this.this$0;
            String string2 = e.toString();
            Logger.logWarning(Logger.defaultTag, authenticated7.getTag() + str + ((Object) string2), null);
        }
        if (i2 < i) {
            ?? ApplyStep = authenticated.applyStep((Client.Authenticated.Step) ref$ObjectRef2.element, step, state);
            ref$ObjectRef2.element = ApplyStep;
            str = str2;
            if (ApplyStep.isChangeSufficient((Device.State) ref$ObjectRef.element)) {
                ?? deviceState = ((Client.Authenticated.Step) ref$ObjectRef2.element).toDeviceState();
                boolean z = i3 != 0;
                Client.Authenticated.Step step3 = (Client.Authenticated.Step) ref$ObjectRef2.element;
                Device.State state5 = (Device.State) ref$ObjectRef.element;
                this.L$0 = ref$ObjectRef2;
                this.L$1 = step;
                this.L$2 = ref$ObjectRef;
                this.L$3 = ref$BooleanRef;
                this.L$4 = authenticated;
                this.L$5 = state;
                this.L$6 = deviceTransition;
                this.L$7 = deviceState;
                this.I$0 = i3;
                this.J$0 = j;
                this.I$1 = i;
                this.I$2 = i2;
                this.label = 1;
                Ref$ObjectRef ref$ObjectRef8 = ref$ObjectRef2;
                Device.State state6 = state;
                if (invokeSuspend$applyState(z, authenticated, deviceTransition, step3, state5, this) != coroutine_suspended) {
                    long j7 = j;
                    Client.Authenticated authenticated8 = authenticated;
                    int i12 = i;
                    Client.Authenticated.DeviceTransition deviceTransition4 = deviceTransition;
                    i4 = i2;
                    i5 = i3;
                    ref$ObjectRef.element = deviceState;
                    ref$BooleanRef.element = true;
                    ref$BooleanRef2 = ref$BooleanRef;
                    i = i12;
                    authenticated = authenticated8;
                    ref$ObjectRef3 = ref$ObjectRef8;
                    j2 = j7;
                    deviceTransition = deviceTransition4;
                    state = state6;
                    Ref$BooleanRef ref$BooleanRef522 = ref$BooleanRef2;
                    i2 = i4 + 1;
                    ref$ObjectRef2 = ref$ObjectRef3;
                    j = j2;
                    ref$BooleanRef = ref$BooleanRef522;
                    i3 = i5;
                    str2 = str;
                    if (i2 < i) {
                        Ref$ObjectRef ref$ObjectRef9 = ref$ObjectRef2;
                        str = str2;
                        if (!ref$BooleanRef.element) {
                            boolean z2 = i3 != 0;
                            Client.Authenticated authenticated9 = this.this$0;
                            Client.Authenticated.DeviceTransition deviceTransition5 = this.this$1;
                            Client.Authenticated.Step step4 = (Client.Authenticated.Step) ref$ObjectRef9.element;
                            Device.State state7 = this.$toState;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.label = 3;
                        }
                        return Unit.INSTANCE;
                    }
                }
            } else {
                Ref$ObjectRef ref$ObjectRef10 = ref$ObjectRef2;
                Device.State state8 = state;
                ref$BooleanRef.element = false;
                this.L$0 = ref$ObjectRef10;
                this.L$1 = step;
                this.L$2 = ref$ObjectRef;
                this.L$3 = ref$BooleanRef;
                this.L$4 = authenticated;
                this.L$5 = state8;
                this.L$6 = deviceTransition;
                this.L$7 = null;
                this.I$0 = i3;
                this.J$0 = j;
                this.I$1 = i;
                this.I$2 = i2;
                this.label = 2;
                if (DelayKt.delay(j, this) != coroutine_suspended) {
                    i4 = i2;
                    ref$BooleanRef2 = ref$BooleanRef;
                    deviceTransition3 = deviceTransition;
                    Client.Authenticated.Step step5 = step;
                    authenticated6 = authenticated;
                    i11 = i;
                    ref$ObjectRef7 = ref$ObjectRef;
                    state4 = state8;
                    i5 = i3;
                    ref$ObjectRef3 = ref$ObjectRef10;
                    j5 = j;
                    step2 = step5;
                    long j62 = j5;
                    deviceTransition = deviceTransition3;
                    j2 = j62;
                    state = state4;
                    ref$ObjectRef = ref$ObjectRef7;
                    i = i11;
                    authenticated = authenticated6;
                    step = step2;
                    Ref$BooleanRef ref$BooleanRef5222 = ref$BooleanRef2;
                    i2 = i4 + 1;
                    ref$ObjectRef2 = ref$ObjectRef3;
                    j = j2;
                    ref$BooleanRef = ref$BooleanRef5222;
                    i3 = i5;
                    str2 = str;
                    if (i2 < i) {
                    }
                }
            }
        }
        return coroutine_suspended;
    }
}
