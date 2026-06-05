package com.urbandroid.sleep.service.google.fit;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.fitness.FitnessOptions;
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
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.SyncShowcaseViewAsyncTask;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApi;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApiFactory;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitExtKt;
import com.urbandroid.sleep.service.google.fit.session.GoogleFitSession;
import com.urbandroid.sleep.service.health.HealthManualSynchronizationAction;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.util.SleepPermissionCompat;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0014J\"\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\f\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/GoogleFitAuthorizationActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "client", "Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApi;", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "permissionsOk", "onStart", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "prepareFitSynchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", "synchronizationFromDate", "Ljava/util/Calendar;", "showSynchronizeButton", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleFitAuthorizationActivity extends BaseActivity implements FeatureLogger {
    private GoogleSignInAccount account;
    private GoogleFitApi client;
    private final String tag = "fit-settings";
    private final AtomicBoolean isRunning = new AtomicBoolean(false);

    private final void permissionsOk() {
        setTitle(getString(R.string.share_connected, getString(R.string.google_fit)));
        ContextExtKt.getSettings(this).resetGoogleFitConnectFailureCount();
        showSynchronizeButton();
        ContextExtKt.getSettings(this).setGoogleFit(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HealthSynchronization<?> prepareFitSynchronization() {
        GoogleFitApiFactory googleFitApiFactory = new GoogleFitApiFactory();
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        GoogleSignInAccount googleSignInAccount = this.account;
        if (googleSignInAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("account");
            googleSignInAccount = null;
        }
        GoogleFitApi googleFitApiCreate = googleFitApiFactory.create(applicationContext, googleSignInAccount);
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        sleepRecordRepository.getClass();
        return new GoogleFitSynchronization((Activity) this, (HealthApi<GoogleFitSession>) googleFitApiCreate, (ISleepRecordRepository) sleepRecordRepository);
    }

    private final void showSynchronizeButton() {
        new HealthManualSynchronizationAction(HealthServiceProvider.GoogleFit.INSTANCE) { // from class: com.urbandroid.sleep.service.google.fit.GoogleFitAuthorizationActivity.showSynchronizeButton.1
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
            public HealthSynchronization<?> prepareSynchronization() {
                return GoogleFitAuthorizationActivity.this.prepareFitSynchronization();
            }
        }.setIsRunningHolder(this.isRunning).synchronizationFromDate(synchronizationFromDate()).show(SyncShowcaseViewAsyncTask.IntegrationApp.Google_Fit);
    }

    private final Calendar synchronizationFromDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, -SharedApplicationContext.getSettings().getGoogleFitSyncManualDays(1825));
        return calendar;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        if (requestCode != 66) {
            if (requestCode != 2) {
                super.onActivityResult(requestCode, resultCode, data2);
                return;
            }
            String strM = FileInsert$$ExternalSyntheticOutline0.m(resultCode, "Fit HR OAUTH Result: ");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            return;
        }
        if (resultCode == -1) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": permissions approved success", null);
            permissionsOk();
            SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
            if (sleepPermissionCompat.isPermissionGranted(this, "android.permission.BODY_SENSORS")) {
                return;
            }
            sleepPermissionCompat.requestPermission(this, "android.permission.BODY_SENSORS", 972);
            return;
        }
        if (resultCode == 0) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": permissions not approved/canceled", null);
            ContextExtKt.getSettings(this).setGoogleFit(false);
            Toast.makeText(this, R.string.no_permission, 1).show();
            finish();
            return;
        }
        String strM2 = FileInsert$$ExternalSyntheticOutline0.m(resultCode, "permissions not approved - code: ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM2, null);
        ContextExtKt.getSettings(this).setGoogleFit(false);
        Toast.makeText(this, R.string.no_permission, 1).show();
        finish();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_fit_connect);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        TintUtil.tint(this);
        ToolbarUtil.fixTitle(this, 20);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.google_fit);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle(R.string.google_fit);
        FitnessOptions fitnessOptions = GoogleFitConstantsKt.fitnessOptions(true);
        GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder().requestEmail().addExtension(fitnessOptions).build();
        googleSignInOptionsBuild.getClass();
        GoogleSignIn.getClient((Activity) this, googleSignInOptionsBuild).signOut();
        GoogleSignInAccount accountForExtension = GoogleSignIn.getAccountForExtension(getApplicationContext(), fitnessOptions);
        accountForExtension.getClass();
        this.account = accountForExtension;
        GoogleSignInAccount googleSignInAccount = null;
        if (accountForExtension == null) {
            Intrinsics.throwUninitializedPropertyAccessException("account");
            accountForExtension = null;
        }
        if (GoogleFitExtKt.hasPermissions(accountForExtension, fitnessOptions)) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": has permissions", null);
            permissionsOk();
        } else {
            Logger.logInfo(Logger.defaultTag, getTag() + ": no permissions", null);
            GoogleSignInAccount googleSignInAccount2 = this.account;
            if (googleSignInAccount2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("account");
                googleSignInAccount2 = null;
            }
            GoogleSignIn.requestPermissions(this, 66, googleSignInAccount2, fitnessOptions);
        }
        GoogleFitApiFactory googleFitApiFactory = new GoogleFitApiFactory();
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        GoogleSignInAccount googleSignInAccount3 = this.account;
        if (googleSignInAccount3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("account");
        } else {
            googleSignInAccount = googleSignInAccount3;
        }
        this.client = googleFitApiFactory.create(applicationContext, googleSignInAccount);
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
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//services/google_fit.html");
        return true;
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
