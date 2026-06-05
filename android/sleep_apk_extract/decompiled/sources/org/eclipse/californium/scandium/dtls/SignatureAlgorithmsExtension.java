package org.eclipse.californium.scandium.dtls;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.HelloExtension;

/* JADX INFO: loaded from: classes5.dex */
public class SignatureAlgorithmsExtension extends HelloExtension {
    private final List<SignatureAndHashAlgorithm> signatureAndHashAlgorithms;

    public SignatureAlgorithmsExtension(List<SignatureAndHashAlgorithm> list) {
        super(HelloExtension.ExtensionType.SIGNATURE_ALGORITHMS);
        this.signatureAndHashAlgorithms = list;
    }

    public static HelloExtension fromExtensionDataReader(DatagramReader datagramReader) {
        ArrayList arrayList = new ArrayList();
        DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(datagramReader.read(16));
        while (datagramReaderCreateRangeReader.bytesAvailable()) {
            arrayList.add(new SignatureAndHashAlgorithm(datagramReaderCreateRangeReader.read(8), datagramReaderCreateRangeReader.read(8)));
        }
        return new SignatureAlgorithmsExtension(Collections.unmodifiableList(arrayList));
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public void addExtensionData(DatagramWriter datagramWriter) {
        int size = this.signatureAndHashAlgorithms.size() * 2;
        datagramWriter.write(size + 2, 16);
        datagramWriter.write(size, 16);
        for (SignatureAndHashAlgorithm signatureAndHashAlgorithm : this.signatureAndHashAlgorithms) {
            datagramWriter.write(signatureAndHashAlgorithm.getHash().getCode(), 8);
            datagramWriter.write(signatureAndHashAlgorithm.getSignature().getCode(), 8);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public int getLength() {
        return Fragment$$ExternalSyntheticOutline1.m(this.signatureAndHashAlgorithms, 2, 6);
    }

    public List<SignatureAndHashAlgorithm> getSupportedSignatureAndHashAlgorithms() {
        return this.signatureAndHashAlgorithms;
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\t\t\t\tLength: ");
        sb.append(getLength() - 4);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\t\t\tSignature Algorithms Length: ");
        sb.append(getLength() - 6);
        sb.append(StringUtil.lineSeparator());
        sb.append("\t\t\t\tSignature Algorithms (");
        sb.append(this.signatureAndHashAlgorithms.size());
        sb.append(" algorithm):");
        for (SignatureAndHashAlgorithm signatureAndHashAlgorithm : this.signatureAndHashAlgorithms) {
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\t\t\t\tSignature Algorithm: ");
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\t\t\t\t\tSignature Hash Algorithm Hash: ");
            if (signatureAndHashAlgorithm.getHash() != null) {
                sb.append(signatureAndHashAlgorithm.getHash());
            } else {
                sb.append("unknown");
            }
            sb.append(StringUtil.lineSeparator());
            sb.append("\t\t\t\t\t\tSignature Hash Algorithm Signature: ");
            if (signatureAndHashAlgorithm.getSignature() != null) {
                sb.append(signatureAndHashAlgorithm.getSignature());
            } else {
                sb.append("unknown");
            }
        }
        sb.append(StringUtil.lineSeparator());
        return sb.toString();
    }
}
