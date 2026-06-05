package com.philips.lighting.hue.sdk.clip.serialisation;

import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.philips.lighting.hue.sdk.clip.PHRuleSerializer;
import com.philips.lighting.hue.sdk.exception.PHInvalidRuleException;
import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.hue.sdk.utilities.PHDateTimePattern;
import com.philips.lighting.hue.sdk.utilities.PHUtilities;
import com.philips.lighting.hue.sdk.utilities.impl.PHConstants;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.rule.PHRuleAction;
import com.philips.lighting.model.rule.PHRuleCondition;
import com.philips.lighting.model.rule.PHSimpleRuleAction;
import com.philips.lighting.model.rule.PHSimpleRuleCondition;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHRuleSerializer1 extends PHCLIPParserBase implements PHRuleSerializer {
    private static final String TAG = "PHRuleSerializer1";
    private static PHRuleSerializer1 ruleSerialisation1;

    private String extractResourceIdentifierFromAddress(String str) {
        if (PHSimpleRuleCondition.PHSimpleRuleAttributeName.getByAddressTemplate(str) != null) {
            return null;
        }
        String[] strArrSplit = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (strArrSplit.length > 3) {
            return strArrSplit[2];
        }
        return null;
    }

    private String getAddressTemplate(String str) {
        String strExtractResourceIdentifierFromAddress = extractResourceIdentifierFromAddress(str);
        return strExtractResourceIdentifierFromAddress == null ? str : str.replace(strExtractResourceIdentifierFromAddress, "%s");
    }

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHRuleSerializer1 m851getInstance() {
        try {
            if (ruleSerialisation1 == null) {
                ruleSerialisation1 = new PHRuleSerializer1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return ruleSerialisation1;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public boolean canCreate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public boolean canDelete() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public boolean canFetchAll() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public boolean canRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public boolean canUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public JSONObject createRule(PHRule pHRule) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("name", pHRule.getName());
        if (pHRule.getStatus() == PHRule.PHRuleStatus.ENABLED) {
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "enabled");
        } else if (pHRule.getStatus() == PHRule.PHRuleStatus.DISABLED) {
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "disabled");
        }
        JSONArray jSONArray = new JSONArray();
        for (PHRuleCondition pHRuleCondition : pHRule.getConditions()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(IntegrityManager.INTEGRITY_TYPE_ADDRESS, pHRuleCondition.getAddress());
            jSONObject2.putOpt("operator", pHRuleCondition.getOperator().getValue());
            if (pHRuleCondition.getValue() != null && !pHRuleCondition.getOperator().equals(PHRuleCondition.PHRuleConditionOperator.OPERATOR_DX) && !pHRuleCondition.getOperator().equals(PHRuleCondition.PHRuleConditionOperator.OPERATOR_DT)) {
                if (pHRuleCondition.getOperator().equals(PHRuleCondition.PHRuleConditionOperator.OPERATOR_DDX)) {
                    PHDateTimePattern pHDateTimePattern = new PHDateTimePattern();
                    pHDateTimePattern.setTimer((Integer) pHRuleCondition.getValue());
                    jSONObject2.putOpt(SDKConstants.PARAM_VALUE, pHDateTimePattern.patternAsString());
                } else {
                    jSONObject2.putOpt(SDKConstants.PARAM_VALUE, pHRuleCondition.getValue().toString());
                }
            }
            jSONArray.put(jSONObject2);
        }
        jSONObject.putOpt("conditions", jSONArray);
        List<PHRuleAction> listExtractRuleActions = extractRuleActions(pHRule);
        JSONArray jSONArray2 = new JSONArray();
        for (PHRuleAction pHRuleAction : listExtractRuleActions) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt(IntegrityManager.INTEGRITY_TYPE_ADDRESS, pHRuleAction.getAddress());
            jSONObject3.putOpt("method", pHRuleAction.getMethod());
            if (pHRuleAction.getBody() != null) {
                jSONObject3.putOpt(SDKConstants.PARAM_A2U_BODY, new JSONObject(pHRuleAction.getBody().toString()));
            }
            jSONArray2.put(jSONObject3);
        }
        jSONObject.putOpt("actions", jSONArray2);
        return jSONObject;
    }

    public List<PHRuleAction> extractRuleActions(PHRule pHRule) {
        ArrayList arrayList = new ArrayList();
        if (pHRule.getActions() == null) {
            throw new PHInvalidRuleException(PHConstants.RULE_NO_ACTIONS_EXTRACTED);
        }
        for (PHRuleAction pHRuleAction : pHRule.getActions()) {
            if (pHRuleAction instanceof PHSimpleRuleAction) {
                PHSimpleRuleAction pHSimpleRuleAction = (PHSimpleRuleAction) pHRuleAction;
                if (pHSimpleRuleAction.getLightIdentifier() != null && pHSimpleRuleAction.getLightState() != null) {
                    try {
                        JSONObject jSONObjectCreateLightStatePacket = PHBridgeVersionManager.getInstance().getLightSerializer().createLightStatePacket(pHSimpleRuleAction.getLightState());
                        PHRuleAction pHRuleAction2 = new PHRuleAction();
                        pHRuleAction2.setAddress("/lights/" + pHSimpleRuleAction.getLightIdentifier() + "/state");
                        pHRuleAction2.setMethod("PUT");
                        pHRuleAction2.setBody(jSONObjectCreateLightStatePacket);
                        arrayList.add(pHRuleAction2);
                    } catch (JSONException e) {
                        PHInvalidRuleException pHInvalidRuleException = new PHInvalidRuleException(PHConstants.RULE_NO_ACTIONS_EXTRACTED);
                        pHInvalidRuleException.initCause(e);
                        throw pHInvalidRuleException;
                    }
                } else if (pHSimpleRuleAction.getGroupIdentifier() == null || pHSimpleRuleAction.getLightState() == null) {
                    if (pHSimpleRuleAction.getGroupIdentifier() == null || pHSimpleRuleAction.getSceneIdentifier() == null) {
                        throw new PHInvalidRuleException(PHConstants.RULE_INVALID_ACTION);
                    }
                    PHRuleAction pHRuleAction3 = new PHRuleAction();
                    pHRuleAction3.setAddress("/groups/" + pHSimpleRuleAction.getGroupIdentifier() + "/action");
                    pHRuleAction3.setMethod("PUT");
                    pHRuleAction3.setBody("{\"scene\": \"" + pHSimpleRuleAction.getSceneIdentifier() + "\"}");
                    arrayList.add(pHRuleAction3);
                } else {
                    try {
                        JSONObject jSONObjectCreateLightStatePacket2 = PHBridgeVersionManager.getInstance().getLightSerializer().createLightStatePacket(pHSimpleRuleAction.getLightState());
                        PHRuleAction pHRuleAction4 = new PHRuleAction();
                        pHRuleAction4.setAddress("/groups/" + pHSimpleRuleAction.getGroupIdentifier() + "/action");
                        pHRuleAction4.setMethod("PUT");
                        pHRuleAction4.setBody(jSONObjectCreateLightStatePacket2.toString());
                        arrayList.add(pHRuleAction4);
                    } catch (JSONException e2) {
                        PHInvalidRuleException pHInvalidRuleException2 = new PHInvalidRuleException(PHConstants.RULE_NO_ACTIONS_EXTRACTED);
                        pHInvalidRuleException2.initCause(e2);
                        throw pHInvalidRuleException2;
                    }
                }
            } else {
                arrayList.add(pHRuleAction);
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw new PHInvalidRuleException(PHConstants.RULE_NO_ACTIONS_EXTRACTED);
    }

    public PHRuleAction parseRuleAction(String str, String str2, Object obj) {
        if (str2 == null) {
            throw new PHInvalidRuleException(PHConstants.RULE_MISSING_ADDRESS);
        }
        String[] strArrSplit = str2.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (strArrSplit.length < 3 || strArrSplit.length > 5) {
            throw new PHInvalidRuleException(PHConstants.RULE_NOT_INVALID_CONDITION_FORMAT);
        }
        String str3 = strArrSplit[2];
        JSONObject jSONObject = null;
        if (!str2.startsWith("/groups/")) {
            if (!str2.startsWith("/lights/")) {
                PHRuleAction pHRuleAction = new PHRuleAction();
                pHRuleAction.setAddress(str2);
                pHRuleAction.setMethod(str);
                pHRuleAction.setBody(obj);
                return pHRuleAction;
            }
            PHSimpleRuleAction pHSimpleRuleAction = new PHSimpleRuleAction();
            pHSimpleRuleAction.setMethod(str);
            pHSimpleRuleAction.setLightIdentifier(str3);
            try {
                jSONObject = new JSONObject((String) obj);
            } catch (JSONException e) {
                if (PHLog.isLoggable()) {
                    PHLog.e(TAG, "JSONException: " + e);
                }
            }
            pHSimpleRuleAction.setLightState(PHBridgeVersionManager.getInstance().getLightSerializer().parseLightState(jSONObject));
            return pHSimpleRuleAction;
        }
        PHSimpleRuleAction pHSimpleRuleAction2 = new PHSimpleRuleAction();
        try {
            jSONObject = new JSONObject((String) obj);
        } catch (JSONException e2) {
            if (PHLog.isLoggable()) {
                PHLog.e(TAG, "JSONException: " + e2);
            }
        }
        if (!jSONObject.has("scene")) {
            PHRuleAction pHRuleAction2 = new PHRuleAction();
            pHRuleAction2.setAddress(str2);
            pHRuleAction2.setMethod(str);
            pHRuleAction2.setBody(obj);
            return pHRuleAction2;
        }
        pHSimpleRuleAction2.setSceneIdentifier(jSONObject.optString("scene"));
        pHSimpleRuleAction2.setAddress(str2);
        pHSimpleRuleAction2.setBody(obj);
        pHSimpleRuleAction2.setMethod(str);
        pHSimpleRuleAction2.setGroupIdentifier(str3);
        return pHSimpleRuleAction2;
    }

    public PHRuleCondition parseRuleCondition(String str, String str2, String str3, JSONObject jSONObject) {
        if (str == null) {
            throw new PHInvalidRuleException(PHConstants.RULE_MISSING_ADDRESS);
        }
        if (str2 == null) {
            throw new PHInvalidRuleException(PHConstants.RULE_INVALID_OPERATOR);
        }
        PHRuleCondition.PHRuleConditionOperator operatorFromShortDesc = PHRuleCondition.getOperatorFromShortDesc(str2);
        String strExtractResourceIdentifierFromAddress = extractResourceIdentifierFromAddress(str);
        PHSimpleRuleCondition.PHSimpleRuleAttributeName byAddressTemplate = PHSimpleRuleCondition.PHSimpleRuleAttributeName.getByAddressTemplate(getAddressTemplate(str));
        if (byAddressTemplate != null) {
            if (operatorFromShortDesc == PHRuleCondition.PHRuleConditionOperator.OPERATOR_DX) {
                return new PHSimpleRuleCondition(strExtractResourceIdentifierFromAddress, byAddressTemplate, operatorFromShortDesc, null);
            }
            Class type = byAddressTemplate.getType();
            return operatorFromShortDesc == PHRuleCondition.PHRuleConditionOperator.OPERATOR_DDX ? new PHSimpleRuleCondition(strExtractResourceIdentifierFromAddress, byAddressTemplate, operatorFromShortDesc, Integer.valueOf(PHDateTimePattern.timeWithTruncatedTimeString(str3))) : type == Integer.TYPE ? new PHSimpleRuleCondition(strExtractResourceIdentifierFromAddress, byAddressTemplate, operatorFromShortDesc, Integer.valueOf(Integer.parseInt(str3))) : type == Boolean.TYPE ? new PHSimpleRuleCondition(strExtractResourceIdentifierFromAddress, byAddressTemplate, operatorFromShortDesc, Boolean.valueOf(Boolean.parseBoolean(str3))) : new PHSimpleRuleCondition(strExtractResourceIdentifierFromAddress, byAddressTemplate, operatorFromShortDesc, str3);
        }
        PHRuleCondition pHRuleCondition = new PHRuleCondition();
        pHRuleCondition.setAddress(str);
        pHRuleCondition.setOperator(PHRuleCondition.getOperatorFromShortDesc(str2));
        pHRuleCondition.setValue(str3);
        return pHRuleCondition;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public List<PHRule> parseRules(JSONObject jSONObject) {
        JSONArray jSONArray;
        PHRule pHRule;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rules");
        JSONObject jSONObject4 = jSONObjectOptJSONObject == null ? jSONObject : jSONObjectOptJSONObject;
        JSONArray jSONArrayNames = jSONObject4.names();
        if (jSONArrayNames != null) {
            int i = 0;
            while (i < jSONArrayNames.length()) {
                String string = jSONArrayNames.getString(i);
                try {
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(string);
                    if (jSONObject5 != null) {
                        String strOptString = jSONObject5.optString("name");
                        String strOptString2 = jSONObject5.optString("lasttriggered");
                        String strOptString3 = jSONObject5.optString("created");
                        String strOptString4 = jSONObject5.optString("owner");
                        String strOptString5 = jSONObject5.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                        PHRule.PHRuleStatus pHRuleStatus = PHRule.PHRuleStatus.UNKNOWN;
                        if (strOptString5 != null) {
                            if (strOptString5.equals("active") || strOptString5.equals("enabled")) {
                                pHRuleStatus = PHRule.PHRuleStatus.ENABLED;
                            }
                            if (strOptString5.equals("disabled")) {
                                pHRuleStatus = PHRule.PHRuleStatus.DISABLED;
                            }
                            if (strOptString5.contains("resource") && strOptString5.contains("deleted")) {
                                pHRuleStatus = PHRule.PHRuleStatus.RESOURCE_DELETED;
                            }
                        }
                        int iOptInt = jSONObject5.optInt("timestriggered");
                        PHRule pHRule2 = new PHRule(strOptString, string);
                        if (strOptString3 != null) {
                            pHRule2.setCreationTime(PHUtilities.stringToDate(strOptString3, "UTC"));
                        }
                        if (strOptString2 != null) {
                            pHRule2.setLastTriggered(PHUtilities.stringToDate(strOptString2, "UTC"));
                        }
                        pHRule2.setOwner(strOptString4);
                        pHRule2.setStatus(pHRuleStatus);
                        pHRule2.setTimesTriggered(iOptInt);
                        JSONArray jSONArrayOptJSONArray = jSONObject5.optJSONArray("conditions");
                        if (jSONArrayOptJSONArray != null) {
                            ArrayList arrayList2 = new ArrayList();
                            int i2 = 0;
                            while (i2 < jSONArrayOptJSONArray.length()) {
                                try {
                                    jSONObject3 = new JSONObject(jSONArrayOptJSONArray.optString(i2));
                                    jSONArray = jSONArrayNames;
                                } catch (JSONException e) {
                                    if (PHLog.isLoggable()) {
                                        jSONArray = jSONArrayNames;
                                        PHLog.e(TAG, "JSONException: " + e);
                                    } else {
                                        jSONArray = jSONArrayNames;
                                    }
                                    jSONObject3 = null;
                                }
                                try {
                                    arrayList2.add(parseRuleCondition(jSONObject3.optString(IntegrityManager.INTEGRITY_TYPE_ADDRESS), jSONObject3.optString("operator"), jSONObject3.optString(SDKConstants.PARAM_VALUE), jSONObject));
                                    i2++;
                                    jSONArrayNames = jSONArray;
                                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                } catch (Exception e2) {
                                    e = e2;
                                    reportParsingError(66, string, "Rule unparsable due to error: " + e.getMessage(), jSONObject4.getJSONObject(string));
                                    i++;
                                    jSONArrayNames = jSONArray;
                                }
                            }
                            pHRule2.setConditions(arrayList2);
                        }
                        jSONArray = jSONArrayNames;
                        JSONArray jSONArrayOptJSONArray2 = jSONObject5.optJSONArray("actions");
                        if (jSONArrayOptJSONArray2 != null) {
                            ArrayList arrayList3 = new ArrayList();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                try {
                                    jSONObject2 = new JSONObject(jSONArrayOptJSONArray2.optString(i3));
                                } catch (JSONException e3) {
                                    if (PHLog.isLoggable()) {
                                        PHLog.e(TAG, "JSONException: " + e3);
                                    }
                                    jSONObject2 = null;
                                }
                                arrayList3.add(parseRuleAction(jSONObject2.optString("method"), jSONObject2.optString(IntegrityManager.INTEGRITY_TYPE_ADDRESS), jSONObject2.optString(SDKConstants.PARAM_A2U_BODY)));
                            }
                            pHRule2.setActions(arrayList3);
                        }
                        pHRule = pHRule2;
                    } else {
                        jSONArray = jSONArrayNames;
                        pHRule = null;
                    }
                    arrayList.add(pHRule);
                } catch (Exception e4) {
                    e = e4;
                    jSONArray = jSONArrayNames;
                }
                i++;
                jSONArrayNames = jSONArray;
            }
        }
        return arrayList;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public JSONObject updateRule(PHRule pHRule) {
        return createRule(pHRule);
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHRuleSerializer
    public boolean validateAPI(PHRule pHRule) {
        return true;
    }
}
