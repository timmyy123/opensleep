package com.google.android.gms.nearby.connection;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionInfo {
    private final String zza;
    private final String zzb;
    private final byte[] zzc;
    private final boolean zzd;
    private final boolean zze;
    private final byte[] zzf;
    private final int zzg;

    private ConnectionInfo(String str, String str2, byte[] bArr, boolean z, boolean z2, byte[] bArr2, int i) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = z;
        this.zze = z2;
        this.zzf = bArr2;
        this.zzg = i;
    }

    public String getEndpointName() {
        return this.zza;
    }

    public boolean isIncomingConnection() {
        return this.zzd;
    }
}
