package com.google.android.gms.home.wifipresence;

import com.google.android.gms.home.wifipresence.WifiFencingState;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zza implements WifiFencingState.Builder {
    private String zza;
    private int zzb;
    private int zzc;
    private Long zzd;
    private byte zze;

    @Override // com.google.android.gms.home.wifipresence.WifiFencingState.Builder
    public final WifiFencingState build() {
        if (this.zze == 3) {
            return new WifiFencingState(this.zza, this.zzb, this.zzc, this.zzd);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zze & 1) == 0) {
            sb.append(" wifiSecurityType");
        }
        if ((this.zze & 2) == 0) {
            sb.append(" connectivityState");
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Missing required properties:".concat(sb.toString()));
        return null;
    }

    @Override // com.google.android.gms.home.wifipresence.WifiFencingState.Builder
    public final WifiFencingState.Builder setConnectivityState(int i) {
        this.zzc = i;
        this.zze = (byte) (this.zze | 2);
        return this;
    }

    @Override // com.google.android.gms.home.wifipresence.WifiFencingState.Builder
    public final WifiFencingState.Builder setWifiSecurityType(int i) {
        this.zzb = i;
        this.zze = (byte) (this.zze | 1);
        return this;
    }
}
