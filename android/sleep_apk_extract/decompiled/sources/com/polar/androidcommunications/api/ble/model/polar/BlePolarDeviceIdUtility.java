package com.polar.androidcommunications.api.ble.model.polar;

import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BlePolarDeviceIdUtility {
    public static String assemblyFullPolarDeviceId(String str) {
        try {
            int length = str.length();
            if (length != 6) {
                return length != 7 ? str : str.concat(String.format("%01X", Byte.valueOf(checkSumForDeviceId(Long.parseLong(str, 16), 7))));
            }
            return str + AppEventsConstants.EVENT_PARAM_VALUE_YES + String.format("%01X", Byte.valueOf(checkSumForDeviceId(Long.parseLong(str, 16), 6)));
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    private static byte checkSumForDeviceId(long j, int i) {
        byte b;
        int i2 = 4;
        if (i == 7) {
            b = (byte) (j & 15);
        } else if (i != 8) {
            i2 = 0;
            b = 1;
        } else {
            b = (byte) ((j >> 4) & 15);
            i2 = 8;
        }
        return (byte) ((((((((b + ((byte) ((j >> (i2 + 4)) & 15))) + ((byte) ((j >> (i2 + 12)) & 15))) + ((byte) ((j >> (i2 + 20)) & 15))) * 3) + ((byte) ((j >> i2) & 15))) + ((byte) ((j >> (i2 + 8)) & 15))) + ((byte) ((j >> (i2 + 16)) & 15))) % 16);
    }
}
