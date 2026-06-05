package com.facebook.ads.redexgen.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.process.ProcessUtils;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class V4 implements AudienceNetworkRemoteServiceApi {
    public static String[] A04 = {"voPBjj5brgSJE0IwRb75go3GzJcvnTMA", "J1wnFcZJgSUrGWuJYgcC3S3AnUnV6DaW", "llX9DPYlWB8oU74zVWsUN0HTEWFOB3Un", "5Y7GwnMqNmRtmsztlHJac4MePUqBHcfA", "yIKXCcKqK5XToLwp", "ch8UU9t", "aylfh5n3ojaiLa86", "37SxUjf9oUYNOIJ9CYsuuXmfZZqWhF1X"};
    public Messenger A00;
    public AudienceNetworkRemoteServiceApi.MessageHandler A01;
    public AudienceNetworkRemoteServiceApi.PackageVerifier A02;
    public final Service A03;

    public V4(Service service) {
        this.A03 = service;
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi
    public final IBinder onBind(Intent intent) {
        if (this.A00 != null) {
            return this.A00.getBinder();
        }
        String[] strArr = A04;
        if (strArr[1].charAt(25) != strArr[3].charAt(25)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[1] = "O6YEFSdI74rZHmUftXmRNGVlzUJePZUI";
        strArr2[3] = "gwoVm4uiBtJW0ezJGOCNGmmGAUT6CAuw";
        return null;
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi
    public final void onCreate() {
        ProcessUtils.setRemoteRenderingProcess(true);
        DynamicLoaderFactory.makeLoader(this.A03).getInitApi().initialize(this.A03, null, null, 2);
        this.A00 = new Messenger(new V5(this.A03.getApplicationContext(), this.A01, this.A02));
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi
    public final void onDestroy() {
        X9.A00().A06();
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi
    public final void setMessageHandler(AudienceNetworkRemoteServiceApi.MessageHandler messageHandler) {
        this.A01 = messageHandler;
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi
    public final void setPackageVerifier(AudienceNetworkRemoteServiceApi.PackageVerifier packageVerifier) {
        this.A02 = packageVerifier;
    }
}
