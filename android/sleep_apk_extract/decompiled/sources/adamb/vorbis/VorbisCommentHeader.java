package adamb.vorbis;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import adamb.ogg.Packet;
import adamb.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class VorbisCommentHeader implements Serializable {
    public List<CommentField> fields;
    public String vendor;

    public VorbisCommentHeader(Packet packet) throws IOException {
        this();
        VorbisPacketStream.validateHeaderPacket(packet, 3);
        byte[] bytes = packet.getBytes();
        int length = VorbisPacketStream.VORBIS.length;
        int i = length + 1;
        ensureData(i, 4, bytes);
        int iAsIntLE = Util.asIntLE(bytes, i, 4);
        int i2 = length + 5;
        ensureData(i2, iAsIntLE, bytes);
        String strTrim = Util.asUTF8(bytes, i2, iAsIntLE).trim();
        this.vendor = strTrim;
        if (strTrim == null) {
            OggIO$$ExternalSyntheticBUOutline0.m("Invalid UTF-8 in vendor string");
            throw null;
        }
        int i3 = i2 + iAsIntLE;
        ensureData(i3, 4, bytes);
        int iAsIntLE2 = Util.asIntLE(bytes, i3, 4);
        int i4 = i3 + 4;
        for (int i5 = 0; i5 < iAsIntLE2; i5++) {
            ensureData(i4, 4, bytes);
            int iAsIntLE3 = Util.asIntLE(bytes, i4, 4);
            int i6 = i4 + 4;
            ensureData(i6, iAsIntLE3, bytes);
            String strAsUTF8 = Util.asUTF8(bytes, i6, iAsIntLE3);
            i4 = i6 + iAsIntLE3;
            if (strAsUTF8 == null) {
                OggIO$$ExternalSyntheticBUOutline0.m("Invalid UTF-8 in vendor string");
                throw null;
            }
            this.fields.add(new CommentField(strAsUTF8));
        }
    }

    private static void ensureData(int i, int i2, byte[] bArr) throws IOException {
        if (i + i2 <= bArr.length) {
            return;
        }
        OggIO$$ExternalSyntheticBUOutline0.m("Vorbis comment header is incomplete.");
    }

    public static int getCommentStructureLength(Packet packet) {
        int iAsIntLE;
        int iAsIntLE2;
        byte[] bytes = packet.getBytes();
        int length = VorbisPacketStream.VORBIS.length;
        int i = length + 1;
        int i2 = length + 5;
        if (i2 > bytes.length || (iAsIntLE = Util.asIntLE(bytes, i, 4) + i2) > bytes.length || (iAsIntLE2 = iAsIntLE + 4) > bytes.length) {
            return -1;
        }
        int iAsIntLE3 = Util.asIntLE(bytes, iAsIntLE, 4);
        for (int i3 = 0; i3 < iAsIntLE3; i3++) {
            int i4 = iAsIntLE2 + 4;
            if (i4 > bytes.length || (iAsIntLE2 = Util.asIntLE(bytes, iAsIntLE2, 4) + i4) > bytes.length) {
                return -1;
            }
        }
        return iAsIntLE2;
    }

    public byte[] toPacket() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        try {
            byteArrayOutputStream.write(3);
            byteArrayOutputStream.write(VorbisPacketStream.VORBIS);
            byte[] bytes = this.vendor.getBytes(OAuth.ENCODING);
            byteArrayOutputStream.write(Util.intLE(bytes.length));
            byteArrayOutputStream.write(bytes);
            byteArrayOutputStream.write(Util.intLE(this.fields.size()));
            StringBuilder sb = new StringBuilder(128);
            for (CommentField commentField : this.fields) {
                sb.setLength(0);
                sb.append(commentField.name);
                sb.append('=');
                sb.append(commentField.value);
                byte[] bytes2 = sb.toString().getBytes(OAuth.ENCODING);
                byteArrayOutputStream.write(Util.intLE(bytes2.length));
                byteArrayOutputStream.write(bytes2);
            }
            byteArrayOutputStream.write(1);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public VorbisCommentHeader() {
        this.vendor = "";
        this.fields = new ArrayList(32);
    }
}
