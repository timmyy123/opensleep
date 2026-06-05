package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhay extends zzhbc {
    private static final zzhce zza = new zzhce(zzhay.class);
    private zzgwi zzb;
    private final boolean zzc;
    private final boolean zzd;

    public zzhay(zzgwi zzgwiVar, boolean z, boolean z2) {
        super(zzgwiVar.size());
        this.zzb = zzgwiVar;
        this.zzc = z;
        this.zzd = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
    public final void zzy(int i, ListenableFuture listenableFuture) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, listenableFuture);
            }
            zzz(null);
        } catch (Throwable th) {
            zzz(null);
            throw th;
        }
    }

    private final void zzE(Throwable th) {
        th.getClass();
        if (this.zzc && !zzb(th) && zzI(zzB(), th)) {
            zzF(th);
        } else if (th instanceof Error) {
            zzF(th);
        }
    }

    private static void zzF(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private final void zzG(int i, Future future) {
        try {
            zzw(i, zzhcx.zza(future));
        } catch (ExecutionException e) {
            zzE(e.getCause());
        } catch (Throwable th) {
            zzE(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzz(zzgwi zzgwiVar) {
        int iZzC = zzC();
        int i = 0;
        zzgtj.zzj(iZzC >= 0, "Less than 0 remaining futures");
        if (iZzC == 0) {
            if (zzgwiVar != null) {
                zzgza zzgzaVarZza = zzgwiVar.zza();
                while (zzgzaVarZza.hasNext()) {
                    Future future = (Future) zzgzaVarZza.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            this.seenExceptionsField = null;
            zzx();
            zzA(2);
        }
    }

    private static boolean zzI(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public void zzA(int i) {
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    public final void zzc() {
        zzgwi zzgwiVar = this.zzb;
        zzA(1);
        if ((zzgwiVar != null) && isCancelled()) {
            boolean zZzj = zzj();
            zzgza zzgzaVarZza = zzgwiVar.zza();
            while (zzgzaVarZza.hasNext()) {
                ((Future) zzgzaVarZza.next()).cancel(zZzj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    public final String zzd() {
        zzgwi zzgwiVar = this.zzb;
        return zzgwiVar != null ? "futures=".concat(zzgwiVar.toString()) : super.zzd();
    }

    public final void zze() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzx();
            return;
        }
        boolean z = this.zzc;
        zzgwi zzgwiVar = this.zzb;
        if (!z) {
            final zzgwi zzgwiVar2 = true != this.zzd ? null : zzgwiVar;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzhaw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzz(zzgwiVar2);
                }
            };
            zzgza zzgzaVarZza = zzgwiVar.zza();
            while (zzgzaVarZza.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) zzgzaVarZza.next();
                if (listenableFuture.isDone()) {
                    zzz(zzgwiVar2);
                } else {
                    listenableFuture.addListener(runnable, zzhbl.INSTANCE);
                }
            }
            return;
        }
        zzgza zzgzaVarZza2 = zzgwiVar.zza();
        final int i = 0;
        while (zzgzaVarZza2.hasNext()) {
            final ListenableFuture listenableFuture2 = (ListenableFuture) zzgzaVarZza2.next();
            int i2 = i + 1;
            if (listenableFuture2.isDone()) {
                zzy(i, listenableFuture2);
            } else {
                listenableFuture2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzhax
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzy(i, listenableFuture2);
                    }
                }, zzhbl.INSTANCE);
            }
            i = i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbc
    public final void zzf(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        Throwable thZzl = zzl();
        Objects.requireNonNull(thZzl);
        zzI(set, thZzl);
    }

    public abstract void zzw(int i, Object obj);

    public abstract void zzx();
}
