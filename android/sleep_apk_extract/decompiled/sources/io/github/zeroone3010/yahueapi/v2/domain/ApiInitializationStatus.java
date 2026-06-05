package io.github.zeroone3010.yahueapi.v2.domain;

/* JADX INFO: loaded from: classes5.dex */
public class ApiInitializationStatus {
    private ApiInitializationError error;
    private ApiInitializationSuccess success;

    public ApiInitializationError getError() {
        return this.error;
    }

    public ApiInitializationSuccess getSuccess() {
        return this.success;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
