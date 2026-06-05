package com.garmin.android.connectiq;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class IQApp implements Parcelable {
    public static final Parcelable.Creator<IQApp> CREATOR = new Parcelable.Creator<IQApp>() { // from class: com.garmin.android.connectiq.IQApp.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IQApp createFromParcel(Parcel parcel) {
            return new IQApp(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IQApp[] newArray(int i) {
            return new IQApp[i];
        }
    };
    private String applicationID;
    private String displayName;
    private IQAppStatus status;
    private int version;

    public enum IQAppStatus {
        UNKNOWN,
        INSTALLED,
        NOT_INSTALLED,
        NOT_SUPPORTED
    }

    public IQApp(Parcel parcel) {
        this.version = parcel.readInt();
        try {
            this.status = IQAppStatus.values()[parcel.readInt()];
        } catch (IndexOutOfBoundsException unused) {
            this.status = IQAppStatus.UNKNOWN;
        }
        this.applicationID = parcel.readString();
        this.displayName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApplicationId() {
        return this.applicationID;
    }

    public String toString() {
        return this.displayName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.version);
        parcel.writeInt(this.status.ordinal());
        parcel.writeString(this.applicationID);
        parcel.writeString(this.displayName);
    }

    public IQApp(String str, String str2, int i) {
        this(str.toUpperCase().replaceAll("[\\s\\-]", ""), IQAppStatus.UNKNOWN, str2, i);
    }

    public IQApp(String str, IQAppStatus iQAppStatus, String str2, int i) {
        this.applicationID = str.toUpperCase().replaceAll("[\\s\\-]", "");
        this.status = iQAppStatus;
        this.displayName = str2;
        this.version = i;
    }

    public IQApp(String str, int i) {
        this(str.toUpperCase().replaceAll("[\\s\\-]", ""), IQAppStatus.INSTALLED, "", i);
    }

    public IQApp(String str) {
        this.applicationID = str.toUpperCase().replaceAll("[\\s\\-]", "");
        this.status = IQAppStatus.UNKNOWN;
        this.displayName = "";
        this.version = 0;
    }
}
