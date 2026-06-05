package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzamj {
    public final boolean zza;
    public final String zzb;
    public final zzahj zzc;
    public final int zzd;
    public final byte[] zze;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzamj(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4 = 1;
        zzgtj.zza((bArr2 == null) ^ (i == 0));
        this.zza = z;
        this.zzb = str;
        this.zzd = i;
        this.zze = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (!str.equals("cbc1")) {
                        StringBuilder sb = new StringBuilder(str.length() + 68);
                        sb.append("Unsupported protection scheme type '");
                        sb.append(str);
                        sb.append("'. Assuming AES-CTR crypto mode.");
                        zzeg.zzc("TrackEncryptionBox", sb.toString());
                    } else {
                        i4 = 2;
                    }
                    break;
                case 3046671:
                    if (str.equals("cbcs")) {
                    }
                    break;
                case 3049879:
                    if (!str.equals("cenc")) {
                    }
                    break;
                case 3049895:
                    if (!str.equals("cens")) {
                    }
                    break;
            }
        }
        this.zzc = new zzahj(i4, bArr, i2, i3);
    }
}
