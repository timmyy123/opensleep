package androidx.health.platform.client.impl.data;

import androidx.health.platform.client.proto.MessageLite;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Landroidx/health/platform/client/impl/data/ProtoData;", "T", "Landroidx/health/platform/client/proto/MessageLite;", "", "<init>", "()V", "proto", "getProto", "()Landroidx/health/platform/client/proto/MessageLite;", "equals", "", "other", "hashCode", "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ProtoData<T extends MessageLite> {
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(getProto(), ((ProtoData) other).getProto());
    }

    public abstract T getProto();

    public int hashCode() {
        return getProto().hashCode();
    }
}
