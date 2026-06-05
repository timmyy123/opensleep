package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzkt extends zzbl implements IInterface {
    public zzkt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.phenotype.internal.IPhenotypeService");
    }

    public final void zze(zzks zzksVar, String str, int i, String[] strArr, byte[] bArr) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzksVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(0);
        parcelZza.writeStringArray(strArr);
        parcelZza.writeByteArray(null);
        zzc(1, parcelZza);
    }

    public final void zzf(zzks zzksVar, String str, String str2, String str3) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzksVar);
        parcelZza.writeString(str);
        parcelZza.writeString("");
        parcelZza.writeString(null);
        zzc(11, parcelZza);
    }

    public final void zzg(zzks zzksVar, String str) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzksVar);
        parcelZza.writeString(str);
        zzc(5, parcelZza);
    }

    public final void zzh(zzks zzksVar, byte[] bArr) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzksVar);
        parcelZza.writeByteArray(bArr);
        zzc(31, parcelZza);
    }

    public final void zzi(zzkq zzkqVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzkqVar);
        zzc(27, parcelZza);
    }

    public final void zzj(String str, zzko zzkoVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbn.zzd(parcelZza, zzkoVar);
        zzc(28, parcelZza);
    }
}
