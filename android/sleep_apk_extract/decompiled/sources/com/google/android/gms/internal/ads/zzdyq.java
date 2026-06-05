package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.ads.AdSDKNotificationListener;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdyq implements zzdht, com.google.android.gms.ads.internal.client.zza, zzddl, zzdcv, zzdfm {
    private final Context zzc;
    private final zzflr zzd;
    private final zzdzl zze;
    private final zzfkq zzf;
    private final zzfkf zzg;
    private final zzekg zzh;
    private final String zzi;
    private Boolean zzk;
    private long zzj = -1;
    final AtomicBoolean zza = new AtomicBoolean(false);
    final AtomicBoolean zzb = new AtomicBoolean(false);
    private final boolean zzl = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhM)).booleanValue();

    public zzdyq(Context context, zzflr zzflrVar, zzdzl zzdzlVar, zzfkq zzfkqVar, zzfkf zzfkfVar, zzekg zzekgVar, String str) {
        this.zzc = context;
        this.zzd = zzflrVar;
        this.zze = zzdzlVar;
        this.zzf = zzfkqVar;
        this.zzg = zzfkfVar;
        this.zzh = zzekgVar;
        this.zzi = str;
    }

    private final boolean zzf() {
        String strZzr;
        if (this.zzk == null) {
            synchronized (this) {
                if (this.zzk == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzce);
                    com.google.android.gms.ads.internal.zzt.zzc();
                    try {
                        strZzr = com.google.android.gms.ads.internal.util.zzs.zzr(this.zzc);
                    } catch (RemoteException unused) {
                        strZzr = null;
                    }
                    boolean zMatches = false;
                    if (str != null && strZzr != null) {
                        try {
                            zMatches = Pattern.matches(str, strZzr);
                        } catch (RuntimeException e) {
                            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzk = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzk.booleanValue();
    }

    private final zzdzk zzg(String str) {
        zzfkq zzfkqVar = this.zzf;
        zzfkp zzfkpVar = zzfkqVar.zzb;
        zzdzk zzdzkVarZza = this.zze.zza();
        zzdzkVarZza.zza(zzfkpVar.zzb);
        zzfkf zzfkfVar = this.zzg;
        zzdzkVarZza.zzb(zzfkfVar);
        zzdzkVarZza.zzc("action", str);
        zzdzkVarZza.zzc("ad_format", this.zzi.toUpperCase(Locale.ROOT));
        List list = zzfkfVar.zzt;
        if (!list.isEmpty()) {
            zzdzkVarZza.zzc("ancn", (String) list.get(0));
        }
        if (zzfkfVar.zzb()) {
            zzdzkVarZza.zzc("device_connectivity", true != com.google.android.gms.ads.internal.zzt.zzh().zzs(this.zzc) ? "offline" : "online");
            zzdzkVarZza.zzc("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis()));
            zzdzkVarZza.zzc("offline_ad", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhT)).booleanValue()) {
            boolean zZza = com.google.android.gms.ads.nonagon.signalgeneration.zzv.zza(zzfkqVar);
            zzdzkVarZza.zzc("scar", String.valueOf(zZza));
            if (zZza) {
                com.google.android.gms.ads.internal.client.zzm zzmVar = zzfkqVar.zza.zza.zzd;
                zzdzkVarZza.zzc("ragent", zzmVar.zzp);
                zzdzkVarZza.zzc("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzc(zzmVar)));
            }
        }
        return zzdzkVarZza;
    }

    private final void zzi(zzdzk zzdzkVar) {
        if (!this.zzg.zzb()) {
            zzdzkVar.zzd();
            return;
        }
        this.zzh.zze(new zzeki(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis(), this.zzf.zzb.zzb.zzb, zzdzkVar.zzg(), 2));
    }

    private final boolean zzj() {
        int i = this.zzg.zzb;
        return i == 2 || i == 5 || i == 6 || i == 7;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zzg.zzb()) {
            zzi(zzg("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcv
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzl) {
            zzdzk zzdzkVarZzg = zzg("ifts");
            zzdzkVarZzg.zzc("reason", "adapter");
            int i = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals("com.google.android.gms.ads") && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals("com.google.android.gms.ads")) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            if (i >= 0) {
                zzdzkVarZzg.zzc("arec", String.valueOf(i));
            }
            String strZza = this.zzd.zza(str);
            if (strZza != null) {
                zzdzkVarZzg.zzc("areec", strZza);
            }
            zzdzkVarZzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcv
    public final void zzd(zzdnn zzdnnVar) {
        if (this.zzl) {
            zzdzk zzdzkVarZzg = zzg("ifts");
            zzdzkVarZzg.zzc("reason", "exception");
            if (!TextUtils.isEmpty(zzdnnVar.getMessage())) {
                zzdzkVarZzg.zzc(SDKConstants.PARAM_DEBUG_MESSAGE, zzdnnVar.getMessage());
            }
            zzdzkVarZzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdH() {
        if (zzf()) {
            zzdzk zzdzkVarZzg = zzg("adapter_impression");
            zzdzkVarZzg.zzc("imp_type", String.valueOf(this.zzg.zze));
            boolean z = this.zzb.get();
            String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            if (z) {
                zzdzkVarZzg.zzc("po", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                zzdzkVarZzg.zzc("pil", String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zzj));
            } else {
                zzdzkVarZzg.zzc("po", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpa)).booleanValue() && zzj()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                zzdzkVarZzg.zzc("foreground", true != com.google.android.gms.ads.internal.util.zzs.zzJ(this.zzc) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                zzdzkVarZzg.zzc("fg_show", true != this.zza.get() ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpb)).booleanValue() && zzj()) {
                if (true == com.google.android.gms.ads.internal.zzt.zzg().zzf()) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
                zzdzkVarZzg.zzc("fg_al", str);
            }
            zzdzkVarZzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdI() {
        if (zzf()) {
            zzg("adapter_shown").zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        if (zzf() || this.zzg.zzb()) {
            zzdzk zzdzkVarZzg = zzg(AdSDKNotificationListener.IMPRESSION_EVENT);
            zzdzkVarZzg.zzc("imp_type", String.valueOf(this.zzg.zze));
            if (this.zzj > 0) {
                zzdzkVarZzg.zzc("p_imp_l", String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zzj));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpa)).booleanValue() && zzj()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                boolean zZzJ = com.google.android.gms.ads.internal.util.zzs.zzJ(this.zzc);
                String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                zzdzkVarZzg.zzc("foreground", true != zZzJ ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                if (true == this.zza.get()) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
                zzdzkVarZzg.zzc("fg_show", str);
            }
            zzi(zzdzkVarZzg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcv
    public final void zze() {
        if (this.zzl) {
            zzdzk zzdzkVarZzg = zzg("ifts");
            zzdzkVarZzg.zzc("reason", "blocked");
            zzdzkVarZzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzk() {
        if (zzf()) {
            this.zzb.set(true);
            this.zzj = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            zzdzk zzdzkVarZzg = zzg("presentation");
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpa)).booleanValue();
            String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            if (zBooleanValue && zzj()) {
                AtomicBoolean atomicBoolean = this.zza;
                com.google.android.gms.ads.internal.zzt.zzc();
                atomicBoolean.set(!com.google.android.gms.ads.internal.util.zzs.zzJ(this.zzc));
                zzdzkVarZzg.zzc("foreground", true != atomicBoolean.get() ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpb)).booleanValue() && zzj()) {
                if (true != com.google.android.gms.ads.internal.zzt.zzg().zzf()) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                zzdzkVarZzg.zzc("fg_al", str);
            }
            zzdzkVarZzg.zzd();
        }
    }
}
