package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzbmy;
import com.google.android.gms.internal.ads.zzbmz;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbnc;
import com.google.android.gms.internal.ads.zzbne;
import com.google.android.gms.internal.ads.zzbnf;
import com.google.android.gms.internal.ads.zzbnh;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbnm;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbnp;
import com.google.android.gms.internal.ads.zzbsb;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbsk;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbp extends zzbef implements zzbq {
    public zzbp() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    public final boolean zzdd(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbh zzbfVar = null;
        zzcp zzcpVar = null;
        switch (i) {
            case 1:
                zzbn zzbnVarZze = zze();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbnVarZze);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbfVar = iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbf(strongBinder);
                }
                zzbeg.zzh(parcel);
                zzf(zzbfVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zzbmz zzbmzVarZzb = zzbmy.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzg(zzbmzVarZzb);
                parcel2.writeNoException();
                return true;
            case 4:
                zzbnc zzbncVarZzb = zzbnb.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzh(zzbncVarZzb);
                parcel2.writeNoException();
                return true;
            case 5:
                String string = parcel.readString();
                zzbni zzbniVarZzb = zzbnh.zzb(parcel.readStrongBinder());
                zzbnf zzbnfVarZzb = zzbne.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzi(string, zzbniVarZzb, zzbnfVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                zzblt zzbltVar = (zzblt) zzbeg.zzb(parcel, zzblt.CREATOR);
                zzbeg.zzh(parcel);
                zzj(zzbltVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcpVar = iInterfaceQueryLocalInterface2 instanceof zzcp ? (zzcp) iInterfaceQueryLocalInterface2 : new zzcp(strongBinder2);
                }
                zzbeg.zzh(parcel);
                zzq(zzcpVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbnm zzbnmVarZzb = zzbnl.zzb(parcel.readStrongBinder());
                zzr zzrVar = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                zzbeg.zzh(parcel);
                zzk(zzbnmVarZzb, zzrVar);
                parcel2.writeNoException();
                return true;
            case 9:
                PublisherAdViewOptions publisherAdViewOptions = (PublisherAdViewOptions) zzbeg.zzb(parcel, PublisherAdViewOptions.CREATOR);
                zzbeg.zzh(parcel);
                zzl(publisherAdViewOptions);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbnp zzbnpVarZzb = zzbno.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzm(zzbnpVarZzb);
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzbsb zzbsbVar = (zzbsb) zzbeg.zzb(parcel, zzbsb.CREATOR);
                zzbeg.zzh(parcel);
                zzn(zzbsbVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbsk zzbskVarZzb = zzbsj.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzo(zzbskVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                AdManagerAdViewOptions adManagerAdViewOptions = (AdManagerAdViewOptions) zzbeg.zzb(parcel, AdManagerAdViewOptions.CREATOR);
                zzbeg.zzh(parcel);
                zzp(adManagerAdViewOptions);
                parcel2.writeNoException();
                return true;
        }
    }
}
