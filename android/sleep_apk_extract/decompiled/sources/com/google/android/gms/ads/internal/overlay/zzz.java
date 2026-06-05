package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcku;
import com.google.android.gms.internal.ads.zzgqx;
import com.google.android.gms.internal.ads.zzgqy;
import com.google.android.gms.internal.ads.zzgqz;
import com.google.android.gms.internal.ads.zzgra;
import com.google.android.gms.internal.ads.zzgrt;
import com.google.android.gms.internal.ads.zzgrv;
import com.google.android.gms.internal.ads.zzgrw;
import com.google.android.gms.internal.ads.zzgrx;
import com.google.android.gms.internal.ads.zzgry;
import com.google.android.gms.internal.ads.zzgsl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzz {
    private zzgrw zzf;
    private zzcku zzc = null;
    private boolean zze = false;
    private String zza = null;
    private zzgqz zzd = null;
    private String zzb = null;

    private final void zzl() {
        if (this.zzf == null) {
            this.zzf = new zzx(this);
        }
    }

    private final zzgry zzm() {
        zzgrx zzgrxVarZzc = zzgry.zzc();
        if (!((Boolean) zzba.zzc().zzd(zzbiq.zzmW)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzgrxVarZzc.zza(str);
            } else {
                zzg("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzgrxVarZzc.zzb(this.zzb);
        }
        return zzgrxVarZzc.zzc();
    }

    public final synchronized void zza(zzcku zzckuVar, Context context) {
        this.zzc = zzckuVar;
        if (!zzb(context)) {
            zzg("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap map = new HashMap();
        map.put("action", "fetch_completed");
        zzi("on_play_store_bind", map);
    }

    public final synchronized boolean zzb(Context context) {
        if (!zzgsl.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzgra.zza(context);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzl();
        this.zze = true;
        return true;
    }

    public final void zzc(zzcku zzckuVar, zzgrt zzgrtVar) {
        if (zzckuVar == null) {
            zzg("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzckuVar;
        if (!this.zze && !zzb(zzckuVar.getContext())) {
            zzg("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzba.zzc().zzd(zzbiq.zzmW)).booleanValue()) {
            this.zzb = zzgrtVar.zzb();
        }
        zzl();
        zzgqz zzgqzVar = this.zzd;
        if (zzgqzVar != null) {
            zzgqzVar.zza(zzgrtVar, this.zzf);
        }
    }

    public final void zzd() {
        zzgqz zzgqzVar;
        if (!this.zze || (zzgqzVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzgqzVar.zzd(zzm(), this.zzf);
            zzh("onLMDOverlayExpand");
        }
    }

    public final void zze() {
        zzgqz zzgqzVar;
        if (!this.zze || (zzgqzVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzgqzVar.zzc(zzm(), this.zzf);
            zzh("onLMDOverlayCollapse");
        }
    }

    public final void zzf() {
        zzgqz zzgqzVar;
        if (!this.zze || (zzgqzVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
            return;
        }
        zzgqx zzgqxVarZzc = zzgqy.zzc();
        if (!((Boolean) zzba.zzc().zzd(zzbiq.zzmW)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzgqxVarZzc.zza(str);
            } else {
                zzg("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzgqxVarZzc.zzb(this.zzb);
        }
        zzgqzVar.zzb(zzgqxVarZzc.zzc(), this.zzf);
    }

    public final void zzg(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.zza(str);
        if (this.zzc != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put("action", str2);
            zzi("onError", map);
        }
    }

    public final void zzh(String str) {
        zzi(str, new HashMap());
    }

    public final void zzi(final String str, final Map map) {
        zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzk(str, map);
            }
        });
    }

    public final void zzj(zzgrv zzgrvVar) {
        if (!TextUtils.isEmpty(zzgrvVar.zzb())) {
            if (!((Boolean) zzba.zzc().zzd(zzbiq.zzmW)).booleanValue()) {
                this.zza = zzgrvVar.zzb();
            }
        }
        switch (zzgrvVar.zza()) {
            case 8152:
                zzh("onLMDOverlayOpened");
                break;
            case 8153:
                zzh("onLMDOverlayClicked");
                break;
            case 8155:
                zzh("onLMDOverlayClose");
                break;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzgrvVar.zza()));
                zzi("onLMDOverlayFailedToOpen", map);
                break;
        }
    }

    public final /* synthetic */ void zzk(String str, Map map) {
        zzcku zzckuVar = this.zzc;
        if (zzckuVar != null) {
            zzckuVar.zze(str, map);
        }
    }
}
