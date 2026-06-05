package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdwh {
    private final zzdcp zza;
    private final zzdkw zzb;
    private final zzddy zzc;
    private final zzdel zzd;
    private final zzdfc zze;
    private final zzdhv zzf;
    private final Executor zzg;
    private final zzdks zzh;
    private final zzcug zzi;
    private final com.google.android.gms.ads.internal.zzb zzj;
    private final zzcdn zzk;
    private final zzbap zzl;
    private final zzdhm zzm;
    private final zzekg zzn;
    private final zzfsc zzo;
    private final zzdzl zzp;
    private final zzctj zzq;
    private final zzdwn zzr;
    private final zzeao zzs;
    private final zzdbs zzt;
    private final zzdbn zzu;

    public zzdwh(zzdcp zzdcpVar, zzddy zzddyVar, zzdel zzdelVar, zzdfc zzdfcVar, zzdhv zzdhvVar, Executor executor, zzdks zzdksVar, zzcug zzcugVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcdn zzcdnVar, zzbap zzbapVar, zzdhm zzdhmVar, zzekg zzekgVar, zzfsc zzfscVar, zzdzl zzdzlVar, zzdkw zzdkwVar, zzctj zzctjVar, zzdwn zzdwnVar, zzeao zzeaoVar, zzdbs zzdbsVar, zzdbn zzdbnVar) {
        this.zza = zzdcpVar;
        this.zzc = zzddyVar;
        this.zzd = zzdelVar;
        this.zze = zzdfcVar;
        this.zzf = zzdhvVar;
        this.zzg = executor;
        this.zzh = zzdksVar;
        this.zzi = zzcugVar;
        this.zzj = zzbVar;
        this.zzk = zzcdnVar;
        this.zzl = zzbapVar;
        this.zzm = zzdhmVar;
        this.zzn = zzekgVar;
        this.zzo = zzfscVar;
        this.zzp = zzdzlVar;
        this.zzb = zzdkwVar;
        this.zzq = zzctjVar;
        this.zzr = zzdwnVar;
        this.zzs = zzeaoVar;
        this.zzt = zzdbsVar;
        this.zzu = zzdbnVar;
    }

    public static final ListenableFuture zzj(zzcku zzckuVar, String str, String str2, final zzdzg zzdzgVar, zzfqg zzfqgVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcQ)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_LOAD_HTML_START.zza(), zzdzgVar);
        }
        final zzcfw zzcfwVar = new zzcfw();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkk)).booleanValue()) {
            zzfpw zzfpwVarZzn = zzfpw.zzn(zzckuVar.getContext(), 112);
            zzfpwVarZzn.zza();
            zzfqf.zzd(zzcfwVar, zzfqgVar, zzfpwVarZzn);
        }
        zzckuVar.zzP().zzG(new zzcmq() { // from class: com.google.android.gms.internal.ads.zzdwf
            @Override // com.google.android.gms.internal.ads.zzcmq
            public final /* synthetic */ void zza(boolean z, int i, String str3, String str4) {
                zzcfw zzcfwVar2 = zzcfwVar;
                if (z) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcQ)).booleanValue()) {
                        zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_LOAD_HTML_END.zza(), zzdzgVar);
                    }
                    zzcfwVar2.zzc(null);
                    return;
                }
                int length = String.valueOf(i).length();
                StringBuilder sb = new StringBuilder(length + 55 + String.valueOf(str3).length() + 15 + String.valueOf(str4).length());
                zzba$$ExternalSyntheticOutline0.m(sb, "Ad Web View failed to load. Error code: ", i, ", Description: ", str3);
                zzcfwVar2.zzd(new Exception(FileInsert$$ExternalSyntheticOutline0.m(sb, ", Failing URL: ", str4)));
            }
        });
        zzckuVar.zzau(str, str2, null);
        return zzcfwVar;
    }

    public final /* synthetic */ void zza() {
        this.zza.onAdClicked();
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    public final /* synthetic */ void zzc() {
        this.zzc.zzb();
    }

    public final /* synthetic */ boolean zzd(View view, MotionEvent motionEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlw)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            this.zzr.zza(motionEvent);
        }
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public final /* synthetic */ void zze(View view) {
        this.zzj.zza();
    }

    public final /* synthetic */ void zzf(zzcku zzckuVar, zzcku zzckuVar2, Map map) {
        this.zzi.zzn(zzckuVar);
    }

    public final /* synthetic */ zzddy zzg() {
        return this.zzc;
    }

    public final /* synthetic */ zzdhm zzh() {
        return this.zzm;
    }

    public final void zzi(final zzcku zzckuVar, boolean z, zzbpt zzbptVar, zzdzg zzdzgVar) {
        zzbak zzbakVarZzb;
        zzbih zzbihVar = zzbiq.zzcQ;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_CONFIGURE_WEBVIEW_START.zza(), zzdzgVar);
        }
        zzckuVar.zzP().zzab(new com.google.android.gms.ads.internal.client.zza() { // from class: com.google.android.gms.internal.ads.zzdwg
            @Override // com.google.android.gms.ads.internal.client.zza
            public final /* synthetic */ void onAdClicked() {
                this.zza.zza();
            }
        }, this.zzd, this.zze, new zzboi() { // from class: com.google.android.gms.internal.ads.zzdvz
            @Override // com.google.android.gms.internal.ads.zzboi
            public final /* synthetic */ void zzb(String str, String str2) {
                this.zza.zzb(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzad() { // from class: com.google.android.gms.internal.ads.zzdwa
            @Override // com.google.android.gms.ads.internal.overlay.zzad
            public final /* synthetic */ void zzl() {
                this.zza.zzc();
            }
        }, z, zzbptVar, this.zzj, new zzdvy(this), this.zzk, this.zzn, this.zzo, this.zzp, null, this.zzb, null, null, null, this.zzq, this.zzs, this.zzt, this.zzu);
        zzckuVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.internal.ads.zzdwb
            @Override // android.view.View.OnTouchListener
            public final /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
                this.zza.zzd(view, motionEvent);
                return false;
            }
        });
        zzckuVar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzdwc
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                this.zza.zze(view);
            }
        });
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdz)).booleanValue() && (zzbakVarZzb = this.zzl.zzb()) != null) {
            zzbakVarZzb.zzh(zzckuVar.zzE());
        }
        zzdks zzdksVar = this.zzh;
        Executor executor = this.zzg;
        zzdksVar.zzq(zzckuVar, executor);
        zzdksVar.zzq(new zzbeq() { // from class: com.google.android.gms.internal.ads.zzdwd
            @Override // com.google.android.gms.internal.ads.zzbeq
            public final /* synthetic */ void zzdj(zzbep zzbepVar) {
                Rect rect = zzbepVar.zzd;
                zzckuVar.zzP().zza(rect.left, rect.top, false);
            }
        }, executor);
        zzdksVar.zza(zzckuVar.zzE());
        zzckuVar.zzab("/trackActiveViewUnit", new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdwe
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzf(zzckuVar, (zzcku) obj, map);
            }
        });
        this.zzi.zzo(zzckuVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_CONFIGURE_WEBVIEW_END.zza(), zzdzgVar);
        }
    }
}
