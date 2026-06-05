package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.ArrayDeque;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public final class zzawh {
    public final zzavc zza;
    public final zzawd zzb;
    public final zzawa zzc;
    public final zzavv zzd;

    public zzawh(zzavc zzavcVar, zzawd zzawdVar, zzavv zzavvVar) {
        int[] iArr = {343945053, 300943123, 276960570, 1098387973, 1376531620, 1545514151, 271059426, 857490000, 454333378};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        this.zza = zzavcVar;
        this.zzb = zzawdVar;
        this.zzd = zzavvVar;
        this.zzc = new zzawa(zzba$$ExternalSyntheticOutline0.m$1((i2 & (~i)) | i3, (i & i4) | i5, i6, i7) ^ (i8 % 454333378));
    }

    public final Optional zza() {
        zzauw zzauwVar;
        try {
            try {
                ArrayDeque arrayDeque = this.zzc.zza;
                if (arrayDeque.isEmpty()) {
                    throw new zzavz();
                }
                zzavx zzavxVar = (zzavx) arrayDeque.pop();
                long j = zzavxVar.zza;
                long j2 = zzavxVar.zzb;
                long j3 = zzavxVar.zzc;
                zzawd zzawdVar = this.zzb;
                if (zzawdVar.zzb < j2) {
                    return Optional.of(zzauw.zzG);
                }
                this.zzd.zza(j);
                if (j3 == 0) {
                    while (zzawdVar.zzb > j2) {
                        zzawdVar.zzc();
                    }
                }
                return Optional.empty();
            } catch (zzavt | zzavu e) {
                throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
            }
        } catch (zzavz unused) {
            zzauwVar = zzauw.zzw;
            return Optional.of(zzauwVar);
        } catch (zzawb unused2) {
            zzauwVar = zzauw.zzG;
            return Optional.of(zzauwVar);
        }
    }
}
