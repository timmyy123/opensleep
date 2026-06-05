package com.urbandroid.sleep.hr.polar.domain;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PpgData {
    public final int channels;
    public final List<PpgSample> ppgSamples = new ArrayList();
    public final long timeStamp;

    public enum PpgFrameType {
        PPG0_TYPE(0),
        AFE4410(1),
        AFE4404(2),
        PPG1_TYPE(3),
        ADPD4000(4),
        AFE_OPERATION_MODE(5),
        SPORT_ID(6),
        DELTA_FRAME(128),
        UNKNOWN_TYPE(PHIpAddressSearchManager.END_IP_SCAN);

        private final int numVal;

        PpgFrameType(int i) {
            this.numVal = i;
        }

        public static PpgFrameType fromId(int i) {
            for (PpgFrameType ppgFrameType : values()) {
                if (ppgFrameType.numVal == i) {
                    return ppgFrameType;
                }
            }
            return UNKNOWN_TYPE;
        }
    }

    public class PpgSample {
        public final List<Integer> ppgDataSamples;
        public final long status;

        public PpgSample(List<Integer> list, long j) {
            this.ppgDataSamples = list;
            this.status = j;
        }

        public String toString() {
            return "PpgSample{status=" + this.status + ", ppgDataSamples=" + this.ppgDataSamples + "}";
        }
    }

    public PpgData(byte[] bArr, long j, int i) {
        int i2;
        long jConvertArrayToUnsignedLong;
        this.timeStamp = j;
        this.channels = i == 0 ? 4 : 18;
        int i3 = 0;
        while (i3 < bArr.length) {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (true) {
                i2 = this.channels;
                if (i4 >= i2) {
                    break;
                }
                arrayList.add(Integer.valueOf(BleUtils.convertArrayToSignedInt(bArr, i3, 3)));
                i3 += 3;
                i4++;
            }
            if (i2 == 18) {
                jConvertArrayToUnsignedLong = BleUtils.convertArrayToUnsignedLong(bArr, i3, 4);
                i3 += 4;
            } else {
                jConvertArrayToUnsignedLong = 0;
            }
            this.ppgSamples.add(new PpgSample(arrayList, jConvertArrayToUnsignedLong));
        }
    }

    public String toString() {
        return "PpgData{timeStamp=" + this.timeStamp + ", channels=" + this.channels + ", ppgSamples=" + this.ppgSamples + "}";
    }
}
