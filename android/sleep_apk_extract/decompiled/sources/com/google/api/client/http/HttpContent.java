package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpContent extends StreamingContent {
    long getLength();

    String getType();

    boolean retrySupported();
}
