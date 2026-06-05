package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbrv;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzet extends zzbrv {
    final /* synthetic */ zzeu zza;

    public /* synthetic */ zzet(zzeu zzeuVar, byte[] bArr) {
        Objects.requireNonNull(zzeuVar);
        this.zza = zzeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final void zzb(List list) {
        int i;
        ArrayList arrayList;
        zzeu zzeuVar = this.zza;
        synchronized (zzeuVar.zzw()) {
            zzeuVar.zzy(false);
            zzeuVar.zzz(true);
            arrayList = new ArrayList(zzeuVar.zzx());
            zzeuVar.zzx().clear();
        }
        zzeu.zzB(list);
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((GlobalInitializator$$ExternalSyntheticLambda1) ((OnInitializationCompleteListener) arrayList.get(i))).getClass();
            Logger.logInfo("ADMOB: initialized");
        }
    }
}
