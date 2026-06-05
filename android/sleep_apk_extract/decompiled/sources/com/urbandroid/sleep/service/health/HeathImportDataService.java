package com.urbandroid.sleep.service.health;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.fitness.FitnessOptions;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.ForegroundService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.calendar.CalendarKt;
import com.urbandroid.sleep.service.google.fit.GoogleFitConstantsKt;
import com.urbandroid.sleep.service.google.fit.GoogleFitSynchronizationFactory;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApiFactory;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitExtKt;
import com.urbandroid.sleep.service.google.healthconnect.HealthConnectSynchronization;
import com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.samsung.shealth.NotifySHealthConnectionCallback;
import com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthSynchronization;
import com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi;
import com.urbandroid.util.ColorUtil;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/service/health/HeathImportDataService;", "Lcom/urbandroid/common/ForegroundService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "handler", "Landroid/os/Handler;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "onStartCommand", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "flags", "startId", "getNotification", "Landroid/app/Notification;", "provider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "progress", "onDestroy", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeathImportDataService extends ForegroundService implements CoroutineScope, FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HealthSynchronization<?> synchronization;
    private final CoroutineContext coroutineContext;
    private final Handler handler;
    private final String tag;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/service/health/HeathImportDataService$Companion;", "", "<init>", "()V", "synchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "provider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context, HealthServiceProvider provider) {
            context.getClass();
            provider.getClass();
            if (SetsKt.setOf((Object[]) new HealthServiceProvider[]{HealthServiceProvider.GoogleFit.INSTANCE, HealthServiceProvider.SamsungSHealth.INSTANCE, HealthServiceProvider.HealthConnect.INSTANCE}).contains(provider)) {
                Intent intent = new Intent(context, (Class<?>) HeathImportDataService.class);
                intent.putExtra("provider-name", provider.getClass().getSimpleName());
                ContextExtKt.startBindForegroundServiceWithLog(context, intent);
            } else {
                Logger.logWarning("unsupported producer " + provider + " for import", null);
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.health.HeathImportDataService$onStartCommand$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.health.HeathImportDataService$onStartCommand$1", f = "HeathImportDataService.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HealthServiceProvider $provider;
        int label;
        final /* synthetic */ HeathImportDataService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HealthServiceProvider healthServiceProvider, HeathImportDataService heathImportDataService, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$provider = healthServiceProvider;
            this.this$0 = heathImportDataService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$provider, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0165 A[Catch: all -> 0x008b, TRY_LEAVE, TryCatch #0 {all -> 0x008b, blocks: (B:5:0x0013, B:7:0x0028, B:9:0x003f, B:15:0x008e, B:23:0x0108, B:27:0x0121, B:29:0x0165, B:16:0x00af, B:18:0x00b7, B:20:0x00e0, B:22:0x00e8, B:32:0x01a7), top: B:38:0x0013 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            HealthSynchronization healthConnectSynchronization;
            HealthSynchronization healthSynchronizationCreate;
            HealthSynchronization healthSynchronization;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            try {
                DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
                Companion companion = HeathImportDataService.INSTANCE;
                HealthServiceProvider healthServiceProvider = this.$provider;
                HealthServiceProvider.GoogleFit googleFit = HealthServiceProvider.GoogleFit.INSTANCE;
                if (Intrinsics.areEqual(healthServiceProvider, googleFit)) {
                    FitnessOptions fitnessOptions = GoogleFitConstantsKt.fitnessOptions(true);
                    GoogleSignInAccount accountForExtension = GoogleSignIn.getAccountForExtension(this.this$0.getApplicationContext(), fitnessOptions);
                    accountForExtension.getClass();
                    if (!GoogleFitExtKt.hasPermissions(accountForExtension, fitnessOptions)) {
                        HeathImportDataService heathImportDataService = this.this$0;
                        Logger.logInfo(Logger.defaultTag, heathImportDataService.getTag() + ": no permissions", null);
                        unit = Unit.INSTANCE;
                        HeathImportDataService.synchronization = null;
                        HeathImportDataService heathImportDataService2 = this.this$0;
                        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(this.$provider.getName(), " finished");
                        Logger.logInfo(Logger.defaultTag, heathImportDataService2.getTag() + ": " + strM$1, null);
                        this.this$0.stopForegroundSelf();
                        return unit;
                    }
                    GoogleFitApiFactory googleFitApiFactory = new GoogleFitApiFactory();
                    Context applicationContext = this.this$0.getApplicationContext();
                    applicationContext.getClass();
                    healthSynchronizationCreate = GoogleFitSynchronizationFactory.getInstance().create(this.this$0.getApplicationContext(), googleFitApiFactory.create(applicationContext, accountForExtension), sleepRecordRepository);
                    healthSynchronizationCreate.setManual(false);
                    healthSynchronizationCreate.setImportMode(true);
                    HeathImportDataService.synchronization = healthSynchronizationCreate;
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(1, !Intrinsics.areEqual(this.$provider, googleFit) ? -3 : -7);
                    HeathImportDataService heathImportDataService3 = this.this$0;
                    String str = this.$provider.getName() + " from " + CalendarKt.getPrettyDate(calendar);
                    Logger.logInfo(Logger.defaultTag, heathImportDataService3.getTag() + ": " + str, null);
                    healthSynchronization = HeathImportDataService.synchronization;
                    if (healthSynchronization != null) {
                        Date time = calendar.getTime();
                        final HeathImportDataService heathImportDataService4 = this.this$0;
                        final HealthServiceProvider healthServiceProvider2 = this.$provider;
                        healthSynchronization.synchronize(time, new HealthSynchronization.ProgressListener() { // from class: com.urbandroid.sleep.service.health.HeathImportDataService.onStartCommand.1.2
                            private HealthSynchronization.ProgressListener.Event currentEvent;
                            private int from;

                            @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                            public void end(HealthServiceProvider provider, HealthSynchronization.ProgressListener.Event event) {
                                provider.getClass();
                                event.getClass();
                                ContextExtKt.sendExplicitBroadcast$default(heathImportDataService4, new Intent("com.urbandroid.sleep.ACTION_DASHBOARD_REFRESH"), null, 2, null);
                            }

                            @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                            public void progress(HealthServiceProvider provider, int currentItem, int numberOfItems) {
                                provider.getClass();
                                if (numberOfItems == 0 || this.currentEvent == null || HeathImportDataService.synchronization == null) {
                                    return;
                                }
                                HeathImportDataService.onStartCommand$updateNotification(heathImportDataService4, healthServiceProvider2, this.from + ((int) (((double) ((currentItem * 100) / numberOfItems)) * 0.5d)));
                            }

                            @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                            public void start(HealthServiceProvider provider, HealthSynchronization.ProgressListener.Event event, int numberOfItems) {
                                provider.getClass();
                                event.getClass();
                                HealthSynchronization.ProgressListener.Event event2 = HealthSynchronization.ProgressListener.Event.LOCAL_DB_INSERT;
                                this.currentEvent = SetsKt.setOf((Object[]) new HealthSynchronization.ProgressListener.Event[]{event2, HealthSynchronization.ProgressListener.Event.HEALTH_READ}).contains(event) ? event : null;
                                if (event == event2) {
                                    this.from = 50;
                                    if (HeathImportDataService.synchronization != null) {
                                        HeathImportDataService.onStartCommand$updateNotification(heathImportDataService4, healthServiceProvider2, this.from);
                                    }
                                }
                            }

                            @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                            public void end(HealthServiceProvider provider) {
                                provider.getClass();
                                if (HeathImportDataService.synchronization != null) {
                                    HeathImportDataService.onStartCommand$updateNotification(heathImportDataService4, healthServiceProvider2, 100);
                                }
                            }

                            @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                            public void start(HealthServiceProvider provider) {
                                provider.getClass();
                                if (HeathImportDataService.synchronization != null) {
                                    HeathImportDataService.onStartCommand$updateNotification(heathImportDataService4, healthServiceProvider2, 0);
                                }
                            }
                        });
                    }
                    HeathImportDataService.synchronization = null;
                    HeathImportDataService heathImportDataService5 = this.this$0;
                    String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(this.$provider.getName(), " finished");
                    Logger.logInfo(Logger.defaultTag, heathImportDataService5.getTag() + ": " + strM$12, null);
                    this.this$0.stopForegroundSelf();
                    return Unit.INSTANCE;
                }
                if (Intrinsics.areEqual(healthServiceProvider, HealthServiceProvider.SamsungSHealth.INSTANCE)) {
                    healthConnectSynchronization = new SamsungSHealthSynchronization(this.this$0.getApplicationContext(), new SamsungSHealthApi(this.this$0.getApplicationContext(), this.this$0.handler, new NotifySHealthConnectionCallback(this.this$0.getApplicationContext()), true), sleepRecordRepository);
                } else {
                    if (!Intrinsics.areEqual(healthServiceProvider, HealthServiceProvider.HealthConnect.INSTANCE)) {
                        HeathImportDataService heathImportDataService6 = this.this$0;
                        String str2 = "unsupported provider '" + this.$provider + "' for import";
                        Logger.logWarning(Logger.defaultTag, heathImportDataService6.getTag() + ": " + str2, null);
                        this.this$0.stopForegroundSelf();
                        unit = Unit.INSTANCE;
                        HeathImportDataService.synchronization = null;
                        HeathImportDataService heathImportDataService7 = this.this$0;
                        String strM$13 = FileInsert$$ExternalSyntheticOutline0.m$1(this.$provider.getName(), " finished");
                        Logger.logInfo(Logger.defaultTag, heathImportDataService7.getTag() + ": " + strM$13, null);
                        this.this$0.stopForegroundSelf();
                        return unit;
                    }
                    Context applicationContext2 = this.this$0.getApplicationContext();
                    applicationContext2.getClass();
                    HealthConnectApi healthConnectApi = new HealthConnectApi(applicationContext2);
                    Context applicationContext3 = this.this$0.getApplicationContext();
                    applicationContext3.getClass();
                    sleepRecordRepository.getClass();
                    healthConnectSynchronization = new HealthConnectSynchronization(applicationContext3, healthConnectApi, sleepRecordRepository);
                }
                healthSynchronizationCreate = healthConnectSynchronization;
                healthSynchronizationCreate.setManual(false);
                healthSynchronizationCreate.setImportMode(true);
                HeathImportDataService.synchronization = healthSynchronizationCreate;
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, !Intrinsics.areEqual(this.$provider, googleFit) ? -3 : -7);
                HeathImportDataService heathImportDataService32 = this.this$0;
                String str3 = this.$provider.getName() + " from " + CalendarKt.getPrettyDate(calendar2);
                Logger.logInfo(Logger.defaultTag, heathImportDataService32.getTag() + ": " + str3, null);
                healthSynchronization = HeathImportDataService.synchronization;
                if (healthSynchronization != null) {
                }
                HeathImportDataService.synchronization = null;
                HeathImportDataService heathImportDataService52 = this.this$0;
                String strM$122 = FileInsert$$ExternalSyntheticOutline0.m$1(this.$provider.getName(), " finished");
                Logger.logInfo(Logger.defaultTag, heathImportDataService52.getTag() + ": " + strM$122, null);
                this.this$0.stopForegroundSelf();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                HeathImportDataService.synchronization = null;
                HeathImportDataService heathImportDataService8 = this.this$0;
                String strM$14 = FileInsert$$ExternalSyntheticOutline0.m$1(this.$provider.getName(), " finished");
                Logger.logInfo(Logger.defaultTag, heathImportDataService8.getTag() + ": " + strM$14, null);
                this.this$0.stopForegroundSelf();
                throw th;
            }
        }
    }

    public HeathImportDataService() {
        super("servicesChannel", 66453, 0, 4, null);
        this.tag = "import";
        this.handler = new Handler();
        this.coroutineContext = Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new HeathImportDataService$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    private final Notification getNotification(HealthServiceProvider provider, int progress) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) HeathImportDataService.class);
        intent.putExtra("cancel", true);
        PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        PendingIntent foregroundService = companion.get(applicationContext, 272666230, intent, 134217728).getForegroundService();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "servicesChannel");
        builder.setSmallIcon(R.drawable.ic_cloud);
        builder.setColor(ColorUtil.i(getApplicationContext(), R.color.tint_notification));
        builder.setShowWhen(false);
        builder.setContentTitle(getApplicationContext().getString(provider.getTitleRes()) + " " + getString(R.string.importing) + " " + progress + " %");
        builder.setProgress(100, progress, false);
        builder.addAction(R.drawable.ic_action_cancel, getString(R.string.cancel), foregroundService);
        Notification notificationBuild = builder.build();
        notificationBuild.getClass();
        return notificationBuild;
    }

    public static /* synthetic */ Notification getNotification$default(HeathImportDataService heathImportDataService, HealthServiceProvider healthServiceProvider, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return heathImportDataService.getNotification(healthServiceProvider, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStartCommand$updateNotification(HeathImportDataService heathImportDataService, HealthServiceProvider healthServiceProvider, int i) {
        Context applicationContext = heathImportDataService.getApplicationContext();
        applicationContext.getClass();
        NotificationsKt.notify(applicationContext, 66453, heathImportDataService.getNotification(healthServiceProvider, i));
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
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return 2;
        }
        GlobalInitializator.initializeIfRequired(this);
        if (intent.getBooleanExtra("cancel", false)) {
            HealthSynchronization<?> healthSynchronization = synchronization;
            if (healthSynchronization != null) {
                healthSynchronization.interrupt();
            }
            synchronization = null;
            ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.ACTION_DASHBOARD_REFRESH"), null, 2, null);
            stopForegroundSelf();
            return 2;
        }
        HealthServiceProvider healthServiceProviderFindOrNull = HealthServiceProvider.INSTANCE.findOrNull(intent.getStringExtra("provider-name"));
        if (healthServiceProviderFindOrNull == null) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("provider-name parameter not correct or found at intent - ", ContextExtKt.stringify$default(intent, null, 1, null));
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM, null);
            return 2;
        }
        if (!SetsKt.setOf((Object[]) new HealthServiceProvider[]{HealthServiceProvider.GoogleFit.INSTANCE, HealthServiceProvider.SamsungSHealth.INSTANCE, HealthServiceProvider.HealthConnect.INSTANCE}).contains(healthServiceProviderFindOrNull)) {
            String str = "unsupported provider '" + healthServiceProviderFindOrNull + "' for import";
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + str, null);
            return 2;
        }
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        if (!healthServiceProviderFindOrNull.isEnabled(applicationContext)) {
            String strM2 = FileInsert$$ExternalSyntheticOutline0.m("provider ", healthServiceProviderFindOrNull.getName(), " is not enabled - import rejected");
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM2, null);
            return 2;
        }
        if (synchronization == null) {
            startForegroundOnce(getNotification$default(this, healthServiceProviderFindOrNull, 0, 2, null), true);
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(healthServiceProviderFindOrNull, this, null), 3, null);
            return 2;
        }
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(healthServiceProviderFindOrNull.getName(), " sync already running");
        Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM$1, null);
        return 2;
    }
}
