package org.mp4parser.muxer.tracks;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.AudioSpecificConfig;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.DecoderConfigDescriptor;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.ESDescriptor;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.SLConfigDescriptor;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;
import org.mp4parser.boxes.iso14496.part14.ESDescriptorBox;
import org.mp4parser.boxes.sampleentry.AudioSampleEntry;
import org.mp4parser.boxes.sampleentry.SampleEntry;
import org.mp4parser.muxer.AbstractTrack;
import org.mp4parser.muxer.DataSource;
import org.mp4parser.muxer.Sample;
import org.mp4parser.muxer.TrackMetaData;

/* JADX INFO: loaded from: classes5.dex */
public class AACTrackImpl extends AbstractTrack {
    public static final Map<Integer, Integer> SAMPLING_FREQUENCY_INDEX_MAP;
    static Map<Integer, String> audioObjectTypes;
    private AudioSampleEntry audioSampleEntry;
    private long avgBitRate;
    private int bufferSizeDB;
    private DataSource dataSource;
    private long[] decTimes;
    private AdtsHeader firstHeader;
    private long maxBitRate;
    private List<Sample> samples;
    TrackMetaData trackMetaData;

    public class AdtsHeader {
        int bufferFullness;
        int channelconfig;
        int copyrightStart;
        int copyrightedStream;
        int frameLength;
        int home;
        int layer;
        int mpegVersion;
        int numAacFramesPerAdtsFrame;
        int original;
        int profile;
        int protectionAbsent;
        int sampleFrequencyIndex;
        int sampleRate;

        public AdtsHeader() {
        }

        public int getSize() {
            return (this.protectionAbsent == 0 ? 2 : 0) + 7;
        }
    }

    static {
        HashMap map = new HashMap();
        SAMPLING_FREQUENCY_INDEX_MAP = map;
        HashMap map2 = new HashMap();
        audioObjectTypes = map2;
        map2.put(1, "AAC Main");
        audioObjectTypes.put(2, "AAC LC (Low Complexity)");
        audioObjectTypes.put(3, "AAC SSR (Scalable Sample Rate)");
        audioObjectTypes.put(4, "AAC LTP (Long Term Prediction)");
        audioObjectTypes.put(5, "SBR (Spectral Band Replication)");
        audioObjectTypes.put(6, "AAC Scalable");
        audioObjectTypes.put(7, "TwinVQ");
        audioObjectTypes.put(8, "CELP (Code Excited Linear Prediction)");
        audioObjectTypes.put(9, "HXVC (Harmonic Vector eXcitation Coding)");
        audioObjectTypes.put(10, "Reserved");
        audioObjectTypes.put(11, "Reserved");
        audioObjectTypes.put(12, "TTSI (Text-To-Speech Interface)");
        audioObjectTypes.put(13, "Main Synthesis");
        audioObjectTypes.put(14, "Wavetable Synthesis");
        audioObjectTypes.put(15, "General MIDI");
        audioObjectTypes.put(16, "Algorithmic Synthesis and Audio Effects");
        audioObjectTypes.put(17, "ER (Error Resilient) AAC LC");
        audioObjectTypes.put(18, "Reserved");
        audioObjectTypes.put(19, "ER AAC LTP");
        audioObjectTypes.put(20, "ER AAC Scalable");
        audioObjectTypes.put(21, "ER TwinVQ");
        audioObjectTypes.put(22, "ER BSAC (Bit-Sliced Arithmetic Coding)");
        audioObjectTypes.put(23, "ER AAC LD (Low Delay)");
        audioObjectTypes.put(24, "ER CELP");
        audioObjectTypes.put(25, "ER HVXC");
        audioObjectTypes.put(26, "ER HILN (Harmonic and Individual Lines plus Noise)");
        audioObjectTypes.put(27, "ER Parametric");
        audioObjectTypes.put(28, "SSC (SinuSoidal Coding)");
        audioObjectTypes.put(29, "PS (Parametric Stereo)");
        audioObjectTypes.put(30, "MPEG Surround");
        audioObjectTypes.put(31, "(Escape value)");
        audioObjectTypes.put(32, "Layer-1");
        audioObjectTypes.put(33, "Layer-2");
        audioObjectTypes.put(34, "Layer-3");
        audioObjectTypes.put(35, "DST (Direct Stream Transfer)");
        audioObjectTypes.put(36, "ALS (Audio Lossless)");
        audioObjectTypes.put(37, "SLS (Scalable LosslesS)");
        audioObjectTypes.put(38, "SLS non-core");
        audioObjectTypes.put(39, "ER AAC ELD (Enhanced Low Delay)");
        audioObjectTypes.put(40, "SMR (Symbolic Music Representation) Simple");
        audioObjectTypes.put(41, "SMR Main");
        audioObjectTypes.put(42, "USAC (Unified Speech and Audio Coding) (no SBR)");
        audioObjectTypes.put(43, "SAOC (Spatial Audio Object Coding)");
        audioObjectTypes.put(44, "LD MPEG Surround");
        audioObjectTypes.put(45, "USAC");
        map.put(96000, 0);
        map.put(88200, 1);
        map.put(64000, 2);
        map.put(48000, 3);
        map.put(44100, 4);
        map.put(32000, 5);
        map.put(24000, 6);
        map.put(22050, 7);
        map.put(16000, 8);
        map.put(12000, 9);
        map.put(11025, 10);
        map.put(8000, 11);
        map.put(0, 96000);
        map.put(1, 88200);
        map.put(2, 64000);
        map.put(3, 48000);
        map.put(4, 44100);
        map.put(5, 32000);
        map.put(6, 24000);
        map.put(7, 22050);
        map.put(8, 16000);
        map.put(9, 12000);
        map.put(10, 11025);
        map.put(11, 8000);
    }

