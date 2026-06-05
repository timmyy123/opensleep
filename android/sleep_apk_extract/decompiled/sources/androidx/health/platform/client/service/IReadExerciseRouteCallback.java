package androidx.health.platform.client.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.response.ReadExerciseRouteResponse;

/* JADX INFO: loaded from: classes.dex */
public interface IReadExerciseRouteCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.service.IReadExerciseRouteCallback";

    public static class Default implements IReadExerciseRouteCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.health.platform.client.service.IReadExerciseRouteCallback
        public void onError(ErrorStatus errorStatus) {
        }

        @Override // androidx.health.platform.client.service.IReadExerciseRouteCallback
        public void onSuccess(ReadExerciseRouteResponse readExerciseRouteResponse) {
        }
    }

    public static abstract class Stub extends Binder implements IReadExerciseRouteCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IReadExerciseRouteCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IReadExerciseRouteCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.service.IReadExerciseRouteCallback
            public void onError(ErrorStatus errorStatus) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IReadExerciseRouteCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, errorStatus, 0);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IReadExerciseRouteCallback
            public void onSuccess(ReadExerciseRouteResponse readExerciseRouteResponse) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IReadExerciseRouteCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, readExerciseRouteResponse, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IReadExerciseRouteCallback.DESCRIPTOR);
        }

        public static IReadExerciseRouteCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IReadExerciseRouteCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IReadExerciseRouteCallback)) ? new Proxy(iBinder) : (IReadExerciseRouteCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IReadExerciseRouteCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IReadExerciseRouteCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess((ReadExerciseRouteResponse) _Parcel.readTypedObject(parcel, ReadExerciseRouteResponse.CREATOR));
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                onError((ErrorStatus) _Parcel.readTypedObject(parcel, ErrorStatus.CREATOR));
            }
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
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

    void onError(ErrorStatus errorStatus);

    void onSuccess(ReadExerciseRouteResponse readExerciseRouteResponse);
}
