package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
final class zzgzd extends zzgzg {
    final char[] zza;

    private zzgzd(zzgzc zzgzcVar) {
        super(zzgzcVar, null);
        this.zza = new char[512];
        zzgtj.zza(zzgzcVar.zzf().length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzgzcVar.zza(i >>> 4);
            this.zza[i | 256] = zzgzcVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzh
    public final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzgtj.zzo(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            char[] cArr = this.zza;
            appendable.append(cArr[i4]);
            appendable.append(cArr[i4 | 256]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzh
    public final int zzb(byte[] bArr, CharSequence charSequence) throws zzgzf {
        if (charSequence.length() % 2 == 1) {
            int length = charSequence.length();
            throw new zzgzf(zzba$$ExternalSyntheticOutline0.m(length, "Invalid input length ", new StringBuilder(String.valueOf(length).length() + 21)));
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            zzgzc zzgzcVar = this.zzb;
            bArr[i2] = (byte) (zzgzcVar.zzc(charSequence.charAt(i + 1)) | (zzgzcVar.zzc(charSequence.charAt(i)) << 4));
            i += 2;
            i2++;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzg
    public final zzgzh zzc(zzgzc zzgzcVar, Character ch) {
        return new zzgzd(zzgzcVar);
    }

    public zzgzd(String str, String str2) {
        this(new zzgzc("base16()", new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}));
    }
}
