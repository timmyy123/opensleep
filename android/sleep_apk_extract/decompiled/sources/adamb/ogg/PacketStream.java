package adamb.ogg;

/* JADX INFO: loaded from: classes.dex */
public class PacketStream {
    private Segment prevSegment;
    private PacketSegmentStream segmentStream;

    public PacketStream(PacketSegmentStream packetSegmentStream) {
        this.segmentStream = packetSegmentStream;
    }

    public Packet next() {
        Segment next;
        String str;
        Packet packet = new Packet();
        do {
            next = this.segmentStream.next();
            if (next == null) {
                return null;
            }
            Segment segment = this.prevSegment;
            if (segment != null) {
                if (segment.getSourcePage() != next.getSourcePage() && !this.prevSegment.isLast() && !next.getSourcePage().isContinued) {
                    str = "Last page did not complete the packet and the new page is not marked as a continuation!";
                    OggIO$$ExternalSyntheticBUOutline0.m(str);
                    return null;
                }
                this.prevSegment = next;
                packet.segments.add(next);
            } else {
                if (next.getSourcePage().isContinued) {
                    str = "First page marked as a continuation!";
                    OggIO$$ExternalSyntheticBUOutline0.m(str);
                    return null;
                }
                this.prevSegment = next;
                packet.segments.add(next);
            }
        } while (!next.isLast());
        return packet;
    }
}
