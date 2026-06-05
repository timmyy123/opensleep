package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.HelloExtension;

/* JADX INFO: loaded from: classes5.dex */
public class SupportedPointFormatsExtension extends HelloExtension {
    public static final SupportedPointFormatsExtension DEFAULT_POINT_FORMATS_EXTENSION;
    private static final List<ECPointFormat> EC_POINT_FORMATS;
    List<ECPointFormat> ecPointFormatList;

    public enum ECPointFormat {
        UNCOMPRESSED(0),
        ANSIX962_COMPRESSED_PRIME(1),
        ANSIX962_COMPRESSED_CHAR2(2);

        private int id;

        ECPointFormat(int i) {
            this.id = i;
        }

        public static ECPointFormat getECPointFormatById(int i) {
            if (i == 0) {
                return UNCOMPRESSED;
            }
            if (i == 1) {
                return ANSIX962_COMPRESSED_PRIME;
            }
            if (i != 2) {
                return null;
            }
            return ANSIX962_COMPRESSED_CHAR2;
        }

        public int getId() {
            return this.id;
        }

        @Override // java.lang.Enum
        public String toString() {
            int i = this.id;
            if (i == 0) {
                return FileInsert$$ExternalSyntheticOutline0.m(this.id, ")", new StringBuilder("uncompressed ("));
            }
            if (i == 1) {
                return FileInsert$$ExternalSyntheticOutline0.m(this.id, ")", new StringBuilder("ansiX962_compressed_prime ("));
            }
            if (i != 2) {
                return "";
            }
            return FileInsert$$ExternalSyntheticOutline0.m(this.id, ")", new StringBuilder("ansiX962_compressed_char2 ("));
        }
    }

    static {
        List<ECPointFormat> listSingletonList = Collections.singletonList(ECPointFormat.UNCOMPRESSED);
        EC_POINT_FORMATS = listSingletonList;
        DEFAULT_POINT_FORMATS_EXTENSION = new SupportedPointFormatsExtension(listSingletonList);
    }

    private SupportedPointFormatsExtension(List<ECPointFormat> list) {
        super(HelloExtension.ExtensionType.EC_POINT_FORMATS);
        this.ecPointFormatList = list;
    }

    public static HelloExtension fromExtensionDataReader(DatagramReader datagramReader) {
        ArrayList arrayList = new ArrayList();
        DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(datagramReader.read(8));
        while (datagramReaderCreateRangeReader.bytesAvailable()) {
            ECPointFormat eCPointFormatById = ECPointFormat.getECPointFormatById(datagramReaderCreateRangeReader.read(8));
            if (eCPointFormatById != null) {
                arrayList.add(eCPointFormatById);
            }
        }
        return (arrayList.size() == 1 && arrayList.contains(ECPointFormat.UNCOMPRESSED)) ? DEFAULT_POINT_FORMATS_EXTENSION : new SupportedPointFormatsExtension(arrayList);
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public void addExtensionData(DatagramWriter datagramWriter) {
        int size = this.ecPointFormatList.size();
        datagramWriter.write(size + 1, 16);
        datagramWriter.write(size, 8);
        Iterator<ECPointFormat> it = this.ecPointFormatList.iterator();
        while (it.hasNext()) {
            datagramWriter.write(it.next().getId(), 8);
        }
    }

    public boolean contains(ECPointFormat eCPointFormat) {
        return this.ecPointFormatList.contains(eCPointFormat);
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public int getLength() {
        return this.ecPointFormatList.size() + 5;
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\t\t\t\tLength: ");
        sb.append(getLength() - 4);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\t\t\tEC point formats length: ");
        sb.append(getLength() - 5);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\t\t\tElliptic Curves Point Formats (");
        sb.append(this.ecPointFormatList.size());
        sb.append("):");
        for (ECPointFormat eCPointFormat : this.ecPointFormatList) {
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\t\t\t\tEC point format: ");
            sb.append(eCPointFormat.toString());
        }
        return sb.toString();
    }
}
