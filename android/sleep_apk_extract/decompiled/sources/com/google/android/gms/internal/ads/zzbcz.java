package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbcz extends zzbdf {
    private final zzbbz zzh;
    private long zzi;

    public zzbcz(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2, zzbbz zzbbzVar) {
        super(zzbbsVar, "CX4J+2yEJ2HtJzNjBSAFoPZxV3S124qFqsrwrEik3kHdsHRX3oIIB4d/zi0EQ0fu", "gfLiyhD2OvLSOj6bwf+kcmK11rwQ90aeBshxHD6xXgk=", zzaxmVar, i, 53);
        this.zzh = zzbbzVar;
        if (zzbbzVar != null) {
            this.zzi = zzbbzVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza() {
        if (this.zzh != null) {
            this.zzd.zzH(((Long) this.zze.invoke(null, Long.valueOf(this.zzi))).longValue());
        }
    }
}
