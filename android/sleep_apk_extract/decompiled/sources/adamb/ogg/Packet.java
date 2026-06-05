package adamb.ogg;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Packet {
    private byte[] bytes;
    public ArrayList<Segment> segments = new ArrayList<>(4);

    public boolean finishesOnPageBoundary() {
        Segment lastSegment = getLastSegment();
        ArrayList<Segment> arrayList = lastSegment.getSourcePage().segments;
        return lastSegment == arrayList.get(arrayList.size() - 1);
    }

    public byte[] getBytes() {
        if (this.bytes == null) {
            Iterator<Segment> it = this.segments.iterator();
            int bytes = 0;
            int size = 0;
            while (it.hasNext()) {
                size += it.next().size();
            }
            this.bytes = new byte[size];
            Iterator<Segment> it2 = this.segments.iterator();
            while (it2.hasNext()) {
                bytes += it2.next().getBytes(this.bytes, bytes);
            }
        }
        return this.bytes;
    }

    public Segment getLastSegment() {
        return this.segments.get(r1.size() - 1);
    }

    public Page getStartingPage() {
        return this.segments.get(0).getSourcePage();
    }
}
