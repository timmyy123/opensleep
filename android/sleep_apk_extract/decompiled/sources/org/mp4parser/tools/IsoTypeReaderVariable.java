package org.mp4parser.tools;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.nio.ByteBuffer;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class IsoTypeReaderVariable {
    public static long read(ByteBuffer byteBuffer, int i) {
        if (i == 1) {
            return IsoTypeReader.readUInt8(byteBuffer);
        }
        if (i == 2) {
            return IsoTypeReader.readUInt16(byteBuffer);
        }
        if (i == 3) {
            return IsoTypeReader.readUInt24(byteBuffer);
        }
        if (i == 4) {
            return IsoTypeReader.readUInt32(byteBuffer);
        }
        if (i == 8) {
            return IsoTypeReader.readUInt64(byteBuffer);
        }
        Types$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "I don't know how to read ", " bytes"));
        return 0L;
    }
}
