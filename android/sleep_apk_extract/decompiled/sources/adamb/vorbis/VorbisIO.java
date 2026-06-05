package adamb.vorbis;

import adamb.ogg.ErrorTolerantPageStream;
import adamb.ogg.OggCRC;
import adamb.ogg.OggIO;
import adamb.ogg.Packet;
import adamb.ogg.PacketSegmentStream;
import adamb.ogg.PacketStream;
import adamb.ogg.Page;
import adamb.ogg.PhysicalPageStream;
import adamb.ogg.Segment;
import adamb.ogg.StreamSerialFilter;
import adamb.util.FileInsert;
import com.facebook.internal.Utility;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.archive.io.RandomAccessInputStream;
import org.archive.io.RandomAccessOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class VorbisIO {
    private static ArrayList<Page> pagify(byte[][] bArr, boolean z) {
        int i = z ? 17 : 255;
        ArrayList<Page> arrayList = new ArrayList<>(8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        Page page = new Page();
        page.isContinued = false;
        int iMin = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = 0;
            while (true) {
                if (page.segments.size() < i) {
                    byte[] bArr2 = bArr[i3];
                    if (i4 >= bArr2.length) {
                        break;
                    }
                    iMin = Math.min(PHIpAddressSearchManager.END_IP_SCAN, bArr2.length - i4);
                    byteArrayOutputStream.write(bArr[i3], i4, iMin);
                    page.segments.add(new Segment(page, i2, iMin));
                    i4 += iMin;
                    i2 += iMin;
                } else {
                    page.content = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.reset();
                    arrayList.add(page);
                    Segment segment = page.segments.get(r3.size() - 1);
                    Page page2 = new Page();
                    page2.isContinued = !segment.isLast();
                    page = page2;
                    i2 = 0;
                }
            }
            if (iMin == 255) {
                page.segments.add(new Segment(page, i2, 0));
            }
        }
        if (page.segments.size() > 0) {
            page.content = byteArrayOutputStream.toByteArray();
            arrayList.add(page);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0054 A[PHI: r14
      0x0054: PHI (r14v2 adamb.vorbis.VorbisCommentHeader) = (r14v0 adamb.vorbis.VorbisCommentHeader), (r14v13 adamb.vorbis.VorbisCommentHeader) binds: [B:6:0x0045, B:8:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void writeComments(File file, VorbisCommentHeader vorbisCommentHeader, CommentUpdater commentUpdater) throws IOException {
        boolean z;
        if (!file.exists()) {
            throw new FileNotFoundException(file.getPath() + " does not exist!");
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        StreamSerialFilter streamSerialFilter = new StreamSerialFilter(new ErrorTolerantPageStream(new PhysicalPageStream(new RandomAccessInputStream(randomAccessFile))), false);
        VorbisPacketStream vorbisPacketStream = new VorbisPacketStream(new PacketStream(new PacketSegmentStream(streamSerialFilter)));
        try {
            Packet next = vorbisPacketStream.next();
            long filePointer = randomAccessFile.getFilePointer();
            Packet next2 = vorbisPacketStream.next();
            int i = next2.getStartingPage().sequence;
            if (commentUpdater != null) {
                vorbisCommentHeader = new VorbisCommentHeader(next2);
                z = commentUpdater.updateComments(vorbisCommentHeader);
            }
            if (z) {
                byte[] packet = vorbisCommentHeader.toPacket();
                int length = next2.getBytes().length - packet.length;
                if (length < 0 || length > 128) {
                    length = 128;
                }
                if (length > 0) {
                    StringBuilder sb = new StringBuilder(vorbisCommentHeader.vendor.length() + length);
                    sb.append(vorbisCommentHeader.vendor);
                    while (length > 0) {
                        sb.append(' ');
                        length--;
                    }
                    String str = vorbisCommentHeader.vendor;
                    vorbisCommentHeader.vendor = sb.toString();
                    packet = vorbisCommentHeader.toPacket();
                    vorbisCommentHeader.vendor = str;
                }
                if (!Arrays.equals(packet, next2.getBytes())) {
                    Packet next3 = vorbisPacketStream.next();
                    long filePointer2 = randomAccessFile.getFilePointer();
                    int i2 = (next3.getLastSegment().getSourcePage().sequence - i) + 1;
                    ArrayList<Page> arrayListPagify = pagify(new byte[][]{packet, next3.getBytes()}, true);
                    Page startingPage = next.getStartingPage();
                    int i3 = startingPage.sequence;
                    for (Page page : arrayListPagify) {
                        page.streamSerialNumber = startingPage.streamSerialNumber;
                        page.absGranulePos = 0L;
                        i3++;
                        page.sequence = i3;
                        page.streamStructureVersion = startingPage.streamStructureVersion;
                        page.isFirst = false;
                        page.isLast = false;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    OggCRC oggCRC = new OggCRC();
                    Iterator<Page> it = arrayListPagify.iterator();
                    while (it.hasNext()) {
                        OggIO.writePageToStream(it.next(), byteArrayOutputStream, oggCRC);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    int size = arrayListPagify.size() - i2;
                    new FileInsert(524288).insert(randomAccessFile, filePointer, filePointer2, byteArray, 0, byteArray.length);
                    if (size != 0) {
                        randomAccessFile.seek(filePointer + ((long) byteArray.length));
                        RandomAccessOutputStream randomAccessOutputStream = new RandomAccessOutputStream(randomAccessFile);
                        while (true) {
                            Page next4 = streamSerialFilter.next();
                            if (next4 == null) {
                                break;
                            }
                            next4.sequence += size;
                            randomAccessFile.seek(randomAccessFile.getFilePointer() - ((long) next4.size()));
                            OggIO.writePageToStream(next4, randomAccessOutputStream, oggCRC);
                        }
                    }
                }
            }
            randomAccessFile.close();
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public static void writeComments(File file, VorbisCommentHeader vorbisCommentHeader) throws IOException {
        writeComments(file, vorbisCommentHeader, null);
    }
}
