package io.rebble.pebblekit2.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import io.rebble.pebblekit2.common.SendDataCallback;

/* JADX INFO: loaded from: classes5.dex */
public interface UniversalRequestResponse extends IInterface {

    public static abstract class Stub extends Binder implements UniversalRequestResponse {

        public static class Proxy implements UniversalRequestResponse {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // io.rebble.pebblekit2.common.UniversalRequestResponse
            public void request(Bundle bundle, SendDataCallback sendDataCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("io.rebble.pebblekit2.common.UniversalRequestResponse");
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(sendDataCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "io.rebble.pebblekit2.common.UniversalRequestResponse");
        }

        public static UniversalRequestResponse asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("io.rebble.pebblekit2.common.UniversalRequestResponse");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof UniversalRequestResponse)) ? new Proxy(iBinder) : (UniversalRequestResponse) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("io.rebble.pebblekit2.common.UniversalRequestResponse");
            }
            if (i == 1598968902) {
                parcel2.writeString("io.rebble.pebblekit2.common.UniversalRequestResponse");
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            Parcelable.Creator creator = Bundle.CREATOR;
            request((Bundle) _Parcel.m2344$$Nest$smreadTypedObject(parcel), SendDataCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: renamed from: -$$Nest$smreadTypedObject, reason: not valid java name */
        public static /* bridge */ /* synthetic */ Object m2344$$Nest$smreadTypedObject(Parcel parcel) {
            return readTypedObject(parcel, Bundle.CREATOR);
        }

        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

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

    void request(Bundle bundle, SendDataCallback sendDataCallback);
}
