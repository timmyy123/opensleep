package twitter4j;

/* JADX INFO: loaded from: classes5.dex */
class PagableResponseListImpl<T> extends ResponseListImpl<T> implements PagableResponseList<T> {
    private static final long serialVersionUID = -8603601553967559275L;
    private final long nextCursor;
    private final long previousCursor;

    public PagableResponseListImpl(int i, JSONObject jSONObject, HttpResponse httpResponse) {
        super(i, httpResponse);
        this.previousCursor = ParseUtil.getLong("previous_cursor", jSONObject);
        this.nextCursor = ParseUtil.getLong("next_cursor", jSONObject);
    }
}
