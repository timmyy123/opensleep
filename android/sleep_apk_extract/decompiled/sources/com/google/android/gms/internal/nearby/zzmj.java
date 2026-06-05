package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        byte[] bArrCreateByteArray = null;
        zznr zznrVar = null;
        zzox[] zzoxVarArr = null;
        byte[] bArrCreateByteArray2 = null;
        zzox zzoxVar = null;
        zzlw zzlwVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 3:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 4:
                    zznrVar = (zznr) SafeParcelReader.createParcelable(parcel, header, zznr.CREATOR);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzoxVarArr = (zzox[]) SafeParcelReader.createTypedArray(parcel, header, zzox.CREATOR);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 9:
                    zzoxVar = (zzox) SafeParcelReader.createParcelable(parcel, header, zzox.CREATOR);
                    break;
                case 10:
                    zzlwVar = (zzlw) SafeParcelReader.createParcelable(parcel, header, zzlw.CREATOR);
                    break;
                case 11:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 12:
                    i6 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzmi(i, i2, bArrCreateByteArray, zznrVar, i3, zzoxVarArr, i4, bArrCreateByteArray2, zzoxVar, zzlwVar, i5, i6, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzmi[i];
    }
}
