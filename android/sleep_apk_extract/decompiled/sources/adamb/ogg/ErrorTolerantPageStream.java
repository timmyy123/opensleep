package adamb.ogg;

import adamb.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class ErrorTolerantPageStream implements PageStream {
    private PhysicalPageStream pps;

    public ErrorTolerantPageStream(PhysicalPageStream physicalPageStream) {
        if (physicalPageStream.getInputStream().markSupported()) {
            this.pps = physicalPageStream;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m("Given input stream does not support mark and reset operations!");
            throw null;
        }
    }

    @Override // adamb.ogg.PageStream
    public Page next() throws IOException {
        PhysicalPageStream physicalPageStream = this.pps;
        boolean z = false;
        while (true) {
            physicalPageStream.setCaptured(z);
            this.pps.getInputStream().mark(65315);
            try {
                return this.pps.next();
            } catch (ChecksumMismatchException | InvalidHeaderException | EOFException unused) {
                InputStream inputStream = this.pps.getInputStream();
                inputStream.reset();
                inputStream.read();
                if (Util.streamFind(inputStream, PhysicalPageStream.OGG_STREAM_CAPTURE_PATTERN) == -1) {
                    return null;
                }
                physicalPageStream = this.pps;
                z = true;
            }
        }
    }
}
