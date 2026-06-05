package com.urbandroid.sleep.captcha;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.captcha.agentsheep.AgentSheepCaptcha;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractCaptchaActivity extends BaseActivity {
    public static boolean SHOWN = false;
    private MenuItem alarmResumeMenuItem;
    private TextView alarmResumeText;
    protected CaptchaSupport captchaSupport;
    private SleepRecord relatedSleepRecord;
    private boolean solved = false;
    private long startTs = -1;
    private long lastIntercation = -1;
    protected final RemainingTimeListener remainingTimeListener = new RemainingTimeListener() { // from class: com.urbandroid.sleep.captcha.AbstractCaptchaActivity.2
        @Override // com.urbandroid.sleep.captcha.RemainingTimeListener
        public void timeRemain(int i, int i2) {
            AbstractCaptchaActivity abstractCaptchaActivity = AbstractCaptchaActivity.this;
            if (i >= i2) {
                abstractCaptchaActivity.alarmResumeText.setVisibility(8);
                if (AbstractCaptchaActivity.this.alarmResumeMenuItem != null) {
                    AbstractCaptchaActivity.this.alarmResumeMenuItem.setVisible(false);
                    return;
                }
                return;
            }
            abstractCaptchaActivity.alarmResumeText.setVisibility(0);
            AbstractCaptchaActivity.this.alarmResumeText.setText(String.valueOf(i));
            AbstractCaptchaActivity.this.alarmResumeText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.silent_white, 0, 0, 0);
            AbstractCaptchaActivity.this.alarmResumeText.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.AbstractCaptchaActivity.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AbstractCaptchaActivity.this.addTime();
                }
            });
            if (AbstractCaptchaActivity.this.alarmResumeMenuItem != null) {
                AbstractCaptchaActivity.this.alarmResumeMenuItem.setVisible(true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void addTime() {
        this.captchaSupport.alive();
        Toast.makeText(this, getString(R.string.button_tracking_add_time, 1), 0).show();
    }

    private void lockOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (getResources().getConfiguration().orientation == 1) {
            if (rotation == 1 || rotation == 2) {
                setRequestedOrientation(9);
                return;
            } else {
                setRequestedOrientation(1);
                return;
            }
        }
        if (rotation == 1 || rotation == 2) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(8);
        }
    }

    public void alive() {
        userInteraction();
    }

    public CaptchaSupport getCaptchaSupport() {
        return this.captchaSupport;
    }

    public int getDifficulty() {
        return this.captchaSupport.getDifficulty();
    }

    public SleepRecord getRelatedSleepRecord() {
        if (this.relatedSleepRecord == null) {
            SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
            this.relatedSleepRecord = record;
            if (record == null) {
                Calendar calendar = Calendar.getInstance();
                long timeInMillis = calendar.getTimeInMillis();
                calendar.add(10, -16);
                List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(calendar.getTimeInMillis(), timeInMillis, false);
                if (sleepRecords == null || sleepRecords.size() == 0) {
                    return null;
                }
                Collections.sort(sleepRecords, new Comparator<SleepRecord>() { // from class: com.urbandroid.sleep.captcha.AbstractCaptchaActivity.1
                    @Override // java.util.Comparator
                    public int compare(SleepRecord sleepRecord, SleepRecord sleepRecord2) {
                        return sleepRecord.getNotNullTo().compareTo(sleepRecord2.getTo()) * (-1);
                    }
                });
                this.relatedSleepRecord = sleepRecords.get(0);
                Logger.logInfo("DreamDiary: record " + this.relatedSleepRecord);
            }
        }
        return this.relatedSleepRecord;
    }

    public boolean isSolved() {
        return this.solved;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Logger.logInfo("Captcha: Leaving captcha after back pressed");
        this.captchaSupport.unsolved();
        finish();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this, ColorUtil.i(this, R.color.bar_dark));
        this.captchaSupport = CaptchaSupportFactory.create(this).setRemainingTimeListener(this.remainingTimeListener);
        setTitle(R.string.captcha_preferene_title);
        if (SharedApplicationContext.getSettings().isDisableScreenRotate() && getClass() != AgentSheepCaptcha.class) {
            lockOrientation();
        }
        getWindow().addFlags(128);
        KeyguardUtil.disable(this);
        this.alarmResumeText = (TextView) InflatorUtil.get(this).inflate(R.layout.captcha_resume_alarm, (ViewGroup) null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -1, 21);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(this.alarmResumeText, layoutParams);
        getSupportActionBar().setElevation(0.0f);
        getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.empty_ab));
        Settings.setGoodTimeToRate(false);
        this.startTs = System.currentTimeMillis();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.captcha_menu, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_item_plus5);
        this.alarmResumeMenuItem = menuItemFindItem;
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(false);
            this.alarmResumeMenuItem.setTitle(getString(R.string.button_tracking_add_time, 1));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.captchaSupport.destroy();
        super.onDestroy();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_item_plus5) {
            return true;
        }
        addTime();
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!isSolved() || getIntent() == null || getIntent().getIntExtra("captchaParentId", 0) == 0) {
            SHOWN = false;
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SHOWN = true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ContextExtKt.sendExplicitBroadcast(this, new Intent(CaptchaCallbackReceiver.CAPTCHA_ACTION_START));
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CaptchaCallbackReceiver.CAPTCHA_ACTION_UPDATE));
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ContextExtKt.sendExplicitBroadcast(this, new Intent(CaptchaCallbackReceiver.CAPTCHA_ACTION_STOP));
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CaptchaCallbackReceiver.CAPTCHA_ACTION_UPDATE));
    }

    public void solved() {
        Logger.logInfo("Captcha: Captcha solved.");
        this.solved = true;
        this.captchaSupport.solved();
        new Settings(this).setLastCaptchaSolvedTimestampNow();
        finish();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.startTs;
        if (jCurrentTimeMillis <= 5000 || jCurrentTimeMillis >= 30000 || TrialFilter.getInstance().isTimeToShowInterstitialAds()) {
            return;
        }
        Settings.setGoodTimeToRate(true);
    }

    public void userInteraction() {
        Logger.logInfo("CAPTCHA: user interaction!");
        if (this.lastIntercation != -1 || System.currentTimeMillis() - this.lastIntercation <= 1000) {
            return;
        }
        this.captchaSupport.alive();
    }
}
