package com.google.android.gms.internal.aicore;

/* JADX INFO: loaded from: classes3.dex */
final class zzgj implements zzfx {
    private final zzga zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzgj(zzga zzgaVar, String str, Object[] objArr) {
        this.zza = zzgaVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i3);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.aicore.zzfx
    public final boolean zza() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.aicore.zzfx
    public final zzga zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.aicore.zzfx
    public final int zzc() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
