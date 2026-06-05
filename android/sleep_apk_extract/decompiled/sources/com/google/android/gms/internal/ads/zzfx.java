package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfx extends zzfz {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzfx(int i, long j) {
        super(i, null);
        this.zza = j;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final String toString() {
        List list = this.zzb;
        String strZze = zzfz.zze(this.zzd);
        String string = Arrays.toString(list.toArray());
        String string2 = Arrays.toString(this.zzc.toArray());
        int length = strZze.length();
        StringBuilder sb = new StringBuilder(length + 9 + String.valueOf(string).length() + 13 + String.valueOf(string2).length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, strZze, " leaves: ", string, " containers: ");
        sb.append(string2);
        return sb.toString();
    }

    public final void zza(zzfy zzfyVar) {
        this.zzb.add(zzfyVar);
    }

    public final void zzb(zzfx zzfxVar) {
        this.zzc.add(zzfxVar);
    }

    public final zzfy zzc(int i) {
        List list = this.zzb;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzfy zzfyVar = (zzfy) list.get(i2);
            if (zzfyVar.zzd == i) {
                return zzfyVar;
            }
        }
        return null;
    }

    public final zzfx zzd(int i) {
        List list = this.zzc;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzfx zzfxVar = (zzfx) list.get(i2);
            if (zzfxVar.zzd == i) {
                return zzfxVar;
            }
        }
        return null;
    }
}
