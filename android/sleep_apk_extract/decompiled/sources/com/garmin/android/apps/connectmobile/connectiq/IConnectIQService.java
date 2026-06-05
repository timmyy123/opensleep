package com.garmin.android.apps.connectmobile.connectiq;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.garmin.android.connectiq.IQApp;
import com.garmin.android.connectiq.IQDevice;
import com.garmin.android.connectiq.IQMessage;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IConnectIQService extends IInterface {

    public static abstract class Stub extends Binder implements IConnectIQService {

        public static class Proxy implements IConnectIQService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.garmin.android.apps.connectmobile.connectiq.IConnectIQService
            public void getApplicationInfo(String str, String str2, IQDevice iQDevice, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.garmin.android.apps.connectmobile.connectiq.IConnectIQService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedObject(parcelObtain, iQDevice, 0);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.garmin.android.apps.connectmobile.connectiq.IConnectIQService
            public List<IQDevice> getConnectedDevices() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.garmin.android.apps.connectmobile.connectiq.IConnectIQService");
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(IQDevice.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.garmin.android.apps.connectmobile.connectiq.IConnectIQService
            public int getStatus(IQDevice iQDevice) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.garmin.android.apps.connectmobile.connectiq.IConnectIQService");
                    _Parcel.writeTypedObject(parcelObtain, iQDevice, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.garmin.android.apps.connectmobile.connectiq.IConnectIQService
            public void registerApp(IQApp iQApp, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.garmin.android.apps.connectmobile.connectiq.IConnectIQService");
                    _Parcel.writeTypedObject(parcelObtain, iQApp, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(9, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.garmin.android.apps.connectmobile.connectiq.IConnectIQService
            public void sendMessage(IQMessage iQMessage, IQDevice iQDevice, IQApp iQApp) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.garmin.android.apps.connectmobile.connectiq.IConnectIQService");
                    _Parcel.writeTypedObject(parcelObtain, iQMessage, 0);
                    _Parcel.writeTypedObject(parcelObtain, iQDevice, 0);
                    _Parcel.writeTypedObject(parcelObtain, iQApp, 0);
                    this.mRemote.transact(7, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.garmin.android.apps.connectmobile.connectiq.IConnectIQService
            public void sendTransientMessage(IQMessage iQMessage, IQDevice iQDevice, IQApp iQApp) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.garmin.android.apps.connectmobile.connectiq.IConnectIQService");
                    _Parcel.writeTypedObject(parcelObtain, iQMessage, 0);
                    _Parcel.writeTypedObject(parcelObtain, iQDevice, 0);
                    _Parcel.writeTypedObject(parcelObtain, iQApp, 0);
                    this.mRemote.transact(10, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.garmin.android.apps.connectmobile.connectiq.IConnectIQService
            public void unregisterApp(IQApp iQApp, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.garmin.android.apps.connectmobile.connectiq.IConnectIQService");
                    _Parcel.writeTypedObject(parcelObtain, iQApp, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(13, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static IConnectIQService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.garmin.android.apps.connectmobile.connectiq.IConnectIQService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IConnectIQService)) ? new Proxy(iBinder) : (IConnectIQService) iInterfaceQueryLocalInterface;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void getApplicationInfo(String str, String str2, IQDevice iQDevice, String str3);

    List<IQDevice> getConnectedDevices();

    int getStatus(IQDevice iQDevice);

    void registerApp(IQApp iQApp, String str, String str2);

    void sendMessage(IQMessage iQMessage, IQDevice iQDevice, IQApp iQApp);

    void sendTransientMessage(IQMessage iQMessage, IQDevice iQDevice, IQApp iQApp);

    void unregisterApp(IQApp iQApp, String str);
}
