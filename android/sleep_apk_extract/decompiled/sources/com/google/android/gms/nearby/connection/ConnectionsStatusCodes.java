package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.CommonStatusCodes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConnectionsStatusCodes extends CommonStatusCodes {
    public static String getStatusCodeString(int i) {
        if (i == 8025) {
            return "MISSING_SETTING_LOCATION_MUST_BE_ON";
        }
        if (i == 8050) {
            return "API_CONNECTION_FAILED_ALREADY_IN_USE";
        }
        switch (i) {
            case 8000:
                return "STATUS_NETWORK_NOT_CONNECTED";
            case 8001:
                return "STATUS_ALREADY_ADVERTISING";
            case 8002:
                return "STATUS_ALREADY_DISCOVERING";
            case 8003:
                return "STATUS_ALREADY_CONNECTED_TO_ENDPOINT";
            case 8004:
                return "STATUS_CONNECTION_REJECTED";
            case 8005:
                return "STATUS_NOT_CONNECTED_TO_ENDPOINT";
            case 8006:
                return "STATUS_CAN_NOT_OBTAIN_DEVICE_PROVIDER";
            case 8007:
                return "STATUS_RADIO_ERROR";
            case 8008:
                return "STATUS_ALREADY_HAVE_ACTIVE_STRATEGY";
            case 8009:
                return "STATUS_OUT_OF_ORDER_API_CALL";
            case 8010:
                return "STATUS_UNSUPPORTED_PAYLOAD_TYPE_FOR_STRATEGY";
            case 8011:
                return "STATUS_ENDPOINT_UNKNOWN";
            case 8012:
                return "STATUS_ENDPOINT_IO_ERROR";
            case 8013:
                return "STATUS_PAYLOAD_IO_ERROR";
            case 8014:
                return "STATUS_PAYLOAD_UNKNOWN";
            case 8015:
                return "STATUS_ALREADY_LISTENING";
            case 8016:
                return "STATUS_AUTH_ERROR";
            default:
                switch (i) {
                    case 8029:
                        return "MISSING_PERMISSION_NEARBY_WIFI_DEVICES";
                    case 8030:
                        return "MISSING_PERMISSION_BLUETOOTH";
                    case 8031:
                        return "MISSING_PERMISSION_BLUETOOTH_ADMIN";
                    case 8032:
                        return "MISSING_PERMISSION_ACCESS_WIFI_STATE";
                    case 8033:
                        return "MISSING_PERMISSION_CHANGE_WIFI_STATE";
                    case 8034:
                        return "MISSING_PERMISSION_ACCESS_COARSE_LOCATION";
                    case 8035:
                        return "MISSING_PERMISSION_RECORD_AUDIO";
                    case 8036:
                        return "MISSING_PERMISSION_ACCESS_FINE_LOCATION";
                    case 8037:
                        return "MISSING_PERMISSION_BLUETOOTH_SCAN";
                    case 8038:
                        return "MISSING_PERMISSION_BLUETOOTH_ADVERTISE";
                    case 8039:
                        return "MISSING_PERMISSION_BLUETOOTH_CONNECT";
                    default:
                        return CommonStatusCodes.getStatusCodeString(i);
                }
        }
    }
}
