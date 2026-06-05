package com.google.android.gms.internal.measurement;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.common.base.Preconditions;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmv implements Comparable {
    final long zza;
    final String zzb;
    final int zzc;
    final long zzd;
    final Object zze;
    private final RuntimeException zzf;

    public zzmv(long j, String str, int i, long j2, Object obj) {
        Preconditions.checkArgument(((j > 0L ? 1 : (j == 0L ? 0 : -1)) == 0) == (str != null));
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
        this.zzd = j2;
        this.zze = obj;
        if (i != 5) {
            this.zzf = null;
            return;
        }
        if (obj == null) {
            this.zzf = new NullPointerException("Null stringOrBytes");
        } else if ((obj instanceof byte[]) || (obj instanceof zzacr)) {
            this.zzf = null;
        } else {
            this.zzf = new RuntimeException("Wrong stringOrBytes type: ".concat(String.valueOf(obj.getClass())));
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzmv zzmvVar = (zzmv) obj;
        long j = zzmvVar.zza;
        long j2 = this.zza;
        int iCompare = Long.compare(j2, j);
        if (iCompare != 0) {
            return iCompare;
        }
        if (j2 != 0) {
            return 0;
        }
        return ((String) Preconditions.checkNotNull(this.zzb)).compareTo((String) Preconditions.checkNotNull(zzmvVar.zzb));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmv)) {
            return false;
        }
        zzmv zzmvVar = (zzmv) obj;
        return this.zza == zzmvVar.zza && Objects.equals(this.zzb, zzmvVar.zzb);
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strZza = zza();
        String strValueOf = String.valueOf(zzb());
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(strZza).length() + 1 + strValueOf.length()), strZza, ":", strValueOf);
    }

    public final String zza() {
        String str = this.zzb;
        return str != null ? str : Long.toString(this.zza);
    }

    public final Object zzb() {
        int i = this.zzc;
        if (i == 0) {
            return Boolean.FALSE;
        }
        if (i == 1) {
            return Boolean.TRUE;
        }
        if (i == 2) {
            return Long.valueOf(this.zzd);
        }
        if (i == 3) {
            return Double.valueOf(Double.longBitsToDouble(this.zzd));
        }
        if (i == 4) {
            Object obj = this.zze;
            Preconditions.checkNotNull(obj);
            return obj;
        }
        if (i != 5) {
            Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "Impossible, this was validated when parsed or created");
            return null;
        }
        Object obj2 = this.zze;
        Preconditions.checkNotNull(obj2);
        try {
            return obj2 instanceof byte[] ? (byte[]) obj2 : ((zzacr) obj2).zzm();
        } catch (Throwable th) {
            RuntimeException runtimeException = this.zzf;
            if (runtimeException != null) {
                th.addSuppressed(runtimeException);
            }
            throw th;
        }
    }
}
