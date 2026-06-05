package org.mp4parser;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.tools.IsoTypeReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBoxParser implements BoxParser {
    private static Logger LOG = LoggerFactory.getLogger(AbstractBoxParser.class.getName());
    ThreadLocal<ByteBuffer> header = new ThreadLocal<ByteBuffer>() { // from class: org.mp4parser.AbstractBoxParser.1
        @Override // java.lang.ThreadLocal
        public ByteBuffer initialValue() {
            return ByteBuffer.allocate(32);
        }
    };
    private List<String> skippedTypes;

    public abstract ParsableBox createBox(String str, byte[] bArr, String str2);

    @Override // org.mp4parser.BoxParser
    public ParsableBox parseBox(ReadableByteChannel readableByteChannel, String str) throws IOException {
        int i;
        long uInt64;
        ParsableBox parsableBoxCreateBox;
        this.header.get().rewind().limit(8);
        int i2 = 0;
        do {
            i = readableByteChannel.read(this.header.get());
            i2 += i;
            byte[] bArr = null;
            if (i2 >= 8) {
                this.header.get().rewind();
                long uInt32 = IsoTypeReader.readUInt32(this.header.get());
                if (uInt32 < 8 && uInt32 > 1) {
                    LOG.error("Plausibility check failed: size < 8 (size = {}). Stop parsing!", Long.valueOf(uInt32));
                    return null;
                }
                String str2 = IsoTypeReader.read4cc(this.header.get());
                if (uInt32 == 1) {
                    readableByteChannel.read(this.header.get());
                    uInt64 = IsoTypeReader.readUInt64(this.header.get()) - 16;
                } else {
                    if (uInt32 == 0) {
                        Types$$ExternalSyntheticBUOutline0.m$2("box size of zero means 'till end of file. That is not yet supported");
                        return null;
                    }
                    uInt64 = uInt32 - 8;
                }
                if ("uuid".equals(str2)) {
                    readableByteChannel.read(this.header.get());
                    byte[] bArr2 = new byte[16];
                    for (int iPosition = this.header.get().position() - 16; iPosition < this.header.get().position(); iPosition++) {
                        bArr2[iPosition - (this.header.get().position() - 16)] = this.header.get().get(iPosition);
                    }
                    uInt64 -= 16;
                    bArr = bArr2;
                }
                List<String> list = this.skippedTypes;
                if (list == null || !list.contains(str2)) {
                    LOG.trace("Creating box {} {} {}", str2, bArr, str);
                    parsableBoxCreateBox = createBox(str2, bArr, str);
                } else {
                    LOG.trace("Skipping box {} {} {}", str2, bArr, str);
                    parsableBoxCreateBox = new SkipBox(str2, bArr, str);
                }
                ParsableBox parsableBox = parsableBoxCreateBox;
                this.header.get().rewind();
                parsableBox.parse(readableByteChannel, this.header.get(), uInt64, this);
                return parsableBox;
            }
        } while (i >= 0);
        Utf8$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }
}
