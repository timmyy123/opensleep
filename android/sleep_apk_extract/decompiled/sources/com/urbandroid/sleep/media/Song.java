package com.urbandroid.sleep.media;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.media.InternalRingtones;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import java.io.File;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes.dex */
public class Song implements Parcelable {
    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() { // from class: com.urbandroid.sleep.media.Song.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Song createFromParcel(Parcel parcel) {
            Song song = new Song();
            song.title = parcel.readString();
            song.artist = parcel.readString();
            song.id = parcel.readLong();
            song.uri = parcel.readString();
            return song;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Song[] newArray(int i) {
            return new Song[i];
        }
    };
    String artist;
    long id;
    String imgUri;
    String title;
    String uri;

    public enum Type {
        NATURE,
        DEVICE,
        RADIO,
        SPOTIFY,
        PLAYLIST
    }

    public Song(String str, String str2, String str3) {
        this.uri = str;
        this.imgUri = str3;
        this.title = str2;
    }

    public static Song fromCursor(Context context, Cursor cursor, int i) {
        boolean z;
        String contentUri;
        Song song = new Song();
        boolean z2 = true;
        try {
            song.title = cursor.getString(cursor.getColumnIndex("title"));
            z = false;
        } catch (Exception e) {
            Logger.logSevere(e);
            song.title = "...";
            z = true;
        }
        try {
            song.artist = cursor.getString(cursor.getColumnIndex("artist"));
        } catch (Exception e2) {
            Logger.logSevere(e2);
            song.artist = "...";
            z = true;
        }
        try {
            song.id = cursor.getLong(cursor.getColumnIndex("_id"));
        } catch (Exception e3) {
            Logger.logSevere(e3);
            song.id = i;
            z = true;
        }
        try {
            contentUri = parseContentUri(cursor.getString(cursor.getColumnIndex("media_volume")), song.id);
        } catch (Exception unused) {
            contentUri = null;
        }
        try {
            song.setUri(parseUltimateUri(context.getContentResolver(), contentUri, cursor.getString(cursor.getColumnIndex("_data"))));
            z2 = z;
        } catch (Exception e4) {
            Logger.logSevere(e4);
            if (contentUri != null) {
                song.setUri(contentUri);
            } else {
                song.setUri("android.resource://com.urbandroid.sleep/raw/fallbackring");
            }
        }
        int columnIndex = cursor.getColumnIndex("songImage");
        if (columnIndex != -1) {
            try {
                song.imgUri = cursor.getString(columnIndex);
            } catch (Exception e5) {
                Logger.logSevere("Song: ", e5);
            }
        }
        if (z2) {
            Logger.logSevere("Issue with song " + song);
        }
        return song;
    }

    public static Type getSongType(String str) {
        return InternalRingtones.getInternalRingtone(str) != null ? Type.NATURE : MultipleMediaUriUtil.isMultipleUri(str) ? Type.PLAYLIST : (str.startsWith("http://") || str.startsWith("https://")) ? Type.RADIO : ISpotifyPlayer.INSTANCE.isSpotifyUri(str) ? Type.SPOTIFY : Type.DEVICE;
    }

    public static Drawable getSongTypeDrawable(Context context, String str) {
        if ("silent".equals(str)) {
            return ContextCompat.getDrawable(context, R.drawable.ic_sound_silent);
        }
        int iOrdinal = getSongType(str).ordinal();
        if (iOrdinal != 0) {
            return iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? ContextCompat.getDrawable(context, R.drawable.ic_sound_tone_color) : ContextCompat.getDrawable(context, R.drawable.ic_sound_playlist) : ContextCompat.getDrawable(context, R.drawable.ic_lullaby_spotify_color) : ContextCompat.getDrawable(context, R.drawable.ic_lullaby_radio);
        }
        InternalRingtones.InternalRingtone internalRingtone = InternalRingtones.getInternalRingtone(str);
        return ContextCompat.getDrawable(context, internalRingtone.getDrawableRes() != -1 ? internalRingtone.getDrawableRes() : R.drawable.ic_sound_all);
    }

    public static String parseContentUri(String str, long j) {
        if (str == null) {
            return null;
        }
        return ContentUris.withAppendedId(Uri.parse(str), j).toString();
    }

    public static String parseFileSystemUri(String str) {
        if (str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            try {
                File file = new File(str);
                if (file.canRead()) {
                    return Uri.fromFile(file).toString();
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return str;
    }

    public static String parseUltimateUri(ContentResolver contentResolver, String str, String str2) {
        String fileSystemUri = parseFileSystemUri(str2);
        if (fileSystemUri == null || !fileSystemUri.startsWith("content://")) {
            return fileSystemUri;
        }
        try {
            contentResolver.openInputStream(Uri.parse(fileSystemUri)).close();
            return fileSystemUri;
        } catch (Exception e) {
            Logger.logSevere(e);
            return str == null ? fileSystemUri : str;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Song)) {
            return false;
        }
        Song song = (Song) obj;
        String str = this.uri;
        if (str == null && song.uri != null) {
            return false;
        }
        if (str != null && song.uri == null) {
            return false;
        }
        if (str == null && song.uri == null) {
            return true;
        }
        return str.equals(song.uri);
    }

    public boolean hasPlus() {
        return "SEPARATOR_WITH_PLUS".equals(this.uri);
    }

    public boolean hasRefresh() {
        return "SEPARATOR_WITH_REFRESH".equals(this.uri);
    }

    public int hashCode() {
        String str = this.uri;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isHide() {
        return this.id == -2;
    }

    public boolean isPlayable() {
        return (isPlaylist() || isSeparator()) ? false : true;
    }

    public boolean isPlaylist() {
        String str = this.uri;
        return str != null && str.startsWith("THIS_IS_A_PLAYLIST");
    }

    public boolean isSeparator() {
        return "SEPARATOR".equals(this.uri) || "SEPARATOR_WITH_REFRESH".equals(this.uri) || "SEPARATOR_WITH_PLUS".equals(this.uri);
    }

    public boolean isShow() {
        return this.id == -3;
    }

    public boolean isShowHide() {
        long j = this.id;
        return j == -3 || j == -2;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Song:");
        sb.append(this.title);
        sb.append(" - ");
        String str = this.artist;
        if (str != null) {
            sb.append(str);
            sb.append(" - ");
        } else {
            sb.append("??? ");
        }
        String str2 = this.uri;
        if (str2 != null) {
            sb.append(str2);
        }
        sb.append(" IMG: ");
        sb.append(this.imgUri);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.artist);
        parcel.writeLong(this.id);
        parcel.writeString(this.uri);
    }

    public Song(String str) {
        this.uri = str;
    }

    public Song(String str, String str2) {
        this(str, str2, null);
    }

    public Song() {
    }

    public static Type getSongType(Song song) {
        return getSongType(song.uri);
    }

    public static Drawable getSongTypeDrawable(Context context, Song song) {
        return getSongTypeDrawable(context, song.uri);
    }
}
