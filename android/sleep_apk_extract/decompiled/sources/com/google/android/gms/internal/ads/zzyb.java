package com.google.android.gms.internal.ads;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzyb extends zzws {
    private static final zzak zza;
    private final zzxm[] zzb;
    private final List zzc;
    private final zzbf[] zzd;
    private final ArrayList zze;
    private int zzf = -1;
    private long[][] zzg;
    private zzxz zzh;
    private final zzwv zzi;

    static {
        zzz zzzVar = new zzz();
        zzzVar.zza("MergingMediaSource");
        zza = zzzVar.zzc();
    }

    public zzyb(boolean z, boolean z2, zzwv zzwvVar, zzxm... zzxmVarArr) {
        this.zzb = zzxmVarArr;
        this.zzi = zzwvVar;
        this.zze = new ArrayList(Arrays.asList(zzxmVarArr));
        this.zzc = new ArrayList(zzxmVarArr.length);
        int i = 0;
        while (true) {
            int length = zzxmVarArr.length;
            if (i >= length) {
                this.zzd = new zzbf[length];
                this.zzg = new long[0][];
                new HashMap();
                zzgyb.zzb(8).zzb(2).zza();
                return;
            }
            this.zzc.add(new ArrayList());
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzA(zzak zzakVar) {
        this.zzb[0].zzA(zzakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzD(zzxi zzxiVar) {
        zzxy zzxyVar = (zzxy) zzxiVar;
        int i = 0;
        while (true) {
            zzxm[] zzxmVarArr = this.zzb;
            if (i >= zzxmVarArr.length) {
                return;
            }
            List list = (List) this.zzc.get(i);
            zzxi zzxiVarZza = zzxyVar.zza(i);
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                if (((zzya) list.get(i2)).zzb().equals(zzxiVarZza)) {
                    list.remove(i2);
                    break;
                }
                i2++;
            }
            zzxmVarArr[i].zzD(zzxyVar.zza(i));
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final zzxi zzG(zzxk zzxkVar, zzabl zzablVar, long j) {
        zzbf[] zzbfVarArr = this.zzd;
        zzxm[] zzxmVarArr = this.zzb;
        int length = zzxmVarArr.length;
        zzxi[] zzxiVarArr = new zzxi[length];
        int iZze = zzbfVarArr[0].zze(zzxkVar.zza);
        for (int i = 0; i < length; i++) {
            zzxk zzxkVarZza = zzxkVar.zza(zzbfVarArr[i].zzf(iZze));
            zzxiVarArr[i] = zzxmVarArr[i].zzG(zzxkVarZza, zzablVar, j - this.zzg[iZze][i]);
            ((List) this.zzc.get(i)).add(new zzya(zzxkVarZza, zzxiVarArr[i], null));
        }
        return new zzxy(this.zzi, this.zzg[iZze], zzxiVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final zzak zzJ() {
        zzxm[] zzxmVarArr = this.zzb;
        return zzxmVarArr.length > 0 ? zzxmVarArr[0].zzJ() : zza;
    }

    @Override // com.google.android.gms.internal.ads.zzws, com.google.android.gms.internal.ads.zzwj
    public final void zza(zzin zzinVar) {
        super.zza(zzinVar);
        int i = 0;
        while (true) {
            zzxm[] zzxmVarArr = this.zzb;
            if (i >= zzxmVarArr.length) {
                return;
            }
            zzv(Integer.valueOf(i), zzxmVarArr[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzws, com.google.android.gms.internal.ads.zzwj
    public final void zzd() {
        super.zzd();
        Arrays.fill(this.zzd, (Object) null);
        this.zzf = -1;
        this.zzh = null;
        ArrayList arrayList = this.zze;
        arrayList.clear();
        Collections.addAll(arrayList, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzws, com.google.android.gms.internal.ads.zzxm
    public final void zzt() throws zzxz {
        zzxz zzxzVar = this.zzh;
        if (zzxzVar != null) {
            throw zzxzVar;
        }
        super.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* bridge */ /* synthetic */ void zzu(Object obj, zzxm zzxmVar, zzbf zzbfVar) {
        int iZzc;
        Integer num = (Integer) obj;
        if (this.zzh != null) {
            return;
        }
        if (this.zzf == -1) {
            iZzc = zzbfVar.zzc();
            this.zzf = iZzc;
        } else {
            int iZzc2 = zzbfVar.zzc();
            int i = this.zzf;
            if (iZzc2 != i) {
                this.zzh = new zzxz(0);
                return;
            }
            iZzc = i;
        }
        if (this.zzg.length == 0) {
            this.zzg = (long[][]) Array.newInstance((Class<?>) Long.TYPE, iZzc, this.zzd.length);
        }
        ArrayList arrayList = this.zze;
        arrayList.remove(zzxmVar);
        zzbf[] zzbfVarArr = this.zzd;
        zzbfVarArr[num.intValue()] = zzbfVar;
        if (arrayList.isEmpty()) {
            zze(zzbfVarArr[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* bridge */ /* synthetic */ zzxk zzx(Object obj, zzxk zzxkVar) {
        int iIntValue = ((Integer) obj).intValue();
        List list = this.zzc;
        List list2 = (List) list.get(iIntValue);
        for (int i = 0; i < list2.size(); i++) {
            if (((zzya) list2.get(i)).zza().equals(zzxkVar)) {
                return ((zzya) ((List) list.get(0)).get(i)).zza();
            }
        }
        return null;
    }
}
