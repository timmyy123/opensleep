package adamb.vorbis;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import adamb.ogg.Packet;
import adamb.ogg.PacketStream;
import adamb.util.Util;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class VorbisPacketStream {
    static final byte[] VORBIS = {118, 111, 114, 98, 105, 115};
    private Packet commentHeader;
    private VorbisIDHeader idHeader;
    private int packetNumber = 0;
    private PacketStream packetStream;

    public VorbisPacketStream(PacketStream packetStream) {
        this.packetStream = packetStream;
    }

    public static void validateHeaderPacket(Packet packet, int i) throws IOException {
        String str;
        int iUbyte;
        int commentStructureLength;
        byte[] bytes = packet.getBytes();
        int length = bytes.length;
        byte[] bArr = VORBIS;
        if (length >= bArr.length + 2) {
            int iUbyte2 = Util.ubyte(bytes[0]);
            if (iUbyte2 != i) {
                throw new IOException("Incorrect Vorbis Header type " + iUbyte2 + "!  Expected " + i + ".");
            }
            if (!Util.intervalEquals(bytes, 1, bArr)) {
                str = "Packet does not contain \"vorbis\"!";
            } else if (iUbyte2 != 3 || (commentStructureLength = VorbisCommentHeader.getCommentStructureLength(packet)) == -1) {
                byte b = bytes[bytes.length - 1];
                iUbyte = Util.ubyte(b);
                if ((i != 5 && Integer.bitCount(iUbyte) == 1) || (i != 5 && iUbyte == 1)) {
                    long j = packet.getStartingPage().absGranulePos;
                    if (j != 0 && j != -1) {
                        str = "Vorbis header with non-zero granule position!";
                    } else if (i == 3 && packet.getStartingPage().isContinued) {
                        str = "Vorbis comment header must be on a fresh page!";
                    } else if (i != 5 || packet.finishesOnPageBoundary()) {
                        return;
                    } else {
                        str = "Vorbis setup header must finish on a page boundary!";
                    }
                }
            } else {
                iUbyte = bytes[commentStructureLength];
                str = i != 5 ? "Header packet does not have correct framing bit set!" : "Header packet does not have correct framing bit set!";
            }
        } else {
            str = "Packet is too small to be a Vorbis header!";
        }
        OggIO$$ExternalSyntheticBUOutline0.m(str);
    }

    public Packet next() throws IOException {
        int i = this.packetNumber + 1;
        this.packetNumber = i;
        PacketStream packetStream = this.packetStream;
        if (i >= 4) {
            return packetStream.next();
        }
        Packet next = packetStream.next();
        int i2 = this.packetNumber;
        if (next == null) {
            throw new EOFException("Incomplete Vorbis stream!  Missing " + (4 - i2) + " of the 3 required header packets.");
        }
        if (i2 == 1) {
            validateHeaderPacket(next, 1);
            this.idHeader = new VorbisIDHeader(next);
            return next;
        }
        if (i2 == 2) {
            validateHeaderPacket(next, 3);
            this.commentHeader = next;
            return next;
        }
        if (i2 == 3) {
            validateHeaderPacket(next, 5);
        }
        return next;
    }
}
