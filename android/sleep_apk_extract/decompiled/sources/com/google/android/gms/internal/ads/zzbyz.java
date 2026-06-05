package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbyz extends zzbee implements zzbzb {
    public zzbyz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzH(int i, String[] strArr, int[] iArr) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzda(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zze() {
        zzda(10, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzf() {
        zzda(14, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final boolean zzg() {
        Parcel parcelZzcZ = zzcZ(11, zza());
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzh(Bundle bundle) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, bundle);
        zzda(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzi() {
        zzda(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzj() {
        zzda(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzk() {
        zzda(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzl() {
        zzda(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzm(int i, int i2, Intent intent) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeInt(i2);
        zzbeg.zzc(parcelZza, intent);
        zzda(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzn(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzo(Bundle bundle) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, bundle);
        Parcel parcelZzcZ = zzcZ(6, parcelZza);
        if (parcelZzcZ.readInt() != 0) {
            bundle.readFromParcel(parcelZzcZ);
        }
        parcelZzcZ.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzp() {
        zzda(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzq() {
        zzda(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzs() {
        zzda(9, zza());
    }
}
