package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.common.util.concurrent.ListenableFuture;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzfdd implements zzhbe {
    static final /* synthetic */ zzfdd zza = new zzfdd();

    private /* synthetic */ zzfdd() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (getTopicsResponse == null) {
            return zzhbw.zza(new zzfdf("", 1, null));
        }
        zzihy zzihyVarZzc = zzihz.zzc();
        Iterator<Object> it = getTopicsResponse.getTopics().iterator();
        if (!it.hasNext()) {
            return zzhbw.zza(new zzfdf(Base64.encodeToString(((zzihz) zzihyVarZzc.zzbm()).zzaN(), 1), 1, null));
        }
        if (it.next() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        zzihx.zzc();
        throw null;
    }
}
