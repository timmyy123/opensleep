package com.google.android.gms.internal.measurement;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.internal.measurement.zzyi;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzxi<API extends zzyi<API>> {
    private final zzzf zza;

    public zzxi(zzzf zzzfVar) {
        this.zza = zzzfVar;
    }

    private static void zzd(String str, zzzd zzzdVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(zzzdVar.zzf() / 1000000)));
        sb.append(": logging error [");
        zzze.zza(1, zzzdVar.zzg(), sb);
        sb.append("]: ");
        sb.append(str);
        System.err.println(sb);
        System.err.flush();
    }

    public final String zza() {
        return this.zza.zza();
    }

    public final boolean zzb(Level level) {
        return this.zza.zzb(level);
    }

    public final void zzc(zzzd zzzdVar) {
        try {
            zzabt zzabtVarZzc = zzabt.zzc();
            try {
                if (zzabtVarZzc.zzb() <= 100) {
                    this.zza.zzc(zzzdVar);
                } else {
                    zzd("unbounded recursion in log statement", zzzdVar);
                }
                zzabtVarZzc.close();
            } finally {
            }
        } catch (RuntimeException e) {
            try {
                this.zza.zzd(e, zzzdVar);
            } catch (RuntimeException e2) {
                String name = e2.getClass().getName();
                String message = e2.getMessage();
                zzd(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(name.length() + 2 + String.valueOf(message).length()), name, ": ", message), zzzdVar);
                try {
                    e2.printStackTrace(System.err);
                } catch (RuntimeException unused) {
                }
            }
        }
    }
}
