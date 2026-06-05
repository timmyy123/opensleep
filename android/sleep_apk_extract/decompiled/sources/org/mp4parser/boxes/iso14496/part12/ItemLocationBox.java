package org.mp4parser.boxes.iso14496.part12;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.AppEventsConstants;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeReaderVariable;
import org.mp4parser.tools.IsoTypeWriter;
import org.mp4parser.tools.IsoTypeWriterVariable;

/* JADX INFO: loaded from: classes5.dex */
public class ItemLocationBox extends AbstractFullBox {
    public static final String TYPE = "iloc";
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_1;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_10;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_11;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_12;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_13;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_2;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_3;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_4;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_5;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_6;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_7;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_8;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_9;
    public int baseOffsetSize;
    public int indexSize;
    public List<Item> items;
    public int lengthSize;
    public int offsetSize;

    static {
        ajc$preClinit();
    }

    public ItemLocationBox() {
        super(TYPE);
        this.offsetSize = 8;
        this.lengthSize = 8;
        this.baseOffsetSize = 8;
        this.indexSize = 0;
        this.items = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("ItemLocationBox.java", ItemLocationBox.class);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getOffsetSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "int"), 118);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setOffsetSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int", "offsetSize", "", "void"), 122);
        ajc$tjp_10 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "createItem", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox$Item"), 159);
        ajc$tjp_11 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "createItem", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "java.nio.ByteBuffer", "bb", "", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox$Item"), 163);
        ajc$tjp_12 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "createExtent", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox$Extent"), 167);
        ajc$tjp_13 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "createExtent", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "java.nio.ByteBuffer", "bb", "", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox$Extent"), 171);
        ajc$tjp_2 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getLengthSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "int"), 126);
        ajc$tjp_3 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setLengthSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int", "lengthSize", "", "void"), 130);
        ajc$tjp_4 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getBaseOffsetSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "int"), 134);
        ajc$tjp_5 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setBaseOffsetSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int", "baseOffsetSize", "", "void"), 138);
        ajc$tjp_6 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getIndexSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "int"), 142);
        ajc$tjp_7 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setIndexSize", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "int", "indexSize", "", "void"), 146);
        ajc$tjp_8 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getItems", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "", "", "", "java.util.List"), 150);
        ajc$tjp_9 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setItems", "org.mp4parser.boxes.iso14496.part12.ItemLocationBox", "java.util.List", "items", "", "void"), 154);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int uInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.offsetSize = uInt8 >>> 4;
        this.lengthSize = uInt8 & 15;
        int uInt82 = IsoTypeReader.readUInt8(byteBuffer);
        this.baseOffsetSize = uInt82 >>> 4;
        if (getVersion() == 1) {
            this.indexSize = uInt82 & 15;
        }
        int uInt16 = IsoTypeReader.readUInt16(byteBuffer);
        for (int i = 0; i < uInt16; i++) {
            this.items.add(new Item(byteBuffer));
        }
    }

    public Extent createExtent(long j, long j2, long j3) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, (Object) this, (Object) this, new Object[]{Conversions.longObject(j), Conversions.longObject(j2), Conversions.longObject(j3)}));
        return new Extent(j, j2, j3);
    }

    public Item createItem(int i, int i2, int i3, long j, List<Extent> list) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, (Object) this, (Object) this, new Object[]{Conversions.intObject(i), Conversions.intObject(i2), Conversions.intObject(i3), Conversions.longObject(j), list}));
        return new Item(i, i2, i3, j, list);
    }

    public int getBaseOffsetSize() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        return this.baseOffsetSize;
    }

    @Override // org.mp4parser.support.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt8(byteBuffer, (this.offsetSize << 4) | this.lengthSize);
        int version = getVersion();
        int i = this.baseOffsetSize;
        if (version == 1) {
            IsoTypeWriter.writeUInt8(byteBuffer, (i << 4) | this.indexSize);
        } else {
            IsoTypeWriter.writeUInt8(byteBuffer, i << 4);
        }
        IsoTypeWriter.writeUInt16(byteBuffer, this.items.size());
        Iterator<Item> it = this.items.iterator();
        while (it.hasNext()) {
            it.next().getContent(byteBuffer);
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    public long getContentSize() {
        Iterator<Item> it = this.items.iterator();
        long size = 8;
        while (it.hasNext()) {
            size += (long) it.next().getSize();
        }
        return size;
    }

    public int getIndexSize() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
        return this.indexSize;
    }

    public List<Item> getItems() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
        return this.items;
    }

    public int getLengthSize() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.lengthSize;
    }

    public int getOffsetSize() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.offsetSize;
    }

    public void setBaseOffsetSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.intObject(i)));
        this.baseOffsetSize = i;
    }

    public void setIndexSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.intObject(i)));
        this.indexSize = i;
    }

    public void setItems(List<Item> list) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, list));
        this.items = list;
    }

    public void setLengthSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i)));
        this.lengthSize = i;
    }

    public void setOffsetSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.intObject(i)));
        this.offsetSize = i;
    }

    public class Extent {
        public long extentIndex;
        public long extentLength;
        public long extentOffset;

        public Extent(ByteBuffer byteBuffer) {
            int i;
            if (ItemLocationBox.this.getVersion() == 1 && (i = ItemLocationBox.this.indexSize) > 0) {
                this.extentIndex = IsoTypeReaderVariable.read(byteBuffer, i);
            }
            this.extentOffset = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.offsetSize);
            this.extentLength = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Extent extent = (Extent) obj;
            return this.extentIndex == extent.extentIndex && this.extentLength == extent.extentLength && this.extentOffset == extent.extentOffset;
        }

        public void getContent(ByteBuffer byteBuffer) {
            int i;
            if (ItemLocationBox.this.getVersion() == 1 && (i = ItemLocationBox.this.indexSize) > 0) {
                IsoTypeWriterVariable.write(this.extentIndex, byteBuffer, i);
            }
            IsoTypeWriterVariable.write(this.extentOffset, byteBuffer, ItemLocationBox.this.offsetSize);
            IsoTypeWriterVariable.write(this.extentLength, byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public int getSize() {
            ItemLocationBox itemLocationBox = ItemLocationBox.this;
            int i = itemLocationBox.indexSize;
            if (i <= 0) {
                i = 0;
            }
            return i + itemLocationBox.offsetSize + itemLocationBox.lengthSize;
        }

        public int hashCode() {
            long j = this.extentOffset;
            long j2 = this.extentLength;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.extentIndex;
            return i + ((int) ((j3 >>> 32) ^ j3));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Extent{extentOffset=");
            sb.append(this.extentOffset);
            sb.append(", extentLength=");
            sb.append(this.extentLength);
            sb.append(", extentIndex=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.extentIndex, '}');
        }

        public Extent(long j, long j2, long j3) {
            this.extentOffset = j;
            this.extentLength = j2;
            this.extentIndex = j3;
        }
    }

    public Extent createExtent(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, byteBuffer));
        return new Extent(byteBuffer);
    }

    public Item createItem(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, byteBuffer));
        return new Item(byteBuffer);
    }

    public class Item {
        public long baseOffset;
        public int constructionMethod;
        public int dataReferenceIndex;
        public List<Extent> extents;
        public int itemId;

        public Item(ByteBuffer byteBuffer) {
            this.extents = new LinkedList();
            this.itemId = IsoTypeReader.readUInt16(byteBuffer);
            if (ItemLocationBox.this.getVersion() == 1) {
                this.constructionMethod = IsoTypeReader.readUInt16(byteBuffer) & 15;
            }
            this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
            int i = ItemLocationBox.this.baseOffsetSize;
            if (i > 0) {
                this.baseOffset = IsoTypeReaderVariable.read(byteBuffer, i);
            } else {
                this.baseOffset = 0L;
            }
            int uInt16 = IsoTypeReader.readUInt16(byteBuffer);
            for (int i2 = 0; i2 < uInt16; i2++) {
                this.extents.add(ItemLocationBox.this.new Extent(byteBuffer));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Item item = (Item) obj;
            if (this.baseOffset != item.baseOffset || this.constructionMethod != item.constructionMethod || this.dataReferenceIndex != item.dataReferenceIndex || this.itemId != item.itemId) {
                return false;
            }
            List<Extent> list = this.extents;
            List<Extent> list2 = item.extents;
            return list == null ? list2 == null : list.equals(list2);
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.writeUInt16(byteBuffer, this.itemId);
            if (ItemLocationBox.this.getVersion() == 1) {
                IsoTypeWriter.writeUInt16(byteBuffer, this.constructionMethod);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.dataReferenceIndex);
            int i = ItemLocationBox.this.baseOffsetSize;
            if (i > 0) {
                IsoTypeWriterVariable.write(this.baseOffset, byteBuffer, i);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.extents.size());
            Iterator<Extent> it = this.extents.iterator();
            while (it.hasNext()) {
                it.next().getContent(byteBuffer);
            }
        }

        public int getSize() {
            int size = (ItemLocationBox.this.getVersion() == 1 ? 4 : 2) + 2 + ItemLocationBox.this.baseOffsetSize + 2;
            Iterator<Extent> it = this.extents.iterator();
            while (it.hasNext()) {
                size += it.next().getSize();
            }
            return size;
        }

        public int hashCode() {
            int i = ((((this.itemId * 31) + this.constructionMethod) * 31) + this.dataReferenceIndex) * 31;
            long j = this.baseOffset;
            int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
            List<Extent> list = this.extents;
            return i2 + (list != null ? list.hashCode() : 0);
        }

        public void setBaseOffset(long j) {
            this.baseOffset = j;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Item{baseOffset=");
            sb.append(this.baseOffset);
            sb.append(", itemId=");
            sb.append(this.itemId);
            sb.append(", constructionMethod=");
            sb.append(this.constructionMethod);
            sb.append(", dataReferenceIndex=");
            sb.append(this.dataReferenceIndex);
            sb.append(", extents=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.extents, '}');
        }

        public Item(int i, int i2, int i3, long j, List<Extent> list) {
            new LinkedList();
            this.itemId = i;
            this.constructionMethod = i2;
            this.dataReferenceIndex = i3;
            this.baseOffset = j;
            this.extents = list;
        }
    }
}
