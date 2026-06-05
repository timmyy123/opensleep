package com.urbandroid.sleep.service.google.healthconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.PermissionController;
import androidx.view.result.ActivityResultLauncher;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.ProgressBarJoiner;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.SyncShowcaseViewAsyncTask;
import com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi;
import com.urbandroid.sleep.service.google.healthconnect.session.HealthConnectSession;
import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.HealthManualSynchronizationAction;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.Util$$ExternalSyntheticLambda2;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0014J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010%\u001a\u00020&X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/HealthConnectSyncActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "checkPermissionsAndSync", "onResume", "requestPermissions", "Landroidx/activity/result/ActivityResultLauncher;", "", "getRequestPermissions", "()Landroidx/activity/result/ActivityResultLauncher;", "prepareHealthConnectSynchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", "Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSession;", "synchronizationFromDate", "Ljava/util/Calendar;", "showSyncButton", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthConnectSyncActivity extends BaseActivity implements FeatureLogger, CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private final String tag = "HealthConnect-SyncActivity";
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final ActivityResultLauncher<Set<String>> requestPermissions = registerForActivityResult(PermissionController.Companion.createRequestPermissionResultContract$default(PermissionController.INSTANCE, null, 1, null), new Util$$ExternalSyntheticLambda2(this, 5));

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity$checkPermissionsAndSync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity$checkPermissionsAndSync$1", f = "HealthConnectSyncActivity.kt", l = {73}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HealthConnectSyncActivity.this.new AnonymousClass1(continuation);
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
                CoroutineDispatcher io2 = Dispatchers.getIO();
                HealthConnectSyncActivity$checkPermissionsAndSync$1$permissions$1 healthConnectSyncActivity$checkPermissionsAndSync$1$permissions$1 = new HealthConnectSyncActivity$checkPermissionsAndSync$1$permissions$1(HealthConnectSyncActivity.this, null);
                this.label = 1;
                obj = BuildersKt.withContext(io2, healthConnectSyncActivity$checkPermissionsAndSync$1$permissions$1, this);
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
            HealthConnectApi.Companion companion = HealthConnectApi.INSTANCE;
            boolean zContainsAll = ((Set) obj).containsAll(companion.getRequiredHealthConnectPermission());
            HealthConnectSyncActivity healthConnectSyncActivity = HealthConnectSyncActivity.this;
            if (zContainsAll) {
                healthConnectSyncActivity.showSyncButton();
            } else {
                healthConnectSyncActivity.getRequestPermissions().launch(companion.getHealthConnectAllPermissions());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity$onResume$1", f = "HealthConnectSyncActivity.kt", l = {93}, m = "invokeSuspend", v = 2)
    public static final class C21541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C21541(Continuation<? super C21541> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HealthConnectSyncActivity.this.new C21541(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                HealthConnectSyncActivity$onResume$1$permissions$1 healthConnectSyncActivity$onResume$1$permissions$1 = new HealthConnectSyncActivity$onResume$1$permissions$1(HealthConnectSyncActivity.this, null);
                this.label = 1;
                obj = BuildersKt.withContext(io2, healthConnectSyncActivity$onResume$1$permissions$1, this);
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
            Set set = (Set) obj;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                zza$$ExternalSyntheticOutline0.m("HealthConnect ", (String) it.next());
            }
            CheckBox checkBox = (CheckBox) HealthConnectSyncActivity.this.findViewById(R.id.permission_sleep);
            if (checkBox != null) {
                checkBox.setChecked(set.containsAll(HealthConnectApi.INSTANCE.getRequiredHealthConnectPermission()));
            }
            CheckBox checkBox2 = (CheckBox) HealthConnectSyncActivity.this.findViewById(R.id.permission_hr);
            if (checkBox2 != null) {
                checkBox2.setChecked(set.containsAll(HealthConnectApi.INSTANCE.getHrHealthConnectPermissions()));
            }
            CheckBox checkBox3 = (CheckBox) HealthConnectSyncActivity.this.findViewById(R.id.permission_spo2);
            if (checkBox3 != null) {
                checkBox3.setChecked(set.containsAll(HealthConnectApi.INSTANCE.getSpo2HealthConnectPermissions()));
            }
            return Unit.INSTANCE;
        }
    }

    private final void checkPermissionsAndSync() {
        if (HealthConnectApi.INSTANCE.isAvailable(this)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(HealthConnectSyncActivity healthConnectSyncActivity, View view) {
        Intent intent = new Intent(HealthConnectClient.INSTANCE.getHealthConnectSettingsAction());
        Intent launchIntentForPackage = healthConnectSyncActivity.getPackageManager().getLaunchIntentForPackage("com.google.android.apps.healthdata");
        if (!HealthConnectApi.INSTANCE.isAvailable(healthConnectSyncActivity) || launchIntentForPackage == null) {
            return;
        }
        healthConnectSyncActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HealthSynchronization<HealthConnectSession> prepareHealthConnectSynchronization() {
        HealthConnectApi healthConnectApi = new HealthConnectApi(this);
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        sleepRecordRepository.getClass();
        return new HealthConnectSynchronization(this, healthConnectApi, sleepRecordRepository);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissions$lambda$0(HealthConnectSyncActivity healthConnectSyncActivity, Set set) {
        set.getClass();
        if (set.containsAll(HealthConnectApi.INSTANCE.getRequiredHealthConnectPermission())) {
            ContextExtKt.getSettings(healthConnectSyncActivity).setHealthConnect(true);
            healthConnectSyncActivity.showSyncButton();
            return;
        }
        ContextExtKt.getSettings(healthConnectSyncActivity).setHealthConnect(false);
        Intent launchIntentForPackage = healthConnectSyncActivity.getPackageManager().getLaunchIntentForPackage(HealthDataSourceProvider.HEALTH_CONNECT.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(ClientDefaults.MAX_MSG_SIZE);
            healthConnectSyncActivity.startActivity(launchIntentForPackage);
        } else {
            Toast.makeText(healthConnectSyncActivity, R.string.general_unspecified_error, 0).show();
        }
        healthConnectSyncActivity.recreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSyncButton() {
        new HealthManualSynchronizationAction(HealthServiceProvider.HealthConnect.INSTANCE) { // from class: com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity.showSyncButton.1
            @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
            public boolean isUpdateProgressEvent(HealthSynchronization.ProgressListener.Event event) {
                event.getClass();
                return EnumSet.of(HealthSynchronization.ProgressListener.Event.LOCAL_DB_READ, HealthSynchronization.ProgressListener.Event.HEALTH_READ, HealthSynchronization.ProgressListener.Event.HEALTH_INSERT, HealthSynchronization.ProgressListener.Event.SPORT_TAG_INSERT, HealthSynchronization.ProgressListener.Event.WALKING_AWAKE_PHASE_INSERT, HealthSynchronization.ProgressListener.Event.HEALTH_READ_HEART_RATE, HealthSynchronization.ProgressListener.Event.HEALTH_INSERT_HEART_RATE, HealthSynchronization.ProgressListener.Event.HEALTH_EXPORT_HEART_RATE).contains(event);
            }

            @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
            public ProgressBarJoiner prepareProgressBarJoiner(ProgressBar progressBar) {
                progressBar.getClass();
                return ProgressBarJoiner.from(progressBar, 3, 10, 8, 1, 1, 1, 1, 1);
            }

            @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
            public HealthSynchronization<HealthConnectSession> prepareSynchronization() {
                return HealthConnectSyncActivity.this.prepareHealthConnectSynchronization();
            }
        }.setIsRunningHolder(this.isRunning).synchronizationFromDate(synchronizationFromDate()).show(SyncShowcaseViewAsyncTask.IntegrationApp.Health_Connect);
    }

    private final Calendar synchronizationFromDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, -1825);
        return calendar;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public final ActivityResultLauncher<Set<String>> getRequestPermissions() {
        return this.requestPermissions;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_health_connect_sync);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        TintUtil.tint(this);
        ToolbarUtil.fixTitle(this, 20);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.health_connect);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle(R.string.health_connect);
        checkPermissionsAndSync();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return false;
        }
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//services/health_connect.html");
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Logger.logInfo("HealthConnect onResume()");
        if (HealthConnectApi.INSTANCE.isAvailable(this)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21541(null), 3, null);
            ((Button) findViewById(R.id.edit)).setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 24));
            return;
        }
        CheckBox checkBox = (CheckBox) findViewById(R.id.permission_sleep);
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.permission_spo2);
        if (checkBox2 != null) {
            checkBox2.setChecked(false);
        }
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.permission_hr);
        if (checkBox3 != null) {
            checkBox3.setChecked(false);
        }
        Toast.makeText(this, R.string.health_connect_error, 1).show();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        if (progressBar != null) {
            progressBar.setIndeterminate(!this.isRunning.get());
        }
    }
}
