package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.home.platform.traits.ValidationIssue;
import java.nio.ByteBuffer;
import org.mp4parser.tools.Hex;
import org.mp4parser.tools.IsoTypeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, ModuleDescriptor.MODULE_VERSION, 186, 187, 188, 189, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, ValidationIssue.INVALID_ENTITY_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253})
public class ExtensionDescriptor extends BaseDescriptor {
    private static Logger LOG = LoggerFactory.getLogger(ExtensionDescriptor.class.getName());

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    ByteBuffer f127data;

    public static int[] allTags() {
        int[] iArr = new int[148];
        for (int i = 106; i < 254; i++) {
            int i2 = i - 106;
            LOG.trace("pos: {}", Integer.valueOf(i2));
            iArr[i2] = i;
        }
        return iArr;
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public int getContentSize() {
        return this.f127data.remaining();
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) {
        this.f127data = byteBuffer.slice();
        byteBuffer.position(this.f127data.remaining() + byteBuffer.position());
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public ByteBuffer serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getSize());
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.tag);
        writeSize(byteBufferAllocate, getContentSize());
        byteBufferAllocate.put(this.f127data.duplicate());
        return byteBufferAllocate;
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public String toString() {
        return "ExtensionDescriptortag=" + this.tag + ",bytes=" + Hex.encodeHex(this.f127data.array()) + '}';
    }
}
