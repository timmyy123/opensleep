package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdqd {
    public static final zzdqd zza = new zzdqd(new zzdqc());
    private final zzbnc zzb;
    private final zzbmz zzc;
    private final zzbnp zzd;
    private final zzbnm zze;
    private final zzbsk zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdqd(zzdqc zzdqcVar) {
        this.zzb = zzdqcVar.zza;
        this.zzc = zzdqcVar.zzb;
        this.zzd = zzdqcVar.zzc;
        this.zzg = new SimpleArrayMap(zzdqcVar.zzf);
        this.zzh = new SimpleArrayMap(zzdqcVar.zzg);
        this.zze = zzdqcVar.zzd;
        this.zzf = zzdqcVar.zze;
    }

    public final zzbnc zza() {
        return this.zzb;
    }

    public final zzbmz zzb() {
        return this.zzc;
    }

    public final zzbnp zzc() {
        return this.zzd;
    }

    public final zzbnm zzd() {
        return this.zze;
    }

    public final zzbsk zze() {
        return this.zzf;
    }

    public final zzbni zzf(String str) {
        if (str == null) {
            return null;
        }
        return (zzbni) this.zzg.get(str);
    }

    public final zzbnf zzg(String str) {
        return (zzbnf) this.zzh.get(str);
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        SimpleArrayMap simpleArrayMap = this.zzg;
        ArrayList arrayList = new ArrayList(simpleArrayMap.getSize());
        for (int i = 0; i < simpleArrayMap.getSize(); i++) {
            arrayList.add((String) simpleArrayMap.keyAt(i));
        }
        return arrayList;
    }

    public /* synthetic */ zzdqd(zzdqc zzdqcVar, byte[] bArr) {
        this(zzdqcVar);
    }
}
