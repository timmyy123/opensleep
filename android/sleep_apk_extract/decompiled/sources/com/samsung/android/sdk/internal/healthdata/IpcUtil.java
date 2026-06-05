package com.samsung.android.sdk.internal.healthdata;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Looper;
import com.samsung.android.sdk.healthdata.HealthData;
import com.samsung.android.sdk.healthdata.HealthDataStore;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;
import java.io.DataOutputStream;
import java.io.IOException;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IpcUtil {
    public static <T extends HealthResultHolder.BaseResult> HealthResultHolder<T> getAsyncResultHolder(final HealthResultReceiver.ForwardAsync forwardAsync, Looper looper) {
        HealthResultHolder<T> healthResultHolder = new HealthResultHolderImpl<T>(looper) { // from class: com.samsung.android.sdk.internal.healthdata.IpcUtil.1
            @Override // com.samsung.android.sdk.internal.healthdata.HealthResultHolderImpl
            public final void cancelResult() {
                forwardAsync.cancel();
            }
        };
        forwardAsync.registerListener(healthResultHolder);
        return healthResultHolder;
    }

    public static void sendBlob(HealthData healthData, String str) throws Throwable {
        DataOutputStream dataOutputStream;
        byte[] bArr = (byte[]) healthData.get(str);
        if (bArr == null) {
            return;
        }
        LocalSocket localSocket = new LocalSocket();
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                String str2 = HealthDataStore.getPlatformPackageName() + ".BlobSocketServer";
                if (HealthDataStore.getMyUserId() != 0) {
                    str2 = str2 + "." + HealthDataStore.getMyUserId();
                }
                localSocket.connect(new LocalSocketAddress(str2));
                dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused) {
        }
        try {
            dataOutputStream.writeUTF(HealthDataStore.getSocketKey());
            dataOutputStream.writeUTF(new String(bArr, OAuth.ENCODING));
            byte[] blob = healthData.getBlob(str);
            if (blob != null) {
                dataOutputStream.writeInt(blob.length);
                dataOutputStream.write(blob);
            } else {
                dataOutputStream.writeInt(0);
            }
            dataOutputStream.flush();
            try {
                dataOutputStream.close();
            } catch (IOException unused2) {
            }
            try {
                localSocket.close();
            } catch (IOException unused3) {
            }
        } catch (IOException unused4) {
            throw new IllegalStateException("Blob data sending failure");
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            try {
                localSocket.close();
                throw th;
            } catch (IOException unused6) {
                throw th;
            }
        }
    }
}
