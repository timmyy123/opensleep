package com.google.android.gms.internal.measurement;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzacq extends zzacp {
    private final byte[] zzb;

    public zzacq(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final zzacr zzc(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzn = zzacr.zzn(0, i2, bArr.length);
        return iZzn == 0 ? zzacr.zza : new zzacm(bArr, 0, iZzn);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final void zzd(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final void zze(zzacj zzacjVar) {
        byte[] bArr = this.zzb;
        zzacjVar.zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final boolean zzf(zzacr zzacrVar) {
        boolean z = zzacrVar instanceof zzacq;
        if (z) {
            return Arrays.equals(this.zzb, ((zzacq) zzacrVar).zzb);
        }
        boolean z2 = zzacrVar instanceof zzacm;
        if (!z2) {
            return zzacrVar.zzf(this);
        }
        byte[] bArr = this.zzb;
        int iZzb = zzacrVar.zzb();
        int length = bArr.length;
        if (length > iZzb) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 18 + String.valueOf(length).length());
            sb.append("Length too large: ");
            sb.append(length);
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length > zzacrVar.zzb()) {
            int iZzb2 = zzacrVar.zzb();
            Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(length).length() + 27 + String.valueOf(iZzb2).length()), length, "Ran off end of other: 0, ", iZzb2, ", "));
            return false;
        }
        if (z) {
            return zzacr.zzo(bArr, 0, ((zzacq) zzacrVar).zzb, 0, length);
        }
        if (!z2) {
            return zzacrVar.zzc(0, length).equals(zzc(0, length));
        }
        zzacm zzacmVar = (zzacm) zzacrVar;
        return zzacr.zzo(bArr, 0, zzacmVar.zzh(), zzacmVar.zzi(), length);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final int zzg(int i, int i2, int i3) {
        return zzaed.zzb(i, this.zzb, 0, i3);
    }

    public final /* synthetic */ byte[] zzh() {
        return this.zzb;
    }
}
