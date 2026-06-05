package org.mp4parser.boxes.iso14496.part15;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;
import org.mp4parser.tools.Hex;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class AvcDecoderConfigurationRecord {
    public int avcLevelIndication;
    public int avcProfileIndication;
    public int bitDepthChromaMinus8;
    public int bitDepthChromaMinus8PaddingBits;
    public int bitDepthLumaMinus8;
    public int bitDepthLumaMinus8PaddingBits;
    public int chromaFormat;
    public int chromaFormatPaddingBits;
    public int configurationVersion;
    public boolean hasExts;
    public int lengthSizeMinusOne;
    public int lengthSizeMinusOnePaddingBits;
    public int numberOfSequenceParameterSetsPaddingBits;
    public List<ByteBuffer> pictureParameterSets;
    public int profileCompatibility;
    public List<ByteBuffer> sequenceParameterSetExts;
    public List<ByteBuffer> sequenceParameterSets;

    public AvcDecoderConfigurationRecord(ByteBuffer byteBuffer) {
        int i;
        this.sequenceParameterSets = new ArrayList();
        this.pictureParameterSets = new ArrayList();
        this.hasExts = true;
        this.chromaFormat = 1;
        this.bitDepthLumaMinus8 = 0;
        this.bitDepthChromaMinus8 = 0;
        this.sequenceParameterSetExts = new ArrayList();
        this.lengthSizeMinusOnePaddingBits = 63;
        this.numberOfSequenceParameterSetsPaddingBits = 7;
        this.chromaFormatPaddingBits = 31;
        this.bitDepthLumaMinus8PaddingBits = 31;
        this.bitDepthChromaMinus8PaddingBits = 31;
        this.configurationVersion = IsoTypeReader.readUInt8(byteBuffer);
        this.avcProfileIndication = IsoTypeReader.readUInt8(byteBuffer);
        this.profileCompatibility = IsoTypeReader.readUInt8(byteBuffer);
        this.avcLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.lengthSizeMinusOnePaddingBits = bitReaderBuffer.readBits(6);
        this.lengthSizeMinusOne = bitReaderBuffer.readBits(2);
        this.numberOfSequenceParameterSetsPaddingBits = bitReaderBuffer.readBits(3);
        int bits = bitReaderBuffer.readBits(5);
        for (int i2 = 0; i2 < bits; i2++) {
            byte[] bArr = new byte[IsoTypeReader.readUInt16(byteBuffer)];
            byteBuffer.get(bArr);
            this.sequenceParameterSets.add(ByteBuffer.wrap(bArr));
        }
        long uInt8 = IsoTypeReader.readUInt8(byteBuffer);
        for (int i3 = 0; i3 < uInt8; i3++) {
            byte[] bArr2 = new byte[IsoTypeReader.readUInt16(byteBuffer)];
            byteBuffer.get(bArr2);
            this.pictureParameterSets.add(ByteBuffer.wrap(bArr2));
        }
        if (byteBuffer.remaining() < 4) {
            this.hasExts = false;
        }
        if (!this.hasExts || ((i = this.avcProfileIndication) != 100 && i != 110 && i != 122 && i != 144)) {
            this.chromaFormat = -1;
            this.bitDepthLumaMinus8 = -1;
            this.bitDepthChromaMinus8 = -1;
            return;
        }
        BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
        this.chromaFormatPaddingBits = bitReaderBuffer2.readBits(6);
        this.chromaFormat = bitReaderBuffer2.readBits(2);
        this.bitDepthLumaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
        this.bitDepthLumaMinus8 = bitReaderBuffer2.readBits(3);
        this.bitDepthChromaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
        this.bitDepthChromaMinus8 = bitReaderBuffer2.readBits(3);
        long uInt82 = IsoTypeReader.readUInt8(byteBuffer);
        for (int i4 = 0; i4 < uInt82; i4++) {
            byte[] bArr3 = new byte[IsoTypeReader.readUInt16(byteBuffer)];
            byteBuffer.get(bArr3);
            this.sequenceParameterSetExts.add(ByteBuffer.wrap(bArr3));
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt8(byteBuffer, this.configurationVersion);
        IsoTypeWriter.writeUInt8(byteBuffer, this.avcProfileIndication);
        IsoTypeWriter.writeUInt8(byteBuffer, this.profileCompatibility);
        IsoTypeWriter.writeUInt8(byteBuffer, this.avcLevelIndication);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.lengthSizeMinusOnePaddingBits, 6);
        bitWriterBuffer.writeBits(this.lengthSizeMinusOne, 2);
        bitWriterBuffer.writeBits(this.numberOfSequenceParameterSetsPaddingBits, 3);
        bitWriterBuffer.writeBits(this.sequenceParameterSets.size(), 5);
        for (ByteBuffer byteBuffer2 : this.sequenceParameterSets) {
            IsoTypeWriter.writeUInt16(byteBuffer, byteBuffer2.limit());
            byteBuffer.put((ByteBuffer) byteBuffer2.rewind());
        }
        IsoTypeWriter.writeUInt8(byteBuffer, this.pictureParameterSets.size());
        for (ByteBuffer byteBuffer3 : this.pictureParameterSets) {
            IsoTypeWriter.writeUInt16(byteBuffer, byteBuffer3.limit());
            byteBuffer.put((ByteBuffer) byteBuffer3.rewind());
        }
        if (this.hasExts) {
            int i = this.avcProfileIndication;
            if (i == 100 || i == 110 || i == 122 || i == 144) {
                BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
                bitWriterBuffer2.writeBits(this.chromaFormatPaddingBits, 6);
                bitWriterBuffer2.writeBits(this.chromaFormat, 2);
                bitWriterBuffer2.writeBits(this.bitDepthLumaMinus8PaddingBits, 5);
                bitWriterBuffer2.writeBits(this.bitDepthLumaMinus8, 3);
                bitWriterBuffer2.writeBits(this.bitDepthChromaMinus8PaddingBits, 5);
                bitWriterBuffer2.writeBits(this.bitDepthChromaMinus8, 3);
                for (ByteBuffer byteBuffer4 : this.sequenceParameterSetExts) {
                    IsoTypeWriter.writeUInt16(byteBuffer, byteBuffer4.limit());
                    byteBuffer.put((ByteBuffer) byteBuffer4.reset());
                }
            }
        }
    }

    public long getContentSize() {
        int i;
        Iterator<ByteBuffer> it = this.sequenceParameterSets.iterator();
        long jLimit = 6;
        while (it.hasNext()) {
            jLimit = jLimit + 2 + ((long) it.next().limit());
        }
        long jLimit2 = jLimit + 1;
        Iterator<ByteBuffer> it2 = this.pictureParameterSets.iterator();
        while (it2.hasNext()) {
            jLimit2 = jLimit2 + 2 + ((long) it2.next().limit());
        }
        if (!this.hasExts || ((i = this.avcProfileIndication) != 100 && i != 110 && i != 122 && i != 144)) {
            return jLimit2;
        }
        long jLimit3 = jLimit2 + 4;
        Iterator<ByteBuffer> it3 = this.sequenceParameterSetExts.iterator();
        while (it3.hasNext()) {
            jLimit3 = jLimit3 + 2 + ((long) it3.next().limit());
        }
        return jLimit3;
    }

    public List<String> getPictureParameterSetsAsStrings() {
        ArrayList arrayList = new ArrayList(this.pictureParameterSets.size());
        Iterator<ByteBuffer> it = this.pictureParameterSets.iterator();
        while (it.hasNext()) {
            arrayList.add(Hex.encodeHex(it.next()));
        }
        return arrayList;
    }

    public List<String> getSequenceParameterSetExtsAsStrings() {
        ArrayList arrayList = new ArrayList(this.sequenceParameterSetExts.size());
        Iterator<ByteBuffer> it = this.sequenceParameterSetExts.iterator();
        while (it.hasNext()) {
            arrayList.add(Hex.encodeHex(it.next()));
        }
        return arrayList;
    }

    public List<String> getSequenceParameterSetsAsStrings() {
        ArrayList arrayList = new ArrayList(this.sequenceParameterSets.size());
        Iterator<ByteBuffer> it = this.sequenceParameterSets.iterator();
        while (it.hasNext()) {
            arrayList.add(Hex.encodeHex(it.next()));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AvcDecoderConfigurationRecord{configurationVersion=");
        sb.append(this.configurationVersion);
        sb.append(", avcProfileIndication=");
        sb.append(this.avcProfileIndication);
        sb.append(", profileCompatibility=");
        sb.append(this.profileCompatibility);
        sb.append(", avcLevelIndication=");
        sb.append(this.avcLevelIndication);
        sb.append(", lengthSizeMinusOne=");
        sb.append(this.lengthSizeMinusOne);
        sb.append(", hasExts=");
        sb.append(this.hasExts);
        sb.append(", chromaFormat=");
        sb.append(this.chromaFormat);
        sb.append(", bitDepthLumaMinus8=");
        sb.append(this.bitDepthLumaMinus8);
        sb.append(", bitDepthChromaMinus8=");
        sb.append(this.bitDepthChromaMinus8);
        sb.append(", lengthSizeMinusOnePaddingBits=");
        sb.append(this.lengthSizeMinusOnePaddingBits);
        sb.append(", numberOfSequenceParameterSetsPaddingBits=");
        sb.append(this.numberOfSequenceParameterSetsPaddingBits);
        sb.append(", chromaFormatPaddingBits=");
        sb.append(this.chromaFormatPaddingBits);
        sb.append(", bitDepthLumaMinus8PaddingBits=");
        sb.append(this.bitDepthLumaMinus8PaddingBits);
        sb.append(", bitDepthChromaMinus8PaddingBits=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.bitDepthChromaMinus8PaddingBits, '}');
    }

    public AvcDecoderConfigurationRecord() {
        this.sequenceParameterSets = new ArrayList();
        this.pictureParameterSets = new ArrayList();
        this.hasExts = true;
        this.chromaFormat = 1;
        this.bitDepthLumaMinus8 = 0;
        this.bitDepthChromaMinus8 = 0;
        this.sequenceParameterSetExts = new ArrayList();
        this.lengthSizeMinusOnePaddingBits = 63;
        this.numberOfSequenceParameterSetsPaddingBits = 7;
        this.chromaFormatPaddingBits = 31;
        this.bitDepthLumaMinus8PaddingBits = 31;
        this.bitDepthChromaMinus8PaddingBits = 31;
    }
}
