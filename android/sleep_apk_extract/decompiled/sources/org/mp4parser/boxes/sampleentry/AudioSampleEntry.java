package org.mp4parser.boxes.sampleentry;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.Box;
import org.mp4parser.BoxParser;
import org.mp4parser.tools.CastUtils;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class AudioSampleEntry extends AbstractSampleEntry {
    private static Logger LOG = LoggerFactory.getLogger((Class<?>) AudioSampleEntry.class);
    public static final String TYPE1 = "samr";
    public static final String TYPE10 = "mlpa";
    public static final String TYPE11 = "dtsl";
    public static final String TYPE12 = "dtsh";
    public static final String TYPE13 = "dtse";
    public static final String TYPE2 = "sawb";
    public static final String TYPE3 = "mp4a";
    public static final String TYPE4 = "drms";
    public static final String TYPE5 = "alac";
    public static final String TYPE7 = "owma";
    public static final String TYPE8 = "ac-3";
    public static final String TYPE9 = "ec-3";
    public static final String TYPE_ENCRYPTED = "enca";
    private long bytesPerFrame;
    private long bytesPerPacket;
    private long bytesPerSample;
    private int channelCount;
    private int compressionId;
    private int packetSize;
    private int reserved1;
    private long reserved2;
    private long sampleRate;
    private int sampleSize;
    private long samplesPerPacket;
    private int soundVersion;
    private byte[] soundVersion2Data;

    public AudioSampleEntry(String str) {
        super(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AudioSampleEntry.class == obj.getClass()) {
            AudioSampleEntry audioSampleEntry = (AudioSampleEntry) obj;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                getBox(Channels.newChannel(byteArrayOutputStream));
                try {
                    audioSampleEntry.getBox(Channels.newChannel(byteArrayOutputStream2));
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
        int i = this.soundVersion;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((i == 1 ? 16 : 0) + 28 + (i == 2 ? 36 : 0));
        byteBufferAllocate.position(6);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.dataReferenceIndex);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.soundVersion);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.reserved1);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.reserved2);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.channelCount);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.sampleSize);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.compressionId);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.packetSize);
        if (this.type.equals(TYPE10)) {
            IsoTypeWriter.writeUInt32(byteBufferAllocate, getSampleRate());
        } else {
            IsoTypeWriter.writeUInt32(byteBufferAllocate, getSampleRate() << 16);
        }
        if (this.soundVersion == 1) {
            IsoTypeWriter.writeUInt32(byteBufferAllocate, this.samplesPerPacket);
            IsoTypeWriter.writeUInt32(byteBufferAllocate, this.bytesPerPacket);
            IsoTypeWriter.writeUInt32(byteBufferAllocate, this.bytesPerFrame);
            IsoTypeWriter.writeUInt32(byteBufferAllocate, this.bytesPerSample);
        }
        if (this.soundVersion == 2) {
            IsoTypeWriter.writeUInt32(byteBufferAllocate, this.samplesPerPacket);
            IsoTypeWriter.writeUInt32(byteBufferAllocate, this.bytesPerPacket);
            IsoTypeWriter.writeUInt32(byteBufferAllocate, this.bytesPerFrame);
            IsoTypeWriter.writeUInt32(byteBufferAllocate, this.bytesPerSample);
            byteBufferAllocate.put(this.soundVersion2Data);
        }
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        writeContainer(writableByteChannel);
    }

    public long getBytesPerFrame() {
        return this.bytesPerFrame;
    }

    public long getBytesPerPacket() {
        return this.bytesPerPacket;
    }

    public long getBytesPerSample() {
        return this.bytesPerSample;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    public int getCompressionId() {
        return this.compressionId;
    }

    public int getPacketSize() {
        return this.packetSize;
    }

    public int getReserved1() {
        return this.reserved1;
    }

    public long getReserved2() {
        return this.reserved2;
    }

    public long getSampleRate() {
        return this.sampleRate;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public long getSamplesPerPacket() {
        return this.samplesPerPacket;
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public long getSize() {
        int i = this.soundVersion;
        int i2 = 16;
        long containerSize = getContainerSize() + ((long) ((i == 1 ? 16 : 0) + 28 + (i == 2 ? 36 : 0)));
        if (!this.largeBox && 8 + containerSize < 4294967296L) {
            i2 = 8;
        }
        return containerSize + ((long) i2);
    }

    public int getSoundVersion() {
        return this.soundVersion;
    }

    public byte[] getSoundVersion2Data() {
        return this.soundVersion2Data;
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
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(28);
        readableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.soundVersion = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.reserved1 = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.reserved2 = IsoTypeReader.readUInt32(byteBufferAllocate);
        this.channelCount = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.sampleSize = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.compressionId = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.packetSize = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.sampleRate = IsoTypeReader.readUInt32(byteBufferAllocate);
        if (!this.type.equals(TYPE10)) {
            this.sampleRate >>>= 16;
        }
        if (this.soundVersion == 1) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(16);
            readableByteChannel.read(byteBufferAllocate2);
            byteBufferAllocate2.rewind();
            this.samplesPerPacket = IsoTypeReader.readUInt32(byteBufferAllocate2);
            this.bytesPerPacket = IsoTypeReader.readUInt32(byteBufferAllocate2);
            this.bytesPerFrame = IsoTypeReader.readUInt32(byteBufferAllocate2);
            this.bytesPerSample = IsoTypeReader.readUInt32(byteBufferAllocate2);
        }
        if (this.soundVersion == 2) {
            ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(36);
            readableByteChannel.read(byteBufferAllocate3);
            byteBufferAllocate3.rewind();
            this.samplesPerPacket = IsoTypeReader.readUInt32(byteBufferAllocate3);
            this.bytesPerPacket = IsoTypeReader.readUInt32(byteBufferAllocate3);
            this.bytesPerFrame = IsoTypeReader.readUInt32(byteBufferAllocate3);
            this.bytesPerSample = IsoTypeReader.readUInt32(byteBufferAllocate3);
            byte[] bArr = new byte[20];
            this.soundVersion2Data = bArr;
            byteBufferAllocate3.get(bArr);
        }
        if (!TYPE7.equals(this.type)) {
            long j2 = j - 28;
            int i = this.soundVersion;
            initContainer(readableByteChannel, (j2 - ((long) (i != 1 ? 0 : 16))) - ((long) (i != 2 ? 0 : 36)), boxParser);
            return;
        }
        LOG.error(TYPE7);
        long j3 = j - 28;
        int i2 = this.soundVersion;
        final long j4 = (j3 - ((long) (i2 != 1 ? 0 : 16))) - ((long) (i2 != 2 ? 0 : 36));
        final ByteBuffer byteBufferAllocate4 = ByteBuffer.allocate(CastUtils.l2i(j4));
        readableByteChannel.read(byteBufferAllocate4);
        addBox(new Box() { // from class: org.mp4parser.boxes.sampleentry.AudioSampleEntry.1
            @Override // org.mp4parser.Box
            public void getBox(WritableByteChannel writableByteChannel) throws IOException {
                byteBufferAllocate4.rewind();
                writableByteChannel.write(byteBufferAllocate4);
            }

            @Override // org.mp4parser.Box
            public long getSize() {
                return j4;
            }

            @Override // org.mp4parser.Box
            public String getType() {
                return "----";
            }
        });
    }

    public void setBytesPerFrame(long j) {
        this.bytesPerFrame = j;
    }

    public void setBytesPerPacket(long j) {
        this.bytesPerPacket = j;
    }

    public void setBytesPerSample(long j) {
        this.bytesPerSample = j;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public void setCompressionId(int i) {
        this.compressionId = i;
    }

    public void setPacketSize(int i) {
        this.packetSize = i;
    }

    public void setReserved1(int i) {
        this.reserved1 = i;
    }

    public void setReserved2(long j) {
        this.reserved2 = j;
    }

    public void setSampleRate(long j) {
        this.sampleRate = j;
    }

    public void setSampleSize(int i) {
        this.sampleSize = i;
    }

    public void setSamplesPerPacket(long j) {
        this.samplesPerPacket = j;
    }

    public void setSoundVersion(int i) {
        this.soundVersion = i;
    }

    public void setSoundVersion2Data(byte[] bArr) {
        this.soundVersion2Data = bArr;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // org.mp4parser.BasicContainer
    public String toString() {
        return "AudioSampleEntry{bytesPerSample=" + this.bytesPerSample + ", bytesPerFrame=" + this.bytesPerFrame + ", bytesPerPacket=" + this.bytesPerPacket + ", samplesPerPacket=" + this.samplesPerPacket + ", packetSize=" + this.packetSize + ", compressionId=" + this.compressionId + ", soundVersion=" + this.soundVersion + ", sampleRate=" + this.sampleRate + ", sampleSize=" + this.sampleSize + ", channelCount=" + this.channelCount + ", boxes=" + getBoxes() + '}';
    }
}
