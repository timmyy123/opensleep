package com.urbandroid.sleep.alarmclock.settings;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.trial.OrderClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1", f = "CaptchaCheatingSettingsActivity.kt", l = {}, m = "invokeSuspend", v = 2)
public final class CaptchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ CaptchaCheatingSettingsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, String str, Continuation<? super CaptchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = captchaCheatingSettingsActivity;
        this.$token = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CaptchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1(this.this$0, this.$token, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((CaptchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zRefundInApp;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        try {
            OrderClient orderClient = new OrderClient();
            String captchaAvoidedSku = this.this$0.getSettings().getCaptchaAvoidedSku();
            captchaAvoidedSku.getClass();
            String captchaAvoidedOrderId = this.this$0.getSettings().getCaptchaAvoidedOrderId();
            captchaAvoidedOrderId.getClass();
            zRefundInApp = orderClient.refundInApp(captchaAvoidedSku, captchaAvoidedOrderId, this.$token);
        } catch (Exception e) {
            Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e);
            zRefundInApp = true;
        }
        return Boxing.boxBoolean(zRefundInApp);
    }
}
