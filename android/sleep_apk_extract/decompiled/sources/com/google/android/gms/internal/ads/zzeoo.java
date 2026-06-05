package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class zzeoo {
    private final zzhcp zzc;
    private zzepe zzf;
    private final String zzh;
    private final int zzi;
    private final zzepd zzj;
    private zzfkf zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;
    private boolean zzl = false;

    public zzeoo(zzfkq zzfkqVar, zzepd zzepdVar, zzhcp zzhcpVar) {
        this.zzi = zzfkqVar.zzb.zzb.zzr;
        this.zzj = zzepdVar;
        this.zzc = zzhcpVar;
        this.zzh = zzepk.zzb(zzfkqVar);
        List list = zzfkqVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfkf) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized boolean zze() {
        if (this.zzl) {
            return false;
        }
        List list = this.zzb;
        if (!list.isEmpty() && ((zzfkf) list.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list2 = this.zzd;
            if (list2.size() < this.zzi) {
                if (zzf(false)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzf(boolean z) {
        try {
            for (zzfkf zzfkfVar : this.zzb) {
                Integer num = (Integer) this.zza.get(zzfkfVar);
                int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
                if (z || !this.zze.contains(zzfkfVar.zzat)) {
                    int i = this.zzg;
                    if (iIntValue < i) {
                        return true;
                    }
                    if (iIntValue > i) {
                        break;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzg() {
        try {
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) this.zza.get((zzfkf) it.next());
                if ((num != null ? num.intValue() : Integer.MAX_VALUE) < this.zzg) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzh() {
        if (!zzf(true)) {
            if (!zzg()) {
                return false;
            }
        }
        return true;
    }

    private final synchronized void zzi() {
        this.zzj.zzd(this.zzk);
        zzepe zzepeVar = this.zzf;
        zzhcp zzhcpVar = this.zzc;
        if (zzepeVar != null) {
            zzhcpVar.zza(zzepeVar);
        } else {
            zzhcpVar.zzb(new zzeph(3, this.zzh));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r2.zzav == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        r6.zzl = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r4.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r6.zzd.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        return (com.google.android.gms.internal.ads.zzfkf) r1.remove(r0);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized zzfkf zza() {
        try {
            if (zze()) {
                int i = 0;
                while (true) {
                    List list = this.zzb;
                    if (i >= list.size()) {
                        break;
                    }
                    zzfkf zzfkfVar = (zzfkf) list.get(i);
                    String str = zzfkfVar.zzat;
                    Set set = this.zze;
                    if (!set.contains(str)) {
                        break;
                    }
                    i++;
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(zzepe zzepeVar, zzfkf zzfkfVar) {
        this.zzl = false;
        this.zzd.remove(zzfkfVar);
        if (zzd()) {
            zzepeVar.zzm();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfkfVar);
        int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
        if (iIntValue > this.zzg) {
            this.zzj.zzf(zzfkfVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzf(this.zzk);
        }
        this.zzg = iIntValue;
        this.zzf = zzepeVar;
        this.zzk = zzfkfVar;
        if (zzh()) {
            return;
        }
        zzi();
    }

    public final synchronized void zzc(Throwable th, zzfkf zzfkfVar) {
        this.zzl = false;
        this.zzd.remove(zzfkfVar);
        this.zze.remove(zzfkfVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zzi();
    }

    public final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
