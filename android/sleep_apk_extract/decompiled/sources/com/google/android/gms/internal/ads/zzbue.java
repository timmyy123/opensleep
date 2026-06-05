package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzbue implements zzbua {
    static final /* synthetic */ zzbue zza = new zzbue();

    private /* synthetic */ zzbue() {
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final /* synthetic */ Object zza(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
    }
}
