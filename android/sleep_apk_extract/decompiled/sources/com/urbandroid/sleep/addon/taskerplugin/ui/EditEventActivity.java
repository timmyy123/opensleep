package com.urbandroid.sleep.addon.taskerplugin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.taskerplugin.bundle.BundleScrubber;
import com.urbandroid.sleep.addon.taskerplugin.bundle.PluginBundleManager;
import com.urbandroid.sleep.service.automation.AutomationEventMapping;

/* JADX INFO: loaded from: classes4.dex */
public final class EditEventActivity extends AbstractPluginActivity {
    private ListView mList = null;

    @Override // android.app.Activity
    public void finish() {
        if (isCanceled() || -1 == this.mList.getCheckedItemPosition()) {
            super.finish();
        }
        if (this.mList.getCheckedItemPosition() >= 0) {
            AutomationEventMapping automationEventMapping = AutomationEventMapping.values()[this.mList.getCheckedItemPosition()];
            Intent intent = new Intent();
            intent.putExtra("com.twofortyfouram.locale.intent.extra.BUNDLE", PluginBundleManager.generateBundle(getApplicationContext(), automationEventMapping.getAction()));
            intent.putExtra("com.twofortyfouram.locale.intent.extra.BLURB", automationEventMapping.getLabel(this));
            setResult(-1, intent);
            super.finish();
        }
    }

    @Override // com.urbandroid.sleep.addon.taskerplugin.ui.AbstractPluginActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BundleScrubber.scrub(getIntent());
        Bundle bundleExtra = getIntent().getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE");
        BundleScrubber.scrub(bundleExtra);
        setContentView(R.layout.tasker_plugin_main);
        ListView listView = (ListView) findViewById(android.R.id.list);
        this.mList = listView;
        listView.setAdapter((ListAdapter) new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, android.R.id.text1, AutomationEventMapping.getLabels(this)));
        if (bundle == null && PluginBundleManager.isBundleValid(bundleExtra)) {
            String string = bundleExtra.getString("com.urbandroid.sleep.taskerplugin.extra.EVENT");
            if (string == null) {
                Log.w("sleep tasker", "no eventName found at com.urbandroid.sleep.taskerplugin.extra.EVENT");
                return;
            }
            Log.w("sleep tasker", "eventName - ".concat(string));
            AutomationEventMapping automationEventMappingFindByAction = AutomationEventMapping.findByAction(bundleExtra.getString("com.urbandroid.sleep.taskerplugin.extra.EVENT"));
            if (automationEventMappingFindByAction == null) {
                Log.w("sleep tasker", "no event found for eventName - ".concat(string));
            } else {
                this.mList.setItemChecked(automationEventMappingFindByAction.getPosition(), true);
            }
        }
    }
}
