package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfkx {
    private com.google.android.gms.ads.internal.client.zzm zza;
    private com.google.android.gms.ads.internal.client.zzr zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzfw zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;
    private zzblt zzh;
    private com.google.android.gms.ads.internal.client.zzx zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;
    private com.google.android.gms.ads.internal.client.zzcl zzl;
    private zzbsb zzn;
    private zzetc zzr;
    private Bundle zzt;
    private JSONArray zzw;
    private com.google.android.gms.ads.internal.client.zzcp zzx;
    private int zzm = 1;
    private final zzfkl zzo = new zzfkl();
    private boolean zzp = false;
    private boolean zzq = false;
    private boolean zzs = false;
    private final AtomicLong zzu = new AtomicLong();
    private boolean zzv = false;

    public final zzfkx zzA(zzfky zzfkyVar) {
        this.zzo.zza(zzfkyVar.zzp.zza);
        this.zza = zzfkyVar.zzd;
        this.zzb = zzfkyVar.zzf;
        this.zzx = zzfkyVar.zzx;
        this.zzc = zzfkyVar.zzg;
        this.zzd = zzfkyVar.zza;
        this.zzf = zzfkyVar.zzh;
        this.zzg = zzfkyVar.zzi;
        this.zzh = zzfkyVar.zzj;
        this.zzi = zzfkyVar.zzk;
        zzs(zzfkyVar.zzm);
        zzr(zzfkyVar.zzn);
        this.zzp = zzfkyVar.zzq;
        this.zzq = zzfkyVar.zzr;
        this.zzr = zzfkyVar.zzc;
        this.zzs = zzfkyVar.zzs;
        this.zzt = zzfkyVar.zzt;
        this.zzu.set(zzfkyVar.zzu.get());
        this.zzv = zzfkyVar.zzv;
        this.zzw = zzfkyVar.zzw;
        return this;
    }

    public final zzfky zzB() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfky(this, null);
    }

    public final boolean zzC() {
        return this.zzp;
    }

    public final boolean zzD() {
        return this.zzq;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzm zzE() {
        return this.zza;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzr zzF() {
        return this.zzb;
    }

    public final /* synthetic */ String zzG() {
        return this.zzc;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzfw zzH() {
        return this.zzd;
    }

    public final /* synthetic */ boolean zzI() {
        return this.zze;
    }

    public final /* synthetic */ ArrayList zzJ() {
        return this.zzf;
    }

    public final /* synthetic */ ArrayList zzK() {
        return this.zzg;
    }

    public final /* synthetic */ zzblt zzL() {
        return this.zzh;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzx zzM() {
        return this.zzi;
    }

    public final /* synthetic */ AdManagerAdViewOptions zzN() {
        return this.zzj;
    }

    public final /* synthetic */ PublisherAdViewOptions zzO() {
        return this.zzk;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzcl zzP() {
        return this.zzl;
    }

    public final /* synthetic */ int zzQ() {
        return this.zzm;
    }

    public final /* synthetic */ zzbsb zzR() {
        return this.zzn;
    }

    public final /* synthetic */ zzfkl zzS() {
        return this.zzo;
    }

    public final /* synthetic */ boolean zzT() {
        return this.zzp;
    }

    public final /* synthetic */ boolean zzU() {
        return this.zzq;
    }

    public final /* synthetic */ zzetc zzV() {
        return this.zzr;
    }

    public final /* synthetic */ boolean zzW() {
        return this.zzs;
    }

    public final /* synthetic */ Bundle zzX() {
        return this.zzt;
    }

    public final /* synthetic */ AtomicLong zzY() {
        return this.zzu;
    }

    public final /* synthetic */ boolean zzZ() {
        return this.zzv;
    }

    public final zzfkx zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zza = zzmVar;
        return this;
    }

    public final /* synthetic */ JSONArray zzaa() {
        return this.zzw;
    }

    public final zzfkx zzab(com.google.android.gms.ads.internal.client.zzcp zzcpVar) {
        this.zzx = zzcpVar;
        return this;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzcp zzac() {
        return this.zzx;
    }

    public final com.google.android.gms.ads.internal.client.zzm zzb() {
        return this.zza;
    }

    public final zzfkx zzc(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzb = zzrVar;
        return this;
    }

    public final zzfkx zzd(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzfkx zze(boolean z) {
        this.zzq = z;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzr zzf() {
        return this.zzb;
    }

    public final zzfkx zzg(String str) {
        this.zzc = str;
        return this;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final zzfkx zzi(com.google.android.gms.ads.internal.client.zzfw zzfwVar) {
        this.zzd = zzfwVar;
        return this;
    }

    public final zzfkl zzj() {
        return this.zzo;
    }

    public final zzfkx zzk(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzfkx zzl(int i) {
        this.zzm = i;
        return this;
    }

    public final zzfkx zzm(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfkx zzn(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfkx zzo(zzblt zzbltVar) {
        this.zzh = zzbltVar;
        return this;
    }

    public final zzfkx zzp(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi = zzxVar;
        return this;
    }

    public final zzfkx zzq(zzbsb zzbsbVar) {
        this.zzn = zzbsbVar;
        this.zzd = new com.google.android.gms.ads.internal.client.zzfw(false, true, false);
        return this;
    }

    public final zzfkx zzr(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zza();
            this.zzl = publisherAdViewOptions.zzb();
        }
        return this;
    }

    public final zzfkx zzs(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfkx zzt(zzetc zzetcVar) {
        this.zzr = zzetcVar;
        return this;
    }

    public final zzfkx zzu(boolean z) {
        this.zzs = true;
        return this;
    }

    public final zzfkx zzv(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final long zzw() {
        return this.zzu.get();
    }

    public final zzfkx zzx(long j) {
        this.zzu.set(j);
        return this;
    }

    public final zzfkx zzy(boolean z) {
        this.zzv = true;
        return this;
    }

    public final zzfkx zzz(JSONArray jSONArray) {
        this.zzw = jSONArray;
        return this;
    }
}
