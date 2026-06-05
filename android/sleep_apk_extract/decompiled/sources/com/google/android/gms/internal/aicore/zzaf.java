package com.google.android.gms.internal.aicore;

import android.os.Parcelable;
import java.util.Locale;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzaf implements Function {
    static final /* synthetic */ zzaf zza = new zzaf();

    private /* synthetic */ zzaf() {
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzdk zzdkVar = (zzdk) obj;
        Parcelable.Creator<zzae> creator = zzae.CREATOR;
        return String.format(Locale.getDefault(), "(%d, %d)", Integer.valueOf(zzdkVar.zza()), Integer.valueOf(zzdkVar.zzb()));
    }
}
