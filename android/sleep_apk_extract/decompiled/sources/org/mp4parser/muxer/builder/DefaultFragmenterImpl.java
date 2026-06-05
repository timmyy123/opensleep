package org.mp4parser.muxer.builder;

import java.util.Arrays;
import org.mp4parser.muxer.Track;
import org.mp4parser.tools.Mp4Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultFragmenterImpl implements Fragmenter {
    private double fragmentLength;

    public DefaultFragmenterImpl(double d) {
        this.fragmentLength = d;
    }

    @Override // org.mp4parser.muxer.builder.Fragmenter
    public long[] sampleNumbers(Track track) {
        long[] jArrCopyOfAndAppend = {1};
        long[] sampleDurations = track.getSampleDurations();
        long[] syncSamples = track.getSyncSamples();
        long timescale = track.getTrackMetaData().getTimescale();
        int i = 0;
        double d = 0.0d;
        while (i < sampleDurations.length) {
            double d2 = (sampleDurations[i] / timescale) + d;
            if (d2 >= this.fragmentLength && (syncSamples == null || Arrays.binarySearch(syncSamples, i + 1) >= 0)) {
                if (i > 0) {
                    jArrCopyOfAndAppend = Mp4Arrays.copyOfAndAppend(jArrCopyOfAndAppend, i + 1);
                }
                d2 = 0.0d;
            }
            i++;
            d = d2;
        }
        return jArrCopyOfAndAppend;
    }
}
