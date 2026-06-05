package com.philips.lighting.model;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueError {
    public static final int AUTHENTICATION_FAILED = 1;
    public static final int BRIDGE_ALREADY_CONNECTED = 27;
    public static final int BRIDGE_NOT_RESPONDING = 46;
    public static final int CLIP_ERROR = 54;
    public static final int DISABLED_PORTAL_SERVICE = 48;
    public static final int FIND_LIGHT_ERROR = 47;
    public static final int GROUP_ID_NOT_FOUND = 43;
    public static final int INVALID_API_CALL = 55;
    public static final int INVALID_DATA = 44;
    public static final int INVALID_JSON = 52;
    public static final int INVALID_OBJECT_PARAMETER = 51;
    public static final int INVALID_PARAMETERS = 23;
    public static final int INVALID_PARAMETERS_INVALID_METHOD = 25;
    public static final int INVALID_PARAMETERS_MISSING_URL = 24;
    public static final int LIGHT_ID_NOT_FOUND = 41;
    public static final int NO_CONNECTION = 22;
    public static final int NO_DATA_FOUND = 53;
    public static final int PORTAL_NOT_RESPONDING = 56;
    public static final int RESOURCE_UNPARSABLE_CONFIG = 60;
    public static final int RESOURCE_UNPARSABLE_GROUP = 62;
    public static final int RESOURCE_UNPARSABLE_LIGHT = 61;
    public static final int RESOURCE_UNPARSABLE_MULTI_LIGHT = 67;
    public static final int RESOURCE_UNPARSABLE_RULE = 66;
    public static final int RESOURCE_UNPARSABLE_SCENE = 63;
    public static final int RESOURCE_UNPARSABLE_SCHEDULE = 64;
    public static final int RESOURCE_UNPARSABLE_SENSOR = 65;
    public static final int SOFTWARE_UPDATE_DOWNLOADING = 57;
    public static final int SOFTWARE_UPDATE_NOT_AVAILABLE = 49;
    public static final int UNABLE_TO_PROCESS_REQUEST = 42;
    public static final int UNSUPPORTED_BRIDGE_RESPONSE = 45;
    public static final int UNSUPPORTED_BRIDGE_VERSION = 50;
    private String address;
    private int code;
    private String message;

    public PHHueError(int i, String str, String str2) {
        this.code = i;
        this.message = str;
        this.address = str2;
    }

    public String getAddress() {
        return this.address;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
