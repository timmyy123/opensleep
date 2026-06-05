package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.common.collect.ImmutableList;
import java.io.File;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsb {
    private final Uri.Builder zza = new Uri.Builder().scheme(ShareInternalUtility.STAGING_PARAM).authority("").path(MqttTopic.TOPIC_LEVEL_SEPARATOR);
    private final ImmutableList.Builder zzb = ImmutableList.builder();

    public /* synthetic */ zzsb(byte[] bArr) {
    }

    public final zzsb zza(File file) {
        this.zza.path(file.getAbsolutePath());
        return this;
    }

    public final Uri zzb() {
        return this.zza.encodedFragment(zzsp.zzb(this.zzb.build())).build();
    }
}
