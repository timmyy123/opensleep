package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfc {
    private final zzbb zza;
    private final zzaz zzb;
    private final zzew zzc;
    private final zzbd zzd = new zzbd();
    private final zzdz zze;
    private final zzex zzf;
    private final zzez zzg;
    private final zzfa zzh;
    private final zzfb zzi;

    public zzfc(zzbb zzbbVar, zzew zzewVar, zzdo zzdoVar, int i, int i2, int i3, int i4) {
        this.zza = zzbbVar;
        this.zzc = zzewVar;
        this.zze = zzdoVar.zzd(zzbbVar.zzd(), new Handler.Callback() { // from class: com.google.android.gms.internal.ads.zzey
            @Override // android.os.Handler.Callback
            public final /* synthetic */ boolean handleMessage(Message message) {
                return this.zza.zzb(message);
            }
        });
        this.zzf = new zzex(this, i);
        this.zzg = new zzez(this, i2);
        this.zzh = new zzfa(this, i3);
        this.zzi = new zzfb(this, i4);
        zzev zzevVar = new zzev(this);
        this.zzb = zzevVar;
        zzbbVar.zze(zzevVar);
    }

    public final void zza() {
        this.zze.zzl(null);
        this.zza.zzf(this.zzb);
    }

    public final /* synthetic */ boolean zzb(Message message) {
        int i = message.what;
        if (i == 1) {
            this.zzf.zza();
            return true;
        }
        if (i == 2) {
            this.zzg.zza();
            return true;
        }
        if (i == 3) {
            this.zzh.zza();
            return true;
        }
        if (i != 4) {
            return false;
        }
        this.zzi.zza();
        return true;
    }

    public final /* synthetic */ void zzc() {
        this.zzf.zza();
        this.zzg.zza();
        this.zzh.zza();
        this.zzi.zza();
    }

    public final /* synthetic */ zzbb zzd() {
        return this.zza;
    }

    public final /* synthetic */ zzew zze() {
        return this.zzc;
    }

    public final /* synthetic */ zzbd zzf() {
        return this.zzd;
    }

    public final /* synthetic */ zzdz zzg() {
        return this.zze;
    }
}
