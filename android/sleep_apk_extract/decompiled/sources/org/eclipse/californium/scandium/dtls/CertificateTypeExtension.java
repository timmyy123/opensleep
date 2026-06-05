package org.eclipse.californium.scandium.dtls;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import org.eclipse.californium.scandium.util.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CertificateTypeExtension extends HelloExtension {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) CertificateTypeExtension.class);
    private final List<CertificateType> certificateTypes;
    private final boolean isClientExtension;

    public CertificateTypeExtension(HelloExtension.ExtensionType extensionType, DatagramReader datagramReader) {
        ArrayList arrayList;
        super(extensionType);
        if (datagramReader == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("extension data must not be null!");
            throw null;
        }
        if (!datagramReader.bytesAvailable()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("extension data must not be empty!");
            throw null;
        }
        boolean z = datagramReader.bitsLeft() > 8;
        this.isClientExtension = z;
        if (z) {
            int i = datagramReader.read(8);
            arrayList = new ArrayList(i);
            DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(i);
            while (datagramReaderCreateRangeReader.bytesAvailable()) {
                int i2 = datagramReaderCreateRangeReader.read(8);
                CertificateType typeFromCode = CertificateType.getTypeFromCode(i2);
                if (typeFromCode != null) {
                    arrayList.add(typeFromCode);
                } else {
                    LOG.debug("Client indicated preference for unknown {} certificate type code [{}]", getType().equals(HelloExtension.ExtensionType.CLIENT_CERT_TYPE) ? "client" : "server", Integer.valueOf(i2));
                }
            }
        } else {
            int i3 = datagramReader.read(8);
            CertificateType typeFromCode2 = CertificateType.getTypeFromCode(i3);
            if (typeFromCode2 == null) {
                LOG.debug("Server selected an unknown {} certificate type code [{}]", getType().equals(HelloExtension.ExtensionType.CLIENT_CERT_TYPE) ? "client" : "server", Integer.valueOf(i3));
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i3, "unknown certificate type code ", "!"));
                throw null;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(typeFromCode2);
            arrayList = arrayList2;
        }
        this.certificateTypes = ListUtils.init(arrayList);
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public void addExtensionData(DatagramWriter datagramWriter) {
        if (!this.isClientExtension) {
            datagramWriter.write(1, 16);
            datagramWriter.write(this.certificateTypes.get(0).getCode(), 8);
            return;
        }
        int size = this.certificateTypes.size();
        datagramWriter.write(size + 1, 16);
        datagramWriter.write(size, 8);
        Iterator<CertificateType> it = this.certificateTypes.iterator();
        while (it.hasNext()) {
            datagramWriter.write(it.next().getCode(), 8);
        }
    }

    public List<CertificateType> getCertificateTypes() {
        return this.certificateTypes;
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public int getLength() {
        if (this.isClientExtension) {
            return this.certificateTypes.size() + 5;
        }
        return 5;
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public String toString() {
        return super.toString();
    }

    public CertificateTypeExtension(HelloExtension.ExtensionType extensionType, List<CertificateType> list) {
        super(extensionType);
        if (list != null) {
            if (!list.isEmpty()) {
                this.isClientExtension = true;
                this.certificateTypes = list;
                return;
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$2("certificate types data must not be empty!");
                throw null;
            }
        }
        Types$$ExternalSyntheticBUOutline0.m$1("certificate types must not be null!");
        throw null;
    }

    public CertificateTypeExtension(HelloExtension.ExtensionType extensionType, CertificateType certificateType) {
        super(extensionType);
        if (certificateType != null) {
            this.isClientExtension = false;
            ArrayList arrayList = new ArrayList(1);
            this.certificateTypes = arrayList;
            arrayList.add(certificateType);
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("certificate type must not be null!");
        throw null;
    }
}
