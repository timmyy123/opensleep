package com.google.android.gms.internal.measurement;

import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbh extends zzav {
    public zzbh() {
        this.zza.add(zzbk.ADD);
        this.zza.add(zzbk.DIVIDE);
        this.zza.add(zzbk.MODULUS);
        this.zza.add(zzbk.MULTIPLY);
        this.zza.add(zzbk.NEGATE);
        this.zza.add(zzbk.POST_DECREMENT);
        this.zza.add(zzbk.POST_INCREMENT);
        this.zza.add(zzbk.PRE_DECREMENT);
        this.zza.add(zzbk.PRE_INCREMENT);
        this.zza.add(zzbk.SUBTRACT);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzbk zzbkVar = zzbk.ADD;
        int iOrdinal = zzh.zze(str).ordinal();
        if (iOrdinal == 0) {
            zzao zzaoVarZza = zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.ADD, 2, list, 0));
            zzao zzaoVarZza2 = zzgVar.zza((zzao) list.get(1));
            if (!(zzaoVarZza instanceof zzak) && !(zzaoVarZza instanceof zzas) && !(zzaoVarZza2 instanceof zzak) && !(zzaoVarZza2 instanceof zzas)) {
                return new zzah(Double.valueOf(zzaoVarZza2.zzd().doubleValue() + zzaoVarZza.zzd().doubleValue()));
            }
            return new zzas(String.valueOf(zzaoVarZza.zzc()).concat(String.valueOf(zzaoVarZza2.zzc())));
        }
        if (iOrdinal == 21) {
            return new zzah(Double.valueOf(zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.DIVIDE, 2, list, 0)).zzd().doubleValue() / zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
        }
        if (iOrdinal == 59) {
            zzao zzaoVarZza3 = zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.SUBTRACT, 2, list, 0));
            zzah zzahVar = new zzah(Double.valueOf(-zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
            return new zzah(Double.valueOf(zzahVar.zzd().doubleValue() + zzaoVarZza3.zzd().doubleValue()));
        }
        if (iOrdinal == 52 || iOrdinal == 53) {
            zzh.zza(str, 2, list);
            zzao zzaoVarZza4 = zzgVar.zza((zzao) list.get(0));
            zzgVar.zza((zzao) list.get(1));
            return zzaoVarZza4;
        }
        if (iOrdinal == 55 || iOrdinal == 56) {
            zzh.zza(str, 1, list);
            return zzgVar.zza((zzao) list.get(0));
        }
        switch (iOrdinal) {
            case 44:
                return new zzah(Double.valueOf(zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.MODULUS, 2, list, 0)).zzd().doubleValue() % zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
            case 45:
                return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue() * zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.MULTIPLY, 2, list, 0)).zzd().doubleValue()));
            case 46:
                return new zzah(Double.valueOf(-zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.NEGATE, 1, list, 0)).zzd().doubleValue()));
            default:
                return zzb(str);
        }
    }
}
