package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class zzio {
    private static volatile zzio zzc;
    private static volatile zzio zzd;
    private static final zzio zze = new zzio(true);
    private final Map<zza, zzjb.zze<?, ?>> zzf = Collections.EMPTY_MAP;

    public static final class zza {
        private final Object zza;
        private final int zzb;

        public zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }
    }

    private zzio(boolean z) {
    }

    public static zzio zzb() {
        zzio zzioVar;
        zzio zzioVar2 = zzc;
        if (zzioVar2 != null) {
            return zzioVar2;
        }
        synchronized (zzio.class) {
            try {
                zzioVar = zzc;
                if (zzioVar == null) {
                    zzioVar = zze;
                    zzc = zzioVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzioVar;
    }

    public static zzio zzc() {
        zzio zzioVar = zzd;
        if (zzioVar != null) {
            return zzioVar;
        }
        synchronized (zzio.class) {
            try {
                zzio zzioVar2 = zzd;
                if (zzioVar2 != null) {
                    return zzioVar2;
                }
                zzio zzioVarZza = zziz.zza(zzio.class);
                zzd = zzioVarZza;
                return zzioVarZza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <ContainingType extends zzkk> zzjb.zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        if (this.zzf.get(new zza(containingtype, i)) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
