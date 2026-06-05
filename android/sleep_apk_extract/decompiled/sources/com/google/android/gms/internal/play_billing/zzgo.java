package com.google.android.gms.internal.play_billing;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Locale;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzgo extends zzgr {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzgo(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            Locale locale = Locale.US;
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(length, i2, "Array range is invalid. Buffer.length=", ", offset=0, length="));
            throw null;
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzb(byte b) throws zzgp {
        int i = this.zzd;
        try {
            int i2 = i + 1;
            try {
                this.zzb[i] = b;
                this.zzd = i2;
            } catch (IndexOutOfBoundsException e) {
                e = e;
                i = i2;
                throw new zzgp(i, this.zzc, 1, e);
            }
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
        }
    }

    public final void zzc(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i2);
            this.zzd += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgp(this.zzd, this.zzc, i2, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzd(int i, boolean z) throws zzgp {
        zzt(i << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zze(int i, zzgk zzgkVar) throws zzgp {
        zzt((i << 3) | 2);
        zzt(zzgkVar.zzd());
        zzgkVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzf(int i, int i2) throws zzgp {
        zzt((i << 3) | 5);
        zzg(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzg(int i) throws zzgp {
        int i2 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i2] = (byte) (i & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i2 + 1] = (byte) ((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i2 + 2] = (byte) ((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i2 + 3] = (byte) ((i >> 24) & PHIpAddressSearchManager.END_IP_SCAN);
            this.zzd = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgp(i2, this.zzc, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzh(int i, long j) throws zzgp {
        zzt((i << 3) | 1);
        zzi(j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzi(long j) throws zzgp {
        int i = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i] = (byte) (((int) j) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i + 1] = (byte) (((int) (j >> 8)) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i + 2] = (byte) (((int) (j >> 16)) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i + 3] = (byte) (((int) (j >> 24)) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i + 4] = (byte) (((int) (j >> 32)) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & PHIpAddressSearchManager.END_IP_SCAN);
            bArr[i + 7] = (byte) (((int) (j >> 56)) & PHIpAddressSearchManager.END_IP_SCAN);
            this.zzd = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgp(i, this.zzc, 8, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzj(int i, int i2) throws zzgp {
        zzt(i << 3);
        zzk(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzk(int i) throws zzgp {
        if (i >= 0) {
            zzt(i);
        } else {
            zzv(i);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzl(byte[] bArr, int i, int i2) {
        zzc(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzm(int i, zzim zzimVar, zzix zzixVar) throws zzgp {
        zzt((i << 3) | 2);
        zzt(((zzfv) zzimVar).zze(zzixVar));
        zzixVar.zzi(zzimVar, this.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzp(int i, String str) throws zzgp {
        zzt((i << 3) | 2);
        zzq(str);
    }

    public final void zzq(String str) throws zzgp {
        int i = this.zzd;
        try {
            int iZzz = zzgr.zzz(str.length() * 3);
            int iZzz2 = zzgr.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzt(zzjt.zzc(str));
                byte[] bArr = this.zzb;
                int i2 = this.zzd;
                this.zzd = zzjt.zzb(str, bArr, i2, this.zzc - i2);
                return;
            }
            int i3 = i + iZzz2;
            this.zzd = i3;
            int iZzb = zzjt.zzb(str, this.zzb, i3, this.zzc - i3);
            this.zzd = i;
            zzt((iZzb - i) - iZzz2);
            this.zzd = iZzb;
        } catch (zzjs e) {
            this.zzd = i;
            zzC(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgp(e2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzr(int i, int i2) throws zzgp {
        zzt((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzs(int i, int i2) throws zzgp {
        zzt(i << 3);
        zzt(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzt(int i) throws zzgp {
        while (true) {
            int i2 = i & (-128);
            byte[] bArr = this.zzb;
            if (i2 == 0) {
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr[i3] = (byte) i;
                return;
            } else {
                try {
                    int i4 = this.zzd;
                    this.zzd = i4 + 1;
                    bArr[i4] = (byte) ((i | 128) & PHIpAddressSearchManager.END_IP_SCAN);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzgp(this.zzd, this.zzc, 1, e);
                }
            }
            throw new zzgp(this.zzd, this.zzc, 1, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzu(int i, long j) throws zzgp {
        zzt(i << 3);
        zzv(j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzv(long j) throws zzgp {
        if (!zzgr.zzc || this.zzc - this.zzd < 10) {
            while (true) {
                long j2 = j & (-128);
                byte[] bArr = this.zzb;
                if (j2 == 0) {
                    int i = this.zzd;
                    this.zzd = i + 1;
                    bArr[i] = (byte) j;
                    return;
                } else {
                    try {
                        int i2 = this.zzd;
                        this.zzd = i2 + 1;
                        bArr[i2] = (byte) ((((int) j) | 128) & PHIpAddressSearchManager.END_IP_SCAN);
                        j >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzgp(this.zzd, this.zzc, 1, e);
                    }
                }
                throw new zzgp(this.zzd, this.zzc, 1, e);
            }
        }
        while (true) {
            long j3 = j & (-128);
            int i3 = (int) j;
            byte[] bArr2 = this.zzb;
            if (j3 == 0) {
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                zzjq.zzn(bArr2, i4, (byte) i3);
                return;
            } else {
                int i5 = this.zzd;
                this.zzd = i5 + 1;
                zzjq.zzn(bArr2, i5, (byte) ((i3 | 128) & PHIpAddressSearchManager.END_IP_SCAN));
                j >>>= 7;
            }
        }
    }
}
