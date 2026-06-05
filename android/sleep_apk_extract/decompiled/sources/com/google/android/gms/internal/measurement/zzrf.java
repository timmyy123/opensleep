package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes3.dex */
public final class zzrf {
    private static final Object zza = new Object();
    private static final Object zzb = new Object();
    private final Context zzc;
    private final Supplier zzd;
    private final Supplier zze;
    private final Supplier zzf;
    private final Supplier zzg;
    private final Supplier zzh;
    private final Uri zzi;
    private volatile zzni zzj;
    private final Uri zzk;
    private volatile zznk zzl;

    public zzrf(Context context, final Supplier supplier, Supplier supplier2, Supplier supplier3) {
        this.zzc = context;
        this.zze = supplier;
        this.zzd = supplier3;
        this.zzf = supplier2;
        zzrz zzrzVarZza = zzsa.zza(context);
        zzrzVarZza.zzb("phenotype_storage_info");
        zzrzVarZza.zzc("storage-info.pb");
        this.zzi = zzrzVarZza.zzd();
        zzrz zzrzVarZza2 = zzsa.zza(context);
        zzrzVarZza2.zzb("phenotype_storage_info");
        zzrzVarZza2.zzc("device-encrypted-storage-info.pb");
        if (zzky.zza()) {
            zzrzVarZza2.zza();
        }
        this.zzk = zzrzVarZza2.zzd();
        this.zzg = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzre
            @Override // com.google.common.base.Supplier
            public final /* synthetic */ Object get() {
                return this.zza.zzd();
            }
        });
        this.zzh = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzqy
            @Override // com.google.common.base.Supplier
            public final /* synthetic */ Object get() {
                return ((ListeningScheduledExecutorService) Preconditions.checkNotNull((ListeningScheduledExecutorService) supplier.get())).schedule((Callable) zzrd.zza, 10000L, TimeUnit.MILLISECONDS);
            }
        });
    }

    private final zzni zzg() {
        zzni zzniVarZzp;
        zzni zzniVar = this.zzj;
        if (zzniVar != null) {
            return zzniVar;
        }
        synchronized (zza) {
            try {
                zzniVarZzp = this.zzj;
                if (zzniVarZzp == null) {
                    zzniVarZzp = zzni.zzp();
                    if (zzky.zzc(this.zzc)) {
                        zzss zzssVarZzb = zzss.zzb(zzniVarZzp);
                        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
                        try {
                            try {
                                zzni zzniVar2 = (zzni) ((zzru) this.zzf.get()).zza(this.zzi, zzssVarZzb);
                                StrictMode.setThreadPolicy(threadPolicy);
                                zzniVarZzp = zzniVar2;
                            } finally {
                                StrictMode.setThreadPolicy(threadPolicy);
                            }
                        } catch (IOException unused) {
                        }
                        this.zzj = zzniVarZzp;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzniVarZzp;
    }

    public final ListenableFuture zza() {
        if (zzky.zzb(this.zzc) || zzg().zze() + TimeChart.DAY >= System.currentTimeMillis()) {
            return Futures.immediateVoidFuture();
        }
        return FluentFuture.from(Futures.nonCancellationPropagating((ListenableFuture) this.zzh.get())).transformAsync(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzrc
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzf((Void) obj);
            }
        }, (ListeningScheduledExecutorService) Preconditions.checkNotNull((ListeningScheduledExecutorService) this.zze.get()));
    }

    public final boolean zzb(boolean z, zzabz zzabzVar) {
        zzni zzniVarZzg = zzg();
        return zzniVarZzg.zzc() && zzniVarZzg.zzi().contains(zzabzVar);
    }

    public final zzqn zzc(boolean z) {
        zzni zzniVarZzg = zzg();
        return new zzqn(zzniVarZzg.zzc(), ImmutableList.copyOf((Collection) zzniVarZzg.zzi()), zzniVarZzg.zzb(), zzniVarZzg.zzd(), (zzniVarZzg.zzj() && zzniVarZzg.zzk().zzb() == ((long) Build.VERSION.SDK_INT)) ? zzniVarZzg.zzk().zza() : "", ImmutableList.copyOf((Collection) zzniVarZzg.zzf()), ImmutableList.copyOf((Collection) zzniVarZzg.zzh()), zzniVarZzg.zza(), zzniVarZzg.zzm(), zzniVarZzg.zzl(), zzniVarZzg.zzn());
    }

    public final /* synthetic */ ListenableFuture zzd() {
        ListeningScheduledExecutorService listeningScheduledExecutorService = (ListeningScheduledExecutorService) Preconditions.checkNotNull((ListeningScheduledExecutorService) this.zze.get());
        final FluentFuture fluentFutureTransform = FluentFuture.from(((zzmj) Preconditions.checkNotNull((zzmj) this.zzd.get())).zzd()).catching(zzmk.class, zzqz.zza, listeningScheduledExecutorService).transform(new Function() { // from class: com.google.android.gms.internal.measurement.zzra
            @Override // com.google.common.base.Function
            public final /* synthetic */ Object apply(Object obj) {
                this.zza.zze((zzno) obj);
                return null;
            }
        }, listeningScheduledExecutorService);
        fluentFutureTransform.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzrb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    Futures.getDone(fluentFutureTransform);
                } catch (Exception e) {
                    if (Log.isLoggable("StorageInfoHandler", 3)) {
                        Log.d("StorageInfoHandler", "Failed to get storage info from GMS", e);
                    }
                }
            }
        }, listeningScheduledExecutorService);
        return fluentFutureTransform;
    }

    public final /* synthetic */ Void zze(zzno zznoVar) {
        zzse zzseVar = new zzse();
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskWrites().build());
        try {
            try {
                synchronized (zza) {
                    zzru zzruVar = (zzru) this.zzf.get();
                    Uri uri = this.zzi;
                    zzsv zzsvVarZzb = zzsv.zzb(zznoVar.zza());
                    zzsvVarZzb.zzc(zzseVar);
                    zzruVar.zza(uri, zzsvVarZzb);
                    this.zzj = zznoVar.zza();
                }
                synchronized (zzb) {
                    zzru zzruVar2 = (zzru) this.zzf.get();
                    Uri uri2 = this.zzk;
                    zzsv zzsvVarZzb2 = zzsv.zzb(zznoVar.zzb());
                    zzsvVarZzb2.zzc(zzseVar);
                    zzruVar2.zza(uri2, zzsvVarZzb2);
                    this.zzl = zznoVar.zzb();
                }
                StrictMode.setThreadPolicy(threadPolicy);
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th;
        }
    }

    public final /* synthetic */ ListenableFuture zzf(Void r1) {
        return Futures.nonCancellationPropagating((ListenableFuture) this.zzg.get());
    }
}
