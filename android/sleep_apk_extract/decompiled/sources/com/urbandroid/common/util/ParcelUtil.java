package com.urbandroid.common.util;

import android.os.Parcel;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ParcelUtil {
    public static Date readNullableDate(Parcel parcel) {
        if (parcel.readByte() == 1) {
            return new Date(parcel.readLong());
        }
        return null;
    }

    public static void writeNullableDate(Parcel parcel, Date date) {
        parcel.writeByte(date != null ? (byte) 1 : (byte) 0);
        if (date != null) {
            parcel.writeLong(date.getTime());
        }
    }
}
