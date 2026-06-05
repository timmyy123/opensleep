package com.urbandroid.sleep.fragment.dashboard.morning;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.fragment.dashboard.share.BitmapComposer;
import com.urbandroid.sleep.gui.ImageCreator;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.image.ShareDataUtil;
import com.urbandroid.util.AirplaneModeUtil;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u000b*\u0001*\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\u0004J)\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0015¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0018\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00102\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningFragment;", "fragment", "Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningFragment;", "getFragment", "()Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningFragment;", "setFragment", "(Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningFragment;)V", "com/urbandroid/sleep/fragment/dashboard/morning/MorningActivity$reloadReceiver$1", "reloadReceiver", "Lcom/urbandroid/sleep/fragment/dashboard/morning/MorningActivity$reloadReceiver$1;", "airplaneMenu", "Landroid/view/MenuItem;", "shareMenu", "getTag", "()Ljava/lang/String;", "tag", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MorningActivity extends BaseActivity implements FeatureLogger {
    private MenuItem airplaneMenu;
    private MorningFragment fragment;
    private final MorningActivity$reloadReceiver$1 reloadReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.fragment.dashboard.morning.MorningActivity$reloadReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MorningFragment fragment = this.this$0.getFragment();
            if (fragment != null) {
                fragment.reload();
            }
        }
    };
    private MenuItem shareMenu;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onOptionsItemSelected$lambda$1(MorningActivity morningActivity, DialogInterface dialogInterface, int i) {
        SleepRecord sleepRecord;
        morningActivity.log("Deleting record from rating activity");
        MorningFragment morningFragment = morningActivity.fragment;
        if (morningFragment != null && (sleepRecord = morningFragment.getSleepRecord()) != null) {
            UndoOperationGroup undoOperationGroup = new UndoOperationGroup(morningActivity.getString(R.string.deleted), new SleepRecord(sleepRecord, false));
            SharedApplicationContext.getInstance().deleteRecord(sleepRecord, undoOperationGroup);
            SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        }
        morningActivity.finish();
    }

    public final MorningFragment getFragment() {
        return this.fragment;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return "MorningActivity";
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
        MorningFragment morningFragment = this.fragment;
        if (morningFragment != null) {
            morningFragment.setSleepRecord(sleepRecord);
        }
        MorningFragment morningFragment2 = this.fragment;
        if (morningFragment2 != null) {
            morningFragment2.reload();
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_morning);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragmentFindFragmentById.getClass();
        MorningFragment morningFragment = (MorningFragment) fragmentFindFragmentById;
        this.fragment = morningFragment;
        if (morningFragment != null) {
            morningFragment.setVisible();
        }
        View viewFindViewById = findViewById(R.id.fab);
        viewFindViewById.getClass();
        ComponentColorUtilKt.color(viewFindViewById);
        Intent intent = getIntent();
        SleepRecord sleepRecord = intent != null ? (SleepRecord) intent.getParcelableExtra("SleepRecord") : null;
        if (sleepRecord == null) {
            finish();
            return;
        }
        MorningFragment morningFragment2 = this.fragment;
        if (morningFragment2 != null) {
            morningFragment2.setSleepRecord(sleepRecord);
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(getString(R.string.good_morning));
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        KeyguardUtil.disableWhenKeyboardUsagePossible(this);
        if (SharedApplicationContext.getSettings().isMorningScreenDark()) {
            getDelegate().setLocalNightMode(2);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem;
        MenuItem menuItem2;
        menu.getClass();
        getMenuInflater().inflate(R.menu.rating_menu, menu);
        this.airplaneMenu = menu.findItem(R.id.menu_airplane);
        this.shareMenu = menu.findItem(R.id.menu_share);
        if (!SharedApplicationContext.getSettings().isAutoSharingEnabled() && SharedApplicationContext.getInstance().getShareService().isConnected(this) && (menuItem2 = this.shareMenu) != null) {
            menuItem2.setTitle(SharedApplicationContext.getInstance().getShareService().getName(this));
        }
        if (!SharedApplicationContext.getSettings().isAirplaneModeOn() && (menuItem = this.airplaneMenu) != null) {
            menuItem.setVisible(false);
        }
        MenuUtil.INSTANCE.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        RecyclerView cardList;
        MorningFragment morningFragment;
        SleepRecord sleepRecord;
        item.getClass();
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_airplane /* 2131362511 */:
                AirplaneModeUtil.disableAirplaneMode(this);
                MenuItem menuItem = this.airplaneMenu;
                if (menuItem != null) {
                    menuItem.setVisible(false);
                }
                return true;
            case R.id.menu_delete /* 2131362520 */:
                new MaterialAlertDialogBuilder(this).setIcon(R.drawable.ic_alert).setTitle(R.string.are_you_sure).setMessage(R.string.realy_delete_confirm_generic).setPositiveButton(R.string.delete, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(this, 10)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
                return true;
            case R.id.menu_doc /* 2131362525 */:
                ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/how_to_read_sleep_graphs.html#morning_screen");
                return true;
            case R.id.menu_share /* 2131362552 */:
                MorningFragment morningFragment2 = this.fragment;
                if (morningFragment2 != null && (cardList = morningFragment2.getCardList()) != null && (morningFragment = this.fragment) != null && (sleepRecord = morningFragment.getSleepRecord()) != null) {
                    Bitmap bitmapAddLogoToBitmap = ImageCreator.addLogoToBitmap(this, new BitmapComposer().getViewAsBitmap(cardList));
                    bitmapAddLogoToBitmap.getClass();
                    String strM = FileInsert$$ExternalSyntheticOutline0.m("graph_detail_", DateUtil.getDatetimestamp(sleepRecord.getFrom()), ".png");
                    ShareDataUtil.saveData(this, strM, ImageCreator.convertBitmapIntoPNGBytes(bitmapAddLogoToBitmap));
                    startActivity(ShareDataUtil.createIntent(this, strM, new SleepRecordStringBuilder(getApplicationContext()).setPrependSleep(true).setAppendAppName(true).setAppendMeasures(true, Measure.ALL_MEASURES).build(sleepRecord)));
                    return true;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        permissions.getClass();
        grantResults.getClass();
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 73309) {
            if (grantResults[0] != 0) {
                Logger.logInfo("Permissions: WIFI Denied ");
                return;
            }
            Logger.logInfo("Permissions: WIFI Granted ");
            MorningFragment morningFragment = this.fragment;
            if (morningFragment != null) {
                morningFragment.reload();
                return;
            }
            return;
        }
        if (requestCode != 73319) {
            return;
        }
        if (grantResults[0] != 0) {
            Logger.logInfo("Permissions: LOCATION Denied ");
            return;
        }
        Logger.logInfo("Permissions: LOCATION Granted ");
        MorningFragment morningFragment2 = this.fragment;
        if (morningFragment2 != null) {
            morningFragment2.reload();
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MorningFragment morningFragment = this.fragment;
        if (morningFragment != null) {
            morningFragment.reload();
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.reloadReceiver, new IntentFilter("com.urbandroid.sleep.ACTION_GRAPH_CHANGED"));
    }
}
