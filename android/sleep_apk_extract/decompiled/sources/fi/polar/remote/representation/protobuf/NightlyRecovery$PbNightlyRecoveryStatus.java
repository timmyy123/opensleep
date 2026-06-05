package fi.polar.remote.representation.protobuf;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class NightlyRecovery$PbNightlyRecoveryStatus extends GeneratedMessageLite<NightlyRecovery$PbNightlyRecoveryStatus, Builder> implements MessageLiteOrBuilder {
    public static final int ANS_RATE_FIELD_NUMBER = 6;
    public static final int ANS_STATUS_FIELD_NUMBER = 3;
    public static final int CREATED_TIMESTAMP_FIELD_NUMBER = 1;
    private static final NightlyRecovery$PbNightlyRecoveryStatus DEFAULT_INSTANCE;
    public static final int EXERCISE_TIP_FIELD_NUMBER = 19;
    public static final int MEAN_BASELINE_RESPIRATION_INTERVAL_FIELD_NUMBER = 15;
    public static final int MEAN_BASELINE_RMSSD_FIELD_NUMBER = 13;
    public static final int MEAN_BASELINE_RRI_FIELD_NUMBER = 11;
    public static final int MEAN_NIGHTLY_RECOVERY_RESPIRATION_INTERVAL_FIELD_NUMBER = 10;
    public static final int MEAN_NIGHTLY_RECOVERY_RMSSD_FIELD_NUMBER = 9;
    public static final int MEAN_NIGHTLY_RECOVERY_RRI_FIELD_NUMBER = 8;
    public static final int MODIFIED_TIMESTAMP_FIELD_NUMBER = 2;
    private static volatile Parser<NightlyRecovery$PbNightlyRecoveryStatus> PARSER = null;
    public static final int RECOVERY_INDICATOR_FIELD_NUMBER = 4;
    public static final int RECOVERY_INDICATOR_SUB_LEVEL_FIELD_NUMBER = 5;
    public static final int SCORE_RATE_OBSOLETE_FIELD_NUMBER = 7;
    public static final int SD_BASELINE_RESPIRATION_INTERVAL_FIELD_NUMBER = 16;
    public static final int SD_BASELINE_RMSSD_FIELD_NUMBER = 14;
    public static final int SD_BASELINE_RRI_FIELD_NUMBER = 12;
    public static final int SLEEP_RESULT_DATE_FIELD_NUMBER = 20;
    public static final int SLEEP_TIP_FIELD_NUMBER = 17;
    public static final int VITALITY_TIP_FIELD_NUMBER = 18;
    private int ansRate_;
    private float ansStatus_;
    private int bitField0_;
    private Types$PbSystemDateTime createdTimestamp_;
    private int meanBaselineRMSSD_;
    private int meanBaselineRRI_;
    private int meanBaselineRespirationInterval_;
    private int meanNightlyRecoveryRMSSD_;
    private int meanNightlyRecoveryRRI_;
    private int meanNightlyRecoveryRespirationInterval_;
    private Types$PbSystemDateTime modifiedTimestamp_;
    private int recoveryIndicatorSubLevel_;
    private int recoveryIndicator_;
    private int scoreRateOBSOLETE_;
    private int sdBaselineRMSSD_;
    private int sdBaselineRRI_;
    private int sdBaselineRespirationInterval_;
    private Types$PbDate sleepResultDate_;
    private byte memoizedIsInitialized = 2;
    private String sleepTip_ = "";
    private String vitalityTip_ = "";
    private String exerciseTip_ = "";

    static {
        NightlyRecovery$PbNightlyRecoveryStatus nightlyRecovery$PbNightlyRecoveryStatus = new NightlyRecovery$PbNightlyRecoveryStatus();
        DEFAULT_INSTANCE = nightlyRecovery$PbNightlyRecoveryStatus;
        GeneratedMessageLite.registerDefaultInstance(NightlyRecovery$PbNightlyRecoveryStatus.class, nightlyRecovery$PbNightlyRecoveryStatus);
    }

    private NightlyRecovery$PbNightlyRecoveryStatus() {
    }

    private void clearAnsRate() {
        this.bitField0_ &= -33;
        this.ansRate_ = 0;
    }

    private void clearAnsStatus() {
        this.bitField0_ &= -5;
        this.ansStatus_ = 0.0f;
    }

    private void clearCreatedTimestamp() {
        this.createdTimestamp_ = null;
        this.bitField0_ &= -2;
    }

    private void clearExerciseTip() {
        this.bitField0_ &= -262145;
        this.exerciseTip_ = getDefaultInstance().getExerciseTip();
    }

    private void clearMeanBaselineRMSSD() {
        this.bitField0_ &= -4097;
        this.meanBaselineRMSSD_ = 0;
    }

    private void clearMeanBaselineRRI() {
        this.bitField0_ &= -1025;
        this.meanBaselineRRI_ = 0;
    }

    private void clearMeanBaselineRespirationInterval() {
        this.bitField0_ &= -16385;
        this.meanBaselineRespirationInterval_ = 0;
    }

    private void clearMeanNightlyRecoveryRMSSD() {
        this.bitField0_ &= -257;
        this.meanNightlyRecoveryRMSSD_ = 0;
    }

    private void clearMeanNightlyRecoveryRRI() {
        this.bitField0_ &= -129;
        this.meanNightlyRecoveryRRI_ = 0;
    }

    private void clearMeanNightlyRecoveryRespirationInterval() {
        this.bitField0_ &= -513;
        this.meanNightlyRecoveryRespirationInterval_ = 0;
    }

    private void clearModifiedTimestamp() {
        this.modifiedTimestamp_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRecoveryIndicator() {
        this.bitField0_ &= -9;
        this.recoveryIndicator_ = 0;
    }

    private void clearRecoveryIndicatorSubLevel() {
        this.bitField0_ &= -17;
        this.recoveryIndicatorSubLevel_ = 0;
    }

    private void clearScoreRateOBSOLETE() {
        this.bitField0_ &= -65;
        this.scoreRateOBSOLETE_ = 0;
    }

    private void clearSdBaselineRMSSD() {
        this.bitField0_ &= -8193;
        this.sdBaselineRMSSD_ = 0;
    }

    private void clearSdBaselineRRI() {
        this.bitField0_ &= -2049;
        this.sdBaselineRRI_ = 0;
    }

    private void clearSdBaselineRespirationInterval() {
        this.bitField0_ &= -32769;
        this.sdBaselineRespirationInterval_ = 0;
    }

    private void clearSleepResultDate() {
        this.sleepResultDate_ = null;
        this.bitField0_ &= -524289;
    }

    private void clearSleepTip() {
        this.bitField0_ &= -65537;
        this.sleepTip_ = getDefaultInstance().getSleepTip();
    }

    private void clearVitalityTip() {
        this.bitField0_ &= -131073;
        this.vitalityTip_ = getDefaultInstance().getVitalityTip();
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCreatedTimestamp(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.createdTimestamp_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.createdTimestamp_ = types$PbSystemDateTime;
        } else {
            this.createdTimestamp_ = Types$PbSystemDateTime.newBuilder(this.createdTimestamp_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    private void mergeModifiedTimestamp(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.modifiedTimestamp_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.modifiedTimestamp_ = types$PbSystemDateTime;
        } else {
            this.modifiedTimestamp_ = Types$PbSystemDateTime.newBuilder(this.modifiedTimestamp_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSleepResultDate(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        Types$PbDate types$PbDate2 = this.sleepResultDate_;
        if (types$PbDate2 == null || types$PbDate2 == Types$PbDate.getDefaultInstance()) {
            this.sleepResultDate_ = types$PbDate;
        } else {
            this.sleepResultDate_ = Types$PbDate.newBuilder(this.sleepResultDate_).mergeFrom(types$PbDate).buildPartial();
        }
        this.bitField0_ |= 524288;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseDelimitedFrom(InputStream inputStream) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(ByteBuffer byteBuffer) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NightlyRecovery$PbNightlyRecoveryStatus> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAnsRate(int i) {
        this.bitField0_ |= 32;
        this.ansRate_ = i;
    }

    private void setAnsStatus(float f) {
        this.bitField0_ |= 4;
        this.ansStatus_ = f;
    }

    private void setCreatedTimestamp(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.createdTimestamp_ = types$PbSystemDateTime;
        this.bitField0_ |= 1;
    }

    private void setExerciseTip(String str) {
        str.getClass();
        this.bitField0_ |= 262144;
        this.exerciseTip_ = str;
    }

    private void setExerciseTipBytes(ByteString byteString) {
        this.exerciseTip_ = byteString.toStringUtf8();
        this.bitField0_ |= 262144;
    }

    private void setMeanBaselineRMSSD(int i) {
        this.bitField0_ |= 4096;
        this.meanBaselineRMSSD_ = i;
    }

    private void setMeanBaselineRRI(int i) {
        this.bitField0_ |= 1024;
        this.meanBaselineRRI_ = i;
    }

    private void setMeanBaselineRespirationInterval(int i) {
        this.bitField0_ |= 16384;
        this.meanBaselineRespirationInterval_ = i;
    }

    private void setMeanNightlyRecoveryRMSSD(int i) {
        this.bitField0_ |= 256;
        this.meanNightlyRecoveryRMSSD_ = i;
    }

    private void setMeanNightlyRecoveryRRI(int i) {
        this.bitField0_ |= 128;
        this.meanNightlyRecoveryRRI_ = i;
    }

    private void setMeanNightlyRecoveryRespirationInterval(int i) {
        this.bitField0_ |= 512;
        this.meanNightlyRecoveryRespirationInterval_ = i;
    }

    private void setModifiedTimestamp(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.modifiedTimestamp_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
    }

    private void setRecoveryIndicator(int i) {
        this.bitField0_ |= 8;
        this.recoveryIndicator_ = i;
    }

    private void setRecoveryIndicatorSubLevel(int i) {
        this.bitField0_ |= 16;
        this.recoveryIndicatorSubLevel_ = i;
    }

    private void setScoreRateOBSOLETE(int i) {
        this.bitField0_ |= 64;
        this.scoreRateOBSOLETE_ = i;
    }

    private void setSdBaselineRMSSD(int i) {
        this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.sdBaselineRMSSD_ = i;
    }

    private void setSdBaselineRRI(int i) {
        this.bitField0_ |= 2048;
        this.sdBaselineRRI_ = i;
    }

    private void setSdBaselineRespirationInterval(int i) {
        this.bitField0_ |= 32768;
        this.sdBaselineRespirationInterval_ = i;
    }

    private void setSleepResultDate(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        this.sleepResultDate_ = types$PbDate;
        this.bitField0_ |= 524288;
    }

    private void setSleepTip(String str) {
        str.getClass();
        this.bitField0_ |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.sleepTip_ = str;
    }

    private void setSleepTipBytes(ByteString byteString) {
        this.sleepTip_ = byteString.toStringUtf8();
        this.bitField0_ |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    private void setVitalityTip(String str) {
        str.getClass();
        this.bitField0_ |= 131072;
        this.vitalityTip_ = str;
    }

    private void setVitalityTipBytes(ByteString byteString) {
        this.vitalityTip_ = byteString.toStringUtf8();
        this.bitField0_ |= 131072;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (NightlyRecovery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NightlyRecovery$PbNightlyRecoveryStatus();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0014\u0000\u0001\u0001\u0014\u0014\u0000\u0000\u0003\u0001ᔉ\u0000\u0002ᐉ\u0001\u0003ခ\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bင\n\fင\u000b\rင\f\u000eင\r\u000fင\u000e\u0010င\u000f\u0011ဈ\u0010\u0012ဈ\u0011\u0013ဈ\u0012\u0014ᐉ\u0013", new Object[]{"bitField0_", "createdTimestamp_", "modifiedTimestamp_", "ansStatus_", "recoveryIndicator_", "recoveryIndicatorSubLevel_", "ansRate_", "scoreRateOBSOLETE_", "meanNightlyRecoveryRRI_", "meanNightlyRecoveryRMSSD_", "meanNightlyRecoveryRespirationInterval_", "meanBaselineRRI_", "sdBaselineRRI_", "meanBaselineRMSSD_", "sdBaselineRMSSD_", "meanBaselineRespirationInterval_", "sdBaselineRespirationInterval_", "sleepTip_", "vitalityTip_", "exerciseTip_", "sleepResultDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NightlyRecovery$PbNightlyRecoveryStatus> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NightlyRecovery$PbNightlyRecoveryStatus.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj != null ? 1 : 0);
                return null;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    public int getAnsRate() {
        return this.ansRate_;
    }

    public float getAnsStatus() {
        return this.ansStatus_;
    }

    public Types$PbSystemDateTime getCreatedTimestamp() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.createdTimestamp_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public String getExerciseTip() {
        return this.exerciseTip_;
    }

    public ByteString getExerciseTipBytes() {
        return ByteString.copyFromUtf8(this.exerciseTip_);
    }

    public int getMeanBaselineRMSSD() {
        return this.meanBaselineRMSSD_;
    }

    public int getMeanBaselineRRI() {
        return this.meanBaselineRRI_;
    }

    public int getMeanBaselineRespirationInterval() {
        return this.meanBaselineRespirationInterval_;
    }

    public int getMeanNightlyRecoveryRMSSD() {
        return this.meanNightlyRecoveryRMSSD_;
    }

    public int getMeanNightlyRecoveryRRI() {
        return this.meanNightlyRecoveryRRI_;
    }

    public int getMeanNightlyRecoveryRespirationInterval() {
        return this.meanNightlyRecoveryRespirationInterval_;
    }

    public Types$PbSystemDateTime getModifiedTimestamp() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.modifiedTimestamp_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public int getRecoveryIndicator() {
        return this.recoveryIndicator_;
    }

    public int getRecoveryIndicatorSubLevel() {
        return this.recoveryIndicatorSubLevel_;
    }

    public int getScoreRateOBSOLETE() {
        return this.scoreRateOBSOLETE_;
    }

    public int getSdBaselineRMSSD() {
        return this.sdBaselineRMSSD_;
    }

    public int getSdBaselineRRI() {
        return this.sdBaselineRRI_;
    }

    public int getSdBaselineRespirationInterval() {
        return this.sdBaselineRespirationInterval_;
    }

    public Types$PbDate getSleepResultDate() {
        Types$PbDate types$PbDate = this.sleepResultDate_;
        return types$PbDate == null ? Types$PbDate.getDefaultInstance() : types$PbDate;
    }

    public String getSleepTip() {
        return this.sleepTip_;
    }

    public ByteString getSleepTipBytes() {
        return ByteString.copyFromUtf8(this.sleepTip_);
    }

    public String getVitalityTip() {
        return this.vitalityTip_;
    }

    public ByteString getVitalityTipBytes() {
        return ByteString.copyFromUtf8(this.vitalityTip_);
    }

    public boolean hasAnsRate() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasAnsStatus() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasCreatedTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasExerciseTip() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasMeanBaselineRMSSD() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasMeanBaselineRRI() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasMeanBaselineRespirationInterval() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasMeanNightlyRecoveryRMSSD() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasMeanNightlyRecoveryRRI() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasMeanNightlyRecoveryRespirationInterval() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasModifiedTimestamp() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRecoveryIndicator() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasRecoveryIndicatorSubLevel() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasScoreRateOBSOLETE() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasSdBaselineRMSSD() {
        return (this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public boolean hasSdBaselineRRI() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasSdBaselineRespirationInterval() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasSleepResultDate() {
        return (this.bitField0_ & 524288) != 0;
    }

    public boolean hasSleepTip() {
        return (this.bitField0_ & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0;
    }

    public boolean hasVitalityTip() {
        return (this.bitField0_ & 131072) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<NightlyRecovery$PbNightlyRecoveryStatus, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(NightlyRecovery$PbNightlyRecoveryStatus.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(NightlyRecovery$PbNightlyRecoveryStatus nightlyRecovery$PbNightlyRecoveryStatus) {
        return DEFAULT_INSTANCE.createBuilder(nightlyRecovery$PbNightlyRecoveryStatus);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(ByteString byteString) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(byte[] bArr) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(InputStream inputStream) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(CodedInputStream codedInputStream) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NightlyRecovery$PbNightlyRecoveryStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NightlyRecovery$PbNightlyRecoveryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
