package io.ktor.client.plugins;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/HttpRedirectConfig;", "", "<init>", "()V", "", "checkHttpMethod", "Z", "getCheckHttpMethod", "()Z", "setCheckHttpMethod", "(Z)V", "allowHttpsDowngrade", "getAllowHttpsDowngrade", "setAllowHttpsDowngrade", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpRedirectConfig {
    private boolean allowHttpsDowngrade;
    private boolean checkHttpMethod = true;

    public final boolean getAllowHttpsDowngrade() {
        return this.allowHttpsDowngrade;
    }

    public final boolean getCheckHttpMethod() {
        return this.checkHttpMethod;
    }
}
