package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
final class zzatr implements zzatd {
    private final Map zza = new HashMap();
    private final zzasq zzb;
    private final BlockingQueue zzc;
    private final zzasv zzd;

    public zzatr(zzasq zzasqVar, BlockingQueue blockingQueue, zzasv zzasvVar) {
        this.zzd = zzasvVar;
        this.zzb = zzasqVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzatd
    public final void zza(zzate zzateVar, zzatk zzatkVar) {
        List list;
        zzasn zzasnVar = zzatkVar.zzb;
        if (zzasnVar == null || zzasnVar.zza(System.currentTimeMillis())) {
            zzb(zzateVar);
            return;
        }
        String strZzi = zzateVar.zzi();
        synchronized (this) {
            list = (List) this.zza.remove(strZzi);
        }
        if (list != null) {
            if (zzatq.zzb) {
                zzatq.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strZzi);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzd.zza((zzate) it.next(), zzatkVar, null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatd
    public final synchronized void zzb(zzate zzateVar) {
        try {
            Map map = this.zza;
            String strZzi = zzateVar.zzi();
            List list = (List) map.remove(strZzi);
            if (list == null || list.isEmpty()) {
                return;
            }
            if (zzatq.zzb) {
                zzatq.zza("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strZzi);
            }
            zzate zzateVar2 = (zzate) list.remove(0);
            map.put(strZzi, list);
            zzateVar2.zzu(this);
            try {
                this.zzc.put(zzateVar2);
            } catch (InterruptedException e) {
                zzatq.zzc("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzb.zza();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzc(zzate zzateVar) {
        try {
            Map map = this.zza;
            String strZzi = zzateVar.zzi();
            if (!map.containsKey(strZzi)) {
                map.put(strZzi, null);
                zzateVar.zzu(this);
                if (zzatq.zzb) {
                    zzatq.zzb("new request, sending to network %s", strZzi);
                }
                return false;
            }
            List arrayList = (List) map.get(strZzi);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            zzateVar.zzc("waiting-for-response");
            arrayList.add(zzateVar);
            map.put(strZzi, arrayList);
            if (zzatq.zzb) {
                zzatq.zzb("Request for cacheKey=%s is in flight, putting on hold.", strZzi);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
