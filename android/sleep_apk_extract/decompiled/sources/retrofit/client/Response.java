package retrofit.client;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.mime.TypedInput;

/* JADX INFO: loaded from: classes5.dex */
public final class Response {
    private final TypedInput body;
    private final List<Header> headers;
    private final String reason;
    private final int status;
    private final String url;

    public Response(String str, int i, String str2, List<Header> list, TypedInput typedInput) {
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("url == null");
            throw null;
        }
        if (i < 200) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Invalid status code: "));
            throw null;
        }
        if (str2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("reason == null");
            throw null;
        }
        if (list == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("headers == null");
            throw null;
        }
        this.url = str;
        this.status = i;
        this.reason = str2;
        this.headers = Collections.unmodifiableList(new ArrayList(list));
        this.body = typedInput;
    }

    public TypedInput getBody() {
        return this.body;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getReason() {
        return this.reason;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }
}
