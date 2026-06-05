package com.urbandroid.sleep.fragment.dashboard.detail;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.NoiseActivity;
import com.urbandroid.sleep.appwidget.DroidWidget;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.fragment.dashboard.share.BitmapComposer;
import com.urbandroid.sleep.gui.ImageCreator;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.image.ShareDataUtil;
import com.urbandroid.util.ColorUtil;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001*\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\u0004J)\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0015¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "", "delete", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailFragment;", "fragment", "Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailFragment;", "getFragment", "()Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailFragment;", "setFragment", "(Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailFragment;)V", "noKeyguard", "Ljava/lang/Boolean;", "getNoKeyguard", "()Ljava/lang/Boolean;", "setNoKeyguard", "(Ljava/lang/Boolean;)V", "com/urbandroid/sleep/fragment/dashboard/detail/SleepDetailActivity$reloadReceiver$1", "reloadReceiver", "Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailActivity$reloadReceiver$1;", "", "getTag", "()Ljava/lang/String;", "tag", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailActivity extends BaseActivity implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SleepDetailFragment fragment;
    private Boolean noKeyguard = Boolean.FALSE;
    private final SleepDetailActivity$reloadReceiver$1 reloadReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity$reloadReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SleepDetailFragment fragment = this.this$0.getFragment();
            if (fragment != null) {
                fragment.reload();
            }
        }
    };

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/detail/SleepDetailActivity$Companion;", "", "<init>", "()V", "getStartIntent", "Landroid/content/Intent;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "sleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "noKeyguard", "", "start", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent getStartIntent$default(Companion companion, Context context, SleepRecord sleepRecord, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.getStartIntent(context, sleepRecord, z);
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, SleepRecord sleepRecord, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.start(context, sleepRecord, z);
        }

        public final Intent getStartIntent(Context context, SleepRecord sleepRecord, boolean noKeyguard) {
            Intent intent = new Intent(context, (Class<?>) SleepDetailActivity.class);
            intent.putExtra("SleepRecord", (Parcelable) sleepRecord);
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            if (noKeyguard) {
                intent.putExtra("keyguard", true);
            }
            return intent;
        }

        public final void start(Context context, SleepRecord sleepRecord, boolean noKeyguard) {
            context.getClass();
            context.startActivity(getStartIntent(context, sleepRecord, noKeyguard));
        }

        private Companion() {
        }
    }

    private final void delete() {
        SleepRecord sleepRecord;
        SleepDetailFragment sleepDetailFragment = this.fragment;
        if (sleepDetailFragment == null || (sleepRecord = sleepDetailFragment.getSleepRecord()) == null) {
            return;
        }
        new Settings(getApplicationContext()).decRecordsCount();
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.deleted), new SleepRecord(sleepRecord, false));
        SharedApplicationContext.getInstance().deleteRecord(sleepRecord, undoOperationGroup);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        finish();
    }

    public static final void start(Context context, SleepRecord sleepRecord, boolean z) {
        INSTANCE.start(context, sleepRecord, z);
    }

    public final SleepDetailFragment getFragment() {
        return this.fragment;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return "SleepDetailActivity";
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        super.onActivityResult(requestCode, resultCode, data2);
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(requestCode, resultCode, "onActivityResult ", " ", " ");
        sbM.append(data2);
        String string = sbM.toString();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + string, null);
        if (data2 == null || !data2.hasExtra("SleepRecord")) {
            return;
        }
        SleepRecord sleepRecord = (SleepRecord) data2.getParcelableExtra("SleepRecord");
        if (sleepRecord == null) {
            finish();
            return;
        }
        SleepDetailFragment sleepDetailFragment = this.fragment;
        if (sleepDetailFragment != null) {
            sleepDetailFragment.setSleepRecord(sleepRecord);
        }
        SleepDetailFragment sleepDetailFragment2 = this.fragment;
        if (sleepDetailFragment2 != null) {
            sleepDetailFragment2.reload();
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_sleep_detail);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragmentFindFragmentById.getClass();
        SleepDetailFragment sleepDetailFragment = (SleepDetailFragment) fragmentFindFragmentById;
        this.fragment = sleepDetailFragment;
        if (sleepDetailFragment != null) {
            sleepDetailFragment.setVisible();
        }
        View viewFindViewById = findViewById(R.id.fab);
        viewFindViewById.getClass();
        ComponentColorUtilKt.color(viewFindViewById);
        Intent intent = getIntent();
        SleepRecord sleepRecord = intent != null ? (SleepRecord) intent.getParcelableExtra("SleepRecord") : null;
        SleepDetailFragment sleepDetailFragment2 = this.fragment;
        if (sleepDetailFragment2 != null) {
            sleepDetailFragment2.setSleepRecord(sleepRecord);
        }
        Intent intent2 = getIntent();
        boolean zHasExtra = intent2 != null ? intent2.hasExtra("keyguard") : false;
        SleepDetailFragment sleepDetailFragment3 = this.fragment;
        if (sleepDetailFragment3 != null) {
            sleepDetailFragment3.setNoKeyguard(zHasExtra);
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) null);
        }
        String title = SleepRecordStringBuilder.getTitle(this, sleepRecord);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle(" ");
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setDisplayHomeAsUpEnabled(true);
        }
        ((Button) findViewById(R.id.title)).setText(title);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        if (appBarLayout != null) {
            appBarLayout.setOutlineProvider(null);
            appBarLayout.setBackgroundColor(ColorUtil.i(this, R.color.bg_main));
            appBarLayout.setStatusBarForegroundColor(ColorUtil.i(this, R.color.bg_main));
            if (Build.VERSION.SDK_INT >= 28) {
                appBarLayout.setOutlineAmbientShadowColor(ColorUtil.i(this, R.color.bg_main));
                appBarLayout.setOutlineSpotShadowColor(ColorUtil.i(this, R.color.bg_main));
            }
            appBarLayout.setDrawingCacheBackgroundColor(ColorUtil.i(this, R.color.bg_main));
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sleep_detail_menu, menu);
        MenuUtil.INSTANCE.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        SleepRecord sleepRecord;
        SleepRecord sleepRecord2;
        SleepRecord sleepRecord3;
        Date to;
        SleepRecord sleepRecord4;
        Date from;
        SleepRecord sleepRecord5;
        RecyclerView cardList;
        SleepDetailFragment sleepDetailFragment;
        SleepRecord sleepRecord6;
        item.getClass();
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_delete /* 2131362520 */:
                delete();
                return true;
            case R.id.menu_doc /* 2131362525 */:
                ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/how_to_read_sleep_graphs.html");
                return true;
            case R.id.menu_noise /* 2131362541 */:
                SleepDetailFragment sleepDetailFragment2 = this.fragment;
                TimeZone timeZone = null;
                if (((sleepDetailFragment2 == null || (sleepRecord5 = sleepDetailFragment2.getSleepRecord()) == null) ? null : sleepRecord5.getTo()) != null) {
                    Intent intent = new Intent(this, (Class<?>) NoiseActivity.class);
                    SleepDetailFragment sleepDetailFragment3 = this.fragment;
                    intent.putExtra("noise_from", (sleepDetailFragment3 == null || (sleepRecord4 = sleepDetailFragment3.getSleepRecord()) == null || (from = sleepRecord4.getFrom()) == null) ? null : Long.valueOf(from.getTime()));
                    SleepDetailFragment sleepDetailFragment4 = this.fragment;
                    intent.putExtra("noise_to", (sleepDetailFragment4 == null || (sleepRecord3 = sleepDetailFragment4.getSleepRecord()) == null || (to = sleepRecord3.getTo()) == null) ? null : Long.valueOf(to.getTime()));
                    SleepDetailFragment sleepDetailFragment5 = this.fragment;
                    if (((sleepDetailFragment5 == null || (sleepRecord2 = sleepDetailFragment5.getSleepRecord()) == null) ? null : sleepRecord2.getTimeZone()) != null) {
                        SleepDetailFragment sleepDetailFragment6 = this.fragment;
                        if (sleepDetailFragment6 != null && (sleepRecord = sleepDetailFragment6.getSleepRecord()) != null) {
                            timeZone = sleepRecord.getTimeZone();
                        }
                        intent.putExtra("noise_timezone", timeZone);
                    }
                    startActivity(intent);
                }
                return true;
            case R.id.menu_share /* 2131362552 */:
                SleepDetailFragment sleepDetailFragment7 = this.fragment;
                if (sleepDetailFragment7 != null && (cardList = sleepDetailFragment7.getCardList()) != null && (sleepDetailFragment = this.fragment) != null && (sleepRecord6 = sleepDetailFragment.getSleepRecord()) != null) {
                    Bitmap bitmapAddLogoToBitmap = ImageCreator.addLogoToBitmap(this, new BitmapComposer().getViewAsBitmap(cardList));
                    bitmapAddLogoToBitmap.getClass();
                    String strM = FileInsert$$ExternalSyntheticOutline0.m("graph_detail_", DateUtil.getDatetimestamp(sleepRecord6.getFrom()), ".png");
                    ShareDataUtil.saveData(this, strM, ImageCreator.convertBitmapIntoPNGBytes(bitmapAddLogoToBitmap));
                    startActivity(ShareDataUtil.createIntent(this, strM, new SleepRecordStringBuilder(getApplicationContext()).setPrependSleep(true).setAppendAppName(true).setAppendMeasures(true, Measure.ALL_MEASURES).build(sleepRecord6)));
                }
                return true;
            default:
                return true;
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.reloadReceiver);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SleepDetailFragment sleepDetailFragment = this.fragment;
        if (sleepDetailFragment != null) {
            sleepDetailFragment.reload();
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.reloadReceiver, new IntentFilter("com.urbandroid.sleep.ACTION_GRAPH_CHANGED"));
        DroidWidget.refresh(this);
    }
}
