package adamb.ogg;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class OggIO {
    public static void writePageToStream(Page page, OutputStream outputStream, OggCRC oggCRC) throws IOException {
        if (page.calculateContentSizeFromSegments() != page.content.length) {
            OggIO$$ExternalSyntheticBUOutline0.m("Incorrect Ogg page segmentation!  Computed size does not match size of content array.");
            return;
        }
        oggCRC.reset();
        page.checksum = 0;
        oggCRC.update(page.getFixedHeaderBytes());
        byte[] segmentTableBytes = page.getSegmentTableBytes();
        oggCRC.update(segmentTableBytes);
        oggCRC.update(page.content);
        page.checksum = oggCRC.getValue();
        outputStream.write(page.getFixedHeaderBytes());
        outputStream.write(segmentTableBytes);
        outputStream.write(page.content);
    }
}
