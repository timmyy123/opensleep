package com.garmin.android.connectiq;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class IQMessage implements Parcelable {
    public static final Parcelable.Creator<IQMessage> CREATOR = new Parcelable.Creator<IQMessage>() { // from class: com.garmin.android.connectiq.IQMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IQMessage createFromParcel(Parcel parcel) {
            return new IQMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IQMessage[] newArray(int i) {
            return new IQMessage[i];
        }
    };
    public byte[] messageData;
    public String notificationAction;
    public String notificationPackage;

    public IQMessage(Parcel parcel) {
        if (parcel.readInt() > 0) {
            this.messageData = parcel.createByteArray();
        }
        this.notificationPackage = parcel.readString();
        this.notificationAction = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        byte[] bArr = this.messageData;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.messageData);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.notificationPackage);
        parcel.writeString(this.notificationAction);
    }

    public IQMessage(byte[] bArr, String str, String str2) {
        byte[] bArr2 = new byte[bArr.length];
        this.messageData = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.notificationPackage = str;
        this.notificationAction = str2;
    }
}
