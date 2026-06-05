package com.urbandroid.sleep.addon.taskerplugin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.urbandroid.common.util.ComponentUtil;
import com.urbandroid.sleep.addon.taskerplugin.TaskerPlugin;
import com.urbandroid.sleep.addon.taskerplugin.bundle.BundleScrubber;
import com.urbandroid.sleep.addon.taskerplugin.bundle.PluginBundleManager;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.automation.AutomationEventMapping;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class QueryReceiver extends BroadcastReceiver {
    public static void setEnabled(Context context, boolean z) {
        ComponentUtil.setEnabled(context, QueryReceiver.class, z);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || !new Settings(context).isTasker()) {
            return;
        }
        if (!"com.twofortyfouram.locale.intent.action.QUERY_CONDITION".equals(intent.getAction())) {
            Locale locale = Locale.US;
            Log.e("SleepAsAndroid", "Received unexpected Intent action " + intent.getAction());
            return;
        }
        Locale locale2 = Locale.US;
        Log.i("SleepAsAndroid", "Query Received action " + intent.getAction());
        BundleScrubber.scrub(intent);
        Bundle bundleExtra = intent.getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE");
        BundleScrubber.scrub(bundleExtra);
        Bundle bundleRetrievePassThroughData = TaskerPlugin.Event.retrievePassThroughData(intent);
        int iRetrievePassThroughMessageID = TaskerPlugin.Event.retrievePassThroughMessageID(intent);
        AutomationEventMapping automationEventMappingFindByAction = (bundleRetrievePassThroughData == null || bundleRetrievePassThroughData.isEmpty()) ? null : AutomationEventMapping.INSTANCE.findByAction(bundleRetrievePassThroughData.getString("sleep_action"));
        if (iRetrievePassThroughMessageID == -1 || automationEventMappingFindByAction == null) {
            setResultCode(18);
            return;
        }
        Log.i("SleepAsAndroid", "Fired sleep event: " + automationEventMappingFindByAction);
        if (!PluginBundleManager.isBundleValid(bundleExtra)) {
            setResultCode(18);
            return;
        }
        AutomationEventMapping automationEventMappingFindByAction2 = AutomationEventMapping.INSTANCE.findByAction(bundleExtra.getString("com.urbandroid.sleep.taskerplugin.extra.EVENT"));
        Log.i("SleepAsAndroid", "Configured sleep event: " + automationEventMappingFindByAction2);
        if (TaskerPlugin.Setting.hostSupportsVariableReturn(intent.getExtras())) {
            Bundle bundle = new Bundle();
            bundle.putString("%sleepevent", automationEventMappingFindByAction.getAction().substring(automationEventMappingFindByAction.getAction().lastIndexOf(46) + 1).replace('_', ' '));
            TaskerPlugin.addVariableBundle(getResultExtras(true), bundle);
        }
        Log.i("SleepAsAndroid", "Result: " + automationEventMappingFindByAction2);
        if (automationEventMappingFindByAction == automationEventMappingFindByAction2) {
            setResultCode(16);
            Log.i("SleepAsAndroid", "RESULT_CONDITION_SATISFIED");
        } else {
            setResultCode(17);
            Log.i("SleepAsAndroid", "RESULT_CONDITION_UNSATISFIED");
        }
    }
}
