package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzlk {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Object zzb = new Object();
    private static final AtomicReference zzc = new AtomicReference();
    private static volatile zzlk zzd = null;
    private static volatile zzlk zze = null;
    private static final Supplier zzf = Suppliers.memoize(zzlp.zza);
    private final zzoh zzg = new zzol();
    private final Context zzh;
    private final Supplier zzi;
    private final Supplier zzj;
    private final Supplier zzk;
    private final Supplier zzl;
    private final zzrf zzm;
    private final Supplier zzn;
    private final zzqe zzo;

    public /* synthetic */ zzlk(Context context, Supplier supplier, Supplier supplier2, final Supplier supplier3, Supplier supplier4, Supplier supplier5, byte[] bArr) {
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(supplier2);
        Preconditions.checkNotNull(supplier3);
        Preconditions.checkNotNull(supplier4);
        Preconditions.checkNotNull(supplier5);
        Supplier supplierMemoize = Suppliers.memoize(supplier);
        Supplier supplierMemoize2 = Suppliers.memoize(supplier2);
        Supplier supplierMemoize3 = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzlq
            @Override // com.google.common.base.Supplier
            public final /* synthetic */ Object get() {
                int i = zzlk.$r8$clinit;
                return (zzqm) ((Optional) supplier3.get()).orNull();
            }
        });
        Supplier supplierMemoize4 = Suppliers.memoize(supplier4);
        Supplier supplierMemoize5 = Suppliers.memoize(supplier5);
        this.zzh = applicationContext;
        this.zzi = supplierMemoize;
        this.zzj = supplierMemoize2;
        this.zzk = supplierMemoize3;
        this.zzl = supplierMemoize4;
        this.zzm = new zzrf(applicationContext, supplierMemoize, supplierMemoize4, supplierMemoize2);
        this.zzn = supplierMemoize5;
        this.zzo = new zzqe(applicationContext, supplierMemoize, supplierMemoize3, supplierMemoize2);
    }

    public static void zza(Context context) {
        Context applicationContext;
        if (zzc.get() != null) {
            return;
        }
        try {
            applicationContext = context.getApplicationContext();
        } catch (NullPointerException unused) {
            zzl();
            zzlz.zza(Level.WARNING, (Executor) zzf.get(), "context.getApplicationContext() yielded NullPointerException", new Object[0]);
            applicationContext = null;
        }
        if (applicationContext != null) {
            AtomicReference atomicReference = zzc;
            while (!atomicReference.compareAndSet(null, applicationContext) && atomicReference.get() == null) {
            }
        }
    }

    public static zzlk zzb() {
        zzlk zzlkVar;
        zzls.zza();
        zzls.zzc();
        Context context = (Context) zzc.get();
        if (context == null) {
            zzls.zzb();
            Utf8$$ExternalSyntheticBUOutline0.m$3("Must call PhenotypeContext.setContext() first");
            return null;
        }
        zzlk zzlkVar2 = zzd;
        if (zzlkVar2 != null) {
            return zzlkVar2;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            applicationContext.getClass();
            Context applicationContext2 = applicationContext.getApplicationContext();
            applicationContext2.getClass();
            Class<?> cls = applicationContext2.getClass();
            new StringBuilder(String.valueOf(cls).length() + 72);
            cls.toString();
            throw new IllegalStateException("Given application context does not implement GeneratedComponentManager: ".concat(String.valueOf(cls)));
        } catch (IllegalStateException unused) {
            synchronized (zzb) {
                try {
                    if (zzd != null) {
                        zzlkVar = zzd;
                    } else {
                        zzlkVar = (zzlk) Optional.absent().or(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzll
                            @Override // com.google.common.base.Supplier
                            public final /* synthetic */ Object get() {
                                int i = zzlk.$r8$clinit;
                                zzlj zzljVar = new zzlj(null);
                                zzljVar.zza(applicationContext);
                                return zzljVar.zzb();
                            }
                        });
                        zzd = zzlkVar;
                        zzlz.zza(Level.CONFIG, zzlkVar.zzg(), "Application doesn't implement PhenotypeApplication interface, falling back to globally set context. See go/phenotype-flag#process-stable-init for more info.", new Object[0]);
                    }
                    return zzlkVar;
                } finally {
                }
            }
        }
    }

    public static boolean zzl() {
        zzls.zzb();
        if (zzc.get() == null) {
            zzls.zzd();
        }
        return false;
    }

    public final Context zzc() {
        return this.zzh;
    }

    public final zzrf zzd() {
        return this.zzm;
    }

    public final Optional zze() {
        return (Optional) this.zzn.get();
    }

    public final zzqe zzf() {
        return this.zzo;
    }

    public final ListeningScheduledExecutorService zzg() {
        return (ListeningScheduledExecutorService) this.zzi.get();
    }

    public final zzmj zzh() {
        return (zzmj) this.zzj.get();
    }

    public final zzru zzi() {
        return (zzru) this.zzl.get();
    }

    public final zzqm zzj() {
        return (zzqm) this.zzk.get();
    }

    public final zzoh zzk() {
        return this.zzg;
    }
}
