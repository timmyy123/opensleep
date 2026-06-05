package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzavq {
    public static final zzavq zzb = new zzavq(new byte[0]);
    public static final Comparator zzc = new zzavp();
    public final byte[] zza;

    public zzavq(byte[] bArr) {
        this.zza = bArr;
    }

    public static zzavq zze(byte[] bArr) {
        return new zzavq(zzh(bArr, 0, bArr.length));
    }

    public static zzavq zzf(String str) {
        return zze(str.getBytes(Charset.forName(zzavo.zza("Hn2H4l0="))));
    }

    public static int zzg(byte b) {
        int[] iArr = {2107654819, 15074090, 1957914693, -2142502098, -1902504939, -100121615, 100669, 1835342733, 837626799};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        return b & ((iArr[7] % 837626799) ^ zzba$$ExternalSyntheticOutline0.m$1((i2 & (~i)) | i3, (i & i4) | i5, i6, i7));
    }

    public static byte[] zzh(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzavq) {
            return Arrays.equals(this.zza, ((zzavq) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(Arrays.hashCode(this.zza));
    }

    public final String toString() {
        int[] iArr = {936621968, 262671172, 1099388327, 506341952, 1363551406, -1491858486, 110389885, 989492335, 981766422};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int iM$1 = zzba$$ExternalSyntheticOutline0.m$1((i2 & (~i)) | i3, (i & i4) | i5, i6, i7);
        String string = Arrays.toString(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + ((i8 % 981766422) ^ iM$1));
        sb.append(zzavo.zza("CVC1qiQNJHikW0iU1TIPZA=="));
        sb.append(string);
        sb.append(zzavo.zza("Ng=="));
        return sb.toString();
    }

    public final byte[] zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        return length == 0 ? new byte[0] : zzh(bArr, 0, length);
    }

    public final byte zzb(int i) {
        int i2 = ((((~2106914653) & 587408197) | 1537377410) + ((2106914653 & 536945509) | 443419704)) - 2137956065;
        int i3 = 2013725218 % 1633938701;
        int i4 = ((((~1287859999) & 62941354) | 437464817) + ((1287859999 & 1639989262) | 1644309956)) - 2060977796;
        int i5 = 1442767057 % 63299708;
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (((length - (i + 1)) | i) >= 0) {
            return bArr[i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(i, i2 ^ i3));
            sb.append(zzavo.zza("Akelqh1fajntGgo="));
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, zzba$$ExternalSyntheticOutline0.m(i, i4 ^ i5)));
        String strZza = zzavo.zza("Akelqh1faDmxRUSK1T9GeQ==");
        String strZza2 = zzavo.zza("Zwk=");
        sb2.append(strZza);
        sb2.append(i);
        sb2.append(strZza2);
        sb2.append(length);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    public final String zzc() {
        Charset charsetForName = Charset.forName(zzavo.zza("Hn2H4l0="));
        byte[] bArr = this.zza;
        return new String(bArr, 0, bArr.length, charsetForName);
    }

    public final zzavq zzd(zzavq zzavqVar) {
        byte[] bArr = zzavqVar.zza;
        int length = bArr.length;
        byte[] bArr2 = this.zza;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2 + length];
        System.arraycopy(bArr2, 0, bArr3, 0, length2);
        System.arraycopy(bArr, 0, bArr3, length2, length);
        return zze(bArr3);
    }
}
