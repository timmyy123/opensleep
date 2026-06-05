package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzelh implements zzeli {
    public static /* synthetic */ zzeln zzl(String str, String str2, String str3, zzelj zzeljVar, String str4, WebView webView, String str5, String str6, zzelk zzelkVar) {
        zzfuy zzfuyVarZza = zzfuy.zza("Google", str2);
        zzfux zzfuxVarZzn = zzn("javascript");
        zzfup zzfupVarZzp = zzp(zzeljVar.toString());
        zzfux zzfuxVar = zzfux.NONE;
        if (zzfuxVarZzn == zzfuxVar) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfupVarZzp == null) {
            String strValueOf = String.valueOf(zzeljVar);
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid html session error; Unable to parse creative type: ".concat(strValueOf));
            return null;
        }
        zzfux zzfuxVarZzn2 = zzn(str4);
        if (zzfupVarZzp != zzfup.VIDEO || zzfuxVarZzn2 != zzfuxVar) {
            zzfum zzfumVarZza = zzfum.zza(zzfuyVarZza, webView, str5, "");
            return new zzeln(zzfuk.zze(zzful.zza(zzfupVarZzp, zzo(zzelkVar.toString()), zzfuxVarZzn, zzfuxVarZzn2, true), zzfumVarZza), zzfumVarZza);
        }
        String strValueOf2 = String.valueOf(str4);
        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid html session error; Video events owner unknown for video creative: ".concat(strValueOf2));
        return null;
    }

    public static /* synthetic */ zzeln zzm(String str, String str2, String str3, String str4, zzelj zzeljVar, WebView webView, String str5, String str6, zzelk zzelkVar) {
        zzfuy zzfuyVarZza = zzfuy.zza(str, str2);
        zzfux zzfuxVarZzn = zzn("javascript");
        zzfux zzfuxVarZzn2 = zzn(str4);
        zzfup zzfupVarZzp = zzp(zzeljVar.toString());
        zzfux zzfuxVar = zzfux.NONE;
        if (zzfuxVarZzn == zzfuxVar) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfupVarZzp == null) {
            String strValueOf = String.valueOf(zzeljVar);
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid js session error; Unable to parse creative type: ".concat(strValueOf));
            return null;
        }
        if (zzfupVarZzp != zzfup.VIDEO || zzfuxVarZzn2 != zzfuxVar) {
            zzfum zzfumVarZzb = zzfum.zzb(zzfuyVarZza, webView, str5, "");
            return new zzeln(zzfuk.zze(zzful.zza(zzfupVarZzp, zzo(zzelkVar.toString()), zzfuxVarZzn, zzfuxVarZzn2, true), zzfumVarZzb), zzfumVarZzb);
        }
        String strValueOf2 = String.valueOf(str4);
        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid js session error; Video events owner unknown for video creative: ".concat(strValueOf2));
        return null;
    }

    private static zzfux zzn(String str) {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str) ? zzfux.NATIVE : "javascript".equals(str) ? zzfux.JAVASCRIPT : zzfux.NONE;
    }

    private static zzfus zzo(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode != -1104128070) {
            if (iHashCode != 1318088141) {
                if (iHashCode == 1988248512 && str.equals("onePixel")) {
                    return zzfus.ONE_PIXEL;
                }
            } else if (str.equals("definedByJavascript")) {
                return zzfus.DEFINED_BY_JAVASCRIPT;
            }
        } else if (str.equals("beginToRender")) {
            return zzfus.BEGIN_TO_RENDER;
        }
        return zzfus.UNSPECIFIED;
    }

    private static zzfup zzp(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == -382745961) {
            if (str.equals("htmlDisplay")) {
                return zzfup.HTML_DISPLAY;
            }
            return null;
        }
        if (iHashCode == 112202875) {
            if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
                return zzfup.VIDEO;
            }
            return null;
        }
        if (iHashCode == 714893483 && str.equals("nativeDisplay")) {
            return zzfup.NATIVE_DISPLAY;
        }
        return null;
    }

    private static final Object zzq(zzelg zzelgVar) {
        try {
            return zzelgVar.zza();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "omid exception");
            return null;
        }
    }

    private static final void zzr(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "omid exception");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final boolean zza(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue()) {
            Boolean bool = (Boolean) zzq(new zzelg() { // from class: com.google.android.gms.internal.ads.zzelf
                @Override // com.google.android.gms.internal.ads.zzelg
                public final /* synthetic */ Object zza() {
                    if (zzfui.zzb()) {
                        return Boolean.TRUE;
                    }
                    zzfui.zza(context);
                    return Boolean.valueOf(zzfui.zzb());
                }
            });
            return bool != null && bool.booleanValue();
        }
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid flag is disabled");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final String zzb(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue()) {
            return (String) zzq(zzekw.zza);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final zzeln zzc(final String str, final WebView webView, String str2, String str3, final String str4, final zzelk zzelkVar, final zzelj zzeljVar, final String str5) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue() || !zzfui.zzb()) {
            return null;
        }
        final String str6 = "javascript";
        final String str7 = "Google";
        final String str8 = "";
        return (zzeln) zzq(new zzelg(str7, str, str6, zzeljVar, str4, webView, str5, str8, zzelkVar) { // from class: com.google.android.gms.internal.ads.zzekx
            private final /* synthetic */ String zzb;
            private final /* synthetic */ zzelj zzd;
            private final /* synthetic */ String zze;
            private final /* synthetic */ WebView zzf;
            private final /* synthetic */ String zzg;
            private final /* synthetic */ zzelk zzi;
            private final /* synthetic */ String zza = "Google";
            private final /* synthetic */ String zzc = "javascript";
            private final /* synthetic */ String zzh = "";

            {
                this.zzb = str;
                this.zzd = zzeljVar;
                this.zze = str4;
                this.zzf = webView;
                this.zzg = str5;
                this.zzi = zzelkVar;
            }

            @Override // com.google.android.gms.internal.ads.zzelg
            public final /* synthetic */ Object zza() {
                return zzelh.zzl(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final zzeln zzd(final String str, final WebView webView, String str2, String str3, final String str4, final String str5, final zzelk zzelkVar, final zzelj zzeljVar, final String str6) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue() || !zzfui.zzb()) {
            return null;
        }
        final String str7 = "";
        final String str8 = "javascript";
        return (zzeln) zzq(new zzelg(str5, str, str8, str4, zzeljVar, webView, str6, str7, zzelkVar) { // from class: com.google.android.gms.internal.ads.zzeky
            private final /* synthetic */ String zza;
            private final /* synthetic */ String zzb;
            private final /* synthetic */ String zzd;
            private final /* synthetic */ zzelj zze;
            private final /* synthetic */ WebView zzf;
            private final /* synthetic */ String zzg;
            private final /* synthetic */ zzelk zzi;
            private final /* synthetic */ String zzc = "javascript";
            private final /* synthetic */ String zzh = "";

            {
                this.zzd = str4;
                this.zze = zzeljVar;
                this.zzf = webView;
                this.zzg = str6;
                this.zzi = zzelkVar;
            }

            @Override // com.google.android.gms.internal.ads.zzelg
            public final /* synthetic */ Object zza() {
                return zzelh.zzm(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final void zze(final zzfuk zzfukVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue() && zzfui.zzb()) {
            Objects.requireNonNull(zzfukVar);
            zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfukVar.zza();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final void zzf(final zzfuk zzfukVar) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue() && zzfui.zzb()) {
                    zzfukVar.zzc();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final void zzg(final zzfuk zzfukVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzela
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue() && zzfui.zzb()) {
                    zzfukVar.zzd(view, zzfur.NOT_VISIBLE, "Ad overlay");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final void zzh(final zzfuk zzfukVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzelb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue() && zzfui.zzb()) {
                    zzfukVar.zzb(view);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final zzfuw zzi(final VersionInfoParcel versionInfoParcel, final WebView webView, boolean z) {
        final boolean z2 = true;
        return (zzfuw) zzq(new zzelg(webView, z2) { // from class: com.google.android.gms.internal.ads.zzelc
            private final /* synthetic */ WebView zzb;

            @Override // com.google.android.gms.internal.ads.zzelg
            public final /* synthetic */ Object zza() {
                VersionInfoParcel versionInfoParcel2 = this.zza;
                int i = versionInfoParcel2.buddyApkVersion;
                int i2 = versionInfoParcel2.clientJarVersion;
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 1 + String.valueOf(i2).length());
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                return zzfuw.zza(zzfuy.zza("Google", sb.toString()), this.zzb, true);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final void zzj(final zzfuw zzfuwVar, final zzfuv zzfuvVar) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeld
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfuwVar.zzb(zzfuvVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeli
    public final void zzk(final zzfuw zzfuwVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzele
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfuwVar.zzd(view, zzfur.NOT_VISIBLE, "Ad overlay");
            }
        });
    }
}
