package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzevs implements zzfci {
    final ArrayList zza;

    public zzevs(ArrayList arrayList) {
        this.zza = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzfln.zzg((Bundle) obj, "android_permissions", this.zza);
    }
}
