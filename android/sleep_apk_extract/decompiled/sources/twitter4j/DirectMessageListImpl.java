package twitter4j;

/* JADX INFO: loaded from: classes5.dex */
class DirectMessageListImpl extends ResponseListImpl<DirectMessage> implements DirectMessageList {
    private static final long serialVersionUID = 8150060768287194508L;
    private final String nextCursor;

    public DirectMessageListImpl(int i, JSONObject jSONObject, HttpResponse httpResponse) {
        super(i, httpResponse);
        this.nextCursor = ParseUtil.getRawString("next_cursor", jSONObject);
    }

    public DirectMessageListImpl(int i, HttpResponse httpResponse) {
        super(i, httpResponse);
        this.nextCursor = null;
    }
}
