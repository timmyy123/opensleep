package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzeff;
import com.google.android.gms.internal.ads.zzegs;
import com.google.android.gms.internal.ads.zzhbe;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzba implements zzhbe {
    private final Executor zza;
    private final zzeff zzb;

    public zzba(Executor executor, zzeff zzeffVar) {
        this.zza = executor;
        this.zzb = zzeffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) {
        final zzcbd zzcbdVar = (zzcbd) obj;
        return zzhbw.zzj(this.zzb.zza(zzcbdVar), new zzhbe() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaz
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj2) {
                zzegs zzegsVar = (zzegs) obj2;
                zzbc zzbcVar = new zzbc(new JsonReader(new InputStreamReader(zzegsVar.zza())), zzegsVar.zzb());
                try {
                    zzbcVar.zzb = com.google.android.gms.ads.internal.client.zzay.zza().zzo(zzcbdVar.zza).toString();
                } catch (JSONException unused) {
                    zzbcVar.zzb = "{}";
                }
                return zzhbw.zza(zzbcVar);
            }
        }, this.zza);
    }
}
