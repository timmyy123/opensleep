package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzs;

/* JADX INFO: loaded from: classes4.dex */
public final class zzj extends com.google.android.gms.internal.vision.zzb implements zzh {
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i, int i2, int i3, int i4, int i5, int i6, zzs zzsVar) {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, iObjectWrapper);
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, iObjectWrapper2);
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, iObjectWrapper3);
        parcelA_.writeInt(i);
        parcelA_.writeInt(i2);
        parcelA_.writeInt(i3);
        parcelA_.writeInt(i4);
        parcelA_.writeInt(i5);
        parcelA_.writeInt(i6);
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, zzsVar);
        Parcel parcelZza = zza(4, parcelA_);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelZza.createTypedArray(FaceParcel.CREATOR);
        parcelZza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, iObjectWrapper);
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, zzsVar);
        Parcel parcelZza = zza(1, parcelA_);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelZza.createTypedArray(FaceParcel.CREATOR);
        parcelZza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zza() {
        zzb(3, a_());
    }
}
