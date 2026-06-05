package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class zzbf extends zzfd implements zzbt {
    private final ListenerHolder zza;
    private final Set zzb = new ArraySet();
    private final Set zzc = new ArraySet();

    public zzbf(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzfe
    public final void zzb(zzfz zzfzVar) {
        this.zza.notifyListener(new zzbc(this, zzfzVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzfe
    public final synchronized void zzc(zzgb zzgbVar) {
        this.zzb.add(zzgbVar.zzc());
        this.zza.notifyListener(new zzaz(this, zzgbVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzfe
    public final synchronized void zzd(zzgh zzghVar) {
        try {
            this.zzb.remove(zzghVar.zzb());
            Status statusZzG = zzch.zzG(zzghVar.zza());
            if (statusZzG.isSuccess()) {
                this.zzc.add(zzghVar.zzb());
            }
            this.zza.notifyListener(new zzba(this, zzghVar, statusZzG));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzfe
    public final synchronized void zze(zzgj zzgjVar) {
        this.zzc.remove(zzgjVar.zza());
        this.zza.notifyListener(new zzbb(this, zzgjVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzbt
    public final synchronized void zzf() {
        try {
            Iterator it = this.zzb.iterator();
            while (it.hasNext()) {
                this.zza.notifyListener(new zzbd(this, (String) it.next()));
            }
            this.zzb.clear();
            Iterator it2 = this.zzc.iterator();
            while (it2.hasNext()) {
                this.zza.notifyListener(new zzbe(this, (String) it2.next()));
            }
            this.zzc.clear();
        } catch (Throwable th) {
            throw th;
        }
    }
}
