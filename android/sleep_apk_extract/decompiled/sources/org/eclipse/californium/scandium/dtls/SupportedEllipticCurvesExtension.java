package org.eclipse.californium.scandium.dtls;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;

/* JADX INFO: loaded from: classes5.dex */
public final class SupportedEllipticCurvesExtension extends HelloExtension {
    private final List<XECDHECryptography.SupportedGroup> supportedGroups;

    public SupportedEllipticCurvesExtension(List<XECDHECryptography.SupportedGroup> list) {
        super(HelloExtension.ExtensionType.ELLIPTIC_CURVES);
        this.supportedGroups = list;
    }

    public static HelloExtension fromExtensionDataReader(DatagramReader datagramReader) {
        ArrayList arrayList = new ArrayList();
        DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(datagramReader.read(16));
        while (datagramReaderCreateRangeReader.bytesAvailable()) {
            XECDHECryptography.SupportedGroup supportedGroupFromId = XECDHECryptography.SupportedGroup.fromId(datagramReaderCreateRangeReader.read(16));
            if (supportedGroupFromId != null) {
                arrayList.add(supportedGroupFromId);
            }
        }
        return new SupportedEllipticCurvesExtension(Collections.unmodifiableList(arrayList));
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public void addExtensionData(DatagramWriter datagramWriter) {
        int size = this.supportedGroups.size() * 2;
        datagramWriter.write(size + 2, 16);
        datagramWriter.write(size, 16);
        Iterator<XECDHECryptography.SupportedGroup> it = this.supportedGroups.iterator();
        while (it.hasNext()) {
            datagramWriter.write(it.next().getId(), 16);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public int getLength() {
        return Fragment$$ExternalSyntheticOutline1.m(this.supportedGroups, 2, 6);
    }

    public List<XECDHECryptography.SupportedGroup> getSupportedGroups() {
        return this.supportedGroups;
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\t\t\t\tLength: ");
        sb.append(getLength() - 4);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\t\t\tElliptic Curves Length: ");
        sb.append(getLength() - 6);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\t\t\tElliptic Curves (");
        sb.append(this.supportedGroups.size());
        sb.append(" curves):");
        for (XECDHECryptography.SupportedGroup supportedGroup : this.supportedGroups) {
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\t\t\t\tElliptic Curve: ");
            sb.append(supportedGroup.name());
            sb.append(" (");
            sb.append(supportedGroup.getId());
            sb.append(")");
        }
        return sb.toString();
    }
}
