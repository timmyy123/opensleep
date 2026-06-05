package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes4.dex */
public final class zzh implements Parcelable.Creator<ExperimentTokens> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExperimentTokens createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        byte[] bArrCreateByteArray = null;
        byte[][] bArrCreateByteArrayArray = null;
        byte[][] bArrCreateByteArrayArray2 = null;
        byte[][] bArrCreateByteArrayArray3 = null;
        byte[][] bArrCreateByteArrayArray4 = null;
        int[] iArrCreateIntArray = null;
        byte[][] bArrCreateByteArrayArray5 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 4:
                    bArrCreateByteArrayArray = SafeParcelReader.createByteArrayArray(parcel, header);
                    break;
                case 5:
                    bArrCreateByteArrayArray2 = SafeParcelReader.createByteArrayArray(parcel, header);
                    break;
                case 6:
                    bArrCreateByteArrayArray3 = SafeParcelReader.createByteArrayArray(parcel, header);
                    break;
                case 7:
                    bArrCreateByteArrayArray4 = SafeParcelReader.createByteArrayArray(parcel, header);
                    break;
                case 8:
                    iArrCreateIntArray = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 9:
                    bArrCreateByteArrayArray5 = SafeParcelReader.createByteArrayArray(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ExperimentTokens(strCreateString, bArrCreateByteArray, bArrCreateByteArrayArray, bArrCreateByteArrayArray2, bArrCreateByteArrayArray3, bArrCreateByteArrayArray4, iArrCreateIntArray, bArrCreateByteArrayArray5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExperimentTokens[] newArray(int i) {
        return new ExperimentTokens[i];
    }
}
