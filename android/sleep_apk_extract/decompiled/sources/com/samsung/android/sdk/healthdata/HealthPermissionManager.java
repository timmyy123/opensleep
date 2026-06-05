package com.samsung.android.sdk.healthdata;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;
import com.samsung.android.sdk.internal.healthdata.IpcUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class HealthPermissionManager {
    private final HealthDataStore a;

    public static class PermissionKey {
        private final String a;
        private final PermissionType b;

        public PermissionKey(String str, PermissionType permissionType) {
            this.a = str;
            this.b = permissionType;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj != null && (obj instanceof PermissionKey)) {
                PermissionKey permissionKey = (PermissionKey) obj;
                String str2 = this.a;
                if (str2 != null && (str = permissionKey.a) != null && str2.equals(str) && this.b.getValue() == permissionKey.b.getValue()) {
                    return true;
                }
            }
            return false;
        }

        public String getDataType() {
            return this.a;
        }

        public PermissionType getPermissionType() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return this.b.getValue() + (str.hashCode() / 31);
        }
    }

    public enum PermissionType {
        READ(0),
        WRITE(1);

        private final int a;

        PermissionType(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public HealthPermissionManager(HealthDataStore healthDataStore) {
        this.a = healthDataStore;
    }

    private static Bundle a(Set<PermissionKey> set) {
        HashMap map = new HashMap();
        for (PermissionKey permissionKey : set) {
            String dataType = permissionKey.getDataType();
            if (dataType == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("The input argument includes null as a dataType of PermissionKey");
                return null;
            }
            ArrayList arrayList = (ArrayList) map.get(dataType);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(dataType, arrayList);
            }
            arrayList.add(Integer.valueOf(permissionKey.getPermissionType().getValue()));
        }
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            ArrayList arrayList2 = (ArrayList) entry.getValue();
            int[] iArr = new int[arrayList2.size()];
            Iterator it = arrayList2.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = ((Integer) it.next()).intValue();
                i++;
            }
            bundle.putIntArray((String) entry.getKey(), iArr);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<PermissionKey, Boolean> b(Bundle bundle) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            int[] intArray = bundle.getIntArray(str);
            if (intArray != null) {
                for (PermissionType permissionType : PermissionType.values()) {
                    int i = intArray[permissionType.getValue()];
                    if (i == 0) {
                        map.put(new PermissionKey(str, permissionType), Boolean.FALSE);
                    } else if (i == 1) {
                        map.put(new PermissionKey(str, permissionType), Boolean.TRUE);
                    }
                }
            }
        }
        return map;
    }

    public Map<PermissionKey, Boolean> isPermissionAcquired(Set<PermissionKey> set) {
        if (set == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The input argument is null");
            return null;
        }
        if (set.isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The input argument has no items");
            return null;
        }
        IHealth iHealth = HealthDataStore.getInterface(this.a);
        Bundle bundleA = a(set);
        try {
            Log.d("Health.Permission", "Checking the health data permissions are acquired...");
            Bundle bundleIsHealthDataPermissionAcquired2 = iHealth.isHealthDataPermissionAcquired2(this.a.a().getPackageName(), bundleA);
            if (bundleIsHealthDataPermissionAcquired2 != null) {
                return b(bundleIsHealthDataPermissionAcquired2);
            }
            throw new IllegalStateException("Binder error occurs during getting the result");
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e));
            return null;
        }
    }

    public HealthResultHolder<PermissionResult> requestPermissions(Set<PermissionKey> set, Activity activity) {
        if (set == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The input argument is null");
            return null;
        }
        if (set.isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The input argument has no items");
            return null;
        }
        IHealth iHealth = HealthDataStore.getInterface(this.a);
        Bundle bundleA = a(set);
        Log.d("Health.Permission", "Trying to acquire the health data permissions...");
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<PermissionResult> asyncResultHolder = IpcUtil.getAsyncResultHolder(forwardAsync, Looper.myLooper());
            Intent intentRequestHealthDataPermissions2 = iHealth.requestHealthDataPermissions2(this.a.a().getPackageName(), forwardAsync, bundleA);
            if (intentRequestHealthDataPermissions2 != null) {
                if (activity != null) {
                    try {
                        activity.startActivity(intentRequestHealthDataPermissions2);
                        return asyncResultHolder;
                    } catch (ActivityNotFoundException e) {
                        throw e;
                    } catch (Exception unused) {
                        throw new IllegalArgumentException("Invalid instance of Activity");
                    }
                }
                Context contextA = this.a.a();
                if (!(contextA instanceof Activity)) {
                    intentRequestHealthDataPermissions2.addFlags(ClientDefaults.MAX_MSG_SIZE);
                }
                contextA.startActivity(intentRequestHealthDataPermissions2);
            }
            return asyncResultHolder;
        } catch (RemoteException e2) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e2));
            return null;
        }
    }

    public static class PermissionResult extends HealthResultHolder.BaseResult implements Parcelable {
        public static final Parcelable.Creator<PermissionResult> CREATOR = new Parcelable.Creator<PermissionResult>() { // from class: com.samsung.android.sdk.healthdata.HealthPermissionManager.PermissionResult.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PermissionResult createFromParcel(Parcel parcel) {
                return new PermissionResult(parcel, (byte) 0);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PermissionResult[] newArray(int i) {
                return new PermissionResult[i];
            }
        };
        private final Bundle a;

        private PermissionResult(Parcel parcel) {
            super(parcel);
            this.a = parcel.readBundle();
        }

        @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Map<PermissionKey, Boolean> getResultMap() {
            return HealthPermissionManager.b(this.a);
        }

        @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.a);
        }

        public PermissionResult(Bundle bundle, int i) {
            super(1, i);
            this.a = bundle;
        }

        public /* synthetic */ PermissionResult(Parcel parcel, byte b) {
            this(parcel);
        }
    }
}
