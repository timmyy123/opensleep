package com.google.home;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00152\u00060\u0001j\u0002`\u0002:\u0001\u0015B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\t\u0010\nBA\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\t\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/HomeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/google/home/HomeError;", "error", "exception", "", "", "subErrors", "<init>", "(Lcom/google/home/HomeError;Ljava/lang/Exception;Ljava/util/Map;)V", "", "code", "message", "(ILjava/lang/String;Ljava/lang/Exception;Ljava/util/Map;)V", "Lcom/google/home/HomeError;", "getError", "()Lcom/google/home/HomeError;", "Ljava/util/Map;", "getSubErrors", "()Ljava/util/Map;", "Companion", "java.com.google.nest.platform.mesh.error_error-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HomeException extends Exception {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HomeError error;
    private final Map<String, HomeError> subErrors;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/google/home/HomeException$Companion;", "", "<init>", "()V", "", "", "Lcom/google/home/HomeError;", "subErrors", "Lcom/google/home/HomeException;", "bulkError", "(Ljava/util/Map;)Lcom/google/home/HomeException;", "message", "invalidArgument", "(Ljava/lang/String;)Lcom/google/home/HomeException;", "failedPrecondition", "internal", "apiNotConnected", "sdkInitializationMissingInfo", "java.com.google.nest.platform.mesh.error_error-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final HomeException apiNotConnected(String message) {
            message.getClass();
            return new HomeException(17, message, null, null, 12, null);
        }

        public final HomeException bulkError(Map<String, HomeError> subErrors) {
            subErrors.getClass();
            if (subErrors.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Bulk errors must have at least 1 value");
                return null;
            }
            if (subErrors.size() != 1) {
                return new HomeException(13, "Multiple errors encountered", null, subErrors);
            }
            return new HomeException((HomeError) CollectionsKt.first(subErrors.values()), null, null, 6, null);
        }

        public final HomeException failedPrecondition(String message) {
            message.getClass();
            return new HomeException(9, message, null, null, 12, null);
        }

        public final HomeException internal(String message) {
            message.getClass();
            return new HomeException(13, message, null, null, 12, null);
        }

        public final HomeException invalidArgument(String message) {
            message.getClass();
            return new HomeException(3, message, null, null, 12, null);
        }

        public final HomeException sdkInitializationMissingInfo(String message) {
            message.getClass();
            return new HomeException(18, message, null, null, 12, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HomeException(HomeError homeError, Exception exc, Map<String, HomeError> map) {
        homeError.getClass();
        map.getClass();
        int code = homeError.getCode();
        String message = homeError.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(code).length() + 2 + String.valueOf(message).length());
        sb.append(code);
        sb.append(": ");
        sb.append(message);
        super(sb.toString(), exc);
        this.error = homeError;
        this.subErrors = map;
    }

    public final HomeError getError() {
        return this.error;
    }

    public /* synthetic */ HomeException(int i, String str, Exception exc, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : exc, (i2 & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomeException(int i, String str, Exception exc, Map<String, HomeError> map) {
        this(new HomeError(i, str), exc, map);
        str.getClass();
        map.getClass();
    }

    public /* synthetic */ HomeException(HomeError homeError, Exception exc, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(homeError, (i & 2) != 0 ? null : exc, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }
}
