package com.urbandroid.sleep.addon.taskerplugin.ui;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.taskerplugin.twofortyfouram.locale.BreadCrumber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractPluginActivity extends Activity {
    private boolean mIsCancelled = false;

    private void setupActionBarApi11() {
        if (getActionBar() != null) {
            getActionBar().setSubtitle(BreadCrumber.generateBreadcrumb(getApplicationContext(), getIntent(), getString(R.string.app_name_long)));
        }
    }

    private void setupActionBarApi14() {
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            try {
                getActionBar().setIcon(getPackageManager().getApplicationIcon(getCallingPackage()));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    private void setupTitleApi11() {
        CharSequence applicationLabel;
        try {
            applicationLabel = getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(getCallingPackage(), 0));
        } catch (PackageManager.NameNotFoundException unused) {
            applicationLabel = null;
        }
        if (applicationLabel != null) {
            setTitle(applicationLabel);
        }
    }

    public boolean isCanceled() {
        return this.mIsCancelled;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupTitleApi11();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.twofortyfouram_locale_help_save_dontsave, menu);
        setupActionBarApi11();
        setupActionBarApi14();
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (16908332 == itemId) {
            finish();
            return true;
        }
        if (R.id.twofortyfouram_locale_menu_dontsave == itemId) {
            this.mIsCancelled = true;
            finish();
            return true;
        }
        if (R.id.twofortyfouram_locale_menu_save != itemId) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
