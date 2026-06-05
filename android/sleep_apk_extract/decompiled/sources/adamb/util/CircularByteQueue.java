package adamb.util;

/* JADX INFO: loaded from: classes.dex */
public class CircularByteQueue {
    private byte[] array;
    private int head = 0;
    private int size;

    public CircularByteQueue(byte[] bArr, boolean z) {
        this.array = bArr;
        if (z) {
            this.size = bArr.length;
        } else {
            this.size = 0;
        }
    }

    public boolean equals(byte[] bArr) {
        int length = bArr.length;
        int i = this.size;
        if (length != i) {
            return false;
        }
        if (i <= 0) {
            return true;
        }
        int length2 = this.array.length - this.head;
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3++) {
            if (this.array[this.head + i3] != bArr[i2]) {
                return false;
            }
            i2++;
        }
        int i4 = this.size - length2;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.array[i5] != bArr[i2]) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public void put(byte b) {
        int i = this.head;
        int i2 = this.size;
        int i3 = i + i2;
        byte[] bArr = this.array;
        if (i3 < bArr.length) {
            bArr[i + i2] = b;
            this.size = i2 + 1;
            return;
        }
        int length = i2 - (bArr.length - i);
        bArr[length] = b;
        if (length != i) {
            this.size = i2 + 1;
            return;
        }
        int i4 = i + 1;
        this.head = i4;
        if (i4 == bArr.length) {
            this.head = 0;
        }
    }
}
