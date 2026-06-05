package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbvd extends zzbee implements zzbvf {
    public zzbvd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzA(boolean z) {
        Parcel parcelZza = zza();
        int i = zzbeg.$r8$clinit;
        parcelZza.writeInt(z ? 1 : 0);
        zzda(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final com.google.android.gms.ads.internal.client.zzea zzB() {
        Parcel parcelZzcZ = zzcZ(26, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbvr zzC() {
        zzbvr zzbvpVar;
        Parcel parcelZzcZ = zzcZ(27, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbvpVar = iInterfaceQueryLocalInterface instanceof zzbvr ? (zzbvr) iInterfaceQueryLocalInterface : new zzbvp(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzD(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(28, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzE(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(30, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzF(IObjectWrapper iObjectWrapper, zzbrt zzbrtVar, List list) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbrtVar);
        parcelZza.writeTypedList(list);
        zzda(31, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzG(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbxq zzH() {
        Parcel parcelZzcZ = zzcZ(33, zza());
        zzbxq zzbxqVar = (zzbxq) zzbeg.zzb(parcelZzcZ, zzbxq.CREATOR);
        parcelZzcZ.recycle();
        return zzbxqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbxq zzI() {
        Parcel parcelZzcZ = zzcZ(34, zza());
        zzbxq zzbxqVar = (zzbxq) zzbeg.zzb(parcelZzcZ, zzbxq.CREATOR);
        parcelZzcZ.recycle();
        return zzbxqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzJ(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzrVar);
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbvl zzK() {
        zzbvl zzbvjVar;
        Parcel parcelZzcZ = zzcZ(36, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbvjVar = iInterfaceQueryLocalInterface instanceof zzbvl ? (zzbvl) iInterfaceQueryLocalInterface : new zzbvj(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzL(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(37, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzM(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzN(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbvn zzO() {
        zzbvn zzbvnVar;
        Parcel parcelZzcZ = zzcZ(15, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvnVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzbvnVar = iInterfaceQueryLocalInterface instanceof zzbvn ? (zzbvn) iInterfaceQueryLocalInterface : new zzbvn(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbvo zzP() {
        zzbvo zzbvoVar;
        Parcel parcelZzcZ = zzcZ(16, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvoVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzbvoVar = iInterfaceQueryLocalInterface instanceof zzbvo ? (zzbvo) iInterfaceQueryLocalInterface : new zzbvo(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final IObjectWrapper zzf() {
        return zzba$$ExternalSyntheticOutline0.m(zzcZ(2, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzh() {
        zzda(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzi() {
        zzda(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzrVar);
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzk(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzl() {
        zzda(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzm() {
        zzda(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzn(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzcca zzccaVar, String str2) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(null);
        zzbeg.zze(parcelZza, zzccaVar);
        parcelZza.writeString(str2);
        zzda(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzo(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzda(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzp() {
        zzda(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final boolean zzq() {
        Parcel parcelZzcZ = zzcZ(13, zza());
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzr(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar, zzblt zzbltVar, List list) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zze(parcelZza, zzbviVar);
        zzbeg.zzc(parcelZza, zzbltVar);
        parcelZza.writeStringList(list);
        zzda(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final boolean zzx() {
        Parcel parcelZzcZ = zzcZ(22, zza());
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzy(IObjectWrapper iObjectWrapper, zzcca zzccaVar, List list) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzccaVar);
        parcelZza.writeStringList(list);
        zzda(23, parcelZza);
    }
}
