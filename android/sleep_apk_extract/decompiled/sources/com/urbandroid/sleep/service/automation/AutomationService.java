package com.urbandroid.sleep.service.automation;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.ForegroundService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity;
import com.urbandroid.sleep.service.automation.AutomationEvent;
import com.urbandroid.sleep.service.automation.AutomationTrigger;
import com.urbandroid.util.ColorUtil;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationService;", "Lcom/urbandroid/common/ForegroundService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "counter", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "onStartCommand", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "flags", "startId", "stopIfIamLast", "", "onDestroy", "getNotification", "Landroid/app/Notification;", "event", "Lcom/urbandroid/sleep/service/automation/AutomationEvent;", "triggers", "", "Lcom/urbandroid/sleep/service/automation/AutomationTrigger;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutomationService extends ForegroundService implements CoroutineScope, FeatureLogger {
    private final CoroutineContext coroutineContext;
    private transient int counter;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.AutomationService$onStartCommand$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.AutomationService$onStartCommand$1", f = "AutomationService.kt", l = {55, 57, 57, 63, 63}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $current;
        final /* synthetic */ List<AutomationTrigger> $enabledTriggers;
        final /* synthetic */ AutomationEvent $event;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ AutomationService this$0;

        /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.AutomationService$onStartCommand$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.service.automation.AutomationService$onStartCommand$1$2", f = "AutomationService.kt", l = {}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AutomationService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(AutomationService automationService, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = automationService;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.stopIfIamLast();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends AutomationTrigger> list, AutomationService automationService, AutomationEvent automationEvent, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$enabledTriggers = list;
            this.this$0 = automationService;
            this.$event = automationEvent;
            this.$current = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$enabledTriggers, this.this$0, this.$event, this.$current, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x01eb, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r0, r1, r24) == r8) goto L61;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ba A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #1 {all -> 0x0040, blocks: (B:14:0x003b, B:53:0x01ce, B:19:0x005b, B:29:0x00b4, B:31:0x00ba, B:39:0x0140, B:50:0x01a0, B:28:0x00a1), top: B:65:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0177  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0179  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01cd  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01cf  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0179 -> B:21:0x0062). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            AutomationService automationService;
            AutomationEvent automationEvent;
            Iterable iterable;
            int i;
            Iterator it;
            int i2;
            int i3;
            AutomationEvent automationEvent2;
            AutomationTrigger automationTrigger;
            AutomationService automationService2;
            Object obj2;
            int i4;
            int i5;
            Throwable th;
            NonCancellable nonCancellable;
            AutomationService$onStartCommand$1$1$1 automationService$onStartCommand$1$1$1;
            int i6;
            AutomationEvent automationEvent3;
            AutomationTrigger automationTrigger2;
            AutomationService automationService3;
            Object next;
            Iterable iterable2;
            Object objFire$default;
            NonCancellable nonCancellable2;
            AutomationService$onStartCommand$1$1$1 automationService$onStartCommand$1$1$12;
            AutomationService automationService4;
            AutomationService automationService5;
            AutomationTrigger automationTrigger3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i7 = this.label;
            try {
            } catch (Throwable th2) {
                NonCancellable nonCancellable3 = NonCancellable.INSTANCE;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, null);
                this.L$0 = th2;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.label = 5;
                if (BuildersKt.withContext(nonCancellable3, anonymousClass2, this) != coroutine_suspended) {
                    throw th2;
                }
            }
            if (i7 == 0) {
                ResultKt.throwOnFailure(obj);
                List<AutomationTrigger> list = this.$enabledTriggers;
                automationService = this.this$0;
                automationEvent = this.$event;
                iterable = list;
                i = this.$current;
                it = list.iterator();
                i2 = 0;
                if (it.hasNext()) {
                }
                return coroutine_suspended;
            }
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 == 3) {
                        th = (Throwable) this.L$3;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    if (i7 == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i7 != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th3 = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th3;
                }
                int i8 = this.I$1;
                int i9 = this.I$0;
                Iterator it2 = (Iterator) this.L$3;
                AutomationEvent automationEvent4 = (AutomationEvent) this.L$2;
                automationService4 = (AutomationService) this.L$1;
                iterable2 = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
                i2 = i8;
                i = i9;
                it = it2;
                automationEvent = automationEvent4;
                automationService = automationService4;
                iterable = iterable2;
                if (it.hasNext()) {
                    next = it.next();
                    AutomationTrigger automationTrigger4 = (AutomationTrigger) next;
                    try {
                        try {
                            String str = automationTrigger4.getName() + " starting ... " + automationEvent.getEventName() + " " + i;
                            Logger.logInfo(Logger.defaultTag, automationService.getTag() + ": " + str, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                            this.L$1 = automationService;
                            this.L$2 = automationEvent;
                            this.L$3 = it;
                            this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                            this.L$5 = automationTrigger4;
                            this.I$0 = i;
                            this.I$1 = i2;
                            this.I$2 = 0;
                            this.label = 1;
                            objFire$default = AutomationTrigger.fire$default(automationTrigger3, automationEvent, 0L, this, 2, null);
                            if (objFire$default != coroutine_suspended) {
                                automationTrigger2 = automationTrigger3;
                                automationEvent3 = automationEvent;
                                i5 = 0;
                                i4 = i2;
                                i6 = i;
                                automationService3 = automationService5;
                                iterable2 = iterable;
                                try {
                                    ((Boolean) objFire$default).getClass();
                                    nonCancellable2 = NonCancellable.INSTANCE;
                                    automationService$onStartCommand$1$1$12 = new AutomationService$onStartCommand$1$1$1(automationService3, automationTrigger2, automationEvent3, i6, null);
                                    automationService4 = automationService3;
                                    AutomationEvent automationEvent5 = automationEvent3;
                                    i = i6;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(iterable2);
                                    this.L$1 = automationService4;
                                    this.L$2 = automationEvent5;
                                    this.L$3 = it;
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(automationTrigger2);
                                    this.I$0 = i;
                                    this.I$1 = i4;
                                    this.I$2 = i5;
                                    this.label = 2;
                                    if (BuildersKt.withContext(nonCancellable2, automationService$onStartCommand$1$1$12, this) == coroutine_suspended) {
                                        i2 = i4;
                                        automationEvent = automationEvent5;
                                        automationService = automationService4;
                                        iterable = iterable2;
                                        if (it.hasNext()) {
                                            NonCancellable nonCancellable4 = NonCancellable.INSTANCE;
                                            AnonymousClass2 anonymousClass22 = new AnonymousClass2(this.this$0, null);
                                            this.L$0 = null;
                                            this.L$1 = null;
                                            this.L$2 = null;
                                            this.L$3 = null;
                                            this.L$4 = null;
                                            this.L$5 = null;
                                            this.label = 4;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    automationService2 = automationService3;
                                    iterable = iterable2;
                                    automationEvent2 = automationEvent3;
                                    i3 = i6;
                                    obj2 = next;
                                    automationTrigger = automationTrigger2;
                                    nonCancellable = NonCancellable.INSTANCE;
                                    automationService$onStartCommand$1$1$1 = new AutomationService$onStartCommand$1$1$1(automationService2, automationTrigger, automationEvent2, i3, null);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(automationTrigger);
                                    this.L$3 = th;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.I$0 = i4;
                                    this.I$1 = i5;
                                    this.label = 3;
                                    if (BuildersKt.withContext(nonCancellable, automationService$onStartCommand$1$1$1, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            AutomationService automationService6 = automationService5;
                            automationEvent2 = automationEvent;
                            i4 = i2;
                            automationService2 = automationService6;
                            i3 = i;
                            obj2 = next;
                            automationTrigger = automationTrigger3;
                            i5 = 0;
                            nonCancellable = NonCancellable.INSTANCE;
                            automationService$onStartCommand$1$1$1 = new AutomationService$onStartCommand$1$1$1(automationService2, automationTrigger, automationEvent2, i3, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(automationTrigger);
                            this.L$3 = th;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.I$0 = i4;
                            this.I$1 = i5;
                            this.label = 3;
                            if (BuildersKt.withContext(nonCancellable, automationService$onStartCommand$1$1$1, this) == coroutine_suspended) {
                            }
                            throw th;
                        }
                        AutomationService automationService7 = automationService;
                        automationTrigger3 = automationTrigger4;
                        automationService5 = automationService7;
                    } catch (Throwable th6) {
                        th = th6;
                        automationService5 = automationService;
                        automationTrigger3 = automationTrigger4;
                    }
                }
                return coroutine_suspended;
            }
            i5 = this.I$2;
            i4 = this.I$1;
            int i10 = this.I$0;
            AutomationTrigger automationTrigger5 = (AutomationTrigger) this.L$5;
            obj2 = this.L$4;
            it = (Iterator) this.L$3;
            AutomationEvent automationEvent6 = (AutomationEvent) this.L$2;
            automationService2 = (AutomationService) this.L$1;
            Iterable iterable3 = (Iterable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i6 = i10;
                automationTrigger2 = automationTrigger5;
                next = obj2;
                automationEvent3 = automationEvent6;
                automationService3 = automationService2;
                iterable2 = iterable3;
                objFire$default = obj;
                ((Boolean) objFire$default).getClass();
                nonCancellable2 = NonCancellable.INSTANCE;
                automationService$onStartCommand$1$1$12 = new AutomationService$onStartCommand$1$1$1(automationService3, automationTrigger2, automationEvent3, i6, null);
                automationService4 = automationService3;
                AutomationEvent automationEvent52 = automationEvent3;
                i = i6;
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable2);
                this.L$1 = automationService4;
                this.L$2 = automationEvent52;
                this.L$3 = it;
                this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                this.L$5 = SpillingKt.nullOutSpilledVariable(automationTrigger2);
                this.I$0 = i;
                this.I$1 = i4;
                this.I$2 = i5;
                this.label = 2;
                if (BuildersKt.withContext(nonCancellable2, automationService$onStartCommand$1$1$12, this) == coroutine_suspended) {
                }
            } catch (Throwable th7) {
                th = th7;
                i3 = i10;
                automationEvent2 = automationEvent6;
                iterable = iterable3;
                automationTrigger = automationTrigger5;
                nonCancellable = NonCancellable.INSTANCE;
                automationService$onStartCommand$1$1$1 = new AutomationService$onStartCommand$1$1$1(automationService2, automationTrigger, automationEvent2, i3, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(automationTrigger);
                this.L$3 = th;
                this.L$4 = null;
                this.L$5 = null;
                this.I$0 = i4;
                this.I$1 = i5;
                this.label = 3;
                if (BuildersKt.withContext(nonCancellable, automationService$onStartCommand$1$1$1, this) == coroutine_suspended) {
                }
                throw th;
            }
        }
    }

    public AutomationService() {
        super("servicesChannel", 87453, 0, 4, null);
        this.tag = "automation";
        this.coroutineContext = AutomationServiceKt.dispatcher.plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new AutomationService$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    private final Notification getNotification(AutomationEvent event, List<? extends AutomationTrigger> triggers) {
        PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) AutomationSettingsActivity.class);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        Unit unit = Unit.INSTANCE;
        PendingIntent activity = companion.get(this, 3232, intent, 134217728).getActivity();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "servicesChannel");
        builder.setSmallIcon(R.drawable.ic_automagic);
        builder.setColor(ColorUtil.i(getApplicationContext(), R.color.tint_notification));
        builder.setShowWhen(false);
        builder.setContentIntent(activity);
        builder.setContentText(Fragment$$ExternalSyntheticOutline1.m(getString(R.string.automation), ": ", event.getEventName(), " -> ", CollectionsKt.joinToString$default(triggers, null, null, null, new AiPrompt$$ExternalSyntheticLambda0(21), 31)));
        Notification notificationBuild = builder.build();
        notificationBuild.getClass();
        return notificationBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getNotification$lambda$1$0(AutomationTrigger automationTrigger) {
        automationTrigger.getClass();
        return automationTrigger.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopIfIamLast() {
        int i = this.counter - 1;
        this.counter = i;
        if (i < 0) {
            this.counter = 0;
        }
        Integer numValueOf = Integer.valueOf(i);
        String strM = Fragment$$ExternalSyntheticOutline1.m(hashCode(), numValueOf.intValue(), "stopIfIamLast: ", " counter=");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        if (numValueOf.intValue() != 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            stopForegroundSelf();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.common.ForegroundService, com.urbandroid.common.LoggingService, android.app.Service
    public void onDestroy() {
        if (this.counter == 0) {
            CoroutineScopeKt.cancel$default(this, null, 1, null);
        }
        super.onDestroy();
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return 2;
        }
        GlobalInitializator.initializeIfRequired(this);
        AutomationEvent.Companion companion = AutomationEvent.INSTANCE;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        AutomationEvent automationEventFromIntent = companion.fromIntent(intent, applicationContext);
        if (automationEventFromIntent == null) {
            return 2;
        }
        AutomationTrigger.Companion companion2 = AutomationTrigger.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        applicationContext2.getClass();
        List<AutomationTrigger> enabledTriggersOrNull = companion2.getEnabledTriggersOrNull(applicationContext2);
        if (enabledTriggersOrNull != null) {
            startForegroundOnce(getNotification(automationEventFromIntent, enabledTriggersOrNull), true);
            int i = this.counter + 1;
            this.counter = i;
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(enabledTriggersOrNull, this, automationEventFromIntent, i, null), 3, null);
            return 2;
        }
        Logger.logWarning(Logger.defaultTag, getTag() + ": No enabled triggers", null);
        startForegroundOnce(getNotification(automationEventFromIntent, CollectionsKt.emptyList()), true);
        stopSelf();
        return 2;
    }
}
