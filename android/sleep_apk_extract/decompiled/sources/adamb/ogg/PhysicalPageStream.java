package adamb.ogg;

import adamb.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class PhysicalPageStream implements PageStream {
    static final byte[] OGG_STREAM_CAPTURE_PATTERN = {79, 103, 103, 83};
    private InputStream is;
    private OggCRC pageCRC = new OggCRC();
    private boolean haveCapture = false;

    public PhysicalPageStream(InputStream inputStream) {
        this.is = inputStream;
    }

    private boolean readPageFromStream(Page page) throws IOException {
        byte[] bArr = new byte[this.haveCapture ? 27 - OGG_STREAM_CAPTURE_PATTERN.length : 27];
        int completely = Util.readCompletely(this.is, bArr);
        if (completely != bArr.length) {
            if (completely == 0) {
                return false;
            }
            throw new EOFException("partial header due to eos");
        }
        int fixedHeaderValues = page.parseFixedHeaderValues(bArr);
        byte[] bArr2 = new byte[fixedHeaderValues];
        if (Util.readCompletely(this.is, bArr2) != fixedHeaderValues) {
            throw new EOFException("partial segment table due to eos");
        }
        byte[] bArr3 = new byte[page.parseSegmentTable(bArr2)];
        page.content = bArr3;
        if (Util.readCompletely(this.is, bArr3) != page.content.length) {
            throw new EOFException("partial page content due to eos");
        }
        this.pageCRC.reset();
        if (this.haveCapture) {
            this.pageCRC.update(OGG_STREAM_CAPTURE_PATTERN);
        }
        System.arraycopy(new byte[4], 0, bArr, this.haveCapture ? 22 - OGG_STREAM_CAPTURE_PATTERN.length : 22, 4);
        this.pageCRC.update(bArr);
        this.pageCRC.update(bArr2);
        this.pageCRC.update(page.content);
        return true;
    }

    public InputStream getInputStream() {
        return this.is;
    }

    @Override // adamb.ogg.PageStream
    public Page next() throws ChecksumMismatchException {
        Page page = new Page();
        if (!readPageFromStream(page)) {
            return null;
        }
        if (page.checksum == this.pageCRC.getValue()) {
            return page;
        }
        throw new ChecksumMismatchException();
    }

    public void setCaptured(boolean z) {
        this.haveCapture = z;
    }
}
