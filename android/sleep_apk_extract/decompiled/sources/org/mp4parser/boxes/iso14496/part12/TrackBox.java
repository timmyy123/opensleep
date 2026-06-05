package org.mp4parser.boxes.iso14496.part12;

import java.util.List;
import org.mp4parser.Box;
import org.mp4parser.support.AbstractContainerBox;
import org.mp4parser.tools.Path;

/* JADX INFO: loaded from: classes5.dex */
public class TrackBox extends AbstractContainerBox {
    public static final String TYPE = "trak";
    private SampleTableBox sampleTableBox;

    public TrackBox() {
        super(TYPE);
    }

    public MediaBox getMediaBox() {
        return (MediaBox) Path.getPath((AbstractContainerBox) this, "mdia[0]");
    }

    public SampleTableBox getSampleTableBox() {
        MediaInformationBox mediaInformationBox;
        SampleTableBox sampleTableBox = this.sampleTableBox;
        if (sampleTableBox != null) {
            return sampleTableBox;
        }
        MediaBox mediaBox = getMediaBox();
        if (mediaBox == null || (mediaInformationBox = mediaBox.getMediaInformationBox()) == null) {
            return null;
        }
        SampleTableBox sampleTableBox2 = mediaInformationBox.getSampleTableBox();
        this.sampleTableBox = sampleTableBox2;
        return sampleTableBox2;
    }

    public TrackHeaderBox getTrackHeaderBox() {
        return (TrackHeaderBox) Path.getPath((AbstractContainerBox) this, "tkhd[0]");
    }

    @Override // org.mp4parser.BasicContainer, org.mp4parser.boxes.sampleentry.SampleEntry
    public void setBoxes(List<? extends Box> list) {
        super.setBoxes(list);
        this.sampleTableBox = null;
    }
}
