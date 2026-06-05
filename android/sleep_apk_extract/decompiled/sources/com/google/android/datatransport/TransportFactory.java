package com.google.android.datatransport;

/* JADX INFO: loaded from: classes3.dex */
public interface TransportFactory {
    <T> Transport<T> getTransport(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer);
}
