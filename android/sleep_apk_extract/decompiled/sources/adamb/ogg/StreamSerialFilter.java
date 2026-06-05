package adamb.ogg;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes.dex */
public class StreamSerialFilter implements LogicalPageStream {
    private int correctSerialNumber;
    private boolean haveSerialNumber;
    private PageStream ps;
    private boolean throwUponForeignPages;

    public StreamSerialFilter(PageStream pageStream, boolean z, Integer num) {
        this.ps = pageStream;
        if (num != null) {
            this.haveSerialNumber = true;
            this.correctSerialNumber = num.intValue();
        } else {
            this.haveSerialNumber = false;
        }
        this.throwUponForeignPages = z;
    }

    @Override // adamb.ogg.PageStream
    public Page next() throws ForeignPageException {
        Page next;
        do {
            next = this.ps.next();
            if (next == null) {
                return null;
            }
            boolean z = this.haveSerialNumber;
            int i = next.streamSerialNumber;
            if (!z) {
                this.correctSerialNumber = i;
                this.haveSerialNumber = true;
                return next;
            }
            if (i == this.correctSerialNumber) {
                return next;
            }
        } while (!this.throwUponForeignPages);
        StringBuilder sb = new StringBuilder("Found Ogg page from a different stream, #");
        sb.append(next.streamSerialNumber);
        sb.append("; expected #");
        throw new ForeignPageException(FileInsert$$ExternalSyntheticOutline0.m(this.correctSerialNumber, "!", sb));
    }

    public StreamSerialFilter(PageStream pageStream, boolean z) {
        this(pageStream, z, null);
    }
}
