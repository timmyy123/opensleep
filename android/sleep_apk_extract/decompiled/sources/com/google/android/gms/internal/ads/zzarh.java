package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
public final class zzarh {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private String zze;

    public zzarh(int i, int i2, int i3) {
        this.zza = i != Integer.MIN_VALUE ? FileInsert$$ExternalSyntheticOutline0.m(i, MqttTopic.TOPIC_LEVEL_SEPARATOR, new StringBuilder(String.valueOf(i).length() + 1)) : "";
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = Integer.MIN_VALUE;
        this.zze = "";
    }

    private final void zzd() {
        if (this.zzd != Integer.MIN_VALUE) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("generateNewId() must be called before retrieving ids.");
    }

    public final void zza() {
        int i = this.zzd;
        int i2 = i == Integer.MIN_VALUE ? this.zzb : i + this.zzc;
        this.zzd = i2;
        String str = this.zza;
        this.zze = zzba$$ExternalSyntheticOutline0.m(i2, str, new StringBuilder(str.length() + String.valueOf(i2).length()));
    }

    public final int zzb() {
        zzd();
        return this.zzd;
    }

    public final String zzc() {
        zzd();
        return this.zze;
    }
}
