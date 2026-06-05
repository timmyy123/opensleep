package com.google.api.client.http;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpRequestFactory {
    private final HttpRequestInitializer initializer;
    private final HttpTransport transport;

    public HttpRequestFactory(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.transport = httpTransport;
        this.initializer = httpRequestInitializer;
    }

    public HttpRequest buildRequest(String str, GenericUrl genericUrl, HttpContent httpContent) {
        HttpRequest httpRequestBuildRequest = this.transport.buildRequest();
        if (genericUrl != null) {
            httpRequestBuildRequest.setUrl(genericUrl);
        }
        HttpRequestInitializer httpRequestInitializer = this.initializer;
        if (httpRequestInitializer != null) {
            httpRequestInitializer.initialize(httpRequestBuildRequest);
        }
        httpRequestBuildRequest.setRequestMethod(str);
        if (httpContent != null) {
            httpRequestBuildRequest.setContent(httpContent);
        }
        return httpRequestBuildRequest;
    }
}
