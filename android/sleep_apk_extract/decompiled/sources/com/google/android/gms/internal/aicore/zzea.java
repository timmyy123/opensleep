package com.google.android.gms.internal.aicore;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
class zzea extends zzdz {
    protected final byte[] zza;

    public zzea(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.aicore.zzeb
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeb) || zzc() != ((zzeb) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzea)) {
            return obj.equals(this);
        }
        zzea zzeaVar = (zzea) obj;
        int iZzh = zzh();
        int iZzh2 = zzeaVar.zzh();
        if (iZzh != 0 && iZzh2 != 0 && iZzh != iZzh2) {
            return false;
        }
        int iZzc = zzc();
        if (iZzc > zzeaVar.zzc()) {
            int iZzc2 = zzc();
            zzbuy$$ExternalSyntheticBUOutline0.m(String.valueOf(iZzc).length() + 18 + String.valueOf(iZzc2).length(), iZzc, iZzc2);
            return false;
        }
        if (iZzc > zzeaVar.zzc()) {
            int iZzc3 = zzeaVar.zzc();
            Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzc).length() + 27 + String.valueOf(iZzc3).length()), iZzc, "Ran off end of other: 0, ", iZzc3, ", "));
            return false;
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzeaVar.zza;
        zzeaVar.zzd();
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

    @Override // com.google.android.gms.internal.aicore.zzeb
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.aicore.zzeb
    public byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.aicore.zzeb
    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.aicore.zzeb
    public final zzeb zze(int i, int i2) {
        int iZzi = zzeb.zzi(0, i2, zzc());
        return iZzi == 0 ? zzeb.zzb : new zzdx(this.zza, 0, iZzi);
    }

    @Override // com.google.android.gms.internal.aicore.zzeb
    public final int zzf(int i, int i2, int i3) {
        return zzfh.zzc(i, this.zza, 0, i3);
    }
}
