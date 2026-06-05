package org.mp4parser.boxes.microsoft.contentprotection;

import java.nio.ByteBuffer;
import java.util.UUID;
import org.mp4parser.boxes.microsoft.ProtectionSpecificHeader;

/* JADX INFO: loaded from: classes5.dex */
public class GenericHeader extends ProtectionSpecificHeader {
    public static UUID PROTECTION_SYSTEM_ID;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    ByteBuffer f135data;

    static {
        UUID uuidFromString = UUID.fromString("00000000-0000-0000-0000-000000000000");
        PROTECTION_SYSTEM_ID = uuidFromString;
        ProtectionSpecificHeader.uuidRegistry.put(uuidFromString, GenericHeader.class);
    }

    @Override // org.mp4parser.boxes.microsoft.ProtectionSpecificHeader
    public ByteBuffer getData() {
        return this.f135data;
    }

    @Override // org.mp4parser.boxes.microsoft.ProtectionSpecificHeader
    public UUID getSystemId() {
        return PROTECTION_SYSTEM_ID;
    }

    @Override // org.mp4parser.boxes.microsoft.ProtectionSpecificHeader
    public void parse(ByteBuffer byteBuffer) {
        this.f135data = byteBuffer;
    }
}
