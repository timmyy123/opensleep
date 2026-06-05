package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzlw {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Object zzb = new Object();

    @Nullable
    private static volatile zzlt zzc;
    private static final AtomicInteger zze;

    static {
        new AtomicReference();
        Preconditions.checkNotNull(zzlu.zza, "BuildInfo must be non-null");
        zze = new AtomicInteger();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0049, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zza(final Context context) {
        if (zzc != null || context == null) {
            return;
        }
        Object obj = zzb;
        synchronized (obj) {
            try {
                if (zzc == null) {
                    synchronized (obj) {
                        zzlt zzltVar = zzc;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzltVar == null || zzltVar.zza() != context) {
                            if (zzltVar != null) {
                                zzld.zza();
                                zzma.zza();
                            }
                            zzc = new zzlc(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzlv
                                @Override // com.google.common.base.Supplier
                                public final /* synthetic */ Object get() {
                                    int i = zzlw.$r8$clinit;
                                    return zzlf.zza(context);
                                }
                            }));
                            zze.incrementAndGet();
                        }
                    }
                }
            } finally {
            }
        }
    }
}
