package com.ftdi.j2xx;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes3.dex */
class FT_EE_Ctrl {
    private FT_Device mDevice;
    boolean mEepromBlank;
    int mEepromSize;
    short mEepromType;

    public FT_EE_Ctrl(FT_Device fT_Device) {
        this.mDevice = fT_Device;
    }

    public int eraseEeprom() {
        return this.mDevice.getConnection().controlTransfer(64, 146, 0, 0, null, 0, 0);
    }

    public int getEepromSize(byte b) {
        short word = (short) readWord(b);
        if (word != 65535) {
            if (word == 70) {
                this.mEepromType = (short) 70;
                this.mEepromSize = 64;
                this.mEepromBlank = false;
                return 64;
            }
            if (word == 82) {
                this.mEepromType = (short) 82;
                this.mEepromSize = 1024;
                this.mEepromBlank = false;
                return 1024;
            }
            if (word == 86) {
                this.mEepromType = (short) 86;
                this.mEepromSize = 128;
                this.mEepromBlank = false;
                return 128;
            }
            if (word != 102) {
                return 0;
            }
            this.mEepromType = (short) 102;
            this.mEepromSize = 128;
            this.mEepromBlank = false;
            return 256;
        }
        boolean zWriteWord = writeWord((short) 192, (short) 192);
        readWord((short) 192);
        readWord((short) 64);
        readWord((short) 0);
        if (!zWriteWord) {
            this.mEepromType = (short) 255;
            this.mEepromSize = 0;
            return 0;
        }
        this.mEepromBlank = true;
        if ((readWord((short) 0) & PHIpAddressSearchManager.END_IP_SCAN) == 192) {
            eraseEeprom();
            this.mEepromType = (short) 70;
            this.mEepromSize = 64;
            return 64;
        }
        if ((readWord((short) 64) & PHIpAddressSearchManager.END_IP_SCAN) == 192) {
            eraseEeprom();
            this.mEepromType = (short) 86;
            this.mEepromSize = 128;
            return 128;
        }
        if ((readWord((short) 192) & PHIpAddressSearchManager.END_IP_SCAN) != 192) {
            eraseEeprom();
            return 0;
        }
        eraseEeprom();
        this.mEepromType = (short) 102;
        this.mEepromSize = 128;
        return 256;
    }

    public int readWord(short s) {
        byte[] bArr = new byte[2];
        if (s >= 1024) {
            return -1;
        }
        this.mDevice.getConnection().controlTransfer(-64, 144, 0, s, bArr, 2, 0);
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public boolean writeWord(short s, short s2) {
        return s < 1024 && this.mDevice.getConnection().controlTransfer(64, 145, s2 & 65535, s & 65535, null, 0, 0) == 0;
    }
}
