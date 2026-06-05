package org.mp4parser.boxes.webm;

import com.facebook.appevents.AppEventsConstants;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class SMPTE2086MasteringDisplayMetadataBox extends AbstractFullBox {
    private static final String TYPE = "SmDm";
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_1;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_10;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_11;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_12;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_13;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_14;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_15;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_16;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_17;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_18;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_19;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_2;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_3;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_4;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_5;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_6;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_7;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_8;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_9;
    long luminanceMax;
    long luminanceMin;
    int primaryBChromaticity_x;
    int primaryBChromaticity_y;
    int primaryGChromaticity_x;
    int primaryGChromaticity_y;
    int primaryRChromaticity_x;
    int primaryRChromaticity_y;
    int whitePointChromaticity_x;
    int whitePointChromaticity_y;

    static {
        ajc$preClinit();
    }

    public SMPTE2086MasteringDisplayMetadataBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("SMPTE2086MasteringDisplayMetadataBox.java", SMPTE2086MasteringDisplayMetadataBox.class);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getPrimaryRChromaticity_x", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "int"), 27);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setPrimaryRChromaticity_x", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "int", "primaryRChromaticity_x", "", "void"), 31);
        ajc$tjp_10 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getPrimaryBChromaticity_y", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "int"), 67);
        ajc$tjp_11 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setPrimaryBChromaticity_y", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "int", "primaryBChromaticity_y", "", "void"), 71);
        ajc$tjp_12 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getWhitePointChromaticity_x", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "int"), 75);
        ajc$tjp_13 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setWhitePointChromaticity_x", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "int", "whitePointChromaticity_x", "", "void"), 79);
        ajc$tjp_14 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getWhitePointChromaticity_y", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "int"), 83);
        ajc$tjp_15 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setWhitePointChromaticity_y", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "int", "whitePointChromaticity_y", "", "void"), 87);
        ajc$tjp_16 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getLuminanceMax", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "long"), 91);
        ajc$tjp_17 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setLuminanceMax", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "long", "luminanceMax", "", "void"), 95);
        ajc$tjp_18 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getLuminanceMin", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "long"), 99);
        ajc$tjp_19 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setLuminanceMin", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "long", "luminanceMin", "", "void"), 103);
        ajc$tjp_2 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getPrimaryRChromaticity_y", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "int"), 35);
        ajc$tjp_3 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setPrimaryRChromaticity_y", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "int", "primaryRChromaticity_y", "", "void"), 39);
        ajc$tjp_4 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getPrimaryGChromaticity_x", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "int"), 43);
        ajc$tjp_5 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setPrimaryGChromaticity_x", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "int", "primaryGChromaticity_x", "", "void"), 47);
        ajc$tjp_6 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getPrimaryGChromaticity_y", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "int"), 51);
        ajc$tjp_7 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setPrimaryGChromaticity_y", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "int", "primaryGChromaticity_y", "", "void"), 55);
        ajc$tjp_8 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getPrimaryBChromaticity_x", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "", "", "", "int"), 59);
        ajc$tjp_9 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setPrimaryBChromaticity_x", "org.mp4parser.boxes.webm.SMPTE2086MasteringDisplayMetadataBox", "int", "primaryBChromaticity_x", "", "void"), 63);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.primaryRChromaticity_x = IsoTypeReader.readUInt16(byteBuffer);
        this.primaryRChromaticity_y = IsoTypeReader.readUInt16(byteBuffer);
        this.primaryGChromaticity_x = IsoTypeReader.readUInt16(byteBuffer);
        this.primaryGChromaticity_y = IsoTypeReader.readUInt16(byteBuffer);
        this.primaryBChromaticity_x = IsoTypeReader.readUInt16(byteBuffer);
        this.primaryBChromaticity_y = IsoTypeReader.readUInt16(byteBuffer);
        this.whitePointChromaticity_x = IsoTypeReader.readUInt16(byteBuffer);
        this.whitePointChromaticity_y = IsoTypeReader.readUInt16(byteBuffer);
        this.luminanceMax = IsoTypeReader.readUInt32(byteBuffer);
        this.luminanceMin = IsoTypeReader.readUInt32(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt16(byteBuffer, this.primaryRChromaticity_x);
        IsoTypeWriter.writeUInt16(byteBuffer, this.primaryRChromaticity_y);
        IsoTypeWriter.writeUInt16(byteBuffer, this.primaryGChromaticity_x);
        IsoTypeWriter.writeUInt16(byteBuffer, this.primaryGChromaticity_y);
        IsoTypeWriter.writeUInt16(byteBuffer, this.primaryBChromaticity_x);
        IsoTypeWriter.writeUInt16(byteBuffer, this.primaryBChromaticity_y);
        IsoTypeWriter.writeUInt16(byteBuffer, this.whitePointChromaticity_x);
        IsoTypeWriter.writeUInt16(byteBuffer, this.whitePointChromaticity_y);
        IsoTypeWriter.writeUInt32(byteBuffer, this.luminanceMax);
        IsoTypeWriter.writeUInt32(byteBuffer, this.luminanceMin);
    }

    @Override // org.mp4parser.support.AbstractBox
    public long getContentSize() {
        return 28L;
    }

    public long getLuminanceMax() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this));
        return this.luminanceMax;
    }

    public long getLuminanceMin() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_18, this, this));
        return this.luminanceMin;
    }

    public int getPrimaryBChromaticity_x() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
        return this.primaryBChromaticity_x;
    }

    public int getPrimaryBChromaticity_y() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this));
        return this.primaryBChromaticity_y;
    }

    public int getPrimaryGChromaticity_x() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        return this.primaryGChromaticity_x;
    }

    public int getPrimaryGChromaticity_y() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
        return this.primaryGChromaticity_y;
    }

    public int getPrimaryRChromaticity_x() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.primaryRChromaticity_x;
    }

    public int getPrimaryRChromaticity_y() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.primaryRChromaticity_y;
    }

    public int getWhitePointChromaticity_x() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this));
        return this.whitePointChromaticity_x;
    }

    public int getWhitePointChromaticity_y() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this));
        return this.whitePointChromaticity_y;
    }

    public void setLuminanceMax(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this, Conversions.longObject(j)));
        this.luminanceMax = j;
    }

    public void setLuminanceMin(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_19, this, this, Conversions.longObject(j)));
        this.luminanceMin = j;
    }

    public void setPrimaryBChromaticity_x(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, Conversions.intObject(i)));
        this.primaryBChromaticity_x = i;
    }

    public void setPrimaryBChromaticity_y(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.intObject(i)));
        this.primaryBChromaticity_y = i;
    }

    public void setPrimaryGChromaticity_x(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.intObject(i)));
        this.primaryGChromaticity_x = i;
    }

    public void setPrimaryGChromaticity_y(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.intObject(i)));
        this.primaryGChromaticity_y = i;
    }

    public void setPrimaryRChromaticity_x(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.intObject(i)));
        this.primaryRChromaticity_x = i;
    }

    public void setPrimaryRChromaticity_y(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i)));
        this.primaryRChromaticity_y = i;
    }

    public void setWhitePointChromaticity_x(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, Conversions.intObject(i)));
        this.whitePointChromaticity_x = i;
    }

    public void setWhitePointChromaticity_y(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this, Conversions.intObject(i)));
        this.whitePointChromaticity_y = i;
    }
}
