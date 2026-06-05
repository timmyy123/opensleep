package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzui {
    public final int zza;
    public final zzxk zzb;
    private final CopyOnWriteArrayList zzc;

    private zzui(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzxk zzxkVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzxkVar;
    }

    public final zzui zza(int i, zzxk zzxkVar) {
        return new zzui(this.zzc, 0, zzxkVar);
    }

    public final void zzb(Handler handler, zzuj zzujVar) {
        this.zzc.add(new zzuh(handler, zzujVar));
    }

    public final void zzc(zzuj zzujVar) {
        CopyOnWriteArrayList<zzuh> copyOnWriteArrayList = this.zzc;
        for (zzuh zzuhVar : copyOnWriteArrayList) {
            if (zzuhVar.zza == zzujVar) {
                copyOnWriteArrayList.remove(zzuhVar);
            }
        }
    }

    public zzui() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
