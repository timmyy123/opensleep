package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzak implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = null;
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = null;
        byte[] bArrCreateByteArray = null;
        ArrayList arrayListCreateTypedList = null;
        Double doubleObject = null;
        ArrayList arrayListCreateTypedList2 = null;
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = null;
        Integer integerObject = null;
        TokenBinding tokenBinding = null;
        String strCreateString = null;
        AuthenticationExtensions authenticationExtensions = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    publicKeyCredentialRpEntity = (PublicKeyCredentialRpEntity) SafeParcelReader.createParcelable(parcel, header, PublicKeyCredentialRpEntity.CREATOR);
                    break;
                case 3:
                    publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) SafeParcelReader.createParcelable(parcel, header, PublicKeyCredentialUserEntity.CREATOR);
                    break;
                case 4:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 5:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, PublicKeyCredentialParameters.CREATOR);
                    break;
                case 6:
                    doubleObject = SafeParcelReader.readDoubleObject(parcel, header);
                    break;
                case 7:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, PublicKeyCredentialDescriptor.CREATOR);
                    break;
                case 8:
                    authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) SafeParcelReader.createParcelable(parcel, header, AuthenticatorSelectionCriteria.CREATOR);
                    break;
                case 9:
                    integerObject = SafeParcelReader.readIntegerObject(parcel, header);
                    break;
                case 10:
                    tokenBinding = (TokenBinding) SafeParcelReader.createParcelable(parcel, header, TokenBinding.CREATOR);
                    break;
                case 11:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 12:
                    authenticationExtensions = (AuthenticationExtensions) SafeParcelReader.createParcelable(parcel, header, AuthenticationExtensions.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PublicKeyCredentialCreationOptions(publicKeyCredentialRpEntity, publicKeyCredentialUserEntity, bArrCreateByteArray, arrayListCreateTypedList, doubleObject, arrayListCreateTypedList2, authenticatorSelectionCriteria, integerObject, tokenBinding, strCreateString, authenticationExtensions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PublicKeyCredentialCreationOptions[i];
    }
}
