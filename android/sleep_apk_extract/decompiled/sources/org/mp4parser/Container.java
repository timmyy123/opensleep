package org.mp4parser;

import java.nio.channels.WritableByteChannel;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface Container {
    List<Box> getBoxes();

    <T extends Box> List<T> getBoxes(Class<T> cls, boolean z);

    void writeContainer(WritableByteChannel writableByteChannel);
}
