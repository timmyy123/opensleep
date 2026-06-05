package com.google.android.gms.internal.serialization;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import java.nio.charset.Charset;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
class zzwq extends zzwp {
    protected final byte[] zza;

    public zzwq(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzwr) || zzc() != ((zzwr) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzwq)) {
            return obj.equals(this);
        }
        zzwq zzwqVar = (zzwq) obj;
        int iZzp = zzp();
        int iZzp2 = zzwqVar.zzp();
        if (iZzp != 0 && iZzp2 != 0 && iZzp != iZzp2) {
            return false;
        }
        int iZzc = zzc();
        if (iZzc > zzwqVar.zzc()) {
            int iZzc2 = zzc();
            zzbuy$$ExternalSyntheticBUOutline0.m(String.valueOf(iZzc).length() + 18 + String.valueOf(iZzc2).length(), iZzc, iZzc2);
            return false;
        }
        if (iZzc > zzwqVar.zzc()) {
            int iZzc3 = zzwqVar.zzc();
            Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzc).length() + 27 + String.valueOf(iZzc3).length()), iZzc, "Ran off end of other: 0, ", iZzc3, ", "));
            return false;
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzwqVar.zza;
        zzwqVar.zzd();
        int i = 0;
        int i2 = 0;
        while (i < iZzc) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public final zzwr zzf(int i, int i2) {
        int iZzq = zzwr.zzq(0, i2, zzc());
        return iZzq == 0 ? zzwr.zzb : new zzwm(this.zza, 0, iZzq);
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public final void zzg(zzwj zzwjVar) {
        zzwjVar.zza(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public final String zzh(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public final int zzj(int i, int i2, int i3) {
        return zzzt.zzc(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.serialization.zzwr
    public final zzwv zzk() {
        return zzwv.zzM(this.zza, 0, zzc(), true);
    }
}
