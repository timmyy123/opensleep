package org.mp4parser.boxes.iso14496.part15;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import org.mp4parser.boxes.samplegrouping.GroupEntry;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class SyncSampleEntry extends GroupEntry {
    public static final String TYPE = "sync";
    int nalUnitType;
    int reserved;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SyncSampleEntry syncSampleEntry = (SyncSampleEntry) obj;
        return this.nalUnitType == syncSampleEntry.nalUnitType && this.reserved == syncSampleEntry.reserved;
    }

    @Override // org.mp4parser.boxes.samplegrouping.GroupEntry
    public ByteBuffer get() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1);
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.nalUnitType + (this.reserved << 6));
        return (ByteBuffer) byteBufferAllocate.rewind();
    }

    public int getNalUnitType() {
        return this.nalUnitType;
    }

    public int getReserved() {
        return this.reserved;
    }

    @Override // org.mp4parser.boxes.samplegrouping.GroupEntry
    public String getType() {
        return TYPE;
    }

    public int hashCode() {
        return (this.reserved * 31) + this.nalUnitType;
    }

    @Override // org.mp4parser.boxes.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        int uInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.reserved = (uInt8 & 192) >> 6;
        this.nalUnitType = uInt8 & 63;
    }

    public void setNalUnitType(int i) {
        this.nalUnitType = i;
    }

    public void setReserved(int i) {
        this.reserved = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SyncSampleEntry{reserved=");
        sb.append(this.reserved);
        sb.append(", nalUnitType=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.nalUnitType, '}');
    }
}
