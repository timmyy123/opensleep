package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class Paging implements Serializable {
    private static final long serialVersionUID = -7226113618341047983L;
    static final char[] S = {'s'};
    static final char[] SMCP = {'s', 'm', 'c', 'p'};
    private static final HttpParameter[] NULL_PARAMETER_ARRAY = new HttpParameter[0];
    private static final List<HttpParameter> NULL_PARAMETER_LIST = new ArrayList(0);
    private int page = -1;
    private int count = -1;
    private long sinceId = -1;
    private long maxId = -1;

    private void addPostParameter(char[] cArr, char c, List<HttpParameter> list, String str, long j) {
        int length = cArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (cArr[i] == c) {
                    break;
                } else {
                    i++;
                }
            } else if (-1 != j) {
                Utf8$$ExternalSyntheticBUOutline0.m$3(FileInsert$$ExternalSyntheticOutline0.m("Paging parameter [", str, "] is not supported with this operation."));
                return;
            }
        }
        if (-1 != j) {
            list.add(new HttpParameter(str, String.valueOf(j)));
        }
    }

    public HttpParameter[] asPostParameterArray(char[] cArr, String str) {
        ArrayList arrayList = new ArrayList(cArr.length);
        addPostParameter(cArr, 's', arrayList, "since_id", getSinceId());
        addPostParameter(cArr, 'm', arrayList, "max_id", getMaxId());
        addPostParameter(cArr, 'c', arrayList, str, getCount());
        addPostParameter(cArr, 'p', arrayList, "page", getPage());
        return arrayList.size() == 0 ? NULL_PARAMETER_ARRAY : (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    public List<HttpParameter> asPostParameterList(char[] cArr, String str) {
        ArrayList arrayList = new ArrayList(cArr.length);
        addPostParameter(cArr, 's', arrayList, "since_id", getSinceId());
        addPostParameter(cArr, 'm', arrayList, "max_id", getMaxId());
        addPostParameter(cArr, 'c', arrayList, str, getCount());
        addPostParameter(cArr, 'p', arrayList, "page", getPage());
        return arrayList.size() == 0 ? NULL_PARAMETER_LIST : arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paging)) {
            return false;
        }
        Paging paging = (Paging) obj;
        return this.count == paging.count && this.maxId == paging.maxId && this.page == paging.page && this.sinceId == paging.sinceId;
    }

    public int getCount() {
        return this.count;
    }

    public long getMaxId() {
        return this.maxId;
    }

    public int getPage() {
        return this.page;
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public int hashCode() {
        int i = ((this.page * 31) + this.count) * 31;
        long j = this.sinceId;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.maxId;
        return i2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Paging{page=");
        sb.append(this.page);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(", sinceId=");
        sb.append(this.sinceId);
        sb.append(", maxId=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.maxId, '}');
    }

    public HttpParameter[] asPostParameterArray() {
        List<HttpParameter> listAsPostParameterList = asPostParameterList(SMCP, "count");
        if (listAsPostParameterList.size() == 0) {
            return NULL_PARAMETER_ARRAY;
        }
        return (HttpParameter[]) listAsPostParameterList.toArray(new HttpParameter[listAsPostParameterList.size()]);
    }
}
