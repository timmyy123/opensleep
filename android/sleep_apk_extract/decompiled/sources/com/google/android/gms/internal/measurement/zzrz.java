package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.collect.ImmutableList;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
public final class zzrz {
    private final String zza;
    private String zzb = "files";
    private String zzc = "common";
    private final Account zzd = zzsa.zza;
    private String zze = "";
    private final ImmutableList.Builder zzf = ImmutableList.builder();

    public /* synthetic */ zzrz(Context context, byte[] bArr) {
        zzsq.zza(context != null, "Context cannot be null", new Object[0]);
        this.zza = context.getPackageName();
    }

    public final zzrz zza() {
        zzsa.zzb("directboot-files");
        this.zzb = "directboot-files";
        return this;
    }

    public final zzrz zzb(String str) {
        zzsa.zzc(str);
        this.zzc = str;
        return this;
    }

    public final zzrz zzc(String str) {
        if (str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            str = str.substring(1);
        }
        Account account = zzsa.zza;
        this.zze = str;
        return this;
    }

    public final Uri zzd() {
        String strM;
        String str = this.zzb;
        String str2 = this.zzc;
        Account account = zzrv.zza;
        Account account2 = this.zzd;
        zzsq.zza(account2.type.indexOf(58) == -1, "Account type contains ':'.", new Object[0]);
        zzsq.zza(account2.type.indexOf(47) == -1, "Account type contains '/'.", new Object[0]);
        zzsq.zza(account2.name.indexOf(47) == -1, "Account name contains '/'.", new Object[0]);
        if (zzrv.zza.equals(account2)) {
            strM = "shared";
        } else {
            String str3 = account2.type;
            String str4 = account2.name;
            strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(zzba$$ExternalSyntheticOutline0.m(1, str3) + String.valueOf(str4).length()), str3, ":", str4);
        }
        String str5 = this.zze;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(String.valueOf(str).length() + 2, 1, String.valueOf(str2)), 1, strM) + String.valueOf(str5).length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, MqttTopic.TOPIC_LEVEL_SEPARATOR, str, MqttTopic.TOPIC_LEVEL_SEPARATOR, str2);
        return new Uri.Builder().scheme("android").authority(this.zza).path(Fragment$$ExternalSyntheticOutline1.m(sb, MqttTopic.TOPIC_LEVEL_SEPARATOR, strM, MqttTopic.TOPIC_LEVEL_SEPARATOR, str5)).encodedFragment(zzsp.zzb(this.zzf.build())).build();
    }
}
