package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdhi implements AppEventListener, OnAdMetadataChangedListener, zzdcr, com.google.android.gms.ads.internal.client.zza, zzdfi, zzddl, zzdeq, com.google.android.gms.ads.internal.overlay.zzr, zzddh, zzdky {
    private final zzdgh zza = new zzdgh(this, null);

    @Nullable
    private zzetc zzb;

    @Nullable
    private zzetg zzc;

    @Nullable
    private zzfge zzd;

    @Nullable
    private zzfjj zze;

    private static void zzs(Object obj, zzdhh zzdhhVar) {
        if (obj != null) {
            zzdhhVar.zza(obj);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzs(this.zzb, zzdgm.zza);
        zzs(this.zzc, zzdgz.zza);
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzs(this.zze, zzdhf.zza);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(final String str, final String str2) {
        zzs(this.zzb, new zzdhh() { // from class: com.google.android.gms.internal.ads.zzdfz
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
                ((zzetc) obj).onAppEvent(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzd(final zzcbp zzcbpVar, final String str, final String str2) {
        zzs(this.zzb, new zzdhh(zzcbpVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzdgg
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
            }
        });
        zzs(this.zze, new zzdhh() { // from class: com.google.android.gms.internal.ads.zzdfy
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
                ((zzfjj) obj).zzd(zzcbpVar, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
        zzs(this.zzb, zzdgj.zza);
        zzs(this.zze, zzdhb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdR() {
        zzs(this.zzb, zzdgn.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdT() {
        zzs(this.zzd, zzdgt.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdU(final int i) {
        zzs(this.zzd, new zzdhh() { // from class: com.google.android.gms.internal.ads.zzdgf
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
                ((zzfge) obj).zzdU(i);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdq() {
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        zzs(this.zzb, zzdgp.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
        zzs(this.zzb, zzdgi.zza);
        zzs(this.zze, zzdha.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
        zzs(this.zzb, zzdgq.zza);
        zzs(this.zze, zzdhg.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdu() {
        zzs(this.zzb, zzdgo.zza);
        zzs(this.zzc, zzdgy.zza);
        zzs(this.zze, zzdhe.zza);
        zzs(this.zzd, zzdgx.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
        zzs(this.zzd, zzdgu.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw() {
        zzs(this.zzd, zzdgv.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdx() {
        zzs(this.zzd, zzdgw.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdy() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdz() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
        zzs(this.zzb, zzdgk.zza);
        zzs(this.zze, zzdhc.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
        zzs(this.zzb, zzdgl.zza);
        zzs(this.zze, zzdhd.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        zzs(this.zzd, zzdgs.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzddh
    public final void zzj(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzs(this.zze, new zzdhh() { // from class: com.google.android.gms.internal.ads.zzdgd
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
                ((zzfjj) obj).zzj(zzeVar);
            }
        });
        zzs(this.zzb, new zzdhh() { // from class: com.google.android.gms.internal.ads.zzdge
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
                ((zzetc) obj).zzj(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzl() {
        zzs(this.zzd, zzdgr.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final void zzm(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzs(this.zzb, new zzdhh() { // from class: com.google.android.gms.internal.ads.zzdga
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
                ((zzetc) obj).zzm(zztVar);
            }
        });
        zzs(this.zze, new zzdhh() { // from class: com.google.android.gms.internal.ads.zzdgb
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
                ((zzfjj) obj).zzm(zztVar);
            }
        });
        zzs(this.zzd, new zzdhh() { // from class: com.google.android.gms.internal.ads.zzdgc
            @Override // com.google.android.gms.internal.ads.zzdhh
            public final /* synthetic */ void zza(Object obj) {
                ((zzfge) obj).zzm(zztVar);
            }
        });
    }

    public final zzdgh zzn() {
        return this.zza;
    }

    public final /* synthetic */ void zzo(zzetc zzetcVar) {
        this.zzb = zzetcVar;
    }

    public final /* synthetic */ void zzp(zzetg zzetgVar) {
        this.zzc = zzetgVar;
    }

    public final /* synthetic */ void zzq(zzfge zzfgeVar) {
        this.zzd = zzfgeVar;
    }

    public final /* synthetic */ void zzr(zzfjj zzfjjVar) {
        this.zze = zzfjjVar;
    }
}
