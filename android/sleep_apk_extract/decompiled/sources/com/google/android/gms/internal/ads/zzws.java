package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzws extends zzwj {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzin zzc;

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void zzM() {
        for (zzwr zzwrVar : this.zza.values()) {
            zzwrVar.zza.zzq(zzwrVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public void zza(zzin zzinVar) {
        this.zzc = zzinVar;
        this.zzb = zzfl.zzd(null);
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void zzc() {
        for (zzwr zzwrVar : this.zza.values()) {
            zzwrVar.zza.zzr(zzwrVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public void zzd() {
        HashMap map = this.zza;
        for (zzwr zzwrVar : map.values()) {
            zzxm zzxmVar = zzwrVar.zza;
            zzxmVar.zzs(zzwrVar.zzb);
            zzwq zzwqVar = zzwrVar.zzc;
            zzxmVar.zzm(zzwqVar);
            zzxmVar.zzo(zzwqVar);
        }
        map.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public void zzt() {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((zzwr) it.next()).zza.zzt();
        }
    }

    public abstract void zzu(Object obj, zzxm zzxmVar, zzbf zzbfVar);

    public final void zzv(final Object obj, zzxm zzxmVar) {
        HashMap map = this.zza;
        zzgtj.zza(!map.containsKey(obj));
        zzxl zzxlVar = new zzxl() { // from class: com.google.android.gms.internal.ads.zzwp
            @Override // com.google.android.gms.internal.ads.zzxl
            public final /* synthetic */ void zza(zzxm zzxmVar2, zzbf zzbfVar) {
                this.zza.zzu(obj, zzxmVar2, zzbfVar);
            }
        };
        zzwq zzwqVar = new zzwq(this, obj);
        map.put(obj, new zzwr(zzxmVar, zzxlVar, zzwqVar));
        Handler handler = this.zzb;
        handler.getClass();
        zzxmVar.zzl(handler, zzwqVar);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzxmVar.zzn(handler2, zzwqVar);
        zzxmVar.zzp(zzxlVar, this.zzc, zzk());
        if (zzj()) {
            return;
        }
        zzxmVar.zzr(zzxlVar);
    }

    public int zzw(Object obj, int i) {
        return 0;
    }

    public abstract zzxk zzx(Object obj, zzxk zzxkVar);

    public long zzy(Object obj, long j, zzxk zzxkVar) {
        return j;
    }
}
