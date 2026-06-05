package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaoq implements zzanl {
    private final zzet zza = new zzet();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzaoq(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = "sans-serif";
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.zzc = bArr[24];
        this.zzd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.zze = true == "Serif".equals(zzfl.zzk(bArr, 43, bArr.length + (-43))) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.zzg = i;
        boolean z = (bArr[0] & 32) != 0;
        this.zzb = z;
        if (z) {
            this.zzf = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.95f));
        } else {
            this.zzf = 0.85f;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            int i7 = i & 1;
            int i8 = i & 2;
            boolean z = true;
            if (i7 != 0) {
                if (i8 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                    z = false;
                }
            } else if (i8 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            } else {
                z = false;
            }
            if ((i & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            } else {
                if (i7 != 0 || z) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & PHIpAddressSearchManager.END_IP_SCAN) << 24)), i3, i4, i5 | 33);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        String strZzK;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        SpannableStringBuilder spannableStringBuilder;
        int i8;
        int i9;
        int i10;
        int i11;
        zzet zzetVar = this.zza;
        zzetVar.zzb(bArr, i + i2);
        zzetVar.zzh(i);
        int i12 = 1;
        int i13 = 0;
        int i14 = 2;
        zzgtj.zza(zzetVar.zzd() >= 2);
        int iZzt = zzetVar.zzt();
        if (iZzt == 0) {
            strZzK = "";
        } else {
            int iZzg = zzetVar.zzg();
            Charset charsetZzR = zzetVar.zzR();
            int iZzg2 = zzetVar.zzg() - iZzg;
            if (charsetZzR == null) {
                charsetZzR = StandardCharsets.UTF_8;
            }
            strZzK = zzetVar.zzK(iZzt - iZzg2, charsetZzR);
        }
        if (strZzK.isEmpty()) {
            zzdtVar.zza(new zzand(zzgwm.zzi(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strZzK);
        int i15 = this.zzc;
        zzb(spannableStringBuilder2, i15, 0, 0, spannableStringBuilder2.length(), 16711680);
        int i16 = i15;
        int i17 = this.zzd;
        zzc(spannableStringBuilder2, i17, -1, 0, spannableStringBuilder2.length(), 16711680);
        int i18 = i17;
        String str = this.zze;
        int length = spannableStringBuilder2.length();
        if (str != "sans-serif") {
            spannableStringBuilder2.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float fMax = this.zzf;
        while (zzetVar.zzd() >= 8) {
            int iZzg3 = zzetVar.zzg();
            int iZzB = zzetVar.zzB();
            int iZzB2 = zzetVar.zzB();
            if (iZzB2 == 1937013100) {
                zzgtj.zza(zzetVar.zzd() >= i14 ? i12 : i13);
                int iZzt2 = zzetVar.zzt();
                int i19 = i13;
                while (i19 < iZzt2) {
                    zzgtj.zza(zzetVar.zzd() >= 12 ? i12 : i13);
                    int iZzt3 = zzetVar.zzt();
                    int iZzt4 = zzetVar.zzt();
                    zzetVar.zzk(i14);
                    int i20 = iZzt2;
                    int iZzs = zzetVar.zzs();
                    zzetVar.zzk(i12);
                    int iZzB3 = zzetVar.zzB();
                    if (iZzt4 > spannableStringBuilder2.length()) {
                        int length2 = spannableStringBuilder2.length();
                        i6 = i16;
                        i7 = i18;
                        spannableStringBuilder = spannableStringBuilder2;
                        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(iZzt4).length() + 44, 2, String.valueOf(length2)));
                        sb.append("Truncating styl end (");
                        sb.append(iZzt4);
                        sb.append(") to cueText.length() (");
                        sb.append(length2);
                        sb.append(").");
                        zzeg.zzc("Tx3gParser", sb.toString());
                        iZzt4 = spannableStringBuilder.length();
                    } else {
                        i6 = i16;
                        i7 = i18;
                        spannableStringBuilder = spannableStringBuilder2;
                    }
                    if (iZzt3 >= iZzt4) {
                        StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(iZzt3).length() + 36, 2, String.valueOf(iZzt4)));
                        sb2.append("Ignoring styl with start (");
                        sb2.append(iZzt3);
                        sb2.append(") >= end (");
                        sb2.append(iZzt4);
                        sb2.append(").");
                        zzeg.zzc("Tx3gParser", sb2.toString());
                        i10 = i6;
                        i9 = i19;
                        i8 = i20;
                        spannableStringBuilder2 = spannableStringBuilder;
                        i11 = i7;
                    } else {
                        i8 = i20;
                        i9 = i19;
                        spannableStringBuilder2 = spannableStringBuilder;
                        int i21 = i6;
                        zzb(spannableStringBuilder2, iZzs, i21, iZzt3, iZzt4, 0);
                        i10 = i21;
                        i11 = i7;
                        zzc(spannableStringBuilder2, iZzB3, i11, iZzt3, iZzt4, 0);
                    }
                    iZzt2 = i8;
                    i16 = i10;
                    i18 = i11;
                    i12 = 1;
                    i14 = 2;
                    i19 = i9 + 1;
                    i13 = 0;
                }
                i3 = i16;
                i4 = i18;
                i5 = i14;
            } else {
                i3 = i16;
                i4 = i18;
                if (iZzB2 == 1952608120 && this.zzb) {
                    i5 = 2;
                    zzgtj.zza(zzetVar.zzd() >= 2);
                    float fZzt = zzetVar.zzt();
                    int i22 = this.zzg;
                    String str2 = zzfl.zza;
                    fMax = Math.max(0.0f, Math.min(fZzt / i22, 0.95f));
                } else {
                    i5 = 2;
                }
            }
            zzetVar.zzh(iZzg3 + iZzB);
            i16 = i3;
            i14 = i5;
            i18 = i4;
            i12 = 1;
            i13 = 0;
        }
        zzcw zzcwVar = new zzcw();
        zzcwVar.zza(spannableStringBuilder2);
        zzcwVar.zzf(fMax, 0);
        zzcwVar.zzg(0);
        zzdtVar.zza(new zzand(zzgwm.zzj(zzcwVar.zzr()), -9223372036854775807L, -9223372036854775807L));
    }
}
