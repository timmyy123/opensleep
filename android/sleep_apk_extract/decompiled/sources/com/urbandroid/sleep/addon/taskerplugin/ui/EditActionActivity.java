package com.urbandroid.sleep.addon.taskerplugin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.taskerplugin.SleepAction;
import com.urbandroid.sleep.addon.taskerplugin.bundle.BundleScrubber;
import com.urbandroid.sleep.addon.taskerplugin.bundle.PluginBundleManager;
import com.urbandroid.sleep.gui.KeyguardUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class EditActionActivity extends AbstractPluginActivity {
    private ListView mList = null;

    @Override // android.app.Activity
    public void finish() {
        if (isCanceled() || -1 == this.mList.getCheckedItemPosition()) {
            super.finish();
        }
        if (this.mList.getCheckedItemPosition() >= 0) {
            SleepAction sleepAction = SleepAction.values()[this.mList.getCheckedItemPosition()];
            Intent intent = new Intent();
            intent.putExtra("com.twofortyfouram.locale.intent.extra.BUNDLE", PluginBundleManager.generateBundle(getApplicationContext(), sleepAction.getAction()));
            intent.putExtra("com.twofortyfouram.locale.intent.extra.BLURB", sleepAction.getLabel(this));
            setResult(-1, intent);
            super.finish();
        }
    }

    @Override // com.urbandroid.sleep.addon.taskerplugin.ui.AbstractPluginActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        SleepAction sleepActionFindByAction;
        super.onCreate(bundle);
        BundleScrubber.scrub(getIntent());
        Bundle bundleExtra = getIntent().getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE");
        BundleScrubber.scrub(bundleExtra);
        setContentView(R.layout.tasker_plugin_main);
        if (getIntent() != null && getIntent().hasExtra("keyguard")) {
            KeyguardUtil.disable(this);
        }
        ListView listView = (ListView) findViewById(android.R.id.list);
        this.mList = listView;
        listView.setAdapter((ListAdapter) new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, android.R.id.text1, SleepAction.getLabels(this)));
        if (bundle == null && PluginBundleManager.isBundleValid(bundleExtra) && (sleepActionFindByAction = SleepAction.findByAction(bundleExtra.getString("com.urbandroid.sleep.taskerplugin.extra.EVENT"))) != null) {
            this.mList.setItemChecked(sleepActionFindByAction.getPosition(), true);
        }
    }
}
