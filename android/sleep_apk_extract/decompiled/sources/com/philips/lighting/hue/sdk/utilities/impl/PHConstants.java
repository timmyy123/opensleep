package com.philips.lighting.hue.sdk.utilities.impl;

/* JADX INFO: loaded from: classes4.dex */
public class PHConstants {
    public static final String RULE_BAD_BRIGE_CONFIG_OPERATOR = "PHBridgeConfiguration resource can not be used in combination with the OPERATOX_DX operator.";
    public static final String RULE_INVALID_ACTION = "Invalid Action Supplied.  Either a LightIdentifier/LightState, GroupIdentifer/LightState or GroupIdentifier/SceneIdentifier should be supplied.";
    public static final String RULE_INVALID_OBJECTS = "Objects in conditions should be a PHLight, PHSensor or PHBridgeConfiguration";
    public static final String RULE_INVALID_OPERATOR = "JSON contains invalid rule condition operator.";
    public static final String RULE_INVALID_PROPERTY = "JSON property is invalid.";
    public static final String RULE_MISSING_ADDRESS = "JSON is missing key: address.";
    public static final String RULE_NOT_INVALID_CONDITION_FORMAT = "JSON invalid rule condition format.";
    public static final String RULE_NOT_SUPPORTED_FIELD = "This field is not supported for this operation.";
    public static final String RULE_NOT_SUPPORTED_OPERATOR = "JSON operator not supported for /config/UTC and /config/localtime.";
    public static final String RULE_NO_ACTIONS_EXTRACTED = "No actions extracted from Rule.";
    public static final String RULE_NO_CONDITIONS_EXTRACTED = "No conditions extracted from Rule.";
    public static final String RULE_NO_LIGHTSTATE_ATTRIBUTES = "No LightState Attributes were found.";
}
