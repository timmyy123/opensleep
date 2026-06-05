package com.urbandroid.sleep.alarmclock;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.ListPreference;
import android.preference.Preference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.fab.ElevantionAnimator;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SetAlarmSubcategory extends PreferenceActivity implements Preference.OnPreferenceChangeListener {
    protected Alarm alarm;
    private ElevantionAnimator elevantionAnimator;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$0(View view) {
        saveAlarmAndFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$1(View view) {
        finish();
    }

    private void restore(Bundle bundle) {
        if (bundle == null || bundle.getParcelable("alarm") == null) {
            return;
        }
        this.alarm = (Alarm) bundle.getParcelable("alarm");
    }

    private void saveAlarmAndFinish() {
        Intent intent = new Intent();
        intent.putExtra("alarm", (Parcelable) mapToAlarm(this.alarm));
        setResult(-1, intent);
        finish();
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int getContentLayout() {
        return R.layout.activity_set_alarm_subcategory;
    }

    public abstract String getDocUrl();

    public abstract void initPrefs(Alarm alarm);

    public void initValue(ListPreference listPreference, Object obj) {
        Logger.logInfo("SetAlarm: custom screen init " + listPreference.getKey() + " " + obj);
        if (obj == null) {
            listPreference.setValue("-2");
        } else {
            listPreference.setValue(String.valueOf(obj));
        }
    }

    public abstract Alarm mapToAlarm(Alarm alarm);

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        saveAlarmAndFinish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.set_alarm_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle bundle) {
        Logger.logInfo("SetAlarm: Subcategory onCreate");
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.surface_variant));
        restore(bundle);
        EdgeToEdgeUtil.insetsBottom(findViewById(R.id.button_panel));
        if (this.alarm == null) {
            this.alarm = (Alarm) getIntent().getParcelableExtra("alarm");
        }
        initPrefs(this.alarm);
        final int i = 0;
        findViewById(android.R.id.button1).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.SetAlarmSubcategory$$ExternalSyntheticLambda0
            public final /* synthetic */ SetAlarmSubcategory f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                SetAlarmSubcategory setAlarmSubcategory = this.f$0;
                switch (i2) {
                    case 0:
                        setAlarmSubcategory.lambda$onCreatePreference$0(view);
                        break;
                    default:
                        setAlarmSubcategory.lambda$onCreatePreference$1(view);
                        break;
                }
            }
        });
        final int i2 = 1;
        findViewById(android.R.id.closeButton).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.SetAlarmSubcategory$$ExternalSyntheticLambda0
            public final /* synthetic */ SetAlarmSubcategory f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i2;
                SetAlarmSubcategory setAlarmSubcategory = this.f$0;
                switch (i22) {
                    case 0:
                        setAlarmSubcategory.lambda$onCreatePreference$0(view);
                        break;
                    default:
                        setAlarmSubcategory.lambda$onCreatePreference$1(view);
                        break;
                }
            }
        });
        getListView().setItemsCanFocus(true);
        getListView().setNestedScrollingEnabled(true);
        getListView().setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarmSubcategory.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                if (SetAlarmSubcategory.this.elevantionAnimator == null) {
                    SetAlarmSubcategory.this.elevantionAnimator = new ElevantionAnimator(absListView.getContext(), SetAlarmSubcategory.this.findViewById(R.id.toolbar), absListView);
                }
                SetAlarmSubcategory.this.elevantionAnimator.scroll();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i3) {
            }
        });
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            saveAlarmAndFinish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return true;
        }
        ViewIntent.urlCustomTab(this, getDocUrl());
        return true;
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        Logger.logInfo("SetAlarm: onPreferenceChange " + preference.getKey() + " " + obj);
        mapToAlarm(this.alarm);
        return true;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Logger.logInfo("onRestoreInstanceState");
        restore(bundle);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("alarm", this.alarm);
    }
}
