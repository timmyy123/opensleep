package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzcci;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcg extends zzbef implements zzch {
    public zzcg() {
        super("com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    public final boolean zzdd(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzcb zzbzVar = null;
        zzce zzccVar = null;
        switch (i) {
            case 1:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzfp.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallback");
                    zzbzVar = iInterfaceQueryLocalInterface instanceof zzcb ? (zzcb) iInterfaceQueryLocalInterface : new zzbz(strongBinder);
                }
                zzbeg.zzh(parcel);
                zze(arrayListCreateTypedArrayList, zzbzVar);
                parcel2.writeNoException();
                return true;
            case 2:
                String string = parcel.readString();
                zzbeg.zzh(parcel);
                boolean zZzf = zzf(string);
                parcel2.writeNoException();
                parcel2.writeInt(zZzf ? 1 : 0);
                return true;
            case 3:
                String string2 = parcel.readString();
                zzbeg.zzh(parcel);
                zzcci zzcciVarZzg = zzg(string2);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcciVarZzg);
                return true;
            case 4:
                String string3 = parcel.readString();
                zzbeg.zzh(parcel);
                boolean zZzh = zzh(string3);
                parcel2.writeNoException();
                parcel2.writeInt(zZzh ? 1 : 0);
                return true;
            case 5:
                String string4 = parcel.readString();
                zzbeg.zzh(parcel);
                zzbgj zzbgjVarZzi = zzi(string4);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbgjVarZzi);
                return true;
            case 6:
                String string5 = parcel.readString();
                zzbeg.zzh(parcel);
                boolean zZzj = zzj(string5);
                parcel2.writeNoException();
                parcel2.writeInt(zZzj ? 1 : 0);
                return true;
            case 7:
                String string6 = parcel.readString();
                zzbeg.zzh(parcel);
                zzbu zzbuVarZzk = zzk(string6);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarZzk);
                return true;
            case 8:
                zzbvb.zzf(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                return true;
            case 9:
                String string7 = parcel.readString();
                zzfp zzfpVar = (zzfp) zzbeg.zzb(parcel, zzfp.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
                    zzccVar = iInterfaceQueryLocalInterface2 instanceof zzce ? (zzce) iInterfaceQueryLocalInterface2 : new zzcc(strongBinder2);
                }
                zzbeg.zzh(parcel);
                boolean zZzm = zzm(string7, zzfpVar, zzccVar);
                parcel2.writeNoException();
                parcel2.writeInt(zZzm ? 1 : 0);
                return true;
            case 10:
                int i3 = parcel.readInt();
                String string8 = parcel.readString();
                zzbeg.zzh(parcel);
                boolean zZzn = zzn(i3, string8);
                parcel2.writeNoException();
                parcel2.writeInt(zZzn ? 1 : 0);
                return true;
            case 11:
                String string9 = parcel.readString();
                zzbeg.zzh(parcel);
                zzbu zzbuVarZzo = zzo(string9);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarZzo);
                return true;
            case 12:
                String string10 = parcel.readString();
                zzbeg.zzh(parcel);
                zzbgj zzbgjVarZzp = zzp(string10);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbgjVarZzp);
                return true;
            case 13:
                String string11 = parcel.readString();
                zzbeg.zzh(parcel);
                zzcci zzcciVarZzq = zzq(string11);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcciVarZzq);
                return true;
            case 14:
                int i4 = parcel.readInt();
                String string12 = parcel.readString();
                zzbeg.zzh(parcel);
                zzfp zzfpVarZzr = zzr(i4, string12);
                parcel2.writeNoException();
                zzbeg.zzd(parcel2, zzfpVarZzr);
                return true;
            case 15:
                int i5 = parcel.readInt();
                zzbeg.zzh(parcel);
                Bundle bundleZzs = zzs(i5);
                parcel2.writeNoException();
                zzbeg.zzd(parcel2, bundleZzs);
                return true;
            case 16:
                int i6 = parcel.readInt();
                String string13 = parcel.readString();
                zzbeg.zzh(parcel);
                int iZzt = zzt(i6, string13);
                parcel2.writeNoException();
                parcel2.writeInt(iZzt);
                return true;
            case 17:
                int i7 = parcel.readInt();
                String string14 = parcel.readString();
                zzbeg.zzh(parcel);
                boolean zZzu = zzu(i7, string14);
                parcel2.writeNoException();
                parcel2.writeInt(zZzu ? 1 : 0);
                return true;
            case 18:
                int i8 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzv(i8);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
