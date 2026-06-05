package com.garmin.android.apps.connectmobile.connectiq;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface ICompanionAppService extends IInterface {

    public static abstract class Stub extends Binder implements ICompanionAppService {
        public Stub() {
            attachInterface(this, "com.garmin.android.apps.connectmobile.connectiq.ICompanionAppService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.garmin.android.apps.connectmobile.connectiq.ICompanionAppService");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.garmin.android.apps.connectmobile.connectiq.ICompanionAppService");
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            String strTransferData = transferData(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strTransferData);
            return true;
        }
    }

    String transferData(String str);
}
