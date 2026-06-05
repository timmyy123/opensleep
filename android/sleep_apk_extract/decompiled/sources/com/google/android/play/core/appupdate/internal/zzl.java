package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzl {
    protected final zzm zza;
    private final IntentFilter zzc;
    private final Context zzd;
    protected final Set zzb = new HashSet();
    private zzk zze = null;
    private volatile boolean zzf = false;

    public zzl(zzm zzmVar, IntentFilter intentFilter, Context context) {
        this.zza = zzmVar;
        this.zzc = intentFilter;
        this.zzd = zzz.zza(context);
    }

    private final void zze() {
        zzk zzkVar;
        if (!this.zzb.isEmpty() && this.zze == null) {
            zzk zzkVar2 = new zzk(this, null);
            this.zze = zzkVar2;
            int i = Build.VERSION.SDK_INT;
            Context context = this.zzd;
            if (i >= 33) {
                context.registerReceiver(zzkVar2, this.zzc, 2);
            } else {
                context.registerReceiver(zzkVar2, this.zzc);
            }
        }
        if (!this.zzb.isEmpty() || (zzkVar = this.zze) == null) {
            return;
        }
        this.zzd.unregisterReceiver(zzkVar);
        this.zze = null;
    }

    public abstract void zza(Context context, Intent intent);

    public final synchronized void zzb(StateUpdatedListener stateUpdatedListener) {
        this.zza.zzd("registerListener", new Object[0]);
        zzac.zza(stateUpdatedListener, "Registered Play Core listener should not be null.");
        this.zzb.add(stateUpdatedListener);
        zze();
    }

    public final synchronized void zzc(StateUpdatedListener stateUpdatedListener) {
        this.zza.zzd("unregisterListener", new Object[0]);
        zzac.zza(stateUpdatedListener, "Unregistered Play Core listener should not be null.");
        this.zzb.remove(stateUpdatedListener);
        zze();
    }

    public final synchronized void zzd(Object obj) {
        Iterator it = new HashSet(this.zzb).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(obj);
        }
    }
}
