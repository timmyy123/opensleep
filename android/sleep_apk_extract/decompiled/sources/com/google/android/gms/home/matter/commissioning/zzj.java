package com.google.android.gms.home.matter.commissioning;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.home.matter.common.DeviceDescriptor;
import com.google.android.gms.home.matter.common.NetworkLocation;

/* JADX INFO: loaded from: classes3.dex */
public final class zzj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        CommissioningWindow commissioningWindow = null;
        DeviceDescriptor deviceDescriptor = null;
        String strCreateString = null;
        String strCreateString2 = null;
        NetworkLocation networkLocation = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                commissioningWindow = (CommissioningWindow) SafeParcelReader.createParcelable(parcel, header, CommissioningWindow.CREATOR);
            } else if (fieldId == 2) {
                deviceDescriptor = (DeviceDescriptor) SafeParcelReader.createParcelable(parcel, header, DeviceDescriptor.CREATOR);
            } else if (fieldId == 3) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 4) {
                strCreateString2 = SafeParcelReader.createString(parcel, header);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                networkLocation = (NetworkLocation) SafeParcelReader.createParcelable(parcel, header, NetworkLocation.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ShareDeviceRequest(commissioningWindow, deviceDescriptor, strCreateString, strCreateString2, networkLocation);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ShareDeviceRequest[i];
    }
}
