package androidx.health.connect.client.impl.platform.aggregate;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000b¨\u0006\u001e"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "", "", "count", "", "total", "<init>", "(ID)V", SDKConstants.PARAM_VALUE, "", "plusAssign", "(D)V", "average", "()D", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCount", "setCount", "(I)V", "D", "getTotal", "setTotal", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class AvgData {
    private int count;
    private double total;

    public /* synthetic */ AvgData(int i, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0d : d);
    }

    public final double average() {
        return this.total / ((double) this.count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvgData)) {
            return false;
        }
        AvgData avgData = (AvgData) other;
        return this.count == avgData.count && Double.compare(this.total, avgData.total) == 0;
    }

    public int hashCode() {
        return Double.hashCode(this.total) + (Integer.hashCode(this.count) * 31);
    }

    public final void plusAssign(double value) {
        this.count++;
        this.total += value;
    }

    public String toString() {
        return "AvgData(count=" + this.count + ", total=" + this.total + ')';
    }

    public AvgData(int i, double d) {
        this.count = i;
        this.total = d;
    }
}
