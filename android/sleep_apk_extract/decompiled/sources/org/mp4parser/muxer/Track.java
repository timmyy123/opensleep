package org.mp4parser.muxer;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;
import org.mp4parser.boxes.sampleentry.SampleEntry;
import org.mp4parser.boxes.samplegrouping.GroupEntry;

/* JADX INFO: loaded from: classes5.dex */
public interface Track extends Closeable {
    List<CompositionTimeToSample.Entry> getCompositionTimeEntries();

    long getDuration();

    List<Object> getEdits();

    String getHandler();

    List<SampleDependencyTypeBox.Entry> getSampleDependencies();

    long[] getSampleDurations();

    List<SampleEntry> getSampleEntries();

    Map<GroupEntry, long[]> getSampleGroups();

    List<Sample> getSamples();

    SubSampleInformationBox getSubsampleInformationBox();

    long[] getSyncSamples();

    TrackMetaData getTrackMetaData();
}
