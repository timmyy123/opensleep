package com.launchdarkly.eventsource;

import com.launchdarkly.eventsource.ResponseHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes5.dex */
final class ResponseHeadersImpl implements ResponseHeaders {
    private static final ResponseHeaders EMPTY = new ResponseHeadersImpl(Collections.EMPTY_LIST);
    private final List<ResponseHeaders.Header> headers;

    private ResponseHeadersImpl(List<ResponseHeaders.Header> list) {
        this.headers = list;
    }

    public static ResponseHeaders fromOkHttpHeaders(Headers headers) {
        if (headers == null || headers.size() == 0) {
            return EMPTY;
        }
        ArrayList arrayList = new ArrayList(headers.size());
        for (int i = 0; i < headers.size(); i++) {
            arrayList.add(new ResponseHeaders.Header(headers.name(i), headers.value(i)));
        }
        return new ResponseHeadersImpl(Collections.unmodifiableList(arrayList));
    }

    public String toString() {
        return "ResponseHeaders(" + this.headers.size() + " headers)";
    }
}
