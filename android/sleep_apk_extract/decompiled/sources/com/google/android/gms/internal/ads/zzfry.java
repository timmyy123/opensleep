package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfry {
    private final zzepd zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfkr zzf;
    private final zzfks zzg;
    private final Clock zzh;
    private final zzbap zzi;

    public zzfry(zzepd zzepdVar, VersionInfoParcel versionInfoParcel, String str, String str2, Context context, zzfkr zzfkrVar, zzfks zzfksVar, Clock clock, zzbap zzbapVar) {
        this.zza = zzepdVar;
        this.zzb = versionInfoParcel.afmaVersion;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfkrVar;
        this.zzg = zzfksVar;
        this.zzh = clock;
        this.zzi = zzbapVar;
    }

    public static String zzd(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzg(String str) {
        return TextUtils.isEmpty(str) ? "" : com.google.android.gms.ads.internal.util.client.zzl.zzj() ? "fakeForAdDebugLog" : str;
    }

    public final List zza(zzfkq zzfkqVar, zzfkf zzfkfVar, List list) {
        return zzb(zzfkqVar, zzfkfVar, false, "", "", list, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, boolean z, String str, String str2, List list, zzdbn zzdbnVar, zzcfe zzcfeVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str3 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            boolean z2 = true;
            String strZzd = zzd(zzd(zzd((String) it.next(), "@gw_adlocid@", zzfkqVar.zza.zza.zzg), "@gw_adnetrefresh@", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES), "@gw_sdkver@", this.zzb);
            if (zzfkfVar != null) {
                String strZzd2 = zzd(zzd(zzd(strZzd, "@gw_qdata@", zzfkfVar.zzy), "@gw_adnetid@", zzfkfVar.zzx), "@gw_allocid@", zzfkfVar.zzw);
                Context context = this.zze;
                strZzd = zzceb.zza(strZzd2, context, zzfkfVar.zzW, zzfkfVar.zzaw);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoZ)).booleanValue() && zzfkfVar.zze == 4) {
                    com.google.android.gms.ads.internal.zzt.zzc();
                    if (true != com.google.android.gms.ads.internal.util.zzs.zzJ(context)) {
                        str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    strZzd = zzd(strZzd, "@gw_aps@", str3);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpk)).booleanValue() && zzcfeVar != null) {
                    int i = zzcfeVar.zza;
                    String strZzd3 = zzd(strZzd, "@gw_is@", i >= 0 ? Integer.toString(i) : "");
                    int i2 = zzcfeVar.zzb;
                    String strZzd4 = zzd(strZzd3, "@gw_fis@", i2 >= 0 ? Integer.toString(i2) : "");
                    int i3 = zzcfeVar.zzc;
                    strZzd = zzd(strZzd4, "@gw_sfis@", i3 >= 0 ? Integer.toString(i3) : "");
                }
            }
            zzepd zzepdVar = this.zza;
            String strZzd5 = zzd(zzd(zzd(zzd(strZzd, "@gw_adnetstatus@", zzepdVar.zzg()), "@gw_ttr@", Long.toString(zzepdVar.zzh(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpi)).booleanValue()) {
                strZzd5 = (zzdbnVar == null || zzdbnVar.zza() <= 0) ? zzd(strZzd5, "@gw_placement_id@", "") : zzd(strZzd5, "@gw_placement_id@", Long.toString(zzdbnVar.zza(), 10));
            }
            boolean z3 = false;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzet)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean zIsEmpty = TextUtils.isEmpty(str2);
            boolean z4 = !zIsEmpty;
            if (z3) {
                z2 = z4;
            } else {
                if (!zIsEmpty) {
                }
                arrayList.add(strZzd5);
            }
            if (this.zzi.zza(Uri.parse(strZzd5))) {
                Uri.Builder builderBuildUpon = Uri.parse(strZzd5).buildUpon();
                if (z3) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("attok", str2);
                }
                strZzd5 = builderBuildUpon.build().toString();
            }
            arrayList.add(strZzd5);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060 A[LOOP:0: B:13:0x005a->B:15:0x0060, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzc(zzfkf zzfkfVar, List list, zzcbp zzcbpVar) {
        zzfkr zzfkrVar;
        zzgth zzgthVarZzd;
        Iterator it;
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = this.zzh.currentTimeMillis();
        try {
            String strZzb = zzcbpVar.zzb();
            String string = Integer.toString(zzcbpVar.zzc());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeu)).booleanValue()) {
                zzfks zzfksVar = this.zzg;
                if (zzfksVar == null) {
                    zzgthVarZzd = zzgth.zzc();
                    String str = (String) zzgthVarZzd.zzb(zzfrx.zza).zza("");
                    String str2 = (String) zzgthVarZzd.zzb(zzfrw.zza).zza("");
                    it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(zzceb.zza(zzd(zzd(zzd(zzd(zzd(zzd((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzb)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfkfVar.zzW, zzfkfVar.zzaw));
                    }
                    return arrayList;
                }
                zzfkrVar = zzfksVar.zza;
            } else {
                zzfkrVar = this.zzf;
            }
            zzgthVarZzd = zzgth.zzd(zzfkrVar);
            String str3 = (String) zzgthVarZzd.zzb(zzfrx.zza).zza("");
            String str22 = (String) zzgthVarZzd.zzb(zzfrw.zza).zza("");
            it = list.iterator();
            while (it.hasNext()) {
            }
            return arrayList;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }
}
