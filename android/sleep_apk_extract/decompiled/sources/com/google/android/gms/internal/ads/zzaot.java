package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaot implements zzanl {
    private final zzet zza = new zzet();

    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        zzcx zzcxVarZzr;
        zzet zzetVar = this.zza;
        zzetVar.zzb(bArr, i2 + i);
        zzetVar.zzh(i);
        ArrayList arrayList = new ArrayList();
        while (zzetVar.zzd() > 0) {
            zzgtj.zzb(zzetVar.zzd() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iZzB = zzetVar.zzB() - 8;
            if (zzetVar.zzB() == 1987343459) {
                CharSequence charSequenceZzc = null;
                zzcw zzcwVarZzb = null;
                while (iZzB > 0) {
                    zzgtj.zzb(iZzB >= 8, "Incomplete vtt cue box header found.");
                    int iZzB2 = zzetVar.zzB();
                    int iZzB3 = zzetVar.zzB();
                    int i3 = iZzB - 8;
                    int i4 = iZzB2 - 8;
                    String strZzk = zzfl.zzk(zzetVar.zzi(), zzetVar.zzg(), i4);
                    zzetVar.zzk(i4);
                    if (iZzB3 == 1937011815) {
                        zzcwVarZzb = zzapc.zzb(strZzk);
                    } else if (iZzB3 == 1885436268) {
                        charSequenceZzc = zzapc.zzc(null, strZzk.trim(), Collections.EMPTY_LIST);
                    }
                    iZzB = i3 - i4;
                }
                if (charSequenceZzc == null) {
                    charSequenceZzc = "";
                }
                if (zzcwVarZzb != null) {
                    zzcwVarZzb.zza(charSequenceZzc);
                    zzcxVarZzr = zzcwVarZzb.zzr();
                } else {
                    Pattern pattern = zzapc.zza;
                    zzapb zzapbVar = new zzapb();
                    zzapbVar.zzc = charSequenceZzc;
                    zzcxVarZzr = zzapbVar.zza().zzr();
                }
                arrayList.add(zzcxVarZzr);
            } else {
                zzetVar.zzk(iZzB);
            }
        }
        zzdtVar.zza(new zzand(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
