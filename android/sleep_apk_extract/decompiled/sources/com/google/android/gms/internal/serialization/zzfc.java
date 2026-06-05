package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
public class zzfc {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final long zze;

    private zzfc(String str, Class cls, boolean z, boolean z2) {
        zzhy.zzd(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        this.zzd = z2;
        int iIdentityHashCode = System.identityHashCode(this);
        long j = 0;
        for (int i = 0; i < 5; i++) {
            j |= 1 << (iIdentityHashCode & 63);
            iIdentityHashCode >>>= 6;
        }
        this.zze = j;
    }

    public static zzfc zzc(String str, Class cls) {
        return new zzfc(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        String name = getClass().getName();
        String name2 = cls.getName();
        int length = name.length();
        int length2 = name2.length();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + length + 1 + 1 + length2 + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, name, MqttTopic.TOPIC_LEVEL_SEPARATOR, str, "[");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, name2, "]");
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public zzfc(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }
}
