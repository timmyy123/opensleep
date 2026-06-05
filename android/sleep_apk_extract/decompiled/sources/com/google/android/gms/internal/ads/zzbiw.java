package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbiw {
    public static final void zza(zzbiv zzbivVar, zzbit zzbitVar) {
        if (zzbitVar.zzb() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (TextUtils.isEmpty(zzbitVar.zzc())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        } else {
            zzbivVar.zza(zzbitVar.zzb(), zzbitVar.zzc(), zzbitVar.zza(), zzbitVar.zzd());
        }
    }
}
