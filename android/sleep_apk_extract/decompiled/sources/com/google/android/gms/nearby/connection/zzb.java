package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes4.dex */
public final class zzb implements Parcelable.Creator {
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
        boolean z12 = true;
        boolean z13 = true;
        boolean z14 = true;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        int i = 0;
        int i2 = 0;
        boolean z19 = false;
        boolean z20 = false;
        int i3 = 0;
        int i4 = 0;
        boolean z21 = false;
        Strategy strategy = null;
        byte[] bArrCreateByteArray = null;
        ParcelUuid parcelUuid = null;
        byte[] bArrCreateByteArray2 = null;
        zzac[] zzacVarArr = null;
        int[] iArrCreateIntArray = null;
        int[] iArrCreateIntArray2 = null;
        byte[] bArrCreateByteArray3 = null;
        long j = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strategy = (Strategy) SafeParcelReader.createParcelable(parcel, header, Strategy.CREATOR);
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
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 7:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 8:
                    parcelUuid = (ParcelUuid) SafeParcelReader.createParcelable(parcel, header, ParcelUuid.CREATOR);
                    break;
                case 9:
                    z5 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z6 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 13:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 14:
                    z18 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 16:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 17:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 18:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 19:
                    zzacVarArr = (zzac[]) SafeParcelReader.createTypedArray(parcel, header, zzac.CREATOR);
                    break;
                case 20:
                    z19 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 21:
                    z8 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 22:
                    z20 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 23:
                    z9 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 24:
                    iArrCreateIntArray = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 25:
                    iArrCreateIntArray2 = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 26:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 27:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 28:
                    bArrCreateByteArray3 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 29:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 30:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 31:
                    z21 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 32:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 33:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 34:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new AdvertisingOptions(strategy, z, z2, z3, z4, bArrCreateByteArray, z15, parcelUuid, z5, z6, z7, z16, z17, z18, i, i2, bArrCreateByteArray2, j, zzacVarArr, z19, z8, z20, z9, iArrCreateIntArray, iArrCreateIntArray2, z10, i3, bArrCreateByteArray3, z11, i4, z21, z12, z13, z14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new AdvertisingOptions[i];
    }
}
