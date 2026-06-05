package org.mp4parser.boxes.iso14496.part12;

import org.mp4parser.support.AbstractContainerBox;
import org.mp4parser.tools.Path;

/* JADX INFO: loaded from: classes5.dex */
public class MediaBox extends AbstractContainerBox {
    public static final String TYPE = "mdia";

    public MediaBox() {
        super(TYPE);
    }

    public HandlerBox getHandlerBox() {
        return (HandlerBox) Path.getPath((AbstractContainerBox) this, "hdlr[0]");
    }

    public MediaHeaderBox getMediaHeaderBox() {
        return (MediaHeaderBox) Path.getPath((AbstractContainerBox) this, "mdhd[0]");
    }

    public MediaInformationBox getMediaInformationBox() {
        return (MediaInformationBox) Path.getPath((AbstractContainerBox) this, "minf[0]");
    }
}
