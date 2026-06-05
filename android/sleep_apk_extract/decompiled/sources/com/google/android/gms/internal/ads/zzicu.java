package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzicu extends zzicx {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    public zzicu(byte[] bArr, int i, int i2) {
        super(null);
        zzida.zzD(i, i + i2, bArr.length);
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final byte zza(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzc(int i, int i2) {
        int iZzD = zzida.zzD(i, i2, this.zzd);
        return iZzD == 0 ? zzida.zza : new zzicu(this.zzb, this.zzc + i, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzd(int i, int i2) {
        int iZzD = zzida.zzD(i, i2, this.zzd);
        return iZzD == 0 ? zzida.zza : new zzicu(this.zzb, this.zzc + i, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, this.zzc + i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final ByteBuffer zzf() {
        return ByteBuffer.wrap(this.zzb, this.zzc, this.zzd).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final void zzg(zzicr zzicrVar) {
        zzicrVar.zza(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final boolean zzj(zzida zzidaVar) {
        return ((zzidaVar instanceof zzicy) || (zzidaVar instanceof zzicu)) ? zzk(zzidaVar, 0, this.zzd) : zzidaVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzicx
    public final boolean zzk(zzida zzidaVar, int i, int i2) {
        if (i2 > zzidaVar.zzb()) {
            int i3 = this.zzd;
            zzbuy$$ExternalSyntheticBUOutline0.m(String.valueOf(i2).length() + 18 + String.valueOf(i3).length(), i2, i3);
            return false;
        }
        int i4 = i + i2;
        if (i4 > zzidaVar.zzb()) {
            int iZzb = zzidaVar.zzb();
            int length = String.valueOf(i).length();
            StringBuilder sb = new StringBuilder(length + 24 + String.valueOf(i2).length() + 2 + String.valueOf(iZzb).length());
            Fragment$$ExternalSyntheticOutline1.m(sb, "Ran off end of other: ", i, ", ", i2);
            Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(iZzb, ", ", sb));
            return false;
        }
        if (zzidaVar instanceof zzicy) {
            return zzida.zzE(this.zzb, this.zzc, ((zzicy) zzidaVar).zzn(), i, i2);
        }
        if (zzidaVar instanceof zzicu) {
            zzicu zzicuVar = (zzicu) zzidaVar;
            return zzida.zzE(this.zzb, this.zzc, zzicuVar.zzb, zzicuVar.zzc + i, i2);
        }
        zzida zzidaVarZzd = zzidaVar.zzd(i, i4);
        int i5 = this.zzc;
        return zzidaVarZzd.equals(zzd(i5, i2 + i5));
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final int zzl(int i, int i2, int i3) {
        return zzier.zzb(i, this.zzb, this.zzc + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzide zzm() {
        return zzide.zzI(this.zzb, this.zzc, this.zzd, true);
    }

    public final /* synthetic */ byte[] zzn() {
        return this.zzb;
    }

    public final /* synthetic */ int zzo() {
        return this.zzc;
    }
}
