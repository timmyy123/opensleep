package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqh {
    public static final zzqh zza;
    static final zzgwp zzb;
    private static final zzgwm zzc;
    private static final zzgwm zzd;
    private static final zzgwm zze;
    private final SparseArray zzf = new SparseArray();
    private final int zzg;
    private final zzgwm zzh;
    private final zzgwm zzi;

    static {
        zzgwm zzgwmVarZzj = zzgwm.zzj(12);
        zzc = zzgwmVarZzj;
        zzgwm zzgwmVarZzi = zzgwm.zzi();
        zzd = zzgwmVarZzi;
        zza = new zzqh(zzgwm.zzj(zzqg.zza), zzgwmVarZzj, zzgwmVarZzi);
        zze = zzgwm.zzl(2, 5, 6);
        zzgwo zzgwoVar = new zzgwo();
        zzgwoVar.zza(5, 6);
        zzgwoVar.zza(17, 6);
        zzgwoVar.zza(7, 6);
        zzgwoVar.zza(30, 10);
        zzgwoVar.zza(18, 6);
        zzgwoVar.zza(6, 8);
        zzgwoVar.zza(8, 8);
        zzgwoVar.zza(14, 8);
        zzb = zzgwoVar.zzc();
    }

    private zzqh(List list, List list2, List list3) {
        for (int i = 0; i < list.size(); i++) {
            zzqg zzqgVar = (zzqg) list.get(i);
            this.zzf.put(zzqgVar.zzb, zzqgVar);
        }
        int iMax = 0;
        for (int i2 = 0; i2 < this.zzf.size(); i2++) {
            iMax = Math.max(iMax, ((zzqg) this.zzf.valueAt(i2)).zzc);
        }
        this.zzg = iMax;
        this.zzh = zzgwm.zzq(list2);
        this.zzi = zzgwm.zzq(list3);
    }

    public static zzqh zza(Context context, zzd zzdVar, AudioDeviceInfo audioDeviceInfo, List list) {
        return zzb(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzdVar, audioDeviceInfo, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzqh zzb(Context context, Intent intent, zzd zzdVar, AudioDeviceInfo audioDeviceInfo, List list) {
        AudioManager audioManagerZza = zzcj.zza(context);
        if (audioDeviceInfo == null) {
            if (Build.VERSION.SDK_INT >= 33) {
                List<AudioDeviceInfo> audioDevicesForAttributes = audioManagerZza.getAudioDevicesForAttributes(zzdVar.zza());
                audioDeviceInfo = audioDevicesForAttributes.isEmpty() ? null : audioDevicesForAttributes.get(0);
            }
        }
        zzgwm zzgwmVarZza = audioDeviceInfo != null ? zzub.zza(audioDeviceInfo) : zzc;
        if (Build.VERSION.SDK_INT >= 33 && (zzfl.zzP(context) || zzfl.zzQ(context))) {
            List<AudioProfile> directProfilesForAttributes = audioManagerZza.getDirectProfilesForAttributes(zzdVar.zza());
            HashMap map = new HashMap();
            map.put(2, new HashSet(zzhah.zzg(12)));
            for (int i = 0; i < directProfilesForAttributes.size(); i++) {
                AudioProfile audioProfileM365m = zzbuy$$ExternalSyntheticBUOutline0.m365m((Object) directProfilesForAttributes.get(i));
                if (audioProfileM365m.getEncapsulationType() != 1) {
                    int format = audioProfileM365m.getFormat();
                    if (zzfl.zzD(format) || zzb.containsKey(Integer.valueOf(format))) {
                        Integer numValueOf = Integer.valueOf(format);
                        if (map.containsKey(numValueOf)) {
                            Set set = (Set) map.get(numValueOf);
                            set.getClass();
                            set.addAll(zzhah.zzg(audioProfileM365m.getChannelMasks()));
                        } else {
                            map.put(numValueOf, new HashSet(zzhah.zzg(audioProfileM365m.getChannelMasks())));
                        }
                    }
                }
            }
            int i2 = zzgwm.$r8$clinit;
            zzgwj zzgwjVar = new zzgwj();
            for (Map.Entry entry : map.entrySet()) {
                zzgwjVar.zzf(new zzqg(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
            }
            return new zzqh(zzgwjVar.zzi(), zzgwmVarZza, list);
        }
        AudioDeviceInfo[] devices = audioDeviceInfo == null ? audioManagerZza.getDevices(2) : new AudioDeviceInfo[]{audioDeviceInfo};
        for (AudioDeviceInfo audioDeviceInfo2 : devices) {
            if (zztu.zza(audioDeviceInfo2.getType())) {
                return new zzqh(zzgwm.zzj(zzqg.zza), zzgwmVarZza, list);
            }
        }
        zzgwv zzgwvVar = new zzgwv();
        zzgwvVar.zzf((Object) 2);
        if (Build.VERSION.SDK_INT >= 29 && (zzfl.zzP(context) || zzfl.zzQ(context))) {
            int i3 = zzgwm.$r8$clinit;
            zzgwj zzgwjVar2 = new zzgwj();
            zzgza zzgzaVarZza = zzb.keySet().zza();
            while (zzgzaVarZza.hasNext()) {
                Integer num = (Integer) zzgzaVarZza.next();
                int iIntValue = num.intValue();
                if (Build.VERSION.SDK_INT >= zzfl.zzF(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), zzdVar.zza())) {
                    zzgwjVar2.zzf(num);
                }
            }
            zzgwjVar2.zzf((Object) 2);
            zzgwvVar.zzg(zzgwjVar2.zzi());
            return new zzqh(zzh(zzhah.zzf(zzgwvVar.zzh()), 10), zzgwmVarZza, list);
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z || zzg()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            zzgwvVar.zzg(zze);
        }
        if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new zzqh(zzh(zzhah.zzf(zzgwvVar.zzh()), 10), zzgwmVarZza, list);
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            zzgwvVar.zzg(zzhah.zzg(intArrayExtra));
        }
        return new zzqh(zzh(zzhah.zzf(zzgwvVar.zzh()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)), zzgwmVarZza, list);
    }

    public static Uri zzc() {
        if (zzg()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    private static boolean zzg() {
        String str = Build.MANUFACTURER;
        return str.equals("Amazon") || str.equals("Xiaomi");
    }

    private static zzgwm zzh(int[] iArr, int i) {
        int i2 = zzgwm.$r8$clinit;
        zzgwj zzgwjVar = new zzgwj();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i3 : iArr) {
            zzgwjVar.zzf(new zzqg(i3, i));
        }
        return zzgwjVar.zzi();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzqh)) {
            return false;
        }
        zzqh zzqhVar = (zzqh) obj;
        SparseArray sparseArray = this.zzf;
        SparseArray<?> sparseArray2 = zzqhVar.zzf;
        String str = zzfl.zza;
        if (Build.VERSION.SDK_INT < 31) {
            int size = sparseArray.size();
            if (size == sparseArray2.size()) {
                for (int i = 0; i < size; i++) {
                    if (!Objects.equals(sparseArray.valueAt(i), sparseArray2.get(sparseArray.keyAt(i)))) {
                        break;
                    }
                }
                if (this.zzg != zzqhVar.zzg) {
                }
            }
        } else if (sparseArray.contentEquals(sparseArray2)) {
            if (this.zzg != zzqhVar.zzg && Objects.equals(this.zzh, zzqhVar.zzh) && Objects.equals(this.zzi, zzqhVar.zzi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iContentHashCode;
        String str = zzfl.zza;
        int i = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.zzf;
        if (i >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iHashCode = 17;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                iHashCode = Objects.hashCode(sparseArray.valueAt(i2)) + ((sparseArray.keyAt(i2) + (iHashCode * 31)) * 31);
            }
            iContentHashCode = iHashCode;
        }
        return Objects.hashCode(this.zzi) + ((Objects.hashCode(this.zzh) + zzba$$ExternalSyntheticOutline0.m(this.zzg, 31, iContentHashCode, 31)) * 31);
    }

    public final String toString() {
        zzgwm zzgwmVar = this.zzi;
        zzgwm zzgwmVar2 = this.zzh;
        String string = this.zzf.toString();
        String strValueOf = String.valueOf(zzgwmVar2);
        String strValueOf2 = String.valueOf(zzgwmVar);
        int i = this.zzg;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(i).length(), 50, string.length(), 28, strValueOf.length(), 26, strValueOf2.length()) + 1);
        zzba$$ExternalSyntheticOutline0.m(sb, "AudioCapabilities[maxChannelCount=", i, ", audioProfiles=", string);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", speakerLayoutChannelMasks=", strValueOf, ", spatializerChannelMasks=", strValueOf2);
        sb.append("]");
        return sb.toString();
    }

    public final zzgwm zzd() {
        return this.zzh;
    }

    public final zzgwm zze() {
        return this.zzi;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[PHI: r1
      0x003a: PHI (r1v3 int) = (r1v2 int), (r1v7 int) binds: [B:11:0x002c, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair zzf(zzv zzvVar, zzd zzdVar) {
        String str = zzvVar.zzp;
        str.getClass();
        int iZzg = zzas.zzg(str, zzvVar.zzk);
        if (!zzb.containsKey(Integer.valueOf(iZzg))) {
            return null;
        }
        int i = 8;
        if (iZzg != 18) {
            if (iZzg == 8) {
                if (zzfl.zza(this.zzf, 8)) {
                    iZzg = 8;
                    if (iZzg == 30) {
                    }
                }
                iZzg = 7;
            } else if (iZzg == 30 && !zzfl.zza(this.zzf, 30)) {
                iZzg = 7;
            }
        } else if (zzfl.zza(this.zzf, 18)) {
            iZzg = 18;
            if (iZzg == 8) {
            }
        } else {
            iZzg = 6;
        }
        SparseArray sparseArray = this.zzf;
        if (!zzfl.zza(sparseArray, iZzg)) {
            return null;
        }
        zzqg zzqgVar = (zzqg) sparseArray.get(iZzg);
        zzqgVar.getClass();
        int iZzb = zzvVar.zzH;
        if (iZzb == -1 || iZzg == 18) {
            int i2 = zzvVar.zzI;
            if (i2 == -1) {
                i2 = 48000;
            }
            iZzb = zzqgVar.zzb(i2, zzdVar);
        } else if (!str.equals("audio/vnd.dts.uhd;profile=p2") || Build.VERSION.SDK_INT >= 33) {
            if (!zzqgVar.zza(iZzb)) {
                return null;
            }
        } else if (iZzb > 10) {
            return null;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 28) {
            i = iZzb;
        } else if (iZzb != 7) {
            if (iZzb == 3 || iZzb == 4 || iZzb == 5) {
                i = 6;
            }
        }
        if (i3 <= 26 && "fugu".equals(Build.DEVICE) && i == 1) {
            i = 2;
        }
        int iZzE = zzfl.zzE(i);
        if (iZzE != 0) {
            return Pair.create(Integer.valueOf(iZzg), Integer.valueOf(iZzE));
        }
        return null;
    }
}
