package io.github.zeroone3010.yahueapi.v2;

/* JADX INFO: loaded from: classes5.dex */
public interface HueEventSource extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    HueEventStreamState getState();
}
