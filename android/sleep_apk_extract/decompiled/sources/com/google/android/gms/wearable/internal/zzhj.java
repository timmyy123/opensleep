package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.MessageClient;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhj extends MessageClient {
    public zzhj(Context context, GoogleApi.Settings settings) {
        super(context, settings);
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Integer> sendMessage(final String str, final String str2, final byte[] bArr) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzhh
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zzhj zzhjVar = this.zza;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                try {
                    ((zzkf) obj).zzq(new zzha(zzhjVar, taskCompletionSource), str, str2, bArr);
                } catch (RemoteException e) {
                    taskCompletionSource.setException(e);
                }
            }
        }).setMethodKey(24020).setFeatures(com.google.android.gms.wearable.zzn.zzx).build());
    }
}
