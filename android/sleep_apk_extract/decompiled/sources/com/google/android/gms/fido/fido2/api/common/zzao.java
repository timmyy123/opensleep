package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzao implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArrCreateByteArray = null;
        Double doubleObject = null;
        String strCreateString = null;
        ArrayList arrayListCreateTypedList = null;
        Integer integerObject = null;
        TokenBinding tokenBinding = null;
        String strCreateString2 = null;
        AuthenticationExtensions authenticationExtensions = null;
        Long longObject = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 3:
                    doubleObject = SafeParcelReader.readDoubleObject(parcel, header);
                    break;
                case 4:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, PublicKeyCredentialDescriptor.CREATOR);
                    break;
                case 6:
                    integerObject = SafeParcelReader.readIntegerObject(parcel, header);
                    break;
                case 7:
                    tokenBinding = (TokenBinding) SafeParcelReader.createParcelable(parcel, header, TokenBinding.CREATOR);
                    break;
                case 8:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 9:
                    authenticationExtensions = (AuthenticationExtensions) SafeParcelReader.createParcelable(parcel, header, AuthenticationExtensions.CREATOR);
                    break;
                case 10:
                    longObject = SafeParcelReader.readLongObject(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PublicKeyCredentialRequestOptions(bArrCreateByteArray, doubleObject, strCreateString, arrayListCreateTypedList, integerObject, tokenBinding, strCreateString2, authenticationExtensions, longObject);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PublicKeyCredentialRequestOptions[i];
    }
}
