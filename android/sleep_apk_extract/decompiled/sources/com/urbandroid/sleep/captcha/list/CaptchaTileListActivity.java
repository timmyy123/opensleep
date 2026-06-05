package com.urbandroid.sleep.captcha.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/CaptchaTileListActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "<init>", "()V", "perAlarm", "", "getPerAlarm", "()Z", "setPerAlarm", "(Z)V", "selectedCaptchaId", "", "getSelectedCaptchaId", "()I", "setSelectedCaptchaId", "(I)V", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaTileListActivity extends BaseActivity implements ICaptchaTileList {
    private boolean perAlarm;
    private int selectedCaptchaId = AbstractCaptchaDialogFragment.INSTANCE.getNOT_INITIALIZED();

    @Override // com.urbandroid.sleep.captcha.list.ICaptchaTileList
    public void dismiss() {
        Intent intent = new Intent();
        intent.putExtra("captchaId", getSelectedCaptchaId());
        setResult(-1, intent);
        finish();
    }

    @Override // com.urbandroid.sleep.captcha.list.ICaptchaTileList
    public boolean getPerAlarm() {
        return this.perAlarm;
    }

    public int getSelectedCaptchaId() {
        return this.selectedCaptchaId;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Exception {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_captcha_list);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeAsUpIndicator(R.drawable.ic_action_cancel);
        }
        setPerAlarm(getIntent().getBooleanExtra("perAlarm", false));
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setTitle(getPerAlarm() ? R.string.captcha_preferene_title : R.string.captcha_default_title);
        }
        Pair<View, CaptchaRecyclerViewAdapter> pairInflateCaptchaList = CaptchaTileDialogFragment.INSTANCE.inflateCaptchaList(this, this);
        pairInflateCaptchaList.component1();
        pairInflateCaptchaList.component2();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }

    public void setPerAlarm(boolean z) {
        this.perAlarm = z;
    }

    @Override // com.urbandroid.sleep.captcha.list.ICaptchaTileList
    public void setSelectedCaptchaId(int i) {
        this.selectedCaptchaId = i;
    }
}
