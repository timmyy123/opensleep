package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaeo extends zzyy implements zzaar {
    public /* synthetic */ zzaeo(byte[] bArr) {
        super(zzaep.zzg);
    }

    public final zzaeo zza(String str) {
        copyOnWrite();
        ((zzaep) this.instance).zzh(str);
        return this;
    }

    @Deprecated
    public final zzaeo zzb(String str) {
        copyOnWrite();
        ((zzaep) this.instance).zzi(str);
        return this;
    }

    public final zzaeo zzc(long j) {
        copyOnWrite();
        ((zzaep) this.instance).zzj(j);
        return this;
    }

    public final zzaeo zzd(zzwe zzweVar) {
        copyOnWrite();
        ((zzaep) this.instance).zzk(zzweVar);
        return this;
    }
}
