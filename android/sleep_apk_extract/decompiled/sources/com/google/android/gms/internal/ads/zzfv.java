package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfv implements zzao {
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzfv(String str, byte[] bArr, int i, int i2) {
        byte b;
        switch (str.hashCode()) {
            case -1949883051:
                if (str.equals("com.android.capture.fps")) {
                    if (i2 != 23) {
                        z = false;
                        zzgtj.zza(z);
                    } else if (bArr.length != 4) {
                        i2 = 23;
                        z = false;
                        zzgtj.zza(z);
                    } else {
                        i2 = 23;
                        zzgtj.zza(z);
                    }
                }
                break;
            case -269399509:
                if (str.equals("auxiliary.tracks.interleaved")) {
                    if (i2 != 75) {
                        z = false;
                        zzgtj.zza(z);
                    } else if (bArr.length == 1 && ((b = bArr[0]) == 0 || b == 1)) {
                        i2 = 75;
                        zzgtj.zza(z);
                    } else {
                        i2 = 75;
                        z = false;
                        zzgtj.zza(z);
                    }
                }
                break;
            case 1011693540:
                if (str.equals("auxiliary.tracks.length")) {
                    if (i2 != 78) {
                        z = false;
                        zzgtj.zza(z);
                    } else if (bArr.length != 8) {
                        i2 = 78;
                        z = false;
                        zzgtj.zza(z);
                    } else {
                        i2 = 78;
                        zzgtj.zza(z);
                    }
                }
                break;
            case 1098277265:
                if (str.equals("auxiliary.tracks.offset")) {
                }
                break;
            case 2002123038:
                if (str.equals("auxiliary.tracks.map")) {
                    zzgtj.zza(i2 == 0);
                }
                break;
        }
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfv.class == obj.getClass()) {
            zzfv zzfvVar = (zzfv) obj;
            if (this.zza.equals(zzfvVar.zza) && Arrays.equals(this.zzb, zzfvVar.zzb) && this.zzc == zzfvVar.zzc && this.zzd == zzfvVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        return ((((Arrays.hashCode(this.zzb) + (iHashCode * 31)) * 31) + this.zzc) * 31) + this.zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        String string;
        int i = this.zzd;
        if (i != 0) {
            if (i == 1) {
                string = zzfl.zzj(this.zzb);
            } else if (i == 23) {
                string = String.valueOf(Float.intBitsToFloat(zzhah.zzd(this.zzb)));
            } else if (i == 67) {
                string = String.valueOf(zzhah.zzd(this.zzb));
            } else if (i == 75) {
                string = String.valueOf(this.zzb[0] & 255);
            } else if (i != 78) {
                byte[] bArr = this.zzb;
                String str = zzfl.zza;
                string = zzgzh.zzn().zzi().zzj(bArr, 0, bArr.length);
            } else {
                string = String.valueOf(new zzet(this.zzb).zzJ());
            }
        } else if (this.zza.equals("auxiliary.tracks.map")) {
            List listZzb = zzb();
            StringBuilder sb = new StringBuilder();
            sb.append("track types = ");
            zzgtd.zzb(sb, listZzb, ",");
            string = sb.toString();
        }
        String str2 = this.zza;
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str2).length() + 18 + String.valueOf(string).length()), "mdta: key=", str2, ", value=", string);
    }

    public final List zzb() {
        zzgtj.zzj(this.zza.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte[] bArr = this.zzb;
        byte b = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b; i++) {
            arrayList.add(Integer.valueOf(bArr[i + 2] & 255));
        }
        return arrayList;
    }
}
