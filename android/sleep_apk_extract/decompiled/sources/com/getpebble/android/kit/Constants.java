package com.getpebble.android.kit;

import android.net.Uri;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class Constants {
    public static final String APP_UUID = "uuid";
    public static final String CUST_APP_TYPE = "app_type";
    public static final String CUST_ICON = "icon";
    public static final String CUST_NAME = "name";
    public static final String DATA_LOG_TAG = "data_log_tag";
    public static final String DATA_LOG_TIMESTAMP = "data_log_timestamp";
    public static final String DATA_LOG_UUID = "data_log_uuid";
    public static final int GOLF_BACK_KEY = 2;
    public static final int GOLF_CMD_KEY = 5;
    public static final int GOLF_CMD_NEXT = 2;
    public static final int GOLF_CMD_PREV = 1;
    public static final int GOLF_FRONT_KEY = 0;
    public static final int GOLF_HOLE_KEY = 3;
    public static final int GOLF_MID_KEY = 1;
    public static final int GOLF_PAR_KEY = 4;
    public static final String INTENT_APP_ACK = "com.getpebble.action.app.ACK";
    public static final String INTENT_APP_CUSTOMIZE = "com.getpebble.action.app.CONFIGURE";
    public static final String INTENT_APP_NACK = "com.getpebble.action.app.NACK";
    public static final String INTENT_APP_RECEIVE = "com.getpebble.action.app.RECEIVE";
    public static final String INTENT_APP_RECEIVE_ACK = "com.getpebble.action.app.RECEIVE_ACK";
    public static final String INTENT_APP_RECEIVE_NACK = "com.getpebble.action.app.RECEIVE_NACK";
    public static final String INTENT_APP_SEND = "com.getpebble.action.app.SEND";
    public static final String INTENT_APP_START = "com.getpebble.action.app.START";
    public static final String INTENT_APP_STOP = "com.getpebble.action.app.STOP";
    public static final String INTENT_DL_ACK_DATA = "com.getpebble.action.dl.ACK_DATA";
    public static final String INTENT_DL_FINISH_SESSION = "com.getpebble.action.dl.FINISH_SESSION_NEW";
    public static final String INTENT_DL_RECEIVE_DATA = "com.getpebble.action.dl.RECEIVE_DATA_NEW";
    public static final String INTENT_DL_REQUEST_DATA = "com.getpebble.action.dl.REQUEST_DATA";
    public static final String INTENT_PEBBLE_CONNECTED = "com.getpebble.action.PEBBLE_CONNECTED";
    public static final String INTENT_PEBBLE_DISCONNECTED = "com.getpebble.action.PEBBLE_DISCONNECTED";
    public static final int KIT_STATE_COLUMN_APPMSG_SUPPORT = 1;
    public static final int KIT_STATE_COLUMN_CONNECTED = 0;
    public static final int KIT_STATE_COLUMN_DATALOGGING_SUPPORT = 2;
    public static final int KIT_STATE_COLUMN_VERSION_MAJOR = 3;
    public static final int KIT_STATE_COLUMN_VERSION_MINOR = 4;
    public static final int KIT_STATE_COLUMN_VERSION_POINT = 5;
    public static final int KIT_STATE_COLUMN_VERSION_TAG = 6;
    public static final String MSG_DATA = "msg_data";
    public static final String PBL_DATA_ID = "pbl_data_id";
    public static final String PBL_DATA_OBJECT = "pbl_data_object";
    public static final String PBL_DATA_TYPE = "pbl_data_type";
    public static final int SPORTS_CUSTOM_LABEL_KEY = 7;
    public static final int SPORTS_CUSTOM_VALUE_KEY = 8;
    public static final int SPORTS_DATA_KEY = 2;
    public static final int SPORTS_DATA_PACE = 1;
    public static final int SPORTS_DATA_SPEED = 0;
    public static final int SPORTS_DISTANCE_KEY = 1;
    public static final int SPORTS_HR_BPM_KEY = 6;
    public static final int SPORTS_LABEL_KEY = 5;
    public static final int SPORTS_STATE_END = 3;
    public static final int SPORTS_STATE_INIT = 0;
    public static final int SPORTS_STATE_KEY = 4;
    public static final int SPORTS_STATE_PAUSED = 2;
    public static final int SPORTS_STATE_RUNNING = 1;
    public static final int SPORTS_TIME_KEY = 0;
    public static final int SPORTS_UNITS_IMPERIAL = 0;
    public static final int SPORTS_UNITS_KEY = 3;
    public static final int SPORTS_UNITS_METRIC = 1;
    public static final String TRANSACTION_ID = "transaction_id";
    public static final UUID SPORTS_UUID = UUID.fromString("4dab81a6-d2fc-458a-992c-7a1f3b96a970");
    public static final UUID GOLF_UUID = UUID.fromString("cf1e816a-9db0-4511-bbb8-f60c48ca8fac");
    static final Uri URI_CONTENT_PRIMARY = Uri.parse("content://com.getpebble.android.provider/state");
    static final Uri URI_CONTENT_BASALT = Uri.parse("content://com.getpebble.android.provider.basalt/state");

    public enum PebbleAppType {
        SPORTS(0),
        GOLF(1),
        OTHER(PHIpAddressSearchManager.END_IP_SCAN);

        public final int ord;

        PebbleAppType(int i) {
            this.ord = i;
        }
    }

    public enum PebbleDataType {
        BYTES(0),
        UINT(2),
        INT(3),
        INVALID(PHIpAddressSearchManager.END_IP_SCAN);

        public final byte ord;

        PebbleDataType(int i) {
            this.ord = (byte) i;
        }

        public static PebbleDataType fromByte(byte b) {
            for (PebbleDataType pebbleDataType : values()) {
                if (pebbleDataType.ord == b) {
                    return pebbleDataType;
                }
            }
            return null;
        }
    }

    private Constants() {
    }
}
