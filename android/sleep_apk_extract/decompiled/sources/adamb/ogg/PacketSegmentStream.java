package adamb.ogg;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class PacketSegmentStream {
    private LogicalPageStream pageStream;
    private LinkedList<Segment> segmentQueue = new LinkedList<>();

    public PacketSegmentStream(LogicalPageStream logicalPageStream) {
        this.pageStream = logicalPageStream;
    }

    public Segment next() {
        while (true) {
            Segment segmentPoll = this.segmentQueue.poll();
            if (segmentPoll != null) {
                return segmentPoll;
            }
            Page next = this.pageStream.next();
            if (next == null) {
                return null;
            }
            this.segmentQueue.addAll(next.segments);
        }
    }
}
