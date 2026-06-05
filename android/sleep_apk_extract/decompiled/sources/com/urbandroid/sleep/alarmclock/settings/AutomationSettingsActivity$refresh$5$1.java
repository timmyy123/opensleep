package com.urbandroid.sleep.alarmclock.settings;

import android.content.Context;
import android.widget.Toast;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.automation.AutomationEvent;
import com.urbandroid.sleep.service.automation.AutomationEventMapping;
import com.urbandroid.sleep.service.automation.AutomationTrigger;
import com.urbandroid.sleep.service.automation.mqtt.MqttTrigger;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity$refresh$5$1", f = "AutomationSettingsActivity.kt", l = {160}, m = "invokeSuspend", v = 2)
public final class AutomationSettingsActivity$refresh$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ AutomationSettingsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutomationSettingsActivity$refresh$5$1(AutomationSettingsActivity automationSettingsActivity, Context context, Continuation<? super AutomationSettingsActivity$refresh$5$1> continuation) {
        super(2, continuation);
        this.this$0 = automationSettingsActivity;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutomationSettingsActivity$refresh$5$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AutomationSettingsActivity$refresh$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063 A[Catch: IOException -> 0x0060, TRY_LEAVE, TryCatch #1 {IOException -> 0x0060, blocks: (B:17:0x004b, B:21:0x0058, B:24:0x0063, B:14:0x0044), top: B:33:0x0044 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AutomationSettingsActivity$refresh$5$1 automationSettingsActivity$refresh$5$1;
        IOException iOException;
        boolean zBooleanValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Toast.makeText(this.this$0, R.string.connecting, 0).show();
                MqttTrigger mqttTrigger = new MqttTrigger(this.$context);
                AutomationEvent automationEventFromSleepEvent = AutomationEvent.INSTANCE.fromSleepEvent(AutomationEventMapping.UNKNOWN);
                this.label = 1;
                automationSettingsActivity$refresh$5$1 = this;
                try {
                    obj = AutomationTrigger.fire$default(mqttTrigger, automationEventFromSleepEvent, 0L, automationSettingsActivity$refresh$5$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zBooleanValue = ((Boolean) obj).booleanValue();
                    AutomationSettingsActivity automationSettingsActivity = automationSettingsActivity$refresh$5$1.this$0;
                    if (zBooleanValue) {
                    }
                } catch (IOException e) {
                    e = e;
                    iOException = e;
                    Toast.makeText(automationSettingsActivity$refresh$5$1.this$0, R.string.failed, 1).show();
                    AutomationSettingsActivity automationSettingsActivity2 = automationSettingsActivity$refresh$5$1.this$0;
                    Logger.logSevere(Logger.defaultTag, automationSettingsActivity2.getTag() + ": fire test failure", iOException);
                }
            } catch (IOException e2) {
                e = e2;
                automationSettingsActivity$refresh$5$1 = this;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            try {
                ResultKt.throwOnFailure(obj);
                automationSettingsActivity$refresh$5$1 = this;
                zBooleanValue = ((Boolean) obj).booleanValue();
                AutomationSettingsActivity automationSettingsActivity3 = automationSettingsActivity$refresh$5$1.this$0;
                if (zBooleanValue) {
                    Toast.makeText(automationSettingsActivity3, R.string.failed, 1).show();
                } else {
                    Toast.makeText(automationSettingsActivity3, R.string.sucess, 0).show();
                }
            } catch (IOException e3) {
                iOException = e3;
                automationSettingsActivity$refresh$5$1 = this;
                Toast.makeText(automationSettingsActivity$refresh$5$1.this$0, R.string.failed, 1).show();
                AutomationSettingsActivity automationSettingsActivity22 = automationSettingsActivity$refresh$5$1.this$0;
                Logger.logSevere(Logger.defaultTag, automationSettingsActivity22.getTag() + ": fire test failure", iOException);
            }
        }
        return Unit.INSTANCE;
    }
}
