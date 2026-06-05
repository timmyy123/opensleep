package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeh {
    private final String zza;
    private final List zzb;
    private final Set zzc;
    private final Bundle zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final Set zzh;
    private final Bundle zzi;
    private final Set zzj;
    private final boolean zzk;
    private final String zzl;
    private final int zzm;
    private long zzn = 0;
    private long zzo;

    public zzeh(zzeg zzegVar) {
        this.zzo = 0L;
        this.zza = zzegVar.zzx();
        this.zzb = zzegVar.zzy();
        this.zzc = Collections.unmodifiableSet(zzegVar.zzr());
        this.zzd = zzegVar.zzs();
        Collections.unmodifiableMap(zzegVar.zzt());
        this.zze = zzegVar.zzz();
        this.zzf = zzegVar.zzA();
        this.zzg = zzegVar.zzB();
        this.zzh = Collections.unmodifiableSet(zzegVar.zzu());
        this.zzi = zzegVar.zzv();
        this.zzj = Collections.unmodifiableSet(zzegVar.zzw());
        this.zzk = zzegVar.zzC();
        this.zzl = zzegVar.zzD();
        this.zzm = zzegVar.zzE();
        this.zzo = zzegVar.zzF();
    }

    public final String zza() {
        return this.zza;
    }

    public final List zzb() {
        return new ArrayList(this.zzb);
    }

    public final Set zzc() {
        return this.zzc;
    }

    public final Bundle zzd(Class cls) {
        return this.zzd.getBundle(cls.getName());
    }

    public final String zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final boolean zzh(Context context) {
        RequestConfiguration requestConfigurationZzp = zzeu.zzb().zzp();
        zzay.zza();
        Set set = this.zzh;
        String strZzF = com.google.android.gms.ads.internal.util.client.zzf.zzF(context);
        return set.contains(strZzF) || requestConfigurationZzp.getTestDeviceIds().contains(strZzF);
    }

    public final Bundle zzi() {
        return this.zzd;
    }

    public final int zzj() {
        return this.zzg;
    }

    public final Bundle zzk() {
        return this.zzi;
    }

    public final Set zzl() {
        return this.zzj;
    }

    @Deprecated
    public final boolean zzm() {
        return this.zzk;
    }

    public final String zzn() {
        return this.zzl;
    }

    public final int zzo() {
        return this.zzm;
    }

    public final void zzp(long j) {
        this.zzn = j;
    }

    public final long zzq() {
        return this.zzn;
    }

    public final long zzr() {
        return this.zzo;
    }
}
