package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzga extends com.google.android.gms.internal.measurement.zzbm implements zzgb {
    public zzga() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzgh zzgfVar = null;
        zzge zzgcVar = null;
        switch (i) {
            case 1:
                zzbh zzbhVar = (zzbh) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbh.CREATOR);
                zzr zzrVar = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zze(zzbhVar, zzrVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzpl zzplVar = (zzpl) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzpl.CREATOR);
                zzr zzrVar2 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzf(zzplVar, zzrVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                zzr zzrVar3 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzg(zzrVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbh zzbhVar2 = (zzbh) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbh.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzh(zzbhVar2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzr zzrVar4 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzi(zzrVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzr zzrVar5 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                boolean zZza = com.google.android.gms.internal.measurement.zzbn.zza(parcel);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listZzj = zzj(zzrVar5, zZza);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzj);
                return true;
            case 9:
                zzbh zzbhVar3 = (zzbh) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbh.CREATOR);
                String string3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                byte[] bArrZzk = zzk(zzbhVar3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrZzk);
                return true;
            case 10:
                long j = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzl(j, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzr zzrVar6 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                String strZzm = zzm(zzrVar6);
                parcel2.writeNoException();
                parcel2.writeString(strZzm);
                return true;
            case 12:
                zzah zzahVar = (zzah) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzah.CREATOR);
                zzr zzrVar7 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzn(zzahVar, zzrVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzah zzahVar2 = (zzah) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzah.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzo(zzahVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZza2 = com.google.android.gms.internal.measurement.zzbn.zza(parcel);
                zzr zzrVar8 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listZzp = zzp(string7, string8, zZza2, zzrVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzp);
                return true;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zZza3 = com.google.android.gms.internal.measurement.zzbn.zza(parcel);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listZzq = zzq(string9, string10, string11, zZza3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzq);
                return true;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzr zzrVar9 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listZzr = zzr(string12, string13, zzrVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzr);
                return true;
            case 17:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listZzs = zzs(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzs);
                return true;
            case 18:
                zzr zzrVar10 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzt(zzrVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR);
                zzr zzrVar11 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzu(bundle, zzrVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzr zzrVar12 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzv(zzrVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                zzr zzrVar13 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzao zzaoVarZzw = zzw(zzrVar13);
                parcel2.writeNoException();
                if (zzaoVarZzw == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    zzaoVarZzw.writeToParcel(parcel2, 1);
                }
                return true;
            case 24:
                zzr zzrVar14 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listZzx = zzx(zzrVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzx);
                return true;
            case 25:
                zzr zzrVar15 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzy(zzrVar15);
                parcel2.writeNoException();
                return true;
            case 26:
                zzr zzrVar16 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzz(zzrVar16);
                parcel2.writeNoException();
                return true;
            case 27:
                zzr zzrVar17 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzA(zzrVar17);
                parcel2.writeNoException();
                return true;
            case 29:
                zzr zzrVar18 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                zzoo zzooVar = (zzoo) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzoo.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    zzgfVar = iInterfaceQueryLocalInterface instanceof zzgh ? (zzgh) iInterfaceQueryLocalInterface : new zzgf(strongBinder);
                }
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzB(zzrVar18, zzooVar, zzgfVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzr zzrVar19 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                zzaf zzafVar = (zzaf) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzaf.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzC(zzrVar19, zzafVar);
                parcel2.writeNoException();
                return true;
            case 31:
                zzr zzrVar20 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    zzgcVar = iInterfaceQueryLocalInterface2 instanceof zzge ? (zzge) iInterfaceQueryLocalInterface2 : new zzgc(strongBinder2);
                }
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzD(zzrVar20, bundle3, zzgcVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
