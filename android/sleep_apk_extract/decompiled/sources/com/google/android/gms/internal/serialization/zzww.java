package com.google.android.gms.internal.serialization;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzww implements zzabd {
    private final zzwv zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzww(zzwv zzwvVar) {
        zzzt.zza(zzwvVar, "input");
        this.zza = zzwvVar;
        zzwvVar.zzd = this;
    }

    private final void zzS(int i) throws zzzu {
        if ((this.zzb & 7) == i) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m();
    }

    private final void zzT(Object obj, zzabe zzabeVar, zzyp zzypVar) throws zzzv {
        zzwv zzwvVar = this.zza;
        int iZzr = zzwvVar.zzr();
        if (zzwvVar.zzb >= zzwvVar.zzc) {
            Gson$$ExternalSyntheticBUOutline0.m("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return;
        }
        int iZzC = zzwvVar.zzC(iZzr);
        this.zza.zzb++;
        zzabeVar.zzg(obj, this, zzypVar);
        this.zza.zzb(0);
        r4.zzb--;
        this.zza.zzD(iZzC);
    }

    private final Object zzU(zzabe zzabeVar, zzyp zzypVar) throws zzzv {
        Object objZza = zzabeVar.zza();
        zzT(objZza, zzabeVar, zzypVar);
        zzabeVar.zzk(objZza);
        return objZza;
    }

    private final void zzV(Object obj, zzabe zzabeVar, zzyp zzypVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzabeVar.zzg(obj, this, zzypVar);
            if (this.zzb == this.zzc) {
            } else {
                throw new zzzv("Failed to parse the message.");
            }
        } finally {
            this.zzc = i;
        }
    }

    private final Object zzW(zzabe zzabeVar, zzyp zzypVar) {
        Object objZza = zzabeVar.zza();
        zzV(objZza, zzabeVar, zzypVar);
        zzabeVar.zzk(objZza);
        return objZza;
    }

    private final Object zzX(zzace zzaceVar, Class cls, zzyp zzypVar) {
        zzace zzaceVar2 = zzace.zza;
        switch (zzaceVar.ordinal()) {
            case 0:
                return Double.valueOf(zze());
            case 1:
                return Float.valueOf(zzf());
            case 2:
                return Long.valueOf(zzh());
            case 3:
                return Long.valueOf(zzg());
            case 4:
                return Integer.valueOf(zzi());
            case 5:
                return Long.valueOf(zzj());
            case 6:
                return Integer.valueOf(zzk());
            case 7:
                return Boolean.valueOf(zzl());
            case 8:
                return zzn();
            case 9:
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$2("unsupported field type.");
                return null;
            case 10:
                return zzo(cls, zzypVar);
            case 11:
                return zzs();
            case 12:
                return Integer.valueOf(zzt());
            case 13:
                return Integer.valueOf(zzu());
            case 14:
                return Integer.valueOf(zzv());
            case 15:
                return Long.valueOf(zzw());
            case 16:
                return Integer.valueOf(zzx());
            case 17:
                return Long.valueOf(zzy());
        }
    }

    private final void zzY(int i) throws zzzv {
        if (this.zza.zzG() == i) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    private static final void zzZ(int i) throws zzzv {
        if ((i & 3) == 0) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Failed to parse the message.");
    }

    public static zzww zza(zzwv zzwvVar) {
        zzww zzwwVar = zzwvVar.zzd;
        return zzwwVar != null ? zzwwVar : new zzww(zzwvVar);
    }

    private static final void zzaa(int i) throws zzzv {
        if ((i & 7) == 0) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Failed to parse the message.");
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzA(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzyw;
        int i = this.zzb;
        if (z) {
            zzyw zzywVar = (zzyw) list;
            int i2 = i & 7;
            if (i2 == 2) {
                int iZzr = this.zza.zzr();
                zzZ(iZzr);
                int iZzG = this.zza.zzG() + iZzr;
                do {
                    zzywVar.zzg(this.zza.zze());
                } while (this.zza.zzG() < iZzG);
                return;
            }
            if (i2 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m();
                return;
            }
            do {
                zzywVar.zzg(this.zza.zze());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 == 2) {
                int iZzr2 = this.zza.zzr();
                zzZ(iZzr2);
                int iZzG2 = this.zza.zzG() + iZzr2;
                do {
                    list.add(Float.valueOf(this.zza.zze()));
                } while (this.zza.zzG() < iZzG2);
                return;
            }
            if (i3 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m();
                return;
            }
            do {
                list.add(Float.valueOf(this.zza.zze()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzB(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaae;
        int i = this.zzb;
        if (z) {
            zzaae zzaaeVar = (zzaae) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar = this.zza;
                int iZzG = zzwvVar.zzG() + zzwvVar.zzr();
                do {
                    zzaaeVar.zzd(this.zza.zzf());
                } while (this.zza.zzG() < iZzG);
                zzY(iZzG);
                return;
            }
            do {
                zzaaeVar.zzd(this.zza.zzf());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar2 = this.zza;
                int iZzG2 = zzwvVar2.zzG() + zzwvVar2.zzr();
                do {
                    list.add(Long.valueOf(this.zza.zzf()));
                } while (this.zza.zzG() < iZzG2);
                zzY(iZzG2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzf()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzC(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaae;
        int i = this.zzb;
        if (z) {
            zzaae zzaaeVar = (zzaae) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar = this.zza;
                int iZzG = zzwvVar.zzG() + zzwvVar.zzr();
                do {
                    zzaaeVar.zzd(this.zza.zzg());
                } while (this.zza.zzG() < iZzG);
                zzY(iZzG);
                return;
            }
            do {
                zzaaeVar.zzd(this.zza.zzg());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar2 = this.zza;
                int iZzG2 = zzwvVar2.zzG() + zzwvVar2.zzr();
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                } while (this.zza.zzG() < iZzG2);
                zzY(iZzG2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzg()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzD(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzzh;
        int i = this.zzb;
        if (z) {
            zzzh zzzhVar = (zzzh) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar = this.zza;
                int iZzG = zzwvVar.zzG() + zzwvVar.zzr();
                do {
                    zzzhVar.zzi(this.zza.zzh());
                } while (this.zza.zzG() < iZzG);
                zzY(iZzG);
                return;
            }
            do {
                zzzhVar.zzi(this.zza.zzh());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar2 = this.zza;
                int iZzG2 = zzwvVar2.zzG() + zzwvVar2.zzr();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzG() < iZzG2);
                zzY(iZzG2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzE(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaae;
        int i = this.zzb;
        if (z) {
            zzaae zzaaeVar = (zzaae) list;
            int i2 = i & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                int iZzr = this.zza.zzr();
                zzaa(iZzr);
                int iZzG = this.zza.zzG() + iZzr;
                do {
                    zzaaeVar.zzd(this.zza.zzi());
                } while (this.zza.zzG() < iZzG);
                return;
            }
            do {
                zzaaeVar.zzd(this.zza.zzi());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                int iZzr2 = this.zza.zzr();
                zzaa(iZzr2);
                int iZzG2 = this.zza.zzG() + iZzr2;
                do {
                    list.add(Long.valueOf(this.zza.zzi()));
                } while (this.zza.zzG() < iZzG2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzi()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzF(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzzh;
        int i = this.zzb;
        if (z) {
            zzzh zzzhVar = (zzzh) list;
            int i2 = i & 7;
            if (i2 == 2) {
                int iZzr = this.zza.zzr();
                zzZ(iZzr);
                int iZzG = this.zza.zzG() + iZzr;
                do {
                    zzzhVar.zzi(this.zza.zzj());
                } while (this.zza.zzG() < iZzG);
                return;
            }
            if (i2 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m();
                return;
            }
            do {
                zzzhVar.zzi(this.zza.zzj());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 == 2) {
                int iZzr2 = this.zza.zzr();
                zzZ(iZzr2);
                int iZzG2 = this.zza.zzG() + iZzr2;
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzG() < iZzG2);
                return;
            }
            if (i3 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m();
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzG(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzwi;
        int i = this.zzb;
        if (z) {
            zzwi zzwiVar = (zzwi) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar = this.zza;
                int iZzG = zzwvVar.zzG() + zzwvVar.zzr();
                do {
                    zzwiVar.zzg(this.zza.zzk());
                } while (this.zza.zzG() < iZzG);
                zzY(iZzG);
                return;
            }
            do {
                zzwiVar.zzg(this.zza.zzk());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar2 = this.zza;
                int iZzG2 = zzwvVar2.zzG() + zzwvVar2.zzr();
                do {
                    list.add(Boolean.valueOf(this.zza.zzk()));
                } while (this.zza.zzG() < iZzG2);
                zzY(iZzG2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzk()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzH(List list, boolean z) throws zzzu {
        int iZza;
        int iZza2;
        if ((this.zzb & 7) != 2) {
            Gson$$ExternalSyntheticBUOutline0.m();
            return;
        }
        if ((list instanceof zzaab) && !z) {
            zzaab zzaabVar = (zzaab) list;
            do {
                zzs();
                zzaabVar.zzb();
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            do {
                list.add(z ? zzn() : zzm());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzI(List list, zzabe zzabeVar, zzyp zzypVar) throws zzzu {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            Gson$$ExternalSyntheticBUOutline0.m();
            return;
        }
        do {
            list.add(zzU(zzabeVar, zzypVar));
            if (this.zza.zzF() || this.zzd != 0) {
                return;
            } else {
                iZza = this.zza.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    @Deprecated
    public final void zzJ(List list, zzabe zzabeVar, zzyp zzypVar) throws zzzu {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            Gson$$ExternalSyntheticBUOutline0.m();
            return;
        }
        do {
            list.add(zzW(zzabeVar, zzypVar));
            if (this.zza.zzF() || this.zzd != 0) {
                return;
            } else {
                iZza = this.zza.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzK(List list) throws zzzu {
        int iZza;
        if ((this.zzb & 7) != 2) {
            Gson$$ExternalSyntheticBUOutline0.m();
            return;
        }
        do {
            list.add(zzs());
            if (this.zza.zzF()) {
                return;
            } else {
                iZza = this.zza.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzL(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzzh;
        int i = this.zzb;
        if (z) {
            zzzh zzzhVar = (zzzh) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar = this.zza;
                int iZzG = zzwvVar.zzG() + zzwvVar.zzr();
                do {
                    zzzhVar.zzi(this.zza.zzr());
                } while (this.zza.zzG() < iZzG);
                zzY(iZzG);
                return;
            }
            do {
                zzzhVar.zzi(this.zza.zzr());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar2 = this.zza;
                int iZzG2 = zzwvVar2.zzG() + zzwvVar2.zzr();
                do {
                    list.add(Integer.valueOf(this.zza.zzr()));
                } while (this.zza.zzG() < iZzG2);
                zzY(iZzG2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzr()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzM(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzzh;
        int i = this.zzb;
        if (z) {
            zzzh zzzhVar = (zzzh) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar = this.zza;
                int iZzG = zzwvVar.zzG() + zzwvVar.zzr();
                do {
                    zzzhVar.zzi(this.zza.zzs());
                } while (this.zza.zzG() < iZzG);
                zzY(iZzG);
                return;
            }
            do {
                zzzhVar.zzi(this.zza.zzs());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar2 = this.zza;
                int iZzG2 = zzwvVar2.zzG() + zzwvVar2.zzr();
                do {
                    list.add(Integer.valueOf(this.zza.zzs()));
                } while (this.zza.zzG() < iZzG2);
                zzY(iZzG2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzs()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzN(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzzh;
        int i = this.zzb;
        if (z) {
            zzzh zzzhVar = (zzzh) list;
            int i2 = i & 7;
            if (i2 == 2) {
                int iZzr = this.zza.zzr();
                zzZ(iZzr);
                int iZzG = this.zza.zzG() + iZzr;
                do {
                    zzzhVar.zzi(this.zza.zzt());
                } while (this.zza.zzG() < iZzG);
                return;
            }
            if (i2 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m();
                return;
            }
            do {
                zzzhVar.zzi(this.zza.zzt());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 == 2) {
                int iZzr2 = this.zza.zzr();
                zzZ(iZzr2);
                int iZzG2 = this.zza.zzG() + iZzr2;
                do {
                    list.add(Integer.valueOf(this.zza.zzt()));
                } while (this.zza.zzG() < iZzG2);
                return;
            }
            if (i3 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m();
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzt()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzO(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaae;
        int i = this.zzb;
        if (z) {
            zzaae zzaaeVar = (zzaae) list;
            int i2 = i & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                int iZzr = this.zza.zzr();
                zzaa(iZzr);
                int iZzG = this.zza.zzG() + iZzr;
                do {
                    zzaaeVar.zzd(this.zza.zzu());
                } while (this.zza.zzG() < iZzG);
                return;
            }
            do {
                zzaaeVar.zzd(this.zza.zzu());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                int iZzr2 = this.zza.zzr();
                zzaa(iZzr2);
                int iZzG2 = this.zza.zzG() + iZzr2;
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzG() < iZzG2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzP(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzzh;
        int i = this.zzb;
        if (z) {
            zzzh zzzhVar = (zzzh) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar = this.zza;
                int iZzG = zzwvVar.zzG() + zzwvVar.zzr();
                do {
                    zzzhVar.zzi(this.zza.zzv());
                } while (this.zza.zzG() < iZzG);
                zzY(iZzG);
                return;
            }
            do {
                zzzhVar.zzi(this.zza.zzv());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar2 = this.zza;
                int iZzG2 = zzwvVar2.zzG() + zzwvVar2.zzr();
                do {
                    list.add(Integer.valueOf(this.zza.zzv()));
                } while (this.zza.zzG() < iZzG2);
                zzY(iZzG2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzv()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzQ(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaae;
        int i = this.zzb;
        if (z) {
            zzaae zzaaeVar = (zzaae) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar = this.zza;
                int iZzG = zzwvVar.zzG() + zzwvVar.zzr();
                do {
                    zzaaeVar.zzd(this.zza.zzw());
                } while (this.zza.zzG() < iZzG);
                zzY(iZzG);
                return;
            }
            do {
                zzaaeVar.zzd(this.zza.zzw());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                zzwv zzwvVar2 = this.zza;
                int iZzG2 = zzwvVar2.zzG() + zzwvVar2.zzr();
                do {
                    list.add(Long.valueOf(this.zza.zzw()));
                } while (this.zza.zzG() < iZzG2);
                zzY(iZzG2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzw()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r8.put(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r7.zza.zzD(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        return;
     */
    @Override // com.google.android.gms.internal.serialization.zzabd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzR(Map map, zzaai zzaaiVar, zzyp zzypVar) throws zzzu {
        zzS(2);
        zzwv zzwvVar = this.zza;
        int iZzC = zzwvVar.zzC(zzwvVar.zzr());
        Object objZzX = zzaaiVar.zzd;
        Object objZzX2 = zzaaiVar.zzb;
        while (true) {
            try {
                int iZzb = zzb();
                if (iZzb == Integer.MAX_VALUE || this.zza.zzF()) {
                    break;
                }
                if (iZzb == 1) {
                    objZzX2 = zzX(zzaaiVar.zza, null, null);
                } else if (iZzb != 2) {
                    try {
                        if (!zzd()) {
                            throw new zzzv("Unable to parse map entry.");
                        }
                    } catch (zzzu unused) {
                        if (!zzd()) {
                            throw new zzzv("Unable to parse map entry.");
                        }
                    }
                } else {
                    objZzX = zzX(zzaaiVar.zzc, zzaaiVar.zzd.getClass(), zzypVar);
                }
            } catch (Throwable th) {
                this.zza.zzD(iZzC);
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final int zzb() {
        int iZza = this.zzd;
        if (iZza != 0) {
            this.zzb = iZza;
            this.zzd = 0;
        } else {
            iZza = this.zza.zza();
            this.zzb = iZza;
        }
        if (iZza == 0 || iZza == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZza >>> 3;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final int zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final boolean zzd() {
        int i;
        if (this.zza.zzF() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzc(i);
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final double zze() throws zzzu {
        zzS(1);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final float zzf() throws zzzu {
        zzS(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final long zzg() throws zzzu {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final long zzh() throws zzzu {
        zzS(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final int zzi() throws zzzu {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final long zzj() throws zzzu {
        zzS(1);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final int zzk() throws zzzu {
        zzS(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final boolean zzl() throws zzzu {
        zzS(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final String zzm() throws zzzu {
        zzS(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final String zzn() throws zzzu {
        zzS(2);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final Object zzo(Class cls, zzyp zzypVar) throws zzzu {
        zzS(2);
        return zzU(zzaba.zza().zzb(cls), zzypVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    @Deprecated
    public final Object zzp(Class cls, zzyp zzypVar) throws zzzu {
        zzS(3);
        return zzW(zzaba.zza().zzb(cls), zzypVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzq(Object obj, zzabe zzabeVar, zzyp zzypVar) throws zzzv {
        zzS(2);
        zzT(obj, zzabeVar, zzypVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzr(Object obj, zzabe zzabeVar, zzyp zzypVar) throws zzzu {
        zzS(3);
        zzV(obj, zzabeVar, zzypVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final zzwr zzs() throws zzzu {
        zzS(2);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final int zzt() throws zzzu {
        zzS(0);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final int zzu() throws zzzu {
        zzS(0);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final int zzv() throws zzzu {
        zzS(5);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final long zzw() throws zzzu {
        zzS(1);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final int zzx() throws zzzu {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final long zzy() throws zzzu {
        zzS(0);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.serialization.zzabd
    public final void zzz(List list) throws zzzv {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzyj;
        int i = this.zzb;
        if (z) {
            zzyj zzyjVar = (zzyj) list;
            int i2 = i & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                int iZzr = this.zza.zzr();
                zzaa(iZzr);
                int iZzG = this.zza.zzG() + iZzr;
                do {
                    zzyjVar.zzg(this.zza.zzd());
                } while (this.zza.zzG() < iZzG);
                return;
            }
            do {
                zzyjVar.zzg(this.zza.zzd());
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza2 = this.zza.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                int iZzr2 = this.zza.zzr();
                zzaa(iZzr2);
                int iZzG2 = this.zza.zzG() + iZzr2;
                do {
                    list.add(Double.valueOf(this.zza.zzd()));
                } while (this.zza.zzG() < iZzG2);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zzd()));
                if (this.zza.zzF()) {
                    return;
                } else {
                    iZza = this.zza.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }
}
