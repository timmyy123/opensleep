package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    public static class Builder<A extends Api.AnyClient, ResultT> {
        private RemoteCall zaa;
        private Feature[] zad;
        private boolean zab = false;
        private boolean zac = false;
        private int zae = 0;

        public /* synthetic */ Builder(byte[] bArr) {
        }

        public TaskApiCall<A, ResultT> build() {
            boolean z = true;
            Preconditions.checkArgument(this.zaa != null, "execute parameter required");
            if (!this.zac) {
                Feature[] featureArr = this.zad;
                if (featureArr == null || (featureArr.length) == 0) {
                    z = false;
                    this.zab = z;
                } else {
                    for (Feature feature : featureArr) {
                        if (!feature.getIsFullyRolledOut()) {
                            z = false;
                            break;
                        }
                    }
                    this.zab = z;
                }
            }
            return new zacm(this, this.zad, this.zab, this.zae);
        }

        public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z) {
            this.zac = true;
            this.zab = z;
            return this;
        }

        public Builder<A, ResultT> setFeatures(Feature... featureArr) {
            this.zad = featureArr;
            return this;
        }

        public Builder<A, ResultT> setMethodKey(int i) {
            this.zae = i;
            return this;
        }

        public final /* synthetic */ RemoteCall zaa() {
            return this.zaa;
        }
    }

    public TaskApiCall(Feature[] featureArr, boolean z, int i) {
        this.zaa = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.zab = z2;
        this.zac = i;
    }

    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>(null);
    }

    public abstract void doExecute(A a, TaskCompletionSource<ResultT> taskCompletionSource);

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final Feature[] zaa() {
        return this.zaa;
    }

    public final int zab() {
        return this.zac;
    }
}
