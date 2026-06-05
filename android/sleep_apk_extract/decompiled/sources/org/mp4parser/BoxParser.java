package org.mp4parser;

import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes5.dex */
public interface BoxParser {
    ParsableBox parseBox(ReadableByteChannel readableByteChannel, String str);
}
