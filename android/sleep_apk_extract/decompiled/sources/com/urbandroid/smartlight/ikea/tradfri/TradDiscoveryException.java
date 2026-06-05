package com.urbandroid.smartlight.ikea.tradfri;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/TradDiscoveryException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", SDKConstants.PARAM_DEBUG_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TradDiscoveryException extends RuntimeException {
    private final String msg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TradDiscoveryException(String str) {
        super(str);
        str.getClass();
        this.msg = str;
    }

    public final String getMsg() {
        return this.msg;
    }
}
