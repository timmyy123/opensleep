package com.samsung.android.sdk.healthdata;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl;
import com.samsung.android.sdk.internal.healthdata.DeleteRequestImpl;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;
import com.samsung.android.sdk.internal.healthdata.InsertRequestImpl;
import com.samsung.android.sdk.internal.healthdata.ReadRequestImpl;

/* JADX INFO: loaded from: classes4.dex */
public interface IDataResolver extends IInterface {

    public static abstract class Stub extends Binder implements IDataResolver {

        public static class a implements IDataResolver {
            private IBinder a;

            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public final void aggregateData2(String str, HealthResultReceiver healthResultReceiver, AggregateRequestImpl aggregateRequestImpl) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (aggregateRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        aggregateRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public final void deleteData2(String str, HealthResultReceiver healthResultReceiver, DeleteRequestImpl deleteRequestImpl) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (deleteRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        deleteRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public final void insertData2(String str, HealthResultReceiver healthResultReceiver, InsertRequestImpl insertRequestImpl) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (insertRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        insertRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public final void readData2(String str, HealthResultReceiver healthResultReceiver, ReadRequestImpl readRequestImpl) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (readRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        readRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public static IDataResolver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.healthdata.IDataResolver");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDataResolver)) ? new a(iBinder) : (IDataResolver) iInterfaceQueryLocalInterface;
        }
    }

    void aggregateData2(String str, HealthResultReceiver healthResultReceiver, AggregateRequestImpl aggregateRequestImpl);

    void deleteData2(String str, HealthResultReceiver healthResultReceiver, DeleteRequestImpl deleteRequestImpl);

    void insertData2(String str, HealthResultReceiver healthResultReceiver, InsertRequestImpl insertRequestImpl);

    void readData2(String str, HealthResultReceiver healthResultReceiver, ReadRequestImpl readRequestImpl);
}
