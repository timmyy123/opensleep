package org.eclipse.californium.scandium.dtls.cipher;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CCMBlockCipher {
    public static final ThreadLocalCipher CIPHER = new ThreadLocalCipher("AES/ECB/NoPadding");

    public static abstract class Block {
        protected final byte[] block;
        protected final int blockSize;

        public Block(int i) {
            this.blockSize = i;
            this.block = new byte[i];
        }

        public int setIntAtEnd(int i, int i2) {
            int i3 = this.blockSize;
            while (i3 > i) {
                i3--;
                this.block[i3] = (byte) i2;
                i2 >>>= 8;
            }
            return i2;
        }
    }

    public static class BlockCipher extends Block {
        private final Cipher cipher;
        private final int nonceL;
        private final byte[] xblock;

        private BlockCipher(Cipher cipher, byte[] bArr) {
            super(cipher.getBlockSize());
            this.cipher = cipher;
            int length = bArr.length;
            this.nonceL = length;
            int i = this.blockSize;
            int i2 = (i - 1) - length;
            if (i2 >= 2 && i2 <= 8) {
                this.xblock = new byte[i];
                byte[] bArr2 = this.block;
                bArr2[0] = (byte) (i2 - 1);
                System.arraycopy(bArr, 0, bArr2, 1, length);
                return;
            }
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(length, "Nonce length ", " invalid for blocksize ");
            sbM65m.append(this.blockSize);
            sbM65m.append(" (valid length [");
            sbM65m.append(this.blockSize - 9);
            sbM65m.append("-");
            sbM65m.append(this.blockSize - 3);
            sbM65m.append("])");
            throw new IllegalArgumentException(sbM65m.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] updateBlock(int i) throws ShortBufferException {
            if (setIntAtEnd(this.nonceL + 1, i) == 0) {
                this.cipher.update(this.block, 0, this.blockSize, this.xblock);
                return this.xblock;
            }
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Index ", " too large for nonce ");
            sbM65m.append(this.nonceL);
            sbM65m.append(" and blocksize ");
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(this.blockSize, " bytes.", sbM65m));
            return null;
        }
    }

    public static class MacCipher extends Block {
        private final Cipher cipher;
        private final byte[] mac;

        private MacCipher(Cipher cipher, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws ShortBufferException {
            super(cipher.getBlockSize());
            this.cipher = cipher;
            int length = bArr3.length;
            int length2 = bArr2.length;
            int length3 = bArr.length;
            int i2 = (this.blockSize - 1) - length3;
            int i3 = 2;
            if (i2 < 2 || i2 > 8) {
                StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(length3, "Nonce length ", " invalid for blocksize ");
                sbM65m.append(this.blockSize);
                sbM65m.append(" (valid length [");
                sbM65m.append(this.blockSize - 9);
                sbM65m.append("-");
                sbM65m.append(this.blockSize - 3);
                sbM65m.append("])");
                throw new IllegalArgumentException(sbM65m.toString());
            }
            int i4 = length2 > 0 ? 1 : 0;
            byte[] bArr4 = this.block;
            bArr4[0] = (byte) ((((i - 2) / 2) * 8) + (i4 * 64) + (i2 - 1));
            System.arraycopy(bArr, 0, bArr4, 1, length3);
            if (setIntAtEnd(length3 + 1, length) != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(this.blockSize, " bytes.", Fragment$$ExternalSyntheticOutline1.m(length, length3, "Length ", " too large for nonce ", " and blocksize ")));
                throw null;
            }
            byte[] bArr5 = this.block;
            cipher.update(bArr5, 0, this.blockSize, bArr5);
            if (length2 > 0) {
                if (length2 < 65280) {
                    xorInt(0, 2, length2);
                } else {
                    xorInt(0, 2, 65534);
                    xorInt(2, 6, length2);
                    i3 = 6;
                }
                update(bArr2, i3);
            }
            update(bArr3, 0);
            this.mac = Arrays.copyOf(this.block, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] getMac() {
            return this.mac;
        }

        private void update(byte[] bArr, int i) throws ShortBufferException {
            int length = bArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = (this.blockSize + i2) - i;
                if (i3 > length) {
                    i3 = length;
                }
                while (i2 < i3) {
                    byte[] bArr2 = this.block;
                    bArr2[i] = (byte) (bArr2[i] ^ bArr[i2]);
                    i2++;
                    i++;
                }
                Cipher cipher = this.cipher;
                byte[] bArr3 = this.block;
                cipher.update(bArr3, 0, this.blockSize, bArr3);
                i = 0;
            }
        }

        public int xorInt(int i, int i2, int i3) {
            while (i2 > i) {
                byte[] bArr = this.block;
                i2--;
                bArr[i2] = (byte) (bArr[i2] ^ ((byte) i3));
                i3 >>>= 8;
            }
            return i3;
        }
    }

    public static final byte[] decrypt(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3) throws InvalidKeyException, InvalidMacException, ShortBufferException {
        Cipher cipherCurrent = CIPHER.current();
        cipherCurrent.init(1, secretKey);
        int i4 = i2 - i3;
        int blockSize = cipherCurrent.getBlockSize();
        byte[] bArr4 = new byte[i4];
        byte[] bArr5 = new byte[i3];
        BlockCipher blockCipher = new BlockCipher(cipherCurrent, bArr);
        byte[] bArrUpdateBlock = blockCipher.updateBlock(0);
        int i5 = i + i4;
        for (int i6 = 0; i6 < i3; i6++) {
            bArr5[i6] = (byte) (bArr3[i5 + i6] ^ bArrUpdateBlock[i6]);
        }
        int i7 = 1;
        int i8 = 0;
        while (i8 < i4) {
            int i9 = i7 + 1;
            byte[] bArrUpdateBlock2 = blockCipher.updateBlock(i7);
            int i10 = i8 + blockSize;
            if (i10 > i4) {
                i10 = i4;
            }
            int i11 = 0;
            while (i8 < i10) {
                bArr4[i8] = (byte) (bArr3[i + i8] ^ bArrUpdateBlock2[i11]);
                i8++;
                i11++;
            }
            i7 = i9;
        }
        byte[] mac = new MacCipher(cipherCurrent, bArr, bArr2, bArr4, i3).getMac();
        if (MessageDigest.isEqual(bArr5, mac)) {
            return bArr4;
        }
        throw new InvalidMacException(mac, bArr5);
    }

    public static final byte[] encrypt(int i, SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) throws InvalidKeyException, ShortBufferException {
        Cipher cipherCurrent = CIPHER.current();
        cipherCurrent.init(1, secretKey);
        int blockSize = cipherCurrent.getBlockSize();
        int length = bArr3.length;
        byte[] mac = new MacCipher(cipherCurrent, bArr, bArr2, bArr3, i2).getMac();
        int i3 = i + length;
        byte[] bArr4 = new byte[i3 + i2];
        BlockCipher blockCipher = new BlockCipher(cipherCurrent, bArr);
        byte[] bArrUpdateBlock = blockCipher.updateBlock(0);
        for (int i4 = 0; i4 < i2; i4++) {
            bArr4[i4 + i3] = (byte) (mac[i4] ^ bArrUpdateBlock[i4]);
        }
        int i5 = 1;
        int i6 = 0;
        while (i6 < length) {
            int i7 = i5 + 1;
            byte[] bArrUpdateBlock2 = blockCipher.updateBlock(i5);
            int i8 = i6 + blockSize;
            if (i8 > length) {
                i8 = length;
            }
            int i9 = 0;
            while (i6 < i8) {
                bArr4[i6 + i] = (byte) (bArr3[i6] ^ bArrUpdateBlock2[i9]);
                i6++;
                i9++;
            }
            i5 = i7;
        }
        return bArr4;
    }
}
