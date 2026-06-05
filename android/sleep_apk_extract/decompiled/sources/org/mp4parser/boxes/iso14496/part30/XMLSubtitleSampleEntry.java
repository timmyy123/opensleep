package org.mp4parser.boxes.iso14496.part30;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.BoxParser;
import org.mp4parser.boxes.sampleentry.AbstractSampleEntry;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;
import org.mp4parser.tools.Mp4Arrays;
import org.mp4parser.tools.Utf8;

/* JADX INFO: loaded from: classes5.dex */
public class XMLSubtitleSampleEntry extends AbstractSampleEntry {
    public static final String TYPE = "stpp";
    private String auxiliaryMimeTypes;
    private String namespace;
    private String schemaLocation;

    public XMLSubtitleSampleEntry() {
        super(TYPE);
        this.namespace = "";
        this.schemaLocation = "";
        this.auxiliaryMimeTypes = "";
    }

    public String getAuxiliaryMimeTypes() {
        return this.auxiliaryMimeTypes;
    }

    @Override // org.mp4parser.boxes.sampleentry.AbstractSampleEntry, org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.auxiliaryMimeTypes.length() + this.schemaLocation.length() + this.namespace.length() + 8 + 3);
        byteBufferAllocate.position(6);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.dataReferenceIndex);
        IsoTypeWriter.writeZeroTermUtf8String(byteBufferAllocate, this.namespace);
        IsoTypeWriter.writeZeroTermUtf8String(byteBufferAllocate, this.schemaLocation);
        IsoTypeWriter.writeZeroTermUtf8String(byteBufferAllocate, this.auxiliaryMimeTypes);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        writeContainer(writableByteChannel);
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getSchemaLocation() {
        return this.schemaLocation;
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public long getSize() {
        long containerSize = getContainerSize() + ((long) zzba$$ExternalSyntheticOutline0.m(this.schemaLocation.length() + this.namespace.length() + 8, 3, this.auxiliaryMimeTypes));
        return containerSize + ((long) ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 8));
    }

    @Override // org.mp4parser.boxes.sampleentry.AbstractSampleEntry, org.mp4parser.support.AbstractContainerBox, org.mp4parser.ParsableBox
    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        readableByteChannel.read((ByteBuffer) byteBufferAllocate.rewind());
        byteBufferAllocate.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBufferAllocate);
        byte[] bArrCopyOfAndAppend = new byte[0];
        while (true) {
            int i = Channels.newInputStream(readableByteChannel).read();
            if (i == 0) {
                break;
            } else {
                bArrCopyOfAndAppend = Mp4Arrays.copyOfAndAppend(bArrCopyOfAndAppend, (byte) i);
            }
        }
        this.namespace = Utf8.convert(bArrCopyOfAndAppend);
        byte[] bArrCopyOfAndAppend2 = new byte[0];
        while (true) {
            int i2 = Channels.newInputStream(readableByteChannel).read();
            if (i2 == 0) {
                break;
            } else {
                bArrCopyOfAndAppend2 = Mp4Arrays.copyOfAndAppend(bArrCopyOfAndAppend2, (byte) i2);
            }
        }
        this.schemaLocation = Utf8.convert(bArrCopyOfAndAppend2);
        byte[] bArrCopyOfAndAppend3 = new byte[0];
        while (true) {
            int i3 = Channels.newInputStream(readableByteChannel).read();
            if (i3 == 0) {
                this.auxiliaryMimeTypes = Utf8.convert(bArrCopyOfAndAppend3);
                initContainer(readableByteChannel, j - ((long) zzba$$ExternalSyntheticOutline0.m(this.schemaLocation.length() + (this.namespace.length() + byteBuffer.remaining()), 3, this.auxiliaryMimeTypes)), boxParser);
                return;
            }
            bArrCopyOfAndAppend3 = Mp4Arrays.copyOfAndAppend(bArrCopyOfAndAppend3, (byte) i3);
        }
    }

    public void setAuxiliaryMimeTypes(String str) {
        this.auxiliaryMimeTypes = str;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void setSchemaLocation(String str) {
        this.schemaLocation = str;
    }
}
