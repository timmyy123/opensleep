package com.google.android.gms.internal.ads;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzwb implements zzwe {
    static final /* synthetic */ zzwb zza = new zzwb();

    private /* synthetic */ zzwb() {
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final /* synthetic */ int zza(Object obj) {
        int i = zzwf.$r8$clinit;
        String str = ((zzvm) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
