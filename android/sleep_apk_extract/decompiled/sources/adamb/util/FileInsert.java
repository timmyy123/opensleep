package adamb.util;

import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public class FileInsert {
    private byte[] chunk;

    public FileInsert(int i) {
        this.chunk = new byte[i];
    }

    private int readCompletely(RandomAccessFile randomAccessFile, byte[] bArr, int i) throws IOException {
        int i2 = randomAccessFile.read(bArr, 0, i);
        while (i2 < i) {
            if (i2 == -1) {
                return 0;
            }
            i2 += randomAccessFile.read(bArr, i2, i - i2);
        }
        return i2;
    }

    public void insert(RandomAccessFile randomAccessFile, long j, long j2, byte[] bArr, int i, int i2) throws IOException {
        long j3;
        long j4 = j2;
        long length = randomAccessFile.length();
        if (j < 0 || j > j4 || j > length || j4 > length) {
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Invalid insertion interval!: from=", " to=", j);
            sbM.append(j4);
            sbM.append(" (file size=");
            sbM.append(length);
            sbM.append(")");
            throw new IllegalArgumentException(sbM.toString());
        }
        boolean z = true;
        if (i2 > 0) {
            byte b = bArr[i];
            byte b2 = bArr[(i + i2) - 1];
        }
        long j5 = ((long) i2) - (j4 - j);
        if (j5 > 0) {
            int length2 = this.chunk.length;
            boolean z2 = false;
            while (!z2) {
                long j6 = length;
                long j7 = length2;
                long j8 = j6 - j7;
                if (j8 <= j4) {
                    length2 = (int) ((j8 + j7) - j4);
                    z2 = z;
                    j3 = j4;
                } else {
                    j3 = j8;
                }
                randomAccessFile.seek(j3);
                int completely = readCompletely(randomAccessFile, this.chunk, length2);
                if (completely != length2) {
                    throw new IOException("Unexpected read shortage: " + completely + " bytes instead of " + length2 + '!');
                }
                long j9 = j3;
                randomAccessFile.seek(j9 + j5);
                randomAccessFile.write(this.chunk, 0, length2);
                length = j9;
                z = true;
            }
        } else if (j5 < 0) {
            while (true) {
                randomAccessFile.seek(j4);
                int i3 = randomAccessFile.read(this.chunk);
                if (i3 == -1) {
                    break;
                }
                long j10 = j4;
                randomAccessFile.seek(j10 + j5);
                randomAccessFile.write(this.chunk, 0, i3);
                j4 = j10 + ((long) i3);
            }
            randomAccessFile.setLength(length + j5);
        }
        randomAccessFile.seek(j);
        randomAccessFile.write(bArr, i, i2);
    }
}
