package com.facebook.ads.redexgen.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.n9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1788n9 implements FF {
    public final int A00;

    public C1788n9() {
        this(-1);
    }

    public C1788n9(int i) {
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.core.FF
    public final int A8Z(int i) {
        if (this.A00 == -1) {
            if (i == 7) {
                return 6;
            }
            return 3;
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.FF
    public final long A8u(FE fe) {
        IOException iOException = fe.A03;
        if ((iOException instanceof C3K) || (iOException instanceof FileNotFoundException) || (iOException instanceof AM) || (iOException instanceof FP) || C02345b.A00(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((fe.A00 - 1) * 1000, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT);
    }
}
