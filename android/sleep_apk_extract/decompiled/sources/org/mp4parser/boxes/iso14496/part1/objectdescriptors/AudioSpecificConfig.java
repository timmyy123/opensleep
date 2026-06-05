package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.tools.Hex;
import org.mp4parser.tools.IsoTypeWriter;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Descriptor(objectTypeIndication = 64, tags = {5})
public class AudioSpecificConfig extends BaseDescriptor {
    public boolean aacScalefactorDataResilienceFlag;
    public boolean aacSectionDataResilienceFlag;
    public boolean aacSpectralDataResilienceFlag;
    public int audioObjectType;
    public int channelConfiguration;
    byte[] configBytes;
    public int coreCoderDelay;
    public int dependsOnCoreCoder;
    public int directMapping;
    public ELDSpecificConfig eldSpecificConfig;
    public int epConfig;
    public int erHvxcExtensionFlag;
    public int extensionAudioObjectType;
    public int extensionChannelConfiguration;
    public int extensionFlag;
    public int extensionFlag3;
    public int extensionSamplingFrequency;
    public int fillBits;
    public int frameLengthFlag;
    public boolean gaSpecificConfig;
    public int hilnContMode;
    public int hilnEnhaLayer;
    public int hilnEnhaQuantMode;
    public int hilnFrameLength;
    public int hilnMaxNumLine;
    public int hilnQuantMode;
    public int hilnSampleRateCode;
    public int hvxcRateMode;
    public int hvxcVarMode;
    public int isBaseLayer;
    public int layerNr;
    public int layer_length;
    public int numOfSubFrame;
    public int origExtensionAudioObjectType;
    public int originalAudioObjectType;
    public int paraExtensionFlag;
    public int paraMode;
    public boolean parametricSpecificConfig;
    public boolean psPresentFlag;
    public int sacPayloadEmbedding;
    public int samplingFrequency;
    public int samplingFrequencyIndex;
    public boolean sbrPresentFlag;
    public int var_ScalableFlag;
    public static Map<Integer, Integer> samplingFrequencyIndexMap = new HashMap();
    public static Map<Integer, String> audioObjectTypeMap = new HashMap();
    public int extensionSamplingFrequencyIndex = -1;
    public int syncExtensionType = -1;
    public int innerSyncExtensionType = -1;
    public int outerSyncExtensionType = -1;
    boolean parsed = false;

    public class ELDSpecificConfig {
        private static final int ELDEXT_TERM = 0;
        public boolean aacScalefactorDataResilienceFlag;
        public boolean aacSectionDataResilienceFlag;
        public boolean aacSpectralDataResilienceFlag;
        public boolean frameLengthFlag;
        public boolean ldSbrCrcFlag;
        public boolean ldSbrPresentFlag;
        public boolean ldSbrSamplingRate;

        public ELDSpecificConfig(int i, BitReaderBuffer bitReaderBuffer) {
            int bits;
            this.frameLengthFlag = bitReaderBuffer.readBool();
            this.aacSectionDataResilienceFlag = bitReaderBuffer.readBool();
            this.aacScalefactorDataResilienceFlag = bitReaderBuffer.readBool();
            this.aacSpectralDataResilienceFlag = bitReaderBuffer.readBool();
            boolean bool = bitReaderBuffer.readBool();
            this.ldSbrPresentFlag = bool;
            if (bool) {
                this.ldSbrSamplingRate = bitReaderBuffer.readBool();
                this.ldSbrCrcFlag = bitReaderBuffer.readBool();
                ld_sbr_header(i, bitReaderBuffer);
            }
            while (bitReaderBuffer.readBits(4) != 0) {
                int bits2 = bitReaderBuffer.readBits(4);
                if (bits2 == 15) {
                    bits = bitReaderBuffer.readBits(8);
                    bits2 += bits;
                } else {
                    bits = 0;
                }
                if (bits == 255) {
                    bits2 += bitReaderBuffer.readBits(16);
                }
                for (int i2 = 0; i2 < bits2; i2++) {
                    bitReaderBuffer.readBits(8);
                }
            }
        }

        public void ld_sbr_header(int i, BitReaderBuffer bitReaderBuffer) {
            int i2;
            switch (i) {
                case 1:
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                    i2 = 3;
                    break;
                case 7:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                AudioSpecificConfig.this.new sbr_header(bitReaderBuffer);
            }
        }
    }

    public class sbr_header {
        public boolean bs_alter_scale;
        public boolean bs_amp_res;
        public int bs_freq_scale;
        public boolean bs_header_extra_1;
        public boolean bs_header_extra_2;
        public boolean bs_interpol_freq;
        public int bs_limiter_bands;
        public int bs_limiter_gains;
        public int bs_noise_bands;
        public int bs_reserved;
        public boolean bs_smoothing_mode;
        public int bs_start_freq;
        public int bs_stop_freq;
        public int bs_xover_band;

