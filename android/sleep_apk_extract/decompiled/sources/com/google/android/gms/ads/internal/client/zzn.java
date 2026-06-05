package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzn {
    private Bundle zza = new Bundle();
    private List zzb = new ArrayList();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List zzg = new ArrayList();
    private int zzh = -1;
    private String zzi = null;
    private final List zzj = new ArrayList();
    private int zzk = 60000;
    private final int zzl = RequestConfiguration.PublisherPrivacyPersonalizationState.DEFAULT.getValue();
    private long zzm = 0;

    public final zzm zza() {
        Bundle bundle = this.zza;
        Bundle bundle2 = this.zze;
        List list = this.zzb;
        boolean z = this.zzc;
        int i = this.zzd;
        int i2 = this.zzh;
        String str = this.zzi;
        List list2 = this.zzj;
        int i3 = this.zzl;
        return new zzm(8, -1L, bundle, -1, list, z, i, false, null, null, null, null, bundle2, this.zzf, this.zzg, null, null, false, null, i2, str, list2, this.zzk, null, i3, this.zzm, 0L);
    }

    public final zzn zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzn zzc(List list) {
        this.zzb = list;
        return this;
    }

    public final zzn zzd(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzn zze(int i) {
        this.zzd = i;
        return this;
    }

    public final zzn zzf(int i) {
        this.zzh = i;
        return this;
    }

    public final zzn zzg(String str) {
        this.zzi = str;
        return this;
    }

    public final zzn zzh(int i) {
        this.zzk = i;
        return this;
    }

    public final zzn zzi(long j) {
        this.zzm = j;
        return this;
    }
}
