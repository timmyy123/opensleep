package com.urbandroid.sleep.media;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.work.WorkerKt$$ExternalSyntheticLambda0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.squareup.picasso.Picasso;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.string.Joiner;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.DefaultRingtoneResolveService;
import com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.media.InternalRingtones;
import com.urbandroid.sleep.media.OnlineRadioRingtones;
import com.urbandroid.sleep.media.Song;
import com.urbandroid.sleep.media.player.PlaybackListener;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.ResourceUtil;
import com.urbandroid.util.RoundCornersTransform;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes.dex */
public class MediaListAdapter extends BaseAdapter {
    public static final String[] COLUMNS = {"_id", "title", "artist", "_data", "songImage", "media_volume"};
    private MediaListActivity activity;
    private final Cursor cursor;
    public final int expandedMask;
    private Handler h;
    private boolean isPerAlarmRingtone;
    private boolean multiple;
    private long nextSongInOrder;
    private ImageButton playButton;
    private ImageButton playlistModeButton;
    private Animation rotateAnimation;
    private Set<String> selectedPlaylists;
    private CompoundButton selectedRow;
    private List<Song> selectedSongs;
    private boolean stopped = false;
    private boolean changed = false;
    private String[] columns = {"title", "artist", "_id", "_data"};
    private String[] columnsPlaylist = {"_id", "name"};
    private String whereClause = "(artist != ?) AND (artist != ?) AND (is_music != ?)";
    private String[] whereValues = {"Sleep as Android", "<unknown>", AppEventsConstants.EVENT_PARAM_VALUE_NO};
    private String whereClauseNotTagged = "(artist = ? OR (is_music = ?))";
    private String[] whereValuesNotTagged = {"<unknown>", AppEventsConstants.EVENT_PARAM_VALUE_NO};
    private int inOrderPlayedSongIndex = 0;
    private ViewGroup selectedSongParent = null;
    private MediaPlayer player = null;
    private ISpotifyPlayer spotifyPlayer = null;
    private final AtomicReference<View> lastSelectedView = new AtomicReference<>(null);

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.MediaListAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements PlaybackListener {
        final /* synthetic */ ProgressBar val$progress;

        public AnonymousClass2(ProgressBar progressBar) {
            this.val$progress = progressBar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fail$1(View view) {
            MediaListAdapter.this.playPreview();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$playbackStarted$0(View view) {
            MediaListAdapter.this.stopPlayer();
        }

        @Override // com.urbandroid.sleep.media.player.PlaybackListener
        public void fail(int i) {
            ProgressBar progressBar = this.val$progress;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            MediaListAdapter.this.playButton.setImageResource(R.drawable.ic_action_play);
            MediaListAdapter.this.playButton.setOnClickListener(new MediaListActivity$$ExternalSyntheticLambda0(this, 2));
            Toast.makeText(MediaListAdapter.this.activity, R.string.general_unspecified_error, 0).show();
        }

        @Override // com.urbandroid.sleep.media.player.PlaybackListener
        public void playbackStarted() {
            MediaListAdapter.this.playButton.setImageResource(R.drawable.ic_action_stop);
            MediaListAdapter.this.playButton.setOnClickListener(new MediaListActivity$$ExternalSyntheticLambda0(this, 1));
            ProgressBar progressBar = this.val$progress;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06d9  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x07ea  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x07f7 A[LOOP:5: B:216:0x07f4->B:218:0x07f7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaListAdapter(MediaListActivity mediaListActivity, boolean z, boolean z2, boolean z3, Song song, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Set<String> set, List<Song> list, int i, String str) {
        MatrixCursor matrixCursor;
        MatrixCursor matrixCursor2;
        Object obj;
        boolean z10;
        MatrixCursor matrixCursor3;
        Settings settings;
        String str2;
        boolean z11;
        boolean z12;
        String str3;
        int i2;
        int i3;
        String str4;
        MatrixCursor matrixCursor4;
        Iterator<InternalRingtones.InternalRingtone> it;
        Settings settings2;
        String str5;
        MatrixCursor matrixCursor5;
        MatrixCursor matrixCursor6;
        String string;
        String resourceName;
        String str6;
        this.multiple = false;
        this.nextSongInOrder = 0L;
        this.isPerAlarmRingtone = false;
        this.selectedSongs = list;
        this.selectedPlaylists = set == null ? new HashSet<>() : set;
        this.multiple = z;
        Logger.logInfo("MediaListAdapter: onCreate song multi:" + z + " current " + song + " selected " + list.size());
        this.activity = mediaListActivity;
        this.expandedMask = (str == null || str.isEmpty()) ? i : MediaListCursorBuilder.allExpandedFlag();
        this.rotateAnimation = AnimationUtils.loadAnimation(mediaListActivity, R.anim.rotate_forever);
        this.isPerAlarmRingtone = z2;
        int i4 = z ? 5 : 25;
        Settings settings3 = new Settings(mediaListActivity.getApplicationContext());
        MediaListCursorBuilder mediaListCursorBuilder = new MediaListCursorBuilder(mediaListActivity.getResources(), song, z, i, str);
        if (song != null && (str6 = song.uri) != null) {
            Uri uri = Uri.parse(str6);
            if (MultipleMediaUriUtil.isMultipleUri(uri)) {
                for (String str7 : MultipleMediaUriUtil.decodeUris(uri)) {
                    if (!z || !str7.equals("android.resource://com.urbandroid.sleep/raw/default")) {
                        addUniqueSong(settings3, str7, song.title);
                    }
                }
            } else if (!z || !song.uri.equals("android.resource://com.urbandroid.sleep/raw/default")) {
                addUniqueSong(settings3, song.uri, song.title);
            }
            this.nextSongInOrder = SharedApplicationContext.getSettings().getPlaylistPosition();
        }
        if (set != null && !set.isEmpty() && z) {
            Iterator<String> it2 = set.iterator();
            while (it2.hasNext()) {
                addUniqueSelectedSong(new Song(it2.next()));
            }
        }
        String[] strArr = COLUMNS;
        MatrixCursor matrixCursor7 = new MatrixCursor(strArr, 1);
        matrixCursor7.newRow().add(666666666665L).add(mediaListActivity.getString(z ? R.string.alert_playlist : R.string.google_music)).add(mediaListActivity.getString(z ? R.string.alert_playlist : R.string.google_music)).add("SEPARATOR");
        MatrixCursor matrixCursor8 = new MatrixCursor(strArr, 1);
        matrixCursor8.newRow().add(666666666660L).add(mediaListActivity.getString(R.string.alert)).add(mediaListActivity.getString(R.string.alert)).add("SEPARATOR");
        MatrixCursor matrixCursor9 = new MatrixCursor(strArr, 1);
        matrixCursor9.newRow().add(666666666668L).add(mediaListActivity.getString(R.string.online_radio)).add(mediaListActivity.getString(R.string.online_radio)).add("SEPARATOR_WITH_PLUS");
        MatrixCursor matrixCursor10 = new MatrixCursor(strArr, 1);
        matrixCursor10.newRow().add(666666666661L).add(mediaListActivity.getString(R.string.music)).add(mediaListActivity.getString(R.string.music)).add("SEPARATOR");
        MatrixCursor matrixCursor11 = new MatrixCursor(strArr, 1);
        matrixCursor11.newRow().add(666666666663L).add(mediaListActivity.getString(R.string.music_not_tagged)).add(mediaListActivity.getString(R.string.music_not_tagged)).add("SEPARATOR");
        MatrixCursor matrixCursor12 = new MatrixCursor(strArr, 1);
        MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor12.newRow();
        StringBuilder sb = new StringBuilder();
        sb.append(mediaListActivity.getString(R.string.ringtone_nature_ALL));
        if (TrialFilter.getInstance().isTrial()) {
            sb.append(" (");
            sb.append(mediaListActivity.getString(R.string.full_version_more));
            sb.append(")");
        }
        rowBuilderNewRow.add(666666666662L).add(sb.toString()).add(sb.toString()).add("SEPARATOR");
        if (z6 && TrialFilter.getInstance().isSpotify()) {
            MatrixCursor matrixCursor13 = new MatrixCursor(strArr, 1);
            matrixCursor13.newRow().add(666666666659L).add(mediaListActivity.getString(R.string.spotify)).add(mediaListActivity.getString(R.string.spotify)).add("SEPARATOR_WITH_REFRESH");
            matrixCursor = matrixCursor13;
        } else {
            matrixCursor = null;
        }
        String str8 = "";
        long j = 9999999999900L;
        if (z) {
            matrixCursor2 = matrixCursor;
            obj = "SEPARATOR";
        } else {
            MatrixCursor matrixCursor14 = new MatrixCursor(strArr, 1);
            if (z2) {
                MatrixCursor.RowBuilder rowBuilderNewRow2 = matrixCursor14.newRow();
                if (settings3.getDefaultRingtoneUri() == null) {
                    resourceName = "ic_sound_alarm_defaults";
                    obj = "SEPARATOR";
                } else {
                    obj = "SEPARATOR";
                    resourceName = ResourceUtil.getResourceName(mediaListActivity, InternalRingtones.getRingtoneIcon(settings3.getDefaultRingtoneUri().toString()));
                }
                String str9 = resourceName;
                matrixCursor2 = matrixCursor;
                rowBuilderNewRow2.add(9999999999900L).add(mediaListActivity.getString(R.string.settings_category_alarm)).add(settings3.getDefaultRingtoneName("")).add("android.resource://com.urbandroid.sleep/raw/default").add(str9);
                j = 9999999999901L;
            } else {
                matrixCursor2 = matrixCursor;
                obj = "SEPARATOR";
            }
            if (z3) {
                matrixCursor14.newRow().add(Long.valueOf(j)).add(mediaListActivity.getString(R.string.silent_alarm_summary)).add("").add("silent").add("ic_sound_silent");
                j++;
            }
            if (z2 || z3) {
                mediaListCursorBuilder.add(matrixCursor14);
            }
        }
        MatrixCursor matrixCursor15 = new MatrixCursor(strArr);
        if (z) {
            try {
                ContentResolver contentResolver = mediaListActivity.getContentResolver();
                Uri uri2 = MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI;
                String[] strArr2 = this.columnsPlaylist;
                Cursor cursorQuery = contentResolver.query(uri2, strArr2, null, null, strArr2[1]);
                if (cursorQuery != null) {
                    int i5 = 0;
                    z10 = false;
                    while (true) {
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        MatrixCursor.RowBuilder rowBuilderNewRow3 = matrixCursor15.newRow();
                        int i6 = cursorQuery.getInt(0);
                        rowBuilderNewRow3.add(Integer.valueOf(i6)).add(cursorQuery.getString(1)).add("").add("THIS_IS_A_PLAYLIST-" + i6);
                        int i7 = i5 + 1;
                        if (i7 > 25) {
                            z10 = true;
                            break;
                        } else {
                            i5 = i7;
                            z10 = true;
                        }
                    }
                    cursorQuery.close();
                } else {
                    z10 = false;
                }
                if (z10) {
                    mediaListCursorBuilder.add(matrixCursor15);
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        if (!z4) {
            if (z7) {
                List<InternalRingtones.InternalRingtone> listInternalRingtones = MedialistKt.internalRingtones();
                MatrixCursor matrixCursor16 = new MatrixCursor(COLUMNS, listInternalRingtones.size());
                Iterator<InternalRingtones.InternalRingtone> it3 = listInternalRingtones.iterator();
                while (it3.hasNext()) {
                    InternalRingtones.InternalRingtone next = it3.next();
                    if (!TrialFilter.getInstance().isTrial() || next.isTrial()) {
                        it = it3;
                        MatrixCursor.RowBuilder rowBuilderNewRow4 = matrixCursor16.newRow();
                        j++;
                        settings2 = settings3;
                        MatrixCursor.RowBuilder rowBuilderAdd = rowBuilderNewRow4.add(Long.valueOf(j));
                        str5 = str8;
                        StringBuilder sb2 = new StringBuilder();
                        matrixCursor5 = matrixCursor15;
                        sb2.append(mediaListActivity.getString(next.titleRes));
                        if (next.hasOrder()) {
                            StringBuilder sb3 = new StringBuilder(" ");
                            matrixCursor6 = matrixCursor8;
                            sb3.append(next.order);
                            string = sb3.toString();
                        } else {
                            matrixCursor6 = matrixCursor8;
                            string = str5;
                        }
                        sb2.append(string);
                        MatrixCursor.RowBuilder rowBuilderAdd2 = rowBuilderAdd.add(sb2.toString());
                        int i8 = next.categoryRes;
                        rowBuilderAdd2.add((i8 == -1 || i8 == R.string.ringtone_nature_ALL) ? null : mediaListActivity.getString(i8)).add(next.uri);
                        int i9 = next.drawableRes;
                        if (i9 != -1) {
                            rowBuilderNewRow4.add(ResourceUtil.getResourceName(mediaListActivity, i9));
                        }
                    } else {
                        it = it3;
                        matrixCursor5 = matrixCursor15;
                        matrixCursor6 = matrixCursor8;
                        settings2 = settings3;
                        str5 = str8;
                    }
                    it3 = it;
                    matrixCursor15 = matrixCursor5;
                    str8 = str5;
                    settings3 = settings2;
                    matrixCursor8 = matrixCursor6;
                }
                matrixCursor3 = matrixCursor15;
                matrixCursor4 = matrixCursor8;
                settings = settings3;
                str2 = str8;
                mediaListCursorBuilder.add(matrixCursor12);
                mediaListCursorBuilder.addCollapsible(matrixCursor16, i4, 2);
            } else {
                matrixCursor3 = matrixCursor15;
                matrixCursor4 = matrixCursor8;
                settings = settings3;
                str2 = "";
            }
            if (z8) {
                ArrayList arrayList = new ArrayList();
                InternalRingtones.InternalRingtone internalRingtone = InternalRingtones.DEVICE_DEFAULT_RINGTONE;
                MatrixCursor matrixCursor17 = new MatrixCursor(this.columns, 1);
                MatrixCursor.RowBuilder rowBuilderNewRow5 = matrixCursor17.newRow();
                j++;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(mediaListActivity.getString(internalRingtone.titleRes));
                sb4.append(internalRingtone.hasOrder() ? " " + internalRingtone.order : str2);
                rowBuilderNewRow5.add(sb4.toString()).add("  ").add(Long.valueOf(j)).add(internalRingtone.uri);
                arrayList.add(matrixCursor17);
                try {
                    arrayList.add(mediaListActivity.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, this.columns, "(is_alarm != ? OR is_ringtone != ?) AND (artist != ?)", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, AppEventsConstants.EVENT_PARAM_VALUE_NO, "Urbandroid"}, "title"));
                } catch (Exception e2) {
                    Logger.logSevere(e2);
                }
                try {
                    arrayList.add(mediaListActivity.getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, this.columns, "(is_alarm != ?) AND (artist != ?)", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "Urbandroid"}, "title"));
                } catch (Exception e3) {
                    Logger.logSevere(e3);
                }
                mediaListCursorBuilder.add(matrixCursor4);
                z11 = false;
                mediaListCursorBuilder.addCollapsible(new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0])), i4, 4);
            }
            if (z) {
                MatrixCursor matrixCursor18 = matrixCursor3;
                z12 = true;
                boolean z13 = loadGoogleMusicPlaylists(matrixCursor18, z11) || loadGoogleMusicPlaylists(matrixCursor18, true);
                if (z6 && z13) {
                    mediaListCursorBuilder.add(matrixCursor7);
                    mediaListCursorBuilder.addCollapsible(matrixCursor18, 1, 1);
                }
            } else {
                z12 = true;
            }
            if (z5) {
                List<OnlineRadioRingtones.Radio> radios = new OnlineRadioRingtones().getRadios(z12);
                MatrixCursor matrixCursor19 = new MatrixCursor(COLUMNS, radios.size());
                for (OnlineRadioRingtones.Radio radio : radios) {
                    j++;
                    MatrixCursor.RowBuilder rowBuilderAdd3 = matrixCursor19.newRow().add(Long.valueOf(j)).add(radio.title);
                    String str10 = radio.genre;
                    rowBuilderAdd3.add((str10 == null || str10.isEmpty()) ? "  " : radio.genre).add(radio.url).add("ic_lullaby_radio");
                }
                mediaListCursorBuilder.add(matrixCursor9);
                mediaListCursorBuilder.addCollapsible(matrixCursor19, i4, 16);
            }
            if (z6 || !TrialFilter.getInstance().isSpotify()) {
                str3 = str2;
            } else {
                MatrixCursor matrixCursor20 = new MatrixCursor(COLUMNS, 1);
                long j2 = j + 1;
                str3 = str2;
                matrixCursor20.newRow().add(Long.valueOf(j2)).add(mediaListActivity.getString(R.string.spotify_current_playlist)).add(str3).add("spotify-play-last-song");
                if (settings.isSpotify()) {
                    for (SpotifyServiceExecutor.SpotifyUri spotifyUri : settings.getSpotifyAlbums()) {
                        j2++;
                        matrixCursor20.newRow().add(Long.valueOf(j2)).add(spotifyUri.getTitle()).add(Joiner.on(", ").join(spotifyUri.getArtists())).add(spotifyUri.getUri()).add(spotifyUri.getImg());
                    }
                } else {
                    matrixCursor20.newRow().add(Long.valueOf(j + 2)).add(mediaListActivity.getString(R.string.connect) + " " + mediaListActivity.getString(R.string.spotify)).add(mediaListActivity.getString(R.string.spotify_current_connect_desc)).add("connect-spotify");
                }
                mediaListCursorBuilder.add(matrixCursor2);
                mediaListCursorBuilder.addCollapsible(matrixCursor20, i4, 8);
            }
            if (z4 && z9) {
                ArrayList arrayList2 = new ArrayList();
                mediaListCursorBuilder.add(matrixCursor10);
                try {
                    ContentResolver contentResolver2 = mediaListActivity.getContentResolver();
                    Uri uri3 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    Cursor cursorQuery2 = contentResolver2.query(uri3, this.columns, this.whereClause, this.whereValues, "artist");
                    if (cursorQuery2 != null) {
                        str4 = "media_volume";
                        try {
                            arrayList2.add(new AdditionalColumnCursorWrapper(cursorQuery2, str4, uri3.toString()));
                        } catch (Exception e4) {
                            e = e4;
                            Logger.logSevere(e);
                        }
                    } else {
                        str4 = "media_volume";
                    }
                } catch (Exception e5) {
                    e = e5;
                    str4 = "media_volume";
                }
                try {
                    ContentResolver contentResolver3 = mediaListActivity.getContentResolver();
                    Uri uri4 = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
                    Cursor cursorQuery3 = contentResolver3.query(uri4, this.columns, this.whereClause, this.whereValues, "artist");
                    if (cursorQuery3 != null) {
                        arrayList2.add(new AdditionalColumnCursorWrapper(cursorQuery3, str4, uri4.toString()));
                    }
                } catch (Exception e6) {
                    Logger.logSevere(e6);
                }
                mediaListCursorBuilder.addCollapsible(arrayList2, i4, 32);
                ArrayList arrayList3 = new ArrayList();
                mediaListCursorBuilder.add(matrixCursor11);
                try {
                    Cursor cursorQuery4 = mediaListActivity.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, this.columns, this.whereClauseNotTagged, this.whereValuesNotTagged, "title");
                    if (cursorQuery4 != null) {
                        arrayList3.add(new AdditionalColumnCursorWrapper(cursorQuery4, str4, MediaStore.Audio.Media.INTERNAL_CONTENT_URI.toString()));
                    }
                } catch (Exception e7) {
                    Logger.logSevere(e7);
                }
                try {
                    ContentResolver contentResolver4 = mediaListActivity.getContentResolver();
                    Uri uri5 = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
                    Cursor cursorQuery5 = contentResolver4.query(uri5, this.columns, this.whereClauseNotTagged, this.whereValuesNotTagged, "title");
                    if (cursorQuery5 != null) {
                        arrayList3.add(new AdditionalColumnCursorWrapper(cursorQuery5, str4, uri5.toString()));
                    }
                } catch (Exception e8) {
                    Logger.logSevere(e8);
                }
                Logger.logInfo("YOUR_NOT_TAG: " + arrayList2.size());
                i2 = 0;
                mediaListCursorBuilder.addCollapsible(arrayList3, 0, 64);
            } else {
                i2 = 0;
            }
            MatrixCursor matrixCursor21 = new MatrixCursor(COLUMNS, 1);
            for (i3 = i2; i3 < 7; i3++) {
                matrixCursor21.newRow().add(Long.valueOf(999999999991L + ((long) i3))).add(str3).add(str3).add(obj);
            }
            mediaListCursorBuilder.add(matrixCursor21);
            this.cursor = mediaListCursorBuilder.toCursor();
        }
        matrixCursor3 = matrixCursor15;
        settings = settings3;
        str2 = "";
        z11 = false;
        if (z) {
        }
        if (z5) {
        }
        if (z6) {
            str3 = str2;
        }
        if (z4) {
            i2 = 0;
        }
        MatrixCursor matrixCursor212 = new MatrixCursor(COLUMNS, 1);
        while (i3 < 7) {
        }
        mediaListCursorBuilder.add(matrixCursor212);
        this.cursor = mediaListCursorBuilder.toCursor();
    }

