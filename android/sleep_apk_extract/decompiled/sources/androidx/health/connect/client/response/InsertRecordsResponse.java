package androidx.health.connect.client.response;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/health/connect/client/response/InsertRecordsResponse;", "", "recordIdsList", "", "", "<init>", "(Ljava/util/List;)V", "getRecordIdsList", "()Ljava/util/List;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InsertRecordsResponse {
    private final List<String> recordIdsList;

    public InsertRecordsResponse(List<String> list) {
        list.getClass();
        this.recordIdsList = list;
    }

    public final List<String> getRecordIdsList() {
        return this.recordIdsList;
    }
}
