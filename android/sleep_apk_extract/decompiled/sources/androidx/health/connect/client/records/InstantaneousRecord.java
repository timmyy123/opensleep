package androidx.health.connect.client.records;

import j$.time.Instant;
import j$.time.ZoneOffset;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/health/connect/client/records/InstantaneousRecord;", "Landroidx/health/connect/client/records/Record;", "j$/time/Instant", "getTime", "()Lj$/time/Instant;", "time", "j$/time/ZoneOffset", "getZoneOffset", "()Lj$/time/ZoneOffset;", "zoneOffset", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InstantaneousRecord extends Record {
    Instant getTime();

    ZoneOffset getZoneOffset();
}
