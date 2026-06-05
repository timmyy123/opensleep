package androidx.health.platform.client.impl.ipc;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class ApiVersionException extends ExecutionException {
    private final int mMinVersion;
    private final int mRemoteVersion;

    public ApiVersionException(int i, int i2) {
        super(Fragment$$ExternalSyntheticOutline1.m(i, i2, "Version requirements for calling the method was not met, remoteVersion: ", ", minVersion: "));
        this.mRemoteVersion = i;
        this.mMinVersion = i2;
    }

    public int getMinVersion() {
        return this.mMinVersion;
    }

    public int getRemoteVersion() {
        return this.mRemoteVersion;
    }
}
