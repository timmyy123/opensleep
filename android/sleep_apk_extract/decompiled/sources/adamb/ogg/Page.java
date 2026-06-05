package adamb.ogg;

import adamb.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Page {
    public long absGranulePos;
    public int checksum;
    public byte[] content;
    public boolean isContinued;
    public boolean isFirst;
    public boolean isLast;
    public int sequence;
    public int streamSerialNumber;
    public ArrayList<Segment> segments = new ArrayList<>(32);
    public int streamStructureVersion = 0;

    public int calculateContentSizeFromSegments() {
        Iterator<Segment> it = this.segments.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [byte] */
    public byte[] getFixedHeaderBytes() {
        byte[] bArr = new byte[27];
        ?? Wrap = ByteBuffer.wrap(bArr);
        Wrap.order(ByteOrder.LITTLE_ENDIAN);
        Wrap.put(PhysicalPageStream.OGG_STREAM_CAPTURE_PATTERN);
        Wrap.put(Util.ubyte(this.streamStructureVersion));
        ?? r2 = this.isContinued;
        ?? r22 = r2;
        if (this.isFirst) {
            r22 = (byte) (r2 | 2);
        }
        ?? r23 = r22;
        if (this.isLast) {
            r23 = (byte) (r22 | 4);
        }
        Wrap.put(r23);
        Wrap.putLong(this.absGranulePos);
        Wrap.putInt(this.streamSerialNumber);
        Wrap.putInt(this.sequence);
        Wrap.putInt(this.checksum);
        Wrap.put(Util.ubyte(this.segments.size()));
        return bArr;
    }

    public byte[] getSegmentTableBytes() {
        int size = this.segments.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = Util.ubyte(this.segments.get(i).size());
        }
        return bArr;
    }

    public int parseFixedHeaderValues(byte[] bArr) throws InvalidHeaderException {
        boolean z = bArr.length == 27;
        if (z && !Util.startsWith(bArr, PhysicalPageStream.OGG_STREAM_CAPTURE_PATTERN)) {
            throw new InvalidHeaderException("Ogg page does not begin with \"OggS\"!");
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        if (z) {
            byteBufferWrap.position(PhysicalPageStream.OGG_STREAM_CAPTURE_PATTERN.length);
        }
        int iUbyte = Util.ubyte(byteBufferWrap.get());
        this.streamStructureVersion = iUbyte;
        if (iUbyte != 0) {
            throw new InvalidHeaderException("Wrong Ogg stream structure revision " + this.streamStructureVersion);
        }
        int iUbyte2 = Util.ubyte(byteBufferWrap.get());
        this.isContinued = (iUbyte2 & 1) > 0;
        this.isFirst = (iUbyte2 & 2) > 0;
        this.isLast = (iUbyte2 & 4) > 0;
        this.absGranulePos = byteBufferWrap.getLong();
        this.streamSerialNumber = byteBufferWrap.getInt();
        this.sequence = byteBufferWrap.getInt();
        this.checksum = byteBufferWrap.getInt();
        return Util.ubyte(byteBufferWrap.get());
    }

    public int parseSegmentTable(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            int iUbyte = Util.ubyte(b);
            this.segments.add(new Segment(this, i, iUbyte));
            i += iUbyte;
        }
        return i;
    }

    public int size() {
        return this.segments.size() + 27 + this.content.length;
    }
}
