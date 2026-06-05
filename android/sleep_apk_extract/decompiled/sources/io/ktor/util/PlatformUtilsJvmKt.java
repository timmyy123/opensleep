package io.ktor.util;

import io.ktor.util.Platform;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lio/ktor/util/PlatformUtils;", "Lio/ktor/util/Platform;", "getPlatform", "(Lio/ktor/util/PlatformUtils;)Lio/ktor/util/Platform;", "platform", "", "isDevelopmentMode", "(Lio/ktor/util/PlatformUtils;)Z", "isNewMemoryModel", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class PlatformUtilsJvmKt {
    public static final Platform getPlatform(PlatformUtils platformUtils) {
        platformUtils.getClass();
        return Platform.Jvm.INSTANCE;
    }

    public static final boolean isDevelopmentMode(PlatformUtils platformUtils) {
        platformUtils.getClass();
        String property = System.getProperty("io.ktor.development");
        return property != null && Boolean.parseBoolean(property);
    }

    public static final boolean isNewMemoryModel(PlatformUtils platformUtils) {
        platformUtils.getClass();
        return true;
    }
}
