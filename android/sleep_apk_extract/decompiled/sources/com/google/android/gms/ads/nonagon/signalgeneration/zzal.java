package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzgta;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzal implements zzgta {
    static final /* synthetic */ zzal zza = new zzal();

    private /* synthetic */ zzal() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        List list = zzap.zza;
        return ((JSONObject) obj).optString("nas");
    }
}
