package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzui implements zzuv {
    private final String zza;
    private final ListenableFuture zzb;
    private final zztv zzc;
    private final Executor zzd;
    private final zzru zze;
    private final Optional zzf;
    private final zzwb zzg;
    private final Object zzh = new Object();
    private final ExecutionSequencer zzi = ExecutionSequencer.create();
    private ListenableFuture zzj = null;

    public zzui(String str, ListenableFuture listenableFuture, zztv zztvVar, Executor executor, zzru zzruVar, Optional optional, zzwb zzwbVar) {
        this.zza = str;
        this.zzb = Futures.nonCancellationPropagating(listenableFuture);
        this.zzc = zztvVar;
        this.zzd = MoreExecutors.newSequentialExecutor(executor);
        this.zze = zzruVar;
        this.zzf = optional;
        this.zzg = zzwbVar;
    }

    public static zzuw zza() {
        return zztx.zza;
    }

    private final Object zzm(Uri uri) throws IOException {
        try {
            try {
                zzwb zzwbVar = this.zzg;
                String str = this.zza;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5);
                sb.append("Read ");
                sb.append(str);
                zzwi zzwiVarZza = zzwbVar.zza(sb.toString(), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
                try {
                    InputStream inputStream = (InputStream) this.zze.zza(uri, zzst.zzb());
                    try {
                        zztv zztvVar = this.zzc;
                        zzafc zzafcVar = (zzafc) ((zzve) zztvVar).zzb().zzcj().zza(inputStream, ((zzve) zztvVar).zzc());
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        zzwiVarZza.close();
                        return zzafcVar;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        zzwiVarZza.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                if (this.zze.zzc(uri)) {
                    throw e;
                }
                return this.zzc.zza();
            }
        } catch (IOException e2) {
            throw zzux.zza(this.zze, uri, e2, this.zza);
        }
    }

    private final void zzn(Uri uri, Object obj) throws IOException {
        Uri uriZza = zzuz.zza(uri, ".tmp");
        try {
            zzwb zzwbVar = this.zzg;
            String str = this.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6);
            sb.append("Write ");
            sb.append(str);
            zzwi zzwiVarZza = zzwbVar.zza(sb.toString(), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
            try {
                zzse zzseVar = new zzse();
                try {
                    zzru zzruVar = this.zze;
                    zzsw zzswVarZzb = zzsw.zzb();
                    zzswVarZzb.zzc(zzseVar);
                    OutputStream outputStream = (OutputStream) zzruVar.zza(uriZza, zzswVarZzb);
                    try {
                        ((zzafc) obj).zzce(outputStream);
                        zzseVar.zzc();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        zzwiVarZza.close();
                        this.zze.zzd(uriZza, uri);
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    throw zzux.zza(this.zze, uri, e, this.zza);
                }
            } finally {
            }
        } catch (IOException e2) {
            zzru zzruVar2 = this.zze;
            if (zzruVar2.zzc(uriZza)) {
                try {
                    zzruVar2.zzb(uriZza);
                } catch (IOException e3) {
                    e2.addSuppressed(e3);
                }
            }
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c A[Catch: all -> 0x0013, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000d, B:13:0x0016, B:14:0x0018, B:16:0x001c, B:17:0x0033, B:18:0x0035), top: B:25:0x0003, inners: #0 }] */
    @Override // com.google.android.gms.internal.measurement.zzuv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ListenableFuture zzb(final AsyncFunction asyncFunction, final Executor executor, zzuu zzuuVar) {
        final ListenableFuture listenableFuture;
        synchronized (this.zzh) {
            ListenableFuture listenableFuture2 = this.zzj;
            if (listenableFuture2 == null || !listenableFuture2.isDone()) {
                if (this.zzj == null) {
                    this.zzj = Futures.nonCancellationPropagating(this.zzi.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzub
                        @Override // com.google.common.util.concurrent.AsyncCallable
                        public final /* synthetic */ ListenableFuture call() {
                            return this.zza.zzf();
                        }
                    }), this.zzd));
                }
                listenableFuture = this.zzj;
            } else {
                try {
                    Futures.getDone(this.zzj);
                } catch (ExecutionException unused) {
                    this.zzj = null;
                }
                if (this.zzj == null) {
                }
                listenableFuture = this.zzj;
            }
        }
        return this.zzi.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zztz
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final /* synthetic */ ListenableFuture call() {
                final zzui zzuiVar = this.zza;
                final ListenableFuture listenableFutureTransformAsync = Futures.transformAsync(listenableFuture, new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzua
                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final /* synthetic */ ListenableFuture apply(Object obj) {
                        return zzuiVar.zze(obj);
                    }
                }, MoreExecutors.directExecutor());
                final ListenableFuture listenableFutureTransformAsync2 = Futures.transformAsync(listenableFutureTransformAsync, asyncFunction, executor);
                return Futures.transformAsync(listenableFutureTransformAsync2, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuc
                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final /* synthetic */ ListenableFuture apply(Object obj) {
                        return zzuiVar.zzg(listenableFutureTransformAsync, listenableFutureTransformAsync2, obj);
                    }
                }), MoreExecutors.directExecutor());
            }
        }), MoreExecutors.directExecutor());
    }

    @Override // com.google.android.gms.internal.measurement.zzuv
    public final String zzc() {
        return this.zza;
    }

    public final /* synthetic */ ListenableFuture zzd() {
        return Futures.nonCancellationPropagating(Futures.transformAsync(this.zzb, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzug
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzk((Uri) obj);
            }
        }), this.zzd));
    }

    public final /* synthetic */ ListenableFuture zze(Object obj) {
        ListenableFuture listenableFuture;
        synchronized (this.zzh) {
            listenableFuture = this.zzj;
        }
        return listenableFuture;
    }

    public final /* synthetic */ ListenableFuture zzf() {
        try {
            return Futures.immediateFuture(zzm((Uri) Futures.getDone(this.zzb)));
        } catch (IOException e) {
            zzty zztyVar = new zzty(this, null);
            Optional optional = this.zzf;
            return !optional.isPresent() ? Futures.immediateFailedFuture(e) : ((e instanceof zzsg) || (e.getCause() instanceof zzsg)) ? Futures.immediateFailedFuture(e) : Futures.transformAsync(((zztf) optional.get()).zza(e, zztyVar), zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzue
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final /* synthetic */ ListenableFuture apply(Object obj) {
                    return this.zza.zzi((Void) obj);
                }
            }), this.zzd);
        }
    }

    public final /* synthetic */ ListenableFuture zzg(ListenableFuture listenableFuture, final ListenableFuture listenableFuture2, Object obj) {
        if (Futures.getDone(listenableFuture).equals(Futures.getDone(listenableFuture2))) {
            return Futures.immediateFuture(obj);
        }
        ListenableFuture listenableFutureTransformAsync = Futures.transformAsync(listenableFuture2, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzud
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj2) {
                return this.zza.zzh(listenableFuture2, obj2);
            }
        }), this.zzd);
        synchronized (this.zzh) {
        }
        return listenableFutureTransformAsync;
    }

    public final /* synthetic */ ListenableFuture zzh(ListenableFuture listenableFuture, Object obj) throws IOException {
        zzn((Uri) Futures.getDone(this.zzb), obj);
        synchronized (this.zzh) {
            this.zzj = listenableFuture;
        }
        return Futures.immediateFuture(obj);
    }

    public final /* synthetic */ ListenableFuture zzi(Void r1) {
        return Futures.immediateFuture(zzm((Uri) Futures.getDone(this.zzb)));
    }

    public final /* synthetic */ ListenableFuture zzj(Object obj) throws IOException {
        zzn((Uri) Futures.getDone(this.zzb), obj);
        return Futures.immediateVoidFuture();
    }

    public final /* synthetic */ ListenableFuture zzk(Uri uri) {
        Uri uriZza = zzuz.zza(uri, ".bak");
        try {
            zzru zzruVar = this.zze;
            if (zzruVar.zzc(uriZza)) {
                zzruVar.zzd(uriZza, uri);
            }
            return Futures.immediateVoidFuture();
        } catch (IOException e) {
            return Futures.immediateFailedFuture(e);
        }
    }

    public final /* synthetic */ ListenableFuture zzl(ListenableFuture listenableFuture) {
        return Futures.transformAsync(listenableFuture, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuf
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzj(obj);
            }
        }), this.zzd);
    }
}
