package com.google.android.gms.internal.aicore;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class zzay extends zzau {
    private final Context zza;
    private final ExecutorService zzb;
    private final Executor zzc;
    private final boolean zzd;

    public /* synthetic */ zzay(Context context, ExecutorService executorService, Executor executor, boolean z, byte[] bArr) {
        this.zza = context;
        this.zzb = executorService;
        this.zzc = executor;
        this.zzd = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzau) {
            zzau zzauVar = (zzau) obj;
            if (this.zza.equals(zzauVar.zza()) && this.zzb.equals(zzauVar.zzb()) && this.zzc.equals(zzauVar.zzc()) && this.zzd == zzauVar.zzd()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.zzd ? 1237 : 1231) ^ ((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003);
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String string2 = this.zzb.toString();
        int length2 = string2.length();
        String string3 = this.zzc.toString();
        int length3 = string3.length();
        boolean z = this.zzd;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 45, length2, 19, length3, 23, String.valueOf(z).length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "AiCoreClientOptions{context=", string, ", workerExecutor=", string2);
        sb.append(", callbackExecutor=");
        sb.append(string3);
        sb.append(", bindImportantEnabled=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.aicore.zzau
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.aicore.zzau
    public final ExecutorService zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.aicore.zzau
    public final Executor zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.aicore.zzau
    public final boolean zzd() {
        return this.zzd;
    }
}
