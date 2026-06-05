package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbmn;
import com.google.android.gms.internal.ads.zzbqp;
import com.google.android.gms.internal.ads.zzbqq;
import com.google.android.gms.internal.ads.zzbqt;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcem;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcn extends zzbef implements zzco {
    public zzcn() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    public final boolean zzdd(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                String string = parcel.readString();
                zzbvc zzbvcVarZzf = zzbvb.zzf(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbu zzbuVarZzb = zzb(iObjectWrapperAsInterface, zzrVar, string, zzbvcVarZzf, i3);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarZzb);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar2 = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                String string2 = parcel.readString();
                zzbvc zzbvcVarZzf2 = zzbvb.zzf(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbu zzbuVarZzc = zzc(iObjectWrapperAsInterface2, zzrVar2, string2, zzbvcVarZzf2, i4);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarZzc);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzbvc zzbvcVarZzf3 = zzbvb.zzf(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbq zzbqVarZzd = zzd(iObjectWrapperAsInterface3, string3, zzbvcVarZzf3, i5);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbqVarZzd);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, null);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzbmi zzbmiVarZze = zze(iObjectWrapperAsInterface4, iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbmiVarZze);
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf4 = zzbvb.zzf(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzcbs zzcbsVarZzf = zzf(iObjectWrapperAsInterface6, zzbvcVarZzf4, i6);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcbsVarZzf);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, null);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzbzb zzbzbVarZzg = zzg(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbzbVarZzg);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzcy zzcyVarZzi = zzi(iObjectWrapperAsInterface8, i7);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcyVarZzi);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar3 = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                String string4 = parcel.readString();
                int i8 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbu zzbuVarZzj = zzj(iObjectWrapperAsInterface9, zzrVar3, string4, i8);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarZzj);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzbmn zzbmnVarZzk = zzk(iObjectWrapperAsInterface10, iObjectWrapperAsInterface11, iObjectWrapperAsInterface12);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbmnVarZzk);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzbvc zzbvcVarZzf5 = zzbvb.zzf(parcel.readStrongBinder());
                int i9 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzcci zzcciVarZzl = zzl(iObjectWrapperAsInterface13, string5, zzbvcVarZzf5, i9);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcciVarZzl);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperAsInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar4 = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                String string6 = parcel.readString();
                zzbvc zzbvcVarZzf6 = zzbvb.zzf(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbu zzbuVarZzm = zzm(iObjectWrapperAsInterface14, zzrVar4, string6, zzbvcVarZzf6, i10);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarZzm);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf7 = zzbvb.zzf(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzcem zzcemVarZzn = zzn(iObjectWrapperAsInterface15, zzbvcVarZzf7, i11);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcemVarZzn);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperAsInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf8 = zzbvb.zzf(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbyu zzbyuVarZzo = zzo(iObjectWrapperAsInterface16, zzbvcVarZzf8, i12);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbyuVarZzo);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperAsInterface17 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf9 = zzbvb.zzf(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                zzbqq zzbqqVarZzc = zzbqp.zzc(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzbqt zzbqtVarZzp = zzp(iObjectWrapperAsInterface17, zzbvcVarZzf9, i13, zzbqqVarZzc);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbqtVarZzp);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperAsInterface18 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf10 = zzbvb.zzf(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzdt zzdtVarZzq = zzq(iObjectWrapperAsInterface18, zzbvcVarZzf10, i14);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzdtVarZzq);
                return true;
            case 18:
                IObjectWrapper iObjectWrapperAsInterface19 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf11 = zzbvb.zzf(parcel.readStrongBinder());
                int i15 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzch zzchVarZzh = zzh(iObjectWrapperAsInterface19, zzbvcVarZzf11, i15);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzchVarZzh);
                return true;
            default:
                return false;
        }
    }
}
