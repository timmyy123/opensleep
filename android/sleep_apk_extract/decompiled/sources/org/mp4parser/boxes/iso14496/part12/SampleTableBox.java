package org.mp4parser.boxes.iso14496.part12;

import org.mp4parser.Box;
import org.mp4parser.support.AbstractContainerBox;
import org.mp4parser.tools.Path;

/* JADX INFO: loaded from: classes5.dex */
public class SampleTableBox extends AbstractContainerBox {
    public static final String TYPE = "stbl";
    private SampleToChunkBox sampleToChunkBox;

    public SampleTableBox() {
        super(TYPE);
    }

    public ChunkOffsetBox getChunkOffsetBox() {
        for (Box box : getBoxes()) {
            if (box instanceof ChunkOffsetBox) {
                return (ChunkOffsetBox) box;
            }
        }
        return null;
    }

    public CompositionTimeToSample getCompositionTimeToSample() {
        return (CompositionTimeToSample) Path.getPath((AbstractContainerBox) this, CompositionTimeToSample.TYPE);
    }

    public SampleDependencyTypeBox getSampleDependencyTypeBox() {
        return (SampleDependencyTypeBox) Path.getPath((AbstractContainerBox) this, SampleDependencyTypeBox.TYPE);
    }

    public SampleDescriptionBox getSampleDescriptionBox() {
        return (SampleDescriptionBox) Path.getPath((AbstractContainerBox) this, SampleDescriptionBox.TYPE);
    }

    public SampleSizeBox getSampleSizeBox() {
        return (SampleSizeBox) Path.getPath((AbstractContainerBox) this, SampleSizeBox.TYPE);
    }

    public SampleToChunkBox getSampleToChunkBox() {
        return (SampleToChunkBox) Path.getPath((AbstractContainerBox) this, SampleToChunkBox.TYPE);
    }

    public SyncSampleBox getSyncSampleBox() {
        return (SyncSampleBox) Path.getPath((AbstractContainerBox) this, SyncSampleBox.TYPE);
    }

    public TimeToSampleBox getTimeToSampleBox() {
        return (TimeToSampleBox) Path.getPath((AbstractContainerBox) this, TimeToSampleBox.TYPE);
    }
}
