package com.google.android.gms.internal.serialization;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzaau implements zzabe {
    private final zzaaq zza;
    private final zzabr zzb;
    private final boolean zzc;
    private final zzyq zzd;

    private zzaau(zzabr zzabrVar, zzyq zzyqVar, zzaaq zzaaqVar) {
        this.zzb = zzabrVar;
        this.zzc = zzaaqVar instanceof zzzc;
        this.zzd = zzyqVar;
        this.zza = zzaaqVar;
    }

    public static zzaau zzh(zzabr zzabrVar, zzyq zzyqVar, zzaaq zzaaqVar) {
        return new zzaau(zzabrVar, zzyqVar, zzaaqVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final Object zza() {
        zzaaq zzaaqVar = this.zza;
        return zzaaqVar instanceof zzzg ? ((zzzg) zzaaqVar).newMutableInstance() : zzaaqVar.newBuilderForType().buildPartial();
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzzg) obj).unknownFields.equals(((zzzg) obj2).unknownFields)) {
            return false;
        }
        if (this.zzc) {
            return ((zzzc) obj).extensions.equals(((zzzc) obj2).extensions);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final int zzc(Object obj) {
        int iHashCode = ((zzzg) obj).unknownFields.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzzc) obj).extensions.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final void zzd(Object obj, Object obj2) {
        zzabg.zzH(this.zzb, obj, obj2);
        if (this.zzc) {
            zzabg.zzG(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final int zze(Object obj) {
        int iZzh = ((zzzg) obj).unknownFields.zzh();
        return this.zzc ? iZzh + ((zzzc) obj).extensions.zzo() : iZzh;
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final void zzf(Object obj, zzach zzachVar) {
        Iterator itZze = ((zzzc) obj).extensions.zze();
        while (itZze.hasNext()) {
            Map.Entry entry = (Map.Entry) itZze.next();
            zzyt zzytVar = (zzyt) entry.getKey();
            if (zzytVar.zzc() != zzacf.MESSAGE || zzytVar.zzd() || zzytVar.zze()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Found invalid MessageSet item.");
                return;
            } else {
                if (entry instanceof zzzx) {
                    zzytVar.zza();
                    ((zzzx) entry).zza();
                    throw null;
                }
                zzachVar.zzv(zzytVar.zza(), entry.getValue());
            }
        }
        ((zzzg) obj).unknownFields.zzf(zzachVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final void zzg(Object obj, zzabd zzabdVar, zzyp zzypVar) {
        boolean zZzd;
        zzabr zzabrVar = this.zzb;
        Object objZzh = zzabrVar.zzh(obj);
        zzyu<zzzd> zzyuVarEnsureExtensionsAreMutable = ((zzzc) obj).ensureExtensionsAreMutable();
        while (zzabdVar.zzb() != Integer.MAX_VALUE) {
            try {
                int iZzc = zzabdVar.zzc();
                zzyq zzyqVar = this.zzd;
                if (iZzc != 11) {
                    if ((iZzc & 7) == 2) {
                        zzze zzzeVarZza = zzypVar.zza(this.zza, iZzc >>> 3);
                        if (zzzeVarZza != null) {
                            zzyqVar.zzc(zzabdVar, zzzeVarZza, zzypVar, zzyuVarEnsureExtensionsAreMutable);
                        } else {
                            zZzd = zzabrVar.zzk(objZzh, zzabdVar, 0);
                        }
                    } else {
                        zZzd = zzabdVar.zzd();
                    }
                    if (!zZzd) {
                        break;
                    }
                } else {
                    zzze zzzeVarZza2 = null;
                    zzwr zzwrVarZzs = null;
                    int iZzt = 0;
                    while (zzabdVar.zzb() != Integer.MAX_VALUE) {
                        int iZzc2 = zzabdVar.zzc();
                        if (iZzc2 == 16) {
                            iZzt = zzabdVar.zzt();
                            zzzeVarZza2 = zzypVar.zza(this.zza, iZzt);
                        } else if (iZzc2 == 26) {
                            if (zzzeVarZza2 != null) {
                                zzyqVar.zzc(zzabdVar, zzzeVarZza2, zzypVar, zzyuVarEnsureExtensionsAreMutable);
                            } else {
                                zzwrVarZzs = zzabdVar.zzs();
                            }
                        } else if (!zzabdVar.zzd()) {
                            break;
                        }
                    }
                    if (zzabdVar.zzc() != 12) {
                        throw new zzzv("Protocol message end-group tag did not match expected tag.");
                    }
                    if (zzwrVarZzs != null) {
                        if (zzzeVarZza2 != null) {
                            zzaap zzaapVarNewBuilderForType = zzzeVarZza2.zzc.newBuilderForType();
                            zzwv zzwvVarZzk = zzwrVarZzs.zzk();
                            zzaapVarNewBuilderForType.mergeFrom(zzwvVarZzk, zzypVar);
                            zzyuVarEnsureExtensionsAreMutable.zzg(zzzeVarZza2.zzd, zzaapVarNewBuilderForType.buildPartial());
                            zzwvVarZzk.zzb(0);
                        } else {
                            zzabrVar.zzd(objZzh, iZzt, zzwrVarZzs);
                        }
                    }
                }
            } finally {
                zzabrVar.zzi(obj, objZzh);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8 A[EDGE_INSN: B:61:0x00b8->B:33:0x00b8 BREAK  A[LOOP:1: B:17:0x0064->B:64:0x0064], SYNTHETIC] */
    @Override // com.google.android.gms.internal.serialization.zzabe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzwg zzwgVar) throws zzzv {
        int iZza;
        zzzg zzzgVar = (zzzg) obj;
        zzabs zzabsVarZzb = zzzgVar.unknownFields;
        if (zzabsVarZzb == zzabs.zza()) {
            zzabsVarZzb = zzabs.zzb();
            zzzgVar.unknownFields = zzabsVarZzb;
        }
        zzabs zzabsVar = zzabsVarZzb;
        zzyu<zzzd> zzyuVarEnsureExtensionsAreMutable = ((zzzc) obj).ensureExtensionsAreMutable();
        zzze zzzeVarZza = null;
        while (i < i2) {
            int iZza2 = zzwh.zza(bArr, i, zzwgVar);
            int i3 = zzwgVar.zza;
            if (i3 == 11) {
                int i4 = i2;
                zzwg zzwgVar2 = zzwgVar;
                int i5 = 0;
                zzwr zzwrVar = null;
                while (true) {
                    if (iZza2 >= i4) {
                        iZza = iZza2;
                        break;
                    }
                    iZza = zzwh.zza(bArr, iZza2, zzwgVar2);
                    int i6 = zzwgVar2.zza;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (zzzeVarZza != null) {
                                iZza2 = zzwh.zzi(zzaba.zza().zzb(zzzeVarZza.zzc.getClass()), bArr, iZza, i4, zzwgVar2);
                                zzyuVarEnsureExtensionsAreMutable.zzg(zzzeVarZza.zzd, zzwgVar2.zzc);
                            } else if (i8 == 2) {
                                iZza2 = zzwh.zzh(bArr, iZza, zzwgVar2);
                                zzwrVar = (zzwr) zzwgVar2.zzc;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iZza2 = zzwh.zzy(i6, bArr, iZza, i4, zzwgVar2);
                        }
                    } else if (i8 == 0) {
                        iZza2 = zzwh.zza(bArr, iZza, zzwgVar2);
                        i5 = zzwgVar2.zza;
                        zzzeVarZza = zzwgVar2.zzd.zza(this.zza, i5);
                    } else if (i6 != 12) {
                    }
                }
                if (zzwrVar != null) {
                    zzabsVar.zzk((i5 << 3) | 2, zzwrVar);
                }
                i = iZza;
                i2 = i4;
                zzwgVar = zzwgVar2;
            } else if ((i3 & 7) == 2) {
                zzzeVarZza = zzwgVar.zzd.zza(this.zza, i3 >>> 3);
                if (zzzeVarZza != null) {
                    i = zzwh.zzi(zzaba.zza().zzb(zzzeVarZza.zzc.getClass()), bArr, iZza2, i2, zzwgVar);
                    zzyuVarEnsureExtensionsAreMutable.zzg(zzzeVarZza.zzd, zzwgVar.zzc);
                } else {
                    i = zzwh.zzx(i3, bArr, iZza2, i2, zzabsVar, zzwgVar);
                }
            } else {
                i = zzwh.zzy(i3, bArr, iZza2, i2, zzwgVar);
            }
        }
        if (i == i2) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Failed to parse the message.");
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final void zzk(Object obj) {
        this.zzb.zzj(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.serialization.zzabe
    public final boolean zzl(Object obj) {
        return ((zzzc) obj).extensions.zzk();
    }
}
