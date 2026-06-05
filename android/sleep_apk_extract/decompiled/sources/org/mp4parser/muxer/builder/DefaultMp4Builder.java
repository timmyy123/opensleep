package org.mp4parser.muxer.builder;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mp4parser.BasicContainer;
import org.mp4parser.Box;
import org.mp4parser.Container;
import org.mp4parser.IsoFile;
import org.mp4parser.ParsableBox;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.DataEntryUrlBox;
import org.mp4parser.boxes.iso14496.part12.DataInformationBox;
import org.mp4parser.boxes.iso14496.part12.DataReferenceBox;
import org.mp4parser.boxes.iso14496.part12.EditBox;
import org.mp4parser.boxes.iso14496.part12.EditListBox;
import org.mp4parser.boxes.iso14496.part12.FileTypeBox;
import org.mp4parser.boxes.iso14496.part12.HandlerBox;
import org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MediaBox;
import org.mp4parser.boxes.iso14496.part12.MediaDataBox;
import org.mp4parser.boxes.iso14496.part12.MediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MediaInformationBox;
import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mp4parser.boxes.iso14496.part12.MovieHeaderBox;
import org.mp4parser.boxes.iso14496.part12.NullMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.part12.SampleSizeBox;
import org.mp4parser.boxes.iso14496.part12.SampleTableBox;
import org.mp4parser.boxes.iso14496.part12.SampleToChunkBox;
import org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox;
import org.mp4parser.boxes.iso14496.part12.SubtitleMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.SyncSampleBox;
import org.mp4parser.boxes.iso14496.part12.TimeToSampleBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;
import org.mp4parser.boxes.iso14496.part12.TrackHeaderBox;
import org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox;
import org.mp4parser.boxes.sampleentry.SampleEntry;
import org.mp4parser.boxes.sampleentry.VisualSampleEntry;
import org.mp4parser.boxes.samplegrouping.GroupEntry;
import org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox;
import org.mp4parser.boxes.samplegrouping.SampleToGroupBox;
import org.mp4parser.muxer.Movie;
import org.mp4parser.muxer.Sample;
import org.mp4parser.muxer.Track;
import org.mp4parser.tools.CastUtils;
import org.mp4parser.tools.IsoTypeWriter;
import org.mp4parser.tools.Mp4Arrays;
import org.mp4parser.tools.Mp4Math;
import org.mp4parser.tools.Offsets;
import org.mp4parser.tools.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultMp4Builder {
    private static Logger LOG = LoggerFactory.getLogger((Class<?>) DefaultMp4Builder.class);
    private Fragmenter fragmenter;
    Map<Track, StaticChunkOffsetBox> chunkOffsetBoxes = new HashMap();
    Set<SampleAuxiliaryInformationOffsetsBox> sampleAuxiliaryInformationOffsetsBoxes = new HashSet();
    HashMap<Track, List<Sample>> track2Sample = new HashMap<>();
    HashMap<Track, long[]> track2SampleSizes = new HashMap<>();

    public class InterleaveChunkMdat implements Box {
        List<List<Sample>> chunkList;
        long contentSize;
        final /* synthetic */ DefaultMp4Builder this$0;
        List<Track> tracks;

        private InterleaveChunkMdat(final DefaultMp4Builder defaultMp4Builder, Movie movie, Map<Track, int[]> map, long j) {
            int i;
            Map<Track, int[]> map2 = map;
            this.this$0 = defaultMp4Builder;
            this.chunkList = new ArrayList();
            this.contentSize = j;
            this.tracks = movie.getTracks();
            ArrayList<Track> arrayList = new ArrayList(map2.keySet());
            Collections.sort(arrayList, new Comparator<Track>() { // from class: org.mp4parser.muxer.builder.DefaultMp4Builder.InterleaveChunkMdat.1
                @Override // java.util.Comparator
                public int compare(Track track, Track track2) {
                    return CastUtils.l2i(track.getTrackMetaData().getTrackId() - track2.getTrackMetaData().getTrackId());
                }
            });
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            for (Track track : arrayList) {
                map3.put(track, 0);
                map4.put(track, 0);
                map5.put(track, Double.valueOf(0.0d));
            }
            while (true) {
                Track track2 = null;
                for (Track track3 : arrayList) {
                    if (track2 == null || ((Double) map5.get(track3)).doubleValue() < ((Double) map5.get(track2)).doubleValue()) {
                        if (((Integer) map3.get(track3)).intValue() < map2.get(track3).length) {
                            track2 = track3;
                        }
                    }
                }
                if (track2 == null) {
                    return;
                }
                int iIntValue = ((Integer) map3.get(track2)).intValue();
                int i2 = map2.get(track2)[iIntValue];
                int iIntValue2 = ((Integer) map4.get(track2)).intValue();
                double dDoubleValue = ((Double) map5.get(track2)).doubleValue();
                int i3 = iIntValue2;
                while (true) {
                    i = iIntValue2 + i2;
                    if (i3 < i) {
                        dDoubleValue += track2.getSampleDurations()[i3] / track2.getTrackMetaData().getTimescale();
                        i3++;
                        iIntValue = iIntValue;
                    }
                }
                this.chunkList.add(track2.getSamples().subList(iIntValue2, i));
                map3.put(track2, Integer.valueOf(iIntValue + 1));
                map4.put(track2, Integer.valueOf(i));
                map5.put(track2, Double.valueOf(dDoubleValue));
                map2 = map;
            }
        }

        private boolean isSmallBox(long j) {
            return j + 8 < 4294967296L;
        }

        @Override // org.mp4parser.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            long size = getSize();
            if (isSmallBox(size)) {
                IsoTypeWriter.writeUInt32(byteBufferAllocate, size);
            } else {
                IsoTypeWriter.writeUInt32(byteBufferAllocate, 1L);
            }
            byteBufferAllocate.put(IsoFile.fourCCtoBytes(MediaDataBox.TYPE));
            if (isSmallBox(size)) {
                byteBufferAllocate.put(new byte[8]);
            } else {
                IsoTypeWriter.writeUInt64(byteBufferAllocate, size);
            }
            byteBufferAllocate.rewind();
            writableByteChannel.write(byteBufferAllocate);
            DefaultMp4Builder.LOG.debug("About to write {}", Long.valueOf(this.contentSize));
            Iterator<List<Sample>> it = this.chunkList.iterator();
            long j = 0;
            long j2 = 0;
            while (it.hasNext()) {
                for (Sample sample : it.next()) {
                    sample.writeTo(writableByteChannel);
                    long size2 = sample.getSize() + j;
                    if (size2 > 1048576) {
                        size2 -= 1048576;
                        j2++;
                        DefaultMp4Builder.LOG.debug("Written {} MB", Long.valueOf(j2));
                    }
                    j = size2;
                }
            }
        }

        @Override // org.mp4parser.Box
        public long getSize() {
            return this.contentSize + 16;
        }

        @Override // org.mp4parser.Box
        public String getType() {
            return MediaDataBox.TYPE;
        }
    }

    private static long sum(long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    public Container build(Movie movie) {
        if (this.fragmenter == null) {
            this.fragmenter = new DefaultFragmenterImpl(2.0d);
        }
        LOG.debug("Creating movie {}", movie);
        Iterator<Track> it = movie.getTracks().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Track next = it.next();
            List<Sample> samples = next.getSamples();
            putSamples(next, samples);
            int size = samples.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = samples.get(i).getSize();
            }
            this.track2SampleSizes.put(next, jArr);
        }
        BasicContainer basicContainer = new BasicContainer();
        basicContainer.addBox(createFileTypeBox(movie));
        HashMap map = new HashMap();
        for (Track track : movie.getTracks()) {
            map.put(track, getChunkSizes(track));
        }
        MovieBox movieBoxCreateMovieBox = createMovieBox(movie, map);
        basicContainer.addBox(movieBoxCreateMovieBox);
        Iterator it2 = Path.getPaths((Box) movieBoxCreateMovieBox, "trak/mdia/minf/stbl/stsz").iterator();
        long jSum = 0;
        while (it2.hasNext()) {
            jSum += sum(((SampleSizeBox) it2.next()).getSampleSizes());
        }
        LOG.debug("About to create mdat");
        InterleaveChunkMdat interleaveChunkMdat = new InterleaveChunkMdat(movie, map, jSum);
        Iterator<Box> it3 = basicContainer.getBoxes().iterator();
        long size2 = 16;
        while (it3.hasNext()) {
            size2 += it3.next().getSize();
        }
        basicContainer.addBox(interleaveChunkMdat);
        LOG.debug("mdat crated");
        Iterator<StaticChunkOffsetBox> it4 = this.chunkOffsetBoxes.values().iterator();
        while (it4.hasNext()) {
            long[] chunkOffsets = it4.next().getChunkOffsets();
            for (int i2 = 0; i2 < chunkOffsets.length; i2++) {
                chunkOffsets[i2] = chunkOffsets[i2] + size2;
            }
        }
        for (SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox : this.sampleAuxiliaryInformationOffsetsBoxes) {
            long jFind = Offsets.find(basicContainer, sampleAuxiliaryInformationOffsetsBox, sampleAuxiliaryInformationOffsetsBox.getSize() + 44);
            long[] offsets = sampleAuxiliaryInformationOffsetsBox.getOffsets();
            for (int i3 = 0; i3 < offsets.length; i3++) {
                offsets[i3] = offsets[i3] + jFind;
            }
            sampleAuxiliaryInformationOffsetsBox.setOffsets(offsets);
        }
        return basicContainer;
    }

    public void createCtts(Track track, SampleTableBox sampleTableBox) {
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        if (compositionTimeEntries == null || compositionTimeEntries.isEmpty()) {
            return;
        }
        CompositionTimeToSample compositionTimeToSample = new CompositionTimeToSample();
        compositionTimeToSample.setEntries(compositionTimeEntries);
        sampleTableBox.addBox(compositionTimeToSample);
    }

    public ParsableBox createEdts(Track track, Movie movie) {
        if (track.getEdits() == null || track.getEdits().size() <= 0) {
            return null;
        }
        EditListBox editListBox = new EditListBox();
        editListBox.setVersion(0);
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = track.getEdits().iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        editListBox.setEntries(arrayList);
        EditBox editBox = new EditBox();
        editBox.addBox(editListBox);
        return editBox;
    }

    public FileTypeBox createFileTypeBox(Movie movie) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("mp42");
        linkedList.add("iso6");
        linkedList.add(VisualSampleEntry.TYPE3);
        linkedList.add("isom");
        return new FileTypeBox("iso6", 1L, linkedList);
    }

    public MovieBox createMovieBox(Movie movie, Map<Track, int[]> map) {
        long duration;
        MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setCreationTime(new Date());
        movieHeaderBox.setModificationTime(new Date());
        movieHeaderBox.setMatrix(movie.getMatrix());
        long timescale = getTimescale(movie);
        long trackId = 0;
        long j = 0;
        for (Track track : movie.getTracks()) {
            if (track.getEdits() == null || track.getEdits().isEmpty()) {
                duration = (track.getDuration() * timescale) / track.getTrackMetaData().getTimescale();
            } else {
                Iterator<Object> it = track.getEdits().iterator();
                if (it.hasNext()) {
                    throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
                }
                duration = (long) (0.0d * timescale);
            }
            if (duration > j) {
                j = duration;
            }
        }
        movieHeaderBox.setDuration(j);
        movieHeaderBox.setTimescale(timescale);
        for (Track track2 : movie.getTracks()) {
            if (trackId < track2.getTrackMetaData().getTrackId()) {
                trackId = track2.getTrackMetaData().getTrackId();
            }
        }
        movieHeaderBox.setNextTrackId(trackId + 1);
        movieBox.addBox(movieHeaderBox);
        Iterator<Track> it2 = movie.getTracks().iterator();
        while (it2.hasNext()) {
            movieBox.addBox(createTrackBox(it2.next(), movie, map));
        }
        ParsableBox parsableBoxCreateUdta = createUdta(movie);
        if (parsableBoxCreateUdta != null) {
            movieBox.addBox(parsableBoxCreateUdta);
        }
        return movieBox;
    }

    public void createSdtp(Track track, SampleTableBox sampleTableBox) {
        if (track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) {
            return;
        }
        SampleDependencyTypeBox sampleDependencyTypeBox = new SampleDependencyTypeBox();
        sampleDependencyTypeBox.setEntries(track.getSampleDependencies());
        sampleTableBox.addBox(sampleDependencyTypeBox);
    }

    public ParsableBox createStbl(Track track, Movie movie, Map<Track, int[]> map) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        createStsd(track, sampleTableBox);
        createStts(track, sampleTableBox);
        createCtts(track, sampleTableBox);
        createStss(track, sampleTableBox);
        createSdtp(track, sampleTableBox);
        createStsc(track, map, sampleTableBox);
        createStsz(track, sampleTableBox);
        createStco(track, movie, map, sampleTableBox);
        HashMap map2 = new HashMap();
        for (Map.Entry<GroupEntry, long[]> entry : track.getSampleGroups().entrySet()) {
            String type = entry.getKey().getType();
            List arrayList = (List) map2.get(type);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map2.put(type, arrayList);
            }
            arrayList.add(entry.getKey());
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            SampleGroupDescriptionBox sampleGroupDescriptionBox = new SampleGroupDescriptionBox();
            String str = (String) entry2.getKey();
            sampleGroupDescriptionBox.setGroupingType(str);
            sampleGroupDescriptionBox.setGroupEntries((List) entry2.getValue());
            SampleToGroupBox sampleToGroupBox = new SampleToGroupBox();
            sampleToGroupBox.setGroupingType(str);
            SampleToGroupBox.Entry entry3 = null;
            for (int i = 0; i < track.getSamples().size(); i++) {
                int i2 = 0;
                for (int i3 = 0; i3 < ((List) entry2.getValue()).size(); i3++) {
                    if (Arrays.binarySearch(track.getSampleGroups().get((GroupEntry) ((List) entry2.getValue()).get(i3)), i) >= 0) {
                        i2 = i3 + 1;
                    }
                }
                if (entry3 == null || entry3.getGroupDescriptionIndex() != i2) {
                    entry3 = new SampleToGroupBox.Entry(1L, i2);
                    sampleToGroupBox.getEntries().add(entry3);
                } else {
                    entry3.setSampleCount(entry3.getSampleCount() + 1);
                }
            }
            sampleTableBox.addBox(sampleGroupDescriptionBox);
            sampleTableBox.addBox(sampleToGroupBox);
        }
        createSubs(track, sampleTableBox);
        LOG.debug("done with stbl for track_{}", Long.valueOf(track.getTrackMetaData().getTrackId()));
        return sampleTableBox;
    }

    public void createStco(Track track, Movie movie, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        int i;
        Map<Track, int[]> map2 = map;
        char c = 0;
        if (this.chunkOffsetBoxes.get(track) == null) {
            LOG.debug("Calculating chunk offsets for track_{}", Long.valueOf(track.getTrackMetaData().getTrackId()));
            ArrayList<Track> arrayList = new ArrayList(map2.keySet());
            Collections.sort(arrayList, new Comparator<Track>() { // from class: org.mp4parser.muxer.builder.DefaultMp4Builder.1
                @Override // java.util.Comparator
                public int compare(Track track2, Track track3) {
                    return CastUtils.l2i(track2.getTrackMetaData().getTrackId() - track3.getTrackMetaData().getTrackId());
                }
            });
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            for (Track track2 : arrayList) {
                map3.put(track2, 0);
                map4.put(track2, 0);
                map5.put(track2, Double.valueOf(0.0d));
                this.chunkOffsetBoxes.put(track2, new StaticChunkOffsetBox());
            }
            long j = 0;
            while (true) {
                Track track3 = null;
                for (Track track4 : arrayList) {
                    if (track3 == null || ((Double) map5.get(track4)).doubleValue() < ((Double) map5.get(track3)).doubleValue()) {
                        if (((Integer) map3.get(track4)).intValue() < map2.get(track4).length) {
                            track3 = track4;
                        }
                    }
                }
                if (track3 == null) {
                    break;
                }
                StaticChunkOffsetBox staticChunkOffsetBox = this.chunkOffsetBoxes.get(track3);
                long[] chunkOffsets = staticChunkOffsetBox.getChunkOffsets();
                long[] jArr = new long[1];
                jArr[c] = j;
                staticChunkOffsetBox.setChunkOffsets(Mp4Arrays.copyOfAndAppend(chunkOffsets, jArr));
                int iIntValue = ((Integer) map3.get(track3)).intValue();
                int i2 = map2.get(track3)[iIntValue];
                int iIntValue2 = ((Integer) map4.get(track3)).intValue();
                double dDoubleValue = ((Double) map5.get(track3)).doubleValue();
                long[] sampleDurations = track3.getSampleDurations();
                int i3 = iIntValue2;
                while (true) {
                    i = iIntValue2 + i2;
                    if (i3 < i) {
                        j += this.track2SampleSizes.get(track3)[i3];
                        dDoubleValue += sampleDurations[r17] / track3.getTrackMetaData().getTimescale();
                        i3++;
                    }
                }
                map3.put(track3, Integer.valueOf(iIntValue + 1));
                map4.put(track3, Integer.valueOf(i));
                map5.put(track3, Double.valueOf(dDoubleValue));
                map2 = map;
                c = 0;
            }
        }
        sampleTableBox.addBox(this.chunkOffsetBoxes.get(track));
    }

    public void createStsc(Track track, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        int[] iArr = map.get(track);
        SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
        sampleToChunkBox.setEntries(new LinkedList());
        List<Sample> samples = track.getSamples();
        List<SampleEntry> sampleEntries = track.getSampleEntries();
        long j = -2147483648L;
        int i = 0;
        long j2 = -2147483648L;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int iIndexOf = sampleEntries.indexOf(samples.get(i).getSampleEntry()) + 1;
            if (j != iArr[i2] || j2 != iIndexOf) {
                long j3 = iIndexOf;
                sampleToChunkBox.getEntries().add(new SampleToChunkBox.Entry(i2 + 1, iArr[i2], j3));
                j = iArr[i2];
                j2 = j3;
            }
            i += iArr[i2];
        }
        sampleTableBox.addBox(sampleToChunkBox);
    }

    public void createStsd(Track track, SampleTableBox sampleTableBox) {
        SampleDescriptionBox sampleDescriptionBox = new SampleDescriptionBox();
        sampleDescriptionBox.setBoxes(track.getSampleEntries());
        sampleTableBox.addBox(sampleDescriptionBox);
    }

    public void createStss(Track track, SampleTableBox sampleTableBox) {
        long[] syncSamples = track.getSyncSamples();
        if (syncSamples == null || syncSamples.length <= 0) {
            return;
        }
        SyncSampleBox syncSampleBox = new SyncSampleBox();
        syncSampleBox.setSampleNumber(syncSamples);
        sampleTableBox.addBox(syncSampleBox);
    }

    public void createStsz(Track track, SampleTableBox sampleTableBox) {
        SampleSizeBox sampleSizeBox = new SampleSizeBox();
        sampleSizeBox.setSampleSizes(this.track2SampleSizes.get(track));
        sampleTableBox.addBox(sampleSizeBox);
    }

    public void createStts(Track track, SampleTableBox sampleTableBox) {
        ArrayList arrayList = new ArrayList();
        TimeToSampleBox.Entry entry = null;
        for (long j : track.getSampleDurations()) {
            if (entry == null || entry.getDelta() != j) {
                entry = new TimeToSampleBox.Entry(1L, j);
                arrayList.add(entry);
            } else {
                entry.setCount(entry.getCount() + 1);
            }
        }
        TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
        timeToSampleBox.setEntries(arrayList);
        sampleTableBox.addBox(timeToSampleBox);
    }

    public void createSubs(Track track, SampleTableBox sampleTableBox) {
        if (track.getSubsampleInformationBox() != null) {
            sampleTableBox.addBox(track.getSubsampleInformationBox());
        }
    }

    public TrackBox createTrackBox(Track track, Movie movie, Map<Track, int[]> map) {
        TrackBox trackBox = new TrackBox();
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setEnabled(true);
        trackHeaderBox.setInMovie(true);
        trackHeaderBox.setMatrix(track.getTrackMetaData().getMatrix());
        trackHeaderBox.setAlternateGroup(track.getTrackMetaData().getGroup());
        trackHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        if (track.getEdits() == null || track.getEdits().isEmpty()) {
            trackHeaderBox.setDuration((getTimescale(movie) * track.getDuration()) / track.getTrackMetaData().getTimescale());
        } else {
            Iterator<Object> it = track.getEdits().iterator();
            if (it.hasNext()) {
                throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
            }
            track.getTrackMetaData().getTimescale();
            trackHeaderBox.setDuration(0L);
        }
        trackHeaderBox.setHeight(track.getTrackMetaData().getHeight());
        trackHeaderBox.setWidth(track.getTrackMetaData().getWidth());
        trackHeaderBox.setLayer(track.getTrackMetaData().getLayer());
        trackHeaderBox.setModificationTime(new Date());
        trackHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackHeaderBox.setVolume(track.getTrackMetaData().getVolume());
        trackBox.addBox(trackHeaderBox);
        trackBox.addBox(createEdts(track, movie));
        MediaBox mediaBox = new MediaBox();
        trackBox.addBox(mediaBox);
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        mediaHeaderBox.setDuration(track.getDuration());
        mediaHeaderBox.setTimescale(track.getTrackMetaData().getTimescale());
        mediaHeaderBox.setLanguage(track.getTrackMetaData().getLanguage());
        mediaBox.addBox(mediaHeaderBox);
        HandlerBox handlerBox = new HandlerBox();
        mediaBox.addBox(handlerBox);
        handlerBox.setHandlerType(track.getHandler());
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        if (track.getHandler().equals("vide")) {
            mediaInformationBox.addBox(new VideoMediaHeaderBox());
        } else if (track.getHandler().equals("soun")) {
            mediaInformationBox.addBox(new SoundMediaHeaderBox());
        } else if (track.getHandler().equals("text")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        } else if (track.getHandler().equals("subt")) {
            mediaInformationBox.addBox(new SubtitleMediaHeaderBox());
        } else if (track.getHandler().equals(ViewHierarchyConstants.HINT_KEY)) {
            mediaInformationBox.addBox(new HintMediaHeaderBox());
        } else if (track.getHandler().equals("sbtl")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        }
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        mediaInformationBox.addBox(dataInformationBox);
        mediaInformationBox.addBox(createStbl(track, movie, map));
        mediaBox.addBox(mediaInformationBox);
        LOG.debug("done with trak for track_{}", Long.valueOf(track.getTrackMetaData().getTrackId()));
        return trackBox;
    }

    public ParsableBox createUdta(Movie movie) {
        return null;
    }

    public int[] getChunkSizes(Track track) {
        long[] jArrSampleNumbers = this.fragmenter.sampleNumbers(track);
        int[] iArr = new int[jArrSampleNumbers.length];
        int i = 0;
        while (i < jArrSampleNumbers.length) {
            int i2 = i + 1;
            iArr[i] = CastUtils.l2i((jArrSampleNumbers.length == i2 ? track.getSamples().size() : jArrSampleNumbers[i2] - 1) - (jArrSampleNumbers[i] - 1));
            i = i2;
        }
        return iArr;
    }

    public long getTimescale(Movie movie) {
        long timescale = movie.getTracks().iterator().next().getTrackMetaData().getTimescale();
        Iterator<Track> it = movie.getTracks().iterator();
        while (it.hasNext()) {
            timescale = Mp4Math.lcm(timescale, it.next().getTrackMetaData().getTimescale());
        }
        return timescale;
    }

    public List<Sample> putSamples(Track track, List<Sample> list) {
        return this.track2Sample.put(track, list);
    }
}
