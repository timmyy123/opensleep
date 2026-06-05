package androidx.health.connect.client.impl.platform;

import android.health.connect.HealthConnectException;
import android.os.RemoteException;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toKtException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Landroid/health/connect/HealthConnectException;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ExceptionConverterKt {
    public static final Exception toKtException(HealthConnectException healthConnectException) {
        healthConnectException.getClass();
        int errorCode = healthConnectException.getErrorCode();
        return errorCode != 3 ? errorCode != 4 ? errorCode != 5 ? errorCode != 6 ? new IllegalStateException(healthConnectException) : new RemoteException(healthConnectException.getMessage()) : new SecurityException(healthConnectException) : new IOException(healthConnectException) : new IllegalArgumentException(healthConnectException);
    }
}
