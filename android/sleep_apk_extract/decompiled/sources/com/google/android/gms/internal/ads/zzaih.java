package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
final class zzaih extends zzaim {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzaih(zzahk zzahkVar) {
        super(zzahkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    public final boolean zza(zzet zzetVar) throws zzail {
        if (this.zzc) {
            zzetVar.zzk(1);
        } else {
            int iZzs = zzetVar.zzs();
            int i = iZzs >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(iZzs >> 2) & 3];
                zzt zztVar = new zzt();
                zztVar.zzn("video/x-flv");
                zztVar.zzo("audio/mpeg");
                zztVar.zzG(1);
                zztVar.zzH(i2);
                this.zza.zzA(zztVar.zzO());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzt zztVar2 = new zzt();
                zztVar2.zzn("video/x-flv");
                zztVar2.zzo(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zztVar2.zzG(1);
                zztVar2.zzH(8000);
                this.zza.zzA(zztVar2.zzO());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzail(zzba$$ExternalSyntheticOutline0.m(i, "Audio format not supported: ", new StringBuilder(String.valueOf(i).length() + 28)));
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    public final boolean zzb(zzet zzetVar, long j) {
        if (this.zze == 2) {
            int iZzd = zzetVar.zzd();
            zzahk zzahkVar = this.zza;
            zzahkVar.zzc(zzetVar, iZzd);
            zzahkVar.zze(j, 1, iZzd, 0, null);
            return true;
        }
        int iZzs = zzetVar.zzs();
        if (iZzs != 0 || this.zzd) {
            if (this.zze == 10 && iZzs != 1) {
                return false;
            }
            int iZzd2 = zzetVar.zzd();
            zzahk zzahkVar2 = this.zza;
            zzahkVar2.zzc(zzetVar, iZzd2);
            zzahkVar2.zze(j, 1, iZzd2, 0, null);
            return true;
        }
        int iZzd3 = zzetVar.zzd();
        byte[] bArr = new byte[iZzd3];
        zzetVar.zzm(bArr, 0, iZzd3);
        zzaev zzaevVarZza = zzaew.zza(bArr);
        zzt zztVar = new zzt();
        zztVar.zzn("video/x-flv");
        zztVar.zzo("audio/mp4a-latm");
        zztVar.zzk(zzaevVarZza.zzc);
        zztVar.zzG(zzaevVarZza.zzb);
        zztVar.zzH(zzaevVarZza.zza);
        zztVar.zzr(Collections.singletonList(bArr));
        this.zza.zzA(zztVar.zzO());
        this.zzd = true;
        return false;
    }
}
