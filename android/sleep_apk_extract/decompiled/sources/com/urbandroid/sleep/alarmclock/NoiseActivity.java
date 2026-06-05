package com.urbandroid.sleep.alarmclock;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.appbar.AppBarLayout;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.SearchActivity;
import com.urbandroid.sleep.async.IHasProgressContext;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.fragment.NoiseFragment;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.toolbar.OffsetListener;
import com.urbandroid.sleep.gui.toolbar.OffsetObserver;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.sleep.service.SharedApplicationContext;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class NoiseActivity extends BaseActivity implements IHasProgressContext, OffsetObserver {
    private NoiseFragment noiseFragment;
    private ProgressContext progressContext;
    private boolean isShowAll = false;
    private boolean toolbarExpanded = true;
    private int verticalOffset = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        List<Noise> noises = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoises(300, this.noiseFragment.getNoiseFilter());
        if (noises == null || noises.size() <= 0) {
            Toast.makeText(getApplicationContext(), R.string.no_recordings, 0).show();
        } else {
            NoiseFragment.playAll(this, noises);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        SearchActivity.start(this, R.id.search_lenses_noise, true);
    }

    @Override // com.urbandroid.sleep.async.IHasProgressContext
    /* JADX INFO: renamed from: getProgressContext */
    public ProgressContext getProgressContextInstance() {
        return this.progressContext;
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public int getVerticalOffset() {
        return this.verticalOffset;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_noise);
        ToolbarUtil.apply(this);
        TintUtil.tint(this);
        getSupportActionBar().setTitle(R.string.noise);
        final int i = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final int i2 = 0;
        if (getIntent() != null && getIntent().hasExtra("noise_from") && getIntent().hasExtra("noise_to")) {
            TimeZone timeZone = TimeZone.getDefault();
            if (getIntent().hasExtra("noise_timezone")) {
                try {
                    stringExtra = getIntent().getStringExtra("noise_timezone");
                } catch (Exception e) {
                    Logger.logSevere(e);
                    stringExtra = null;
                }
                if (stringExtra != null) {
                    timeZone = DesugarTimeZone.getTimeZone(stringExtra);
                }
            }
            if (getIntent().getLongExtra("noise_from", -1L) == -1) {
                this.isShowAll = true;
            } else {
                this.isShowAll = false;
                new SleepRecordStringBuilder(getApplicationContext());
                Date date = new Date(getIntent().getLongExtra("noise_from", -1L));
                Date date2 = new Date(getIntent().getLongExtra("noise_to", -1L));
                new SleepRecord(timeZone.getID(), date, date2, 1).setTo(date2);
            }
        } else {
            this.isShowAll = true;
            getSupportActionBar().setTitle(getString(R.string.noise));
        }
        ((AppBarLayout) findViewById(R.id.appbar)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new OffsetListener(this, this, findViewById(R.id.search_button)));
        NoiseFragment noiseFragment = (NoiseFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        this.noiseFragment = noiseFragment;
        noiseFragment.setVisible();
        this.progressContext = new ProgressContext(this);
        View viewFindViewById = findViewById(R.id.fab);
        ComponentColorUtilKt.color(viewFindViewById);
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.NoiseActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ NoiseActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                NoiseActivity noiseActivity = this.f$0;
                switch (i3) {
                    case 0:
                        noiseActivity.lambda$onCreate$0(view);
                        break;
                    default:
                        noiseActivity.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        findViewById(R.id.search_button).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.NoiseActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ NoiseActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                NoiseActivity noiseActivity = this.f$0;
                switch (i3) {
                    case 0:
                        noiseActivity.lambda$onCreate$0(view);
                        break;
                    default:
                        noiseActivity.lambda$onCreate$1(view);
                        break;
                }
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.isShowAll) {
            getMenuInflater().inflate(R.menu.noise_menu_all, menu);
        } else {
            getMenuInflater().inflate(R.menu.noise_menu, menu);
        }
        MenuUtil.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.delete_all /* 2131362157 */:
                this.noiseFragment.deleteItemConfirmCheck(null, NoiseFragment.DeleteMode.ALL);
                break;
            case R.id.menu_all /* 2131362513 */:
                Intent intent = new Intent(this, (Class<?>) NoiseActivity.class);
                intent.putExtra("noise_from", -1L);
                intent.putExtra("noise_to", -1L);
                startActivity(intent);
                break;
            case R.id.menu_doc /* 2131362525 */:
                ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/sleep_noise_recording.html");
                break;
            case R.id.play_all /* 2131362750 */:
                this.noiseFragment.playAll(this);
                break;
        }
        return true;
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public void setExpanded(boolean z) {
        this.toolbarExpanded = z;
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public void setVerticalOffset(int i) {
        this.verticalOffset = i;
    }
}
