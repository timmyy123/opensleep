package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.internal.Utility;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzarb implements zzaqt {
    final /* synthetic */ zzard zza;
    private final zzes zzb;
    private final SparseArray zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzarb(zzard zzardVar, int i) {
        Objects.requireNonNull(zzardVar);
        this.zza = zzardVar;
        this.zzb = new zzes(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zza(zzfi zzfiVar, zzagb zzagbVar, zzarh zzarhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zzb(zzet zzetVar) {
        zzard zzardVar;
        int i;
        zzes zzesVar;
        int i2;
        int i3;
        if (zzetVar.zzs() != 2) {
            return;
        }
        zzard zzardVar2 = this.zza;
        zzfi zzfiVar = (zzfi) zzardVar2.zzh().get(0);
        if ((zzetVar.zzs() & 128) != 0) {
            zzetVar.zzk(1);
            int iZzt = zzetVar.zzt();
            int i4 = 3;
            zzetVar.zzk(3);
            zzes zzesVar2 = this.zzb;
            zzetVar.zzl(zzesVar2, 2);
            zzesVar2.zzh(3);
            int i5 = 13;
            zzardVar2.zzq(zzesVar2.zzj(13));
            zzetVar.zzl(zzesVar2, 2);
            int i6 = 4;
            zzesVar2.zzh(4);
            int i7 = 12;
            zzetVar.zzk(zzesVar2.zzj(12));
            SparseArray sparseArray = this.zzc;
            sparseArray.clear();
            SparseIntArray sparseIntArray = this.zzd;
            sparseIntArray.clear();
            int iZzd = zzetVar.zzd();
            while (iZzd > 0) {
                int i8 = 5;
                zzetVar.zzl(zzesVar2, 5);
                int iZzj = zzesVar2.zzj(8);
                zzesVar2.zzh(i4);
                int iZzj2 = zzesVar2.zzj(i5);
                zzesVar2.zzh(i6);
                int iZzj3 = zzesVar2.zzj(i7);
                int iZzg = zzetVar.zzg();
                int i9 = iZzg + iZzj3;
                String str = null;
                ArrayList arrayList = null;
                int i10 = -1;
                int iZzs = 0;
                while (zzetVar.zzg() < i9) {
                    int iZzs2 = zzetVar.zzs();
                    int iZzg2 = zzetVar.zzg() + zzetVar.zzs();
                    if (iZzg2 > i9) {
                        break;
                    }
                    if (iZzs2 == i8) {
                        long jZzz = zzetVar.zzz();
                        if (jZzz != 1094921523) {
                            if (jZzz != 1161904947) {
                                if (jZzz != 1094921524) {
                                    if (jZzz == 1212503619) {
                                        i3 = 36;
                                        zzardVar = zzardVar2;
                                        i10 = i3;
                                        i = iZzg2;
                                        zzesVar = zzesVar2;
                                        i2 = iZzd;
                                    }
                                    zzardVar = zzardVar2;
                                    i = iZzg2;
                                    zzesVar = zzesVar2;
                                    i2 = iZzd;
                                }
                                zzardVar = zzardVar2;
                                i = iZzg2;
                                zzesVar = zzesVar2;
                                i2 = iZzd;
                                i10 = 172;
                            }
                            zzardVar = zzardVar2;
                            zzesVar = zzesVar2;
                            i2 = iZzd;
                            i10 = 135;
                            i = iZzg2;
                        }
                        zzardVar = zzardVar2;
                        i = iZzg2;
                        zzesVar = zzesVar2;
                        i2 = iZzd;
                        i10 = 129;
                    } else {
                        if (iZzs2 != 106) {
                            if (iZzs2 == 122) {
                                zzardVar = zzardVar2;
                                zzesVar = zzesVar2;
                                i2 = iZzd;
                                i10 = 135;
                                i = iZzg2;
                            } else {
                                if (iZzs2 == 127) {
                                    int iZzs3 = zzetVar.zzs();
                                    if (iZzs3 != 21) {
                                        if (iZzs3 == 14) {
                                            i3 = 136;
                                        } else {
                                            if (iZzs3 == 33) {
                                                i3 = 139;
                                            }
                                            zzardVar = zzardVar2;
                                            i = iZzg2;
                                            zzesVar = zzesVar2;
                                            i2 = iZzd;
                                        }
                                    }
                                    zzardVar = zzardVar2;
                                    i = iZzg2;
                                    zzesVar = zzesVar2;
                                    i2 = iZzd;
                                    i10 = 172;
                                } else if (iZzs2 == 123) {
                                    i3 = 138;
                                } else if (iZzs2 == 10) {
                                    String strTrim = zzetVar.zzK(3, StandardCharsets.UTF_8).trim();
                                    iZzs = zzetVar.zzs();
                                    zzardVar = zzardVar2;
                                    str = strTrim;
                                    i = iZzg2;
                                    zzesVar = zzesVar2;
                                    i2 = iZzd;
                                } else if (iZzs2 == 89) {
                                    ArrayList arrayList2 = new ArrayList();
                                    while (zzetVar.zzg() < iZzg2) {
                                        int i11 = iZzg2;
                                        String strTrim2 = zzetVar.zzK(3, StandardCharsets.UTF_8).trim();
                                        int iZzs4 = zzetVar.zzs();
                                        int i12 = iZzd;
                                        byte[] bArr = new byte[4];
                                        zzetVar.zzm(bArr, 0, 4);
                                        arrayList2.add(new zzare(strTrim2, iZzs4, bArr));
                                        iZzd = i12;
                                        iZzg2 = i11;
                                        zzesVar2 = zzesVar2;
                                        zzardVar2 = zzardVar2;
                                    }
                                    zzardVar = zzardVar2;
                                    i = iZzg2;
                                    zzesVar = zzesVar2;
                                    i2 = iZzd;
                                    arrayList = arrayList2;
                                    i10 = 89;
                                } else {
                                    zzardVar = zzardVar2;
                                    i = iZzg2;
                                    zzesVar = zzesVar2;
                                    i2 = iZzd;
                                    if (iZzs2 == 111) {
                                        i10 = 257;
                                    }
                                }
                                zzardVar = zzardVar2;
                                i10 = i3;
                                i = iZzg2;
                                zzesVar = zzesVar2;
                                i2 = iZzd;
                            }
                        }
                        zzardVar = zzardVar2;
                        i = iZzg2;
                        zzesVar = zzesVar2;
                        i2 = iZzd;
                        i10 = 129;
                    }
                    zzetVar.zzk(i - zzetVar.zzg());
                    iZzd = i2;
                    zzesVar2 = zzesVar;
                    zzardVar2 = zzardVar;
                    i8 = 5;
                }
                zzard zzardVar3 = zzardVar2;
                zzes zzesVar3 = zzesVar2;
                int i13 = iZzd;
                zzetVar.zzh(i9);
                zzarf zzarfVar = new zzarf(i10, str, iZzs, arrayList, Arrays.copyOfRange(zzetVar.zzi(), iZzg, i9));
                if (iZzj == 6 || iZzj == 5) {
                    iZzj = zzarfVar.zza;
                }
                iZzd = i13 - (iZzj3 + 5);
                if (!zzardVar3.zzk().get(iZzj2)) {
                    zzari zzariVarZzb = zzardVar3.zzi().zzb(iZzj, zzarfVar);
                    sparseIntArray.put(iZzj2, iZzj2);
                    sparseArray.put(iZzj2, zzariVarZzb);
                }
                i6 = 4;
                zzesVar2 = zzesVar3;
                zzardVar2 = zzardVar3;
                i4 = 3;
                i5 = 13;
                i7 = 12;
            }
            zzard zzardVar4 = zzardVar2;
            int size = sparseIntArray.size();
            for (int i14 = 0; i14 < size; i14++) {
                int iKeyAt = sparseIntArray.keyAt(i14);
                int iValueAt = sparseIntArray.valueAt(i14);
                zzardVar4.zzk().put(iKeyAt, true);
                zzardVar4.zzl().put(iValueAt, true);
                zzari zzariVar = (zzari) sparseArray.valueAt(i14);
                if (zzariVar != null) {
                    zzariVar.zza(zzfiVar, zzardVar4.zzm(), new zzarh(iZzt, iKeyAt, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    zzardVar4.zzj().put(iValueAt, zzariVar);
                }
            }
            zzardVar4.zzj().remove(this.zze);
            zzardVar4.zzo(0);
            if (zzardVar4.zzn() == 0) {
                zzardVar4.zzm().zzv();
                zzardVar4.zzp(true);
            }
        }
    }
}
