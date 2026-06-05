package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.tools.IsoTypeReader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class InitialObjectDescriptor extends ObjectDescriptorBase {
    int audioProfileLevelIndication;
    int graphicsProfileLevelIndication;
    int includeInlineProfileLevelFlag;
    int oDProfileLevelIndication;
    private int objectDescriptorId;
    int sceneProfileLevelIndication;
    int urlFlag;
    int urlLength;
    String urlString;
    int visualProfileLevelIndication;
    List<ESDescriptor> esDescriptors = new ArrayList();
    List<ExtensionDescriptor> extensionDescriptors = new ArrayList();
    List<BaseDescriptor> unknownDescriptors = new ArrayList();

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) {
        int size;
        int uInt16 = IsoTypeReader.readUInt16(byteBuffer);
        this.objectDescriptorId = (65472 & uInt16) >> 6;
        this.urlFlag = (uInt16 & 63) >> 5;
        this.includeInlineProfileLevelFlag = (uInt16 & 31) >> 4;
        int size2 = getSize();
        int i = size2 - 2;
        if (this.urlFlag == 1) {
            int uInt8 = IsoTypeReader.readUInt8(byteBuffer);
            this.urlLength = uInt8;
            this.urlString = IsoTypeReader.readString(byteBuffer, uInt8);
            size = i - (this.urlLength + 1);
        } else {
            this.oDProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.sceneProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.audioProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.visualProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.graphicsProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            size = size2 - 7;
            if (size > 2) {
                BaseDescriptor baseDescriptorCreateFrom = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                size -= baseDescriptorCreateFrom.getSize();
                if (baseDescriptorCreateFrom instanceof ESDescriptor) {
                    this.esDescriptors.add((ESDescriptor) baseDescriptorCreateFrom);
                } else {
                    this.unknownDescriptors.add(baseDescriptorCreateFrom);
                }
            }
        }
        if (size > 2) {
            BaseDescriptor baseDescriptorCreateFrom2 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
            if (baseDescriptorCreateFrom2 instanceof ExtensionDescriptor) {
                this.extensionDescriptors.add((ExtensionDescriptor) baseDescriptorCreateFrom2);
            } else {
                this.unknownDescriptors.add(baseDescriptorCreateFrom2);
            }
        }
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder("InitialObjectDescriptor{objectDescriptorId=");
        sb.append(this.objectDescriptorId);
        sb.append(", urlFlag=");
        sb.append(this.urlFlag);
        sb.append(", includeInlineProfileLevelFlag=");
        sb.append(this.includeInlineProfileLevelFlag);
        sb.append(", urlLength=");
        sb.append(this.urlLength);
        sb.append(", urlString='");
        sb.append(this.urlString);
        sb.append("', oDProfileLevelIndication=");
        sb.append(this.oDProfileLevelIndication);
        sb.append(", sceneProfileLevelIndication=");
        sb.append(this.sceneProfileLevelIndication);
        sb.append(", audioProfileLevelIndication=");
        sb.append(this.audioProfileLevelIndication);
        sb.append(", visualProfileLevelIndication=");
        sb.append(this.visualProfileLevelIndication);
        sb.append(", graphicsProfileLevelIndication=");
        sb.append(this.graphicsProfileLevelIndication);
        sb.append(", esDescriptors=");
        sb.append(this.esDescriptors);
        sb.append(", extensionDescriptors=");
        sb.append(this.extensionDescriptors);
        sb.append(", unknownDescriptors=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.unknownDescriptors, '}');
    }
}
