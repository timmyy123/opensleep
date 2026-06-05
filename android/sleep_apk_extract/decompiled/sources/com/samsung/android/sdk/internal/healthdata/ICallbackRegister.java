package com.samsung.android.sdk.internal.healthdata;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver;

/* JADX INFO: loaded from: classes4.dex */
public interface ICallbackRegister extends IInterface {

    public static abstract class Stub extends Binder implements ICallbackRegister {

        public static class a implements ICallbackRegister {
            private IBinder a;

            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.sdk.internal.healthdata.ICallbackRegister
            public final void setCallback(int i, IHealthResultReceiver iHealthResultReceiver) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iHealthResultReceiver != null ? iHealthResultReceiver.asBinder() : null);
                    this.a.transact(1, parcelObtain, null, 1);
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
        }

        public static ICallbackRegister asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICallbackRegister)) ? new a(iBinder) : (ICallbackRegister) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
                setCallback(parcel.readInt(), IHealthResultReceiver.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
                cancel(parcel.readInt());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
            return true;
        }
    }

    void cancel(int i);

    void setCallback(int i, IHealthResultReceiver iHealthResultReceiver);
}
