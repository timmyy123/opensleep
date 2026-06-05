package com.google.android.gms.internal.measurement;

import android.os.StrictMode;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzpg {
    private volatile zzqs zzd;
    private final zzlk zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final ImmutableSet zzi;
    private final zzps zzj;
    private final zzqt zzk;
    private static final zzpe zzc = new zzpe(null);
    static final zzon zza = new zzon(zzox.zza, false, false, false, false, ImmutableSet.of());

    public /* synthetic */ zzpg(zzlk zzlkVar, zzon zzonVar, String str, byte[] bArr) {
        this.zze = zzlkVar;
        String strZza = zzonVar.zza(zzlkVar.zzc());
        this.zzf = strZza;
        this.zzg = "";
        this.zzh = zzonVar.zzb();
        this.zzi = zzonVar.zzc();
        this.zzd = null;
        this.zzj = new zzps();
        this.zzk = new zzqt(zzlkVar, strZza, "", false);
    }

    public static zzpe zzd() {
        return zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:5:0x0005, B:7:0x0009, B:9:0x0013, B:28:0x009a, B:30:0x009e, B:32:0x00a4, B:12:0x001e, B:14:0x002b, B:16:0x0033, B:18:0x003d, B:21:0x0054, B:23:0x0079, B:24:0x0085, B:26:0x008d, B:34:0x00a8, B:35:0x00ab, B:36:0x00ac, B:8:0x000d), top: B:41:0x0005, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzqs zzq() {
        zzqs zzqsVarZzb;
        zzqs zzqsVar = this.zzd;
        if (zzqsVar != null) {
            return zzqsVar;
        }
        synchronized (this) {
            try {
                zzqsVarZzb = this.zzd;
                if (zzqsVarZzb == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                    try {
                        zzqs zzqsVarZza = this.zzk.zza();
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                        if (!zzqsVarZza.zzk()) {
                            zzlk zzlkVar = this.zze;
                            zzlkVar.zzd().zza();
                            if (this.zzh || this.zzk.zzb() || !zzqsVarZza.zzd().isEmpty()) {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoy
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzf();
                                    }
                                });
                                zzlkVar.zzk().zza(zzqsVarZza.zze(), this.zzi, this.zzf);
                                if (!this.zzg.equals("")) {
                                    zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoq
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzh();
                                        }
                                    });
                                }
                                if (this.zzk.zzb()) {
                                    zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzor
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzi();
                                        }
                                    });
                                }
                            } else {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzop
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzg();
                                    }
                                });
                                zzqsVarZzb = zzqs.zzb(zzqv.zzi(), zzqsVarZza);
                                if (this.zzh || !zzqsVarZzb.zzj()) {
                                    this.zzd = zzqsVarZzb;
                                }
                            }
                        }
                        zzqsVarZzb = zzqsVarZza;
                        if (this.zzh) {
                            this.zzd = zzqsVarZzb;
                        }
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzqsVarZzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzg() {
        final zzqt zzqtVar = this.zzk;
        final ListenableFuture listenableFutureZzd = zzqtVar.zzd(this.zzg);
        AsyncFunction asyncFunction = new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzpf
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzqtVar.zzc((zzqv) obj);
            }
        };
        zzlk zzlkVar = this.zze;
        Futures.transformAsync(listenableFutureZzd, asyncFunction, zzlkVar.zzg()).addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzov
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzm(listenableFutureZzd);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038 A[Catch: CancellationException -> 0x001d, ExecutionException -> 0x001f, TryCatch #3 {CancellationException -> 0x001d, ExecutionException -> 0x001f, blocks: (B:2:0x0000, B:4:0x0018, B:17:0x002a, B:19:0x0038, B:21:0x0040, B:27:0x004e, B:29:0x0052, B:11:0x0021, B:32:0x0070, B:13:0x0024, B:16:0x0029, B:25:0x0046, B:26:0x004d), top: B:38:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void zzm(ListenableFuture listenableFuture) {
        zzqs zzqsVar;
        try {
            zzqv zzqvVar = (zzqv) Futures.getDone(listenableFuture);
            zzqs zzqsVarZza = zzqs.zza(zzqvVar, new zzqr(6, 2));
            boolean z = this.zzh;
            Preconditions.checkNotNull(zzqsVarZza);
            if (z || (zzqsVar = this.zzd) == null) {
                synchronized (this) {
                    if (!z) {
                        zzqsVar = this.zzd;
                        if (zzqsVar != null) {
                            if (!zzqsVar.zzf().equals(zzqsVarZza.zzf())) {
                                zzqm zzqmVarZzj = this.zze.zzj();
                                if (zzqmVarZzj != null) {
                                    zzqmVarZzj.zza();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    this.zzd = zzqsVarZza;
                    this.zzj.zzb();
                }
            } else if (!zzqsVar.zzf().equals(zzqsVarZza.zzf())) {
            }
            if (this.zzh) {
                zzlk zzlkVar = this.zze;
                Futures.catching(zzlkVar.zzh().zzb(zzqvVar.zza()), Throwable.class, new Function() { // from class: com.google.android.gms.internal.measurement.zzow
                    @Override // com.google.common.base.Function
                    public final /* synthetic */ Object apply(Object obj) {
                        this.zza.zzn((Throwable) obj);
                        return null;
                    }
                }, zzlkVar.zzg());
            }
        } catch (CancellationException e) {
            e = e;
            if (e.getCause() instanceof SecurityException) {
                String str = this.zzf;
                Log.w("FlagStore", Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 64), "Unable to update local snapshot for ", str, ", may result in stale flags."), e);
            }
        } catch (ExecutionException e2) {
            e = e2;
            if (e.getCause() instanceof SecurityException) {
            }
        }
    }

    public final Object zza(String str, boolean z) {
        return zzq().zzf().get(str);
    }

    public final String zzb() {
        return this.zzf;
    }

    public final zzps zzc() {
        return this.zzj;
    }

    public final /* synthetic */ ListenableFuture zzf() {
        ListenableFuture listenableFutureZzb;
        zzqs zzqsVarZzq = zzq();
        String strZzd = zzqsVarZzq.zzd();
        zzlk zzlkVar = this.zze;
        zzqn zzqnVarZzc = zzlkVar.zzd().zzc(false);
        if (zzqnVarZzc.zze()) {
            if (Strings.isNullOrEmpty(strZzd) && !zzqnVarZzc.zzd()) {
                return Futures.immediateVoidFuture();
            }
            zzmb zzmbVarZzb = zzme.zzb();
            zzmbVarZzb.zzb(zzqsVarZzq.zzi());
            if (!Strings.isNullOrEmpty(strZzd)) {
                zzmbVarZzb.zza(strZzd);
            }
            if (zzqnVarZzc.zzd()) {
                zzmbVarZzb.zzc(this.zzf);
            }
            listenableFutureZzb = zzlkVar.zzh().zzc((zzme) zzmbVarZzb.zzbd());
        } else {
            if (Strings.isNullOrEmpty(strZzd)) {
                return Futures.immediateVoidFuture();
            }
            listenableFutureZzb = zzlkVar.zzh().zzb(strZzd);
        }
        return Futures.catchingAsync(listenableFutureZzb, zzmk.class, new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzos
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzj((zzmk) obj);
            }
        }, zzlkVar.zzg());
    }

    public final /* synthetic */ void zzh() {
        zzlk zzlkVar = this.zze;
        final ListenableFuture listenableFutureZza = zzpu.zza(zzlkVar, this.zzf, this.zzg);
        listenableFutureZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzot
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzk(listenableFutureZza);
            }
        }, zzlkVar.zzg());
    }

    public final /* synthetic */ void zzi() {
        this.zze.zzf().zza(zzabz.FILE, this.zzh, zzou.zza);
    }

    public final /* synthetic */ ListenableFuture zzj(zzmk zzmkVar) {
        int iZza = zzmkVar.zza();
        if ((iZza == 29501 || iZza == 29537 || iZza == 29538 || iZza == 29539 || iZza == 29540 || iZza == 29541 || iZza == 29542 || iZza == 29543 || iZza == 29544) && !this.zzk.zzb()) {
            zzg();
        }
        return Futures.immediateVoidFuture();
    }

    public final /* synthetic */ void zzk(ListenableFuture listenableFuture) {
        try {
            Futures.getDone(listenableFuture);
        } catch (Exception e) {
            String str = this.zzf;
            Log.w("FlagStore", Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 73), "Failed to store account on flag read for: ", str, " which may lead to stale flags."), e);
        }
    }

    public final /* synthetic */ Void zzn(Throwable th) {
        Log.w("FlagStore", "Failed to commit to updated flags for ".concat(String.valueOf(this.zzf)), th);
        return null;
    }

    public final /* synthetic */ boolean zzo() {
        if (!this.zzh) {
            return true;
        }
        zzqs zzqsVar = this.zzd;
        if (zzqsVar == null) {
            return false;
        }
        if (!zzqsVar.zzh() && !zzqsVar.zzg() && !this.zzk.zzb()) {
            return false;
        }
        synchronized (this) {
            try {
                zzqs zzqsVar2 = this.zzd;
                if (zzqsVar2 != null && (zzqsVar2.zzh() || zzqsVar2.zzg() || this.zzk.zzb())) {
                    this.zzd = null;
                    this.zzj.zzb();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return false;
    }
}
