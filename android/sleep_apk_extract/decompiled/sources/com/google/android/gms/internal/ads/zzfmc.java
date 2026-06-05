package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfmc implements zzimu {
    private zzfmc(zzfmb zzfmbVar) {
    }

    public static zzfmc zza(zzfmb zzfmbVar) {
        return new zzfmc(zzfmbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        Clock defaultClock = DefaultClock.getInstance();
        zzinc.zzb(defaultClock);
        return defaultClock;
    }
}
