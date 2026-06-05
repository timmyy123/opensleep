package adamb.vorbis;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import adamb.ogg.Packet;
import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import adamb.util.Util;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class VorbisIDHeader {
    public int audioChannels;
    public long audioSampleRate;
    public int blockSize0;
    public int blockSize1;
    public int maxBitRate;
    public int minBitRate;
    public int nominalBitRate;

    public VorbisIDHeader(Packet packet) throws IOException {
        int i;
        byte[] bytes = packet.getBytes();
        if (bytes.length != 30) {
            OggIO$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(bytes.length, " for Vorbis ID header", new StringBuilder("Invalid packet size ")));
            throw null;
        }
        int length = VorbisPacketStream.VORBIS.length;
        int iAsIntLE = Util.asIntLE(bytes, length + 1, 4);
        this.audioChannels = Util.ubyte(bytes[length + 5]);
        this.audioSampleRate = Util.asLongLE(bytes, length + 6, 4);
        this.maxBitRate = Util.asIntLE(bytes, length + 10, 4);
        this.nominalBitRate = Util.asIntLE(bytes, length + 14, 4);
        this.minBitRate = Util.asIntLE(bytes, length + 18, 4);
        int i2 = length + 22;
        int iLowNibble = Util.lowNibble(bytes[i2]);
        int iHighNibble = Util.highNibble(bytes[i2]);
        this.blockSize0 = (int) Math.pow(2.0d, iLowNibble);
        this.blockSize1 = (int) Math.pow(2.0d, iHighNibble);
        Util.ubyte(bytes[length + 23]);
        if (iAsIntLE != 0) {
            OggIO$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(iAsIntLE, "Incompatible Voribis version "));
            throw null;
        }
        if (this.audioChannels <= 0) {
            OggIO$$ExternalSyntheticBUOutline0.m("Audio channels must be > 0");
            throw null;
        }
        if (this.audioSampleRate <= 0) {
            OggIO$$ExternalSyntheticBUOutline0.m("Audio sample rate must be greater than 0");
            throw null;
        }
        int i3 = this.blockSize0;
        if (i3 < 64 || i3 >= 8192 || (i = this.blockSize1) < 64 || i >= 8192 || i3 > i) {
            StringBuilder sb = new StringBuilder("Invalid block size values (");
            sb.append(this.blockSize0);
            sb.append(",");
            OggIO$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.blockSize1, ")", sb));
            throw null;
        }
    }
}
