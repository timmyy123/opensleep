package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.animation.Animator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.work.impl.Schedulers$$ExternalSyntheticLambda1;
import com.facebook.internal.Utility;
import com.facebook.login.LoginManager$$ExternalSyntheticLambda1;
import com.facebook.share.internal.ShareConstants;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.error.IErrorDialogAction;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.releasenotes.ReleaseNotes;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.common.util.PowerManagerCompat;
import com.urbandroid.common.util.PreferencesUtils;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.privacy.Consent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.FirstUsePreviewActivity;
import com.urbandroid.sleep.NewAddRecordActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.StartShortcutActivity;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.achievement.AchievementActivity;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionPermission;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.advice.AdviceActivity;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.ads.AdMobController;
import com.urbandroid.sleep.ads.IAdsController;
import com.urbandroid.sleep.ai.AiActivity;
import com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.NoEscapeActivity;
import com.urbandroid.sleep.alarmclock.settings.NoEscapeManager;
import com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SearchActivity;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.appwidget.DroidWidget;
import com.urbandroid.sleep.async.ExportDataAsyncTask;
import com.urbandroid.sleep.async.IHasProgressContext;
import com.urbandroid.sleep.async.ImportDataAsyncTask;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.captcha.LOLCaptcha$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.promo.PromoEvent;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.errorreporting.ErrorReporting;
import com.urbandroid.sleep.fragment.AlarmFragment;
import com.urbandroid.sleep.fragment.GraphFragment;
import com.urbandroid.sleep.fragment.ILazyFragment;
import com.urbandroid.sleep.fragment.NoiseFragment;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
import com.urbandroid.sleep.fragment.TabTuneActivity;
import com.urbandroid.sleep.fragment.addon.AddonFragment;
import com.urbandroid.sleep.fragment.dashboard.DashboardFragment;
import com.urbandroid.sleep.fragment.dashboard.TabTuneFragment;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.NoSwipeViewPager;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.dialog.DocItemDialogFragment;
import com.urbandroid.sleep.gui.drawer.IMenuDrawerItem;
import com.urbandroid.sleep.gui.drawer.MenuDrawerAppTitle;
import com.urbandroid.sleep.gui.drawer.MenuDrawerEnd;
import com.urbandroid.sleep.gui.drawer.MenuDrawerHeader;
import com.urbandroid.sleep.gui.drawer.MenuDrawerHomeScreen;
import com.urbandroid.sleep.gui.drawer.MenuDrawerItem;
import com.urbandroid.sleep.gui.drawer.MenuDrawerLongItem;
import com.urbandroid.sleep.gui.drawer.MenuDrawerRecyclerViewAdapter;
import com.urbandroid.sleep.gui.drawer.MenuDrawerSection;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener;
import com.urbandroid.sleep.media.lullaby.LullabyActivity;
import com.urbandroid.sleep.nearby.pairtracking.PairTracking;
import com.urbandroid.sleep.persistence.ExportUtilKt;
import com.urbandroid.sleep.service.DeleteObsoleteNoisesService;
import com.urbandroid.sleep.service.NoiseMediaStoreJob;
import com.urbandroid.sleep.service.PromoSyncJob;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.fit.GoogleFitSyncJobService;
import com.urbandroid.sleep.service.invites.InviteUtils;
import com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthSyncJobService;
import com.urbandroid.sleep.shortcut.ShortcutActivity;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.sleep.trial.IBillingServiceStatusListener;
import com.urbandroid.sleep.trial.IBillingStatusListener;
import com.urbandroid.sleep.trial.JavaBilling;
import com.urbandroid.sleep.trial.eu.LocationUtils;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.VolumeUtil;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.io.ByteStreamsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmClock extends BaseActivity implements IHasProgressContext {
    public static String ACTION_START_DOWNLOAD_FROM_CLOUD = "com.urbandroid.sleep.ACTION_START_DOWNLOAD_FROM_CLOUD";
    public static String ACTIVITY_RECOGNITION_INTENT_ACTION = "com.urbandroid.sleep.ACTION_PROCESS_ACTIVITY_TRANSITIONS";
    public static boolean refreshAfterResume = false;
    private IAdsController adMobController;
    private Animation attentionAnim;
    private JavaBilling billing;
    private MenuDrawerRecyclerViewAdapter drawerAdapter;
    private DrawerLayout drawerLayout;
    private RecyclerView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private Animation fadeInAnim;
    private Animation fadeOutAnim;
    private Handler h;
    private Animation hideAnim;
    private AlertDialog homeScreenSelectionDialog;
    private ViewGroup leftDrawerLayout;
    private MenuItem menuItemAdd;
    private BottomNavigationView navigation;
    private ProgressContext progressContext;
    private BroadcastReceiver receiver;
    private Settings settings;
    private Animation showAnim;
    private Animation showFab;
    private Snackbar snoozeSnackbar;
    private TabsAdapter tabsAdapter;
    private TabLayout tabsLayout;
    private TextView trialInfo;
    private ViewGroup trialLayout;
    private TextView trialUnlock;
    public UnlockFlow unlockFlow;
    private ViewPager viewPager;
    public static Map<Class, Integer> fragmentIdMap = new HashMap();
    private static long lastBSRefreshTimestamp = 0;
    private static long lastShownUndoOperationTimestamp = 0;
    private static Snackbar undoSnackbar = null;
    private boolean promo = false;
    private boolean isShown = false;
    private boolean resumed = false;
    private boolean isInWideLandscapeMode = false;
    private boolean isTabNoise = true;
    private boolean isTabAddon = true;
    private boolean isTabGraphs = true;
    private boolean isTabStats = true;
    private boolean isTabDashboard = false;
    private boolean isTabTune = true;
    private boolean isDashboard = false;
    private boolean isAlarmOnly = false;
    private final List<Object> napDrawerItems = new LinkedList();
    private int toolbarMarginTop = -1;
    private AppBarStateChangeListener.State appbarState = null;
    private final Runnable unlockAttentionRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.23
        @Override // java.lang.Runnable
        public void run() {
            if (AlarmClock.this.trialUnlock == null || AlarmClock.this.attentionAnim == null || !AlarmClock.this.trialUnlock.isShown()) {
                return;
            }
            AlarmClock.this.trialUnlock.startAnimation(AlarmClock.this.attentionAnim);
        }
    };

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.AlarmClock$34, reason: invalid class name */
    public class AnonymousClass34 implements DialogInterface.OnClickListener {
        final /* synthetic */ String val$packageName;
        final /* synthetic */ Settings val$settings;

        public AnonymousClass34(Settings settings, String str) {
            this.val$settings = settings;
            this.val$packageName = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onClick$1(Settings settings, DialogInterface dialogInterface, int i) {
            settings.setRateNever();
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Rate_never");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String string;
            this.val$settings.setRateDislike(false);
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(AlarmClock.this.getActivity());
            AlarmClock alarmClock = AlarmClock.this;
            boolean zEquals = "com.urbandroid.sleep.full.key".equals(this.val$packageName);
            AlarmClock alarmClock2 = AlarmClock.this;
            if (zEquals) {
                string = alarmClock2.getString(R.string.rate_text_2) + " (" + AlarmClock.this.getString(R.string.app_name_long_unlock) + ")";
            } else {
                string = alarmClock2.getString(R.string.rate_text_2);
            }
            int i2 = 1;
            materialAlertDialogBuilder.setView(DialogUtil.getImageDialogView(alarmClock, string, R.drawable.ratedroid)).setPositiveButton(R.string.rate, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.34.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface2, int i3) {
                    ViewIntent.market(AlarmClock.this.getActivity(), AnonymousClass34.this.val$packageName);
                    AnonymousClass34.this.val$settings.setRateDone();
                    SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Rate_done");
                }
            }).setNegativeButton(R.string.button_captcha_cancel, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda22(this.val$settings, i2)).setNeutralButton(R.string.never, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda22(this.val$settings, 2)).setOnCancelListener((DialogInterface.OnCancelListener) new AlarmClock$$ExternalSyntheticLambda23(this.val$settings, i2)).show();
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.AlarmClock$54, reason: invalid class name */
    public class AnonymousClass54 extends ArrayAdapter<String> {
        final /* synthetic */ Settings val$settings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass54(Context context, int i, Settings settings) {
            super(context, i);
            this.val$settings = settings;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getView$0(Settings settings, int i, View view) {
            settings.setDashboard(false);
            settings.setAlarmOnly(false);
            if (i == 0) {
                settings.setDashboard(true);
            } else if (i == 2) {
                settings.setAlarmOnly(true);
            }
            if (AlarmClock.this.homeScreenSelectionDialog != null && AlarmClock.this.homeScreenSelectionDialog.isShowing()) {
                AlarmClock.this.homeScreenSelectionDialog.dismiss();
            }
            AlarmClock.this.finish();
            AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) AlarmClock.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getView$1(View view) {
            AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) TabTuneActivity.class));
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) AlarmClock.this.getLayoutInflater().inflate(R.layout.select_dialog_item_with_action, (ViewGroup) null);
            ((TextView) viewGroup2.findViewById(android.R.id.text1)).setText((CharSequence) getItem(i));
            View viewFindViewById = viewGroup2.findViewById(android.R.id.text1);
            final Settings settings = this.val$settings;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock$54$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$getView$0(settings, i, view2);
                }
            });
            ((TextView) viewGroup2.findViewById(android.R.id.text1)).setCompoundDrawablesRelativeWithIntrinsicBounds(this.val$settings.getHomeScreenIcon(i), 0, 0, 0);
            int selectedHomeScreen = this.val$settings.getSelectedHomeScreen();
            AlarmClock alarmClock = AlarmClock.this;
            if (selectedHomeScreen == i) {
                viewGroup2.setBackgroundColor(ColorUtil.i(alarmClock, R.color.selection));
            } else {
                viewGroup2.setBackgroundColor(ColorUtil.i(alarmClock, R.color.transparent));
            }
            int i2 = 1;
            if (i != 1) {
                viewGroup2.findViewById(R.id.action).setVisibility(8);
                return viewGroup2;
            }
            viewGroup2.findViewById(R.id.action).setVisibility(0);
            ((ImageButton) viewGroup2.findViewById(R.id.action)).setImageResource(R.drawable.ic_pencil);
            viewGroup2.findViewById(R.id.action).setOnClickListener(new EditActivity$$ExternalSyntheticLambda0(this, i2));
            return viewGroup2;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.AlarmClock$55, reason: invalid class name */
    /* JADX INFO: loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass55 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$trial$IBillingStatusListener$Status;

        static {
            int[] iArr = new int[IBillingStatusListener.Status.values().length];
            $SwitchMap$com$urbandroid$sleep$trial$IBillingStatusListener$Status = iArr;
            try {
                iArr[IBillingStatusListener.Status.OWNED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$trial$IBillingStatusListener$Status[IBillingStatusListener.Status.NOT_OWNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$trial$IBillingStatusListener$Status[IBillingStatusListener.Status.PURCHASE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class GraphFragmentUpdater implements Runnable {
        public GraphFragmentUpdater() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlarmClock.this.updateOnGraphsChange();
        }
    }

    public class TabsAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {
        private final ActionBar actionBar;
        private AddonFragment addonFragment;
        private AlarmFragment alarmFragment;
        private final Context context;
        private final Map<Integer, ILazyFragment> createdFragments;
        private DashboardFragment dashboardFragment;
        private GraphFragment graphFragment;
        private final Handler h;
        private final Runnable handleTabShowCaseRunnable;
        private NoiseFragment noiseFragment;
        private StatsFragmentNew statsFragment;
        private Drawable tabIcon;
        private final Runnable tabIconAnimator;
        private Handler tabIconHandler;
        private TabTuneFragment tabTuneFragment;
        private final ArrayList<TabInfo> tabs;
        private final ViewPager viewPager;

        public final class TabInfo {
            private final Bundle args;
            private final Class<?> clss;
            private final int iconDrawable;
            private final int titleRes;

            public TabInfo(int i, Bundle bundle, Class<?> cls, int i2) {
                this.titleRes = i;
                this.args = bundle;
                this.clss = cls;
                this.iconDrawable = i2;
            }
        }

        public TabsAdapter(AppCompatActivity appCompatActivity, ViewPager viewPager) {
            super(appCompatActivity.getSupportFragmentManager());
            this.tabs = new ArrayList<>();
            this.createdFragments = new HashMap();
            this.tabIconAnimator = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.TabsAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TabsAdapter.this.tabIcon != null) {
                        Object current = TabsAdapter.this.tabIcon.getCurrent();
                        TabsAdapter.this.tabIcon = null;
                        if (current == null || !(current instanceof Animatable)) {
                            return;
                        }
                        Logger.logInfo("tab animable " + current);
                        Animatable animatable = (Animatable) current;
                        if (animatable.isRunning()) {
                            return;
                        }
                        animatable.stop();
                        animatable.start();
                    }
                }
            };
            this.handleTabShowCaseRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.TabsAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    TabsAdapter.this.handleTabShowCase();
                }
            };
            this.context = appCompatActivity;
            this.actionBar = appCompatActivity.getSupportActionBar();
            this.viewPager = viewPager;
            viewPager.setAdapter(this);
            viewPager.setOnPageChangeListener(this);
            this.h = new Handler();
        }

        private Set<Integer> getVisiblePositions(int i) {
            HashSet hashSet = new HashSet();
            if (!AlarmClock.this.isInWideLandscapeMode) {
                hashSet.add(Integer.valueOf(i));
                return hashSet;
            }
            if (i > getCount() - 2) {
                i = getCount() - 2;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                hashSet.add(Integer.valueOf(i + i2));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleTabShowCase() {
        }

        private String makeFragmentName(long j) {
            if (this.viewPager == null) {
                return "";
            }
            return "android:switcher:" + this.viewPager.getId() + ":" + j;
        }

        private <T> T reassociateFragment(FragmentManager fragmentManager, Class<T> cls) {
            T t = (T) fragmentManager.findFragmentByTag(makeFragmentName(AlarmClock.fragmentIdMap.get(cls).intValue()));
            if (t != null) {
                Iterator<TabInfo> it = this.tabs.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().clss.equals(t.getClass())) {
                        this.createdFragments.put(Integer.valueOf(i), (ILazyFragment) t);
                    }
                    i++;
                }
            }
            return t;
        }

        private void refreshFragmentsOnPageSelection(int i) {
            Set<Integer> visiblePositions = getVisiblePositions(i);
            for (Map.Entry<Integer, ILazyFragment> entry : this.createdFragments.entrySet()) {
                Integer key = entry.getKey();
                ILazyFragment value = entry.getValue();
                if (visiblePositions.contains(key)) {
                    value.setVisible();
                } else {
                    value.setInvisible();
                }
            }
        }

        public void addTab(int i, Class<?> cls, int i2, Bundle bundle) {
            this.tabs.add(new TabInfo(i2, bundle, cls, i));
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.tabs.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            TabInfo tabInfo = this.tabs.get(i);
            Fragment fragmentInstantiate = Fragment.instantiate(this.context, tabInfo.clss.getName(), tabInfo.args);
            if (i == 0) {
                this.alarmFragment = (AlarmFragment) fragmentInstantiate;
            } else if (fragmentInstantiate instanceof GraphFragment) {
                this.graphFragment = (GraphFragment) fragmentInstantiate;
            } else if (fragmentInstantiate instanceof StatsFragmentNew) {
                this.statsFragment = (StatsFragmentNew) fragmentInstantiate;
            } else if (fragmentInstantiate instanceof NoiseFragment) {
                this.noiseFragment = (NoiseFragment) fragmentInstantiate;
            } else if (fragmentInstantiate instanceof AddonFragment) {
                this.addonFragment = (AddonFragment) fragmentInstantiate;
            } else if (fragmentInstantiate instanceof DashboardFragment) {
                this.dashboardFragment = (DashboardFragment) fragmentInstantiate;
            } else if (fragmentInstantiate instanceof TabTuneFragment) {
                this.tabTuneFragment = (TabTuneFragment) fragmentInstantiate;
            }
            ILazyFragment iLazyFragment = (ILazyFragment) fragmentInstantiate;
            this.createdFragments.put(Integer.valueOf(i), iLazyFragment);
            if (getVisiblePositions(this.viewPager.getCurrentItem()).contains(Integer.valueOf(i))) {
                iLazyFragment.setVisible();
            }
            return fragmentInstantiate;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            if (AlarmClock.fragmentIdMap.get(this.tabs.get(i).clss) != null) {
                return r0.intValue();
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown fragment id ", this.tabs.get(i).clss);
            return 0L;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            return AlarmClock.this.isInWideLandscapeMode ? 0.5f : 1.0f;
        }

        public ArrayList<TabInfo> getTabs() {
            return this.tabs;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            zza$$ExternalSyntheticOutline0.m(i, "AlarmClock: Page selected ");
            refreshFragmentsOnPageSelection(i);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Logger.logInfo("AlarmClock: Tab selected " + tab.getPosition());
            int position = tab.getPosition();
            onPageSelected(tab.getPosition());
            this.viewPager.setCurrentItem(tab.getPosition());
            if (Environment.isKitKatOrGreater()) {
                Drawable icon = tab.getIcon();
                this.tabIcon = icon;
                if (icon != null) {
                    if (this.tabIconHandler == null) {
                        Logger.logInfo("tab handler");
                        this.tabIconHandler = new Handler();
                    }
                    this.tabIconHandler.removeCallbacks(this.tabIconAnimator);
                    this.tabIconHandler.postDelayed(this.tabIconAnimator, 250L);
                }
            }
            this.h.removeCallbacks(this.handleTabShowCaseRunnable);
            if (position == 2 && Experiments.getInstance().isShowCaseExperiment() && TrialFilter.getInstance().daysUsed(14, 30)) {
                this.h.postDelayed(this.handleTabShowCaseRunnable, 1000L);
            }
            AlarmClock.this.handleFabChange(tab.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        public void reassociateExistingFragments() {
            Logger.logInfo("AlarmClock: reassociate existing fragments");
            FragmentManager supportFragmentManager = AlarmClock.this.getSupportFragmentManager();
            if (supportFragmentManager == null || AlarmClock.this.isDashboard) {
                return;
            }
            this.alarmFragment = (AlarmFragment) reassociateFragment(supportFragmentManager, AlarmFragment.class);
            this.graphFragment = (GraphFragment) reassociateFragment(supportFragmentManager, GraphFragment.class);
            this.statsFragment = (StatsFragmentNew) reassociateFragment(supportFragmentManager, StatsFragmentNew.class);
            this.noiseFragment = (NoiseFragment) reassociateFragment(supportFragmentManager, NoiseFragment.class);
            this.addonFragment = (AddonFragment) reassociateFragment(supportFragmentManager, AddonFragment.class);
            this.dashboardFragment = (DashboardFragment) reassociateFragment(supportFragmentManager, DashboardFragment.class);
            this.tabTuneFragment = (TabTuneFragment) reassociateFragment(supportFragmentManager, TabTuneFragment.class);
            ViewPager viewPager = this.viewPager;
            refreshFragmentsOnPageSelection(viewPager != null ? viewPager.getCurrentItem() : 0);
        }

        public void reset(int i) {
            Iterator<ILazyFragment> it = this.createdFragments.values().iterator();
            while (it.hasNext()) {
                it.next().setInvisible();
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager != null) {
                viewPager.setAdapter(this);
                this.viewPager.setCurrentItem(i);
            }
            onPageSelected(i);
        }
    }

    private void addNewAlarm() {
        startActivity(new Intent(this, (Class<?>) SetAlarm.class));
    }

    private void animateShowView(final View view, boolean z) {
        if (z && view.getVisibility() == 8 && view.getTag() == null) {
            view.startAnimation(this.showAnim);
            view.setVisibility(0);
        } else {
            if (z || view.getVisibility() != 0) {
                return;
            }
            this.hideAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.29
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(8);
                    AlarmClock.this.hideAnim.setAnimationListener(null);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            view.startAnimation(this.hideAnim);
        }
    }

    private void animateTabChange(int i) {
        animateShowView(findViewById(R.id.droid), i == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDrawer() {
        DrawerLayout drawerLayout = this.drawerLayout;
        if (drawerLayout == null || !drawerLayout.isDrawerOpen(this.leftDrawerLayout)) {
            return;
        }
        this.drawerLayout.closeDrawer(this.leftDrawerLayout);
    }

    private void disableBluetoothLeBasedFeatures(Settings settings) {
        settings.setHrBt(false);
        settings.setOximeter(false);
        if (settings.isDirectBleWearableSelectedForTracking()) {
            settings.setSelectedWearable(Wearable.NONE);
        }
        settings.setPairTracking(false);
    }

    private int getTabCount() {
        if (this.isDashboard) {
            return 0;
        }
        int i = !this.isTabAddon ? 6 : 7;
        if (!this.isTabNoise) {
            i--;
        }
        if (!this.isTabGraphs) {
            i--;
        }
        if (!this.isTabStats) {
            i--;
        }
        if (!this.isTabDashboard) {
            i--;
        }
        return !this.isTabTune ? i - 1 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFabChange(int i) {
        if (this.resumed) {
            Logger.logInfo("AlarmClock: handleFabChange fab " + i);
            MaterialButton materialButton = (MaterialButton) findViewById(R.id.fab);
            if (findViewById(R.id.appbar) != null) {
                ((AppBarLayout) findViewById(R.id.appbar)).setExpanded(true);
            }
            if (this.showFab == null) {
                this.showFab = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_show);
            }
            if (materialButton.getVisibility() == 8) {
                updateFabState(materialButton, i);
                animateTabChange(i);
            } else {
                updateFabState(materialButton, i);
                animateTabChange(i);
            }
            materialButton.setVisibility(0);
        }
    }

    private boolean handlePermissions() {
        String strName;
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.POST_NOTIFICATIONS")) {
            arrayList.add("android.permission.POST_NOTIFICATIONS");
        }
        if (i >= 34 && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.USE_FULL_SCREEN_INTENT") && this.settings.isAlarmFullscreen()) {
            arrayList.add("android.permission.USE_FULL_SCREEN_INTENT");
        }
        if (i >= 34 && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.ACTIVITY_RECOGNITION") && this.settings.getSleepTimeSuggestionMode() != SleepTimeSuggestionManager.Mode.DISABLED) {
            arrayList.add("android.permission.ACTIVITY_RECOGNITION");
        }
        if (i < 33) {
            if (this.settings.isBackupLocal() && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (this.settings.isBackupLocal() && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
            if (this.settings.isRecordingRequiresStorage() && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (this.settings.isRecordingRequiresStorage() && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if ((this.settings.isUltrasonicTracking() || this.settings.isDoingMicrophoneRecording()) && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.RECORD_AUDIO")) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        int i2 = 1;
        if ((this.settings.isGoogleFit() || this.settings.getAutoStartMode() == 1) && !ActivityRecognitionPermission.isGranted(getApplicationContext()) && (strName = ActivityRecognitionPermission.name(getApplicationContext())) != null) {
            arrayList.add(strName);
        }
        boolean z = i >= 31 && (this.settings.isHrBt() || this.settings.isOximeter() || PairTracking.INSTANCE.shouldPairTrackingBeUsed(this, false) || this.settings.isDirectBleWearableSelectedForTracking() || this.settings.hasSleepPhaserOrSleepMask());
        int i3 = 3;
        boolean z2 = (this.settings.isQRCaptchaHomeOnly() && this.settings.getDefaultCaptchaId() == 3) || (this.settings.isNFCCaptchaHomeOnly() && this.settings.getDefaultCaptchaId() == 6);
        if (!z2) {
            z2 = i < 31 && (this.settings.isHrBt() || this.settings.isOximeter() || PairTracking.INSTANCE.shouldPairTrackingBeUsed(this, false) || this.settings.isDirectBleWearableSelectedForTracking() || this.settings.hasSleepPhaserOrSleepMask());
        }
        boolean z3 = i >= 29 && i < 31 && (this.settings.isHrBt() || this.settings.isOximeter() || this.settings.isDirectBleWearableSelectedForTracking() || PairTracking.INSTANCE.shouldPairTrackingBeUsed(this, false) || this.settings.hasSleepPhaserOrSleepMask());
        if (z && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.BLUETOOTH_CONNECT")) {
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
        }
        if (z && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.BLUETOOTH_SCAN")) {
            arrayList.add("android.permission.BLUETOOTH_SCAN");
        }
        if (PairTracking.INSTANCE.shouldPairTrackingBeUsed(this, false) && z && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.BLUETOOTH_ADVERTISE")) {
            arrayList.add("android.permission.BLUETOOTH_ADVERTISE");
        }
        if (!z3 && z2 && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        if (z3 && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (this.settings.isUseFlashlight() && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.CAMERA")) {
            arrayList.add("android.permission.CAMERA");
        }
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        if (i >= 28 && activityManager.isBackgroundRestricted() && !this.settings.isIgnoreBackgroundRestrictedWarning()) {
            Logger.logSevere("AlarmClock: activityManager.isBackgroundRestricted()");
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
            materialAlertDialogBuilder.setIcon(R.drawable.ic_alert);
            materialAlertDialogBuilder.setTitle((CharSequence) getString(R.string.advice_caution).toUpperCase());
            materialAlertDialogBuilder.setMessage((CharSequence) (getString(R.string.background_restrictions) + "\n\n" + getString(R.string.step_problematic_manufacturer) + "\n\n" + getString(R.string.background_restrictions_steps)));
            materialAlertDialogBuilder.setPositiveButton(R.string.resolve, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda3(this, i2));
            materialAlertDialogBuilder.setNegativeButton(R.string.instructions_ignore, (DialogInterface.OnClickListener) null);
            materialAlertDialogBuilder.setNeutralButton(R.string.never, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda3(this, 2));
            materialAlertDialogBuilder.show();
            return false;
        }
        if (!ContextExtKt.canScheduleExactAlarmsCompat(alarmManager)) {
            Logger.logSevere("AlarmClock: Cannot schedule EXACT alarms");
            MaterialAlertDialogBuilder materialAlertDialogBuilder2 = new MaterialAlertDialogBuilder(this);
            materialAlertDialogBuilder2.setIcon(R.drawable.ic_alert);
            materialAlertDialogBuilder2.setTitle((CharSequence) getString(R.string.exact_alarm_restrictions_title));
            materialAlertDialogBuilder2.setMessage((CharSequence) getString(R.string.exact_alarm_restrictions_summary));
            materialAlertDialogBuilder2.setPositiveButton(R.string.resolve, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.20
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    try {
                        AlarmClock.this.startActivity(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.fromParts("package", AlarmClock.this.getPackageName(), null)));
                    } catch (Exception unused) {
                        Toast.makeText(AlarmClock.this, R.string.general_unspecified_error, 1).show();
                    }
                }
            });
            materialAlertDialogBuilder2.setNegativeButton(R.string.instructions_ignore, (DialogInterface.OnClickListener) null);
            materialAlertDialogBuilder2.show();
            return false;
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("AlarmClock: request permission: ");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(" ");
            }
            Logger.logInfo(sb.toString());
            PermissionCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 972);
            return false;
        }
        if (!this.settings.isFailedToInitRecording() || !this.settings.isRecordingMasterSwitchEnabled()) {
            if (!Experiments.getInstance().useAndroidMDozeHackForegroundService() && this.settings.isBatteryOptimized() && !PowerManagerCompat.isIgnoringBatteryOptimizations(this)) {
                try {
                    PowerManagerCompat.requestIgnoreBatteryOptimizations(this);
                } catch (Exception unused) {
                }
            }
            if ((this.settings.isVolumePermissionNeeded() || this.settings.isMuteAlerts()) && Environment.isNOrGreater()) {
                VolumeUtil.askStreamVolumePermission(this);
            }
            StringBuilder sb2 = new StringBuilder("AlarmClock: showNoEscapeDialog ");
            sb2.append(this.settings.isCaptchaNoEscape());
            sb2.append(!this.settings.isCaptchaNoEscapeNever());
            sb2.append(this.settings.isTimeToSuggestNoEscape());
            Logger.logInfo(sb2.toString());
            if (this.settings.isCaptchaNoEscape() && !this.settings.isCaptchaNoEscapeNever() && this.settings.isTimeToSuggestNoEscape()) {
                NoEscapeManager noEscapeManager = new NoEscapeManager(this);
                this.settings.setNoEscapeSuggestTime();
                Logger.logInfo("AlarfmClock: showNoEscapeDialog " + noEscapeManager.isNoEscapeFullyConfigured());
                if (!noEscapeManager.isNoEscapeFullyConfigured()) {
                    MaterialAlertDialogBuilder materialAlertDialogBuilder3 = new MaterialAlertDialogBuilder(this);
                    materialAlertDialogBuilder3.setTitle(R.string.captcha_no_escape);
                    materialAlertDialogBuilder3.setMessage(R.string.no_escape_we_can_do_more);
                    materialAlertDialogBuilder3.setPositiveButton(R.string.agree, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda3(this, i3));
                    materialAlertDialogBuilder3.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
                    materialAlertDialogBuilder3.setNeutralButton(R.string.never, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda3(this, 4));
                    materialAlertDialogBuilder3.show();
                }
            }
        } else {
            if (this.settings.getAutoStartMode() > 0) {
                AlarmSettingsActivity.askOverlay(this, 30, R.string.automatic_sleep_tracking, R.string.overlay_permission_mic_android11, "AlarmClock");
                return true;
            }
            if (this.settings.getSelectedWearable() != Wearable.NONE) {
                AlarmSettingsActivity.askOverlay(this, 30, R.string.wearable_start, R.string.overlay_permission_mic_android11, "SmartwatchSettingsActivity");
                return true;
            }
        }
        return true;
    }

    private void hideUnlockFlow() {
        UnlockFlow unlockFlow = this.unlockFlow;
        if (unlockFlow != null) {
            unlockFlow.onStop();
            findViewById(R.id.activity_unlock).setVisibility(8);
            refreshTrialStatus();
            this.unlockFlow = null;
        }
    }

    private boolean importCsvIfProvided() {
        if (getIntent() == null || !getIntent().hasExtra("cvsImportUri")) {
            return false;
        }
        Logger.logDebug("Backup csv: Importing records");
        if (this.progressContext == null) {
            this.progressContext = new ProgressContext(this);
        }
        String stringExtra = getIntent().getStringExtra("cvsImportUri");
        getIntent().removeExtra("cvsImportUri");
        new ImportDataAsyncTask(this.progressContext, this, new GraphFragmentUpdater()).withUri(stringExtra).execute(new Void[0]);
        return true;
    }

    private boolean importIfProvided() {
        return importZipIfProvided() || importCsvIfProvided();
    }

    private boolean importZipIfProvided() {
        if (getIntent() == null || !getIntent().hasExtra("zipImportUri")) {
            return false;
        }
        if (this.progressContext == null) {
            this.progressContext = new ProgressContext(this);
        }
        if (Build.VERSION.SDK_INT >= 33 || PermissionCompat.isPermissionGranted(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            String stringExtra = getIntent().getStringExtra("zipImportUri");
            getIntent().removeExtra("zipImportUri");
            ExportUtilKt.showImportDialog(this, stringExtra, this.progressContext, new GraphFragmentUpdater());
            return true;
        }
        String stringExtra2 = getIntent().getStringExtra("zipImportUri");
        getIntent().removeExtra("zipImportUri");
        ExportUtilKt.showImportDialog(this, stringExtra2, this.progressContext, new GraphFragmentUpdater());
        PermissionCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 937);
        return true;
    }

    private void initAdapter() {
        MenuDrawerRecyclerViewAdapter menuDrawerRecyclerViewAdapter = new MenuDrawerRecyclerViewAdapter(this);
        this.drawerAdapter = menuDrawerRecyclerViewAdapter;
        menuDrawerRecyclerViewAdapter.add(initMenuDrawer());
        this.drawerList.setAdapter(this.drawerAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.6
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                int itemViewType = AlarmClock.this.drawerAdapter.getItemViewType(i);
                return (itemViewType == IMenuDrawerItem.Type.HEADER.ordinal() || itemViewType == IMenuDrawerItem.Type.SECTION.ordinal() || itemViewType == IMenuDrawerItem.Type.ITEM_LONG.ordinal() || itemViewType == IMenuDrawerItem.Type.APP_TITLE.ordinal() || itemViewType == IMenuDrawerItem.Type.HOME_SCREEN_TOGGLE.ordinal()) ? 2 : 1;
            }
        });
        this.drawerList.setLayoutManager(gridLayoutManager);
        this.drawerAdapter.notifyDataSetChanged();
    }

    private List<IMenuDrawerItem<?>> initMenuDrawer() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuDrawerHeader(this));
        arrayList.add(new MenuDrawerAppTitle(this));
        if (TrialFilter.getInstance().isTrial()) {
            arrayList.add(new MenuDrawerLongItem(this, getString(R.string.upgrade_to_premium), R.drawable.ic_crown_big) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.36
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    AlarmClock.this.startUnlockFlow();
                    AlarmClock.this.closeDrawer();
                }
            });
        }
        Settings settings = new Settings(this);
        if (!settings.isAlarmOnly()) {
            if (settings.isDashboard()) {
                arrayList.add(new MenuDrawerItem(this, getString(R.string.alarm_list_title), R.drawable.ic_alarm) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.37
                    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                    public void onClick() {
                        Intent intent = new Intent(AlarmClock.this, (Class<?>) AlarmActivity.class);
                        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "menu");
                        AlarmClock.this.startActivity(intent);
                        AlarmClock.this.closeDrawer();
                    }
                });
            }
            if ((!settings.isTabs() && !settings.isDashboard()) || (settings.isTabs() && !settings.isTabDashboard())) {
                arrayList.add(new MenuDrawerItem(this, getString(R.string.dashboard), R.drawable.ic_dashboard) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.38
                    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                    public void onClick() {
                        AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) DashboardActivity.class));
                        AlarmClock.this.closeDrawer();
                    }
                });
            }
            if (!settings.isTabs() || !settings.isTabStats()) {
                arrayList.add(new MenuDrawerItem(this, getString(R.string.stats), R.drawable.ic_timelapse) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.39
                    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                    public void onClick() {
                        AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) StatsActivity.class));
                        AlarmClock.this.closeDrawer();
                    }
                });
            }
            if (!settings.isTabs() || !settings.isTabGraphs()) {
                arrayList.add(new MenuDrawerItem(this, getString(R.string.graphs), R.drawable.ic_action_graph) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.40
                    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                    public void onClick() {
                        AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) GraphActivity.class));
                        AlarmClock.this.closeDrawer();
                    }
                });
            }
            arrayList.add(new MenuDrawerItem(this, getString(R.string.advanced_stats), R.drawable.ic_action_stats) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.41
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    boolean zIsTrialExpired = TrialFilter.getInstance().isTrialExpired();
                    AlarmClock alarmClock = AlarmClock.this;
                    if (!zIsTrialExpired) {
                        alarmClock.startActivity(new Intent(AlarmClock.this.getActivity(), (Class<?>) SleepStats.class));
                    } else {
                        alarmClock.showPurchaseDialog();
                        AlarmClock.this.closeDrawer();
                    }
                }
            });
            if (!settings.isTabs() || !settings.isTabNoise()) {
                arrayList.add(new MenuDrawerItem(this, getString(R.string.noise), R.drawable.ic_action_noise) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.42
                    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                    public void onClick() {
                        AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) NoiseActivity.class));
                        AlarmClock.this.closeDrawer();
                    }
                });
            }
            arrayList.add(new MenuDrawerSection(this, getString(R.string.improve)));
            arrayList.add(new MenuDrawerItem(this, getString(R.string.goal), R.drawable.ic_goal) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.43
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    GoalDetailActivity.start(AlarmClock.this.getApplicationContext());
                    AlarmClock.this.closeDrawer();
                }
            });
            arrayList.add(new MenuDrawerItem(this, getString(R.string.advice), R.drawable.ic_lightbulb) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.44
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    AlarmClock.this.startActivity(new Intent(AlarmClock.this.getActivity(), (Class<?>) AdviceActivity.class));
                    AlarmClock.this.closeDrawer();
                }
            });
            arrayList.add(new MenuDrawerLongItem(this, getString(R.string.achievements), R.drawable.ic_trophy) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.45
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) AchievementActivity.class));
                    AlarmClock.this.closeDrawer();
                }
            });
            arrayList.add(new MenuDrawerLongItem(this, getString(R.string.sleep_assistant), R.drawable.ic_action_sleepasand) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.46
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) AiActivity.class));
                    AlarmClock.this.closeDrawer();
                }
            });
            arrayList.add(new MenuDrawerSection(this, getString(R.string.start, "")));
            arrayList.add(new MenuDrawerItem(this, getString(R.string.shortcut), R.drawable.ic_automagic) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.47
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) ShortcutActivity.class));
                    AlarmClock.this.closeDrawer();
                }
            });
            arrayList.add(new MenuDrawerItem(this, getString(R.string.lullaby), R.drawable.ic_action_lullaby) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.48
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    LullabyActivity.start(AlarmClock.this);
                    AlarmClock.this.closeDrawer();
                }
            });
            arrayList.add(new MenuDrawerItem(this, getString(R.string.backup), R.drawable.ic_cloud_upload) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.49
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    BackupItemDialogFragment.newInstance().show(AlarmClock.this.getSupportFragmentManager(), "backup");
                }
            });
        }
        arrayList.add(new MenuDrawerHomeScreen(this));
        arrayList.add(new MenuDrawerSection(this, getString(R.string.support)));
        arrayList.add(new MenuDrawerItem(this, getString(R.string.support), R.drawable.ic_help) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.50
            @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
            public void onClick() {
                DocItemDialogFragment.newInstance("menu", AlarmClock.this.getString(R.string.support), null).show(AlarmClock.this.getSupportFragmentManager(), "help");
                AlarmClock.this.closeDrawer();
            }
        });
        arrayList.add(new MenuDrawerItem(this, getString(R.string.privacy), R.drawable.ic_incognito) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.51
            @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
            public void onClick() {
                AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) PrivacySettingsActivity.class));
                AlarmClock.this.closeDrawer();
            }
        });
        arrayList.add(new MenuDrawerLongItem(this, getString(R.string.invite_friends), R.drawable.ic_share_variant) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.52
            @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
            public void onClick() {
                InviteUtils.invite(AlarmClock.this);
                AlarmClock.this.closeDrawer();
            }
        });
        if (PreferencesUtils.getBillStatus(getApplicationContext()) && TrialFilter.getInstance().isSubscription()) {
            arrayList.add(new MenuDrawerLongItem(this, getString(R.string.subscription), R.drawable.ic_puzzle) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.53
                @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
                public void onClick() {
                    String subscriptionSku = TrialFilter.getInstance().getSubscriptionSku();
                    String strM$1 = "https://play.google.com/store/account/subscriptions?package=" + AlarmClock.this.getPackageName();
                    if (subscriptionSku != null) {
                        strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(strM$1, "&sku=", subscriptionSku);
                    }
                    AlarmClock.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(strM$1)));
                    AlarmClock.this.closeDrawer();
                }
            });
        }
        arrayList.add(new MenuDrawerEnd(this));
        return arrayList;
    }

    private void initTabs() {
        Logger.logInfo("AlarmClock: Removing tabs");
        ViewPager viewPager = this.viewPager;
        if (viewPager == null) {
            Logger.logSevere("ViewPager is NULL");
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "ViewPager is null", 5);
            return;
        }
        viewPager.setAdapter(null);
        this.viewPager.setOffscreenPageLimit(getTabCount());
        TabsAdapter tabsAdapter = new TabsAdapter(this, this.viewPager);
        this.tabsAdapter = tabsAdapter;
        int i = 0;
        if (!this.isDashboard) {
            tabsAdapter.addTab(R.drawable.ic_tab_alarm, AlarmFragment.class, R.string.default_label, null);
            if (SharedApplicationContext.getSettings().isTabDashboard()) {
                this.tabsAdapter.addTab(R.drawable.ic_tab_dashboard, DashboardFragment.class, R.string.dashboard, null);
            }
            if (SharedApplicationContext.getSettings().isTabStats()) {
                this.tabsAdapter.addTab(R.drawable.ic_tab_stats, StatsFragmentNew.class, R.string.stats, null);
            }
            if (SharedApplicationContext.getSettings().isTabGraphs()) {
                this.tabsAdapter.addTab(R.drawable.ic_tab_graph, GraphFragment.class, R.string.graphs, null);
            }
            if (SharedApplicationContext.getSettings().isTabNoise()) {
                this.tabsAdapter.addTab(R.drawable.ic_tab_noise, NoiseFragment.class, R.string.noise, null);
            }
            if (SharedApplicationContext.getSettings().isTabAddon()) {
                this.tabsAdapter.addTab(R.drawable.ic_tab_addon, AddonFragment.class, R.string.addon, null);
            }
            if (SharedApplicationContext.getSettings().isTabTune()) {
                this.tabsAdapter.addTab(R.drawable.ic_tab_tune, TabTuneFragment.class, R.string.tabs, null);
            }
            BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
            if (bottomNavigationView != null) {
                bottomNavigationView.setOnItemSelectedListener(new AlarmClock$$ExternalSyntheticLambda2(this, bottomNavigationView));
            }
            bottomNavigationView.getMenu().getItem(1).setVisible(SharedApplicationContext.getSettings().isTabDashboard());
            bottomNavigationView.getMenu().getItem(2).setVisible(SharedApplicationContext.getSettings().isTabStats());
            bottomNavigationView.getMenu().getItem(3).setVisible(SharedApplicationContext.getSettings().isTabGraphs());
            bottomNavigationView.getMenu().getItem(4).setVisible(SharedApplicationContext.getSettings().isTabNoise());
            if (SharedApplicationContext.getSettings().isAlarmOnly() || SharedApplicationContext.getSettings().isDashboard()) {
                bottomNavigationView.setVisibility(8);
            } else {
                bottomNavigationView.setVisibility(0);
            }
        }
        this.tabsAdapter.reassociateExistingFragments();
        this.tabsLayout.setupWithViewPager(this.viewPager);
        this.tabsLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this.tabsAdapter);
        Iterator<TabsAdapter.TabInfo> it = this.tabsAdapter.getTabs().iterator();
        while (it.hasNext()) {
            this.tabsLayout.getTabAt(i).setIcon(it.next().iconDrawable);
            i++;
        }
        updateFabState((MaterialButton) findViewById(R.id.fab), this.tabsLayout.getSelectedTabPosition());
    }

    public static JavaBilling initializeBilling(Activity activity, IBillingServiceStatusListener iBillingServiceStatusListener, IBillingStatusListener iBillingStatusListener) {
        try {
            JavaBilling javaBilling = new JavaBilling(activity, new AlarmClock$$ExternalSyntheticLambda2(activity, iBillingStatusListener), iBillingServiceStatusListener);
            if (iBillingServiceStatusListener != null) {
                javaBilling.connect();
            }
            return javaBilling;
        } catch (Exception e) {
            Logger.logWarning("INAPP BSH creation failed.", e);
            return null;
        }
    }

    private void initializeShortcuts() {
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                Logger.logInfo("Shortcut init ");
                ShortcutManager shortcutManager = (ShortcutManager) getSystemService(ShortcutManager.class);
                ArrayList arrayList = new ArrayList();
                int iIntValue = SharedApplicationContext.getSettings().getLastNapMinutes().iterator().next().intValue();
                String str = getResources().getString(R.string.button_nap) + " " + iIntValue + getResources().getString(R.string.bed_time_min);
                arrayList.add(new ShortcutInfo.Builder(this, "id_sleep_track_start").setShortLabel(getString(R.string.settings_category_track)).setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_shortcut_track)).setIntent(new Intent("com.urbandroid.sleep.ACTION_START_SLEEP_TRACK_FROM_ACTIVITY", null, getApplicationContext(), StartShortcutActivity.class)).build());
                arrayList.add(new ShortcutInfo.Builder(this, "id_ideal_sleep_track_start").setShortLabel(getString(R.string.ideal_alarm_label)).setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_shortcut_bedtime)).setIntent(new Intent("com.urbandroid.sleep.ACTION_START_IDEAL_SLEEP_TRACK_FROM_ACTIVITY", null, getApplicationContext(), StartShortcutActivity.class)).build());
                Intent intent = new Intent("com.urbandroid.sleep.ACTION_START_NAP1_FROM_ACTIVITY", null, getApplicationContext(), StartShortcutActivity.class);
                intent.putExtra("minutes", iIntValue);
                arrayList.add(new ShortcutInfo.Builder(this, "id_sleep_track_nap1").setShortLabel(str).setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_shortcut_snooze)).setIntent(intent).build());
                arrayList.add(new ShortcutInfo.Builder(this, "id_add_alarm").setShortLabel(getString(R.string.add_alarm)).setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_shortcut_add)).setIntent(new Intent("android.intent.action.SET_ALARM", null, this, SetAlarm.class)).build());
                shortcutManager.setDynamicShortcuts(arrayList);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    private boolean isScreenSizeWideLandscape(int i, int i2) {
        return i == 2 && screenIsLarge(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePermissions$13(DialogInterface dialogInterface, int i) {
        try {
            startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", getPackageName(), null)));
        } catch (Exception unused) {
            Toast.makeText(this, R.string.general_unspecified_error, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePermissions$14(DialogInterface dialogInterface, int i) {
        this.settings.setIgnoreBackgroundRestrictedWarning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePermissions$15(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this, (Class<?>) NoEscapeActivity.class);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePermissions$16(DialogInterface dialogInterface, int i) {
        this.settings.setCaptchaNoEscapeNever();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initTabs$21(BottomNavigationView bottomNavigationView, MenuItem menuItem) {
        Menu menu = bottomNavigationView.getMenu();
        int i = 0;
        for (int i2 = 0; i2 < menu.size(); i2++) {
            if (menuItem.getItemId() == menu.getItem(i2).getItemId()) {
                this.settings.setActiveTab(menuItem.getItemId());
                navigateTo(i);
                return true;
            }
            if (menu.getItem(i2).isVisible()) {
                i++;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initializeBilling$23(Activity activity, IBillingStatusListener iBillingStatusListener, String str, IBillingStatusListener.Status status) {
        Logger.logInfo("INAPP: Received BSH result: " + status + " SKU: " + str);
        int i = AnonymousClass55.$SwitchMap$com$urbandroid$sleep$trial$IBillingStatusListener$Status[status.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (str != null) {
                        TrialFilter.getInstance().removeSku(str);
                    }
                    Toast.makeText(activity, R.string.general_unspecified_error, 1).show();
                    if (str != null && str.startsWith("sleep.unlock")) {
                        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventUnlockClicked(false, TrialFilter.getInstance().daysUsed());
                        ViewIntent.market(activity, "com.urbandroid.sleep.full.key");
                    }
                }
            } else if (str != null) {
                TrialFilter.getInstance().removeSku(str);
                if (str.startsWith("sleep.unlock") && PreferencesUtils.getBillStatus(activity.getApplicationContext())) {
                    PreferencesUtils.storeBillStatus(activity, false);
                    TrialFilter.getInstance().reevaluate();
                    if (activity instanceof AlarmClock) {
                        ((AlarmClock) activity).refreshTrialStatus();
                    }
                }
            }
        } else if (str != null) {
            TrialFilter.getInstance().addSku(str);
            if (str.startsWith("sleep.unlock")) {
                boolean billStatus = PreferencesUtils.getBillStatus(activity.getApplicationContext());
                zza$$ExternalSyntheticOutline0.m("INAPP: previousBillStatus: ", billStatus);
                if (!billStatus) {
                    activity.findViewById(R.id.activity_unlock).setVisibility(8);
                    PreferencesUtils.storeBillStatus(activity.getApplicationContext(), true);
                    TrialFilter.getInstance().refreshByBillingStatus();
                    if (activity instanceof AlarmClock) {
                        ((AlarmClock) activity).refreshTrialStatus();
                    }
                }
            }
        }
        if (activity instanceof AlarmClock) {
            ((AlarmClock) activity).initAdapter();
        }
        if (iBillingStatusListener != null) {
            iBillingStatusListener.onStatusDetected(str, status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.drawerLayout.open();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(int i) {
        try {
            this.navigation.setSelectedItemId(i);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        startUnlockFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$11(DialogInterface dialogInterface, int i) {
        startUnlockFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$12(DialogInterface dialogInterface, int i) {
        if (this.billing != null) {
            PreferencesUtils.storeCloudPremiumStatusUnknown(this);
            this.billing.startPurchaseFlow(Billing.PurchaseType.CLOUD_PREMIUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onWindowFocusChanged$6(View view) {
        Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
        if (!this.settings.isTransitionAnimation()) {
            startActivity(intent);
        } else {
            ActivityOptionsCompat.makeSceneTransitionAnimation(this, findViewById(R.id.search_button), "searchText");
            ContextCompat.startActivity(this, intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, findViewById(R.id.toolbar), "searchTr").toBundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onWindowFocusChanged$7(final TextView textView) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.switch_text_out);
        final Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.switch_text_in);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                textView.setText(R.string.search);
                textView.setAnimation(animationLoadAnimation2);
                textView.setTag("done");
                textView.setVisibility(0);
                textView.setTextColor(ColorUtil.i(AlarmClock.this, R.color.tertiary));
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        textView.startAnimation(animationLoadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTrialStatusForTabs$18(View view) {
        startUnlockFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTrialStatusForTabs$19(View view) {
        startUnlockFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupTrial$17(View view) {
        startUnlockFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEuConsent$10(View view) {
        ViewIntent.url(getApplicationContext(), getResources().getString(R.string.privacy_policy_link));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEuConsent$8(Snackbar snackbar, Snackbar.Callback callback, Settings settings, View view) {
        snackbar.removeCallback(callback);
        settings.setUserAdsAgreed();
        Snackbar.make(getActivity().findViewById(R.id.drawer_main), R.string.revoke_consent, 0).show();
        Consent.INSTANCE.loadAndShowConsent(this, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEuConsent$9(Snackbar snackbar, Snackbar.Callback callback, Settings settings, View view) {
        snackbar.removeCallback(callback);
        settings.setUserAnalyticsAgreed();
        FirebaseAnalytics.getInstance(this).setAnalyticsCollectionEnabled(true);
        Snackbar.make(getActivity().findViewById(R.id.drawer_main), R.string.revoke_consent, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showGarminDialog$5(Context context, DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", "com.urbandroid.sleep.garmin", null));
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            context.startActivity(intent);
        } catch (Exception unused) {
            context.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRatingDialog$26(DialogInterface dialogInterface, int i) {
        ViewIntent.sendTo(this, "support@urbandroid.org", getString(R.string.app_name) + " " + getString(R.string.feedback) + " - 20260519 (231055) " + Build.VERSION.SDK_INT + " " + Build.MANUFACTURER + " " + Build.MODEL, getString(R.string.improvement_feedback) + "\n\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRatingDialog$27(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRatingDialog$28(Settings settings, DialogInterface dialogInterface, int i) {
        settings.setRateLaterDislike();
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Rate_dislike");
        new MaterialAlertDialogBuilder(getActivity()).setView(DialogUtil.getImageDialogView(this, R.string.improvement_feedback, R.drawable.feedbackdroid)).setPositiveButton(R.string.feedback, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda3(this, 5)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) new SetAlarm$$ExternalSyntheticLambda1(2)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRatingPlayStore$24(ReviewManager reviewManager, ReviewInfo reviewInfo, final Settings settings) {
        if (this.isShown) {
            Logger.logInfo("Rating: launchReviewFlow() ");
            try {
                reviewManager.launchReviewFlow(this, reviewInfo).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.33
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public void onSuccess(Void r1) {
                        Logger.logInfo("Rating: launchReviewFlow() success ");
                        settings.setRateLaterPlayStore();
                    }
                });
            } catch (Exception e) {
                Logger.logSevere("Rating: error ", e);
                try {
                    ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "No rating dialog", 10);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRatingPlayStore$25(Handler handler, ReviewManager reviewManager, Settings settings, ReviewInfo reviewInfo) {
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("Rating: requestReviewFlow() success shown "), this.isShown);
        if (this.isShown) {
            handler.postDelayed(new Schedulers$$ExternalSyntheticLambda1(this, reviewManager, reviewInfo, settings, 5), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showReleaseNotes$22(Activity activity, DialogInterface dialogInterface, int i) {
        if (Experiments.getInstance().isBeta() && TrialFilter.getInstance().hasUnlock()) {
            ViewIntent.market(activity, "com.urbandroid.sleep.full.key");
        } else {
            ViewIntent.market(activity, activity.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startHomeScreenSelectionDialog$31(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSleepCloudPurchaseIfNeeded$0() {
        this.billing.startPurchaseFlow(Billing.PurchaseType.CLOUD_PREMIUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSleepCloudPurchaseIfNeeded$1(String str, IBillingStatusListener.Status status) {
        Logger.logInfo("InApp: sleep.cloud startPurchaseFlow result: " + status);
        if (str == null || !str.startsWith("sleep.cloud")) {
            return;
        }
        if (status == IBillingStatusListener.Status.OWNED) {
            startCloudActivity();
        } else if (status != IBillingStatusListener.Status.NOT_OWNED) {
            Toast.makeText(this, R.string.general_unspecified_error, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startUnlockFlow$4479d2c5$1() {
        hideUnlockFlow();
        if (getIntent() == null || !getIntent().hasExtra("com.urbandroid.sleep.START_UNLOCK_CLOUD_PURCHASE")) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFabState$20(View view) {
        new SleepStarter().startSleep(getApplicationContext());
    }

    private boolean menuAction(int i) {
        if (i != R.id.menu_add_alarm) {
            if (i != R.id.menu_item_settings) {
                return false;
            }
            startActivity(new Intent(getActivity(), (Class<?>) SimpleSettingsActivity.class));
            return true;
        }
        BottomNavigationView bottomNavigationView = this.navigation;
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(R.id.menu_alarm);
        } else {
            navigateTo(0);
        }
        addNewAlarm();
        return true;
    }

    private void navigateTo(int i) {
        TabLayout.Tab tabAt;
        TabLayout tabLayout = this.tabsLayout;
        if (tabLayout == null || (tabAt = tabLayout.getTabAt(i)) == null) {
            return;
        }
        tabAt.select();
    }

    private void refreshFragmentMap() {
        fragmentIdMap.clear();
        fragmentIdMap.put(AlarmFragment.class, 0);
        fragmentIdMap.put(DashboardFragment.class, 1);
        fragmentIdMap.put(StatsFragmentNew.class, 2);
        fragmentIdMap.put(GraphFragment.class, 3);
        fragmentIdMap.put(NoiseFragment.class, 4);
        fragmentIdMap.put(AddonFragment.class, 5);
        fragmentIdMap.put(TabTuneFragment.class, 6);
    }

    private void refreshTabsLayout() {
        ViewPager viewPager;
        TabLayout tabLayout = this.tabsLayout;
        if (tabLayout == null || (viewPager = this.viewPager) == null) {
            return;
        }
        tabLayout.setupWithViewPager(viewPager);
        refreshTabsVisibility();
    }

    private void refreshTabsVisibility() {
        ViewPager viewPager;
        if (this.tabsLayout == null || (viewPager = this.viewPager) == null) {
            return;
        }
        if (this.isInWideLandscapeMode || this.isDashboard || viewPager.getAdapter().getCount() == 1) {
            this.tabsLayout.setVisibility(8);
        }
    }

    private void refreshTrialStatusForDashboard() {
        if (this.isDashboard) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                Logger.logInfo("INAPP: fragment ".concat(fragment.getClass().getSimpleName()));
                if (fragment instanceof DashboardFragment) {
                    ((DashboardFragment) fragment).refreshTrial();
                    return;
                }
            }
        }
    }

    private void refreshTrialStatusForTabs() {
        if (this.isDashboard) {
            return;
        }
        setupTrial();
        Logger.logInfo("AlarmClock: Refresh trial status");
        this.trialLayout.setVisibility(8);
        if (getActivity() == null) {
            Logger.logWarning("AlarmFragment: No activity when refreshing trial status");
            return;
        }
        if (!TrialFilter.getInstance().isOurSignature() && !Experiments.getInstance().isOurExperimentalPhone()) {
            this.trialLayout.setVisibility(0);
            this.trialInfo.setText(R.string.unknown_signature);
            this.trialInfo.setTextColor(getResources().getColor(R.color.negative));
            this.trialUnlock.setText(R.string.unknown_signature_install);
            this.trialLayout.setOnClickListener(new AlarmClock$$ExternalSyntheticLambda8(this, 3));
            return;
        }
        if (!TrialFilter.getInstance().isTrial()) {
            Logger.logInfo("Is full - unlock button gone");
            return;
        }
        PromoEvent nextPromo = SharedApplicationContext.getSettings().getNextPromo();
        if (nextPromo != null && nextPromo.getSale() > 0) {
            nextPromo.getInterval().isIn(System.currentTimeMillis());
        }
        boolean z = nextPromo != null && nextPromo.getSale() > 0 && nextPromo.getInterval().isIn(System.currentTimeMillis());
        int iDetectSalePercentage = Billing.PurchaseType.detectSalePercentage();
        boolean z2 = iDetectSalePercentage <= 0 ? z : true;
        this.trialLayout.setVisibility(0);
        this.trialUnlock.setText(R.string.trial_unlock);
        this.trialLayout.setOnClickListener(new AlarmClock$$ExternalSyntheticLambda8(this, 4));
        Logger.logInfo("Is trial - unlock button visible");
        TrialFilter.getInstance().timeToExpire();
        this.trialInfo.setText(TrialFilter.getTrialProgressText(this));
        this.trialInfo.setTextColor(getResources().getColor(R.color.tertiary));
        Handler handler = new Handler();
        if (z2) {
            if (this.billing == null) {
                initializeBilling();
            }
            if (iDetectSalePercentage > 0) {
                Logger.logDebug("PROMO: showing event " + iDetectSalePercentage);
                this.trialUnlock.setText(getResources().getString(R.string.sale, iDetectSalePercentage + "%"));
            }
            Logger.logDebug("PROMO: showing " + ((Object) this.trialUnlock.getText()));
            handler.removeCallbacks(this.unlockAttentionRunnable);
            handler.postDelayed(this.unlockAttentionRunnable, 4000L);
        }
    }

    private boolean screenIsLarge(int i) {
        return false;
    }

    private void setupTrial() {
        ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(R.id.trial_layout);
        this.trialLayout = viewGroup;
        this.trialUnlock = (TextView) viewGroup.findViewById(R.id.trial_unlock_button);
        this.trialInfo = (TextView) this.trialLayout.findViewById(R.id.trial_warning);
        this.trialUnlock.setOnClickListener(new AlarmClock$$ExternalSyntheticLambda8(this, 7));
    }

    private void showEuConsent() {
        final AlarmClock alarmClock;
        final Snackbar snackbarMake;
        final Settings settings = new Settings(this);
        if (settings.isEuCountry() && settings.isUserAdsAgreed() && TrialFilter.getInstance().isTrialExpired()) {
            Consent.INSTANCE.loadAndShowConsent(this, false, false);
        }
        if (TrialFilter.getInstance().isTimeToShowGdprWarning()) {
            if (!settings.isUserAdsAgreed() && !settings.isOptOutAds() && settings.isTimeToAskAds()) {
                final Snackbar.Callback callback = new Snackbar.Callback() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.7
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                    public void onDismissed(Snackbar snackbar, int i) {
                        super.onDismissed(snackbar, i);
                        settings.setAdsAsked();
                        Snackbar.make(AlarmClock.this.getActivity().findViewById(R.id.drawer_main), R.string.revoke_consent, 0).show();
                    }
                };
                snackbarMake = Snackbar.make(getActivity().findViewById(R.id.drawer_main), R.string.ads_consent, -2);
                snackbarMake.setTextMaxLines(5);
                final int i = 0;
                alarmClock = this;
                snackbarMake.setAction(R.string.agree, new View.OnClickListener(alarmClock) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock$$ExternalSyntheticLambda25
                    public final /* synthetic */ AlarmClock f$0;

                    {
                        this.f$0 = alarmClock;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i2 = i;
                        Settings settings2 = settings;
                        Snackbar.Callback callback2 = callback;
                        Snackbar snackbar = snackbarMake;
                        AlarmClock alarmClock2 = this.f$0;
                        switch (i2) {
                            case 0:
                                alarmClock2.lambda$showEuConsent$8(snackbar, callback2, settings2, view);
                                break;
                            default:
                                alarmClock2.lambda$showEuConsent$9(snackbar, callback2, settings2, view);
                                break;
                        }
                    }
                });
                snackbarMake.addCallback(callback);
            } else if (settings.isUserAnalyticsAgreed() || settings.isOptOutAnalytics() || !settings.isTimeToAskAnalytics()) {
                alarmClock = this;
                snackbarMake = null;
            } else {
                final Snackbar.Callback callback2 = new Snackbar.Callback() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.8
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                    public void onDismissed(Snackbar snackbar, int i2) {
                        super.onDismissed(snackbar, i2);
                        settings.setAnalyticsAsked();
                        Snackbar.make(AlarmClock.this.getActivity().findViewById(R.id.drawer_main), R.string.revoke_consent, 0).show();
                    }
                };
                snackbarMake = Snackbar.make(getActivity().findViewById(R.id.drawer_main), R.string.analytics_consent, -2);
                snackbarMake.setTextMaxLines(5);
                final int i2 = 1;
                alarmClock = this;
                snackbarMake.addCallback(callback2).setAction(R.string.agree, new View.OnClickListener(alarmClock) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock$$ExternalSyntheticLambda25
                    public final /* synthetic */ AlarmClock f$0;

                    {
                        this.f$0 = alarmClock;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i22 = i2;
                        Settings settings2 = settings;
                        Snackbar.Callback callback22 = callback2;
                        Snackbar snackbar = snackbarMake;
                        AlarmClock alarmClock2 = this.f$0;
                        switch (i22) {
                            case 0:
                                alarmClock2.lambda$showEuConsent$8(snackbar, callback22, settings2, view);
                                break;
                            default:
                                alarmClock2.lambda$showEuConsent$9(snackbar, callback22, settings2, view);
                                break;
                        }
                    }
                });
            }
            if (snackbarMake != null) {
                try {
                    TextView textView = (TextView) snackbarMake.getView().findViewById(R.id.snackbar_text);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setMaxLines(8);
                    textView.setOnClickListener(new AlarmClock$$ExternalSyntheticLambda8(alarmClock, 6));
                } catch (Exception e) {
                    Logger.logSevere("AlarmClock: snackbar error ", e);
                }
                snackbarMake.show();
            }
        }
    }

    public static void showGarminDialog(Context context) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        materialAlertDialogBuilder.setTitle(R.string.addon_urbandroid_garmin);
        materialAlertDialogBuilder.setMessage(R.string.addon_garmin_uninstall);
        materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new UnlockFlow$$ExternalSyntheticLambda4(context, 2));
        materialAlertDialogBuilder.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
        materialAlertDialogBuilder.show();
    }

    private void showRatingDialog(Settings settings, String str) {
        settings.setRateLater();
        Logger.logInfo("AlarmClock: Rating dialog");
        try {
            int i = 0;
            new MaterialAlertDialogBuilder(getActivity()).setView(DialogUtil.getImageDialogView(this, R.string.rate_text, R.drawable.lovedroid)).setPositiveButton(R.string.yes, (DialogInterface.OnClickListener) new AnonymousClass34(settings, str)).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda21(this, settings, i)).setNeutralButton(R.string.button_captcha_cancel, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda22(settings, i)).setOnCancelListener((DialogInterface.OnCancelListener) new AlarmClock$$ExternalSyntheticLambda23(settings, i)).show();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    private void showRatingPlayStore(Settings settings) {
        Logger.logInfo("Rating: requestReviewFlow() ");
        ReviewManager reviewManagerCreate = ReviewManagerFactory.create(this);
        reviewManagerCreate.requestReviewFlow().addOnSuccessListener(new LoginManager$$ExternalSyntheticLambda1(this, new Handler(), reviewManagerCreate, settings));
    }

    public static void showReleaseNotes(Activity activity) {
        MaterialAlertDialogBuilder materialAlertDialogBuilderShowReleaseNotes = new ReleaseNotes(activity).showReleaseNotes();
        materialAlertDialogBuilderShowReleaseNotes.setIcon(R.drawable.ic_gift);
        materialAlertDialogBuilderShowReleaseNotes.setNeutralButton(R.string.rate_text_3, (DialogInterface.OnClickListener) new UnlockFlow$$ExternalSyntheticLambda4(activity, 1));
        materialAlertDialogBuilderShowReleaseNotes.show();
    }

    private void showShowcaseAtFirstUse() {
        Logger.logInfo("AlarmClock: showShowcaseAtFirstUse");
        if (TrialFilter.getInstance().isFirstUsageOnce()) {
            Logger.logInfo("AlarmClock: setting firstUse to false");
            DashboardFragment dashboardFragment = getDashboardFragment();
            if (dashboardFragment != null) {
                dashboardFragment.showShowcase(this);
            }
        }
    }

    private void startCloudActivity() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.urbandroid.sleep.addon.port");
        launchIntentForPackage.addFlags(ClientDefaults.MAX_MSG_SIZE);
        launchIntentForPackage.putExtra("TS", TrialFilter.getCloudTimestamp(this));
        startActivity(launchIntentForPackage);
    }

    public static void startPurchaseFlow(Context context) {
        Intent intent = new Intent(context, (Class<?>) AlarmClock.class);
        intent.putExtra("com.urbandroid.sleep.START_UNLOCK_CLOUD_PURCHASE", true);
        context.startActivity(intent);
    }

    private void startSleepCloudPurchaseIfNeeded(Intent intent) {
        if (intent.hasExtra("com.urbandroid.sleep.START_CLOUD_PURCHASE")) {
            Logger.logInfo("InApp: Application started with start cloud purchase intent." + ContextExtKt.stringify(intent));
            if (PreferencesUtils.isCloudPremiumStatus(this)) {
                startCloudActivity();
            } else {
                PreferencesUtils.storeCloudPremiumStatusUnknown(this);
                initializeBilling(this, new AlarmClock$$ExternalSyntheticLambda6(this), new AlarmClock$$ExternalSyntheticLambda6(this));
            }
        }
    }

    private void toggleDrawer() {
        ViewGroup viewGroup;
        DrawerLayout drawerLayout = this.drawerLayout;
        if (drawerLayout == null || (viewGroup = this.leftDrawerLayout) == null) {
            return;
        }
        boolean zIsDrawerOpen = drawerLayout.isDrawerOpen(viewGroup);
        DrawerLayout drawerLayout2 = this.drawerLayout;
        if (zIsDrawerOpen) {
            drawerLayout2.closeDrawer(this.leftDrawerLayout);
        } else {
            drawerLayout2.openDrawer(this.leftDrawerLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFabState(MaterialButton materialButton, int i) {
        String string;
        Logger.logInfo("AlarmClock: update fab " + i);
        if (new Settings(this).isAlarmOnly()) {
            materialButton.setIconResource(R.drawable.ic_alarm_plus_white);
            materialButton.setText(R.string.add_alarm);
            Logger.logInfo("AlarmClock: init onClick add");
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) SetAlarm.class));
                }
            });
            return;
        }
        Fragment item = this.tabsAdapter.getItem(i);
        if ((item instanceof AlarmFragment) || (item instanceof DashboardFragment)) {
            boolean zIsRunningTimely = SleepService.isRunningTimely();
            if (zIsRunningTimely) {
                string = getString(R.string.settings_category_track) + " " + getString(R.string.in_progress).toLowerCase().replaceAll("…", "");
            } else {
                string = getString(R.string.start_sleep_tracking);
            }
            materialButton.setText(string);
            materialButton.setIconResource(zIsRunningTimely ? R.drawable.ic_tab_graph_anim_ongoing : R.drawable.ic_action_track_white);
            if (zIsRunningTimely) {
                try {
                    ((AnimationDrawable) materialButton.getIcon()).start();
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
            }
            Logger.logInfo("AlarmClock: init onClick track");
            materialButton.setOnClickListener(new AlarmClock$$ExternalSyntheticLambda8(this, 5));
            if (this.tabsAdapter.alarmFragment != null) {
                this.tabsAdapter.alarmFragment.updateDroidIcon();
                return;
            }
            return;
        }
        if ((item instanceof GraphFragment) || (item instanceof StatsFragmentNew)) {
            materialButton.setIconResource(R.drawable.ic_plus_white);
            materialButton.setText(R.string.add_record_title);
            Logger.logInfo("AlarmClock: init onClick add");
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NewAddRecordActivity.start(AlarmClock.this.getActivity());
                }
            });
            return;
        }
        if (item instanceof NoiseFragment) {
            materialButton.setIconResource(R.drawable.ic_action_play_white);
            materialButton.setText(R.string.play_all_recording);
            Logger.logInfo("AlarmClock: init onClick play");
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlarmClock.this.tabsAdapter.noiseFragment != null) {
                        try {
                            List<Noise> noises = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoises(300, AlarmClock.this.tabsAdapter.noiseFragment.getNoiseFilter());
                            if (noises == null || noises.size() <= 0) {
                                Toast.makeText(AlarmClock.this.getApplicationContext(), R.string.no_recordings, 0).show();
                            } else {
                                NoiseFragment.playAll(AlarmClock.this.getActivity(), noises);
                            }
                        } catch (Exception e2) {
                            Logger.logSevere("Play noises failure", e2);
                            Toast.makeText(AlarmClock.this.getApplicationContext(), R.string.general_unspecified_error, 0).show();
                        }
                    }
                }
            });
            return;
        }
        if (item instanceof AddonFragment) {
            materialButton.setIconResource(R.drawable.ic_information_white);
            materialButton.setText(R.string.addons_install);
            Logger.logInfo("AlarmClock: init onClick info");
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.27
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ViewIntent.url(AlarmClock.this.getApplicationContext(), "https://play.google.com/store/apps/dev?id=9219179332656617922");
                }
            });
            return;
        }
        if (item instanceof TabTuneFragment) {
            materialButton.setIconResource(R.drawable.ic_action_accept_white);
            materialButton.setText(R.string.set_time);
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.28
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlarmClock.this.finish();
                    AlarmClock.this.startActivity(new Intent(AlarmClock.this, (Class<?>) AlarmClock.class));
                }
            });
        }
    }

    public Activity getActivity() {
        return this;
    }

    public DashboardFragment getDashboardFragment() {
        if (!this.isDashboard) {
            return null;
        }
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof DashboardFragment) {
                return (DashboardFragment) fragment;
            }
        }
        return null;
    }

    @Override // com.urbandroid.sleep.async.IHasProgressContext
    /* JADX INFO: renamed from: getProgressContext */
    public ProgressContext getProgressContextInstance() {
        return this.progressContext;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        File fileCreateTempFile;
        FileOutputStream fileOutputStream;
        super.onActivityResult(i, i2, intent);
        zza$$ExternalSyntheticOutline0.m(Fragment$$ExternalSyntheticOutline1.m(i, i2, "Activity result ", " ", " Progress Context not null: "), this.progressContext != null);
        if (i2 == 333) {
            showDialog(64);
            return;
        }
        if (i != 777 || i2 != -1 || intent == null) {
            if (i == 765) {
                if (TrialFilter.getInstance().isTrial() && TrialFilter.getInstance().getVersion() != TrialFilter.Version.FULL) {
                    showPurchaseDialog();
                    return;
                }
                if (i2 == -1) {
                    this.progressContext = new ProgressContext(this);
                    if (intent == null || intent.getData() == null) {
                        new ImportDataAsyncTask(this.progressContext, this, new GraphFragmentUpdater()).execute(new Void[0]);
                        return;
                    }
                    if (Build.VERSION.SDK_INT < 33 && !PermissionCompat.isPermissionGranted(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        ExportUtilKt.showImportDialog(this, intent.getData().toString(), this.progressContext, new GraphFragmentUpdater());
                        PermissionCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 937);
                        return;
                    } else {
                        ExportUtilKt.showImportDialog(this, intent.getData().toString(), this.progressContext, new GraphFragmentUpdater());
                        Logger.logInfo("Backup: Doing import " + intent.getData());
                        return;
                    }
                }
                return;
            }
            return;
        }
        Uri data2 = intent.getData();
        if (data2 == null) {
            return;
        }
        Logger.logInfo("Picked zip/csv import file uri: " + data2);
        this.progressContext = new ProgressContext(this);
        if (!data2.toString().endsWith(".csv")) {
            ExportUtilKt.showImportDialogUri(this, data2, this.progressContext, new GraphFragmentUpdater());
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileCreateTempFile = File.createTempFile("sleep-export.", ".csv", getCacheDir());
                fileCreateTempFile.deleteOnExit();
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ByteStreamsKt.copyTo(getContentResolver().openInputStream(data2), fileOutputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            new ImportDataAsyncTask(this.progressContext, this, null).withUri(fileCreateTempFile.getAbsolutePath()).execute(new Void[0]);
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Logger.logSevere(e);
            Toast.makeText(this, R.string.general_unspecified_error, 1).show();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.drawerLayout != null) {
            this.drawerToggle.onConfigurationChanged(configuration);
        }
        this.isInWideLandscapeMode = isScreenSizeWideLandscape(configuration.orientation, configuration.screenLayout & 15);
        if (this.isDashboard) {
            return;
        }
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            this.tabsAdapter.reset(viewPager.getCurrentItem());
        }
        if (this.adMobController != null) {
            boolean zIsEligibleForAds = IAdsController.isEligibleForAds(this);
            IAdsController iAdsController = this.adMobController;
            if (zIsEligibleForAds) {
                iAdsController.load("ca-app-pub-1970766161278534/9024459229", "ca-app-pub-1970766161278534/3835324682");
                this.adMobController.resume();
            } else {
                iAdsController.hide();
            }
        }
        refreshTabsLayout();
        new Handler().postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.30
            @Override // java.lang.Runnable
            public void run() {
                if (AlarmClock.this.tabsAdapter == null || AlarmClock.this.tabsAdapter.graphFragment == null) {
                    return;
                }
                AlarmClock.this.tabsAdapter.graphFragment.preload();
            }
        }, 250L);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AlarmClock alarmClock;
        setTheme(R.style.Theme_sleep_drawer);
        super.onCreate(bundle);
        this.resumed = false;
        this.h = new Handler();
        LocationUtils.resolveCountry(this);
        GlobalInitializator.initializeIfRequired(this);
        TrialFilter.getInstance().reevaluate();
        AlarmClockOnCreate.INSTANCE.onCreate();
        getWindow().setStatusBarColor(ColorUtil.i(this, R.color.transparent));
        Settings settings = new Settings(this);
        this.settings = settings;
        this.isDashboard = settings.isDashboard();
        this.isAlarmOnly = this.settings.isAlarmOnly();
        if (!this.isDashboard) {
            refreshFragmentMap();
        }
        if (getIntent() != null && getIntent().hasExtra("keyguard")) {
            KeyguardUtil.disable(this);
        }
        if (!TrialFilter.getInstance().isFirstUsage()) {
            handlePermissions();
        }
        zza$$ExternalSyntheticOutline0.m(getResources().getConfiguration().uiMode & 48, "Current night mode ");
        setContentView(this.isDashboard ? R.layout.main_drawer_dashboard : R.layout.main_drawer);
        View viewFindViewById = findViewById(R.id.fab);
        int i = 1;
        if (viewFindViewById != null && getIntent() != null && getIntent().hasExtra("track_onboarding")) {
            TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.fab), getString(R.string.start_sleep_tracking), getString(R.string.market_text_featured)).dimColor(R.color.transparent_black).outerCircleColor(R.color.tap_target_color).targetCircleColor(R.color.white).cancelable(true).tintTarget(false).textColor(R.color.primary), new TapTargetView.Listener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.1
                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                public void onTargetClick(TapTargetView tapTargetView) {
                    super.onTargetClick(tapTargetView);
                    new SleepStarter().startSleep(AlarmClock.this);
                }
            });
        }
        try {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                ((CoordinatorLayout.LayoutParams) layoutParams).gravity = 8388693;
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        this.showAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.show);
        this.hideAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.hide);
        this.fadeInAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scale_down_more);
        this.fadeOutAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scale_up_more);
        this.leftDrawerLayout = (ViewGroup) findViewById(R.id.left_drawer);
        this.drawerList = (RecyclerView) findViewById(R.id.drawer_recycler);
        ToolbarUtil.apply(this);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        if (Build.VERSION.SDK_INT >= 30) {
            EdgeToEdgeUtil.insetsHorizontal(findViewById(R.id.drawer));
            EdgeToEdgeUtil.insetsBottom(findViewById(R.id.fab), (this.isDashboard || this.settings.isAlarmOnly()) ? 0 : ActivityUtils.getDip(this, 80));
            EdgeToEdgeUtil.insetsHeight(appBarLayout, ActivityUtils.getDip(this, 68));
            if (!this.isDashboard && ((!this.isAlarmOnly) & TrialFilter.getInstance().isTrial())) {
                findViewById(R.id.unlock_layout).setVisibility(0);
                EdgeToEdgeUtil.insetsBottom(findViewById(R.id.unlock_layout), (this.isDashboard || this.settings.isAlarmOnly()) ? 0 : ActivityUtils.getDip(this, 142));
            }
            findViewById(R.id.top_shade).setVisibility(0);
        } else {
            if (!this.isDashboard && !this.settings.isAlarmOnly()) {
                ((ViewGroup.MarginLayoutParams) findViewById(R.id.fab).getLayoutParams()).bottomMargin = ActivityUtils.getDip(this, 80);
                findViewById(R.id.fab).requestLayout();
            }
            findViewById(R.id.top_shade).setVisibility(8);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.drawerLayout = drawerLayout;
        if (drawerLayout == null || getSupportActionBar() == null) {
            alarmClock = this;
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            ((Toolbar) findViewById(R.id.toolbar)).setNavigationIcon(R.drawable.ic_menu);
            alarmClock = this;
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, R.string.app_name, R.string.app_name) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.2
                @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
                public void onDrawerClosed(View view) {
                }

                @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
                public void onDrawerOpened(View view) {
                }

                @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
                public void onDrawerSlide(View view, float f) {
                }
            };
            alarmClock.drawerToggle = actionBarDrawerToggle;
            alarmClock.drawerLayout.setDrawerListener(actionBarDrawerToggle);
        }
        alarmClock.drawerLayout.addDrawerListener(alarmClock.drawerToggle);
        alarmClock.drawerToggle.setToolbarNavigationClickListener(new AlarmClock$$ExternalSyntheticLambda8(alarmClock, i));
        alarmClock.drawerToggle.setDrawerIndicatorEnabled(false);
        alarmClock.drawerToggle.setHomeAsUpIndicator(R.drawable.ex_menu);
        alarmClock.drawerToggle.syncState();
        alarmClock.initAdapter();
        ViewPager viewPager = (ViewPager) alarmClock.findViewById(R.id.viewpager);
        alarmClock.viewPager = viewPager;
        if (viewPager != null) {
            ((NoSwipeViewPager) viewPager).setPagingEnabled(false);
        }
        TabLayout tabLayout = (TabLayout) alarmClock.findViewById(R.id.tabs);
        alarmClock.tabsLayout = tabLayout;
        if (tabLayout != null) {
            tabLayout.setVisibility(8);
        }
        alarmClock.isTabStats = SharedApplicationContext.getSettings().isTabStats();
        alarmClock.isTabNoise = SharedApplicationContext.getSettings().isTabNoise();
        alarmClock.isTabAddon = SharedApplicationContext.getSettings().isTabAddon();
        alarmClock.isTabGraphs = SharedApplicationContext.getSettings().isTabGraphs();
        alarmClock.isTabDashboard = SharedApplicationContext.getSettings().isTabDashboard();
        alarmClock.isInWideLandscapeMode = alarmClock.isScreenSizeWideLandscape(alarmClock.getResources().getConfiguration().orientation, alarmClock.getResources().getConfiguration().screenLayout & 15);
        if (alarmClock.getIntent().hasExtra("SleepRecord")) {
            Logger.logInfo("Application started with a cached sleep record -> restart track.");
            StartTrackReceiver.restartFromIntent(alarmClock, alarmClock.getIntent());
        }
        if (alarmClock.getIntent() != null && alarmClock.getIntent().hasExtra("notification_tapped")) {
            BedtimeReceiver.cancelRepeatNotification(alarmClock.getApplicationContext());
        }
        alarmClock.receiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("com.urbandroid.sleep.PUSH_LATER".equals(intent.getAction())) {
                    zza$$ExternalSyntheticOutline0.m(new StringBuilder("InApp: Push later received. BSH non null: "), AlarmClock.this.billing != null);
                    if (AlarmClock.this.billing == null) {
                        Logger.logInfo("InApp: Scenario 3");
                        AlarmClock.this.initializeBilling();
                    }
                    AlarmClock.this.showDialog(56);
                    return;
                }
                if (("com.urbandroid.sleep.ACTION_DASHBOARD_REFRESH".equals(intent.getAction()) || "com.urbandroid.sleep.alarmclock.cancel_snooze_finished".equals(intent.getAction())) && AlarmClock.this.snoozeSnackbar != null) {
                    AlarmClock.this.snoozeSnackbar.dismiss();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.PUSH_LATER");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_DASHBOARD_REFRESH");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
        int i2 = 2;
        ContextCompat.registerReceiver(alarmClock, alarmClock.receiver, intentFilter, 2);
        alarmClock.startSleepCloudPurchaseIfNeeded(alarmClock.getIntent());
        alarmClock.navigation = (BottomNavigationView) alarmClock.findViewById(R.id.navigation);
        if (bundle != null) {
            int i3 = bundle.getInt("page");
            if (bundle.getBoolean("unlock")) {
                alarmClock.startUnlockFlow();
            }
            zza$$ExternalSyntheticOutline0.m(i3, "AlarmClock: selected navigation id ");
            if (alarmClock.navigation != null) {
                alarmClock.h.postDelayed(new LOLCaptcha$$ExternalSyntheticLambda2(alarmClock, i3, 4), 100L);
            }
        } else {
            final int activeTab = alarmClock.settings.getActiveTab();
            if (activeTab != 0) {
                zza$$ExternalSyntheticOutline0.m(activeTab, "Navigating to last active id ");
                if (alarmClock.navigation != null) {
                    alarmClock.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AlarmClock.this.navigation.setSelectedItemId(activeTab);
                            } catch (Exception e2) {
                                Logger.logSevere(e2);
                            }
                        }
                    }, 100L);
                }
            }
        }
        alarmClock.adMobController = new AdMobController(alarmClock, R.id.adsStub);
        if (TrialFilter.getInstance().isTrial()) {
            PromoSyncJob.start(alarmClock);
            alarmClock.refreshTrialStatusForTabs();
        }
        if (alarmClock.getIntent() != null && alarmClock.getIntent().hasExtra("after_interstitial_ad")) {
            Snackbar.make(alarmClock.findViewById(R.id.drawer_main), R.string.no_ads_unlock, -2).setAction(R.string.no_ads, new AlarmClock$$ExternalSyntheticLambda8(alarmClock, i2)).show();
        } else if (!SharedApplicationContext.getSettings().isFirstUsage()) {
            alarmClock.showEuConsent();
        }
        alarmClock.initializeShortcuts();
        alarmClock.attentionAnim = AnimationUtils.loadAnimation(alarmClock.getActivity().getApplicationContext(), R.anim.blow_little);
        if (CleanupService.shouldRun(alarmClock)) {
            Logger.logInfo("CleanupService should run");
            CleanupService.start(alarmClock);
        } else {
            Logger.logInfo("CleanupService nothing to run");
        }
        if (alarmClock.getIntent() != null && alarmClock.getIntent().hasExtra("com.urbandroid.sleep.START_UNLOCK_CLOUD_PURCHASE")) {
            alarmClock.startUnlockFlow();
            return;
        }
        if (alarmClock.importIfProvided()) {
            return;
        }
        if (alarmClock.getIntent() != null && ACTION_START_DOWNLOAD_FROM_CLOUD.equals(alarmClock.getIntent().getAction())) {
            BackupItemDialogFragment.startDownloadFromCloud(alarmClock);
        }
        SharedApplicationContext.getSettings().resetWakeUpCheckRepeatIfExpired();
        if (TrialFilter.getInstance().isAddonGarmin() && alarmClock.settings.isWearableSelected(Wearable.ADDON_URBANDROID_GARMIN)) {
            showGarminDialog(alarmClock);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 50) {
            return new MaterialAlertDialogBuilder(this).setTitle(R.string.menu_delete_old).setItems((CharSequence[]) getResources().getStringArray(R.array.delete_older_than_entries), new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    final int iIntValue = Integer.valueOf(AlarmClock.this.getResources().getStringArray(R.array.delete_older_than_values)[i2]).intValue();
                    if (iIntValue >= 0) {
                        new ExportDataAsyncTask(AlarmClock.this.progressContext, AlarmClock.this) { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.11.1
                            @Override // com.urbandroid.sleep.async.ExportDataAsyncTask, com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
                            public void onPostExecute(Void r2) {
                                super.onPostExecute(r2);
                                Logger.logInfo("AlarmClock: Deleting records older than: " + iIntValue);
                                SharedApplicationContext.getInstance().getSleepRecordRepository().deleteOld(iIntValue);
                                AlarmClock.this.new GraphFragmentUpdater().run();
                            }
                        }.execute(new Void[0]);
                    }
                }
            }).create();
        }
        if (i == 53) {
            return new MaterialAlertDialogBuilder(this).setMessage(R.string.unlock_thanks).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.14
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).create();
        }
        if (i == 59) {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
            materialAlertDialogBuilder.setTitle((CharSequence) getResources().getString(R.string.beta_welcome_title));
            materialAlertDialogBuilder.setMessage((CharSequence) getResources().getString(R.string.beta_welcome_message));
            materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.13
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    AlarmClock.showReleaseNotes(AlarmClock.this);
                }
            });
            return materialAlertDialogBuilder.create();
        }
        if (i == 66) {
            return new MaterialAlertDialogBuilder(this).setIcon(R.drawable.ic_cloud_download).setTitle(R.string.backup).setItems((CharSequence[]) getResources().getStringArray(R.array.menu_backup_download), new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (i2 == 0) {
                        TrialFilter.getInstance().reevaluate();
                        if (TrialFilter.getInstance().isTrial() && TrialFilter.getInstance().getVersion() != TrialFilter.Version.FULL && !TrialFilter.getInstance().isAddonImport()) {
                            AlarmClock.this.showPurchaseDialog();
                            return;
                        }
                        ProgressContext progressContext = AlarmClock.this.progressContext;
                        AlarmClock alarmClock = AlarmClock.this;
                        new ImportDataAsyncTask(progressContext, alarmClock, alarmClock.new GraphFragmentUpdater()).zipped().execute(new Void[0]);
                        return;
                    }
                    if (i2 != 1) {
                        return;
                    }
                    Logger.logInfo("Backup: Cloud download");
                    TrialFilter.getInstance().reevaluate();
                    if (!TrialFilter.getInstance().isAddonImport()) {
                        ViewIntent.market(AlarmClock.this, "com.urbandroid.sleep.addon.port");
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.MAIN");
                        intent.setComponent(new ComponentName("com.urbandroid.sleep.addon.port", "com.urbandroid.sleep.addon.port.PullActivity"));
                        AlarmClock.this.startActivityForResult(intent, 765);
                    } catch (Exception e) {
                        Logger.logSevere(e);
                        ViewIntent.market(AlarmClock.this, "com.urbandroid.sleep.addon.port");
                    }
                }
            }).create();
        }
        if (i == 56) {
            return new MaterialAlertDialogBuilder(this).setMessage(R.string.cloud_sync_rejected).setPositiveButton(R.string.upgrade_to_premium, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda3(this, 6)).setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).create();
        }
        int i2 = 0;
        if (i == 57) {
            Dialog dialogProvideOnDemandDialog = ErrorReporter.getInstance().provideOnDemandDialog(getActivity());
            dialogProvideOnDemandDialog.setCanceledOnTouchOutside(false);
            return dialogProvideOnDemandDialog;
        }
        switch (i) {
            case 62:
                new MaterialAlertDialogBuilder(this);
                MaterialAlertDialogBuilder materialAlertDialogBuilder2 = new MaterialAlertDialogBuilder(this);
                materialAlertDialogBuilder2.setMessage((CharSequence) getResources().getString(R.string.rewards_extend_trial_days_error));
                materialAlertDialogBuilder2.setPositiveButton(R.string.trial_unlock, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda3(this, i2));
                materialAlertDialogBuilder2.setNegativeButton(R.string.botton_free, (DialogInterface.OnClickListener) null);
                return materialAlertDialogBuilder2.create();
            case 63:
                Dialog dialogProvideOnDemandDialog2 = ErrorReporter.getInstance().provideOnDemandDialog(getActivity(), new IErrorDialogAction() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.17
                    @Override // com.urbandroid.common.error.IErrorDialogAction
                    public void execute(DialogInterface dialogInterface, String str) {
                        try {
                            ErrorReporting.reportWearableThroughAddonActivity(AlarmClock.this, str);
                        } catch (ActivityNotFoundException e) {
                            Logger.logDebug("ErrorReportActivity not found, reporting using REPORT broadcast", e);
                            ErrorReporting.reportWearableThroughBroadcast(AlarmClock.this, str);
                        }
                        dialogInterface.dismiss();
                    }
                });
                dialogProvideOnDemandDialog2.setCanceledOnTouchOutside(false);
                return dialogProvideOnDemandDialog2;
            case 64:
                final View viewInflate = InflatorUtil.get(getActivity()).inflate(R.layout.dialog_unlock_restore_contact_support, (ViewGroup) null, false);
                return new MaterialAlertDialogBuilder(getActivity()).setTitle(R.string.get_support).setView(viewInflate).setPositiveButton(R.string.on_demand_report_send, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.16
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        ErrorReporter.getInstance().generateOnDemandReport(null, ((EditText) viewInflate.findViewById(R.id.comment)).getText().toString(), ((EditText) viewInflate.findViewById(R.id.order_no)).getText().toString());
                    }
                }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
            default:
                return null;
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        this.isInWideLandscapeMode = isScreenSizeWideLandscape(getResources().getConfiguration().orientation, getResources().getConfiguration().screenLayout & 15);
        getMenuInflater().inflate(R.menu.bar_menu, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_add_alarm);
        this.menuItemAdd = menuItemFindItem;
        menuItemFindItem.setVisible(false);
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        IAdsController iAdsController = this.adMobController;
        if (iAdsController != null) {
            iAdsController.destroy();
        }
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.receiver = null;
        }
        JavaBilling javaBilling = this.billing;
        if (javaBilling != null) {
            javaBilling.destroy();
            this.billing = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            toggleDrawer();
            return false;
        }
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.drawerLayout != null && this.leftDrawerLayout != null) {
            UnlockFlow unlockFlow = this.unlockFlow;
            if (unlockFlow != null) {
                unlockFlow.back();
            } else {
                finish();
            }
        }
        return false;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        importIfProvided();
        if (getIntent() != null && getIntent().hasExtra("notification_tapped")) {
            BedtimeReceiver.cancelRepeatNotification(getApplicationContext());
        }
        if (intent != null) {
            startSleepCloudPurchaseIfNeeded(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            toggleDrawer();
        }
        return menuAction(menuItem.getItemId());
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        if (bottomNavigationView != null && new Settings(this).isTabs()) {
            bottomNavigationView.setVisibility(8);
        }
        Logger.logInfo("Rating: onPause()");
        this.isShown = false;
        IAdsController iAdsController = this.adMobController;
        if (iAdsController != null) {
            iAdsController.pause();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.drawerLayout != null) {
            this.drawerToggle.syncState();
        }
    }

    @Override // com.urbandroid.common.BaseActivity
    public void onPostResumeAfterRecreate() {
        this.isShown = true;
        Logger.logInfo("Theme: onPostAfterRecreate() called, Rating: " + GlobalInitializator.isInitRecently());
        Settings settings = new Settings(this);
        if (!settings.isFirstUsage() && TrialFilter.getInstance().getVersion() == TrialFilter.Version.TRIAL) {
            Logger.logInfo("Rating: shouldAsk " + settings.shouldAskForRatingPlayStore() + " isTime " + settings.isTimeToRateAgainPlayStore() + " isTimeSooner " + settings.isTimeToRateAgainSoonerPlayStore() + " goodTime " + Settings.isGoodTimeToRate());
            MaterialAlertDialogBuilder materialAlertDialogBuilderShowReleaseNotesIfUpdated = new ReleaseNotes(getActivity()).showReleaseNotesIfUpdated();
            if (!this.isDashboard && settings.isShowReleaseNotes() && !settings.isTabDashboard() && materialAlertDialogBuilderShowReleaseNotesIfUpdated != null) {
                try {
                    Logger.logInfo("Release notes, showing ");
                    materialAlertDialogBuilderShowReleaseNotesIfUpdated.setNeutralButton(R.string.never_rate, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.32
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SharedApplicationContext.getSettings().setShowReleaseNotes(false);
                        }
                    });
                    materialAlertDialogBuilderShowReleaseNotesIfUpdated.show();
                    return;
                } catch (Exception e) {
                    Logger.logSevere(e);
                    return;
                }
            }
            if (GlobalInitializator.isInitRecently()) {
                Logger.logInfo("Rating: not asking, init recently ");
                return;
            }
            if (settings.shouldAskForRating()) {
                Logger.logInfo("Rating: SHOULD like ");
                showRatingDialog(settings, (Experiments.getInstance().isBeta() && TrialFilter.getInstance().hasUnlock()) ? "com.urbandroid.sleep.full.key" : getPackageName());
            } else if (settings.shouldAskForRatingPlayStore()) {
                Logger.logInfo("Rating: SHOULD Play Store ");
                showRatingPlayStore(settings);
            }
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        DialogUtil.fixDivider(dialog);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Logger.logInfo("AlarmClock: onRequestPermissionsResult ");
        int i2 = 0;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            zza$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m5m("AlarmClock: onRequestPermissionsResult permission ", strArr[i3], " = "), iArr[i3]);
            if (iArr[i3] == 0) {
                i2++;
            }
        }
        zza$$ExternalSyntheticOutline0.m(i2, "AlarmClock: granted ");
        if (i == 972) {
            Settings settings = new Settings(this);
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (iArr[i4] != 0) {
                    String str = strArr[i4];
                    str.getClass();
                    switch (str) {
                        case "android.permission.ACCESS_FINE_LOCATION":
                            disableBluetoothLeBasedFeatures(settings);
                            break;
                        case "android.permission.ACCESS_COARSE_LOCATION":
                            settings.setGeoOptOut(true);
                            disableBluetoothLeBasedFeatures(settings);
                            break;
                        case "android.permission.CAMERA":
                            settings.setUseFlashlight(false);
                            break;
                        case "android.permission.WRITE_EXTERNAL_STORAGE":
                            settings.setBackupLocal(false);
                            break;
                        case "android.permission.RECORD_AUDIO":
                            settings.disableAnyKindOfRecording();
                            break;
                    }
                }
            }
        } else if (i == 937 && getIntent().hasExtra("zipImportUri")) {
            String stringExtra = getIntent().getStringExtra("zipImportUri");
            getIntent().removeExtra("zipImportUri");
            ExportUtilKt.showImportDialog(this, stringExtra, this.progressContext, new GraphFragmentUpdater());
        } else if (i == 937 && !getIntent().hasExtra("zipImportUri")) {
            ExportUtilKt.showImportDialog(this, null, this.progressContext, new GraphFragmentUpdater());
        }
        Logger.logInfo("AlarmClock: showShowcase permission");
        showShowcaseAtFirstUse();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        if (bottomNavigationView != null && new Settings(this).isTabs()) {
            bottomNavigationView.setVisibility(0);
        }
        Logger.logInfo("AlarmClock: onResume()");
        Logger.logInfo("AlarmClock: onResume() first " + TrialFilter.getInstance().isFirstUsage() + " tutorial shown " + SharedApplicationContext.getSettings().isShowCaseShown(FirstUsePreviewActivity.SHOWN_TUTORIAL));
        if (TrialFilter.getInstance().isFirstUsage() && SharedApplicationContext.getSettings().isShowCaseShown(FirstUsePreviewActivity.SHOWN_TUTORIAL)) {
            boolean zHandlePermissions = handlePermissions();
            zza$$ExternalSyntheticOutline0.m("AlarmClock: delayed handlePermissions at first use ", zHandlePermissions);
            if (zHandlePermissions) {
                showShowcaseAtFirstUse();
            }
        }
        final Handler handler = new Handler();
        if (!this.isDashboard) {
            handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.21
                /* JADX WARN: Multi-variable type inference failed */
                public boolean isFragmentReadToBeLazyLoaded(ILazyFragment iLazyFragment) {
                    if (iLazyFragment == 0 || iLazyFragment.isAlreadyLoaded()) {
                        return false;
                    }
                    Fragment fragment = (Fragment) iLazyFragment;
                    return (fragment.isDetached() || fragment.getActivity() == null) ? false : true;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (AlarmClock.this.tabsAdapter == null) {
                        return;
                    }
                    boolean zIsFragmentReadToBeLazyLoaded = isFragmentReadToBeLazyLoaded(AlarmClock.this.tabsAdapter.graphFragment);
                    AlarmClock alarmClock = AlarmClock.this;
                    if (zIsFragmentReadToBeLazyLoaded) {
                        alarmClock.tabsAdapter.graphFragment.preload();
                        handler.postDelayed(this, 50L);
                        return;
                    }
                    boolean zIsFragmentReadToBeLazyLoaded2 = isFragmentReadToBeLazyLoaded(alarmClock.tabsAdapter.statsFragment);
                    AlarmClock alarmClock2 = AlarmClock.this;
                    if (zIsFragmentReadToBeLazyLoaded2) {
                        alarmClock2.tabsAdapter.statsFragment.preload();
                        handler.postDelayed(this, 50L);
                        return;
                    }
                    boolean zIsFragmentReadToBeLazyLoaded3 = isFragmentReadToBeLazyLoaded(alarmClock2.tabsAdapter.noiseFragment);
                    AlarmClock alarmClock3 = AlarmClock.this;
                    if (zIsFragmentReadToBeLazyLoaded3) {
                        alarmClock3.tabsAdapter.noiseFragment.preload();
                        handler.postDelayed(this, 50L);
                        return;
                    }
                    boolean zIsFragmentReadToBeLazyLoaded4 = isFragmentReadToBeLazyLoaded(alarmClock3.tabsAdapter.addonFragment);
                    AlarmClock alarmClock4 = AlarmClock.this;
                    if (zIsFragmentReadToBeLazyLoaded4) {
                        alarmClock4.tabsAdapter.addonFragment.preload();
                        handler.postDelayed(this, 50L);
                    } else if (isFragmentReadToBeLazyLoaded(alarmClock4.tabsAdapter.dashboardFragment)) {
                        AlarmClock.this.tabsAdapter.dashboardFragment.preload();
                        handler.postDelayed(this, 50L);
                    }
                }
            }, 250L);
            handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.22
                @Override // java.lang.Runnable
                public void run() {
                    if (AlarmClock.this.tabsLayout == null) {
                        handler.postDelayed(this, 500L);
                    } else {
                        AlarmClock alarmClock = AlarmClock.this;
                        alarmClock.updateFabState((MaterialButton) alarmClock.findViewById(R.id.fab), AlarmClock.this.tabsLayout.getSelectedTabPosition());
                    }
                }
            }, 500L);
        }
        TrialFilter.getInstance().reevaluate();
        if (this.adMobController != null) {
            if (this.isDashboard || !IAdsController.isEligibleForAds(this)) {
                Logger.logDebug("ADMOB: Hiding ADMOB unlock installed");
                this.adMobController.hide();
            } else {
                Logger.logDebug("ADMOB: Load view");
                this.adMobController.load("ca-app-pub-1970766161278534/9024459229", "ca-app-pub-1970766161278534/3835324682");
                this.adMobController.resume();
            }
        }
        List<Integer> lastNapMinutes = SharedApplicationContext.getSettings().getLastNapMinutes();
        Iterator<Object> it = this.napDrawerItems.iterator();
        Iterator<Integer> it2 = lastNapMinutes.iterator();
        if (it2.hasNext()) {
            Integer next = it2.next();
            if (it.hasNext()) {
                if (it.next() != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return;
                } else {
                    next.getClass();
                    throw null;
                }
            }
        }
        this.drawerAdapter.notifyDataSetChanged();
        this.drawerList.invalidate();
        showUndoToastIfNeeded();
        if (Build.VERSION.SDK_INT >= 26 && new Settings(this).isSmartwatchEnabled()) {
            Logger.logDebug("AlarmClock: sending init to SleepWatchStarter");
            Intent intent = new Intent("com.urbandroid.watchsleepstarter.INIT");
            intent.setFlags(32);
            ContextExtKt.sendExplicitBroadcast(this, intent, "com.urbandroid.watchsleepstarter");
        }
        findViewById(R.id.fab);
        this.resumed = true;
        DroidWidget.refresh(this);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResumeFragments() {
        super.onResumeFragments();
        Logger.logInfo("AlarmClock: onResumeFragments");
        if (this.isDashboard) {
            return;
        }
        Settings settings = new Settings(this);
        if (this.tabsAdapter == null || SharedApplicationContext.getSettings().isTabAddon() != this.isTabAddon || settings.isTabNoise() != this.isTabNoise || settings.isTabGraphs() != this.isTabGraphs || settings.isTabStats() != this.isTabStats || settings.isTabDashboard() != this.isTabDashboard || settings.isTabTune() != this.isTabTune) {
            this.isTabAddon = settings.isTabAddon();
            this.isTabNoise = settings.isTabNoise();
            this.isTabGraphs = settings.isTabGraphs();
            this.isTabStats = settings.isTabStats();
            this.isTabDashboard = settings.isTabDashboard();
            this.isTabTune = settings.isTabTune();
            initTabs();
        }
        refreshTabsVisibility();
        try {
            if (this.tabsAdapter == null || this.tabsLayout == null) {
                return;
            }
            updateFabState((MaterialButton) findViewById(R.id.fab), this.tabsLayout.getSelectedTabPosition());
            if (this.tabsLayout.getSelectedTabPosition() != 0) {
                Logger.logInfo("AlarmClock: alarm fragment invisible");
                this.tabsAdapter.alarmFragment.setInvisible();
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.viewPager != null) {
            bundle.putInt("page", ((BottomNavigationView) findViewById(R.id.navigation)).getSelectedItemId());
        }
        bundle.putBoolean("unlock", this.unlockFlow != null);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Logger.logInfo("AlarmClock: onStart() ");
        Settings settings = new Settings(this);
        if (refreshAfterResume) {
            refreshAfterResume = false;
            finish();
            startActivity(new Intent(this, (Class<?>) AlarmClock.class));
            return;
        }
        if (this.progressContext == null) {
            this.progressContext = new ProgressContext(this);
        }
        boolean z = (TrialFilter.getInstance().hasUnlock() && PreferencesUtils.isUnlockAcked(this)) ? false : true;
        boolean zIsAddonImport = TrialFilter.getInstance().isAddonImport();
        Logger.logDebug("inAppNeedsChecking: " + z + " cloudNeedsChecking: " + zIsAddonImport);
        if (z || zIsAddonImport) {
            long j = lastBSRefreshTimestamp;
            if (j == 0 || j + 720000 < System.currentTimeMillis() || TrialFilter.getInstance().isTrial()) {
                if (this.billing == null) {
                    initializeBilling();
                }
                if (this.billing != null) {
                    Logger.logInfo("InApp: Refreshing BSH status");
                    this.billing.refreshSleepPurchaseState();
                    this.billing.refreshCloudSubscriptionState();
                }
                lastBSRefreshTimestamp = System.currentTimeMillis();
            }
        }
        settings.detectCaptchaAvoided();
        Logger.logInfo("AvoidCaptcha: settings.isCaptchaAvoided() && settings.getCaptchaAvoidedOrderId()");
        if (settings.isCaptchaAvoided() && (settings.isCaptchaNoEscape() || settings.hasDefaultCaptcha())) {
            if (settings.getCaptchaAvoidedOrderId() != null) {
                CaptchaCheatingSettingsActivity.start(this);
            } else {
                Logger.logInfo("AvoidCaptcha: snackbar");
                Snackbar.make(findViewById(R.id.drawer_main), getString(R.string.alarm_avoid_protection_failed) + " " + getString(R.string.try_something, getString(R.string.captcha_no_escape)), -2).setAction(R.string.button_ok, new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.31
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CaptchaCheatingSettingsActivity.start(AlarmClock.this);
                    }
                }).show();
                settings.setCaptchaAvoided(false);
            }
        }
        if (SharedApplicationContext.getSettings().isGoogleFitSyncNeeded()) {
            Logger.logInfo("Google Fit need sync");
            GoogleFitSyncJobService.start(getApplicationContext(), false);
        }
        if (SharedApplicationContext.getSettings().isSamsungSHealthSyncNeeded()) {
            Logger.logInfo("Samsung Samsung Health need sync");
            SamsungSHealthSyncJobService.start(getApplicationContext());
        }
        if (AlarmKlaxon.isRunning() && AlarmKlaxon.currentAlarm != null) {
            Intent intent = new Intent(this, (Class<?>) AlarmAlertFullScreen.class);
            intent.putExtra("intent.extra.alarm", (Serializable) AlarmKlaxon.currentAlarm);
            intent.putExtra("CREATION_SOURCE", "AlarmClock-onStart");
            intent.setFlags(872546304);
            startActivity(intent);
        }
        this.snoozeSnackbar = Alarm.showSnoozeSnackbar((ViewGroup) findViewById(R.id.drawer_main), this);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (SharedApplicationContext.getSettings().isTimeToDeleteOldNoises()) {
            DeleteObsoleteNoisesService.start(this);
            if (SharedApplicationContext.getSettings().isMediaStoreAlbum()) {
                NoiseMediaStoreJob.start(this);
            }
        }
        ProgressContext progressContext = this.progressContext;
        if (progressContext != null) {
            progressContext.activityStop();
            this.progressContext = null;
        }
        JavaBilling javaBilling = this.billing;
        if (javaBilling != null) {
            javaBilling.destroy();
            this.billing = null;
        }
        Snackbar snackbar = this.snoozeSnackbar;
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        final TextView textView;
        super.onWindowFocusChanged(z);
        if (!z || this.h == null || (textView = (TextView) findViewById(R.id.search_button)) == null) {
            return;
        }
        textView.setOnClickListener(new AlarmClock$$ExternalSyntheticLambda8(this, 0));
        if (textView.getTag() == null) {
            this.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onWindowFocusChanged$7(textView);
                }
            }, 3000L);
        }
    }

    public void refreshTrialStatus() {
        Logger.logInfo("INAPP: refreshTrialStatus");
        if (this.isDashboard) {
            refreshTrialStatusForDashboard();
        } else {
            refreshTrialStatusForTabs();
        }
    }

    public void showPurchaseDialog() {
        new MaterialAlertDialogBuilder(this).setMessage((CharSequence) getString(R.string.unlock_text)).setTitle(R.string.app_name_long_unlock).setIcon(R.drawable.ic_lock_unlock).setPositiveButton(R.string.trial_unlock, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.19
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AlarmClock.this.startUnlockFlow();
            }
        }).setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.18
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public void showUndoToastIfNeeded() {
        final UndoOperationGroup currentUndoOperation = SharedApplicationContext.getInstance().getSleepRecordRepository().getCurrentUndoOperation();
        if (currentUndoOperation == null || currentUndoOperation.timestamp() < lastShownUndoOperationTimestamp || currentUndoOperation.timestamp() < System.currentTimeMillis() - 60000 || currentUndoOperation.getOriginalRecord() == null) {
            Snackbar snackbar = undoSnackbar;
            if (snackbar != null && snackbar.isShown()) {
                undoSnackbar.dismiss();
            }
            if (currentUndoOperation != null) {
                Logger.logInfo("Undo: cancel snackbar (" + currentUndoOperation.getName() + ") for timestamp: " + currentUndoOperation.timestamp() + " lastShownUndoOperationTimestamp: " + lastShownUndoOperationTimestamp);
                return;
            }
            return;
        }
        Logger.logInfo("Undo: " + currentUndoOperation.timestamp());
        Logger.logInfo("Undo: Going to show undo operation (" + currentUndoOperation.getName() + ") for timestamp: " + currentUndoOperation.timestamp() + " lastShownUndoOperationTimestamp: " + lastShownUndoOperationTimestamp);
        lastShownUndoOperationTimestamp = currentUndoOperation.timestamp();
        String name = currentUndoOperation.getName();
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(name, "\n");
        sbM.append(new SleepRecordStringBuilder(this).setPrependSleep(true).setAppendRange(true).setAppendDay(true).build(currentUndoOperation.getOriginalRecord()));
        Snackbar action = Snackbar.make(findViewById(R.id.drawer_main), sbM.toString(), (name == null || !name.startsWith(getResources().getString(R.string.delete))) ? 0 : -2).addCallback(new Snackbar.Callback() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            public void onDismissed(Snackbar snackbar2, int i) {
                super.onDismissed(snackbar2, i);
                if (i == 0) {
                    zza$$ExternalSyntheticOutline0.m(i, "Undo dismiss ");
                    AlarmClock.lastShownUndoOperationTimestamp = currentUndoOperation.timestamp() + 1;
                }
            }
        }).setAction(R.string.undo, new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmClock.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SharedApplicationContext.getInstance().getSleepRecordRepository().performUndo();
                AlarmClock.this.updateOnGraphsChange();
            }
        });
        undoSnackbar = action;
        action.show();
    }

    public void startHomeScreenSelectionDialog() {
        Settings settings = new Settings(this);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setTitle(R.string.home_screen);
        AnonymousClass54 anonymousClass54 = new AnonymousClass54(this, R.layout.select_dialog_item_with_action, settings);
        anonymousClass54.add(getString(R.string.dashboard));
        anonymousClass54.add(getString(R.string.tabs));
        anonymousClass54.add(getString(R.string.alarms_only));
        materialAlertDialogBuilder.setAdapter((ListAdapter) anonymousClass54, (DialogInterface.OnClickListener) new SetAlarm$$ExternalSyntheticLambda1(1));
        this.homeScreenSelectionDialog = materialAlertDialogBuilder.show();
    }

    public void startUnlockFlow(Billing.PurchaseType purchaseType) {
        if (getDashboardFragment() != null) {
            Logger.logInfo("Dynamic link hiding show case ");
            getDashboardFragment().hideShowCase();
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_unlock);
        Logger.logInfo("Dynamic link new UnlockFloat() ");
        this.unlockFlow = new UnlockFlow(this, viewGroup, new AlarmClock$$ExternalSyntheticLambda5(this, 0));
        if (this.billing == null) {
            initializeBilling();
        }
        this.unlockFlow.setBilling(this.billing);
        this.unlockFlow.onCreate();
        this.unlockFlow.onStart();
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.unfade);
        View viewFindViewById = findViewById(R.id.drawer_layout);
        try {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(viewGroup, viewFindViewById.getRight(), viewFindViewById.getBottom(), 0.0f, (int) Math.hypot(r1, r7));
            animatorCreateCircularReveal.setDuration(700L);
            animatorCreateCircularReveal.start();
        } catch (Exception e) {
            viewGroup.startAnimation(animationLoadAnimation);
            Logger.logSevere(e);
        }
        viewGroup.setVisibility(0);
    }

    public void updateOnGraphsChange() {
        TabsAdapter tabsAdapter = this.tabsAdapter;
        if (tabsAdapter != null && tabsAdapter.graphFragment != null) {
            this.tabsAdapter.graphFragment.setDataUpdated();
        }
        TabsAdapter tabsAdapter2 = this.tabsAdapter;
        if (tabsAdapter2 == null || tabsAdapter2.statsFragment == null) {
            return;
        }
        this.tabsAdapter.statsFragment.setDataUpdated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeBilling() {
        JavaBilling javaBillingInitializeBilling = initializeBilling(this, null, null);
        this.billing = javaBillingInitializeBilling;
        UnlockFlow unlockFlow = this.unlockFlow;
        if (unlockFlow == null || javaBillingInitializeBilling == null) {
            return;
        }
        unlockFlow.setBilling(javaBillingInitializeBilling);
    }

    public void startUnlockFlow() {
        startUnlockFlow(SharedApplicationContext.getSettings().isSpecialPromoActive() ? Billing.PurchaseType.PROMO_SPECIAL : null);
    }
}
