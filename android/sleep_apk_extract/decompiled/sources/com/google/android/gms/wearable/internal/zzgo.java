package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgo extends com.google.android.gms.internal.wearable.zzb implements zzgp {
    public zzgo() {
        super("com.google.android.gms.wearable.internal.IWearableListener");
    }

    public static zzgp zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
        return iInterfaceQueryLocalInterface instanceof zzgp ? (zzgp) iInterfaceQueryLocalInterface : new zzgn(iBinder);
    }

    @Override // com.google.android.gms.internal.wearable.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzgj zzgjVar = null;
        zzgk zzgkVar = null;
        switch (i) {
            case 1:
                DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.wearable.zzc.zza(parcel, DataHolder.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzb(dataHolder);
                return true;
            case 2:
                zzhk zzhkVar = (zzhk) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhk.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzc(zzhkVar);
                return true;
            case 3:
                zzib zzibVar = (zzib) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzib.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzd(zzibVar);
                return true;
            case 4:
                zzib zzibVar2 = (zzib) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzib.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zze(zzibVar2);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzib.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzf(arrayListCreateTypedArrayList);
                return true;
            case 6:
                zzl zzlVar = (zzl) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzl.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzh(zzlVar);
                return true;
            case 7:
                zzbq zzbqVar = (zzbq) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzbq.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzj(zzbqVar);
                return true;
            case 8:
                zzao zzaoVar = (zzao) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzao.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzg(zzaoVar);
                return true;
            case 9:
                zzj zzjVar = (zzj) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzj.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzi(zzjVar);
                return true;
            case 10:
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzhk zzhkVar2 = (zzhk) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhk.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IRpcResponseCallback");
                    zzgjVar = iInterfaceQueryLocalInterface instanceof zzgj ? (zzgj) iInterfaceQueryLocalInterface : new zzgj(strongBinder);
                }
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzn(zzhkVar2, zzgjVar);
                return true;
            case 14:
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                return true;
            case 15:
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                return true;
            case 16:
                zzia zziaVar = (zzia) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzia.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzk(zziaVar);
                return true;
            case 17:
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                return true;
            case 18:
                zzft zzftVar = (zzft) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzft.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.wearable.internal.IServiceResponseCallback");
                    zzgkVar = iInterfaceQueryLocalInterface2 instanceof zzgk ? (zzgk) iInterfaceQueryLocalInterface2 : new zzgk(strongBinder2);
                }
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                boolean zZzo = zzo(zzftVar, zzgkVar);
                parcel2.writeNoException();
                parcel2.writeInt(zZzo ? 1 : 0);
                return true;
        }
    }
}
