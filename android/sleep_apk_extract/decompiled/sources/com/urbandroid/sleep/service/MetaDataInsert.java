package com.urbandroid.sleep.service;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.List;
import org.mp4parser.Box;
import org.mp4parser.Container;
import org.mp4parser.IsoFile;
import org.mp4parser.boxes.apple.AppleAlbumBox;
import org.mp4parser.boxes.apple.AppleArtistBox;
import org.mp4parser.boxes.apple.AppleCommentBox;
import org.mp4parser.boxes.apple.AppleCoverBox;
import org.mp4parser.boxes.apple.AppleGenreBox;
import org.mp4parser.boxes.apple.AppleItemListBox;
import org.mp4parser.boxes.apple.AppleNameBox;
import org.mp4parser.boxes.iso14496.part12.ChunkOffsetBox;
import org.mp4parser.boxes.iso14496.part12.FreeBox;
import org.mp4parser.boxes.iso14496.part12.HandlerBox;
import org.mp4parser.boxes.iso14496.part12.MediaDataBox;
import org.mp4parser.boxes.iso14496.part12.MetaBox;
import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mp4parser.boxes.iso14496.part12.UserDataBox;
import org.mp4parser.support.AbstractContainerBox;
import org.mp4parser.tools.Path;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class MetaDataInsert {

    public static class BetterByteArrayOutputStream extends ByteArrayOutputStream {
        public /* synthetic */ BetterByteArrayOutputStream(int i) {
            this();
        }

        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }

        private BetterByteArrayOutputStream() {
        }
    }

    private void correctChunkOffsets(MovieBox movieBox, long j) {
        List paths = Path.getPaths((Box) movieBox, "trak/mdia[0]/minf[0]/stbl[0]/stco[0]");
        if (paths.isEmpty()) {
            paths = Path.getPaths((Box) movieBox, "trak/mdia[0]/minf[0]/stbl[0]/st64[0]");
        }
        Iterator it = paths.iterator();
        while (it.hasNext()) {
            long[] chunkOffsets = ((ChunkOffsetBox) it.next()).getChunkOffsets();
            for (int i = 0; i < chunkOffsets.length; i++) {
                chunkOffsets[i] = chunkOffsets[i] + j;
            }
        }
    }

    private boolean needsOffsetCorrection(IsoFile isoFile) {
        if (Path.getPath(isoFile, "moov[0]/mvex[0]") != null) {
            return false;
        }
        for (Box box : isoFile.getBoxes()) {
            if (MovieBox.TYPE.equals(box.getType())) {
                return true;
            }
            if (MediaDataBox.TYPE.equals(box.getType())) {
                return false;
            }
        }
        Types$$ExternalSyntheticBUOutline0.m$2("I need moov or mdat. Otherwise all this doesn't make sense");
        return false;
    }

    public FreeBox findFreeBox(Container container) {
        FreeBox freeBoxFindFreeBox;
        for (Box box : container.getBoxes()) {
            System.err.println(box.getType());
            if (box instanceof FreeBox) {
                return (FreeBox) box;
            }
            if ((box instanceof Container) && (freeBoxFindFreeBox = findFreeBox((Container) box)) != null) {
                return freeBoxFindFreeBox;
            }
        }
        return null;
    }

    public FileChannel splitFileAndInsert(File file, long j, long j2) throws IOException {
        FileChannel channel = new RandomAccessFile(file, "r").getChannel();
        File fileCreateTempFile = File.createTempFile("ChangeMetaData", "splitFileAndInsert");
        FileChannel channel2 = new RandomAccessFile(fileCreateTempFile, "rw").getChannel();
        channel.position(j);
        channel2.transferFrom(channel, 0L, channel.size() - j);
        channel.close();
        FileChannel channel3 = new RandomAccessFile(file, "rw").getChannel();
        channel3.position(j + j2);
        long jTransferTo = 0;
        channel2.position(0L);
        while (true) {
            FileChannel fileChannel = channel3;
            FileChannel fileChannel2 = channel2;
            jTransferTo += fileChannel2.transferTo(0L, channel2.size() - jTransferTo, fileChannel);
            if (jTransferTo == fileChannel2.size()) {
                System.out.println(jTransferTo);
                fileChannel2.close();
                fileCreateTempFile.delete();
                return fileChannel;
            }
            System.out.println(jTransferTo);
            channel2 = fileChannel2;
            channel3 = fileChannel;
        }
    }

    public void writeRandomMetadata(File file, String str, String str2, String str3, String str4, String str5, byte[] bArr) throws IOException {
        long j;
        long j2;
        FileChannel channel;
        if (!file.exists()) {
            throw new FileNotFoundException("File " + file + " not exists");
        }
        if (!file.canWrite()) {
            Home$$ExternalSyntheticBUOutline0.m$2("No write permissions to file ", file);
            return;
        }
        IsoFile isoFile = new IsoFile(file);
        MovieBox movieBox = (MovieBox) isoFile.getBoxes(MovieBox.class).get(0);
        FreeBox freeBoxFindFreeBox = findFreeBox(movieBox);
        boolean zNeedsOffsetCorrection = needsOffsetCorrection(isoFile);
        long size = movieBox.getSize();
        Iterator<Box> it = isoFile.getBoxes().iterator();
        long size2 = 0;
        while (true) {
            if (!it.hasNext()) {
                j = 0;
                break;
            }
            Box next = it.next();
            j = 0;
            if (MovieBox.TYPE.equals(next.getType())) {
                break;
            } else {
                size2 += next.getSize();
            }
        }
        UserDataBox userDataBox = (UserDataBox) Path.getPath((AbstractContainerBox) movieBox, UserDataBox.TYPE);
        if (userDataBox == null) {
            userDataBox = new UserDataBox();
            movieBox.addBox(userDataBox);
        }
        MetaBox metaBox = (MetaBox) Path.getPath((AbstractContainerBox) userDataBox, MetaBox.TYPE);
        if (metaBox == null) {
            metaBox = new MetaBox();
            HandlerBox handlerBox = new HandlerBox();
            handlerBox.setHandlerType("mdir");
            metaBox.addBox(handlerBox);
            userDataBox.addBox(metaBox);
        }
        AppleItemListBox appleItemListBox = (AppleItemListBox) Path.getPath((AbstractContainerBox) metaBox, AppleItemListBox.TYPE);
        if (appleItemListBox == null) {
            appleItemListBox = new AppleItemListBox();
            metaBox.addBox(appleItemListBox);
        }
        if (freeBoxFindFreeBox == null) {
            freeBoxFindFreeBox = new FreeBox(131072);
            metaBox.addBox(freeBoxFindFreeBox);
        }
        AppleNameBox appleNameBox = new AppleNameBox();
        appleNameBox.setValue(str);
        appleItemListBox.addBox(appleNameBox);
        AppleArtistBox appleArtistBox = new AppleArtistBox();
        appleArtistBox.setValue(str2);
        appleItemListBox.addBox(appleArtistBox);
        AppleAlbumBox appleAlbumBox = new AppleAlbumBox();
        appleAlbumBox.setValue(str3);
        appleItemListBox.addBox(appleAlbumBox);
        AppleGenreBox appleGenreBox = new AppleGenreBox();
        appleGenreBox.setValue(str4);
        appleItemListBox.addBox(appleGenreBox);
        AppleCommentBox appleCommentBox = new AppleCommentBox();
        appleCommentBox.setValue(str5);
        appleItemListBox.addBox(appleCommentBox);
        AppleCoverBox appleCoverBox = new AppleCoverBox();
        appleCoverBox.setJpg(bArr);
        appleItemListBox.addBox(appleCoverBox);
        long size3 = movieBox.getSize();
        long j3 = size3 - size;
        FreeBox freeBox = freeBoxFindFreeBox;
        if (freeBoxFindFreeBox.getData().limit() > j3) {
            freeBox.setData(ByteBuffer.allocate((int) (((long) freeBox.getData().limit()) - j3)));
            size3 = movieBox.getSize();
            j3 = size3 - size;
        }
        if (zNeedsOffsetCorrection && j3 != j) {
            correctChunkOffsets(movieBox, j3);
        }
        BetterByteArrayOutputStream betterByteArrayOutputStream = new BetterByteArrayOutputStream(0);
        movieBox.getBox(Channels.newChannel(betterByteArrayOutputStream));
        isoFile.close();
        if (j3 != j) {
            long j4 = size2;
            channel = splitFileAndInsert(file, j4, size3 - size);
            j2 = j4;
        } else {
            j2 = size2;
            channel = new RandomAccessFile(file, "rw").getChannel();
        }
        channel.position(j2);
        channel.write(ByteBuffer.wrap(betterByteArrayOutputStream.getBuffer(), 0, betterByteArrayOutputStream.size()));
        channel.close();
    }
}
