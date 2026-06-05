package org.mp4parser.muxer;

import java.nio.channels.WritableByteChannel;
import org.mp4parser.boxes.sampleentry.SampleEntry;

/* JADX INFO: loaded from: classes5.dex */
public interface Sample {
    SampleEntry getSampleEntry();

    long getSize();

    void writeTo(WritableByteChannel writableByteChannel);
}
