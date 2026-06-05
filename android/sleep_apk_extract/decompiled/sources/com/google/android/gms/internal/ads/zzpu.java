package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class zzpu implements zzqd {
    public static final zzgub zza = zzps.zza;
    private static final Random zzb = new Random();
    private zzqc zzf;
    private String zzh;
    private final zzbe zzc = new zzbe();
    private final zzbd zzd = new zzbd();
    private final HashMap zze = new HashMap();
    private zzbf zzg = zzbf.zza;
    private long zzi = -1;

    public zzpu(zzgub zzgubVar) {
    }

    private final void zzl(zznn zznnVar) {
        if (zznnVar.zzb.zzg()) {
            String str = this.zzh;
            if (str != null) {
                zzpt zzptVar = (zzpt) this.zze.get(str);
                zzptVar.getClass();
                zzm(zzptVar);
                return;
            }
            return;
        }
        zzpt zzptVar2 = (zzpt) this.zze.get(this.zzh);
        int i = zznnVar.zzc;
        zzxk zzxkVar = zznnVar.zzd;
        this.zzh = zzo(i, zzxkVar).zze();
        zzc(zznnVar);
        if (zzxkVar == null || !zzxkVar.zzb()) {
            return;
        }
        if (zzptVar2 != null) {
            if (zzptVar2.zzg() == zzxkVar.zzd && zzptVar2.zzh() != null) {
                zzxk zzxkVarZzh = zzptVar2.zzh();
                if (zzxkVarZzh.zzb == zzxkVar.zzb) {
                    zzxk zzxkVarZzh2 = zzptVar2.zzh();
                    if (zzxkVarZzh2.zzc == zzxkVar.zzc) {
                        return;
                    }
                }
            }
        }
        zzo(i, new zzxk(zzxkVar.zza, zzxkVar.zzd));
    }

    private final void zzm(zzpt zzptVar) {
        if (zzptVar.zzg() != -1 && zzptVar.zzi()) {
            this.zzi = zzptVar.zzg();
        }
        this.zzh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final long zzi() {
        zzpt zzptVar = (zzpt) this.zze.get(this.zzh);
        return (zzptVar == null || zzptVar.zzg() == -1) ? this.zzi + 1 : zzptVar.zzg();
    }

    private final zzpt zzo(int i, zzxk zzxkVar) {
        HashMap map = this.zze;
        long j = Long.MAX_VALUE;
        zzpt zzptVar = null;
        for (zzpt zzptVar2 : map.values()) {
            zzptVar2.zzc(i, zzxkVar);
            if (zzptVar2.zzb(i, zzxkVar)) {
                long jZzg = zzptVar2.zzg();
                if (jZzg == -1 || jZzg < j) {
                    zzptVar = zzptVar2;
                    j = jZzg;
                } else if (jZzg == j) {
                    String str = zzfl.zza;
                    if (zzptVar.zzh() != null && zzptVar2.zzh() != null) {
                        zzptVar = zzptVar2;
                    }
                }
            }
        }
        if (zzptVar != null) {
            return zzptVar;
        }
        String strZzp = zzp();
        zzpt zzptVar3 = new zzpt(this, strZzp, i, zzxkVar);
        map.put(strZzp, zzptVar3);
        return zzptVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzp() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zza(zzqc zzqcVar) {
        this.zzf = zzqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized String zzb(zzbf zzbfVar, zzxk zzxkVar) {
        return zzo(zzbfVar.zzo(zzxkVar.zza, this.zzd).zzc, zzxkVar).zze();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[Catch: all -> 0x0024, TryCatch #0 {all -> 0x0024, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001b, B:17:0x0027, B:19:0x0033, B:21:0x003b, B:23:0x0043, B:25:0x004d, B:28:0x0056, B:30:0x005c, B:32:0x0071, B:33:0x008a, B:35:0x0090, B:36:0x0093, B:38:0x009f, B:40:0x00a5, B:46:0x00b6), top: B:49:0x0001 }] */
    @Override // com.google.android.gms.internal.ads.zzqd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzc(zznn zznnVar) {
        try {
            if (this.zzf == null) {
                throw null;
            }
            zzbf zzbfVar = zznnVar.zzb;
            if (!zzbfVar.zzg()) {
                zzxk zzxkVar = zznnVar.zzd;
                if (zzxkVar != null) {
                    long j = zzxkVar.zzd;
                    if (j == -1 || j >= zzi()) {
                        zzpt zzptVar = (zzpt) this.zze.get(this.zzh);
                        if (zzptVar == null || zzptVar.zzg() != -1 || zzptVar.zzf() == zznnVar.zzc) {
                            int i = zznnVar.zzc;
                            zzpt zzptVarZzo = zzo(i, zzxkVar);
                            if (this.zzh == null) {
                                this.zzh = zzptVarZzo.zze();
                            }
                            if (zzxkVar != null && zzxkVar.zzb()) {
                                Object obj = zzxkVar.zza;
                                long j2 = zzxkVar.zzd;
                                int i2 = zzxkVar.zzb;
                                zzpt zzptVarZzo2 = zzo(i, new zzxk(obj, j2, i2));
                                if (!zzptVarZzo2.zzi()) {
                                    zzptVarZzo2.zzj(true);
                                    zzbd zzbdVar = this.zzd;
                                    zzbfVar.zzo(obj, zzbdVar);
                                    zzbdVar.zzc(i2);
                                    Math.max(0L, zzfl.zzr(0L) + zzfl.zzr(0L));
                                }
                            }
                            if (!zzptVarZzo.zzi()) {
                                zzptVarZzo.zzj(true);
                            }
                            if (zzptVarZzo.zze().equals(this.zzh) && !zzptVarZzo.zzk()) {
                                zzptVarZzo.zzl(true);
                                this.zzf.zzc(zznnVar, zzptVarZzo.zze());
                            }
                        }
                    }
                }
            }
        } finally {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized void zzd(zznn zznnVar) {
        try {
            if (this.zzf == null) {
                throw null;
            }
            zzbf zzbfVar = this.zzg;
            this.zzg = zznnVar.zzb;
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzpt zzptVar = (zzpt) it.next();
                if (!zzptVar.zza(zzbfVar, this.zzg) || zzptVar.zzd(zznnVar)) {
                    it.remove();
                    if (zzptVar.zze().equals(this.zzh)) {
                        zzm(zzptVar);
                    }
                    if (zzptVar.zzi()) {
                        this.zzf.zzd(zznnVar, zzptVar.zze(), false);
                    }
                }
            }
            zzl(zznnVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized void zze(zznn zznnVar, int i) {
        try {
            if (this.zzf == null) {
                throw null;
            }
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzpt zzptVar = (zzpt) it.next();
                if (zzptVar.zzd(zznnVar)) {
                    it.remove();
                    boolean zEquals = zzptVar.zze().equals(this.zzh);
                    if (zEquals) {
                        zzm(zzptVar);
                    }
                    if (zzptVar.zzi()) {
                        boolean z = false;
                        if (i == 0 && zEquals && zzptVar.zzk()) {
                            z = true;
                        }
                        this.zzf.zzd(zznnVar, zzptVar.zze(), z);
                    }
                }
            }
            zzl(zznnVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized String zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized void zzg(zznn zznnVar) {
        zzqc zzqcVar;
        try {
            String str = this.zzh;
            if (str != null) {
                zzpt zzptVar = (zzpt) this.zze.get(str);
                if (zzptVar == null) {
                    throw null;
                }
                zzm(zzptVar);
            }
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzpt zzptVar2 = (zzpt) it.next();
                it.remove();
                if (zzptVar2.zzi() && (zzqcVar = this.zzf) != null) {
                    zzqcVar.zzd(zznnVar, zzptVar2.zze(), false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final /* synthetic */ zzbe zzj() {
        return this.zzc;
    }

    public final /* synthetic */ zzbd zzk() {
        return this.zzd;
    }
}
