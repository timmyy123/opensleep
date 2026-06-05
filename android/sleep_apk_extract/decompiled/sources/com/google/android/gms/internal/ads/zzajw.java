package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzajw implements zzao {
    public final List zza;

    public zzajw(List list) {
        this.zza = list;
        boolean z = false;
        if (!list.isEmpty()) {
            long j = ((zzajv) list.get(0)).zzb;
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (((zzajv) list.get(i)).zza < j) {
                    z = true;
                    break;
                } else {
                    j = ((zzajv) list.get(i)).zzb;
                    i++;
                }
            }
        }
        zzgtj.zza(!z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzajw.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzajw) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }
}
