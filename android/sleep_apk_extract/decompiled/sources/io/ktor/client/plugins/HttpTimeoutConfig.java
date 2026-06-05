package io.ktor.client.plugins;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/plugins/HttpTimeoutConfig;", "", "", "requestTimeoutMillis", "connectTimeoutMillis", "socketTimeoutMillis", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", SDKConstants.PARAM_VALUE, "checkTimeoutValue", "(Ljava/lang/Long;)Ljava/lang/Long;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "_requestTimeoutMillis", "Ljava/lang/Long;", "_connectTimeoutMillis", "_socketTimeoutMillis", "getRequestTimeoutMillis", "()Ljava/lang/Long;", "setRequestTimeoutMillis", "(Ljava/lang/Long;)V", "getConnectTimeoutMillis", "setConnectTimeoutMillis", "getSocketTimeoutMillis", "setSocketTimeoutMillis", "Companion", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpTimeoutConfig {
    private static final AttributeKey<HttpTimeoutConfig> key;
    private Long _connectTimeoutMillis;
    private Long _requestTimeoutMillis;
    private Long _socketTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        KType kTypeTypeOf = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpTimeoutConfig.class);
        try {
            kTypeTypeOf = Reflection.typeOf(HttpTimeoutConfig.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("TimeoutConfiguration", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
    }

    public HttpTimeoutConfig(Long l, Long l2, Long l3) {
        this._requestTimeoutMillis = 0L;
        this._connectTimeoutMillis = 0L;
        this._socketTimeoutMillis = 0L;
        setRequestTimeoutMillis(l);
        setConnectTimeoutMillis(l2);
        setSocketTimeoutMillis(l3);
    }

    private final Long checkTimeoutValue(Long value) {
        if (value == null || value.longValue() > 0) {
            return value;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS");
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || HttpTimeoutConfig.class != other.getClass()) {
            return false;
        }
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) other;
        return Intrinsics.areEqual(this._requestTimeoutMillis, httpTimeoutConfig._requestTimeoutMillis) && Intrinsics.areEqual(this._connectTimeoutMillis, httpTimeoutConfig._connectTimeoutMillis) && Intrinsics.areEqual(this._socketTimeoutMillis, httpTimeoutConfig._socketTimeoutMillis);
    }

    /* JADX INFO: renamed from: getConnectTimeoutMillis, reason: from getter */
    public final Long get_connectTimeoutMillis() {
        return this._connectTimeoutMillis;
    }

    /* JADX INFO: renamed from: getRequestTimeoutMillis, reason: from getter */
    public final Long get_requestTimeoutMillis() {
        return this._requestTimeoutMillis;
    }

    /* JADX INFO: renamed from: getSocketTimeoutMillis, reason: from getter */
    public final Long get_socketTimeoutMillis() {
        return this._socketTimeoutMillis;
    }

    public int hashCode() {
        Long l = this._requestTimeoutMillis;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this._connectTimeoutMillis;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this._socketTimeoutMillis;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public final void setConnectTimeoutMillis(Long l) {
        this._connectTimeoutMillis = checkTimeoutValue(l);
    }

    public final void setRequestTimeoutMillis(Long l) {
        this._requestTimeoutMillis = checkTimeoutValue(l);
    }

    public final void setSocketTimeoutMillis(Long l) {
        this._socketTimeoutMillis = checkTimeoutValue(l);
    }

    public /* synthetic */ HttpTimeoutConfig(Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3);
    }
}
