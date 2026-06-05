package adamb.ogg;

/* JADX INFO: loaded from: classes.dex */
public class Segment {
    private int pageOffset;
    private int size;
    private Page sourcePage;

    public Segment(Page page, int i, int i2) {
        this.sourcePage = page;
        this.pageOffset = i;
        this.size = i2;
    }

    public int getBytes(byte[] bArr, int i) {
        System.arraycopy(this.sourcePage.content, this.pageOffset, bArr, i, this.size);
        return this.size;
    }

    public Page getSourcePage() {
        return this.sourcePage;
    }

    public boolean isLast() {
        return this.size < 255;
    }

    public int size() {
        return this.size;
    }
}
