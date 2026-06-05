package com.urbandroid.sleep.alarmclock;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.addon.AddonFragment;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.util.EdgeToEdgeUtil;

/* JADX INFO: loaded from: classes4.dex */
public class AddonActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        ViewIntent.url(getApplicationContext(), "https://play.google.com/store/apps/dev?id=9219179332656617922");
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_addon);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.addon);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ((AddonFragment) getSupportFragmentManager().findFragmentById(R.id.fragment)).setVisible();
        View viewFindViewById = findViewById(R.id.fab);
        EdgeToEdgeUtil.insetsBottom(viewFindViewById);
        ComponentColorUtilKt.color(viewFindViewById);
        viewFindViewById.setOnClickListener(new EditActivity$$ExternalSyntheticLambda0(this, 2));
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
            return true;
        }
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//addons/");
        return true;
    }
}
