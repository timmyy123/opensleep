package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzwf {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final HashMap zzb = new HashMap();

    public static zzvm zza() {
        List listZzb = zzb("audio/raw", false, false);
        if (listZzb.isEmpty()) {
            return null;
        }
        return (zzvm) listZzb.get(0);
    }

    public static synchronized List zzb(String str, boolean z, boolean z2) {
        try {
            zzvw zzvwVar = new zzvw(str, z, z2);
            HashMap map = zzb;
            List list = (List) map.get(zzvwVar);
            if (list != null) {
                return list;
            }
            ArrayList arrayListZzh = zzh(zzvwVar, new zzwa(z, z2, str.equals("video/mv-hevc")));
            if (z) {
                arrayListZzh.isEmpty();
            }
            if ("audio/raw".equals(str)) {
                if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && arrayListZzh.size() == 1 && ((zzvm) arrayListZzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    arrayListZzh.add(zzvm.zza("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
                }
                zzj(arrayListZzh, zzwb.zza);
            }
            if (Build.VERSION.SDK_INT < 32 && arrayListZzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzvm) arrayListZzh.get(0)).zza)) {
                arrayListZzh.add((zzvm) arrayListZzh.remove(0));
            }
            zzgwm zzgwmVarZzq = zzgwm.zzq(arrayListZzh);
            map.put(zzvwVar, zzgwmVarZzq);
            return zzgwmVarZzq;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static List zzc(zzvv zzvvVar, zzv zzvVar, boolean z, boolean z2) {
        List listZza = zzvvVar.zza(zzvVar.zzp, z, z2);
        List listZzd = zzd(zzvvVar, zzvVar, z, z2);
        int i = zzgwm.$r8$clinit;
        zzgwj zzgwjVar = new zzgwj();
        zzgwjVar.zzh(listZza);
        zzgwjVar.zzh(listZzd);
        return zzgwjVar.zzi();
    }

    public static List zzd(zzvv zzvvVar, zzv zzvVar, boolean z, boolean z2) {
        String strZzg = zzg(zzvVar);
        return strZzg == null ? zzgwm.zzi() : zzvvVar.zza(strZzg, z, z2);
    }

    public static List zze(final Context context, List list, final zzv zzvVar) {
        ArrayList arrayList = new ArrayList(list);
        zzj(arrayList, new zzwe() { // from class: com.google.android.gms.internal.ads.zzwd
            @Override // com.google.android.gms.internal.ads.zzwe
            public final /* synthetic */ int zza(Object obj) {
                int i = zzwf.$r8$clinit;
                return ((zzvm) obj).zzd(context, zzvVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    public static MediaCodecInfo.CodecProfileLevel zzf(int i, int i2) {
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i;
        codecProfileLevel.level = i2;
        return codecProfileLevel;
    }

    public static String zzg(zzv zzvVar) {
        zzdp zzdpVarZzf;
        String str = zzvVar.zzp;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str) && (zzdpVarZzf = zzdq.zzf(zzvVar)) != null && zzdpVarZzf.zzc()) {
            int iZza = zzdpVarZzf.zza();
            if (iZza == 16 || iZza == 256) {
                return "video/hevc";
            }
            if (iZza == 512) {
                return "video/avc";
            }
            if (iZza == 1024) {
                zzi zziVar = zzvVar.zzF;
                if (zziVar != null && zziVar.zzd == 6 && zziVar.zzc == 1) {
                    return null;
                }
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str)) {
            return "video/hevc";
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0200 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0130 A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:64:0x00f8, B:71:0x0114, B:77:0x0128, B:79:0x0130, B:87:0x0149, B:89:0x0153, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x013c), top: B:127:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013c A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:64:0x00f8, B:71:0x0114, B:77:0x0128, B:79:0x0130, B:87:0x0149, B:89:0x0153, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x013c), top: B:127:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0153 A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:64:0x00f8, B:71:0x0114, B:77:0x0128, B:79:0x0130, B:87:0x0149, B:89:0x0153, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x013c), top: B:127:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0158 A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:64:0x00f8, B:71:0x0114, B:77:0x0128, B:79:0x0130, B:87:0x0149, B:89:0x0153, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x013c), top: B:127:0x00f8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList zzh(zzvw zzvwVar, zzvy zzvyVar) throws zzvx {
        String str;
        String str2;
        int i;
        int i2;
        String str3;
        String str4;
        String str5;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean zZzd;
        boolean zZze;
        boolean z;
        int i3;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        boolean zIsHardwareAccelerated;
        boolean zIsVendor;
        zzvw zzvwVar2 = zzvwVar;
        zzvy zzvyVar2 = zzvyVar;
        String str6 = "secure-playback";
        String str7 = "tunneled-playback";
        try {
            ArrayList arrayList = new ArrayList();
            String str8 = zzvwVar2.zza;
            int iZza = zzvyVar2.zza();
            boolean zZzc = zzvyVar2.zzc();
            int i4 = 0;
            while (i4 < iZza) {
                MediaCodecInfo mediaCodecInfoZzb = zzvyVar2.zzb(i4);
                if (Build.VERSION.SDK_INT < 29 || !mediaCodecInfoZzb.isAlias()) {
                    int i5 = iZza;
                    String name = mediaCodecInfoZzb.getName();
                    if (mediaCodecInfoZzb.isEncoder() || (!zZzc && name.endsWith(".secure"))) {
                        str = str6;
                        str2 = str7;
                        i = i4;
                        i2 = i5;
                    } else {
                        String[] supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                        int length = supportedTypes.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 < length) {
                                int i7 = i6;
                                str3 = supportedTypes[i7];
                                if (str3.equalsIgnoreCase(str8)) {
                                    break;
                                }
                                i6 = i7 + 1;
                            } else if (str8.equals("video/dolby-vision")) {
                                str3 = "OMX.MS.HEVCDV.Decoder".equals(name) ? "video/hevcdv" : ("OMX.RTK.video.decoder".equals(name) || "OMX.realtek.video.decoder.tunneled".equals(name)) ? "video/dv_hevc" : null;
                            } else if (str8.equals("video/mv-hevc")) {
                                if ("c2.qti.mvhevc.decoder".equals(name) || "c2.qti.mvhevc.decoder.secure".equals(name)) {
                                    str3 = "video/x-mvhevc";
                                }
                            } else if (str8.equals("audio/alac") && "OMX.lge.alac.decoder".equals(name)) {
                                str3 = "audio/x-lg-alac";
                            } else if (str8.equals("audio/flac") && "OMX.lge.flac.decoder".equals(name)) {
                                str3 = "audio/x-lg-flac";
                            } else if (str8.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(name)) {
                                str3 = "audio/lg-ac3";
                            }
                        }
                        if (str3 != null) {
                            try {
                                capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str3);
                                zZzd = zzvyVar2.zzd(str7, str3, capabilitiesForType);
                                zZze = zzvyVar2.zze(str7, str3, capabilitiesForType);
                                str2 = str7;
                            } catch (Exception e) {
                                e = e;
                                str4 = str3;
                            }
                            if (zzvwVar2.zzc) {
                                if (zZzd) {
                                    boolean zZzd2 = zzvyVar2.zzd(str6, str3, capabilitiesForType);
                                    boolean zZze2 = zzvyVar2.zze(str6, str3, capabilitiesForType);
                                    z = zzvwVar2.zzb;
                                    if (!z) {
                                        if (z) {
                                        }
                                        i3 = Build.VERSION.SDK_INT;
                                        str = str6;
                                        if (i3 < 29) {
                                        }
                                        boolean zZzi = zzi(mediaCodecInfoZzb, str8);
                                        boolean z2 = zIsHardwareAccelerated;
                                        if (i3 < 29) {
                                        }
                                        if (zZzc) {
                                            boolean z3 = zIsVendor;
                                            i = i4;
                                            i2 = i5;
                                            MediaCodecInfo.CodecCapabilities codecCapabilities2 = codecCapabilities;
                                            str4 = str3;
                                            str5 = name;
                                            if (zZzc) {
                                                continue;
                                            }
                                        } else {
                                            boolean z32 = zIsVendor;
                                            i = i4;
                                            i2 = i5;
                                            MediaCodecInfo.CodecCapabilities codecCapabilities22 = codecCapabilities;
                                            str4 = str3;
                                            str5 = name;
                                            if (zZzc) {
                                            }
                                        }
                                        StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 24 + str4.length() + 1);
                                        sb.append("Failed to query codec ");
                                        sb.append(str5);
                                        sb.append(" (");
                                        sb.append(str4);
                                        sb.append(")");
                                        zzeg.zze("MediaCodecUtil", sb.toString());
                                        throw e;
                                    }
                                }
                                str = str6;
                            } else {
                                if (!zZze) {
                                    boolean zZzd22 = zzvyVar2.zzd(str6, str3, capabilitiesForType);
                                    boolean zZze22 = zzvyVar2.zze(str6, str3, capabilitiesForType);
                                    z = zzvwVar2.zzb;
                                    if (!z || !zZze22) {
                                        if (z) {
                                            if (zZzd22) {
                                                zZzd22 = true;
                                            }
                                        }
                                        i3 = Build.VERSION.SDK_INT;
                                        str = str6;
                                        if (i3 < 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            codecCapabilities = capabilitiesForType;
                                        } else {
                                            codecCapabilities = capabilitiesForType;
                                            zIsHardwareAccelerated = !zzi(mediaCodecInfoZzb, str8);
                                        }
                                        boolean zZzi2 = zzi(mediaCodecInfoZzb, str8);
                                        boolean z22 = zIsHardwareAccelerated;
                                        if (i3 < 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            String strZza = zzgss.zza(mediaCodecInfoZzb.getName());
                                            zIsVendor = (strZza.startsWith("omx.google.") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) ? false : true;
                                        }
                                        if ((zZzc || z != zZzd22) && (zZzc || z)) {
                                            boolean z322 = zIsVendor;
                                            i = i4;
                                            i2 = i5;
                                            MediaCodecInfo.CodecCapabilities codecCapabilities222 = codecCapabilities;
                                            str4 = str3;
                                            str5 = name;
                                            if (zZzc && zZzd22) {
                                                StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 7);
                                                sb2.append(str5);
                                                sb2.append(".secure");
                                                arrayList.add(zzvm.zza(sb2.toString(), str8, str4, codecCapabilities222, z22, zZzi2, z322, false, true));
                                                return arrayList;
                                            }
                                        } else {
                                            boolean z4 = zIsVendor;
                                            i = i4;
                                            i2 = i5;
                                            str4 = str3;
                                            try {
                                                str5 = name;
                                                try {
                                                    arrayList.add(zzvm.zza(name, str8, str4, codecCapabilities, z22, zZzi2, z4, false, false));
                                                } catch (Exception e2) {
                                                    e = e2;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                str5 = name;
                                                StringBuilder sb3 = new StringBuilder(String.valueOf(str5).length() + 24 + str4.length() + 1);
                                                sb3.append("Failed to query codec ");
                                                sb3.append(str5);
                                                sb3.append(" (");
                                                sb3.append(str4);
                                                sb3.append(")");
                                                zzeg.zze("MediaCodecUtil", sb3.toString());
                                                throw e;
                                            }
                                        }
                                    }
                                }
                                str = str6;
                            }
                        }
                        i = i4;
                        i2 = i5;
                    }
                } else {
                    str = str6;
                    str2 = str7;
                    i2 = iZza;
                    i = i4;
                }
                i4 = i + 1;
                zzvyVar2 = zzvyVar;
                iZza = i2;
                str6 = str;
                str7 = str2;
                zzvwVar2 = zzvwVar;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new zzvx(e4, null);
        }
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzas.zza(str)) {
            return true;
        }
        String strZza = zzgss.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.") || ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google."))) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }

    private static void zzj(List list, final zzwe zzweVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwc
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                int i = zzwf.$r8$clinit;
                zzwe zzweVar2 = zzweVar;
                return zzweVar2.zza(obj2) - zzweVar2.zza(obj);
            }
        });
    }
}
