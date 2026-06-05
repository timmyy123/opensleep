package org.mp4parser.boxes.iso14496.part15;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import org.mp4parser.boxes.samplegrouping.GroupEntry;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class TemporalLayerSampleGroup extends GroupEntry {
    public static final String TYPE = "tscl";
    int temporalLayerId;
    int tlAvgBitRate;
    int tlAvgFrameRate;
    int tlConstantFrameRate;
    int tlMaxBitRate;
    long tlconstraint_indicator_flags;
    int tllevel_idc;
    long tlprofile_compatibility_flags;
    int tlprofile_idc;
    int tlprofile_space;
    boolean tltier_flag;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TemporalLayerSampleGroup temporalLayerSampleGroup = (TemporalLayerSampleGroup) obj;
        return this.temporalLayerId == temporalLayerSampleGroup.temporalLayerId && this.tlAvgBitRate == temporalLayerSampleGroup.tlAvgBitRate && this.tlAvgFrameRate == temporalLayerSampleGroup.tlAvgFrameRate && this.tlConstantFrameRate == temporalLayerSampleGroup.tlConstantFrameRate && this.tlMaxBitRate == temporalLayerSampleGroup.tlMaxBitRate && this.tlconstraint_indicator_flags == temporalLayerSampleGroup.tlconstraint_indicator_flags && this.tllevel_idc == temporalLayerSampleGroup.tllevel_idc && this.tlprofile_compatibility_flags == temporalLayerSampleGroup.tlprofile_compatibility_flags && this.tlprofile_idc == temporalLayerSampleGroup.tlprofile_idc && this.tlprofile_space == temporalLayerSampleGroup.tlprofile_space && this.tltier_flag == temporalLayerSampleGroup.tltier_flag;
    }

    @Override // org.mp4parser.boxes.samplegrouping.GroupEntry
    public ByteBuffer get() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(20);
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.temporalLayerId);
        IsoTypeWriter.writeUInt8(byteBufferAllocate, (this.tlprofile_space << 6) + (this.tltier_flag ? 32 : 0) + this.tlprofile_idc);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.tlprofile_compatibility_flags);
        IsoTypeWriter.writeUInt48(byteBufferAllocate, this.tlconstraint_indicator_flags);
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.tllevel_idc);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.tlMaxBitRate);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.tlAvgBitRate);
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.tlConstantFrameRate);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.tlAvgFrameRate);
        return (ByteBuffer) byteBufferAllocate.rewind();
    }

    public int getTemporalLayerId() {
        return this.temporalLayerId;
    }

    public int getTlAvgBitRate() {
        return this.tlAvgBitRate;
    }

    public int getTlAvgFrameRate() {
        return this.tlAvgFrameRate;
    }

    public int getTlConstantFrameRate() {
        return this.tlConstantFrameRate;
    }

    public int getTlMaxBitRate() {
        return this.tlMaxBitRate;
    }

    public long getTlconstraint_indicator_flags() {
        return this.tlconstraint_indicator_flags;
    }

    public int getTllevel_idc() {
        return this.tllevel_idc;
    }

    public long getTlprofile_compatibility_flags() {
        return this.tlprofile_compatibility_flags;
    }

    public int getTlprofile_idc() {
        return this.tlprofile_idc;
    }

    public int getTlprofile_space() {
        return this.tlprofile_space;
    }

    @Override // org.mp4parser.boxes.samplegrouping.GroupEntry
    public String getType() {
        return TYPE;
    }

    public int hashCode() {
        int i = ((((((this.temporalLayerId * 31) + this.tlprofile_space) * 31) + (this.tltier_flag ? 1 : 0)) * 31) + this.tlprofile_idc) * 31;
        long j = this.tlprofile_compatibility_flags;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.tlconstraint_indicator_flags;
        return ((((((((((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.tllevel_idc) * 31) + this.tlMaxBitRate) * 31) + this.tlAvgBitRate) * 31) + this.tlConstantFrameRate) * 31) + this.tlAvgFrameRate;
    }

    public boolean isTltier_flag() {
        return this.tltier_flag;
    }

    @Override // org.mp4parser.boxes.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        this.temporalLayerId = IsoTypeReader.readUInt8(byteBuffer);
        int uInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.tlprofile_space = (uInt8 & 192) >> 6;
        this.tltier_flag = (uInt8 & 32) > 0;
        this.tlprofile_idc = uInt8 & 31;
        this.tlprofile_compatibility_flags = IsoTypeReader.readUInt32(byteBuffer);
        this.tlconstraint_indicator_flags = IsoTypeReader.readUInt48(byteBuffer);
        this.tllevel_idc = IsoTypeReader.readUInt8(byteBuffer);
        this.tlMaxBitRate = IsoTypeReader.readUInt16(byteBuffer);
        this.tlAvgBitRate = IsoTypeReader.readUInt16(byteBuffer);
        this.tlConstantFrameRate = IsoTypeReader.readUInt8(byteBuffer);
        this.tlAvgFrameRate = IsoTypeReader.readUInt16(byteBuffer);
    }

    public void setTemporalLayerId(int i) {
        this.temporalLayerId = i;
    }

    public void setTlAvgBitRate(int i) {
        this.tlAvgBitRate = i;
    }

    public void setTlAvgFrameRate(int i) {
        this.tlAvgFrameRate = i;
    }

    public void setTlConstantFrameRate(int i) {
        this.tlConstantFrameRate = i;
    }

    public void setTlMaxBitRate(int i) {
        this.tlMaxBitRate = i;
    }

    public void setTlconstraint_indicator_flags(long j) {
        this.tlconstraint_indicator_flags = j;
    }

    public void setTllevel_idc(int i) {
        this.tllevel_idc = i;
    }

    public void setTlprofile_compatibility_flags(long j) {
        this.tlprofile_compatibility_flags = j;
    }

    public void setTlprofile_idc(int i) {
        this.tlprofile_idc = i;
    }

    public void setTlprofile_space(int i) {
        this.tlprofile_space = i;
    }

    public void setTltier_flag(boolean z) {
        this.tltier_flag = z;
    }

    @Override // org.mp4parser.boxes.samplegrouping.GroupEntry
    public int size() {
        return 20;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TemporalLayerSampleGroup{temporalLayerId=");
        sb.append(this.temporalLayerId);
        sb.append(", tlprofile_space=");
        sb.append(this.tlprofile_space);
        sb.append(", tltier_flag=");
        sb.append(this.tltier_flag);
        sb.append(", tlprofile_idc=");
        sb.append(this.tlprofile_idc);
        sb.append(", tlprofile_compatibility_flags=");
        sb.append(this.tlprofile_compatibility_flags);
        sb.append(", tlconstraint_indicator_flags=");
        sb.append(this.tlconstraint_indicator_flags);
        sb.append(", tllevel_idc=");
        sb.append(this.tllevel_idc);
        sb.append(", tlMaxBitRate=");
        sb.append(this.tlMaxBitRate);
        sb.append(", tlAvgBitRate=");
        sb.append(this.tlAvgBitRate);
        sb.append(", tlConstantFrameRate=");
        sb.append(this.tlConstantFrameRate);
        sb.append(", tlAvgFrameRate=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.tlAvgFrameRate, '}');
    }
}
