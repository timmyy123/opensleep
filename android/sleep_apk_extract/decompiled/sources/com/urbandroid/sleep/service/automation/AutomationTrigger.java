package com.urbandroid.sleep.service.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.automation.ifttt.IftttTrigger;
import com.urbandroid.sleep.service.automation.mqtt.MqttTrigger;
import com.urbandroid.sleep.service.automation.webhooks.WebhookTrigger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H¤@¢\u0006\u0002\u0010\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationTrigger;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "name", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "tag", "getTag", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "", "()Z", "doSend", "event", "Lcom/urbandroid/sleep/service/automation/AutomationEvent;", "timeoutInMs", "", "(Lcom/urbandroid/sleep/service/automation/AutomationEvent;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fire", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AutomationTrigger implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final String name;
    private final String tag;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationTrigger$Companion;", "", "<init>", "()V", "getEnabledTriggersOrNull", "", "Lcom/urbandroid/sleep/service/automation/AutomationTrigger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<AutomationTrigger> getEnabledTriggersOrNull(Context context) {
            context.getClass();
            List listListOf = CollectionsKt.listOf((Object[]) new AutomationTrigger[]{new MqttTrigger(context), new IftttTrigger(context), new WebhookTrigger(context)});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listListOf) {
                if (((AutomationTrigger) obj).isEnabled()) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.AutomationTrigger$fire$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.AutomationTrigger", f = "AutomationTrigger.kt", l = {27}, m = "fire", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationTrigger.this.fire(null, 0L, this);
        }
    }

    public AutomationTrigger(Context context, String str) {
        context.getClass();
        str.getClass();
        this.context = context;
        this.name = str;
        this.tag = FileInsert$$ExternalSyntheticOutline0.m("automation:trigger:", str);
    }

    public static /* synthetic */ Object fire$default(AutomationTrigger automationTrigger, AutomationEvent automationEvent, long j, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: fire");
            return null;
        }
        if ((i & 2) != 0) {
            j = Utils.getSecondsInMillis(15);
        }
        return automationTrigger.fire(automationEvent, j, continuation);
    }

    public abstract Object doSend(AutomationEvent automationEvent, long j, Continuation<? super Boolean> continuation);

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fire(AutomationEvent automationEvent, long j, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        boolean zBooleanValue;
        Boolean boolBoxBoolean;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objSupervisorScope = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        boolean zBooleanValue2 = false;
        try {
        } catch (Exception e) {
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(automationEvent.getEventName(), " send failure");
            Logger.logSevere(Logger.defaultTag, getTag() + ": " + strM$1, e);
            zBooleanValue = false;
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSupervisorScope);
            String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(automationEvent.getEventName(), " firing ...");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM$12, null);
            Context context = this.context;
            String strM$13 = FileInsert$$ExternalSyntheticOutline0.m$1(getTag(), ": ", automationEvent.getEventName());
            if (!ContextExtKt.hasConnectivity(context)) {
                Logger.logSevere(strM$13.concat(" - no connectivity"), null);
                boolBoxBoolean = null;
                if (boolBoxBoolean == null) {
                    zBooleanValue2 = boolBoxBoolean.booleanValue();
                } else {
                    String strM$14 = FileInsert$$ExternalSyntheticOutline0.m$1(automationEvent.getEventName(), " fire failure");
                    Logger.logSevere(Logger.defaultTag, getTag() + ": " + strM$14, null);
                }
                return Boxing.boxBoolean(zBooleanValue2);
            }
            AutomationTrigger$fire$2$1 automationTrigger$fire$2$1 = new AutomationTrigger$fire$2$1(this, automationEvent, j, null);
            anonymousClass1.L$0 = automationEvent;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(strM$13);
            anonymousClass1.J$0 = j;
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 1;
            objSupervisorScope = SupervisorKt.supervisorScope(automationTrigger$fire$2$1, anonymousClass1);
            if (objSupervisorScope == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            automationEvent = (AutomationEvent) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objSupervisorScope);
        }
        zBooleanValue = ((Boolean) objSupervisorScope).booleanValue();
        boolBoxBoolean = Boxing.boxBoolean(zBooleanValue);
        if (boolBoxBoolean == null) {
        }
        return Boxing.boxBoolean(zBooleanValue2);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public abstract boolean isEnabled();
}
