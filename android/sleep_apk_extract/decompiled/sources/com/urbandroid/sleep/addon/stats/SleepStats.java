package com.urbandroid.sleep.addon.stats;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationBarView;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.addon.stats.filter.AcceptAllFilter;
import com.urbandroid.sleep.addon.stats.filter.FilterFactory;
import com.urbandroid.sleep.addon.stats.filter.IFilter;
import com.urbandroid.sleep.addon.stats.model.IStatRepo;
import com.urbandroid.sleep.addon.stats.model.NoRecordsException;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.addon.stats.util.ImageCreator;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.NoSwipeViewPager;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.image.ShareDataUtil;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.achartengine.GraphicalView;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class SleepStats extends BaseActivity implements AdapterView.OnItemSelectedListener {
    public static int CUTOFF = 0;
    public static float DENSITY = 0.0f;
    public static int FILTER = 0;
    public static int IDEAL = 420;
    public static String KEY_IDEAL = "key_ideal_m";
    public static String KEY_PERIOD = "key_period";
    public static String KEY_TAB = "key_tab_2";
    private ChartFragmentAdapter chartAdapter;
    private FilterAdapter filterAdapter;
    private Spinner filterSpinner;
    private List<float[]> heatMap;
    private LinearLayout layout;
    private Spinner periodSpinner;
    private SharedPreferences preferences;
    private ProgressBar progress;
    private StatRepo statRepo;
    private ViewPager viewPager;
    public static IFilter FILTER_INSTANCE = new AcceptAllFilter();
    public static int DAYS = 8;
    public static int PERIOD_INDEX = 1;
    public static final Uri PREF_CONTENT_URI = Uri.parse("content://com.urbandroid.sleep.preference/preferences");
    public static int[] PERIODS = {8, 15, 31, 92, 183, 367, 3650};
    public boolean noData = false;
    private int initialTab = -1;
    private List<StatRecord> mergedStatRecords = new ArrayList();
    private List<StatRecord> rawStatRecords = new ArrayList();
    private int currentTab = 0;
    private List<GraphicalView> graphicalViews = new ArrayList();
    private int[] idealValues = new int[81];
    private String[] idealEntries = new String[82];

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.SleepStats$8, reason: invalid class name */
    public class AnonymousClass8 extends AsyncTask<Void, Void, Void> {
        public AnonymousClass8() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$0() {
            Logger.logInfo("SleepStats: Delayed adapter defresh");
            SleepStats.this.refreshAdapter();
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            Logger.logInfo("SleepStats: Repo init start");
            try {
                SleepStats.this.statRepo.initialize(SleepStats.this, (Date) null, StatRepo.Mode.FULL);
                SleepStats sleepStats = SleepStats.this;
                sleepStats.mergedStatRecords = sleepStats.statRepo.getMergedStatRecords();
                SleepStats sleepStats2 = SleepStats.this;
                sleepStats2.rawStatRecords = sleepStats2.statRepo.getRawStatRecords();
                if (SleepStats.this.mergedStatRecords.size() < 1) {
                    SleepStats.this.noRecords();
                }
                Collections.sort(SleepStats.this.rawStatRecords, new Comparator<StatRecord>() { // from class: com.urbandroid.sleep.addon.stats.SleepStats.8.1
                    @Override // java.util.Comparator
                    public int compare(StatRecord statRecord, StatRecord statRecord2) {
                        return statRecord.getToDate().compareTo(statRecord2.getToDate());
                    }
                });
                SleepStats.this.heatMap = new ArrayList();
                Iterator it = SleepStats.this.rawStatRecords.iterator();
                while (it.hasNext()) {
                    SleepStats.this.heatMap.add(((StatRecord) it.next()).getData());
                }
                Logger.logInfo("SleepStats: Heat map size " + SleepStats.this.heatMap.size());
                SleepStats.this.recalculateStats();
                return null;
            } catch (NoRecordsException e) {
                Logger.logSevere(e);
                SleepStats.this.saadMissing();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r5) {
            Logger.logInfo("SleepStats: Repo init post");
            SleepStats.this.periodSpinner.setOnItemSelectedListener(SleepStats.this);
            SleepStats.this.filterSpinner.setOnItemSelectedListener(SleepStats.this);
            SleepStats.this.setupTabs();
            SleepStats.this.refreshTags();
            SleepStats.this.hideProgress();
            int i = 0;
            SleepStats.this.findViewById(R.id.navigation).setVisibility(0);
            SleepStats sleepStats = SleepStats.this;
            if (sleepStats.noData) {
                ((BaseActivity) sleepStats).h.postDelayed(new SleepStats$8$$ExternalSyntheticLambda0(this, i), 1L);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Logger.logInfo("SleepStats: Repo init pre");
            SleepStats sleepStats = SleepStats.this;
            sleepStats.showProgress(sleepStats.getResources().getString(R.string.stats_caption_loading));
            ((BottomNavigationView) SleepStats.this.findViewById(R.id.navigation)).setOnItemSelectedListener(null);
            ((BottomNavigationView) SleepStats.this.findViewById(R.id.navigation)).setVisibility(8);
        }
    }

    private void calculateAdvice() {
        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.addon.stats.SleepStats.9
            @Override // android.os.AsyncTask
            public void onPostExecute(Void r1) {
                SleepStats.this.hideProgress();
                SleepStats.this.refreshAdapter();
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                SleepStats sleepStats = SleepStats.this;
                sleepStats.showProgress(sleepStats.getResources().getString(R.string.stats_caption_loading));
            }

            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                SleepStats.this.recalculateStats();
                return null;
            }
        }.execute(new Void[0]);
    }

    private int getDayIncidenceHour(Context context) {
        String string;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(PREF_CONTENT_URI, null, "day_incidence_hour", null, null);
                if (cursorQuery.moveToFirst() && (string = cursorQuery.getString(0)) != null) {
                    try {
                        int i = Integer.parseInt(string);
                        try {
                            cursorQuery.close();
                            return i;
                        } catch (Exception e) {
                            Logger.logSevere(e);
                            return i;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            } catch (Exception e2) {
                Logger.logSevere(e2);
                if (cursorQuery != null) {
                }
                return 0;
            }
            try {
                cursorQuery.close();
            } catch (Exception e3) {
                Logger.logSevere(e3);
            }
            return 0;
        } finally {
        }
    }

    public static int getDip(int i) {
        float f = DENSITY;
        return f != -1.0f ? (int) ((i * f) + 0.5f) : i;
    }

    private synchronized void initializeRepo() {
        this.statRepo = new StatRepo();
        new AnonymousClass8().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noRecords() {
        final MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setTitle(R.string.app_title_stats);
        materialAlertDialogBuilder.setMessage(R.string.no_records).setCancelable(false).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.addon.stats.SleepStats.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        runOnUiThread(new Runnable() { // from class: com.urbandroid.sleep.addon.stats.SleepStats.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    materialAlertDialogBuilder.show();
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void recalculateStats() {
        this.statRepo.calculate(this);
    }

    private void refresh(final boolean z) {
        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.addon.stats.SleepStats.3
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                Logger.logDebug("SleepStats: Refreshing view cache");
                SleepStats.this.recalculateStats();
                return null;
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Void r3) {
                Logger.logDebug("SleepStats: Refresh post");
                SleepStats.this.hideProgress();
                SleepStats.this.refreshAdapter();
                if (z) {
                    SleepStats.this.refreshTags();
                }
                int i = SleepStats.this.getResources().getConfiguration().orientation;
                SleepStats sleepStats = SleepStats.this;
                if (i == 2) {
                    sleepStats.findViewById(R.id.navigation).setVisibility(8);
                } else {
                    sleepStats.findViewById(R.id.navigation).setVisibility(0);
                }
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                SleepStats sleepStats = SleepStats.this;
                sleepStats.showProgress(sleepStats.getResources().getString(R.string.stats_caption_loading));
                SleepStats.this.findViewById(R.id.navigation).setVisibility(8);
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTags() {
        this.filterAdapter.setTags(this.statRepo.getAvailableTags());
        this.filterAdapter.setCounts(this.statRepo.getAvailableTagCounts());
        this.filterAdapter.notifyDataSetChanged();
        this.filterSpinner.setSelection(0);
        this.filterSpinner.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saadMissing() {
        final MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setTitle(R.string.stats);
        materialAlertDialogBuilder.setMessage(R.string.no_records).setCancelable(false).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.addon.stats.SleepStats.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SleepStats.this.finish();
            }
        });
        runOnUiThread(new Runnable() { // from class: com.urbandroid.sleep.addon.stats.SleepStats.5
            @Override // java.lang.Runnable
            public void run() {
                materialAlertDialogBuilder.show();
            }
        });
    }

    private ArrayAdapter<CharSequence> setupSpinner(Spinner spinner, Object[] objArr) {
        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter(this, R.layout.spinner, objArr) { // from class: com.urbandroid.sleep.addon.stats.SleepStats.1
            @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
            public View getDropDownView(int i, View view, ViewGroup viewGroup) {
                View dropDownView = super.getDropDownView(i, view, viewGroup);
                ((TextView) dropDownView).setGravity(17);
                return dropDownView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = (TextView) super.getView(i, view, viewGroup);
                textView.setTextColor(ContextCompat.getColor(SleepStats.this, R.color.primary));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                return textView;
            }
        };
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        return arrayAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupTabs() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        this.viewPager = viewPager;
        if (viewPager instanceof NoSwipeViewPager) {
            ((NoSwipeViewPager) viewPager).setPagingEnabled(false);
        }
        this.viewPager.setOffscreenPageLimit(0);
        ChartFragmentAdapter chartFragmentAdapter = new ChartFragmentAdapter(getSupportFragmentManager(), this);
        this.chartAdapter = chartFragmentAdapter;
        this.viewPager.setAdapter(chartFragmentAdapter);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(bottomNavigationView.getMenu().getItem(this.currentTab).getItemId());
        ((BottomNavigationView) findViewById(R.id.navigation)).setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: com.urbandroid.sleep.addon.stats.SleepStats.2
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                SleepStats.this.viewPager.setCurrentItem(menuItem.getOrder(), true);
                SleepStats.this.currentTab = menuItem.getOrder();
                return true;
            }
        });
        int i = this.initialTab;
        if (i != -1) {
            this.viewPager.setCurrentItem(i);
            saveCurrentTab(this.initialTab);
            this.initialTab = -1;
        }
    }

    public static void startChronotype(Context context) {
        Intent intent = new Intent(context, (Class<?>) SleepStats.class);
        intent.putExtra("extra_tab", 2);
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        context.startActivity(intent);
    }

    public static void startFirst(Context context) {
        Intent intent = new Intent(context, (Class<?>) SleepStats.class);
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        context.startActivity(intent);
    }

    public static void startFirstHandleTrial(Context context) {
        if (!TrialFilter.getInstance().isTrialExpired()) {
            startFirst(context);
        } else {
            if (!(context instanceof Activity)) {
                Toast.makeText(context, R.string.expire_info_freemium_first, 1).show();
                return;
            }
            MaterialAlertDialogBuilder icon = new MaterialAlertDialogBuilder(context).setMessage((CharSequence) context.getString(R.string.unlock_text)).setTitle(R.string.app_name_long_unlock).setIcon(R.drawable.ic_lock_unlock);
            final Activity activity = (Activity) context;
            icon.setPositiveButton(R.string.trial_unlock, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.addon.stats.SleepStats$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AlarmClock.startPurchaseFlow(activity);
                }
            }).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    private void updateIdeal() {
        IDEAL = SharedApplicationContext.getSettings().getIdealSleepMinutes();
    }

    public List<float[]> getHeatMap() {
        return this.heatMap;
    }

    public List<StatRecord> getMergedStatRecords() {
        return this.mergedStatRecords;
    }

    public int getPeriod() {
        int selectedItemPosition = this.periodSpinner.getSelectedItemPosition();
        if (selectedItemPosition <= 0) {
            return 7;
        }
        int[] iArr = PERIODS;
        if (selectedItemPosition < iArr.length) {
            return iArr[selectedItemPosition];
        }
        return 7;
    }

    public List<StatRecord> getRawStatRecords() {
        return this.rawStatRecords;
    }

    public IStatRepo getStatRepo() {
        return this.statRepo;
    }

    public synchronized void hideProgress() {
        try {
            ProgressBar progressBar = this.progress;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager != null) {
                viewPager.setVisibility(0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setStatusBarColor(ColorUtil.i(this, R.color.bg_card));
        setContentView(R.layout.activity_charts);
        this.progress = (ProgressBar) findViewById(R.id.init_progress);
        GlobalInitializator.initializeIfRequired(this);
        ToolbarUtil.apply(this);
        TintUtil.tint(this);
        SharedApplicationContext.getSettings().addShowCaseShown("sc_charts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.layout = (LinearLayout) findViewById(R.id.chart);
        int i = 0;
        for (int i2 = 30; i2 < 840; i2 += 10) {
            this.idealValues[i] = i2;
            int i3 = IDEAL;
            String[] strArr = this.idealEntries;
            if (i2 == i3) {
                strArr[i] = getResources().getString(R.string.schedule_ideal);
            } else {
                strArr[i] = DateUtil.formatMinutes(Integer.valueOf(i2));
            }
            i++;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.preferences = defaultSharedPreferences;
        IDEAL = defaultSharedPreferences.getInt(KEY_IDEAL, 240);
        DAYS = Math.min(this.preferences.getInt(KEY_PERIOD, 8), PERIODS[6]);
        this.currentTab = this.preferences.getInt(KEY_TAB, 0);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("extra_tab", 0);
            this.initialTab = intExtra;
            this.currentTab = intExtra;
            zza$$ExternalSyntheticOutline0.m(new StringBuilder("Charts: tab param "), this.initialTab);
        }
        this.filterSpinner = (Spinner) findViewById(R.id.filter);
        FilterAdapter filterAdapter = new FilterAdapter(this);
        this.filterAdapter = filterAdapter;
        this.filterSpinner.setAdapter((SpinnerAdapter) filterAdapter);
        this.filterAdapter.setDropDownViewResource(R.layout.charts_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.period);
        this.periodSpinner = spinner;
        setupSpinner(spinner, R.array.period_array);
        DENSITY = getResources().getDisplayMetrics().density;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_charts, menu);
        MenuUtil.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        Logger.logInfo("SleepStats: onItemSelected " + i + " " + j);
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        if (adapterView.equals(this.periodSpinner)) {
            FILTER = 0;
            FILTER_INSTANCE = FilterFactory.getFilter(0, "");
            DAYS = PERIODS[i];
            PERIOD_INDEX = i;
            zza$$ExternalSyntheticOutline0.m(new StringBuilder("SleepStats: period SAVE "), DAYS);
            editorEdit.putInt(KEY_PERIOD, DAYS);
            if (this.currentTab != 3) {
                refresh();
            } else {
                calculateAdvice();
            }
        } else if (adapterView.equals(this.filterSpinner)) {
            int selectedItemPosition = this.filterSpinner.getSelectedItemPosition();
            FILTER = selectedItemPosition;
            FILTER_INSTANCE = FilterFactory.getFilter(selectedItemPosition, this.filterAdapter.getItem(this.filterSpinner.getSelectedItemPosition()));
            if (this.currentTab != 3) {
                refresh(false);
            } else {
                calculateAdvice();
            }
        }
        editorEdit.apply();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_doc) {
            ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/charts.html");
            return true;
        }
        if (itemId != R.id.menu_share) {
            return false;
        }
        try {
            String str = "charts" + System.currentTimeMillis() + ".png";
            ShareDataUtil.saveData(this, str, ImageCreator.convertBitmapIntoPNGBytes(com.urbandroid.sleep.gui.ImageCreator.createBitmapWithLogo(findViewById(R.id.viewpager_parent))));
            startActivity(ShareDataUtil.createIntent(this, str, getString(R.string.charts_summary) + ", " + getString(R.string.app_name_long)));
        } catch (Exception e) {
            Logger.logSevere(e);
            Toast.makeText(this, "Cannot save share file", 0).show();
        }
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        int i = 0;
        FILTER = 0;
        FILTER_INSTANCE = FilterFactory.getFilter(0, null);
        initializeRepo();
        if (FILTER < this.filterAdapter.getCount()) {
            this.filterSpinner.setSelection(FILTER, true);
        } else {
            FILTER = 0;
            FILTER_INSTANCE = FilterFactory.getFilter(0, "");
            this.filterSpinner.setSelection(FILTER, true);
        }
        while (true) {
            int[] iArr = PERIODS;
            if (i >= iArr.length) {
                break;
            }
            if (iArr[i] == DAYS) {
                this.periodSpinner.setSelection(i, true);
                PERIOD_INDEX = i;
                break;
            }
            i++;
        }
        CUTOFF = getDayIncidenceHour(this);
        updateIdeal();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.periodSpinner.setOnItemSelectedListener(null);
        this.filterSpinner.setOnItemSelectedListener(null);
        this.initialTab = -1;
    }

    public void refreshAdapter() {
        Logger.logInfo("SleepStats: refreshAdapter");
        ChartFragmentAdapter chartFragmentAdapter = new ChartFragmentAdapter(getSupportFragmentManager(), this);
        this.chartAdapter = chartFragmentAdapter;
        this.viewPager.setAdapter(chartFragmentAdapter);
        this.chartAdapter.notifyDataSetChanged();
        this.viewPager.setCurrentItem(this.currentTab);
    }

    public void saveCurrentTab(int i) {
        this.currentTab = i;
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putInt(KEY_TAB, this.currentTab);
        editorEdit.apply();
        Logger.logInfo("Saving tab " + i);
    }

    public synchronized void showProgress(String str) {
        try {
            ProgressBar progressBar = this.progress;
            if (progressBar != null) {
                progressBar.setVisibility(0);
                this.progress.setIndeterminate(true);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager != null) {
                viewPager.setVisibility(8);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void refresh() {
        refresh(true);
    }

    private ArrayAdapter<CharSequence> setupSpinner(Spinner spinner, int i) {
        return setupSpinner(spinner, getResources().getTextArray(i));
    }

    public static void startFirstHandleTrial(Context context, String str) {
        SharedApplicationContext.getSettings().setChartTrendLastSelectedGraphTitle(str);
        startFirstHandleTrial(context);
    }
}
