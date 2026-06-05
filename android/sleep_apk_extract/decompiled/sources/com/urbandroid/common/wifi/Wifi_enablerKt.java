package com.urbandroid.common.wifi;

import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "applicantId", "", "timeoutInSecond", "Lcom/urbandroid/common/wifi/WifiContext;", "enableWifi", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class Wifi_enablerKt {

    /* JADX INFO: renamed from: com.urbandroid.common.wifi.Wifi_enablerKt$enableWifi$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.common.wifi.Wifi_enablerKt", f = "wifi-enabler.kt", l = {13}, m = "enableWifi", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return Wifi_enablerKt.enableWifi(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.common.wifi.Wifi_enablerKt$enableWifi$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/common/wifi/WifiContext;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.common.wifi.Wifi_enablerKt$enableWifi$2", f = "wifi-enabler.kt", l = {49}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WifiContext>, Object> {
        final /* synthetic */ String $applicantId;
        final /* synthetic */ int $timeoutInSecond;
        int I$0;
        long J$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$timeoutInSecond = i;
            this.$applicantId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$timeoutInSecond, this.$applicantId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WifiContext> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            long secondsInMillis = Utils.getSecondsInMillis(this.$timeoutInSecond);
            Wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new Wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, this.$applicantId, this.$timeoutInSecond);
            this.J$0 = secondsInMillis;
            this.I$0 = 0;
            this.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(secondsInMillis, wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object enableWifi(String str, int i, Continuation<? super WifiContext> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(i, str, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.I$0 = i;
                anonymousClass1.label = 1;
                objWithContext = BuildersKt.withContext(main, anonymousClass2, anonymousClass1);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = anonymousClass1.I$0;
                ResultKt.throwOnFailure(objWithContext);
            }
            return (WifiContext) objWithContext;
        } catch (TimeoutCancellationException unused) {
            Logger.logWarning("unable to enable wifi - timeout " + i + " sec", null);
            return null;
        }
    }
}
