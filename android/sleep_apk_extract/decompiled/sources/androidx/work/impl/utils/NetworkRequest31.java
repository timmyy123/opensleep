package androidx.work.impl.utils;

import android.net.NetworkRequest;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Landroidx/work/impl/utils/NetworkRequest31;", "", "<init>", "()V", "capabilities", "", "request", "Landroid/net/NetworkRequest;", "transportTypes", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class NetworkRequest31 {
    public static final NetworkRequest31 INSTANCE = new NetworkRequest31();

    private NetworkRequest31() {
    }

    public final int[] capabilities(NetworkRequest request) {
        request.getClass();
        int[] capabilities = request.getCapabilities();
        capabilities.getClass();
        return capabilities;
    }

    public final int[] transportTypes(NetworkRequest request) {
        request.getClass();
        int[] transportTypes = request.getTransportTypes();
        transportTypes.getClass();
        return transportTypes;
    }
}
