package org.mp4parser;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes5.dex */
public interface Box {
    void getBox(WritableByteChannel writableByteChannel);

    long getSize();

    String getType();
}
