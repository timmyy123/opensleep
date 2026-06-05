package com.google.android.gms.internal.auth;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzdc {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Nullable
    private static volatile zzda zze;
    final zzcz zzb;
    final String zzc;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private static final Object zza = new Object();
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzde zzh = new zzde(zzcu.zza);
    private static final AtomicInteger zzi = new AtomicInteger();

    public /* synthetic */ zzdc(zzcz zzczVar, String str, Object obj, boolean z, zzdb zzdbVar) {
        if (zzczVar.zza == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Must pass a valid SharedPreferences file name or ContentProvider URI");
            throw null;
        }
        this.zzb = zzczVar;
        this.zzc = str;
        this.zzj = obj;
    }

    public static void zzc() {
        zzi.incrementAndGet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zzd(final Context context) {
        if (zze != null || context == null) {
            return;
        }
        Object obj = zza;
        synchronized (obj) {
            try {
                if (zze == null) {
                    synchronized (obj) {
                        zzda zzdaVar = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzdaVar == null || zzdaVar.zza() != context) {
                            zzcg.zzd();
                            zzdd.zzc();
                            zzco.zze();
                            zze = new zzcd(context, zzdo.zza(new zzdj() { // from class: com.google.android.gms.internal.auth.zzct
                                @Override // com.google.android.gms.internal.auth.zzdj
                                public final Object zza() {
                                    Context context2 = context;
                                    int i = zzdc.$r8$clinit;
                                    return zzcp.zza(context2);
                                }
                            }));
                            zzi.incrementAndGet();
                        }
                    }
                }
            } finally {
            }
        }
    }

    public abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[PHI: r2
      0x003e: PHI (r2v1 com.google.android.gms.internal.auth.zzdh) = (r2v0 com.google.android.gms.internal.auth.zzdh), (r2v5 com.google.android.gms.internal.auth.zzdh) binds: [B:8:0x0016, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb() {
        String strZza;
        zzcg zzcgVarZza;
        Object objZza;
        Object objZzb;
        int i = zzi.get();
        if (this.zzk < i) {
            synchronized (this) {
                try {
                    if (this.zzk < i) {
                        zzda zzdaVar = zze;
                        zzdh zzdhVarZzc = zzdh.zzc();
                        Object objZza2 = null;
                        if (zzdaVar != null) {
                            zzdhVarZzc = (zzdh) zzdaVar.zzb().zza();
                            if (zzdhVarZzc.zzb()) {
                                zzci zzciVar = (zzci) zzdhVarZzc.zza();
                                zzcz zzczVar = this.zzb;
                                strZza = zzciVar.zza(zzczVar.zza, null, zzczVar.zzc, this.zzc);
                            } else {
                                strZza = null;
                            }
                            if (zzdaVar == null) {
                                throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                            }
                            Uri uri = this.zzb.zza;
                            if (uri != null) {
                                if (zzcq.zza(zzdaVar.zza(), uri)) {
                                    zzcgVarZza = zzcg.zza(zzdaVar.zza().getContentResolver(), this.zzb.zza, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            zzdc.zzc();
                                        }
                                    });
                                }
                                objZza = (zzcgVarZza != null || (objZzb = zzcgVarZza.zzb(this.zzc)) == null) ? null : zza(objZzb);
                                if (objZza == null) {
                                    if (!this.zzb.zzd) {
                                        String strZzc = zzco.zza(zzdaVar.zza()).zzb(this.zzb.zzd ? null : this.zzc);
                                        if (strZzc != null) {
                                            objZza2 = zza(strZzc);
                                        }
                                    }
                                    objZza = objZza2 == null ? this.zzj : objZza2;
                                }
                                if (zzdhVarZzc.zzb()) {
                                    objZza = strZza == null ? this.zzj : zza(strZza);
                                }
                                this.zzl = objZza;
                                this.zzk = i;
                            } else {
                                zzdd.zza(zzdaVar.zza(), null, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzdc.zzc();
                                    }
                                });
                            }
                            zzcgVarZza = null;
                            if (zzcgVarZza != null) {
                                if (objZza == null) {
                                }
                                if (zzdhVarZzc.zzb()) {
                                }
                                this.zzl = objZza;
                                this.zzk = i;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        return this.zzl;
    }
}
