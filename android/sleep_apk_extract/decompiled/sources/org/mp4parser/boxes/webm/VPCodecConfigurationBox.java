package org.mp4parser.boxes.webm;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;
import twitter4j.TwitterImpl$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class VPCodecConfigurationBox extends AbstractFullBox {
    public static final String TYPE = "vpcC";
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
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_2;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_3;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_4;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_5;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_6;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_7;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_8;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_9;
    private int bitDepth;
    private int chromaSubsampling;
    private byte[] codecIntializationData;
    private int colourPrimaries;
    private int level;
    private int matrixCoefficients;
    private int profile;
    private int transferCharacteristics;
    private int videoFullRangeFlag;

    static {
        ajc$preClinit();
    }

    public VPCodecConfigurationBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("VPCodecConfigurationBox.java", VPCodecConfigurationBox.class);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getProfile", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "int"), 81);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setProfile", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "int", "profile", "", "void"), 85);
        ajc$tjp_10 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getColourPrimaries", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "int"), 121);
        ajc$tjp_11 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setColourPrimaries", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "int", "colourPrimaries", "", "void"), 125);
        ajc$tjp_12 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getTransferCharacteristics", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "int"), 129);
        ajc$tjp_13 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setTransferCharacteristics", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "int", "transferCharacteristics", "", "void"), 133);
        ajc$tjp_14 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getMatrixCoefficients", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "int"), 137);
        ajc$tjp_15 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setMatrixCoefficients", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "int", "matrixCoefficients", "", "void"), 141);
        ajc$tjp_16 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getCodecIntializationData", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "[B"), 145);
        ajc$tjp_17 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setCodecIntializationData", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "[B", "codecIntializationData", "", "void"), 149);
        ajc$tjp_18 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, InAppPurchaseConstants.METHOD_TO_STRING, "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "java.lang.String"), 154);
        ajc$tjp_2 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getLevel", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "int"), 89);
        ajc$tjp_3 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setLevel", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "int", "level", "", "void"), 93);
        ajc$tjp_4 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getBitDepth", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "int"), 97);
        ajc$tjp_5 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setBitDepth", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "int", "bitDepth", "", "void"), 101);
        ajc$tjp_6 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getChromaSubsampling", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "int"), 105);
        ajc$tjp_7 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setChromaSubsampling", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "int", "chromaSubsampling", "", "void"), 109);
        ajc$tjp_8 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getVideoFullRangeFlag", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "", "", "", "int"), 113);
        ajc$tjp_9 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setVideoFullRangeFlag", "org.mp4parser.boxes.webm.VPCodecConfigurationBox", "int", "videoFullRangeFlag", "", "void"), 117);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.profile = bitReaderBuffer.readBits(8);
        this.level = bitReaderBuffer.readBits(8);
        this.bitDepth = bitReaderBuffer.readBits(4);
        this.chromaSubsampling = bitReaderBuffer.readBits(3);
        this.videoFullRangeFlag = bitReaderBuffer.readBits(1);
        this.colourPrimaries = bitReaderBuffer.readBits(8);
        this.transferCharacteristics = bitReaderBuffer.readBits(8);
        this.matrixCoefficients = bitReaderBuffer.readBits(8);
        byte[] bArr = new byte[bitReaderBuffer.readBits(16)];
        this.codecIntializationData = bArr;
        byteBuffer.get(bArr);
    }

    public int getBitDepth() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        return this.bitDepth;
    }

    public int getChromaSubsampling() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
        return this.chromaSubsampling;
    }

    public byte[] getCodecIntializationData() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this));
        return this.codecIntializationData;
    }

    public int getColourPrimaries() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this));
        return this.colourPrimaries;
    }

    @Override // org.mp4parser.support.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.profile, 8);
        bitWriterBuffer.writeBits(this.level, 8);
        bitWriterBuffer.writeBits(this.bitDepth, 4);
        bitWriterBuffer.writeBits(this.chromaSubsampling, 3);
        bitWriterBuffer.writeBits(this.videoFullRangeFlag, 1);
        bitWriterBuffer.writeBits(this.colourPrimaries, 8);
        bitWriterBuffer.writeBits(this.transferCharacteristics, 8);
        bitWriterBuffer.writeBits(this.matrixCoefficients, 8);
        bitWriterBuffer.writeBits(this.codecIntializationData.length, 16);
        byteBuffer.put(this.codecIntializationData);
    }

    @Override // org.mp4parser.support.AbstractBox
    public long getContentSize() {
        return this.codecIntializationData.length + 12;
    }

    public int getLevel() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.level;
    }

    public int getMatrixCoefficients() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this));
        return this.matrixCoefficients;
    }

    public int getProfile() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.profile;
    }

    public int getTransferCharacteristics() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this));
        return this.transferCharacteristics;
    }

    public int getVideoFullRangeFlag() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
        return this.videoFullRangeFlag;
    }

    public void setBitDepth(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.intObject(i)));
        this.bitDepth = i;
    }

    public void setChromaSubsampling(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.intObject(i)));
        this.chromaSubsampling = i;
    }

    public void setCodecIntializationData(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this, bArr));
        this.codecIntializationData = bArr;
    }

    public void setColourPrimaries(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.intObject(i)));
        this.colourPrimaries = i;
    }

    public void setLevel(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i)));
        this.level = i;
    }

    public void setMatrixCoefficients(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this, Conversions.intObject(i)));
        this.matrixCoefficients = i;
    }

    public void setProfile(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.intObject(i)));
        this.profile = i;
    }

    public void setTransferCharacteristics(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, Conversions.intObject(i)));
        this.transferCharacteristics = i;
    }

    public void setVideoFullRangeFlag(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, Conversions.intObject(i)));
        this.videoFullRangeFlag = i;
    }

    public String toString() {
        StringBuilder sbM = TwitterImpl$$ExternalSyntheticOutline0.m(Factory.makeJP(ajc$tjp_18, this, this), "VPCodecConfigurationBox{profile=");
        sbM.append(this.profile);
        sbM.append(", level=");
        sbM.append(this.level);
        sbM.append(", bitDepth=");
        sbM.append(this.bitDepth);
        sbM.append(", chromaSubsampling=");
        sbM.append(this.chromaSubsampling);
        sbM.append(", videoFullRangeFlag=");
        sbM.append(this.videoFullRangeFlag);
        sbM.append(", colourPrimaries=");
        sbM.append(this.colourPrimaries);
        sbM.append(", transferCharacteristics=");
        sbM.append(this.transferCharacteristics);
        sbM.append(", matrixCoefficients=");
        sbM.append(this.matrixCoefficients);
        sbM.append(", codecIntializationData=");
        sbM.append(Arrays.toString(this.codecIntializationData));
        sbM.append('}');
        return sbM.toString();
    }
}
