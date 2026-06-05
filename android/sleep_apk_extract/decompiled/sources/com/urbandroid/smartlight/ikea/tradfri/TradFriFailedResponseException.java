package com.urbandroid.smartlight.ikea.tradfri;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import org.eclipse.californium.core.coap.CoAP;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/TradFriFailedResponseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorCode", "Lorg/eclipse/californium/core/coap/CoAP$ResponseCode;", SDKConstants.PARAM_DEBUG_MESSAGE, "", "<init>", "(Lorg/eclipse/californium/core/coap/CoAP$ResponseCode;Ljava/lang/String;)V", "getErrorCode", "()Lorg/eclipse/californium/core/coap/CoAP$ResponseCode;", "getMsg", "()Ljava/lang/String;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TradFriFailedResponseException extends RuntimeException {
    private final CoAP.ResponseCode errorCode;
    private final String msg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TradFriFailedResponseException(CoAP.ResponseCode responseCode, String str) {
        super(str);
        responseCode.getClass();
        str.getClass();
        this.errorCode = responseCode;
        this.msg = str;
    }

    public final CoAP.ResponseCode getErrorCode() {
        return this.errorCode;
    }

    public final String getMsg() {
        return this.msg;
    }
}
