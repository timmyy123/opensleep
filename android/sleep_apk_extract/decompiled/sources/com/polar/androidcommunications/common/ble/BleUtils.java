package com.polar.androidcommunications.common.ble;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.polar.androidcommunications.api.ble.BleLogger;
import java.util.HashMap;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BleUtils {
    public static final String TAG = "BleUtils";

    public enum AD_TYPE {
        GAP_ADTYPE_UNKNOWN(0),
        GAP_ADTYPE_FLAGS(1),
        GAP_ADTYPE_16BIT_MORE(2),
        GAP_ADTYPE_16BIT_COMPLETE(3),
        GAP_ADTYPE_32BIT_MORE(4),
        GAP_ADTYPE_32BIT_COMPLETE(5),
        GAP_ADTYPE_128BIT_MORE(6),
        GAP_ADTYPE_128BIT_COMPLETE(7),
        GAP_ADTYPE_LOCAL_NAME_SHORT(8),
        GAP_ADTYPE_LOCAL_NAME_COMPLETE(9),
        GAP_ADTYPE_POWER_LEVEL(10),
        GAP_ADTYPE_OOB_CLASS_OF_DEVICE(11),
        GAP_ADTYPE_OOB_SIMPLE_PAIRING_HASHC(12),
        GAP_ADTYPE_OOB_SIMPLE_PAIRING_RANDR(13),
        GAP_ADTYPE_SM_TK(14),
        GAP_ADTYPE_SM_OOB_FLAG(15),
        GAP_ADTYPE_SLAVE_CONN_INTERVAL_RANGE(16),
        GAP_ADTYPE_SIGNED_DATA(17),
        GAP_ADTYPE_SERVICES_LIST_16BIT(18),
        GAP_ADTYPE_SERVICES_LIST_128BIT(19),
        GAP_ADTYPE_SERVICE_DATA(20),
        GAP_ADTYPE_MANUFACTURER_SPECIFIC(PHIpAddressSearchManager.END_IP_SCAN);

        private final int numVal;

        AD_TYPE(int i) {
            this.numVal = i;
        }
    }

    public enum EVENT_TYPE {
        ADV_IND(0),
        ADV_DIRECT_IND(1),
        ADV_SCAN_IND(2),
        ADV_NONCONN_IND(3),
        SCAN_RSP(4);

        private final int numVal;

        EVENT_TYPE(int i) {
            this.numVal = i;
        }
    }

    public static HashMap<AD_TYPE, byte[]> advertisementBytes2Map(byte[] bArr) {
        HashMap<AD_TYPE, byte[]> map = new HashMap<>();
        int i = 0;
        while (true) {
            int i2 = i + 2;
            try {
                if (i2 >= bArr.length) {
                    break;
                }
                AD_TYPE code = getCode(bArr[i + 1]);
                int i3 = bArr[i];
                if (i3 <= 0) {
                    break;
                }
                if (map.containsKey(code) && code == AD_TYPE.GAP_ADTYPE_MANUFACTURER_SPECIFIC) {
                    Objects.requireNonNull(map.get(code));
                    byte[] bArr2 = new byte[(r6.length + i3) - 1];
                    int i4 = i3 - 1;
                    System.arraycopy(bArr, i2, bArr2, 0, i4);
                    byte[] bArr3 = map.get(code);
                    Objects.requireNonNull(bArr3);
                    byte[] bArr4 = map.get(code);
                    Objects.requireNonNull(bArr4);
                    System.arraycopy(bArr3, 0, bArr2, i4, bArr4.length);
                    map.put(code, bArr2);
                } else {
                    int i5 = i3 - 1;
                    byte[] bArr5 = new byte[i5];
                    System.arraycopy(bArr, i2, bArr5, 0, i5);
                    map.put(code, bArr5);
                }
                i += i3 + 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                BleLogger.e(TAG, "incorrect advertisement data detected: " + e.getLocalizedMessage());
                return map;
            }
        }
        return map;
    }

    private static AD_TYPE getCode(byte b) {
        try {
            return b == -1 ? AD_TYPE.GAP_ADTYPE_MANUFACTURER_SPECIFIC : AD_TYPE.values()[b];
        } catch (ArrayIndexOutOfBoundsException unused) {
            return AD_TYPE.GAP_ADTYPE_UNKNOWN;
        }
    }

    public static void validate(boolean z, String str) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1((Object) str);
    }
}
