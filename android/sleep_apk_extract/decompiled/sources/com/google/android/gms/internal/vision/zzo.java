package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

/* JADX INFO: loaded from: classes4.dex */
public final class zzo extends zzb implements zzl {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final Barcode[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) {
        Parcel parcelA_ = a_();
        zzd.zza(parcelA_, iObjectWrapper);
        zzd.zza(parcelA_, zzsVar);
        Parcel parcelZza = zza(1, parcelA_);
        Barcode[] barcodeArr = (Barcode[]) parcelZza.createTypedArray(Barcode.CREATOR);
        parcelZza.recycle();
        return barcodeArr;
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final Barcode[] zzb(IObjectWrapper iObjectWrapper, zzs zzsVar) {
        Parcel parcelA_ = a_();
        zzd.zza(parcelA_, iObjectWrapper);
        zzd.zza(parcelA_, zzsVar);
        Parcel parcelZza = zza(2, parcelA_);
        Barcode[] barcodeArr = (Barcode[]) parcelZza.createTypedArray(Barcode.CREATOR);
        parcelZza.recycle();
        return barcodeArr;
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final void zza() {
        zzb(3, a_());
    }
}
