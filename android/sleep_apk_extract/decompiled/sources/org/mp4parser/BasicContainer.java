package org.mp4parser;

import java.io.EOFException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BasicContainer implements Container {
    private List<Box> boxes = new ArrayList();

    public void addBox(Box box) {
        if (box != null) {
            ArrayList arrayList = new ArrayList(getBoxes());
            this.boxes = arrayList;
            arrayList.add(box);
        }
    }

    public <T extends Box> List<T> getBoxes(Class<T> cls) {
        ArrayList arrayList = null;
        Box box = null;
        for (Box box2 : getBoxes()) {
            if (cls.isInstance(box2)) {
                if (box == null) {
                    box = box2;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                        arrayList.add(box);
                    }
                    arrayList.add(box2);
                }
            }
        }
        return arrayList != null ? arrayList : box != null ? Collections.singletonList(box) : Collections.EMPTY_LIST;
    }

    public long getContainerSize() {
        long size = 0;
        for (int i = 0; i < getBoxes().size(); i++) {
            size += this.boxes.get(i).getSize();
        }
        return size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initContainer(ReadableByteChannel readableByteChannel, long j, BoxParser boxParser) throws EOFException {
        long size = 0;
        while (true) {
            if (j >= 0 && size >= j) {
                return;
            }
            try {
                ParsableBox box = boxParser.parseBox(readableByteChannel, this instanceof ParsableBox ? ((ParsableBox) this).getType() : null);
                this.boxes.add(box);
                size += box.getSize();
            } catch (EOFException e) {
                if (j >= 0) {
                    throw e;
                }
                return;
            }
        }
    }

    public void setBoxes(List<? extends Box> list) {
        this.boxes = new ArrayList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.boxes.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.boxes.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // org.mp4parser.Container
    public final void writeContainer(WritableByteChannel writableByteChannel) {
        Iterator<Box> it = getBoxes().iterator();
        while (it.hasNext()) {
            it.next().getBox(writableByteChannel);
        }
    }

    @Override // org.mp4parser.Container
    public List<Box> getBoxes() {
        return this.boxes;
    }

    @Override // org.mp4parser.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls, boolean z) {
        ArrayList arrayList = new ArrayList(2);
        List<Box> boxes = getBoxes();
        for (int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            if (cls.isInstance(box)) {
                arrayList.add(box);
            }
            if (z && (box instanceof Container)) {
                arrayList.addAll(((Container) box).getBoxes(cls, z));
            }
        }
        return arrayList;
    }
}
