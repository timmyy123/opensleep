package org.eclipse.californium.scandium.dtls;

import java.util.List;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.HelloExtension;

/* JADX INFO: loaded from: classes5.dex */
public class ClientCertificateTypeExtension extends CertificateTypeExtension {
    private ClientCertificateTypeExtension(DatagramReader datagramReader) {
        super(HelloExtension.ExtensionType.CLIENT_CERT_TYPE, datagramReader);
    }

    public static ClientCertificateTypeExtension fromExtensionDataReaader(DatagramReader datagramReader) {
        return new ClientCertificateTypeExtension(datagramReader);
    }

    @Override // org.eclipse.californium.scandium.dtls.CertificateTypeExtension, org.eclipse.californium.scandium.dtls.HelloExtension
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (CertificateType certificateType : getCertificateTypes()) {
            sb.append("\t\t\t\tClient certificate type: ");
            sb.append(certificateType);
            sb.append(StringUtil.lineSeparator());
        }
        return sb.toString();
    }

    public ClientCertificateTypeExtension(List<CertificateType> list) {
        super(HelloExtension.ExtensionType.CLIENT_CERT_TYPE, list);
    }

    public ClientCertificateTypeExtension(CertificateType certificateType) {
        super(HelloExtension.ExtensionType.CLIENT_CERT_TYPE, certificateType);
    }
}
