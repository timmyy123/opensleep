package com.google.android.gms.internal.ads;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzidf implements zzigc {
    private final zzide zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzidf(zzide zzideVar) {
        zzideVar.getClass();
        this.zza = zzideVar;
        zzideVar.zzd = this;
    }

    private final void zzQ(int i) throws zzies {
        if ((this.zzb & 7) == i) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1();
    }

    private final void zzR(Object obj, zzigh zzighVar, zzido zzidoVar) throws zziet {
        zzide zzideVar = this.zza;
        int iZzo = zzideVar.zzo();
        zzideVar.zzJ();
        int iZzB = zzideVar.zzB(iZzo);
        zzideVar.zza++;
        zzighVar.zzg(obj, this, zzidoVar);
        zzideVar.zzb(0);
        zzideVar.zza--;
        zzideVar.zzC(iZzB);
    }

    private final Object zzS(zzigh zzighVar, zzido zzidoVar) throws zziet {
        Object objZza = zzighVar.zza();
        zzR(objZza, zzighVar, zzidoVar);
        zzighVar.zzk(objZza);
        return objZza;
    }

    private final void zzT(Object obj, zzigh zzighVar, zzido zzidoVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzighVar.zzg(obj, this, zzidoVar);
            if (this.zzb == this.zzc) {
            } else {
                throw new zziet("Failed to parse the message.");
            }
        } finally {
            this.zzc = i;
        }
    }

    private final Object zzU(zzihg zzihgVar, Class cls, zzido zzidoVar) throws zzies {
        zzihg zzihgVar2 = zzihg.zza;
        switch (zzihgVar.ordinal()) {
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
                return zzS(zzifz.zza().zzb(cls), zzidoVar);
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

    private final void zzV(int i) throws zziet {
        if (this.zza.zzE() == i) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    private static final void zzW(int i) throws zziet {
        if ((i & 3) == 0) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("Failed to parse the message.");
    }

    private static final void zzX(int i) throws zziet {
        if ((i & 7) == 0) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("Failed to parse the message.");
    }

    public static zzidf zza(zzide zzideVar) {
        Object obj = zzideVar.zzd;
        return obj != null ? (zzidf) obj : new zzidf(zzideVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzA(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzifd;
        int i = this.zzb;
        if (z) {
            zzifd zzifdVar = (zzifd) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zzifdVar.zzd(zzideVar.zzg());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzg());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Long.valueOf(zzideVar3.zzg()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzg()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzB(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzief;
        int i = this.zzb;
        if (z) {
            zzief zziefVar = (zzief) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zziefVar.zzi(zzideVar.zzh());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzh());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Integer.valueOf(zzideVar3.zzh()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzh()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzC(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzifd;
        int i = this.zzb;
        if (z) {
            zzifd zzifdVar = (zzifd) list;
            int i2 = i & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzX(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zzifdVar.zzd(zzideVar.zzi());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzi());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzX(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Long.valueOf(zzideVar3.zzi()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzi()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzD(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzief;
        int i = this.zzb;
        if (z) {
            zzief zziefVar = (zzief) list;
            int i2 = i & 7;
            if (i2 == 2) {
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzW(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zziefVar.zzi(zzideVar.zzj());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            if (i2 != 5) {
                zzbuy$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzj());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 == 2) {
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzW(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Integer.valueOf(zzideVar3.zzj()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            if (i3 != 5) {
                zzbuy$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzj()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzE(List list) throws zziet {
        int iZza;
        if (list instanceof zzicq) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i = this.zzb & 7;
        if (i == 0) {
            do {
                zzide zzideVar = this.zza;
                list.add(Boolean.valueOf(zzideVar.zzk()));
                if (zzideVar.zzD()) {
                    return;
                } else {
                    iZza = zzideVar.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i != 2) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        zzide zzideVar2 = this.zza;
        int iZzE = zzideVar2.zzE() + zzideVar2.zzo();
        do {
            list.add(Boolean.valueOf(zzideVar2.zzk()));
        } while (zzideVar2.zzE() < iZzE);
        zzV(iZzE);
    }

    public final void zzF(List list, boolean z) throws zzies {
        int iZza;
        int iZza2;
        if ((this.zzb & 7) != 2) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        if ((list instanceof zzifa) && !z) {
            zzifa zzifaVar = (zzifa) list;
            do {
                zzq();
                zzifaVar.zzb();
                zzide zzideVar = this.zza;
                if (zzideVar.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            do {
                list.add(z ? zzn() : zzm());
                zzide zzideVar2 = this.zza;
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza = zzideVar2.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzG(List list, zzigh zzighVar, zzido zzidoVar) throws zzies {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        do {
            list.add(zzS(zzighVar, zzidoVar));
            zzide zzideVar = this.zza;
            if (zzideVar.zzD() || this.zzd != 0) {
                return;
            } else {
                iZza = zzideVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    @Deprecated
    public final void zzH(List list, zzigh zzighVar, zzido zzidoVar) throws zzies {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        do {
            Object objZza = zzighVar.zza();
            zzT(objZza, zzighVar, zzidoVar);
            zzighVar.zzk(objZza);
            list.add(objZza);
            zzide zzideVar = this.zza;
            if (zzideVar.zzD() || this.zzd != 0) {
                return;
            } else {
                iZza = zzideVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzI(List list) throws zzies {
        int iZza;
        if ((this.zzb & 7) != 2) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        do {
            list.add(zzq());
            zzide zzideVar = this.zza;
            if (zzideVar.zzD()) {
                return;
            } else {
                iZza = zzideVar.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzJ(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzief;
        int i = this.zzb;
        if (z) {
            zzief zziefVar = (zzief) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zziefVar.zzi(zzideVar.zzo());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzo());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Integer.valueOf(zzideVar3.zzo()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzo()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzK(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzief;
        int i = this.zzb;
        if (z) {
            zzief zziefVar = (zzief) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zziefVar.zzi(zzideVar.zzp());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzp());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Integer.valueOf(zzideVar3.zzp()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzp()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzL(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzief;
        int i = this.zzb;
        if (z) {
            zzief zziefVar = (zzief) list;
            int i2 = i & 7;
            if (i2 == 2) {
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzW(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zziefVar.zzi(zzideVar.zzq());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            if (i2 != 5) {
                zzbuy$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzq());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 == 2) {
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzW(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Integer.valueOf(zzideVar3.zzq()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            if (i3 != 5) {
                zzbuy$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzq()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzM(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzifd;
        int i = this.zzb;
        if (z) {
            zzifd zzifdVar = (zzifd) list;
            int i2 = i & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzX(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zzifdVar.zzd(zzideVar.zzr());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzr());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzX(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Long.valueOf(zzideVar3.zzr()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzr()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzN(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzief;
        int i = this.zzb;
        if (z) {
            zzief zziefVar = (zzief) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zziefVar.zzi(zzideVar.zzs());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzs());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Integer.valueOf(zzideVar3.zzs()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzs()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzO(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzifd;
        int i = this.zzb;
        if (z) {
            zzifd zzifdVar = (zzifd) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zzifdVar.zzd(zzideVar.zzt());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzt());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Long.valueOf(zzideVar3.zzt()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzt()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
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
    
        r9.zza.zzC(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzigc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzP(Map map, zzifh zzifhVar, zzido zzidoVar) throws zzies {
        zzQ(2);
        zzide zzideVar = this.zza;
        int iZzB = zzideVar.zzB(zzideVar.zzo());
        Object obj = zzifhVar.zzd;
        Object objZzU = zzifhVar.zzb;
        Object objZzU2 = obj;
        while (true) {
            try {
                int iZzb = zzb();
                if (iZzb == Integer.MAX_VALUE || zzideVar.zzD()) {
                    break;
                }
                if (iZzb == 1) {
                    objZzU = zzU(zzifhVar.zza, null, null);
                } else if (iZzb != 2) {
                    try {
                        if (!zzd()) {
                            throw new zziet("Unable to parse map entry.");
                        }
                    } catch (zzies e) {
                        if (!zzd()) {
                            throw new zziet("Unable to parse map entry.", e);
                        }
                    }
                } else {
                    objZzU2 = zzU(zzifhVar.zzc, obj.getClass(), zzidoVar);
                }
            } catch (Throwable th) {
                this.zza.zzC(iZzB);
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigc
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

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        int i;
        zzide zzideVar = this.zza;
        if (zzideVar.zzD() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return zzideVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final double zze() throws zzies {
        zzQ(1);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final float zzf() throws zzies {
        zzQ(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzg() throws zzies {
        zzQ(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzh() throws zzies {
        zzQ(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzi() throws zzies {
        zzQ(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzj() throws zzies {
        zzQ(1);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzk() throws zzies {
        zzQ(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final boolean zzl() throws zzies {
        zzQ(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final String zzm() throws zzies {
        zzQ(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final String zzn() throws zzies {
        zzQ(2);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzo(Object obj, zzigh zzighVar, zzido zzidoVar) throws zziet {
        zzQ(2);
        zzR(obj, zzighVar, zzidoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzp(Object obj, zzigh zzighVar, zzido zzidoVar) throws zzies {
        zzQ(3);
        zzT(obj, zzighVar, zzidoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final zzida zzq() throws zzies {
        zzQ(2);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzr() throws zzies {
        zzQ(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzs() throws zzies {
        zzQ(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzt() throws zzies {
        zzQ(5);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzu() throws zzies {
        zzQ(1);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzv() throws zzies {
        zzQ(0);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzw() throws zzies {
        zzQ(0);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzx(List list) throws zziet {
        int iZza;
        if (list instanceof zzidl) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i = this.zzb & 7;
        if (i == 1) {
            do {
                zzide zzideVar = this.zza;
                list.add(Double.valueOf(zzideVar.zzd()));
                if (zzideVar.zzD()) {
                    return;
                } else {
                    iZza = zzideVar.zza();
                }
            } while (iZza == this.zzb);
            this.zzd = iZza;
            return;
        }
        if (i != 2) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        zzide zzideVar2 = this.zza;
        int iZzo = zzideVar2.zzo();
        zzX(iZzo);
        int iZzE = zzideVar2.zzE() + iZzo;
        do {
            list.add(Double.valueOf(zzideVar2.zzd()));
        } while (zzideVar2.zzE() < iZzE);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzy(List list) throws zziet {
        int iZza;
        if (list instanceof zzidv) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int i = this.zzb & 7;
        if (i == 2) {
            zzide zzideVar = this.zza;
            int iZzo = zzideVar.zzo();
            zzW(iZzo);
            int iZzE = zzideVar.zzE() + iZzo;
            do {
                list.add(Float.valueOf(zzideVar.zze()));
            } while (zzideVar.zzE() < iZzE);
            return;
        }
        if (i != 5) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        do {
            zzide zzideVar2 = this.zza;
            list.add(Float.valueOf(zzideVar2.zze()));
            if (zzideVar2.zzD()) {
                return;
            } else {
                iZza = zzideVar2.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzz(List list) throws zziet {
        int iZza;
        int iZza2;
        boolean z = list instanceof zzifd;
        int i = this.zzb;
        if (z) {
            zzifd zzifdVar = (zzifd) list;
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zzifdVar.zzd(zzideVar.zzf());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzf());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i3 = i & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    zzbuy$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Long.valueOf(zzideVar3.zzf()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzf()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }
}
