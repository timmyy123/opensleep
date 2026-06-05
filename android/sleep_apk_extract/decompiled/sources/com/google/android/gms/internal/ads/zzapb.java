package com.google.android.gms.internal.ads;

import android.text.Layout;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzapb {
    public CharSequence zzc;
    public long zza = 0;
    public long zzb = 0;
    public int zzd = 2;
    public float zze = -3.4028235E38f;
    public int zzf = 1;
    public int zzg = 0;
    public float zzh = -3.4028235E38f;
    public int zzi = Integer.MIN_VALUE;
    public float zzj = 1.0f;
    public int zzk = Integer.MIN_VALUE;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzcw zza() {
        Layout.Alignment alignment;
        float f = this.zzh;
        float f2 = -3.4028235E38f;
        if (f == -3.4028235E38f) {
            int i = this.zzd;
            f = i != 4 ? i != 5 ? 0.5f : 1.0f : 0.0f;
        }
        int i2 = this.zzi;
        if (i2 == Integer.MIN_VALUE) {
            int i3 = this.zzd;
            if (i3 == 1) {
                i2 = 0;
            } else if (i3 == 3) {
                i2 = 2;
            } else if (i3 != 4) {
                if (i3 != 5) {
                    i2 = 1;
                }
            }
        }
        zzcw zzcwVar = new zzcw();
        int i4 = this.zzd;
        if (i4 == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else if (i4 == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i4 == 3) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        } else if (i4 != 4) {
            if (i4 != 5) {
                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i4).length() + 23), "Unknown textAlignment: ", i4, "WebvttCueParser");
                alignment = null;
            }
        }
        zzcwVar.zzd(alignment);
        float f3 = this.zze;
        int i5 = this.zzf;
        if (f3 == -3.4028235E38f || i5 != 0 || (f3 >= 0.0f && f3 <= 1.0f)) {
            if (f3 != -3.4028235E38f) {
                f2 = f3;
            } else if (i5 == 0) {
                f2 = 1.0f;
            }
        }
        zzcwVar.zzf(f2, i5);
        zzcwVar.zzg(this.zzg);
        zzcwVar.zzi(f);
        zzcwVar.zzj(i2);
        float f4 = this.zzj;
        if (i2 == 0) {
            f = 1.0f - f;
        } else if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3(String.valueOf(i2));
                return null;
            }
        } else if (f <= 0.5f) {
            f += f;
        } else {
            float f5 = 1.0f - f;
            f = f5 + f5;
        }
        zzcwVar.zzm(Math.min(f4, f));
        zzcwVar.zzo(this.zzk);
        CharSequence charSequence = this.zzc;
        if (charSequence != null) {
            zzcwVar.zza(charSequence);
        }
        return zzcwVar;
    }
}
