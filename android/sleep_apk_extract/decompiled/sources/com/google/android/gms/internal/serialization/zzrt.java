package com.google.android.gms.internal.serialization;

import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/nest/platform/mesh/api/logger/Logger$LoggerAtLevel;", "", "logLevel", "Lcom/google/nest/platform/mesh/api/logger/LogLevel;", "<init>", "(Lcom/google/nest/platform/mesh/api/logger/Logger;Lcom/google/nest/platform/mesh/api/logger/LogLevel;)V", "log", "", "message", "", "items", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "java.com.google.nest.platform.mesh.api.logger_logger-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzrt {
    final /* synthetic */ zzru zza;
    private final zzrs zzb;

    public zzrt(zzru zzruVar, zzrs zzrsVar) {
        zzrsVar.getClass();
        this.zza = zzruVar;
        this.zzb = zzrsVar;
    }

    public final void zza(String str, Object... objArr) {
        str.getClass();
        objArr.getClass();
        this.zza.zzb.zza(this.zzb, str, Arrays.copyOf(objArr, objArr.length));
    }
}
