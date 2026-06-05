package com.urbandroid.sleep.media;

import com.urbandroid.sleep.R;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class InternalRingtones {
    public static InternalRingtone DEVICE_DEFAULT_RINGTONE;
    private static List<InternalRingtone> ringtoneList = new ArrayList();

    static {
        InternalRingtone internalRingtone = new InternalRingtone(R.string.device_default, R.drawable.ic_lullaby_whitenoise, "android.resource://com.urbandroid.sleep/raw/phone", true, R.string.empty);
        DEVICE_DEFAULT_RINGTONE = internalRingtone;
        ringtoneList.add(internalRingtone);
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_BIRDS, R.drawable.ic_sound_bird, "android.resource://com.urbandroid.sleep/raw/sp_stream_7_r1_midpitch", true));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_CUCKCOO, R.drawable.ic_sound_cockoo, "android.resource://com.urbandroid.sleep/raw/sp_stream_6_r1_l3_midpitch", true));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_COCK, R.drawable.ic_sound_cock, "android.resource://com.urbandroid.sleep/raw/cock", true));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_BIRDS, R.drawable.ic_sound_bird_trans, "android.resource://com.urbandroid.sleep/raw/sp_stream_3_r1_midpitch", 2));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_BIRDS, R.drawable.ic_sound_bird_trans, "android.resource://com.urbandroid.sleep/raw/sp_stream_2_r1_midpitch", 3));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_SEA, R.drawable.ic_sound_seagull, "android.resource://com.urbandroid.sleep/raw/sea", true));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_SEA, R.drawable.ic_sound_seagull_flip, "android.resource://com.urbandroid.sleep/raw/sp_sea_2_r2_priority", 2));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_WAVES, R.drawable.ic_lullaby_sea, "android.resource://com.urbandroid.sleep/raw/sp_sea_1_loop_priority"));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_CRICKETS, R.drawable.ic_sound_cricket, "android.resource://com.urbandroid.sleep/raw/sp_stream_8_r1_l2", true));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_STORM, R.drawable.ic_lullaby_storm, "android.resource://com.urbandroid.sleep/raw/sp_storm_6_pitch", true));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_WHALE, R.drawable.ic_lullaby_whale, "android.resource://com.urbandroid.sleep/raw/sp_whale_2_r2_pitch_priority"));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_nature_STREAM, R.drawable.ic_lullaby_stream, "android.resource://com.urbandroid.sleep/raw/sp_stream_1_loop_priority"));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_sleepyheads_RINGER, R.drawable.ic_lullaby_clock, "android.resource://com.urbandroid.sleep/raw/classic", 1, true, R.string.ringtone_sleepyheads_ALL));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_sleepyheads_XYLO, R.drawable.ic_sound_xylo, "android.resource://com.urbandroid.sleep/raw/xylo", 1, true, R.string.ringtone_sleepyheads_ALL));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_sleepyheads_BELLS, R.drawable.ic_lullaby_bells, "android.resource://com.urbandroid.sleep/raw/sp_sea_4_l1", 1, R.string.ringtone_sleepyheads_ALL));
        ringtoneList.add(new InternalRingtone(R.string.ringtone_sleepyheads_HORN, R.drawable.ic_sound_horn, "android.resource://com.urbandroid.sleep/raw/sp_sea_3_r1_l2", 1, R.string.ringtone_sleepyheads_ALL));
        ringtoneList.add(new InternalRingtone(R.string.settings_category_lucid_title, R.drawable.ic_feature_lucid, "android.resource://com.urbandroid.sleep/raw/dreaming", 1, true, -1));
        ringtoneList.add(new InternalRingtone(R.string.tongue_click, R.drawable.ic_sound_tongue, "android.resource://com.urbandroid.sleep/raw/antisnore", 1, true, -1));
        ringtoneList.add(new InternalRingtone(R.string.oximeter_alarm, R.drawable.ic_lullaby_breath, "android.resource://com.urbandroid.sleep/raw/apnea", 1, true, -1));
    }

    public static InternalRingtone getInternalRingtone(String str) {
        if (str == null) {
            return null;
        }
        for (InternalRingtone internalRingtone : ringtoneList) {
            if (internalRingtone.uri.equals(str)) {
                return internalRingtone;
            }
        }
        return null;
    }

    public static int getRingtoneIcon(String str) {
        InternalRingtone internalRingtone = getInternalRingtone(str);
        return internalRingtone != null ? internalRingtone.getDrawableRes() : (str == null || !(str.startsWith("http://") || str.startsWith("https://"))) ? (str == null || !ISpotifyPlayer.INSTANCE.isSpotifyUri(str)) ? R.drawable.ic_sound_tone_color : R.drawable.ic_lullaby_spotify_color : R.drawable.ic_lullaby_radio;
    }

    public static List<InternalRingtone> getRingtoneList() {
        return ringtoneList;
    }

    public static int getTitleRes(String str) {
        InternalRingtone internalRingtone = getInternalRingtone(str);
        if (internalRingtone != null) {
            return internalRingtone.titleRes;
        }
        return -1;
    }

    public static class InternalRingtone {
        int categoryRes;
        int drawableRes;
        int order;
        int titleRes;
        boolean trial;
        String uri;

        public InternalRingtone(int i, int i2, String str) {
            this.categoryRes = R.string.ringtone_nature_ALL;
            this.order = 1;
            this.trial = false;
            this.titleRes = i;
            this.uri = str;
            this.drawableRes = i2;
        }

        public int getDrawableRes() {
            return this.drawableRes;
        }

        public int getTitleRes() {
            return this.titleRes;
        }

        public String getUri() {
            return this.uri;
        }

        public boolean hasOrder() {
            return this.order > 1;
        }

        public boolean isTrial() {
            return this.trial;
        }

        public InternalRingtone(int i, int i2, String str, boolean z) {
            this.categoryRes = R.string.ringtone_nature_ALL;
            this.order = 1;
            this.titleRes = i;
            this.uri = str;
            this.trial = z;
            this.drawableRes = i2;
        }

        public InternalRingtone(int i, int i2, String str, boolean z, int i3) {
            this.order = 1;
            this.titleRes = i;
            this.uri = str;
            this.trial = z;
            this.categoryRes = i3;
            this.drawableRes = i2;
        }

        public InternalRingtone(int i, int i2, String str, int i3, int i4) {
            this.trial = false;
            this.titleRes = i;
            this.uri = str;
            this.order = i3;
            this.categoryRes = i4;
            this.drawableRes = i2;
        }

        public InternalRingtone(int i, int i2, String str, int i3, boolean z, int i4) {
            this.titleRes = i;
            this.uri = str;
            this.order = i3;
            this.categoryRes = i4;
            this.trial = z;
            this.drawableRes = i2;
        }

        public InternalRingtone(int i, int i2, String str, int i3) {
            this.categoryRes = R.string.ringtone_nature_ALL;
            this.trial = false;
            this.titleRes = i;
            this.uri = str;
            this.order = i3;
            this.drawableRes = i2;
        }
    }
}
