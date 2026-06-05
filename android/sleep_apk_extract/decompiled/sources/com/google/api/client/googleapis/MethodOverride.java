package com.google.api.client.googleapis;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;

/* JADX INFO: loaded from: classes4.dex */
public final class MethodOverride implements HttpExecuteInterceptor, HttpRequestInitializer {
    private final boolean overrideAllMethods;

    public MethodOverride(boolean z) {
        this.overrideAllMethods = z;
    }

    private boolean overrideThisMethod(HttpRequest httpRequest) {
        String requestMethod = httpRequest.getRequestMethod();
        if (requestMethod.equals("POST")) {
            return false;
        }
        if (!requestMethod.equals("GET") ? this.overrideAllMethods : httpRequest.getUrl().build().length() > 2048) {
            return !httpRequest.getTransport().supportsMethod(requestMethod);
        }
        return true;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void initialize(HttpRequest httpRequest) {
        httpRequest.setInterceptor(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void intercept(HttpRequest httpRequest) {
        if (overrideThisMethod(httpRequest)) {
            String requestMethod = httpRequest.getRequestMethod();
            httpRequest.setRequestMethod("POST");
            httpRequest.getHeaders().set("X-HTTP-Method-Override", (Object) requestMethod);
            if (requestMethod.equals("GET")) {
                httpRequest.setContent(new UrlEncodedContent(httpRequest.getUrl().clone()));
                httpRequest.getUrl().clear();
            } else if (httpRequest.getContent() == null) {
                httpRequest.setContent(new EmptyContent());
            }
        }
    }

    public MethodOverride() {
        this(false);
    }
}
