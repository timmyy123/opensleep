package org.mp4parser.muxer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mp4parser.boxes.samplegrouping.GroupEntry;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractTrack implements Track {
    String name;
    List<Object> edits = new ArrayList();
    Map<GroupEntry, long[]> sampleGroups = new HashMap();

    public AbstractTrack(String str) {
        this.name = str;
    }

    @Override // org.mp4parser.muxer.Track
    public long getDuration() {
        long j = 0;
        for (long j2 : getSampleDurations()) {
            j += j2;
        }
        return j;
    }

    @Override // org.mp4parser.muxer.Track
    public List<Object> getEdits() {
        return this.edits;
    }

    @Override // org.mp4parser.muxer.Track
    public Map<GroupEntry, long[]> getSampleGroups() {
        return this.sampleGroups;
    }
}
