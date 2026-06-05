package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzell {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzfkf zzc;
    private final zzcku zzd;
    private final zzdzl zze;
    private zzfuw zzf;

    public zzell(Context context, VersionInfoParcel versionInfoParcel, zzfkf zzfkfVar, zzcku zzckuVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfkfVar;
        this.zzd = zzckuVar;
        this.zze = zzdzlVar;
    }

    public final synchronized boolean zza(boolean z) {
        zzcku zzckuVar;
        zzfkf zzfkfVar = this.zzc;
        if (zzfkfVar.zzT) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgk)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgn)).booleanValue() && (zzckuVar = this.zzd) != null) {
                    if (this.zzf != null) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid javascript session service already started for ad.");
                        return false;
                    }
                    if (!com.google.android.gms.ads.internal.zzt.zzu().zza(this.zza)) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Unable to initialize omid.");
                        return false;
                    }
                    if (zzfkfVar.zzV.zzb()) {
                        zzfuw zzfuwVarZzi = com.google.android.gms.ads.internal.zzt.zzu().zzi(this.zzb, zzckuVar.zzD(), true);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgo)).booleanValue()) {
                            zzdzl zzdzlVar = this.zze;
                            String str = zzfuwVarZzi != null ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            zzdzk zzdzkVarZza = zzdzlVar.zza();
                            zzdzkVarZza.zzc("omid_js_session_success", str);
                            zzdzkVarZza.zzd();
                        }
                        if (zzfuwVarZzi == null) {
                            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Unable to create javascript session service.");
                            return false;
                        }
                        int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Created omid javascript session service.");
                        this.zzf = zzfuwVarZzi;
                        zzckuVar.zzal(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final synchronized boolean zzb() {
        return this.zzf != null;
    }

    public final synchronized void zzc() {
        zzcku zzckuVar;
        try {
            zzfuw zzfuwVar = this.zzf;
            if (zzfuwVar == null || (zzckuVar = this.zzd) == null) {
                return;
            }
            Iterator it = zzckuVar.zzF().iterator();
            while (it.hasNext()) {
                com.google.android.gms.ads.internal.zzt.zzu().zzk(zzfuwVar, (View) it.next());
            }
            zzckuVar.zze("onSdkLoaded", zzgwp.zza());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd() {
        zzcku zzckuVar;
        if (this.zzf == null || (zzckuVar = this.zzd) == null) {
            return;
        }
        zzckuVar.zze("onSdkImpression", zzgwp.zza());
    }

    public final synchronized void zze(zzfuv zzfuvVar) {
        zzcku zzckuVar;
        zzfuw zzfuwVar = this.zzf;
        if (zzfuwVar == null || (zzckuVar = this.zzd) == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zzj(zzfuwVar, zzfuvVar);
        this.zzf = null;
        zzckuVar.zzal(null);
    }

    public final synchronized void zzf(View view) {
        zzfuw zzfuwVar = this.zzf;
        if (zzfuwVar != null) {
            com.google.android.gms.ads.internal.zzt.zzu().zzk(zzfuwVar, view);
        }
    }
}
