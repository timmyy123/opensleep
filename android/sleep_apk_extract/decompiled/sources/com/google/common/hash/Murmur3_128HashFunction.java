package com.google.common.hash;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    public static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private long h1;
        private long h2;
        private int length;

        public Murmur3_128Hasher(int i) {
            super(16);
            long j = i;
            this.h1 = j;
            this.h2 = j;
            this.length = 0;
        }

        private void bmix64(long j, long j2) {
            long jMixK1 = mixK1(j) ^ this.h1;
            this.h1 = jMixK1;
            long jRotateLeft = Long.rotateLeft(jMixK1, 27);
            long j3 = this.h2;
            this.h1 = ((jRotateLeft + j3) * 5) + 1390208809;
            long jMixK2 = mixK2(j2) ^ j3;
            this.h2 = jMixK2;
            this.h2 = ((Long.rotateLeft(jMixK2, 31) + this.h1) * 5) + 944331445;
        }

        private static long fmix64(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        private static long mixK1(long j) {
            return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        private static long mixK2(long j) {
            return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j = this.h1;
            long j2 = this.length;
            long j3 = j ^ j2;
            long j4 = j2 ^ this.h2;
            long j5 = j3 + j4;
            this.h1 = j5;
            this.h2 = j4 + j5;
            this.h1 = fmix64(j5);
            long jFmix64 = fmix64(this.h2);
            long j6 = this.h1 + jFmix64;
            this.h1 = j6;
            this.h2 = jFmix64 + j6;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.h1).putLong(this.h2).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            this.length = byteBuffer.remaining() + this.length;
            long j8 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j = 0;
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 2:
                    j2 = 0;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 3:
                    j3 = 0;
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 4:
                    j4 = 0;
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 5:
                    j5 = 0;
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 6:
                    j6 = 0;
                    j5 = (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40) ^ j6;
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 7:
                    j6 = ((long) UnsignedBytes.toInt(byteBuffer.get(6))) << 48;
                    j5 = (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40) ^ j6;
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j2 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j3;
                    j = j2 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j7 = j ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 8:
                    j7 = byteBuffer.getLong();
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 9:
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 10:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 11:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 12:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 13:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 14:
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                case 15:
                    j8 = ((long) UnsignedBytes.toInt(byteBuffer.get(14))) << 48;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j8 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j8 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong();
                    this.h1 = mixK1(j7) ^ this.h1;
                    this.h2 ^= mixK2(j8);
                    break;
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "Should never get here.");
                    break;
            }
        }
    }

    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return this.seed ^ Murmur3_128HashFunction.class.hashCode();
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(this.seed, ")", new StringBuilder("Hashing.murmur3_128("));
    }
}
