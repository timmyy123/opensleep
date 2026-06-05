package com.google.api.client.http.javanet;

import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnectionFactory {
    HttpURLConnection openConnection(URL url);
}
