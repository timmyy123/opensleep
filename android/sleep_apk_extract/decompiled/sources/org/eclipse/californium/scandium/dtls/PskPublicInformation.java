package org.eclipse.californium.scandium.dtls;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.StandardCharsets;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class PskPublicInformation extends Bytes {
    public static final PskPublicInformation EMPTY = new PskPublicInformation("");
    private boolean compliantEncoding;
    private String publicInfo;

    public PskPublicInformation(String str) {
        super(str == null ? null : str.getBytes(StandardCharsets.UTF_8), 65535, false);
        this.publicInfo = str;
        this.compliantEncoding = true;
    }

    public static PskPublicInformation fromByteArray(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? EMPTY : new PskPublicInformation(bArr);
    }

    public String getPublicInfoAsString() {
        return this.publicInfo;
    }

    public boolean isCompliantEncoding() {
        return this.compliantEncoding;
    }

    public void normalize(String str) {
        if (str == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("public information must not be null");
        } else if (str.isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("public information must not be empty");
        } else {
            this.publicInfo = str;
            this.compliantEncoding = Arrays.equals(getBytes(), str.getBytes(StandardCharsets.UTF_8));
        }
    }

    public String toString() {
        boolean z = this.compliantEncoding;
        String str = this.publicInfo;
        if (z) {
            return str;
        }
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str, MqttTopic.TOPIC_LEVEL_SEPARATOR);
        sbM.append(getAsString());
        return sbM.toString();
    }

    private PskPublicInformation(byte[] bArr) {
        this(new String(bArr, StandardCharsets.UTF_8), bArr);
    }

    public PskPublicInformation(String str, byte[] bArr) {
        super(bArr, 65535, false);
        this.publicInfo = str;
        this.compliantEncoding = Arrays.equals(bArr, str.getBytes(StandardCharsets.UTF_8));
    }
}