    public AACTrackImpl(DataSource dataSource, String str) throws IOException {
        super(dataSource.toString());
        this.trackMetaData = new TrackMetaData();
        this.dataSource = dataSource;
        this.samples = new ArrayList();
        AdtsHeader samples = readSamples(dataSource);
        this.firstHeader = samples;
        double d = ((double) samples.sampleRate) / 1024.0d;
        double size = ((double) this.samples.size()) / d;
        LinkedList linkedList = new LinkedList();
        Iterator<Sample> it = this.samples.iterator();
        long j = 0;
        while (true) {
            int iIntValue = 0;
            if (!it.hasNext()) {
                break;
            }
            int size2 = (int) it.next().getSize();
            j += (long) size2;
            linkedList.add(Integer.valueOf(size2));
            while (linkedList.size() > d) {
                linkedList.pop();
            }
            if (linkedList.size() == ((int) d)) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    iIntValue += ((Integer) it2.next()).intValue();
                }
                if (((((double) iIntValue) * 8.0d) / ((double) linkedList.size())) * d > this.maxBitRate) {
                    this.maxBitRate = (int) r7;
                }
            }
        }
        this.avgBitRate = (int) ((j * 8) / size);
        this.bufferSizeDB = 1536;
        AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
        this.audioSampleEntry = audioSampleEntry;
        int i = this.firstHeader.channelconfig;
        if (i == 7) {
            audioSampleEntry.setChannelCount(8);
        } else {
            audioSampleEntry.setChannelCount(i);
        }
        this.audioSampleEntry.setSampleRate(this.firstHeader.sampleRate);
        this.audioSampleEntry.setDataReferenceIndex(1);
        this.audioSampleEntry.setSampleSize(16);
        ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
        ESDescriptor eSDescriptor = new ESDescriptor();
        eSDescriptor.setEsId(0);
        SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
        sLConfigDescriptor.setPredefined(2);
        eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
        DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
        decoderConfigDescriptor.setObjectTypeIndication(64);
        decoderConfigDescriptor.setStreamType(5);
        decoderConfigDescriptor.setBufferSizeDB(this.bufferSizeDB);
        decoderConfigDescriptor.setMaxBitRate(this.maxBitRate);
        decoderConfigDescriptor.setAvgBitRate(this.avgBitRate);
        AudioSpecificConfig audioSpecificConfig = new AudioSpecificConfig();
        audioSpecificConfig.setOriginalAudioObjectType(2);
        audioSpecificConfig.setSamplingFrequencyIndex(this.firstHeader.sampleFrequencyIndex);
        audioSpecificConfig.setChannelConfiguration(this.firstHeader.channelconfig);
        decoderConfigDescriptor.setAudioSpecificInfo(audioSpecificConfig);
        eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
        eSDescriptorBox.setEsDescriptor(eSDescriptor);
        this.audioSampleEntry.addBox(eSDescriptorBox);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(str);
        this.trackMetaData.setVolume(1.0f);
        this.trackMetaData.setTimescale(this.firstHeader.sampleRate);
        long[] jArr = new long[this.samples.size()];
        this.decTimes = jArr;
        Arrays.fill(jArr, 1024L);
    }

    private AdtsHeader readADTSHeader(DataSource dataSource) throws IOException {
        AdtsHeader adtsHeader = new AdtsHeader();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(7);
        while (byteBufferAllocate.position() < 7) {
            if (dataSource.read(byteBufferAllocate) == -1) {
                return null;
            }
        }
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) byteBufferAllocate.rewind());
        if (bitReaderBuffer.readBits(12) != 4095) {
            OggIO$$ExternalSyntheticBUOutline0.m("Expected Start Word 0xfff");
            return null;
        }
        adtsHeader.mpegVersion = bitReaderBuffer.readBits(1);
        adtsHeader.layer = bitReaderBuffer.readBits(2);
        adtsHeader.protectionAbsent = bitReaderBuffer.readBits(1);
        adtsHeader.profile = bitReaderBuffer.readBits(2) + 1;
        int bits = bitReaderBuffer.readBits(4);
        adtsHeader.sampleFrequencyIndex = bits;
        adtsHeader.sampleRate = SAMPLING_FREQUENCY_INDEX_MAP.get(Integer.valueOf(bits)).intValue();
        bitReaderBuffer.readBits(1);
        adtsHeader.channelconfig = bitReaderBuffer.readBits(3);
        adtsHeader.original = bitReaderBuffer.readBits(1);
        adtsHeader.home = bitReaderBuffer.readBits(1);
        adtsHeader.copyrightedStream = bitReaderBuffer.readBits(1);
        adtsHeader.copyrightStart = bitReaderBuffer.readBits(1);
        adtsHeader.frameLength = bitReaderBuffer.readBits(13);
        adtsHeader.bufferFullness = bitReaderBuffer.readBits(11);
        int bits2 = bitReaderBuffer.readBits(2) + 1;
        adtsHeader.numAacFramesPerAdtsFrame = bits2;
        if (bits2 != 1) {
            OggIO$$ExternalSyntheticBUOutline0.m("This muxer can only work with 1 AAC frame per ADTS frame");
            return null;
        }
        if (adtsHeader.protectionAbsent == 0) {
            dataSource.read(ByteBuffer.allocate(2));
        }
        return adtsHeader;
    }

    private AdtsHeader readSamples(DataSource dataSource) throws IOException {
        AdtsHeader adtsHeader = null;
        while (true) {
            AdtsHeader aDTSHeader = this.readADTSHeader(dataSource);
            if (aDTSHeader == null) {
                return adtsHeader;
            }
            if (adtsHeader == null) {
                adtsHeader = aDTSHeader;
            }
            final long jPosition = dataSource.position();
            final long size = aDTSHeader.frameLength - aDTSHeader.getSize();
            AACTrackImpl aACTrackImpl = this;
            this.samples.add(new Sample() { // from class: org.mp4parser.muxer.tracks.AACTrackImpl.1
                @Override // org.mp4parser.muxer.Sample
                public SampleEntry getSampleEntry() {
                    return AACTrackImpl.this.audioSampleEntry;
                }

                @Override // org.mp4parser.muxer.Sample
                public long getSize() {
                    return size;
                }

                @Override // org.mp4parser.muxer.Sample
                public void writeTo(WritableByteChannel writableByteChannel) {
                    AACTrackImpl.this.dataSource.transferTo(jPosition, size, writableByteChannel);
                }
            });
            dataSource.position((dataSource.position() + ((long) aDTSHeader.frameLength)) - ((long) aDTSHeader.getSize()));
            this = aACTrackImpl;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.dataSource.close();
    }

    @Override // org.mp4parser.muxer.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // org.mp4parser.muxer.Track
    public String getHandler() {
        return "soun";
    }

    @Override // org.mp4parser.muxer.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }

    @Override // org.mp4parser.muxer.Track
    public long[] getSampleDurations() {
        return this.decTimes;
    }

    @Override // org.mp4parser.muxer.Track
    public List<SampleEntry> getSampleEntries() {
        return Collections.singletonList(this.audioSampleEntry);
    }

    @Override // org.mp4parser.muxer.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // org.mp4parser.muxer.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    @Override // org.mp4parser.muxer.Track
    public long[] getSyncSamples() {
        return null;
    }

    @Override // org.mp4parser.muxer.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AACTrackImpl{sampleRate=");
        sb.append(this.firstHeader.sampleRate);
        sb.append(", channelconfig=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.firstHeader.channelconfig, '}');
    }

    public AACTrackImpl(DataSource dataSource) {
        this(dataSource, "eng");
    }
}
