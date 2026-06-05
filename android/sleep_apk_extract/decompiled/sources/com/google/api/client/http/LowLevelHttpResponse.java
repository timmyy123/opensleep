package com.google.api.client.http;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LowLevelHttpResponse {
    public abstract void disconnect();

    public abstract InputStream getContent();

    public abstract String getContentEncoding();

    public abstract long getContentLength();

    public abstract String getContentType();

    public abstract int getHeaderCount();

    public abstract String getHeaderName(int i);

    public abstract String getHeaderValue(int i);

    public abstract String getReasonPhrase();

    public abstract int getStatusCode();

    public abstract String getStatusLine();
}
