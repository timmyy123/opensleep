package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzxa implements zzhp {
    private final zzhp zza;
    private final int zzb;
    private final zzwz zzc;
    private final byte[] zzd;
    private int zze;

    public zzxa(zzhp zzhpVar, int i, zzwz zzwzVar) {
        zzgtj.zza(i > 0);
        this.zza = zzhpVar;
        this.zzb = i;
        this.zzc = zzwzVar;
        this.zzd = new byte[1];
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) {
        int i3 = this.zze;
        if (i3 == 0) {
            zzhp zzhpVar = this.zza;
            byte[] bArr2 = this.zzd;
            int i4 = 0;
            if (zzhpVar.zza(bArr2, 0, 1) != -1) {
                int i5 = (bArr2[0] & PHIpAddressSearchManager.END_IP_SCAN) << 4;
                if (i5 != 0) {
                    byte[] bArr3 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int iZza = zzhpVar.zza(bArr3, i4, i6);
                        if (iZza != -1) {
                            i4 += iZza;
                            i6 -= iZza;
                        }
                    }
                    while (i5 > 0) {
                        int i7 = i5 - 1;
                        if (bArr3[i7] != 0) {
                            break;
                        }
                        i5 = i7;
                    }
                    if (i5 > 0) {
                        this.zzc.zza(new zzet(bArr3, i5));
                    }
                }
                i3 = this.zzb;
                this.zze = i3;
            }
            return -1;
        }
        int iZza2 = this.zza.zza(bArr, i, Math.min(i3, i2));
        if (iZza2 != -1) {
            this.zze -= iZza2;
        }
        return iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zze(zzin zzinVar) {
        zzinVar.getClass();
        this.zza.zze(zzinVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        return this.zza.zzj();
    }
}
