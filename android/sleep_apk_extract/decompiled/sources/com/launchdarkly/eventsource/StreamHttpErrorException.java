package com.launchdarkly.eventsource;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class StreamHttpErrorException extends StreamException {
    private final int code;
    private final ResponseHeaders headers;

    public StreamHttpErrorException(int i, ResponseHeaders responseHeaders) {
        super(FileInsert$$ExternalSyntheticOutline0.m(i, "Server returned HTTP error "));
        this.code = i;
        this.headers = responseHeaders;
    }

    public ResponseHeaders getHeaders() {
        return this.headers;
    }
}
