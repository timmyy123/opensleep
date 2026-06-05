package com.google.android.gms.internal.ads;

import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgai extends zzfzw {
    private zzgub<Integer> zza;
    private zzgub<Integer> zzb;
    private zzfzy zzc;
    private HttpURLConnection zzd;

    public zzgai(zzgub<Integer> zzgubVar, zzgub<Integer> zzgubVar2, zzfzy zzfzyVar) {
        this.zza = zzgubVar;
        this.zzb = zzgubVar2;
        this.zzc = zzfzyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzA() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzB() {
        return -1;
    }

    public static void zzi(HttpURLConnection httpURLConnection) {
        zzfzx.zzb();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzi(this.zzd);
    }

    public HttpURLConnection zzh(zzfzy zzfzyVar, final int i, final int i2) {
        this.zza = new zzgub() { // from class: com.google.android.gms.internal.ads.zzgaf
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzgub() { // from class: com.google.android.gms.internal.ads.zzgag
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = zzfzyVar;
        return zzj();
    }

    public HttpURLConnection zzj() {
        zzfzx.zza(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfzy zzfzyVar = this.zzc;
        zzfzyVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfzyVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public zzgai() {
        this(zzgah.zza, zzfzz.zza, null);
    }
}
