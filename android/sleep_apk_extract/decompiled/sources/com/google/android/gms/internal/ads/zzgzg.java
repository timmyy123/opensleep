package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class zzgzg extends zzgzh {
    private volatile zzgzh zza;
    final zzgzc zzb;
    final Character zzc;

    public zzgzg(zzgzc zzgzcVar, Character ch) {
        this.zzb = zzgzcVar;
        boolean z = true;
        if (ch != null && zzgzcVar.zze('=')) {
            z = false;
        }
        zzgtj.zzf(z, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgzg) {
            zzgzg zzgzgVar = (zzgzg) obj;
            if (this.zzb.equals(zzgzgVar.zzb) && Objects.equals(this.zzc, zzgzgVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() ^ Objects.hashCode(this.zzc);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzgzc zzgzcVar = this.zzb;
        sb.append(zzgzcVar);
        if (8 % zzgzcVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public void zza(Appendable appendable, byte[] bArr, int i, int i2) {
        int i3 = 0;
        zzgtj.zzo(0, i2, bArr.length);
        while (i3 < i2) {
            int i4 = this.zzb.zzd;
            zze(appendable, bArr, i3, Math.min(i4, i2 - i3));
            i3 += i4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public int zzb(byte[] bArr, CharSequence charSequence) throws zzgzf {
        int i;
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzgzc zzgzcVar = this.zzb;
        if (!zzgzcVar.zzb(length)) {
            int length2 = charSequenceZzg.length();
            throw new zzgzf(zzba$$ExternalSyntheticOutline0.m(length2, "Invalid input length ", new StringBuilder(String.valueOf(length2).length() + 21)));
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequenceZzg.length()) {
            long jZzc = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = zzgzcVar.zzc;
                if (i4 >= i) {
                    break;
                }
                jZzc <<= zzgzcVar.zzb;
                if (i2 + i4 < charSequenceZzg.length()) {
                    jZzc |= (long) zzgzcVar.zzc(charSequenceZzg.charAt(i5 + i2));
                    i5++;
                }
                i4++;
            }
            int i6 = zzgzcVar.zzd;
            int i7 = i5 * zzgzcVar.zzb;
            int i8 = (i6 - 1) * 8;
            while (i8 >= (i6 * 8) - i7) {
                bArr[i3] = (byte) ((jZzc >>> i8) & 255);
                i8 -= 8;
                i3++;
            }
            i2 += i;
        }
        return i3;
    }

    public zzgzh zzc(zzgzc zzgzcVar, Character ch) {
        return new zzgzg(zzgzcVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final int zzd(int i) {
        zzgzc zzgzcVar = this.zzb;
        return zzgzcVar.zzc * zzgzz.zzb(i, zzgzcVar.zzd, RoundingMode.CEILING);
    }

    public final void zze(Appendable appendable, byte[] bArr, int i, int i2) {
        zzgtj.zzo(i, i + i2, bArr.length);
        zzgzc zzgzcVar = this.zzb;
        int i3 = zzgzcVar.zzd;
        int i4 = 0;
        zzgtj.zza(i2 <= i3);
        long j = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            j = (j | ((long) (bArr[i + i5] & 255))) << 8;
        }
        int i6 = (i2 + 1) * 8;
        int i7 = zzgzcVar.zzb;
        while (i4 < i2 * 8) {
            appendable.append(zzgzcVar.zza(zzgzcVar.zza & ((int) (j >>> ((i6 - i7) - i4)))));
            i4 += i7;
        }
        if (this.zzc != null) {
            while (i4 < i3 * 8) {
                appendable.append('=');
                i4 += i7;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final int zzf(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        if (this.zzc == null) {
            return charSequence;
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final zzgzh zzh() {
        return this.zzc == null ? this : zzc(this.zzb, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final zzgzh zzi() {
        zzgzh zzgzhVarZzc = this.zza;
        if (zzgzhVarZzc == null) {
            zzgzc zzgzcVar = this.zzb;
            zzgzc zzgzcVarZzd = zzgzcVar.zzd();
            zzgzhVarZzc = zzgzcVarZzd == zzgzcVar ? this : zzc(zzgzcVarZzd, this.zzc);
            this.zza = zzgzhVarZzc;
        }
        return zzgzhVarZzc;
    }

    public zzgzg(String str, String str2, Character ch) {
        this(new zzgzc(str, str2.toCharArray()), ch);
    }
}
