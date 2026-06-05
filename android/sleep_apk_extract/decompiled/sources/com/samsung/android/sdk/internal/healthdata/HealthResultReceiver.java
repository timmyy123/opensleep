package com.samsung.android.sdk.internal.healthdata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import com.samsung.android.sdk.healthdata.HealthPermissionManager;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.internal.healthdata.ICallbackRegister;
import com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HealthResultReceiver implements Parcelable {
    public static final Parcelable.Creator<HealthResultReceiver> CREATOR = new Parcelable.Creator<HealthResultReceiver>() { // from class: com.samsung.android.sdk.internal.healthdata.HealthResultReceiver.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HealthResultReceiver createFromParcel(Parcel parcel) {
            int iDataPosition = parcel.dataPosition();
            parcel.readInt();
            parcel.readStrongBinder();
            int i = parcel.readInt();
            parcel.setDataPosition(iDataPosition);
            byte b = 0;
            if (i == 0) {
                return new Async(parcel, b);
            }
            if (i == 1) {
                return new Sync(parcel, b);
            }
            if (i == 2) {
                return new ForwardAsync(parcel, b);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Invalid result parcel type : "));
            return null;
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HealthResultReceiver[] newArray(int i) {
            return new HealthResultReceiver[i];
        }
    };
    private final int a;

    private HealthResultReceiver(Parcel parcel) {
        this.a = parcel.readInt();
    }

    public static /* synthetic */ ClassLoader a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? HealthResultHolder.BaseResult.class.getClassLoader() : HealthPermissionManager.PermissionResult.class.getClassLoader() : HealthDataResolver.AggregateResult.class.getClassLoader() : HealthDataResolver.ReadResult.class.getClassLoader();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
    }

    public static class Async extends HealthResultReceiver {
        private RemoteResultListener a;
        private ICallbackRegister b;
        private IHealthResultReceiver c;
        private final int d;
        private final int e;
        private Intent f;

        /* JADX WARN: Illegal instructions before constructor call */
        private Async(Parcel parcel) {
            byte b2 = 0;
            super(parcel, b2);
            this.c = new b(this, b2);
            this.b = ICallbackRegister.Stub.asInterface(parcel.readStrongBinder());
            parcel.readInt();
            this.d = parcel.readInt();
            int i = parcel.readInt();
            this.e = i;
            parcel.readBundle(HealthResultReceiver.a(i));
            this.f = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            try {
                this.b.setCallback(0, this.c);
            } catch (RemoteException unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Bundle bundle) {
            if (this.a == null) {
                return;
            }
            bundle.setClassLoader(HealthPermissionManager.PermissionResult.class.getClassLoader());
            int i2 = bundle.getInt("type", -1);
            if (i2 == 1) {
                this.a.onReceiveHealthResult(i, (HealthDataResolver.ReadResult) bundle.getParcelable("parcel"));
            } else if (i2 == 2) {
                this.a.onReceiveHealthResult(i, (HealthDataResolver.AggregateResult) bundle.getParcelable("parcel"));
            } else if (i2 != 3) {
                this.a.onReceiveHealthResult(i, (HealthResultHolder.BaseResult) bundle.getParcelable("parcel"));
            } else {
                int i3 = bundle.getInt("PERMISSION_RESULT_COUNT");
                bundle.remove("PERMISSION_RESULT_COUNT");
                bundle.remove("type");
                this.a.onReceiveHealthResult(i, new HealthPermissionManager.PermissionResult(bundle, i3));
            }
            this.a = null;
        }

        public void onCancelResult(int i) {
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            synchronized (this) {
                try {
                    byte b2 = 0;
                    if (this.b == null) {
                        this.b = new a(this, b2);
                    }
                    parcel.writeStrongBinder(this.b.asBinder());
                } catch (Throwable th) {
                    throw th;
                }
            }
            parcel.writeInt(0);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeBundle(null);
            parcel.writeParcelable(this.f, 0);
        }

        public class a extends ICallbackRegister.Stub {
            private a() {
            }

            @Override // com.samsung.android.sdk.internal.healthdata.ICallbackRegister
            public final void cancel(int i) {
                Async.this.onCancelResult(i);
            }

            @Override // com.samsung.android.sdk.internal.healthdata.ICallbackRegister
            public final void setCallback(int i, IHealthResultReceiver iHealthResultReceiver) {
                Async.this.c = iHealthResultReceiver;
            }

            public /* synthetic */ a(Async async, byte b) {
                this();
            }
        }

        public class b extends IHealthResultReceiver.Stub {
            private b() {
            }

            @Override // com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver
            public final void send(int i, Bundle bundle) {
                Async.this.a(i, bundle);
            }

            public /* synthetic */ b(Async async, byte b) {
                this();
            }
        }

        public /* synthetic */ Async(Parcel parcel, byte b2) {
            this(parcel);
        }
    }

    public static class ForwardAsync extends HealthResultReceiver {
        private IHealthResultReceiver a;
        private RemoteResultListener b;
        private AtomicBoolean c;

        /* JADX WARN: Illegal instructions before constructor call */
        public ForwardAsync() {
            byte b = 0;
            super(b);
            this.a = new a(this, b);
            this.c = new AtomicBoolean(false);
        }

        public static /* synthetic */ void a(ForwardAsync forwardAsync, int i, Bundle bundle) {
            if (forwardAsync.c.get() || forwardAsync.b == null) {
                return;
            }
            bundle.setClassLoader(HealthPermissionManager.PermissionResult.class.getClassLoader());
            int i2 = bundle.getInt("type", -1);
            if (i2 == 1) {
                forwardAsync.b.onReceiveHealthResult(i, (HealthDataResolver.ReadResult) bundle.getParcelable("parcel"));
            } else if (i2 == 2) {
                forwardAsync.b.onReceiveHealthResult(i, (HealthDataResolver.AggregateResult) bundle.getParcelable("parcel"));
            } else if (i2 != 3) {
                forwardAsync.b.onReceiveHealthResult(i, (HealthResultHolder.BaseResult) bundle.getParcelable("parcel"));
            } else {
                int i3 = bundle.getInt("PERMISSION_RESULT_COUNT");
                bundle.remove("PERMISSION_RESULT_COUNT");
                bundle.remove("type");
                forwardAsync.b.onReceiveHealthResult(i, new HealthPermissionManager.PermissionResult(bundle, i3));
            }
            forwardAsync.b = null;
        }

        public void cancel() {
            this.c.set(true);
        }

        public <T extends HealthResultHolder.BaseResult> void registerListener(RemoteResultListener<T> remoteResultListener) {
            this.b = remoteResultListener;
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeStrongBinder(this.a.asBinder());
            parcel.writeInt(2);
        }

        public class a extends IHealthResultReceiver.Stub {
            private a() {
            }

            @Override // com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver
            public final void send(int i, Bundle bundle) {
                ForwardAsync.a(ForwardAsync.this, i, bundle);
            }

            public /* synthetic */ a(ForwardAsync forwardAsync, byte b) {
                this();
            }
        }

        public /* synthetic */ ForwardAsync(Parcel parcel, byte b) {
            this(parcel);
        }

        private ForwardAsync(Parcel parcel) {
            super(parcel, (byte) 0);
            this.a = IHealthResultReceiver.Stub.asInterface(parcel.readStrongBinder());
            parcel.readInt();
        }
    }

    public /* synthetic */ HealthResultReceiver(Parcel parcel, byte b) {
        this(parcel);
    }

    private HealthResultReceiver() {
        this.a = 0;
    }

    public /* synthetic */ HealthResultReceiver(byte b) {
        this();
    }

    public static class Sync extends HealthResultReceiver {
        private final int a;
        private final int b;
        private final Bundle c;

        private Sync(Parcel parcel) {
            super(parcel, (byte) 0);
            parcel.readStrongBinder();
            parcel.readInt();
            this.a = parcel.readInt();
            int i = parcel.readInt();
            this.b = i;
            this.c = parcel.readBundle(HealthResultReceiver.a(i));
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeStrongBinder(null);
            parcel.writeInt(1);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeBundle(this.c);
            parcel.writeParcelable(null, 0);
        }

        public /* synthetic */ Sync(Parcel parcel, byte b) {
            this(parcel);
        }
    }
}
