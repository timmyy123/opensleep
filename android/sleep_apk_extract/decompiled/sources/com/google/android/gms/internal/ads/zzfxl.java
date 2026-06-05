package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzfxl extends zzfxi {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final long zze;

    public /* synthetic */ zzfxl(String str, boolean z, boolean z2, boolean z3, long j, boolean z4, long j2, byte[] bArr) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = j;
        this.zze = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfxi) {
            zzfxi zzfxiVar = (zzfxi) obj;
            if (this.zza.equals(zzfxiVar.zza()) && this.zzb == zzfxiVar.zzb() && this.zzc == zzfxiVar.zzc()) {
                zzfxiVar.zzd();
                if (this.zzd == zzfxiVar.zze()) {
                    zzfxiVar.zzf();
                    if (this.zze == zzfxiVar.zzg()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((int) this.zze) ^ ((((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zzd)) * 1000003) ^ 1237) * 1000003);
    }

    public final String toString() {
        boolean z = this.zzb;
        int length = String.valueOf(z).length();
        boolean z2 = this.zzc;
        int length2 = String.valueOf(z2).length();
        long j = this.zzd;
        int length3 = String.valueOf(j).length();
        long j2 = this.zze;
        int length4 = String.valueOf(j2).length();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + 56 + length + 32 + length2 + 57 + length3 + 61 + length4 + 1);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append(", enableQuerySignalsTimeout=false, querySignalsTimeoutMs=");
        sb.append(j);
        sb.append(", enableQuerySignalsCache=false, querySignalsCacheTtlSeconds=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final boolean zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final boolean zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final long zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final long zzg() {
        return this.zze;
    }
}
