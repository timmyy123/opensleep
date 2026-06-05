package com.google.android.gms.home.matter.commissioning;

import android.content.ComponentName;
import com.google.android.gms.home.matter.commissioning.CommissioningRequest;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zza implements CommissioningRequest.Builder {
    private DeviceInfo zza;
    private String zzb;
    private String zzc;
    private ComponentName zzd;
    private boolean zze;
    private boolean zzf;
    private byte zzg;

    @Override // com.google.android.gms.home.matter.commissioning.CommissioningRequest.Builder
    public final CommissioningRequest build() {
        if (this.zzg == 3) {
            return new CommissioningRequest(null, null, this.zza, this.zzb, this.zzc, this.zzd, this.zze, null, this.zzf);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzg & 1) == 0) {
            sb.append(" storeToGoogleFabric");
        }
        if ((this.zzg & 2) == 0) {
            sb.append(" shareDeviceFlow");
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Missing required properties:".concat(sb.toString()));
        return null;
    }

    @Override // com.google.android.gms.home.matter.commissioning.CommissioningRequest.Builder
    public final CommissioningRequest.Builder setDeviceNameHint(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.home.matter.commissioning.CommissioningRequest.Builder
    public final CommissioningRequest.Builder setShareDeviceFlow(boolean z) {
        this.zzf = z;
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    public final CommissioningRequest.Builder setStoreToGoogleFabric(boolean z) {
        this.zze = z;
        this.zzg = (byte) (this.zzg | 1);
        return this;
    }
}
