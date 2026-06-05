package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.extractor.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class I0 {
    public final ByteArrayOutputStream A00 = new ByteArrayOutputStream(512);
    public final DataOutputStream A01 = new DataOutputStream(this.A00);

    public static void A00(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public final byte[] A01(EventMessage eventMessage) {
        this.A00.reset();
        try {
            A00(this.A01, eventMessage.A03);
            A00(this.A01, eventMessage.A04 != null ? eventMessage.A04 : "");
            this.A01.writeLong(eventMessage.A01);
            this.A01.writeLong(eventMessage.A02);
            this.A01.write(eventMessage.A05);
            this.A01.flush();
            return this.A00.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
