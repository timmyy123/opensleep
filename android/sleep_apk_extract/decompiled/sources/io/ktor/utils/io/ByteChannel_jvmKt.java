package io.ktor.utils.io;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0014\u0010\u0003\u001a\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"", "getDEVELOPMENT_MODE", "()Z", "DEVELOPMENT_MODE", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ByteChannel_jvmKt {
    public static final boolean getDEVELOPMENT_MODE() {
        String property = System.getProperty("io.ktor.development");
        return property != null && Boolean.parseBoolean(property);
    }
}
