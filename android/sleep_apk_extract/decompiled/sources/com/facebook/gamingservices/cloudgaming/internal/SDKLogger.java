package com.facebook.gamingservices.cloudgaming.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.appevents.InternalAppEventsLogger;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SDKLogger {
    private static SDKLogger instance;
    private final InternalAppEventsLogger logger;
    private String appID = null;
    private String userID = null;
    private String sessionID = null;
    private ConcurrentHashMap<String, String> requestIDToFunctionTypeMap = new ConcurrentHashMap<>();

    private SDKLogger(Context context) {
        this.logger = new InternalAppEventsLogger(context);
    }

    private Bundle getInitParameters() {
        Bundle bundle = new Bundle();
        String str = this.appID;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = this.sessionID;
        if (str2 != null) {
            bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, str2);
        }
        return bundle;
    }

    public static synchronized SDKLogger getInstance(Context context) {
        try {
            if (instance == null) {
                instance = new SDKLogger(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private Bundle getParametersWithRequestIDAndFunctionType(String str) {
        Bundle initParameters = getInitParameters();
        if (str != null) {
            String orDefault = this.requestIDToFunctionTypeMap.getOrDefault(str, null);
            initParameters.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str);
            if (orDefault != null) {
                initParameters.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, orDefault);
                this.requestIDToFunctionTypeMap.remove(str);
            }
        }
        return initParameters;
    }

    public void logGameLoadComplete() {
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_GAME_LOAD_COMPLETE, getInitParameters());
    }

    public void logInternalError(SDKMessageEnum sDKMessageEnum, Exception exc) {
        Bundle initParameters = getInitParameters();
        initParameters.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, sDKMessageEnum.toString());
        initParameters.putString("error_type", exc.getClass().getName());
        initParameters.putString("error_message", exc.getMessage());
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_INTERNAL_ERROR, initParameters);
    }

    public void logLoginSuccess() {
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_LOGIN_SUCCESS, getInitParameters());
    }

    public void logPreparingRequest(String str, String str2, JSONObject jSONObject) {
        Bundle parametersWithRequestIDAndFunctionType = getParametersWithRequestIDAndFunctionType(str2, str);
        parametersWithRequestIDAndFunctionType.putString("payload", jSONObject.toString());
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_PREPARING_REQUEST, parametersWithRequestIDAndFunctionType);
    }

    public void logSendingErrorResponse(FacebookRequestError facebookRequestError, String str) {
        Bundle parametersWithRequestIDAndFunctionType = getParametersWithRequestIDAndFunctionType(str);
        parametersWithRequestIDAndFunctionType.putString("error_code", Integer.toString(facebookRequestError.getErrorCode()));
        parametersWithRequestIDAndFunctionType.putString("error_type", facebookRequestError.getErrorType());
        parametersWithRequestIDAndFunctionType.putString("error_message", facebookRequestError.getErrorMessage());
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENDING_ERROR_RESPONSE, parametersWithRequestIDAndFunctionType);
    }

    public void logSendingSuccessResponse(String str) {
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENDING_SUCCESS_RESPONSE, getParametersWithRequestIDAndFunctionType(str));
    }

    public void logSentRequest(String str, String str2, JSONObject jSONObject) {
        Bundle parametersWithRequestIDAndFunctionType = getParametersWithRequestIDAndFunctionType(str2, str);
        this.requestIDToFunctionTypeMap.put(str2, str);
        parametersWithRequestIDAndFunctionType.putString("payload", jSONObject.toString());
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENT_REQUEST, parametersWithRequestIDAndFunctionType);
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setUserID(String str) {
        this.userID = str;
    }

    private Bundle getParametersWithRequestIDAndFunctionType(String str, String str2) {
        Bundle initParameters = getInitParameters();
        initParameters.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str);
        initParameters.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, str2);
        return initParameters;
    }

    public static void logInternalError(Context context, SDKMessageEnum sDKMessageEnum, Exception exc) {
        getInstance(context).logInternalError(sDKMessageEnum, exc);
    }
}
