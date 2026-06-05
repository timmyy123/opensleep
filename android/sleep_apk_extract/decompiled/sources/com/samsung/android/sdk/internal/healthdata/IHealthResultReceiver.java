package com.samsung.android.sdk.internal.healthdata;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public interface IHealthResultReceiver extends IInterface {

    public static abstract class Stub extends Binder implements IHealthResultReceiver {

        public static class a implements IHealthResultReceiver {
            private IBinder a;

            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver");
        }

        public static IHealthResultReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IHealthResultReceiver)) ? new a(iBinder) : (IHealthResultReceiver) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver");
                send(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver");
            return true;
        }
    }

    void send(int i, Bundle bundle);
}
