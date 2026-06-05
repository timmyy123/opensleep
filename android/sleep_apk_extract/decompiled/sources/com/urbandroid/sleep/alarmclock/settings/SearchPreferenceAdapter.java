package com.urbandroid.sleep.alarmclock.settings;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJW\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0014¢\u0006\u0004\b \u0010!J+\u0010'\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u0017H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0017H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0014H\u0016¢\u0006\u0004\b0\u0010!J7\u00105\u001a\u0002042\f\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020\u00172\u0006\u00103\u001a\u00020+H\u0016¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0014H\u0016¢\u0006\u0004\b:\u0010!J7\u0010;\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020\u00172\u0006\u00103\u001a\u00020+H\u0016¢\u0006\u0004\b;\u0010<R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u001c8\u0016X\u0096D¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010HR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010JR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/SearchPreferenceAdapter;", "Landroid/widget/BaseAdapter;", "Lcom/urbandroid/sleep/gui/IFilterListAdapter;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/preference/PreferenceManager;", "pm", "<init>", "(Landroid/app/Activity;Landroid/preference/PreferenceManager;)V", "", "Landroid/preference/Preference;", "list", "", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "map", "Landroid/preference/PreferenceGroup;", "parentMap", "group", "activity", "", "mapPreferences", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Landroid/preference/PreferenceGroup;Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;)V", "", "resource", "Landroid/preference/PreferenceScreen;", "inflatePreferenceScreen", "(Landroid/preference/PreferenceManager;I)Landroid/preference/PreferenceScreen;", "", "filterString", "filterItems", "(Ljava/lang/String;)V", "init", "()V", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "getItem", "(I)Landroid/preference/Preference;", "", "getItemId", "(I)J", "getCount", "()I", "pause", "Landroid/widget/AdapterView;", ViewHierarchyConstants.VIEW_KEY, "id", "", "onItemLongClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z", "Lcom/urbandroid/sleep/gui/IFilterListAdapter$IFilter;", "filter", "(Lcom/urbandroid/sleep/gui/IFilterListAdapter$IFilter;)V", "notifyChanged", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "Landroid/preference/PreferenceManager;", "getPm", "()Landroid/preference/PreferenceManager;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "activityMap", "Ljava/util/Map;", "prefs", "Ljava/util/List;", "getPrefs", "()Ljava/util/List;", "filteredPrefs", "Ljava/util/ArrayList;", "preferenceActivities", "Ljava/util/ArrayList;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchPreferenceAdapter extends BaseAdapter implements IFilterListAdapter, FeatureLogger {
    private final Map<Preference, SimpleSettingsActivity> activityMap;
    private final Activity context;
    private final List<Preference> filteredPrefs;
    private final Map<Preference, PreferenceGroup> parentMap;
    private final PreferenceManager pm;
    private final ArrayList<SimpleSettingsActivity> preferenceActivities;
    private final List<Preference> prefs;
    private final String tag;

    public SearchPreferenceAdapter(Activity activity, PreferenceManager preferenceManager) {
        activity.getClass();
        preferenceManager.getClass();
        this.context = activity;
        this.pm = preferenceManager;
        this.tag = "SearchPref";
        this.activityMap = new LinkedHashMap();
        this.parentMap = new LinkedHashMap();
        this.prefs = new ArrayList();
        this.filteredPrefs = new ArrayList();
        this.preferenceActivities = new ArrayList<>();
    }

    private final void filterItems(String filterString) {
        this.filteredPrefs.clear();
        for (Preference preference : this.prefs) {
            try {
                Activity activity = this.context;
                SimpleSettingsActivity simpleSettingsActivity = this.activityMap.get(preference);
                String string = activity.getString(simpleSettingsActivity != null ? simpleSettingsActivity.getTitleResource() : R.string.settings);
                string.getClass();
                Locale locale = Locale.ROOT;
                String lowerCase = string.toLowerCase(locale);
                lowerCase.getClass();
                if (filterString != null && !Intrinsics.areEqual("", filterString)) {
                    if (!PreferenceExtKt.matches(preference, filterString)) {
                        PreferenceGroup preferenceGroup = this.parentMap.get(preference);
                        String lowerCase2 = String.valueOf(preferenceGroup != null ? preferenceGroup.getTitle() : null).toLowerCase(locale);
                        lowerCase2.getClass();
                        if (StringsKt.contains$default(lowerCase2, filterString) || StringsKt.contains$default(lowerCase, filterString)) {
                        }
                    }
                    this.filteredPrefs.add(preference);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                String key = preference.getKey();
                String message = e.getMessage();
                StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Search: ", filterString, " ? ", key, " Exception: ");
                sbM6m.append(message);
                Logger.logInfo(sbM6m.toString());
            }
        }
        notifyDataSetChanged();
    }

    private final PreferenceScreen inflatePreferenceScreen(PreferenceManager pm, int resource) {
        try {
            Method declaredMethod = Class.forName(pm.getClass().getName()).getDeclaredMethod("inflateFromResource", Context.class, Integer.TYPE, PreferenceScreen.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(pm, this.context, Integer.valueOf(resource), null);
            objInvoke.getClass();
            return (PreferenceScreen) objInvoke;
        } catch (Throwable th) {
            Logger.logSevere(Logger.defaultTag, getTag(), th);
            return null;
        }
    }

    private final void mapPreferences(List<Preference> list, Map<Preference, SimpleSettingsActivity> map, Map<Preference, PreferenceGroup> parentMap, PreferenceGroup group, SimpleSettingsActivity activity) {
        SearchPreferenceAdapter searchPreferenceAdapter;
        List<Preference> list2;
        Map<Preference, SimpleSettingsActivity> map2;
        Map<Preference, PreferenceGroup> map3;
        SimpleSettingsActivity simpleSettingsActivity;
        if (group != null) {
            int preferenceCount = group.getPreferenceCount();
            int i = 0;
            while (i < preferenceCount) {
                Preference preference = group.getPreference(i);
                String strM = FileInsert$$ExternalSyntheticOutline0.m("Pref ", preference.getKey());
                Logger.logInfo(Logger.defaultTag, this.getTag() + ": " + strM, null);
                if (preference instanceof PreferenceGroup) {
                    searchPreferenceAdapter = this;
                    list2 = list;
                    map2 = map;
                    map3 = parentMap;
                    simpleSettingsActivity = activity;
                    searchPreferenceAdapter.mapPreferences(list2, map2, map3, (PreferenceGroup) preference, simpleSettingsActivity);
                } else {
                    searchPreferenceAdapter = this;
                    list2 = list;
                    map2 = map;
                    map3 = parentMap;
                    simpleSettingsActivity = activity;
                    if (preference.getTitle() != null && !Intrinsics.areEqual("Advance settings", preference.getTitle()) && preference.getIcon() != null) {
                        list2.add(preference);
                        map2.put(preference, simpleSettingsActivity);
                        map3.put(preference, group);
                    }
                }
                i++;
                this = searchPreferenceAdapter;
                list = list2;
                map = map2;
                parentMap = map3;
                activity = simpleSettingsActivity;
            }
        }
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void filter(IFilterListAdapter.IFilter filter) {
        filterItems(filter != null ? filter.getFilterString() : null);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.filteredPrefs.size();
    }

    @Override // android.widget.Adapter
    public Preference getItem(int position) {
        return this.filteredPrefs.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        CharSequence title;
        if (convertView == null) {
            convertView = InflatorUtil.INSTANCE.get(this.context).inflate(R.layout.preference_search, parent, false);
            convertView.getClass();
        }
        Preference item = getItem(position);
        TextView textView = (TextView) convertView.findViewById(R.id.path);
        if (textView != null) {
            Context context = convertView.getContext();
            SimpleSettingsActivity simpleSettingsActivity = this.activityMap.get(getItem(position));
            String string = context.getString(simpleSettingsActivity != null ? simpleSettingsActivity.getTitleResource() : R.string.settings);
            PreferenceGroup preferenceGroup = this.parentMap.get(getItem(position));
            if (preferenceGroup == null || (title = preferenceGroup.getTitle()) == null) {
                title = "";
            }
            textView.setText(string + " > " + ((Object) title) + " ");
        }
        TextView textView2 = (TextView) convertView.findViewById(android.R.id.title);
        if (textView2 != null) {
            textView2.setText(String.valueOf(item.getTitle()));
        }
        ImageView imageView = (ImageView) convertView.findViewById(android.R.id.icon);
        if (imageView != null) {
            imageView.setImageDrawable(item.getIcon());
        }
        TextView textView3 = (TextView) convertView.findViewById(android.R.id.summary);
        if (textView3 != null) {
            textView3.setText(item.getSummary());
        }
        TextView textView4 = (TextView) convertView.findViewById(android.R.id.summary);
        if (textView4 != null) {
            textView4.setVisibility(item.getSummary() == null ? 8 : 0);
        }
        return convertView;
    }

    public final void init() {
        ArrayList<SimpleSettingsActivity> arrayList = this.preferenceActivities;
        arrayList.add(new AlarmSettingsActivity());
        arrayList.add(new AutomationSettingsActivity());
        arrayList.add(new BackupAlarmSettingsActivity());
        arrayList.add(new BedtimeSettingsActivity());
        arrayList.add(new CaptchaSettingsActivity());
        arrayList.add(new CaptchaCheatingSettingsActivity());
        arrayList.add(new GentleSettingsActivity());
        arrayList.add(new JetLagSettingsActivity());
        arrayList.add(new LucidSettingsActivity());
        arrayList.add(new LullabySettingsActivity());
        arrayList.add(new MiscSettingsActivity());
        arrayList.add(new MorningScreenSettingsActivity());
        arrayList.add(new NoiseSettingsActivity());
        arrayList.add(new PairSettingsActivity());
        arrayList.add(new PrivacySettingsActivity());
        arrayList.add(new ServicesSettingsActivity());
        arrayList.add(new StatsSettingsActivity());
        arrayList.add(new SmartLightSettingsActivity());
        arrayList.add(new SmartSettingsActivity());
        arrayList.add(new SmartwatchSettingsActivity());
        arrayList.add(new SnoozeSettingsActivity());
        arrayList.add(new SoundRecognitionSettingsActivity());
        arrayList.add(new SocialSettingsActivity());
        arrayList.add(new StatsSettingsActivity());
        arrayList.add(new TrackSettingsActivity());
        arrayList.add(new TrackAutoSettingsActivity());
        arrayList.add(new AwakeSettingsActivity());
        Iterator<SimpleSettingsActivity> it = this.preferenceActivities.iterator();
        it.getClass();
        while (it.hasNext()) {
            SimpleSettingsActivity next = it.next();
            next.getClass();
            SimpleSettingsActivity simpleSettingsActivity = next;
            PreferenceScreen preferenceScreenInflatePreferenceScreen = inflatePreferenceScreen(this.pm, simpleSettingsActivity.getPreferenceResource());
            String str = "Pref screen " + simpleSettingsActivity.getClass() + " res=" + simpleSettingsActivity.getPreferenceResource() + " -> " + preferenceScreenInflatePreferenceScreen;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            mapPreferences(this.prefs, this.activityMap, this.parentMap, preferenceScreenInflatePreferenceScreen, simpleSettingsActivity);
        }
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void notifyChanged() {
        notifyDataSetChanged();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Preference preference = this.filteredPrefs.get(position);
        Activity activity = this.context;
        Activity activity2 = this.context;
        SimpleSettingsActivity simpleSettingsActivity = this.activityMap.get(preference);
        Intent intent = new Intent(activity2, simpleSettingsActivity != null ? simpleSettingsActivity.getClass() : null);
        intent.putExtra("extra_highlight_key", preference.getKey());
        activity.startActivity(intent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void pause() {
    }
}
