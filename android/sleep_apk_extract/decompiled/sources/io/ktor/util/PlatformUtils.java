package io.ktor.util;

import io.ktor.util.Platform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lio/ktor/util/PlatformUtils;", "", "<init>", "()V", "", "IS_BROWSER", "Z", "getIS_BROWSER", "()Z", "IS_NODE", "getIS_NODE", "IS_JS", "getIS_JS", "IS_WASM_JS", "getIS_WASM_JS", "IS_JVM", "getIS_JVM", "IS_NATIVE", "getIS_NATIVE", "IS_DEVELOPMENT_MODE", "getIS_DEVELOPMENT_MODE", "IS_NEW_MM_ENABLED", "getIS_NEW_MM_ENABLED", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformUtils {
    public static final PlatformUtils INSTANCE;
    private static final boolean IS_BROWSER;
    private static final boolean IS_DEVELOPMENT_MODE;
    private static final boolean IS_JS;
    private static final boolean IS_JVM;
    private static final boolean IS_NATIVE;
    private static final boolean IS_NEW_MM_ENABLED;
    private static final boolean IS_NODE;
    private static final boolean IS_WASM_JS;

    static {
        PlatformUtils platformUtils = new PlatformUtils();
        INSTANCE = platformUtils;
        PlatformUtilsJvmKt.getPlatform(platformUtils);
        IS_BROWSER = false;
        PlatformUtilsJvmKt.getPlatform(platformUtils);
        IS_NODE = false;
        PlatformUtilsJvmKt.getPlatform(platformUtils);
        IS_JS = false;
        PlatformUtilsJvmKt.getPlatform(platformUtils);
        IS_WASM_JS = false;
        IS_JVM = Intrinsics.areEqual(PlatformUtilsJvmKt.getPlatform(platformUtils), Platform.Jvm.INSTANCE);
        IS_NATIVE = Intrinsics.areEqual(PlatformUtilsJvmKt.getPlatform(platformUtils), Platform.Native.INSTANCE);
        IS_DEVELOPMENT_MODE = PlatformUtilsJvmKt.isDevelopmentMode(platformUtils);
        IS_NEW_MM_ENABLED = PlatformUtilsJvmKt.isNewMemoryModel(platformUtils);
    }

    private PlatformUtils() {
    }

    public final boolean getIS_BROWSER() {
        return IS_BROWSER;
    }

    public final boolean getIS_DEVELOPMENT_MODE() {
        return IS_DEVELOPMENT_MODE;
    }
}
