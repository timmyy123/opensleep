package com.google.android.gms.nearby;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.nearby.zzdq;
import com.google.android.gms.internal.nearby.zzer;
import com.google.android.gms.internal.nearby.zzo;
import com.google.android.gms.internal.nearby.zzoz;
import com.google.android.gms.internal.nearby.zzr;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzbx;
import com.google.android.gms.nearby.messages.internal.zzby;
import com.google.android.gms.nearby.messages.zzc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Nearby {

    @Deprecated
    public static final Api<ConnectionsOptions> CONNECTIONS_API = new Api<>("Nearby.CONNECTIONS_API", zzer.zzb, zzer.zza);

    @Deprecated
    public static final Connections Connections = new zzer();

    @Deprecated
    public static final Api<MessagesOptions> MESSAGES_API = new Api<>("Nearby.MESSAGES_API", zzbx.zzc, zzbx.zzb);

    @Deprecated
    public static final Messages Messages = zzbx.zza;
    public static final zzc zza = new zzby();

    @Deprecated
    public static final Api zzb = new Api("Nearby.BOOTSTRAP_API", zzr.zzb, zzr.zza);

    @Deprecated
    public static final zzo zzc = new zzr();

    public static final ConnectionsClient getConnectionsClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return zzdq.zzb(context, null);
    }

    public static boolean zza(Context context) {
        if (Wrappers.packageManager(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            return zzoz.zza(context.getContentResolver(), "gms:nearby:requires_gms_check", true);
        }
        return true;
    }
}
