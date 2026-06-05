package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.wearable.internal.zzau;
import com.google.android.gms.wearable.internal.zzdg;
import com.google.android.gms.wearable.internal.zzgz;
import com.google.android.gms.wearable.internal.zzhj;
import com.google.android.gms.wearable.internal.zzhq;
import com.google.android.gms.wearable.internal.zzhy;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Wearable {

    @Deprecated
    public static final Api<WearableOptions> API;
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;

    @Deprecated
    public static final DataApi DataApi = new zzdg();

    @Deprecated
    public static final CapabilityApi CapabilityApi = new com.google.android.gms.wearable.internal.zzah();

    @Deprecated
    public static final MessageApi MessageApi = new zzgz();

    @Deprecated
    public static final NodeApi NodeApi = new zzhq();

    @Deprecated
    public static final ChannelApi ChannelApi = new zzau();

    public static final class WearableOptions implements Api.ApiOptions {
        public static final WearableOptions zza = new WearableOptions(new Builder());
        private final Looper zzb;

        public static class Builder {
            private Looper zza;

            public final /* synthetic */ Looper zza() {
                return this.zza;
            }
        }

        private WearableOptions(Builder builder) {
            this.zzb = builder.zza();
        }

        public boolean equals(Object obj) {
            return obj instanceof WearableOptions;
        }

        public int hashCode() {
            return Objects.hashCode(WearableOptions.class);
        }
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzs zzsVar = new zzs();
        zzb = zzsVar;
        API = new Api<>("Wearable.API", zzsVar, clientKey);
    }

    public static MessageClient getMessageClient(Context context) {
        return new zzhj(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static NodeClient getNodeClient(Context context) {
        return new zzhy(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
