package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzxy implements zzxi, zzxh {
    private final zzxi[] zza;
    private final boolean[] zzb;
    private zzxh zzf;
    private zzzn zzg;
    private final ArrayList zzd = new ArrayList();
    private final HashMap zze = new HashMap();
    private zzze zzi = new zzwu(zzgwm.zzi(), zzgwm.zzi());
    private final IdentityHashMap zzc = new IdentityHashMap();
    private zzxi[] zzh = new zzxi[0];

    public zzxy(zzwv zzwvVar, long[] jArr, zzxi... zzxiVarArr) {
        this.zza = zzxiVarArr;
        this.zzb = new boolean[zzxiVarArr.length];
        for (int i = 0; i < zzxiVarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zzb[i] = true;
                this.zza[i] = new zzzk(zzxiVarArr[i], j);
            }
        }
    }

    public final zzxi zza(int i) {
        boolean z = this.zzb[i];
        zzxi[] zzxiVarArr = this.zza;
        return z ? ((zzzk) zzxiVarArr[i]).zza() : zzxiVarArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxh zzxhVar, long j) {
        this.zzf = zzxhVar;
        ArrayList arrayList = this.zzd;
        zzxi[] zzxiVarArr = this.zza;
        Collections.addAll(arrayList, zzxiVarArr);
        for (zzxi zzxiVar : zzxiVarArr) {
            zzxiVar.zzb(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzc() {
        int i = 0;
        while (true) {
            zzxi[] zzxiVarArr = this.zza;
            if (i >= zzxiVarArr.length) {
                return;
            }
            zzxiVarArr[i].zzc();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final zzzn zzd() {
        zzzn zzznVar = this.zzg;
        zzznVar.getClass();
        return zzznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zze(zzaba[] zzabaVarArr, boolean[] zArr, zzzc[] zzzcVarArr, boolean[] zArr2, long j) {
        int length;
        int[] iArr;
        int length2 = zzabaVarArr.length;
        int[] iArr2 = new int[length2];
        int[] iArr3 = new int[length2];
        int i = 0;
        int i2 = 0;
        while (true) {
            length = zzabaVarArr.length;
            if (i2 >= length) {
                break;
            }
            zzzc zzzcVar = zzzcVarArr[i2];
            Integer num = zzzcVar == null ? null : (Integer) this.zzc.get(zzzcVar);
            iArr2[i2] = num == null ? -1 : num.intValue();
            zzaba zzabaVar = zzabaVarArr[i2];
            if (zzabaVar != null) {
                String str = zzabaVar.zza().zzb;
                iArr3[i2] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr3[i2] = -1;
            }
            i2++;
        }
        IdentityHashMap identityHashMap = this.zzc;
        identityHashMap.clear();
        zzxi[] zzxiVarArr = this.zza;
        zzzc[] zzzcVarArr2 = new zzzc[length];
        zzzc[] zzzcVarArr3 = new zzzc[length];
        zzaba[] zzabaVarArr2 = new zzaba[length];
        ArrayList arrayList = new ArrayList(zzxiVarArr.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < zzxiVarArr.length) {
            int i4 = i;
            while (i4 < zzabaVarArr.length) {
                zzzcVarArr3[i4] = iArr2[i4] == i3 ? zzzcVarArr[i4] : null;
                if (iArr3[i4] == i3) {
                    zzaba zzabaVar2 = zzabaVarArr[i4];
                    zzabaVar2.getClass();
                    iArr = iArr3;
                    zzbg zzbgVar = (zzbg) this.zze.get(zzabaVar2.zza());
                    zzbgVar.getClass();
                    zzabaVarArr2[i4] = new zzxx(zzabaVar2, zzbgVar);
                } else {
                    iArr = iArr3;
                    zzabaVarArr2[i4] = null;
                }
                i4++;
                iArr3 = iArr;
            }
            int[] iArr4 = iArr3;
            ArrayList arrayList2 = arrayList;
            int i5 = i3;
            long jZze = zzxiVarArr[i3].zze(zzabaVarArr2, zArr, zzzcVarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jZze;
            } else if (jZze != j2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Children enabled at different positions.");
                return 0L;
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzabaVarArr.length; i6++) {
                if (iArr4[i6] == i5) {
                    zzzc zzzcVar2 = zzzcVarArr3[i6];
                    zzzcVar2.getClass();
                    zzzcVarArr2[i6] = zzzcVar2;
                    identityHashMap.put(zzzcVar2, Integer.valueOf(i5));
                    z = true;
                } else if (iArr2[i6] == i5) {
                    zzgtj.zzi(zzzcVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(zzxiVarArr[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            iArr3 = iArr4;
            i = 0;
        }
        int i7 = i;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzzcVarArr2, i7, zzzcVarArr, i7, length);
        this.zzh = (zzxi[]) arrayList3.toArray(new zzxi[i7]);
        this.zzi = new zzwu(arrayList3, zzgxm.zzc(arrayList3, zzxw.zza));
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzf(long j, boolean z) {
        for (zzxi zzxiVar : this.zzh) {
            zzxiVar.zzf(j, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final void zzg(long j) {
        this.zzi.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzh() {
        long j = -9223372036854775807L;
        for (zzxi zzxiVar : this.zzh) {
            long jZzh = zzxiVar.zzh();
            if (jZzh == -9223372036854775807L) {
                if (j != -9223372036854775807L && zzxiVar.zzj(j) != j) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Unexpected child seekToUs result.");
                    return 0L;
                }
            } else if (j == -9223372036854775807L) {
                for (zzxi zzxiVar2 : this.zzh) {
                    if (zzxiVar2 == zzxiVar) {
                        break;
                    }
                    if (zzxiVar2.zzj(jZzh) != jZzh) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Unexpected child seekToUs result.");
                        return 0L;
                    }
                }
                j = jZzh;
            } else if (jZzh != j) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Conflicting discontinuities.");
                return 0L;
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        return this.zzi.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzj(long j) {
        long jZzj = this.zzh[0].zzj(j);
        int i = 1;
        while (true) {
            zzxi[] zzxiVarArr = this.zzh;
            if (i >= zzxiVarArr.length) {
                return jZzj;
            }
            if (zzxiVarArr[i].zzj(jZzj) != jZzj) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unexpected child seekToUs result.");
                return 0L;
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzk(long j, zzni zzniVar) {
        zzxi[] zzxiVarArr = this.zzh;
        return (zzxiVarArr.length > 0 ? zzxiVarArr[0] : this.zza[0]).zzk(j, zzniVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        return this.zzi.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        ArrayList arrayList = this.zzd;
        if (arrayList.isEmpty()) {
            return this.zzi.zzm(zzmaVar);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzxi) arrayList.get(i)).zzm(zzmaVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return this.zzi.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        ArrayList arrayList = this.zzd;
        arrayList.remove(zzxiVar);
        if (arrayList.isEmpty()) {
            zzxi[] zzxiVarArr = this.zza;
            int i = 0;
            for (zzxi zzxiVar2 : zzxiVarArr) {
                i += zzxiVar2.zzd().zzb;
            }
            zzbg[] zzbgVarArr = new zzbg[i];
            int i2 = 0;
            for (int i3 = 0; i3 < zzxiVarArr.length; i3++) {
                zzzn zzznVarZzd = zzxiVarArr[i3].zzd();
                int i4 = zzznVarZzd.zzb;
                int i5 = 0;
                while (i5 < i4) {
                    zzbg zzbgVarZza = zzznVarZzd.zza(i5);
                    int i6 = zzbgVarZza.zza;
                    zzv[] zzvVarArr = new zzv[i6];
                    int i7 = 0;
                    while (i7 < i6) {
                        zzv zzvVarZza = zzbgVarZza.zza(i7);
                        zzt zztVarZza = zzvVarZza.zza();
                        String str = zzvVarZza.zza;
                        if (str == null) {
                            str = "";
                        }
                        zzxi[] zzxiVarArr2 = zzxiVarArr;
                        int i8 = i2;
                        StringBuilder sb = new StringBuilder(str.length() + zzba$$ExternalSyntheticOutline0.m(i3, 1));
                        sb.append(i3);
                        sb.append(":");
                        sb.append(str);
                        zztVarZza.zza(sb.toString());
                        String str2 = zzvVarZza.zzn;
                        if (str2 != null) {
                            StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(i3, 1) + str2.length());
                            sb2.append(i3);
                            sb2.append(":");
                            sb2.append(str2);
                            zztVarZza.zzm(sb2.toString());
                        }
                        zzvVarArr[i7] = zztVarZza.zzO();
                        i7++;
                        zzxiVarArr = zzxiVarArr2;
                        i2 = i8;
                    }
                    zzxi[] zzxiVarArr3 = zzxiVarArr;
                    int i9 = i2;
                    String str3 = zzbgVarZza.zzb;
                    StringBuilder sb3 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(i3, 1) + String.valueOf(str3).length());
                    sb3.append(i3);
                    sb3.append(":");
                    sb3.append(str3);
                    zzbg zzbgVar = new zzbg(sb3.toString(), zzvVarArr);
                    this.zze.put(zzbgVar, zzbgVarZza);
                    i2 = i9 + 1;
                    zzbgVarArr[i9] = zzbgVar;
                    i5++;
                    zzxiVarArr = zzxiVarArr3;
                }
            }
            this.zzg = new zzzn(zzbgVarArr);
            zzxh zzxhVar = this.zzf;
            zzxhVar.getClass();
            zzxhVar.zzp(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        zzxh zzxhVar = this.zzf;
        zzxhVar.getClass();
        zzxhVar.zzs(this);
    }
}
