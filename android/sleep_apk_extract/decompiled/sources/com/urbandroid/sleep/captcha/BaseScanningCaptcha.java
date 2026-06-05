package com.urbandroid.sleep.captcha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.captcha.domain.CaptchaChildResult;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.util.IntentUtil;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.location.geocell.GeocellUtils;
import com.urbandroid.sleep.location.geocell.Point;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseScanningCaptcha<T> extends AbstractCaptchaActivity {
    MenuItem deleteMenuItem;
    private CheckBox fallbackCheck;
    private CheckBox homeCheck;
    private TextView learnedText;
    private TextView learnedTextCount;
    private CheckBox multiscanCheck;
    private boolean homeMode = true;
    private boolean multiscanMode = false;
    private boolean fallbackMode = false;
    private Set<String> scannedStrings = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(Settings settings, CompoundButton compoundButton, boolean z) {
        this.fallbackMode = z;
        settings.setCodeCaptchaFallback(z);
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(CompoundButton compoundButton, boolean z) {
        this.multiscanMode = z;
        setMultiscanMode(z);
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(CompoundButton compoundButton, boolean z) {
        if (z && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
            PermissionCompat.requestPermission(this, "android.permission.ACCESS_COARSE_LOCATION", 376);
            return;
        }
        this.homeMode = z;
        setHomeMode(z);
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        Logger.logInfo("Captcha: Scan clicked ");
        userInteraction();
        if (getStoredValues().length != 0) {
            startScanner(false);
            return;
        }
        Logger.logInfo("Captcha: Finishing captcha, nothing learned...");
        Toast.makeText(this, R.string.nothing_learned_toast, 1).show();
        solved();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        Logger.logInfo("Captcha: Learn clicked ");
        startScanner(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5() {
        startScanner(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestPermissionsResult$6(DialogInterface dialogInterface, int i) {
        ViewIntent.showPermissionsSettings(this);
    }

    private void processFallbackResult(Intent intent) {
        CaptchaChildResult childResult = IntentUtil.getChildResult(intent);
        Logger.logInfo("Captcha: fallback result " + childResult);
        if (childResult == null || !childResult.isSolved()) {
            return;
        }
        solved();
    }

    private void setLearnedText() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        String[] storedValues = getStoredValues();
        this.learnedTextCount.setText("");
        if (storedValues.length == 0 || this.captchaSupport.isOperationalMode()) {
            this.multiscanCheck.setEnabled(false);
        }
        if (storedValues.length < 2 || this.captchaSupport.isOperationalMode()) {
            this.multiscanCheck.setEnabled(false);
        } else {
            this.multiscanCheck.setEnabled(true);
        }
        if (storedValues.length == 0) {
            this.learnedText.setText("-");
        } else {
            if (storedValues.length > 1) {
                this.learnedTextCount.setText(MqttTopic.SINGLE_LEVEL_WILDCARD + getString(R.string.xmore, String.valueOf(storedValues.length - 1)));
            }
            this.learnedText.setText(storedValues[0]);
            if (this.deleteMenuItem != null) {
                boolean zIsConfigurationMode = this.captchaSupport.isConfigurationMode();
                MenuItem menuItem = this.deleteMenuItem;
                if (zIsConfigurationMode) {
                    menuItem.setVisible(true);
                } else {
                    menuItem.setVisible(false);
                }
            }
        }
        TextView textView = (TextView) findViewById(R.id.captcha_code_scan_text);
        if (storedValues.length == 0) {
            textView.setText(getString(R.string.button_ok));
        } else {
            textView.setText(getString(R.string.captcha_scan));
        }
        if (!this.captchaSupport.isConfigurationMode()) {
            if (this.multiscanMode) {
                getSupportActionBar().setTitle(this.scannedStrings.size() + " / " + storedValues.length + " " + getResources().getString(getTitleResource()));
            } else {
                getSupportActionBar().setTitle(this.scannedStrings.size() + " / 1 " + getResources().getString(getTitleResource()));
            }
        }
        this.fallbackCheck.setChecked(SharedApplicationContext.getSettings().isCodeCaptchaFallback());
    }

    public abstract void addScannedValue(String str);

    public abstract String convertToMD5(T t);

    public abstract void forgetAllCaptchas();

    public abstract String[] getStoredValues();

    public abstract int getTitleResource();

    public abstract Class getTutorialActivity();

    public abstract boolean isHomeMode();

    public abstract boolean isMultiscanMode();

    public abstract boolean isValueEqual(T t, String str);

    public boolean notAtHome(Point point, String str) {
        String mostFrequentGeo = Tag.getMostFrequentGeo(3);
        if (mostFrequentGeo == null) {
            return false;
        }
        Logger.logInfo("Captcha: Most frequent geo: ".concat(mostFrequentGeo));
        int iPointDistance = (int) GeocellUtils.pointDistance(mostFrequentGeo, point);
        Logger.logInfo("Captcha: " + str + " distance from home: " + iPointDistance + " meters");
        return iPointDistance > 2500;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "Captcha: Scanner result: ", ", ", ", ");
        sbM.append(intent);
        Logger.logInfo(sbM.toString());
        boolean zWasExecutedInLearnMode = wasExecutedInLearnMode(i);
        T scannedValue = parseScannedValue(i, i2, intent);
        if (scannedValue == null) {
            Logger.logInfo("Captcha: No value scanned");
            return;
        }
        String strConvertToMD5 = convertToMD5(scannedValue);
        zza$$ExternalSyntheticOutline0.m("Captcha: NFC Barcode QRCode: MD5 ", strConvertToMD5);
        if (zWasExecutedInLearnMode) {
            addScannedValue(strConvertToMD5);
            setLearnedText();
            if (!this.captchaSupport.isConfigurationMode()) {
                solved();
            }
        } else {
            String[] storedValues = getStoredValues();
            if (storedValues.length != 0) {
                int length = storedValues.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        Toast.makeText(this, R.string.scanned_tag_different, 1).show();
                        break;
                    }
                    String str = storedValues[i3];
                    if (isValueEqual(scannedValue, str)) {
                        zza$$ExternalSyntheticOutline0.m("Captcha: Solved ", str);
                        if (this.multiscanMode) {
                            this.scannedStrings.add(str);
                            StringBuilder sb = new StringBuilder("Captcha: Scanned so far ");
                            sb.append(this.scannedStrings.size());
                            sb.append(" out of ");
                            zza$$ExternalSyntheticOutline0.m(sb, storedValues.length);
                            if (this.scannedStrings.size() == storedValues.length) {
                                solved();
                            }
                        } else {
                            solved();
                        }
                    } else {
                        Logger.logInfo("Captcha: Non match '" + str + "' != '" + scannedValue + "'");
                        i3++;
                    }
                }
            } else {
                Logger.logInfo("Captcha: Learning as it was not stored ");
                addScannedValue(strConvertToMD5);
                solved();
            }
            if (!isSolved() && !this.multiscanMode) {
                Logger.logInfo("Captcha: Not solved yet");
                Toast.makeText(this, R.string.scanned_tag_different, 1).show();
            }
        }
        update();
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        Logger.logInfo("Captcha: onCreate()");
        setContentView(R.layout.captcha_code);
        final Settings settings = new Settings(this);
        this.scannedStrings.clear();
        if (bundle != null) {
            this.scannedStrings = (Set) bundle.get("scanned");
        }
        this.learnedText = (TextView) findViewById(R.id.captcha_code_learned);
        this.learnedTextCount = (TextView) findViewById(R.id.captcha_code_learned_count);
        this.multiscanCheck = (CheckBox) findViewById(R.id.captcha_code_switch);
        this.fallbackCheck = (CheckBox) findViewById(R.id.captcha_code_fallback);
        this.homeCheck = (CheckBox) findViewById(R.id.captcha_code_only_at_home);
        this.fallbackMode = settings.isCodeCaptchaFallback();
        this.fallbackCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.urbandroid.sleep.captcha.BaseScanningCaptcha$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$onCreate$0(settings, compoundButton, z);
            }
        });
        boolean zIsMultiscanMode = isMultiscanMode();
        this.multiscanMode = zIsMultiscanMode;
        this.multiscanCheck.setChecked(zIsMultiscanMode);
        final int i = 0;
        this.multiscanCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.urbandroid.sleep.captcha.BaseScanningCaptcha$$ExternalSyntheticLambda2
            public final /* synthetic */ BaseScanningCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i2 = i;
                BaseScanningCaptcha baseScanningCaptcha = this.f$0;
                switch (i2) {
                    case 0:
                        baseScanningCaptcha.lambda$onCreate$1(compoundButton, z);
                        break;
                    default:
                        baseScanningCaptcha.lambda$onCreate$2(compoundButton, z);
                        break;
                }
            }
        });
        boolean zIsHomeMode = isHomeMode();
        this.homeMode = zIsHomeMode;
        this.homeCheck.setChecked(zIsHomeMode);
        final int i2 = 1;
        this.homeCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.urbandroid.sleep.captcha.BaseScanningCaptcha$$ExternalSyntheticLambda2
            public final /* synthetic */ BaseScanningCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i22 = i2;
                BaseScanningCaptcha baseScanningCaptcha = this.f$0;
                switch (i22) {
                    case 0:
                        baseScanningCaptcha.lambda$onCreate$1(compoundButton, z);
                        break;
                    default:
                        baseScanningCaptcha.lambda$onCreate$2(compoundButton, z);
                        break;
                }
            }
        });
        setLearnedText();
        View viewFindViewById = findViewById(R.id.captcha_code_scan);
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.captcha.BaseScanningCaptcha$$ExternalSyntheticLambda4
            public final /* synthetic */ BaseScanningCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                BaseScanningCaptcha baseScanningCaptcha = this.f$0;
                switch (i3) {
                    case 0:
                        baseScanningCaptcha.lambda$onCreate$3(view);
                        break;
                    default:
                        baseScanningCaptcha.lambda$onCreate$4(view);
                        break;
                }
            }
        });
        if (this.captchaSupport.isConfigurationMode()) {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = findViewById(R.id.captcha_code_learn);
        final String[] storedValues = getStoredValues();
        if (this.captchaSupport.isConfigurationMode() || storedValues.length == 0) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.captcha.BaseScanningCaptcha$$ExternalSyntheticLambda4
                public final /* synthetic */ BaseScanningCaptcha f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i3 = i2;
                    BaseScanningCaptcha baseScanningCaptcha = this.f$0;
                    switch (i3) {
                        case 0:
                            baseScanningCaptcha.lambda$onCreate$3(view);
                            break;
                        default:
                            baseScanningCaptcha.lambda$onCreate$4(view);
                            break;
                    }
                }
            });
        } else {
            viewFindViewById2.setVisibility(8);
            if (findViewById(R.id.code_settings) != null) {
                findViewById(R.id.code_settings).setVisibility(8);
            }
        }
        final View viewFindViewById3 = findViewById(R.id.captcha_code_home_only);
        SleepRecord relatedSleepRecord = getRelatedSleepRecord();
        boolean z = this.captchaSupport.isOperationalMode() && storedValues.length > 0 && isHomeMode();
        boolean zNotAtHome = notAtHome(relatedSleepRecord);
        showSkipButton(viewFindViewById3, false);
        if (z) {
            if (zNotAtHome) {
                Logger.logInfo("Captcha: Did not sleep at home, allow skip");
                showSkipButton(viewFindViewById3, true);
            } else {
                Logger.logInfo("Captcha: update location.");
                LocationService.getLocation(getApplicationContext(), new LocationService.LocationCallback() { // from class: com.urbandroid.sleep.captcha.BaseScanningCaptcha.1
                    @Override // com.urbandroid.sleep.location.LocationService.LocationCallback
                    public void updateLocation(Location location) {
                        if (BaseScanningCaptcha.this.notAtHome(location)) {
                            Logger.logInfo("Captcha: Scan NOT at home, allow skip");
                            BaseScanningCaptcha.this.showSkipButton(viewFindViewById3, true);
                            return;
                        }
                        Logger.logInfo("Captcha: Scan at home");
                        if (BaseScanningCaptcha.this.captchaSupport.isOperationalMode() && storedValues.length > 0 && bundle == null) {
                            Logger.logDebug("Captcha: Auto starting scanner");
                            BaseScanningCaptcha.this.startScanner(false);
                        }
                    }
                });
            }
        } else if (this.captchaSupport.isOperationalMode() && storedValues.length > 0 && bundle == null) {
            Logger.logDebug("Captcha: Auto starting scanner");
            this.h.postDelayed(new BaseScanningCaptcha$$ExternalSyntheticLambda6(this, i), 500L);
        }
        update();
        if (!this.captchaSupport.isOperationalMode() && storedValues.length == 0 && showTutorial()) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) getTutorialActivity()));
        }
        getSupportActionBar().setTitle(getResources().getString(getTitleResource()));
        if (getIntent() == null || !getIntent().hasExtra("extra_fallback")) {
            processFallbackResult(getIntent());
        } else {
            Logger.logInfo("Captcha: extra fallback");
            startFallback();
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.code_captcha_menu, menu);
        this.deleteMenuItem = menu.findItem(R.id.menu_item_delete);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_doc);
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_fallback);
        if (!this.fallbackMode && (getCaptchaSupport().isPreviewMode() || getCaptchaSupport().isOperationalMode())) {
            menuItemFindItem2.setVisible(false);
        }
        if (!this.captchaSupport.isConfigurationMode() || getStoredValues() == null || getStoredValues().length > 0 || AlarmKlaxon.isRunning()) {
            this.deleteMenuItem.setVisible(false);
            menuItemFindItem.setVisible(false);
        }
        update();
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.logInfo("Captcha: newIntent");
        if (intent == null || !intent.hasExtra("extra_fallback")) {
            processFallbackResult(intent);
        } else {
            Logger.logInfo("Captcha: extra fallback");
            startFallback();
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_doc) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) getTutorialActivity()));
            return true;
        }
        if (itemId == R.id.menu_fallback) {
            startFallback();
            return true;
        }
        if (itemId != R.id.menu_item_delete) {
            return true;
        }
        if (AlarmKlaxon.isRunning()) {
            Toast.makeText(this, R.string.general_unspecified_error, 0).show();
        } else {
            DialogUtil.fixButtonsAndDivider(new MaterialAlertDialogBuilder(this).setMessage(R.string.realy_delete_confirm_generic).setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.captcha.BaseScanningCaptcha.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseScanningCaptcha.this.forgetAllCaptchas();
                    BaseScanningCaptcha.this.update();
                }
            }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show(), R.color.white);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 376) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            DialogUtil.fixButtonsAndDivider(new MaterialAlertDialogBuilder(this).setTitle(R.string.no_permission).setMessage((CharSequence) ViewIntent.getNoPermissionText(this, "android.permission-group.LOCATION", R.string.only_at_home)).setPositiveButton(R.string.settings, (DialogInterface.OnClickListener) new NFCCaptcha$$ExternalSyntheticLambda0(this, 2)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null).show(), R.color.white);
            this.homeMode = false;
            setHomeMode(false);
        } else {
            this.homeMode = true;
            setHomeMode(true);
        }
        update();
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        update();
        this.captchaSupport.setRemainingTimeListener(this.remainingTimeListener);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("scanned", (Serializable) this.scannedStrings);
    }

    public abstract T parseScannedValue(int i, int i2, Intent intent);

    public abstract void setHomeMode(boolean z);

    public abstract void setMultiscanMode(boolean z);

    public void showSkipButton(View view, boolean z) {
        if (!z) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.BaseScanningCaptcha.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BaseScanningCaptcha.this.solved();
                }
            });
        }
    }

    public abstract boolean showTutorial();

    public void startFallback() {
        CaptchaInfo captchaInfoFindById = SharedApplicationContext.getCaptchaManager().getFinder().findById(2);
        if (captchaInfoFindById == null) {
            Logger.logSevere("No captcha info");
            return;
        }
        try {
            getCaptchaSupport().getLauncher().difficulty(Math.max(getDifficulty() * 100, 100)).mode(getCaptchaSupport().getMode()).addFlags(131072).start(captchaInfoFindById);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public abstract void startScanner(boolean z);

    public abstract boolean wasExecutedInLearnMode(int i);

    public boolean notAtHome(SleepRecord sleepRecord) {
        if (sleepRecord == null || sleepRecord.getGeo() == null) {
            return false;
        }
        return notAtHome(GeocellUtils.computeBox(sleepRecord.getGeo()).center(), "record: " + sleepRecord.getFromTime());
    }

    public boolean notAtHome(Location location) {
        if (location == null) {
            return false;
        }
        return notAtHome(new Point(location.getLat(), location.getLon()), "Current Loc: " + location);
    }
}
