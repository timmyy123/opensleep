package org.mp4parser.boxes.dolby;

import com.facebook.appevents.AppEventsConstants;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.mp4parser.support.AbstractBox;
import org.mp4parser.support.RequiresParseDetailAspect;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class DoViConfigurationBox extends AbstractBox {
    public static final String TYPE = "dvcC";
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
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_20;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_21;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_22;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_23;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_3;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_4;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_5;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_6;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_7;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_8;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_9;
    private boolean blPresentFlag;
    private int dvLevel;
    private int dvProfile;
    private int dvVersionMajor;
    private int dvVersionMinor;
    private boolean elPresentFlag;
    private long reserved1;
    private long reserved2;
    private long reserved3;
    private long reserved4;
    private long reserved5;
    private boolean rpuPresentFlag;

    static {
        ajc$preClinit();
    }

    public DoViConfigurationBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("DoViConfigurationBox.java", DoViConfigurationBox.class);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getDvVersionMajor", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "int"), 70);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setDvVersionMajor", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "int", "dvVersionMajor", "", "void"), 74);
        ajc$tjp_10 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "isElPresentFlag", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "boolean"), 110);
        ajc$tjp_11 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setElPresentFlag", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "boolean", "elPresentFlag", "", "void"), 114);
        ajc$tjp_12 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "isBlPresentFlag", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "boolean"), 118);
        ajc$tjp_13 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setBlPresentFlag", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "boolean", "blPresentFlag", "", "void"), 122);
        ajc$tjp_14 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getReserved1", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "long"), 126);
        ajc$tjp_15 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setReserved1", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "long", "reserved1", "", "void"), 130);
        ajc$tjp_16 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getReserved2", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "long"), 134);
        ajc$tjp_17 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setReserved2", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "long", "reserved2", "", "void"), 138);
        ajc$tjp_18 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getReserved3", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "long"), 142);
        ajc$tjp_19 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setReserved3", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "long", "reserved3", "", "void"), 146);
        ajc$tjp_2 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getDvVersionMinor", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "int"), 78);
        ajc$tjp_20 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getReserved4", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "long"), 150);
        ajc$tjp_21 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setReserved4", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "long", "reserved4", "", "void"), 154);
        ajc$tjp_22 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getReserved5", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "long"), 158);
        ajc$tjp_23 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setReserved5", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "long", "reserved5", "", "void"), 162);
        ajc$tjp_3 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setDvVersionMinor", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "int", "dvVersionMinor", "", "void"), 82);
        ajc$tjp_4 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getDvProfile", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "int"), 86);
        ajc$tjp_5 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setDvProfile", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "int", "dvProfile", "", "void"), 90);
        ajc$tjp_6 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getDvLevel", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "int"), 94);
        ajc$tjp_7 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setDvLevel", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "int", "dvLevel", "", "void"), 98);
        ajc$tjp_8 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "isRpuPresentFlag", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "", "", "", "boolean"), 102);
        ajc$tjp_9 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setRpuPresentFlag", "org.mp4parser.boxes.dolby.DoViConfigurationBox", "boolean", "rpuPresentFlag", "", "void"), 106);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.dvVersionMajor = IsoTypeReader.readUInt8(byteBuffer);
        this.dvVersionMinor = IsoTypeReader.readUInt8(byteBuffer);
        int uInt16 = IsoTypeReader.readUInt16(byteBuffer);
        this.dvProfile = (uInt16 >> 9) & 127;
        this.dvLevel = (uInt16 >> 3) & 63;
        this.rpuPresentFlag = (uInt16 & 4) > 0;
        this.elPresentFlag = (uInt16 & 2) > 0;
        this.blPresentFlag = (uInt16 & 1) > 0;
        this.reserved1 = IsoTypeReader.readUInt32(byteBuffer);
        this.reserved2 = IsoTypeReader.readUInt32(byteBuffer);
        this.reserved3 = IsoTypeReader.readUInt32(byteBuffer);
        this.reserved4 = IsoTypeReader.readUInt32(byteBuffer);
        this.reserved5 = IsoTypeReader.readUInt32(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt8(byteBuffer, this.dvVersionMajor);
        IsoTypeWriter.writeUInt8(byteBuffer, this.dvVersionMinor);
        int i = this.dvProfile;
        IsoTypeWriter.writeUInt16(byteBuffer, ((i & 127) << 9) + ((i & 63) << 3) + (this.rpuPresentFlag ? 4 : 0) + (this.elPresentFlag ? 2 : 0) + (this.blPresentFlag ? 1 : 0));
        IsoTypeWriter.writeUInt32(byteBuffer, this.reserved1);
        IsoTypeWriter.writeUInt32(byteBuffer, this.reserved2);
        IsoTypeWriter.writeUInt32(byteBuffer, this.reserved3);
        IsoTypeWriter.writeUInt32(byteBuffer, this.reserved4);
        IsoTypeWriter.writeUInt32(byteBuffer, this.reserved5);
    }

    @Override // org.mp4parser.support.AbstractBox
    public long getContentSize() {
        return 24L;
    }

    public int getDvLevel() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
        return this.dvLevel;
    }

    public int getDvProfile() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        return this.dvProfile;
    }

    public int getDvVersionMajor() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.dvVersionMajor;
    }

    public int getDvVersionMinor() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.dvVersionMinor;
    }

    public long getReserved1() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this));
        return this.reserved1;
    }

    public long getReserved2() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this));
        return this.reserved2;
    }

    public long getReserved3() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_18, this, this));
        return this.reserved3;
    }

    public long getReserved4() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_20, this, this));
        return this.reserved4;
    }

    public long getReserved5() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_22, this, this));
        return this.reserved5;
    }

    public boolean isBlPresentFlag() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this));
        return this.blPresentFlag;
    }

    public boolean isElPresentFlag() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this));
        return this.elPresentFlag;
    }

    public boolean isRpuPresentFlag() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
        return this.rpuPresentFlag;
    }

    public void setBlPresentFlag(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, Conversions.booleanObject(z)));
        this.blPresentFlag = z;
    }

    public void setDvLevel(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.intObject(i)));
        this.dvLevel = i;
    }

    public void setDvProfile(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.intObject(i)));
        this.dvProfile = i;
    }

    public void setDvVersionMajor(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.intObject(i)));
        this.dvVersionMajor = i;
    }

    public void setDvVersionMinor(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i)));
        this.dvVersionMinor = i;
    }

    public void setElPresentFlag(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.booleanObject(z)));
        this.elPresentFlag = z;
    }

    public void setReserved1(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this, Conversions.longObject(j)));
        this.reserved1 = j;
    }

    public void setReserved2(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this, Conversions.longObject(j)));
        this.reserved2 = j;
    }

    public void setReserved3(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_19, this, this, Conversions.longObject(j)));
        this.reserved3 = j;
    }

    public void setReserved4(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_21, this, this, Conversions.longObject(j)));
        this.reserved4 = j;
    }

    public void setReserved5(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_23, this, this, Conversions.longObject(j)));
        this.reserved5 = j;
    }

    public void setRpuPresentFlag(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, Conversions.booleanObject(z)));
        this.rpuPresentFlag = z;
    }
}
