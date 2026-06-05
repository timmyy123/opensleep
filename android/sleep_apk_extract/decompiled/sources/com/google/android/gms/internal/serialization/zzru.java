package com.google.android.gms.internal.serialization;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u00060\tR\u00020\u0000J\n\u0010\r\u001a\u00060\tR\u00020\u0000J\n\u0010\u000e\u001a\u00060\tR\u00020\u0000J\n\u0010\u000f\u001a\u00060\tR\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tR\u00020\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/google/nest/platform/mesh/api/logger/Logger;", "", "platformLogger", "Lcom/google/nest/platform/mesh/api/logger/PlatformLogger;", "<init>", "(Lcom/google/nest/platform/mesh/api/logger/PlatformLogger;)V", "loggersPerLevel", "", "Lcom/google/nest/platform/mesh/api/logger/LogLevel;", "Lcom/google/nest/platform/mesh/api/logger/Logger$LoggerAtLevel;", "getLoggersPerLevel", "()Ljava/util/Map;", "atInfo", "atDebug", "atWarning", "atSevere", "LoggerAtLevel", "java.com.google.nest.platform.mesh.api.logger_logger-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzru {
    private final Map zza;
    private final zzrr zzb;

    public zzru(zzrr zzrrVar) {
        zzrrVar.getClass();
        this.zzb = zzrrVar;
        zzrs zzrsVar = zzrs.zza;
        Pair pair = TuplesKt.to(zzrsVar, new zzrt(this, zzrsVar));
        zzrs zzrsVar2 = zzrs.zzb;
        Pair pair2 = TuplesKt.to(zzrsVar2, new zzrt(this, zzrsVar2));
        zzrs zzrsVar3 = zzrs.zzc;
        Pair pair3 = TuplesKt.to(zzrsVar3, new zzrt(this, zzrsVar3));
        zzrs zzrsVar4 = zzrs.zzd;
        this.zza = MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to(zzrsVar4, new zzrt(this, zzrsVar4)));
    }

    public final zzrt zza() {
        Object obj = this.zza.get(zzrs.zza);
        obj.getClass();
        return (zzrt) obj;
    }

    public final zzrt zzb() {
        Object obj = this.zza.get(zzrs.zzb);
        obj.getClass();
        return (zzrt) obj;
    }

    public final zzrt zzc() {
        Object obj = this.zza.get(zzrs.zzc);
        obj.getClass();
        return (zzrt) obj;
    }

    public final zzrt zzd() {
        Object obj = this.zza.get(zzrs.zzd);
        obj.getClass();
        return (zzrt) obj;
    }
}
