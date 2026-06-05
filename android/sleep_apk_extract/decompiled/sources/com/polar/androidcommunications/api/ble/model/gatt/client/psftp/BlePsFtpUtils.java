package com.polar.androidcommunications.api.ble.model.gatt.client.psftp;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BlePsFtpUtils {
    public static final UUID RFC77_PFTP_SERVICE = UUID.fromString("0000FEEE-0000-1000-8000-00805f9b34fb");
    public static final UUID RFC77_PFTP_MTU_CHARACTERISTIC = UUID.fromString("FB005C51-02E7-F387-1CAD-8ACD2D8DF0C8");
    public static final UUID RFC77_PFTP_D2H_CHARACTERISTIC = UUID.fromString("FB005C52-02E7-F387-1CAD-8ACD2D8DF0C8");
    public static final UUID RFC77_PFTP_H2D_CHARACTERISTIC = UUID.fromString("FB005C53-02E7-F387-1CAD-8ACD2D8DF0C8");

    public enum MessageType {
        REQUEST,
        QUERY,
        NOTIFICATION
    }

    public static class PftpOperationTimeout extends Exception {
        public PftpOperationTimeout(String str) {
            super(str);
        }
    }

    public static class PftpResponseError extends Exception {
        private final int error;

        public PftpResponseError(String str, int i) {
            super(str + " Error: " + i);
            this.error = i;
        }

        public int getError() {
            return this.error;
        }
    }

    public static class PftpRfc76ResponseHeader {
        public int error;
        public int next;
        public byte[] payload;
        public long sequenceNumber;
        public int status;

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("first: ");
            sb.append(this.next);
            sb.append(" length: ");
            sb.append(this.status);
            sb.append(" error: ");
            sb.append(this.error);
            sb.append(" payload: ");
            byte[] bArr = this.payload;
            if (bArr != null) {
                str = new String(bArr);
            } else {
                str = "null seq: " + this.sequenceNumber;
            }
            sb.append(str);
            return sb.toString();
        }
    }

    public static class Rfc76SequenceNumber {
        long seq = 0;

        public long getSeq() {
            return this.seq;
        }

        public void increment() {
            long j = this.seq;
            if (j < 15) {
                this.seq = j + 1;
            } else {
                this.seq = 0L;
            }
        }
    }

    public static byte[] buildRfc76MessageFrame(ByteArrayInputStream byteArrayInputStream, int i, int i2, Rfc76SequenceNumber rfc76SequenceNumber) {
        byte[] bArr;
        int i3 = i2 - 1;
        if (byteArrayInputStream.available() > i3) {
            bArr = new byte[i2];
            bArr[0] = (byte) (((long) (i | bArr[0] | 6)) | (rfc76SequenceNumber.getSeq() << 4));
            byteArrayInputStream.read(bArr, 1, i3);
        } else if (byteArrayInputStream.available() > 0) {
            bArr = new byte[byteArrayInputStream.available() + 1];
            bArr[0] = (byte) (((long) (i | bArr[0] | 2)) | (rfc76SequenceNumber.getSeq() << 4));
            byteArrayInputStream.read(bArr, 1, byteArrayInputStream.available());
        } else {
            bArr = new byte[1];
            bArr[0] = (byte) (((long) (bArr[0] | i | 2)) | (rfc76SequenceNumber.getSeq() << 4));
        }
        rfc76SequenceNumber.increment();
        return bArr;
    }

    public static ByteArrayInputStream makeCompleteMessageStream(ByteArrayInputStream byteArrayInputStream, ByteArrayInputStream byteArrayInputStream2, MessageType messageType, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iOrdinal = messageType.ordinal();
        if (iOrdinal == 0) {
            int iAvailable = byteArrayInputStream.available();
            byteArrayOutputStream.write(new byte[]{(byte) (iAvailable & PHIpAddressSearchManager.END_IP_SCAN), (byte) ((iAvailable & 32512) >> 8)}, 0, 2);
            IOUtils.copy(byteArrayInputStream, byteArrayOutputStream);
            if (byteArrayInputStream2 != null) {
                IOUtils.copy(byteArrayInputStream2, byteArrayOutputStream);
            }
        } else if (iOrdinal == 1) {
            byteArrayOutputStream.write(new byte[]{(byte) (i & PHIpAddressSearchManager.END_IP_SCAN), (byte) (((i & 32512) >> 8) | 128)}, 0, 2);
            if (byteArrayInputStream != null) {
                IOUtils.copy(byteArrayInputStream, byteArrayOutputStream);
            }
        } else if (iOrdinal == 2) {
            byteArrayOutputStream.write(new byte[]{(byte) i}, 0, 1);
            if (byteArrayInputStream != null) {
                IOUtils.copy(byteArrayInputStream, byteArrayOutputStream);
            }
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public static void processRfc76MessageFrameHeader(PftpRfc76ResponseHeader pftpRfc76ResponseHeader, byte[] bArr) {
        byte b = bArr[0];
        pftpRfc76ResponseHeader.next = b & 1;
        int i = (b >> 1) & 3;
        pftpRfc76ResponseHeader.status = i;
        pftpRfc76ResponseHeader.sequenceNumber = (b >> 4) & 15;
        if (i == 0) {
            pftpRfc76ResponseHeader.error = (((bArr[2] << 8) & PHIpAddressSearchManager.END_IP_SCAN) | (bArr[1] & 255)) & 65535;
        } else {
            byte[] bArr2 = new byte[bArr.length - 1];
            pftpRfc76ResponseHeader.payload = bArr2;
            System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
        }
    }

    public static PftpRfc76ResponseHeader processRfc76MessageFrameHeader(byte[] bArr) {
        PftpRfc76ResponseHeader pftpRfc76ResponseHeader = new PftpRfc76ResponseHeader();
        processRfc76MessageFrameHeader(pftpRfc76ResponseHeader, bArr);
        return pftpRfc76ResponseHeader;
    }
}
