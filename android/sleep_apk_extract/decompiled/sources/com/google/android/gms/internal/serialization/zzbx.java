package com.google.android.gms.internal.serialization;

import android.content.Context;
import android.content.IntentSender;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.home.internal.zzb;
import com.google.android.gms.home.internal.zze;
import com.google.android.gms.home.matter.commissioning.CommissioningClient;
import com.google.android.gms.home.matter.commissioning.CommissioningRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbx extends GoogleApi implements CommissioningClient {
    private static final zze zzb = zze.zzc("InternalCommissioningClient", 338);
    private static final Api.ClientKey zzc;
    private static final Api.AbstractClientBuilder zzd;
    private static final Api zze;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzc = clientKey;
        zzbw zzbwVar = new zzbw();
        zzd = zzbwVar;
        zze = new Api("CommissioningClient.API", zzbwVar, clientKey);
    }

    public zzbx(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zze, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void zze(CommissioningRequest commissioningRequest, zzb zzbVar, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(((zze) zzbVar.getService()).zze(commissioningRequest));
        } catch (UnsupportedOperationException unused) {
            taskCompletionSource.setException(zzch.zzb());
        }
    }

    @Override // com.google.android.gms.home.matter.commissioning.CommissioningClient
    public final Task<IntentSender> commissionDevice(final CommissioningRequest commissioningRequest) {
        return !zzch.zza() ? Tasks.forException(zzch.zzb()) : doRead(TaskApiCall.builder().setFeatures(zzg.zzb).run(new RemoteCall() { // from class: com.google.android.gms.internal.home.zzca
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zzbx.zze(commissioningRequest, (zzb) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(31704).setAutoResolveMissingFeatures(false).build());
    }
}
