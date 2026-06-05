package androidx.health.platform.client.impl.error;

import android.os.Build;
import android.os.RemoteException;
import androidx.health.platform.client.error.ErrorStatus;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00060\u0004j\u0002`\b*\u00020\tH\u0000\"(\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"errorCodeExceptionMap", "", "", "Lkotlin/reflect/KClass;", "Ljava/lang/Exception;", "getErrorCodeExceptionMap", "()Ljava/util/Map;", "toException", "Lkotlin/Exception;", "Landroidx/health/platform/client/error/ErrorStatus;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ErrorStatusConverterKt {
    private static final Map<Integer, KClass<? extends Exception>> errorCodeExceptionMap = MapsKt.mapOf(TuplesKt.to(1, Reflection.getOrCreateKotlinClass(UnsupportedOperationException.class)), TuplesKt.to(2, Reflection.getOrCreateKotlinClass(UnsupportedOperationException.class)), TuplesKt.to(3, Reflection.getOrCreateKotlinClass(UnsupportedOperationException.class)), TuplesKt.to(4, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.to(10000, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.to(10001, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.to(10002, Reflection.getOrCreateKotlinClass(IllegalArgumentException.class)), TuplesKt.to(10003, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.to(10004, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.to(10005, Reflection.getOrCreateKotlinClass(RemoteException.class)), TuplesKt.to(10006, Reflection.getOrCreateKotlinClass(IOException.class)), TuplesKt.to(10007, Reflection.getOrCreateKotlinClass(RemoteException.class)), TuplesKt.to(10008, Reflection.getOrCreateKotlinClass(RemoteException.class)), TuplesKt.to(10010, Reflection.getOrCreateKotlinClass(RemoteException.class)));

    public static final Map<Integer, KClass<? extends Exception>> getErrorCodeExceptionMap() {
        return errorCodeExceptionMap;
    }

    public static final Exception toException(ErrorStatus errorStatus) {
        errorStatus.getClass();
        KClass<? extends Exception> kClass = errorCodeExceptionMap.get(Integer.valueOf(errorStatus.getErrorCode()));
        return kClass != null ? Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(SecurityException.class)) ? new SecurityException(errorStatus.getErrorMessage()) : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(RemoteException.class)) ? Build.VERSION.SDK_INT > 24 ? new RemoteException(errorStatus.getErrorMessage()) : new RemoteException() : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(IllegalArgumentException.class)) ? new IllegalArgumentException(errorStatus.getErrorMessage()) : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(IOException.class)) ? new IOException(errorStatus.getErrorMessage()) : new UnsupportedOperationException(errorStatus.getErrorMessage()) : new UnsupportedOperationException(errorStatus.getErrorMessage());
    }
}
