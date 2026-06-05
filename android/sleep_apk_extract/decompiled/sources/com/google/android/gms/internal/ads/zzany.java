package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zzany {
    private final zzet zza = new zzet();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    public final zzcx zza() {
        int i;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzet zzetVar = this.zza;
        if (zzetVar.zze() == 0 || zzetVar.zzg() != zzetVar.zze() || !this.zzc) {
            return null;
        }
        zzetVar.zzh(0);
        int i2 = this.zzh * this.zzi;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int iZzs = zzetVar.zzs();
            if (iZzs != 0) {
                i = i3 + 1;
                iArr[i3] = this.zzb[iZzs];
            } else {
                int iZzs2 = zzetVar.zzs();
                if (iZzs2 != 0) {
                    int iZzs3 = iZzs2 & 63;
                    if ((iZzs2 & 64) != 0) {
                        iZzs3 = (iZzs3 << 8) | zzetVar.zzs();
                    }
                    int i4 = iZzs2 & 128;
                    int[] iArr2 = this.zzb;
                    i = iZzs3 + i3;
                    Arrays.fill(iArr, i3, i, i4 == 0 ? iArr2[0] : iArr2[zzetVar.zzs()]);
                }
            }
            i3 = i;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcw zzcwVar = new zzcw();
        zzcwVar.zzc(bitmapCreateBitmap);
        zzcwVar.zzi(this.zzf / this.zzd);
        zzcwVar.zzj(0);
        zzcwVar.zzf(this.zzg / this.zze, 0);
        zzcwVar.zzg(0);
        zzcwVar.zzm(this.zzh / this.zzd);
        zzcwVar.zzn(this.zzi / this.zze);
        return zzcwVar.zzr();
    }

    public final void zzb() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zza(0);
        this.zzc = false;
    }

    public final /* synthetic */ void zzc(zzet zzetVar, int i) {
        if (i % 5 != 2) {
            return;
        }
        zzetVar.zzk(2);
        int[] iArr = this.zzb;
        Arrays.fill(iArr, 0);
        int i2 = 0;
        for (int i3 = i / 5; i2 < i3; i3 = i3) {
            int iZzs = zzetVar.zzs();
            int iZzs2 = zzetVar.zzs();
            int iZzs3 = zzetVar.zzs();
            int iZzs4 = zzetVar.zzs();
            double d = iZzs2;
            int iZzs5 = zzetVar.zzs() << 24;
            String str = zzfl.zza;
            double d2 = iZzs3 - 128;
            double d3 = iZzs4 - 128;
            iArr[iZzs] = (Math.max(0, Math.min((int) ((1.402d * d2) + d), PHIpAddressSearchManager.END_IP_SCAN)) << 16) | iZzs5 | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), PHIpAddressSearchManager.END_IP_SCAN)) << 8) | Math.max(0, Math.min((int) ((d3 * 1.772d) + d), PHIpAddressSearchManager.END_IP_SCAN));
            i2++;
        }
        this.zzc = true;
    }

    public final /* synthetic */ void zzd(zzet zzetVar, int i) {
        int iZzx;
        if (i < 4) {
            return;
        }
        zzetVar.zzk(3);
        int i2 = i - 4;
        if ((zzetVar.zzs() & 128) != 0) {
            if (i2 < 7 || (iZzx = zzetVar.zzx()) < 4) {
                return;
            }
            this.zzh = zzetVar.zzt();
            this.zzi = zzetVar.zzt();
            this.zza.zza(iZzx - 4);
            i2 = i - 11;
        }
        zzet zzetVar2 = this.zza;
        int iZzg = zzetVar2.zzg();
        int iZze = zzetVar2.zze();
        if (iZzg >= iZze || i2 <= 0) {
            return;
        }
        int iMin = Math.min(i2, iZze - iZzg);
        zzetVar.zzm(zzetVar2.zzi(), iZzg, iMin);
        zzetVar2.zzh(iZzg + iMin);
    }

    public final /* synthetic */ void zze(zzet zzetVar, int i) {
        if (i < 19) {
            return;
        }
        this.zzd = zzetVar.zzt();
        this.zze = zzetVar.zzt();
        zzetVar.zzk(11);
        this.zzf = zzetVar.zzt();
        this.zzg = zzetVar.zzt();
    }
}
