package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class zzbp extends zzfk {
    private final ListenerHolder zza;
    private final Set zzb = new ArraySet();

    public zzbp(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzg(zzgn zzgnVar) {
        if (zzgnVar.zza() != null) {
            return zzgnVar.zzb() == null || "__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(zzgnVar.zzb());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzfl
    public final synchronized void zzb(zzgl zzglVar) {
        this.zza.notifyListener(new zzbl(this, zzglVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzfl
    public final synchronized void zzc(zzgn zzgnVar) {
        try {
            if (!zzg(zzgnVar)) {
                this.zzb.add(zzgnVar.zzb());
            }
            this.zza.notifyListener(new zzbm(this, zzgnVar));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzfl
    public final synchronized void zzd(zzgp zzgpVar) {
        this.zzb.remove(zzgpVar.zza());
        this.zza.notifyListener(new zzbn(this, zzgpVar));
    }

    public final synchronized void zze() {
        try {
            Iterator it = this.zzb.iterator();
            while (it.hasNext()) {
                this.zza.notifyListener(new zzbo(this, (String) it.next()));
            }
            this.zzb.clear();
        } catch (Throwable th) {
            throw th;
        }
    }
}
