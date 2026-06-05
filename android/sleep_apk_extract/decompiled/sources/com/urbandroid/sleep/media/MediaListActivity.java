package com.urbandroid.sleep.media;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.util.string.StringUtil;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.ViewUtil;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.media.Song;
import com.urbandroid.sleep.media.googlemusic.GoogleMusicPlayerKt;
import com.urbandroid.sleep.media.spotify.ConnectivityChangeReceiver;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.media.spotify.SpotifyManager;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.RadioUrlParser;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.VolumeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.models.UserPrivate;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes.dex */
public class MediaListActivity extends BaseActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private static final AtomicLong lastSpotifyAlbumLoad = new AtomicLong(0);
    private ActionMode actionMode;
    private MediaListAdapter adapter;
    private ConnectivityManager connectivityManager;
    private ListView listView;
    private View loading;
    private EditText search;
    private String searchQuery;
    private ViewGroup selectedSongLayout;
    private Settings settings;
    private TabLayout tabs;
    private SeekBar volumebar;
    private boolean initialActiveTabSet = false;
    private boolean multiple = false;
    private boolean perAlarm = false;
    private String initialSongTitle = null;
    private boolean silent = false;
    private int stream = 4;
    public String uri = null;
    private boolean hidePlaylists = false;
    private boolean showRadios = false;
    private boolean radiosOnly = false;
    private boolean showIntegration = false;
    private boolean showNatureRingtones = false;
    private boolean showPhoneInternalRingtones = false;
    private boolean showYourMusic = false;
    private ArrayList<String> selectedPlaylists = null;
    private int expandedMaskFromSettings = 0;
    private final AtomicBoolean radiosFromNetLoaded = new AtomicBoolean(false);
    private boolean isStreamingService = false;
    private ScrollAnimator scrollAnimator = null;
    private MediaTextWatcher filterTextWatcher = new MediaTextWatcher();
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() { // from class: com.urbandroid.sleep.media.MediaListActivity.11
        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            menuItem.getItemId();
            return false;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.playlist_menu, menu);
            ViewUtil.setOverflowButtonColor(R.color.white, MediaListActivity.this);
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            if (MediaListActivity.this.adapter != null) {
                MediaListActivity.this.adapter.clear();
                MediaListActivity.this.selectedPlaylists.clear();
                MediaListActivity.this.uri = null;
            }
            MediaListActivity.this.actionMode = null;
            MediaListActivity.this.multiple = false;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    };

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.MediaListActivity$15, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass15 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$media$Song$Type;

        static {
            int[] iArr = new int[Song.Type.values().length];
            $SwitchMap$com$urbandroid$sleep$media$Song$Type = iArr;
            try {
                iArr[Song.Type.NATURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$media$Song$Type[Song.Type.RADIO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$media$Song$Type[Song.Type.SPOTIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$media$Song$Type[Song.Type.DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$media$Song$Type[Song.Type.PLAYLIST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface LoadAlbumListener {
        void finished();
    }

    public class MediaTextWatcher implements TextWatcher {
        private String lastS;
        private int size = 0;
        private int pos = 0;

        public MediaTextWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (MediaListActivity.this.adapter == null) {
                return;
            }
            if (this.lastS == null && (charSequence == null || charSequence.toString().trim().isEmpty())) {
                return;
            }
            String str = this.lastS;
            if (str == null || !str.equals(charSequence.toString().trim())) {
                this.lastS = charSequence.toString().trim();
                MediaListActivity.this.searchQuery = charSequence.toString().trim();
                boolean zIsEmpty = MediaListActivity.this.searchQuery.isEmpty();
                MediaListActivity mediaListActivity = MediaListActivity.this;
                if (!zIsEmpty) {
                    mediaListActivity.reload(mediaListActivity.adapter.getSelectedSongs());
                    return;
                }
                mediaListActivity.searchQuery = null;
                MediaListActivity mediaListActivity2 = MediaListActivity.this;
                mediaListActivity2.reload(0, mediaListActivity2.adapter.getSelectedSongs());
            }
        }

        public void searchNext() {
            String str = this.lastS;
            if (str == null || str.length() <= 0) {
                return;
            }
            onTextChanged(this.lastS, 0, 0, 0);
        }
    }

    public interface OnChangeListener {
        void onChange();
    }

    public static AlertDialog createAddRadioDialog(final Context context, final OnChangeListener onChangeListener) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        View viewInflate = InflatorUtil.get(context).inflate(R.layout.dialog_add_radio, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.edit1);
        final EditText editText2 = (EditText) viewInflate.findViewById(R.id.edit2);
        Button button = (Button) viewInflate.findViewById(R.id.find);
        button.setText(context.getString(R.string.find) + " URL");
        button.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(editText, context, 21));
        materialAlertDialogBuilder.setView(viewInflate);
        materialAlertDialogBuilder.setPositiveButton(R.string.menu_add, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.media.MediaListActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MediaListActivity.lambda$createAddRadioDialog$4(editText, editText2, context, onChangeListener, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        return materialAlertDialogBuilder.create();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Uri uri2;
        Throwable th;
        Exception exc;
        Cursor cursorQuery;
        ?? r8 = 0;
        try {
            try {
                try {
                    uri2 = uri;
                    try {
                        cursorQuery = context.getContentResolver().query(uri2, new String[]{"_data"}, str, strArr, null);
                    } catch (Exception e) {
                        e = e;
                        exc = e;
                        cursorQuery = null;
                        Toast.makeText(context, R.string.general_unspecified_error, 1).show();
                        Logger.logSevere("MediaList: cannot resolve '" + uri2 + "'", exc);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    try {
                        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        cursorQuery.close();
                        return string;
                    } catch (Exception e2) {
                        exc = e2;
                        Toast.makeText(context, R.string.general_unspecified_error, 1).show();
                        Logger.logSevere("MediaList: cannot resolve '" + uri2 + "'", exc);
                        if (cursorQuery != null) {
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r8 = uri;
                    if (r8 != 0) {
                        throw th;
                    }
                    r8.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (r8 != 0) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            uri2 = uri;
        }
    }

    private int getExpandedFlagsBySongType(Song.Type type) {
        return 0;
    }

    private int getTabTitle(Song.Type type) {
        int i = AnonymousClass15.$SwitchMap$com$urbandroid$sleep$media$Song$Type[type.ordinal()];
        if (i == 1) {
            return R.string.ringtone_nature_ALL;
        }
        if (i == 2) {
            return R.string.online_radio;
        }
        if (i == 3) {
            return R.string.spotify;
        }
        if (i == 4) {
            return R.string.phone;
        }
        if (i != 5) {
            return 0;
        }
        return R.string.alert_playlist;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAddRadioDialog$3(EditText editText, Context context, View view) {
        if (editText.getText() != null && editText.getText().toString().trim().length() <= 1) {
            ViewIntent.url(context, "https://streamurl.link");
            return;
        }
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("station", editText.getText())};
        HashMap map = new HashMap(1);
        Map.Entry entry = entryArr[0];
        Object key = entry.getKey();
        Objects.requireNonNull(key);
        Object value = entry.getValue();
        Objects.requireNonNull(value);
        if (map.put(key, value) == null) {
            sendPostIntentViaRedirect(context, "https://streamurl.link", Collections.unmodifiableMap(map));
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m("duplicate key: ", key));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAddRadioDialog$4(EditText editText, EditText editText2, Context context, final OnChangeListener onChangeListener, DialogInterface dialogInterface, int i) {
        final String string = editText.getText().toString();
        final String string2 = editText2.getText().toString();
        if (ContextExtKt.hasConnectivity(context)) {
            new AsyncTask<Void, Void, String>() { // from class: com.urbandroid.sleep.media.MediaListActivity.12
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    String str2 = string;
                    if (str2 != null && str2.length() > 1 && str != null && str.length() > 8) {
                        SharedApplicationContext.getSettings().addOnlineRadio(string, str, "key_online_radios");
                    }
                    onChangeListener.onChange();
                }

                @Override // android.os.AsyncTask
                public String doInBackground(Void... voidArr) {
                    return RadioUrlParser.parse(string2);
                }
            }.execute(new Void[0]);
        } else {
            Toast.makeText(context, R.string.no_connection, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.filterTextWatcher.searchNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemClick$1(Settings settings, Song song, DialogInterface dialogInterface, int i) {
        settings.removeOnlineRadio(song.title, song.uri, "key_online_radios");
        lambda$onCreateDialog$5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemClick$2(View view, int i, DialogInterface dialogInterface, int i2) throws Throwable {
        MediaListAdapter mediaListAdapter = this.adapter;
        mediaListAdapter.toggleCheck(view, (Song) mediaListAdapter.getItem(i), true, this.multiple, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPostResumeAfterRecreate$6() {
        View viewFindViewById = findViewById(R.id.appbar);
        int[] iArr = new int[2];
        viewFindViewById.getLocationOnScreen(iArr);
        int dip = ActivityUtils.getDip(this, 48);
        int width = viewFindViewById.getWidth() - ActivityUtils.getDip(this, 58);
        int dip2 = ActivityUtils.getDip(this, 13) + iArr[1];
        Rect rect = new Rect(width, dip2, width + dip, dip + dip2);
        try {
            TapTargetView.showFor(this, TapTarget.forBounds(rect, getResources().getString(R.string.alert_playlist), getResources().getString(R.string.playlist_shuffle) + ", " + getResources().getString(R.string.playlist_ordered) + ", " + getResources().getString(R.string.playlist_loop_single)).dimColor(R.color.transparent_black).outerCircleColor(R.color.tap_target_color).icon(ContextCompat.getDrawable(this, R.drawable.ic_action_view_as_list_black)).textColor(R.color.primary).tintTarget(false));
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public static void loadAlbums(SpotifyServiceExecutor spotifyServiceExecutor, final LoadAlbumListener loadAlbumListener) {
        spotifyServiceExecutor.getUris(new SpotifyServiceExecutor.ResultListener<List<SpotifyServiceExecutor.SpotifyUri>>() { // from class: com.urbandroid.sleep.media.MediaListActivity.13
            @Override // com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor.ResultListener
            public void success(List<SpotifyServiceExecutor.SpotifyUri> list) {
                if (SharedApplicationContext.getSettings().getSpotifyAlbums().equals(list)) {
                    Logger.logDebug("MediaList: No change in Spotify albums");
                } else {
                    SharedApplicationContext.getSettings().storeSpotifyAlbums(list);
                }
                LoadAlbumListener loadAlbumListener2 = loadAlbumListener;
                if (loadAlbumListener2 != null) {
                    loadAlbumListener2.finished();
                }
            }
        }, Arrays.asList(SpotifyServiceExecutor.SpotifyUriType.ALBUM, SpotifyServiceExecutor.SpotifyUriType.PLAYLIST));
    }

    public static void loadSpotifyAlbums(final Activity activity, final LoadAlbumListener loadAlbumListener) {
        String spotifyToken = SharedApplicationContext.getSettings().getSpotifyToken();
        zza$$ExternalSyntheticOutline0.m("Spotify: ", spotifyToken);
        if (spotifyToken != null) {
            SpotifyApi spotifyApi = new SpotifyApi();
            spotifyApi.setAccessToken(spotifyToken);
            final SpotifyServiceExecutor spotifyServiceExecutor = new SpotifyServiceExecutor(spotifyApi.getService());
            spotifyServiceExecutor.getUser(new SpotifyServiceExecutor.ResultListener<UserPrivate>() { // from class: com.urbandroid.sleep.media.MediaListActivity.10
                @Override // com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor.ResultListener
                public void success(UserPrivate userPrivate) {
                    Logger.logInfo("Spotify: user " + userPrivate);
                    MediaListActivity.lastSpotifyAlbumLoad.set(System.currentTimeMillis());
                    if (userPrivate != null) {
                        SharedApplicationContext.getSettings().setSpotifyProduct(userPrivate.product);
                        SharedApplicationContext.getSettings().setSpotifyPremium(SpotifyManager.isPremium(userPrivate.product));
                        Logger.logInfo("Spotify: loading ");
                        MediaListActivity.loadAlbums(spotifyServiceExecutor, loadAlbumListener);
                        return;
                    }
                    SharedApplicationContext.getSettings().setSpotifyToken(null);
                    SpotifyManager.from(activity).authenticate();
                    LoadAlbumListener loadAlbumListener2 = loadAlbumListener;
                    if (loadAlbumListener2 != null) {
                        loadAlbumListener2.finished();
                    }
                }
            });
            return;
        }
        Logger.logInfo("Spotify: no token ");
        SpotifyManager.from(activity).authenticate();
        lastSpotifyAlbumLoad.set(System.currentTimeMillis());
        if (loadAlbumListener != null) {
            loadAlbumListener.finished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(boolean z) {
        synchronized (this) {
            try {
                MediaListAdapter mediaListAdapter = this.adapter;
                if (mediaListAdapter != null) {
                    mediaListAdapter.stopPlayer();
                    Logger.logInfo("MediaList: Selected song " + this.adapter.getSongUri());
                }
                MediaListAdapter mediaListAdapter2 = this.adapter;
                if (mediaListAdapter2 == null || mediaListAdapter2.getSongUri() == null || !this.adapter.isChanged()) {
                    setResult(0);
                } else {
                    Logger.logInfo("MediaList: Save song " + this.adapter.getSongUri());
                    Intent intent = getIntent();
                    intent.putExtra("extra_alert_title", this.adapter.getSongName());
                    intent.putExtra("extra_alert_uri", this.adapter.getSongUri().toString());
                    intent.putExtra("extra_playlists", new ArrayList(this.adapter.getSelectedPlaylists()));
                    Logger.logInfo("MediaList: RESULT_OK " + this.adapter.getSongUri());
                    setResult(-1, intent);
                }
                if (z) {
                    finish();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void sendPostIntentViaRedirect(Context context, String str, Map<String, Editable> map) {
        try {
            File file = new File(context.getExternalCacheDir(), "redirect.html");
            String stringFromInputStream = StringUtil.getStringFromInputStream(context.getAssets().open("radio_url_search.html"));
            ArrayList arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(String.format("<input type=\"hidden\" name=\"%s\" value=\"%s\" />", str2, map.get(str2)));
            }
            Logger.logDebug("redirect file: " + file.getAbsolutePath());
            String strReplace = stringFromInputStream.replace("{{url}}", str).replace("{{method}}", "POST").replace("{{enctype}}", "multipart/form-data");
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (true) {
                    sb.append((CharSequence) next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) "\n");
                    next = it.next();
                }
            }
            String strReplace2 = strReplace.replace("{{fields}}", sb.toString());
            new FileOutputStream(file).write(strReplace2.getBytes());
            Logger.logDebug("redirect: " + strReplace2);
            Uri uriForFile = FileProvider.getUriForFile(context, "com.urbandroid.sleep.fileprovider", file);
            new Handler().postDelayed(new MediaListActivity$$ExternalSyntheticLambda4(file, 1), 8000L);
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            customTabsIntentBuild.intent.addFlags(1);
            customTabsIntentBuild.launchUrl(context, uriForFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActiveTab(TabLayout.Tab tab) {
        Logger.logDebug("setActiveSection: " + tab.getId());
        for (Song.Type type : Song.Type.values()) {
            if (tab.getPosition() == type.ordinal()) {
                setVisibilityVariablesBySongType(type);
                reload(getExpandedFlagsBySongType(type));
                if (type == Song.Type.SPOTIFY && this.settings.isSpotify() && ConnectivityChangeReceiver.isConnected(this.connectivityManager) && (System.currentTimeMillis() - lastSpotifyAlbumLoad.get()) / 1000 > 120) {
                    loadSpotifyAlbums(this, new MediaListActivity$$ExternalSyntheticLambda3(this));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInitialActiveTab() {
        MediaListAdapter mediaListAdapter = this.adapter;
        if (mediaListAdapter == null || this.initialActiveTabSet) {
            return;
        }
        setActiveTab(mediaListAdapter.getSelectedSongsType().ordinal());
        this.initialActiveTabSet = true;
    }

    private void setVisibilityVariablesBySongType(Song.Type type) {
        Song.Type type2 = Song.Type.PLAYLIST;
        this.showNatureRingtones = type == type2 || type == Song.Type.NATURE;
        this.showPhoneInternalRingtones = type == type2 || type == Song.Type.DEVICE;
        this.showYourMusic = type == type2 || type == Song.Type.DEVICE;
        this.showRadios = type == type2 || type == Song.Type.RADIO;
        this.radiosOnly = type == Song.Type.RADIO;
        this.showIntegration = type == type2 || type == Song.Type.SPOTIFY;
        this.multiple = type == type2;
    }

    private void setupVolumeBar(SeekBar seekBar, final int i) {
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        int streamMaxVolume = audioManager.getStreamMaxVolume(i);
        int streamVolume = audioManager.getStreamVolume(i);
        seekBar.setMax(streamMaxVolume);
        seekBar.setProgress(streamVolume);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.urbandroid.sleep.media.MediaListActivity.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int i2, boolean z) {
                StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i2, "MediaList: Setting volume ", " stream ");
                sbM65m.append(MediaListActivity.this.streamName(i));
                Logger.logInfo(sbM65m.toString());
                Logger.logDebug("MediaList: setVolumeStream() " + i2);
                VolumeUtil.setStreamVolume(MediaListActivity.this.getApplicationContext(), i, i2);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String streamName(int i) {
        return i != 3 ? i != 4 ? String.valueOf(i) : "ALARM" : "MUSIC";
    }

    public String getRealPathFromUri(Uri uri) {
        if (Environment.isKitKatOrGreater()) {
            try {
                Logger.logInfo("MediaList: getPath authority " + uri.getAuthority() + " uri " + uri);
                if (isMediaDocument(uri)) {
                    String str = (String) Class.forName("android.provider.DocumentsContract").getDeclaredMethod("getDocumentId", Uri.class).invoke(null, uri);
                    Logger.logInfo("MediaList: docId " + str);
                    String[] strArrSplit = str.split(":");
                    String str2 = strArrSplit[0];
                    Logger.logInfo("MediaList: type " + str2);
                    if (!"audio".equals(str2)) {
                        throw new IllegalArgumentException("Not an audio document");
                    }
                    Uri uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    String[] strArr = {strArrSplit[1]};
                    Logger.logInfo("MediaList: id " + strArrSplit[1]);
                    return getDataColumn(this, uri2, "_id=?", strArr);
                }
                if (isDownloadsDocument(uri)) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue());
                    Logger.logInfo("MediaList: uri from downloads " + uriWithAppendedId);
                    return getDataColumn(this, uriWithAppendedId, null, null);
                }
                if (isExternalStorageDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit2[0])) {
                        return android.os.Environment.getExternalStorageDirectory() + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit2[1];
                    }
                }
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return uri.toString();
                }
                throw new IllegalArgumentException("Not an media document. Authority: " + uri.getAuthority());
            } catch (Exception e) {
                Logger.logSevere("MediaList: error ", e);
                Toast.makeText(this, "Not a local audio file", 0).show();
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(this, uri, null, null);
            }
            if (ShareInternalUtility.STAGING_PARAM.equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public int getStream() {
        return this.stream;
    }

    public boolean isStreamingServiceUri(String str) {
        return ISpotifyPlayer.INSTANCE.isSpotifyUri(str) || GoogleMusicPlayerKt.isGoogleMusicPlaylistUri(str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Cursor cursorQuery = null;
        if (i == 1337) {
            MediaListAdapter mediaListAdapter = this.adapter;
            if (mediaListAdapter == null) {
                Logger.logSevere("MediaList: NULL adapter");
                return;
            }
            View view = mediaListAdapter.getLastSelectedView().get();
            final ProgressBar progressBar = view != null ? (ProgressBar) view.findViewById(R.id.progress) : null;
            SpotifyManager.from(this).onAuthenticateResult(i, i2, intent, new SpotifyManager.ResultListener() { // from class: com.urbandroid.sleep.media.MediaListActivity.14
                @Override // com.urbandroid.sleep.media.spotify.SpotifyManager.ResultListener
                public void fail(int i3) {
                    ProgressBar progressBar2 = progressBar;
                    if (progressBar2 != null) {
                        progressBar2.setVisibility(8);
                    }
                }

                @Override // com.urbandroid.sleep.media.spotify.SpotifyManager.ResultListener
                public void success(String str) {
                    MediaListActivity.this.settings.setSpotifyToken(str);
                    SpotifyApi spotifyApi = new SpotifyApi();
                    spotifyApi.setAccessToken(str);
                    MediaListActivity.loadAlbums(new SpotifyServiceExecutor(spotifyApi.getService()), null);
                }
            });
            return;
        }
        if (intent == null) {
            Toast.makeText(this, "Nothing selected", 0).show();
            return;
        }
        Logger.logInfo("MediaList: Data " + intent);
        Logger.logInfo("MediaList: Data " + intent.getData());
        Logger.logInfo("MediaList: Data " + intent.getExtras());
        if (intent.getExtras() != null) {
            Iterator<String> it = intent.getExtras().keySet().iterator();
            while (it.hasNext()) {
                zza$$ExternalSyntheticOutline0.m("MediaList: Data ", it.next());
            }
        }
        String string = getString(R.string.alert);
        if (intent.getData() != null) {
            String string2 = intent.getData().toString();
            Intent intent2 = new Intent();
            if (string2.startsWith("content://")) {
                try {
                    cursorQuery = getContentResolver().query(Uri.parse(string2), null, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    }
                    cursorQuery.close();
                    grantUriPermission(getPackageName(), intent.getData(), 1);
                    getContentResolver().takePersistableUriPermission(intent.getData(), intent.getFlags() & 1);
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            } else if (ISpotifyPlayer.INSTANCE.isSpotifyUri(string2)) {
                string = getString(R.string.spotify);
            }
            intent2.putExtra("extra_alert_title", string);
            if (string2.startsWith("content")) {
                String realPathFromUri = getRealPathFromUri(intent.getData());
                if (realPathFromUri != null) {
                    Logger.logInfo("MediaList: Resolved uri ".concat(realPathFromUri));
                    string2 = realPathFromUri;
                } else {
                    Toast.makeText(this, R.string.general_unspecified_error, 0).show();
                    setResult(0, intent2);
                    finish();
                }
            }
            intent2.putExtra("extra_alert_uri", string2);
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        Settings settings = new Settings(getApplicationContext());
        this.settings = settings;
        this.expandedMaskFromSettings = settings.getMediaListExpandedMask();
        this.connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
        setContentView(R.layout.activity_media_list);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setStatusBarColor(ColorUtil.i(this, R.color.bar));
        EdgeToEdgeUtil.insetsBottom(findViewById(R.id.button_panel));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_action_accept);
        }
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.surface_variant));
        int i = 0;
        if (getIntent() != null) {
            this.multiple = getIntent().getBooleanExtra("extra_alert_multiple", false);
            this.hidePlaylists = getIntent().getBooleanExtra("extra_allow_playlist", false);
            ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("extra_playlists");
            this.selectedPlaylists = stringArrayListExtra;
            if (stringArrayListExtra == null) {
                this.selectedPlaylists = new ArrayList<>();
            }
            String stringExtra = getIntent().getStringExtra("extra_alert_uri");
            this.uri = stringExtra;
            try {
                if (MultipleMediaUriUtil.isMultipleUri(Uri.parse(stringExtra))) {
                    this.multiple = true;
                }
            } catch (Exception unused) {
            }
            if (this.multiple) {
                this.stream = getIntent().getIntExtra("extra_stream", 4);
                Iterator<String> it = this.selectedPlaylists.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (isStreamingServiceUri(it.next())) {
                        this.isStreamingService = true;
                        break;
                    }
                }
            } else if (getIntent().hasExtra("extra_stream")) {
                this.stream = getIntent().getIntExtra("extra_stream", 4);
            } else {
                this.isStreamingService = isStreamingServiceUri(this.uri);
                this.stream = (isStreamingServiceUri(this.uri) || this.settings.getAlarmOutput() > 0) ? 3 : 4;
            }
            this.showIntegration = getIntent().getBooleanExtra("extra_integration", false);
            this.showRadios = getIntent().getBooleanExtra("extra_alert_radio", true);
            this.radiosOnly = getIntent().hasExtra("extra_alert_radio_only");
            this.silent = getIntent().getBooleanExtra("extra_silent", false);
            this.perAlarm = getIntent().getBooleanExtra("extra_hide_app_settings", false);
            this.initialSongTitle = getIntent().getStringExtra("extra_alert_title");
            if (getIntent().hasExtra("extra_alert_radio_add")) {
                showDialog(1);
            }
        }
        if (bundle != null) {
            this.initialSongTitle = bundle.getString("title");
            this.uri = bundle.getString(ShareConstants.MEDIA_URI);
        }
        EditText editText = (EditText) findViewById(R.id.search);
        this.search = editText;
        editText.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.media.MediaListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaListActivity.this.search.setVisibility(0);
                MediaListActivity.this.search.requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) MediaListActivity.this.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(MediaListActivity.this.search, 1);
                }
            }
        });
        this.search.setOnClickListener(new MediaListActivity$$ExternalSyntheticLambda0(this, i));
        View viewFindViewById = findViewById(R.id.progress);
        this.loading = viewFindViewById;
        viewFindViewById.setVisibility(0);
        ListView listView = (ListView) findViewById(R.id.list);
        this.listView = listView;
        listView.setVerticalFadingEdgeEnabled(false);
        this.listView.setNestedScrollingEnabled(true);
        this.listView.setOnItemClickListener(this);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        if (appBarLayout != null) {
            appBarLayout.setOutlineProvider(null);
            appBarLayout.setBackgroundColor(ColorUtil.i(this, R.color.bg_main));
            appBarLayout.setStatusBarForegroundColor(ColorUtil.i(this, R.color.bg_main));
            if (Build.VERSION.SDK_INT >= 28) {
                appBarLayout.setOutlineAmbientShadowColor(ColorUtil.i(this, R.color.bg_main));
                appBarLayout.setOutlineSpotShadowColor(ColorUtil.i(this, R.color.bg_main));
            }
            appBarLayout.setDrawingCacheBackgroundColor(ColorUtil.i(this, R.color.bg_main));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.preview_card);
        this.selectedSongLayout = viewGroup;
        this.volumebar = (SeekBar) viewGroup.findViewById(R.id.volumebar);
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.media.MediaListActivity.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                if (MediaListActivity.this.scrollAnimator == null) {
                    MediaListActivity.this.scrollAnimator = new ScrollAnimator(MediaListActivity.this);
                }
                MediaListActivity.this.scrollAnimator.scroll(i2);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
            }
        });
        setupVolumeBar(this.volumebar, this.stream);
        ViewGroup viewGroup2 = (ViewGroup) getLayoutInflater().inflate(R.layout.row_media_list_header, (ViewGroup) null);
        ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(R.layout.row_media_list_footer, (ViewGroup) null);
        this.listView.addHeaderView(viewGroup2);
        this.listView.addFooterView(viewGroup3);
        this.tabs = (TabLayout) findViewById(R.id.categories);
        Song.Type[] typeArrValues = Song.Type.values();
        int length = typeArrValues.length;
        while (i < length) {
            Song.Type type = typeArrValues[i];
            TabLayout.Tab tabNewTab = this.tabs.newTab();
            if ((!this.hidePlaylists || type != Song.Type.PLAYLIST) && (((z = this.showIntegration) || type != Song.Type.RADIO) && (z || type != Song.Type.SPOTIFY))) {
                this.tabs.addTab(tabNewTab);
                tabNewTab.setText(getTabTitle(type));
            }
            i++;
        }
        this.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.urbandroid.sleep.media.MediaListActivity.3
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                MediaListActivity.this.setActiveTab(tab);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        Button button = (Button) findViewById(R.id.media_save);
        Button button2 = (Button) findViewById(R.id.media_revert);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.media.MediaListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaListActivity.this.save();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.media.MediaListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                synchronized (MediaListActivity.this) {
                    try {
                        if (MediaListActivity.this.adapter != null) {
                            MediaListActivity.this.adapter.stopPlayer();
                        }
                        MediaListActivity.this.setResult(0);
                        MediaListActivity.this.finish();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        if ((getResources().getConfiguration().screenLayout & 15) < 2) {
            findViewById(R.id.button_panel).setVisibility(8);
        }
        if (this.search.getTag() == null) {
            this.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.MediaListActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(MediaListActivity.this.getApplicationContext(), R.anim.switch_text_out);
                    final Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(MediaListActivity.this.getApplicationContext(), R.anim.switch_text_in);
                    animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.media.MediaListActivity.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            MediaListActivity.this.search.setHint(R.string.search);
                            MediaListActivity.this.search.setAnimation(animationLoadAnimation2);
                            MediaListActivity.this.search.setTag("done");
                            MediaListActivity.this.search.setVisibility(0);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    MediaListActivity.this.search.startAnimation(animationLoadAnimation);
                }
            }, 1500L);
        }
        AlarmSettingsActivity.askOverlay(this);
        OnlineRadioRingtones.syncRadiosIfRequired(this);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i != 1) {
            return null;
        }
        return createAddRadioDialog(this, new MediaListActivity$$ExternalSyntheticLambda3(this));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ringtone_menu, menu);
        MenuUtil.showIcons(menu);
        menu.findItem(R.id.menu_ringtone).setTitle(getString(R.string.xmore, ""));
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, final View view, int i, long j) throws Throwable {
        if (this.adapter == null) {
            return;
        }
        final int i2 = i - 1;
        Settings settings = SharedApplicationContext.getSettings();
        int itemViewType = this.adapter.getItemViewType(i2);
        if (itemViewType == 1 || itemViewType == 2) {
            Song song = (Song) this.adapter.getItem(i2);
            int i3 = 0;
            if (this.multiple || !settings.hasOnlineRadiosForUrl(song.uri, "key_online_radios")) {
                this.isStreamingService = false;
                if (!this.multiple || itemViewType != 1) {
                    this.isStreamingService = isStreamingServiceUri(song.uri);
                } else if (this.adapter.isChecked(view) || !isStreamingServiceUri(song.uri)) {
                    Iterator<Song> it = this.adapter.getSelectedSongs().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Song next = it.next();
                        if (isStreamingServiceUri(next.uri) && !next.uri.equals(song.uri)) {
                            this.isStreamingService = true;
                            break;
                        }
                    }
                } else {
                    this.isStreamingService = true;
                }
                this.adapter.toggleCheck(view, song, true, this.multiple, i2);
            } else {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(view.getContext());
                materialAlertDialogBuilder.setTitle((CharSequence) song.title);
                materialAlertDialogBuilder.setNeutralButton(R.string.delete, (DialogInterface.OnClickListener) new MediaListActivity$$ExternalSyntheticLambda1(this, settings, song, i3));
                materialAlertDialogBuilder.setPositiveButton(R.string.set_time, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.media.MediaListActivity$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) throws Throwable {
                        this.f$0.lambda$onItemClick$2(view, i2, dialogInterface, i4);
                    }
                });
                materialAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
                materialAlertDialogBuilder.create().show();
            }
        }
        AlarmSettingsActivity.askOverlay(this);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) throws Throwable {
        if (this.actionMode == null) {
            startPlaylistSelection();
        }
        onItemClick(adapterView, view, i, j);
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        save();
        return false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intentCreateChooser;
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            save();
            finish();
            return true;
        }
        if (itemId == R.id.menu_help) {
            ViewIntent.url(this, "https://sleep.urbandroid.org/docs//alarms/ringtone.html");
        } else if (itemId == R.id.menu_ringtone) {
            if (PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") || PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_MEDIA_AUDIO")) {
                try {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    if (Environment.isKitKatOrGreater()) {
                        intentCreateChooser = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intentCreateChooser.addCategory("android.intent.category.OPENABLE");
                    } else {
                        intent.setType("audio/*");
                        intentCreateChooser = Intent.createChooser(intent, getString(R.string.alert));
                    }
                    intentCreateChooser.setType("audio/*");
                    startActivityForResult(intentCreateChooser, 1);
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(this, "No system media picker", 0).show();
                }
            } else if (Build.VERSION.SDK_INT >= 33) {
                SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
                sleepPermissionCompat.requestPermission(this, "android.permission.READ_MEDIA_AUDIO", 1);
                if (sleepPermissionCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_MEDIA_AUDIO")) {
                    Toast.makeText(this, R.string.no_permission, 0).show();
                }
            } else {
                SleepPermissionCompat sleepPermissionCompat2 = SleepPermissionCompat.INSTANCE;
                sleepPermissionCompat2.requestPermission(this, "android.permission.READ_EXTERNAL_STORAGE", 1);
                if (sleepPermissionCompat2.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE")) {
                    Toast.makeText(this, R.string.no_permission, 0).show();
                }
            }
            return true;
        }
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity
    public void onPostResumeAfterRecreate() {
        Logger.logInfo("Theme: onPostAfterRecreate() called");
        if (!Environment.isIcsOrGreater() || this.multiple || this.hidePlaylists || !new Settings(this).showShowCaseIfNotShown("sc_media_playlist")) {
            return;
        }
        new Handler().postDelayed(new MediaListActivity$$ExternalSyntheticLambda4(this, 0), 1000L);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        MediaListAdapter mediaListAdapter = this.adapter;
        if (mediaListAdapter != null && mediaListAdapter.getSongUri() != null) {
            bundle.putString(ShareConstants.MEDIA_URI, this.adapter.getSongUri().toString());
            bundle.putString("title", this.adapter.getSongName());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        lambda$onCreateDialog$5();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.adapter != null) {
            try {
                this.search.removeTextChangedListener(this.filterTextWatcher);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
            this.adapter.stop();
        }
    }

    public void reload(final String str, String str2, final boolean z, final int i, final int i2, int i3, final long j, final List<Song> list) {
        this.uri = str;
        MediaListAdapter mediaListAdapter = this.adapter;
        if (mediaListAdapter != null) {
            mediaListAdapter.stopPlayer();
        }
        final String str3 = str2 == null ? this.initialSongTitle : str2;
        Logger.logInfo("update selected song reload " + str + " " + str2);
        this.loading.setVisibility(0);
        int iAllExpandedFlag = MediaListCursorBuilder.allExpandedFlag();
        Settings settings = this.settings;
        if (i == iAllExpandedFlag) {
            settings.setMediaListExpandedMask(0);
        } else {
            settings.setMediaListExpandedMask(i);
        }
        MediaListAdapter mediaListAdapter2 = this.adapter;
        final int separatorPosition = mediaListAdapter2 != null ? mediaListAdapter2.getSeparatorPosition(i3) : -1;
        final int firstVisiblePosition = this.adapter != null ? this.listView.getFirstVisiblePosition() : -1;
        final int lastVisiblePosition = this.adapter != null ? this.listView.getLastVisiblePosition() : -1;
        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.media.MediaListActivity.8
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                MediaListActivity mediaListActivity = MediaListActivity.this;
                MediaListAdapter mediaListAdapter3 = new MediaListAdapter(mediaListActivity, mediaListActivity.multiple, MediaListActivity.this.perAlarm, MediaListActivity.this.silent || MediaListActivity.this.perAlarm, new Song(str, str3), MediaListActivity.this.radiosOnly, MediaListActivity.this.showRadios, MediaListActivity.this.showIntegration, MediaListActivity.this.showNatureRingtones, MediaListActivity.this.showPhoneInternalRingtones, MediaListActivity.this.showYourMusic, MediaListActivity.this.selectedPlaylists != null ? new HashSet(MediaListActivity.this.selectedPlaylists) : null, list, i, MediaListActivity.this.searchQuery);
                synchronized (MediaListActivity.this) {
                    MediaListActivity.this.adapter = mediaListAdapter3;
                }
                return null;
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:4:0x0003, B:6:0x000c, B:10:0x001e, B:12:0x0054, B:14:0x0058, B:21:0x0067, B:19:0x005f, B:22:0x0073, B:23:0x0081, B:9:0x001a, B:24:0x009e), top: B:29:0x0003 }] */
            @Override // android.os.AsyncTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onPostExecute(Void r7) {
                synchronized (MediaListActivity.this) {
                    try {
                        if (MediaListActivity.this.adapter != null) {
                            View childAt = MediaListActivity.this.listView.getChildAt(0);
                            int top = childAt == null ? 0 : childAt.getTop();
                            MediaListActivity.this.listView.setAdapter((ListAdapter) MediaListActivity.this.adapter);
                            MediaListActivity.this.adapter.setChanged(z);
                            MediaListActivity mediaListActivity = MediaListActivity.this;
                            mediaListActivity.setTitle(MultipleMediaUriUtil.size(mediaListActivity.adapter.getSongUri()), MediaListActivity.this.multiple);
                            int i4 = separatorPosition;
                            if (i4 != -1) {
                                if (i4 < firstVisiblePosition || i4 > lastVisiblePosition) {
                                    if (j == -3) {
                                        MediaListActivity.this.listView.setSelectionFromTop(firstVisiblePosition, top);
                                    } else {
                                        MediaListActivity.this.listView.setSelectionFromTop(firstVisiblePosition - i2, top);
                                    }
                                }
                            }
                            MediaListActivity.this.setInitialActiveTab();
                            MediaListActivity.this.adapter.setSelectedSongParent(MediaListActivity.this.selectedSongLayout);
                            MediaListActivity.this.adapter.updateSelectedSong();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                MediaListActivity.this.search.addTextChangedListener(MediaListActivity.this.filterTextWatcher);
                MediaListActivity.this.listView.setVisibility(0);
                MediaListActivity.this.loading.setVisibility(8);
                MediaListActivity.this.save(false);
            }
        }.execute(new Void[0]);
        if (!this.showRadios || this.radiosFromNetLoaded.get()) {
            return;
        }
        new AsyncTask<Void, Void, Boolean>() { // from class: com.urbandroid.sleep.media.MediaListActivity.9
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                try {
                    return Boolean.valueOf(new OnlineRadioRingtones().getRadiosFromNet().wasUpdated);
                } catch (Exception e) {
                    Logger.logSevere("MediaList: getRadiosFromNet failure", e);
                    return Boolean.FALSE;
                }
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Boolean bool) {
                MediaListActivity.this.radiosFromNetLoaded.set(true);
                if (bool.booleanValue()) {
                    MediaListActivity.this.lambda$onCreateDialog$5();
                }
            }
        }.execute(new Void[0]);
    }

    public void setTitle(int i, boolean z) {
        ActionMode actionMode;
        if (z && (actionMode = this.actionMode) != null) {
            actionMode.setTitle(getString(R.string.alert_playlist_size, Integer.valueOf(i)));
            return;
        }
        MediaListAdapter mediaListAdapter = this.adapter;
        if (mediaListAdapter == null || mediaListAdapter.getSelectedSongs().size() <= 1) {
            setTitle(getString(R.string.alert));
            return;
        }
        if (getSupportActionBar() != null) {
            setTitle(getString(R.string.alert) + " (" + i + ")");
        }
    }

    public void startPlaylistSelection() {
        Logger.logInfo("MediaList: startPlaylistSelection ");
        MediaListAdapter mediaListAdapter = this.adapter;
        if (mediaListAdapter == null) {
            return;
        }
        this.uri = null;
        mediaListAdapter.clear();
        this.multiple = true;
        Iterator<Song> it = this.adapter.getSelectedSongs().iterator();
        while (it.hasNext()) {
            Logger.logInfo("MediaList: SONG " + it.next());
        }
        Logger.logInfo("MediaList: songs " + this.adapter.getSelectedSongs().size());
        reload(this.adapter.getSelectedSongs());
    }

    private void setActiveTab(int i) {
        try {
            TabLayout tabLayout = this.tabs;
            tabLayout.selectTab(tabLayout.getTabAt(i));
            setActiveTab(this.tabs.getTabAt(i));
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public void reload(List<Song> list) {
        MediaListAdapter mediaListAdapter = this.adapter;
        reload(mediaListAdapter != null ? mediaListAdapter.expandedMask : this.expandedMaskFromSettings, list);
    }

    public void reload(int i, List<Song> list) {
        String str = this.uri;
        MediaListAdapter mediaListAdapter = this.adapter;
        reload(str, null, mediaListAdapter != null && mediaListAdapter.isChanged(), i, 0, 0, 0L, list);
    }

    public void reload(int i) {
        String str = this.uri;
        MediaListAdapter mediaListAdapter = this.adapter;
        boolean z = mediaListAdapter != null && mediaListAdapter.isChanged();
        MediaListAdapter mediaListAdapter2 = this.adapter;
        reload(str, null, z, i, 0, 0, 0L, mediaListAdapter2 != null ? mediaListAdapter2.getSelectedSongs() : new ArrayList<>());
    }

    /* JADX INFO: renamed from: reload, reason: merged with bridge method [inline-methods] */
    public void lambda$onCreateDialog$5() {
        MediaListAdapter mediaListAdapter = this.adapter;
        reload(mediaListAdapter != null ? mediaListAdapter.expandedMask : this.expandedMaskFromSettings, mediaListAdapter != null ? mediaListAdapter.getSelectedSongs() : new ArrayList<>());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save() {
        save(true);
    }
}