    private void addUniqueSong(Settings settings, String str, String str2) {
        if (!ISpotifyPlayer.INSTANCE.isSpotifyUri(str) || (!"spotify-play-last-song".equals(str) && settings.isSpotify())) {
            addUniqueSelectedSong(new Song(str, str2));
        } else {
            addUniqueSelectedSong(new Song(str, this.activity.getResources().getString(R.string.spotify_current_playlist)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0124, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0126, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0141, code lost:
    
        if (r4 != null) goto L50;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0113 -> B:70:0x0144). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<Song> fetchSongsFromPlaylist(long j) throws Throwable {
        Exception exc;
        SecurityException securityException;
        Throwable th;
        Cursor cursorQuery;
        LinkedList linkedList = new LinkedList();
        Cursor cursorQuery2 = this.activity.getContentResolver().query(MediaStore.Audio.Playlists.Members.getContentUri("external", j), this.columns, "is_music != 0 ", null, null);
        if (cursorQuery2 != null) {
            while (cursorQuery2.moveToNext()) {
                linkedList.add(Song.fromCursor(this.activity, cursorQuery2, -1));
            }
            cursorQuery2.close();
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    cursorQuery = this.activity.getContentResolver().query(Uri.parse("content://com.google.android.music.MusicContent/playlists/" + j + "/members"), new String[]{"audio_id", "title", "SourceId"}, null, null, null);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SecurityException e) {
                securityException = e;
            } catch (Exception e2) {
                exc = e2;
            }
        } catch (Exception e3) {
            Logger.logSevere(e3);
        }
        if (cursorQuery == null) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                    return linkedList;
                } catch (Exception e4) {
                    Logger.logSevere(e4);
                    return linkedList;
                }
            }
            return linkedList;
        }
        int i = 0;
        while (cursorQuery.moveToNext()) {
            try {
                long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("audio_id"));
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("SourceId"));
                Song song = new Song();
                song.id = j2;
                song.title = string;
                String dataColumn = MediaListActivity.getDataColumn(this.activity, Uri.parse("content://media/external/audio/media/" + string2), null, null);
                if (dataColumn != null && dataColumn.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                    dataColumn = Song.parseFileSystemUri(dataColumn);
                }
                if (i < 10) {
                    Logger.logDebug("song id: " + j2 + " source id: " + string2 + " resolved to path: " + dataColumn + " song title: " + string);
                }
                if (dataColumn != null) {
                    song.setUri(dataColumn);
                    linkedList.add(song);
                }
                i++;
                if (i > 200) {
                    break;
                }
            } catch (SecurityException e5) {
                securityException = e5;
                cursor = cursorQuery;
                if (securityException.getMessage().contains("Permission Denial")) {
                    Logger.logSevere(securityException.toString());
                } else {
                    Logger.logSevere(securityException);
                }
            } catch (Exception e6) {
                exc = e6;
                cursor = cursorQuery;
                Logger.logSevere(exc);
            } catch (Throwable th3) {
                th = th3;
                cursor = cursorQuery;
                if (cursor == null) {
                    throw th;
                }
                try {
                    cursor.close();
                    throw th;
                } catch (Exception e7) {
                    Logger.logSevere(e7);
                    throw th;
                }
            }
        }
        cursorQuery.close();
        return linkedList;
        return linkedList;
    }

    private Song getNextInOrderPlayedSong(List<Song> list) {
        if (this.inOrderPlayedSongIndex >= list.size() - 1) {
            this.inOrderPlayedSongIndex = 0;
        } else {
            this.inOrderPlayedSongIndex++;
        }
        return list.get(this.inOrderPlayedSongIndex);
    }

    private void initPlaylistModeButton(ImageButton imageButton) {
        if (SharedApplicationContext.getSettings().isAlarmPlaylistShuffle()) {
            imageButton.setImageResource(R.drawable.ic_playlist_shuffle);
        } else if (SharedApplicationContext.getSettings().isAlarmPlaylistOrdered()) {
            imageButton.setImageResource(R.drawable.ic_playlist_inorder);
        } else {
            imageButton.setImageResource(R.drawable.ic_playlist_loop1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getView$0(View view) {
        this.activity.lambda$onCreateDialog$5();
        view.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getView$1(View view) {
        if (!SharedApplicationContext.getSettings().isSpotify()) {
            SimpleSettingsActivity.startHighlight(this.activity, ServicesSettingsActivity.class, "spotify");
        } else {
            view.startAnimation(this.rotateAnimation);
            MediaListActivity.loadSpotifyAlbums(this.activity, new WorkerKt$$ExternalSyntheticLambda0(this, view, 18));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPreview$10(final ProgressBar progressBar, MediaPlayer mediaPlayer) {
        Logger.logInfo("MediaList: Player start");
        this.player.start();
        this.playButton.setImageResource(R.drawable.ic_action_stop);
        this.playButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, 4));
        if (this.h == null) {
            this.h = new Handler();
        }
        this.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.MediaListAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                ProgressBar progressBar2 = progressBar;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                }
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPreview$11(View view) {
        playPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPreview$12(ProgressBar progressBar, MediaPlayer mediaPlayer) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this.playButton.setImageResource(R.drawable.ic_action_play);
        this.playButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPreview$13(View view) {
        stopPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPreview$6(View view) {
        stopPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPreview$7(View view) {
        playPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$playPreview$8(ProgressBar progressBar, MediaPlayer mediaPlayer, int i, int i2) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this.playButton.setImageResource(R.drawable.ic_action_play);
        this.playButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, 3));
        StringBuilder sb = new StringBuilder("MediaList: Media player ERROR ");
        sb.append(i);
        sb.append(" ");
        zza$$ExternalSyntheticOutline0.m(sb, i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPreview$9(View view) {
        stopPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopPlayer$14(View view) {
        playPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopPlayer$15(MediaPlayer mediaPlayer) {
        try {
            if (this.player != null) {
                Logger.logInfo("MediaList: Player release after prepare");
                this.player.release();
                this.player = null;
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toggleCheck$5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSelectedSong$2(View view) {
        playPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSelectedSong$3(View view) {
        rotatePlaylistMode(this.playlistModeButton);
        this.activity.lambda$onCreateDialog$5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSelectedSong$4(ViewGroup viewGroup, View view, View view2) {
        clear();
        ((TextView) viewGroup.findViewById(android.R.id.title)).setText(this.activity.getString(R.string.alert_playlist) + " (0)");
        view.setVisibility(8);
        view.setOnClickListener(null);
    }

    private boolean loadGoogleMusicPlaylists(MatrixCursor matrixCursor, boolean z) {
        Exception exc;
        boolean z2 = false;
        try {
            Cursor cursorQuery = this.activity.getContentResolver().query(Uri.parse("content://com.google.android.music.MusicContent/playlists"), z ? new String[]{"_id", "name", "isAllLocal", "hasAny"} : new String[]{"_id", "playlist_name", "isAllLocal", "hasAny"}, null, null, this.columnsPlaylist[1]);
            if (cursorQuery != null) {
                boolean z3 = false;
                int i = 0;
                while (true) {
                    try {
                        if (!cursorQuery.moveToNext()) {
                            z2 = z3;
                            break;
                        }
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex("hasAny")) == 1) {
                            int i2 = cursorQuery.getInt(0);
                            String string = cursorQuery.getString(1);
                            MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
                            Logger.logInfo("Google Music Playlist: " + string + " " + i2);
                            MatrixCursor.RowBuilder rowBuilderAdd = rowBuilderNewRow.add(Integer.valueOf(i2)).add(string).add("   ");
                            StringBuilder sb = new StringBuilder();
                            sb.append("googlemusic://playlist/");
                            sb.append(string);
                            rowBuilderAdd.add(sb.toString());
                            i++;
                            if (i > 25) {
                                z2 = true;
                                break;
                            }
                            z3 = true;
                        }
                    } catch (Exception e) {
                        exc = e;
                        z2 = z3;
                        Logger.logWarning("Using old names: " + z + " ... Error: " + exc.getMessage());
                        return z2;
                    }
                }
                cursorQuery.close();
            }
            return z2;
        } catch (Exception e2) {
            exc = e2;
        }
    }

    private void rotatePlaylistMode(ImageButton imageButton) {
        Settings settings = SharedApplicationContext.getSettings();
        if (settings.isAlarmPlaylistShuffle()) {
            settings.setAlarmPlaylistOrdered();
            imageButton.setImageResource(R.drawable.ic_playlist_inorder);
        } else if (settings.isAlarmPlaylistOrdered()) {
            settings.setAlarmPlaylistLooping();
            imageButton.setImageResource(R.drawable.ic_playlist_loop1);
        } else {
            settings.setAlarmPlaylistShuffle();
            imageButton.setImageResource(R.drawable.ic_playlist_shuffle);
        }
    }

    private void updateSelectedSong(List<Song> list) {
        Logger.logInfo("update selected song " + list);
        ViewGroup viewGroup = this.selectedSongParent;
        if (viewGroup == null || list == null) {
            return;
        }
        Logger.logInfo("update selected song " + list.size());
        if (list.size() > 0) {
            int i = 0;
            Song song = list.get(0);
            Logger.logInfo("update selected first song " + song);
            ((ImageView) viewGroup.findViewById(android.R.id.icon)).setImageDrawable(Song.getSongTypeDrawable(this.activity, song));
            String str = song.title;
            if (str == null || str.trim().length() == 0) {
                ((TextView) viewGroup.findViewById(android.R.id.title)).setText(R.string.button_preview);
            } else {
                ((TextView) viewGroup.findViewById(android.R.id.title)).setText(song.title);
            }
            if ("android.resource://com.urbandroid.sleep/raw/default".equals(song.uri)) {
                ((TextView) viewGroup.findViewById(android.R.id.title)).setText(this.activity.getString(R.string.settings_category_alarm));
            }
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.volume_icon);
            ImageButton imageButton = (ImageButton) viewGroup.findViewById(R.id.play);
            this.playButton = imageButton;
            imageButton.setImageResource(R.drawable.ic_action_play);
            ((ImageButton) viewGroup.findViewById(R.id.play)).setImageResource(R.drawable.ic_action_play);
            this.playButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, i));
            if ("silent".equals(song.uri) && list.size() == 1) {
                this.playButton.setVisibility(4);
                imageView.setImageResource(R.drawable.ic_volume_off);
            } else {
                imageView.setImageResource(R.drawable.ic_volume_high);
                this.playButton.setVisibility(0);
            }
            View viewFindViewById = viewGroup.findViewById(R.id.playlist_del);
            this.playlistModeButton = (ImageButton) viewGroup.findViewById(R.id.playlist_mode);
            if (this.multiple || list.size() > 1) {
                ((TextView) viewGroup.findViewById(android.R.id.title)).setText(this.activity.getString(R.string.alert_playlist) + " (" + list.size() + ")");
                ((ImageView) viewGroup.findViewById(android.R.id.icon)).setImageResource(R.drawable.ic_sound_playlist);
                this.playlistModeButton.setVisibility(0);
                initPlaylistModeButton(this.playlistModeButton);
                this.playlistModeButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, 5));
            } else {
                this.playlistModeButton.setVisibility(8);
            }
            if (list.size() > 1) {
                viewFindViewById.setVisibility(0);
                viewFindViewById.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda3(this, viewGroup, viewFindViewById, i));
            } else {
                viewFindViewById.setVisibility(8);
                viewFindViewById.setOnClickListener(null);
            }
            viewGroup.findViewById(android.R.id.summary).setVisibility(8);
        }
    }

    public void addUniqueSelectedSong(Song song) {
        if (!this.selectedSongs.contains(song)) {
            this.selectedSongs.add(song);
        }
        if (song.isPlaylist()) {
            this.selectedPlaylists.add(song.uri);
        }
        if (this.selectedSongs.size() > 1) {
            Song song2 = new Song("silent");
            if (this.selectedSongs.contains(song2)) {
                this.selectedSongs.remove(song2);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    public void clear() {
        Logger.logInfo("MediaList: CLEAR ");
        this.selectedSongs.clear();
        Set<String> set = this.selectedPlaylists;
        if (set != null) {
            set.clear();
        }
        this.selectedRow = null;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (this.stopped || (cursor = this.cursor) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (this.stopped || (cursor = this.cursor) == null) {
            return new Song();
        }
        cursor.moveToPosition(i);
        return Song.fromCursor(this.activity, this.cursor, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return ((Song) getItem(i)).id;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Song song = (Song) getItem(i);
        if (song.isSeparator()) {
            return 0;
        }
        return song.isShowHide() ? 2 : 1;
    }

    public AtomicReference<View> getLastSelectedView() {
        return this.lastSelectedView;
    }

    public Set<String> getSelectedPlaylists() {
        return this.selectedPlaylists;
    }

    public List<Song> getSelectedSongs() {
        return this.selectedSongs;
    }

    public Song.Type getSelectedSongsType() {
        List<Song> list = this.selectedSongs;
        return (list == null || list.size() == 0) ? Song.Type.NATURE : this.selectedSongs.size() > 1 ? Song.Type.PLAYLIST : Song.getSongType(this.selectedSongs.get(0));
    }

    public int getSeparatorPosition(int i) {
        while (i != 0) {
            if (((Song) getItem(i)).isSeparator()) {
                return i;
            }
            i--;
        }
        return 0;
    }

    public String getSongName() {
        if (this.selectedSongs.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (this.selectedSongs.size() > 1 || (this.selectedSongs.size() == 1 && this.selectedSongs.get(0).title == null)) {
            sb.append(this.activity.getString(R.string.alert_playlist_size, Integer.valueOf(this.selectedSongs.size() - this.selectedPlaylists.size())));
        } else {
            Song song = this.selectedSongs.get(0);
            String str = song.title;
            if (str != null) {
                sb.append(str);
            } else {
                boolean zStartsWith = song.uri.startsWith("googlemusic://playlist/");
                String str2 = song.uri;
                if (zStartsWith) {
                    sb.append(str2.substring(23));
                } else {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }

    public Uri getSongUri() {
        ArrayList arrayList = new ArrayList(getSelectedSongs());
        if (arrayList.size() == 0) {
            return null;
        }
        if (arrayList.size() > 1) {
            arrayList.remove(new Song());
        }
        int i = 0;
        if (arrayList.size() == 1) {
            Song song = (Song) arrayList.get(0);
            String str = song.uri;
            if (str == null || !song.isPlayable()) {
                return null;
            }
            return Uri.parse(str);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((Song) it.next()).isPlaylist()) {
                it.remove();
            }
        }
        String[] strArr = new String[Math.min(arrayList.size(), 200)];
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            strArr[i] = ((Song) it2.next()).uri;
            i++;
            if (i >= 200) {
                break;
            }
        }
        return MultipleMediaUriUtil.parse(strArr);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        String str;
        View viewInflate2;
        Song song = (Song) getItem(i);
        if (view == null) {
            if (song.isSeparator()) {
                viewInflate2 = View.inflate(this.activity, R.layout.category_media, null);
            } else if (song.isShowHide()) {
                viewInflate2 = View.inflate(this.activity, R.layout.row_media_list_show_hide_item, null);
            } else {
                boolean z = this.multiple;
                MediaListActivity mediaListActivity = this.activity;
                viewInflate2 = z ? View.inflate(mediaListActivity, R.layout.row_media_list_item, null) : View.inflate(mediaListActivity, R.layout.row_media_list_item_single, null);
            }
            viewInflate = viewInflate2;
        } else {
            viewInflate = view;
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.song_img);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.song_img_bg);
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.circle_bg_accent);
        }
        String str2 = "";
        if (imageView != null) {
            imageView.setVisibility(0);
            if (!ISpotifyPlayer.INSTANCE.isSpotifyUri(song.uri)) {
                String str3 = song.imgUri;
                if (str3 != null) {
                    try {
                        imageView.setImageResource(ResourceUtil.getResourceByName(this.activity, "drawable", str3));
                    } catch (Exception e) {
                        Logger.logSevere(e);
                    }
                } else {
                    imageView.setImageResource(R.drawable.ic_sound_tone);
                }
            } else if (song.uri.endsWith("spotify-play-last-song") || (str = song.imgUri) == null || str.isEmpty()) {
                imageView.setImageResource(R.drawable.ic_lullaby_spotify_color);
            } else {
                try {
                    Picasso.with(this.activity.getApplicationContext()).load(song.imgUri).transform(new RoundCornersTransform(ActivityUtils.getDip(this.activity, 48))).resize(48, 48).into(imageView);
                } catch (Exception e2) {
                    Logger.logWarning(e2.toString());
                    imageView.setImageResource(R.drawable.empty_ab);
                }
            }
            if (imageView2 != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
                MediaListActivity mediaListActivity2 = this.activity;
                StringBuilder sb = new StringBuilder("t");
                sb.append(i % 7);
                sb.append(i % 2 == 0 ? "a" : "");
                gradientDrawable.setColor(ColorUtil.i(mediaListActivity2, ResourceUtil.getResourceByName(mediaListActivity2, "color", sb.toString())));
                imageView2.setImageDrawable(gradientDrawable);
            }
        }
        if (song.isSeparator()) {
            View viewFindViewById = viewInflate.findViewById(R.id.separator);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(i == 0 ? 8 : 0);
            }
            if (viewInflate.findViewById(android.R.id.title) != null) {
                TextView textView = (TextView) viewInflate.findViewById(android.R.id.title);
                if (textView == null) {
                    viewInflate = View.inflate(this.activity, R.layout.category_media, null);
                    textView = (TextView) viewInflate.findViewById(android.R.id.title);
                }
                ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.refreshButton);
                if (imageView3 != null) {
                    imageView3.setVisibility((song.hasPlus() || song.hasRefresh()) ? 0 : 8);
                    boolean zHasRefresh = song.hasRefresh();
                    int i2 = R.drawable.ic_add;
                    if (zHasRefresh) {
                        if (SharedApplicationContext.getSettings().isSpotify()) {
                            i2 = R.drawable.ic_refresh;
                        }
                        imageView3.setImageResource(i2);
                        imageView3.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, 7));
                    } else if (song.hasPlus()) {
                        imageView3.setImageResource(R.drawable.ic_add);
                        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.media.MediaListAdapter.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                boolean zHasConnectivity = ContextExtKt.hasConnectivity(MediaListAdapter.this.activity);
                                MediaListAdapter mediaListAdapter = MediaListAdapter.this;
                                if (zHasConnectivity) {
                                    mediaListAdapter.activity.showDialog(1);
                                    return;
                                }
                                Toast toastMakeText = Toast.makeText(mediaListAdapter.activity, R.string.no_connection, 0);
                                toastMakeText.setGravity(17, 0, 0);
                                toastMakeText.show();
                            }
                        });
                    }
                }
                textView.setText(song.title);
            }
        } else if (song.isShowHide()) {
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.show_hide_text);
            if (textView2 != null) {
                textView2.setText(song.title);
            }
            ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.show_hide_icon);
            if (imageView4 != null) {
                imageView4.setImageResource(song.isHide() ? R.drawable.arrow_up_trans : R.drawable.arrow_down_trans);
            }
        } else {
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.song_title);
            if (textView3 == null) {
                viewInflate = View.inflate(this.activity, R.layout.row_media_list_item, null);
                textView3 = (TextView) viewInflate.findViewById(R.id.song_title);
            }
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.song_artist);
            String str4 = song.artist;
            if (str4 != null && !"<unknown>".equals(str4)) {
                str2 = song.artist;
            }
            textView4.setText(str2);
            CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(R.id.song_check);
            if (this.selectedSongs.contains(song)) {
                compoundButton.setChecked(true);
                if (!this.multiple && this.selectedRow == null) {
                    this.selectedRow = compoundButton;
                }
            } else {
                compoundButton.setChecked(false);
                ((ProgressBar) viewInflate.findViewById(R.id.progress)).setVisibility(8);
            }
            if (textView4.getText() == null || textView4.getText().toString().trim().isEmpty()) {
                textView4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
            }
            if (this.selectedSongs.contains(song) && this.selectedSongs.size() > 1 && SharedApplicationContext.getSettings().isAlarmPlaylistOrdered()) {
                textView3.setText("(" + (this.selectedSongs.indexOf(song) + 1) + ") " + song.title);
            } else {
                textView3.setText(song.title);
            }
        }
        return viewInflate;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public boolean isChanged() {
        return this.changed;
    }

    public boolean isChecked(View view) {
        View viewFindViewById = view.findViewById(R.id.song_check);
        if (viewFindViewById != null) {
            return ((CompoundButton) viewFindViewById).isChecked();
        }
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItemViewType(i) != 0;
    }

    public void playPreview(View view, Song song) {
        Uri defaultPhoneRingtone;
        Logger.logInfo("Play preview " + song);
        if (this.stopped) {
            Logger.logInfo("Play preview stopped ");
            return;
        }
        if (view != null) {
            this.lastSelectedView.set(view);
        }
        try {
            stopPlayer();
            String string = song.uri;
            if (string != null && !string.equals("silent")) {
                if (string.equals("android.resource://com.urbandroid.sleep/raw/default")) {
                    Uri uriRandomUriIfMultiple = MultipleMediaUriUtil.randomUriIfMultiple(SharedApplicationContext.getSettings().getDefaultRingtoneUri());
                    if (uriRandomUriIfMultiple != null && !"spotify-play-last-song".equals(uriRandomUriIfMultiple.toString())) {
                        string = uriRandomUriIfMultiple.toString();
                    }
                    Logger.logWarning("MediaList: not playable uri");
                    return;
                }
                final ProgressBar progressBar = view != null ? (ProgressBar) view.findViewById(R.id.progress) : null;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                if (string.equals("android.resource://com.urbandroid.sleep/raw/phone") && (defaultPhoneRingtone = SharedApplicationContext.getSettings().getDefaultPhoneRingtone()) != null) {
                    string = defaultPhoneRingtone.toString();
                }
                Logger.logInfo("MediaList: Playing " + Uri.encode(string));
                ISpotifyPlayer.Companion companion = ISpotifyPlayer.INSTANCE;
                if (companion.isSpotifyUri(song.uri)) {
                    ISpotifyPlayer mode = companion.getSpotifyPlayer(this.activity.getApplicationContext(), new AnonymousClass2(progressBar)).setMode(ISpotifyPlayer.PlayerMode.LULLABY);
                    this.spotifyPlayer = mode;
                    mode.play(song.uri);
                    ImageButton imageButton = this.playButton;
                    if (imageButton != null) {
                        imageButton.setImageResource(R.drawable.ic_action_stop);
                        this.playButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, 8));
                        return;
                    }
                    return;
                }
                this.player = new MediaPlayer();
                if (string == null || !(string.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR) || string.startsWith("android") || string.startsWith(ShareInternalUtility.STAGING_PARAM) || string.startsWith("content"))) {
                    this.player.setDataSource(string);
                } else {
                    this.player.setDataSource(this.activity, Uri.parse(string));
                }
                int i = 1;
                this.player.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).setLegacyStreamType(this.activity.getStream()).setContentType(2).build());
                this.player.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.urbandroid.sleep.media.MediaListAdapter$$ExternalSyntheticLambda8
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        return this.f$0.lambda$playPreview$8(progressBar, mediaPlayer, i2, i3);
                    }
                });
                this.player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.urbandroid.sleep.media.MediaListAdapter$$ExternalSyntheticLambda9
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer) {
                        this.f$0.lambda$playPreview$10(progressBar, mediaPlayer);
                    }
                });
                this.player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.urbandroid.sleep.media.MediaListAdapter$$ExternalSyntheticLambda10
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        this.f$0.lambda$playPreview$12(progressBar, mediaPlayer);
                    }
                });
                Logger.logInfo("MediaList: Player prepareAsync");
                this.player.prepareAsync();
                ImageButton imageButton2 = this.playButton;
                if (imageButton2 != null) {
                    imageButton2.setImageResource(R.drawable.ic_action_stop);
                    this.playButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, i));
                }
            }
        } catch (Throwable th) {
            Logger.logSevere(th);
        }
    }

    public void setChanged(boolean z) {
        this.changed = z;
    }

    public void setSelectedSongParent(ViewGroup viewGroup) {
        this.selectedSongParent = viewGroup;
    }

    public void stop() {
        stopPlayer();
        this.stopped = true;
        this.cursor.close();
    }

    public void stopPlayer() {
        Logger.logInfo("MediaList: Player stop");
        ISpotifyPlayer iSpotifyPlayer = this.spotifyPlayer;
        if (iSpotifyPlayer != null) {
            iSpotifyPlayer.stop();
            this.spotifyPlayer = null;
        }
        ImageButton imageButton = this.playButton;
        if (imageButton != null) {
            imageButton.setImageResource(R.drawable.ic_action_play);
            this.playButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda1(this, 6));
        }
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null) {
                mediaPlayer.setOnPreparedListener(new MediaListAdapter$$ExternalSyntheticLambda5(this, 0));
                this.player.stop();
                this.player.release();
                Logger.logInfo("MediaList: Player release");
                this.player = null;
            }
        } catch (IllegalStateException e) {
            Logger.logSevere(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void toggleCheck(View view, Song song, boolean z, boolean z2, int i) throws Throwable {
        Logger.logInfo("MediaListAdapter: Song toggle, multi:" + z2 + " selected row " + this.selectedRow);
        if ("connect-spotify".equals(song.uri)) {
            Logger.logInfo("MediaListAdapter: Connect Spotify");
            SimpleSettingsActivity.startHighlight(this.activity, ServicesSettingsActivity.class, "spotify");
            return;
        }
        if (song.isShowHide()) {
            Song song2 = this.selectedSongs.isEmpty() ? null : this.selectedSongs.get(0);
            int iIndexOf = song.uri.indexOf(124);
            String strSubstring = song.uri;
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            int i2 = Integer.parseInt(strSubstring);
            int i3 = Integer.parseInt(iIndexOf == -1 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : song.uri.substring(iIndexOf + 1));
            boolean zIsShow = song.isShow();
            int i4 = this.expandedMask;
            this.activity.reload(song2 == null ? null : song2.uri, song2 != null ? song2.title : null, this.changed, zIsShow ? i4 | i2 : (~i2) & i4, i3, i, song.id, this.selectedSongs);
            return;
        }
        CompoundButton compoundButton = (CompoundButton) view.findViewById(R.id.song_check);
        if (!z2 && !this.changed) {
            this.selectedSongs.clear();
            this.selectedRow = null;
            this.activity.uri = null;
        }
        if (compoundButton == null) {
            return;
        }
        if (compoundButton.isChecked() && z2) {
            compoundButton.setChecked(false);
            compoundButton.invalidate();
            if (song.isPlaylist()) {
                List<Song> listFetchSongsFromPlaylist = fetchSongsFromPlaylist(song.id);
                this.selectedPlaylists.remove(song.uri);
                Iterator<Song> it = listFetchSongsFromPlaylist.iterator();
                while (it.hasNext()) {
                    this.selectedSongs.remove(it.next());
                }
            }
            this.selectedSongs.remove(song);
        } else {
            if (!z2) {
                CompoundButton compoundButton2 = this.selectedRow;
                if (compoundButton2 != null) {
                    compoundButton2.setChecked(false);
                    this.selectedRow.invalidate();
                }
                this.selectedSongs.clear();
                this.selectedRow = compoundButton;
            }
            compoundButton.setChecked(true);
            stopPlayer();
            addUniqueSelectedSong(song);
            if (song.isPlaylist()) {
                for (Song song3 : fetchSongsFromPlaylist(song.id)) {
                    if (obj == null) {
                        Logger.logInfo("Playlist: previewSong " + song3.title + " " + song3.uri);
                        obj = song3;
                    }
                    addUniqueSelectedSong(song3);
                }
            } else if ("android.resource://com.urbandroid.sleep/raw/phone".equals(song.uri)) {
                DefaultRingtoneResolveService.storeActualDefaultRingtoneUri(this.activity.getApplicationContext(), new Events$$ExternalSyntheticBUOutline0(10));
            }
        }
        this.changed = true;
        this.activity.setTitle(MultipleMediaUriUtil.size(getSongUri()), z2);
        updateSelectedSong(this.selectedSongs);
        notifyDataSetChanged();
    }

    public void playPreview() {
        List<Song> selectedSongs = getSelectedSongs();
        if (this.lastSelectedView == null || selectedSongs == null || getSelectedSongs().size() <= 0) {
            return;
        }
        View view = this.lastSelectedView.get();
        Logger.logDebug("Play clicked, songs size: " + selectedSongs.size() + " ordered " + SharedApplicationContext.getSettings().isAlarmPlaylistOrdered() + " shuffle " + SharedApplicationContext.getSettings().isAlarmPlaylistShuffle());
        if (selectedSongs.size() > 1) {
            if (SharedApplicationContext.getSettings().isAlarmPlaylistOrdered()) {
                playPreview(view, getNextInOrderPlayedSong(selectedSongs));
                return;
            }
            if (SharedApplicationContext.getSettings().isAlarmPlaylistShuffle()) {
                int iNextInt = ThreadLocalRandom.current().nextInt(selectedSongs.size());
                Logger.logDebug("Shuffle next int: " + iNextInt);
                playPreview(view, selectedSongs.get(iNextInt));
                return;
            }
            playPreview(view, selectedSongs.get(0));
            return;
        }
        playPreview(view, selectedSongs.get(0));
    }

    public void updateSelectedSong() {
        updateSelectedSong(this.selectedSongs);
    }
}