        public sbr_header(BitReaderBuffer bitReaderBuffer) {
            this.bs_amp_res = bitReaderBuffer.readBool();
            this.bs_start_freq = bitReaderBuffer.readBits(4);
            this.bs_stop_freq = bitReaderBuffer.readBits(4);
            this.bs_xover_band = bitReaderBuffer.readBits(3);
            this.bs_reserved = bitReaderBuffer.readBits(2);
            this.bs_header_extra_1 = bitReaderBuffer.readBool();
            this.bs_header_extra_2 = bitReaderBuffer.readBool();
            if (this.bs_header_extra_1) {
                this.bs_freq_scale = bitReaderBuffer.readBits(2);
                this.bs_alter_scale = bitReaderBuffer.readBool();
                this.bs_noise_bands = bitReaderBuffer.readBits(2);
            }
            if (this.bs_header_extra_2) {
                this.bs_limiter_bands = bitReaderBuffer.readBits(2);
                this.bs_limiter_gains = bitReaderBuffer.readBits(2);
                this.bs_interpol_freq = bitReaderBuffer.readBool();
            }
            this.bs_smoothing_mode = bitReaderBuffer.readBool();
        }
    }

    static {
        samplingFrequencyIndexMap.put(0, 96000);
        samplingFrequencyIndexMap.put(1, 88200);
        samplingFrequencyIndexMap.put(2, 64000);
        samplingFrequencyIndexMap.put(3, 48000);
        samplingFrequencyIndexMap.put(4, 44100);
        samplingFrequencyIndexMap.put(5, 32000);
        samplingFrequencyIndexMap.put(6, 24000);
        samplingFrequencyIndexMap.put(7, 22050);
        samplingFrequencyIndexMap.put(8, 16000);
        samplingFrequencyIndexMap.put(9, 12000);
        samplingFrequencyIndexMap.put(10, 11025);
        samplingFrequencyIndexMap.put(11, 8000);
        audioObjectTypeMap.put(1, "AAC main");
        audioObjectTypeMap.put(2, "AAC LC");
        audioObjectTypeMap.put(3, "AAC SSR");
        audioObjectTypeMap.put(4, "AAC LTP");
        audioObjectTypeMap.put(5, "SBR");
        audioObjectTypeMap.put(6, "AAC Scalable");
        audioObjectTypeMap.put(7, "TwinVQ");
        audioObjectTypeMap.put(8, "CELP");
        audioObjectTypeMap.put(9, "HVXC");
        audioObjectTypeMap.put(10, "(reserved)");
        audioObjectTypeMap.put(11, "(reserved)");
        audioObjectTypeMap.put(12, "TTSI");
        audioObjectTypeMap.put(13, "Main synthetic");
        audioObjectTypeMap.put(14, "Wavetable synthesis");
        audioObjectTypeMap.put(15, "General MIDI");
        audioObjectTypeMap.put(16, "Algorithmic Synthesis and Audio FX");
        audioObjectTypeMap.put(17, "ER AAC LC");
        audioObjectTypeMap.put(18, "(reserved)");
        audioObjectTypeMap.put(19, "ER AAC LTP");
        audioObjectTypeMap.put(20, "ER AAC Scalable");
        audioObjectTypeMap.put(21, "ER TwinVQ");
        audioObjectTypeMap.put(22, "ER BSAC");
        audioObjectTypeMap.put(23, "ER AAC LD");
        audioObjectTypeMap.put(24, "ER CELP");
        audioObjectTypeMap.put(25, "ER HVXC");
        audioObjectTypeMap.put(26, "ER HILN");
        audioObjectTypeMap.put(27, "ER Parametric");
        audioObjectTypeMap.put(28, "SSC");
        audioObjectTypeMap.put(29, "PS");
        audioObjectTypeMap.put(30, "MPEG Surround");
        audioObjectTypeMap.put(31, "(escape)");
        audioObjectTypeMap.put(32, "Layer-1");
        audioObjectTypeMap.put(33, "Layer-2");
        audioObjectTypeMap.put(34, "Layer-3");
        audioObjectTypeMap.put(35, "DST");
        audioObjectTypeMap.put(36, "ALS");
        audioObjectTypeMap.put(37, "SLS");
        audioObjectTypeMap.put(38, "SLS non-core");
        audioObjectTypeMap.put(39, "ER AAC ELD");
        audioObjectTypeMap.put(40, "SMR Simple");
        audioObjectTypeMap.put(41, "SMR Main");
    }

    public AudioSpecificConfig() {
        this.tag = 5;
    }

