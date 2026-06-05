package org.eclipse.californium.scandium.dtls;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.net.InetSocketAddress;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class RecordSizeLimitExtension extends HelloExtension {
    private int recordSizeLimit;

    public RecordSizeLimitExtension(int i) {
        super(HelloExtension.ExtensionType.RECORD_SIZE_LIMIT);
        this.recordSizeLimit = ensureInRange(i);
    }

    public static int ensureInRange(int i) {
        if (i >= 64 && i <= 65535) {
            return i;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "Record size limit must be within [64...65535], not ", "!"));
        return 0;
    }

    public static RecordSizeLimitExtension fromExtensionDataReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) throws HandshakeException {
        if (datagramReader == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("record size limit must not be null!");
            return null;
        }
        int i = datagramReader.read(16);
        if (i >= 64) {
            return new RecordSizeLimitExtension(i);
        }
        throw new HandshakeException(Fragment$$ExternalSyntheticOutline1.m(i, "record size limit must be at last 64 bytes, not only ", "!"), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, inetSocketAddress));
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public void addExtensionData(DatagramWriter datagramWriter) {
        datagramWriter.write(2, 16);
        datagramWriter.write(this.recordSizeLimit, 16);
    }

    @Override // org.eclipse.californium.scandium.dtls.HelloExtension
    public int getLength() {
        return 6;
    }

    public int getRecordSizeLimit() {
        return this.recordSizeLimit;
    }
}
