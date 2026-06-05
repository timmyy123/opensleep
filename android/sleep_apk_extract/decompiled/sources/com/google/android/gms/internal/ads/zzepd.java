package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzepd {
    private final Clock zza;
    private final zzepf zzb;
    private final zzfsc zzc;
    private final LinkedHashMap zzd = new LinkedHashMap();
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhN)).booleanValue();
    private final zzelx zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;

    public zzepd(Clock clock, zzepf zzepfVar, zzelx zzelxVar, zzfsc zzfscVar) {
        this.zza = clock;
        this.zzb = zzepfVar;
        this.zzf = zzelxVar;
        this.zzc = zzfscVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final synchronized boolean zzi(zzfkf zzfkfVar) {
        zzepc zzepcVar = (zzepc) this.zzd.get(zzfkfVar);
        if (zzepcVar == null) {
            return false;
        }
        return zzepcVar.zzc == 8;
    }

    public final synchronized void zza() {
        this.zzi = this.zza.elapsedRealtime();
    }

    public final synchronized void zzb() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzc(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfkf zzfkfVar = (zzfkf) it.next();
            String str = zzfkfVar.zzw;
            if (!TextUtils.isEmpty(str)) {
                this.zzd.put(zzfkfVar, new zzepc(str, zzfkfVar.zzaf, Integer.MAX_VALUE, 0L, null));
            }
        }
    }

    public final synchronized void zzd(zzfkf zzfkfVar) {
        try {
            this.zzh = this.zza.elapsedRealtime() - this.zzi;
            if (zzfkfVar != null) {
                this.zzf.zzi(zzfkfVar);
            }
            this.zzg = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized ListenableFuture zze(zzfkq zzfkqVar, zzfkf zzfkfVar, ListenableFuture listenableFuture, zzfry zzfryVar) {
        zzfki zzfkiVar = zzfkqVar.zzb.zzb;
        long jElapsedRealtime = this.zza.elapsedRealtime();
        String str = zzfkfVar.zzw;
        if (str != null) {
            this.zzd.put(zzfkfVar, new zzepc(str, zzfkfVar.zzaf, 9, 0L, null));
            zzhbw.zzr(listenableFuture, new zzepb(this, jElapsedRealtime, zzfkiVar, zzfkfVar, str, zzfryVar, zzfkqVar), zzcfr.zzh);
        }
        return listenableFuture;
    }

    public final synchronized void zzf(zzfkf zzfkfVar) {
        zzepc zzepcVar = (zzepc) this.zzd.get(zzfkfVar);
        if (zzepcVar == null || this.zzg) {
            return;
        }
        zzepcVar.zzc = 8;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.zzd.entrySet().iterator();
            while (it.hasNext()) {
                zzepc zzepcVar = (zzepc) ((Map.Entry) it.next()).getValue();
                if (zzepcVar.zzc != Integer.MAX_VALUE) {
                    arrayList.add(zzepcVar.toString());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized long zzh() {
        return this.zzh;
    }

    public final /* synthetic */ Clock zzj() {
        return this.zza;
    }

    public final /* synthetic */ zzepf zzk() {
        return this.zzb;
    }

    public final /* synthetic */ zzfsc zzl() {
        return this.zzc;
    }

    public final /* synthetic */ LinkedHashMap zzm() {
        return this.zzd;
    }

    public final /* synthetic */ boolean zzn() {
        return this.zze;
    }

    public final /* synthetic */ zzelx zzo() {
        return this.zzf;
    }

    public final /* synthetic */ boolean zzp() {
        return this.zzg;
    }
}
