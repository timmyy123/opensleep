package com.google.android.gms.home.matter;

import android.content.Context;
import com.google.android.gms.home.matter.commissioning.CommissioningClient;
import com.google.android.gms.home.matter.discovery.DiscoveryClient;
import com.google.android.gms.internal.serialization.zzbx;
import com.google.android.gms.internal.serialization.zzcl;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Matter {
    public static CommissioningClient getCommissioningClient(Context context) {
        return new zzbx(context);
    }

    public static DiscoveryClient getDiscoveryClient(Context context) {
        return new zzcl(context);
    }
}
