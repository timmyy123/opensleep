package com.google.home.matter.serialization;

import com.google.android.gms.internal.serialization.zzru;
import com.google.android.gms.internal.serialization.zzrv;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/SerializationLogger;", "", "<init>", "()V", "logger", "Lcom/google/nest/platform/mesh/api/logger/Logger;", "getLogger", "()Lcom/google/nest/platform/mesh/api/logger/Logger;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SerializationLogger {
    public static final SerializationLogger INSTANCE = new SerializationLogger();
    private static final zzru logger = zzrv.zza("UddmSerializer");

    private SerializationLogger() {
    }

    public final zzru getLogger() {
        return logger;
    }
}
