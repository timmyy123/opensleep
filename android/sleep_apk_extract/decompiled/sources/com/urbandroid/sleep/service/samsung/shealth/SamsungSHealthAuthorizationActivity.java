package com.urbandroid.sleep.service.samsung.shealth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult;
import com.samsung.android.sdk.healthdata.HealthPermissionManager;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.ProgressBarJoiner;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.SyncShowcaseViewAsyncTask;
import com.urbandroid.sleep.service.health.HealthManualSynchronizationAction;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi;
import com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthConnectionListener;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class SamsungSHealthAuthorizationActivity extends BaseActivity implements SamsungSHealthConnectionListener {
    private SamsungSHealthApi client;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final AtomicBoolean isAlive = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean permissionAllowed(Set<HealthPermissionManager.PermissionKey> set, Map<HealthPermissionManager.PermissionKey, Boolean> map) {
        for (HealthPermissionManager.PermissionKey permissionKey : set) {
            if (!map.containsKey(permissionKey) || !map.get(permissionKey).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SamsungSHealthSynchronization prepareSHealthSynchronization() {
        return new SamsungSHealthSynchronization(getApplicationContext(), new SamsungSHealthApi(getApplicationContext(), new Handler(), this, true), SharedApplicationContext.getInstance().getSleepRecordRepository());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestMandatoryPermissions(final Settings settings) {
        this.client.requestPermissions(this, SamsungSHealthApi.MANDATORY_PERMISSIONS, new SamsungSHealthApi.PermissionListener() { // from class: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthAuthorizationActivity.4
            @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.PermissionListener
            public void permissionFailed() {
                SamsungSHealthAuthorizationActivity.this.finish();
            }

            @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.PermissionListener
            public void permissionResult(Map<HealthPermissionManager.PermissionKey, Boolean> map) {
                boolean zHasPermissions = SamsungSHealthAuthorizationActivity.this.client.hasPermissions(SamsungSHealthApi.MANDATORY_PERMISSIONS);
                boolean zHasPermissions2 = SamsungSHealthAuthorizationActivity.this.client.hasPermissions(SamsungSHealthApi.EXERCISE_PERMISSIONS);
                boolean zHasPermissions3 = SamsungSHealthAuthorizationActivity.this.client.hasPermissions(SamsungSHealthApi.HEART_RATE_PERMISSIONS);
                if (!zHasPermissions && !zHasPermissions2 && !zHasPermissions3) {
                    Logger.logWarning("S-Health permissions failure - Sleep/Exercise/HR not granted");
                    SamsungSHealthAuthorizationActivity.this.finish();
                    return;
                }
                settings.setSamsungSHealth(true);
                SamsungSHealthAuthorizationActivity samsungSHealthAuthorizationActivity = SamsungSHealthAuthorizationActivity.this;
                samsungSHealthAuthorizationActivity.setTitle(samsungSHealthAuthorizationActivity.getString(R.string.share_connected, samsungSHealthAuthorizationActivity.getApplicationContext().getString(R.string.samsung_shealth)));
                Logger.logInfo("S-Health permissions ok");
                SamsungSHealthAuthorizationActivity.this.showSynchronizeButton();
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConnectionFailureDialog(final HealthConnectionErrorResult healthConnectionErrorResult) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        String strM = FileInsert$$ExternalSyntheticOutline0.m("Connection with S Health ", TrialFilter.getInstance().isSamsungSHealth() ? TrialFilter.getInstance().getSamsungSHealthPackageInfo().versionName : "", " is not available");
        if (healthConnectionErrorResult != null) {
            int errorCode = healthConnectionErrorResult.getErrorCode();
            strM = errorCode != 2 ? errorCode != 4 ? errorCode != 6 ? errorCode != 8 ? errorCode != 9 ? strM.concat("\n\nPlease make S Health available") : strM.concat("\n\nPlease agree with S Health policy") : strM.concat(" due to security/signature issue") : strM.concat("\n\nPlease enable S Health") : strM.concat("\n\nPlease upgrade S Health") : strM.concat("\n\nPlease install S Health");
        }
        materialAlertDialogBuilder.setMessage((CharSequence) strM);
        materialAlertDialogBuilder.setPositiveButton(getResources().getText(R.string.button_ok), new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthAuthorizationActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                HealthConnectionErrorResult healthConnectionErrorResult2 = healthConnectionErrorResult;
                if (healthConnectionErrorResult2 != null && healthConnectionErrorResult2.hasResolution()) {
                    try {
                        healthConnectionErrorResult.resolve(SamsungSHealthAuthorizationActivity.this);
                    } catch (ActivityNotFoundException unused) {
                        MaterialAlertDialogBuilder materialAlertDialogBuilder2 = new MaterialAlertDialogBuilder(SamsungSHealthAuthorizationActivity.this);
                        materialAlertDialogBuilder2.setMessage((CharSequence) "Please upgrade S Health");
                        materialAlertDialogBuilder2.setNeutralButton(SamsungSHealthAuthorizationActivity.this.getResources().getText(R.string.button_cancel), new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthAuthorizationActivity.5.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface2, int i2) {
                                SamsungSHealthAuthorizationActivity.this.finish();
                            }
                        });
                        materialAlertDialogBuilder2.show();
                        return;
                    }
                }
                SamsungSHealthAuthorizationActivity.this.finish();
            }
        });
        if (healthConnectionErrorResult != null && healthConnectionErrorResult.hasResolution()) {
            materialAlertDialogBuilder.setNegativeButton(getResources().getText(R.string.button_cancel), new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthAuthorizationActivity.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SamsungSHealthAuthorizationActivity.this.finish();
                }
            });
        }
        if (this.isAlive.get()) {
            materialAlertDialogBuilder.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSynchronizeButton() {
        final Settings settings = SharedApplicationContext.getSettings();
        new HealthManualSynchronizationAction(this, HealthServiceProvider.SamsungSHealth.INSTANCE) { // from class: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthAuthorizationActivity.1
            @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
            public boolean isUpdateProgressEvent(HealthSynchronization.ProgressListener.Event event) {
                return EnumSet.of(HealthSynchronization.ProgressListener.Event.LOCAL_DB_READ, HealthSynchronization.ProgressListener.Event.HEALTH_READ, HealthSynchronization.ProgressListener.Event.HEALTH_INSERT, HealthSynchronization.ProgressListener.Event.SPORT_TAG_INSERT, HealthSynchronization.ProgressListener.Event.WALKING_AWAKE_PHASE_INSERT, HealthSynchronization.ProgressListener.Event.HEALTH_READ_HEART_RATE, HealthSynchronization.ProgressListener.Event.HEALTH_INSERT_HEART_RATE, HealthSynchronization.ProgressListener.Event.HEALTH_EXPORT_HEART_RATE).contains(event);
            }

            @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
            public boolean postSynchronization(Activity activity, boolean z) {
                if (z) {
                    return true;
                }
                settings.setSamsungSHealth(false);
                SamsungSHealthAuthorizationActivity.this.showConnectionFailureDialog(new HealthConnectionErrorResult(8, true));
                return false;
            }

            @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
            public ProgressBarJoiner prepareProgressBarJoiner(ProgressBar progressBar) {
                return ProgressBarJoiner.from(progressBar, 3, 10, 12, 1, 1, 1, 1, 1);
            }

            @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
            public HealthSynchronization<?> prepareSynchronization() {
                return SamsungSHealthAuthorizationActivity.this.prepareSHealthSynchronization();
            }
        }.setIsRunningHolder(this.isRunning).synchronizationFromDate(getSynchronizationFromDate()).show(SyncShowcaseViewAsyncTask.IntegrationApp.Samsung_SHealth);
    }

    public Calendar getSynchronizationFromDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -7);
        return calendar;
    }

    @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthConnectionListener
    public void onConnected(SamsungSHealthApi samsungSHealthApi) {
        Logger.logInfo("S-Health Connection success");
        final Settings settings = SharedApplicationContext.getSettings();
        if (settings.isSamsungSHealth() && getIntent() != null && "com.urbandroid.sleep.samsung.shealth.sleep_stage_permission".equals(getIntent().getAction())) {
            this.client.requestPermissions(this, SamsungSHealthApi.SLEEP_STAGE_PERMISSIONS, new SamsungSHealthApi.PermissionListener() { // from class: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthAuthorizationActivity.2
                @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.PermissionListener
                public void permissionFailed() {
                    SamsungSHealthAuthorizationActivity.this.finish();
                }

                @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.PermissionListener
                public void permissionResult(Map<HealthPermissionManager.PermissionKey, Boolean> map) {
                    HealthPermissionManager.PermissionKey permissionKey = SamsungSHealthApi.SLEEP_STAGE_READ_PERMISSION;
                    int i = 0;
                    boolean z = map.containsKey(permissionKey) && map.get(permissionKey).booleanValue();
                    HealthPermissionManager.PermissionKey permissionKey2 = SamsungSHealthApi.SLEEP_STAGE_WRITE_PERMISSION;
                    boolean z2 = map.containsKey(permissionKey2) && map.get(permissionKey2).booleanValue();
                    Logger.logInfo("S-Health: sleep-stage: hasRead " + z + " hasWrite " + z2);
                    if (z && !z2) {
                        SamsungSHealthApi samsungSHealthApi2 = SamsungSHealthAuthorizationActivity.this.client;
                        SamsungSHealthAuthorizationActivity samsungSHealthAuthorizationActivity = SamsungSHealthAuthorizationActivity.this;
                        samsungSHealthApi2.requestPermission(samsungSHealthAuthorizationActivity, permissionKey2, new SleepStagesPermissionListener(samsungSHealthAuthorizationActivity, i));
                    } else {
                        if (!z2 || z) {
                            SamsungSHealthAuthorizationActivity.this.finish();
                            return;
                        }
                        SamsungSHealthApi samsungSHealthApi3 = SamsungSHealthAuthorizationActivity.this.client;
                        SamsungSHealthAuthorizationActivity samsungSHealthAuthorizationActivity2 = SamsungSHealthAuthorizationActivity.this;
                        samsungSHealthApi3.requestPermission(samsungSHealthAuthorizationActivity2, permissionKey, new SleepStagesPermissionListener(samsungSHealthAuthorizationActivity2, i));
                    }
                }
            }, true);
        }
        if (settings.isSamsungSHealth() && (this.client.hasPermissions(SamsungSHealthApi.SLEEP_PERMISSIONS) || this.client.hasPermissions(SamsungSHealthApi.EXERCISE_PERMISSIONS))) {
            return;
        }
        final Context applicationContext = getApplicationContext();
        this.client.requestPermissions(this, SamsungSHealthApi.ALL_PERMISSIONS, new SamsungSHealthApi.PermissionListener() { // from class: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthAuthorizationActivity.3
            @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.PermissionListener
            public void permissionFailed() {
                SamsungSHealthAuthorizationActivity.this.client.printPermissions();
                Logger.logWarning("S-Health permissions not allowed for Sleep");
                SamsungSHealthAuthorizationActivity.this.finish();
            }

            @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.PermissionListener
            public void permissionResult(Map<HealthPermissionManager.PermissionKey, Boolean> map) {
                SamsungSHealthAuthorizationActivity.this.client.printPermissions();
                if (!SamsungSHealthAuthorizationActivity.this.permissionAllowed(SamsungSHealthApi.MANDATORY_PERMISSIONS, map)) {
                    Logger.logWarning("S-Health mandatory permissions failure - Sleep/Sleep Stages not granted");
                    SamsungSHealthAuthorizationActivity.this.requestMandatoryPermissions(settings);
                    return;
                }
                settings.setSamsungSHealth(true);
                SamsungSHealthAuthorizationActivity samsungSHealthAuthorizationActivity = SamsungSHealthAuthorizationActivity.this;
                samsungSHealthAuthorizationActivity.setTitle(samsungSHealthAuthorizationActivity.getString(R.string.share_connected, applicationContext.getString(R.string.samsung_shealth)));
                Logger.logInfo("S-Health permissions ok");
                SamsungSHealthAuthorizationActivity.this.showSynchronizeButton();
            }
        }, false);
    }

    @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthConnectionListener
    public void onConnectionFailed(HealthConnectionErrorResult healthConnectionErrorResult) {
        Logger.logInfo("Connection failed. Cause: " + healthConnectionErrorResult.toString() + " errCode:" + healthConnectionErrorResult.getErrorCode() + " hasResolution: " + healthConnectionErrorResult.hasResolution());
        showConnectionFailureDialog(healthConnectionErrorResult);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_shealth_connect);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        TintUtil.tint(this);
        ToolbarUtil.fixTitle(this, 20);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.samsung_shealth);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.client = new SamsungSHealthApi(getApplicationContext(), new Handler(), this, false);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return false;
        }
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//services/s_health.html");
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isAlive.set(false);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isAlive.set(true);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        setTitle(R.string.samsung_shealth);
        ((ProgressBar) findViewById(R.id.progress)).setIndeterminate(!this.isRunning.get());
        Logger.logInfo("Connecting...");
        this.client.asynchConnect();
    }

    public class SleepStagesPermissionListener implements SamsungSHealthApi.PermissionListener {
        private SleepStagesPermissionListener() {
        }

        @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.PermissionListener
        public void permissionFailed() {
            SamsungSHealthAuthorizationActivity.this.finish();
        }

        @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.PermissionListener
        public void permissionResult(Map<HealthPermissionManager.PermissionKey, Boolean> map) {
            if (map.containsValue(Boolean.FALSE)) {
                SamsungSHealthAuthorizationActivity.this.finish();
            } else {
                Logger.logInfo("S-Health sleep-stage permissions ok");
                SamsungSHealthAuthorizationActivity.this.showSynchronizeButton();
            }
        }

        public /* synthetic */ SleepStagesPermissionListener(SamsungSHealthAuthorizationActivity samsungSHealthAuthorizationActivity, int i) {
            this();
        }
    }
}
