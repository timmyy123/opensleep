package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.connection.zzae;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzjm zzjmVar = null;
        zzjc zzjcVar = null;
        byte[] bArrCreateByteArray = null;
        ArrayList arrayListCreateTypedList = null;
        ArrayList arrayListCreateTypedList2 = null;
        ArrayList arrayListCreateTypedList3 = null;
        zzjo zzjoVar = null;
        zzjg zzjgVar = null;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    zzjmVar = (zzjm) SafeParcelReader.createParcelable(parcel, header, zzjm.CREATOR);
                    break;
                case 2:
                    zzjcVar = (zzjc) SafeParcelReader.createParcelable(parcel, header, zzjc.CREATOR);
                    break;
                case 3:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, com.google.android.gms.nearby.connection.zzg.CREATOR);
                    break;
                case 6:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, zzae.CREATOR);
                    break;
                case 7:
                    arrayListCreateTypedList3 = SafeParcelReader.createTypedList(parcel, header, com.google.android.gms.nearby.connection.zzi.CREATOR);
                    break;
                case 8:
                    zzjoVar = (zzjo) SafeParcelReader.createParcelable(parcel, header, zzjo.CREATOR);
                    break;
                case 9:
                    zzjgVar = (zzjg) SafeParcelReader.createParcelable(parcel, header, zzjg.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzje(zzjmVar, zzjcVar, bArrCreateByteArray, z, arrayListCreateTypedList, arrayListCreateTypedList2, arrayListCreateTypedList3, zzjoVar, zzjgVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzje[i];
    }
}
