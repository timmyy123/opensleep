package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextScope;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 92\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00019B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u0012J\u0019\u0010 \u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b \u0010!J7\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010#J+\u0010&\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0017H\u0016¢\u0006\u0004\b,\u0010-R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\f058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107¨\u0006:"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/SearchDocumentationAdapter;", "Landroid/widget/BaseAdapter;", "Lcom/urbandroid/sleep/gui/IFilterListAdapter;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/ContextScope;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/app/Activity;)V", "", "query", "", "Lcom/urbandroid/sleep/alarmclock/settings/DocsItem;", ShareConstants.FEED_SOURCE_PARAM, "", "searchLocally", "(Ljava/lang/String;Ljava/util/List;)V", "pause", "()V", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "position", "", "id", "", "onItemLongClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z", "notifyChanged", "Lcom/urbandroid/sleep/gui/IFilterListAdapter$IFilter;", "filter", "(Lcom/urbandroid/sleep/gui/IFilterListAdapter$IFilter;)V", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "convertView", "Landroid/view/ViewGroup;", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "getItem", "(I)Lcom/urbandroid/sleep/alarmclock/settings/DocsItem;", "getItemId", "(I)J", "getCount", "()I", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "result", "Ljava/util/List;", "indices", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchDocumentationAdapter extends BaseAdapter implements IFilterListAdapter, FeatureLogger, ContextScope {
    private final Activity context;
    private List<DocsItem> indices;
    private List<DocsItem> result;
    private final String tag;

    public SearchDocumentationAdapter(Activity activity) {
        activity.getClass();
        this.context = activity;
        this.tag = "SearchDocs";
        this.result = new ArrayList();
        DocsItem docsItem = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/how_to_read_sleep_graphs.html"), getValue(R.string.graphs), "Graph", "Graphs");
        DocsItem docsItem2 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//alarms/bedtime_notification.html"), getValue(R.string.time_to_bed_title));
        DocsItem docsItem3 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//alarms/bedtime_notification.html"), getValue(R.string.time_to_bed_smart_title));
        DocsItem docsItem4 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//alarms/alarm_settings.html"), getValue(R.string.settings_category_alarm), getValue(R.string.default_label));
        DocsItem docsItem5 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//alarms/captcha.html"), getValue(R.string.settings_category_captcha), getValue(R.string.stop_oversleeping), getValue(R.string.captcha_qr_code_title));
        DocsItem docsItem6 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sleep_tracking.html"), getValue(R.string.settings_category_track));
        DocsItem docsItem7 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sound_recognition.html"), getValue(R.string.sleep_recording_title), getValue(R.string.noise), getValue(R.string.stats_caption_snore), "Snoring", "Snore");
        DocsItem docsItem8 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/lullaby.html"), getValue(R.string.lullaby), getValue(R.string.sound));
        DocsItem docsItem9 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/lucid_dreaming.html"), getValue(R.string.settings_category_lucid_title), "Lucid");
        DocsItem docsItem10 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/jetlag.html"), getValue(R.string.jetlag), "Jetlag", "Jet lag");
        DocsItem docsItem11 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//devices/wearables.html"), getValue(R.string.smartwatch), getValue(R.string.control_fitbit), getValue(R.string.addon_urbandroid_samsung), getValue(R.string.control_garmin), "Pebble", "Mi Band", "Amazefit", "Amazfit", "Galaxy", "Gear", "Wear OS", "Wear", "Android Wear", "Oxymeter", "Oximeter", "StressLocator", "Smart watch", "Smartwatch");
        DocsItem docsItem12 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//devices/smart_light.html"), getValue(R.string.settings_category_smartlight), "Smart bulbs", "Philips HUE", "Hue", "lifx", "mi led", "IKEA", "Tradfri", "trådfri");
        DocsItem docsItem13 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//services/backup_data.html"), getValue(R.string.backup), getValue(R.string.menu_upload_cloud), getValue(R.string.menu_download_cloud), "SleepCloud");
        DocsItem docsItem14 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//services/google_fit.html"), getValue(R.string.google_fit));
        DocsItem docsItem15 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//services/google_calendar.html"), getValue(R.string.google_calendar));
        DocsItem docsItem16 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//services/ifttt.html"), getValue(R.string.ifttt), getValue(R.string.automatic), "Automation");
        DocsItem docsItem17 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//services/tasker_automate.html"), getValue(R.string.tasker), getValue(R.string.automatic), "Automation");
        DocsItem docsItem18 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//services/spotify.html"), getValue(R.string.spotify));
        DocsItem docsItem19 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/automatic_sleep_tracking.html"), getValue(R.string.automatic_sleep_tracking), getValue(R.string.automatic), getValue(R.string.settings_category_track));
        DocsItem docsItem20 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sleep_time_estimation.html"), getValue(R.string.sleep_time_suggestion), getValue(R.string.sleep_time_suggestion_description), getValue(R.string.settings_category_track));
        DocsItem docsItem21 = new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sleep_tracking.html#using-sonar"), getValue(R.string.sensor_sonar), getValue(R.string.contact_less), "Contact-less", "contactless");
        URL url = new URL("https://sleep.urbandroid.org/docs//sleep/sleep_tracking.html#using-accelerometer");
        String str = getContext().getResources().getStringArray(R.array.non_deep_sleep_method_entries)[0];
        str.getClass();
        this.indices = CollectionsKt.listOf((Object[]) new DocsItem[]{docsItem, docsItem2, docsItem3, docsItem4, docsItem5, docsItem6, docsItem7, docsItem8, docsItem9, docsItem10, docsItem11, docsItem12, docsItem13, docsItem14, docsItem15, docsItem16, docsItem17, docsItem18, docsItem19, docsItem20, docsItem21, new DocsItem(url, str), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sound_recognition.html"), getValue(R.string.stats_caption_snore), "Snoring", "Snore"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/pair_tracking.html"), getValue(R.string.pair_tracking)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/chrono_jetlag.html"), getValue(R.string.chronotype), getValue(R.string.owl), getValue(R.string.lark)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/charts.html"), getValue(R.string.advanced_stats), getValue(R.string.stats), getValue(R.string.lark)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions"), getValue(R.string.score), getValue(R.string.settings_category_sleep), "sleepscore"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sleep_tracking_theory.html"), getValue(R.string.rem), getValue(R.string.settings_category_track), "REM", "Sleep cycle", "Sleep stages", "Sleep phases", getValue(R.string.label_light_sleep), getValue(R.string.label_deep_sleep)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//faqs/"), "FAQ", getValue(R.string.get_support), getValue(R.string.menu_about)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/goals.html"), getValue(R.string.goal), getValue(R.string.improve)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/advice.html"), getValue(R.string.advice), getValue(R.string.advice_summary)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/tags.html"), getValue(R.string.tag), "Tagging", "Tags"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//general/translation.html"), getValue(R.string.contribute_translation)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//devices/oximeter.html"), getValue(R.string.apnea_category), getValue(R.string.apnea_category_summary), getValue(R.string.apnea_result), "Apnea"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/heart_rate.html"), getValue(R.string.hr), "Bluetooth Smart", "BTLE", "BLE", getValue(R.string.hrv), "HR", "HRV", getValue(R.string.hrv)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//ux/personalize.html"), getValue(R.string.text_to_speech_title), getValue(R.string.text_to_speech_summary), getValue(R.string.theme), getValue(R.string.graph_color_theme_title), "color"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sleep_tracking.html#battery-optimized"), getValue(R.string.sensor_batching_title), getValue(R.string.step_battery_optimized)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/awake_detection.html"), getValue(R.string.awake_detection), getValue(R.string.awake), getValue(R.string.awake_detection_when_using_phone)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//ux/widgets.html"), "Widgets"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//devices/sleep_phaser.html"), getValue(R.string.sleep_phaser), getValue(R.string.sleep_phaser_desc)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//devices/sleep_mask.html"), getValue(R.string.addons_mask_title), getValue(R.string.addons_mask_desc)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//devs/0parent.html"), "Developer APIs", "APIs", "API", "SDK"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//general/permissions.html"), getValue(R.string.no_permission), "Permissions"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//services/s_health.html"), getValue(R.string.samsung_shealth), "S Health", "SHealth"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//ux/homescreen.html"), getValue(R.string.home_screen), getValue(R.string.alarms_only), getValue(R.string.tabs), getValue(R.string.dashboard)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/sleep_apnea.html"), "Sleep apnea", getValue(R.string.oximeter), "Sleep apnoe", "Sleep apnoea"), new DocsItem(new URL("https://sleep.urbandroid.org/docs//faqs/general_change_language.html"), "language"), new DocsItem(new URL("https://forum.urbandroid.org/"), getValue(R.string.forum)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//sleep/smart_wake_up.html"), getValue(R.string.settings_category_smart), getValue(R.string.settings_category_smart), getValue(R.string.non_deep_sleep_window_title), getValue(R.string.settings_category_smart_summary), getValue(R.string.settings_category_track)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//alarms/snooze.html"), getValue(R.string.alarm_alert_snooze_text), getValue(R.string.stop_oversleeping)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//alarms/captcha.html#alarm-avoiding-protection"), getValue(R.string.refund), getValue(R.string.captcha_no_escape)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//automation/"), getValue(R.string.automation), getValue(R.string.tasker), getValue(R.string.webhooks), getValue(R.string.ifttt), getValue(R.string.intent_api)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//general/plan.html"), getValue(R.string.upgrade_to_premium), getValue(R.string.expire_info_freemium_first), getValue(R.string.unlock_text)), new DocsItem(new URL("https://sleep.urbandroid.org/docs//faqs/purchase_not_unlocked.html"), getValue(R.string.restore_purchase), getValue(R.string.unlock_restore_wait))});
    }

    private final void searchLocally(String query, List<DocsItem> source) {
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + query, null);
        if (query != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : source) {
                String[] titles = ((DocsItem) obj).getTitles();
                int length = titles.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (StringsKt__StringsKt.contains((CharSequence) titles[i], (CharSequence) query, true)) {
                        arrayList.add(obj);
                        break;
                    }
                    i++;
                }
            }
            this.result = CollectionsKt.toMutableList((Collection) arrayList);
            notifyChanged();
            String string = this.result.toString();
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + string, null);
        }
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void filter(IFilterListAdapter.IFilter filter) {
        searchLocally(filter != null ? filter.getFilterString() : null, this.indices);
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ int getArgb(int i) {
        return super.getArgb(i);
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ ColorStateList getAsColorStateList(int i) {
        return super.getAsColorStateList(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.result.size();
    }

    @Override // android.widget.Adapter
    public DocsItem getItem(int position) {
        return this.result.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ String getValue(int i) {
        return super.getValue(i);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        TextView textView2;
        if (convertView == null) {
            convertView = InflatorUtil.INSTANCE.get(getContext()).inflate(R.layout.documentation_search, parent, false);
        }
        DocsItem item = getItem(position);
        if (convertView != null && (textView2 = (TextView) convertView.findViewById(android.R.id.title)) != null) {
            textView2.setText(item.getTitles()[0]);
        }
        if (convertView != null && (textView = (TextView) convertView.findViewById(android.R.id.summary)) != null) {
            String string = item.getUrl().toString();
            string.getClass();
            textView.setText(string.substring(8));
        }
        convertView.getClass();
        return convertView;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void notifyChanged() {
        notifyDataSetChanged();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ViewIntent.urlCustomTab(getContext(), getItem(position).getUrl().toString());
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void pause() {
    }

    @Override // com.urbandroid.sleep.ContextScope
    public Activity getContext() {
        return this.context;
    }
}