    private int gaSpecificConfigSize() {
        int i = this.dependsOnCoreCoder == 1 ? 16 : 2;
        int i2 = i + 1;
        if (this.channelConfiguration == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m("can't parse program_config_element yet");
            return 0;
        }
        int i3 = this.audioObjectType;
        if (i3 == 6 || i3 == 20) {
            i2 = i + 4;
        }
        if (this.extensionFlag != 1) {
            return i2;
        }
        if (i3 == 22) {
            i2 += 16;
        }
        if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
            i2 += 3;
        }
        int i4 = i2 + 1;
        if (this.extensionFlag3 != 1) {
            return i4;
        }
        Types$$ExternalSyntheticBUOutline0.m$2("Not implemented");
        return 0;
    }

    private static int getAudioObjectType(BitReaderBuffer bitReaderBuffer) {
        int bits = bitReaderBuffer.readBits(5);
        return bits == 31 ? bitReaderBuffer.readBits(6) + 32 : bits;
    }

    private void parseErHvxcConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) {
        this.hvxcVarMode = bitReaderBuffer.readBits(1);
        this.hvxcRateMode = bitReaderBuffer.readBits(2);
        int bits = bitReaderBuffer.readBits(1);
        this.erHvxcExtensionFlag = bits;
        if (bits == 1) {
            this.var_ScalableFlag = bitReaderBuffer.readBits(1);
        }
    }

    private void parseGaSpecificConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) {
        this.frameLengthFlag = bitReaderBuffer.readBits(1);
        int bits = bitReaderBuffer.readBits(1);
        this.dependsOnCoreCoder = bits;
        if (bits == 1) {
            this.coreCoderDelay = bitReaderBuffer.readBits(14);
        }
        this.extensionFlag = bitReaderBuffer.readBits(1);
        if (i2 == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m("can't parse program_config_element yet");
            return;
        }
        if (i3 == 6 || i3 == 20) {
            this.layerNr = bitReaderBuffer.readBits(3);
        }
        if (this.extensionFlag == 1) {
            if (i3 == 22) {
                this.numOfSubFrame = bitReaderBuffer.readBits(5);
                this.layer_length = bitReaderBuffer.readBits(11);
            }
            if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                this.aacSectionDataResilienceFlag = bitReaderBuffer.readBool();
                this.aacScalefactorDataResilienceFlag = bitReaderBuffer.readBool();
                this.aacSpectralDataResilienceFlag = bitReaderBuffer.readBool();
            }
            int bits2 = bitReaderBuffer.readBits(1);
            this.extensionFlag3 = bits2;
            if (bits2 == 1) {
                Types$$ExternalSyntheticBUOutline0.m$2("not yet implemented");
                return;
            }
        }
        this.gaSpecificConfig = true;
    }

    private void parseHilnConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) {
        this.hilnQuantMode = bitReaderBuffer.readBits(1);
        this.hilnMaxNumLine = bitReaderBuffer.readBits(8);
        this.hilnSampleRateCode = bitReaderBuffer.readBits(4);
        this.hilnFrameLength = bitReaderBuffer.readBits(12);
        this.hilnContMode = bitReaderBuffer.readBits(2);
    }

    private void parseHilnEnexConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) {
        int bits = bitReaderBuffer.readBits(1);
        this.hilnEnhaLayer = bits;
        if (bits == 1) {
            this.hilnEnhaQuantMode = bitReaderBuffer.readBits(2);
        }
    }

    private void parseParaConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) {
        int bits = bitReaderBuffer.readBits(2);
        this.paraMode = bits;
        if (bits != 1) {
            parseErHvxcConfig(i, i2, i3, bitReaderBuffer);
        }
        if (this.paraMode != 0) {
            parseHilnConfig(i, i2, i3, bitReaderBuffer);
        }
        this.paraExtensionFlag = bitReaderBuffer.readBits(1);
        this.parametricSpecificConfig = true;
    }

    private void parseParametricSpecificConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) {
        int bits = bitReaderBuffer.readBits(1);
        this.isBaseLayer = bits;
        if (bits == 1) {
            parseParaConfig(i, i2, i3, bitReaderBuffer);
        } else {
            parseHilnEnexConfig(i, i2, i3, bitReaderBuffer);
        }
    }

    private static void writeAudioObjectType(int i, BitWriterBuffer bitWriterBuffer) {
        if (i < 32) {
            bitWriterBuffer.writeBits(i, 5);
        } else {
            bitWriterBuffer.writeBits(31, 5);
            bitWriterBuffer.writeBits(i - 32, 6);
        }
    }

    private void writeGaSpecificConfig(BitWriterBuffer bitWriterBuffer) {
        bitWriterBuffer.writeBits(this.frameLengthFlag, 1);
        bitWriterBuffer.writeBits(this.dependsOnCoreCoder, 1);
        if (this.dependsOnCoreCoder == 1) {
            bitWriterBuffer.writeBits(this.coreCoderDelay, 14);
        }
        bitWriterBuffer.writeBits(this.extensionFlag, 1);
        if (this.channelConfiguration == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m("can't parse program_config_element yet");
            return;
        }
        int i = this.audioObjectType;
        if (i == 6 || i == 20) {
            bitWriterBuffer.writeBits(this.layerNr, 3);
        }
        if (this.extensionFlag == 1) {
            if (this.audioObjectType == 22) {
                bitWriterBuffer.writeBits(this.numOfSubFrame, 5);
                bitWriterBuffer.writeBits(this.layer_length, 11);
            }
            int i2 = this.audioObjectType;
            if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                bitWriterBuffer.writeBool(this.aacSectionDataResilienceFlag);
                bitWriterBuffer.writeBool(this.aacScalefactorDataResilienceFlag);
                bitWriterBuffer.writeBool(this.aacSpectralDataResilienceFlag);
            }
            bitWriterBuffer.writeBits(this.extensionFlag3, 1);
            if (this.extensionFlag3 != 1) {
                return;
            }
            Types$$ExternalSyntheticBUOutline0.m$2("not yet implemented");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AudioSpecificConfig audioSpecificConfig = (AudioSpecificConfig) obj;
        return this.aacScalefactorDataResilienceFlag == audioSpecificConfig.aacScalefactorDataResilienceFlag && this.aacSectionDataResilienceFlag == audioSpecificConfig.aacSectionDataResilienceFlag && this.aacSpectralDataResilienceFlag == audioSpecificConfig.aacSpectralDataResilienceFlag && this.audioObjectType == audioSpecificConfig.audioObjectType && this.channelConfiguration == audioSpecificConfig.channelConfiguration && this.coreCoderDelay == audioSpecificConfig.coreCoderDelay && this.dependsOnCoreCoder == audioSpecificConfig.dependsOnCoreCoder && this.directMapping == audioSpecificConfig.directMapping && this.epConfig == audioSpecificConfig.epConfig && this.erHvxcExtensionFlag == audioSpecificConfig.erHvxcExtensionFlag && this.extensionAudioObjectType == audioSpecificConfig.extensionAudioObjectType && this.extensionChannelConfiguration == audioSpecificConfig.extensionChannelConfiguration && this.extensionFlag == audioSpecificConfig.extensionFlag && this.extensionFlag3 == audioSpecificConfig.extensionFlag3 && this.extensionSamplingFrequency == audioSpecificConfig.extensionSamplingFrequency && this.extensionSamplingFrequencyIndex == audioSpecificConfig.extensionSamplingFrequencyIndex && this.fillBits == audioSpecificConfig.fillBits && this.frameLengthFlag == audioSpecificConfig.frameLengthFlag && this.gaSpecificConfig == audioSpecificConfig.gaSpecificConfig && this.hilnContMode == audioSpecificConfig.hilnContMode && this.hilnEnhaLayer == audioSpecificConfig.hilnEnhaLayer && this.hilnEnhaQuantMode == audioSpecificConfig.hilnEnhaQuantMode && this.hilnFrameLength == audioSpecificConfig.hilnFrameLength && this.hilnMaxNumLine == audioSpecificConfig.hilnMaxNumLine && this.hilnQuantMode == audioSpecificConfig.hilnQuantMode && this.hilnSampleRateCode == audioSpecificConfig.hilnSampleRateCode && this.hvxcRateMode == audioSpecificConfig.hvxcRateMode && this.hvxcVarMode == audioSpecificConfig.hvxcVarMode && this.isBaseLayer == audioSpecificConfig.isBaseLayer && this.layerNr == audioSpecificConfig.layerNr && this.layer_length == audioSpecificConfig.layer_length && this.numOfSubFrame == audioSpecificConfig.numOfSubFrame && this.paraExtensionFlag == audioSpecificConfig.paraExtensionFlag && this.paraMode == audioSpecificConfig.paraMode && this.parametricSpecificConfig == audioSpecificConfig.parametricSpecificConfig && this.psPresentFlag == audioSpecificConfig.psPresentFlag && this.sacPayloadEmbedding == audioSpecificConfig.sacPayloadEmbedding && this.samplingFrequency == audioSpecificConfig.samplingFrequency && this.samplingFrequencyIndex == audioSpecificConfig.samplingFrequencyIndex && this.sbrPresentFlag == audioSpecificConfig.sbrPresentFlag && this.syncExtensionType == audioSpecificConfig.syncExtensionType && this.var_ScalableFlag == audioSpecificConfig.var_ScalableFlag && Arrays.equals(this.configBytes, audioSpecificConfig.configBytes);
    }

    public int getChannelConfiguration() {
        return this.channelConfiguration;
    }

    public byte[] getConfigBytes() {
        return serializeConfigBytes().array();
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public int getContentSize() {
        int i = this.originalAudioObjectType > 30 ? 11 : 5;
        int i2 = i + 4;
        if (this.samplingFrequencyIndex == 15) {
            i2 = i + 28;
        }
        int iGaSpecificConfigSize = i2 + 4;
        int i3 = this.audioObjectType;
        if (i3 == 5 || i3 == 29) {
            iGaSpecificConfigSize = i2 + 8;
            if (this.extensionSamplingFrequencyIndex == 15) {
                iGaSpecificConfigSize = i2 + 32;
            }
        }
        if (i3 == 22) {
            iGaSpecificConfigSize += 4;
        }
        if (this.gaSpecificConfig) {
            iGaSpecificConfigSize += gaSpecificConfigSize();
        }
        int i4 = this.outerSyncExtensionType;
        if (i4 >= 0) {
            int i5 = iGaSpecificConfigSize + 11;
            if (i4 == 695) {
                int i6 = iGaSpecificConfigSize + 16;
                int i7 = this.extensionAudioObjectType;
                if (i7 > 30) {
                    i6 = iGaSpecificConfigSize + 22;
                }
                if (i7 == 5) {
                    iGaSpecificConfigSize = i6 + 1;
                    if (this.sbrPresentFlag) {
                        iGaSpecificConfigSize = i6 + 5;
                        if (this.extensionSamplingFrequencyIndex == 15) {
                            iGaSpecificConfigSize = i6 + 29;
                        }
                        int i8 = this.innerSyncExtensionType;
                        if (i8 >= 0) {
                            iGaSpecificConfigSize = i8 == 1352 ? iGaSpecificConfigSize + 12 : iGaSpecificConfigSize + 11;
                        }
                    }
                } else {
                    iGaSpecificConfigSize = i6;
                }
                if (i7 == 22) {
                    int i9 = iGaSpecificConfigSize + 1;
                    if (this.sbrPresentFlag) {
                        i9 = iGaSpecificConfigSize + 5;
                        if (this.extensionSamplingFrequencyIndex == 15) {
                            i9 = iGaSpecificConfigSize + 29;
                        }
                    }
                    iGaSpecificConfigSize = i9 + 4;
                }
            } else {
                iGaSpecificConfigSize = i5;
            }
        }
        return (int) Math.ceil(((double) iGaSpecificConfigSize) / 8.0d);
    }

    public int getExtensionAudioObjectType() {
        return this.extensionAudioObjectType;
    }

    public int getExtensionSamplingFrequency() {
        int i = this.extensionSamplingFrequencyIndex;
        return i == 15 ? this.extensionSamplingFrequency : samplingFrequencyIndexMap.get(Integer.valueOf(i)).intValue();
    }

    public int getSamplingFrequency() {
        int i = this.samplingFrequencyIndex;
        return i == 15 ? this.samplingFrequency : samplingFrequencyIndexMap.get(Integer.valueOf(i)).intValue();
    }

    public int hashCode() {
        byte[] bArr = this.configBytes;
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((bArr != null ? Arrays.hashCode(bArr) : 0) * 31) + this.audioObjectType) * 31) + this.samplingFrequencyIndex) * 31) + this.samplingFrequency) * 31) + this.channelConfiguration) * 31) + this.extensionAudioObjectType) * 31) + (this.sbrPresentFlag ? 1 : 0)) * 31) + (this.psPresentFlag ? 1 : 0)) * 31) + this.extensionSamplingFrequencyIndex) * 31) + this.extensionSamplingFrequency) * 31) + this.extensionChannelConfiguration) * 31) + this.sacPayloadEmbedding) * 31) + this.fillBits) * 31) + this.epConfig) * 31) + this.directMapping) * 31) + this.syncExtensionType) * 31) + this.frameLengthFlag) * 31) + this.dependsOnCoreCoder) * 31) + this.coreCoderDelay) * 31) + this.extensionFlag) * 31) + this.layerNr) * 31) + this.numOfSubFrame) * 31) + this.layer_length) * 31) + (this.aacSectionDataResilienceFlag ? 1 : 0)) * 31) + (this.aacScalefactorDataResilienceFlag ? 1 : 0)) * 31) + (this.aacSpectralDataResilienceFlag ? 1 : 0)) * 31) + this.extensionFlag3) * 31) + (this.gaSpecificConfig ? 1 : 0)) * 31) + this.isBaseLayer) * 31) + this.paraMode) * 31) + this.paraExtensionFlag) * 31) + this.hvxcVarMode) * 31) + this.hvxcRateMode) * 31) + this.erHvxcExtensionFlag) * 31) + this.var_ScalableFlag) * 31) + this.hilnQuantMode) * 31) + this.hilnMaxNumLine) * 31) + this.hilnSampleRateCode) * 31) + this.hilnFrameLength) * 31) + this.hilnContMode) * 31) + this.hilnEnhaLayer) * 31) + this.hilnEnhaQuantMode) * 31) + (this.parametricSpecificConfig ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0103  */
    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseDetail(ByteBuffer byteBuffer) {
        this.parsed = true;
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit(this.sizeOfInstance);
        byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
        byte[] bArr = new byte[this.sizeOfInstance];
        this.configBytes = bArr;
        byteBufferSlice.get(bArr);
        byteBufferSlice.rewind();
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBufferSlice);
        int audioObjectType = getAudioObjectType(bitReaderBuffer);
        this.audioObjectType = audioObjectType;
        this.originalAudioObjectType = audioObjectType;
        int bits = bitReaderBuffer.readBits(4);
        this.samplingFrequencyIndex = bits;
        if (bits == 15) {
            this.samplingFrequency = bitReaderBuffer.readBits(24);
        }
        this.channelConfiguration = bitReaderBuffer.readBits(4);
        int i = this.audioObjectType;
        if (i == 5 || i == 29) {
            this.extensionAudioObjectType = 5;
            this.sbrPresentFlag = true;
            if (i == 29) {
                this.psPresentFlag = true;
            }
            int bits2 = bitReaderBuffer.readBits(4);
            this.extensionSamplingFrequencyIndex = bits2;
            if (bits2 == 15) {
                this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
            }
            int audioObjectType2 = getAudioObjectType(bitReaderBuffer);
            this.audioObjectType = audioObjectType2;
            if (audioObjectType2 == 22) {
                this.extensionChannelConfiguration = bitReaderBuffer.readBits(4);
            }
        } else {
            this.extensionAudioObjectType = 0;
        }
        int i2 = this.audioObjectType;
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                parseGaSpecificConfig(this.samplingFrequencyIndex, this.channelConfiguration, i2, bitReaderBuffer);
                break;
            case 8:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse CelpSpecificConfig yet");
                return;
            case 9:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse HvxcSpecificConfig yet");
                return;
            case 12:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse TTSSpecificConfig yet");
                return;
            case 13:
            case 14:
            case 15:
            case 16:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse StructuredAudioSpecificConfig yet");
                return;
            case 24:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse ErrorResilientCelpSpecificConfig yet");
                return;
            case 25:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse ErrorResilientHvxcSpecificConfig yet");
                return;
            case 26:
            case 27:
                parseParametricSpecificConfig(this.samplingFrequencyIndex, this.channelConfiguration, i2, bitReaderBuffer);
                break;
            case 28:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse SSCSpecificConfig yet");
                return;
            case 30:
                this.sacPayloadEmbedding = bitReaderBuffer.readBits(1);
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse SpatialSpecificConfig yet");
                return;
            case 32:
            case 33:
            case 34:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse MPEG_1_2_SpecificConfig yet");
                return;
            case 35:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse DSTSpecificConfig yet");
                return;
            case 36:
                this.fillBits = bitReaderBuffer.readBits(5);
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse ALSSpecificConfig yet");
                return;
            case 37:
            case 38:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse SLSSpecificConfig yet");
                return;
            case 39:
                this.eldSpecificConfig = new ELDSpecificConfig(this.channelConfiguration, bitReaderBuffer);
                break;
            case 40:
            case 41:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse SymbolicMusicSpecificConfig yet");
                return;
        }
        int i3 = this.audioObjectType;
        if (i3 == 17 || i3 == 39) {
            int bits3 = bitReaderBuffer.readBits(2);
            this.epConfig = bits3;
            if (bits3 == 2 || bits3 == 3) {
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse ErrorProtectionSpecificConfig yet");
                return;
            } else if (bits3 == 3) {
                int bits4 = bitReaderBuffer.readBits(1);
                this.directMapping = bits4;
                if (bits4 == 0) {
                    Types$$ExternalSyntheticBUOutline0.m$2("not implemented");
                    return;
                }
            }
        } else {
            switch (i3) {
            }
        }
        if (this.extensionAudioObjectType == 5 || bitReaderBuffer.remainingBits() < 16) {
            return;
        }
        int bits5 = bitReaderBuffer.readBits(11);
        this.syncExtensionType = bits5;
        this.outerSyncExtensionType = bits5;
        if (bits5 == 695) {
            int audioObjectType3 = getAudioObjectType(bitReaderBuffer);
            this.extensionAudioObjectType = audioObjectType3;
            if (audioObjectType3 == 5) {
                boolean bool = bitReaderBuffer.readBool();
                this.sbrPresentFlag = bool;
                if (bool) {
                    int bits6 = bitReaderBuffer.readBits(4);
                    this.extensionSamplingFrequencyIndex = bits6;
                    if (bits6 == 15) {
                        this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                    }
                    if (bitReaderBuffer.remainingBits() >= 12) {
                        int bits7 = bitReaderBuffer.readBits(11);
                        this.syncExtensionType = bits7;
                        this.innerSyncExtensionType = bits7;
                        if (bits7 == 1352) {
                            this.psPresentFlag = bitReaderBuffer.readBool();
                        }
                    }
                }
            }
            if (this.extensionAudioObjectType == 22) {
                boolean bool2 = bitReaderBuffer.readBool();
                this.sbrPresentFlag = bool2;
                if (bool2) {
                    int bits8 = bitReaderBuffer.readBits(4);
                    this.extensionSamplingFrequencyIndex = bits8;
                    if (bits8 == 15) {
                        this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                    }
                }
                this.extensionChannelConfiguration = bitReaderBuffer.readBits(4);
            }
        }
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public ByteBuffer serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getSize());
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.tag);
        writeSize(byteBufferAllocate, getContentSize());
        byteBufferAllocate.put(serializeConfigBytes());
        return (ByteBuffer) byteBufferAllocate.rewind();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ByteBuffer serializeConfigBytes() {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[getContentSize()]);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBufferWrap);
        writeAudioObjectType(this.originalAudioObjectType, bitWriterBuffer);
        bitWriterBuffer.writeBits(this.samplingFrequencyIndex, 4);
        if (this.samplingFrequencyIndex == 15) {
            bitWriterBuffer.writeBits(this.samplingFrequency, 24);
        }
        bitWriterBuffer.writeBits(this.channelConfiguration, 4);
        int i = this.audioObjectType;
        if (i == 5 || i == 29) {
            this.extensionAudioObjectType = 5;
            this.sbrPresentFlag = true;
            if (i == 29) {
                this.psPresentFlag = true;
            }
            bitWriterBuffer.writeBits(this.extensionSamplingFrequencyIndex, 4);
            if (this.extensionSamplingFrequencyIndex == 15) {
                bitWriterBuffer.writeBits(this.extensionSamplingFrequency, 24);
            }
            writeAudioObjectType(this.audioObjectType, bitWriterBuffer);
            if (this.audioObjectType == 22) {
                bitWriterBuffer.writeBits(this.extensionChannelConfiguration, 4);
            }
        }
        switch (this.audioObjectType) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                writeGaSpecificConfig(bitWriterBuffer);
                break;
            case 8:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write CelpSpecificConfig yet");
                return null;
            case 9:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write HvxcSpecificConfig yet");
                return null;
            case 12:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write TTSSpecificConfig yet");
                return null;
            case 13:
            case 14:
            case 15:
            case 16:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write StructuredAudioSpecificConfig yet");
                return null;
            case 24:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write ErrorResilientCelpSpecificConfig yet");
                return null;
            case 25:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write ErrorResilientHvxcSpecificConfig yet");
                return null;
            case 26:
            case 27:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write parseParametricSpecificConfig yet");
                return null;
            case 28:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write SSCSpecificConfig yet");
                return null;
            case 30:
                bitWriterBuffer.writeBits(this.sacPayloadEmbedding, 1);
                Utf8$$ExternalSyntheticBUOutline0.m("can't write SpatialSpecificConfig yet");
                return null;
            case 32:
            case 33:
            case 34:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write MPEG_1_2_SpecificConfig yet");
                return null;
            case 35:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write DSTSpecificConfig yet");
                return null;
            case 36:
                bitWriterBuffer.writeBits(this.fillBits, 5);
                Utf8$$ExternalSyntheticBUOutline0.m("can't write ALSSpecificConfig yet");
                return null;
            case 37:
            case 38:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write SLSSpecificConfig yet");
                return null;
            case 39:
                Utf8$$ExternalSyntheticBUOutline0.m("can't write ELDSpecificConfig yet");
                return null;
            case 40:
            case 41:
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse SymbolicMusicSpecificConfig yet");
                return null;
        }
        int i2 = this.audioObjectType;
        if (i2 == 17 || i2 == 39) {
            bitWriterBuffer.writeBits(this.epConfig, 2);
            int i3 = this.epConfig;
            if (i3 == 2 || i3 == 3) {
                Utf8$$ExternalSyntheticBUOutline0.m("can't parse ErrorProtectionSpecificConfig yet");
                return null;
            }
            if (i3 == 3) {
                bitWriterBuffer.writeBits(this.directMapping, 1);
                if (this.directMapping == 0) {
                    Types$$ExternalSyntheticBUOutline0.m$2("not implemented");
                    return null;
                }
            }
        } else {
            switch (i2) {
            }
        }
        int i4 = this.outerSyncExtensionType;
        if (i4 >= 0) {
            bitWriterBuffer.writeBits(i4, 11);
            if (this.outerSyncExtensionType == 695) {
                writeAudioObjectType(this.extensionAudioObjectType, bitWriterBuffer);
                if (this.extensionAudioObjectType == 5) {
                    bitWriterBuffer.writeBool(this.sbrPresentFlag);
                    if (this.sbrPresentFlag) {
                        bitWriterBuffer.writeBits(this.extensionSamplingFrequencyIndex, 4);
                        if (this.extensionSamplingFrequencyIndex == 15) {
                            bitWriterBuffer.writeBits(this.extensionSamplingFrequency, 24);
                        }
                        int i5 = this.innerSyncExtensionType;
                        if (i5 >= 0) {
                            bitWriterBuffer.writeBits(i5, 11);
                            if (this.syncExtensionType == 1352) {
                                bitWriterBuffer.writeBool(this.psPresentFlag);
                            }
                        }
                    }
                }
                if (this.extensionAudioObjectType == 22) {
                    bitWriterBuffer.writeBool(this.sbrPresentFlag);
                    if (this.sbrPresentFlag) {
                        bitWriterBuffer.writeBits(this.extensionSamplingFrequencyIndex, 4);
                        if (this.extensionSamplingFrequencyIndex == 15) {
                            bitWriterBuffer.writeBits(this.extensionSamplingFrequency, 24);
                        }
                    }
                    bitWriterBuffer.writeBits(this.extensionChannelConfiguration, 4);
                }
            }
        }
        return (ByteBuffer) byteBufferWrap.rewind();
    }

    public void setAudioObjectType(int i) {
        this.audioObjectType = i;
    }

    public void setChannelConfiguration(int i) {
        this.channelConfiguration = i;
    }

    public void setOriginalAudioObjectType(int i) {
        this.originalAudioObjectType = i;
    }

    public void setSamplingFrequency(int i) {
        this.samplingFrequency = i;
    }

    public void setSamplingFrequencyIndex(int i) {
        this.samplingFrequencyIndex = i;
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder("AudioSpecificConfig{configBytes=");
        sb.append(Hex.encodeHex(this.configBytes));
        sb.append(", audioObjectType=");
        sb.append(this.audioObjectType);
        sb.append(" (");
        sb.append(audioObjectTypeMap.get(Integer.valueOf(this.audioObjectType)));
        sb.append("), samplingFrequencyIndex=");
        sb.append(this.samplingFrequencyIndex);
        sb.append(" (");
        sb.append(samplingFrequencyIndexMap.get(Integer.valueOf(this.samplingFrequencyIndex)));
        sb.append("), samplingFrequency=");
        sb.append(this.samplingFrequency);
        sb.append(", channelConfiguration=");
        sb.append(this.channelConfiguration);
        if (this.extensionAudioObjectType > 0) {
            sb.append(", extensionAudioObjectType=");
            sb.append(this.extensionAudioObjectType);
            sb.append(" (");
            sb.append(audioObjectTypeMap.get(Integer.valueOf(this.extensionAudioObjectType)));
            sb.append("), sbrPresentFlag=");
            sb.append(this.sbrPresentFlag);
            sb.append(", psPresentFlag=");
            sb.append(this.psPresentFlag);
            sb.append(", extensionSamplingFrequencyIndex=");
            sb.append(this.extensionSamplingFrequencyIndex);
            sb.append(" (");
            sb.append(samplingFrequencyIndexMap.get(Integer.valueOf(this.extensionSamplingFrequencyIndex)));
            sb.append("), extensionSamplingFrequency=");
            sb.append(this.extensionSamplingFrequency);
            sb.append(", extensionChannelConfiguration=");
            sb.append(this.extensionChannelConfiguration);
        }
        sb.append(", syncExtensionType=");
        sb.append(this.syncExtensionType);
        if (this.gaSpecificConfig) {
            sb.append(", frameLengthFlag=");
            sb.append(this.frameLengthFlag);
            sb.append(", dependsOnCoreCoder=");
            sb.append(this.dependsOnCoreCoder);
            sb.append(", coreCoderDelay=");
            sb.append(this.coreCoderDelay);
            sb.append(", extensionFlag=");
            sb.append(this.extensionFlag);
            sb.append(", layerNr=");
            sb.append(this.layerNr);
            sb.append(", numOfSubFrame=");
            sb.append(this.numOfSubFrame);
            sb.append(", layer_length=");
            sb.append(this.layer_length);
            sb.append(", aacSectionDataResilienceFlag=");
            sb.append(this.aacSectionDataResilienceFlag);
            sb.append(", aacScalefactorDataResilienceFlag=");
            sb.append(this.aacScalefactorDataResilienceFlag);
            sb.append(", aacSpectralDataResilienceFlag=");
            sb.append(this.aacSpectralDataResilienceFlag);
            sb.append(", extensionFlag3=");
            sb.append(this.extensionFlag3);
        }
        if (this.parametricSpecificConfig) {
            sb.append(", isBaseLayer=");
            sb.append(this.isBaseLayer);
            sb.append(", paraMode=");
            sb.append(this.paraMode);
            sb.append(", paraExtensionFlag=");
            sb.append(this.paraExtensionFlag);
            sb.append(", hvxcVarMode=");
            sb.append(this.hvxcVarMode);
            sb.append(", hvxcRateMode=");
            sb.append(this.hvxcRateMode);
            sb.append(", erHvxcExtensionFlag=");
            sb.append(this.erHvxcExtensionFlag);
            sb.append(", var_ScalableFlag=");
            sb.append(this.var_ScalableFlag);
            sb.append(", hilnQuantMode=");
            sb.append(this.hilnQuantMode);
            sb.append(", hilnMaxNumLine=");
            sb.append(this.hilnMaxNumLine);
            sb.append(", hilnSampleRateCode=");
            sb.append(this.hilnSampleRateCode);
            sb.append(", hilnFrameLength=");
            sb.append(this.hilnFrameLength);
            sb.append(", hilnContMode=");
            sb.append(this.hilnContMode);
            sb.append(", hilnEnhaLayer=");
            sb.append(this.hilnEnhaLayer);
            sb.append(", hilnEnhaQuantMode=");
            sb.append(this.hilnEnhaQuantMode);
        }
        sb.append('}');
        return sb.toString();
    }

    public int getAudioObjectType() {
        return this.audioObjectType;
    }
}
