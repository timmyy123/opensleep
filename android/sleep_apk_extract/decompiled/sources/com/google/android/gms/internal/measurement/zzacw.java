package com.google.android.gms.internal.measurement;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzacw implements zzafo {
    private final zzacv zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzacw(zzacv zzacvVar) {
        this.zza = zzacvVar;
        zzacvVar.zzd = this;
    }

    private final void zzQ(int i) throws zzaeg {
        if ((this.zzb & 7) == i) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1();
    }

    private final void zzR(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws zzaeh {
        zzacv zzacvVar = this.zza;
        int iZzp = zzacvVar.zzp();
        zzacvVar.zzO();
        int iZzD = zzacvVar.zzD(iZzp);
        zzacvVar.zza++;
        zzafpVar.zzg(obj, this, zzadfVar);
        zzacvVar.zzb(0);
        zzacvVar.zza--;
        zzacvVar.zzE(iZzD);
    }

    private final Object zzS(zzafp zzafpVar, zzadf zzadfVar) throws zzaeh {
        Object objZza = zzafpVar.zza();
        zzR(objZza, zzafpVar, zzadfVar);
        zzafpVar.zzk(objZza);
        return objZza;
    }

    private final void zzT(Object obj, zzafp zzafpVar, zzadf zzadfVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzafpVar.zzg(obj, this, zzadfVar);
            if (this.zzb == this.zzc) {
            } else {
                throw new zzaeh("Failed to parse the message.");
            }
        } finally {
            this.zzc = i;
        }
    }

    private final Object zzU(zzagm zzagmVar, Class cls, zzadf zzadfVar) throws zzaeg {
        zzagm zzagmVar2 = zzagm.zza;
        switch (zzagmVar.ordinal()) {
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
                zzQ(2);
                return zzS(zzafl.zza().zzb(cls), zzadfVar);
            case 11:
                return zzq();
            case 12:
                return Integer.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Integer.valueOf(zzt());
            case 15:
                return Long.valueOf(zzu());
            case 16:
                return Integer.valueOf(zzv());
            case 17:
                return Long.valueOf(zzw());
        }
    }

    private final void zzV(int i) throws zzaeh {
        if (this.zza.zzH() == i) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    private static final void zzW(int i) throws zzaeh {
        if ((i & 3) == 0) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1("Failed to parse the message.");
    }

    private static final void zzX(int i) throws zzaeh {
        if ((i & 7) == 0) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1("Failed to parse the message.");
    }

    public static zzacw zza(zzacv zzacvVar) {
        Object obj = zzacvVar.zzd;
        return obj != null ? (zzacw) obj : new zzacw(zzacvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzA(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaeq;
        int i = this.zzb;
        if (z) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzg());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzg());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzg()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzg()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzB(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzadv;
        int i = this.zzb;
        if (z) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzh());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzh());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzh()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzh()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzC(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaeq;
        int i = this.zzb;
        if (z) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = i & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzX(iZzp);
                int iZzH = zzacvVar.zzH() + iZzp;
                do {
                    zzaeqVar.zzf(zzacvVar.zzi());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzi());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzX(iZzp2);
                int iZzH2 = zzacvVar3.zzH() + iZzp2;
                do {
                    list.add(Long.valueOf(zzacvVar3.zzi()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzi()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzD(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzadv;
        int i = this.zzb;
        if (z) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = i & 7;
            if (i2 == 2) {
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzW(iZzp);
                int iZzH = zzacvVar.zzH() + iZzp;
                do {
                    zzadvVar.zzh(zzacvVar.zzj());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            if (i2 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzj());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 == 2) {
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzW(iZzp2);
                int iZzH2 = zzacvVar3.zzH() + iZzp2;
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzj()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            if (i3 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzj()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzE(List list) throws zzaeh {
        int iZza;
        if (list instanceof zzaci) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i = this.zzb & 7;
        if (i == 0) {
            do {
                zzacv zzacvVar = this.zza;
                list.add(Boolean.valueOf(zzacvVar.zzk()));
                if (zzacvVar.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i != 2) {
            Gson$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        zzacv zzacvVar2 = this.zza;
        int iZzH = zzacvVar2.zzH() + zzacvVar2.zzp();
        do {
            list.add(Boolean.valueOf(zzacvVar2.zzk()));
        } while (zzacvVar2.zzH() < iZzH);
        zzV(iZzH);
    }

    public final void zzF(List list, boolean z) throws zzaeg {
        int iZza;
        int iZza2;
        if ((this.zzb & 7) != 2) {
            Gson$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        if ((list instanceof zzaen) && !z) {
            zzaen zzaenVar = (zzaen) list;
            do {
                zzq();
                zzaenVar.zzb();
                zzacv zzacvVar = this.zza;
                if (zzacvVar.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            do {
                list.add(z ? zzn() : zzm());
                zzacv zzacvVar2 = this.zza;
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar2.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzG(List list, zzafp zzafpVar, zzadf zzadfVar) throws zzaeg {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            Gson$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        do {
            list.add(zzS(zzafpVar, zzadfVar));
            zzacv zzacvVar = this.zza;
            if (zzacvVar.zzG() || this.zzd != 0) {
                return;
            } else {
                iZza = zzacvVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    @Deprecated
    public final void zzH(List list, zzafp zzafpVar, zzadf zzadfVar) throws zzaeg {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            Gson$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        do {
            Object objZza = zzafpVar.zza();
            zzT(objZza, zzafpVar, zzadfVar);
            zzafpVar.zzk(objZza);
            list.add(objZza);
            zzacv zzacvVar = this.zza;
            if (zzacvVar.zzG() || this.zzd != 0) {
                return;
            } else {
                iZza = zzacvVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzI(List list) throws zzaeg {
        int iZza;
        if ((this.zzb & 7) != 2) {
            Gson$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        do {
            list.add(zzq());
            zzacv zzacvVar = this.zza;
            if (zzacvVar.zzG()) {
                return;
            } else {
                iZza = zzacvVar.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzJ(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzadv;
        int i = this.zzb;
        if (z) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzp());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzp());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzp()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzp()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzK(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzadv;
        int i = this.zzb;
        if (z) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzq());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzq());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzq()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzq()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzL(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzadv;
        int i = this.zzb;
        if (z) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = i & 7;
            if (i2 == 2) {
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzW(iZzp);
                int iZzH = zzacvVar.zzH() + iZzp;
                do {
                    zzadvVar.zzh(zzacvVar.zzr());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            if (i2 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzr());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 == 2) {
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzW(iZzp2);
                int iZzH2 = zzacvVar3.zzH() + iZzp2;
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzr()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            if (i3 != 5) {
                Gson$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzr()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzM(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaeq;
        int i = this.zzb;
        if (z) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = i & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzp = zzacvVar.zzp();
                zzX(iZzp);
                int iZzH = zzacvVar.zzH() + iZzp;
                do {
                    zzaeqVar.zzf(zzacvVar.zzs());
                } while (zzacvVar.zzH() < iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzs());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzp2 = zzacvVar3.zzp();
                zzX(iZzp2);
                int iZzH2 = zzacvVar3.zzH() + iZzp2;
                do {
                    list.add(Long.valueOf(zzacvVar3.zzs()));
                } while (zzacvVar3.zzH() < iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzs()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzN(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzadv;
        int i = this.zzb;
        if (z) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzt());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzt());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzt()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzt()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzO(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaeq;
        int i = this.zzb;
        if (z) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzu());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzu());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzu()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzu()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        r10.put(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        r9.zza.zzE(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        return;
     */
    @Override // com.google.android.gms.internal.measurement.zzafo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzP(Map map, zzaeu zzaeuVar, zzadf zzadfVar) throws zzaeg {
        zzQ(2);
        zzacv zzacvVar = this.zza;
        int iZzD = zzacvVar.zzD(zzacvVar.zzp());
        Object obj = zzaeuVar.zzd;
        Object objZzU = zzaeuVar.zzb;
        Object objZzU2 = obj;
        while (true) {
            try {
                int iZzb = zzb();
                if (iZzb == Integer.MAX_VALUE || zzacvVar.zzG()) {
                    break;
                }
                if (iZzb == 1) {
                    objZzU = zzU(zzaeuVar.zza, null, null);
                } else if (iZzb != 2) {
                    try {
                        if (!zzd()) {
                            throw new zzaeh("Unable to parse map entry.");
                        }
                    } catch (zzaeg e) {
                        if (!zzd()) {
                            throw new zzaeh("Unable to parse map entry.", e);
                        }
                    }
                } else {
                    objZzU2 = zzU(zzaeuVar.zzc, obj.getClass(), zzadfVar);
                }
            } catch (Throwable th) {
                this.zza.zzE(iZzD);
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
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

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        int i;
        zzacv zzacvVar = this.zza;
        if (zzacvVar.zzG() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return zzacvVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final double zze() throws zzaeg {
        zzQ(1);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final float zzf() throws zzaeg {
        zzQ(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzg() throws zzaeg {
        zzQ(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzh() throws zzaeg {
        zzQ(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzi() throws zzaeg {
        zzQ(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzj() throws zzaeg {
        zzQ(1);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzk() throws zzaeg {
        zzQ(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final boolean zzl() throws zzaeg {
        zzQ(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final String zzm() throws zzaeg {
        zzQ(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final String zzn() throws zzaeg {
        zzQ(2);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzo(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws zzaeh {
        zzQ(2);
        zzR(obj, zzafpVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzp(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws zzaeg {
        zzQ(3);
        zzT(obj, zzafpVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final zzacr zzq() throws zzaeg {
        zzQ(2);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzr() throws zzaeg {
        zzQ(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzs() throws zzaeg {
        zzQ(0);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzt() throws zzaeg {
        zzQ(5);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzu() throws zzaeg {
        zzQ(1);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzv() throws zzaeg {
        zzQ(0);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzw() throws zzaeg {
        zzQ(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzx(List list) throws zzaeh {
        int iZza;
        if (list instanceof zzadc) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i = this.zzb & 7;
        if (i == 1) {
            do {
                zzacv zzacvVar = this.zza;
                list.add(Double.valueOf(zzacvVar.zzd()));
                if (zzacvVar.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i != 2) {
            Gson$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        zzacv zzacvVar2 = this.zza;
        int iZzp = zzacvVar2.zzp();
        zzX(iZzp);
        int iZzH = zzacvVar2.zzH() + iZzp;
        do {
            list.add(Double.valueOf(zzacvVar2.zzd()));
        } while (zzacvVar2.zzH() < iZzH);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzy(List list) throws zzaeh {
        int iZza;
        if (list instanceof zzadm) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i = this.zzb & 7;
        if (i == 2) {
            zzacv zzacvVar = this.zza;
            int iZzp = zzacvVar.zzp();
            zzW(iZzp);
            int iZzH = zzacvVar.zzH() + iZzp;
            do {
                list.add(Float.valueOf(zzacvVar.zze()));
            } while (zzacvVar.zzH() < iZzH);
            return;
        }
        if (i != 5) {
            Gson$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        do {
            zzacv zzacvVar2 = this.zza;
            list.add(Float.valueOf(zzacvVar2.zze()));
            if (zzacvVar2.zzG()) {
                return;
            } else {
                iZza = zzacvVar2.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzz(List list) throws zzaeh {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzaeq;
        int i = this.zzb;
        if (z) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar = this.zza;
                int iZzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzf());
                } while (zzacvVar.zzH() < iZzH);
                zzV(iZzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzf());
                if (zzacvVar2.zzG()) {
                    return;
                } else {
                    iZza2 = zzacvVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    Gson$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzacv zzacvVar3 = this.zza;
                int iZzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzf()));
                } while (zzacvVar3.zzH() < iZzH2);
                zzV(iZzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzf()));
                if (zzacvVar4.zzG()) {
                    return;
                } else {
                    iZza = zzacvVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }
}
