package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzazk implements PackageManager$OnChecksumsReadyListener {
    final zzhcp zza = zzhcp.zze();

    public final void onChecksumsReady(List list) {
        int size;
        int i;
        if (list == null) {
            this.zza.zza("");
            return;
        }
        try {
            size = list.size();
        } catch (Throwable unused) {
        }
        for (i = 0; i < size; i++) {
            ApkChecksum apkChecksumM = zzbuy$$ExternalSyntheticBUOutline0.m(list.get(i));
            if (apkChecksumM.getType() == 8) {
                zzhcp zzhcpVar = this.zza;
                zzgzh zzgzhVarZzi = zzgzh.zzn().zzi();
                byte[] value = apkChecksumM.getValue();
                zzhcpVar.zza(zzgzhVarZzi.zzj(value, 0, value.length));
                return;
            }
            this.zza.zza("");
        }
        this.zza.zza("");
    }
}
