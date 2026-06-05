package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.internal.wearable.zzak;
import com.google.android.gms.internal.wearable.zzam;
import com.google.android.gms.wearable.MessageApi;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public final class zzkf extends GmsClient {
    private final ExecutorService zzf;
    private final zzgu zzg;
    private final zzgu zzh;
    private final zzgu zzi;
    private final zzgu zzj;
    private final zzgu zzk;
    private final zzgu zzl;
    private final zzgu zzm;
    private final zzgu zzn;
    private final zzgu zzo;
    private final zzgu zzp;
    private final zzkp zzq;
    private final zzak zzr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkf(final Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        super(context, looper, 14, clientSettings, connectionCallbacks, onConnectionFailedListener);
        ExecutorService executorServiceZza = com.google.android.gms.internal.wearable.zzp.zza().zza(2);
        zzkp zzkpVarZza = zzkp.zza(context);
        this.zzg = new zzgu();
        this.zzh = new zzgu();
        this.zzi = new zzgu();
        this.zzj = new zzgu();
        this.zzk = new zzgu();
        this.zzl = new zzgu();
        this.zzm = new zzgu();
        this.zzn = new zzgu();
        this.zzo = new zzgu();
        this.zzp = new zzgu();
        new zzgu();
        new zzgu();
        executorServiceZza.getClass();
        this.zzf = executorServiceZza;
        this.zzq = zzkpVarZza;
        this.zzr = zzam.zza(new zzak() { // from class: com.google.android.gms.wearable.internal.zzke
        });
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        if (!requiresGooglePlayServices()) {
            try {
                Bundle bundle = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
                int i = bundle != null ? bundle.getInt("com.google.android.wearable.api.version", 0) : 0;
                if (i < 8600000) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 71);
                    sb.append("The Wear OS app is out of date. Requires API version 8600000 but found ");
                    sb.append(i);
                    Log.w("WearableClient", sb.toString());
                    Context context = getContext();
                    Context context2 = getContext();
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    triggerNotAvailable(connectionProgressReportCallbacks, 6, com.google.android.gms.internal.wearable.zzl.zza(context, 0, intent, com.google.android.gms.internal.wearable.zzl.zza));
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                triggerNotAvailable(connectionProgressReportCallbacks, 16, null);
                return;
            }
        }
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        return iInterfaceQueryLocalInterface instanceof zzgq ? (zzgq) iInterfaceQueryLocalInterface : new zzgq(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.wearable.zzn.zzH;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 8600000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServicePackage() {
        return this.zzq.zzb() ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 30);
            sb.append("onPostInitHandler: statusCode ");
            sb.append(i);
            Log.v("WearableClient", sb.toString());
        }
        if (i == 0) {
            this.zzg.zza(iBinder);
            this.zzh.zza(iBinder);
            this.zzi.zza(iBinder);
            this.zzk.zza(iBinder);
            this.zzl.zza(iBinder);
            this.zzm.zza(iBinder);
            this.zzn.zza(iBinder);
            this.zzo.zza(iBinder);
            this.zzp.zza(iBinder);
            this.zzj.zza(iBinder);
            i = 0;
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return !this.zzq.zzb();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzD(BaseImplementation$ResultHolder baseImplementation$ResultHolder, MessageApi.MessageListener messageListener) {
        this.zzl.zzc(this, baseImplementation$ResultHolder, messageListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzq(BaseImplementation$ResultHolder baseImplementation$ResultHolder, String str, String str2, byte[] bArr) {
        ((zzgq) getService()).zzi(new zzjy(baseImplementation$ResultHolder), str, str2, bArr);
    }

    public final void zzy(BaseImplementation$ResultHolder baseImplementation$ResultHolder, MessageApi.MessageListener messageListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        this.zzl.zzb(this, baseImplementation$ResultHolder, messageListener, zzko.zzm(listenerHolder, intentFilterArr));
    }
}
