package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzkr extends zzbm implements zzks {
    public zzkr() {
        super("com.google.android.gms.phenotype.internal.IPhenotypeCallbacks");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Status status = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzbn.zzf(parcel);
                zzb(status);
                return true;
            case 2:
                Status status2 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzbn.zzf(parcel);
                zzc(status2);
                return true;
            case 3:
                Status status3 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzbn.zzf(parcel);
                zze(status3);
                return true;
            case 4:
                Status status4 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzjh zzjhVar = (zzjh) zzbn.zzb(parcel, zzjh.CREATOR);
                zzbn.zzf(parcel);
                zzf(status4, zzjhVar);
                return true;
            case 5:
                Status status5 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzbn.zzf(parcel);
                zzg(status5);
                return true;
            case 6:
                Status status6 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzjl zzjlVar = (zzjl) zzbn.zzb(parcel, zzjl.CREATOR);
                zzbn.zzf(parcel);
                zzh(status6, zzjlVar);
                return true;
            case 7:
                Status status7 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzjj zzjjVar = (zzjj) zzbn.zzb(parcel, zzjj.CREATOR);
                zzbn.zzf(parcel);
                zzi(status7, zzjjVar);
                return true;
            case 8:
                Status status8 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzbn.zzf(parcel);
                zzj(status8);
                return true;
            case 9:
                Status status9 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzjo zzjoVar = (zzjo) zzbn.zzb(parcel, zzjo.CREATOR);
                zzbn.zzf(parcel);
                zzk(status9, zzjoVar);
                return true;
            case 10:
                Status status10 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzjh zzjhVar2 = (zzjh) zzbn.zzb(parcel, zzjh.CREATOR);
                zzbn.zzf(parcel);
                zzl(status10, zzjhVar2);
                return true;
            case 11:
                Status status11 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                long j = parcel.readLong();
                zzbn.zzf(parcel);
                zzm(status11, j);
                return true;
            case 12:
                Status status12 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzbn.zzf(parcel);
                zzn(status12);
                return true;
            case 13:
                Status status13 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzjs zzjsVar = (zzjs) zzbn.zzb(parcel, zzjs.CREATOR);
                zzbn.zzf(parcel);
                zzo(status13, zzjsVar);
                return true;
            case 14:
                Status status14 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzbn.zzf(parcel);
                zzd(status14);
                return true;
            case 15:
                Status status15 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                zzbn.zzf(parcel);
                zzp(status15);
                return true;
            case 16:
                Status status16 = (Status) zzbn.zzb(parcel, Status.CREATOR);
                long j2 = parcel.readLong();
                zzbn.zzf(parcel);
                zzq(status16, j2);
                return true;
            default:
                return false;
        }
    }
}
