package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbaj {
    protected volatile Boolean zzb;
    private final zzbbs zzc;
    private static final ConditionVariable zzd = new ConditionVariable();
    protected static volatile zzfzc zza = null;
    private static volatile Random zze = null;

    public zzbaj(zzbbs zzbbsVar) {
        this.zzc = zzbbsVar;
        zzbbsVar.zzd().execute(new zzbai(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zze == null) {
                synchronized (zzbaj.class) {
                    try {
                        if (zze == null) {
                            zze = new Random();
                        }
                    } finally {
                    }
                }
            }
            return zze.nextInt();
        }
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzd.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzaws zzawsVarZza = zzaww.zza();
            zzawsVarZza.zza(this.zzc.zza.getPackageName());
            zzawsVarZza.zzb(j);
            if (str != null) {
                zzawsVarZza.zze(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzawsVarZza.zzc(stringWriter.toString());
                zzawsVarZza.zzd(exc.getClass().getName());
            }
            zzfzb zzfzbVarZza = zza.zza(((zzaww) zzawsVarZza.zzbm()).zzaN());
            zzfzbVarZza.zzc(i);
            if (i2 != -1) {
                zzfzbVarZza.zzb(i2);
            }
            zzfzbVarZza.zza();
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ zzbbs zzb() {
        return this.zzc;
    }
}
