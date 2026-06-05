package com.google.android.gms.internal.serialization;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzyr extends zzyq {
    @Override // com.google.android.gms.internal.serialization.zzyq
    public final void zza(Object obj) {
        ((zzzc) obj).extensions.zzb();
    }

    @Override // com.google.android.gms.internal.serialization.zzyq
    public final void zzb(zzach zzachVar, Map.Entry entry) {
        zzzd zzzdVar = (zzzd) entry.getKey();
        if (!zzzdVar.zzd) {
            zzace zzaceVar = zzace.zza;
            switch (zzzdVar.zzc.ordinal()) {
                case 0:
                    zzachVar.zzf(zzzdVar.zzb, ((Double) entry.getValue()).doubleValue());
                    break;
                case 1:
                    zzachVar.zze(zzzdVar.zzb, ((Float) entry.getValue()).floatValue());
                    break;
                case 2:
                    zzachVar.zzc(zzzdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case 3:
                    zzachVar.zzh(zzzdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    zzachVar.zzi(zzzdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 5:
                    zzachVar.zzj(zzzdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case 6:
                    zzachVar.zzk(zzzdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 7:
                    zzachVar.zzl(zzzdVar.zzb, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 8:
                    zzachVar.zzm(zzzdVar.zzb, (String) entry.getValue());
                    break;
                case 9:
                    zzachVar.zzs(zzzdVar.zzb, entry.getValue(), zzaba.zza().zzb(entry.getValue().getClass()));
                    break;
                case 10:
                    zzachVar.zzr(zzzdVar.zzb, entry.getValue(), zzaba.zza().zzb(entry.getValue().getClass()));
                    break;
                case 11:
                    zzachVar.zzn(zzzdVar.zzb, (zzwr) entry.getValue());
                    break;
                case 12:
                    zzachVar.zzo(zzzdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    zzachVar.zzi(zzzdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 14:
                    zzachVar.zzb(zzzdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    zzachVar.zzd(zzzdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case 16:
                    zzachVar.zzp(zzzdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 17:
                    zzachVar.zzq(zzzdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzace zzaceVar2 = zzace.zza;
        switch (zzzdVar.zzc.ordinal()) {
            case 0:
                zzabg.zza(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 1:
                zzabg.zzb(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 2:
                zzabg.zzc(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 3:
                zzabg.zzd(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 4:
                zzabg.zzh(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 5:
                zzabg.zzf(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 6:
                zzabg.zzk(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 7:
                zzabg.zzn(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 8:
                zzabg.zzo(zzzdVar.zzb, (List) entry.getValue(), zzachVar);
                break;
            case 9:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzabg.zzr(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzaba.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case 10:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzabg.zzq(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzaba.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case 11:
                zzabg.zzp(zzzdVar.zzb, (List) entry.getValue(), zzachVar);
                break;
            case 12:
                zzabg.zzi(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 13:
                zzabg.zzh(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 14:
                zzabg.zzl(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 15:
                zzabg.zzg(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 16:
                zzabg.zzj(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
            case 17:
                zzabg.zze(zzzdVar.zzb, (List) entry.getValue(), zzachVar, zzzdVar.zze);
                break;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzyq
    public final void zzc(zzabd zzabdVar, Object obj, zzyp zzypVar, zzyu zzyuVar) {
        zzze zzzeVar = (zzze) obj;
        zzyuVar.zzg(zzzeVar.zzd, zzabdVar.zzo(zzzeVar.zzc.getClass(), zzypVar));
    }
}
