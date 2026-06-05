package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfue extends zzgwe {
    private final LinkedList zza = new LinkedList();

    @Override // java.util.Collection, java.util.Queue
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzftm zzftmVar = (zzftm) obj;
        int iZzf = zzftmVar.zzf();
        LinkedList linkedList = this.zza;
        if (iZzf != 3) {
            linkedList.add(zzftmVar);
            return true;
        }
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            zzftm zzftmVar2 = (zzftm) listIterator.next();
            if (zzftmVar2.zzf() == 3) {
                double dZze = zzftmVar2.zze();
                double dZze2 = zzftmVar.zze();
                if (dZze < dZze2 || (dZze == dZze2 && zzftmVar2.zzc() > zzftmVar.zzc())) {
                    listIterator.set(zzftmVar);
                    zzftmVar = zzftmVar2;
                }
            }
        }
        linkedList.add(zzftmVar);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgwe
    public final Queue zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgwd
    public final /* synthetic */ Object zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgwb
    public final /* synthetic */ Collection zzc() {
        return this.zza;
    }
}
