package org.mp4parser.tools;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.nio.ByteBuffer;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class IsoTypeWriterVariable {
    public static void write(long j, ByteBuffer byteBuffer, int i) {
        if (i == 1) {
            IsoTypeWriter.writeUInt8(byteBuffer, (int) (j & 255));
            return;
        }
        if (i == 2) {
            IsoTypeWriter.writeUInt16(byteBuffer, (int) (j & 65535));
            return;
        }
        if (i == 3) {
            IsoTypeWriter.writeUInt24(byteBuffer, (int) (j & 16777215));
            return;
        }
        if (i == 4) {
            IsoTypeWriter.writeUInt32(byteBuffer, j);
        } else if (i == 8) {
            IsoTypeWriter.writeUInt64(byteBuffer, j);
        } else {
            Types$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "I don't know how to read ", " bytes"));
        }
    }
}
