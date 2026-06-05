package org.mp4parser.boxes.iso23001.part7;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.math.BigInteger;
import java.util.Arrays;
import org.mp4parser.tools.Hex;

/* JADX INFO: loaded from: classes5.dex */
public class CencSampleAuxiliaryDataFormat {
    public byte[] iv = new byte[0];
    public Pair[] pairs = null;

    public class ByteBytePair extends AbstractPair {
        private byte clear;
        private byte encrypted;

        public ByteBytePair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = (byte) i;
            this.encrypted = (byte) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class ByteIntPair extends AbstractPair {
        private byte clear;
        private int encrypted;

        public ByteIntPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = (byte) i;
            this.encrypted = (int) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class ByteLongPair extends AbstractPair {
        private byte clear;
        private long encrypted;

        public ByteLongPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = (byte) i;
            this.encrypted = j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class ByteShortPair extends AbstractPair {
        private byte clear;
        private short encrypted;

        public ByteShortPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = (byte) i;
            this.encrypted = (short) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class IntBytePair extends AbstractPair {
        private int clear;
        private byte encrypted;

        public IntBytePair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = i;
            this.encrypted = (byte) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class IntIntPair extends AbstractPair {
        private int clear;
        private int encrypted;

        public IntIntPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = i;
            this.encrypted = (int) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class IntLongPair extends AbstractPair {
        private int clear;
        private long encrypted;

        public IntLongPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = i;
            this.encrypted = j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class IntShortPair extends AbstractPair {
        private int clear;
        private short encrypted;

        public IntShortPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = i;
            this.encrypted = (short) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public interface Pair {
        int clear();

        long encrypted();
    }

    public class ShortBytePair extends AbstractPair {
        private short clear;
        private byte encrypted;

        public ShortBytePair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = (short) i;
            this.encrypted = (byte) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class ShortIntPair extends AbstractPair {
        private short clear;
        private int encrypted;

        public ShortIntPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = (short) i;
            this.encrypted = (int) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class ShortLongPair extends AbstractPair {
        private short clear;
        private long encrypted;

        public ShortLongPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = (short) i;
            this.encrypted = j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public class ShortShortPair extends AbstractPair {
        private short clear;
        private short encrypted;

        public ShortShortPair(int i, long j) {
            super(CencSampleAuxiliaryDataFormat.this, null);
            this.clear = (short) i;
            this.encrypted = (short) j;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.clear;
        }

        @Override // org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.encrypted;
        }
    }

    public Pair createPair(int i, long j) {
        return i <= 127 ? j <= 127 ? new ByteBytePair(i, j) : j <= 32767 ? new ByteShortPair(i, j) : j <= 2147483647L ? new ByteIntPair(i, j) : new ByteLongPair(i, j) : i <= 32767 ? j <= 127 ? new ShortBytePair(i, j) : j <= 32767 ? new ShortShortPair(i, j) : j <= 2147483647L ? new ShortIntPair(i, j) : new ShortLongPair(i, j) : j <= 127 ? new IntBytePair(i, j) : j <= 32767 ? new IntShortPair(i, j) : j <= 2147483647L ? new IntIntPair(i, j) : new IntLongPair(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = (CencSampleAuxiliaryDataFormat) obj;
        if (!new BigInteger(this.iv).equals(new BigInteger(cencSampleAuxiliaryDataFormat.iv))) {
            return false;
        }
        Pair[] pairArr = this.pairs;
        Pair[] pairArr2 = cencSampleAuxiliaryDataFormat.pairs;
        return pairArr == null ? pairArr2 == null : Arrays.equals(pairArr, pairArr2);
    }

    public int getSize() {
        int length = this.iv.length;
        Pair[] pairArr = this.pairs;
        if (pairArr == null || pairArr.length <= 0) {
            return length;
        }
        return (pairArr.length * 6) + length + 2;
    }

    public int hashCode() {
        byte[] bArr = this.iv;
        int iHashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        Pair[] pairArr = this.pairs;
        return iHashCode + (pairArr != null ? Arrays.hashCode(pairArr) : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Entry{iv=");
        sb.append(Hex.encodeHex(this.iv));
        sb.append(", pairs=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, Arrays.toString(this.pairs), '}');
    }

    public abstract class AbstractPair implements Pair {
        private AbstractPair() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            return clear() == pair.clear() && encrypted() == pair.encrypted();
        }

        public String toString() {
            return "P(" + clear() + "|" + encrypted() + ")";
        }

        public /* synthetic */ AbstractPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, AbstractPair abstractPair) {
            this();
        }
    }
}
