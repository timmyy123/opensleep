package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.records.Record;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00028\u0001H&¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "T", "Landroidx/health/connect/client/records/Record;", "R", "", "filterAndAggregate", "", "record", "(Landroidx/health/connect/client/records/Record;)V", "getResult", "()Ljava/lang/Object;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Aggregator<T extends Record, R> {
    void filterAndAggregate(T record);

    R getResult();
}
