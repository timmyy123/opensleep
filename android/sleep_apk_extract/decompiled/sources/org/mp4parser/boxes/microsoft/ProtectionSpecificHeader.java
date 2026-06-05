package org.mp4parser.boxes.microsoft;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.boxes.microsoft.contentprotection.GenericHeader;
import org.mp4parser.tools.Hex;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ProtectionSpecificHeader {
    protected static Map<UUID, Class<? extends ProtectionSpecificHeader>> uuidRegistry = new HashMap();

    public static ProtectionSpecificHeader createFor(UUID uuid, ByteBuffer byteBuffer) throws IllegalAccessException, InstantiationException {
        Class<? extends ProtectionSpecificHeader> cls = uuidRegistry.get(uuid);
        ProtectionSpecificHeader protectionSpecificHeaderNewInstance = null;
        if (cls != null) {
            try {
                protectionSpecificHeaderNewInstance = cls.newInstance();
            } catch (IllegalAccessException e) {
                Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                return null;
            } catch (InstantiationException e2) {
                Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e2);
                return null;
            }
        }
        if (protectionSpecificHeaderNewInstance == null) {
            protectionSpecificHeaderNewInstance = new GenericHeader();
        }
        protectionSpecificHeaderNewInstance.parse(byteBuffer);
        return protectionSpecificHeaderNewInstance;
    }

    public boolean equals(Object obj) {
        throw new RuntimeException("somebody called equals on me but that's not supposed to happen.");
    }

    public abstract ByteBuffer getData();

    public abstract UUID getSystemId();

    public abstract void parse(ByteBuffer byteBuffer);

    public String toString() {
        StringBuilder sb = new StringBuilder("ProtectionSpecificHeader{data=");
        ByteBuffer byteBufferDuplicate = getData().duplicate();
        byteBufferDuplicate.rewind();
        byte[] bArr = new byte[byteBufferDuplicate.limit()];
        byteBufferDuplicate.get(bArr);
        sb.append(Hex.encodeHex(bArr));
        sb.append('}');
        return sb.toString();
    }
}
