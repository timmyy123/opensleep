package com.google.android.gms.internal.aicore;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzax extends zzas {
    private Context zza;
    private ExecutorService zzb;
    private Executor zzc;
    private boolean zzd;
    private byte zze;

    @Override // com.google.android.gms.internal.aicore.zzas
    public final zzas zza(ExecutorService executorService) {
        if (executorService != null) {
            this.zzb = executorService;
            return this;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Null workerExecutor");
        return null;
    }

    @Override // com.google.android.gms.internal.aicore.zzas
    public final zzas zzb(Executor executor) {
        if (executor != null) {
            this.zzc = executor;
            return this;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Null callbackExecutor");
        return null;
    }

    public final zzas zzc(boolean z) {
        this.zzd = true;
        this.zze = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.aicore.zzas
    public final zzau zzd() {
        Context context;
        ExecutorService executorService;
        Executor executor;
        if (this.zze == 1 && (context = this.zza) != null && (executorService = this.zzb) != null && (executor = this.zzc) != null) {
            return new zzay(context, executorService, executor, this.zzd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" context");
        }
        if (this.zzb == null) {
            sb.append(" workerExecutor");
        }
        if (this.zzc == null) {
            sb.append(" callbackExecutor");
        }
        if (this.zze == 0) {
            sb.append(" bindImportantEnabled");
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Missing required properties:".concat(sb.toString()));
        return null;
    }

    public final zzas zze(Context context) {
        if (context != null) {
            this.zza = context;
            return this;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Null context");
        return null;
    }
}
