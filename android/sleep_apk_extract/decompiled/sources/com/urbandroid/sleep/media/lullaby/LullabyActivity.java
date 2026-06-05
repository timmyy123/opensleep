package com.urbandroid.sleep.media.lullaby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.NextAlarmPreference$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.OnlineRadioRingtones;
import com.urbandroid.sleep.media.spotify.SpotifyManager;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.EdgeToEdgeUtil;
import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u00010\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0019\u0010\u0004J)\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0004R\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\tR$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyActivity;", "Lcom/urbandroid/common/BaseActivity;", "", "<init>", "()V", "", "show", "", "updatePlaying", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "onStop", "Landroid/view/Menu;", "menu", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "onPause", "onResume", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "startedFromTracking", "Z", "getStartedFromTracking", "()Z", "setStartedFromTracking", "Lcom/urbandroid/sleep/media/lullaby/LullabyFragment;", "fragment", "Lcom/urbandroid/sleep/media/lullaby/LullabyFragment;", "getFragment", "()Lcom/urbandroid/sleep/media/lullaby/LullabyFragment;", "setFragment", "(Lcom/urbandroid/sleep/media/lullaby/LullabyFragment;)V", "Landroid/content/BroadcastReceiver;", "actionReceiver", "Landroid/content/BroadcastReceiver;", "com/urbandroid/sleep/media/lullaby/LullabyActivity$playingReceiver$1", "playingReceiver", "Lcom/urbandroid/sleep/media/lullaby/LullabyActivity$playingReceiver$1;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabyActivity extends BaseActivity {
    private LullabyFragment fragment;
    private boolean startedFromTracking;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_STARTED_FROM_TRACKING = "started_from_tracking";
    private static final String ACTION_REFRESH = "com.urbandroid.sleep.ACTION_REFRESH_LULLABY_LIST";
    private static final String ACTION_REFRESH_SPOTIFY = "com.urbandroid.sleep.ACTION_REFRESH_LULLABY_LIST";
    private static final String ACTION_CLOSE = "com.urbandroid.sleep.ACTION_CLOSE_LULLABY_LIST";
    private final BroadcastReceiver actionReceiver = new LullabyActivity$actionReceiver$1(this);
    private final LullabyActivity$playingReceiver$1 playingReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.media.lullaby.LullabyActivity$playingReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.this$0.updatePlaying();
        }
    };

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyActivity$Companion;", "", "<init>", "()V", "EXTRA_STARTED_FROM_TRACKING", "", "getEXTRA_STARTED_FROM_TRACKING", "()Ljava/lang/String;", "ACTION_REFRESH", "getACTION_REFRESH", "ACTION_REFRESH_SPOTIFY", "getACTION_REFRESH_SPOTIFY", "ACTION_CLOSE", "getACTION_CLOSE", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "startFromTracking", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getACTION_CLOSE() {
            return LullabyActivity.ACTION_CLOSE;
        }

        public final String getACTION_REFRESH() {
            return LullabyActivity.ACTION_REFRESH;
        }

        public final String getACTION_REFRESH_SPOTIFY() {
            return LullabyActivity.ACTION_REFRESH_SPOTIFY;
        }

        public final String getEXTRA_STARTED_FROM_TRACKING() {
            return LullabyActivity.EXTRA_STARTED_FROM_TRACKING;
        }

        public final void start(Context context) {
            context.getClass();
            context.startActivity(new Intent(context, (Class<?>) LullabyActivity.class));
        }

        public final void startFromTracking(Context context) {
            context.getClass();
            Intent intent = new Intent(context, (Class<?>) LullabyActivity.class);
            intent.putExtra(getEXTRA_STARTED_FROM_TRACKING(), true);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.lullaby.LullabyActivity$onActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/urbandroid/sleep/media/lullaby/LullabyActivity$onActivityResult$1", "Lcom/urbandroid/sleep/media/spotify/SpotifyManager$ResultListener;", GraphResponse.SUCCESS_KEY, "", SDKConstants.PARAM_ACCESS_TOKEN, "", "fail", "reason", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 implements SpotifyManager.ResultListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void success$lambda$0(LullabyActivity lullabyActivity) {
            LullabyFragment fragment = lullabyActivity.getFragment();
            if (fragment != null) {
                fragment.refresh();
            }
        }

        @Override // com.urbandroid.sleep.media.spotify.SpotifyManager.ResultListener
        public void fail(int reason) {
        }

        @Override // com.urbandroid.sleep.media.spotify.SpotifyManager.ResultListener
        public void success(String accessToken) {
            accessToken.getClass();
            SharedApplicationContext.getSettings().setSpotifyToken(accessToken);
            SpotifyApi spotifyApi = new SpotifyApi();
            spotifyApi.setAccessToken(accessToken);
            SpotifyService service = spotifyApi.getService();
            service.getClass();
            MediaListActivity.loadAlbums(new SpotifyServiceExecutor(service), new LullabyActivity$actionReceiver$1$$ExternalSyntheticLambda0(LullabyActivity.this, 1));
        }
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    public static final void startFromTracking(Context context) {
        INSTANCE.startFromTracking(context);
    }

    private final void updatePlaying(boolean show) {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.playing);
        viewGroup.setOnTouchListener(new NextAlarmPreference$$ExternalSyntheticLambda1(4));
        TextView textView = (TextView) findViewById(R.id.playing_title);
        View viewFindViewById = findViewById(R.id.playing_stop);
        ImageView imageView = (ImageView) findViewById(R.id.playing_icon);
        imageView.setImageResource(R.drawable.ic_tab_graph_anim_ongoing);
        Drawable drawable = imageView.getDrawable();
        drawable.getClass();
        ((AnimationDrawable) drawable).start();
        viewGroup.setVisibility(show ? 0 : 8);
        textView.setText(LullabyService.LULLABY_NAME);
        viewFindViewById.setOnClickListener(new LullabyItem$$ExternalSyntheticLambda0(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updatePlaying$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updatePlaying$lambda$1(LullabyActivity lullabyActivity, View view) {
        if (LullabyService.isRunning()) {
            LullabyService.stop(lullabyActivity);
        }
        lullabyActivity.updatePlaying(false);
    }

    public final LullabyFragment getFragment() {
        return this.fragment;
    }

    public final boolean getStartedFromTracking() {
        return this.startedFromTracking;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        super.onActivityResult(requestCode, resultCode, data2);
        if (requestCode == 1337) {
            SpotifyManager.from(this).onAuthenticateResult(requestCode, resultCode, data2, new AnonymousClass1());
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_lullaby);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.lullaby);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        EdgeToEdgeUtil.Companion.insetsBottom$default(EdgeToEdgeUtil.INSTANCE, findViewById(R.id.playing), 0, false, 6, null);
        if (SleepService.isRunning()) {
            getDelegate().setLocalNightMode(2);
        }
        KeyguardUtil.disable(this);
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Lullaby_screen");
        OnlineRadioRingtones.syncRadiosIfRequired(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.startedFromTracking = intent.hasExtra(EXTRA_STARTED_FROM_TRACKING);
        }
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragmentFindFragmentById.getClass();
        this.fragment = (LullabyFragment) fragmentFindFragmentById;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.lullaby_menu, menu);
        MenuUtil.INSTANCE.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_doc) {
            ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/lullaby.html");
            return true;
        }
        if (itemId != R.id.menu_settings) {
            return true;
        }
        startActivity(new Intent(this, (Class<?>) LullabySettingsActivity.class));
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.playingReceiver);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        updatePlaying();
        LullabyActivity$playingReceiver$1 lullabyActivity$playingReceiver$1 = this.playingReceiver;
        IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_STOPPED_PLAYBACK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_AUTO_STOP_PLAYBACK");
        Unit unit = Unit.INSTANCE;
        ContextCompat.registerReceiver(this, lullabyActivity$playingReceiver$1, intentFilter, 2);
        LullabyFragment lullabyFragment = this.fragment;
        if (lullabyFragment != null) {
            lullabyFragment.refresh();
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        BroadcastReceiver broadcastReceiver = this.actionReceiver;
        IntentFilter intentFilter = new IntentFilter(ACTION_REFRESH);
        intentFilter.addAction(ACTION_REFRESH_SPOTIFY);
        intentFilter.addAction(ACTION_CLOSE);
        Unit unit = Unit.INSTANCE;
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.actionReceiver);
    }

    public final void updatePlaying() {
        updatePlaying(LullabyService.isRunning());
    }
}
