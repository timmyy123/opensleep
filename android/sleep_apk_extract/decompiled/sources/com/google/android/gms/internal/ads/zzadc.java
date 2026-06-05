package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadc {
    private final Context zza;
    private boolean zzb;
    private zzvv zzc = zzvv.zzb;
    private final zzvh zzd;
    private Handler zze;
    private zzaep zzf;

    public zzadc(Context context) {
        this.zza = context;
        this.zzd = new zzvb(context, null, null);
    }

    public final zzadc zza(zzvv zzvvVar) {
        this.zzc = zzvvVar;
        return this;
    }

    public final zzadc zzb(Handler handler) {
        this.zze = handler;
        return this;
    }

    public final zzadc zzc(zzaep zzaepVar) {
        this.zzf = zzaepVar;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzade zzd() {
        boolean z;
        zzgtj.zzi(!this.zzb);
        Handler handler = this.zze;
        if (handler != null || this.zzf != null) {
            z = false;
            if (handler != null && this.zzf != null) {
                z = true;
            }
        }
        zzgtj.zzi(z);
        this.zzb = true;
        return new zzade(this);
    }

    public final /* synthetic */ Context zze() {
        return this.zza;
    }

    public final /* synthetic */ zzvv zzf() {
        return this.zzc;
    }

    public final /* synthetic */ zzvh zzg() {
        return this.zzd;
    }

    public final /* synthetic */ Handler zzh() {
        return this.zze;
    }

    public final /* synthetic */ zzaep zzi() {
        return this.zzf;
    }
}
