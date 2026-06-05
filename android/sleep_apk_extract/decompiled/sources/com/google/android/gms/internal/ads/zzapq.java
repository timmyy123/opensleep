package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzapq implements zzarg {
    private final List zza;

    public zzapq(int i, List list) {
        this.zza = list;
    }

    private final zzaqw zzc(zzarf zzarfVar) {
        return new zzaqw(zze(zzarfVar), "video/mp2t");
    }

    private final zzarl zzd(zzarf zzarfVar) {
        return new zzarl(zze(zzarfVar), "video/mp2t");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3 */
    private final List zze(zzarf zzarfVar) {
        String str;
        int i;
        List listSingletonList;
        zzet zzetVar = new zzet(zzarfVar.zze);
        ArrayList arrayList = this.zza;
        while (zzetVar.zzd() > 0) {
            int iZzs = zzetVar.zzs();
            int iZzg = zzetVar.zzg() + zzetVar.zzs();
            if (iZzs == 134) {
                arrayList = new ArrayList();
                int iZzs2 = zzetVar.zzs() & 31;
                for (int i2 = 0; i2 < iZzs2; i2++) {
                    String strZzK = zzetVar.zzK(3, StandardCharsets.UTF_8);
                    int iZzs3 = zzetVar.zzs();
                    boolean z = (iZzs3 & 128) != 0;
                    if (z) {
                        i = iZzs3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bZzs = (byte) zzetVar.zzs();
                    zzetVar.zzk(1);
                    if (z) {
                        int i3 = bZzs & 64;
                        int i4 = zzdq.$r8$clinit;
                        listSingletonList = Collections.singletonList(i3 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzt zztVar = new zzt();
                    zztVar.zzo(str);
                    zztVar.zze(strZzK);
                    zztVar.zzL(i);
                    zztVar.zzr(listSingletonList);
                    arrayList.add(zztVar.zzO());
                }
            }
            zzetVar.zzh(iZzg);
            arrayList = arrayList;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzarg
    public final SparseArray zza() {
        return new SparseArray();
    }

    @Override // com.google.android.gms.internal.ads.zzarg
    public final zzari zzb(int i, zzarf zzarfVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzaqm(new zzaqf(zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
            }
            if (i == 21) {
                return new zzaqm(new zzaqd("video/mp2t"));
            }
            if (i == 27) {
                return new zzaqm(new zzaqa(zzc(zzarfVar), false, false, "video/mp2t"));
            }
            if (i == 36) {
                return new zzaqm(new zzaqc(zzc(zzarfVar), "video/mp2t"));
            }
            if (i == 45) {
                return new zzaqm(new zzaqg("video/mp2t"));
            }
            if (i == 89) {
                return new zzaqm(new zzaps(zzarfVar.zzd, "video/mp2t"));
            }
            if (i == 172) {
                return new zzaqm(new zzapm(zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
            }
            if (i == 257) {
                return new zzaqu(new zzaql("application/vnd.dvb.ait", "video/mp2t"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzaqm(new zzapr(zzarfVar.zzb, zzarfVar.zza(), 5408, "video/mp2t"));
                        }
                        switch (i) {
                            case 15:
                                return new zzaqm(new zzapp(false, zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
                            case 16:
                                return new zzaqm(new zzapy(zzd(zzarfVar), "video/mp2t"));
                            case 17:
                                return new zzaqm(new zzaqe(zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzaqu(new zzaql("application/x-scte35", "video/mp2t"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzaqm(new zzapr(zzarfVar.zzb, zzarfVar.zza(), 4096, "video/mp2t"));
                }
                return new zzaqm(new zzapj(zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
            }
        }
        return new zzaqm(new zzapv(zzd(zzarfVar), "video/mp2t"));
    }
}
