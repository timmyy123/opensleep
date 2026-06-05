package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzicy extends zzicx {
    private final byte[] zzb;

    public zzicy(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzc(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzD = zzida.zzD(i, i2, bArr.length);
        return iZzD == 0 ? zzida.zza : new zzicu(bArr, i, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzd(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzD = zzida.zzD(i, i2, bArr.length);
        return iZzD == 0 ? zzida.zza : new zzicu(bArr, i, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final ByteBuffer zzf() {
        return ByteBuffer.wrap(this.zzb).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final void zzg(zzicr zzicrVar) {
        byte[] bArr = this.zzb;
        zzicrVar.zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final boolean zzj(zzida zzidaVar) {
        return zzidaVar instanceof zzicy ? Arrays.equals(this.zzb, ((zzicy) zzidaVar).zzb) : zzidaVar instanceof zzicu ? zzk(zzidaVar, 0, this.zzb.length) : zzidaVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzicx
    public final boolean zzk(zzida zzidaVar, int i, int i2) {
        if (i2 > zzidaVar.zzb()) {
            byte[] bArr = this.zzb;
            int length = String.valueOf(i2).length();
            int length2 = bArr.length;
            zzbuy$$ExternalSyntheticBUOutline0.m(length + 18 + String.valueOf(length2).length(), i2, length2);
            return false;
        }
        int i3 = i + i2;
        if (i3 <= zzidaVar.zzb()) {
            if (zzidaVar instanceof zzicy) {
                return zzida.zzE(this.zzb, 0, ((zzicy) zzidaVar).zzb, i, i2);
            }
            if (!(zzidaVar instanceof zzicu)) {
                return zzidaVar.zzd(i, i3).equals(zzd(0, i2));
            }
            zzicu zzicuVar = (zzicu) zzidaVar;
            return zzida.zzE(this.zzb, 0, zzicuVar.zzn(), zzicuVar.zzo() + i, i2);
        }
        int iZzb = zzidaVar.zzb();
        int length3 = String.valueOf(i).length();
        StringBuilder sb = new StringBuilder(length3 + 24 + String.valueOf(i2).length() + 2 + String.valueOf(iZzb).length());
        Fragment$$ExternalSyntheticOutline1.m(sb, "Ran off end of other: ", i, ", ", i2);
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(iZzb, ", ", sb));
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final int zzl(int i, int i2, int i3) {
        return zzier.zzb(i, this.zzb, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzide zzm() {
        byte[] bArr = this.zzb;
        return zzide.zzI(bArr, 0, bArr.length, true);
    }

    public final /* synthetic */ byte[] zzn() {
        return this.zzb;
    }
}
