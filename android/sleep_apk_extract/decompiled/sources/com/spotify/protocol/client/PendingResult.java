package com.spotify.protocol.client;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface PendingResult<T> {
    Result<T> await(long j, TimeUnit timeUnit);
}
