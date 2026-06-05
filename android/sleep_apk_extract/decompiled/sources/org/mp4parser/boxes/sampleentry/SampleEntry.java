package org.mp4parser.boxes.sampleentry;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import org.mp4parser.BoxParser;
import org.mp4parser.Container;
import org.mp4parser.ParsableBox;

/* JADX INFO: loaded from: classes5.dex */
public interface SampleEntry extends ParsableBox, Container {
    @Override // org.mp4parser.Box
    /* synthetic */ void getBox(WritableByteChannel writableByteChannel);

    @Override // org.mp4parser.Container
    /* synthetic */ List getBoxes();

    /* synthetic */ List getBoxes(Class cls);

    @Override // org.mp4parser.Container
    /* synthetic */ List getBoxes(Class cls, boolean z);

    int getDataReferenceIndex();

    @Override // org.mp4parser.Box
    /* synthetic */ long getSize();

    @Override // org.mp4parser.Box
    /* synthetic */ String getType();

    @Override // org.mp4parser.ParsableBox
    /* synthetic */ void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, BoxParser boxParser);

    /* synthetic */ void setBoxes(List list);

    void setDataReferenceIndex(int i);

    @Override // org.mp4parser.Container
    /* synthetic */ void writeContainer(WritableByteChannel writableByteChannel);
}
