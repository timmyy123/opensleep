package org.eclipse.californium.scandium.dtls;

import java.util.List;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.HelloExtension;

/* JADX INFO: loaded from: classes5.dex */
public class ServerCertificateTypeExtension extends CertificateTypeExtension {
    private ServerCertificateTypeExtension(DatagramReader datagramReader) {
        super(HelloExtension.ExtensionType.SERVER_CERT_TYPE, datagramReader);
    }

    public static ServerCertificateTypeExtension fromExtensionDataReader(DatagramReader datagramReader) {
        return new ServerCertificateTypeExtension(datagramReader);
    }

    @Override // org.eclipse.californium.scandium.dtls.CertificateTypeExtension, org.eclipse.californium.scandium.dtls.HelloExtension
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (CertificateType certificateType : getCertificateTypes()) {
            sb.append("\t\t\t\tServer certificate type: ");
            sb.append(certificateType);
            sb.append(StringUtil.lineSeparator());
        }
        return sb.toString();
    }

    public ServerCertificateTypeExtension(List<CertificateType> list) {
        super(HelloExtension.ExtensionType.SERVER_CERT_TYPE, list);
    }

    public ServerCertificateTypeExtension(CertificateType certificateType) {
        super(HelloExtension.ExtensionType.SERVER_CERT_TYPE, certificateType);
    }
}
