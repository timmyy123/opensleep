package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcap extends zzbef implements zzcaq {
    public zzcap() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    public final boolean zzdd(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzcau zzcasVar = null;
        zzcav zzcavVar = null;
        zzcau zzcasVar2 = null;
        zzcau zzcasVar3 = null;
        zzcau zzcasVar4 = null;
        switch (i) {
            case 1:
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                zzbeg.zzd(parcel2, null);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (iInterfaceQueryLocalInterface instanceof zzcar) {
                    }
                }
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                zzcbd zzcbdVar = (zzcbd) zzbeg.zzb(parcel, zzcbd.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzcasVar = iInterfaceQueryLocalInterface2 instanceof zzcau ? (zzcau) iInterfaceQueryLocalInterface2 : new zzcas(strongBinder2);
                }
                zzbeg.zzh(parcel);
                zze(zzcbdVar, zzcasVar);
                parcel2.writeNoException();
                return true;
            case 5:
                zzcbd zzcbdVar2 = (zzcbd) zzbeg.zzb(parcel, zzcbd.CREATOR);
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzcasVar4 = iInterfaceQueryLocalInterface3 instanceof zzcau ? (zzcau) iInterfaceQueryLocalInterface3 : new zzcas(strongBinder3);
                }
                zzbeg.zzh(parcel);
                zzf(zzcbdVar2, zzcasVar4);
                parcel2.writeNoException();
                return true;
            case 6:
                zzcbd zzcbdVar3 = (zzcbd) zzbeg.zzb(parcel, zzcbd.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzcasVar3 = iInterfaceQueryLocalInterface4 instanceof zzcau ? (zzcau) iInterfaceQueryLocalInterface4 : new zzcas(strongBinder4);
                }
                zzbeg.zzh(parcel);
                zzg(zzcbdVar3, zzcasVar3);
                parcel2.writeNoException();
                return true;
            case 7:
                String string = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzcasVar2 = iInterfaceQueryLocalInterface5 instanceof zzcau ? (zzcau) iInterfaceQueryLocalInterface5 : new zzcas(strongBinder5);
                }
                zzbeg.zzh(parcel);
                zzh(string, zzcasVar2);
                parcel2.writeNoException();
                return true;
            case 8:
                zzcam zzcamVar = (zzcam) zzbeg.zzb(parcel, zzcam.CREATOR);
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
                    zzcavVar = iInterfaceQueryLocalInterface6 instanceof zzcav ? (zzcav) iInterfaceQueryLocalInterface6 : new zzcav(strongBinder6);
                }
                zzbeg.zzh(parcel);
                zzj(zzcamVar, zzcavVar);
                parcel2.writeNoException();
                return true;
            case 9:
                String string2 = parcel.readString();
                zzbeg.zzh(parcel);
                zzi(string2);
                parcel2.writeNoException();
                return true;
        }
    }
}
