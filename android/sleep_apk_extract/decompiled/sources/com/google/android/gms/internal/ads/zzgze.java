package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
final class zzgze extends zzgzg {
    private zzgze(zzgzc zzgzcVar, Character ch) {
        super(zzgzcVar, ch);
        zzgtj.zza(zzgzcVar.zzf().length == 64);
    }

    @Override // com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzh
    public final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzgtj.zzo(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & 255;
            int i6 = bArr[i3 + 1] & 255;
            int i7 = bArr[i3 + 2] & 255;
            zzgzc zzgzcVar = this.zzb;
            int i8 = (i6 << 8) | (i5 << 16) | i7;
            appendable.append(zzgzcVar.zza(i8 >>> 18));
            appendable.append(zzgzcVar.zza((i8 >>> 12) & 63));
            appendable.append(zzgzcVar.zza((i8 >>> 6) & 63));
            appendable.append(zzgzcVar.zza(i8 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zze(appendable, bArr, i3, i2 - i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzh
    public final int zzb(byte[] bArr, CharSequence charSequence) throws zzgzf {
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzgzc zzgzcVar = this.zzb;
        if (!zzgzcVar.zzb(length)) {
            int length2 = charSequenceZzg.length();
            throw new zzgzf(zzba$$ExternalSyntheticOutline0.m(length2, "Invalid input length ", new StringBuilder(String.valueOf(length2).length() + 21)));
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceZzg.length()) {
            int i3 = i2 + 1;
            int iZzc = (zzgzcVar.zzc(charSequenceZzg.charAt(i + 1)) << 12) | (zzgzcVar.zzc(charSequenceZzg.charAt(i)) << 18);
            bArr[i2] = (byte) (iZzc >>> 16);
            int i4 = i + 2;
            if (i4 < charSequenceZzg.length()) {
                int i5 = i + 3;
                int iZzc2 = iZzc | (zzgzcVar.zzc(charSequenceZzg.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((iZzc2 >>> 8) & PHIpAddressSearchManager.END_IP_SCAN);
                if (i5 < charSequenceZzg.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((iZzc2 | zzgzcVar.zzc(charSequenceZzg.charAt(i5))) & PHIpAddressSearchManager.END_IP_SCAN);
                } else {
                    i2 = i6;
                    i = i5;
                }
            } else {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzg
    public final zzgzh zzc(zzgzc zzgzcVar, Character ch) {
        return new zzgze(zzgzcVar, ch);
    }

    public zzgze(String str, String str2, Character ch) {
        this(new zzgzc(str, str2.toCharArray()), ch);
    }
}
