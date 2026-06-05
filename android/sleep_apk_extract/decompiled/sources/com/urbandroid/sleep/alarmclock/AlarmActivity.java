package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.facebook.share.internal.ShareConstants;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.settings.SearchActivity;
import com.urbandroid.sleep.appwidget.DroidWidget;
import com.urbandroid.sleep.fragment.AlarmFragment;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.toolbar.OffsetListener;
import com.urbandroid.sleep.gui.toolbar.OffsetObserver;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.sleep.service.Settings;
import java.util.Locale;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0014¢\u0006\u0004\b \u0010\u0004R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/AlarmActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/sleep/gui/toolbar/OffsetObserver;", "<init>", "()V", "", "expanded", "", "setExpanded", "(Z)V", "", SpotifyService.OFFSET, "setVerticalOffset", "(I)V", "getVerticalOffset", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "onBackPressed", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "onStart", "onStop", "onPostResume", "onDestroy", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "getH", "()Landroid/os/Handler;", "setH", "(Landroid/os/Handler;)V", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/BroadcastReceiver;", "getReceiver", "()Landroid/content/BroadcastReceiver;", "toolbarExpanded", "Z", "verticalOffset", "I", "Lcom/google/android/material/snackbar/Snackbar;", "snoozeSnackbar", "Lcom/google/android/material/snackbar/Snackbar;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AlarmActivity extends BaseActivity implements OffsetObserver {
    private Handler h;
    private Snackbar snoozeSnackbar;
    private final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.AlarmActivity$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context p0, Intent p1) {
            if (this.this$0.snoozeSnackbar != null) {
                try {
                    Snackbar snackbar = this.this$0.snoozeSnackbar;
                    if (snackbar != null) {
                        snackbar.dismiss();
                    }
                } catch (Exception unused) {
                }
            }
        }
    };
    private boolean toolbarExpanded = true;
    private int verticalOffset = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(AlarmActivity alarmActivity, View view) {
        alarmActivity.startActivity(new Intent(alarmActivity, (Class<?>) SetAlarm.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(AlarmActivity alarmActivity, View view) {
        new SleepStarter().startSleep(alarmActivity.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(AlarmActivity alarmActivity, View view) {
        SearchActivity.INSTANCE.start(alarmActivity, R.id.search_lenses_alarm, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPostResume$lambda$1(MaterialButton materialButton) {
        if (SleepService.isRunningTimely()) {
            materialButton.setIconResource(R.drawable.ic_tab_graph_anim_ongoing);
            Drawable icon = materialButton.getIcon();
            icon.getClass();
            ((AnimationDrawable) icon).start();
            Logger.logInfo("starting running animation");
        }
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public int getVerticalOffset() {
        return this.verticalOffset;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!isTaskRoot() && !getIntent().hasExtra("back_to_dashboard")) {
            super.onBackPressed();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) AlarmClock.class);
        intent.addFlags(67108864);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        startActivity(intent);
        finishAfterTransition();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        String stringExtra;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        final int i = 2;
        ContextCompat.registerReceiver(this, this.receiver, new IntentFilter("com.urbandroid.sleep.alarmclock.cancel_snooze_finished"), 2);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        ActionBar supportActionBar = getSupportActionBar();
        final int i2 = 1;
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.alarm_list_title);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        this.h = new Handler();
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.fab);
        Settings settings = new Settings(this);
        ComponentColorUtilKt.color(materialButton);
        final int i3 = 0;
        if (settings.isAlarmOnly()) {
            materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.AlarmActivity$$ExternalSyntheticLambda1
                public final /* synthetic */ AlarmActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i4 = i3;
                    AlarmActivity alarmActivity = this.f$0;
                    switch (i4) {
                        case 0:
                            AlarmActivity.onCreate$lambda$1(alarmActivity, view);
                            break;
                        case 1:
                            AlarmActivity.onCreate$lambda$2(alarmActivity, view);
                            break;
                        default:
                            AlarmActivity.onCreate$lambda$3(alarmActivity, view);
                            break;
                    }
                }
            });
        } else {
            materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.AlarmActivity$$ExternalSyntheticLambda1
                public final /* synthetic */ AlarmActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i4 = i2;
                    AlarmActivity alarmActivity = this.f$0;
                    switch (i4) {
                        case 0:
                            AlarmActivity.onCreate$lambda$1(alarmActivity, view);
                            break;
                        case 1:
                            AlarmActivity.onCreate$lambda$2(alarmActivity, view);
                            break;
                        default:
                            AlarmActivity.onCreate$lambda$3(alarmActivity, view);
                            break;
                    }
                }
            });
        }
        if (settings.isDashboard() && ((settings.showShowCaseIfNotShown("sc_alarm_list_add_alarm2") && TrialFilter.getInstance().daysUsed(0, 10)) || ((intent = getIntent()) != null && (stringExtra = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM)) != null && stringExtra.equals("tutorial")))) {
            TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.add_alarm_tb), getResources().getString(R.string.add_alarm), "").outerCircleColor(R.color.tap_target_color).icon(getDrawable(R.drawable.ic_alarm_plus)).dimColor(R.color.tap_target_shade).tintTarget(false).textColor(R.color.primary), new TapTargetView.Listener() { // from class: com.urbandroid.sleep.alarmclock.AlarmActivity.onCreate.4
                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                public void onTargetClick(TapTargetView view) {
                    view.getClass();
                    super.onTargetClick(view);
                    AlarmActivity alarmActivity = AlarmActivity.this;
                    alarmActivity.startActivity(new Intent(alarmActivity, (Class<?>) SetAlarm.class));
                }

                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
                    view.getClass();
                    super.onTargetDismissed(view, userInitiated);
                }
            });
        }
        View viewFindViewById = findViewById(R.id.search_button);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        if (appBarLayout == null || viewFindViewById == null) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new OffsetListener(this, this, viewFindViewById));
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.AlarmActivity$$ExternalSyntheticLambda1
            public final /* synthetic */ AlarmActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i4 = i;
                AlarmActivity alarmActivity = this.f$0;
                switch (i4) {
                    case 0:
                        AlarmActivity.onCreate$lambda$1(alarmActivity, view);
                        break;
                    case 1:
                        AlarmActivity.onCreate$lambda$2(alarmActivity, view);
                        break;
                    default:
                        AlarmActivity.onCreate$lambda$3(alarmActivity, view);
                        break;
                }
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.getClass();
        menuInflater.inflate(R.menu.add_alarm_menu, menu);
        MenuUtil.INSTANCE.showIcons(menu);
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.receiver);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.menu_add_alarm) {
                return false;
            }
            startActivity(new Intent(this, (Class<?>) SetAlarm.class));
            return true;
        }
        if (isTaskRoot() || getIntent().hasExtra("back_to_dashboard")) {
            Intent intent = new Intent(this, (Class<?>) AlarmClock.class);
            intent.addFlags(67108864);
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            startActivity(intent);
        }
        finishAfterTransition();
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        String string;
        super.onPostResume();
        boolean zIsRunningTimely = SleepService.isRunningTimely();
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.fab);
        if (zIsRunningTimely) {
            String string2 = getString(R.string.settings_category_track);
            String string3 = getString(R.string.in_progress);
            string3.getClass();
            String lowerCase = string3.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            string = FileInsert$$ExternalSyntheticOutline0.m$1(string2, " ", new Regex("…").replace(lowerCase, ""));
        } else {
            string = getString(R.string.start_sleep_tracking);
        }
        materialButton.setText(string);
        materialButton.setIconResource(zIsRunningTimely ? R.drawable.ic_tab_graph_anim_ongoing : R.drawable.ic_action_track_white);
        if (zIsRunningTimely) {
            try {
                Handler handler = this.h;
                if (handler != null) {
                    handler.postDelayed(new AlarmActivity$$ExternalSyntheticLambda0(materialButton, 0), 500L);
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        DroidWidget.refresh(this);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
            fragmentFindFragmentById.getClass();
            ((AlarmFragment) fragmentFindFragmentById).setVisible();
        } catch (Exception unused) {
        }
        this.snoozeSnackbar = Alarm.showSnoozeSnackbar((ViewGroup) findViewById(R.id.parent), this);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragmentFindFragmentById.getClass();
        ((AlarmFragment) fragmentFindFragmentById).setInvisible();
        Snackbar snackbar = this.snoozeSnackbar;
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public void setExpanded(boolean expanded) {
        this.toolbarExpanded = expanded;
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public void setVerticalOffset(int offset) {
        this.verticalOffset = offset;
    }
}
