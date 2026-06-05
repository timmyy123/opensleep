package org.mp4parser.boxes.sampleentry;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.BoxParser;
import org.mp4parser.Container;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;
import org.mp4parser.tools.Utf8;

/* JADX INFO: loaded from: classes5.dex */
public final class VisualSampleEntry extends AbstractSampleEntry implements Container {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE1 = "mp4v";
    public static final String TYPE2 = "s263";
    public static final String TYPE3 = "avc1";
    public static final String TYPE4 = "avc3";
    public static final String TYPE5 = "drmi";
    public static final String TYPE6 = "hvc1";
    public static final String TYPE7 = "hev1";
    public static final String TYPE_ENCRYPTED = "encv";
    private String compressorname;
    private int depth;
    private int frameCount;
    private int height;
    private double horizresolution;
    private long[] predefined;
    private double vertresolution;
    private int width;

    public VisualSampleEntry() {
        super(TYPE3);
        this.horizresolution = 72.0d;
        this.vertresolution = 72.0d;
        this.frameCount = 1;
        this.compressorname = "";
        this.depth = 24;
        this.predefined = new long[3];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && VisualSampleEntry.class == obj.getClass()) {
            VisualSampleEntry visualSampleEntry = (VisualSampleEntry) obj;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                getBox(Channels.newChannel(byteArrayOutputStream));
                try {
                    visualSampleEntry.getBox(Channels.newChannel(byteArrayOutputStream2));
                    return Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray());
                } catch (IOException e) {
                    Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                    return false;
                }
            } catch (IOException e2) {
                Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e2);
            }
        }
        return false;
    }

    @Override // org.mp4parser.boxes.sampleentry.AbstractSampleEntry, org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(78);
        byteBufferAllocate.position(6);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.dataReferenceIndex);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, 0);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, 0);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.predefined[0]);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.predefined[1]);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.predefined[2]);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, getWidth());
        IsoTypeWriter.writeUInt16(byteBufferAllocate, getHeight());
        IsoTypeWriter.writeFixedPoint1616(byteBufferAllocate, getHorizresolution());
        IsoTypeWriter.writeFixedPoint1616(byteBufferAllocate, getVertresolution());
        IsoTypeWriter.writeUInt32(byteBufferAllocate, 0L);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, getFrameCount());
        IsoTypeWriter.writeUInt8(byteBufferAllocate, Utf8.utf8StringLengthInBytes(getCompressorname()));
        byteBufferAllocate.put(Utf8.convert(getCompressorname()));
        int iUtf8StringLengthInBytes = Utf8.utf8StringLengthInBytes(getCompressorname());
        while (iUtf8StringLengthInBytes < 31) {
            iUtf8StringLengthInBytes++;
            byteBufferAllocate.put((byte) 0);
        }
        IsoTypeWriter.writeUInt16(byteBufferAllocate, getDepth());
        IsoTypeWriter.writeUInt16(byteBufferAllocate, 65535);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        writeContainer(writableByteChannel);
    }

    public String getCompressorname() {
        return this.compressorname;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public int getHeight() {
        return this.height;
    }

    public double getHorizresolution() {
        return this.horizresolution;
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public long getSize() {
        long containerSize = getContainerSize();
        return 78 + containerSize + ((long) ((this.largeBox || containerSize + 86 >= 4294967296L) ? 16 : 8));
    }

    public double getVertresolution() {
        return this.vertresolution;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            getBox(Channels.newChannel(byteArrayOutputStream));
            return Arrays.hashCode(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return 0;
        }
    }

    @Override // org.mp4parser.boxes.sampleentry.AbstractSampleEntry, org.mp4parser.support.AbstractContainerBox, org.mp4parser.ParsableBox
    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(78);
        readableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBufferAllocate);
        IsoTypeReader.readUInt16(byteBufferAllocate);
        IsoTypeReader.readUInt16(byteBufferAllocate);
        this.predefined[0] = IsoTypeReader.readUInt32(byteBufferAllocate);
        this.predefined[1] = IsoTypeReader.readUInt32(byteBufferAllocate);
        this.predefined[2] = IsoTypeReader.readUInt32(byteBufferAllocate);
        this.width = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.height = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.horizresolution = IsoTypeReader.readFixedPoint1616(byteBufferAllocate);
        this.vertresolution = IsoTypeReader.readFixedPoint1616(byteBufferAllocate);
        IsoTypeReader.readUInt32(byteBufferAllocate);
        this.frameCount = IsoTypeReader.readUInt16(byteBufferAllocate);
        int uInt8 = IsoTypeReader.readUInt8(byteBufferAllocate);
        if (uInt8 > 31) {
            uInt8 = 31;
        }
        byte[] bArr = new byte[uInt8];
        byteBufferAllocate.get(bArr);
        this.compressorname = Utf8.convert(bArr);
        if (uInt8 < 31) {
            byteBufferAllocate.get(new byte[31 - uInt8]);
        }
        this.depth = IsoTypeReader.readUInt16(byteBufferAllocate);
        IsoTypeReader.readUInt16(byteBufferAllocate);
        initContainer(readableByteChannel, j - 78, boxParser);
    }

    public void setCompressorname(String str) {
        this.compressorname = str;
    }

    public void setDepth(int i) {
        this.depth = i;
    }

    public void setFrameCount(int i) {
        this.frameCount = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setHorizresolution(double d) {
        this.horizresolution = d;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVertresolution(double d) {
        this.vertresolution = d;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public VisualSampleEntry(String str) {
        super(str);
        this.horizresolution = 72.0d;
        this.vertresolution = 72.0d;
        this.frameCount = 1;
        this.compressorname = "";
        this.depth = 24;
        this.predefined = new long[3];
    }
}
