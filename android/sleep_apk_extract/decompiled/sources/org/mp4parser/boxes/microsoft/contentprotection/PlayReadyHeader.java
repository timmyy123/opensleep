package org.mp4parser.boxes.microsoft.contentprotection;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.boxes.microsoft.ProtectionSpecificHeader;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class PlayReadyHeader extends ProtectionSpecificHeader {
    public static UUID PROTECTION_SYSTEM_ID;
    private long length;
    private List<PlayReadyRecord> records;

    public static abstract class PlayReadyRecord {
        int type;

        public static class DefaulPlayReadyRecord extends PlayReadyRecord {
            ByteBuffer value;

            public DefaulPlayReadyRecord(int i) {
                super(i);
            }

            @Override // org.mp4parser.boxes.microsoft.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                return this.value;
            }

            @Override // org.mp4parser.boxes.microsoft.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                this.value = byteBuffer.duplicate();
            }
        }

        public static class EmeddedLicenseStore extends PlayReadyRecord {
            ByteBuffer value;

            public EmeddedLicenseStore() {
                super(3);
            }

            @Override // org.mp4parser.boxes.microsoft.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                return this.value;
            }

            @Override // org.mp4parser.boxes.microsoft.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                this.value = byteBuffer.duplicate();
            }

            @Override // org.mp4parser.boxes.microsoft.contentprotection.PlayReadyHeader.PlayReadyRecord
            public String toString() {
                return "EmeddedLicenseStore{length=" + getValue().limit() + '}';
            }
        }

        public static class RMHeader extends PlayReadyRecord {
            String header;

            public RMHeader() {
                super(1);
            }

            public String getHeader() {
                return this.header;
            }

            @Override // org.mp4parser.boxes.microsoft.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                try {
                    return ByteBuffer.wrap(this.header.getBytes("UTF-16LE"));
                } catch (UnsupportedEncodingException e) {
                    Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                    return null;
                }
            }

            @Override // org.mp4parser.boxes.microsoft.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                try {
                    byte[] bArr = new byte[byteBuffer.slice().limit()];
                    byteBuffer.get(bArr);
                    this.header = new String(bArr, "UTF-16LE");
                } catch (UnsupportedEncodingException e) {
                    Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                }
            }

            public void setHeader(String str) {
                this.header = str;
            }

            @Override // org.mp4parser.boxes.microsoft.contentprotection.PlayReadyHeader.PlayReadyRecord
            public String toString() {
                StringBuilder sb = new StringBuilder("RMHeader{length=");
                sb.append(getValue().limit());
                sb.append(", header='");
                return FileInsert$$ExternalSyntheticOutline0.m(sb, this.header, "'}");
            }
        }

        public PlayReadyRecord(int i) {
            this.type = i;
        }

        public static List<PlayReadyRecord> createFor(ByteBuffer byteBuffer, int i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                int uInt16BE = IsoTypeReader.readUInt16BE(byteBuffer);
                int uInt16BE2 = IsoTypeReader.readUInt16BE(byteBuffer);
                PlayReadyRecord defaulPlayReadyRecord = uInt16BE != 1 ? uInt16BE != 2 ? uInt16BE != 3 ? new DefaulPlayReadyRecord(uInt16BE) : new EmeddedLicenseStore() : new DefaulPlayReadyRecord(2) : new RMHeader();
                defaulPlayReadyRecord.parse((ByteBuffer) byteBuffer.slice().limit(uInt16BE2));
                byteBuffer.position(byteBuffer.position() + uInt16BE2);
                arrayList.add(defaulPlayReadyRecord);
            }
            return arrayList;
        }

        public abstract ByteBuffer getValue();

        public abstract void parse(ByteBuffer byteBuffer);

        public String toString() {
            return "PlayReadyRecord{type=" + this.type + ", length=" + getValue().limit() + '}';
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95");
        PROTECTION_SYSTEM_ID = uuidFromString;
        ProtectionSpecificHeader.uuidRegistry.put(uuidFromString, PlayReadyHeader.class);
    }

    @Override // org.mp4parser.boxes.microsoft.ProtectionSpecificHeader
    public ByteBuffer getData() {
        Iterator<PlayReadyRecord> it = this.records.iterator();
        int iLimit = 6;
        while (it.hasNext()) {
            iLimit = iLimit + 4 + it.next().getValue().rewind().limit();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iLimit);
        IsoTypeWriter.writeUInt32BE(byteBufferAllocate, iLimit);
        IsoTypeWriter.writeUInt16BE(byteBufferAllocate, this.records.size());
        for (PlayReadyRecord playReadyRecord : this.records) {
            IsoTypeWriter.writeUInt16BE(byteBufferAllocate, playReadyRecord.type);
            IsoTypeWriter.writeUInt16BE(byteBufferAllocate, playReadyRecord.getValue().limit());
            byteBufferAllocate.put(playReadyRecord.getValue());
        }
        return byteBufferAllocate;
    }

    public List<PlayReadyRecord> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    @Override // org.mp4parser.boxes.microsoft.ProtectionSpecificHeader
    public UUID getSystemId() {
        return PROTECTION_SYSTEM_ID;
    }

    @Override // org.mp4parser.boxes.microsoft.ProtectionSpecificHeader
    public void parse(ByteBuffer byteBuffer) {
        this.length = IsoTypeReader.readUInt32BE(byteBuffer);
        this.records = PlayReadyRecord.createFor(byteBuffer, IsoTypeReader.readUInt16BE(byteBuffer));
    }

    public void setRecords(List<PlayReadyRecord> list) {
        this.records = list;
    }

    @Override // org.mp4parser.boxes.microsoft.ProtectionSpecificHeader
    public String toString() {
        StringBuilder sb = new StringBuilder("PlayReadyHeader{length=");
        sb.append(this.length);
        sb.append(", recordCount=");
        sb.append(this.records.size());
        sb.append(", records=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.records, '}');
    }
}
