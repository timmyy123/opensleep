package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzacw extends zzyy implements zzaar {
    public /* synthetic */ zzacw(byte[] bArr) {
        super(zzacx.zzf);
    }

    public final zzacw zza(String str) {
        copyOnWrite();
        ((zzacx) this.instance).zzb(str);
        return this;
    }

    public final zzacw zzb(zzaep zzaepVar) {
        copyOnWrite();
        ((zzacx) this.instance).zzc(zzaepVar);
        return this;
    }

    public final zzacw zzc(boolean z) {
        copyOnWrite();
        ((zzacx) this.instance).zzd(z);
        return this;
    }
}
