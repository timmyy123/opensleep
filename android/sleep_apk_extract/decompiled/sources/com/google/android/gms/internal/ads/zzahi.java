package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzahi implements zzagb {
    private final long zzb;
    private final zzagb zzc;

    public zzahi(long j, zzagb zzagbVar) {
        this.zzb = j;
        this.zzc = zzagbVar;
    }

    public final /* synthetic */ long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final zzahk zzu(int i, int i2) {
        return this.zzc.zzu(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzv() {
        this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzw(zzahb zzahbVar) {
        this.zzc.zzw(new zzahh(this, zzahbVar, zzahbVar));
    }
}
