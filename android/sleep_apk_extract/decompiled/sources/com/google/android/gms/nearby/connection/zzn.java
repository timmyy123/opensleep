package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes4.dex */
public final class zzn implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z14 = false;
        long j = 0;
        byte[] bArrCreateByteArray = null;
        int[] iArrCreateIntArray = null;
        int[] iArrCreateIntArray2 = null;
        byte[] bArrCreateByteArray2 = null;
        Strategy strategy = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 2:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 3:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 4:
                    z3 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    z4 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    z5 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 7:
                    z6 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 8:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 10:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z8 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    z9 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 13:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 15:
                    iArrCreateIntArray = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 16:
                    iArrCreateIntArray2 = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 17:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 18:
                    strategy = (Strategy) SafeParcelReader.createParcelable(parcel, header, Strategy.CREATOR);
                    break;
                case 19:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 20:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 21:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 22:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 23:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ConnectionOptions(z12, z, z2, z3, z4, z5, z6, z7, bArrCreateByteArray, z13, z8, z9, i, i2, iArrCreateIntArray, iArrCreateIntArray2, bArrCreateByteArray2, strategy, i3, j, z14, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionOptions[i];
    }
}
