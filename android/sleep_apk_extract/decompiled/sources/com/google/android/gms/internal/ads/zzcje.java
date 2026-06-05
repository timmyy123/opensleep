package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcje extends zzcja {
    public zzcje(zzchn zzchnVar) {
        super(zzchnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zze(String str) {
        String strZzg = com.google.android.gms.ads.internal.util.client.zzf.zzg(str);
        zzchn zzchnVar = (zzchn) this.zzc.get();
        if (zzchnVar != null && strZzg != null) {
            zzchnVar.zzt(strZzg, this);
        }
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("VideoStreamNoopCache is doing nothing.");
        zzq(str, strZzg, "noop", "Noop cache is a noop.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
    }
}
