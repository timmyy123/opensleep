package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes3.dex */
public final class zzml implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzme zzmeVar = null;
        zzme zzmeVar2 = null;
        zzme zzmeVar3 = null;
        zzka zzkaVar = null;
        int i = -128;
        long j = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    zzmeVar = (zzme) SafeParcelReader.createParcelable(parcel, header, zzme.CREATOR);
                    break;
                case 2:
                    zzmeVar2 = (zzme) SafeParcelReader.createParcelable(parcel, header, zzme.CREATOR);
                    break;
                case 3:
                    zzmeVar3 = (zzme) SafeParcelReader.createParcelable(parcel, header, zzme.CREATOR);
                    break;
                case 4:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 5:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzkaVar = (zzka) SafeParcelReader.createParcelable(parcel, header, zzka.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzmk(zzmeVar, zzmeVar2, zzmeVar3, j, i, zzkaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzmk[i];
    }
}
