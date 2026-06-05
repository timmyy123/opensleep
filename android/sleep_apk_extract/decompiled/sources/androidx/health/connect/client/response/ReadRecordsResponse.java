package androidx.health.connect.client.response;

import androidx.health.connect.client.records.Record;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B!\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/response/ReadRecordsResponse;", "T", "Landroidx/health/connect/client/records/Record;", "", "records", "", "pageToken", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getRecords", "()Ljava/util/List;", "getPageToken", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReadRecordsResponse<T extends Record> {
    private final String pageToken;
    private final List<T> records;

    /* JADX WARN: Multi-variable type inference failed */
    public ReadRecordsResponse(List<? extends T> list, String str) {
        list.getClass();
        this.records = list;
        this.pageToken = str;
    }

    public final String getPageToken() {
        return this.pageToken;
    }

    public final List<T> getRecords() {
        return this.records;
    }
}
