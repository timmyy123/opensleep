package retrofit.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import retrofit.mime.TypedOutput;

/* JADX INFO: loaded from: classes5.dex */
public final class Request {
    private final TypedOutput body;
    private final List<Header> headers;
    private final String method;
    private final String url;

    public Request(String str, String str2, List<Header> list, TypedOutput typedOutput) {
        if (str == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Method must not be null.");
            throw null;
        }
        if (str2 == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("URL must not be null.");
            throw null;
        }
        this.method = str;
        this.url = str2;
        if (list == null) {
            this.headers = Collections.EMPTY_LIST;
        } else {
            this.headers = Collections.unmodifiableList(new ArrayList(list));
        }
        this.body = typedOutput;
    }

    public TypedOutput getBody() {
        return this.body;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }
}
