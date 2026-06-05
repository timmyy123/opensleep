package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfky {
    public final com.google.android.gms.ads.internal.client.zzfw zza;
    public final zzbsb zzb;
    public final zzetc zzc;
    public final com.google.android.gms.ads.internal.client.zzm zzd;
    public final Bundle zze;
    public final com.google.android.gms.ads.internal.client.zzr zzf;
    public final String zzg;
    public final ArrayList zzh;
    public final ArrayList zzi;
    public final zzblt zzj;
    public final com.google.android.gms.ads.internal.client.zzx zzk;
    public final int zzl;
    public final AdManagerAdViewOptions zzm;
    public final PublisherAdViewOptions zzn;
    public final com.google.android.gms.ads.internal.client.zzcl zzo;
    public final zzfkm zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final boolean zzs;
    public final Bundle zzt;
    public final AtomicLong zzu;
    public final boolean zzv;
    public final JSONArray zzw;
    public final com.google.android.gms.ads.internal.client.zzcp zzx;

    public /* synthetic */ zzfky(zzfkx zzfkxVar, byte[] bArr) {
        this.zzf = zzfkxVar.zzF();
        this.zzg = zzfkxVar.zzG();
        this.zzx = zzfkxVar.zzac();
        this.zze = zzfkxVar.zzE().zzB;
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE2 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE3 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE4 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE5 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE6 = zzfkxVar.zzE();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzE7 = zzfkxVar.zzE();
        int i = zzfkxVar.zzE().zza;
        long j = zzmVarZzE7.zzb;
        Bundle bundle = zzmVarZzE6.zzc;
        int i2 = zzmVarZzE5.zzd;
        List list = zzmVarZzE4.zze;
        boolean z = zzmVarZzE3.zzf;
        int i3 = zzmVarZzE2.zzg;
        boolean z2 = true;
        if (!zzmVarZzE.zzh && !zzfkxVar.zzI()) {
            z2 = false;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = new com.google.android.gms.ads.internal.client.zzm(i, j, bundle, i2, list, z, i3, z2, zzfkxVar.zzE().zzi, zzfkxVar.zzE().zzj, zzfkxVar.zzE().zzk, zzfkxVar.zzE().zzl, zzfkxVar.zzE().zzm, zzfkxVar.zzE().zzn, zzfkxVar.zzE().zzo, zzfkxVar.zzE().zzp, zzfkxVar.zzE().zzq, zzfkxVar.zzE().zzr, zzfkxVar.zzE().zzs, zzfkxVar.zzE().zzt, zzfkxVar.zzE().zzu, zzfkxVar.zzE().zzv, com.google.android.gms.ads.internal.util.zzs.zza(zzfkxVar.zzE().zzw), zzfkxVar.zzE().zzx, zzfkxVar.zzE().zzy, zzfkxVar.zzE().zzz, zzfkxVar.zzE().zzA);
        this.zzd = zzmVar;
        this.zza = zzfkxVar.zzH() != null ? zzfkxVar.zzH() : zzfkxVar.zzL() != null ? zzfkxVar.zzL().zzf : null;
        this.zzh = zzfkxVar.zzJ();
        this.zzi = zzfkxVar.zzK();
        this.zzj = zzfkxVar.zzJ() == null ? null : zzfkxVar.zzL() == null ? new zzblt(new NativeAdOptions.Builder().build()) : zzfkxVar.zzL();
        this.zzk = zzfkxVar.zzM();
        this.zzl = zzfkxVar.zzQ();
        this.zzm = zzfkxVar.zzN();
        this.zzn = zzfkxVar.zzO();
        this.zzo = zzfkxVar.zzP();
        this.zzb = zzfkxVar.zzR();
        this.zzp = new zzfkm(zzfkxVar.zzS(), null);
        this.zzq = zzfkxVar.zzT();
        this.zzr = zzfkxVar.zzU();
        this.zzc = zzfkxVar.zzV();
        this.zzs = zzfkxVar.zzW();
        this.zzt = zzfkxVar.zzX();
        this.zzu = zzmVar.zzA != 0 ? new AtomicLong(zzmVar.zzA) : zzfkxVar.zzY();
        this.zzv = zzfkxVar.zzZ();
        this.zzw = zzfkxVar.zzaa();
    }

    public final boolean zza() {
        return this.zzg.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzef));
    }
}
