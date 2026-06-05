package com.google.android.gms.internal.measurement;

import com.google.common.collect.ImmutableList;
import java.util.UUID;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzvo extends zzwv {
    private ImmutableList zza;
    private ImmutableList zzb;
    private UUID zzc;
    private long zzd;
    private byte zze;

    public final zzwv zza(ImmutableList immutableList) {
        if (immutableList != null) {
            this.zza = immutableList;
            return this;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Null spansNames");
        return null;
    }

    public final zzwv zzb(ImmutableList immutableList) {
        if (immutableList != null) {
            this.zzb = immutableList;
            return this;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Null extras");
        return null;
    }

    public final zzwv zzc(UUID uuid) {
        if (uuid != null) {
            this.zzc = uuid;
            return this;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Null rootTraceId");
        return null;
    }

    public final zzwv zzd(long j) {
        this.zzd = -1L;
        this.zze = (byte) 1;
        return this;
    }

    public final zzww zze() {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        UUID uuid;
        if (this.zze == 1 && (immutableList = this.zza) != null && (immutableList2 = this.zzb) != null && (uuid = this.zzc) != null) {
            return new zzvp(immutableList, immutableList2, uuid, this.zzd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" spansNames");
        }
        if (this.zzb == null) {
            sb.append(" extras");
        }
        if (this.zzc == null) {
            sb.append(" rootTraceId");
        }
        if (this.zze == 0) {
            sb.append(" rootDurationMs");
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Missing required properties:".concat(sb.toString()));
        return null;
    }
}
