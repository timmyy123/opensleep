package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class MaxFragmentLengthExtension extends HelloExtension {
    private final Length fragmentLength;

    public enum Length {
        BYTES_512(1, 512),
        BYTES_1024(2, 1024),
        BYTES_2048(3, 2048),
        BYTES_4096(4, 4096);

        private int code;
        private int length;

        Length(int i, int i2) {
            this.code = i;
            this.length = i2;
        }

        public static Length fromCode(int i) {
            if (i == 1) {
                return BYTES_512;
            }
            if (i == 2) {
                return BYTES_1024;
            }
            if (i == 3) {
                return BYTES_2048;
            }
            if (i != 4) {
                return null;
            }
            return BYTES_4096;
        }

        public int code() {
            return this.code;
        }

        public int length() {
            return this.length;
        }
    }

    public MaxFragmentLengthExtension(Length length) {
        super(HelloExtension.ExtensionType.MAX_FRAGMENT_LENGTH);
        if (length != null) {
            this.fragmentLength = length;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Length must not be null");
            throw null;
        }
    }

    public static final MaxFragmentLengthExtension fromExtensionDataReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) throws HandshakeException {
        int i = datagramReader.read(8);
        Length lengthFromCode = Length.fromCode(i);
        if (lengthFromCode != null) {
            return new MaxFragmentLengthExtension(lengthFromCode);
        }
        throw new HandshakeException(String.format("Peer uses unknown code [%d] in %s extension", Integer.valueOf(i), HelloExtension.ExtensionType.MAX_FRAGMENT_LENGTH.name()), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, inetSocketAddress));
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public void addExtensionData(DatagramWriter datagramWriter) {
        datagramWriter.write(1, 16);
        datagramWriter.write(this.fragmentLength.code, 8);
    }

    public Length getFragmentLength() {
        return this.fragmentLength;
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public int getLength() {
        return 5;
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public String toString() {
        return super.toString() + "\t\t\t\tCode: " + this.fragmentLength.code() + " (" + this.fragmentLength.length() + " bytes)";
    }

    public MaxFragmentLengthExtension(int i) {
        this(Length.fromCode(i));
    }
}
