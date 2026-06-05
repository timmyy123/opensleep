package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ApplicationMessage extends AbstractMessage {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private final byte[] f122data;

    public ApplicationMessage(byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        if (bArr != null) {
            this.f122data = bArr;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("data must not be null!");
            throw null;
        }
    }

    public static DTLSMessage fromByteArray(byte[] bArr, InetSocketAddress inetSocketAddress) {
        return new ApplicationMessage(bArr, inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public ContentType getContentType() {
        return ContentType.APPLICATION_DATA;
    }

    public byte[] getData() {
        return this.f122data;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public int size() {
        return this.f122data.length;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public byte[] toByteArray() {
        return this.f122data;
    }

    public String toString() {
        return "\tApplication Data: " + StringUtil.byteArray2Hex(this.f122data) + StringUtil.lineSeparator();
    }
}
