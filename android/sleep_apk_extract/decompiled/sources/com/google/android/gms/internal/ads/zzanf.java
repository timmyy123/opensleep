package com.google.android.gms.internal.ads;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzanf {
    public static void zza(zzang zzangVar, zzank zzankVar, zzdt zzdtVar) {
        for (int i = 0; i < zzangVar.zza(); i++) {
            long jZzb = zzangVar.zzb(i);
            List listZzc = zzangVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i == zzangVar.zza() - 1) {
                    Home$$ExternalSyntheticBUOutline0.m$2();
                    return;
                } else {
                    long jZzb2 = zzangVar.zzb(i + 1) - zzangVar.zzb(i);
                    if (jZzb2 > 0) {
                        zzdtVar.zza(new zzand(listZzc, jZzb, jZzb2));
                    }
                }
            }
        }
    }
}
